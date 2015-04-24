package com.marcomene.statmec.statmec;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class HelloWorldTest extends TestCase {

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testHelloWorld() throws Exception {
        HelloWorld.helloWorld();
    }
}