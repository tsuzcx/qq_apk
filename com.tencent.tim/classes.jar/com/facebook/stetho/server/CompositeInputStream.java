package com.facebook.stetho.server;

import com.facebook.stetho.common.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class CompositeInputStream
  extends InputStream
{
  private int mCurrentIndex;
  private final InputStream[] mStreams;
  
  public CompositeInputStream(InputStream[] paramArrayOfInputStream)
  {
    if ((paramArrayOfInputStream == null) || (paramArrayOfInputStream.length < 2)) {
      throw new IllegalArgumentException("Streams must be non-null and have more than 1 entry");
    }
    this.mStreams = paramArrayOfInputStream;
    this.mCurrentIndex = 0;
  }
  
  private void closeAll(int paramInt)
    throws IOException
  {
    int i = 0;
    Object localObject1 = null;
    Object localObject2;
    for (;;)
    {
      if (i < this.mStreams.length) {
        try
        {
          this.mStreams[i].close();
          i += 1;
        }
        catch (IOException localIOException)
        {
          localObject2 = localIOException;
          if (i != paramInt)
          {
            if (localObject1 != null) {
              break label71;
            }
            localObject2 = localIOException;
          }
        }
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (localObject1 != localObject2)) {
        LogUtil.w((Throwable)localObject1, "Suppressing exception");
      }
      localObject1 = localObject2;
      break;
      return;
      label71:
      localObject2 = localObject1;
    }
  }
  
  private boolean tryMoveToNextStream()
  {
    if (this.mCurrentIndex + 1 < this.mStreams.length)
    {
      this.mCurrentIndex += 1;
      return true;
    }
    return false;
  }
  
  public int available()
    throws IOException
  {
    return this.mStreams[this.mCurrentIndex].available();
  }
  
  public void close()
    throws IOException
  {
    closeAll(this.mCurrentIndex);
  }
  
  public void mark(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
    throws IOException
  {
    int i;
    do
    {
      i = this.mStreams[this.mCurrentIndex].read();
    } while ((i == -1) && (tryMoveToNextStream()));
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i;
    do
    {
      i = this.mStreams[this.mCurrentIndex].read(paramArrayOfByte, paramInt1, paramInt2);
    } while ((i == -1) && (tryMoveToNextStream()));
    return i;
  }
  
  public void reset()
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    int i = read(new byte[(int)paramLong]);
    if (i >= 0) {
      return i;
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.CompositeInputStream
 * JD-Core Version:    0.7.0.1
 */