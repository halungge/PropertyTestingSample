package mlz.money;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.*;


@RunWith(JUnitQuickcheck.class)
public class CalculatorProperties {

    @Property
    public void additionIsCommutative(BigDecimal a, BigDecimal b){

        assertEquals(Calculator.add(a, b), Calculator.add(b,a));
    }

}