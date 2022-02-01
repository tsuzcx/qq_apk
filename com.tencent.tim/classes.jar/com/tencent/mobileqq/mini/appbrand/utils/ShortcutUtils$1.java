package com.tencent.mobileqq.mini.appbrand.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import jll;

final class ShortcutUtils$1
  implements DialogInterface.OnClickListener
{
  ShortcutUtils$1(BaseActivity paramBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    jll.openPermissionActivity(this.val$activity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ShortcutUtils.1
 * JD-Core Version:    0.7.0.1
 */