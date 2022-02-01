package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;

@Beta
@GwtIncompatible
public final class ByteStreams
{
  private static final OutputStream NULL_OUTPUT_STREAM = new ByteStreams.1();
  private static final int ZERO_COPY_CHUNK_SIZE = 524288;
  
  @CanIgnoreReturnValue
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramOutputStream);
    byte[] arrayOfByte = createBuffer();
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        return l;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  @CanIgnoreReturnValue
  public static long copy(ReadableByteChannel paramReadableByteChannel, WritableByteChannel paramWritableByteChannel)
    throws IOException
  {
    Preconditions.checkNotNull(paramReadableByteChannel);
    Preconditions.checkNotNull(paramWritableByteChannel);
    long l2;
    if ((paramReadableByteChannel instanceof FileChannel))
    {
      paramReadableByteChannel = (FileChannel)paramReadableByteChannel;
      l2 = paramReadableByteChannel.position();
      l1 = l2;
      long l3;
      do
      {
        long l4;
        do
        {
          l4 = paramReadableByteChannel.transferTo(l1, 524288L, paramWritableByteChannel);
          l3 = l1 + l4;
          paramReadableByteChannel.position(l3);
          l1 = l3;
        } while (l4 > 0L);
        l1 = l3;
      } while (l3 < paramReadableByteChannel.size());
      l2 = l3 - l2;
      return l2;
    }
    ByteBuffer localByteBuffer = ByteBuffer.wrap(createBuffer());
    long l1 = 0L;
    for (;;)
    {
      l2 = l1;
      if (paramReadableByteChannel.read(localByteBuffer) == -1) {
        break;
      }
      localByteBuffer.flip();
      while (localByteBuffer.hasRemaining()) {
        l1 += paramWritableByteChannel.write(localByteBuffer);
      }
      localByteBuffer.clear();
    }
  }
  
  static byte[] createBuffer()
  {
    return new byte[8192];
  }
  
  @CanIgnoreReturnValue
  public static long exhaust(InputStream paramInputStream)
    throws IOException
  {
    long l1 = 0L;
    byte[] arrayOfByte = createBuffer();
    for (;;)
    {
      long l2 = paramInputStream.read(arrayOfByte);
      if (l2 == -1L) {
        break;
      }
      l1 += l2;
    }
    return l1;
  }
  
  public static InputStream limit(InputStream paramInputStream, long paramLong)
  {
    return new LimitedInputStream(paramInputStream, paramLong);
  }
  
  public static ByteArrayDataInput newDataInput(ByteArrayInputStream paramByteArrayInputStream)
  {
    return new ByteArrayDataInputStream((ByteArrayInputStream)Preconditions.checkNotNull(paramByteArrayInputStream));
  }
  
  public static ByteArrayDataInput newDataInput(byte[] paramArrayOfByte)
  {
    return newDataInput(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public static ByteArrayDataInput newDataInput(byte[] paramArrayOfByte, int paramInt)
  {
    Preconditions.checkPositionIndex(paramInt, paramArrayOfByte.length);
    return newDataInput(new ByteArrayInputStream(paramArrayOfByte, paramInt, paramArrayOfByte.length - paramInt));
  }
  
  public static ByteArrayDataOutput newDataOutput()
  {
    return newDataOutput(new ByteArrayOutputStream());
  }
  
  public static ByteArrayDataOutput newDataOutput(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException(String.format("Invalid size: %s", new Object[] { Integer.valueOf(paramInt) }));
    }
    return newDataOutput(new ByteArrayOutputStream(paramInt));
  }
  
  public static ByteArrayDataOutput newDataOutput(ByteArrayOutputStream paramByteArrayOutputStream)
  {
    return new ByteArrayDataOutputStream((ByteArrayOutputStream)Preconditions.checkNotNull(paramByteArrayOutputStream));
  }
  
  public static OutputStream nullOutputStream()
  {
    return NULL_OUTPUT_STREAM;
  }
  
  @CanIgnoreReturnValue
  public static int read(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramArrayOfByte);
    if (paramInt2 < 0) {
      throw new IndexOutOfBoundsException("len is negative");
    }
    int i = 0;
    for (;;)
    {
      int j;
      if (i < paramInt2)
      {
        j = paramInputStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
        if (j != -1) {}
      }
      else
      {
        return i;
      }
      i += j;
    }
  }
  
  @CanIgnoreReturnValue
  public static <T> T readBytes(InputStream paramInputStream, ByteProcessor<T> paramByteProcessor)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramByteProcessor);
    byte[] arrayOfByte = createBuffer();
    int i;
    do
    {
      i = paramInputStream.read(arrayOfByte);
    } while ((i != -1) && (paramByteProcessor.processBytes(arrayOfByte, 0, i)));
    return paramByteProcessor.getResult();
  }
  
  public static void readFully(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    readFully(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static void readFully(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 = read(paramInputStream, paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != paramInt2) {
      throw new EOFException("reached end of stream after reading " + paramInt1 + " bytes; " + paramInt2 + " bytes expected");
    }
  }
  
  public static void skipFully(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    long l = skipUpTo(paramInputStream, paramLong);
    if (l < paramLong) {
      throw new EOFException("reached end of stream after skipping " + l + " bytes; " + paramLong + " bytes expected");
    }
  }
  
  private static long skipSafely(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    int i = paramInputStream.available();
    if (i == 0) {
      return 0L;
    }
    return paramInputStream.skip(Math.min(i, paramLong));
  }
  
  static long skipUpTo(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    byte[] arrayOfByte = createBuffer();
    long l2;
    for (long l1 = 0L;; l1 = l2 + l1) {
      if (l1 < paramLong)
      {
        long l4 = paramLong - l1;
        long l3 = skipSafely(paramInputStream, l4);
        l2 = l3;
        if (l3 == 0L)
        {
          l3 = paramInputStream.read(arrayOfByte, 0, (int)Math.min(l4, arrayOfByte.length));
          l2 = l3;
          if (l3 != -1L) {}
        }
      }
      else
      {
        return l1;
      }
    }
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(Math.max(32, paramInputStream.available()));
    copy(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  static byte[] toByteArray(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = paramInt;
    int k;
    if (i > 0)
    {
      int j = paramInt - i;
      k = paramInputStream.read(arrayOfByte, j, i);
      if (k == -1) {
        localObject = Arrays.copyOf(arrayOfByte, j);
      }
    }
    do
    {
      return localObject;
      i -= k;
      break;
      paramInt = paramInputStream.read();
      localObject = arrayOfByte;
    } while (paramInt == -1);
    Object localObject = new FastByteArrayOutputStream(null);
    ((FastByteArrayOutputStream)localObject).write(paramInt);
    copy(paramInputStream, (OutputStream)localObject);
    paramInputStream = new byte[arrayOfByte.length + ((FastByteArrayOutputStream)localObject).size()];
    System.arraycopy(arrayOfByte, 0, paramInputStream, 0, arrayOfByte.length);
    ((FastByteArrayOutputStream)localObject).writeTo(paramInputStream, arrayOfByte.length);
    return paramInputStream;
  }
  
  static class ByteArrayDataInputStream
    implements ByteArrayDataInput
  {
    final DataInput input;
    
    ByteArrayDataInputStream(ByteArrayInputStream paramByteArrayInputStream)
    {
      this.input = new DataInputStream(paramByteArrayInputStream);
    }
    
    public boolean readBoolean()
    {
      try
      {
        boolean bool = this.input.readBoolean();
        return bool;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public byte readByte()
    {
      try
      {
        byte b = this.input.readByte();
        return b;
      }
      catch (EOFException localEOFException)
      {
        throw new IllegalStateException(localEOFException);
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public char readChar()
    {
      try
      {
        char c = this.input.readChar();
        return c;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public double readDouble()
    {
      try
      {
        double d = this.input.readDouble();
        return d;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public float readFloat()
    {
      try
      {
        float f = this.input.readFloat();
        return f;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public void readFully(byte[] paramArrayOfByte)
    {
      try
      {
        this.input.readFully(paramArrayOfByte);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new IllegalStateException(paramArrayOfByte);
      }
    }
    
    public void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      try
      {
        this.input.readFully(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new IllegalStateException(paramArrayOfByte);
      }
    }
    
    public int readInt()
    {
      try
      {
        int i = this.input.readInt();
        return i;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public String readLine()
    {
      try
      {
        String str = this.input.readLine();
        return str;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public long readLong()
    {
      try
      {
        long l = this.input.readLong();
        return l;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public short readShort()
    {
      try
      {
        short s = this.input.readShort();
        return s;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public String readUTF()
    {
      try
      {
        String str = this.input.readUTF();
        return str;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public int readUnsignedByte()
    {
      try
      {
        int i = this.input.readUnsignedByte();
        return i;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public int readUnsignedShort()
    {
      try
      {
        int i = this.input.readUnsignedShort();
        return i;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public int skipBytes(int paramInt)
    {
      try
      {
        paramInt = this.input.skipBytes(paramInt);
        return paramInt;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
  }
  
  static class ByteArrayDataOutputStream
    implements ByteArrayDataOutput
  {
    final ByteArrayOutputStream byteArrayOutputSteam;
    final DataOutput output;
    
    ByteArrayDataOutputStream(ByteArrayOutputStream paramByteArrayOutputStream)
    {
      this.byteArrayOutputSteam = paramByteArrayOutputStream;
      this.output = new DataOutputStream(paramByteArrayOutputStream);
    }
    
    public byte[] toByteArray()
    {
      return this.byteArrayOutputSteam.toByteArray();
    }
    
    public void write(int paramInt)
    {
      try
      {
        this.output.write(paramInt);
        return;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public void write(byte[] paramArrayOfByte)
    {
      try
      {
        this.output.write(paramArrayOfByte);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new AssertionError(paramArrayOfByte);
      }
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      try
      {
        this.output.write(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new AssertionError(paramArrayOfByte);
      }
    }
    
    public void writeBoolean(boolean paramBoolean)
    {
      try
      {
        this.output.writeBoolean(paramBoolean);
        return;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public void writeByte(int paramInt)
    {
      try
      {
        this.output.writeByte(paramInt);
        return;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public void writeBytes(String paramString)
    {
      try
      {
        this.output.writeBytes(paramString);
        return;
      }
      catch (IOException paramString)
      {
        throw new AssertionError(paramString);
      }
    }
    
    public void writeChar(int paramInt)
    {
      try
      {
        this.output.writeChar(paramInt);
        return;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public void writeChars(String paramString)
    {
      try
      {
        this.output.writeChars(paramString);
        return;
      }
      catch (IOException paramString)
      {
        throw new AssertionError(paramString);
      }
    }
    
    public void writeDouble(double paramDouble)
    {
      try
      {
        this.output.writeDouble(paramDouble);
        return;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public void writeFloat(float paramFloat)
    {
      try
      {
        this.output.writeFloat(paramFloat);
        return;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public void writeInt(int paramInt)
    {
      try
      {
        this.output.writeInt(paramInt);
        return;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public void writeLong(long paramLong)
    {
      try
      {
        this.output.writeLong(paramLong);
        return;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public void writeShort(int paramInt)
    {
      try
      {
        this.output.writeShort(paramInt);
        return;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public void writeUTF(String paramString)
    {
      try
      {
        this.output.writeUTF(paramString);
        return;
      }
      catch (IOException paramString)
      {
        throw new AssertionError(paramString);
      }
    }
  }
  
  static final class FastByteArrayOutputStream
    extends ByteArrayOutputStream
  {
    void writeTo(byte[] paramArrayOfByte, int paramInt)
    {
      System.arraycopy(this.buf, 0, paramArrayOfByte, paramInt, this.count);
    }
  }
  
  static final class LimitedInputStream
    extends FilterInputStream
  {
    private long left;
    private long mark = -1L;
    
    LimitedInputStream(InputStream paramInputStream, long paramLong)
    {
      super();
      Preconditions.checkNotNull(paramInputStream);
      if (paramLong >= 0L) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "limit must be non-negative");
        this.left = paramLong;
        return;
      }
    }
    
    public int available()
      throws IOException
    {
      return (int)Math.min(this.in.available(), this.left);
    }
    
    public void mark(int paramInt)
    {
      try
      {
        this.in.mark(paramInt);
        this.mark = this.left;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public int read()
      throws IOException
    {
      if (this.left == 0L) {
        return -1;
      }
      int i = this.in.read();
      if (i != -1) {
        this.left -= 1L;
      }
      return i;
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if (this.left == 0L) {
        return -1;
      }
      paramInt2 = (int)Math.min(paramInt2, this.left);
      paramInt1 = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        this.left -= paramInt1;
      }
      return paramInt1;
    }
    
    public void reset()
      throws IOException
    {
      try
      {
        if (!this.in.markSupported()) {
          throw new IOException("Mark not supported");
        }
      }
      finally {}
      if (this.mark == -1L) {
        throw new IOException("Mark not set");
      }
      this.in.reset();
      this.left = this.mark;
    }
    
    public long skip(long paramLong)
      throws IOException
    {
      paramLong = Math.min(paramLong, this.left);
      paramLong = this.in.skip(paramLong);
      this.left -= paramLong;
      return paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.ByteStreams
 * JD-Core Version:    0.7.0.1
 */