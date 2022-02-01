package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class BlockAdPlugin$7
  implements Runnable
{
  BlockAdPlugin$7(BlockAdPlugin paramBlockAdPlugin, int paramInt1, String paramString, int paramInt2, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", "error");
      localJSONObject.put("compId", this.val$compId);
      localJSONObject.put("errMsg", this.val$errMsg);
      localJSONObject.put("errCode", this.val$errorCode);
      BlockAdPlugin.access$200(this.this$0, this.val$req, localJSONObject, "onBlockAdStateChange");
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("BlockAdPlugin", "bannerErrorStateCallback error", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.BlockAdPlugin.7
 * JD-Core Version:    0.7.0.1
 */