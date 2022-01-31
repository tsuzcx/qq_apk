package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class en
  implements DialogInterface.OnClickListener
{
  en(el paramel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a.a, FaceRecognitionCameraActivity.class);
    paramDialogInterface.putExtra("flag", 2);
    paramDialogInterface.putExtra("scene", 11);
    this.a.a.startActivityForResult(paramDialogInterface, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.en
 * JD-Core Version:    0.7.0.1
 */