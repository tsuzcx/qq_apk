package com.tencent.token.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.token.utils.x;

class aar
  implements Runnable
{
  aar(TakeIDPhotoComfirmActivity paramTakeIDPhotoComfirmActivity, String paramString, ImageView paramImageView) {}
  
  public void run()
  {
    Bitmap localBitmap = x.b(this.a, Math.max(this.b.getWidth(), this.b.getHeight()));
    this.b.setImageBitmap(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aar
 * JD-Core Version:    0.7.0.1
 */