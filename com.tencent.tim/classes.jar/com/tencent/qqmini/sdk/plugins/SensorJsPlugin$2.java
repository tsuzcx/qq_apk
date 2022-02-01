package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONException;
import org.json.JSONObject;

class SensorJsPlugin$2
  implements Runnable
{
  SensorJsPlugin$2(SensorJsPlugin paramSensorJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      SensorJsPlugin.access$000(this.this$0);
      if (new JSONObject(this.val$req.jsonParams).optBoolean("enable"))
      {
        if (this.this$0.startAccelerometer(this.val$req.jsService, 3))
        {
          SensorJsPlugin.access$102(this.this$0, true);
          this.val$req.ok();
          return;
        }
        this.val$req.fail();
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
    this.this$0.stopAccelerometer();
    if (!SensorJsPlugin.access$100(this.this$0)) {
      this.val$req.fail(":fail to disable, not enable?");
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("errMsg", this.val$req.event + ":cancel");
      this.val$req.evaluateCallbackJs(localJSONObject.toString());
      return;
      SensorJsPlugin.access$102(this.this$0, false);
      this.val$req.ok();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SensorJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */