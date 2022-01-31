package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class jo
  implements DialogInterface.OnCancelListener
{
  jo(jl paramjl) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    FaceStartVryCameraActivity.access$700(this.b.a).a(true);
    FaceStartVryCameraActivity.access$700(this.b.a).a();
    FaceStartVryCameraActivity.access$202(this.b.a, false);
    if (!this.a) {
      this.b.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.jo
 * JD-Core Version:    0.7.0.1
 */