package com.tencent.biz.pubaccount.readinjoy.config.beans;

import com.tencent.aladdin.config.parse.AladdinConfigBean;

public class OccasionRule
  implements AladdinConfigBean
{
  private int baseDelayMs = 10000;
  private int debounceIntervalMinutes = 60;
  private int maximumWakeUpTimes = 3;
  private int randomDelayUpperBound = 10000;
  
  public int getBaseDelayMs()
  {
    return this.baseDelayMs;
  }
  
  public int getDebounceIntervalMinutes()
  {
    return this.debounceIntervalMinutes;
  }
  
  public int getMaximumWakeUpTimes()
  {
    return this.maximumWakeUpTimes;
  }
  
  public int getRandomDelayUpperBound()
  {
    return this.randomDelayUpperBound;
  }
  
  public String toString()
  {
    return "OccasionRule{baseDelayMs=" + this.baseDelayMs + ", debounceIntervalMinutes=" + this.debounceIntervalMinutes + ", maximumWakeUpTimes=" + this.maximumWakeUpTimes + ", randomDelayUpperBound=" + this.randomDelayUpperBound + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.beans.OccasionRule
 * JD-Core Version:    0.7.0.1
 */