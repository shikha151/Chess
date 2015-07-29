/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import Chess.Knight;
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
public class KnightTest {
    
    public KnightTest() {
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
     * Test of getPossibleInitialPositions method, of class Knight.
     */
    @Test
    public void testGetPossibleInitialPositions() {
        System.out.println("getPossibleInitialPositions");
        String Position = "h8";
        Knight instance = new Knight();
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("f7");
        expResult.add("g6");
        ArrayList<String> result = instance.getPossibleInitialPositions(Position);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
