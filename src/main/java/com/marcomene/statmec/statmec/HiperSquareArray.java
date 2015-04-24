package com.marcomene.statmec.statmec;

import javax.management.OperationsException;
import java.security.InvalidParameterException;

/**
 * Created by u0h2247 on 4/24/2015.
 */
public class HiperSquareArray<T> {

    private int d;
    private int l;
    private int N;
    private T[] underlying;

    public HiperSquareArray(int l, int d) {

        if(d < 1){
            throw new InvalidParameterException("d must be > 0, given: " + d);
        }
        if(l < 0){
            throw new InvalidParameterException("l must be >= 0, given: " + l);
        }

        this.d = d;
        this.l = l;
        N = (int)Math.pow(l,d);

        underlying = (T[])new Object[N];
    }

    public int getDim() {
        return d;
    }

    public T get(int... I) throws Exception {  // see http://stackoverflow.com/questions/3158730/java-3-dots-in-parameters for dots

        return underlying[internalIndex(I)];
    }

    public void set(T s, int... I) throws Exception {

        underlying[internalIndex(I)] = s;
    }

    private int internalIndex(int[] I) throws Exception {

        if(I.length > d){
            throw new Exception("Index length is greater than array dimensions(" + d + "): I.length: " + I.length );
        }

        int internalIndex = 0;
        for (int i = 1; i <= I.length; ++i) {
            if(I[i-1] >= l || I[i-1] < 0){ // cannot go beyond the side size
                throw new Exception("I value is not within the bounds([0,"+l+"]): " + I[i-1] );
            }
            internalIndex += (int)Math.pow(l,d-i) * I[i-1]  ;
        }
        return internalIndex;
    }




}
