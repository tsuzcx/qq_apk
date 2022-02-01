import android.support.annotation.NonNull;
import com.tencent.commonsdk.pool.ByteArrayPool;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class awdj
  extends FilterOutputStream
{
  private static final Object POOL_LOCK = new Object();
  private static awdj b;
  private static int poolSize;
  private final int MAX_POOL_SIZE = 4;
  private awdj a;
  protected byte[] buf;
  protected int count;
  private boolean used;
  
  private awdj(@NonNull OutputStream paramOutputStream)
  {
    this(paramOutputStream, 8192);
  }
  
  private awdj(@NonNull OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream);
    this.buf = ByteArrayPool.getGenericInstance().getBuf(paramInt);
    this.used = true;
  }
  
  public static awdj a(@NonNull OutputStream paramOutputStream)
  {
    awdj localawdj = null;
    synchronized (POOL_LOCK)
    {
      if (b != null)
      {
        localawdj = b;
        b = localawdj.a;
        localawdj.a = null;
        poolSize -= 1;
      }
      if (localawdj != null)
      {
        localawdj.out = paramOutputStream;
        localawdj.used = true;
        return localawdj;
      }
    }
    return new awdj(paramOutputStream);
  }
  
  private void checkNotClosed()
    throws IOException
  {
    if (!this.used) {
      throw new IOException("BufferedOutputStream is closed");
    }
  }
  
  public static void checkOffsetAndCount(int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 | paramInt3) < 0) || (paramInt2 > paramInt1) || (paramInt1 - paramInt2 < paramInt3)) {
      throw new IndexOutOfBoundsException("length=" + paramInt1 + "; regionStart=" + paramInt2 + "; regionLength=" + paramInt3);
    }
  }
  
  private void clearForRecycle()
  {
    this.count = 0;
    this.out = null;
    this.used = false;
  }
  
  private void flushInternal()
    throws IOException
  {
    if (this.count > 0)
    {
      this.out.write(this.buf, 0, this.count);
      this.count = 0;
    }
  }
  
  private void recycle()
  {
    clearForRecycle();
    synchronized (POOL_LOCK)
    {
      if (poolSize < 4)
      {
        this.a = b;
        b = this;
        poolSize += 1;
      }
      return;
    }
  }
  
  public void close()
    throws IOException
  {
    try
    {
      boolean bool = this.used;
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
          recycle();
        }
      }
      finally
      {
        recycle();
      }
      localObject1 = finally;
    }
  }
  
  public void flush()
    throws IOException
  {
    try
    {
      checkNotClosed();
      flushInternal();
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
    throws IOException
  {
    try
    {
      checkNotClosed();
      if (this.count == this.buf.length)
      {
        this.out.write(this.buf, 0, this.count);
        this.count = 0;
      }
      byte[] arrayOfByte = this.buf;
      int i = this.count;
      this.count = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      return;
    }
    finally {}
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      checkNotClosed();
      if (paramArrayOfByte == null) {
        throw new NullPointerException("buffer == null");
      }
    }
    finally {}
    byte[] arrayOfByte = this.buf;
    if (paramInt2 >= arrayOfByte.length)
    {
      flushInternal();
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      return;
      checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
      if (paramInt2 > arrayOfByte.length - this.count) {
        flushInternal();
      }
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, this.count, paramInt2);
      this.count += paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awdj
 * JD-Core Version:    0.7.0.1
 */