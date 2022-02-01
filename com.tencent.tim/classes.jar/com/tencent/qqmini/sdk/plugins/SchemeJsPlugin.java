package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@JsPlugin
public class SchemeJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "SchemeJsPlugin";
  
  @JsEvent({"openScheme"})
  public void openScheme(RequestEvent paramRequestEvent)
  {
    Activity localActivity = this.mMiniAppContext.getAttachedActivity();
    if (localActivity == null) {
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      if (((JSONObject)localObject).has("api_name"))
      {
        String str = ((JSONObject)localObject).optString("api_name");
        JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("data");
        localObject = null;
        if (localJSONObject != null) {
          localObject = JSONUtil.json2Params(localJSONObject);
        }
        localObject = str + "?" + (String)localObject;
        ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).openSchema(localActivity, (String)localObject, new SchemeJsPlugin.1(this, new Handler(Looper.getMainLooper()), paramRequestEvent, (String)localObject));
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("SchemeJsPlugin", paramRequestEvent.event + " error.", localException);
      return;
    }
    paramRequestEvent.fail("params error.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SchemeJsPlugin
 * JD-Core Version:    0.7.0.1
 */