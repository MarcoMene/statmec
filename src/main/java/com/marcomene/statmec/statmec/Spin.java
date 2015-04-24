package com.marcomene.statmec.statmec;

/**
 * Created by u0h2247 on 4/24/2015.
 */
public enum Spin {
    UP(1),DW(-1);

    private int value;

    private Spin(int value) {
        this.value = value;
    }

    public int numValue() { return value; }
}
