package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class BannerAdPlugin$2
  implements Runnable
{
  BannerAdPlugin$2(BannerAdPlugin paramBannerAdPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    boolean bool = BannerAdPlugin.access$900(this.this$0);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("state", "show");
        if (!bool) {
          continue;
        }
        str = "ok";
        localJSONObject.put("status", str);
        BannerAdPlugin.access$600(this.this$0, this.val$req, localJSONObject, "onBannerAdShowDone");
      }
      catch (JSONException localJSONException)
      {
        String str;
        BannerAdPlugin.access$300(this.this$0, this.val$req, 1003, (String)BannerAdPlugin.access$200().get(Integer.valueOf(1003)), 0);
        QMLog.i("BannerAdPlugin", "handle operateBannerAd show error", localJSONException);
        continue;
      }
      QMLog.i("BannerAdPlugin", "showBannerAd " + bool);
      return;
      str = "error";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BannerAdPlugin.2
 * JD-Core Version:    0.7.0.1
 */