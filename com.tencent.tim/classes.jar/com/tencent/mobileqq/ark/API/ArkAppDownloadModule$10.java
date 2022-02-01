package com.tencent.mobileqq.ark.API;

import adnc;
import adne;
import adnf;
import android.content.Context;
import android.content.SharedPreferences;
import anot;
import aqha;
import aqju;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;

public class ArkAppDownloadModule$10
  implements Runnable
{
  public ArkAppDownloadModule$10(adnc paramadnc, Context paramContext, String paramString1, WadlParams paramWadlParams, SharedPreferences paramSharedPreferences, String paramString2, String paramString3) {}
  
  public void run()
  {
    if (this.val$context == null)
    {
      QLog.e("ark.download.module", 1, "start download context is null");
      return;
    }
    aqju localaqju = aqha.a(this.val$context, 230, null, this.buG, this.val$context.getString(2131721058), this.val$context.getString(2131690499), new adne(this), new adnf(this));
    localaqju.setCheckBox(this.buH, null);
    localaqju.show();
    anot.c(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "6", "", this.c.appId, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDownloadModule.10
 * JD-Core Version:    0.7.0.1
 */