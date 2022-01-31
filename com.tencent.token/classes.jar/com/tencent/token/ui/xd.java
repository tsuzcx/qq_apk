package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class xd
  implements View.OnClickListener
{
  xd(RealNameStep1InputNameIdActivity paramRealNameStep1InputNameIdActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, FaceRegCameraActivity.class);
    paramView.putExtra("flag", 3);
    paramView.putExtra("scene", 2);
    this.a.startActivityForResult(paramView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xd
 * JD-Core Version:    0.7.0.1
 */