package com.tencent.token;

import android.app.Activity;
import com.tencent.turingfd.sdk.qps.Grape;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class aer
{
  public static List<acd> a = new ArrayList();
  public static acg b;
  public static Set<String> c = new HashSet();
  public static final acd d = new a();
  public static acg e = new b();
  
  public final class a
    implements acd
  {
    public final void a(String paramString, int paramInt1, int paramInt2, Grape paramGrape)
    {
      Iterator localIterator = aer.a.iterator();
      while (localIterator.hasNext())
      {
        acd localacd = (acd)localIterator.next();
        if (localacd != null) {
          localacd.a(paramString, paramInt1, paramInt2, paramGrape);
        }
      }
    }
  }
  
  public final class b
    implements acg
  {
    public final void a(Activity paramActivity)
    {
      Object localObject1 = aer.b;
      if (localObject1 != null) {
        ((acg)localObject1).a(paramActivity);
      }
      int i;
      if (aer.c.contains(paramActivity.getClass().getName())) {
        i = 100;
      } else {
        i = 999;
      }
      localObject1 = (aca)aca.a.b();
      paramActivity.getApplicationContext();
      paramActivity = paramActivity.getClass().getName();
      ((aca)localObject1).d = aer.d;
      Object localObject2;
      if (((aca)localObject1).b.get(paramActivity) == null)
      {
        localObject2 = new aca.b((aca)localObject1, paramActivity, i);
        ((aca)localObject1).b.put(paramActivity, localObject2);
        ach.c.add(localObject2);
      }
      if (((aca)localObject1).c.get(paramActivity) == null)
      {
        localObject2 = new aca.c((aca)localObject1, i);
        ((aca)localObject1).c.put(paramActivity, localObject2);
        ach.d.add(localObject2);
      }
    }
    
    public final void b(Activity paramActivity)
    {
      aca localaca = (aca)aca.a.b();
      paramActivity.getApplicationContext();
      paramActivity = paramActivity.getClass().getName();
      Object localObject = (aca.b)localaca.b.get(paramActivity);
      ach.c.remove(localObject);
      localaca.b.remove(paramActivity);
      localObject = (aca.c)localaca.c.get(paramActivity);
      ach.d.remove(localObject);
      localaca.c.remove(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aer
 * JD-Core Version:    0.7.0.1
 */