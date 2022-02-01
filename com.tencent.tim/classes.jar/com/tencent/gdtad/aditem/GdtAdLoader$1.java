package com.tencent.gdtad.aditem;

import android.content.Context;
import com.tencent.ad.tangram.loader.AdLoaderWithJSON;
import com.tencent.ad.tangram.loader.AdLoaderWithJSON.Session;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tgc;
import tgc.b;
import tkv;
import tkw;
import tlm;
import tlm.a;
import tlm.b;
import tlo;
import tlo.a;

public class GdtAdLoader$1
  implements Runnable
{
  public GdtAdLoader$1(tgc paramtgc, WeakReference paramWeakReference) {}
  
  public void run()
  {
    tkw.i("GdtAdLoader", "load");
    tlo.a().a((Context)this.dv.get(), new tlo.a());
    if ((this.dv == null) || (this.dv.get() == null) || (tgc.a(this.this$0) == null) || (!tgc.a(this.this$0).canSend()))
    {
      tgc.a(this.this$0);
      return;
    }
    tgc.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet.support_https.set(true);
    Object localObject = new tlm.a();
    ((tlm.a)localObject).aJy = "d61533";
    localObject = tlm.a((Context)this.dv.get(), (tlm.a)localObject);
    if (localObject != null) {}
    for (localObject = ((tlm.b)localObject).b;; localObject = null)
    {
      if (localObject != null) {
        tgc.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet.device_info.set((MessageMicro)localObject);
      }
      localObject = tkv.pbToJson(tgc.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
      if ((localObject == null) || (!(localObject instanceof JSONObject))) {
        break;
      }
      AdLoaderWithJSON.Session localSession = new AdLoaderWithJSON.Session();
      localSession.request = ((JSONObject)JSONObject.class.cast(localObject));
      AdLoaderWithJSON.load(localSession);
      tgc.a(this.this$0).timeMillis = localSession.timeMillis;
      tgc.a(this.this$0).httpResponseCode = localSession.httpResponseCode;
      if ((localSession.httpResponseCode != 200) || (localSession.response == null) || (localSession.response == JSONObject.NULL)) {
        break;
      }
      tgc.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp = ((qq_ad_get.QQAdGetRsp)qq_ad_get.QQAdGetRsp.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp(), localSession.response)));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAdLoader.1
 * JD-Core Version:    0.7.0.1
 */