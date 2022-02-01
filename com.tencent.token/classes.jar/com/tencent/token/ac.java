package com.tencent.token;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;

public final class ac
{
  public final String a;
  public final LinkedHashMap<String, ab> b = new LinkedHashMap();
  public String c;
  public File d;
  public RandomAccessFile e;
  public ab f = null;
  
  public ac(File paramFile, String paramString)
  {
    this.c = paramString;
    this.a = paramFile.getPath();
    this.d = null;
    this.e = new RandomAccessFile(this.a, "r");
    long l2 = this.e.length() - 22L;
    long l1 = 0L;
    if (l2 >= 0L)
    {
      long l3 = l2 - 65536L;
      if (l3 >= 0L) {
        l1 = l3;
      }
      do
      {
        this.e.seek(l2);
        if (Integer.reverseBytes(this.e.readInt()) == 101010256)
        {
          paramFile = new byte[18];
          this.e.readFully(paramFile);
          paramFile = new z(paramFile, ByteOrder.LITTLE_ENDIAN);
          int i = paramFile.b();
          int k = paramFile.b();
          int j = paramFile.b();
          int m = paramFile.b();
          paramFile.d += 4;
          int n = paramFile.a();
          if ((j == m) && (i == 0) && (k == 0))
          {
            paramFile = new BufferedInputStream(new a(this.e, n), 4096);
            paramString = new byte[46];
            i = 0;
            while (i < j)
            {
              ab localab = new ab(paramString, paramFile);
              this.b.put(localab.a, localab);
              if (localab.a.equals(this.c))
              {
                this.f = localab;
                return;
              }
              localab.a.contains("lib");
              i += 1;
            }
            return;
          }
          throw new ZipException("spanned archives not supported");
        }
        l2 -= 1L;
      } while (l2 >= l1);
      throw new ZipException("EOCD not found; not a Zip archive?");
    }
    throw new ZipException("too short to be Zip");
  }
  
  public final InputStream a(ab paramab)
  {
    Object localObject2 = paramab.a;
    if (this.e != null)
    {
      if (localObject2 != null)
      {
        ??? = (ab)this.b.get(localObject2);
        paramab = (ab)???;
        if (??? == null)
        {
          paramab = this.b;
          ??? = new StringBuilder();
          ((StringBuilder)???).append((String)localObject2);
          ((StringBuilder)???).append("/");
          paramab = (ab)paramab.get(((StringBuilder)???).toString());
        }
        if (paramab == null) {
          return null;
        }
        ??? = paramab.a;
        if ((??? != null) && ((((String)???).contains("../")) || (((String)???).contains("..\\")))) {
          throw new ad();
        }
        synchronized (this.e)
        {
          localObject2 = new a((RandomAccessFile)???, paramab.g + 28L);
          DataInputStream localDataInputStream = new DataInputStream((InputStream)localObject2);
          int i = Short.reverseBytes(localDataInputStream.readShort());
          localDataInputStream.close();
          ((a)localObject2).skip(paramab.f + i);
          ((a)localObject2).c = (((a)localObject2).b + paramab.b);
          if (paramab.d == 8)
          {
            i = Math.max(1024, (int)Math.min(paramab.c, 65535L));
            paramab = new b((InputStream)localObject2, new Inflater(true), i, paramab);
            return paramab;
          }
          return localObject2;
        }
      }
      throw new NullPointerException();
    }
    throw new IllegalStateException("Zip file closed");
  }
  
  public final void a()
  {
    Object localObject1 = this.e;
    if (localObject1 != null) {
      try
      {
        this.e = null;
        ((RandomAccessFile)localObject1).close();
        localObject1 = this.d;
        if (localObject1 != null)
        {
          ((File)localObject1).delete();
          this.d = null;
          return;
        }
      }
      finally {}
    }
  }
  
  public final void finalize()
  {
    try
    {
      super.finalize();
      return;
    }
    finally {}
  }
  
  public static final class a
    extends InputStream
  {
    public RandomAccessFile a;
    public long b;
    public long c;
    
    public a(RandomAccessFile paramRandomAccessFile, long paramLong)
    {
      this.a = paramRandomAccessFile;
      this.b = paramLong;
      this.c = paramRandomAccessFile.length();
    }
    
    public final int available()
    {
      if (this.b < this.c) {
        return 1;
      }
      return 0;
    }
    
    public final int read()
    {
      byte[] arrayOfByte = new byte[1];
      int j = read(arrayOfByte, 0, 1);
      int i = -1;
      if (j != -1) {
        i = arrayOfByte[0] & 0xFF;
      }
      return i;
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      synchronized (this.a)
      {
        this.a.seek(this.b);
        int i = paramInt2;
        if (paramInt2 > this.c - this.b) {
          i = (int)(this.c - this.b);
        }
        paramInt1 = this.a.read(paramArrayOfByte, paramInt1, i);
        if (paramInt1 > 0)
        {
          this.b += paramInt1;
          return paramInt1;
        }
        return -1;
      }
    }
    
    public final long skip(long paramLong)
    {
      long l2 = this.c - this.b;
      long l1 = paramLong;
      if (paramLong > l2) {
        l1 = l2;
      }
      this.b += l1;
      return l1;
    }
  }
  
  public static final class b
    extends InflaterInputStream
  {
    public ab a;
    public long b = 0L;
    
    public b(InputStream paramInputStream, Inflater paramInflater, int paramInt, ab paramab)
    {
      super(paramInflater, paramInt);
      this.a = paramab;
    }
    
    public final int available()
    {
      if (super.available() == 0) {
        return 0;
      }
      return (int)(this.a.c - this.b);
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        this.b += paramInt1;
      }
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ac
 * JD-Core Version:    0.7.0.1
 */