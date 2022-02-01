package com.tencent.superplayer.bandwidth;

public class MaxPredictor
  extends AbstractPredictor
{
  long onSample(long paramLong)
  {
    return Math.max(paramLong, this.currentPredition);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.MaxPredictor
 * JD-Core Version:    0.7.0.1
 */