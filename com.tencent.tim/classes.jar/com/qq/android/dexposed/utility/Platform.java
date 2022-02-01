package com.qq.android.dexposed.utility;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class Platform
{
  static Platform PLATFORM_INTERNAL = new Platform32Bit();
  
  static
  {
    if (Runtime.is64Bit())
    {
      PLATFORM_INTERNAL = new Platform64Bit();
      return;
    }
  }
  
  public static Platform getPlatform()
  {
    return PLATFORM_INTERNAL;
  }
  
  public abstract int getIntSize();
  
  public abstract int orderByteToInt(byte[] paramArrayOfByte);
  
  public abstract long orderByteToLong(byte[] paramArrayOfByte);
  
  public abstract byte[] orderIntToByte(int paramInt);
  
  public abstract byte[] orderLongToByte(long paramLong, int paramInt);
  
  static class Platform32Bit
    extends Platform
  {
    public int getIntSize()
    {
      return 4;
    }
    
    public int orderByteToInt(byte[] paramArrayOfByte)
    {
      return ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }
    
    public long orderByteToLong(byte[] paramArrayOfByte)
    {
      return ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN).getInt() & 0xFFFFFFFF;
    }
    
    public byte[] orderIntToByte(int paramInt)
    {
      return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(paramInt).array();
    }
    
    public byte[] orderLongToByte(long paramLong, int paramInt)
    {
      return ByteBuffer.allocate(paramInt).order(ByteOrder.LITTLE_ENDIAN).putInt((int)paramLong).array();
    }
  }
  
  static class Platform64Bit
    extends Platform
  {
    public int getIntSize()
    {
      return 8;
    }
    
    public int orderByteToInt(byte[] paramArrayOfByte)
    {
      return ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }
    
    public long orderByteToLong(byte[] paramArrayOfByte)
    {
      return ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN).getLong();
    }
    
    public byte[] orderIntToByte(int paramInt)
    {
      return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(paramInt).array();
    }
    
    public byte[] orderLongToByte(long paramLong, int paramInt)
    {
      return ByteBuffer.allocate(paramInt).order(ByteOrder.LITTLE_ENDIAN).putLong(paramLong).array();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.qq.android.dexposed.utility.Platform
 * JD-Core Version:    0.7.0.1
 */