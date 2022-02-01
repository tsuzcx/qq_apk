package com.tencent.mobileqq.intervideo.od;

import aibz;
import aigt;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ODLoadingActivity$3
  implements Runnable
{
  ODLoadingActivity$3(ODLoadingActivity paramODLoadingActivity, Future paramFuture, long paramLong, Bundle paramBundle) {}
  
  public void run()
  {
    try
    {
      ((aibz)this.h.get(6L, TimeUnit.SECONDS)).enter(this.this$0, this.abk, this.val$bundle, new aigt(this));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ODLoadingActivity", 2, "getBizPm fail", localException);
      }
      this.this$0.runOnUiThread(new ODLoadingActivity.3.2(this));
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.od.ODLoadingActivity.3
 * JD-Core Version:    0.7.0.1
 */