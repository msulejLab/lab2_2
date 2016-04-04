package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import static org.hamcrest.Matchers.is;

import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void testMultiplyByWithPositiveMultiplier() {
        Money money = new Money(300);
        double multiplier = 5;

        Money result = money.multiplyBy(multiplier);
        assertThat(result.toString(), is("1500,00 " + Money.DEFAULT_CURRENCY));
    }

    @Test
    public void testMultiplyByWithNegativeMultiplier() {
        Money money = new Money(50);
        double multiplier = -5;

        Money result = money.multiplyBy(multiplier);
        assertThat(result.toString(), is("-250,00 " + Money.DEFAULT_CURRENCY));
    }

    @Test
    public void testMultiplyByWithZeroMultiplier() {
        Money money = new Money(50);
        double multiplier = 0;

        Money result = money.multiplyBy(multiplier);
        assertThat(result.toString(), is("0,00 " + Money.DEFAULT_CURRENCY));
    }
}
