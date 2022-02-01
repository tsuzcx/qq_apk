package com.tencent.android.tpush.service;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.d;
import com.tencent.android.tpush.service.util.SharePrefsUtil;

class a$9
  implements com.tencent.android.tpush.service.c.a
{
  a$9(a parama, String paramString1, String paramString2, String paramString3, String paramString4, Context paramContext) {}
  
  public void a(int paramInt, String paramString, d paramd)
  {
    if (paramInt == 0)
    {
      TLogger.ii("PushServiceBroadcastHandler", ">> bind OtherPushToken success ack with [accId = " + this.a + "  , rsp = " + paramInt + "]  token = " + this.b + " otherPushType = " + this.c + " otherPushToken = " + this.d);
      SharePrefsUtil.setString(this.e, this.a + "otherpush", this.b + ":" + this.d);
      SharePrefsUtil.setLong(this.e, this.a + "otherpush" + "ts", System.currentTimeMillis());
      return;
    }
    TLogger.ee("PushServiceBroadcastHandler", ">> updateOtherPushToken ack failed responseCode=" + paramInt);
  }
  
  public void b(int paramInt, String paramString, d paramd)
  {
    TLogger.ee("PushServiceBroadcastHandler", "@@ updateOtherPushToken onMessageSendFailed " + paramInt + "," + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.a.9
 * JD-Core Version:    0.7.0.1
 */