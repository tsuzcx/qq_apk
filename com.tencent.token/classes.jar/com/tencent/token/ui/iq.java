package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.utils.t;

final class iq
  implements View.OnClickListener
{
  iq(FaceRecognitionDefaultActivity paramFaceRecognitionDefaultActivity) {}
  
  public final void onClick(View paramView)
  {
    if (t.l() == 0) {}
    for (paramView = new Intent(this.a, FaceRecognitionCameraActivityOld.class);; paramView = new Intent(this.a, FaceRecognitionCameraActivity.class))
    {
      paramView.putExtra("flag", 2);
      paramView.putExtra("istry", 1);
      paramView.putExtra("scene", 6);
      this.a.startActivity(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.iq
 * JD-Core Version:    0.7.0.1
 */