package com.tencent.tbs.one.impl.a;

import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.OutputStream;

public final class h
  extends OutputStream
{
  private OutputStream[] a;
  
  public h(OutputStream[] paramArrayOfOutputStream)
  {
    this.a = paramArrayOfOutputStream;
  }
  
  public final void close()
    throws IOException
  {
    OutputStream[] arrayOfOutputStream = this.a;
    int j = arrayOfOutputStream.length;
    int i = 0;
    while (i < j)
    {
      arrayOfOutputStream[i].close();
      i += 1;
    }
  }
  
  public final void flush()
    throws IOException
  {
    OutputStream[] arrayOfOutputStream = this.a;
    int j = arrayOfOutputStream.length;
    int i = 0;
    while (i < j)
    {
      arrayOfOutputStream[i].flush();
      i += 1;
    }
  }
  
  public final void write(int paramInt)
    throws IOException
  {
    OutputStream[] arrayOfOutputStream = this.a;
    int j = arrayOfOutputStream.length;
    int i = 0;
    while (i < j)
    {
      arrayOfOutputStream[i].write(paramInt);
      i += 1;
    }
  }
  
  public final void write(@NonNull byte[] paramArrayOfByte)
    throws IOException
  {
    OutputStream[] arrayOfOutputStream = this.a;
    int j = arrayOfOutputStream.length;
    int i = 0;
    while (i < j)
    {
      arrayOfOutputStream[i].write(paramArrayOfByte);
      i += 1;
    }
  }
  
  public final void write(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    OutputStream[] arrayOfOutputStream = this.a;
    int j = arrayOfOutputStream.length;
    int i = 0;
    while (i < j)
    {
      arrayOfOutputStream[i].write(paramArrayOfByte, paramInt1, paramInt2);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.h
 * JD-Core Version:    0.7.0.1
 */