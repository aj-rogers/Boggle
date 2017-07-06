/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.util.ArrayList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
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
public class BoggleUiTest {
    
    public BoggleUiTest() {
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
     * Test of initComponents method, of class BoggleUi.
     */
    @Test
    public void testInitComponents() {
        System.out.println("initComponents");
        BoggleUi instance = null;
        instance.initComponents();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UiMethod method, of class BoggleUi.
     */
    @Test
    public void testUiMethod() {
        System.out.println("UiMethod");
        BoggleUi instance = null;
        instance.UiMethod();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UiMenu method, of class BoggleUi.
     */
    @Test
    public void testUiMenu() {
        System.out.println("UiMenu");
        BoggleUi instance = null;
        JMenuBar expResult = null;
        JMenuBar result = instance.UiMenu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UiButtons method, of class BoggleUi.
     */
    @Test
    public void testUiButtons() {
        System.out.println("UiButtons");
        BoggleUi instance = null;
        JPanel expResult = null;
        JPanel result = instance.UiButtons();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UiText method, of class BoggleUi.
     */
    @Test
    public void testUiText() {
        System.out.println("UiText");
        BoggleUi instance = null;
        JPanel expResult = null;
        JPanel result = instance.UiText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDictionary method, of class BoggleUi.
     */
    @Test
    public void testGetDictionary() {
        System.out.println("getDictionary");
        ArrayList dictWordsArray = null;
        BoggleUi instance = null;
        instance.getDictionary(dictWordsArray);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of timerStart method, of class BoggleUi.
     */
    @Test
    public void testTimerStart() {
        System.out.println("timerStart");
        BoggleUi instance = null;
        instance.timerStart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
