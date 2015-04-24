package com.marcomene.statmec.statmec;

import junit.framework.TestCase;

public class SpinTest extends TestCase {

    public void testSpinEnum() throws Exception {

        Spin spin;

        spin = Spin.UP;
        assertEquals(1,spin.numValue() );

        spin = Spin.DW;
        assertEquals(-1,spin.numValue() );

    }

}