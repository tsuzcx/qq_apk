package com.tencent.biz.qrcode.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

public abstract class ScannerActivity$QQDialogCancelListener
  implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener
{
  public abstract void a();
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    a();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerActivity.QQDialogCancelListener
 * JD-Core Version:    0.7.0.1
 */