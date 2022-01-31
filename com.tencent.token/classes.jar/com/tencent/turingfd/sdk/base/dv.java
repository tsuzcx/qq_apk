package com.tencent.turingfd.sdk.base;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class dv
{
  public ByteBuffer a = ByteBuffer.allocate(128);
  public String b = "GBK";
  
  public void a(byte paramByte, int paramInt)
  {
    byte b1;
    if (paramInt < 15)
    {
      b1 = (byte)(paramInt << 4 | paramByte);
      this.a.put(b1);
      return;
    }
    if (paramInt < 256)
    {
      b1 = (byte)(paramByte | 0xF0);
      this.a.put(b1);
      this.a.put((byte)paramInt);
      return;
    }
    throw new class(dt.a("tag is too large: ", paramInt));
  }
  
  public void a(double paramDouble, int paramInt)
  {
    a(10);
    a((byte)5, paramInt);
    this.a.putDouble(paramDouble);
  }
  
  public void a(float paramFloat, int paramInt)
  {
    a(6);
    a((byte)4, paramInt);
    this.a.putFloat(paramFloat);
  }
  
  public void a(int paramInt)
  {
    if (this.a.remaining() < paramInt)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate((this.a.capacity() + paramInt) * 2);
      localByteBuffer.put(this.a.array(), 0, this.a.position());
      this.a = localByteBuffer;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(6);
    if ((paramInt1 >= -32768) && (paramInt1 <= 32767))
    {
      a((short)paramInt1, paramInt2);
      return;
    }
    a((byte)2, paramInt2);
    this.a.putInt(paramInt1);
  }
  
  public void a(long paramLong, int paramInt)
  {
    a(10);
    if ((paramLong >= -2147483648L) && (paramLong <= 2147483647L))
    {
      a((int)paramLong, paramInt);
      return;
    }
    a((byte)3, paramInt);
    this.a.putLong(paramLong);
  }
  
  public void a(float paramfloat, int paramInt)
  {
    a(2);
    a((byte)10, paramInt);
    paramfloat.a(this);
    a(2);
    a((byte)11, 0);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Byte)) {
      b(((Byte)paramObject).byteValue(), paramInt);
    }
    for (;;)
    {
      return;
      if ((paramObject instanceof Boolean))
      {
        a(((Boolean)paramObject).booleanValue(), paramInt);
        return;
      }
      if ((paramObject instanceof Short))
      {
        a(((Short)paramObject).shortValue(), paramInt);
        return;
      }
      if ((paramObject instanceof Integer))
      {
        a(((Integer)paramObject).intValue(), paramInt);
        return;
      }
      if ((paramObject instanceof Long))
      {
        a(((Long)paramObject).longValue(), paramInt);
        return;
      }
      if ((paramObject instanceof Float))
      {
        a(((Float)paramObject).floatValue(), paramInt);
        return;
      }
      if ((paramObject instanceof Double))
      {
        a(((Double)paramObject).doubleValue(), paramInt);
        return;
      }
      if ((paramObject instanceof String))
      {
        a((String)paramObject, paramInt);
        return;
      }
      if ((paramObject instanceof Map))
      {
        a((Map)paramObject, paramInt);
        return;
      }
      if ((paramObject instanceof List))
      {
        a((List)paramObject, paramInt);
        return;
      }
      if ((paramObject instanceof float))
      {
        a((float)paramObject, paramInt);
        return;
      }
      if ((paramObject instanceof byte[]))
      {
        a((byte[])paramObject, paramInt);
        return;
      }
      int i;
      if ((paramObject instanceof boolean[]))
      {
        paramObject = (boolean[])paramObject;
        a(8);
        a((byte)9, paramInt);
        a(paramObject.length, 0);
        i = paramObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
      else if ((paramObject instanceof short[]))
      {
        paramObject = (short[])paramObject;
        a(8);
        a((byte)9, paramInt);
        a(paramObject.length, 0);
        i = paramObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
      else if ((paramObject instanceof int[]))
      {
        paramObject = (int[])paramObject;
        a(8);
        a((byte)9, paramInt);
        a(paramObject.length, 0);
        i = paramObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
      else if ((paramObject instanceof long[]))
      {
        paramObject = (long[])paramObject;
        a(8);
        a((byte)9, paramInt);
        a(paramObject.length, 0);
        i = paramObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
      else if ((paramObject instanceof float[]))
      {
        paramObject = (float[])paramObject;
        a(8);
        a((byte)9, paramInt);
        a(paramObject.length, 0);
        i = paramObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
      else if ((paramObject instanceof double[]))
      {
        paramObject = (double[])paramObject;
        a(8);
        a((byte)9, paramInt);
        a(paramObject.length, 0);
        i = paramObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
      else
      {
        if (!paramObject.getClass().isArray()) {
          break;
        }
        paramObject = (Object[])paramObject;
        a(8);
        a((byte)9, paramInt);
        a(paramObject.length, 0);
        i = paramObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
    }
    if ((paramObject instanceof Collection))
    {
      a((Collection)paramObject, paramInt);
      return;
    }
    throw new class("write object error: unsupport type. " + paramObject.getClass());
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes(this.b);
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        paramString = paramString.getBytes();
      }
      a((byte)6, paramInt);
      this.a.put((byte)paramString.length);
      this.a.put(paramString);
    }
    a(paramString.length + 10);
    if (paramString.length > 255)
    {
      a((byte)7, paramInt);
      this.a.putInt(paramString.length);
      this.a.put(paramString);
      return;
    }
  }
  
  public void a(Collection paramCollection, int paramInt)
  {
    a(8);
    a((byte)9, paramInt);
    if (paramCollection == null) {}
    for (paramInt = 0;; paramInt = paramCollection.size())
    {
      a(paramInt, 0);
      if (paramCollection == null) {
        break;
      }
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        a(paramCollection.next(), 0);
      }
    }
  }
  
  public void a(Map paramMap, int paramInt)
  {
    a(8);
    a((byte)8, paramInt);
    if (paramMap == null) {}
    for (paramInt = 0;; paramInt = paramMap.size())
    {
      a(paramInt, 0);
      if (paramMap == null) {
        break;
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        a(localEntry.getKey(), 0);
        a(localEntry.getValue(), 1);
      }
    }
  }
  
  public void a(short paramShort, int paramInt)
  {
    a(4);
    if ((paramShort >= -128) && (paramShort <= 127))
    {
      b((byte)paramShort, paramInt);
      return;
    }
    a((byte)1, paramInt);
    this.a.putShort(paramShort);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    b((byte)paramBoolean, paramInt);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    a(paramArrayOfByte.length + 8);
    a((byte)13, paramInt);
    a((byte)0, 0);
    a(paramArrayOfByte.length, 0);
    this.a.put(paramArrayOfByte);
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[this.a.position()];
    System.arraycopy(this.a.array(), 0, arrayOfByte, 0, this.a.position());
    return arrayOfByte;
  }
  
  public void b(byte paramByte, int paramInt)
  {
    a(3);
    if (paramByte == 0)
    {
      a((byte)12, paramInt);
      return;
    }
    a((byte)0, paramInt);
    this.a.put(paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.dv
 * JD-Core Version:    0.7.0.1
 */