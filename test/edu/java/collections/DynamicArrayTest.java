/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.java.collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 *
 * @author Roman
 */
public class DynamicArrayTest {
    
    public DynamicArrayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of size method, of class DynamicArray.
     */
    @Test
    public void testSize() {////////////////success
        System.out.println("size");
        DynamicArray<Integer> instance = new DynamicArray<Integer>();
        int expResult = 0;
        int result = instance.size();
        //1 test
        assertEquals(expResult, result);
        //2 test
        for(int i=0;i< 50;i++)
            instance.Add(i * 4);
        expResult = 50;
        result = instance.size();
        assertEquals(expResult,result);
        //3 test
        for (int i=0;i<25;i++)
            instance.deleteAt(0);
        expResult = 25;
        result = instance.size();
        assertEquals(expResult,result);
    }

    /**
     * Test of Add method, of class DynamicArray.
     */
    @Test
    public void testAdd() {///////////////success
        System.out.println("Add");
        String element = "string instance";
        DynamicArray<String> instance = new DynamicArray<String>();
        instance.Add(element);
        String actual = instance.get(0);
        assertEquals(element,actual);
    }

    

    /**
     * Test of delete method, of class DynamicArray.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        DynamicArray<Integer> instance = new DynamicArray<Integer>();
        int element = 8;
        int expected,actual;
        for(int i=0;i<10;i++)
            instance.Add(i);
        instance.delete(element);
        actual = instance.indexOf(element);
        expected = -1;
        assertEquals(expected,actual);
    }

    /**
     * Test of deleteAt method, of class DynamicArray.
     */
    @Test
    public void testDeleteAt() {
        System.out.println("deleteAt");
        int index = 0;
        DynamicArray instance = new DynamicArray();
        instance.deleteAt(index);
    }

    /**
     * Test of indexOf method, of class DynamicArray.
     */
    @Test
    public void testIndexOf() {////success
        DynamicArray<Integer> instance = new DynamicArray<Integer>();
        for(int i=0;i<10;i++)
            instance.Add(i);
        int result = instance.indexOf(6);
        int expResult = 6;
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class DynamicArray.
     */
    @Test
    public void testGet() {////////////////*
        System.out.println("get");
        DynamicArray<String> instance = new DynamicArray<String>();
        String expResult = "nu11";
        for(int i=0;i<20;i++)
            instance.Add("nu" + i);
        String result = instance.get(11);
        assertEquals(expResult, result);
    }

    /**
     * Test of clear method, of class DynamicArray.
     */
    @Test
    public void testClear() {////////////success
        System.out.println("clear");
        DynamicArray<Integer> instance = new DynamicArray<Integer>();
        int result;
        int expResult;
        for (int i =0;i<23;i++)
            instance.Add(i);
        instance.clear();
        expResult = 0;
        result = instance.size();
        assertEquals(expResult,result);
    }

    /**
     * Test of addRange method, of class DynamicArray.
     */
    @Test
    public void testAddRange() {///////////*
        System.out.println("addRange");
        DynamicArray<Integer> instance = new DynamicArray<Integer>();
        ArrayList<Integer> list  = new ArrayList<Integer>();
        int[] array = new int[100];
        int[] expArray = new int[100];
        for (int i=0;i<100;i++)
        {
            list.add(i*2);
            expArray[i] = i*2;
        }
        instance.addRange(list);
        for (int i=0;i<100;i++)
            array[i] = instance.get(i);
        assertArrayEquals("message",expArray,array);
        
    }
    
}
