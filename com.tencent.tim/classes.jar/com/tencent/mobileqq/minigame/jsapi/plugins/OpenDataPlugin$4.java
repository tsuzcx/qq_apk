package com.tencent.mobileqq.minigame.jsapi.plugins;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserInteractiveStorageRsp;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class OpenDataPlugin$4
  implements MiniAppCmdInterface
{
  OpenDataPlugin$4(OpenDataPlugin paramOpenDataPlugin, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("OpenDataPlugin", 1, "getPotentialFriendList receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    if (paramJSONObject == null)
    {
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , ret == null");
      GameLog.vconsoleLog("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , ret == null");
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "getUserInteractiveStorage", null, this.val$callbackId);
      return;
    }
    if (paramBoolean)
    {
      int i;
      JSONObject localJSONObject;
      try
      {
        Object localObject = (CloudStorage.StGetUserInteractiveStorageRsp)paramJSONObject.get("response");
        i = paramJSONObject.getInt("retCode");
        paramJSONObject = paramJSONObject.getString("errMsg");
        String str = ((CloudStorage.StGetUserInteractiveStorageRsp)localObject).encryptedData.get();
        localObject = ((CloudStorage.StGetUserInteractiveStorageRsp)localObject).iv.get();
        localJSONObject = new JSONObject();
        if (i == 0)
        {
          localJSONObject.put("encryptedData", str);
          localJSONObject.put("iv", localObject);
          this.this$0.jsPluginEngine.callbackJsEventOK(this.val$jsRuntime, "getUserInteractiveStorage", localJSONObject, this.val$callbackId);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error ", paramJSONObject);
        GameLog.vconsoleLog("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error " + paramJSONObject.getMessage());
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "getUserInteractiveStorage", null, this.val$callbackId);
        return;
      }
      localJSONObject.put("errMsg", paramJSONObject);
      localJSONObject.put("errCode", i);
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE ret != null");
      GameLog.vconsoleLog("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error ret != null");
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "getUserInteractiveStorage", localJSONObject, this.val$callbackId);
      return;
    }
    GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , isSuc false");
    GameLog.vconsoleLog("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , isSuc false");
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "getUserInteractiveStorage", null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.OpenDataPlugin.4
 * JD-Core Version:    0.7.0.1
 */