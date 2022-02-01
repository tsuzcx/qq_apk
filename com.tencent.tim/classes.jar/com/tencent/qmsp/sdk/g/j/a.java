package com.tencent.qmsp.sdk.g.j;

import android.content.Context;
import com.tencent.qmsp.sdk.base.IVendorCallback;
import com.tencent.qmsp.sdk.base.b;
import com.tencent.qmsp.sdk.base.c;
import java.lang.reflect.Method;

public class a
  implements b
{
  private static Class b;
  private static Object c;
  private static Method d;
  private static Method e;
  private Context a;
  
  public a()
  {
    try
    {
      c.c("xm start");
      b = Class.forName("com.android.id.impl.IdProviderImpl");
      c = b.newInstance();
      Class localClass = b;
      d = localClass.getMethod("getOAID", new Class[] { Context.class });
      localClass = b;
      e = localClass.getMethod("getAAID", new Class[] { Context.class });
      return;
    }
    catch (Exception localException)
    {
      c.a("xm reflect exception!" + localException);
    }
  }
  
  private String a(Context paramContext, Object paramObject, Method paramMethod)
  {
    if ((paramObject != null) && (paramMethod != null)) {
      try
      {
        paramContext = paramMethod.invoke(paramObject, new Object[] { paramContext });
        if (paramContext != null)
        {
          paramContext = (String)paramContext;
          return paramContext;
        }
      }
      catch (Exception paramContext) {}
    }
    return null;
  }
  
  public String a()
  {
    Object localObject = c;
    if (localObject != null)
    {
      Method localMethod = d;
      if (localMethod != null) {
        return a(this.a, localObject, localMethod);
      }
    }
    return null;
  }
  
  public void a(Context paramContext, IVendorCallback paramIVendorCallback)
  {
    this.a = paramContext;
  }
  
  public String b()
  {
    Object localObject = c;
    if (localObject != null)
    {
      Method localMethod = e;
      if (localMethod != null) {
        return a(this.a, localObject, localMethod);
      }
    }
    return null;
  }
  
  public void c() {}
  
  public boolean d()
  {
    return true;
  }
  
  public boolean e()
  {
    return (b != null) && (c != null);
  }
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.j.a
 * JD-Core Version:    0.7.0.1
 */