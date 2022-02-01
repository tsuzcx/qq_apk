package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import java.lang.ref.WeakReference;
import nox;
import noz;

class RunningJob$5
  implements Runnable
{
  public void run()
  {
    if (this.this$0.a.mIsCancel) {}
    while (this.cw.get() == null) {
      return;
    }
    ((nox)this.cw.get()).a(this.this$0.a, this.val$progress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob.5
 * JD-Core Version:    0.7.0.1
 */