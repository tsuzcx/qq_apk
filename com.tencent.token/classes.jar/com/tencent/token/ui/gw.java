package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.view.View;
import com.tencent.token.ui.base.co;

final class gw
  implements DialogInterface.OnClickListener
{
  gw(fz paramfz) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FaceRecognitionCameraActivityOld.access$1700(this.a.a).b();
    FaceRecognitionCameraActivityOld.access$1100(this.a.a).removeMessages(13);
    this.a.a.setContentView(2130903089);
    this.a.a.hideTitle();
    this.a.a.findViewById(2131296572).setOnClickListener(new gx(this));
    FaceRecognitionCameraActivityOld.access$1900(this.a.a);
    if (FaceRecognitionCameraActivityOld.access$1000(this.a.a) != null) {
      FaceRecognitionCameraActivityOld.access$1000(this.a.a).a(this.a.a, FaceRecognitionCameraActivityOld.access$100(this.a.a), FaceRecognitionCameraActivityOld.access$1100(this.a.a));
    }
    FaceRecognitionCameraActivityOld.access$402(this.a.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gw
 * JD-Core Version:    0.7.0.1
 */