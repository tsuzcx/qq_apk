package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import msd;
import msd.b;
import muj;

public class OrientationDetector$2
  implements Runnable
{
  public OrientationDetector$2(msd parammsd, Activity paramActivity) {}
  
  public void run()
  {
    msd.a(this.this$0, this.val$activity.getRequestedOrientation());
    msd.a(this.this$0, new msd.b(this.this$0, new Handler(Looper.getMainLooper())));
    msd.a(this.this$0).registerObserver();
    msd.a(this.this$0, muj.isSystemAutoRotateOpen(this.val$activity));
    this.this$0.enable(msd.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.2
 * JD-Core Version:    0.7.0.1
 */