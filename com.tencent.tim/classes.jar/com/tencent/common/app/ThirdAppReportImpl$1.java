package com.tencent.common.app;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import swv;

public class ThirdAppReportImpl$1
  implements Runnable
{
  public ThirdAppReportImpl$1(swv paramswv, Intent paramIntent, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void run()
  {
    try
    {
      swv.a(this.val$intent, this.aHF, this.lM, this.aHG, this.aHH);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ThirdAppReport", 2, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.common.app.ThirdAppReportImpl.1
 * JD-Core Version:    0.7.0.1
 */