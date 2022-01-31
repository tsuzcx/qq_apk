package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ic
  implements DialogInterface.OnCancelListener
{
  ic(hs paramhs, boolean paramBoolean) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    FaceRegCameraActivity.access$400(this.b.a).setStop(true);
    FaceRegCameraActivity.access$400(this.b.a).c();
    FaceRegCameraActivity.access$202(this.b.a, false);
    if (!this.a) {
      this.b.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ic
 * JD-Core Version:    0.7.0.1
 */