package com.tencent.qqmini.miniapp.widget.media;

import android.graphics.Bitmap;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePushListenerReflect.ITXSnapshotListener;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class MiniAppLivePusher$4
  implements TXLivePushListenerReflect.ITXSnapshotListener
{
  MiniAppLivePusher$4(MiniAppLivePusher paramMiniAppLivePusher, String paramString, RequestEvent paramRequestEvent) {}
  
  public void onSnapshot(Bitmap paramBitmap)
  {
    ThreadManager.executeOnDiskIOThreadPool(new MiniAppLivePusher.4.1(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePusher.4
 * JD-Core Version:    0.7.0.1
 */