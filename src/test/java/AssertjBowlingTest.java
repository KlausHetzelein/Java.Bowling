import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.SoftAssertions;

public class AssertjBowlingTest
{
    @Test
    public void given_1_TotalScore_1()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(1);
        final int totalScore = calculator.getTotalScore();
        final SoftAssertions softly = new SoftAssertions();
        softly.assertThat(totalScore).as("Wir werfen 1").isEqualTo(1).isBetween(1, 10);
        softly.assertAll();
    }

    @Test
    public void given_6_4_4_4_FrameScore_Frame1_14()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(6);
        calculator.Roll(4);
        calculator.Roll(4);
        calculator.Roll(4);

        assertThat(calculator.getFrameScoreOf(1)).as("Frame 1 ist Spare").isEqualTo(14);
        assertThat(calculator.getFrameScoreOf(2)).isEqualTo(8);
    }

    @Test
    public void given_exception()
    {
        assertThatThrownBy(() -> {
            throw new Exception("boom!");
        }).hasMessage("boom!");

        // ... or BDD style
        final Throwable thrown = catchThrowable(() -> {
            throw new Exception("boom!");
        });
        // assertThat(thrown).hasMessageContaining("boom").isExactlyInstanceOf(RuntimeException.class);
    }
}
