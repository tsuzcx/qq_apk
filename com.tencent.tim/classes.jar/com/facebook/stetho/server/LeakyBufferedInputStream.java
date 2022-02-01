package com.facebook.stetho.server;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class LeakyBufferedInputStream
  extends BufferedInputStream
{
  private boolean mLeaked;
  private boolean mMarked;
  
  public LeakyBufferedInputStream(InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream, paramInt);
  }
  
  private byte[] clearBufferLocked()
  {
    byte[] arrayOfByte = new byte[this.count - this.pos];
    System.arraycopy(this.buf, this.pos, arrayOfByte, 0, arrayOfByte.length);
    this.pos = 0;
    this.count = 0;
    return arrayOfByte;
  }
  
  private void throwIfLeaked()
  {
    if (this.mLeaked) {
      throw new IllegalStateException();
    }
  }
  
  private void throwIfMarked()
  {
    if (this.mMarked) {
      throw new IllegalStateException();
    }
  }
  
  public InputStream leakBufferAndStream()
  {
    try
    {
      throwIfLeaked();
      throwIfMarked();
      this.mLeaked = true;
      CompositeInputStream localCompositeInputStream = new CompositeInputStream(new InputStream[] { new ByteArrayInputStream(clearBufferLocked()), this.in });
      return localCompositeInputStream;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void mark(int paramInt)
  {
    try
    {
      throwIfLeaked();
      this.mMarked = true;
      super.mark(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      throwIfLeaked();
      this.mMarked = false;
      super.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.LeakyBufferedInputStream
 * JD-Core Version:    0.7.0.1
 */