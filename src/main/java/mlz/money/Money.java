package mlz.money;

import java.math.BigDecimal;


public class Money {

    private BigDecimal value;
    public Money(BigDecimal value){
        this.value = value;
        this.value.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal value(){
        return value;
    }

}
