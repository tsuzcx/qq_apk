package com.tencent.token.utils;

import com.tencent.token.cd;
import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class d
{
  private static FileFilter a = new FileFilter()
  {
    public boolean accept(File paramAnonymousFile)
    {
      boolean bool2 = paramAnonymousFile.isDirectory();
      boolean bool1 = false;
      if (!bool2) {
        return false;
      }
      if (d.a(paramAnonymousFile) > 0L) {
        bool1 = true;
      }
      return bool1;
    }
  };
  private String b = "Tracer.File";
  private int c = 2147483647;
  private int d = 2147483647;
  private int e = 4096;
  private long f = 10000L;
  private File g;
  private int h = 10;
  private String i = ".log";
  private long j = 9223372036854775807L;
  private FileFilter k = new FileFilter()
  {
    public boolean accept(File paramAnonymousFile)
    {
      boolean bool2 = paramAnonymousFile.getName().endsWith(d.this.j());
      boolean bool1 = false;
      if (!bool2) {
        return false;
      }
      if (d.d(paramAnonymousFile) != -1) {
        bool1 = true;
      }
      return bool1;
    }
  };
  private Comparator<? super File> l = new Comparator()
  {
    public int a(File paramAnonymousFile1, File paramAnonymousFile2)
    {
      return d.d(paramAnonymousFile1) - d.d(paramAnonymousFile2);
    }
  };
  
  public d(File paramFile, int paramInt1, int paramInt2, int paramInt3, String paramString1, long paramLong1, int paramInt4, String paramString2, long paramLong2)
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
    catch (Exception paramFile)
    {
      label22:
      break label22;
    }
    return -1L;
  }
  
  private File d(long paramLong)
  {
    return e(a(paramLong));
  }
  
  private File e(File paramFile)
  {
    File[] arrayOfFile = b(paramFile);
    if ((arrayOfFile != null) && (arrayOfFile.length != 0))
    {
      a(arrayOfFile);
      File localFile = arrayOfFile[(arrayOfFile.length - 1)];
      int n = arrayOfFile.length - e();
      localObject = localFile;
      int m = n;
      if ((int)localFile.length() > d())
      {
        m = f(localFile);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(m + 1);
        ((StringBuilder)localObject).append(j());
        localObject = new File(paramFile, ((StringBuilder)localObject).toString());
        m = n + 1;
      }
      n = 0;
      while (n < m)
      {
        arrayOfFile[n].delete();
        n += 1;
      }
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("1");
    ((StringBuilder)localObject).append(j());
    return new File(paramFile, ((StringBuilder)localObject).toString());
  }
  
  private static int f(File paramFile)
  {
    try
    {
      paramFile = paramFile.getName();
      int m = Integer.parseInt(paramFile.substring(0, paramFile.indexOf('.')));
      return m;
    }
    catch (Exception paramFile)
    {
      label22:
      break label22;
    }
    return -1;
  }
  
  public File a()
  {
    return d(cd.c().s());
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
    if (h() == null) {
      return;
    }
    File[] arrayOfFile = h().listFiles(a);
    if (arrayOfFile == null) {
      return;
    }
    int n = arrayOfFile.length;
    int m = 0;
    while (m < n)
    {
      File localFile = arrayOfFile[m];
      long l1 = a(localFile);
      if (System.currentTimeMillis() - l1 > k()) {
        e.a(localFile);
      }
      m += 1;
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
 * Qualified Name:     com.tencent.token.utils.d
 * JD-Core Version:    0.7.0.1
 */