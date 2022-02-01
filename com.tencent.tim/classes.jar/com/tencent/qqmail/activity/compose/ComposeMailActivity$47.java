package com.tencent.qqmail.activity.compose;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.model.qmdomain.AttachInfo;

class ComposeMailActivity$47
  implements ImageDownloadListener
{
  ComposeMailActivity$47(ComposeMailActivity paramComposeMailActivity, AttachInfo paramAttachInfo) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject) {}
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    this.val$attachInfo.setThumbnailData(paramBitmap);
    this.val$attachInfo.setThumbnailPath(paramString1);
    ComposeMailActivity.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.47
 * JD-Core Version:    0.7.0.1
 */