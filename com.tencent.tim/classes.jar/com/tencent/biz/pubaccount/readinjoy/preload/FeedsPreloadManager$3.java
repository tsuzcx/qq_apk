package com.tencent.biz.pubaccount.readinjoy.preload;

import com.tencent.qphone.base.util.QLog;
import lka;
import lkc;
import lke;

public class FeedsPreloadManager$3
  implements Runnable
{
  public FeedsPreloadManager$3(lka paramlka, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool;
    if (lke.O(this.akG)) {
      bool = false;
    }
    try
    {
      lka.a(this.this$0);
      lkc.Y(this.akG, bool);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("FeedsPreloadManager", 1, "preloadFeedsImp exception, e = ", localException);
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager.3
 * JD-Core Version:    0.7.0.1
 */