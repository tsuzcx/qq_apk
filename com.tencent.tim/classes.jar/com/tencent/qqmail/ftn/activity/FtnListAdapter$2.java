package com.tencent.qqmail.ftn.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.HashMap;

class FtnListAdapter$2
  implements ImageDownloadListener
{
  FtnListAdapter$2(FtnListAdapter paramFtnListAdapter, int paramInt, View paramView, ImageView paramImageView, String paramString) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    QMLog.log(6, "FtnListAdapter", "getThumb error url " + paramString);
    if (FtnListAdapter.access$300(this.this$0, this.val$position, this.val$view))
    {
      if (FtnListAdapter.access$400(this.this$0).containsKey(this.val$sha)) {
        this.val$ftnThumbnail.setImageBitmap((Bitmap)FtnListAdapter.access$400(this.this$0).get(this.val$sha));
      }
    }
    else {
      return;
    }
    this.val$ftnThumbnail.setImageResource(2130840449);
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if ((paramBitmap != null) && (FtnListAdapter.access$300(this.this$0, this.val$position, this.val$view)))
    {
      paramString1 = new BitmapDrawable(FtnListAdapter.access$100(this.this$0).getResources(), paramBitmap);
      this.val$ftnThumbnail.setImageDrawable(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListAdapter.2
 * JD-Core Version:    0.7.0.1
 */