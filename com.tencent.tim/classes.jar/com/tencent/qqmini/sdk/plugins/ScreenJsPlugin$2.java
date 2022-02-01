package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class ScreenJsPlugin$2
  implements Runnable
{
  ScreenJsPlugin$2(ScreenJsPlugin paramScreenJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.val$req.jsonParams);
      if (localJSONObject.has("value"))
      {
        double d = localJSONObject.optDouble("value");
        ScreenJsPlugin.setScreenBrightness(ScreenJsPlugin.access$200(this.this$0).getAttachedActivity(), (float)d);
        this.val$req.ok();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("ScreenJsPlugin", localThrowable.getMessage(), localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ScreenJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */