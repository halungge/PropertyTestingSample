package com.zuehlke.mlz.rational;

/**
 * Created by magdalena on 23.09.16.
 */
public class Rational {

    private final int enumerator;
    private final int denominator;

    public Rational(int enumerator) {
        this(enumerator, 1);
    }

    public Rational(int enumerator, int denominator) {
        int ggt = ggt(enumerator, denominator);
        this.enumerator = enumerator/ggt;
        this.denominator = denominator/ggt;
    }

    //TODO this is not tailrecursive...
    private int ggt(int val1, int val2){
        if(val2 == 0) return val1;
        else{
            return ggt(val2, val1 % val2);
        }

    }

    public int getDenominator() {
        return denominator;
    }

    public int getEnumerator() {
        return enumerator;
    }

    public Rational add(Rational number2) {
        int enumerator = this.enumerator * number2.getDenominator() + denominator * number2.getEnumerator();
        int denominator = this.denominator * number2.getDenominator();
    int ggt = ggt(enumerator, denominator);
        return new Rational(enumerator/ggt, denominator/ggt);
    }
}
