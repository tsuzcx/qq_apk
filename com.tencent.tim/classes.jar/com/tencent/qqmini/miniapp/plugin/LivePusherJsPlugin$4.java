package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.miniapp.widget.media.CoverPusherView;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.CoverView;
import org.json.JSONObject;

class LivePusherJsPlugin$4
  implements Runnable
{
  LivePusherJsPlugin$4(LivePusherJsPlugin paramLivePusherJsPlugin, int paramInt, String paramString, RequestEvent paramRequestEvent, JSONObject paramJSONObject) {}
  
  public void run()
  {
    CoverView localCoverView = CoverViewAction.obtain(LivePusherJsPlugin.access$900(this.this$0)).get(this.val$livePusherId);
    if (!(localCoverView instanceof CoverPusherView)) {
      return;
    }
    ((CoverPusherView)localCoverView).operateLivePusher(this.val$type, this.val$req, this.val$jsonObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePusherJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */