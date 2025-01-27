package string_calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValueTest {
    @Test
    void create() {
        assertThat(new Integer(1)).isInstanceOf(Integer.class);
        assertThat(Operator.MULTIPLY).isInstanceOf(Operator.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"!", "@", "#", "$", "^", "&"})
    void wrongOperator(String input) {
        Parser parser = new Parser();
        assertThatThrownBy(() -> Operator.create(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/", "%"})
    void collectOperator(String input) {
        Parser parser = new Parser();
        assertThat(Operator.create(input)).isInstanceOf(Operator.class);
    }
}
