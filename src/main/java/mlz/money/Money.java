package mlz.money;

import java.math.BigDecimal;


public class Money {

    private BigDecimal value;

    /**
     * instantiates Money with BigDecimal, the BigDecimal is assumed to be positive
     * for safety the Money is instantiated with its abs value
     * @param value
     */
    public Money(BigDecimal value){
        this.value = value.abs();
        this.value.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal value(){
        return value;
    }

    public String toString(){
        return value().toString();
    }

}
