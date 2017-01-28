package mlz.money;

import java.math.BigDecimal;


public enum Coin{
    ONE(BigDecimal.ONE),
    TWO(new BigDecimal("2.00")),
    FIVE(new BigDecimal("5.00")),
    HALF(new BigDecimal("0.50")),
    QUARTER(new BigDecimal("0.25"));


    private BigDecimal value;

    private Coin(BigDecimal value){
        this.value = value;
    }
    public BigDecimal value(){
        return value;
    }



}
