package com.tencent.feedback.proguard;

import com.tencent.feedback.eup.jni.c;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class h
{
  private ByteBuffer a;
  private String b = "GBK";
  
  public h() {}
  
  public h(byte[] paramArrayOfByte)
  {
    this.a = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public h(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = ByteBuffer.wrap(paramArrayOfByte);
    this.a.position(4);
  }
  
  private double a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      c localc = new c();
      a(localc, this.a);
      paramInt = localc.a;
      if (paramInt != 12)
      {
        switch (paramInt)
        {
        default: 
          throw new g("type mismatch.");
        case 5: 
          return this.a.getDouble();
        }
        return this.a.getFloat();
      }
      return 0.0D;
    }
    if (!paramBoolean) {
      return paramDouble;
    }
    throw new g("require field not exist.");
  }
  
  private float a(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      c localc = new c();
      a(localc, this.a);
      paramInt = localc.a;
      if (paramInt != 4)
      {
        if (paramInt == 12) {
          return 0.0F;
        }
        throw new g("type mismatch.");
      }
      return this.a.getFloat();
    }
    if (!paramBoolean) {
      return paramFloat;
    }
    throw new g("require field not exist.");
  }
  
  private static int a(c paramc, ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.get();
    paramc.a = ((byte)(i & 0xF));
    paramc.b = ((i & 0xF0) >> 4);
    if (paramc.b == 15)
    {
      paramc.b = paramByteBuffer.get();
      return 2;
    }
    return 1;
  }
  
  private <K, V> Map<K, V> a(Map<K, V> paramMap1, Map<K, V> paramMap2, int paramInt, boolean paramBoolean)
  {
    if ((paramMap2 != null) && (!paramMap2.isEmpty()))
    {
      Object localObject = (Map.Entry)paramMap2.entrySet().iterator().next();
      paramMap2 = ((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if (a(paramInt))
      {
        c localc = new c();
        a(localc, this.a);
        if (localc.a == 8)
        {
          int i = a(0, 0, true);
          if (i >= 0)
          {
            paramInt = 0;
            while (paramInt < i)
            {
              paramMap1.put(a(paramMap2, 0, true), a(localObject, 1, true));
              paramInt += 1;
            }
          }
          paramMap1 = new StringBuilder("size invalid: ");
          paramMap1.append(i);
          throw new g(paramMap1.toString());
        }
        throw new g("type mismatch.");
      }
      if (!paramBoolean) {
        return paramMap1;
      }
      throw new g("require field not exist.");
    }
    return new HashMap();
  }
  
  private void a()
  {
    c localc = new c();
    do
    {
      a(localc, this.a);
      a(localc.a);
    } while (localc.a != 11);
  }
  
  private void a(byte paramByte)
  {
    byte b2 = 0;
    byte b1 = 0;
    switch (paramByte)
    {
    default: 
      throw new g("invalid type.");
    case 13: 
      localObject = new c();
      a((c)localObject, this.a);
      if (((c)localObject).a == 0)
      {
        paramByte = a(0, 0, true);
        localObject = this.a;
        ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + paramByte);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("skipField with invalid type, type value: ");
      localStringBuilder.append(paramByte);
      localStringBuilder.append(", ");
      localStringBuilder.append(((c)localObject).a);
      throw new g(localStringBuilder.toString());
    case 11: 
    case 12: 
      return;
    case 10: 
      a();
      return;
    case 9: 
      b2 = a(0, 0, true);
      paramByte = b1;
      while (paramByte < b2)
      {
        localObject = new c();
        a((c)localObject, this.a);
        a(((c)localObject).a);
        paramByte += 1;
      }
      return;
    case 8: 
      b1 = a(0, 0, true);
      paramByte = b2;
      while (paramByte < b1 << 1)
      {
        localObject = new c();
        a((c)localObject, this.a);
        a(((c)localObject).a);
        paramByte += 1;
      }
      return;
    case 7: 
      paramByte = this.a.getInt();
      localObject = this.a;
      ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + paramByte);
      return;
    case 6: 
      b1 = this.a.get();
      paramByte = b1;
      if (b1 < 0) {
        paramByte = b1 + 256;
      }
      localObject = this.a;
      ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + paramByte);
      return;
    case 5: 
      localObject = this.a;
      ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + 8);
      return;
    case 4: 
      localObject = this.a;
      ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + 4);
      return;
    case 3: 
      localObject = this.a;
      ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + 8);
      return;
    case 2: 
      localObject = this.a;
      ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + 4);
      return;
    case 1: 
      localObject = this.a;
      ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + 2);
      return;
    }
    Object localObject = this.a;
    ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + 1);
  }
  
  private boolean a(int paramInt)
  {
    try
    {
      c localc = new c();
      for (;;)
      {
        i = a(localc, this.a.duplicate());
        if ((paramInt <= localc.b) || (localc.a == 11)) {
          break;
        }
        this.a.position(this.a.position() + i);
        a(localc.a);
      }
      int i = localc.b;
      return paramInt == i;
    }
    catch (g|BufferUnderflowException localg) {}
    return false;
  }
  
  private <T> T[] a(T[] paramArrayOfT, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayOfT != null) && (paramArrayOfT.length != 0)) {
      return b(paramArrayOfT[0], paramInt, paramBoolean);
    }
    throw new g("unable to get type of key and value.");
  }
  
  private <T> T[] b(T paramT, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      Object localObject = new c();
      a((c)localObject, this.a);
      if (((c)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          localObject = (Object[])Array.newInstance(paramT.getClass(), i);
          paramInt = 0;
          while (paramInt < i)
          {
            localObject[paramInt] = a(paramT, 0, true);
            paramInt += 1;
          }
          return localObject;
        }
        paramT = new StringBuilder("size invalid: ");
        paramT.append(i);
        throw new g(paramT.toString());
      }
      throw new g("type mismatch.");
    }
    if (!paramBoolean) {
      return null;
    }
    throw new g("require field not exist.");
  }
  
  private boolean[] d(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new c();
      a((c)localObject, this.a);
      if (((c)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          boolean[] arrayOfBoolean = new boolean[i];
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfBoolean;
            if (paramInt >= i) {
              break;
            }
            if (a((byte)0, 0, true) != 0) {
              paramBoolean = true;
            } else {
              paramBoolean = false;
            }
            arrayOfBoolean[paramInt] = paramBoolean;
            paramInt += 1;
          }
        }
        localObject = new StringBuilder("size invalid: ");
        ((StringBuilder)localObject).append(i);
        throw new g(((StringBuilder)localObject).toString());
      }
      throw new g("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return localObject;
    }
    throw new g("require field not exist.");
  }
  
  private short[] e(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new c();
      a((c)localObject, this.a);
      if (((c)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          short[] arrayOfShort = new short[i];
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfShort;
            if (paramInt >= i) {
              break;
            }
            arrayOfShort[paramInt] = a(arrayOfShort[0], 0, true);
            paramInt += 1;
          }
        }
        localObject = new StringBuilder("size invalid: ");
        ((StringBuilder)localObject).append(i);
        throw new g(((StringBuilder)localObject).toString());
      }
      throw new g("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return localObject;
    }
    throw new g("require field not exist.");
  }
  
  private int[] f(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new c();
      a((c)localObject, this.a);
      if (((c)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          int[] arrayOfInt = new int[i];
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfInt;
            if (paramInt >= i) {
              break;
            }
            arrayOfInt[paramInt] = a(arrayOfInt[0], 0, true);
            paramInt += 1;
          }
        }
        localObject = new StringBuilder("size invalid: ");
        ((StringBuilder)localObject).append(i);
        throw new g(((StringBuilder)localObject).toString());
      }
      throw new g("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return localObject;
    }
    throw new g("require field not exist.");
  }
  
  private long[] g(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new c();
      a((c)localObject, this.a);
      if (((c)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          long[] arrayOfLong = new long[i];
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfLong;
            if (paramInt >= i) {
              break;
            }
            arrayOfLong[paramInt] = a(arrayOfLong[0], 0, true);
            paramInt += 1;
          }
        }
        localObject = new StringBuilder("size invalid: ");
        ((StringBuilder)localObject).append(i);
        throw new g(((StringBuilder)localObject).toString());
      }
      throw new g("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return localObject;
    }
    throw new g("require field not exist.");
  }
  
  private float[] h(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new c();
      a((c)localObject, this.a);
      if (((c)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          float[] arrayOfFloat = new float[i];
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfFloat;
            if (paramInt >= i) {
              break;
            }
            arrayOfFloat[paramInt] = a(arrayOfFloat[0], 0, true);
            paramInt += 1;
          }
        }
        localObject = new StringBuilder("size invalid: ");
        ((StringBuilder)localObject).append(i);
        throw new g(((StringBuilder)localObject).toString());
      }
      throw new g("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return localObject;
    }
    throw new g("require field not exist.");
  }
  
  private double[] i(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new c();
      a((c)localObject, this.a);
      if (((c)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          double[] arrayOfDouble = new double[i];
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfDouble;
            if (paramInt >= i) {
              break;
            }
            arrayOfDouble[paramInt] = a(arrayOfDouble[0], 0, true);
            paramInt += 1;
          }
        }
        localObject = new StringBuilder("size invalid: ");
        ((StringBuilder)localObject).append(i);
        throw new g(((StringBuilder)localObject).toString());
      }
      throw new g("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return localObject;
    }
    throw new g("require field not exist.");
  }
  
  public final byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      c localc = new c();
      a(localc, this.a);
      paramInt = localc.a;
      if (paramInt != 0)
      {
        if (paramInt == 12) {
          return 0;
        }
        throw new g("type mismatch.");
      }
      return this.a.get();
    }
    if (!paramBoolean) {
      return paramByte;
    }
    throw new g("require field not exist.");
  }
  
  public final int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (a(paramInt2))
    {
      c localc = new c();
      a(localc, this.a);
      paramInt1 = localc.a;
      if (paramInt1 != 12)
      {
        switch (paramInt1)
        {
        default: 
          throw new g("type mismatch.");
        case 2: 
          return this.a.getInt();
        case 1: 
          return this.a.getShort();
        }
        return this.a.get();
      }
      return 0;
    }
    if (!paramBoolean) {
      return paramInt1;
    }
    throw new g("require field not exist.");
  }
  
  public final int a(String paramString)
  {
    this.b = paramString;
    return 0;
  }
  
  public final long a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      c localc = new c();
      a(localc, this.a);
      paramInt = localc.a;
      if (paramInt != 12)
      {
        switch (paramInt)
        {
        default: 
          throw new g("type mismatch.");
        case 3: 
          return this.a.getLong();
        case 2: 
          return this.a.getInt();
        case 1: 
          return this.a.getShort();
        }
        return this.a.get();
      }
      return 0L;
    }
    if (!paramBoolean) {
      return paramLong;
    }
    throw new g("require field not exist.");
  }
  
  public final j a(j paramj, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt)) {
      try
      {
        paramj = (j)paramj.getClass().newInstance();
        c localc = new c();
        a(localc, this.a);
        if (localc.a == 10)
        {
          paramj.a(this);
          a();
          return paramj;
        }
        throw new g("type mismatch.");
      }
      catch (Exception paramj)
      {
        throw new g(paramj.getMessage());
      }
    }
    if (!paramBoolean) {
      return null;
    }
    throw new g("require field not exist.");
  }
  
  public final <T> Object a(T paramT, int paramInt, boolean paramBoolean)
  {
    boolean bool2 = paramT instanceof Byte;
    int i = 0;
    boolean bool1 = false;
    if (bool2) {
      return Byte.valueOf(a((byte)0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Boolean))
    {
      if (a((byte)0, paramInt, paramBoolean) != 0) {
        bool1 = true;
      }
      return Boolean.valueOf(bool1);
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
      return String.valueOf(b(paramInt, paramBoolean));
    }
    if ((paramT instanceof Map))
    {
      paramT = (Map)paramT;
      return (HashMap)a(new HashMap(), paramT, paramInt, paramBoolean);
    }
    if ((paramT instanceof List))
    {
      paramT = (List)paramT;
      if ((paramT != null) && (!paramT.isEmpty()))
      {
        paramT = b(paramT.get(0), paramInt, paramBoolean);
        if (paramT == null) {
          return null;
        }
        ArrayList localArrayList = new ArrayList();
        paramInt = i;
        while (paramInt < paramT.length)
        {
          localArrayList.add(paramT[paramInt]);
          paramInt += 1;
        }
        return localArrayList;
      }
      return new ArrayList();
    }
    if ((paramT instanceof j)) {
      return a((j)paramT, paramInt, paramBoolean);
    }
    if (paramT.getClass().isArray())
    {
      if ((!(paramT instanceof byte[])) && (!(paramT instanceof Byte[])))
      {
        if ((paramT instanceof boolean[])) {
          return d(paramInt, paramBoolean);
        }
        if ((paramT instanceof short[])) {
          return e(paramInt, paramBoolean);
        }
        if ((paramT instanceof int[])) {
          return f(paramInt, paramBoolean);
        }
        if ((paramT instanceof long[])) {
          return g(paramInt, paramBoolean);
        }
        if ((paramT instanceof float[])) {
          return h(paramInt, paramBoolean);
        }
        if ((paramT instanceof double[])) {
          return i(paramInt, paramBoolean);
        }
        return a((Object[])paramT, paramInt, paramBoolean);
      }
      return c(paramInt, paramBoolean);
    }
    throw new g("read object error: unsupport type.");
  }
  
  public final <K, V> HashMap<K, V> a(Map<K, V> paramMap, int paramInt, boolean paramBoolean)
  {
    return (HashMap)a(new HashMap(), paramMap, paramInt, paramBoolean);
  }
  
  public final short a(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      c localc = new c();
      a(localc, this.a);
      paramInt = localc.a;
      if (paramInt != 12)
      {
        switch (paramInt)
        {
        default: 
          throw new g("type mismatch.");
        case 1: 
          return this.a.getShort();
        }
        return (short)this.a.get();
      }
      return 0;
    }
    if (!paramBoolean) {
      return paramShort;
    }
    throw new g("require field not exist.");
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = this.a;
    if (localByteBuffer != null) {
      localByteBuffer.clear();
    }
    this.a = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public final boolean a(int paramInt, boolean paramBoolean)
  {
    return a((byte)0, paramInt, paramBoolean) != 0;
  }
  
  public final String b(int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localObject = new c();
      a((c)localObject, this.a);
      switch (((c)localObject).a)
      {
      default: 
        throw new g("type mismatch.");
      case 7: 
        paramInt = this.a.getInt();
        if ((paramInt <= 104857600) && (paramInt >= 0))
        {
          localObject = new byte[paramInt];
          this.a.get((byte[])localObject);
        }
        break;
      }
    }
    try
    {
      str = new String((byte[])localObject, this.b);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      String str;
      label118:
      int i;
      break label118;
    }
    return new String((byte[])localObject);
    Object localObject = new StringBuilder("String too long: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new g(((StringBuilder)localObject).toString());
    i = this.a.get();
    paramInt = i;
    if (i < 0) {
      paramInt = i + 256;
    }
    localObject = new byte[paramInt];
    this.a.get((byte[])localObject);
    try
    {
      str = new String((byte[])localObject, this.b);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      label213:
      break label213;
    }
    return new String((byte[])localObject);
    if (!paramBoolean) {
      return null;
    }
    throw new g("require field not exist.");
  }
  
  public final byte[] c(int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      Object localObject = new c();
      a((c)localObject, this.a);
      int i = ((c)localObject).a;
      if (i != 9)
      {
        if (i == 13)
        {
          c localc = new c();
          a(localc, this.a);
          if (localc.a == 0)
          {
            i = a(0, 0, true);
            if (i >= 0)
            {
              localObject = new byte[i];
              this.a.get((byte[])localObject);
              return localObject;
            }
            localStringBuilder = new StringBuilder("invalid size, tag: ");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(", type: ");
            localStringBuilder.append(((c)localObject).a);
            localStringBuilder.append(", ");
            localStringBuilder.append(localc.a);
            localStringBuilder.append(", size: ");
            localStringBuilder.append(i);
            throw new g(localStringBuilder.toString());
          }
          StringBuilder localStringBuilder = new StringBuilder("type mismatch, tag: ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(", type: ");
          localStringBuilder.append(((c)localObject).a);
          localStringBuilder.append(", ");
          localStringBuilder.append(localc.a);
          throw new g(localStringBuilder.toString());
        }
        throw new g("type mismatch.");
      }
      i = a(0, 0, true);
      if (i >= 0)
      {
        localObject = new byte[i];
        paramInt = 0;
        while (paramInt < i)
        {
          localObject[paramInt] = a(localObject[0], 0, true);
          paramInt += 1;
        }
        return localObject;
      }
      localObject = new StringBuilder("size invalid: ");
      ((StringBuilder)localObject).append(i);
      throw new g(((StringBuilder)localObject).toString());
    }
    if (!paramBoolean) {
      return null;
    }
    throw new g("require field not exist.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.h
 * JD-Core Version:    0.7.0.1
 */