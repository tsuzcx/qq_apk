package com.tencent.mobileqq.transfile;

import aokr;
import aokr.e;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ForwardSdkShareProcessor$RichStep$1
  implements Runnable
{
  public ForwardSdkShareProcessor$RichStep$1(aokr.e parame) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "RichStep|run|retry=" + aokr.e.a(this.b));
    }
    if (this.b.dY.get())
    {
      this.b.doCancel();
      return;
    }
    int i = aokr.e.a(this.b);
    if (aokr.e.a(this.b).get())
    {
      if ((i == -1) && (aokr.e.a(this.b).getAndIncrement() < 2))
      {
        ThreadManager.post(this, 8, null, true);
        return;
      }
      aokr.e.a(this.b).set(false);
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "RichStep|rich fail,lack=" + aokr.a(this.b.this$0));
    }
    this.b.cMA = true;
    this.b.dVB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.RichStep.1
 * JD-Core Version:    0.7.0.1
 */