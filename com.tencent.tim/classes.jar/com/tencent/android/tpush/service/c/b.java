package com.tencent.android.tpush.service.c;

import android.content.Context;
import android.os.Process;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.MessageType;
import com.tencent.android.tpush.service.protocol.d;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.MqttChannel;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;

public class b
{
  private static volatile boolean a = true;
  private static volatile boolean b = true;
  private long c = b();
  
  public static b a()
  {
    return c.a;
  }
  
  private void a(Context paramContext, b paramb)
  {
    TLogger.d("XGMqttChannel", "doActionWhenConnected");
    if (!Util.isNullOrEmptyString(GuidInfoManager.getToken(paramContext)))
    {
      paramb.a();
      return;
    }
    MqttChannel.getInstance(paramContext).getConnectState(new b.3(this, paramb, paramContext));
  }
  
  private long b()
  {
    int i = Process.myPid();
    long l = System.currentTimeMillis();
    return (i % 1000 + l % 100000000000L * 1000L) * 1000L;
  }
  
  private static void b(Context paramContext, int paramInt, String paramString, long paramLong, d paramd)
  {
    if (paramInt != 0) {
      if (paramInt != -1103) {
        break label125;
      }
    }
    for (;;)
    {
      try
      {
        if (!a) {
          break label124;
        }
        a = false;
        ServiceStat.reportErrCode(paramContext, paramInt, paramString, paramLong, paramd.a().getStr());
        return;
      }
      catch (Throwable paramContext)
      {
        TLogger.e("XGMqttChannel", "handleErrCodeReport error: " + paramContext.getMessage());
        return;
      }
      if (b)
      {
        b = false;
        ServiceStat.reportErrCode(paramContext, paramInt, paramString, paramLong, paramd.a().getStr());
        return;
      }
      label124:
      label125:
      do
      {
        if ((paramInt <= 1010000) || (paramInt >= 1011000))
        {
          ServiceStat.reportErrCode(paramContext, paramInt, paramString, paramLong, paramd.a().getStr());
          return;
          a = true;
        }
        return;
        if (paramInt == -3) {
          break;
        }
      } while (paramInt != -4);
    }
  }
  
  public void a(Context paramContext, d paramd, a parama)
  {
    a(paramContext, new b.1(this, paramd, paramContext, parama));
  }
  
  public void b(Context paramContext, d paramd, a parama)
  {
    a(paramContext, new b.2(this, paramd, paramContext, parama));
  }
  
  static class a
    extends OnMqttCallback
  {
    private a a;
    private d b;
    private Context c;
    
    a(Context paramContext, a parama, d paramd)
    {
      this.c = paramContext.getApplicationContext();
      this.a = parama;
      this.b = paramd;
    }
    
    public void callback(int paramInt, String paramString)
    {
      if (paramInt >= 0) {
        this.a.a(paramInt, paramString, this.b);
      }
      for (;;)
      {
        b.a(this.c, paramInt, paramString, this.requestId, this.b);
        return;
        this.a.b(paramInt, paramString, this.b);
      }
    }
  }
  
  static abstract interface b
  {
    public abstract void a();
    
    public abstract void a(int paramInt, String paramString);
  }
  
  public static class c
  {
    public static b a = new b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.c.b
 * JD-Core Version:    0.7.0.1
 */