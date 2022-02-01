package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.ViewGroup;
import wun;
import wup;

public class AIOShakeHelper$1$2$1
  implements Runnable
{
  public AIOShakeHelper$1$2$1(wup paramwup) {}
  
  public void run()
  {
    if ((wun.a(this.a.a.this$0) != null) && (wun.a(this.a.a.this$0).getParent() != null)) {
      ((ViewGroup)wun.a(this.a.a.this$0).getParent()).removeView(wun.a(this.a.a.this$0));
    }
    wun.a(this.a.a.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.1.2.1
 * JD-Core Version:    0.7.0.1
 */