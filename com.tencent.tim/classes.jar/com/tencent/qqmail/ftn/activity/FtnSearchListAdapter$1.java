package com.tencent.qqmail.ftn.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.qqmail.download.listener.ImageDownloadListener;

class FtnSearchListAdapter$1
  implements ImageDownloadListener
{
  FtnSearchListAdapter$1(FtnSearchListAdapter paramFtnSearchListAdapter, int paramInt, View paramView, ImageView paramImageView) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    if (this.this$0.isUpdateThumbImage(this.val$position, this.val$view)) {
      this.val$thumbnail.setImageResource(2130840449);
    }
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if ((paramBitmap != null) && (this.this$0.isUpdateThumbImage(this.val$position, this.val$view)))
    {
      paramString1 = new BitmapDrawable(FtnSearchListAdapter.access$000(this.this$0).getResources(), paramBitmap);
      this.val$thumbnail.setImageDrawable(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnSearchListAdapter.1
 * JD-Core Version:    0.7.0.1
 */