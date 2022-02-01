package com.tencent.mobileqq.ark.debug;

import adsb;
import adtt;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAsyncShareMiniAppTest$1$1
  implements Runnable
{
  public ArkAsyncShareMiniAppTest$1$1(adsb paramadsb, JSONObject paramJSONObject, adtt paramadtt, Object paramObject) {}
  
  public void run()
  {
    if ((this.val$msgJson == null) || (this.val$callback == null) || (this.val$userData == null) || (!(this.val$userData instanceof Bundle))) {
      QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, new Object[] { "AAShare.process return callback=", this.val$callback });
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, new Object[] { "AAShare.process engine res =", "test" });
      }
      try
      {
        long l = ((Bundle)this.val$userData).getLong("key_process_message_uniseq");
        if (TextUtils.isEmpty("test")) {
          break;
        }
        JSONObject localJSONObject3 = new JSONObject(this.val$msgJson.getString("forward_ark_app_meta"));
        JSONObject localJSONObject2 = localJSONObject3.optJSONObject("intro");
        JSONObject localJSONObject1 = localJSONObject2;
        if (localJSONObject2 == null) {
          localJSONObject1 = localJSONObject3.optJSONObject("detail");
        }
        localJSONObject1.put("desc", "uniseq=" + String.valueOf(l) + ", 更新metaData接口测试,测试更新meta中的desc");
        this.val$msgJson.put("forward_ark_app_meta", localJSONObject3.toString());
        bool = true;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, "AAShare.mArkMessagePreprocessor process e =", localJSONException);
          boolean bool = false;
        }
      }
      QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, new Object[] { "AAShare.process isProcessed=", Boolean.valueOf(bool), ", msgJson=", this.val$msgJson.toString() });
    } while (this.val$callback == null);
    this.val$callback.a(bool, this.val$msgJson, this.val$userData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.ArkAsyncShareMiniAppTest.1.1
 * JD-Core Version:    0.7.0.1
 */