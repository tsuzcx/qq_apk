package com.tencent.halley.downloader.c;

import android.text.TextUtils;
import com.tencent.halley.common.b;
import com.tencent.token.ac;
import com.tencent.token.l;
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
            ac localac = new ac(this, arrayOfString[j]);
            if (localac.a)
            {
              this.i.add(localac);
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
      ac localac;
      for (long l = 0L; localIterator.hasNext(); l += localac.e - localac.d) {
        localac = (ac)localIterator.next();
      }
      return l;
    }
  }
  
  public final ac a()
  {
    label238:
    label244:
    label250:
    for (;;)
    {
      synchronized (this.i)
      {
        ac localac1;
        if (this.i.size() == 0)
        {
          localac1 = new ac(this, 0L, 0L, 0L, -1L);
        }
        else
        {
          ac localac2 = (ac)this.i.get(0);
          Iterator localIterator = this.i.iterator();
          if (!localIterator.hasNext()) {
            break label238;
          }
          localac1 = (ac)localIterator.next();
          if ((localac1.h) || (localac1.a(this.a) <= 0L))
          {
            if (localac1.a(this.a) <= localac2.a(this.a)) {
              continue;
            }
            localac2 = localac1;
            continue;
          }
          if (localac1 != null) {
            break label250;
          }
          long l1 = localac2.a(this.a);
          long l2 = localac2.f;
          if (l1 <= l.e() << 1) {
            break label244;
          }
          l1 = l2 + l1 / 2L;
          localac1 = new ac(this, l1, l1, l1, localac2.g);
          localac1.c = localac2.b;
        }
        if (localac1 != null) {
          localac1.h = true;
        }
        return localac1;
      }
      Object localObject2 = null;
      continue;
      localObject2 = null;
    }
  }
  
  public final ac a(int paramInt)
  {
    synchronized (this.i)
    {
      try
      {
        ac localac = (ac)this.i.get(paramInt);
        if (localac != null) {
          return localac;
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
  
  public final boolean a(ac paramac)
  {
    if (paramac.b == -1) {}
    for (;;)
    {
      ac localac;
      synchronized (this.i)
      {
        if (paramac.c == -1)
        {
          if (this.i.size() != 0)
          {
            b.c("TaskDivider", "first section, list size should be 0!!!");
          }
          else
          {
            paramac.b = 0;
            paramac.g = this.a;
            this.i.add(paramac);
            return true;
          }
        }
        else
        {
          if (paramac.c < this.i.size()) {
            continue;
          }
          localObject = new StringBuilder("parent id:");
          ((StringBuilder)localObject).append(paramac.c);
          ((StringBuilder)localObject).append(" wrong!!!");
          b.d("TaskDivider", ((StringBuilder)localObject).toString());
        }
        return false;
        localObject = null;
        Iterator localIterator = this.i.iterator();
        if (localIterator.hasNext())
        {
          localac = (ac)localIterator.next();
          if (localac.b == paramac.c)
          {
            if (localac.f >= localac.g) {
              return false;
            }
            if (localac.f + l.e() <= paramac.d) {
              break label334;
            }
            return false;
          }
          if ((localac.g <= paramac.d) || (localac.d >= paramac.g)) {
            continue;
          }
          return false;
        }
        if (localObject == null) {
          return false;
        }
        paramac.b = this.i.size();
        ((ac)localObject).g = paramac.d;
        this.i.add(paramac);
        return true;
      }
      Object localObject = new StringBuilder("addRealSection of id ");
      ((StringBuilder)localObject).append(paramac.b);
      ((StringBuilder)localObject).append(" should not happen!!!");
      b.d("TaskDivider", ((StringBuilder)localObject).toString());
      return false;
      label334:
      localObject = localac;
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
        localStringBuilder.append(((ac)localIterator.next()).a());
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
      ac localac;
      for (long l = 0L; localIterator.hasNext(); l += localac.f - localac.d) {
        localac = (ac)localIterator.next();
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