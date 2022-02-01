package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import java.lang.ref.WeakReference;
import lgl;
import nox;
import noz;

class RunningJob$4
  implements Runnable
{
  RunningJob$4(RunningJob paramRunningJob, WeakReference paramWeakReference, Throwable paramThrowable) {}
  
  public void run()
  {
    if (this.this$0.a.mIsCancel) {
      lgl.a(6, this.this$0.a);
    }
    while (this.cw.get() == null) {
      return;
    }
    ((nox)this.cw.get()).a(this.this$0.a, this.val$exception);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob.4
 * JD-Core Version:    0.7.0.1
 */