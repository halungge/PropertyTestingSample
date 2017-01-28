package mlz.money;

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


    //fails because of empty list..
    @Property
    public void depositMoneyAddsToBalance(List<Coin> handFullOfCoins){
        account.deposit(handFullOfCoins);
        assertTrue("balance is not > 0", account.getBalance().doubleValue() > 0);
    }

}