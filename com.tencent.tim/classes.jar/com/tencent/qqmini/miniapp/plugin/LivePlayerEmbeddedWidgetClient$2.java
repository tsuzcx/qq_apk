package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Bitmap;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.ISnapshotOuterListener;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;

class LivePlayerEmbeddedWidgetClient$2
  implements TXLivePlayerJSAdapter.ISnapshotOuterListener
{
  LivePlayerEmbeddedWidgetClient$2(LivePlayerEmbeddedWidgetClient paramLivePlayerEmbeddedWidgetClient, String paramString, IJsService paramIJsService, int paramInt) {}
  
  public void onSnapshot(Bitmap paramBitmap)
  {
    ThreadManager.executeOnDiskIOThreadPool(new LivePlayerEmbeddedWidgetClient.2.1(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePlayerEmbeddedWidgetClient.2
 * JD-Core Version:    0.7.0.1
 */