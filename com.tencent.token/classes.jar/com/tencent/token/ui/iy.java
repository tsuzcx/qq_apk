package com.tencent.token.ui;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.token.ui.base.FaceView;

class iy
  implements Runnable
{
  iy(FaceStartVryCameraActivity paramFaceStartVryCameraActivity, float paramFloat) {}
  
  public void run()
  {
    ((ViewGroup.MarginLayoutParams)FaceStartVryCameraActivity.access$900(this.b).getLayoutParams()).topMargin = ((int)(FaceStartVryCameraActivity.access$600(this.b).getCenterY() - this.a * 170.0F));
    ((ViewGroup.MarginLayoutParams)FaceStartVryCameraActivity.access$1000(this.b).getLayoutParams()).topMargin = ((int)(FaceStartVryCameraActivity.access$600(this.b).getCenterY() - this.a * 170.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.iy
 * JD-Core Version:    0.7.0.1
 */