package com.tencent.mobileqq.activity.aio.doodle;

import mqq.util.WeakReference;
import wrf;

public class DoodleMsgView$1$2
  implements Runnable
{
  public DoodleMsgView$1$2(wrf paramwrf, int paramInt) {}
  
  public void run()
  {
    if (DoodleMsgView.a(this.a.this$0) != null)
    {
      DoodleMsgView.a locala = (DoodleMsgView.a)DoodleMsgView.a(this.a.this$0).get();
      if (locala != null) {
        locala.CH(this.bRf);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.1.2
 * JD-Core Version:    0.7.0.1
 */