package com.tencent.token.ui;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.token.ui.base.FaceView;

class gk
  implements Runnable
{
  gk(FaceRecognitionCameraActivity paramFaceRecognitionCameraActivity, float paramFloat) {}
  
  public void run()
  {
    ((ViewGroup.MarginLayoutParams)FaceRecognitionCameraActivity.access$1000(this.b).getLayoutParams()).topMargin = ((int)(FaceRecognitionCameraActivity.access$700(this.b).getCenterY() - this.a * 170.0F));
    ((ViewGroup.MarginLayoutParams)FaceRecognitionCameraActivity.access$1100(this.b).getLayoutParams()).topMargin = ((int)(FaceRecognitionCameraActivity.access$700(this.b).getCenterY() - this.a * 170.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gk
 * JD-Core Version:    0.7.0.1
 */