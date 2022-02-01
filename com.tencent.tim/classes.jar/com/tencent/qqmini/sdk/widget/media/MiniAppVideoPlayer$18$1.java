package com.tencent.qqmini.sdk.widget.media;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniAppVideoPlayer$18$1
  implements Runnable
{
  MiniAppVideoPlayer$18$1(MiniAppVideoPlayer.18 param18, Canvas paramCanvas, AbsVideoPlayer paramAbsVideoPlayer, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((MiniAppVideoPlayer.access$5600(this.this$1.this$0) != null) && (MiniAppVideoPlayer.access$5600(this.this$1.this$0).getVisibility() == 0))
    {
      MiniAppVideoPlayer.access$5600(this.this$1.this$0).setDrawingCacheEnabled(true);
      MiniAppVideoPlayer.access$5600(this.this$1.this$0).buildDrawingCache();
      MiniAppVideoPlayer.access$5600(this.this$1.this$0).setDrawingCacheEnabled(false);
    }
    if ((MiniAppVideoPlayer.access$5700(this.this$1.this$0) != null) && (MiniAppVideoPlayer.access$5700(this.this$1.this$0).getVisibility() == 0))
    {
      MiniAppVideoPlayer.access$5700(this.this$1.this$0).setDrawingCacheEnabled(true);
      MiniAppVideoPlayer.access$5700(this.this$1.this$0).buildDrawingCache();
      Bitmap localBitmap = MiniAppVideoPlayer.access$5700(this.this$1.this$0).getDrawingCache();
      if (localBitmap != null) {
        this.val$canvas.drawBitmap(Bitmap.createBitmap(localBitmap), 0.0F, 0.0F, null);
      }
      MiniAppVideoPlayer.access$5700(this.this$1.this$0).setDrawingCacheEnabled(false);
    }
    if (this.this$1.val$onCaptureImageListener != null) {
      this.this$1.val$onCaptureImageListener.onCaptureImageSucceed(this.val$tvk_iMediaPlayer, this.val$mergedBitmap);
    }
    try
    {
      MiniAppVideoPlayer.access$800(this.this$1.this$0).setOnCaptureImageListener(null);
      MiniAppVideoPlayer.18.access$5802(this.this$1, true);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("MiniAppVideoPlayer", "onCaptureImageSucceed mVideoPlayer.setOnCaptureImageListener get a Throwable:", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.18.1
 * JD-Core Version:    0.7.0.1
 */