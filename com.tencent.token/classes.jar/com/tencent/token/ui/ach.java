package com.tencent.token.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.token.utils.t;

final class ach
  implements Runnable
{
  ach(TakeIDPhotoComfirmActivity paramTakeIDPhotoComfirmActivity, String paramString, ImageView paramImageView) {}
  
  public final void run()
  {
    Bitmap localBitmap = t.b(this.a, Math.max(this.b.getWidth(), this.b.getHeight()));
    this.b.setImageBitmap(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ach
 * JD-Core Version:    0.7.0.1
 */