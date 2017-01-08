package mlz.money;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.*;


@RunWith(JUnitQuickcheck.class)
public class CalculatorProperties {

    @Property(trials = 100)
    public void additionIsCommutative(BigDecimal a, BigDecimal b){
        System.out.printf("testing with a= %2.10f  and b=%2.10f\n", a, b);
        assertEquals(Calculator.add(a, b), Calculator.add(b,a));
    }

}