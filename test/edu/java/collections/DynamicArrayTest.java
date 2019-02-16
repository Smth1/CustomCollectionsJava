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
    public void testSizeEmpty() {///success
        DynamicArray<Integer> instance = new DynamicArray<Integer>();
        int expResult = 0;
        int result = instance.size();
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of Size method, of class DynamicArray
     */
    @Test
    public void testSizeFull() {///success
        DynamicArray<Integer> instance = new DynamicArray<Integer>();
        int expResult;
        int result;
        
        for(int i=0;i< 50;i++)
            instance.Add(i * 4);
        
        expResult = 50;
        result = instance.size();
        assertEquals(expResult,result);
    }
    
    /**
     * Test of Size method, of class DynamicArray
     */
    @Test
    public void testSizeModified() {///success
        DynamicArray<Integer> instance = new DynamicArray<Integer>();
        int expResult;
        int result;
        
        for(int i=0;i< 50;i++)
            instance.Add(i * 4);
        
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
    public void testAdd() {///success
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
    public void testDeleteDefault() {///success
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
     * Test of delete method, of class DynamicArray.
     */
    @Test
    public void testDeleteEmpty() {///success
        DynamicArray<Integer> instance = new DynamicArray<Integer>();
        int element = 8;
        int expected,actual;
        
        instance.delete(element);
        
        actual = instance.indexOf(element);
        expected = -1;
        
        assertEquals(expected,actual);
    }
    
    /**
     * Test of delete method, of class DynamicArray
     */
    @Test
    public void TestDeleteNotExist() {///success
        DynamicArray<Integer> instance = new DynamicArray<Integer>();
        int element = 18;
        int expected,actual;
        
        for(int i=0;i<10;i++)
            instance.Add(i);
        
        instance.delete(element);
        actual = instance.indexOf(element);
        expected = -1;
        
        assertEquals(expected,actual);
    }
    
    /**
     * Test of delete method, of class DynamicArray
     */
    @Test
    public void testDeleteBegin() {///success
        DynamicArray<Integer> instance = new DynamicArray<Integer>();
        int element = 0;
        int expected,actual;
        
        for(int i=0;i<10;i++)
            instance.Add(i);
        
        instance.delete(element);
        actual = instance.get(element);
        expected = 1;
        
        assertEquals(expected,actual);
    }
    
    /**
     * Test of delete method, of class DynamicArray.
     */
    @Test
    public void testDeleteEnd() {///success
        DynamicArray<Integer> instance = new DynamicArray<Integer>();
        int element = 9;
        int expected,actual;
        
        for(int i=0;i<10;i++)
            instance.Add(i);
        
        instance.delete(element);
        actual = instance.get(element-1);
        expected = 8;
        
        assertEquals(expected,actual);
    }
    
    /**
     * Test of deleteAt method, of class DynamicArray.
     */
    @Test
    public void testDeleteAtInside() {///success
        DynamicArray<Integer> instance = new DynamicArray<Integer>();
        int index = 5;
        int actual,expected;
        
        for(int i=0;i<10;i++)
            instance.Add(i);
        
        instance.deleteAt(index);
        actual = instance.get(index);
        expected = 6;
        
        assertEquals(expected,actual);
    }
    
    /**
     * Test of deleteAt method, of class DynamicArray.
     */
    @Test
    public void testDeleteAtOutside() {///success
        DynamicArray<Integer> instance = new DynamicArray<Integer>();
        int index = 15;
        int actual,expected;
        
        for(int i=0;i<10;i++)
            instance.Add(i);
        
        instance.deleteAt(index);
        actual = instance.size();
        expected = 10;
        
        assertEquals(expected,actual);
    }
    
    /**
     * Test of indexOf method, of class DynamicArray.
     */
    @Test
    public void testIndexOfInside() {////success
        DynamicArray<Integer> instance = new DynamicArray<Integer>();
        int result;
        int expResult;
        
        for(int i=0;i<10;i++)
            instance.Add(i);
        
        result = instance.indexOf(6);
        expResult = 6;
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of indexOf method, of class DynamicArray.
     */
    @Test
    public void testIndexOfNotExist() {///success
        DynamicArray<Integer> instance = new DynamicArray<Integer>();
        int result;
        int expResult;
        
        for(int i=0;i<10;i++)
            instance.Add(i);
        
        result = instance.indexOf(11);
        expResult = -1;
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of get method, of class DynamicArray.
     */
    @Test
    public void testGet() {////////////////success
        DynamicArray<String> instance = new DynamicArray<String>();
        String expResult = "nu11";
        String result;
        
        for(int i=0;i<20;i++)
            instance.Add("nu" + i);
        result = instance.get(11);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of clear method, of class DynamicArray.
     */
    @Test
    public void testClearDefault() {////////////success
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
     * Test of clear method,of class DynamicArray.
     */
    public void testClearEmpty() {///success
        DynamicArray<Integer> instance = new DynamicArray<Integer>();
        int result;
        int expResult;       
        
        instance.clear();
        expResult = 0;
        result = instance.size();
        
        assertEquals(expResult,result);
    }
    
    /**
     * Test of addRange method, of class DynamicArray.
     */
    @Test
    public void testAddRange() {///////////success
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
