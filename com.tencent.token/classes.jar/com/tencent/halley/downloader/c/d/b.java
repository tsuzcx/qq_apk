package com.tencent.halley.downloader.c.d;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  public a a;
  private boolean b = false;
  private a c;
  private Map d = new ConcurrentHashMap();
  private AtomicInteger e = new AtomicInteger(0);
  
  public b(String paramString, boolean paramBoolean)
  {
    this.b = paramBoolean;
    if (paramBoolean) {}
    for (a.a locala = a.a.b;; locala = a.a.a)
    {
      this.a = new a(paramString, locala);
      this.a.a(this.e.getAndIncrement());
      return;
    }
  }
  
  private c d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    synchronized (this.d)
    {
      c localc2 = (c)this.d.get(paramString);
      c localc1 = localc2;
      if (localc2 == null)
      {
        localc1 = new c(this, paramString);
        this.d.put(paramString, localc1);
      }
      return localc1;
    }
  }
  
  public final a a(String paramString, a parama)
  {
    Object localObject;
    if (parama.b != a.a.b)
    {
      localObject = parama;
      if (parama.b != a.a.a) {}
    }
    else
    {
      paramString = d(paramString);
      localObject = parama;
      if (paramString != null)
      {
        paramString = paramString.a(a.a.d);
        localObject = parama;
        if (paramString != null) {
          localObject = paramString;
        }
      }
    }
    return localObject;
  }
  
  public final a a(String paramString, a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    a.a locala = null;
    Object localObject2 = null;
    Object localObject1;
    if (parama != null)
    {
      locala = parama.b;
      localObject1 = localObject2;
      if (!paramBoolean2)
      {
        localObject1 = localObject2;
        if (a.b(parama.b))
        {
          c localc = (c)this.d.get(paramString);
          localObject1 = localObject2;
          if (localc != null)
          {
            parama = localc.a(parama);
            localObject1 = parama;
            if (parama != null) {
              return parama;
            }
          }
        }
      }
      localObject2 = locala;
      parama = (a)localObject1;
      localObject1 = localObject2;
    }
    for (;;)
    {
      int i = a.a.a().length;
      if ((parama == null) && (i > 0))
      {
        localObject1 = a.a((a.a)localObject1, paramBoolean1);
        if (a.a((a.a)localObject1))
        {
          localObject2 = (c)this.d.get(paramString);
          if (localObject2 == null) {
            break label195;
          }
          parama = ((c)localObject2).a((a.a)localObject1);
        }
      }
      label195:
      for (;;)
      {
        i -= 1;
        break;
        if (localObject1 == a.a.g)
        {
          parama = this.c;
        }
        else
        {
          parama = this.a;
          continue;
          paramString = parama;
          if (parama == null) {
            paramString = this.a;
          }
          return paramString;
        }
      }
      localObject1 = null;
      parama = locala;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      paramString1 = d(paramString1);
    } while (paramString1 == null);
    paramString1.a(paramString2);
  }
  
  public final void a(String paramString1, String paramString2, a.a parama)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      paramString1 = d(paramString1);
    } while (paramString1 == null);
    paramString1.a(paramString2, parama);
  }
  
  public final boolean a()
  {
    return this.b;
  }
  
  public final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = (c)this.d.get(paramString);
    int i;
    if (paramString != null)
    {
      if (!paramString.b) {
        break label42;
      }
      i = 0;
    }
    while (i != 0)
    {
      return true;
      label42:
      if ((paramString.a != null) && (paramString.a.size() > 0)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    return false;
  }
  
  public final String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a != null) {
      localStringBuilder.append("0,").append(this.a).append(";");
    }
    if (this.c != null) {
      localStringBuilder.append("1,").append(this.c).append(";");
    }
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (c)this.d.get(localObject);
      if (localObject != null) {
        localStringBuilder.append(localObject).append(";");
      }
    }
    return localStringBuilder.toString();
  }
  
  public final void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.c = new a(paramString, a.a.g);
    this.c.a(this.e.getAndIncrement());
  }
  
  public final void b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      paramString1 = d(paramString1);
    } while (paramString1 == null);
    paramString1.b(paramString2);
  }
  
  public final void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = d(paramString);
    } while (paramString == null);
    paramString.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.c.d.b
 * JD-Core Version:    0.7.0.1
 */