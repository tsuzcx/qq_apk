package com.tencent.token;

import com.tencent.halley.common.b.c;
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

public final class lj
{
  ByteBuffer a;
  public String b = "GBK";
  
  public lj() {}
  
  public lj(byte[] paramArrayOfByte)
  {
    this.a = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public lj(byte[] paramArrayOfByte, byte paramByte)
  {
    this.a = ByteBuffer.wrap(paramArrayOfByte);
    this.a.position(4);
  }
  
  private double a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      a locala = new a();
      a(locala, this.a);
      paramInt = locala.a;
      if (paramInt != 12)
      {
        switch (paramInt)
        {
        default: 
          throw new RuntimeException("type mismatch.");
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
    throw new RuntimeException("require field not exist.");
  }
  
  private float a(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      a locala = new a();
      a(locala, this.a);
      paramInt = locala.a;
      if (paramInt != 4)
      {
        if (paramInt == 12) {
          return 0.0F;
        }
        throw new RuntimeException("type mismatch.");
      }
      return this.a.getFloat();
    }
    if (!paramBoolean) {
      return paramFloat;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  private static int a(a parama, ByteBuffer paramByteBuffer)
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
  
  private void a()
  {
    a locala = new a();
    do
    {
      a(locala, this.a);
      a(locala.a);
    } while (locala.a != 11);
  }
  
  private void a(byte paramByte)
  {
    byte b2 = 0;
    byte b1 = 0;
    switch (paramByte)
    {
    default: 
      throw new RuntimeException("invalid type.");
    case 13: 
      localObject = new a();
      a((a)localObject, this.a);
      if (((a)localObject).a == 0)
      {
        paramByte = a(0, 0, true);
        localObject = this.a;
        ((ByteBuffer)localObject).position(((ByteBuffer)localObject).position() + paramByte);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("skipField with invalid type, type value: ");
      localStringBuilder.append(paramByte);
      localStringBuilder.append(", ");
      localStringBuilder.append(((a)localObject).a);
      throw new RuntimeException(localStringBuilder.toString());
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
        localObject = new a();
        a((a)localObject, this.a);
        a(((a)localObject).a);
        paramByte += 1;
      }
      return;
    case 8: 
      b1 = a(0, 0, true);
      paramByte = b2;
      while (paramByte < b1 << 1)
      {
        localObject = new a();
        a((a)localObject, this.a);
        a(((a)localObject).a);
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
      a locala = new a();
      for (;;)
      {
        int i = a(locala, this.a.duplicate());
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
        this.a.position(this.a.position() + i);
        a(locala.a);
      }
      return false;
    }
    catch (BufferUnderflowException|RuntimeException localBufferUnderflowException)
    {
      return false;
    }
  }
  
  private Object[] b(Object paramObject, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      Object localObject = new a();
      a((a)localObject, this.a);
      if (((a)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          localObject = (Object[])Array.newInstance(paramObject.getClass(), i);
          paramInt = 0;
          while (paramInt < i)
          {
            localObject[paramInt] = a(paramObject, 0, true);
            paramInt += 1;
          }
          return localObject;
        }
        throw new RuntimeException("size invalid: ".concat(String.valueOf(i)));
      }
      throw new RuntimeException("type mismatch.");
    }
    if (!paramBoolean) {
      return null;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  private boolean[] c(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      if (((a)localObject).a == 9)
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
        throw new RuntimeException("size invalid: ".concat(String.valueOf(i)));
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
  
  private short[] d(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      if (((a)localObject).a == 9)
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
        throw new RuntimeException("size invalid: ".concat(String.valueOf(i)));
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
  
  private int[] e(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      if (((a)localObject).a == 9)
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
        throw new RuntimeException("size invalid: ".concat(String.valueOf(i)));
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
  
  private long[] f(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      if (((a)localObject).a == 9)
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
        throw new RuntimeException("size invalid: ".concat(String.valueOf(i)));
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
  
  private float[] g(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      if (((a)localObject).a == 9)
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
        throw new RuntimeException("size invalid: ".concat(String.valueOf(i)));
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
  
  private double[] h(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      if (((a)localObject).a == 9)
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
        throw new RuntimeException("size invalid: ".concat(String.valueOf(i)));
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
  
  public final byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      a locala = new a();
      a(locala, this.a);
      paramInt = locala.a;
      if (paramInt != 0)
      {
        if (paramInt == 12) {
          return 0;
        }
        throw new RuntimeException("type mismatch.");
      }
      return this.a.get();
    }
    if (!paramBoolean) {
      return paramByte;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public final int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (a(paramInt2))
    {
      a locala = new a();
      a(locala, this.a);
      paramInt1 = locala.a;
      if (paramInt1 != 12)
      {
        switch (paramInt1)
        {
        default: 
          throw new RuntimeException("type mismatch.");
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
    throw new RuntimeException("require field not exist.");
  }
  
  public final long a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      a locala = new a();
      a(locala, this.a);
      paramInt = locala.a;
      if (paramInt != 12)
      {
        switch (paramInt)
        {
        default: 
          throw new RuntimeException("type mismatch.");
        case 3: 
          return this.a.getLong();
        case 2: 
          paramInt = this.a.getInt();
          break;
        case 1: 
          paramInt = this.a.getShort();
          break;
        case 0: 
          paramInt = this.a.get();
        }
        return paramInt;
      }
      return 0L;
    }
    if (!paramBoolean) {
      return paramLong;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public final c a(c paramc, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt)) {
      try
      {
        paramc = (c)paramc.getClass().newInstance();
        a locala = new a();
        a(locala, this.a);
        if (locala.a == 10)
        {
          paramc.a(this);
          a();
          return paramc;
        }
        throw new RuntimeException("type mismatch.");
      }
      catch (Exception paramc)
      {
        throw new RuntimeException(paramc.getMessage());
      }
    }
    if (!paramBoolean) {
      return null;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public final Object a(Object paramObject, int paramInt, boolean paramBoolean)
  {
    boolean bool2 = paramObject instanceof Byte;
    int i = 0;
    boolean bool1 = false;
    if (bool2) {
      return Byte.valueOf(a((byte)0, paramInt, paramBoolean));
    }
    if ((paramObject instanceof Boolean))
    {
      if (a((byte)0, paramInt, paramBoolean) != 0) {
        bool1 = true;
      }
      return Boolean.valueOf(bool1);
    }
    if ((paramObject instanceof Short)) {
      return Short.valueOf(a((short)0, paramInt, paramBoolean));
    }
    if ((paramObject instanceof Integer)) {
      return Integer.valueOf(a(0, paramInt, paramBoolean));
    }
    if ((paramObject instanceof Long)) {
      return Long.valueOf(a(0L, paramInt, paramBoolean));
    }
    if ((paramObject instanceof Float)) {
      return Float.valueOf(a(0.0F, paramInt, paramBoolean));
    }
    if ((paramObject instanceof Double)) {
      return Double.valueOf(a(0.0D, paramInt, paramBoolean));
    }
    if ((paramObject instanceof String)) {
      return a(paramInt, paramBoolean);
    }
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      return (HashMap)a(new HashMap(), paramObject, paramInt, paramBoolean);
    }
    if ((paramObject instanceof List))
    {
      paramObject = (List)paramObject;
      if ((paramObject != null) && (!paramObject.isEmpty()))
      {
        paramObject = b(paramObject.get(0), paramInt, paramBoolean);
        if (paramObject == null) {
          return null;
        }
        ArrayList localArrayList = new ArrayList();
        paramInt = i;
        while (paramInt < paramObject.length)
        {
          localArrayList.add(paramObject[paramInt]);
          paramInt += 1;
        }
        return localArrayList;
      }
      return new ArrayList();
    }
    if ((paramObject instanceof c)) {
      return a((c)paramObject, paramInt, paramBoolean);
    }
    if (paramObject.getClass().isArray())
    {
      if ((!(paramObject instanceof byte[])) && (!(paramObject instanceof Byte[])))
      {
        if ((paramObject instanceof boolean[])) {
          return c(paramInt, paramBoolean);
        }
        if ((paramObject instanceof short[])) {
          return d(paramInt, paramBoolean);
        }
        if ((paramObject instanceof int[])) {
          return e(paramInt, paramBoolean);
        }
        if ((paramObject instanceof long[])) {
          return f(paramInt, paramBoolean);
        }
        if ((paramObject instanceof float[])) {
          return g(paramInt, paramBoolean);
        }
        if ((paramObject instanceof double[])) {
          return h(paramInt, paramBoolean);
        }
        paramObject = (Object[])paramObject;
        if ((paramObject != null) && (paramObject.length != 0)) {
          return b(paramObject[0], paramInt, paramBoolean);
        }
        throw new RuntimeException("unable to get type of key and value.");
      }
      return b(paramInt, paramBoolean);
    }
    throw new RuntimeException("read object error: unsupport type.");
  }
  
  public final String a(int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      switch (((a)localObject).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      case 7: 
        paramInt = this.a.getInt();
        if ((paramInt <= 104857600) && (paramInt >= 0) && (paramInt <= this.a.capacity()))
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
      label129:
      int i;
      break label129;
    }
    return new String((byte[])localObject);
    throw new RuntimeException("String too long: ".concat(String.valueOf(paramInt)));
    i = this.a.get();
    paramInt = i;
    if (i < 0) {
      paramInt = i + 256;
    }
    Object localObject = new byte[paramInt];
    this.a.get((byte[])localObject);
    try
    {
      str = new String((byte[])localObject, this.b);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      label210:
      break label210;
    }
    return new String((byte[])localObject);
    if (!paramBoolean) {
      return null;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public final Map a(Map paramMap1, Map paramMap2, int paramInt, boolean paramBoolean)
  {
    if ((paramMap2 != null) && (!paramMap2.isEmpty()))
    {
      Object localObject = (Map.Entry)paramMap2.entrySet().iterator().next();
      paramMap2 = ((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if (a(paramInt))
      {
        a locala = new a();
        a(locala, this.a);
        if (locala.a == 8)
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
          throw new RuntimeException("size invalid: ".concat(String.valueOf(i)));
        }
        throw new RuntimeException("type mismatch.");
      }
      if (!paramBoolean) {
        return paramMap1;
      }
      throw new RuntimeException("require field not exist.");
    }
    return new HashMap();
  }
  
  public final short a(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      a locala = new a();
      a(locala, this.a);
      paramInt = locala.a;
      if (paramInt != 12)
      {
        switch (paramInt)
        {
        default: 
          throw new RuntimeException("type mismatch.");
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
    throw new RuntimeException("require field not exist.");
  }
  
  public final byte[] b(int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      Object localObject = new a();
      a((a)localObject, this.a);
      int i = ((a)localObject).a;
      if (i != 9)
      {
        if (i == 13)
        {
          a locala = new a();
          a(locala, this.a);
          if (locala.a == 0)
          {
            i = a(0, 0, true);
            if ((i >= 0) && (i <= this.a.capacity()))
            {
              localObject = new byte[i];
              this.a.get((byte[])localObject);
              return localObject;
            }
            localStringBuilder = new StringBuilder("invalid size, tag: ");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(", type: ");
            localStringBuilder.append(((a)localObject).a);
            localStringBuilder.append(", ");
            localStringBuilder.append(locala.a);
            localStringBuilder.append(", size: ");
            localStringBuilder.append(i);
            throw new RuntimeException(localStringBuilder.toString());
          }
          StringBuilder localStringBuilder = new StringBuilder("type mismatch, tag: ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(", type: ");
          localStringBuilder.append(((a)localObject).a);
          localStringBuilder.append(", ");
          localStringBuilder.append(locala.a);
          throw new RuntimeException(localStringBuilder.toString());
        }
        throw new RuntimeException("type mismatch.");
      }
      i = a(0, 0, true);
      if ((i >= 0) && (i <= this.a.capacity()))
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
      throw new RuntimeException("size invalid: ".concat(String.valueOf(i)));
    }
    if (!paramBoolean) {
      return null;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public static final class a
  {
    public byte a;
    public int b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.lj
 * JD-Core Version:    0.7.0.1
 */