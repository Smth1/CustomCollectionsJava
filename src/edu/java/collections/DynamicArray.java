/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.java.collections;

import java.util.*;

/**
 *
 * @author Roman
 * @param <T>
 */
public class DynamicArray<T> {
    private T elements[];
    
    private int sizeArray;
    
    public int size() {
        return sizeArray;
    }
    
    public DynamicArray(int initialSize) {
        this.elements = (T[])new Object[initialSize];
        sizeArray = 0;
    }
    
    public DynamicArray() {
        this(10);
    }
    
    public DynamicArray(T[] array) {
        this.elements = (T[])new Object[array.length];
        System.arraycopy(array, 0, elements, 0 , array.length);
        sizeArray = array.length;
    }
    
    public void Add(T element) {
        if (sizeArray == elements.length)
            resize(this.elements.length * 2);
        
            elements[sizeArray++] = element;
    }
    
    public void resize(int newSize) {
        if (newSize > this.elements.length) {
            Object[] newArray = new Object[newSize];
            System.arraycopy(this.elements, 0, newArray, 0, this.elements.length);
            this.elements = (T[])newArray;
        }
    }
    
    public void delete(T element) {
        int index = indexOf(element);
        
        if (index != -1)
            System.arraycopy(elements, index + 1, elements, index, sizeArray-index);
        
        sizeArray--;
    }
    
    public void deleteAt(int index) {
        if ((index >= 0) && (index < sizeArray))
            System.arraycopy(elements, index + 1, elements, index, sizeArray-index);
        
        sizeArray--;
    }
    
    public int indexOf(T element) {
        for(int i = 0; i < sizeArray; i++) {
            if (element == elements[i])
                return i;
        }
        return -1;
    }
    
    public T  get(int index) {
        rangeCheck(index);
        return (T) elements[index];
    }
    
    private void rangeCheck(int index) {
        if (index >= sizeArray)
            throw new IndexOutOfBoundsException("Array owerflowed");
    }
    
    public void clear() {
        for (int i = 0; i < sizeArray; i++)
            elements[i] = null;
        
        sizeArray = 0;
    }
    
    public void addRange(Collection<T> collection) {
       Object[] temp = collection.toArray();
       
       rangeCheck(sizeArray + temp.length);
       System.arraycopy(temp, 0, this.elements, this.sizeArray , temp.length);
       sizeArray += temp.length;
    }
}