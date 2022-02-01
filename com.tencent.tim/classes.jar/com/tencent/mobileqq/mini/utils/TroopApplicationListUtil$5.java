package com.tencent.mobileqq.mini.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import arcz.b;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class TroopApplicationListUtil$5
  extends Handler
{
  TroopApplicationListUtil$5(Looper paramLooper, BaseJsPluginEngine paramBaseJsPluginEngine, TroopApplicationListUtil.JsPluginParam paramJsPluginParam)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof arcz.b))
    {
      paramMessage = (arcz.b)paramMessage.obj;
      if (paramMessage.resultCode == 0)
      {
        try
        {
          if (paramMessage.czO != null)
          {
            QLog.d("TroopApplicationListUtil", 1, new Object[] { "handleMessage cgiState.htmlBody: ", paramMessage.czO });
            int i = new JSONObject(paramMessage.czO).optInt("ec", -1);
            TroopApplicationListUtil.access$000(i);
            paramMessage = new JSONObject();
            if ((i == 0) || (i == 41012))
            {
              paramMessage.put("errorCode", i);
              this.val$jsPluginEngine.callbackJsEventOK(this.val$jsPluginParam.jsRuntime, this.val$jsPluginParam.event, paramMessage, this.val$jsPluginParam.callbackId);
              return;
            }
            paramMessage.put("errorCode", i);
            this.val$jsPluginEngine.callbackJsEventFail(this.val$jsPluginParam.jsRuntime, this.val$jsPluginParam.event, paramMessage, this.val$jsPluginParam.callbackId);
            return;
          }
        }
        catch (JSONException paramMessage)
        {
          QLog.e("TroopApplicationListUtil", 1, "handleMessage addMiniAppToTroopApplicationList exception ", paramMessage);
          this.val$jsPluginEngine.callbackJsEventFail(this.val$jsPluginParam.jsRuntime, this.val$jsPluginParam.event, null, "native error, json exception", this.val$jsPluginParam.callbackId);
          return;
        }
        this.val$jsPluginEngine.callbackJsEventFail(this.val$jsPluginParam.jsRuntime, this.val$jsPluginParam.event, null, "native error, htmlBody is null", this.val$jsPluginParam.callbackId);
        return;
      }
      QLog.e("TroopApplicationListUtil", 1, "handleMessage addMiniAppToTroopApplicationList ,resultCode : " + paramMessage.resultCode);
      this.val$jsPluginEngine.callbackJsEventFail(this.val$jsPluginParam.jsRuntime, this.val$jsPluginParam.event, null, "native error, request fail", this.val$jsPluginParam.callbackId);
      return;
    }
    QLog.e("TroopApplicationListUtil", 1, new Object[] { "handleMessage addMiniAppToTroopApplicationList ", " invalid msg.obj" });
    this.val$jsPluginEngine.callbackJsEventFail(this.val$jsPluginParam.jsRuntime, this.val$jsPluginParam.event, null, "native error, invalid msg.obj", this.val$jsPluginParam.callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.5
 * JD-Core Version:    0.7.0.1
 */