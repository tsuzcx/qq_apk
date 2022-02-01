package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class AuthJsPlugin$1
  implements AsyncResult
{
  AuthJsPlugin$1(AuthJsPlugin paramAuthJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      QMLog.d("AuthJsPlugin", "call API_LOGIN  code:" + paramJSONObject.toString());
      this.val$req.ok(paramJSONObject);
      return;
    }
    QMLog.e("AuthJsPlugin", "call API_LOGIN failed ");
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.AuthJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */