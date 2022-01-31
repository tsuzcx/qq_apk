package com.tencent.beacon.b;

import android.content.Context;
import com.tencent.beacon.a.b.e.a;
import com.tencent.beacon.d.a;
import com.tencent.beacon.event.m;
import com.tencent.beacon.upload.f;
import com.tencent.beacon.upload.g;
import java.util.Arrays;
import java.util.List;

public final class d
  implements com.tencent.beacon.a.b.b
{
  private static d a = null;
  private Context b;
  private g c;
  private f d;
  
  private d(Context paramContext, g paramg)
  {
    this.b = paramContext.getApplicationContext();
    this.c = paramg;
    this.d = new e();
    if (this.c != null) {
      this.c.a(105, this.d);
    }
    paramContext = com.tencent.beacon.a.b.c.a(this.b);
    paramContext.a(this);
    paramContext.a(2, this.c);
  }
  
  public static d a(Context paramContext, g paramg)
  {
    try
    {
      if ((a == null) && (!m.a))
      {
        a.e(" SpeedMonitorModule create instance", new Object[0]);
        a = new d(paramContext, paramg);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static d d()
  {
    try
    {
      d locald = a;
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean e()
  {
    com.tencent.beacon.a.b.e locale = com.tencent.beacon.a.b.e.a();
    if (locale != null) {
      return locale.c(2);
    }
    return false;
  }
  
  public final void a() {}
  
  public final boolean a(b[] paramArrayOfb)
  {
    if ((paramArrayOfb == null) || (paramArrayOfb.length <= 0)) {
      return true;
    }
    paramArrayOfb = Arrays.asList(paramArrayOfb);
    com.tencent.beacon.a.c.a().a(new c(this.b, paramArrayOfb));
    return true;
  }
  
  public final void b()
  {
    Object localObject = com.tencent.beacon.a.b.c.a(this.b).b();
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((com.tencent.beacon.a.b.e)localObject).b(2);
      if ((((e.a)localObject).a()) && (localObject != null) && (((e.a)localObject).e() != null)) {
        try
        {
          f localf = this.d;
          localObject = e.a(((e.a)localObject).e());
          if (localObject != null)
          {
            a((b[])((List)localObject).toArray(new b[0]));
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public final void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.b.d
 * JD-Core Version:    0.7.0.1
 */