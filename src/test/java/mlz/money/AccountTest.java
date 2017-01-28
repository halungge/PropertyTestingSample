package mlz.money;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class AccountTest {
    private Account account;
    @Before
    public void setUp() throws Exception {
        account = new Account();

    }

    @Test
    public void newlyCreatedAccountHasZeroBalance(){
        assertTrue("initial balance is not 0", new BigDecimal("0.0").compareTo(account.getBalance()) == 0);
    }

    @Test
    public void depositAddsBalance() throws Exception {
        account.deposit(Arrays.asList(Coin.QUARTER, Coin.QUARTER, Coin.FIVE, Coin.FIVE, Coin.ONE));
        assertTrue("balance was " + account.getBalance(), new BigDecimal("11.50").compareTo(account.getBalance()) == 0);

    }

    @Test
    public void depositTwiceAddsToBalance() throws Exception {
        //same as before
        account.deposit(Arrays.asList(Coin.QUARTER, Coin.QUARTER, Coin.FIVE, Coin.FIVE, Coin.ONE));
        //add another 1 = 2 * 0.5
        account.deposit(Arrays.asList(Coin.HALF, Coin.HALF));
        assertTrue("balance was " + account.getBalance(), new BigDecimal("12.50").compareTo(account.getBalance()) == 0);

    }

    @Test
    public void withdrawDecreasesBalance(){
        account.deposit(new Money(BigDecimal.TEN));
        Money subtracted = new Money(new BigDecimal("5.70"));
        account.withdraw(subtracted);
        assertTrue(" balance " + account.getBalance() + " was not 4.30", new BigDecimal("4.30").compareTo(account.getBalance()s)==0 );
    }


    //fails because of empty list..
    @Property
    public void depositCoinsIncreasesBalance(List<Coin> handFullOfCoins){
        account.deposit(handFullOfCoins);
        assertTrue("balance is not > 0", account.getBalance().doubleValue() > 0);
    }


    @Test
    public void depositedMoneyAddsToBalance() {
        BigDecimal amount = new BigDecimal("13.50");
        account.deposit(new Money(amount));
        assertTrue("balance is not 13.50", amount.compareTo(account.getBalance()) == 0);
    }

    @Test
    public void depositingTwiceAddsTotalSum() {
        BigDecimal ten = new BigDecimal("10.0");
        account.deposit(new Money(ten));
        BigDecimal threeFifty = new BigDecimal("3.50");
        account.deposit(new Money(threeFifty));
        assertTrue("balance is not 13.50", new BigDecimal("13.50").compareTo(account.getBalance()) == 0);
    }



    //fails due to missing generator
    @Property
    public void depositedAmountAddsToBalance(@From(MoneyGenerator.class) Money amount){
        account.deposit(amount);
        assertTrue("balance should be equal to amount", amount.value().compareTo(account.getBalance()) == 0);
    }


    @Property
    public void depositMoneyIncreasesBalance(@From(MoneyGenerator.class) Money amount1, @From(MoneyGenerator.class) Money amount2){
        account.deposit(amount1);
        account.deposit(amount2);
        assertTrue("balance should be larger than amount1", amount1.value().compareTo(account.getBalance()) <= 0);
        assertTrue("balance should be larger than amount2", amount2.value().compareTo(account.getBalance()) <= 0);

    }



}