package com.tencent.qqmail.card.view;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;

class CollapsingAvatarsView$1
  implements ImageDownloadListener
{
  CollapsingAvatarsView$1(CollapsingAvatarsView paramCollapsingAvatarsView, String paramString, CircularImageView paramCircularImageView) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject) {}
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if (this.val$icon.equals(paramString1)) {
      this.val$avatarView.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.CollapsingAvatarsView.1
 * JD-Core Version:    0.7.0.1
 */