
public class BowlingCalculator
{
    final static char FrameSeparatorDisplay = ',';
    final static String StrikeDisplay = "X";
    final static String SpareDisplay = "/";
    final static int MaxPins = 10;
    final static int MaxFrames = 10;
    final static int MaxRollsInGame = 21;

    final int[] _rolls = new int[MaxRollsInGame];
    final int[] _frameScore = new int[MaxFrames];
    final String[] _frameDisplay = new String[MaxFrames];
    int _currentRoll;
    int _totalScore;

    public int getTotalScore()
    {
        return _totalScore;
    }

    private void calculateScore()
    {
        _totalScore = 0;
        int roll = 0;
        for (int frame = 0; frame < MaxFrames && roll < _currentRoll; frame++)
        {
            if (isStrike(roll))
            {
                _frameScore[frame] = MaxPins + _rolls[roll + 1] + _rolls[roll + 2];
                _frameDisplay[frame] = StrikeDisplay;
                roll += 1;
            }
            else if (isSpare(roll))
            {
                _frameScore[frame] = MaxPins + _rolls[roll + 2];
                _frameDisplay[frame] = SpareDisplay;
                roll += 2;
            }
            else
            {
                _frameScore[frame] = _rolls[roll] + _rolls[roll + 1];
                _frameDisplay[frame] = String.valueOf(_frameScore[frame]);
                roll += 2;
            }

            _totalScore += _frameScore[frame];
        }
    }

    private boolean isStrike(final int roll)
    {
        return _rolls[roll] == MaxPins;
    }

    private boolean isSpare(final int roll)
    {
        return _rolls[roll] + _rolls[roll + 1] == MaxPins;
    }

    public void Roll(final int roll)
    {
        _rolls[_currentRoll++] = roll;
        calculateScore();
    }

    public int getFrameScoreOf(final int frameNumber)
    {
        return _frameScore[frameNumber - 1];
    }

    public String getDisplayText()
    {
        final StringBuilder displayText = new StringBuilder();

        for (int frame = 0; frame < _frameScore.length; frame++)
        {
            if (frameNotYetPlayed(frame))
            {
                break;
            }

            if (frame > 0)
            {
                displayText.append(FrameSeparatorDisplay);
            }

            displayText.append(_frameDisplay[frame]);
        }

        return displayText.toString();
    }

    private boolean frameNotYetPlayed(final int frame)
    {
        return _frameDisplay[frame] == null;
    }
}
