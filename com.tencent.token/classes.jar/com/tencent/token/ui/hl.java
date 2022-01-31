package com.tencent.token.ui;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.e;
import com.tencent.token.utils.n;

final class hl
  implements View.OnClickListener
{
  hl(FaceRecognitionCameraActivityOld paramFaceRecognitionCameraActivityOld) {}
  
  public final void onClick(View paramView)
  {
    e.c("onBackPressed");
    FaceRecognitionCameraActivityOld.access$1100(this.a).removeMessages(90);
    if (n.a().c())
    {
      FaceRecognitionCameraActivityOld.access$1100(this.a).postDelayed(new hm(this), 300L);
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hl
 * JD-Core Version:    0.7.0.1
 */