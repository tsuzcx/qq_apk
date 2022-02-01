package com.tencent.qqmail.attachment.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.ui.FtnFileInformationView;

class ImagePagerActivity$16
  implements ImageDownloadListener
{
  ImagePagerActivity$16(ImagePagerActivity paramImagePagerActivity) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    ImagePagerActivity.access$4000(this.this$0);
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    ImagePagerActivity.access$3700(this.this$0);
    ImagePagerActivity.access$3802(this.this$0, new BitmapDrawable(this.this$0.getResources(), paramBitmap));
    ImagePagerActivity.access$3900(this.this$0).setFileThumbDrawable(ImagePagerActivity.access$3800(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity.16
 * JD-Core Version:    0.7.0.1
 */