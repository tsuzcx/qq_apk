package com.tencent.qqmail.activity.readmail;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.qqmail.download.listener.ImageDownloadListener;

class ReadMailFragment$AttachListViewAdapter$14
  implements ImageDownloadListener
{
  ReadMailFragment$AttachListViewAdapter$14(ReadMailFragment.AttachListViewAdapter paramAttachListViewAdapter, String paramString, ImageView paramImageView) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject) {}
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if ((this.this$1.this$0.isAttachedToActivity()) && (paramBitmap != null) && (this.val$thumbUrl.equals(paramString1)))
    {
      paramString1 = new BitmapDrawable(this.this$1.this$0.getResources(), paramBitmap);
      this.val$thumb.setImageDrawable(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.AttachListViewAdapter.14
 * JD-Core Version:    0.7.0.1
 */