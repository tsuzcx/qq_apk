package com.tencent.beacon.e;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private ByteBuffer a;
  private String b = "GBK";
  
  public b()
  {
    this(128);
  }
  
  public b(int paramInt)
  {
    this.a = ByteBuffer.allocate(paramInt);
  }
  
  private void a(int paramInt)
  {
    int i;
    if (this.a.remaining() < paramInt) {
      i = this.a.capacity();
    }
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i + paramInt << 1);
      localByteBuffer.put(this.a.array(), 0, this.a.position());
      this.a = localByteBuffer;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw localIllegalArgumentException;
    }
  }
  
  private void b(byte paramByte, int paramInt)
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
    throw new RuntimeException("tag is too large: " + paramInt);
  }
  
  public final int a(String paramString)
  {
    this.b = paramString;
    return 0;
  }
  
  public final ByteBuffer a()
  {
    return this.a;
  }
  
  public final void a(byte paramByte, int paramInt)
  {
    a(3);
    if (paramByte == 0)
    {
      b((byte)12, paramInt);
      return;
    }
    b((byte)0, paramInt);
    this.a.put(paramByte);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    a(6);
    if ((paramInt1 >= -32768) && (paramInt1 <= 32767))
    {
      a((short)paramInt1, paramInt2);
      return;
    }
    b((byte)2, paramInt2);
    this.a.putInt(paramInt1);
  }
  
  public final void a(long paramLong, int paramInt)
  {
    a(10);
    if ((paramLong >= -2147483648L) && (paramLong <= 2147483647L))
    {
      a((int)paramLong, paramInt);
      return;
    }
    b((byte)3, paramInt);
    this.a.putLong(paramLong);
  }
  
  public final void a(c paramc, int paramInt)
  {
    a(2);
    b((byte)10, paramInt);
    paramc.a(this);
    a(2);
    b((byte)11, 0);
  }
  
  public final void a(Object paramObject, int paramInt)
  {
    int i = 1;
    if ((paramObject instanceof Byte)) {
      a(((Byte)paramObject).byteValue(), paramInt);
    }
    for (;;)
    {
      return;
      if ((paramObject instanceof Boolean))
      {
        if (((Boolean)paramObject).booleanValue()) {}
        for (;;)
        {
          a((byte)i, paramInt);
          return;
          i = 0;
        }
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
      float f;
      if ((paramObject instanceof Float))
      {
        f = ((Float)paramObject).floatValue();
        a(6);
        b((byte)4, paramInt);
        this.a.putFloat(f);
        return;
      }
      double d;
      if ((paramObject instanceof Double))
      {
        d = ((Double)paramObject).doubleValue();
        a(10);
        b((byte)5, paramInt);
        this.a.putDouble(d);
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
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        a(2);
        b((byte)10, paramInt);
        paramObject.a(this);
        a(2);
        b((byte)11, 0);
        return;
      }
      if ((paramObject instanceof byte[]))
      {
        a((byte[])paramObject, paramInt);
        return;
      }
      if ((paramObject instanceof boolean[]))
      {
        paramObject = (boolean[])paramObject;
        a(8);
        b((byte)9, paramInt);
        a(paramObject.length, 0);
        int j = paramObject.length;
        paramInt = 0;
        label339:
        if (paramInt < j) {
          if (paramObject[paramInt] == 0) {
            break label369;
          }
        }
        label369:
        for (i = 1;; i = 0)
        {
          a((byte)i, 0);
          paramInt += 1;
          break label339;
          break;
        }
      }
      if ((paramObject instanceof short[]))
      {
        paramObject = (short[])paramObject;
        a(8);
        b((byte)9, paramInt);
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
        b((byte)9, paramInt);
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
        b((byte)9, paramInt);
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
        b((byte)9, paramInt);
        a(paramObject.length, 0);
        i = paramObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          f = paramObject[paramInt];
          a(6);
          b((byte)4, 0);
          this.a.putFloat(f);
          paramInt += 1;
        }
      }
      else if ((paramObject instanceof double[]))
      {
        paramObject = (double[])paramObject;
        a(8);
        b((byte)9, paramInt);
        a(paramObject.length, 0);
        i = paramObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          d = paramObject[paramInt];
          a(10);
          b((byte)5, 0);
          this.a.putDouble(d);
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
        b((byte)9, paramInt);
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
    throw new RuntimeException("write object error: unsupport type. " + paramObject.getClass());
  }
  
  public final void a(String paramString, int paramInt)
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
      b((byte)6, paramInt);
      this.a.put((byte)paramString.length);
      this.a.put(paramString);
    }
    a(paramString.length + 10);
    if (paramString.length > 255)
    {
      b((byte)7, paramInt);
      this.a.putInt(paramString.length);
      this.a.put(paramString);
      return;
    }
  }
  
  public final <T> void a(Collection<T> paramCollection, int paramInt)
  {
    a(8);
    b((byte)9, paramInt);
    if (paramCollection == null)
    {
      paramInt = 0;
      a(paramInt, 0);
      if (paramCollection != null) {
        paramCollection = paramCollection.iterator();
      }
    }
    for (;;)
    {
      if (!paramCollection.hasNext())
      {
        return;
        paramInt = paramCollection.size();
        break;
      }
      a((Object)paramCollection.next(), 0);
    }
  }
  
  public final <K, V> void a(Map<K, V> paramMap, int paramInt)
  {
    a(8);
    b((byte)8, paramInt);
    if (paramMap == null)
    {
      paramInt = 0;
      a(paramInt, 0);
      if (paramMap != null) {
        paramMap = paramMap.entrySet().iterator();
      }
    }
    for (;;)
    {
      if (!paramMap.hasNext())
      {
        return;
        paramInt = paramMap.size();
        break;
      }
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      a(localEntry.getKey(), 0);
      a(localEntry.getValue(), 1);
    }
  }
  
  public final void a(short paramShort, int paramInt)
  {
    a(4);
    if ((paramShort >= -128) && (paramShort <= 127))
    {
      a((byte)paramShort, paramInt);
      return;
    }
    b((byte)1, paramInt);
    this.a.putShort(paramShort);
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      a((byte)i, paramInt);
      return;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt)
  {
    a(paramArrayOfByte.length + 8);
    b((byte)13, paramInt);
    b((byte)0, 0);
    a(paramArrayOfByte.length, 0);
    this.a.put(paramArrayOfByte);
  }
  
  public final byte[] b()
  {
    byte[] arrayOfByte = new byte[this.a.position()];
    System.arraycopy(this.a.array(), 0, arrayOfByte, 0, this.a.position());
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.e.b
 * JD-Core Version:    0.7.0.1
 */