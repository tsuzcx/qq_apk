import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class aaui
{
  private byte[] buffer;
  volatile boolean closed = false;
  private int in = -1;
  private int out;
  
  static
  {
    if (!aaui.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public aaui(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("RDDataPipe : Pipe Size <= 0");
    }
    this.buffer = new byte[paramInt];
    if (QLog.isColorLevel()) {
      QLog.d("RDDataPipe", 2, "RDDataPipe init, size:" + paramInt);
    }
  }
  
  private void cyB()
    throws IOException
  {
    if (this.closed) {
      throw new IOException("RDDataPipe : Pipe closed");
    }
  }
  
  private void cyC()
    throws IOException
  {
    while (this.in == this.out)
    {
      cyB();
      notifyAll();
      try
      {
        wait(100L);
      }
      catch (InterruptedException localInterruptedException)
      {
        QLog.e("RDDataPipe", 2, "awaitSpace, wait exception:" + localInterruptedException.toString());
      }
    }
  }
  
  public void close()
  {
    this.closed = true;
    try
    {
      this.in = -1;
      notifyAll();
      return;
    }
    finally {}
  }
  
  public void flush()
    throws IOException
  {
    try
    {
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int g(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        cyB();
        i = paramInt2;
        j = paramInt1;
        if (i <= 0) {
          break label211;
        }
        if (this.in == this.out) {
          cyC();
        }
        if (this.out >= this.in) {
          break label81;
        }
        paramInt1 = this.buffer.length - this.in;
      }
      finally {}
      if ((!$assertionsDisabled) && (k <= 0))
      {
        throw new AssertionError();
        label81:
        if (this.in < this.out)
        {
          if (this.in == -1)
          {
            this.out = 0;
            this.in = 0;
            paramInt1 = this.buffer.length - this.in;
            break label220;
          }
          paramInt1 = this.out - this.in;
          break label220;
        }
      }
      else
      {
        System.arraycopy(paramArrayOfByte, j, this.buffer, this.in, k);
        paramInt1 = i - k;
        int m = j + k;
        this.in = (k + this.in);
        i = paramInt1;
        j = m;
        if (this.in < this.buffer.length) {
          continue;
        }
        this.in = 0;
        i = paramInt1;
        j = m;
        continue;
        label211:
        return paramInt2 - i;
      }
      paramInt1 = 0;
      label220:
      int k = paramInt1;
      if (paramInt1 > i) {
        k = i;
      }
    }
  }
  
  public int read()
    throws IOException
  {
    int i = -1;
    try
    {
      if (this.closed) {
        throw new IOException("RDDataPipe : Pipe closed");
      }
    }
    finally {}
    for (;;)
    {
      notifyAll();
      try
      {
        wait(1000L);
        if (this.in < 0)
        {
          boolean bool = this.closed;
          if (!bool) {
            continue;
          }
          return i;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("RDDataPipe", 2, "read, wait exception:" + localInterruptedException);
            continue;
            byte[] arrayOfByte = this.buffer;
            i = this.out;
            this.out = (i + 1);
            int j = arrayOfByte[i] & 0xFF;
            if (this.out >= this.buffer.length) {
              this.out = 0;
            }
            i = j;
            if (this.in == this.out)
            {
              this.in = -1;
              i = j;
            }
          }
        }
      }
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = 0;
    if (paramArrayOfByte == null) {
      try
      {
        throw new NullPointerException();
      }
      finally {}
    }
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt2 > paramArrayOfByte.length - paramInt1)) {
      throw new IndexOutOfBoundsException();
    }
    if (paramInt2 == 0) {
      paramInt2 = i;
    }
    int j;
    do
    {
      do
      {
        for (;;)
        {
          return paramInt2;
          i = read();
          if (i >= 0) {
            break;
          }
          paramInt2 = -1;
        }
        paramInt2 = i;
      } while (this.in < 0);
      paramInt2 = i;
    } while (j <= 1);
    if (this.in > this.out) {
      paramInt2 = Math.min(this.buffer.length - this.out, this.in - this.out);
    }
    for (;;)
    {
      System.arraycopy(this.buffer, this.out, paramArrayOfByte, paramInt1 + i, k);
      this.out += k;
      paramInt2 = i + k;
      int k = j - k;
      if (this.out >= this.buffer.length) {
        this.out = 0;
      }
      i = paramInt2;
      j = k;
      if (this.in != this.out) {
        break;
      }
      this.in = -1;
      i = paramInt2;
      j = k;
      break;
      paramInt2 = this.buffer.length;
      k = this.out;
      paramInt2 -= k;
      break label256;
      paramArrayOfByte[paramInt1] = ((byte)i);
      i = 1;
      j = paramInt2;
      break;
      label256:
      k = paramInt2;
      if (paramInt2 > j - 1) {
        k = j - 1;
      }
    }
  }
  
  public int write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramArrayOfByte == null) {}
    while ((paramInt1 < 0) || (paramInt1 > paramArrayOfByte.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length) || (paramInt1 + paramInt2 < 0) || (paramInt2 == 0)) {
      return 0;
    }
    return g(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  /* Error */
  public int zg()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	aaui:in	I
    //   6: ifge +13 -> 19
    //   9: aload_0
    //   10: getfield 40	aaui:buffer	[B
    //   13: arraylength
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 31	aaui:in	I
    //   23: aload_0
    //   24: getfield 79	aaui:out	I
    //   27: if_icmpne +8 -> 35
    //   30: iconst_0
    //   31: istore_1
    //   32: goto -17 -> 15
    //   35: aload_0
    //   36: getfield 31	aaui:in	I
    //   39: aload_0
    //   40: getfield 79	aaui:out	I
    //   43: if_icmple +22 -> 65
    //   46: aload_0
    //   47: getfield 40	aaui:buffer	[B
    //   50: arraylength
    //   51: aload_0
    //   52: getfield 31	aaui:in	I
    //   55: aload_0
    //   56: getfield 79	aaui:out	I
    //   59: isub
    //   60: isub
    //   61: istore_1
    //   62: goto -47 -> 15
    //   65: aload_0
    //   66: getfield 79	aaui:out	I
    //   69: istore_1
    //   70: aload_0
    //   71: getfield 31	aaui:in	I
    //   74: istore_2
    //   75: iload_1
    //   76: iload_2
    //   77: isub
    //   78: istore_1
    //   79: goto -64 -> 15
    //   82: astore_3
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_3
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	aaui
    //   14	65	1	i	int
    //   74	4	2	j	int
    //   82	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	82	finally
    //   19	30	82	finally
    //   35	62	82	finally
    //   65	75	82	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaui
 * JD-Core Version:    0.7.0.1
 */