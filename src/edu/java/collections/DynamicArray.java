/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.java.collections;

import java.util.*;
import java.util.function.Consumer;

/**
 *
 * @author Roman
 * @param <T>
 */
public class DynamicArray<T> implements List<T> {
    private T elements[];
    
    private int sizeArray;    
    
    public DynamicArray(int initialSize) {
        this.elements = (T[])new Object[initialSize];
        this.sizeArray = 0;
    }
    
    public DynamicArray() {
        this(10);
    }
    
    public DynamicArray(T[] array) {
        this.elements = (T[])new Object[array.length];
        System.arraycopy(array, 0, this.elements, 0 , array.length);
        this.sizeArray = array.length;
    }
    
    @Override
    public boolean add(T element) {
        if (this.sizeArray == this.elements.length) {
            resize(this.elements.length * 2);
        }
        
        this.elements[this.sizeArray++] = element;
            
        return true;
    }
    
    @Override
    public void add(int index,T element) {
        
        if (this.sizeArray == this.elements.length) {
            resize(this.elements.length * 2);
        }
        
        rangeCheck(index);
        
        Object[] newArray = new Object[this.sizeArray + 1];
        
        System.arraycopy(this.elements, 0, newArray, 0, index);
        System.arraycopy(this.elements, index, newArray, index+1, this.sizeArray - index +1);
        this.elements = (T[])newArray;
        this.elements[index] = element;
    }
    
    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            this.add(t);
        }
        
        return true;
    }
    
    @Override
    public boolean addAll(int index,Collection<? extends T> c) {
        for (T t : c) {
            this.add(index,t);
        }
        
        return true;
    }
        
    @Override
    public void clear() {
        for (int i = 0; i < this.sizeArray; i++) {
            this.elements[i] = null;
        }
        
        this.sizeArray = 0;
    }
    
    @Override
    public boolean contains(Object o) {
        for (Object i : this.elements) {
            if (o.equals(i))
                return true;
        }
        
        return false;
    }
    
    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object t : c) {
            if (!contains(t)) {
                return false;
            }
        }
        
        return true;
    }
    
    @Override
    public boolean equals(Object o) {
        return o.equals(this);
    }
        
    @Override
    public T  get(int index) {
        rangeCheck(index);
        
        return (T) this.elements[index];
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.elements);
    }
        
    @Override
    public int indexOf(Object element) {
        for(int i = 0; i < this.sizeArray; i++) {
            if (element == this.elements[i]) {
                return i;
            }
        }
        
        return -1;
    }
                
    @Override
    public boolean isEmpty() {
        return this.sizeArray == 0;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }
        
    @Override
    public int lastIndexOf(Object o) {
        int index = 0;
        
        if (!contains((T) o))
            return -1;
        
        for (int i = 0;i < this.sizeArray; i++) {
            if (this.elements[i] == o) {
                index = i;             
            }
        }
        
        return index;
    }
    
    @Override
    public ListIterator<T> listIterator() {
        return new DynamicIterator();
    }
    
    @Override
    public ListIterator<T> listIterator(int index) {
        return new DynamicIterator(index);
    }
    
    private void resize(int newSize) {
        if (newSize > this.elements.length) {
            Object[] newArray = new Object[newSize];
            
            System.arraycopy(this.elements, 0, newArray, 0, this.elements.length);
            this.elements = (T[])newArray;
        }
    }
    
    @Override
    public T remove(int index) {
        T elem = this.get(index);
        if ((index >= 0) && (index < this.sizeArray)) {
            T[] temp = (T[]) new Object[this.sizeArray-1];
            
            System.arraycopy(this.elements, 0, temp, 0, index);
            System.arraycopy(this.elements, index + 1, temp, index, this.sizeArray - index -1);
            this.elements = temp;
            this.sizeArray--;
        }
        
        return elem;
    }
    
    @Override
    public boolean remove(Object o) {
        int index = this.indexOf(o);
        
        if (index == -1) {
            return false;
        }        
        
        this.remove(index);
        
        return true;
    }
        
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isExist = true;
        
        for (Object t : c) {
            if (!this.remove(t)) {
                isExist = false;
            }
        }
        
        return isExist;
    }
    
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isExist = true;
        for (Object t : this.elements) {
            if (!c.contains(t)) {
                if (!this.remove(t)) {
                    isExist = false;
                }
            }
        }
        return isExist;
    }
    
    @Override
    public T set(int index, T element) {
        if (index >= 0 && index < this.sizeArray) {
            T oldElement = this.elements[index];
            
            this.elements[index] = element;
            
            return oldElement;
        }
        else {
            return element;
        }
    }
    
    @Override
    public int size() {
        return this.sizeArray;
    }
    
    @Override
    public Spliterator<T> spliterator() {
        return new ArraySpliterator();
    }
    
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> list = new DynamicArray<>();
        
        this.rangeCheck(fromIndex);
        this.rangeCheck(toIndex);
        
        for (int i = fromIndex; i < toIndex; i++) {
            list.add(get(i));
        }
        
        return list;
    }
    
    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.sizeArray];
        
        System.arraycopy(this.elements, 0, array, 0, this.sizeArray);
        
        return array;
    }
    
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < this.sizeArray)
            return (T[]) Arrays.copyOf(this.elements, this.sizeArray, a.getClass());
        
        System.arraycopy(this.elements , 0, a, 0, this.sizeArray);
        
        if (a.length > this.sizeArray) {
            a[this.sizeArray] = null;
        }

        return a;
    }
    
    public void addRange(Collection<T> collection) {
       Object[] temp = collection.toArray();
       
       while (this.elements.length < this.sizeArray + temp.length) {
           resize(this.elements.length * 2);
       }
       
       System.arraycopy(temp, 0, this.elements, this.sizeArray , temp.length);
       this.sizeArray += temp.length;
    }
    
    private void rangeCheck(int index) {
        if (index >= this.sizeArray || index <0) {
            throw new IndexOutOfBoundsException("Index is not valid");
        }
    }
    
    private class ArrayIterator implements Iterator<T> {
        int index = 0;
        
        public ArrayIterator() {
            index = 0;
        }
        
        public ArrayIterator(int index) {
            this.index = index;
        }
        
        @Override
        public boolean hasNext() {
            return this.index < sizeArray;
        }

        @Override
        public T next() {
            return elements[this.index++];
        }

        @Override
        public void remove() {
            Iterator.super.remove(); //To change body of generated methods, choose Tools | Templates.
        }               
    }
    
    private class DynamicIterator implements ListIterator<T> {
        int index = 0;   
        
        public DynamicIterator() {
            index = 0;
        }
        
        public DynamicIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return this.index < sizeArray;
        }

        @Override
        public T next() {
            return elements[this.index++];
        }

        @Override
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override
        public T previous() {
            return elements[--this.index];
        }

        @Override
        public int nextIndex() {
            if (this.hasNext())
                return this.index;
            else
                return sizeArray;
        }

        @Override
        public int previousIndex() {
            if (this.hasPrevious())
                return this.index-1;
            else
                return sizeArray;
        }

        @Override
        public void remove() {
            DynamicArray.this.remove(this.index);
        }

        @Override
        public void set(T e) {
            DynamicArray.this.set(this.index, e);
        }

        @Override
        public void add(T e) {
            DynamicArray.this.add(this.index,e);
        }        
    }
    
    private class ArraySpliterator implements Spliterator<T> {
        
        
        @Override
        public boolean tryAdvance(Consumer<? super T> action) {
            return true;
        }

        @Override
        public Spliterator<T> trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return 0;
        }

        @Override
        public int characteristics() {
            return 0;
        }
        
    }
}
