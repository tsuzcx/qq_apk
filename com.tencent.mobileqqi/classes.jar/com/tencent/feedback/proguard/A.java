package com.tencent.feedback.proguard;

import android.content.Context;
import com.tencent.feedback.common.d;
import com.tencent.feedback.common.e;
import com.tencent.feedback.upload.AbstractUploadDatas;
import java.util.ArrayList;

public final class A
  extends AbstractUploadDatas
{
  private y d = null;
  private byte e = -1;
  
  public A(Context paramContext, y paramy, byte paramByte)
  {
    super(paramContext, 1111, 110);
    this.d = paramy;
    this.e = paramByte;
  }
  
  public static Z a(Context paramContext, y paramy, byte paramByte)
  {
    if ((paramy == null) || (paramContext == null)) {
      return null;
    }
    String str1 = com.tencent.feedback.common.a.h(paramContext);
    Object localObject1 = paramy.a(str1);
    if ((localObject1 == null) || (localObject1.length <= 0)) {
      return null;
    }
    paramy.a((q[])localObject1);
    d.a(paramContext);
    paramy = d.b(paramContext);
    String str2 = d.d(paramContext);
    str2 = a.a(d.m() + paramy + str2);
    paramContext = d.e(paramContext);
    ArrayList localArrayList = new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      byte b;
      switch (localObject2.b())
      {
      default: 
        e.c("rqdp{  unknown app state :%d ,drop it}", new Object[] { Integer.valueOf(localObject2.b()) });
        i += 1;
        break;
      case 1: 
        b = 1;
      case 2: 
      case 3: 
        for (;;)
        {
          Y localY = new Y(localObject2.a(), b, localObject2.e(), localObject2.c());
          e.b("rqdp{  loc st :%s , uid:%s ,  tm:%d , st:%d }", new Object[] { localObject2.c(), localObject2.e(), Long.valueOf(localObject2.a()), Byte.valueOf(b) });
          localArrayList.add(localY);
          break;
          b = 2;
          continue;
          b = 3;
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      localObject1 = new Z();
      ((Z)localObject1).a = str2;
      ((Z)localObject1).c = paramy;
      ((Z)localObject1).d = paramContext;
      ((Z)localObject1).b = str1;
      ((Z)localObject1).f = localArrayList;
      ((Z)localObject1).e = paramByte;
      return localObject1;
    }
    return null;
  }
  
  private C e()
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localObject3 = a(this.c, this.d, this.e);
        if (localObject3 != null) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject3;
        localThrowable.printStackTrace();
        continue;
      }
      finally {}
      return localObject1;
      e.b("rqdp{   guid =} %s rqdp{ procName=} %s rqdp{ imei=}%s rqdp{ mac=}%s", new Object[] { ((Z)localObject3).a, ((Z)localObject3).b, ((Z)localObject3).c, ((Z)localObject3).d });
      localObject3 = a(this.c, this.a, ((Z)localObject3).a());
      localObject1 = localObject3;
    }
  }
  
  public final C a()
  {
    try
    {
      C localC = e();
      return localC;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void done(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.A
 * JD-Core Version:    0.7.0.1
 */