package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.token.p;

final class db
  implements DialogInterface.OnClickListener
{
  db(DetectIDPhotoActivity paramDetectIDPhotoActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.dismissDialog();
    p.a().a(System.currentTimeMillis(), 134);
    paramDialogInterface = new Intent(this.a, RealNameTakeIDPhotoActivity.class);
    if ((DetectIDPhotoActivity.access$800(this.a) != null) && (DetectIDPhotoActivity.access$800(this.a).length() > 0)) {
      paramDialogInterface.putExtra("frontdata", DetectIDPhotoActivity.access$800(this.a));
    }
    paramDialogInterface.putExtra("scene", 2);
    this.a.startActivityForResult(paramDialogInterface, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.db
 * JD-Core Version:    0.7.0.1
 */