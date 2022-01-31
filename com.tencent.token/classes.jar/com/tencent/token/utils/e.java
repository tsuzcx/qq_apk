package com.tencent.token.utils;

import com.tencent.token.ag;
import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public final class e
{
  private static FileFilter a = new f();
  private String b = "Tracer.File";
  private int c = 2147483647;
  private int d = 2147483647;
  private int e = 4096;
  private long f = 10000L;
  private File g;
  private int h = 10;
  private String i = ".log";
  private long j = 9223372036854775807L;
  private FileFilter k = new g(this);
  private Comparator l = new h(this);
  
  public e(File paramFile, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    this.g = paramFile;
    this.d = paramInt;
    this.c = 262144;
    this.e = 8192;
    this.b = paramString1;
    this.f = 10000L;
    this.h = 10;
    this.i = paramString2;
    this.j = paramLong;
  }
  
  public static long a(File paramFile)
  {
    try
    {
      long l1 = new SimpleDateFormat("yyyy-MM-dd").parse(paramFile.getName()).getTime();
      return l1;
    }
    catch (Exception paramFile) {}
    return -1L;
  }
  
  private static int d(File paramFile)
  {
    try
    {
      paramFile = paramFile.getName();
      int m = Integer.parseInt(paramFile.substring(0, paramFile.indexOf('.')));
      return m;
    }
    catch (Exception paramFile) {}
    return -1;
  }
  
  public final File a()
  {
    File localFile = a(ag.c().r());
    File[] arrayOfFile = localFile.listFiles(this.k);
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      localObject2 = new File(localFile, "1" + this.i);
      return localObject2;
    }
    Arrays.sort(arrayOfFile, this.l);
    Object localObject2 = arrayOfFile[(arrayOfFile.length - 1)];
    int n = arrayOfFile.length - this.d;
    int m = n;
    Object localObject1 = localObject2;
    if ((int)((File)localObject2).length() > this.c)
    {
      m = d((File)localObject2);
      localObject1 = new File(localFile, m + 1 + this.i);
      m = n + 1;
    }
    n = 0;
    for (;;)
    {
      localObject2 = localObject1;
      if (n >= m) {
        break;
      }
      arrayOfFile[n].delete();
      n += 1;
    }
  }
  
  public final File a(long paramLong)
  {
    File localFile = new File(this.g, new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(paramLong)));
    localFile.mkdirs();
    return localFile;
  }
  
  public final File[] a(File[] paramArrayOfFile)
  {
    Arrays.sort(paramArrayOfFile, this.l);
    return paramArrayOfFile;
  }
  
  public final void b()
  {
    if (this.g == null) {}
    for (;;)
    {
      return;
      File[] arrayOfFile = this.g.listFiles(a);
      if (arrayOfFile != null)
      {
        int n = arrayOfFile.length;
        int m = 0;
        while (m < n)
        {
          File localFile = arrayOfFile[m];
          long l1 = a(localFile);
          if (System.currentTimeMillis() - l1 > this.j) {
            i.a(localFile);
          }
          m += 1;
        }
      }
    }
  }
  
  public final File[] b(File paramFile)
  {
    return paramFile.listFiles(this.k);
  }
  
  public final String c()
  {
    return this.b;
  }
  
  public final int d()
  {
    return this.e;
  }
  
  public final long e()
  {
    return this.f;
  }
  
  public final int f()
  {
    return this.h;
  }
  
  public final String g()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.e
 * JD-Core Version:    0.7.0.1
 */