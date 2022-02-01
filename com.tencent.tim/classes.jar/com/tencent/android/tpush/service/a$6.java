package com.tencent.android.tpush.service;

import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.d;

class a$6
  implements com.tencent.android.tpush.service.c.a
{
  a$6(a parama, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3) {}
  
  public void a(int paramInt, String paramString, d paramd)
  {
    if (paramInt == 0)
    {
      TLogger.ii("PushServiceBroadcastHandler", "Get tags ack success  [accId = " + this.a + " , offset = " + this.b + " , limit = " + this.c + ", response = " + paramString + "]");
      a.a(this.g, paramInt, this.b, this.c, this.d, paramString, this.e);
      return;
    }
    TLogger.ee("PushServiceBroadcastHandler", "Set tag ack failed with responseCode = " + paramInt + " , tagName = " + this.f);
    a.b(this.g, paramInt, this.b, this.c, this.d, paramString, this.e);
  }
  
  public void b(int paramInt, String paramString, d paramd)
  {
    TLogger.ee("PushServiceBroadcastHandler", "@@ QueryTagsHandler onMessageSendFailed: " + paramInt + ", " + paramString);
    a.b(this.g, paramInt, this.b, this.c, this.d, paramString, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.a.6
 * JD-Core Version:    0.7.0.1
 */