import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BowlingTests
{
    @Test
    public void given_1_TotalScore_1()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(1);
        final int totalScore = calculator.getTotalScore();

        assertEquals(1, totalScore);
    }

    @Test
    public void given_1_3_TotalScore_4()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(1);
        calculator.Roll(3);
        final int totalScore = calculator.getTotalScore();

        assertEquals(4, totalScore);
    }

    @Test
    public void given_4_6_4_TotalScore_18()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(4);
        calculator.Roll(6);
        calculator.Roll(4);
        final int totalScore = calculator.getTotalScore();

        assertEquals(18, totalScore);
    }

    @Test
    public void given_4_6_4_3_TotalScore_21()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(4);
        calculator.Roll(6);
        calculator.Roll(4);
        calculator.Roll(3);
        final int totalScore = calculator.getTotalScore();

        assertEquals(21, totalScore);
    }


    @Test
    public void given_4_6_4_6_5_TotalScore_34()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(4);
        calculator.Roll(6);
        calculator.Roll(4);
        calculator.Roll(6);
        calculator.Roll(5);
        final int totalScore = calculator.getTotalScore();

        assertEquals(34, totalScore);
    }

    @Test
    public void given_4_6_4_6_TotalScore_24()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(4);
        calculator.Roll(6);
        calculator.Roll(4);
        calculator.Roll(6);
        final int totalScore = calculator.getTotalScore();

        assertEquals(24, totalScore);
    }

    @Test
    public void given_10_4_TotalScore_18()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(10);
        calculator.Roll(4);
        final int totalScore = calculator.getTotalScore();

        assertEquals(18, totalScore);
    }

    @Test
    public void given_10_4_4_TotalScore_26()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(10);
        calculator.Roll(4);
        calculator.Roll(4);
        final int totalScore = calculator.getTotalScore();

        assertEquals(26, totalScore);
    }

    @Test
    public void given_10_0_4_TotalScore_18()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(10);
        calculator.Roll(0);
        calculator.Roll(4);
        final int totalScore = calculator.getTotalScore();

        assertEquals(18, totalScore);
    }

    @Test
    public void given_perfectGame_TotalScore_300()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(10);
        calculator.Roll(10);
        calculator.Roll(10);
        calculator.Roll(10);
        calculator.Roll(10);
        calculator.Roll(10);
        calculator.Roll(10);
        calculator.Roll(10);
        calculator.Roll(10);
        calculator.Roll(10);
        calculator.Roll(10);
        calculator.Roll(10);
        final int totalScore = calculator.getTotalScore();

        assertEquals(300, totalScore);
    }

    @Test
    public void given_1_FrameScore_1()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(1);
        final int frameScore = calculator.getFrameScoreOf(1);

        assertEquals(1, frameScore);
    }

    @Test
    public void given_1_3_FrameScore_4()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(1);
        calculator.Roll(3);
        final int frameScore = calculator.getFrameScoreOf(1);

        assertEquals(4, frameScore);
    }

    @Test
    public void given_6_4_4_FrameScore_14()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(6);
        calculator.Roll(4);
        calculator.Roll(4);
        final int frameScore = calculator.getFrameScoreOf(1);

        assertEquals(14, frameScore);
    }

    @Test
    public void given_6_4_4_4_FrameScore_Frame1_14()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(6);
        calculator.Roll(4);
        calculator.Roll(4);
        calculator.Roll(4);
        assertEquals(14, calculator.getFrameScoreOf(1));
        assertEquals(8, calculator.getFrameScoreOf(2));
    }

    @Test
    public void given_10_4_4_3_FrameScore_Frame1_18()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(10);
        calculator.Roll(4);
        calculator.Roll(4);
        calculator.Roll(3);
        assertEquals(18, calculator.getFrameScoreOf(1));
        assertEquals(8, calculator.getFrameScoreOf(2));
        assertEquals(3, calculator.getFrameScoreOf(3));
    }

    @Test
    public void given_10_10_10_4_3_2_FrameScore_Frame1_30()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(10);
        calculator.Roll(10);
        calculator.Roll(10);
        calculator.Roll(4);
        calculator.Roll(3);
        calculator.Roll(2);
        assertEquals(30, calculator.getFrameScoreOf(1));
        assertEquals(24, calculator.getFrameScoreOf(2));
        assertEquals(17, calculator.getFrameScoreOf(3));
        assertEquals(7, calculator.getFrameScoreOf(4));
        assertEquals(2, calculator.getFrameScoreOf(5));
    }

    @Test
    public void given_2_Display_2()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(2);
        assertEquals("2", calculator.getDisplayText());
    }

    @Test
    public void given_2_5_Display_7()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(2);
        calculator.Roll(5);
        assertEquals("7", calculator.getDisplayText());
    }

    @Test
    public void given_2_5_3_Display_7_3()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(2);
        calculator.Roll(5);
        calculator.Roll(3);
        assertEquals("7,3", calculator.getDisplayText());
    }

    @Test
    public void given_5_5_3_Display_SpareCharacter_3()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(5);
        calculator.Roll(5);
        calculator.Roll(3);
        assertEquals("/,3", calculator.getDisplayText());
    }

    @Test
    public void given_10_5_3_6_4_4_0_0_4_Display_SpareCharacter_xxx()
    {
        final BowlingCalculator calculator = new BowlingCalculator();
        calculator.Roll(10);
        calculator.Roll(5);
        calculator.Roll(3);
        calculator.Roll(6);
        calculator.Roll(4);
        calculator.Roll(4);
        calculator.Roll(0);
        calculator.Roll(0);
        calculator.Roll(0);
        assertEquals("X,8,/,4,0", calculator.getDisplayText());
    }
}
