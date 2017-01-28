package mlz.money;

import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

import java.math.BigDecimal;

import static org.junit.Assert.*;


public class CalculatorTest {
    @Test
    public void addAmounts(){
        BigDecimal amount1 = new BigDecimal("2.3");
        BigDecimal amount2 = new BigDecimal("2.0");
        assertTrue(new BigDecimal("4.3").compareTo(Calculator.add(amount1, amount2)) == 0);
    }

    //but who guarantees that the code also works for values 1000, 2.3 ? or any other I can think of?

    @Test
    public void addZeroDoesNotChangeValue(){
        BigDecimal amount1 = new BigDecimal("2.3");
        BigDecimal amount2 = new BigDecimal("0.0");
        assertTrue(amount1.compareTo(Calculator.add(amount1, amount2)) == 0);
    }


    @Test
    public void addNegativeAmount(){
        BigDecimal amount1 = new BigDecimal("2.3");
        BigDecimal amount2 = new BigDecimal("-2.0");
        assertTrue(new BigDecimal("0.3").compareTo(Calculator.add(amount1, amount2))== 0);
    }


    @Test
    public void addNegativeAmountDoesNotFallBelowZero(){
        BigDecimal amount1 = new BigDecimal("-2.3");
        BigDecimal amount2 = new BigDecimal("2.0");
        assertTrue(new BigDecimal("0.0").compareTo(Calculator.add(amount2, amount1)) == 0);
    }
}