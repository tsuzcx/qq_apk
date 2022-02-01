package com.tencent.mobileqq.activity.qwallet.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import anpc;
import aqcv;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class QWalletTools$4
  implements Runnable
{
  public QWalletTools$4(String paramString1, int paramInt1, String paramString2, AppRuntime paramAppRuntime, String paramString3, String paramString4, int paramInt2, String paramString5, long paramLong) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tenpay_mqq");
    localStringBuilder.append("|");
    localStringBuilder.append(this.val$uin);
    localStringBuilder.append("||");
    localStringBuilder.append(this.cgs);
    localStringBuilder.append("|");
    localStringBuilder.append(this.azN);
    localStringBuilder.append("|0|1|0|android.");
    try
    {
      localStringBuilder.append(this.val$app.getApplication().getPackageManager().getPackageInfo(this.val$app.getApplication().getPackageName(), 0).versionName);
      localStringBuilder.append("|");
      localStringBuilder.append(aqcv.gP());
      localStringBuilder.append("|");
      if ((!TextUtils.isEmpty(this.bcN)) || (!TextUtils.isEmpty(this.bcO)))
      {
        localStringBuilder.append(this.bcN);
        localStringBuilder.append(".");
        localStringBuilder.append(this.bcO);
      }
      localStringBuilder.append("|");
      localStringBuilder.append(this.cgt);
      localStringBuilder.append(".");
      if (!TextUtils.isEmpty(this.bcP)) {
        localStringBuilder.append(this.bcP.replace("|", ","));
      }
      localStringBuilder.append("|");
      if (0L != this.LQ) {
        VACDReportUtil.b(this.LQ, null, this.azN, "op_type=" + this.cgs, 0, "");
      }
      anpc.a(BaseApplication.getContext()).i(this.val$app, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.QWalletTools.4
 * JD-Core Version:    0.7.0.1
 */