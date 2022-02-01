package com.tencent.android.tpush.service;

import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.d;
import com.tencent.android.tpush.service.protocol.r;

class a$8
  implements com.tencent.android.tpush.service.c.a
{
  a$8(a parama, String paramString1, String paramString2) {}
  
  public void a(int paramInt, String paramString, d paramd)
  {
    if (paramInt == 0)
    {
      TLogger.ii("PushServiceBroadcastHandler", ">> UnRegister ack with [accId = " + this.a + " , packName = " + this.b + " , rsp = " + "]");
      a.a(this.c, paramInt, (r)paramd, this.b);
      return;
    }
    TLogger.e("PushServiceBroadcastHandler", ">> unregeister ack failed responseCode=" + paramInt);
    a.a(this.c, paramInt, "服务器处理失败，返回错误", (r)paramd, this.b);
  }
  
  public void b(int paramInt, String paramString, d paramd)
  {
    TLogger.e("PushServiceBroadcastHandler", "@@ unregister onMessageSendFailed " + paramInt + "," + paramString);
    a.a(this.c, paramInt, paramString, (r)paramd, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.a.8
 * JD-Core Version:    0.7.0.1
 */