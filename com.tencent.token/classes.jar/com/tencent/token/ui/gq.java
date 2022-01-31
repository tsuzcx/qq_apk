package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class gq
  implements DialogInterface.OnCancelListener
{
  gq(fz paramfz, boolean paramBoolean) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    FaceRecognitionCameraActivityOld.access$1000(this.b.a).d();
    FaceRecognitionCameraActivityOld.access$1000(this.b.a).a();
    FaceRecognitionCameraActivityOld.access$002(this.b.a, false);
    if (!this.a) {
      this.b.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gq
 * JD-Core Version:    0.7.0.1
 */