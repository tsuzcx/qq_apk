package com.tencent.feedback.upload;

import com.tencent.feedback.common.e;

public class c
{
  private long a = 0L;
  private long b = 0L;
  private int c = 0;
  
  public long a()
  {
    try
    {
      long l = this.a;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      e.h("rqdp{  recevied:}%d", new Object[] { Long.valueOf(paramLong) });
      this.b += paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    try
    {
      e.h("rqdp{  send:}%s rqdp{  sz:}%d rqdp{  apn:}%s", new Object[] { paramString1, Long.valueOf(paramLong), paramString2 });
      this.c += 1;
      this.a += paramLong;
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public long b()
  {
    try
    {
      long l = this.b;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.upload.c
 * JD-Core Version:    0.7.0.1
 */