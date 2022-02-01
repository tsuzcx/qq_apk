package net.jarlehansen.protobuf.original.output;

import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import net.jarlehansen.protobuf.original.WireFormat;

public final class CodedOutputStream
{
  private static final int LITTLE_ENDIAN_32_SIZE = 4;
  public static final int LITTLE_ENDIAN_64_SIZE = 8;
  private final byte[] buffer;
  private final int limit;
  private int position;
  
  private CodedOutputStream(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.position = paramInt1;
    this.limit = (paramInt1 + paramInt2);
  }
  
  public static int computeBoolSize(int paramInt, boolean paramBoolean)
  {
    return computeTagSize(paramInt) + 1;
  }
  
  public static int computeBytesSize(int paramInt, ByteString paramByteString)
  {
    if (paramByteString == null) {
      return 0;
    }
    return computeTagSize(paramInt) + computeRawVarint32Size(paramByteString.size()) + paramByteString.size();
  }
  
  public static int computeDoubleSize(int paramInt, double paramDouble)
  {
    return computeTagSize(paramInt) + 8;
  }
  
  public static int computeFloatSize(int paramInt, float paramFloat)
  {
    return computeTagSize(paramInt) + 4;
  }
  
  public static int computeInt32Size(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0) {
      return computeTagSize(paramInt1) + computeRawVarint32Size(paramInt2);
    }
    return computeTagSize(paramInt1) + 10;
  }
  
  public static int computeInt64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeRawVarint64Size(paramLong);
  }
  
  public static int computeRawVarint32Size(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xFFFFC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int computeRawVarint64Size(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0x0 & paramLong) == 0L) {
      return 5;
    }
    if ((0x0 & paramLong) == 0L) {
      return 6;
    }
    if ((0x0 & paramLong) == 0L) {
      return 7;
    }
    if ((0x0 & paramLong) == 0L) {
      return 8;
    }
    if ((0x0 & paramLong) == 0L) {
      return 9;
    }
    return 10;
  }
  
  public static int computeStringSize(int paramInt, String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      paramInt = computeTagSize(paramInt);
      int i = computeRawVarint32Size(paramString.length);
      int j = paramString.length;
      return j + (paramInt + i);
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException("UTF-8 not supported.");
    }
  }
  
  public static int computeTagSize(int paramInt)
  {
    return computeRawVarint32Size(WireFormat.makeTag(paramInt, 0));
  }
  
  public static CodedOutputStream newInstance(byte[] paramArrayOfByte)
  {
    return newInstance(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private static CodedOutputStream newInstance(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new CodedOutputStream(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private int spaceLeft()
  {
    return this.limit - this.position;
  }
  
  private void writeRawByte(byte paramByte)
    throws IOException
  {
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  private void writeRawByte(int paramInt)
    throws IOException
  {
    writeRawByte((byte)paramInt);
  }
  
  private void writeRawBytes(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte == null) {
      return;
    }
    writeRawBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private void writeRawBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramArrayOfByte == null) {}
    int i;
    do
    {
      return;
      if (this.limit - this.position >= paramInt2)
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, paramInt2);
        this.position += paramInt2;
        return;
      }
      i = this.limit - this.position;
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, i);
      paramInt2 -= i;
      this.position = this.limit;
    } while (paramInt2 > this.limit);
    System.arraycopy(paramArrayOfByte, paramInt1 + i, this.buffer, 0, paramInt2);
    this.position = paramInt2;
  }
  
  private void writeRawLittleEndian32(int paramInt)
    throws IOException
  {
    writeRawByte(paramInt & 0xFF);
    writeRawByte(paramInt >> 8 & 0xFF);
    writeRawByte(paramInt >> 16 & 0xFF);
    writeRawByte(paramInt >> 24 & 0xFF);
  }
  
  private void writeRawLittleEndian64(long paramLong)
    throws IOException
  {
    writeRawByte((int)paramLong & 0xFF);
    writeRawByte((int)(paramLong >> 8) & 0xFF);
    writeRawByte((int)(paramLong >> 16) & 0xFF);
    writeRawByte((int)(paramLong >> 24) & 0xFF);
    writeRawByte((int)(paramLong >> 32) & 0xFF);
    writeRawByte((int)(paramLong >> 40) & 0xFF);
    writeRawByte((int)(paramLong >> 48) & 0xFF);
    writeRawByte((int)(paramLong >> 56) & 0xFF);
  }
  
  void checkNoSpaceLeft()
  {
    if (spaceLeft() != 0) {
      throw new IllegalStateException("Did not write as much data as expected. Space left: " + spaceLeft());
    }
  }
  
  public void writeBool(int paramInt, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    writeTag(paramInt, 0);
    paramInt = i;
    if (paramBoolean) {
      paramInt = 1;
    }
    writeRawByte(paramInt);
  }
  
  public void writeBytes(int paramInt, ByteString paramByteString)
    throws IOException
  {
    if (paramByteString == null) {
      return;
    }
    writeTag(paramInt, 2);
    paramByteString = paramByteString.toByteArray();
    writeRawVarint32(paramByteString.length);
    writeRawBytes(paramByteString);
  }
  
  public void writeDelimitedSize(int paramInt)
    throws IOException
  {
    writeRawVarint32(paramInt);
  }
  
  public void writeDouble(int paramInt, double paramDouble)
    throws IOException
  {
    writeTag(paramInt, 1);
    writeRawLittleEndian64(Double.doubleToLongBits(paramDouble));
  }
  
  public void writeFloat(int paramInt, float paramFloat)
    throws IOException
  {
    writeTag(paramInt, 5);
    writeRawLittleEndian32(Float.floatToIntBits(paramFloat));
  }
  
  public void writeInt32(int paramInt1, int paramInt2)
    throws IOException
  {
    writeTag(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      writeRawVarint32(paramInt2);
      return;
    }
    writeRawVarint64(paramInt2);
  }
  
  public void writeInt64(int paramInt, long paramLong)
    throws IOException
  {
    writeTag(paramInt, 0);
    writeRawVarint64(paramLong);
  }
  
  public void writeMessage(int paramInt1, int paramInt2)
    throws IOException
  {
    writeTag(paramInt1, 2);
    writeRawVarint32(paramInt2);
  }
  
  public void writeRawVarint32(int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        writeRawByte(paramInt);
        return;
      }
      writeRawByte(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public void writeRawVarint64(long paramLong)
    throws IOException
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        writeRawByte((int)paramLong);
        return;
      }
      writeRawByte((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public void writeString(int paramInt, String paramString)
    throws IOException
  {
    if (paramString == null) {
      return;
    }
    writeTag(paramInt, 2);
    paramString = paramString.getBytes("UTF-8");
    writeRawVarint32(paramString.length);
    writeRawBytes(paramString);
  }
  
  public void writeTag(int paramInt1, int paramInt2)
    throws IOException
  {
    writeRawVarint32(WireFormat.makeTag(paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.jarlehansen.protobuf.original.output.CodedOutputStream
 * JD-Core Version:    0.7.0.1
 */