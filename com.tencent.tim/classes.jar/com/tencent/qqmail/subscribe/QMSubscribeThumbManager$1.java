package com.tencent.qqmail.subscribe;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;

class QMSubscribeThumbManager$1
  implements ImageDownloadListener
{
  QMSubscribeThumbManager$1(QMSubscribeThumbManager paramQMSubscribeThumbManager, int paramInt1, int paramInt2) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    if (!(paramObject + "").equals("fromDisk")) {
      this.this$0.triggerSyncSubscribeThumbError(this.val$position, this.val$index, paramString, null);
    }
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if (paramBitmap != null)
    {
      this.this$0.triggerSyncSubscribeThumbSuccess(this.val$position, this.val$index, paramString1, paramBitmap);
      return;
    }
    this.this$0.triggerSyncSubscribeThumbError(this.val$position, this.val$index, paramString1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.QMSubscribeThumbManager.1
 * JD-Core Version:    0.7.0.1
 */