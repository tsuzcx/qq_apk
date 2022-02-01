package com.tencent.tbs.one.impl.a;

import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

public final class k
  extends InputStream
{
  public long a = 0L;
  public a b;
  private InputStream c;
  private long d;
  private int e = 0;
  
  public k(InputStream paramInputStream, long paramLong)
  {
    this.c = paramInputStream;
    this.d = paramLong;
  }
  
  private void a()
    throws IOException
  {
    if ((this.b != null) && (!this.b.a())) {
      throw new IOException("Aborted");
    }
  }
  
  private void b()
  {
    if ((this.d > 0L) && (this.b != null))
    {
      int i = (int)(this.a / this.d * 100.0D);
      if (i - this.e >= 2)
      {
        this.e = i;
        this.b.a(i);
      }
    }
  }
  
  public final int available()
    throws IOException
  {
    return this.c.available();
  }
  
  public final void close()
    throws IOException
  {
    this.c.close();
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      this.c.mark(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean markSupported()
  {
    return this.c.markSupported();
  }
  
  public final int read()
    throws IOException
  {
    a();
    int i = this.c.read();
    if (i != -1)
    {
      this.a += 1L;
      b();
    }
    return i;
  }
  
  public final int read(@NonNull byte[] paramArrayOfByte)
    throws IOException
  {
    a();
    int i = this.c.read(paramArrayOfByte);
    if (i != -1)
    {
      this.a += i;
      b();
    }
    return i;
  }
  
  public final int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    a();
    paramInt1 = this.c.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1)
    {
      this.a += paramInt1;
      b();
    }
    return paramInt1;
  }
  
  public final void reset()
    throws IOException
  {
    try
    {
      this.c.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long skip(long paramLong)
    throws IOException
  {
    return this.c.skip(paramLong);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
    
    public abstract boolean a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.k
 * JD-Core Version:    0.7.0.1
 */