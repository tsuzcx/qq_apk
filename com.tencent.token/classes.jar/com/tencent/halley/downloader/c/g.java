package com.tencent.halley.downloader.c;

import android.text.TextUtils;
import com.tencent.halley.common.c;
import com.tencent.token.ad;
import com.tencent.token.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
{
  public long a = -1L;
  public volatile long b = 0L;
  volatile long c = 0L;
  volatile long d = 0L;
  public boolean e = false;
  private long f = 0L;
  private String g = "";
  private String h = "";
  private List i = new LinkedList();
  
  public g(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    label232:
    try
    {
      paramString = paramString.split("\\|");
      if ((paramString == null) || (paramString.length == 0)) {}
      while ((!paramString[0].equals("3.0")) || (paramString.length < 7)) {
        return;
      }
      try
      {
        this.a = Long.parseLong(paramString[1]);
        this.b = Long.parseLong(paramString[2]);
        this.c = Long.parseLong(paramString[3]);
        this.d = Long.parseLong(paramString[4]);
        String[] arrayOfString = paramString[5].split(";");
        int k = arrayOfString.length;
        for (;;)
        {
          if (j >= k) {
            break label232;
          }
          ad localad = new ad(this, arrayOfString[j]);
          if (!localad.a) {
            break;
          }
          this.i.add(localad);
          j += 1;
        }
        this.i.clear();
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
        c.a("TaskDivider", "parseLong for totalLen fail.", paramString);
        return;
      }
      return;
    }
    catch (Exception paramString) {}
    if (paramString.length == 9)
    {
      a(paramString[7]);
      b(paramString[8]);
    }
    this.f = h();
    this.e = true;
    return;
  }
  
  private long h()
  {
    synchronized (this.i)
    {
      Iterator localIterator = this.i.iterator();
      ad localad;
      for (long l = 0L; localIterator.hasNext(); l = localad.e - localad.d + l) {
        localad = (ad)localIterator.next();
      }
      return l;
    }
  }
  
  public final ad a()
  {
    for (;;)
    {
      Object localObject4;
      synchronized (this.i)
      {
        if (this.i.size() == 0)
        {
          localObject1 = new ad(this, 0L, 0L, 0L, -1L);
          if (localObject1 != null) {
            ((ad)localObject1).h = true;
          }
          return localObject1;
        }
        localObject4 = (ad)this.i.get(0);
        localObject5 = this.i.iterator();
        label80:
        if (!((Iterator)localObject5).hasNext()) {
          break label257;
        }
        Object localObject1 = (ad)((Iterator)localObject5).next();
        if ((!((ad)localObject1).h) && (((ad)localObject1).a(this.a) > 0L))
        {
          localObject5 = localObject1;
          localObject1 = localObject5;
          if (localObject5 != null) {
            continue;
          }
          l1 = ((ad)localObject4).a(this.a);
          l2 = ((ad)localObject4).f;
          if (l1 <= h.e() << 1) {
            break label244;
          }
          l1 = l2 + l1 / 2L;
          localObject1 = new ad(this, l1, l1, l1, ((ad)localObject4).g);
          ((ad)localObject1).c = ((ad)localObject4).b;
        }
      }
      long l1 = localObject2.a(this.a);
      long l2 = ((ad)localObject4).a(this.a);
      if (l1 > l2) {}
      for (;;)
      {
        localObject4 = localObject2;
        break label80;
        label244:
        Object localObject3 = null;
        break;
        localObject3 = localObject4;
      }
      label257:
      Object localObject5 = null;
    }
  }
  
  public final ad a(int paramInt)
  {
    synchronized (this.i)
    {
      try
      {
        ad localad = (ad)this.i.get(paramInt);
        if (localad != null) {
          return localad;
        }
      }
      catch (Exception localException)
      {
        c.a("TaskDivider", localException);
        c.d("TaskDivider", "getSection fail. sectionId:" + paramInt + ", divider:" + b());
        return null;
      }
    }
  }
  
  public final void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("null")))
    {
      this.g = "";
      return;
    }
    this.g = paramString.replace("|", "");
  }
  
  public final boolean a(ad paramad)
  {
    if (paramad.b == -1) {}
    for (;;)
    {
      synchronized (this.i)
      {
        if (paramad.c == -1)
        {
          if (this.i.size() != 0)
          {
            c.c("TaskDivider", "first section, list size should be 0!!!");
            return false;
          }
          paramad.b = 0;
          paramad.g = this.a;
          this.i.add(paramad);
          return true;
        }
        if (paramad.c >= this.i.size()) {
          c.d("TaskDivider", "parent id:" + paramad.c + " wrong!!!");
        }
      }
      Object localObject = null;
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        ad localad = (ad)localIterator.next();
        if (localad.b == paramad.c)
        {
          if (localad.f >= localad.g) {
            return false;
          }
          localObject = localad;
          if (localad.f + h.e() > paramad.d) {
            return false;
          }
        }
        else if ((localad.g > paramad.d) && (localad.d < paramad.g))
        {
          return false;
        }
      }
      if (localObject == null) {
        return false;
      }
      paramad.b = this.i.size();
      localObject.g = paramad.d;
      this.i.add(paramad);
      return true;
      c.d("TaskDivider", "addRealSection of id " + paramad.b + " should not happen!!!");
    }
  }
  
  public final String b()
  {
    StringBuilder localStringBuilder = new StringBuilder("3.0");
    localStringBuilder.append("|");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append(this.d);
    localStringBuilder.append("|");
    synchronized (this.i)
    {
      Iterator localIterator = this.i.iterator();
      if (localIterator.hasNext())
      {
        localStringBuilder.append(((ad)localIterator.next()).a());
        localStringBuilder.append(";");
      }
    }
    if (this.i.size() > 0) {
      localObject.deleteCharAt(localObject.length() - 1);
    }
    localObject.append("|");
    localObject.append("null");
    localObject.append("|");
    if (TextUtils.isEmpty(this.g))
    {
      localObject.append("null");
      localObject.append("|");
      if (!TextUtils.isEmpty(this.h)) {
        break label243;
      }
      localObject.append("null");
    }
    for (;;)
    {
      return localObject.toString();
      localObject.append(this.g);
      break;
      label243:
      localObject.append(this.h);
    }
  }
  
  public final void b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("null")))
    {
      this.h = "";
      return;
    }
    this.h = paramString.replace("|", "");
  }
  
  public final String c()
  {
    return this.h;
  }
  
  public final long d()
  {
    return h();
  }
  
  public final boolean e()
  {
    return (this.a > 0L) && (this.a == h());
  }
  
  public final long f()
  {
    synchronized (this.i)
    {
      Iterator localIterator = this.i.iterator();
      ad localad;
      for (long l = 0L; localIterator.hasNext(); l = localad.f - localad.d + l) {
        localad = (ad)localIterator.next();
      }
      return l;
    }
  }
  
  public final long g()
  {
    return h() - this.f;
  }
  
  public final String toString()
  {
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.c.g
 * JD-Core Version:    0.7.0.1
 */