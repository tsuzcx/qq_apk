package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.utils.t;

final class vg
  implements View.OnClickListener
{
  vg(RealNameFindActivity paramRealNameFindActivity) {}
  
  public final void onClick(View paramView)
  {
    if (t.l() == 0) {}
    for (paramView = new Intent(this.a, FaceRecognitionCameraActivityOld.class);; paramView = new Intent(this.a, FaceRecognitionCameraActivity.class))
    {
      paramView.putExtra("flag", 3);
      paramView.putExtra("istry", 5);
      paramView.putExtra("ish5zzb", RealNameFindActivity.access$1900(this.a));
      paramView.putExtra("scene", 3);
      this.a.startActivityForResult(paramView, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vg
 * JD-Core Version:    0.7.0.1
 */