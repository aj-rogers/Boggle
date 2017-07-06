/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AJ Rogers
 */
public class DieTest {
    
    public DieTest() {
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
     * Test of randomLetter method, of class Die.
     */
    @Test
    public void testRandomLetter() {
        System.out.println("randomLetter");
        Die instance = new Die();
        instance.randomLetter();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLetter method, of class Die.
     */
    @Test
    public void testGetLetter() {
        System.out.println("getLetter");
        Die instance = new Die();
        String expResult = "";
        String result = instance.getLetter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLetter method, of class Die.
     */
    @Test
    public void testAddLetter() {
        System.out.println("addLetter");
        String face = "";
        Die instance = new Die();
        instance.addLetter(face);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAllLetters method, of class Die.
     */
    @Test
    public void testDisplayAllLetters() {
        System.out.println("displayAllLetters");
        Die instance = new Die();
        instance.displayAllLetters();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
