package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.action.PhoneNumberAction;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONArray;
import org.json.JSONObject;

class TelephonyJsPlugin$1
  implements AsyncResult
{
  TelephonyJsPlugin$1(TelephonyJsPlugin paramTelephonyJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.d("TelephonyJsPlugin", "onCmdListener isSuccess = " + paramBoolean + "; result = " + paramJSONObject);
    String str = null;
    Object localObject = new JSONArray();
    if (paramJSONObject != null)
    {
      str = paramJSONObject.optString("errMsg");
      localObject = paramJSONObject.optJSONArray("phoneLists");
    }
    if (paramBoolean)
    {
      if ((localObject == null) || (((JSONArray)localObject).length() == 0))
      {
        this.val$req.fail("no binding Phone number");
        return;
      }
      try
      {
        localObject = new JSONObject(this.val$req.jsonParams);
        ((JSONObject)localObject).put("getPhoneNumber", paramJSONObject);
        this.val$req.jsonParams = ((JSONObject)localObject).toString();
        TelephonyJsPlugin.access$000(this.this$0).performAction(PhoneNumberAction.obtain(this.val$req, new TelephonyJsPlugin.1.1(this)));
        return;
      }
      catch (Throwable paramJSONObject)
      {
        QMLog.e("TelephonyJsPlugin", "getPhoneNumber error", paramJSONObject);
        return;
      }
    }
    this.val$req.fail(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.TelephonyJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */