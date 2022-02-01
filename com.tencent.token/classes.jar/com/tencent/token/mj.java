package com.tencent.token;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class mj
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
  
  public mj(String paramString)
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
            md localmd = new md(this, arrayOfString[j]);
            if (localmd.b)
            {
              this.i.add(localmd);
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
          li.a("TaskDivider", "parseLong for totalLen fail.", paramString);
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
  
  public final md a()
  {
    label238:
    label244:
    label250:
    for (;;)
    {
      synchronized (this.i)
      {
        md localmd1;
        if (this.i.size() == 0)
        {
          localmd1 = new md(this, 0L, 0L, 0L, -1L);
        }
        else
        {
          md localmd2 = (md)this.i.get(0);
          Iterator localIterator = this.i.iterator();
          if (!localIterator.hasNext()) {
            break label238;
          }
          localmd1 = (md)localIterator.next();
          if ((localmd1.i) || (localmd1.a(this.a) <= 0L))
          {
            if (localmd1.a(this.a) <= localmd2.a(this.a)) {
              continue;
            }
            localmd2 = localmd1;
            continue;
          }
          if (localmd1 != null) {
            break label250;
          }
          long l1 = localmd2.a(this.a);
          long l2 = localmd2.g;
          if (l1 <= ky.e() << 1) {
            break label244;
          }
          l1 = l2 + l1 / 2L;
          localmd1 = new md(this, l1, l1, l1, localmd2.h);
          localmd1.d = localmd2.c;
        }
        if (localmd1 != null) {
          localmd1.i = true;
        }
        return localmd1;
      }
      Object localObject2 = null;
      continue;
      localObject2 = null;
    }
  }
  
  public final md a(int paramInt)
  {
    synchronized (this.i)
    {
      try
      {
        md localmd = (md)this.i.get(paramInt);
        if (localmd != null) {
          return localmd;
        }
      }
      catch (Exception localException)
      {
        li.a("TaskDivider", localException);
        ??? = new StringBuilder("getSection fail. sectionId:");
        ((StringBuilder)???).append(paramInt);
        ((StringBuilder)???).append(", divider:");
        ((StringBuilder)???).append(b());
        li.d("TaskDivider", ((StringBuilder)???).toString());
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
  
  public final boolean a(md parammd)
  {
    if (parammd.c == -1) {}
    for (;;)
    {
      md localmd;
      synchronized (this.i)
      {
        if (parammd.d == -1)
        {
          if (this.i.size() != 0)
          {
            li.c("TaskDivider", "first section, list size should be 0!!!");
          }
          else
          {
            parammd.c = 0;
            parammd.h = this.a;
            this.i.add(parammd);
            return true;
          }
        }
        else
        {
          if (parammd.d < this.i.size()) {
            continue;
          }
          localObject = new StringBuilder("parent id:");
          ((StringBuilder)localObject).append(parammd.d);
          ((StringBuilder)localObject).append(" wrong!!!");
          li.d("TaskDivider", ((StringBuilder)localObject).toString());
        }
        return false;
        localObject = null;
        Iterator localIterator = this.i.iterator();
        if (localIterator.hasNext())
        {
          localmd = (md)localIterator.next();
          if (localmd.c == parammd.d)
          {
            if (localmd.g >= localmd.h) {
              return false;
            }
            if (localmd.g + ky.e() <= parammd.e) {
              break label334;
            }
            return false;
          }
          if ((localmd.h <= parammd.e) || (localmd.e >= parammd.h)) {
            continue;
          }
          return false;
        }
        if (localObject == null) {
          return false;
        }
        parammd.c = this.i.size();
        ((md)localObject).h = parammd.e;
        this.i.add(parammd);
        return true;
      }
      Object localObject = new StringBuilder("addRealSection of id ");
      ((StringBuilder)localObject).append(parammd.c);
      ((StringBuilder)localObject).append(" should not happen!!!");
      li.d("TaskDivider", ((StringBuilder)localObject).toString());
      return false;
      label334:
      localObject = localmd;
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
        md localmd = (md)localIterator.next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(localmd.c);
        localStringBuilder2.append(md.a);
        localStringBuilder2.append(localmd.d);
        localStringBuilder2.append(md.a);
        localStringBuilder2.append(localmd.e);
        localStringBuilder2.append(md.a);
        localStringBuilder2.append(localmd.f);
        localStringBuilder2.append(md.a);
        localStringBuilder2.append(localmd.h);
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
      md localmd;
      for (long l = 0L; localIterator.hasNext(); l += localmd.f - localmd.e) {
        localmd = (md)localIterator.next();
      }
      return l;
    }
  }
  
  public final long d()
  {
    synchronized (this.i)
    {
      Iterator localIterator = this.i.iterator();
      md localmd;
      for (long l = 0L; localIterator.hasNext(); l += localmd.g - localmd.e) {
        localmd = (md)localIterator.next();
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
 * Qualified Name:     com.tencent.token.mj
 * JD-Core Version:    0.7.0.1
 */