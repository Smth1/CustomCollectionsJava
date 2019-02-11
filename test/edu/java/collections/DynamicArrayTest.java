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
    public void testSize() {
        System.out.println("size");
        DynamicArray instance = new DynamicArray();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Add method, of class DynamicArray.
     */
    @Test
    public void testAdd() {
        System.out.println("Add");
        Object element = null;
        DynamicArray instance = new DynamicArray();
        instance.Add(element);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resize method, of class DynamicArray.
     */
    @Test
    public void testResize() {
        System.out.println("resize");
        int newSize = 0;
        DynamicArray instance = new DynamicArray();
        instance.resize(newSize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DynamicArray.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Object element = null;
        DynamicArray instance = new DynamicArray();
        instance.delete(element);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of indexOf method, of class DynamicArray.
     */
    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        Object element = null;
        DynamicArray instance = new DynamicArray();
        int expResult = 0;
        int result = instance.indexOf(element);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class DynamicArray.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        DynamicArray instance = new DynamicArray();
        Object expResult = null;
        Object result = instance.get(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class DynamicArray.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        DynamicArray instance = new DynamicArray();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRange method, of class DynamicArray.
     */
    @Test
    public void testAddRange() {
        System.out.println("addRange");
        DynamicArray instance = new DynamicArray();
        instance.addRange(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
