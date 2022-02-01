package com.tencent.qqmail.account.helper;

import android.os.CountDownTimer;

public class VerifyCountDownTimer
  extends CountDownTimer
{
  public static final long COUNT_DOWN_INTERVAL = 1000L;
  private CountDownAction action;
  
  public VerifyCountDownTimer(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    if (this.action != null) {
      this.action.onFinish();
    }
  }
  
  public void onTick(long paramLong)
  {
    if (this.action != null) {
      this.action.onTick(paramLong);
    }
  }
  
  public void setCountDownAction(CountDownAction paramCountDownAction)
  {
    this.action = paramCountDownAction;
  }
  
  public static abstract interface CountDownAction
  {
    public abstract void onFinish();
    
    public abstract void onTick(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.VerifyCountDownTimer
 * JD-Core Version:    0.7.0.1
 */