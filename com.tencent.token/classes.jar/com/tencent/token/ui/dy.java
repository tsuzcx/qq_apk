package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class dy
  implements DialogInterface.OnClickListener
{
  dy(FaceChangePwdIndexActivity paramFaceChangePwdIndexActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a, StartPwdUpdateInfoActivity.class);
    this.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dy
 * JD-Core Version:    0.7.0.1
 */