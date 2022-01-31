package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.token.utils.t;

final class du
  implements DialogInterface.OnClickListener
{
  du(ds paramds) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (t.l() == 0) {}
    for (paramDialogInterface = new Intent(this.a.a, FaceRecognitionCameraActivityOld.class);; paramDialogInterface = new Intent(this.a.a, FaceRecognitionCameraActivity.class))
    {
      paramDialogInterface.putExtra("flag", 2);
      paramDialogInterface.putExtra("scene", 9);
      this.a.a.startActivityForResult(paramDialogInterface, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.du
 * JD-Core Version:    0.7.0.1
 */