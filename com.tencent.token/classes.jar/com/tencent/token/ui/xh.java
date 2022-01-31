package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.p;
import com.tencent.token.utils.t;

final class xh
  implements View.OnClickListener
{
  xh(xg paramxg) {}
  
  public final void onClick(View paramView)
  {
    this.a.a.dismiss();
    p.a().a(System.currentTimeMillis(), 91);
    if (t.l() == 0) {}
    for (paramView = new Intent(this.a.a, FaceRecognitionCameraActivityOld.class);; paramView = new Intent(this.a.a, FaceRegCameraActivity.class))
    {
      paramView.putExtra("flag", 3);
      paramView.putExtra("scene", 2);
      this.a.a.startActivityForResult(paramView, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xh
 * JD-Core Version:    0.7.0.1
 */