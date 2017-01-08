package mlz.money;

import java.math.BigDecimal;


public class Account {
    private BigDecimal balance;
    public Account(BigDecimal balance) {

        this.balance = balance.abs();
    }

    public Account(){
        this(new BigDecimal("0.0"));
    }


    public void deposit(BigDecimal sum){
        balance = Calculator.add(balance, sum);
    }

    public void withdraw(BigDecimal sum){
        balance = Calculator.subtract(balance, sum);
    }

}
