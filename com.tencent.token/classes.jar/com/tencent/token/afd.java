package com.tencent.token;

import com.tencent.turingfd.sdk.qps.Lyra;
import com.tencent.turingfd.sdk.qps.Orion;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class afd
{
  public ByteBuffer a = ByteBuffer.allocate(128);
  
  private void a(int paramInt)
  {
    if (this.a.remaining() < paramInt)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate((this.a.capacity() + paramInt) * 2);
      localByteBuffer.put(this.a.array(), 0, this.a.position());
      this.a = localByteBuffer;
    }
  }
  
  private void a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Byte))
    {
      a(((Byte)paramObject).byteValue(), paramInt);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      a((byte)((Boolean)paramObject).booleanValue(), paramInt);
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
    if ((paramObject instanceof Orion))
    {
      a((Orion)paramObject, paramInt);
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
      b((byte)9, paramInt);
      a(paramObject.length, 0);
      i = paramObject.length;
      paramInt = 0;
      while (paramInt < i)
      {
        a((byte)paramObject[paramInt], 0);
        paramInt += 1;
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
    if ((paramObject instanceof int[]))
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
    if ((paramObject instanceof long[]))
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
    if ((paramObject instanceof float[]))
    {
      paramObject = (float[])paramObject;
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
    if ((paramObject instanceof double[]))
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
    if (paramObject.getClass().isArray())
    {
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
    if ((paramObject instanceof Collection))
    {
      a((Collection)paramObject, paramInt);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("write object error: unsupport type. ");
    localStringBuilder.append(paramObject.getClass());
    throw new Lyra(localStringBuilder.toString());
  }
  
  private void b(byte paramByte, int paramInt)
  {
    byte b;
    if (paramInt < 15)
    {
      b = (byte)(paramByte | paramInt << 4);
      this.a.put(b);
      return;
    }
    if (paramInt < 256)
    {
      b = (byte)(paramByte | 0xF0);
      this.a.put(b);
      this.a.put((byte)paramInt);
      return;
    }
    throw new Lyra("tag is too large: ".concat(String.valueOf(paramInt)));
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
  
  public final void a(float paramFloat, int paramInt)
  {
    a(6);
    b((byte)4, paramInt);
    this.a.putFloat(paramFloat);
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
  
  public final void a(Orion paramOrion, int paramInt)
  {
    a(2);
    b((byte)10, paramInt);
    paramOrion.a(this);
    a(2);
    b((byte)11, 0);
  }
  
  public final void a(String paramString, int paramInt)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("GBK");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label12:
      break label12;
    }
    paramString = paramString.getBytes();
    a(paramString.length + 10);
    if (paramString.length > 255)
    {
      b((byte)7, paramInt);
      this.a.putInt(paramString.length);
      this.a.put(paramString);
      return;
    }
    b((byte)6, paramInt);
    this.a.put((byte)paramString.length);
    this.a.put(paramString);
  }
  
  public final <T> void a(Collection<T> paramCollection, int paramInt)
  {
    a(8);
    b((byte)9, paramInt);
    if (paramCollection == null) {
      paramInt = 0;
    } else {
      paramInt = paramCollection.size();
    }
    a(paramInt, 0);
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        a(paramCollection.next(), 0);
      }
    }
  }
  
  public final <K, V> void a(Map<K, V> paramMap, int paramInt)
  {
    a(8);
    b((byte)8, paramInt);
    if (paramMap == null) {
      paramInt = 0;
    } else {
      paramInt = paramMap.size();
    }
    a(paramInt, 0);
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        a(localEntry.getKey(), 0);
        a(localEntry.getValue(), 1);
      }
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
  
  public final void a(byte[] paramArrayOfByte, int paramInt)
  {
    a(paramArrayOfByte.length + 8);
    b((byte)13, paramInt);
    b((byte)0, 0);
    a(paramArrayOfByte.length, 0);
    this.a.put(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afd
 * JD-Core Version:    0.7.0.1
 */