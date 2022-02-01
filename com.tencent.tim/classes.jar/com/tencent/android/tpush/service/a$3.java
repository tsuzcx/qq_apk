package com.tencent.android.tpush.service;

import android.content.Context;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.d;
import com.tencent.android.tpush.service.protocol.m;
import com.tencent.android.tpush.service.protocol.n;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.XGApiConfig;

class a$3
  implements com.tencent.android.tpush.service.c.a
{
  a$3(a parama, Context paramContext, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString, d paramd)
  {
    if (paramInt == 0)
    {
      n localn = new n();
      try
      {
        if (i.b(paramString)) {
          paramString = i.e(SharePrefsUtil.getString(this.a, "REGISTERED_RSP", ""));
        }
        for (;;)
        {
          localn.a(paramString);
          TLogger.dd("PushServiceBroadcastHandler", ">> Register onResponse [accId = " + this.b + ", token:" + localn.b + ", otherPushType:" + localn.d + ", otherToken:" + localn.e + " , packName = " + this.c + "]");
          a.a(this.e, paramInt, localn, (m)paramd, this.c, this.d);
          c.b(this.a);
          XGApiConfig.setRegisterSuccess(this.a);
          return;
          SharePrefsUtil.setString(this.a, "REGISTERED_RSP", i.f(paramString));
        }
        TLogger.ww("PushServiceBroadcastHandler", ">> Register ack fail, 服务器处理失败,返回错误; responseCode = " + paramInt);
      }
      catch (Throwable paramString)
      {
        TLogger.ee("PushServiceBroadcastHandler", ">> Register onResponse fail, 解析返回内容格式错误 " + paramInt);
        a.a(this.e, -101, "解析服务器返回内容失败", (m)paramd, this.c);
        return;
      }
    }
    a.a(this.e, paramInt, "服务器处理失败，返回错误", (m)paramd, this.c);
  }
  
  public void b(int paramInt, String paramString, d paramd)
  {
    TLogger.ee("PushServiceBroadcastHandler", "@@ registetr onMessageSendFailed: " + paramInt + ", " + paramString);
    a.a(this.e, paramInt, paramString, (m)paramd, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.a.3
 * JD-Core Version:    0.7.0.1
 */