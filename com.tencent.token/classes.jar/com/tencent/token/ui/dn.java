package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;

class dn
  implements View.OnClickListener
{
  dn(DetectIDPhotoActivity paramDetectIDPhotoActivity) {}
  
  public void onClick(View paramView)
  {
    if (DetectIDPhotoActivity.access$100(this.a) != null) {
      DetectIDPhotoActivity.access$100(this.a).setStop(true);
    }
    DetectIDPhotoActivity.access$200(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dn
 * JD-Core Version:    0.7.0.1
 */