package com.tencent.open.appcommon;

import android.app.Activity;
import android.os.Bundle;
import arue;
import aryv;
import arzk;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public final class AppClient$3
  implements Runnable
{
  public AppClient$3(String paramString1, String paramString2, String paramString3, Activity paramActivity, boolean paramBoolean) {}
  
  public void run()
  {
    arzk.a();
    if (arzk.aHx())
    {
      Bundle localBundle = new Bundle();
      String str = aryv.PARAM_SNG_APPID;
      if (this.val$appId == null) {}
      for (localObject = "";; localObject = this.val$appId)
      {
        localBundle.putString(str, (String)localObject);
        localBundle.putString(aryv.PARAM_TASK_APPID, "");
        localBundle.putString(aryv.PARAM_TASK_APK_ID, "");
        localBundle.putString(aryv.PARAM_TASK_PACKNAME, this.val$packageName);
        localBundle.putInt(aryv.PARAM_TASK_VERSION, 0);
        localBundle.putString(aryv.PARAM_VIA, "ANDROIDQQ.SHARESOURCE");
        localBundle.putString("big_brother_source_key", this.arC);
        ThreadManager.getSubThreadHandler().post(new AppClient.3.1(this, localBundle));
        return;
      }
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("uin", "");
    ((Bundle)localObject).putString("sid", "");
    ((Bundle)localObject).putString("via", "ANDROIDQQ.SHARESOURCE");
    ((Bundle)localObject).putBoolean("autoDownload", false);
    ((Bundle)localObject).putString("packageName", this.val$packageName);
    ((Bundle)localObject).putString("subpagetype", "SHARESOURCE");
    arue.a(this.G, this.val$appId, 2462, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.AppClient.3
 * JD-Core Version:    0.7.0.1
 */