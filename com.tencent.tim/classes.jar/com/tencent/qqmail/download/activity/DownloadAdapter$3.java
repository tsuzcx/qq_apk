package com.tencent.qqmail.download.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.qqmail.download.listener.ImageDownloadListener;

class DownloadAdapter$3
  implements ImageDownloadListener
{
  DownloadAdapter$3(DownloadAdapter paramDownloadAdapter, String paramString, int paramInt, View paramView, ImageView paramImageView) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject) {}
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if ((paramBitmap != null) && (this.val$previewUrl.equals(paramString1)) && (this.val$position == DownloadAdapter.access$000(this.this$0, this.val$view)))
    {
      paramString1 = new BitmapDrawable(DownloadAdapter.access$100(this.this$0).getResources(), paramBitmap);
      this.val$thumb.setImageDrawable(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadAdapter.3
 * JD-Core Version:    0.7.0.1
 */