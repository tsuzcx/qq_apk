package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.utils.t;

final class xo
  implements View.OnClickListener
{
  xo(RealNameStep1InputNameIdActivity paramRealNameStep1InputNameIdActivity) {}
  
  public final void onClick(View paramView)
  {
    if (t.l() == 0) {}
    for (paramView = new Intent(this.a, FaceRecognitionCameraActivityOld.class);; paramView = new Intent(this.a, FaceRegCameraActivity.class))
    {
      paramView.putExtra("flag", 3);
      paramView.putExtra("scene", 2);
      this.a.startActivityForResult(paramView, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xo
 * JD-Core Version:    0.7.0.1
 */