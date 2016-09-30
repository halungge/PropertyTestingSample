package com.zuehlke.mlz.rational;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by magdalena on 23.09.16.
 */
public class RationalTest {

    private Rational number;

    @Test
    public void rationalNumberHasDenominator(){
        int denominator = 7;
        number = new Rational(5, denominator);
        assertEquals(denominator, number.getDenominator());
    }

    @Test
    public void rationalNumberHasEnumerator(){
        int value = 5;
        number =new Rational(value);
        assertEquals(value, number.getEnumerator());

    }
    @Test
    public void rationalIsMaximallyReduced(){
        number = new Rational(3,6);
        assertEquals(1, number.getEnumerator());
        assertEquals(2, number.getDenominator());
    }


    @Test
    public void addTwoRationalNumbersWithSameDenominators(){
        number = new Rational(5,3);
        Rational number2 = new Rational(2,3);
        Rational sum = number.add(number2);
         assertEquals(7, sum.getEnumerator());
        assertEquals(3, sum.getDenominator());
    }

    @Test
    public void addTwoRationalsWithDifferentDenominator(){
        number = new Rational(5,3);
        Rational number2 = new Rational(1,2);
        Rational sum = number.add(number2);
        assertEquals(13, sum.getEnumerator() );
        assertEquals(6, sum.getDenominator());
    }
}