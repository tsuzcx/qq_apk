package com.tencent.qqmail.activity.compose;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.utilities.log.QMLog;

class ComposeMailActivity$46
  implements ImageDownloadListener
{
  ComposeMailActivity$46(ComposeMailActivity paramComposeMailActivity, AttachInfo paramAttachInfo) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject) {}
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.val$attachInfo.setThumbnailData(paramBitmap);
      if (ComposeMailActivity.access$5400(this.this$0) != null) {
        ComposeMailActivity.access$5400(this.this$0).notifyDataSetChanged();
      }
    }
    else
    {
      return;
    }
    QMLog.log(6, "ComposeMailActivity", "attachAdapter null onSuccessInMainThread getBitmapWithSession");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.46
 * JD-Core Version:    0.7.0.1
 */