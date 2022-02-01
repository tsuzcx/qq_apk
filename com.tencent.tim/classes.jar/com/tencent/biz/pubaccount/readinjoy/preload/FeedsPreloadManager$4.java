package com.tencent.biz.pubaccount.readinjoy.preload;

import com.tencent.qphone.base.util.QLog;
import ljz;
import ljz.a;
import lka;
import lke;

public class FeedsPreloadManager$4
  implements Runnable
{
  public FeedsPreloadManager$4(lka paramlka, ljz.a parama, long paramLong) {}
  
  public void run()
  {
    ljz localljz = ljz.b();
    if (localljz != null)
    {
      if (!lke.i(this.a.h)) {
        QLog.d("FeedsPreloadManager", 1, "is not latest request, do not update preload cache.");
      }
    }
    else {
      return;
    }
    QLog.d("FeedsPreloadManager", 1, new Object[] { "feeds preload recPackageSize = ", Long.valueOf(this.uE), ", limit = ", Integer.valueOf(20000) });
    if (this.uE > 20000L)
    {
      QLog.d("FeedsPreloadManager", 1, "preload feeds recPackage is too large, do not update cache.");
      return;
    }
    QLog.d("FeedsPreloadManager", 1, "update preload cache.");
    localljz.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager.4
 * JD-Core Version:    0.7.0.1
 */