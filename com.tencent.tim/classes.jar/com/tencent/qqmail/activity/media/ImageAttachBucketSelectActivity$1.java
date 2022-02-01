package com.tencent.qqmail.activity.media;

import android.graphics.Bitmap;
import com.tencent.qqmail.model.mail.watcher.LoadImageWatcher;
import com.tencent.qqmail.utilities.thread.Threads;

class ImageAttachBucketSelectActivity$1
  implements LoadImageWatcher
{
  ImageAttachBucketSelectActivity$1(ImageAttachBucketSelectActivity paramImageAttachBucketSelectActivity) {}
  
  public void onError(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3) {}
  
  public void onProcess(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
  
  public void onSuccess(long paramLong, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean)
  {
    Threads.runOnMainThread(new ImageAttachBucketSelectActivity.1.1(this, paramString1, paramString2, paramString3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.1
 * JD-Core Version:    0.7.0.1
 */