package com.tencent.token;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.tencent.turingfd.sdk.base.Lemon;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class acy
{
  public static abs a;
  public static abu b;
  public static Set<String> c = new HashSet();
  public static final abs d = new b();
  public static abu e = new a();
  
  public static void a()
  {
    abv.f = true;
  }
  
  public static void a(Activity paramActivity)
  {
    c.add(paramActivity.getClass().getName());
    abv.g.add(paramActivity.getClass().getName());
  }
  
  public static void a(Context paramContext, abs paramabs, abu paramabu)
  {
    try
    {
      a = paramabs;
      b = paramabu;
      paramContext = paramContext.getApplicationContext();
      abv.e = e;
      if (!abv.a)
      {
        abv.a = true;
        abv.a();
        abv.a((Application)paramContext);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static final class a
    implements abu
  {
    public final void a(Activity paramActivity)
    {
      Object localObject1 = acy.b;
      if (localObject1 != null) {
        ((abu)localObject1).a(paramActivity);
      }
      int i;
      if (acy.c.contains(paramActivity.getClass().getName())) {
        i = 100;
      } else {
        i = 999;
      }
      localObject1 = (abp)abp.a.b();
      Object localObject2 = acy.d;
      paramActivity.getApplicationContext();
      ((abp)localObject1).d = ((abs)localObject2);
      localObject2 = paramActivity.getClass().getName();
      paramActivity = new abp.d((abp)localObject1, paramActivity.getClass().getName(), i);
      ((abp)localObject1).b.put(localObject2, paramActivity);
      abv.c.add(paramActivity);
      paramActivity = new abp.b((abp)localObject1, i);
      ((abp)localObject1).c.put(localObject2, paramActivity);
      abv.d.add(paramActivity);
    }
    
    public final void b(Activity paramActivity)
    {
      abp localabp = (abp)abp.a.b();
      paramActivity = paramActivity.getClass().getName();
      Object localObject = (abp.d)localabp.b.get(paramActivity);
      abv.c.remove(localObject);
      localabp.b.remove(paramActivity);
      localObject = (abp.b)localabp.c.get(paramActivity);
      abv.d.remove(localObject);
      localabp.c.remove(paramActivity);
    }
  }
  
  public static final class b
    implements abs
  {
    public final void a(String paramString, int paramInt1, int paramInt2, Lemon paramLemon)
    {
      abs localabs = acy.a;
      if (localabs != null) {
        localabs.a(paramString, paramInt1, paramInt2, paramLemon);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acy
 * JD-Core Version:    0.7.0.1
 */