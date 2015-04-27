package com.marcomene.statmec.statmec;

import junit.framework.TestCase;

import java.util.List;

public class HiperSquareArrayTest extends TestCase {

    public void testGet() throws Exception {

        HyperSquareArray<Integer> v;
        v = new HyperSquareArray<Integer>(2,2);

        assertEquals(2,v.getDim());

        v.set(1,0,0);
        v.set(2,0,1);
        v.set(3,1,0);
        v.set(4,1,1);

        assertEquals(1,(int)v.get(0,0));
        assertEquals(2,(int)v.get(0,1));
        assertEquals(3,(int)v.get(1,0));
        assertEquals(4,(int)v.get(1,1));

        v = new HyperSquareArray<Integer>(2,3);

        assertEquals(3,v.getDim());

        v.set(1,0,0,0);
        v.set(2,0,0,1);

        assertEquals(1,(int)v.get(0,0,0));
        assertEquals(2,(int)v.get(0,0,1));

        // try corner cases
        v = new HyperSquareArray<Integer>(0,1);

        boolean exFound;

        exFound = false;
        try{
            v = new HyperSquareArray<Integer>(1,0);
        }
        catch (Exception e){
            exFound = true;
        }
        assertTrue(exFound);

        exFound = false;
        try{
            v = new HyperSquareArray<Integer>(1,1);
            v.get(2,2);
        }
        catch (Exception e){
            exFound = true;
        }
        assertTrue(exFound);

        exFound = false;
        try{
            v = new HyperSquareArray<Integer>(1,1);
            v.set(1,2,2);
        }
        catch (Exception e){
            exFound = true;
        }
        assertTrue(exFound);

        v = new HyperSquareArray<Integer>(0,1);  // should be ok to instantiate a zero-length array

    }

    public void testGet2() throws Exception {

        HyperSquareArray<Integer> v;
        v = new HyperSquareArray<Integer>(2,4);

        assertEquals(4,v.getDim());
        assertEquals(16,v.getN());
        assertEquals(2,v.getL());

        v.set(1,0,0,0,0);

        for( int i = 0; i < v.getN(); ++i){
            v.set(i,i);
            assertTrue(v.get(i) == i);
        }

        boolean exFound;

        exFound = false;
        try{
            v.get(v.getN());  // out of index
        }
        catch (Exception e){
            exFound = true;
        }
        assertTrue(exFound);

    }

    public void testIndexing() throws Exception {

        HyperSquareArray<Integer> v;
        v = new HyperSquareArray<Integer>(2,3);

        assertEquals(0,(int)v.linearIndex(0,0,0));
        assertEquals(1,(int)v.linearIndex(0,0,1));
        assertEquals(2,(int)v.linearIndex(0,1,0));
        assertEquals(3,(int)v.linearIndex(0,1,1));
        assertEquals(7,(int)v.linearIndex(1,1,1));

        int[] I;
        // 0,0,0
        I = v.vectorialIndex(0);
        assertTrue(I.length == 3);
        assertEquals(0,I[0]);
        assertEquals(0,I[1]);
        assertEquals(0,I[2]);

        // 1,0,1
        I = v.vectorialIndex(5);
        assertTrue(I.length == 3);
        assertEquals(1,I[0]);
        assertEquals(0,I[1]);
        assertEquals(1,I[2]);

        // 1,1,0
        I = v.vectorialIndex(6);
        assertTrue(I.length == 3);
        assertEquals(1,I[0]);
        assertEquals(1,I[1]);
        assertEquals(0,I[2]);


    }

    public void testGetNeighbors() throws Exception{

        HyperSquareArray<Integer> v;
        v = new HyperSquareArray<Integer>(2,2);

        v.set(1,0,0);
        v.set(2,0,1);
        v.set(3,1,0);
        v.set(4,1,1);

        List<Integer> neighbors;
        neighbors = v.getNeighbors(0,0);
        assertTrue(neighbors.size() == 2);
        assertTrue(neighbors.contains(2));
        assertTrue(neighbors.contains(3));
        assertTrue(!neighbors.contains(4));

        neighbors = v.getNeighbors(0);
        assertTrue(neighbors.size() == 2);
        assertTrue(neighbors.contains(2));
        assertTrue(neighbors.contains(3));
        assertTrue(!neighbors.contains(4));

        neighbors = v.getNeighbors(1,1);
        assertTrue(neighbors.size() == 2);
        assertTrue(neighbors.contains(2));
        assertTrue(neighbors.contains(3));
        assertTrue(!neighbors.contains(1));

        neighbors = v.getNeighbors(3);
        assertTrue(neighbors.size() == 2);
        assertTrue(neighbors.contains(2));
        assertTrue(neighbors.contains(3));
        assertTrue(!neighbors.contains(1));

        v = new HyperSquareArray<Integer>(3,2);

        for(int i = 0; i < 9;++i) {
            v.set(i+1, i);
        }

        neighbors = v.getNeighbors(1,1);
        assertTrue(neighbors.size() == 4);
        assertTrue(neighbors.contains(2));
        assertTrue(neighbors.contains(4));
        assertTrue(neighbors.contains(6));
        assertTrue(neighbors.contains(8));
        assertTrue(!neighbors.contains(1));
        assertTrue(!neighbors.contains(3));
        assertTrue(!neighbors.contains(5));
        assertTrue(!neighbors.contains(7));
        assertTrue(!neighbors.contains(9));

        neighbors = v.getNeighbors(0,1);
        assertTrue(neighbors.size() == 3);
        assertTrue(neighbors.contains(1));
        assertTrue(neighbors.contains(3));
        assertTrue(neighbors.contains(5));
        assertTrue(!neighbors.contains(2));
        assertTrue(!neighbors.contains(4));
        assertTrue(!neighbors.contains(6));
        assertTrue(!neighbors.contains(7));
        assertTrue(!neighbors.contains(8));
        assertTrue(!neighbors.contains(9));


    }

}