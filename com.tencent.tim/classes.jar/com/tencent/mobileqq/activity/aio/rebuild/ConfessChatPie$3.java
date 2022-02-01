package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import xxt;
import xxw;

public class ConfessChatPie$3
  implements Runnable
{
  public ConfessChatPie$3(xxt paramxxt) {}
  
  public void run()
  {
    try
    {
      LottieComposition.Factory.fromAssetFileName(this.this$0.mContext, "qq_confess_holmes_progress_lottie.json", new xxw(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.this$0.TAG, 1, "loadHolmesProgressAnimation fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.3
 * JD-Core Version:    0.7.0.1
 */