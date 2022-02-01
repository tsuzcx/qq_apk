package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.minigame.model.BlockAdInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class BlockAdPlugin$5
  implements Runnable
{
  BlockAdPlugin$5(BlockAdPlugin paramBlockAdPlugin, int paramInt, BlockAdInfo paramBlockAdInfo, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    if (BlockAdPlugin.access$800(this.this$0, this.val$compId)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", "resize");
      localJSONObject.put("compId", this.val$currentPosInfo.getCompId());
      localJSONObject.put("width", this.val$currentPosInfo.getRealWidth());
      localJSONObject.put("height", this.val$currentPosInfo.getRealHeight());
      BlockAdPlugin.access$200(this.this$0, this.val$req, localJSONObject, "onBlockAdStateChange");
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("BlockAdPlugin", "updateBannerAd informJs error", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.BlockAdPlugin.5
 * JD-Core Version:    0.7.0.1
 */