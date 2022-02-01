package com.tencent.mobileqq.mini.appbrand.utils;

import acfp;
import android.app.Activity;

final class ShortcutUtils$4
  implements Runnable
{
  ShortcutUtils$4(Activity paramActivity) {}
  
  public void run()
  {
    if (ShortcutUtils.PermissionDialog.canShowDialog()) {
      ShortcutUtils.PermissionDialog.createPermissionDialog(this.val$activity, acfp.m(2131714449), acfp.m(2131714455), acfp.m(2131714436), new ShortcutUtils.4.1(this), new ShortcutUtils.4.2(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ShortcutUtils.4
 * JD-Core Version:    0.7.0.1
 */