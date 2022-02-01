package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tlm;
import tlm.a;
import tlm.b;

class BridgeModule$15
  implements Runnable
{
  BridgeModule$15(BridgeModule paramBridgeModule, String paramString) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = new tlm.a();
    ((tlm.a)localObject1).aJy = "ce2d9f";
    localObject1 = tlm.a(BaseApplication.getContext(), (tlm.a)localObject1);
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = ((tlm.b)localObject1).b;; localObject2 = null)
    {
      if (localObject1 != null) {}
      try
      {
        localJSONObject.put("aid_ticket", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
        localJSONObject.put("taid_ticket", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
        localJSONObject.put("md5_android_id", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.get());
        localJSONObject.put("md5_mac", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.get());
        this.this$0.invokeCallJS(this.val$callback, localJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      this.this$0.invokeErrorCallJS(this.val$callback, "GdtDeviceInfo is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.15
 * JD-Core Version:    0.7.0.1
 */