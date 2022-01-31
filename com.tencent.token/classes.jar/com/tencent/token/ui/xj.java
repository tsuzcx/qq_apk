package com.tencent.token.ui;

import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.token.p;

final class xj
  implements View.OnClickListener
{
  xj(xg paramxg) {}
  
  public final void onClick(View paramView)
  {
    this.a.a.dismiss();
    p.a().a(System.currentTimeMillis(), 93);
    paramView = new DisplayMetrics();
    this.a.a.getWindowManager().getDefaultDisplay().getMetrics(paramView);
    if (RealNameStep1InputNameIdActivity.access$100(this.a.a))
    {
      paramView = new Intent(this.a.a, DetectIDPhotoActivity.class);
      this.a.a.startActivityForResult(paramView, 2);
      return;
    }
    paramView = new Intent(this.a.a, RealNameTakeIDPhotoActivity.class);
    paramView.putExtra("scene", 2);
    this.a.a.startActivityForResult(paramView, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xj
 * JD-Core Version:    0.7.0.1
 */