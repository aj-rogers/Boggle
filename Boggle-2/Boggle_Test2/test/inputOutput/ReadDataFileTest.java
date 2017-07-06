/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputOutput;

import java.util.ArrayList;
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
public class ReadDataFileTest {
    
    public ReadDataFileTest() {
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
     * Test of populateData2 method, of class ReadDataFile.
     */
    @Test
    public void testPopulateData2() {
        System.out.println("populateData2");
        ReadDataFile instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.populateData2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populateData method, of class ReadDataFile.
     */
    @Test
    public void testPopulateData() {
        System.out.println("populateData");
        ReadDataFile instance = null;
        instance.populateData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class ReadDataFile.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        ReadDataFile instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
