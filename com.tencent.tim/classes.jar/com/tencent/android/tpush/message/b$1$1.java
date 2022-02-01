package com.tencent.android.tpush.message;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.stat.ServiceStat;

class b$1$1
  implements Runnable
{
  b$1$1(b.1 param1, Intent paramIntent, Context paramContext, String paramString) {}
  
  public void run()
  {
    long l = this.a.getLongExtra("msgId", -1L);
    MessageManager.getInstance().updateCachedMsgIntentToCancel(this.b, l);
    Intent localIntent = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
    localIntent.setPackage(this.c);
    localIntent.putExtras(this.a);
    localIntent.putExtra("TPUSH.FEEDBACK", 4);
    BroadcastAgent.sendBroadcast(this.b, localIntent);
    localIntent = new Intent("com.tencent.android.xg.vip.action.PUSH_CANCELLED.RESULT.V4");
    localIntent.putExtras(this.a);
    localIntent.putExtra("clickTime", System.currentTimeMillis() / 1000L);
    ServiceStat.appReportNotificationCleared(this.b, localIntent);
    BroadcastAgent.sendBroadcast(this.b, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.message.b.1.1
 * JD-Core Version:    0.7.0.1
 */