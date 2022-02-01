package com.tencent.mobileqq.teamwork;

import aobx;
import java.util.TimerTask;

public final class TeamWorkHttpUtils$1
  extends TimerTask
{
  public TeamWorkHttpUtils$1(int[] paramArrayOfInt, aobx paramaobx) {}
  
  public void run()
  {
    if (this.oj[0] >= 99)
    {
      this.a.notifyUI(4, true, new Object[] { Integer.valueOf(99) });
      return;
    }
    int[] arrayOfInt = this.oj;
    arrayOfInt[0] += 2;
    this.a.notifyUI(4, true, new Object[] { Integer.valueOf(this.oj[0]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkHttpUtils.1
 * JD-Core Version:    0.7.0.1
 */