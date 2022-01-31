package com.tencent.token;

import java.util.concurrent.TimeUnit;
import okhttp3.ak;
import okhttp3.am;
import okhttp3.ap;
import okhttp3.aq;
import okhttp3.g;
import okhttp3.h;

public class ee
{
  private static ee b;
  private ak a = new am().a(60L, TimeUnit.SECONDS).c(60L, TimeUnit.SECONDS).b(60L, TimeUnit.SECONDS).a();
  
  public static ee a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new ee();
      }
      return b;
    }
    finally {}
  }
  
  private void a(ap paramap, h paramh)
  {
    this.a.a(paramap).a(paramh);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, h paramh)
  {
    a(new aq().a("RANGE", "bytes=" + paramLong1 + "-" + paramLong2).a(paramString).a(), paramh);
  }
  
  public void a(String paramString, h paramh)
  {
    a(new aq().a(paramString).a(), paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ee
 * JD-Core Version:    0.7.0.1
 */