package com.tencent.android.tpush.service;

import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.d;

class a$4
  implements com.tencent.android.tpush.service.c.a
{
  a$4(a parama, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void a(int paramInt, String paramString, d paramd)
  {
    if (paramInt == 0)
    {
      if (XGPushConfig.enableDebug) {
        TLogger.d("PushServiceBroadcastHandler", ">> AccountHandler [accId = " + this.a + ", packageNme: " + this.b + "]");
      }
      a.a(this.f, paramInt, this.c, this.d, this.e, this.b);
      return;
    }
    TLogger.e("PushServiceBroadcastHandler", ">> AccountHandler ack fail responseCode = " + paramInt);
    a.a(this.f, paramInt, "服务器处理失败，返回错误", this.c, this.d, this.e, this.b);
  }
  
  public void b(int paramInt, String paramString, d paramd)
  {
    TLogger.ee("PushServiceBroadcastHandler", "@@ AccountHandler onMessageSendFailed: " + paramInt + ", " + paramString);
    a.a(this.f, paramInt, paramString, this.c, this.d, this.e, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.a.4
 * JD-Core Version:    0.7.0.1
 */