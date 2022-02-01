package com.tencent.open.appcommon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import aroi;
import arug;
import arwq;
import arwt;
import arzk;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.tmassistantbase.common.DownloadSDKConfigManager;
import java.io.File;
import java.util.HashMap;

public final class AppClient$2
  implements Runnable
{
  public AppClient$2(Bundle paramBundle1, Bundle paramBundle2, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    boolean bool;
    Object localObject1;
    Object localObject2;
    Intent localIntent;
    Bundle localBundle;
    label169:
    Object localObject3;
    if (arug.y(this.val$bundle.getString("schemaUrl")).get("auto_download") != null)
    {
      bool = true;
      if (!arzk.a().a(aroi.a().getContext(), this.bz, bool, false))
      {
        localObject1 = arug.Dj() + File.separator + "qapp_center_detail.htm";
        localObject2 = new File((String)localObject1);
        if (!((File)localObject2).exists())
        {
          arwt.w("AppClient", "file" + (String)localObject1 + " not exist copyassets.");
          arwq.iH("Page/system", arug.Dk());
        }
        localIntent = new Intent();
        localBundle = new Bundle();
        if (!((File)localObject2).exists()) {
          break label461;
        }
        localObject2 = "file:///" + (String)localObject1;
        localObject3 = "&from=-10&id=" + this.cCn;
        if (!TextUtils.isEmpty(this.cCo))
        {
          localObject1 = localObject3;
          if (this.cCo.contains("channelId")) {}
        }
        else
        {
          localObject1 = (String)localObject3 + "&channelId=" + this.cCp;
        }
        if (!bool) {
          break label534;
        }
        localObject1 = (String)localObject1 + "&auto_download=1";
      }
    }
    label523:
    label534:
    for (;;)
    {
      localObject3 = localObject1;
      if (!TextUtils.isEmpty(this.cCo))
      {
        if (this.cCo.equals(this.cCn)) {
          localObject3 = localObject1;
        }
      }
      else
      {
        label300:
        localIntent.setClass(aroi.a().getContext(), QZoneAppListActivity.class);
        if (!DownloadSDKConfigManager.canGotoNewDetailPage(this.cCq)) {
          break label523;
        }
        localBundle.putInt("goto_type", 7);
      }
      for (;;)
      {
        localBundle.putString("APP_URL", (String)localObject2);
        localBundle.putBoolean("FROM_FEED", true);
        localBundle.putString("APP_PARAMS", (String)localObject3);
        if (this.val$bundle.getInt("process_id") == 2) {
          localBundle.putInt("process_id", 2);
        }
        arwt.i("Jie", "APP_URL:" + (String)localObject2 + " |  PARAMS >>> " + localBundle.getString("APP_PARAMS"));
        localIntent.putExtras(localBundle);
        localIntent.putExtra("adapter_action", "action_app_detail");
        localIntent.addFlags(872415232);
        aroi.a().getContext().startActivity(localIntent);
        return;
        bool = false;
        break;
        label461:
        localObject2 = arug.Dp() + File.separator + "qapp_center_detail.htm";
        break label169;
        localObject3 = (String)localObject1 + "&" + this.cCo;
        break label300;
        localBundle.putInt("goto_type", 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.AppClient.2
 * JD-Core Version:    0.7.0.1
 */