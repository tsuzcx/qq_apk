package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class VideoJsPlugin$1
  implements Runnable
{
  VideoJsPlugin$1(VideoJsPlugin paramVideoJsPlugin, RequestEvent paramRequestEvent, int paramInt, JSONObject paramJSONObject1, JSONObject paramJSONObject2) {}
  
  public void run()
  {
    if (VideoJsPlugin.access$100(this.this$0, VideoJsPlugin.access$000(this.this$0), this.val$req.jsService, this.val$videoPlayerId, this.val$jsonObject))
    {
      this.val$req.ok(this.val$result);
      return;
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.VideoJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */