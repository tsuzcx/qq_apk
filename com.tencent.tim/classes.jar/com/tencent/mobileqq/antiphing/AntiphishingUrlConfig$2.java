package com.tencent.mobileqq.antiphing;

import abgr;
import abgu;
import android.content.Context;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

public class AntiphishingUrlConfig$2
  implements Runnable
{
  public AntiphishingUrlConfig$2(abgr paramabgr, Context paramContext, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (abgr.getAvailableInternalMemorySize() > 3000000L)
    {
      if (new abgu(this.R).a(this.bfE, abgr.b(this.this$0), this.bfF, false))
      {
        QLog.d(abgr.a(this.this$0), 1, "Successfully Update Config!");
        abgr.a(this.this$0).sendEmptyMessage(abgr.a(this.this$0));
      }
    }
    else {
      return;
    }
    abgr.a(this.this$0).sendEmptyMessage(abgr.b(this.this$0));
    QLog.d(abgr.a(this.this$0), 1, "Update Config Error!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.AntiphishingUrlConfig.2
 * JD-Core Version:    0.7.0.1
 */