package com.tencent.android.tpush.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.f.a;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;

final class b$1
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("packName");
    TLogger.ii("MessageHelper", "onReceive: Notification has canceled! pkg name: " + str);
    if ((a.a(paramContext.getApplicationContext())) || ((!i.b(str)) && (str.equals(paramContext.getPackageName())))) {
      CommonWorkingThread.getInstance().execute(new b.1.1(this, paramIntent, paramContext, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.message.b.1
 * JD-Core Version:    0.7.0.1
 */