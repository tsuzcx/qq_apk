package com.tencent.tmassistantsdk.downloadservice;

import java.util.ArrayList;
import java.util.Iterator;

public final class e
{
  private static e a = null;
  private ArrayList b = new ArrayList();
  
  public static e a()
  {
    if (a == null) {
      a = new e();
    }
    return a;
  }
  
  public final void a(k paramk)
  {
    try
    {
      if (!this.b.contains(paramk)) {
        this.b.add(paramk);
      }
      return;
    }
    finally
    {
      paramk = finally;
      throw paramk;
    }
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((k)localIterator.next()).a(paramString1, paramInt1, paramInt2, paramString2);
      }
    }
    finally {}
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((k)localIterator.next()).a(paramString, paramLong1, paramLong2);
      }
    }
    finally {}
  }
  
  public final void b(k paramk)
  {
    try
    {
      this.b.remove(paramk);
      return;
    }
    finally
    {
      paramk = finally;
      throw paramk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.e
 * JD-Core Version:    0.7.0.1
 */