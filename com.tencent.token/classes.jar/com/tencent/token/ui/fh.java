package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class fh
  implements DialogInterface.OnCancelListener
{
  fh(es parames, boolean paramBoolean) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    FaceRecognitionCameraActivity.access$700(this.b.a).a(true);
    FaceRecognitionCameraActivity.access$700(this.b.a).a();
    FaceRecognitionCameraActivity.access$202(this.b.a, false);
    if (!this.a) {
      this.b.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.fh
 * JD-Core Version:    0.7.0.1
 */