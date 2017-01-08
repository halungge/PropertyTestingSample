package mlz.money;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.When;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.greaterThan;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeThat;


@RunWith(JUnitQuickcheck.class)
public class CalculatorProperties {

    @Property(trials = 2)
    public void isCommutative(@When(seed = 23L) BigDecimal a, @When(seed=77L)BigDecimal b){
        System.out.printf("testing with a= %2.10f  and b=%2.10f\n", a, b);
        assertEquals(Calculator.add(a, b), Calculator.add(b,a));
    }

    @Property
    public void zeroIsNeutralElement(BigDecimal a){
        assertEquals(a, Calculator.add(a, BigDecimal.ZERO));
    }

    @Property
    public void additionIncreasesAmount(BigDecimal a, BigDecimal b){
        System.out.printf("trying with with a= %2.4f  and b=%2.4f\n", a, b);
        assumeThat(b, greaterThan(BigDecimal.ZERO));
        System.out.printf("assert with a= %2.4f  and b=%2.4f\n", a, b);
        assertTrue("sum is smaller than original value a = " + a, Calculator.add(a, b).compareTo(a) >= 0);
    }
    @Property
    public void fixAdditionIncreasesAmountByConfiguringGenerator(BigDecimal a, @InRange(min = "0")BigDecimal b){
        assertTrue("sum is smaller than original value a = " + a, Calculator.add(a, b).compareTo(a) >= 0);
    }

}