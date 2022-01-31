package com.tencent.token.ui;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.token.ui.base.FaceView;

final class ka
  implements Runnable
{
  ka(FaceStartVryCameraActivity paramFaceStartVryCameraActivity, float paramFloat) {}
  
  public final void run()
  {
    ((ViewGroup.MarginLayoutParams)FaceStartVryCameraActivity.access$800(this.b).getLayoutParams()).topMargin = ((int)(FaceStartVryCameraActivity.access$400(this.b).a() - this.a * 170.0F));
    ((ViewGroup.MarginLayoutParams)FaceStartVryCameraActivity.access$900(this.b).getLayoutParams()).topMargin = ((int)(FaceStartVryCameraActivity.access$400(this.b).a() - this.a * 170.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ka
 * JD-Core Version:    0.7.0.1
 */