package com.tencent.token;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class mp
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
  
  public mp(String paramString)
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
            mj localmj = new mj(this, arrayOfString[j]);
            if (localmj.b)
            {
              this.i.add(localmj);
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
          lo.a("TaskDivider", "parseLong for totalLen fail.", paramString);
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
  
  public final mj a()
  {
    label238:
    label244:
    label250:
    for (;;)
    {
      synchronized (this.i)
      {
        mj localmj1;
        if (this.i.size() == 0)
        {
          localmj1 = new mj(this, 0L, 0L, 0L, -1L);
        }
        else
        {
          mj localmj2 = (mj)this.i.get(0);
          Iterator localIterator = this.i.iterator();
          if (!localIterator.hasNext()) {
            break label238;
          }
          localmj1 = (mj)localIterator.next();
          if ((localmj1.i) || (localmj1.a(this.a) <= 0L))
          {
            if (localmj1.a(this.a) <= localmj2.a(this.a)) {
              continue;
            }
            localmj2 = localmj1;
            continue;
          }
          if (localmj1 != null) {
            break label250;
          }
          long l1 = localmj2.a(this.a);
          long l2 = localmj2.g;
          if (l1 <= le.e() << 1) {
            break label244;
          }
          l1 = l2 + l1 / 2L;
          localmj1 = new mj(this, l1, l1, l1, localmj2.h);
          localmj1.d = localmj2.c;
        }
        if (localmj1 != null) {
          localmj1.i = true;
        }
        return localmj1;
      }
      Object localObject2 = null;
      continue;
      localObject2 = null;
    }
  }
  
  public final mj a(int paramInt)
  {
    synchronized (this.i)
    {
      try
      {
        mj localmj = (mj)this.i.get(paramInt);
        if (localmj != null) {
          return localmj;
        }
      }
      catch (Exception localException)
      {
        lo.a("TaskDivider", localException);
        ??? = new StringBuilder("getSection fail. sectionId:");
        ((StringBuilder)???).append(paramInt);
        ((StringBuilder)???).append(", divider:");
        ((StringBuilder)???).append(b());
        lo.d("TaskDivider", ((StringBuilder)???).toString());
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
  
  public final boolean a(mj parammj)
  {
    if (parammj.c == -1) {}
    for (;;)
    {
      mj localmj;
      synchronized (this.i)
      {
        if (parammj.d == -1)
        {
          if (this.i.size() != 0)
          {
            lo.c("TaskDivider", "first section, list size should be 0!!!");
          }
          else
          {
            parammj.c = 0;
            parammj.h = this.a;
            this.i.add(parammj);
            return true;
          }
        }
        else
        {
          if (parammj.d < this.i.size()) {
            continue;
          }
          localObject = new StringBuilder("parent id:");
          ((StringBuilder)localObject).append(parammj.d);
          ((StringBuilder)localObject).append(" wrong!!!");
          lo.d("TaskDivider", ((StringBuilder)localObject).toString());
        }
        return false;
        localObject = null;
        Iterator localIterator = this.i.iterator();
        if (localIterator.hasNext())
        {
          localmj = (mj)localIterator.next();
          if (localmj.c == parammj.d)
          {
            if (localmj.g >= localmj.h) {
              return false;
            }
            if (localmj.g + le.e() <= parammj.e) {
              break label334;
            }
            return false;
          }
          if ((localmj.h <= parammj.e) || (localmj.e >= parammj.h)) {
            continue;
          }
          return false;
        }
        if (localObject == null) {
          return false;
        }
        parammj.c = this.i.size();
        ((mj)localObject).h = parammj.e;
        this.i.add(parammj);
        return true;
      }
      Object localObject = new StringBuilder("addRealSection of id ");
      ((StringBuilder)localObject).append(parammj.c);
      ((StringBuilder)localObject).append(" should not happen!!!");
      lo.d("TaskDivider", ((StringBuilder)localObject).toString());
      return false;
      label334:
      localObject = localmj;
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
        mj localmj = (mj)localIterator.next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(localmj.c);
        localStringBuilder2.append(mj.a);
        localStringBuilder2.append(localmj.d);
        localStringBuilder2.append(mj.a);
        localStringBuilder2.append(localmj.e);
        localStringBuilder2.append(mj.a);
        localStringBuilder2.append(localmj.f);
        localStringBuilder2.append(mj.a);
        localStringBuilder2.append(localmj.h);
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
      mj localmj;
      for (long l = 0L; localIterator.hasNext(); l += localmj.f - localmj.e) {
        localmj = (mj)localIterator.next();
      }
      return l;
    }
  }
  
  public final long d()
  {
    synchronized (this.i)
    {
      Iterator localIterator = this.i.iterator();
      mj localmj;
      for (long l = 0L; localIterator.hasNext(); l += localmj.g - localmj.e) {
        localmj = (mj)localIterator.next();
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
 * Qualified Name:     com.tencent.token.mp
 * JD-Core Version:    0.7.0.1
 */