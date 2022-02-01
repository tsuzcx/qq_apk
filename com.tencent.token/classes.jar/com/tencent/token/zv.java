package com.tencent.token;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public final class zv
{
  static FileFilter a = new FileFilter()
  {
    public final boolean accept(File paramAnonymousFile)
    {
      if (!paramAnonymousFile.isDirectory()) {
        return false;
      }
      return zv.a(paramAnonymousFile) > 0L;
    }
  };
  String b = "Tracer.File";
  int c = 4096;
  long d = 10000L;
  File e;
  int f = 10;
  String g = ".log";
  long h = 9223372036854775807L;
  private int i = 2147483647;
  private int j = 2147483647;
  private FileFilter k = new FileFilter()
  {
    public final boolean accept(File paramAnonymousFile)
    {
      if (!paramAnonymousFile.getName().endsWith(zv.this.g)) {
        return false;
      }
      return zv.c(paramAnonymousFile) != -1;
    }
  };
  private Comparator<? super File> l = new Comparator() {};
  
  public zv(File paramFile, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    this.e = paramFile;
    this.j = paramInt;
    this.i = 262144;
    this.c = 8192;
    this.b = paramString1;
    this.d = 10000L;
    this.f = 10;
    this.g = paramString2;
    this.h = paramLong;
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
  
  private File d(File paramFile)
  {
    File[] arrayOfFile = b(paramFile);
    if ((arrayOfFile != null) && (arrayOfFile.length != 0))
    {
      a(arrayOfFile);
      File localFile = arrayOfFile[(arrayOfFile.length - 1)];
      int n = arrayOfFile.length - this.j;
      localObject = localFile;
      int m = n;
      if ((int)localFile.length() > this.i)
      {
        m = e(localFile);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(m + 1);
        ((StringBuilder)localObject).append(this.g);
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
    Object localObject = new StringBuilder("1");
    ((StringBuilder)localObject).append(this.g);
    return new File(paramFile, ((StringBuilder)localObject).toString());
  }
  
  private static int e(File paramFile)
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
  
  public final File a(long paramLong)
  {
    return d(b(paramLong));
  }
  
  public final File[] a(File[] paramArrayOfFile)
  {
    Arrays.sort(paramArrayOfFile, this.l);
    return paramArrayOfFile;
  }
  
  public final File b(long paramLong)
  {
    File localFile = new File(this.e, new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(paramLong)));
    localFile.mkdirs();
    return localFile;
  }
  
  public final File[] b(File paramFile)
  {
    return paramFile.listFiles(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zv
 * JD-Core Version:    0.7.0.1
 */