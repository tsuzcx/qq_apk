package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

public class aa
  extends Handler
{
  public int a = 1;
  public do b = new do();
  public q c;
  public dg d;
  
  public aa(Looper paramLooper, dg paramdg)
  {
    super(paramLooper);
    this.b.F = 32;
    this.c = new q();
    this.d = paramdg;
  }
  
  public final String a(Context paramContext)
  {
    System.currentTimeMillis();
    paramContext = p.a(paramContext);
    paramContext = ed.a(a(ed.b(), paramContext), paramContext.g, false);
    if ((paramContext instanceof try)) {
      return ((try)paramContext).B;
    }
    return "";
  }
  
  public final boolean a()
  {
    System.currentTimeMillis();
    Object localObject = this.c.a();
    localObject = ed.a(a(ed.b(), (ac)localObject), ((ac)localObject).g, false);
    if ((localObject instanceof Bilberry))
    {
      localObject = (Bilberry)localObject;
      this.c.a((Bilberry)localObject);
      return true;
    }
    return false;
  }
  
  public final byte[] a(Context paramContext, ac paramac)
  {
    int i = paramac.a;
    Object localObject1 = paramac.f;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.c;
      if (!TextUtils.isEmpty(((q)localObject2).a)) {
        break label164;
      }
      localObject2 = ((q)localObject2).d;
      label40:
      localObject2 = z.a(i, (byte[])localObject1, (String)localObject2);
      do localdo = this.b;
      if (paramac.a != 152) {
        break label174;
      }
      localObject1 = "";
      label70:
      localdo.D = ((String)localObject1);
      this.b.B = p.b(paramContext);
      paramContext = z.a(this.a, (int)localObject2, this.b);
      i = paramac.c;
      paramContext = ed.a(paramContext);
      localObject1 = this.d;
      if (localObject1 != null) {
        break label186;
      }
      paramContext = new byte[0];
      label127:
      paramContext = ed.a(paramContext, new char(), false);
      if (paramContext != null) {
        break label215;
      }
    }
    label164:
    label174:
    label186:
    label215:
    for (paramContext = null;; paramContext = (char)paramContext)
    {
      for (;;)
      {
        if (paramContext != null) {
          break label223;
        }
        return null;
        localObject1 = ed.a(paramac.e);
        break;
        localObject2 = ((q)localObject2).b;
        break label40;
        localObject1 = this.c.a;
        break label70;
        localObject1 = (o)localObject1;
        try
        {
          paramContext = ((o)localObject1).a(i, paramContext).b;
        }
        catch (Throwable paramContext)
        {
          paramContext = new byte[0];
        }
      }
      break label127;
    }
    label223:
    i = this.a;
    this.a = (i + 1);
    if (i >= 2147483647) {
      this.a = 1;
    }
    paramac = z.a(paramac.b, paramContext);
    if (paramac == null) {
      return null;
    }
    paramContext = this.c;
    if (TextUtils.isEmpty(paramContext.a)) {}
    for (paramContext = paramContext.d;; paramContext = paramContext.b) {
      return z.a(paramac, paramContext);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1) {
      if (i == 2) {}
    }
    do
    {
      do
      {
        return;
        paramMessage = (ac)paramMessage.obj;
        Object localObject1 = paramMessage.d;
        if ((this.c.b()) && (!a()))
        {
          ((t)localObject1).a(-1, null);
          return;
        }
        Object localObject2 = ed.b();
        if (TextUtils.isEmpty(p.b((Context)localObject2)))
        {
          p.a((Context)localObject2, a((Context)localObject2));
          if (TextUtils.isEmpty(p.b((Context)localObject2)))
          {
            ((t)localObject1).a(-2, null);
            return;
          }
        }
        localObject1 = a((Context)localObject2, paramMessage);
        localObject2 = paramMessage.g;
        if (localObject2 != null)
        {
          localObject1 = ed.a((byte[])localObject1, (float)localObject2, false);
          if (localObject1 == null)
          {
            ((t)paramMessage.d).a(-3, null);
            return;
          }
          ((t)paramMessage.d).a(0, (float)localObject1);
          return;
        }
        if (localObject1 == null)
        {
          ((t)paramMessage.d).a(-3, null);
          return;
        }
        ((t)paramMessage.d).a(0, (byte[])localObject1);
        return;
        System.currentTimeMillis();
      } while (!a());
      paramMessage = ed.b();
    } while (!TextUtils.isEmpty(p.b(paramMessage)));
    p.a(paramMessage, a(paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.aa
 * JD-Core Version:    0.7.0.1
 */