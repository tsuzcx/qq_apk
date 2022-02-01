package com.tencent.mobileqq.ark.API;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForArk;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import ocp;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tkv;

class ArkAppNotifyCenter$GdtNotify$2
  implements Runnable
{
  ArkAppNotifyCenter$GdtNotify$2(ArkAppNotifyCenter.a parama, String paramString1, WeakReference paramWeakReference, String paramString2) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(this.val$params);
        Object localObject3 = ((JSONObject)localObject1).getJSONObject("options");
        boolean bool1 = ((JSONObject)localObject3).getBoolean("reportForClick");
        boolean bool2 = ((JSONObject)localObject3).getBoolean("appAutoDownload");
        boolean bool3 = ((JSONObject)localObject3).optBoolean("videoCeilingSupported", false);
        int i = ((JSONObject)localObject3).optInt("clickScene");
        int j = ((JSONObject)localObject3).optInt("clickPosition");
        localObject3 = ((JSONObject)localObject3).optString("gdtRefsid");
        localObject1 = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), ((JSONObject)localObject1).getJSONObject("adInfo")));
        GdtHandler.Params localParams = new GdtHandler.Params();
        localParams.processId = 7;
        localParams.activity = this.am;
        localParams.ad = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject1);
        localParams.reportForClick = bool1;
        localParams.aOV = bool2;
        if (bool3)
        {
          localObject1 = GdtVideoCeilingFragmentForJS.class;
          localParams.n = ((Class)localObject1);
          localParams.videoCeilingSupportedIfNotInstalled = bool3;
          localParams.p = GdtCanvasFragmentForArk.class;
          localParams.sceneID = i;
          localParams.componentID = j;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localParams.extra = new Bundle();
            localParams.extra.putString("big_brother_ref_source_key", (String)localObject3);
            GdtHandler.a(localParams);
            return;
          }
          if ((TextUtils.isEmpty(this.val$appName)) || (!this.val$appName.equals("com.tencent.yundong"))) {
            continue;
          }
          localParams.extra = new Bundle();
          localParams.extra.putString("big_brother_ref_source_key", ocp.fq("3026775809"));
          continue;
        }
        Object localObject2 = null;
      }
      catch (Exception localException)
      {
        QLog.e("ark.ArkAppNotifyCenter", 1, "ark.notify error!", localException);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.2
 * JD-Core Version:    0.7.0.1
 */