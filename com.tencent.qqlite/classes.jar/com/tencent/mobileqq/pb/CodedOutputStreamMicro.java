package com.tencent.mobileqq.pb;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class CodedOutputStreamMicro
{
  public static final int DEFAULT_BUFFER_SIZE = 4096;
  public static final int LITTLE_ENDIAN_32_SIZE = 4;
  public static final int LITTLE_ENDIAN_64_SIZE = 8;
  private final byte[] buffer;
  private final int limit;
  private final OutputStream output;
  private int position;
  
  private CodedOutputStreamMicro(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    this.output = paramOutputStream;
    this.buffer = paramArrayOfByte;
    this.position = 0;
    this.limit = paramArrayOfByte.length;
  }
  
  private CodedOutputStreamMicro(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.output = null;
    this.buffer = paramArrayOfByte;
    this.position = paramInt1;
    this.limit = (paramInt1 + paramInt2);
  }
  
  public static int computeBoolSize(int paramInt, boolean paramBoolean)
  {
    return computeTagSize(paramInt) + computeBoolSizeNoTag(paramBoolean);
  }
  
  public static int computeBoolSizeNoTag(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int computeByteArraySize(int paramInt, byte[] paramArrayOfByte)
  {
    return computeTagSize(paramInt) + computeByteArraySizeNoTag(paramArrayOfByte);
  }
  
  public static int computeByteArraySizeNoTag(byte[] paramArrayOfByte)
  {
    return computeRawVarint32Size(paramArrayOfByte.length) + paramArrayOfByte.length;
  }
  
  public static int computeBytesSize(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    return computeTagSize(paramInt) + computeBytesSizeNoTag(paramByteStringMicro);
  }
  
  public static int computeBytesSizeNoTag(ByteStringMicro paramByteStringMicro)
  {
    return computeRawVarint32Size(paramByteStringMicro.size()) + paramByteStringMicro.size();
  }
  
  public static int computeDoubleSize(int paramInt, double paramDouble)
  {
    return computeTagSize(paramInt) + computeDoubleSizeNoTag(paramDouble);
  }
  
  public static int computeDoubleSizeNoTag(double paramDouble)
  {
    return 8;
  }
  
  public static int computeEnumSize(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeEnumSizeNoTag(paramInt2);
  }
  
  public static int computeEnumSizeNoTag(int paramInt)
  {
    return computeRawVarint32Size(paramInt);
  }
  
  public static int computeFixed32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeFixed32SizeNoTag(paramInt2);
  }
  
  public static int computeFixed32SizeNoTag(int paramInt)
  {
    return 4;
  }
  
  public static int computeFixed64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeFixed64SizeNoTag(paramLong);
  }
  
  public static int computeFixed64SizeNoTag(long paramLong)
  {
    return 8;
  }
  
  public static int computeFloatSize(int paramInt, float paramFloat)
  {
    return computeTagSize(paramInt) + computeFloatSizeNoTag(paramFloat);
  }
  
  public static int computeFloatSizeNoTag(float paramFloat)
  {
    return 4;
  }
  
  public static int computeGroupSize(int paramInt, MessageMicro<?> paramMessageMicro)
  {
    return computeTagSize(paramInt) * 2 + computeGroupSizeNoTag(paramMessageMicro);
  }
  
  public static int computeGroupSizeNoTag(MessageMicro<?> paramMessageMicro)
  {
    return paramMessageMicro.getCachedSize();
  }
  
  public static int computeInt32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeInt32SizeNoTag(paramInt2);
  }
  
  public static int computeInt32SizeNoTag(int paramInt)
  {
    if (paramInt >= 0) {
      return computeRawVarint32Size(paramInt);
    }
    return 10;
  }
  
  public static int computeInt64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeInt64SizeNoTag(paramLong);
  }
  
  public static int computeInt64SizeNoTag(long paramLong)
  {
    return computeRawVarint64Size(paramLong);
  }
  
  public static int computeMessageSize(int paramInt, MessageMicro<?> paramMessageMicro)
  {
    return computeTagSize(paramInt) + computeMessageSizeNoTag(paramMessageMicro);
  }
  
  public static int computeMessageSizeNoTag(MessageMicro<?> paramMessageMicro)
  {
    int i = paramMessageMicro.getCachedSize();
    return i + computeRawVarint32Size(i);
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
  
  public static int computeSFixed32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeSFixed32SizeNoTag(paramInt2);
  }
  
  public static int computeSFixed32SizeNoTag(int paramInt)
  {
    return 4;
  }
  
  public static int computeSFixed64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeSFixed64SizeNoTag(paramLong);
  }
  
  public static int computeSFixed64SizeNoTag(long paramLong)
  {
    return 8;
  }
  
  public static int computeSInt32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeSInt32SizeNoTag(paramInt2);
  }
  
  public static int computeSInt32SizeNoTag(int paramInt)
  {
    return computeRawVarint32Size(encodeZigZag32(paramInt));
  }
  
  public static int computeSInt64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeSInt64SizeNoTag(paramLong);
  }
  
  public static int computeSInt64SizeNoTag(long paramLong)
  {
    return computeRawVarint64Size(encodeZigZag64(paramLong));
  }
  
  public static int computeStringSize(int paramInt, String paramString)
  {
    return computeTagSize(paramInt) + computeStringSizeNoTag(paramString);
  }
  
  public static int computeStringSizeNoTag(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = computeRawVarint32Size(paramString.length);
      int j = paramString.length;
      return j + i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.");
    }
  }
  
  public static int computeTagSize(int paramInt)
  {
    return computeRawVarint32Size(WireFormatMicro.makeTag(paramInt, 0));
  }
  
  public static int computeUInt32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeUInt32SizeNoTag(paramInt2);
  }
  
  public static int computeUInt32SizeNoTag(int paramInt)
  {
    return computeRawVarint32Size(paramInt);
  }
  
  public static int computeUInt64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeUInt64SizeNoTag(paramLong);
  }
  
  public static int computeUInt64SizeNoTag(long paramLong)
  {
    return computeRawVarint64Size(paramLong);
  }
  
  public static int encodeZigZag32(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public static long encodeZigZag64(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static CodedOutputStreamMicro newInstance(OutputStream paramOutputStream)
  {
    return newInstance(paramOutputStream, 4096);
  }
  
  public static CodedOutputStreamMicro newInstance(OutputStream paramOutputStream, int paramInt)
  {
    return new CodedOutputStreamMicro(paramOutputStream, new byte[paramInt]);
  }
  
  public static CodedOutputStreamMicro newInstance(byte[] paramArrayOfByte)
  {
    return newInstance(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static CodedOutputStreamMicro newInstance(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new CodedOutputStreamMicro(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private void refreshBuffer()
    throws IOException
  {
    if (this.output == null) {
      throw new OutOfSpaceException();
    }
    this.output.write(this.buffer, 0, this.position);
    this.position = 0;
  }
  
  public void checkNoSpaceLeft()
  {
    if (spaceLeft() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public void flush()
    throws IOException
  {
    if (this.output != null) {
      refreshBuffer();
    }
  }
  
  public int spaceLeft()
  {
    if (this.output == null) {
      return this.limit - this.position;
    }
    throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
  }
  
  public void writeBool(int paramInt, boolean paramBoolean)
    throws IOException
  {
    writeTag(paramInt, 0);
    writeBoolNoTag(paramBoolean);
  }
  
  public void writeBoolNoTag(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      writeRawByte(i);
      return;
    }
  }
  
  public void writeByteArray(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    writeTag(paramInt, 2);
    writeByteArrayNoTag(paramArrayOfByte);
  }
  
  public void writeByteArrayNoTag(byte[] paramArrayOfByte)
    throws IOException
  {
    writeRawVarint32(paramArrayOfByte.length);
    writeRawBytes(paramArrayOfByte);
  }
  
  public void writeBytes(int paramInt, ByteStringMicro paramByteStringMicro)
    throws IOException
  {
    writeTag(paramInt, 2);
    writeBytesNoTag(paramByteStringMicro);
  }
  
  public void writeBytesNoTag(ByteStringMicro paramByteStringMicro)
    throws IOException
  {
    paramByteStringMicro = paramByteStringMicro.toByteArray();
    writeRawVarint32(paramByteStringMicro.length);
    writeRawBytes(paramByteStringMicro);
  }
  
  public void writeDouble(int paramInt, double paramDouble)
    throws IOException
  {
    writeTag(paramInt, 1);
    writeDoubleNoTag(paramDouble);
  }
  
  public void writeDoubleNoTag(double paramDouble)
    throws IOException
  {
    writeRawLittleEndian64(Double.doubleToLongBits(paramDouble));
  }
  
  public void writeEnum(int paramInt1, int paramInt2)
    throws IOException
  {
    writeTag(paramInt1, 0);
    writeEnumNoTag(paramInt2);
  }
  
  public void writeEnumNoTag(int paramInt)
    throws IOException
  {
    writeRawVarint32(paramInt);
  }
  
  public void writeFixed32(int paramInt1, int paramInt2)
    throws IOException
  {
    writeTag(paramInt1, 5);
    writeFixed32NoTag(paramInt2);
  }
  
  public void writeFixed32NoTag(int paramInt)
    throws IOException
  {
    writeRawLittleEndian32(paramInt);
  }
  
  public void writeFixed64(int paramInt, long paramLong)
    throws IOException
  {
    writeTag(paramInt, 1);
    writeFixed64NoTag(paramLong);
  }
  
  public void writeFixed64NoTag(long paramLong)
    throws IOException
  {
    writeRawLittleEndian64(paramLong);
  }
  
  public void writeFloat(int paramInt, float paramFloat)
    throws IOException
  {
    writeTag(paramInt, 5);
    writeFloatNoTag(paramFloat);
  }
  
  public void writeFloatNoTag(float paramFloat)
    throws IOException
  {
    writeRawLittleEndian32(Float.floatToIntBits(paramFloat));
  }
  
  public void writeGroup(int paramInt, MessageMicro<?> paramMessageMicro)
    throws IOException
  {
    writeTag(paramInt, 3);
    writeGroupNoTag(paramMessageMicro);
    writeTag(paramInt, 4);
  }
  
  public void writeGroupNoTag(MessageMicro<?> paramMessageMicro)
    throws IOException
  {
    paramMessageMicro.writeTo(this);
  }
  
  public void writeInt32(int paramInt1, int paramInt2)
    throws IOException
  {
    writeTag(paramInt1, 0);
    writeInt32NoTag(paramInt2);
  }
  
  public void writeInt32NoTag(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      writeRawVarint32(paramInt);
      return;
    }
    writeRawVarint64(paramInt);
  }
  
  public void writeInt64(int paramInt, long paramLong)
    throws IOException
  {
    writeTag(paramInt, 0);
    writeInt64NoTag(paramLong);
  }
  
  public void writeInt64NoTag(long paramLong)
    throws IOException
  {
    writeRawVarint64(paramLong);
  }
  
  public void writeMessage(int paramInt, MessageMicro<?> paramMessageMicro)
    throws IOException
  {
    writeTag(paramInt, 2);
    writeMessageNoTag(paramMessageMicro);
  }
  
  public void writeMessageNoTag(MessageMicro<?> paramMessageMicro)
    throws IOException
  {
    writeRawVarint32(paramMessageMicro.getCachedSize());
    paramMessageMicro.writeTo(this);
  }
  
  public void writeRawByte(byte paramByte)
    throws IOException
  {
    if (this.position == this.limit) {
      refreshBuffer();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public void writeRawByte(int paramInt)
    throws IOException
  {
    writeRawByte((byte)paramInt);
  }
  
  public void writeRawBytes(byte[] paramArrayOfByte)
    throws IOException
  {
    writeRawBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void writeRawBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.limit - this.position >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, paramInt2);
      this.position += paramInt2;
      return;
    }
    int i = this.limit - this.position;
    System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, i);
    paramInt1 += i;
    paramInt2 -= i;
    this.position = this.limit;
    refreshBuffer();
    if (paramInt2 <= this.limit)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, 0, paramInt2);
      this.position = paramInt2;
      return;
    }
    this.output.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void writeRawLittleEndian32(int paramInt)
    throws IOException
  {
    writeRawByte(paramInt & 0xFF);
    writeRawByte(paramInt >> 8 & 0xFF);
    writeRawByte(paramInt >> 16 & 0xFF);
    writeRawByte(paramInt >> 24 & 0xFF);
  }
  
  public void writeRawLittleEndian64(long paramLong)
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
  
  public void writeSFixed32(int paramInt1, int paramInt2)
    throws IOException
  {
    writeTag(paramInt1, 5);
    writeSFixed32NoTag(paramInt2);
  }
  
  public void writeSFixed32NoTag(int paramInt)
    throws IOException
  {
    writeRawLittleEndian32(paramInt);
  }
  
  public void writeSFixed64(int paramInt, long paramLong)
    throws IOException
  {
    writeTag(paramInt, 1);
    writeSFixed64NoTag(paramLong);
  }
  
  public void writeSFixed64NoTag(long paramLong)
    throws IOException
  {
    writeRawLittleEndian64(paramLong);
  }
  
  public void writeSInt32(int paramInt1, int paramInt2)
    throws IOException
  {
    writeTag(paramInt1, 0);
    writeSInt32NoTag(paramInt2);
  }
  
  public void writeSInt32NoTag(int paramInt)
    throws IOException
  {
    writeRawVarint32(encodeZigZag32(paramInt));
  }
  
  public void writeSInt64(int paramInt, long paramLong)
    throws IOException
  {
    writeTag(paramInt, 0);
    writeSInt64NoTag(paramLong);
  }
  
  public void writeSInt64NoTag(long paramLong)
    throws IOException
  {
    writeRawVarint64(encodeZigZag64(paramLong));
  }
  
  public void writeString(int paramInt, String paramString)
    throws IOException
  {
    writeTag(paramInt, 2);
    writeStringNoTag(paramString);
  }
  
  public void writeStringNoTag(String paramString)
    throws IOException
  {
    paramString = paramString.getBytes("UTF-8");
    writeRawVarint32(paramString.length);
    writeRawBytes(paramString);
  }
  
  public void writeTag(int paramInt1, int paramInt2)
    throws IOException
  {
    writeRawVarint32(WireFormatMicro.makeTag(paramInt1, paramInt2));
  }
  
  public void writeUInt32(int paramInt1, int paramInt2)
    throws IOException
  {
    writeTag(paramInt1, 0);
    writeUInt32NoTag(paramInt2);
  }
  
  public void writeUInt32NoTag(int paramInt)
    throws IOException
  {
    writeRawVarint32(paramInt);
  }
  
  public void writeUInt64(int paramInt, long paramLong)
    throws IOException
  {
    writeTag(paramInt, 0);
    writeUInt64NoTag(paramLong);
  }
  
  public void writeUInt64NoTag(long paramLong)
    throws IOException
  {
    writeRawVarint64(paramLong);
  }
  
  public static class OutOfSpaceException
    extends IOException
  {
    private static final long serialVersionUID = -6947486886997889499L;
    
    OutOfSpaceException()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pb.CodedOutputStreamMicro
 * JD-Core Version:    0.7.0.1
 */