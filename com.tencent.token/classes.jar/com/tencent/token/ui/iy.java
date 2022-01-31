package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.view.View;
import com.tencent.token.ui.base.co;

final class iy
  implements DialogInterface.OnClickListener
{
  iy(iv paramiv) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FaceRegCameraActivity.access$1300(this.a.a).b();
    FaceRegCameraActivity.access$1600(this.a.a).removeMessages(13);
    this.a.a.setContentView(2130903091);
    this.a.a.hideTitle();
    this.a.a.findViewById(2131296572).setOnClickListener(new iz(this));
    FaceRegCameraActivity.access$1700(this.a.a);
    if (FaceRegCameraActivity.access$400(this.a.a) != null) {
      FaceRegCameraActivity.access$400(this.a.a).a(this.a.a, FaceRegCameraActivity.access$1800(this.a.a), FaceRegCameraActivity.access$1600(this.a.a), FaceRegCameraActivity.access$500(this.a.a), FaceRegCameraActivity.access$600(this.a.a));
    }
    FaceRegCameraActivity.access$302(this.a.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.iy
 * JD-Core Version:    0.7.0.1
 */