package com.tencent.qqmail.activity.media;

import android.graphics.Bitmap;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;

class ImageCropActivity$3
  implements Runnable
{
  ImageCropActivity$3(ImageCropActivity paramImageCropActivity) {}
  
  public void run()
  {
    Bitmap localBitmap1 = ImageUtil.memSafeScaleImage(ImageCropActivity.access$100(this.this$0), 1, 1.0F);
    Bitmap localBitmap2 = ImageUtil.fixImageOrientation(localBitmap1, ImageCropActivity.access$100(this.this$0));
    if (localBitmap2 != localBitmap1) {
      localBitmap1.recycle();
    }
    ImageCropActivity.access$300(this.this$0, new ImageCropActivity.3.1(this, localBitmap2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageCropActivity.3
 * JD-Core Version:    0.7.0.1
 */