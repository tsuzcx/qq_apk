package com.tencent.turingfd.sdk.base;

import TT;;
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

public final class cy
{
  public ByteBuffer a;
  public String b = "GBK";
  
  public cy(byte[] paramArrayOfByte)
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
      throw new goto("type mismatch.");
      return this.a.get();
    }
    throw new goto("require field not exist.");
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
      throw new goto("type mismatch.");
      return this.a.getDouble();
      return this.a.getFloat();
    }
    throw new goto("require field not exist.");
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
      throw new goto("type mismatch.");
      return this.a.getFloat();
    }
    throw new goto("require field not exist.");
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
      throw new goto("type mismatch.");
      return this.a.getInt();
      return this.a.getShort();
      return this.a.get();
    }
    throw new goto("require field not exist.");
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
          throw new goto("type mismatch.");
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
    throw new goto("require field not exist.");
  }
  
  public break a(break parambreak, int paramInt, boolean paramBoolean)
  {
    ByteBuffer localByteBuffer = null;
    if (a(paramInt)) {}
    do
    {
      try
      {
        parambreak = (break)parambreak.getClass().newInstance();
        localByteBuffer = this.a;
        paramInt = localByteBuffer.get();
        int i = (byte)(paramInt & 0xF);
        if ((paramInt & 0xF0) >> 4 == 15) {
          localByteBuffer.get();
        }
        if (i == 10)
        {
          parambreak.a(this);
          a();
          return parambreak;
        }
        throw new goto("type mismatch.");
      }
      catch (Exception parambreak)
      {
        throw new goto(parambreak.getMessage());
      }
      parambreak = localByteBuffer;
    } while (!paramBoolean);
    throw new goto("require field not exist.");
  }
  
  public <T> Object a(T paramT, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    if ((paramT instanceof Byte))
    {
      paramT = Byte.valueOf(a((byte)0, paramInt, paramBoolean));
      return paramT;
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
    if ((paramT instanceof Map))
    {
      localObject1 = (Map)paramT;
      paramT = new HashMap();
      if ((localObject1 == null) || (((Map)localObject1).isEmpty())) {
        paramT = new HashMap();
      }
    }
    for (;;)
    {
      return paramT;
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
            throw new goto("type mismatch.");
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
              paramT.put(a(localObject1, 0, true), a(localObject2, 1, true));
              paramInt += 1;
            }
          }
          throw new goto(ci.a("size invalid: ", i));
        }
      }
      else if (paramBoolean)
      {
        throw new goto("require field not exist.");
        if ((paramT instanceof List))
        {
          paramT = (List)paramT;
          if ((paramT == null) || (paramT.isEmpty())) {
            return new ArrayList();
          }
          localObject2 = b(paramT.get(0), paramInt, paramBoolean);
          paramT = (TT)localObject1;
          if (localObject2 == null) {
            break;
          }
          localObject1 = new ArrayList();
          paramInt = 0;
          for (;;)
          {
            paramT = (TT)localObject1;
            if (paramInt >= localObject2.length) {
              break;
            }
            ((ArrayList)localObject1).add(localObject2[paramInt]);
            paramInt += 1;
          }
        }
        if ((paramT instanceof break)) {
          return a((break)paramT, paramInt, paramBoolean);
        }
        if (paramT.getClass().isArray())
        {
          if (((paramT instanceof byte[])) || ((paramT instanceof Byte[]))) {
            return a(null, paramInt, paramBoolean);
          }
          if ((paramT instanceof boolean[]))
          {
            if (a(paramInt))
            {
              paramT = this.a;
              paramInt = paramT.get();
              i = (byte)(paramInt & 0xF);
              if ((paramInt & 0xF0) >> 4 == 15) {
                paramT.get();
              }
              if (i != 9)
              {
                paramT = (TT)localObject1;
                if (i == 11) {
                  break;
                }
                throw new goto("type mismatch.");
              }
              i = a(0, 0, true);
              if (i >= 0)
              {
                localObject1 = new boolean[i];
                paramInt = 0;
                for (;;)
                {
                  paramT = (TT)localObject1;
                  if (paramInt >= i) {
                    break;
                  }
                  localObject1[paramInt] = a(localObject1[0], 0, true);
                  paramInt += 1;
                }
              }
              throw new goto(ci.a("size invalid: ", i));
            }
            paramT = (TT)localObject1;
            if (!paramBoolean) {
              break;
            }
            throw new goto("require field not exist.");
          }
          if ((paramT instanceof short[]))
          {
            if (a(paramInt))
            {
              paramT = this.a;
              paramInt = paramT.get();
              i = (byte)(paramInt & 0xF);
              if ((paramInt & 0xF0) >> 4 == 15) {
                paramT.get();
              }
              if (i != 9)
              {
                paramT = (TT)localObject1;
                if (i == 11) {
                  break;
                }
                throw new goto("type mismatch.");
              }
              i = a(0, 0, true);
              if (i >= 0)
              {
                localObject1 = new short[i];
                paramInt = 0;
                for (;;)
                {
                  paramT = (TT)localObject1;
                  if (paramInt >= i) {
                    break;
                  }
                  localObject1[paramInt] = a(localObject1[0], 0, true);
                  paramInt += 1;
                }
              }
              throw new goto(ci.a("size invalid: ", i));
            }
            paramT = (TT)localObject1;
            if (!paramBoolean) {
              break;
            }
            throw new goto("require field not exist.");
          }
          if ((paramT instanceof int[]))
          {
            if (a(paramInt))
            {
              paramT = this.a;
              paramInt = paramT.get();
              i = (byte)(paramInt & 0xF);
              if ((paramInt & 0xF0) >> 4 == 15) {
                paramT.get();
              }
              if (i != 9)
              {
                paramT = (TT)localObject1;
                if (i == 11) {
                  break;
                }
                throw new goto("type mismatch.");
              }
              i = a(0, 0, true);
              if (i >= 0)
              {
                localObject1 = new int[i];
                paramInt = 0;
                for (;;)
                {
                  paramT = (TT)localObject1;
                  if (paramInt >= i) {
                    break;
                  }
                  localObject1[paramInt] = a(localObject1[0], 0, true);
                  paramInt += 1;
                }
              }
              throw new goto(ci.a("size invalid: ", i));
            }
            paramT = (TT)localObject1;
            if (!paramBoolean) {
              break;
            }
            throw new goto("require field not exist.");
          }
          if ((paramT instanceof long[]))
          {
            if (a(paramInt))
            {
              paramT = this.a;
              paramInt = paramT.get();
              i = (byte)(paramInt & 0xF);
              if ((paramInt & 0xF0) >> 4 == 15) {
                paramT.get();
              }
              if (i != 9)
              {
                paramT = (TT)localObject1;
                if (i == 11) {
                  break;
                }
                throw new goto("type mismatch.");
              }
              i = a(0, 0, true);
              if (i >= 0)
              {
                localObject1 = new long[i];
                paramInt = 0;
                for (;;)
                {
                  paramT = (TT)localObject1;
                  if (paramInt >= i) {
                    break;
                  }
                  localObject1[paramInt] = a(localObject1[0], 0, true);
                  paramInt += 1;
                }
              }
              throw new goto(ci.a("size invalid: ", i));
            }
            paramT = (TT)localObject1;
            if (!paramBoolean) {
              break;
            }
            throw new goto("require field not exist.");
          }
          if ((paramT instanceof float[]))
          {
            paramT = (float[])null;
            if (a(paramInt))
            {
              paramT = this.a;
              paramInt = paramT.get();
              i = (byte)(paramInt & 0xF);
              if ((paramInt & 0xF0) >> 4 == 15) {
                paramT.get();
              }
              if (i != 9)
              {
                paramT = (TT)localObject1;
                if (i == 11) {
                  break;
                }
                throw new goto("type mismatch.");
              }
              i = a(0, 0, true);
              if (i >= 0)
              {
                localObject1 = new float[i];
                paramInt = 0;
                for (;;)
                {
                  paramT = (TT)localObject1;
                  if (paramInt >= i) {
                    break;
                  }
                  localObject1[paramInt] = a(localObject1[0], 0, true);
                  paramInt += 1;
                }
              }
              throw new goto(ci.a("size invalid: ", i));
            }
            paramT = (TT)localObject1;
            if (!paramBoolean) {
              break;
            }
            throw new goto("require field not exist.");
          }
          if ((paramT instanceof double[]))
          {
            if (a(paramInt))
            {
              paramT = this.a;
              paramInt = paramT.get();
              i = (byte)(paramInt & 0xF);
              if ((paramInt & 0xF0) >> 4 == 15) {
                paramT.get();
              }
              if (i != 9)
              {
                paramT = (TT)localObject1;
                if (i == 11) {
                  break;
                }
                throw new goto("type mismatch.");
              }
              i = a(0, 0, true);
              if (i >= 0)
              {
                localObject1 = new double[i];
                paramInt = 0;
                for (;;)
                {
                  paramT = (TT)localObject1;
                  if (paramInt >= i) {
                    break;
                  }
                  localObject1[paramInt] = a(localObject1[0], 0, true);
                  paramInt += 1;
                }
              }
              throw new goto(ci.a("size invalid: ", i));
            }
            paramT = (TT)localObject1;
            if (!paramBoolean) {
              break;
            }
            throw new goto("require field not exist.");
          }
          paramT = (Object[])paramT;
          if (paramT.length != 0) {
            return b(paramT[0], paramInt, paramBoolean);
          }
          throw new goto("unable to get type of key and value.");
        }
        throw new goto("read object error: unsupport type.");
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
      throw new goto("type mismatch.");
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
      throw new goto(ci.a("String too long: ", paramInt));
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
    throw new goto("require field not exist.");
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
      throw new goto("type mismatch.");
      return this.a.getShort();
      return (short)this.a.get();
    }
    throw new goto("require field not exist.");
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
      throw new goto("invalid type.");
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
      throw new goto("skipField with invalid type, type value: " + paramByte + ", " + b2);
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
      catch (goto localgoto)
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
      throw new goto("invalid size, tag: " + paramInt + ", type: " + i + ", " + j + ", size: " + k);
      throw new goto("type mismatch, tag: " + paramInt + ", type: " + i + ", " + j);
      throw new goto("type mismatch.");
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
      throw new goto(ci.a("size invalid: ", i));
    }
    throw new goto("require field not exist.");
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
  
  public final <T> T[] b(T paramT, int paramInt, boolean paramBoolean)
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
      throw new goto("type mismatch.");
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
      throw new goto(ci.a("size invalid: ", i));
    }
    throw new goto("require field not exist.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cy
 * JD-Core Version:    0.7.0.1
 */