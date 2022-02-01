package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class BlockAdPlugin$2
  implements Runnable
{
  BlockAdPlugin$2(BlockAdPlugin paramBlockAdPlugin, int paramInt, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    boolean bool = BlockAdPlugin.access$500(this.this$0, this.val$compId);
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
        localJSONObject.put("compId", this.val$compId);
        BlockAdPlugin.access$200(this.this$0, this.val$req, localJSONObject, "onBlockAdShowDone");
      }
      catch (JSONException localJSONException)
      {
        String str;
        BlockAdPlugin.access$100(this.this$0, this.val$req, 1003, (String)BlockAdPlugin.access$600().get(Integer.valueOf(1003)), this.val$compId, 0);
        QMLog.i("BlockAdPlugin", "handle operateBannerAd show error", localJSONException);
        continue;
      }
      QMLog.i("BlockAdPlugin", "showBlockAd " + bool);
      return;
      str = "error";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.BlockAdPlugin.2
 * JD-Core Version:    0.7.0.1
 */