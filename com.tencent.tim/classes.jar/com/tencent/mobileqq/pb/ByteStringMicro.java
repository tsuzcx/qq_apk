package com.tencent.mobileqq.pb;

import java.io.UnsupportedEncodingException;

public final class ByteStringMicro
{
  public static final ByteStringMicro EMPTY = new ByteStringMicro(new byte[0]);
  private final byte[] bytes;
  private volatile int hash = 0;
  
  private ByteStringMicro(byte[] paramArrayOfByte)
  {
    this.bytes = paramArrayOfByte;
  }
  
  public static ByteStringMicro copyFrom(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    return new ByteStringMicro(paramString1.getBytes(paramString2));
  }
  
  public static ByteStringMicro copyFrom(byte[] paramArrayOfByte)
  {
    return copyFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static ByteStringMicro copyFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new ByteStringMicro(arrayOfByte);
  }
  
  public static ByteStringMicro copyFromUtf8(String paramString)
  {
    try
    {
      paramString = new ByteStringMicro(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported?");
    }
  }
  
  public byte byteAt(int paramInt)
  {
    return this.bytes[paramInt];
  }
  
  public void copyTo(byte[] paramArrayOfByte, int paramInt)
  {
    System.arraycopy(this.bytes, 0, paramArrayOfByte, paramInt, this.bytes.length);
  }
  
  public void copyTo(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.bytes, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof ByteStringMicro)) {
        return false;
      }
      Object localObject = (ByteStringMicro)paramObject;
      int j = this.bytes.length;
      if (j != ((ByteStringMicro)localObject).bytes.length) {
        return false;
      }
      paramObject = this.bytes;
      localObject = ((ByteStringMicro)localObject).bytes;
      int i = 0;
      while (i < j)
      {
        if (paramObject[i] != localObject[i]) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  public int hashCode()
  {
    int i = this.hash;
    int j = i;
    byte[] arrayOfByte;
    int k;
    if (i == 0)
    {
      arrayOfByte = this.bytes;
      k = this.bytes.length;
      j = 0;
    }
    int m;
    for (i = k;; i = m + i * 31)
    {
      if (j >= k)
      {
        j = i;
        if (i == 0) {
          j = 1;
        }
        this.hash = j;
        return j;
      }
      m = arrayOfByte[j];
      j += 1;
    }
  }
  
  public boolean isEmpty()
  {
    return this.bytes.length == 0;
  }
  
  public int size()
  {
    return this.bytes.length;
  }
  
  public byte[] toByteArray()
  {
    int i = this.bytes.length;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.bytes, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public String toString(String paramString)
    throws UnsupportedEncodingException
  {
    return new String(this.bytes, paramString);
  }
  
  public String toStringUtf8()
  {
    try
    {
      String str = new String(this.bytes, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported?");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pb.ByteStringMicro
 * JD-Core Version:    0.7.0.1
 */