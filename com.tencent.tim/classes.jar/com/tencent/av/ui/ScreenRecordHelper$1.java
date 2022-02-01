package com.tencent.av.ui;

import java.util.TimerTask;
import jds;
import jds.a;

public class ScreenRecordHelper$1
  extends TimerTask
{
  public ScreenRecordHelper$1(jds paramjds) {}
  
  public void run()
  {
    if (jds.a(this.this$0) != null)
    {
      jds.a(this.this$0, jds.a(this.this$0) + 1000L);
      jds.a(this.this$0).cA(jds.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.ScreenRecordHelper.1
 * JD-Core Version:    0.7.0.1
 */