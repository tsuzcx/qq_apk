package org.apache.commons.io.output;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.input.ClosedInputStream;

public class ByteArrayOutputStream
  extends OutputStream
{
  static final int DEFAULT_SIZE = 1024;
  private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  private final List<byte[]> buffers = new ArrayList();
  private int count;
  private byte[] currentBuffer;
  private int currentBufferIndex;
  private int filledBufferSum;
  private boolean reuseBuffers = true;
  
  public ByteArrayOutputStream()
  {
    this(1024);
  }
  
  public ByteArrayOutputStream(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Negative initial size: " + paramInt);
    }
    try
    {
      needNewBuffer(paramInt);
      return;
    }
    finally {}
  }
  
  private void needNewBuffer(int paramInt)
  {
    if (this.currentBufferIndex < this.buffers.size() - 1)
    {
      this.filledBufferSum += this.currentBuffer.length;
      this.currentBufferIndex += 1;
      this.currentBuffer = ((byte[])this.buffers.get(this.currentBufferIndex));
      return;
    }
    if (this.currentBuffer == null) {}
    for (this.filledBufferSum = 0;; this.filledBufferSum += this.currentBuffer.length)
    {
      this.currentBufferIndex += 1;
      this.currentBuffer = new byte[paramInt];
      this.buffers.add(this.currentBuffer);
      return;
      paramInt = Math.max(this.currentBuffer.length << 1, paramInt - this.filledBufferSum);
    }
  }
  
  public static InputStream toBufferedInputStream(InputStream paramInputStream)
    throws IOException
  {
    return toBufferedInputStream(paramInputStream, 1024);
  }
  
  public static InputStream toBufferedInputStream(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramInt);
    localByteArrayOutputStream.write(paramInputStream);
    return localByteArrayOutputStream.toInputStream();
  }
  
  public void close()
    throws IOException
  {}
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield 107	org/apache/commons/io/output/ByteArrayOutputStream:count	I
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield 70	org/apache/commons/io/output/ByteArrayOutputStream:filledBufferSum	I
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield 62	org/apache/commons/io/output/ByteArrayOutputStream:currentBufferIndex	I
    //   17: aload_0
    //   18: getfield 36	org/apache/commons/io/output/ByteArrayOutputStream:reuseBuffers	Z
    //   21: ifeq +26 -> 47
    //   24: aload_0
    //   25: aload_0
    //   26: getfield 34	org/apache/commons/io/output/ByteArrayOutputStream:buffers	Ljava/util/List;
    //   29: aload_0
    //   30: getfield 62	org/apache/commons/io/output/ByteArrayOutputStream:currentBufferIndex	I
    //   33: invokeinterface 76 2 0
    //   38: checkcast 77	[B
    //   41: putfield 72	org/apache/commons/io/output/ByteArrayOutputStream:currentBuffer	[B
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield 72	org/apache/commons/io/output/ByteArrayOutputStream:currentBuffer	[B
    //   52: aload_0
    //   53: getfield 34	org/apache/commons/io/output/ByteArrayOutputStream:buffers	Ljava/util/List;
    //   56: iconst_0
    //   57: invokeinterface 76 2 0
    //   62: checkcast 77	[B
    //   65: arraylength
    //   66: istore_1
    //   67: aload_0
    //   68: getfield 34	org/apache/commons/io/output/ByteArrayOutputStream:buffers	Ljava/util/List;
    //   71: invokeinterface 110 1 0
    //   76: aload_0
    //   77: iload_1
    //   78: invokespecial 60	org/apache/commons/io/output/ByteArrayOutputStream:needNewBuffer	(I)V
    //   81: aload_0
    //   82: iconst_1
    //   83: putfield 36	org/apache/commons/io/output/ByteArrayOutputStream:reuseBuffers	Z
    //   86: goto -42 -> 44
    //   89: astore_2
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	ByteArrayOutputStream
    //   66	12	1	i	int
    //   89	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	44	89	finally
    //   47	86	89	finally
  }
  
  public int size()
  {
    try
    {
      int i = this.count;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public byte[] toByteArray()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 107	org/apache/commons/io/output/ByteArrayOutputStream:count	I
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +13 -> 21
    //   11: getstatic 22	org/apache/commons/io/output/ByteArrayOutputStream:EMPTY_BYTE_ARRAY	[B
    //   14: astore 4
    //   16: aload_0
    //   17: monitorexit
    //   18: aload 4
    //   20: areturn
    //   21: iload_2
    //   22: newarray byte
    //   24: astore 4
    //   26: aload_0
    //   27: getfield 34	org/apache/commons/io/output/ByteArrayOutputStream:buffers	Ljava/util/List;
    //   30: invokeinterface 116 1 0
    //   35: astore 5
    //   37: iconst_0
    //   38: istore_1
    //   39: aload 5
    //   41: invokeinterface 122 1 0
    //   46: ifeq +41 -> 87
    //   49: aload 5
    //   51: invokeinterface 126 1 0
    //   56: checkcast 77	[B
    //   59: astore 6
    //   61: aload 6
    //   63: arraylength
    //   64: iload_2
    //   65: invokestatic 129	java/lang/Math:min	(II)I
    //   68: istore_3
    //   69: aload 6
    //   71: iconst_0
    //   72: aload 4
    //   74: iload_1
    //   75: iload_3
    //   76: invokestatic 135	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   79: iload_2
    //   80: iload_3
    //   81: isub
    //   82: istore_2
    //   83: iload_2
    //   84: ifne +6 -> 90
    //   87: goto -71 -> 16
    //   90: iload_1
    //   91: iload_3
    //   92: iadd
    //   93: istore_1
    //   94: goto -55 -> 39
    //   97: astore 4
    //   99: aload_0
    //   100: monitorexit
    //   101: aload 4
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	ByteArrayOutputStream
    //   38	56	1	i	int
    //   6	78	2	j	int
    //   68	25	3	k	int
    //   14	59	4	arrayOfByte1	byte[]
    //   97	5	4	localObject	Object
    //   35	15	5	localIterator	Iterator
    //   59	11	6	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   2	7	97	finally
    //   11	16	97	finally
    //   21	37	97	finally
    //   39	79	97	finally
  }
  
  public InputStream toInputStream()
  {
    try
    {
      int i = this.count;
      if (i == 0)
      {
        localObject1 = new ClosedInputStream();
        return localObject1;
      }
      Object localObject1 = new ArrayList(this.buffers.size());
      Iterator localIterator = this.buffers.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          byte[] arrayOfByte = (byte[])localIterator.next();
          int j = Math.min(arrayOfByte.length, i);
          ((List)localObject1).add(new ByteArrayInputStream(arrayOfByte, 0, j));
          i -= j;
          if (i != 0) {}
        }
        else
        {
          this.reuseBuffers = false;
          localObject1 = new SequenceInputStream(Collections.enumeration((Collection)localObject1));
          break;
        }
      }
    }
    finally {}
  }
  
  @Deprecated
  public String toString()
  {
    return new String(toByteArray(), Charset.defaultCharset());
  }
  
  public String toString(String paramString)
    throws UnsupportedEncodingException
  {
    return new String(toByteArray(), paramString);
  }
  
  public String toString(Charset paramCharset)
  {
    return new String(toByteArray(), paramCharset);
  }
  
  public int write(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      int j = this.count - this.filledBufferSum;
      int i = paramInputStream.read(this.currentBuffer, j, this.currentBuffer.length - j);
      int m;
      for (int k = 0; i != -1; k = m)
      {
        m = k + i;
        j += i;
        this.count = (i + this.count);
        i = j;
        if (j == this.currentBuffer.length)
        {
          needNewBuffer(this.currentBuffer.length);
          i = 0;
        }
        k = paramInputStream.read(this.currentBuffer, i, this.currentBuffer.length - i);
        j = i;
        i = k;
      }
      return k;
    }
    finally {}
  }
  
  public void write(int paramInt)
  {
    try
    {
      int j = this.count - this.filledBufferSum;
      int i = j;
      if (j == this.currentBuffer.length)
      {
        needNewBuffer(this.count + 1);
        i = 0;
      }
      this.currentBuffer[i] = ((byte)paramInt);
      this.count += 1;
      return;
    }
    finally {}
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramArrayOfByte.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length) || (paramInt1 + paramInt2 < 0)) {
      throw new IndexOutOfBoundsException();
    }
    if (paramInt2 == 0) {
      return;
    }
    try
    {
      int m = this.count + paramInt2;
      int j = this.count - this.filledBufferSum;
      int i = paramInt2;
      while (i > 0)
      {
        int k = Math.min(i, this.currentBuffer.length - j);
        System.arraycopy(paramArrayOfByte, paramInt1 + paramInt2 - i, this.currentBuffer, j, k);
        k = i - k;
        i = k;
        if (k > 0)
        {
          needNewBuffer(m);
          j = 0;
          i = k;
        }
      }
      this.count = m;
      return;
    }
    finally {}
  }
  
  /* Error */
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 107	org/apache/commons/io/output/ByteArrayOutputStream:count	I
    //   6: istore_2
    //   7: aload_0
    //   8: getfield 34	org/apache/commons/io/output/ByteArrayOutputStream:buffers	Ljava/util/List;
    //   11: invokeinterface 116 1 0
    //   16: astore 4
    //   18: aload 4
    //   20: invokeinterface 122 1 0
    //   25: ifeq +39 -> 64
    //   28: aload 4
    //   30: invokeinterface 126 1 0
    //   35: checkcast 77	[B
    //   38: astore 5
    //   40: aload 5
    //   42: arraylength
    //   43: iload_2
    //   44: invokestatic 129	java/lang/Math:min	(II)I
    //   47: istore_3
    //   48: aload_1
    //   49: aload 5
    //   51: iconst_0
    //   52: iload_3
    //   53: invokevirtual 190	java/io/OutputStream:write	([BII)V
    //   56: iload_2
    //   57: iload_3
    //   58: isub
    //   59: istore_2
    //   60: iload_2
    //   61: ifne +6 -> 67
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: goto -49 -> 18
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	ByteArrayOutputStream
    //   0	75	1	paramOutputStream	OutputStream
    //   6	55	2	i	int
    //   47	12	3	j	int
    //   16	13	4	localIterator	Iterator
    //   38	12	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   2	18	70	finally
    //   18	56	70	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.output.ByteArrayOutputStream
 * JD-Core Version:    0.7.0.1
 */