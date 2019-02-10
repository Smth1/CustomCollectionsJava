/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections1;

/**
 *
 * @author Roman
 */
public class JavaApp {
    public static void main(String[] args) {
        DynamicArray<String> array = new DynamicArray<String>();
        array.Add("hello");
        for (int i=0;i<100;i++) {array.Add("hello " + i);}
        System.out.println(array.size());
        for (int i=0;i<array.size();i++)
            System.out.println(array.get(i));
        array.deleteAt(50);
        for (int i=0;i<array.size();i++)
            System.out.println(array.get(i));
        
    }
         
    
}
