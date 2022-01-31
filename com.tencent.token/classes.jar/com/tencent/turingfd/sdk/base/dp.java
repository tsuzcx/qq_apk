package com.tencent.turingfd.sdk.base;

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

public final class dp
{
  public ByteBuffer a;
  public String b = "GBK";
  
  public dp(byte[] paramArrayOfByte)
  {
    this.a = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localByteBuffer = this.a;
      paramInt = localByteBuffer.get();
      i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (i != 0) {
        if (i != 11)
        {
          if (i != 12) {
            break label68;
          }
          paramByte = 0;
        }
      }
    }
    label68:
    while (!paramBoolean)
    {
      ByteBuffer localByteBuffer;
      int i;
      return paramByte;
      throw new catch("type mismatch.");
      return this.a.get();
    }
    throw new catch("require field not exist.");
  }
  
  public double a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localByteBuffer = this.a;
      paramInt = localByteBuffer.get();
      i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (i != 4) {
        if (i != 5) {
          if (i != 11)
          {
            if (i != 12) {
              break label75;
            }
            paramDouble = 0.0D;
          }
        }
      }
    }
    label75:
    while (!paramBoolean)
    {
      ByteBuffer localByteBuffer;
      int i;
      return paramDouble;
      throw new catch("type mismatch.");
      return this.a.getDouble();
      return this.a.getFloat();
    }
    throw new catch("require field not exist.");
  }
  
  public float a(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localByteBuffer = this.a;
      paramInt = localByteBuffer.get();
      i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (i != 4) {
        if (i != 11)
        {
          if (i != 12) {
            break label69;
          }
          paramFloat = 0.0F;
        }
      }
    }
    label69:
    while (!paramBoolean)
    {
      ByteBuffer localByteBuffer;
      int i;
      return paramFloat;
      throw new catch("type mismatch.");
      return this.a.getFloat();
    }
    throw new catch("require field not exist.");
  }
  
  public int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (a(paramInt2))
    {
      localByteBuffer = this.a;
      i = localByteBuffer.get();
      paramInt2 = (byte)(i & 0xF);
      if ((i & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (paramInt2 != 0) {
        if (paramInt2 != 1) {
          if (paramInt2 != 2) {
            if (paramInt2 != 11)
            {
              if (paramInt2 != 12) {
                break label77;
              }
              paramInt1 = 0;
            }
          }
        }
      }
    }
    label77:
    while (!paramBoolean)
    {
      ByteBuffer localByteBuffer;
      int i;
      return paramInt1;
      throw new catch("type mismatch.");
      return this.a.getInt();
      return this.a.getShort();
      return this.a.get();
    }
    throw new catch("require field not exist.");
  }
  
  public long a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localByteBuffer = this.a;
      paramInt = localByteBuffer.get();
      i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (i != 11)
      {
        if (i == 12) {
          break label139;
        }
        switch (i)
        {
        default: 
          throw new catch("type mismatch.");
        case 3: 
          paramLong = this.a.getLong();
        }
      }
    }
    label139:
    while (!paramBoolean)
    {
      ByteBuffer localByteBuffer;
      int i;
      return paramLong;
      return this.a.getInt();
      return this.a.getShort();
      return this.a.get();
      return 0L;
    }
    throw new catch("require field not exist.");
  }
  
  public float a(float paramfloat, int paramInt, boolean paramBoolean)
  {
    ByteBuffer localByteBuffer = null;
    if (a(paramInt)) {}
    do
    {
      try
      {
        paramfloat = (float)paramfloat.getClass().newInstance();
        localByteBuffer = this.a;
        paramInt = localByteBuffer.get();
        int i = (byte)(paramInt & 0xF);
        if ((paramInt & 0xF0) >> 4 == 15) {
          localByteBuffer.get();
        }
        if (i == 10)
        {
          paramfloat.a(this);
          a();
          return paramfloat;
        }
        throw new catch("type mismatch.");
      }
      catch (Exception paramfloat)
      {
        throw new catch(paramfloat.getMessage());
      }
      paramfloat = localByteBuffer;
    } while (!paramBoolean);
    throw new catch("require field not exist.");
  }
  
  public Object a(Object paramObject, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    if ((paramObject instanceof Byte))
    {
      paramObject = Byte.valueOf(a((byte)0, paramInt, paramBoolean));
      return paramObject;
    }
    if ((paramObject instanceof Boolean)) {
      return Boolean.valueOf(a(false, paramInt, paramBoolean));
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
      localObject1 = (Map)paramObject;
      paramObject = new HashMap();
      if ((localObject1 == null) || (((Map)localObject1).isEmpty())) {
        paramObject = new HashMap();
      }
    }
    for (;;)
    {
      return paramObject;
      Object localObject2 = (Map.Entry)((Map)localObject1).entrySet().iterator().next();
      localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      int i;
      if (a(paramInt))
      {
        ByteBuffer localByteBuffer = this.a;
        paramInt = localByteBuffer.get();
        i = (byte)(paramInt & 0xF);
        if ((paramInt & 0xF0) >> 4 == 15) {
          localByteBuffer.get();
        }
        if (i != 8)
        {
          if (i != 11) {
            throw new catch("type mismatch.");
          }
        }
        else
        {
          i = a(0, 0, true);
          if (i >= 0)
          {
            paramInt = 0;
            while (paramInt < i)
            {
              paramObject.put(a(localObject1, 0, true), a(localObject2, 1, true));
              paramInt += 1;
            }
          }
          throw new catch(dt.a("size invalid: ", i));
        }
      }
      else if (paramBoolean)
      {
        throw new catch("require field not exist.");
        if ((paramObject instanceof List))
        {
          paramObject = (List)paramObject;
          if ((paramObject == null) || (paramObject.isEmpty())) {
            return new ArrayList();
          }
          localObject2 = b(paramObject.get(0), paramInt, paramBoolean);
          paramObject = localObject1;
          if (localObject2 == null) {
            break;
          }
          localObject1 = new ArrayList();
          paramInt = 0;
          for (;;)
          {
            paramObject = localObject1;
            if (paramInt >= localObject2.length) {
              break;
            }
            ((ArrayList)localObject1).add(localObject2[paramInt]);
            paramInt += 1;
          }
        }
        if ((paramObject instanceof float)) {
          return a((float)paramObject, paramInt, paramBoolean);
        }
        if (paramObject.getClass().isArray())
        {
          if (((paramObject instanceof byte[])) || ((paramObject instanceof Byte[]))) {
            return a(null, paramInt, paramBoolean);
          }
          if ((paramObject instanceof boolean[]))
          {
            if (a(paramInt))
            {
              paramObject = this.a;
              paramInt = paramObject.get();
              i = (byte)(paramInt & 0xF);
              if ((paramInt & 0xF0) >> 4 == 15) {
                paramObject.get();
              }
              if (i != 9)
              {
                paramObject = localObject1;
                if (i == 11) {
                  break;
                }
                throw new catch("type mismatch.");
              }
              i = a(0, 0, true);
              if (i >= 0)
              {
                localObject1 = new boolean[i];
                paramInt = 0;
                for (;;)
                {
                  paramObject = localObject1;
                  if (paramInt >= i) {
                    break;
                  }
                  localObject1[paramInt] = a(localObject1[0], 0, true);
                  paramInt += 1;
                }
              }
              throw new catch(dt.a("size invalid: ", i));
            }
            paramObject = localObject1;
            if (!paramBoolean) {
              break;
            }
            throw new catch("require field not exist.");
          }
          if ((paramObject instanceof short[]))
          {
            if (a(paramInt))
            {
              paramObject = this.a;
              paramInt = paramObject.get();
              i = (byte)(paramInt & 0xF);
              if ((paramInt & 0xF0) >> 4 == 15) {
                paramObject.get();
              }
              if (i != 9)
              {
                paramObject = localObject1;
                if (i == 11) {
                  break;
                }
                throw new catch("type mismatch.");
              }
              i = a(0, 0, true);
              if (i >= 0)
              {
                localObject1 = new short[i];
                paramInt = 0;
                for (;;)
                {
                  paramObject = localObject1;
                  if (paramInt >= i) {
                    break;
                  }
                  localObject1[paramInt] = a(localObject1[0], 0, true);
                  paramInt += 1;
                }
              }
              throw new catch(dt.a("size invalid: ", i));
            }
            paramObject = localObject1;
            if (!paramBoolean) {
              break;
            }
            throw new catch("require field not exist.");
          }
          if ((paramObject instanceof int[]))
          {
            if (a(paramInt))
            {
              paramObject = this.a;
              paramInt = paramObject.get();
              i = (byte)(paramInt & 0xF);
              if ((paramInt & 0xF0) >> 4 == 15) {
                paramObject.get();
              }
              if (i != 9)
              {
                paramObject = localObject1;
                if (i == 11) {
                  break;
                }
                throw new catch("type mismatch.");
              }
              i = a(0, 0, true);
              if (i >= 0)
              {
                localObject1 = new int[i];
                paramInt = 0;
                for (;;)
                {
                  paramObject = localObject1;
                  if (paramInt >= i) {
                    break;
                  }
                  localObject1[paramInt] = a(localObject1[0], 0, true);
                  paramInt += 1;
                }
              }
              throw new catch(dt.a("size invalid: ", i));
            }
            paramObject = localObject1;
            if (!paramBoolean) {
              break;
            }
            throw new catch("require field not exist.");
          }
          if ((paramObject instanceof long[]))
          {
            if (a(paramInt))
            {
              paramObject = this.a;
              paramInt = paramObject.get();
              i = (byte)(paramInt & 0xF);
              if ((paramInt & 0xF0) >> 4 == 15) {
                paramObject.get();
              }
              if (i != 9)
              {
                paramObject = localObject1;
                if (i == 11) {
                  break;
                }
                throw new catch("type mismatch.");
              }
              i = a(0, 0, true);
              if (i >= 0)
              {
                localObject1 = new long[i];
                paramInt = 0;
                for (;;)
                {
                  paramObject = localObject1;
                  if (paramInt >= i) {
                    break;
                  }
                  localObject1[paramInt] = a(localObject1[0], 0, true);
                  paramInt += 1;
                }
              }
              throw new catch(dt.a("size invalid: ", i));
            }
            paramObject = localObject1;
            if (!paramBoolean) {
              break;
            }
            throw new catch("require field not exist.");
          }
          if ((paramObject instanceof float[]))
          {
            paramObject = (float[])null;
            if (a(paramInt))
            {
              paramObject = this.a;
              paramInt = paramObject.get();
              i = (byte)(paramInt & 0xF);
              if ((paramInt & 0xF0) >> 4 == 15) {
                paramObject.get();
              }
              if (i != 9)
              {
                paramObject = localObject1;
                if (i == 11) {
                  break;
                }
                throw new catch("type mismatch.");
              }
              i = a(0, 0, true);
              if (i >= 0)
              {
                localObject1 = new float[i];
                paramInt = 0;
                for (;;)
                {
                  paramObject = localObject1;
                  if (paramInt >= i) {
                    break;
                  }
                  localObject1[paramInt] = a(localObject1[0], 0, true);
                  paramInt += 1;
                }
              }
              throw new catch(dt.a("size invalid: ", i));
            }
            paramObject = localObject1;
            if (!paramBoolean) {
              break;
            }
            throw new catch("require field not exist.");
          }
          if ((paramObject instanceof double[]))
          {
            if (a(paramInt))
            {
              paramObject = this.a;
              paramInt = paramObject.get();
              i = (byte)(paramInt & 0xF);
              if ((paramInt & 0xF0) >> 4 == 15) {
                paramObject.get();
              }
              if (i != 9)
              {
                paramObject = localObject1;
                if (i == 11) {
                  break;
                }
                throw new catch("type mismatch.");
              }
              i = a(0, 0, true);
              if (i >= 0)
              {
                localObject1 = new double[i];
                paramInt = 0;
                for (;;)
                {
                  paramObject = localObject1;
                  if (paramInt >= i) {
                    break;
                  }
                  localObject1[paramInt] = a(localObject1[0], 0, true);
                  paramInt += 1;
                }
              }
              throw new catch(dt.a("size invalid: ", i));
            }
            paramObject = localObject1;
            if (!paramBoolean) {
              break;
            }
            throw new catch("require field not exist.");
          }
          paramObject = (Object[])paramObject;
          if (paramObject.length != 0) {
            return b(paramObject[0], paramInt, paramBoolean);
          }
          throw new catch("unable to get type of key and value.");
        }
        throw new catch("read object error: unsupport type.");
      }
    }
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localObject = this.a;
      paramInt = ((ByteBuffer)localObject).get();
      i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        ((ByteBuffer)localObject).get();
      }
      if (i != 6) {
        if (i != 7) {
          if (i != 11) {}
        }
      }
    }
    while (!paramBoolean)
    {
      return null;
      throw new catch("type mismatch.");
      paramInt = this.a.getInt();
      if ((paramInt <= 104857600) && (paramInt >= 0))
      {
        localObject = new byte[paramInt];
        this.a.get((byte[])localObject);
        try
        {
          String str1 = new String((byte[])localObject, this.b);
          return str1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1)
        {
          return new String((byte[])localObject);
        }
      }
      throw new catch(dt.a("String too long: ", paramInt));
      int i = this.a.get();
      paramInt = i;
      if (i < 0) {
        paramInt = i + 256;
      }
      Object localObject = new byte[paramInt];
      this.a.get((byte[])localObject);
      try
      {
        String str2 = new String((byte[])localObject, this.b);
        return str2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        return new String((byte[])localObject);
      }
    }
    throw new catch("require field not exist.");
  }
  
  public short a(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localByteBuffer = this.a;
      paramInt = localByteBuffer.get();
      i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (i != 0) {
        if (i != 1) {
          if (i != 11)
          {
            if (i != 12) {
              break label74;
            }
            paramShort = 0;
          }
        }
      }
    }
    label74:
    while (!paramBoolean)
    {
      ByteBuffer localByteBuffer;
      int i;
      return paramShort;
      throw new catch("type mismatch.");
      return this.a.getShort();
      return (short)this.a.get();
    }
    throw new catch("require field not exist.");
  }
  
  public void a()
  {
    byte b1;
    do
    {
      if (this.a.remaining() == 0) {
        return;
      }
      ByteBuffer localByteBuffer = this.a;
      int i = localByteBuffer.get();
      b1 = (byte)(i & 0xF);
      if ((i & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      a(b1);
    } while (b1 != 11);
  }
  
  public final void a(byte paramByte)
  {
    byte b2 = 0;
    byte b1 = 0;
    switch (paramByte)
    {
    default: 
      throw new catch("invalid type.");
    case 13: 
      ByteBuffer localByteBuffer = this.a;
      b1 = localByteBuffer.get();
      b2 = (byte)(b1 & 0xF);
      if ((b1 & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (b2 == 0) {
        b(a(0, 0, true));
      }
    case 11: 
    case 12: 
      return;
      throw new catch("skipField with invalid type, type value: " + paramByte + ", " + b2);
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
      b(this.a.getInt());
      return;
    case 6: 
      b1 = this.a.get();
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
  
  public boolean a(int paramInt)
  {
    int i;
    byte b1;
    int j;
    for (;;)
    {
      try
      {
        ByteBuffer localByteBuffer = this.a.duplicate();
        i = localByteBuffer.get();
        b1 = (byte)(i & 0xF);
        i = (i & 0xF0) >> 4;
        if (i != 15) {
          break label94;
        }
        i = localByteBuffer.get() & 0xFF;
        j = 2;
      }
      catch (catch localcatch)
      {
        return false;
        return false;
      }
      catch (BufferUnderflowException localBufferUnderflowException)
      {
        continue;
      }
      b(j);
      a(b1);
    }
    while ((paramInt <= i) || (b1 == 11)) {
      if (paramInt == i)
      {
        return true;
        label94:
        j = 1;
      }
    }
  }
  
  public boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return a((byte)paramBoolean1, paramInt, paramBoolean2) != 0;
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    paramArrayOfByte = null;
    if (a(paramInt))
    {
      localObject = this.a;
      j = ((ByteBuffer)localObject).get();
      i = (byte)(j & 0xF);
      if ((j & 0xF0) >> 4 == 15) {
        ((ByteBuffer)localObject).get();
      }
      if (i != 9) {
        if (i != 11)
        {
          if (i != 13) {
            break label254;
          }
          paramArrayOfByte = this.a;
          k = paramArrayOfByte.get();
          j = (byte)(k & 0xF);
          if ((k & 0xF0) >> 4 == 15) {
            paramArrayOfByte.get();
          }
          if (j != 0) {
            break label204;
          }
          k = a(0, 0, true);
          if (k < 0) {
            break label143;
          }
          paramArrayOfByte = new byte[k];
          this.a.get(paramArrayOfByte);
        }
      }
    }
    label143:
    label204:
    label254:
    while (!paramBoolean)
    {
      Object localObject;
      int j;
      int k;
      return paramArrayOfByte;
      throw new catch("invalid size, tag: " + paramInt + ", type: " + i + ", " + j + ", size: " + k);
      throw new catch("type mismatch, tag: " + paramInt + ", type: " + i + ", " + j);
      throw new catch("type mismatch.");
      int i = a(0, 0, true);
      if (i >= 0)
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
      throw new catch(dt.a("size invalid: ", i));
    }
    throw new catch("require field not exist.");
  }
  
  public final void b()
  {
    ByteBuffer localByteBuffer = this.a;
    int i = localByteBuffer.get();
    byte b1 = (byte)(i & 0xF);
    if ((i & 0xF0) >> 4 == 15) {
      localByteBuffer.get();
    }
    a(b1);
  }
  
  public final void b(int paramInt)
  {
    ByteBuffer localByteBuffer = this.a;
    localByteBuffer.position(localByteBuffer.position() + paramInt);
  }
  
  public final Object[] b(Object paramObject, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localObject = this.a;
      paramInt = ((ByteBuffer)localObject).get();
      i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        ((ByteBuffer)localObject).get();
      }
      if (i != 9) {
        if (i != 11) {}
      }
    }
    while (!paramBoolean)
    {
      Object localObject = null;
      return localObject;
      throw new catch("type mismatch.");
      int i = a(0, 0, true);
      if (i >= 0)
      {
        Object[] arrayOfObject = (Object[])Array.newInstance(paramObject.getClass(), i);
        paramInt = 0;
        for (;;)
        {
          localObject = arrayOfObject;
          if (paramInt >= i) {
            break;
          }
          arrayOfObject[paramInt] = a(paramObject, 0, true);
          paramInt += 1;
        }
      }
      throw new catch(dt.a("size invalid: ", i));
    }
    throw new catch("require field not exist.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.dp
 * JD-Core Version:    0.7.0.1
 */