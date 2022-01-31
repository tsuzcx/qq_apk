package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class vc
  implements View.OnClickListener
{
  vc(RealNameFindActivity paramRealNameFindActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, FaceRecognitionCameraActivity.class);
    paramView.putExtra("flag", 3);
    paramView.putExtra("istry", 5);
    paramView.putExtra("ish5zzb", RealNameFindActivity.access$1900(this.a));
    paramView.putExtra("real_uin", RealNameFindActivity.access$900(this.a));
    if (RealNameFindActivity.access$700(this.a)) {
      paramView.putExtra("scene", 13);
    }
    for (;;)
    {
      this.a.startActivityForResult(paramView, 1);
      return;
      paramView.putExtra("scene", 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vc
 * JD-Core Version:    0.7.0.1
 */