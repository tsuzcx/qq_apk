package com.tencent.android.tpush.service;

import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.d;

class a$7
  implements com.tencent.android.tpush.service.c.a
{
  a$7(a parama, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public void a(int paramInt, String paramString, d paramd)
  {
    if (paramInt == 0)
    {
      TLogger.ii("PushServiceBroadcastHandler", "Set tag ack success  [accId = " + this.a + " , tagtype = " + this.b + " , tagName = " + this.c + ", packName = " + this.d + "]");
      a.a(this.f, paramInt, this.c, this.b, this.d, this.e);
      return;
    }
    TLogger.ee("PushServiceBroadcastHandler", "Set tag ack failed with responseCode = " + paramInt + " , tagName = " + this.c);
    a.b(this.f, paramInt, "服务器处理失败，返回错误", this.c, this.b, this.d, this.e);
  }
  
  public void b(int paramInt, String paramString, d paramd)
  {
    TLogger.ee("PushServiceBroadcastHandler", "@@ TagHandler onMessageSendFailed: " + paramInt + ", " + paramString);
    a.b(this.f, paramInt, paramString, this.c, this.b, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.a.7
 * JD-Core Version:    0.7.0.1
 */