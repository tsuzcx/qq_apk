package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import arhz;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import stj;

public final class NewReportPlugin$2
  implements Runnable
{
  public NewReportPlugin$2(Bundle paramBundle, String paramString1, int paramInt, BaseActivity paramBaseActivity, String paramString2, String paramString3, String paramString4, arhz paramarhz) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = this.P;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      String str2 = ((Bundle)localObject1).getString("text_evidence", "");
      String str3 = ((Bundle)localObject1).getString("img_evidence", "");
      String str4 = ((Bundle)localObject1).getString("url_evidence", "");
      String str5 = ((Bundle)localObject1).getString("video_evidence", "");
      String str6 = ((Bundle)localObject1).getString("file_evidence", "");
      String str7 = ((Bundle)localObject1).getString("audio_evidence", "");
      String str8 = ((Bundle)localObject1).getString("user_input_param", "");
      if (!TextUtils.isEmpty(this.aGt))
      {
        localObject2 = this.aGt;
        if (this.val$activity.app == null) {
          break label234;
        }
      }
      label234:
      for (String str1 = stj.a(this.val$activity.app, this.aGq, this.aGr, this.val$scene, (Bundle)localObject1);; str1 = "chatmsg%3A")
      {
        localObject1 = stj.a(this.val$activity, this.aGu, "", "", this.aGr, "", this.val$scene, (String)localObject2, str1, str2, str3, str4, str5, str6, str7, str8, (Bundle)localObject1);
        if (QLog.isColorLevel()) {
          QLog.i("NewReportPlugin", 2, String.format("nearbySafetyRealReport post: %s", new Object[] { localObject1 }));
        }
        this.val$activity.runOnUiThread(new NewReportPlugin.2.1(this, (String)localObject1));
        return;
        localObject2 = stj.cl(this.val$scene);
        break;
      }
      return;
    }
    catch (Exception localException)
    {
      this.val$activity.runOnUiThread(new NewReportPlugin.2.2(this, localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.2
 * JD-Core Version:    0.7.0.1
 */