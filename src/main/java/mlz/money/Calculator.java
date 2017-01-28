package mlz.money;


import java.math.BigDecimal;

public class Calculator {
    public static BigDecimal add(BigDecimal value1, BigDecimal amount2) {
        BigDecimal value = value1.add(amount2);
        if(value.compareTo(BigDecimal.ZERO) < 0) {
            return BigDecimal.ZERO;
        }else{
            return value;
        }

    }

}
