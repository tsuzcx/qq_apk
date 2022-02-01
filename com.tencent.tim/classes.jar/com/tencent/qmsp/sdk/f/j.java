package com.tencent.qmsp.sdk.f;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class j
  extends FilterOutputStream
{
  private static j e;
  private static int f;
  private static final Object g = new Object();
  private boolean a;
  private j b;
  protected byte[] c;
  protected int d;
  
  private j(OutputStream paramOutputStream)
  {
    this(paramOutputStream, 8192);
  }
  
  private j(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream);
    this.c = a.a().a(paramInt);
    this.a = true;
  }
  
  public static j a(OutputStream paramOutputStream)
  {
    j localj = null;
    synchronized (g)
    {
      if (e != null)
      {
        localj = e;
        e = localj.b;
        localj.b = null;
        f -= 1;
      }
      if (localj != null)
      {
        localj.out = paramOutputStream;
        localj.a = true;
        return localj;
      }
      return new j(paramOutputStream);
    }
  }
  
  private void a()
  {
    if (this.a) {
      return;
    }
    throw new IOException("BufferedOutputStream is closed");
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 | paramInt3) >= 0) && (paramInt2 <= paramInt1) && (paramInt1 - paramInt2 >= paramInt3)) {
      return;
    }
    throw new IndexOutOfBoundsException("length=" + paramInt1 + "; regionStart=" + paramInt2 + "; regionLength=" + paramInt3);
  }
  
  private void b()
  {
    this.d = 0;
    this.out = null;
    this.a = false;
  }
  
  private void c()
  {
    int i = this.d;
    if (i > 0)
    {
      this.out.write(this.c, 0, i);
      this.d = 0;
    }
  }
  
  private void d()
  {
    b();
    synchronized (g)
    {
      if (f < 4)
      {
        this.b = e;
        e = this;
        f += 1;
      }
      return;
    }
  }
  
  public void close()
  {
    try
    {
      boolean bool = this.a;
      if (bool) {
        break label14;
      }
    }
    finally
    {
      try
      {
        for (;;)
        {
          label14:
          super.close();
          d();
        }
      }
      finally
      {
        d();
      }
      localObject1 = finally;
    }
  }
  
  public void flush()
  {
    try
    {
      a();
      c();
      this.out.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void write(int paramInt)
  {
    try
    {
      a();
      int i = this.d;
      byte[] arrayOfByte = this.c;
      if (i == arrayOfByte.length)
      {
        this.out.write(arrayOfByte, 0, i);
        this.d = 0;
      }
      arrayOfByte = this.c;
      i = this.d;
      this.d = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      return;
    }
    finally {}
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      a();
      if (paramArrayOfByte != null)
      {
        byte[] arrayOfByte = this.c;
        if (paramInt2 >= arrayOfByte.length)
        {
          c();
          this.out.write(paramArrayOfByte, paramInt1, paramInt2);
        }
        for (;;)
        {
          return;
          a(paramArrayOfByte.length, paramInt1, paramInt2);
          if (paramInt2 > arrayOfByte.length - this.d) {
            c();
          }
          System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, this.d, paramInt2);
          this.d += paramInt2;
        }
      }
      throw new NullPointerException("buffer == null");
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.f.j
 * JD-Core Version:    0.7.0.1
 */