package com.tencent.token.ui;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.token.ui.base.FaceView;

final class fx
  implements Runnable
{
  fx(FaceRecognitionCameraActivity paramFaceRecognitionCameraActivity, float paramFloat) {}
  
  public final void run()
  {
    ((ViewGroup.MarginLayoutParams)FaceRecognitionCameraActivity.access$900(this.b).getLayoutParams()).topMargin = ((int)(FaceRecognitionCameraActivity.access$500(this.b).a() - this.a * 170.0F));
    ((ViewGroup.MarginLayoutParams)FaceRecognitionCameraActivity.access$1000(this.b).getLayoutParams()).topMargin = ((int)(FaceRecognitionCameraActivity.access$500(this.b).a() - this.a * 170.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.fx
 * JD-Core Version:    0.7.0.1
 */