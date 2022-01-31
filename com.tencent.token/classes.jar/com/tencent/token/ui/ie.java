package com.tencent.token.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.token.utils.t;

final class ie
  implements Runnable
{
  ie(FaceRecognitionComfirmActivity paramFaceRecognitionComfirmActivity, ImageView paramImageView) {}
  
  public final void run()
  {
    Bitmap localBitmap = t.b(FaceRecognitionComfirmActivity.access$000(this.b), Math.max(this.a.getWidth(), this.a.getHeight()));
    this.a.setImageBitmap(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ie
 * JD-Core Version:    0.7.0.1
 */