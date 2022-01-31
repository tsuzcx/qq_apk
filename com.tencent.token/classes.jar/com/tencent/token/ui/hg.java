package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class hg
  implements DialogInterface.OnClickListener
{
  hg(FaceRecognitionCameraActivityOld paramFaceRecognitionCameraActivityOld) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FaceRecognitionCameraActivityOld.access$1000(this.a).b(FaceRecognitionCameraActivityOld.access$400(this.a));
    this.a.dismissDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hg
 * JD-Core Version:    0.7.0.1
 */