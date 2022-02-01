package com.tencent.token;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class nd
{
  public long a = -1L;
  public volatile long b = 0L;
  volatile long c = 0L;
  volatile long d = 0L;
  String e = "";
  public boolean f;
  private long g = 0L;
  private String h = "";
  private List i;
  
  public nd(String paramString)
  {
    int j = 0;
    this.f = false;
    this.i = new LinkedList();
    this.f = false;
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
            mx localmx = new mx(this, arrayOfString[j]);
            if (localmx.b)
            {
              this.i.add(localmx);
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
          mc.a("TaskDivider", "parseLong for totalLen fail.", paramString);
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception paramString) {}
    this.g = c();
    this.f = true;
    return;
  }
  
  public final mx a()
  {
    label238:
    label244:
    label250:
    for (;;)
    {
      synchronized (this.i)
      {
        mx localmx1;
        if (this.i.size() == 0)
        {
          localmx1 = new mx(this, 0L, 0L, 0L, -1L);
        }
        else
        {
          mx localmx2 = (mx)this.i.get(0);
          Iterator localIterator = this.i.iterator();
          if (!localIterator.hasNext()) {
            break label238;
          }
          localmx1 = (mx)localIterator.next();
          if ((localmx1.i) || (localmx1.a(this.a) <= 0L))
          {
            if (localmx1.a(this.a) <= localmx2.a(this.a)) {
              continue;
            }
            localmx2 = localmx1;
            continue;
          }
          if (localmx1 != null) {
            break label250;
          }
          long l1 = localmx2.a(this.a);
          long l2 = localmx2.g;
          if (l1 <= ls.e() << 1) {
            break label244;
          }
          l1 = l2 + l1 / 2L;
          localmx1 = new mx(this, l1, l1, l1, localmx2.h);
          localmx1.d = localmx2.c;
        }
        if (localmx1 != null) {
          localmx1.i = true;
        }
        return localmx1;
      }
      Object localObject2 = null;
      continue;
      localObject2 = null;
    }
  }
  
  public final mx a(int paramInt)
  {
    synchronized (this.i)
    {
      try
      {
        mx localmx = (mx)this.i.get(paramInt);
        if (localmx != null) {
          return localmx;
        }
      }
      catch (Exception localException)
      {
        mc.a("TaskDivider", localException);
        ??? = new StringBuilder("getSection fail. sectionId:");
        ((StringBuilder)???).append(paramInt);
        ((StringBuilder)???).append(", divider:");
        ((StringBuilder)???).append(b());
        mc.d("TaskDivider", ((StringBuilder)???).toString());
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
      this.h = paramString;
      return;
    }
  }
  
  public final boolean a(mx parammx)
  {
    if (parammx.c == -1) {}
    for (;;)
    {
      mx localmx;
      synchronized (this.i)
      {
        if (parammx.d == -1)
        {
          if (this.i.size() != 0)
          {
            mc.c("TaskDivider", "first section, list size should be 0!!!");
          }
          else
          {
            parammx.c = 0;
            parammx.h = this.a;
            this.i.add(parammx);
            return true;
          }
        }
        else
        {
          if (parammx.d < this.i.size()) {
            continue;
          }
          localObject = new StringBuilder("parent id:");
          ((StringBuilder)localObject).append(parammx.d);
          ((StringBuilder)localObject).append(" wrong!!!");
          mc.d("TaskDivider", ((StringBuilder)localObject).toString());
        }
        return false;
        localObject = null;
        Iterator localIterator = this.i.iterator();
        if (localIterator.hasNext())
        {
          localmx = (mx)localIterator.next();
          if (localmx.c == parammx.d)
          {
            if (localmx.g >= localmx.h) {
              return false;
            }
            if (localmx.g + ls.e() <= parammx.e) {
              break label334;
            }
            return false;
          }
          if ((localmx.h <= parammx.e) || (localmx.e >= parammx.h)) {
            continue;
          }
          return false;
        }
        if (localObject == null) {
          return false;
        }
        parammx.c = this.i.size();
        ((mx)localObject).h = parammx.e;
        this.i.add(parammx);
        return true;
      }
      Object localObject = new StringBuilder("addRealSection of id ");
      ((StringBuilder)localObject).append(parammx.c);
      ((StringBuilder)localObject).append(" should not happen!!!");
      mc.d("TaskDivider", ((StringBuilder)localObject).toString());
      return false;
      label334:
      localObject = localmx;
    }
  }
  
  public final String b()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("3.0");
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.a);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.b);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.c);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.d);
    localStringBuilder1.append("|");
    synchronized (this.i)
    {
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        mx localmx = (mx)localIterator.next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(localmx.c);
        localStringBuilder2.append(mx.a);
        localStringBuilder2.append(localmx.d);
        localStringBuilder2.append(mx.a);
        localStringBuilder2.append(localmx.e);
        localStringBuilder2.append(mx.a);
        localStringBuilder2.append(localmx.f);
        localStringBuilder2.append(mx.a);
        localStringBuilder2.append(localmx.h);
        localStringBuilder1.append(localStringBuilder2.toString());
        localStringBuilder1.append(";");
      }
      if (this.i.size() > 0) {
        localStringBuilder1.deleteCharAt(localStringBuilder1.length() - 1);
      }
      localStringBuilder1.append("|");
      localStringBuilder1.append("null");
      localStringBuilder1.append("|");
      if (TextUtils.isEmpty(this.h)) {
        ??? = "null";
      } else {
        ??? = this.h;
      }
      localStringBuilder1.append((String)???);
      localStringBuilder1.append("|");
      if (TextUtils.isEmpty(this.e)) {
        ??? = "null";
      } else {
        ??? = this.e;
      }
      localStringBuilder1.append((String)???);
      return localStringBuilder1.toString();
    }
  }
  
  public final void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("null"))) {}
    for (paramString = paramString.replace("|", "");; paramString = "")
    {
      this.e = paramString;
      return;
    }
  }
  
  final long c()
  {
    synchronized (this.i)
    {
      Iterator localIterator = this.i.iterator();
      mx localmx;
      for (long l = 0L; localIterator.hasNext(); l += localmx.f - localmx.e) {
        localmx = (mx)localIterator.next();
      }
      return l;
    }
  }
  
  public final long d()
  {
    synchronized (this.i)
    {
      Iterator localIterator = this.i.iterator();
      mx localmx;
      for (long l = 0L; localIterator.hasNext(); l += localmx.g - localmx.e) {
        localmx = (mx)localIterator.next();
      }
      return l;
    }
  }
  
  public final long e()
  {
    return c() - this.g;
  }
  
  public final String toString()
  {
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.nd
 * JD-Core Version:    0.7.0.1
 */