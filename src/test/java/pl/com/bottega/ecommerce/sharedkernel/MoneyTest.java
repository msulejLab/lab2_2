package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import java.util.Currency;

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

    @Test
    public void testAddWithPositiveAddend() {
        Money firstMoney = new Money(50);
        Money secondMoney = new Money(100);

        Money result = firstMoney.add(secondMoney);
        assertThat(result.toString(), is("150,00 " + Money.DEFAULT_CURRENCY));
    }

    @Test
    public void testAddWithNegativeAddend() {
        Money firstMoney = new Money(100);
        Money secondMoney = new Money(-99);

        Money result = firstMoney.add(secondMoney);
        assertThat(result.toString(), is("1,00 " + Money.DEFAULT_CURRENCY));
    }

    @Test
    public void testAddWithZeroAddend() {
        Money firstMoney = new Money(100);
        Money secondMoney = new Money(0);

        Money result = firstMoney.add(secondMoney);
        assertThat(result.toString(), is("100,00 " + Money.DEFAULT_CURRENCY));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithDifferentCurrency() {
        Money firstMoney = new Money(50, Currency.getInstance("PLN"));
        Money secondMoney = new Money(20, Currency.getInstance("CHF"));

        Money result = firstMoney.add(secondMoney);
    }


    @Test
    public void testSubtractWithPositiveSubtrahend() {
        Money firstMoney = new Money(200);
        Money secondMoney = new Money(100);

        Money result = firstMoney.subtract(secondMoney);
        assertThat(result.toString(), is("100,00 " + Money.DEFAULT_CURRENCY));
    }


    @Test
    public void testSubtractWithNegativeSubtrahend() {
        Money firstMoney = new Money(50);
        Money secondMoney = new Money(-120);

        Money result = firstMoney.subtract(secondMoney);
        assertThat(result.toString(), is("170,00 " + Money.DEFAULT_CURRENCY));
    }

    @Test
    public void testSubtractWithZeroSubtrahend() {
        Money firstMoney = new Money(100);
        Money secondMoney = new Money(0);

        Money result = firstMoney.subtract(secondMoney);
        assertThat(result.toString(), is("100,00 " + Money.DEFAULT_CURRENCY));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractWithDifferentCurrency() {
        Money firstMoney = new Money(50, Currency.getInstance("PLN"));
        Money secondMoney = new Money(20, Currency.getInstance("CHF"));

        Money result = firstMoney.subtract(secondMoney);
    }

    @Test
    public void moreIsGreaterThanLess() {
        Money firstMoney = new Money(100);
        Money secondMoney = new Money(50);

        boolean result = firstMoney.greaterThan(secondMoney);
        assertThat(result, is(true));
    }

    @Test
    public void lessIsNotGreaterThanMore() {
        Money firstMoney = new Money(50);
        Money secondMoney = new Money(100);

        boolean result = firstMoney.greaterThan(secondMoney);
        assertThat(result, is(false));
    }

    @Test
    public void sameIsNotGreaterThanSame() {
        Money firstMoney = new Money(100);
        Money secondMoney = new Money(100);

        boolean result = firstMoney.greaterThan(secondMoney);
        assertThat(result, is(false));
    }

    @Test
    public void lessIsLessThanMore() {
        Money firstMoney = new Money(50);
        Money secondMoney = new Money(100);

        boolean result = firstMoney.lessThan(secondMoney);
        assertThat(result, is(true));
    }

    @Test
    public void moreIsNotLessThanLess() {
        Money firstMoney = new Money(100);
        Money secondMoney = new Money(50);

        boolean result = firstMoney.lessThan(secondMoney);
        assertThat(result, is(false));
    }

    @Test
    public void sameIsNotLessThanSame() {
        Money firstMoney = new Money(100);
        Money secondMoney = new Money(100);

        boolean result = firstMoney.lessThan(secondMoney);
        assertThat(result, is(false));
    }

    @Test
    public void lessIsLessOrEqualThanMore() {
        Money firstMoney = new Money(50);
        Money secondMoney = new Money(100);

        boolean result = firstMoney.lessOrEquals(secondMoney);
        assertThat(result, is(true));
    }

    @Test
    public void moreIsNotLessOrEqualThanLess() {
        Money firstMoney = new Money(100);
        Money secondMoney = new Money(50);

        boolean result = firstMoney.lessOrEquals(secondMoney);
        assertThat(result, is(false));
    }

    @Test
    public void sameIsLessOrEqualThanSame() {
        Money firstMoney = new Money(100);
        Money secondMoney = new Money(100);

        boolean result = firstMoney.lessOrEquals(secondMoney);
        assertThat(result, is(true));
    }
}
