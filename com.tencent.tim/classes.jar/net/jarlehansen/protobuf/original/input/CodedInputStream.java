package net.jarlehansen.protobuf.original.input;

import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import net.jarlehansen.protobuf.original.WireFormat;

public final class CodedInputStream
{
  private static final int BUFFER_SIZE = 2048;
  private static final int DEFAULT_SIZE_LIMIT = 67108864;
  private byte[] buffer;
  private int bufferPos;
  private int bufferSize;
  private int bufferSizeAfterLimit = 0;
  private int currentLimit = 2147483647;
  private InputStream input;
  private int lastTag = 0;
  private int sizeLimit = 67108864;
  private int totalBytesRetired = 0;
  
  private CodedInputStream(InputStream paramInputStream)
  {
    this.buffer = new byte[2048];
    this.bufferSize = 0;
    this.bufferPos = 0;
    this.input = paramInputStream;
  }
  
  private CodedInputStream(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.bufferSize = (paramInt1 + paramInt2);
    this.bufferPos = paramInt1;
    this.input = null;
  }
  
  public static CodedInputStream newInstance(InputStream paramInputStream)
  {
    return new CodedInputStream(paramInputStream);
  }
  
  public static CodedInputStream newInstance(byte[] paramArrayOfByte)
  {
    return new CodedInputStream(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int readDelimitedSize(InputStream paramInputStream)
    throws IOException
  {
    return readRawVarint32(paramInputStream);
  }
  
  private int[] readInnerRawVarint32(int paramInt)
    throws IOException
  {
    int j = readRawByte(paramInt);
    int i = paramInt + 1;
    if (j >= 0) {
      return new int[] { j, i };
    }
    paramInt = j & 0x7F;
    j = readRawByte(i);
    if (j >= 0)
    {
      i += 1;
      paramInt |= j << 7;
    }
    int k;
    do
    {
      for (;;)
      {
        return new int[] { paramInt, i };
        paramInt |= (j & 0x7F) << 7;
        j = readRawByte(i);
        if (j >= 0)
        {
          i += 1;
          paramInt |= j << 14;
        }
        else
        {
          paramInt |= (j & 0x7F) << 14;
          j = readRawByte(i);
          if (j < 0) {
            break;
          }
          i += 1;
          paramInt |= j << 21;
        }
      }
      k = readRawByte(i);
      paramInt = paramInt | (j & 0x7F) << 21 | k << 28;
      j = i + 1;
      i = j;
    } while (k >= 0);
    paramInt = 0;
    while (paramInt < 5)
    {
      if (readRawByte(j) >= 0) {
        return new int[] { k, j + 1 };
      }
      paramInt += 1;
    }
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  private byte readRawByte()
    throws IOException
  {
    if (this.bufferPos == this.bufferSize) {
      refillBuffer(true);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bufferPos;
    this.bufferPos = (i + 1);
    return arrayOfByte[i];
  }
  
  private byte readRawByte(int paramInt)
    throws IOException
  {
    return this.buffer[paramInt];
  }
  
  private byte[] readRawBytes(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw InvalidProtocolBufferException.negativeSize();
    }
    if (this.totalBytesRetired + this.bufferPos + paramInt > this.currentLimit)
    {
      skipRawBytes(this.currentLimit - this.totalBytesRetired - this.bufferPos);
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    if (paramInt <= this.bufferSize - this.bufferPos)
    {
      localObject = new byte[paramInt];
      System.arraycopy(this.buffer, this.bufferPos, localObject, 0, paramInt);
      this.bufferPos += paramInt;
      return localObject;
    }
    if (paramInt < 2048)
    {
      localObject = new byte[paramInt];
      i = this.bufferSize - this.bufferPos;
      System.arraycopy(this.buffer, this.bufferPos, localObject, 0, i);
      this.bufferPos = this.bufferSize;
      refillBuffer(true);
      while (paramInt - i > this.bufferSize)
      {
        System.arraycopy(this.buffer, 0, localObject, i, this.bufferSize);
        i += this.bufferSize;
        this.bufferPos = this.bufferSize;
        refillBuffer(true);
      }
      System.arraycopy(this.buffer, 0, localObject, i, paramInt - i);
      this.bufferPos = (paramInt - i);
      return localObject;
    }
    int m = this.bufferPos;
    int n = this.bufferSize;
    this.totalBytesRetired += this.bufferSize;
    this.bufferPos = 0;
    this.bufferSize = 0;
    Object localObject = new LinkedList();
    int i = paramInt - (n - m);
    while (i > 0)
    {
      arrayOfByte1 = new byte[Math.min(i, 2048)];
      int j = 0;
      while (j < arrayOfByte1.length)
      {
        if (this.input == null) {}
        for (int k = -1; k == -1; k = this.input.read(arrayOfByte1, j, arrayOfByte1.length - j)) {
          throw InvalidProtocolBufferException.truncatedMessage();
        }
        this.totalBytesRetired += k;
        j += k;
      }
      j = arrayOfByte1.length;
      ((LinkedList)localObject).add(arrayOfByte1);
      i -= j;
    }
    byte[] arrayOfByte1 = new byte[paramInt];
    i = n - m;
    System.arraycopy(this.buffer, m, arrayOfByte1, 0, i);
    paramInt = 0;
    while (paramInt < ((LinkedList)localObject).size())
    {
      byte[] arrayOfByte2 = (byte[])((LinkedList)localObject).get(paramInt);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, arrayOfByte2.length);
      i += arrayOfByte2.length;
      paramInt += 1;
    }
    return arrayOfByte1;
  }
  
  private int readRawVarint32()
    throws IOException
  {
    int i = readRawByte();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = readRawByte();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = readRawByte();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = readRawByte();
      if (k >= 0) {
        return i | k << 21;
      }
      j = readRawByte();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        break label133;
      }
      i = k;
      if (readRawByte() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  private static int readRawVarint32(InputStream paramInputStream)
    throws IOException
  {
    int i = 0;
    int j = 0;
    int k;
    for (;;)
    {
      k = i;
      if (i >= 32) {
        break;
      }
      k = paramInputStream.read();
      if (k == -1) {
        throw InvalidProtocolBufferException.truncatedMessage();
      }
      j |= (k & 0x7F) << i;
      if ((k & 0x80) == 0) {
        return j;
      }
      i += 7;
    }
    do
    {
      k += 7;
      if (k >= 64) {
        break;
      }
      i = paramInputStream.read();
      if (i == -1) {
        throw InvalidProtocolBufferException.truncatedMessage();
      }
    } while ((i & 0x80) != 0);
    return j;
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  private void recomputeBufferSizeAfterLimit()
  {
    this.bufferSize += this.bufferSizeAfterLimit;
    int i = this.totalBytesRetired + this.bufferSize;
    if (i > this.currentLimit)
    {
      this.bufferSizeAfterLimit = (i - this.currentLimit);
      this.bufferSize -= this.bufferSizeAfterLimit;
      return;
    }
    this.bufferSizeAfterLimit = 0;
  }
  
  private boolean refillBuffer(boolean paramBoolean)
    throws IOException
  {
    if (this.bufferPos < this.bufferSize) {
      throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }
    if (this.totalBytesRetired + this.bufferSize == this.currentLimit)
    {
      if (paramBoolean) {
        throw InvalidProtocolBufferException.truncatedMessage();
      }
      return false;
    }
    this.totalBytesRetired += this.bufferSize;
    this.bufferPos = 0;
    if (this.input == null) {}
    for (int i = -1;; i = this.input.read(this.buffer))
    {
      this.bufferSize = i;
      if (this.bufferSize != -1) {
        break label117;
      }
      this.bufferSize = 0;
      if (!paramBoolean) {
        break;
      }
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    return false;
    label117:
    recomputeBufferSizeAfterLimit();
    i = this.totalBytesRetired + this.bufferSize + this.bufferSizeAfterLimit;
    if ((i > this.sizeLimit) || (i < 0)) {
      throw InvalidProtocolBufferException.sizeLimitExceeded();
    }
    return true;
  }
  
  private void skipRawBytes(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw InvalidProtocolBufferException.negativeSize();
    }
    if (this.totalBytesRetired + this.bufferPos + paramInt > this.currentLimit)
    {
      skipRawBytes(this.currentLimit - this.totalBytesRetired - this.bufferPos);
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    if (paramInt < this.bufferSize - this.bufferPos) {
      this.bufferPos += paramInt;
    }
    for (;;)
    {
      return;
      int i = this.bufferSize - this.bufferPos;
      this.totalBytesRetired += i;
      this.bufferPos = 0;
      this.bufferSize = 0;
      while (i < paramInt)
      {
        if (this.input == null) {}
        for (int j = -1; j <= 0; j = (int)this.input.skip(paramInt - i)) {
          throw InvalidProtocolBufferException.truncatedMessage();
        }
        i += j;
        this.totalBytesRetired = (j + this.totalBytesRetired);
      }
    }
  }
  
  public boolean readBool()
    throws IOException
  {
    return readRawVarint32() != 0;
  }
  
  public ByteString readBytes()
    throws IOException
  {
    int i = readRawVarint32();
    if ((i < this.bufferSize - this.bufferPos) && (i > 0))
    {
      ByteString localByteString = ByteString.copyFrom(this.buffer, this.bufferPos, i);
      this.bufferPos = (i + this.bufferPos);
      return localByteString;
    }
    return ByteString.copyFrom(readRawBytes(i));
  }
  
  public double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(readRawLittleEndian64());
  }
  
  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(readRawLittleEndian32());
  }
  
  public int readInt32()
    throws IOException
  {
    return readRawVarint32();
  }
  
  public LinkedList<Integer> readInt32s()
    throws IOException
  {
    LinkedList localLinkedList = new LinkedList();
    while (this.bufferPos < this.bufferSize) {
      localLinkedList.add(Integer.valueOf(readRawVarint32()));
    }
    return localLinkedList;
  }
  
  public long readInt64()
    throws IOException
  {
    return readRawVarint64();
  }
  
  public int readMessageStart()
    throws IOException
  {
    return readRawVarint32();
  }
  
  public LinkedList<byte[]> readMessages(int paramInt)
    throws IOException
  {
    LinkedList localLinkedList = new LinkedList();
    int i = readRawVarint32();
    Object localObject = new byte[i];
    System.arraycopy(this.buffer, this.bufferPos, localObject, 0, i);
    localLinkedList.add(localObject);
    this.bufferPos = (i + this.bufferPos);
    i = this.bufferPos;
    if (this.bufferPos == this.bufferSize) {
      return localLinkedList;
    }
    localObject = readInnerRawVarint32(i);
    for (i = localObject[0];; i = localObject[0])
    {
      if (WireFormat.getTagFieldNumber(i) == paramInt)
      {
        this.bufferPos = localObject[1];
        i = readRawVarint32();
        localObject = new byte[i];
        System.arraycopy(this.buffer, this.bufferPos, localObject, 0, i);
        localLinkedList.add(localObject);
        this.bufferPos = (i + this.bufferPos);
        if (this.bufferPos != this.bufferSize) {}
      }
      else
      {
        return localLinkedList;
      }
      localObject = readInnerRawVarint32(this.bufferPos);
    }
  }
  
  int readRawLittleEndian32()
    throws IOException
  {
    return readRawByte() & 0xFF | (readRawByte() & 0xFF) << 8 | (readRawByte() & 0xFF) << 16 | (readRawByte() & 0xFF) << 24;
  }
  
  long readRawLittleEndian64()
    throws IOException
  {
    int i = readRawByte();
    int j = readRawByte();
    int k = readRawByte();
    int m = readRawByte();
    int n = readRawByte();
    int i1 = readRawByte();
    int i2 = readRawByte();
    int i3 = readRawByte();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public long readRawVarint64()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = readRawByte();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  public String readString()
    throws IOException
  {
    int i = readRawVarint32();
    if ((i < this.bufferSize - this.bufferPos) && (i > 0))
    {
      String str = new String(this.buffer, this.bufferPos, i, "UTF-8");
      this.bufferPos = (i + this.bufferPos);
      return str;
    }
    return new String(readRawBytes(i), "UTF-8");
  }
  
  public int readTag()
    throws IOException
  {
    if ((this.bufferPos == this.bufferSize) && (!refillBuffer(false)))
    {
      this.lastTag = 0;
      return 0;
    }
    this.lastTag = readRawVarint32();
    if (this.lastTag == 0) {
      throw InvalidProtocolBufferException.invalidTag();
    }
    return this.lastTag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.jarlehansen.protobuf.original.input.CodedInputStream
 * JD-Core Version:    0.7.0.1
 */