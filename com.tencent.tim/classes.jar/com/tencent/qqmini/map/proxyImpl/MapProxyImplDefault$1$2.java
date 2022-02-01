package com.tencent.qqmini.map.proxyImpl;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.launcher.core.proxy.MapProxy.MapSnapshotCallback;
import com.tencent.qqmini.sdk.utils.SaveCaptureImageUitl;

class MapProxyImplDefault$1$2
  implements Runnable
{
  MapProxyImplDefault$1$2(MapProxyImplDefault.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.this$1.val$callback != null) {
      this.this$1.val$callback.onSnapshotReady(SaveCaptureImageUitl.cutAndSaveShareScreenshot(this.this$1.val$context, this.val$cachingBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.map.proxyImpl.MapProxyImplDefault.1.2
 * JD-Core Version:    0.7.0.1
 */