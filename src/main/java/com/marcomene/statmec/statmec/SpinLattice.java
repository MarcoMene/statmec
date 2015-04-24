package com.marcomene.statmec.statmec;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by u0h2247 on 4/24/2015.
 */
public class SpinLattice {

    private int N; // number of sites
    private int d; // dimensions
    private int l; // length of a side (lato)


    public SpinLattice(int d, int l) {

        if(d < 1){
            throw new InvalidParameterException("d must be > 0, given: " + d);
        }
        if(l < 1){
            throw new InvalidParameterException("l must be > 0, given: " + l);
        }

        this.d = d;
        this.l = l;
        N = l * d;



    }

    public Spin getSpin(int... I){  // see http://stackoverflow.com/questions/3158730/java-3-dots-in-parameters for dots
        return null;
    }

    public void setSpin(Spin s, int... I){

    }

    public void setRandomSpins() {


    }
}
