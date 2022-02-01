package com.tencent.mobileqq.ark.API;

import adoi;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tgc;
import tgc.b;
import tkv;

public class ArkAppNotifyCenter$GdtNotify$3
  implements Runnable
{
  ArkAppNotifyCenter$GdtNotify$3(ArkAppNotifyCenter.a parama, String paramString1, String paramString2, WeakReference paramWeakReference) {}
  
  public void run()
  {
    try
    {
      this.this$0.d = new adoi(this);
      tgc.b localb = new tgc.b();
      localb.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGet(), new JSONObject(this.val$params))));
      new tgc(localb, new WeakReference(this.this$0.d)).c(this.gt);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ark.ArkAppNotifyCenter", 1, "ark.notify error!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.3
 * JD-Core Version:    0.7.0.1
 */