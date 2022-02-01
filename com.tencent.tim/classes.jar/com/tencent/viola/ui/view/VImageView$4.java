package com.tencent.viola.ui.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.tencent.viola.ui.view.image.ImageDrawable;
import com.tencent.viola.utils.ViolaUtils;

class VImageView$4
  implements Runnable
{
  VImageView$4(VImageView paramVImageView, Drawable paramDrawable, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = ImageDrawable.drawableToBitmap(this.val$drawable, this.val$width, this.val$height, this.this$0.getScaleType());
    if (localObject != null)
    {
      ViolaUtils.fastblur((Bitmap)localObject, VImageView.access$200(this.this$0));
      localObject = new BitmapDrawable(this.this$0.getResources(), (Bitmap)localObject);
      new Handler(Looper.getMainLooper()).post(new VImageView.4.1(this, (Drawable)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.VImageView.4
 * JD-Core Version:    0.7.0.1
 */