package com.tencent.android.tpush.common;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.android.tpush.logging.TLogger;

final class b$3
  implements Runnable
{
  b$3(int paramInt, Context paramContext) {}
  
  public void run()
  {
    try
    {
      TLogger.i("BadgeUtils", "set oppo badge " + this.a);
      Bundle localBundle = new Bundle();
      localBundle.putInt("app_badge_count", this.a);
      this.b.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, localBundle);
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.w("BadgeUtils", "set oppo badge error" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.common.b.3
 * JD-Core Version:    0.7.0.1
 */