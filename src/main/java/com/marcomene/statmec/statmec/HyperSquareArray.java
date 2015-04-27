package com.marcomene.statmec.statmec;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by u0h2247 on 4/24/2015.
 */
public class HyperSquareArray<T> {

    private int d;
    private int l;
    private int N;
    private T[] underlying;

    public HyperSquareArray(int l, int d) {

        if (d < 1) {
            throw new InvalidParameterException("d must be > 0, given: " + d);
        }
        if (l < 0) {
            throw new InvalidParameterException("l must be >= 0, given: " + l);
        }

        this.d = d;
        this.l = l;
        N = (int) Math.pow(l, d);

        underlying = (T[]) new Object[N];
    }

    public int getDim() {
        return d;
    }

    public int getL() {
        return l;
    }

    public int getN() {
        return N;
    }

    public T get(int i) throws Exception {  // access directly the underlying, useful for iterating
        if (l == 0) return null;

        return underlying[i]; // automatic exception if index out of range
    }

    public void set(T s, int i) throws Exception {  // access directly the underlying, useful for iterating
        if (l == 0) return;

        underlying[i] = s; // automatic exception if index out of range
    }

    public T get(int... I) throws Exception {  // see http://stackoverflow.com/questions/3158730/java-3-dots-in-parameters for dots
        if (l == 0) return null;

        return underlying[linearIndex(I)];
    }

    public void set(T s, int... I) throws Exception {
        if (l == 0) return;

        underlying[linearIndex(I)] = s;
    }

    // get the list of Ts surrounding I
    public List<T> getNeighbors(int... I) throws Exception {

        if (l == 0) return null;

        List<T> neighbors = new LinkedList<T>();
        int[] tmpI = I.clone();
        for (int dd = 0; dd < d; ++dd) {
            if (I[dd] > 0) { // to handle corner cases
                tmpI[dd] = I[dd] - 1;
                neighbors.add(get(tmpI));
                tmpI[dd] = I[dd]; // revert to old one once you've used it
            }
            if (I[dd] < l - 1) {
                tmpI[dd] = I[dd] + 1;
                neighbors.add(get(tmpI));
                tmpI[dd] = I[dd]; // revert to old one once you've used it
            }
        }
        return neighbors;
    }

    public List<T> getNeighbors(int i) throws Exception {
        return getNeighbors(vectorialIndex(i));
    }

    //TODO: getNeighborsCouples, test it

    // translate vectorial index to linear one
    public Integer linearIndex(int... I) throws Exception {

        if (l == 0) return null;

        if (I.length > d) {
            throw new Exception("Index length is greater than array dimensions(" + d + "): I.length: " + I.length);
        }

        int internalIndex = 0;
        for (int i = 1; i <= I.length; ++i) {
            if (I[i - 1] >= l || I[i - 1] < 0) { // cannot go beyond the side size
                throw new Exception("I value is not within the bounds([0," + l + "]): " + I[i - 1]);
            }
            internalIndex += (int) Math.pow(l, d - i) * I[i - 1];
        }
        return internalIndex;
    }

    // translate linear index to vectorial one
    public int[] vectorialIndex(int i) throws Exception {

        if (l == 0) return null;

        if (i >= N || i < 0) { // cannot go beyond the side size
            throw new Exception("i value is not within the bounds([0," + (N - 1) + "]): " + i);
        }

        int[] I = new int[d];
        for (int j = 1; j <= d; ++j) {
            I[j - 1] = (i / ((int) Math.pow(l, d - j))) % l;
        }
        return I;
    }

}
