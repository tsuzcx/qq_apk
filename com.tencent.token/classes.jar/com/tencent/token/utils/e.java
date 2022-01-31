package com.tencent.token.utils;

import com.tencent.token.cx;
import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class e
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
  
  public e(File paramFile, int paramInt1, int paramInt2, int paramInt3, String paramString1, long paramLong1, int paramInt4, String paramString2, long paramLong2)
  {
    c(paramFile);
    b(paramInt1);
    a(paramInt2);
    c(paramInt3);
    a(paramString1);
    b(paramLong1);
    d(paramInt4);
    b(paramString2);
    c(paramLong2);
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
  
  private File d(long paramLong)
  {
    return e(a(paramLong));
  }
  
  private File e(File paramFile)
  {
    File[] arrayOfFile = b(paramFile);
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      paramFile = new File(paramFile, "1" + j());
      return paramFile;
    }
    a(arrayOfFile);
    File localFile2 = arrayOfFile[(arrayOfFile.length - 1)];
    int n = arrayOfFile.length - e();
    int m = n;
    File localFile1 = localFile2;
    if ((int)localFile2.length() > d())
    {
      m = f(localFile2);
      localFile1 = new File(paramFile, m + 1 + j());
      m = n + 1;
    }
    n = 0;
    for (;;)
    {
      paramFile = localFile1;
      if (n >= m) {
        break;
      }
      arrayOfFile[n].delete();
      n += 1;
    }
  }
  
  private static int f(File paramFile)
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
  
  public File a()
  {
    return d(cx.c().s());
  }
  
  public File a(long paramLong)
  {
    File localFile = new File(h(), new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(paramLong)));
    localFile.mkdirs();
    return localFile;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public File[] a(File[] paramArrayOfFile)
  {
    Arrays.sort(paramArrayOfFile, this.l);
    return paramArrayOfFile;
  }
  
  public void b()
  {
    if (h() == null) {}
    for (;;)
    {
      return;
      File[] arrayOfFile = h().listFiles(a);
      if (arrayOfFile != null)
      {
        int n = arrayOfFile.length;
        int m = 0;
        while (m < n)
        {
          File localFile = arrayOfFile[m];
          long l1 = a(localFile);
          if (System.currentTimeMillis() - l1 > k()) {
            i.a(localFile);
          }
          m += 1;
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.f = paramLong;
  }
  
  public void b(String paramString)
  {
    this.i = paramString;
  }
  
  public File[] b(File paramFile)
  {
    return paramFile.listFiles(this.k);
  }
  
  public String c()
  {
    return this.b;
  }
  
  public void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.j = paramLong;
  }
  
  public void c(File paramFile)
  {
    this.g = paramFile;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public void d(int paramInt)
  {
    this.h = paramInt;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public int f()
  {
    return this.e;
  }
  
  public long g()
  {
    return this.f;
  }
  
  public File h()
  {
    return this.g;
  }
  
  public int i()
  {
    return this.h;
  }
  
  public String j()
  {
    return this.i;
  }
  
  public long k()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.e
 * JD-Core Version:    0.7.0.1
 */