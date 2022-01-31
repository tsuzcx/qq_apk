package com.tencent.tmassistantsdk.downloadservice;

import android.content.res.Resources.NotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
{
  private static Pattern c = Pattern.compile("^\\s*bytes\\s+(\\d+)-(\\d+)/(\\d+)\\s*$");
  private long a;
  private Long b;
  
  static
  {
    Pattern.compile("^\\s*([^=\\s]+)\\s*=\\s*(\\d*)\\s*-\\s*(\\d*)((?:\\s*,\\s*(?:\\d*)-(?:\\d*))*)\\s*$");
  }
  
  private b(long paramLong1, long paramLong2)
  {
    this(paramLong1, Long.valueOf(paramLong2));
    if (paramLong1 < 0L) {
      throw new IllegalArgumentException("If end is provided, start must be positive.");
    }
    if (paramLong2 < paramLong1) {
      throw new IllegalArgumentException("end must be >= start.");
    }
  }
  
  private b(long paramLong, Long paramLong1)
  {
    this.a = paramLong;
    this.b = paramLong1;
  }
  
  public static b a(String paramString)
  {
    Matcher localMatcher = c.matcher(paramString);
    if (!localMatcher.matches()) {
      throw new Throwable("Invalid content-range format: " + paramString);
    }
    return new b(Long.parseLong(localMatcher.group(1)), Long.parseLong(localMatcher.group(2)));
  }
  
  public static long b(String paramString)
  {
    int i = paramString.indexOf("/");
    if (i == -1) {
      throw new Resources.NotFoundException();
    }
    return Long.parseLong(paramString.substring(i + 1));
  }
  
  public final long a()
  {
    return this.a;
  }
  
  public final long b()
  {
    if (this.b != null) {}
    for (int i = 1; i == 0; i = 0) {
      throw new IllegalStateException("Byte-range does not have end.  Check hasEnd() before use");
    }
    return this.b.longValue();
  }
  
  public final boolean equals(Object paramObject)
  {
    int k = 0;
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      if (this.a == paramObject.a) {
        break label29;
      }
    }
    label29:
    label88:
    label91:
    for (;;)
    {
      return false;
      int i;
      if (this.b != null)
      {
        i = 1;
        if (paramObject.b == null) {
          break label88;
        }
      }
      for (int j = 1;; j = 0)
      {
        if (i != j) {
          break label91;
        }
        i = k;
        if (this.b != null) {
          i = 1;
        }
        if (i == 0) {
          break label93;
        }
        return this.b.equals(Long.valueOf(paramObject.b()));
        i = 0;
        break;
      }
    }
    label93:
    return true;
  }
  
  public final int hashCode()
  {
    int j = Long.valueOf(this.a).hashCode() + 629;
    int i = j;
    if (this.b != null) {
      i = j * 37 + this.b.hashCode();
    }
    return i;
  }
  
  public final String toString()
  {
    if (this.b != null) {
      return "bytes=" + this.a + "-" + this.b;
    }
    if (this.a < 0L) {
      return "bytes=" + this.a;
    }
    return "bytes=" + this.a + "-";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.b
 * JD-Core Version:    0.7.0.1
 */