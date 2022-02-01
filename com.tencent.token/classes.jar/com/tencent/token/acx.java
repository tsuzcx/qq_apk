package com.tencent.token;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.tencent.turingfd.sdk.base.Lemon;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class acx
{
  public static abr a;
  public static abt b;
  public static Set<String> c = new HashSet();
  public static final abr d = new b();
  public static abt e = new a();
  
  public static void a()
  {
    abu.f = true;
  }
  
  public static void a(Activity paramActivity)
  {
    c.add(paramActivity.getClass().getName());
    abu.g.add(paramActivity.getClass().getName());
  }
  
  public static void a(Context paramContext, abr paramabr, abt paramabt)
  {
    try
    {
      a = paramabr;
      b = paramabt;
      paramContext = paramContext.getApplicationContext();
      abu.e = e;
      if (!abu.a)
      {
        abu.a = true;
        abu.a();
        abu.a((Application)paramContext);
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
    implements abt
  {
    public final void a(Activity paramActivity)
    {
      Object localObject1 = acx.b;
      if (localObject1 != null) {
        ((abt)localObject1).a(paramActivity);
      }
      int i;
      if (acx.c.contains(paramActivity.getClass().getName())) {
        i = 100;
      } else {
        i = 999;
      }
      localObject1 = (abo)abo.a.b();
      Object localObject2 = acx.d;
      paramActivity.getApplicationContext();
      ((abo)localObject1).d = ((abr)localObject2);
      localObject2 = paramActivity.getClass().getName();
      paramActivity = new abo.d((abo)localObject1, paramActivity.getClass().getName(), i);
      ((abo)localObject1).b.put(localObject2, paramActivity);
      abu.c.add(paramActivity);
      paramActivity = new abo.b((abo)localObject1, i);
      ((abo)localObject1).c.put(localObject2, paramActivity);
      abu.d.add(paramActivity);
    }
    
    public final void b(Activity paramActivity)
    {
      abo localabo = (abo)abo.a.b();
      paramActivity = paramActivity.getClass().getName();
      Object localObject = (abo.d)localabo.b.get(paramActivity);
      abu.c.remove(localObject);
      localabo.b.remove(paramActivity);
      localObject = (abo.b)localabo.c.get(paramActivity);
      abu.d.remove(localObject);
      localabo.c.remove(paramActivity);
    }
  }
  
  public static final class b
    implements abr
  {
    public final void a(String paramString, int paramInt1, int paramInt2, Lemon paramLemon)
    {
      abr localabr = acx.a;
      if (localabr != null) {
        localabr.a(paramString, paramInt1, paramInt2, paramLemon);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acx
 * JD-Core Version:    0.7.0.1
 */