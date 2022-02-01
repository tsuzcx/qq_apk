package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import arhz;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import stj;

public final class NewReportPlugin$3
  implements Runnable
{
  public NewReportPlugin$3(int paramInt, BaseActivity paramBaseActivity, String paramString1, String paramString2, Bundle paramBundle, String paramString3, String paramString4, String paramString5, String paramString6, arhz paramarhz) {}
  
  public void run()
  {
    try
    {
      Object localObject = stj.a(this.val$scene, this.val$activity, this.aGw, this.aGr, this.Q);
      localObject = stj.a(this.val$activity, this.aGw, this.aGx, this.aGy, this.aGr, this.aGz, this.val$scene, stj.cl(this.val$scene), this.aGA, "", "", "", "", "", "", "", (Bundle)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("NewReportPlugin", 1, "safetyNewReport postData=" + (String)localObject);
      }
      this.val$activity.runOnUiThread(new NewReportPlugin.3.1(this, (String)localObject));
      return;
    }
    catch (Exception localException)
    {
      this.val$activity.runOnUiThread(new NewReportPlugin.3.2(this, localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.3
 * JD-Core Version:    0.7.0.1
 */