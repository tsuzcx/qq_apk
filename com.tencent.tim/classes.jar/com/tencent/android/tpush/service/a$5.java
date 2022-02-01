package com.tencent.android.tpush.service;

import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.d;

class a$5
  implements com.tencent.android.tpush.service.c.a
{
  a$5(a parama, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public void a(int paramInt, String paramString, d paramd)
  {
    if (paramInt == 0)
    {
      TLogger.ii("PushServiceBroadcastHandler", "Set attributes ack success  [accId = " + this.a + " ,attributesType = " + this.b + " ,attributesName = " + this.c + " ,packName = " + this.d + "]");
      a.a(this.f, paramInt, this.c, this.b, this.d, this.e, paramString);
      return;
    }
    TLogger.ee("PushServiceBroadcastHandler", "Set attributes ack failed with responseCode = " + paramInt + " , attributesName = " + this.c);
    a.a(this.f, paramInt, "服务器处理失败，返回错误", this.c, this.b, this.d, this.e);
  }
  
  public void b(int paramInt, String paramString, d paramd)
  {
    TLogger.ee("PushServiceBroadcastHandler", "@@ attributesHandler onMessageSendFailed: " + paramInt + ", " + paramString);
    a.a(this.f, paramInt, paramString, this.c, this.b, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.a.5
 * JD-Core Version:    0.7.0.1
 */