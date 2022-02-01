package com.tencent.qqmini.sdk.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

final class MiniCustomDialog$2
  implements DialogInterface.OnClickListener
{
  MiniCustomDialog$2(Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramDialogInterface.setData(Uri.fromParts("package", this.val$activity.getPackageName(), null));
      this.val$activity.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniCustomDialog.2
 * JD-Core Version:    0.7.0.1
 */