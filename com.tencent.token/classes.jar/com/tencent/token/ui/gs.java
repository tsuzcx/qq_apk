package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.token.ui.base.FaceImageView;

final class gs
  implements DialogInterface.OnCancelListener
{
  gs(fz paramfz) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    FaceRecognitionCameraActivityOld.access$1000(this.a.a).b(FaceRecognitionCameraActivityOld.access$400(this.a.a));
    FaceRecognitionCameraActivityOld.access$300(this.a.a).a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gs
 * JD-Core Version:    0.7.0.1
 */