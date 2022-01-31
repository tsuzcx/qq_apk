package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.utils.t;

final class im
  implements View.OnClickListener
{
  im(FaceRecognitionCreateActivity paramFaceRecognitionCreateActivity) {}
  
  public final void onClick(View paramView)
  {
    if (t.l() == 0) {}
    for (paramView = new Intent(this.a, FaceRecognitionCameraActivityOld.class);; paramView = new Intent(this.a, FaceRegCameraActivity.class))
    {
      paramView.putExtra("scene", 1);
      paramView.putExtra("flag", 1);
      this.a.startActivity(paramView);
      this.a.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.im
 * JD-Core Version:    0.7.0.1
 */