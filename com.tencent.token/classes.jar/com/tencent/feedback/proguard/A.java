package com.tencent.feedback.proguard;

import android.content.Context;
import com.tencent.feedback.common.c;
import com.tencent.feedback.common.e;
import com.tencent.feedback.upload.AbstractUploadDatas;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class A
  extends AbstractUploadDatas
{
  private y d = null;
  private byte e = -1;
  
  public A(Context paramContext, y paramy, byte paramByte)
  {
    super(paramContext, 1111, 520);
    this.d = paramy;
    this.e = paramByte;
  }
  
  public static S a(Context paramContext, y paramy, byte paramByte)
  {
    if ((paramy == null) || (paramContext == null)) {
      return null;
    }
    paramContext = c.a(paramContext);
    String str1 = paramContext.E();
    Object localObject1 = paramy.a(str1);
    if ((localObject1 == null) || (localObject1.length <= 0)) {
      return null;
    }
    paramy.a((q[])localObject1);
    paramy = new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    if (i < j)
    {
      Object localObject2 = localObject1[i];
      R localR = new R();
      localR.a = localObject2.a();
      localR.d = localObject2.c();
      localR.c = localObject2.e();
      switch (localObject2.b())
      {
      default: 
        e.c("rqdp{  unknown app state :%d ,drop it}", new Object[] { Integer.valueOf(localObject2.b()) });
      }
      for (;;)
      {
        i += 1;
        break;
        localR.b = 1;
        Iterator localIterator;
        String str2;
        for (;;)
        {
          localR.e = new HashMap();
          if (paramContext.F() >= 0) {
            localR.e.put("C01", paramContext.F());
          }
          if (paramContext.G() >= 0) {
            localR.e.put("C02", paramContext.G());
          }
          if (paramContext.I() <= 0) {
            break;
          }
          localIterator = paramContext.J().iterator();
          while (localIterator.hasNext())
          {
            str2 = (String)localIterator.next();
            localR.e.put("C03_" + str2, paramContext.k(str2));
          }
          localR.b = 2;
          continue;
          localR.b = 3;
          continue;
          localR.b = 4;
        }
        if (paramContext.L() > 0)
        {
          localIterator = paramContext.M().iterator();
          while (localIterator.hasNext())
          {
            str2 = (String)localIterator.next();
            localR.e.put("C04_" + str2, paramContext.l(str2));
          }
        }
        paramy.add(localR);
        e.b("rqdp{  loc st :%s , uid:%s ,  tm:%d , st:%d }", new Object[] { localObject2.c(), localObject2.e(), Long.valueOf(localObject2.a()), Integer.valueOf(localObject2.b()) });
      }
    }
    if (paramy.size() > 0)
    {
      localObject1 = new S();
      ((S)localObject1).b = str1;
      ((S)localObject1).d = paramy;
      ((S)localObject1).a = paramByte;
      ((S)localObject1).c = paramContext.h();
      ((S)localObject1).e = new HashMap();
      ((S)localObject1).e.put("A7", paramContext.d());
      ((S)localObject1).e.put("A6", paramContext.w());
      ((S)localObject1).e.put("A5", paramContext.v());
      ((S)localObject1).e.put("A2", paramContext.t());
      ((S)localObject1).e.put("A1", paramContext.t());
      ((S)localObject1).e.put("A24", paramContext.f());
      ((S)localObject1).e.put("A17", paramContext.u());
      ((S)localObject1).e.put("A15", paramContext.z());
      ((S)localObject1).e.put("A13", paramContext.C());
      ((S)localObject1).e.put("A3", paramContext.o());
      ((S)localObject1).e.put("A22", paramContext.h());
      return localObject1;
    }
    return null;
  }
  
  private N e()
  {
    localObject3 = null;
    for (;;)
    {
      try
      {
        localObject1 = a(this.c, this.d, this.e);
        if (localObject1 != null) {
          continue;
        }
        localObject1 = localObject3;
      }
      catch (Throwable localThrowable)
      {
        Object localObject1 = localObject3;
        if (e.a(localThrowable)) {
          continue;
        }
        localThrowable.printStackTrace();
        localObject1 = localObject3;
        continue;
      }
      finally {}
      return localObject1;
      localObject1 = a(this.c, this.a, ((S)localObject1).a());
    }
  }
  
  public final N a()
  {
    try
    {
      N localN = e();
      return localN;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void done(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.A
 * JD-Core Version:    0.7.0.1
 */