package com.huawei.hms.support.api.push.b;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.api.push.b.c.d;
import com.huawei.hms.support.log.HMSLog;

public class a
{
  private void a(Context paramContext, Intent paramIntent, com.huawei.hms.support.api.push.b.b.a parama)
  {
    HMSLog.i("PushSelfShowLog", "receive a selfshow message ,the type is" + parama.j());
    if (!com.huawei.hms.support.api.push.b.a.a.a(parama.j())) {
      return;
    }
    long l = com.huawei.hms.support.api.push.b.d.a.a(parama.h());
    if (l == 0L)
    {
      new d(paramContext, parama, paramIntent.getStringExtra("extra_encrypt_data")).start();
      return;
    }
    HMSLog.d("PushSelfShowLog", "waiting ……");
    paramIntent.setPackage(paramContext.getPackageName());
    com.huawei.hms.support.api.push.b.d.a.a(paramContext, paramIntent, l);
  }
  
  private void a(Context paramContext, Intent paramIntent, String paramString, com.huawei.hms.support.api.push.b.b.a parama, int paramInt)
  {
    HMSLog.d("PushSelfShowLog", "receive a selfshow userhandle message");
    if (!"-1".equals(paramString)) {
      com.huawei.hms.support.api.push.b.d.a.b(paramContext, paramIntent);
    }
    for (;;)
    {
      if ("1".equals(paramString)) {
        new com.huawei.hms.support.api.push.b.a.a(paramContext, parama).a();
      }
      return;
      com.huawei.hms.support.api.push.b.d.a.a(paramContext, paramInt);
    }
  }
  
  private void a(Context paramContext, Intent paramIntent, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, int paramInt)
  {
    paramArrayOfByte1 = new com.huawei.hms.support.api.push.b.b.a(paramArrayOfByte1, paramArrayOfByte2);
    if (!paramArrayOfByte1.b())
    {
      HMSLog.d("PushSelfShowLog", "parseMessage failed");
      return;
    }
    HMSLog.i("PushSelfShowLog", " onReceive the msg id = " + paramArrayOfByte1.a() + ",and cmd is" + paramArrayOfByte1.j() + ",and the eventId is " + paramString);
    if (paramString == null)
    {
      a(paramContext, paramIntent, paramArrayOfByte1);
      return;
    }
    a(paramContext, paramIntent, paramString, paramArrayOfByte1, paramInt);
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {}
    try
    {
      HMSLog.d("PushSelfShowLog", "enter SelfShowReceiver receiver, context or intent is null");
      return;
    }
    catch (RuntimeException paramContext)
    {
      Object localObject;
      byte[] arrayOfByte;
      HMSLog.d("PushSelfShowLog", "onReceive RuntimeException.");
      return;
      String str = paramIntent.getStringExtra("selfshow_event_id");
      int i = paramIntent.getIntExtra("selfshow_notify_id", 0);
      HMSLog.i("PushSelfShowLog", "get notifyId:" + i);
      a(paramContext, paramIntent, (byte[])localObject, arrayOfByte, str, i);
      return;
    }
    catch (Exception paramContext)
    {
      HMSLog.d("PushSelfShowLog", "onReceive Exception.");
    }
    localObject = paramIntent.getAction();
    if (("com.huawei.intent.action.PUSH".equals(localObject)) || ("com.huawei.push.msg.NOTIFY_MSG".equals(localObject)) || ("com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(localObject)))
    {
      localObject = paramIntent.getByteArrayExtra("selfshow_info");
      arrayOfByte = paramIntent.getByteArrayExtra("selfshow_token");
      if ((localObject == null) || (localObject.length == 0) || (arrayOfByte == null) || (arrayOfByte.length == 0))
      {
        HMSLog.i("PushSelfShowLog", "self show info or token is null.");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.push.b.a
 * JD-Core Version:    0.7.0.1
 */