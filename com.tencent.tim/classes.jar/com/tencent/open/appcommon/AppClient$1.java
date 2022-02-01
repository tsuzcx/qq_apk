package com.tencent.open.appcommon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import aryv;
import aryy;
import arzk;
import com.tencent.open.downloadnew.DownloadInfo;

public final class AppClient$1
  implements Runnable
{
  public AppClient$1(String paramString1, Bundle paramBundle1, String paramString2, Activity paramActivity, Intent paramIntent, Bundle paramBundle2) {}
  
  public void run()
  {
    if (arzk.a().aHy())
    {
      DownloadInfo localDownloadInfo = aryy.a().c(this.val$appId);
      if (localDownloadInfo != null)
      {
        if (localDownloadInfo.downloadType == 1)
        {
          this.val$extras.putString(aryv.PARAM_SNG_APPID, localDownloadInfo.appId);
          this.val$extras.putString(aryv.PARAM_TASK_APPID, localDownloadInfo.cDG);
          this.val$extras.putString(aryv.PARAM_TASK_APK_ID, localDownloadInfo.cCL);
          this.val$extras.putString(aryv.PARAM_VIA, this.cCm);
          this.val$extras.putString(aryv.PARAM_TASK_PACKNAME, localDownloadInfo.packageName);
          this.val$extras.putInt(aryv.PARAM_TASK_VERSION, localDownloadInfo.versionCode);
          arzk.a().a(this.G, this.val$extras, false, false);
          return;
        }
        this.G.startActivityForResult(this.val$intent, 200);
        return;
      }
      if ((this.val$bundle != null) && (this.val$bundle.containsKey(aryv.PARAM_TASK_PACKNAME)))
      {
        this.val$extras.putAll(this.val$bundle);
        arzk.a().a(this.G, this.val$extras, false, false);
        return;
      }
      this.G.startActivityForResult(this.val$intent, 200);
      return;
    }
    this.G.startActivityForResult(this.val$intent, 200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.AppClient.1
 * JD-Core Version:    0.7.0.1
 */