package com.huawei.hms.support.api.push.b.c;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

public class d
  extends Thread
{
  private Context a;
  private com.huawei.hms.support.api.push.b.b.a b;
  private String c;
  
  public d(Context paramContext, com.huawei.hms.support.api.push.b.b.a parama, String paramString)
  {
    this.a = paramContext;
    this.b = parama;
    this.c = paramString;
  }
  
  private static Intent a(Context paramContext, com.huawei.hms.support.api.push.b.b.a parama)
  {
    if (parama == null) {
      return null;
    }
    Intent localIntent1 = com.huawei.hms.support.api.push.b.d.a.b(paramContext, parama.o());
    if (parama.g() != null) {}
    for (;;)
    {
      try
      {
        localObject = Intent.parseUri(parama.g(), 0);
        HMSLog.d("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0)，" + ((Intent)localObject).toURI());
        boolean bool = com.huawei.hms.support.api.push.b.d.a.a(paramContext, parama.o(), (Intent)localObject).booleanValue();
        if (!bool) {
          break label172;
        }
        paramContext = (Context)localObject;
        return paramContext;
      }
      catch (Exception paramContext)
      {
        HMSLog.w("PushSelfShowLog", "intentUri error" + paramContext.toString());
        return localIntent1;
      }
      Object localObject = localIntent1;
      if (parama.p() != null)
      {
        Intent localIntent2 = new Intent(parama.p());
        localObject = localIntent1;
        if (com.huawei.hms.support.api.push.b.d.a.a(paramContext, parama.o(), localIntent2).booleanValue()) {
          localObject = localIntent2;
        }
      }
      ((Intent)localObject).setPackage(parama.o());
      return localObject;
      label172:
      paramContext = localIntent1;
    }
  }
  
  private boolean a(Context paramContext)
  {
    if ("cosa".equals(this.b.j())) {
      return b(paramContext);
    }
    return true;
  }
  
  private boolean b(Context paramContext)
  {
    return com.huawei.hms.support.api.push.b.d.a.c(paramContext, this.b.o());
  }
  
  private boolean b(Context paramContext, com.huawei.hms.support.api.push.b.b.a parama)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ("cosa".equals(parama.j()))
    {
      parama = a(paramContext, parama);
      bool1 = bool2;
      if (parama == null)
      {
        HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
        bool1 = true;
      }
      if (!com.huawei.hms.support.api.push.b.d.a.a(paramContext, parama))
      {
        HMSLog.i("PushSelfShowLog", "no permission to start activity");
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void run()
  {
    HMSLog.i("PushSelfShowLog", "enter run()");
    try
    {
      if (a(this.a))
      {
        if (b(this.a, this.b)) {
          return;
        }
        c.a(this.a, this.b, this.c);
        return;
      }
    }
    catch (Exception localException)
    {
      HMSLog.e("PushSelfShowLog", localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.push.b.c.d
 * JD-Core Version:    0.7.0.1
 */