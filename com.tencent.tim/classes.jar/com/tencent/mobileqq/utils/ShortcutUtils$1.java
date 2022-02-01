package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.res.Resources;
import aqml;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public final class ShortcutUtils$1
  implements Runnable
{
  public void run()
  {
    boolean bool = aqml.hasShortCut(this.val$context, new String[] { this.val$context.getString(2131721057) });
    if (QLog.isColorLevel()) {
      QLog.d(aqml.access$000(), 2, "createShortcut " + bool + ", " + aqml.access$100());
    }
    if (bool)
    {
      if (aqml.access$108() < 3) {
        ThreadManager.getSubThreadHandler().postDelayed(this, 1000L);
      }
      return;
    }
    Intent localIntent1 = new Intent("android.intent.action.MAIN");
    localIntent1.setClassName(this.val$context, this.val$className);
    localIntent1.addCategory("android.intent.category.LAUNCHER");
    localIntent1.addFlags(268435456);
    localIntent1.addFlags(2097152);
    Intent localIntent2 = new Intent();
    localIntent2.putExtra("android.intent.extra.shortcut.INTENT", localIntent1);
    localIntent2.putExtra("android.intent.extra.shortcut.NAME", this.val$context.getResources().getString(2131721057));
    localIntent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this.val$context.getApplicationContext(), 2130840732));
    localIntent2.putExtra("duplicate", false);
    localIntent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
    this.val$context.sendOrderedBroadcast(localIntent2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShortcutUtils.1
 * JD-Core Version:    0.7.0.1
 */