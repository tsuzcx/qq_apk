package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class il
  implements DialogInterface.OnCancelListener
{
  il(ij paramij, boolean paramBoolean) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    FaceStartVryCameraActivity.access$300(this.b.a).setStop(true);
    FaceStartVryCameraActivity.access$300(this.b.a).c();
    FaceStartVryCameraActivity.access$202(this.b.a, false);
    if (!this.a) {
      this.b.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.il
 * JD-Core Version:    0.7.0.1
 */