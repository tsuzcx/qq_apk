package com.tencent.mobileqq.ark.API;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tgh;
import tkv;

class ArkAppNotifyCenter$GdtNotify$5
  implements Runnable
{
  ArkAppNotifyCenter$GdtNotify$5(ArkAppNotifyCenter.a parama, String paramString) {}
  
  public void run()
  {
    try
    {
      if (TextUtils.isEmpty(this.val$params))
      {
        QLog.e("ark.ArkAppNotifyCenter", 1, "ark ad_preload_after_ad_loaded params invalid", null);
        return;
      }
      Object localObject = new JSONObject(this.val$params);
      localObject = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), ((JSONObject)localObject).getJSONObject("adInfo"))));
      QLog.d("ark.ArkAppNotifyCenter", 1, "ark ad_preload_after_ad_loaded start", null);
      tgh.a().a((GdtAd)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ark.ArkAppNotifyCenter", 1, "ark ad_preload_after_ad_loaded error", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.5
 * JD-Core Version:    0.7.0.1
 */