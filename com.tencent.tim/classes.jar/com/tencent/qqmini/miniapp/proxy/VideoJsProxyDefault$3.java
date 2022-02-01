package com.tencent.qqmini.miniapp.proxy;

import android.content.Intent;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy.Bridge;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import java.io.File;

class VideoJsProxyDefault$3
  implements IActivityResultListener
{
  VideoJsProxyDefault$3(VideoJsProxyDefault paramVideoJsProxyDefault, VideoJsProxyDefault.BridgeInfo paramBridgeInfo, File paramFile, boolean paramBoolean) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 4) {
      return false;
    }
    if (paramInt2 != -1)
    {
      if (paramInt2 == 0) {
        VideoJsProxyDefault.access$400(this.this$0).responseCancel(this.val$bridgeInfo.callbackId, this.val$bridgeInfo.eventName, null);
      }
      this.val$videoFile.deleteOnExit();
      ActivityResultManager.g().removeActivityResultListener(this);
      return true;
    }
    VideoJsProxyDefault.access$300(this.this$0, this.val$videoFile, this.val$compress, this.val$bridgeInfo);
    ActivityResultManager.g().removeActivityResultListener(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault.3
 * JD-Core Version:    0.7.0.1
 */