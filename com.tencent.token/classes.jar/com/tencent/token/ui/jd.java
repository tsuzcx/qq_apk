package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.ui.base.FaceView;

final class jd
  implements DialogInterface.OnCancelListener
{
  jd(iv paramiv) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    FaceRegCameraActivity.access$302(this.a.a, 0);
    FaceRegCameraActivity.access$400(this.a.a).a(true, false, 0, FaceRegCameraActivity.access$300(this.a.a));
    FaceRegCameraActivity.access$500(this.a.a).c(0);
    FaceRegCameraActivity.access$600(this.a.a).setText(2131362782);
    FaceRegCameraActivity.access$700(this.a.a).setImageResource(2130837712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.jd
 * JD-Core Version:    0.7.0.1
 */