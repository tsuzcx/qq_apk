package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class eg
  implements DialogInterface.OnCancelListener
{
  eg(ee paramee) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    FacePKCameraActivity.access$600(this.b.a).a(true);
    FacePKCameraActivity.access$600(this.b.a).a();
    FacePKCameraActivity.access$002(this.b.a, false);
    if (!this.a) {
      this.b.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.eg
 * JD-Core Version:    0.7.0.1
 */