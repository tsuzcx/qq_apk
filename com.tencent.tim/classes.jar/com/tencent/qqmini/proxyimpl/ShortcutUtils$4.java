package com.tencent.qqmini.proxyimpl;

import acfp;
import android.app.Activity;
import aswu.b;
import aswx;
import aswy;

public final class ShortcutUtils$4
  implements Runnable
{
  public ShortcutUtils$4(Activity paramActivity) {}
  
  public void run()
  {
    if (aswu.b.canShowDialog()) {
      aswu.b.a(this.val$activity, acfp.m(2131714449), acfp.m(2131714455), acfp.m(2131714436), new aswx(this), new aswy(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShortcutUtils.4
 * JD-Core Version:    0.7.0.1
 */