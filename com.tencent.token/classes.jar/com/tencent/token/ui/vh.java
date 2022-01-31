package com.tencent.token.ui;

import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;

final class vh
  implements View.OnClickListener
{
  vh(RealNameFindActivity paramRealNameFindActivity) {}
  
  public final void onClick(View paramView)
  {
    this.a.getWindowManager().getDefaultDisplay().getWidth();
    this.a.getWindowManager().getDefaultDisplay().getHeight();
    paramView = new DisplayMetrics();
    this.a.getWindowManager().getDefaultDisplay().getMetrics(paramView);
    if (RealNameFindActivity.access$100(this.a))
    {
      paramView = new Intent(this.a, DetectIDPhotoActivity.class);
      this.a.startActivityForResult(paramView, 2);
      return;
    }
    paramView = new Intent(this.a, RealNameTakeIDPhotoActivity.class);
    paramView.putExtra("scene", 2);
    this.a.startActivityForResult(paramView, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vh
 * JD-Core Version:    0.7.0.1
 */