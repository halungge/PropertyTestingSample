package mlz.money;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.When;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.*;


@RunWith(JUnitQuickcheck.class)
public class CalculatorProperties {

    @Property(trials = 2)
    public void additionIsCommutative(@When(seed = 23L) BigDecimal a, @When(seed=77L)BigDecimal b){
        System.out.printf("testing with a= %2.10f  and b=%2.10f\n", a, b);
        assertEquals(Calculator.add(a, b), Calculator.add(b,a));
    }

    @Property
    public void zeroIsNeutralElement(BigDecimal a){
        assertEquals(a, Calculator.add(a, BigDecimal.ZERO));
    }

    @Property
    public void additionIncreasesAmount(BigDecimal a, BigDecimal b){
        assertTrue(Calculator.add(a, b).compareTo(a) >= 0);
    }

}