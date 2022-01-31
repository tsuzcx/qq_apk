package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class cu
  implements DialogInterface.OnClickListener
{
  cu(ct paramct) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.dismissDialog();
    paramDialogInterface = new Intent(this.a.a, FaceRecognitionDefaultActivity.class);
    paramDialogInterface.addFlags(67108864);
    this.a.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.cu
 * JD-Core Version:    0.7.0.1
 */