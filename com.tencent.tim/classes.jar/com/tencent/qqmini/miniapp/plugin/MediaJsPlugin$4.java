package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.sdk.core.manager.ObserverManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.media.CoverVideoView;

class MediaJsPlugin$4
  implements Runnable
{
  MediaJsPlugin$4(MediaJsPlugin paramMediaJsPlugin, int paramInt, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    CoverView localCoverView = CoverViewAction.obtain(MediaJsPlugin.access$900(this.this$0)).get(this.val$videoPlayerId);
    if ((localCoverView instanceof CoverVideoView))
    {
      ((ObserverManager)MediaJsPlugin.access$1000(this.this$0).getManager(ObserverManager.class)).deleteObserver(((CoverVideoView)localCoverView).getVideoPlayerStatusObserver());
      CoverViewAction.obtain(MediaJsPlugin.access$1100(this.this$0)).del(this.val$videoPlayerId);
      this.val$req.ok();
      return;
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.MediaJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */