package com.tencent.qqmail.bottle.controller;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMAvatar;

class BottleManager$3
  implements ImageDownloadListener
{
  BottleManager$3(BottleManager paramBottleManager, int paramInt, String paramString1, BottleManager.AvatarCallback paramAvatarCallback, String paramString2) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("AvatarDisplay: loadAVA error:").append(paramString).append(", err: ");
    if (paramObject != null) {}
    for (paramString = paramObject.toString();; paramString = "error is null")
    {
      QMLog.log(5, "BottleManager", paramString);
      if ((paramObject == null) || (!(paramObject instanceof String)) || (!((String)paramObject).equals("downloading"))) {
        break;
      }
      return;
    }
    paramString = this.this$0.getDefalAvatar(this.val$uin, this.val$type);
    ImageDownloadManager.shareInstance().addMemoryCache(this.val$key, paramString);
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    paramString1 = new QMAvatar(this.val$type);
    paramString1.setAvatar(paramBitmap);
    paramString1 = paramString1.getBitmap();
    ImageDownloadManager.shareInstance().addMemoryCache(this.val$key, paramString1);
    this.val$callback.onSuccessInMainThread2(this.val$uin, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleManager.3
 * JD-Core Version:    0.7.0.1
 */