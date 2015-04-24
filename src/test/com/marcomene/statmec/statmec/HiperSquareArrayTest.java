package com.marcomene.statmec.statmec;

import junit.framework.TestCase;

public class HiperSquareArrayTest extends TestCase {

    public void testGet() throws Exception {

        HiperSquareArray<Integer> v;
        v = new HiperSquareArray<Integer>(2,2);

        assertEquals(2,v.getDim());

        v.set(1,0,0);
        v.set(2,0,1);
        v.set(3,1,0);
        v.set(4,1,1);

        assertEquals(1,(int)v.get(0,0));
        assertEquals(2,(int)v.get(0,1));
        assertEquals(3,(int)v.get(1,0));
        assertEquals(4,(int)v.get(1,1));


        // try corner cases
        v = new HiperSquareArray<Integer>(0,1);

        boolean exFound;

        exFound = false;
        try{
            v = new HiperSquareArray<Integer>(1,0);
        }
        catch (Exception e){
            exFound = true;
        }
        assertTrue(exFound);

        exFound = false;
        try{
            v = new HiperSquareArray<Integer>(1,1);
            v.get(2,2);
        }
        catch (Exception e){
            exFound = true;
        }
        assertTrue(exFound);

        exFound = false;
        try{
            v = new HiperSquareArray<Integer>(1,1);
            v.set(1,2,2);
        }
        catch (Exception e){
            exFound = true;
        }
        assertTrue(exFound);

    }
}