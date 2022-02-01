package com.tencent.mobileqq.activity;

import android.os.Looper;
import android.os.MessageQueue;
import veq;

public class KeepAliveGuideActivity$3
  implements Runnable
{
  KeepAliveGuideActivity$3(KeepAliveGuideActivity paramKeepAliveGuideActivity) {}
  
  public void run()
  {
    Looper.myQueue().addIdleHandler(new veq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.KeepAliveGuideActivity.3
 * JD-Core Version:    0.7.0.1
 */