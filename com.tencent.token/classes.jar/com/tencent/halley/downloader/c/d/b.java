package com.tencent.halley.downloader.c.d;

import android.text.TextUtils;
import com.tencent.halley.common.h;
import java.util.ArrayList;
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
    a.a locala;
    if (paramBoolean) {
      locala = a.a.b;
    } else {
      locala = a.a.a;
    }
    this.a = new a(paramString, locala);
    this.a.a(this.e.getAndIncrement());
  }
  
  private a d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    synchronized (this.d)
    {
      a locala2 = (a)this.d.get(paramString);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a(paramString);
        this.d.put(paramString, locala1);
      }
      return locala1;
    }
  }
  
  public final a a(String paramString, a parama)
  {
    if ((parama.b == a.a.b) || (parama.b == a.a.a))
    {
      paramString = d(paramString);
      if (paramString != null)
      {
        paramString = paramString.a(a.a.d);
        if (paramString != null) {
          return paramString;
        }
      }
    }
    return parama;
  }
  
  public final a a(String paramString, a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Object localObject1;
    a.a locala1;
    if (parama != null)
    {
      a.a locala2 = parama.b;
      localObject1 = localObject2;
      locala1 = locala2;
      if (!paramBoolean2)
      {
        localObject1 = localObject2;
        locala1 = locala2;
        if (a.b(parama.b))
        {
          a locala = (a)this.d.get(paramString);
          localObject1 = localObject2;
          locala1 = locala2;
          if (locala != null)
          {
            parama = locala.a(parama);
            localObject1 = parama;
            locala1 = locala2;
            if (parama != null) {
              return parama;
            }
          }
        }
      }
    }
    else
    {
      locala1 = null;
      localObject1 = localObject2;
    }
    int i = a.a.a().length;
    while ((localObject1 == null) && (i > 0))
    {
      locala1 = a.a(locala1, paramBoolean1);
      if (a.a(locala1))
      {
        parama = (a)this.d.get(paramString);
        if (parama != null) {
          localObject1 = parama.a(locala1);
        }
      }
      else
      {
        if (locala1 == a.a.g) {
          parama = this.c;
        } else {
          parama = this.a;
        }
        localObject1 = parama;
      }
      i -= 1;
    }
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = this.a;
    }
    return paramString;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      paramString1 = d(paramString1);
      if (paramString1 != null) {
        paramString1.a(paramString2);
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, a.a parama)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      paramString1 = d(paramString1);
      if (paramString1 != null) {
        paramString1.a(paramString2, parama);
      }
    }
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
    paramString = (a)this.d.get(paramString);
    if (paramString != null)
    {
      if (paramString.b) {}
      while ((paramString.a != null) && (paramString.a.size() > 0))
      {
        i = 0;
        break;
      }
      int i = 1;
      return i != 0;
    }
    return true;
  }
  
  public final String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a != null)
    {
      localStringBuilder.append("0,");
      localStringBuilder.append(this.a);
      localStringBuilder.append(";");
    }
    if (this.c != null)
    {
      localStringBuilder.append("1,");
      localStringBuilder.append(this.c);
      localStringBuilder.append(";");
    }
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (a)this.d.get(localObject);
      if (localObject != null)
      {
        localStringBuilder.append(localObject);
        localStringBuilder.append(";");
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
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      paramString1 = d(paramString1);
      if (paramString1 != null) {
        paramString1.b(paramString2);
      }
    }
  }
  
  public final void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = d(paramString);
    if (paramString != null) {
      paramString.b = true;
    }
  }
  
  final class a
  {
    List a;
    boolean b = false;
    private String c;
    private List d;
    private List e;
    private List f;
    private a g;
    private List h;
    private a i;
    
    public a(String paramString)
    {
      this.c = paramString;
    }
    
    private static void a(StringBuilder paramStringBuilder, List paramList)
    {
      if (paramList != null)
      {
        if ((paramStringBuilder != null) && (paramList != null)) {}
        try
        {
          if (paramList.size() > 0)
          {
            Iterator localIterator = paramList.iterator();
            while (localIterator.hasNext())
            {
              a locala = (a)localIterator.next();
              if (locala != null)
              {
                paramStringBuilder.append(locala);
                paramStringBuilder.append(",");
              }
            }
          }
          return;
        }
        finally {}
      }
    }
    
    private List b(a.a parama)
    {
      if (parama == a.a.c) {
        return this.d;
      }
      if (parama == a.a.e) {
        return this.a;
      }
      if (parama == a.a.f) {
        return this.e;
      }
      if (parama == a.a.j) {
        return this.f;
      }
      if (parama == a.a.h) {
        return this.h;
      }
      return null;
    }
    
    public final a a(a.a parama)
    {
      try
      {
        if (parama == a.a.d)
        {
          parama = this.g;
          return parama;
        }
        if (parama == a.a.i)
        {
          parama = this.i;
          return parama;
        }
        if (a.b(parama))
        {
          parama = b(parama);
          if (parama != null)
          {
            parama = (a)parama.get(0);
            return parama;
          }
        }
        return null;
      }
      finally {}
    }
    
    public final a a(a parama)
    {
      if (parama == null) {
        return null;
      }
      try
      {
        List localList = b(parama.b);
        if (localList != null)
        {
          int k = 0;
          while (k < localList.size())
          {
            if (parama == localList.get(k))
            {
              int m = localList.size();
              if (k == m - 1) {
                return null;
              }
              parama = (a)localList.get(k + 1);
              return parama;
            }
            k += 1;
          }
        }
        return null;
      }
      finally {}
    }
    
    public final void a(String paramString)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        if (this.g == null)
        {
          this.g = new a(paramString, a.a.d);
          this.g.a(b.a(b.this).getAndIncrement());
          return;
        }
        this.g.a = paramString;
        return;
      }
      finally {}
    }
    
    public final void a(String paramString, a.a parama)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        List localList;
        if (parama == a.a.c)
        {
          if (this.d == null) {
            this.d = new ArrayList();
          }
          localList = this.d;
        }
        else if (parama == a.a.e)
        {
          if (this.a == null) {
            this.a = new ArrayList();
          }
          localList = this.a;
        }
        else if (parama == a.a.f)
        {
          if (this.e == null) {
            this.e = new ArrayList();
          }
          localList = this.e;
        }
        else if (parama == a.a.j)
        {
          if (this.f == null) {
            this.f = new ArrayList();
          }
          localList = this.f;
        }
        else
        {
          if (parama != a.a.h) {
            break label261;
          }
          if (this.h == null) {
            this.h = new ArrayList();
          }
          localList = this.h;
        }
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          bool = paramString.equalsIgnoreCase(((a)localIterator.next()).a);
          if (bool) {
            return;
          }
        }
        paramString = new a(paramString, parama);
        paramString.a(b.a(b.this).getAndIncrement());
        localList.add(paramString);
        return;
        label261:
        return;
      }
      finally {}
    }
    
    public final void b(String paramString)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        if (this.i == null)
        {
          this.i = new a(paramString, a.a.i);
          this.i.a(b.a(b.this).getAndIncrement());
          return;
        }
        this.i.a = paramString;
        return;
      }
      finally {}
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(h.b(this.c));
      localStringBuilder.append(",");
      a(localStringBuilder, this.d);
      a(localStringBuilder, this.a);
      a(localStringBuilder, this.e);
      a(localStringBuilder, this.f);
      a locala = this.g;
      if (locala != null)
      {
        localStringBuilder.append(locala);
        localStringBuilder.append(",");
      }
      a(localStringBuilder, this.h);
      locala = this.i;
      if (locala != null) {
        localStringBuilder.append(locala);
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.c.d.b
 * JD-Core Version:    0.7.0.1
 */