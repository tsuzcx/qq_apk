package com.tencent.halley.downloader.c;

import android.text.TextUtils;
import com.tencent.halley.common.b;
import com.tencent.token.ab;
import com.tencent.token.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  public long a = -1L;
  public volatile long b = 0L;
  volatile long c = 0L;
  volatile long d = 0L;
  public boolean e;
  private long f = 0L;
  private String g = "";
  private String h = "";
  private List i;
  
  public d(String paramString)
  {
    int j = 0;
    this.e = false;
    this.i = new LinkedList();
    this.e = false;
    if (!TextUtils.isEmpty(paramString)) {}
    label260:
    try
    {
      paramString = paramString.split("\\|");
      if (paramString != null)
      {
        if (paramString.length == 0) {
          return;
        }
        if (!paramString[0].equals("3.0")) {
          return;
        }
        if (paramString.length < 7) {
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
          while (j < k)
          {
            ab localab = new ab(this, arrayOfString[j]);
            if (localab.a)
            {
              this.i.add(localab);
              j += 1;
            }
            else
            {
              this.i.clear();
              return;
            }
          }
          if (paramString.length != 9) {
            break label260;
          }
          a(paramString[7]);
          b(paramString[8]);
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
          b.a("TaskDivider", "parseLong for totalLen fail.", paramString);
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception paramString) {}
    this.f = h();
    this.e = true;
    return;
  }
  
  private long h()
  {
    synchronized (this.i)
    {
      Iterator localIterator = this.i.iterator();
      ab localab;
      for (long l = 0L; localIterator.hasNext(); l += localab.e - localab.d) {
        localab = (ab)localIterator.next();
      }
      return l;
    }
  }
  
  public final ab a()
  {
    label238:
    label244:
    label250:
    for (;;)
    {
      synchronized (this.i)
      {
        ab localab1;
        if (this.i.size() == 0)
        {
          localab1 = new ab(this, 0L, 0L, 0L, -1L);
        }
        else
        {
          ab localab2 = (ab)this.i.get(0);
          Iterator localIterator = this.i.iterator();
          if (!localIterator.hasNext()) {
            break label238;
          }
          localab1 = (ab)localIterator.next();
          if ((localab1.h) || (localab1.a(this.a) <= 0L))
          {
            if (localab1.a(this.a) <= localab2.a(this.a)) {
              continue;
            }
            localab2 = localab1;
            continue;
          }
          if (localab1 != null) {
            break label250;
          }
          long l1 = localab2.a(this.a);
          long l2 = localab2.f;
          if (l1 <= k.e() << 1) {
            break label244;
          }
          l1 = l2 + l1 / 2L;
          localab1 = new ab(this, l1, l1, l1, localab2.g);
          localab1.c = localab2.b;
        }
        if (localab1 != null) {
          localab1.h = true;
        }
        return localab1;
      }
      Object localObject2 = null;
      continue;
      localObject2 = null;
    }
  }
  
  public final ab a(int paramInt)
  {
    synchronized (this.i)
    {
      try
      {
        ab localab = (ab)this.i.get(paramInt);
        if (localab != null) {
          return localab;
        }
      }
      catch (Exception localException)
      {
        b.a("TaskDivider", localException);
        ??? = new StringBuilder("getSection fail. sectionId:");
        ((StringBuilder)???).append(paramInt);
        ((StringBuilder)???).append(", divider:");
        ((StringBuilder)???).append(b());
        b.d("TaskDivider", ((StringBuilder)???).toString());
        return null;
      }
      throw localException;
    }
  }
  
  public final void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("null"))) {}
    for (paramString = paramString.replace("|", "");; paramString = "")
    {
      this.g = paramString;
      return;
    }
  }
  
  public final boolean a(ab paramab)
  {
    if (paramab.b == -1) {}
    for (;;)
    {
      ab localab;
      synchronized (this.i)
      {
        if (paramab.c == -1)
        {
          if (this.i.size() != 0)
          {
            b.c("TaskDivider", "first section, list size should be 0!!!");
          }
          else
          {
            paramab.b = 0;
            paramab.g = this.a;
            this.i.add(paramab);
            return true;
          }
        }
        else
        {
          if (paramab.c < this.i.size()) {
            continue;
          }
          localObject = new StringBuilder("parent id:");
          ((StringBuilder)localObject).append(paramab.c);
          ((StringBuilder)localObject).append(" wrong!!!");
          b.d("TaskDivider", ((StringBuilder)localObject).toString());
        }
        return false;
        localObject = null;
        Iterator localIterator = this.i.iterator();
        if (localIterator.hasNext())
        {
          localab = (ab)localIterator.next();
          if (localab.b == paramab.c)
          {
            if (localab.f >= localab.g) {
              return false;
            }
            if (localab.f + k.e() <= paramab.d) {
              break label334;
            }
            return false;
          }
          if ((localab.g <= paramab.d) || (localab.d >= paramab.g)) {
            continue;
          }
          return false;
        }
        if (localObject == null) {
          return false;
        }
        paramab.b = this.i.size();
        ((ab)localObject).g = paramab.d;
        this.i.add(paramab);
        return true;
      }
      Object localObject = new StringBuilder("addRealSection of id ");
      ((StringBuilder)localObject).append(paramab.b);
      ((StringBuilder)localObject).append(" should not happen!!!");
      b.d("TaskDivider", ((StringBuilder)localObject).toString());
      return false;
      label334:
      localObject = localab;
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
      while (localIterator.hasNext())
      {
        localStringBuilder.append(((ab)localIterator.next()).a());
        localStringBuilder.append(";");
      }
      if (this.i.size() > 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      localStringBuilder.append("|");
      localStringBuilder.append("null");
      localStringBuilder.append("|");
      if (TextUtils.isEmpty(this.g)) {
        ??? = "null";
      } else {
        ??? = this.g;
      }
      localStringBuilder.append((String)???);
      localStringBuilder.append("|");
      if (TextUtils.isEmpty(this.h)) {
        ??? = "null";
      } else {
        ??? = this.h;
      }
      localStringBuilder.append((String)???);
      return localStringBuilder.toString();
    }
  }
  
  public final void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("null"))) {}
    for (paramString = paramString.replace("|", "");; paramString = "")
    {
      this.h = paramString;
      return;
    }
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
    long l = this.a;
    return (l > 0L) && (l == h());
  }
  
  public final long f()
  {
    synchronized (this.i)
    {
      Iterator localIterator = this.i.iterator();
      ab localab;
      for (long l = 0L; localIterator.hasNext(); l += localab.f - localab.d) {
        localab = (ab)localIterator.next();
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
 * Qualified Name:     com.tencent.halley.downloader.c.d
 * JD-Core Version:    0.7.0.1
 */