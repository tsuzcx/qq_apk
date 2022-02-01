package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Beta
@GwtIncompatible
public final class LittleEndianDataInputStream
  extends FilterInputStream
  implements DataInput
{
  public LittleEndianDataInputStream(InputStream paramInputStream)
  {
    super((InputStream)Preconditions.checkNotNull(paramInputStream));
  }
  
  private byte readAndCheckByte()
    throws IOException, EOFException
  {
    int i = this.in.read();
    if (-1 == i) {
      throw new EOFException();
    }
    return (byte)i;
  }
  
  @CanIgnoreReturnValue
  public boolean readBoolean()
    throws IOException
  {
    return readUnsignedByte() != 0;
  }
  
  @CanIgnoreReturnValue
  public byte readByte()
    throws IOException
  {
    return (byte)readUnsignedByte();
  }
  
  @CanIgnoreReturnValue
  public char readChar()
    throws IOException
  {
    return (char)readUnsignedShort();
  }
  
  @CanIgnoreReturnValue
  public double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(readLong());
  }
  
  @CanIgnoreReturnValue
  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(readInt());
  }
  
  public void readFully(byte[] paramArrayOfByte)
    throws IOException
  {
    ByteStreams.readFully(this, paramArrayOfByte);
  }
  
  public void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    ByteStreams.readFully(this, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  @CanIgnoreReturnValue
  public int readInt()
    throws IOException
  {
    byte b1 = readAndCheckByte();
    byte b2 = readAndCheckByte();
    byte b3 = readAndCheckByte();
    return Ints.fromBytes(readAndCheckByte(), b3, b2, b1);
  }
  
  @CanIgnoreReturnValue
  public String readLine()
  {
    throw new UnsupportedOperationException("readLine is not supported");
  }
  
  @CanIgnoreReturnValue
  public long readLong()
    throws IOException
  {
    byte b1 = readAndCheckByte();
    byte b2 = readAndCheckByte();
    byte b3 = readAndCheckByte();
    byte b4 = readAndCheckByte();
    byte b5 = readAndCheckByte();
    byte b6 = readAndCheckByte();
    byte b7 = readAndCheckByte();
    return Longs.fromBytes(readAndCheckByte(), b7, b6, b5, b4, b3, b2, b1);
  }
  
  @CanIgnoreReturnValue
  public short readShort()
    throws IOException
  {
    return (short)readUnsignedShort();
  }
  
  @CanIgnoreReturnValue
  public String readUTF()
    throws IOException
  {
    return new DataInputStream(this.in).readUTF();
  }
  
  @CanIgnoreReturnValue
  public int readUnsignedByte()
    throws IOException
  {
    int i = this.in.read();
    if (i < 0) {
      throw new EOFException();
    }
    return i;
  }
  
  @CanIgnoreReturnValue
  public int readUnsignedShort()
    throws IOException
  {
    byte b = readAndCheckByte();
    return Ints.fromBytes((byte)0, (byte)0, readAndCheckByte(), b);
  }
  
  public int skipBytes(int paramInt)
    throws IOException
  {
    return (int)this.in.skip(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.LittleEndianDataInputStream
 * JD-Core Version:    0.7.0.1
 */