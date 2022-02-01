package com.tencent.android.tpush.common;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;

final class b$1
  implements Runnable
{
  b$1(int paramInt, Context paramContext) {}
  
  public void run()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        String str1;
        if (ChannelUtils.isBrandHuaWei())
        {
          str1 = "content://com.huawei.android.launcher.settings/badge/";
          TLogger.i("BadgeUtils", "change huawei badge " + this.a);
          Bundle localBundle1 = new Bundle();
          localBundle1.putString("package", this.b.getPackageName());
          localBundle1.putString("class", i.p(this.b));
          Bundle localBundle2 = this.b.getContentResolver().call(Uri.parse(str1), "getbadgeNumber", null, localBundle1);
          if (localBundle2 == null) {
            break label196;
          }
          i = localBundle2.getInt("badgenumber", 0);
          i += this.a;
          if (i < 0)
          {
            i = j;
            localBundle1.putInt("badgenumber", i);
            this.b.getContentResolver().call(Uri.parse(str1), "change_badge", null, localBundle1);
          }
        }
        else
        {
          if (!ChannelUtils.isBrandHonor()) {
            break label201;
          }
          str1 = "content://com.huawei.android.launcher.settings/badge/";
          continue;
        }
        continue;
      }
      catch (Throwable localThrowable)
      {
        TLogger.w("BadgeUtils", "change huawei badge error: " + localThrowable.toString());
        return;
      }
      label196:
      int i = 0;
      continue;
      label201:
      String str2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.common.b.1
 * JD-Core Version:    0.7.0.1
 */