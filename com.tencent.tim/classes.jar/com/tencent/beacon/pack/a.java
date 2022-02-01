package com.tencent.beacon.pack;

import com.tencent.beacon.base.util.c;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  protected String a = "GBK";
  private ByteBuffer b;
  
  public a() {}
  
  public a(byte[] paramArrayOfByte)
  {
    this.b = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public a(byte[] paramArrayOfByte, int paramInt)
  {
    this.b = ByteBuffer.wrap(paramArrayOfByte);
    this.b.position(paramInt);
  }
  
  public static int a(a parama, ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.get();
    parama.a = ((byte)(i & 0xF));
    parama.b = ((i & 0xF0) >> 4);
    if (parama.b == 15)
    {
      parama.b = (paramByteBuffer.get() & 0xFF);
      return 2;
    }
    return 1;
  }
  
  private <K, V> Map<K, V> a(Map<K, V> paramMap1, Map<K, V> paramMap2, int paramInt, boolean paramBoolean)
  {
    if ((paramMap2 == null) || (paramMap2.isEmpty())) {
      paramMap2 = new HashMap();
    }
    do
    {
      return paramMap2;
      paramMap2 = (Map.Entry)paramMap2.entrySet().iterator().next();
      Object localObject1 = paramMap2.getKey();
      Object localObject2 = paramMap2.getValue();
      if (a(paramInt))
      {
        paramMap2 = new a();
        a(paramMap2);
        if (paramMap2.a == 8)
        {
          int i = a(0, 0, true);
          if (i >= 0)
          {
            paramInt = 0;
            for (;;)
            {
              paramMap2 = paramMap1;
              if (paramInt >= i) {
                break;
              }
              paramMap1.put(a(localObject1, 0, true), a(localObject2, 1, true));
              paramInt += 1;
            }
          }
          throw new RuntimeException("size invalid: " + i);
        }
        throw new RuntimeException("type mismatch.");
      }
      paramMap2 = paramMap1;
    } while (!paramBoolean);
    throw new RuntimeException("require field not exist.");
  }
  
  private void a(byte paramByte)
  {
    byte b2 = 0;
    byte b1 = 0;
    a locala;
    switch (paramByte)
    {
    default: 
      throw new RuntimeException("invalid type.");
    case 13: 
      locala = new a();
      a(locala);
      if (locala.a == 0) {
        b(a(0, 0, true));
      }
    case 11: 
    case 12: 
      return;
      throw new RuntimeException("skipField with invalid type, type value: " + paramByte + ", " + locala.a);
    case 10: 
      a();
      return;
    case 9: 
      b2 = a(0, 0, true);
      paramByte = b1;
      while (paramByte < b2)
      {
        b();
        paramByte += 1;
      }
    case 8: 
      b1 = a(0, 0, true);
      paramByte = b2;
      while (paramByte < b1 * 2)
      {
        b();
        paramByte += 1;
      }
    case 7: 
      b(this.b.getInt());
      return;
    case 6: 
      b1 = this.b.get();
      paramByte = b1;
      if (b1 < 0) {
        paramByte = b1 + 256;
      }
      b(paramByte);
      return;
    case 5: 
      b(8);
      return;
    case 4: 
      b(4);
      return;
    case 3: 
      b(8);
      return;
    case 2: 
      b(4);
      return;
    case 1: 
      b(2);
      return;
    }
    b(1);
  }
  
  private int b(a parama)
  {
    return a(parama, this.b.duplicate());
  }
  
  private void b()
  {
    a locala = new a();
    a(locala);
    a(locala.a);
  }
  
  private void b(int paramInt)
  {
    ByteBuffer localByteBuffer = this.b;
    localByteBuffer.position(localByteBuffer.position() + paramInt);
  }
  
  private <T> T[] b(T paramT, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject);
      if (((a)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          Object[] arrayOfObject = (Object[])Array.newInstance(paramT.getClass(), i);
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfObject;
            if (paramInt >= i) {
              break;
            }
            arrayOfObject[paramInt] = a(paramT, 0, true);
            paramInt += 1;
          }
        }
        throw new RuntimeException("size invalid: " + i);
      }
      throw new RuntimeException("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return localObject;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      locala = new a();
      a(locala);
      paramInt = locala.a;
      if (paramInt != 0) {
        if (paramInt == 12) {
          paramByte = 0;
        }
      }
    }
    while (!paramBoolean)
    {
      a locala;
      return paramByte;
      throw new RuntimeException("type mismatch.");
      return this.b.get();
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public double a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      locala = new a();
      a(locala);
      paramInt = locala.a;
      if (paramInt != 4) {
        if (paramInt != 5) {
          if (paramInt == 12) {
            paramDouble = 0.0D;
          }
        }
      }
    }
    while (!paramBoolean)
    {
      a locala;
      return paramDouble;
      throw new RuntimeException("type mismatch.");
      return this.b.getDouble();
      return this.b.getFloat();
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public float a(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      locala = new a();
      a(locala);
      paramInt = locala.a;
      if (paramInt != 4) {
        if (paramInt == 12) {
          paramFloat = 0.0F;
        }
      }
    }
    while (!paramBoolean)
    {
      a locala;
      return paramFloat;
      throw new RuntimeException("type mismatch.");
      return this.b.getFloat();
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (a(paramInt2))
    {
      locala = new a();
      a(locala);
      paramInt1 = locala.a;
      if (paramInt1 != 0) {
        if (paramInt1 != 1) {
          if (paramInt1 != 2) {
            if (paramInt1 == 12) {
              paramInt1 = 0;
            }
          }
        }
      }
    }
    while (!paramBoolean)
    {
      a locala;
      return paramInt1;
      throw new RuntimeException("type mismatch.");
      return this.b.getInt();
      return this.b.getShort();
      return this.b.get();
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public int a(String paramString)
  {
    this.a = paramString;
    return 0;
  }
  
  public long a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      locala = new a();
      a(locala);
      paramInt = locala.a;
      if (paramInt != 12) {
        switch (paramInt)
        {
        default: 
          throw new RuntimeException("type mismatch.");
        case 3: 
          paramLong = this.b.getLong();
        }
      }
    }
    while (!paramBoolean)
    {
      a locala;
      return paramLong;
      return this.b.getInt();
      return this.b.getShort();
      return this.b.get();
      return 0L;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public AbstractJceStruct a(AbstractJceStruct paramAbstractJceStruct, int paramInt, boolean paramBoolean)
  {
    a locala = null;
    if (a(paramInt)) {}
    do
    {
      try
      {
        paramAbstractJceStruct = (AbstractJceStruct)paramAbstractJceStruct.getClass().newInstance();
        locala = new a();
        a(locala);
        if (locala.a == 10)
        {
          paramAbstractJceStruct.readFrom(this);
          a();
          return paramAbstractJceStruct;
        }
        throw new RuntimeException("type mismatch.");
      }
      catch (Exception paramAbstractJceStruct)
      {
        throw new RuntimeException(paramAbstractJceStruct.getMessage());
      }
      paramAbstractJceStruct = locala;
    } while (!paramBoolean);
    throw new RuntimeException("require field not exist.");
  }
  
  public <T> Object a(T paramT, int paramInt, boolean paramBoolean)
  {
    if ((paramT instanceof Byte)) {
      return Byte.valueOf(a((byte)0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Boolean)) {
      return Boolean.valueOf(a(false, paramInt, paramBoolean));
    }
    if ((paramT instanceof Short)) {
      return Short.valueOf(a((short)0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Integer)) {
      return Integer.valueOf(a(0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Long)) {
      return Long.valueOf(a(0L, paramInt, paramBoolean));
    }
    if ((paramT instanceof Float)) {
      return Float.valueOf(a(0.0F, paramInt, paramBoolean));
    }
    if ((paramT instanceof Double)) {
      return Double.valueOf(a(0.0D, paramInt, paramBoolean));
    }
    if ((paramT instanceof String)) {
      return a(paramInt, paramBoolean);
    }
    if ((paramT instanceof Map)) {
      return a((Map)paramT, paramInt, paramBoolean);
    }
    if ((paramT instanceof List)) {
      return a((List)paramT, paramInt, paramBoolean);
    }
    if ((paramT instanceof AbstractJceStruct)) {
      return a((AbstractJceStruct)paramT, paramInt, paramBoolean);
    }
    if (paramT.getClass().isArray())
    {
      if (((paramT instanceof byte[])) || ((paramT instanceof Byte[]))) {
        return a(null, paramInt, paramBoolean);
      }
      if ((paramT instanceof boolean[])) {
        return a(null, paramInt, paramBoolean);
      }
      if ((paramT instanceof short[])) {
        return a(null, paramInt, paramBoolean);
      }
      if ((paramT instanceof int[])) {
        return a(null, paramInt, paramBoolean);
      }
      if ((paramT instanceof long[])) {
        return a(null, paramInt, paramBoolean);
      }
      if ((paramT instanceof float[])) {
        return a((float[])null, paramInt, paramBoolean);
      }
      if ((paramT instanceof double[])) {
        return a(null, paramInt, paramBoolean);
      }
      return a((Object[])paramT, paramInt, paramBoolean);
    }
    throw new RuntimeException("read object error: unsupport type.");
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (a(paramInt))
    {
      localObject1 = new a();
      a((a)localObject1);
      paramInt = ((a)localObject1).a;
      if (paramInt != 6) {
        if (paramInt == 7)
        {
          paramInt = this.b.getInt();
          if ((paramInt <= 104857600) && (paramInt >= 0) && (paramInt <= this.b.capacity()))
          {
            localObject2 = new byte[paramInt];
            this.b.get((byte[])localObject2);
          }
        }
      }
    }
    while (!paramBoolean)
    {
      Object localObject2;
      try
      {
        localObject1 = new String((byte[])localObject2, this.a);
        return localObject1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        return new String((byte[])localObject2, Charset.forName("UTF-8"));
      }
      throw new RuntimeException("String too long: " + paramInt);
      throw new RuntimeException("type mismatch.");
      int i = this.b.get();
      paramInt = i;
      if (i < 0) {
        paramInt = i + 256;
      }
      byte[] arrayOfByte = new byte[paramInt];
      this.b.get(arrayOfByte);
      try
      {
        localObject2 = new String(arrayOfByte, this.a);
        return localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        return new String(arrayOfByte, Charset.forName("UTF-8"));
      }
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public <K, V> HashMap<K, V> a(Map<K, V> paramMap, int paramInt, boolean paramBoolean)
  {
    return (HashMap)a(new HashMap(), paramMap, paramInt, paramBoolean);
  }
  
  public <T> List<T> a(List<T> paramList, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    if ((paramList == null) || (paramList.isEmpty())) {
      return new ArrayList();
    }
    paramList = b(paramList.get(0), paramInt, paramBoolean);
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramInt = i;
    while (paramInt < paramList.length)
    {
      localArrayList.add(paramList[paramInt]);
      paramInt += 1;
    }
    return localArrayList;
  }
  
  public short a(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      locala = new a();
      a(locala);
      paramInt = locala.a;
      if (paramInt != 0) {
        if (paramInt != 1) {
          if (paramInt == 12) {
            paramShort = 0;
          }
        }
      }
    }
    while (!paramBoolean)
    {
      a locala;
      return paramShort;
      throw new RuntimeException("type mismatch.");
      return this.b.getShort();
      return (short)this.b.get();
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public void a()
  {
    a locala = new a();
    do
    {
      a(locala);
      a(locala.a);
    } while (locala.a != 11);
  }
  
  public void a(a parama)
  {
    a(parama, this.b);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.b = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public boolean a(int paramInt)
  {
    try
    {
      a locala = new a();
      for (;;)
      {
        int i = b(locala);
        if (locala.a == 11) {
          return false;
        }
        if (paramInt <= locala.b)
        {
          if (paramInt != locala.b) {
            break;
          }
          return true;
        }
        b(i);
        a(locala.a);
      }
      return false;
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      c.a(localBufferUnderflowException);
      return false;
    }
    catch (RuntimeException localRuntimeException)
    {
      c.a(localRuntimeException);
    }
  }
  
  public boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    paramBoolean1 = false;
    if (a((byte)0, paramInt, paramBoolean2) != 0) {
      paramBoolean1 = true;
    }
    return paramBoolean1;
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    paramArrayOfByte = null;
    if (a(paramInt))
    {
      paramArrayOfByte = new a();
      a(paramArrayOfByte);
      i = paramArrayOfByte.a;
      if (i != 9) {
        if (i == 13)
        {
          localObject = new a();
          a((a)localObject);
          if (((a)localObject).a == 0)
          {
            i = a(0, 0, true);
            if ((i >= 0) && (i <= this.b.capacity()))
            {
              paramArrayOfByte = new byte[i];
              this.b.get(paramArrayOfByte);
            }
          }
        }
      }
    }
    while (!paramBoolean)
    {
      Object localObject;
      return paramArrayOfByte;
      throw new RuntimeException("invalid size, tag: " + paramInt + ", type: " + paramArrayOfByte.a + ", " + ((a)localObject).a + ", size: " + i);
      throw new RuntimeException("type mismatch, tag: " + paramInt + ", type: " + paramArrayOfByte.a + ", " + ((a)localObject).a);
      throw new RuntimeException("type mismatch.");
      int i = a(0, 0, true);
      if ((i >= 0) && (i <= this.b.capacity()))
      {
        localObject = new byte[i];
        paramInt = 0;
        for (;;)
        {
          paramArrayOfByte = (byte[])localObject;
          if (paramInt >= i) {
            break;
          }
          localObject[paramInt] = a(localObject[0], 0, true);
          paramInt += 1;
        }
      }
      throw new RuntimeException("size invalid: " + i);
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public double[] a(double[] paramArrayOfDouble, int paramInt, boolean paramBoolean)
  {
    paramArrayOfDouble = null;
    if (a(paramInt))
    {
      paramArrayOfDouble = new a();
      a(paramArrayOfDouble);
      if (paramArrayOfDouble.a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          double[] arrayOfDouble = new double[i];
          paramInt = 0;
          for (;;)
          {
            paramArrayOfDouble = arrayOfDouble;
            if (paramInt >= i) {
              break;
            }
            arrayOfDouble[paramInt] = a(arrayOfDouble[0], 0, true);
            paramInt += 1;
          }
        }
        throw new RuntimeException("size invalid: " + i);
      }
      throw new RuntimeException("type mismatch.");
    }
    if (!paramBoolean) {
      return paramArrayOfDouble;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public float[] a(float[] paramArrayOfFloat, int paramInt, boolean paramBoolean)
  {
    paramArrayOfFloat = null;
    if (a(paramInt))
    {
      paramArrayOfFloat = new a();
      a(paramArrayOfFloat);
      if (paramArrayOfFloat.a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          float[] arrayOfFloat = new float[i];
          paramInt = 0;
          for (;;)
          {
            paramArrayOfFloat = arrayOfFloat;
            if (paramInt >= i) {
              break;
            }
            arrayOfFloat[paramInt] = a(arrayOfFloat[0], 0, true);
            paramInt += 1;
          }
        }
        throw new RuntimeException("size invalid: " + i);
      }
      throw new RuntimeException("type mismatch.");
    }
    if (!paramBoolean) {
      return paramArrayOfFloat;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public int[] a(int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    paramArrayOfInt = null;
    if (a(paramInt))
    {
      paramArrayOfInt = new a();
      a(paramArrayOfInt);
      if (paramArrayOfInt.a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          int[] arrayOfInt = new int[i];
          paramInt = 0;
          for (;;)
          {
            paramArrayOfInt = arrayOfInt;
            if (paramInt >= i) {
              break;
            }
            arrayOfInt[paramInt] = a(arrayOfInt[0], 0, true);
            paramInt += 1;
          }
        }
        throw new RuntimeException("size invalid: " + i);
      }
      throw new RuntimeException("type mismatch.");
    }
    if (!paramBoolean) {
      return paramArrayOfInt;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public long[] a(long[] paramArrayOfLong, int paramInt, boolean paramBoolean)
  {
    paramArrayOfLong = null;
    if (a(paramInt))
    {
      paramArrayOfLong = new a();
      a(paramArrayOfLong);
      if (paramArrayOfLong.a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          long[] arrayOfLong = new long[i];
          paramInt = 0;
          for (;;)
          {
            paramArrayOfLong = arrayOfLong;
            if (paramInt >= i) {
              break;
            }
            arrayOfLong[paramInt] = a(arrayOfLong[0], 0, true);
            paramInt += 1;
          }
        }
        throw new RuntimeException("size invalid: " + i);
      }
      throw new RuntimeException("type mismatch.");
    }
    if (!paramBoolean) {
      return paramArrayOfLong;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public <T> T[] a(T[] paramArrayOfT, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayOfT != null) && (paramArrayOfT.length != 0)) {
      return b(paramArrayOfT[0], paramInt, paramBoolean);
    }
    throw new RuntimeException("unable to get type of key and value.");
  }
  
  public short[] a(short[] paramArrayOfShort, int paramInt, boolean paramBoolean)
  {
    paramArrayOfShort = null;
    if (a(paramInt))
    {
      paramArrayOfShort = new a();
      a(paramArrayOfShort);
      if (paramArrayOfShort.a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          short[] arrayOfShort = new short[i];
          paramInt = 0;
          for (;;)
          {
            paramArrayOfShort = arrayOfShort;
            if (paramInt >= i) {
              break;
            }
            arrayOfShort[paramInt] = a(arrayOfShort[0], 0, true);
            paramInt += 1;
          }
        }
        throw new RuntimeException("size invalid: " + i);
      }
      throw new RuntimeException("type mismatch.");
    }
    if (!paramBoolean) {
      return paramArrayOfShort;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public boolean[] a(boolean[] paramArrayOfBoolean, int paramInt, boolean paramBoolean)
  {
    paramArrayOfBoolean = null;
    if (a(paramInt))
    {
      paramArrayOfBoolean = new a();
      a(paramArrayOfBoolean);
      if (paramArrayOfBoolean.a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          boolean[] arrayOfBoolean = new boolean[i];
          paramInt = 0;
          for (;;)
          {
            paramArrayOfBoolean = arrayOfBoolean;
            if (paramInt >= i) {
              break;
            }
            arrayOfBoolean[paramInt] = a(arrayOfBoolean[0], 0, true);
            paramInt += 1;
          }
        }
        throw new RuntimeException("size invalid: " + i);
      }
      throw new RuntimeException("type mismatch.");
    }
    if (!paramBoolean) {
      return paramArrayOfBoolean;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public static class a
  {
    public byte a;
    public int b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.pack.a
 * JD-Core Version:    0.7.0.1
 */