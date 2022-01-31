package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class jf
  implements DialogInterface.OnCancelListener
{
  jf(iv paramiv) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    FaceRegCameraActivity.access$400(this.b.a).a(true);
    FaceRegCameraActivity.access$400(this.b.a).a();
    FaceRegCameraActivity.access$202(this.b.a, false);
    if (!this.a) {
      this.b.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.jf
 * JD-Core Version:    0.7.0.1
 */