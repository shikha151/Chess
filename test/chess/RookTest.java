/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import Chess.Rook;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author test
 */
public class RookTest {
    
    public RookTest() {
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
     * Test of getPossibleInitialPositions method, of class Rook.
     */
    @Test
    public void testGetPossibleInitialPositions() {
        System.out.println("getPossibleInitialPositions");
        String Position = "e3";
        Rook instance = new Rook();
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("f3");
        expResult.add("g3");
        expResult.add("h3");
        expResult.add("d3");
        expResult.add("c3");
        expResult.add("b3");
        expResult.add("a3");
        expResult.add("e2");
        expResult.add("e1");
        expResult.add("e4");
        expResult.add("e5");
        expResult.add("e6");
        expResult.add("e7");
        expResult.add("e8");
        
        
        ArrayList<String> result = instance.getPossibleInitialPositions(Position);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of main method, of class Rook.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Rook.main(args);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
