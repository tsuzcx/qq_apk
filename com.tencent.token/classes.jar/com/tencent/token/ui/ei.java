package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ei
  implements DialogInterface.OnClickListener
{
  ei(FacePKCameraActivity paramFacePKCameraActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FacePKCameraActivity.access$600(this.a).a(true, false, 0, 0);
    this.a.dismissDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ei
 * JD-Core Version:    0.7.0.1
 */