package com.tencent.token;

import java.util.concurrent.TimeUnit;
import okhttp3.e;
import okhttp3.f;
import okhttp3.v;
import okhttp3.v.a;
import okhttp3.x;
import okhttp3.x.a;

public class dc
{
  private static dc b;
  private v a = new v.a().a(60L, TimeUnit.SECONDS).c(60L, TimeUnit.SECONDS).b(60L, TimeUnit.SECONDS).a();
  
  public static dc a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new dc();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void a(x paramx, f paramf)
  {
    this.a.a(paramx).a(paramf);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, f paramf)
  {
    x.a locala = new x.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bytes=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramLong2);
    a(locala.a("RANGE", localStringBuilder.toString()).a(paramString).a(), paramf);
  }
  
  public void a(String paramString, f paramf)
  {
    a(new x.a().a(paramString).a(), paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dc
 * JD-Core Version:    0.7.0.1
 */