package com.tencent.android.tpush.service;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.d;

class a$2
  implements com.tencent.android.tpush.service.c.a
{
  a$2(a parama, String paramString1, Context paramContext, String paramString2, Intent paramIntent) {}
  
  public void a(int paramInt, String paramString, d paramd)
  {
    if (paramInt == 0)
    {
      TLogger.ii("PushServiceBroadcastHandler", ">> sendCommReportMessage ack with [accId = " + this.a + "  , rsp = " + paramInt + "]");
      com.tencent.android.tpush.a.b(this.b, this.c, this.d.toURI());
      return;
    }
    TLogger.ee("PushServiceBroadcastHandler", ">> sendCommReportMessage ack failed responseCode=" + paramInt);
  }
  
  public void b(int paramInt, String paramString, d paramd)
  {
    TLogger.ee("PushServiceBroadcastHandler", "@@ sendCommReportMessage onMessageSendFailed " + paramInt + "," + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.a.2
 * JD-Core Version:    0.7.0.1
 */