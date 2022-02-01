package com.tencent.android.tpush.common;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;

final class b$2
  implements Runnable
{
  b$2(int paramInt, Context paramContext) {}
  
  public void run()
  {
    String str = "";
    try
    {
      if (ChannelUtils.isBrandHuaWei()) {
        str = "content://com.huawei.android.launcher.settings/badge/";
      }
      for (;;)
      {
        TLogger.i("BadgeUtils", "set huawei badge " + this.a);
        Bundle localBundle = new Bundle();
        localBundle.putString("package", this.b.getPackageName());
        localBundle.putString("class", i.p(this.b));
        localBundle.putInt("badgenumber", this.a);
        this.b.getContentResolver().call(Uri.parse(str), "change_badge", null, localBundle);
        return;
        if (ChannelUtils.isBrandHonor()) {
          str = "content://com.huawei.android.launcher.settings/badge/";
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.w("BadgeUtils", "set huawei badge error: " + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.common.b.2
 * JD-Core Version:    0.7.0.1
 */