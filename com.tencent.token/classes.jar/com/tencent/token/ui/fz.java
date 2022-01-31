package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class fz
  implements DialogInterface.OnCancelListener
{
  fz(fj paramfj, boolean paramBoolean) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    FaceRecognitionCameraActivity.access$400(this.b.a).setStop(true);
    FaceRecognitionCameraActivity.access$400(this.b.a).c();
    FaceRecognitionCameraActivity.access$202(this.b.a, false);
    if (!this.a) {
      this.b.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.fz
 * JD-Core Version:    0.7.0.1
 */