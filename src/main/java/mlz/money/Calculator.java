package mlz.money;


import java.math.BigDecimal;

public class Calculator {
    public static BigDecimal add(BigDecimal value1, BigDecimal amount2) {

        return value1.add(amount2);
    }

    public static BigDecimal subtract(BigDecimal amount1, BigDecimal amount2) {
        BigDecimal value = amount1.subtract(amount2);
        if(value.compareTo(BigDecimal.ZERO) < 0) {
            return BigDecimal.ZERO;
        }else{
            return value;
        }
    }
}
