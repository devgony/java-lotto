package lotto;

import org.junit.jupiter.api.Test;

import static lotto.Const.LOTTERY_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WalletTest {
    @Test
    void shouldCreate14Lotteries() {
        // given
        Wallet wallet = new Wallet(new Money(14000));
        // when
        wallet.createLotteries();
        // then
        assertThat(wallet.lotteries).hasSize(14);
    }

    @Test
    void buyLotteryShouldTake1000() {
        Wallet wallet = new Wallet(new Money(14000));
        wallet.buyLottery();
        Wallet expected = new Wallet(new Money(14000 - LOTTERY_PRICE));
        assertThat(wallet.moneyEquals(expected)).isTrue();
    }

    @Test
    void lessThan1000CannotBuyLottery() {
        // given
        Wallet wallet = new Wallet(new Money(999));
        // when
        // then
        assertThatThrownBy(() -> wallet.buyLottery()).isInstanceOf(IllegalCallerException.class);
    }
}
