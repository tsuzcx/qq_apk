package com.tencent.android.tpush.common;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.logging.TLogger;

final class b$4
  implements Runnable
{
  b$4(int paramInt, Context paramContext) {}
  
  public void run()
  {
    try
    {
      TLogger.i("BadgeUtils", "set vivo badge " + this.a);
      Intent localIntent = new Intent();
      localIntent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
      localIntent.putExtra("packageName", this.b.getPackageName());
      localIntent.putExtra("className", i.p(this.b));
      localIntent.putExtra("notificationNum", this.a);
      localIntent.addFlags(16777216);
      this.b.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.w("BadgeUtils", "set vivo badge error: " + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.common.b.4
 * JD-Core Version:    0.7.0.1
 */