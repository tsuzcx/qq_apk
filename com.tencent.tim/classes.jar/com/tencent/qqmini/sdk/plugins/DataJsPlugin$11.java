package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class DataJsPlugin$11
  implements AdProxy.ICmdListener
{
  DataJsPlugin$11(DataJsPlugin paramDataJsPlugin, RequestEvent paramRequestEvent, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int i;
    Object localObject;
    if (paramBoolean) {
      try
      {
        i = paramJSONObject.getInt("retCode");
        paramJSONObject.getString("errMsg");
        localObject = paramJSONObject.getString("response");
        String str1 = paramJSONObject.optString("adClass");
        String str2 = paramJSONObject.optString("fromSDK");
        paramJSONObject = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("data", localObject);
          localJSONObject.put("ret", i);
          localJSONObject.put("adClass", str1);
          if (!TextUtils.isEmpty(str2)) {
            localJSONObject.put("fromSDK", str2);
          }
          paramJSONObject.put("data", localJSONObject.toString());
          QMLog.d("DataJsPlugin", "requestAdInfo. retCode = " + i);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QMLog.i("DataJsPlugin", "requestAdInfo. retCode = " + i);
          }
        }
        this.val$req.ok(paramJSONObject);
        DataJsPlugin.access$500(this.this$0, (String)localObject, this.val$constAdType);
        return;
      }
      catch (Exception paramJSONObject)
      {
        this.val$req.fail();
        return;
      }
    }
    if (paramJSONObject != null)
    {
      i = paramJSONObject.getInt("retCode");
      paramJSONObject = paramJSONObject.getString("errMsg");
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("ret", i);
        ((JSONObject)localObject).put("errMsg", paramJSONObject);
        this.val$req.fail((JSONObject)localObject, "");
        return;
      }
      catch (JSONException paramJSONObject)
      {
        QMLog.e("DataJsPlugin", "requestAdInfo. retCode = " + i);
        return;
      }
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */