package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class LivePlayerJsPlugin$3
  implements Runnable
{
  LivePlayerJsPlugin$3(LivePlayerJsPlugin paramLivePlayerJsPlugin, int paramInt, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    CoverViewAction.obtain(LivePlayerJsPlugin.access$900(this.this$0)).del(this.val$livePlayerId);
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePlayerJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */