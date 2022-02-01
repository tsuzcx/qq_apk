package com.tencent.biz.subscribe.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;

public final class MergeBitmapBlurUtil$2
  implements Runnable
{
  public MergeBitmapBlurUtil$2(Bitmap paramBitmap, ImageView paramImageView) {}
  
  public void run()
  {
    if ((this.val$bitmap != null) && (this.ob != null)) {
      this.ob.setImageBitmap(this.val$bitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.MergeBitmapBlurUtil.2
 * JD-Core Version:    0.7.0.1
 */