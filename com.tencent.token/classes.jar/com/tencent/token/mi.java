package com.tencent.token;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class mi
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
  
  public mi(String paramString)
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
            mc localmc = new mc(this, arrayOfString[j]);
            if (localmc.b)
            {
              this.i.add(localmc);
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
          lh.a("TaskDivider", "parseLong for totalLen fail.", paramString);
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
  
  public final mc a()
  {
    label238:
    label244:
    label250:
    for (;;)
    {
      synchronized (this.i)
      {
        mc localmc1;
        if (this.i.size() == 0)
        {
          localmc1 = new mc(this, 0L, 0L, 0L, -1L);
        }
        else
        {
          mc localmc2 = (mc)this.i.get(0);
          Iterator localIterator = this.i.iterator();
          if (!localIterator.hasNext()) {
            break label238;
          }
          localmc1 = (mc)localIterator.next();
          if ((localmc1.i) || (localmc1.a(this.a) <= 0L))
          {
            if (localmc1.a(this.a) <= localmc2.a(this.a)) {
              continue;
            }
            localmc2 = localmc1;
            continue;
          }
          if (localmc1 != null) {
            break label250;
          }
          long l1 = localmc2.a(this.a);
          long l2 = localmc2.g;
          if (l1 <= kx.e() << 1) {
            break label244;
          }
          l1 = l2 + l1 / 2L;
          localmc1 = new mc(this, l1, l1, l1, localmc2.h);
          localmc1.d = localmc2.c;
        }
        if (localmc1 != null) {
          localmc1.i = true;
        }
        return localmc1;
      }
      Object localObject2 = null;
      continue;
      localObject2 = null;
    }
  }
  
  public final mc a(int paramInt)
  {
    synchronized (this.i)
    {
      try
      {
        mc localmc = (mc)this.i.get(paramInt);
        if (localmc != null) {
          return localmc;
        }
      }
      catch (Exception localException)
      {
        lh.a("TaskDivider", localException);
        ??? = new StringBuilder("getSection fail. sectionId:");
        ((StringBuilder)???).append(paramInt);
        ((StringBuilder)???).append(", divider:");
        ((StringBuilder)???).append(b());
        lh.d("TaskDivider", ((StringBuilder)???).toString());
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
  
  public final boolean a(mc parammc)
  {
    if (parammc.c == -1) {}
    for (;;)
    {
      mc localmc;
      synchronized (this.i)
      {
        if (parammc.d == -1)
        {
          if (this.i.size() != 0)
          {
            lh.c("TaskDivider", "first section, list size should be 0!!!");
          }
          else
          {
            parammc.c = 0;
            parammc.h = this.a;
            this.i.add(parammc);
            return true;
          }
        }
        else
        {
          if (parammc.d < this.i.size()) {
            continue;
          }
          localObject = new StringBuilder("parent id:");
          ((StringBuilder)localObject).append(parammc.d);
          ((StringBuilder)localObject).append(" wrong!!!");
          lh.d("TaskDivider", ((StringBuilder)localObject).toString());
        }
        return false;
        localObject = null;
        Iterator localIterator = this.i.iterator();
        if (localIterator.hasNext())
        {
          localmc = (mc)localIterator.next();
          if (localmc.c == parammc.d)
          {
            if (localmc.g >= localmc.h) {
              return false;
            }
            if (localmc.g + kx.e() <= parammc.e) {
              break label334;
            }
            return false;
          }
          if ((localmc.h <= parammc.e) || (localmc.e >= parammc.h)) {
            continue;
          }
          return false;
        }
        if (localObject == null) {
          return false;
        }
        parammc.c = this.i.size();
        ((mc)localObject).h = parammc.e;
        this.i.add(parammc);
        return true;
      }
      Object localObject = new StringBuilder("addRealSection of id ");
      ((StringBuilder)localObject).append(parammc.c);
      ((StringBuilder)localObject).append(" should not happen!!!");
      lh.d("TaskDivider", ((StringBuilder)localObject).toString());
      return false;
      label334:
      localObject = localmc;
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
        mc localmc = (mc)localIterator.next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(localmc.c);
        localStringBuilder2.append(mc.a);
        localStringBuilder2.append(localmc.d);
        localStringBuilder2.append(mc.a);
        localStringBuilder2.append(localmc.e);
        localStringBuilder2.append(mc.a);
        localStringBuilder2.append(localmc.f);
        localStringBuilder2.append(mc.a);
        localStringBuilder2.append(localmc.h);
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
      mc localmc;
      for (long l = 0L; localIterator.hasNext(); l += localmc.f - localmc.e) {
        localmc = (mc)localIterator.next();
      }
      return l;
    }
  }
  
  public final long d()
  {
    synchronized (this.i)
    {
      Iterator localIterator = this.i.iterator();
      mc localmc;
      for (long l = 0L; localIterator.hasNext(); l += localmc.g - localmc.e) {
        localmc = (mc)localIterator.next();
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
 * Qualified Name:     com.tencent.token.mi
 * JD-Core Version:    0.7.0.1
 */