package mlz.money;

import java.math.BigDecimal;
import java.util.List;


public class Account {
    private BigDecimal balance;
    private Account(BigDecimal balance) {
        this.balance = balance.abs();
        this.balance.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public Account(){
        this(new BigDecimal("0.0"));
    }


    public void deposit(List<Coin> coins){
       balance = newBalance(balance, coins);

    }

    public void deposit(Money money){
        balance = Calculator.add(balance, money.value());
    }

    private BigDecimal newBalance(BigDecimal balance, List<Coin> increment){
        return increment.stream().map(m -> m.value()).reduce(balance, Calculator::add);
    }

    public BigDecimal getBalance(){
        return balance;
    }

    //TODO remove subtract
    public void withdraw(BigDecimal sum){
        balance = Calculator.subtract(balance, sum);
    }

}
