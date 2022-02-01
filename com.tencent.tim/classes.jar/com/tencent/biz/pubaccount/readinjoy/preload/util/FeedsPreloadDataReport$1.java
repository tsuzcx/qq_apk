package com.tencent.biz.pubaccount.readinjoy.preload.util;

import com.tencent.qphone.base.util.QLog;
import kbp;
import kxm;

public final class FeedsPreloadDataReport$1
  implements Runnable
{
  public FeedsPreloadDataReport$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = kxm.getAccount();
    QLog.d("FeedsPreloadDataReport", 1, new Object[] { "actionName = ", this.val$actionName, "\n", "r2 = ", str, " r5 = ", this.val$r5 });
    kbp.a(null, "", this.val$actionName, this.val$actionName, 0, 0, str, "", "", this.val$r5, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.preload.util.FeedsPreloadDataReport.1
 * JD-Core Version:    0.7.0.1
 */