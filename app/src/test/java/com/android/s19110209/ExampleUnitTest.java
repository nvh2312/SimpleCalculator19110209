package com.android.s19110209;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)

public class ExampleUnitTest {
    private Calculator mCalculator;
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    //ADD
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(2d, 1d);
        assertThat(resultAdd, is(equalTo(3d)));
    }

    @Test
    public void addTwoNumbersNegative() {
        double resultAdd = mCalculator.add(-5d, 2d);
        assertThat(resultAdd, is(equalTo(3d)));
    }

    @Test
    public void addTwoNumbersWorksWithNegativeResult() {
        double resultAdd = mCalculator.add(-2d, -2d);
        assertThat(resultAdd, is(equalTo(-4d)));
    }

    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = mCalculator.add(1.123d, 1.123d);
        assertThat(resultAdd, is(equalTo(2.246)));
    }

    @Test
    public void addTwoNumbersBigums() {
        double resultAdd = mCalculator.add(223456781d, 211111111d);
        assertThat(resultAdd, is(equalTo(434567892d)));
    }

    //SUB
    @Test
    public void subTwoNumbers() {
        double resultSub = mCalculator.sub(2d, 1d);
        assertThat(resultSub, is(equalTo(1d)));
    }
    @Test
    public void subWorksWithNegativeResult() {
        double resultSub = mCalculator.sub(1d, 3d);
        assertThat(resultSub, is(equalTo(-2d)));
    }

    @Test
    public void subTwoNumbersNegative() {
        double resultSub = mCalculator.sub(-1d, -2d);
        assertThat(resultSub, is(equalTo(1d)));
    }
    @Test
    public void subTwoNumbersFloats() {
        double resultSub = mCalculator.sub(2.222d, 1.111d);
        assertThat(resultSub, is(equalTo(1.111d)));
    }
    @Test
    public void subTwoNumbersBignums() {
        double resultSub = mCalculator.sub(234567892d, 111111111d);
        assertThat(resultSub, is(equalTo(123456781d)));
    }
    //MUL
    @Test
    public void mulTwoNumbers() {
        double resultMul = mCalculator.mul(2d, 2d);
        assertThat(resultMul, is(equalTo(4d)));
    }
    @Test
    public void mulTwoNumbersZero() {
        double resultMul = mCalculator.mul(2d, 0d);
        assertThat(resultMul, is(equalTo(0d)));
    }
    @Test
    public void mulTwoNumbersNegative() {
        double resultMul = mCalculator.mul(-2d, -1d);
        assertThat(resultMul, is(equalTo(2d)));
    }
    @Test
    public void mulWorksWithNegativeResult() {
        double resultMul = mCalculator.mul(-2d, 1d);
        assertThat(resultMul, is(equalTo(-2d)));
    }
    @Test
    public void mulTwoNumbersNegativeAndZero() {
        double resultMul = mCalculator.mul(-2d, 0d);
        assertThat(resultMul, is(equalTo(-0d)));
    }
    @Test
    public void mulTwoNumbersFloats() {
        double resultMul = mCalculator.mul(0.5d, 0.5d);
        assertThat(resultMul, is(equalTo(0.25d)));
    }
    //DIV
    @Test
    public void divTwoNumbers() {
        double resultDiv = mCalculator.div(4d, 2d);
        assertThat(resultDiv, is(equalTo(2d)));
    }
    @Test
    public void divTwoNumbersZero() {
        double resultDiv = mCalculator.div(32d,0);
        assertThat(resultDiv, is(equalTo(Double.POSITIVE_INFINITY)));
    }
    @Test
    public void divTwoNumbersNegative() {
        double resultDiv = mCalculator.div(-4d, -2d);
        assertThat(resultDiv, is(equalTo(2d)));
    }
    @Test
    public void divWorksWithNegativeResult() {
        double resultDiv = mCalculator.div(-4d, 2d);
        assertThat(resultDiv, is(equalTo(-2d)));
    }
    @Test
    public void divTwoNumbersBignums() {
        double resultDiv = mCalculator.div(999999999d, 333333333d);
        assertThat(resultDiv, is(equalTo(3d)));
    }
    @Test
    public void divTwoNumbersFloats() {
        double resultDiv = mCalculator.div(0.25d, 0.5d);
        assertThat(resultDiv, is(equalTo(0.5d)));
    }
    //POW
    @Test
    public void powTwoNumbers() {
        double resultPow = mCalculator.pow(2d, 3d);
        assertThat(resultPow, is(equalTo(8d)));
    }
    @Test
    public void powTwoNumbersNegative() {
        double resultPow = mCalculator.pow(2d, -2d);
        assertThat(resultPow, is(equalTo(0.25d)));
    }
    @Test
    public void powTwoNumbersFloats() {
        double resultPow = mCalculator.pow(0.25d, 0.5d);
        assertThat(resultPow, is(equalTo(0.5d)));
    }
    @Test
    public void powWorksWithNegativeResult() {
        double resultPow = mCalculator.pow(-2d, 3d);
        assertThat(resultPow, is(equalTo(-8d)));
    }
    @Test
    public void powTwoNumbersBignums() {
        double resultPow = mCalculator.pow(999999999d, 333333333d);
        assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }
    //FACT
    @Test
    public void factNumber() {
        double resultFact = mCalculator.fact(3d);
        assertThat(resultFact, is(equalTo(6d)));
    }
    @Test
    public void factNumberNegative() {
        double resultFact = mCalculator.fact(-3d);
        assertThat(resultFact, is(equalTo(0d)));
    }
    @Test
    public void factNumberFloat() {
        double resultFact = mCalculator.fact(0.5d);
        assertThat(resultFact, is(equalTo(0d)));
    }
    @Test
    public void factBignum() {
        double resultFact = mCalculator.fact(34d);
        assertThat(resultFact, is(equalTo(0d)));
    }
    @Test
    public void factWithZero() {
        double resultFact = mCalculator.fact(0d);
        assertThat(resultFact, is(equalTo(1d)));
    }
    //LOG
    @Test
    public void logTwoNumbers() {
        double resultLog = mCalculator.log(2d, 4d);
        assertThat(resultLog, is(equalTo(2d)));
    }
    @Test
    public void logTwoNumbersNegative() {
        double resultLog = mCalculator.log(2d, -3d);
        assertThat(resultLog, is(equalTo(Double.NaN)));
    }
    @Test
    public void logTwoNumbersBaseNegative() {
        double resultLog = mCalculator.log(-2d, 3d);
        assertThat(resultLog, is(equalTo(Double.NaN)));
    }
    @Test
    public void logTwoNumbersFloats() {
        double resultLog = mCalculator.log(0.25d, 0.5d);
        assertThat(resultLog, is(equalTo(0.5d)));
    }
    @Test
    public void logTwoNumbersBaseE() {
        double resultLog = mCalculator.log(Math.E, 1d);
        assertThat(resultLog, is(equalTo(0d)));
    }
}