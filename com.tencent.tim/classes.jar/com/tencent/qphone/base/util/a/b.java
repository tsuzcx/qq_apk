package com.tencent.qphone.base.util.a;

import java.io.IOException;

public class b
  extends c
{
  private static int e = 8192;
  private c a;
  private char[] b;
  private int c;
  private int d;
  
  public b(c paramc)
  {
    this(paramc, e);
  }
  
  public b(c paramc, int paramInt)
  {
    super(paramc);
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Buffer size <= 0");
    }
    this.a = paramc;
    this.b = new char[paramInt];
    this.c = paramInt;
    this.d = 0;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  private void b()
    throws IOException
  {
    if (this.a == null) {
      throw new IOException("Stream closed");
    }
  }
  
  void a()
    throws IOException
  {
    synchronized (this.lock)
    {
      b();
      if (this.d == 0) {
        return;
      }
      this.a.write(this.b, 0, this.d);
      this.d = 0;
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    synchronized (this.lock)
    {
      a();
      this.a.a(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
  }
  
  public void close()
    throws IOException
  {
    synchronized (this.lock)
    {
      if (this.a == null) {
        return;
      }
    }
  }
  
  public void flush()
    throws IOException
  {
    synchronized (this.lock)
    {
      a();
      this.a.flush();
      return;
    }
  }
  
  public void write(int paramInt)
    throws IOException
  {
    synchronized (this.lock)
    {
      b();
      if (this.d >= this.c) {
        a();
      }
      char[] arrayOfChar = this.b;
      int i = this.d;
      this.d = (i + 1);
      arrayOfChar[i] = ((char)paramInt);
      return;
    }
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    synchronized (this.lock)
    {
      b();
      int i = paramInt1 + paramInt2;
      while (paramInt1 < i)
      {
        int j = a(this.c - this.d, i - paramInt1);
        paramString.getChars(paramInt1, paramInt1 + j, this.b, this.d);
        paramInt2 = paramInt1 + j;
        this.d = (j + this.d);
        paramInt1 = paramInt2;
        if (this.d >= this.c)
        {
          a();
          paramInt1 = paramInt2;
        }
      }
    }
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    synchronized (this.lock)
    {
      b();
      if ((paramInt1 < 0) || (paramInt1 > paramArrayOfChar.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length) || (paramInt1 + paramInt2 < 0)) {
        throw new IndexOutOfBoundsException();
      }
    }
    if (paramInt2 == 0) {
      return;
    }
    if (paramInt2 >= this.c)
    {
      a();
      this.a.write(paramArrayOfChar, paramInt1, paramInt2);
      return;
    }
    for (;;)
    {
      int i;
      if (paramInt1 < i)
      {
        int j = a(this.c - this.d, i - paramInt1);
        System.arraycopy(paramArrayOfChar, paramInt1, this.b, this.d, j);
        paramInt2 = paramInt1 + j;
        this.d = (j + this.d);
        paramInt1 = paramInt2;
        if (this.d >= this.c)
        {
          a();
          paramInt1 = paramInt2;
        }
      }
      else
      {
        return;
        i = paramInt1 + paramInt2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.a.b
 * JD-Core Version:    0.7.0.1
 */