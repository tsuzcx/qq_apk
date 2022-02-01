package com.tencent.token;

import TT;;
import com.tencent.turingfd.sdk.base.break;
import com.tencent.turingfd.sdk.base.goto;
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

public final class afk
{
  public ByteBuffer a;
  public String b = "GBK";
  
  public afk(byte[] paramArrayOfByte)
  {
    this.a = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  private byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      ByteBuffer localByteBuffer = this.a;
      paramInt = localByteBuffer.get();
      int i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (i != 0)
      {
        if (i != 11)
        {
          if (i == 12) {
            return 0;
          }
          throw new goto("type mismatch.");
        }
      }
      else {
        return this.a.get();
      }
    }
    else
    {
      if (paramBoolean) {
        break label90;
      }
    }
    return paramByte;
    label90:
    throw new goto("require field not exist.");
  }
  
  private void a()
  {
    byte b1;
    do
    {
      if (this.a.remaining() == 0) {
        break;
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
  
  private void a(byte paramByte)
  {
    byte b2 = 0;
    byte b1 = 0;
    switch (paramByte)
    {
    default: 
      throw new goto("invalid type.");
    case 13: 
      Object localObject = this.a;
      b1 = ((ByteBuffer)localObject).get();
      b2 = (byte)(b1 & 0xF);
      if ((b1 & 0xF0) >> 4 == 15) {
        ((ByteBuffer)localObject).get();
      }
      if (b2 == 0)
      {
        b(a(0, 0, true));
        return;
      }
      localObject = new StringBuilder("skipField with invalid type, type value: ");
      ((StringBuilder)localObject).append(paramByte);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(b2);
      throw new goto(((StringBuilder)localObject).toString());
    case 10: 
      a();
      return;
    case 9: 
      b2 = a(0, 0, true);
      paramByte = b1;
    case 8: 
    case 7: 
    case 6: 
    case 5: 
    case 4: 
    case 3: 
    case 2: 
    case 1: 
    case 0: 
      while (paramByte < b2)
      {
        b();
        paramByte += 1;
        continue;
        b1 = a(0, 0, true);
        paramByte = b2;
        while (paramByte < b1 * 2)
        {
          b();
          paramByte += 1;
          continue;
          b(this.a.getInt());
          return;
          b1 = this.a.get();
          paramByte = b1;
          if (b1 < 0) {
            paramByte = b1 + 256;
          }
          b(paramByte);
          return;
          b(8);
          return;
          b(4);
          return;
          b(8);
          return;
          b(4);
          return;
          b(2);
          return;
          b(1);
        }
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    for (;;)
    {
      try
      {
        ByteBuffer localByteBuffer = this.a.duplicate();
        i = localByteBuffer.get();
        byte b1 = (byte)(i & 0xF);
        int j = (i & 0xF0) >> 4;
        if (j == 15)
        {
          j = localByteBuffer.get() & 0xFF;
          i = 2;
          if ((paramInt > j) && (b1 != 11))
          {
            b(i);
            a(b1);
            continue;
          }
          return paramInt == j;
        }
      }
      catch (goto|BufferUnderflowException localgoto)
      {
        return false;
      }
      int i = 1;
    }
  }
  
  private void b()
  {
    ByteBuffer localByteBuffer = this.a;
    int i = localByteBuffer.get();
    byte b1 = (byte)(i & 0xF);
    if ((i & 0xF0) >> 4 == 15) {
      localByteBuffer.get();
    }
    a(b1);
  }
  
  private void b(int paramInt)
  {
    ByteBuffer localByteBuffer = this.a;
    localByteBuffer.position(localByteBuffer.position() + paramInt);
  }
  
  private <T> T[] b(T paramT, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      Object localObject = this.a;
      paramInt = ((ByteBuffer)localObject).get();
      int i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        ((ByteBuffer)localObject).get();
      }
      if (i != 9)
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
          localObject = (Object[])Array.newInstance(paramT.getClass(), i);
          paramInt = 0;
          while (paramInt < i)
          {
            localObject[paramInt] = a(paramT, 0, true);
            paramInt += 1;
          }
          return localObject;
        }
        throw new goto(aeu.a("size invalid: ", i));
      }
    }
    else
    {
      if (paramBoolean) {
        break label150;
      }
    }
    return null;
    label150:
    throw new goto("require field not exist.");
  }
  
  public final double a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      ByteBuffer localByteBuffer = this.a;
      paramInt = localByteBuffer.get();
      int i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (i != 4)
      {
        if (i != 5)
        {
          if (i != 11)
          {
            if (i == 12) {
              return 0.0D;
            }
            throw new goto("type mismatch.");
          }
        }
        else {
          return this.a.getDouble();
        }
      }
      else {
        return this.a.getFloat();
      }
    }
    else
    {
      if (paramBoolean) {
        break label107;
      }
    }
    return paramDouble;
    label107:
    throw new goto("require field not exist.");
  }
  
  public final float a(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      ByteBuffer localByteBuffer = this.a;
      paramInt = localByteBuffer.get();
      int i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (i != 4)
      {
        if (i != 11)
        {
          if (i == 12) {
            return 0.0F;
          }
          throw new goto("type mismatch.");
        }
      }
      else {
        return this.a.getFloat();
      }
    }
    else
    {
      if (paramBoolean) {
        break label91;
      }
    }
    return paramFloat;
    label91:
    throw new goto("require field not exist.");
  }
  
  public final int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (a(paramInt2))
    {
      ByteBuffer localByteBuffer = this.a;
      paramInt2 = localByteBuffer.get();
      int i = (byte)(paramInt2 & 0xF);
      if ((paramInt2 & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 11)
            {
              if (i == 12) {
                return 0;
              }
              throw new goto("type mismatch.");
            }
          }
          else {
            return this.a.getInt();
          }
        }
        else {
          return this.a.getShort();
        }
      }
      else {
        return this.a.get();
      }
    }
    else
    {
      if (paramBoolean) {
        break label118;
      }
    }
    return paramInt1;
    label118:
    throw new goto("require field not exist.");
  }
  
  public final long a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      ByteBuffer localByteBuffer = this.a;
      paramInt = localByteBuffer.get();
      int i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (i != 11)
      {
        if (i != 12)
        {
          switch (i)
          {
          default: 
            throw new goto("type mismatch.");
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
    }
    else
    {
      if (paramBoolean) {
        break label146;
      }
    }
    return paramLong;
    label146:
    throw new goto("require field not exist.");
  }
  
  public final break a(break parambreak, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt)) {
      try
      {
        parambreak = (break)parambreak.getClass().newInstance();
        ByteBuffer localByteBuffer = this.a;
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
    }
    if (!paramBoolean) {
      return null;
    }
    throw new goto("require field not exist.");
  }
  
  public final <T> Object a(T paramT, int paramInt, boolean paramBoolean)
  {
    boolean bool = paramT instanceof Byte;
    int i = 0;
    if (bool) {
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
    if ((paramT instanceof Map))
    {
      paramT = (Map)paramT;
      localObject1 = new HashMap();
      if ((paramT != null) && (!paramT.isEmpty()))
      {
        paramT = (Map.Entry)paramT.entrySet().iterator().next();
        localObject2 = paramT.getKey();
        localObject3 = paramT.getValue();
        if (a(paramInt))
        {
          paramT = this.a;
          paramInt = paramT.get();
          i = (byte)(paramInt & 0xF);
          if ((paramInt & 0xF0) >> 4 == 15) {
            paramT.get();
          }
          if (i != 8)
          {
            if (i == 11) {
              return localObject1;
            }
            throw new goto("type mismatch.");
          }
          i = a(0, 0, true);
          if (i >= 0)
          {
            paramInt = 0;
            for (;;)
            {
              paramT = (TT)localObject1;
              if (paramInt >= i) {
                break;
              }
              ((Map)localObject1).put(a(localObject2, 0, true), a(localObject3, 1, true));
              paramInt += 1;
            }
          }
          throw new goto(aeu.a("size invalid: ", i));
        }
        if (!paramBoolean) {
          return localObject1;
        }
        throw new goto("require field not exist.");
      }
      paramT = new HashMap();
      return paramT;
    }
    bool = paramT instanceof List;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject1 = null;
    if (bool)
    {
      paramT = (List)paramT;
      if ((paramT != null) && (!paramT.isEmpty()))
      {
        localObject2 = b(paramT.get(0), paramInt, paramBoolean);
        if (localObject2 == null) {
          return null;
        }
        localObject1 = new ArrayList();
        paramInt = i;
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
      paramT = new ArrayList();
      return paramT;
    }
    if ((paramT instanceof break)) {
      return a((break)paramT, paramInt, paramBoolean);
    }
    if (paramT.getClass().isArray())
    {
      if ((!(paramT instanceof byte[])) && (!(paramT instanceof Byte[])))
      {
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
              if (i == 11) {
                return null;
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
            throw new goto(aeu.a("size invalid: ", i));
          }
          if (!paramBoolean)
          {
            paramT = (TT)localObject1;
            return paramT;
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
              if (i == 11) {
                return null;
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
            throw new goto(aeu.a("size invalid: ", i));
          }
          if (!paramBoolean)
          {
            paramT = (TT)localObject2;
            return paramT;
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
              if (i == 11) {
                return null;
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
            throw new goto(aeu.a("size invalid: ", i));
          }
          if (!paramBoolean)
          {
            paramT = localObject3;
            return paramT;
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
              if (i == 11) {
                return null;
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
            throw new goto(aeu.a("size invalid: ", i));
          }
          if (!paramBoolean)
          {
            paramT = localObject4;
            return paramT;
          }
          throw new goto("require field not exist.");
        }
        if ((paramT instanceof float[]))
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
              if (i == 11) {
                return null;
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
            throw new goto(aeu.a("size invalid: ", i));
          }
          if (!paramBoolean)
          {
            paramT = localObject5;
            return paramT;
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
              if (i == 11) {
                return null;
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
            throw new goto(aeu.a("size invalid: ", i));
          }
          if (!paramBoolean)
          {
            paramT = localObject6;
            return paramT;
          }
          throw new goto("require field not exist.");
        }
        paramT = (Object[])paramT;
        if (paramT.length != 0) {
          return b(paramT[0], paramInt, paramBoolean);
        }
        throw new goto("unable to get type of key and value.");
      }
      return b(paramInt, paramBoolean);
    }
    throw new goto("read object error: unsupport type.");
  }
  
  public final String a(int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localObject = this.a;
      paramInt = ((ByteBuffer)localObject).get();
      i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        ((ByteBuffer)localObject).get();
      }
      if (i != 6)
      {
        if (i != 7)
        {
          if (i == 11) {
            break label219;
          }
          throw new goto("type mismatch.");
        }
        paramInt = this.a.getInt();
        if ((paramInt <= 104857600) && (paramInt >= 0))
        {
          localObject = new byte[paramInt];
          this.a.get((byte[])localObject);
        }
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
      label127:
      break label127;
    }
    return new String((byte[])localObject);
    throw new goto(aeu.a("String too long: ", paramInt));
    int i = this.a.get();
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
      label205:
      label219:
      break label205;
    }
    return new String((byte[])localObject);
    if (!paramBoolean) {
      return null;
    }
    throw new goto("require field not exist.");
  }
  
  public final short a(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      ByteBuffer localByteBuffer = this.a;
      paramInt = localByteBuffer.get();
      int i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 11)
          {
            if (i == 12) {
              return 0;
            }
            throw new goto("type mismatch.");
          }
        }
        else {
          return this.a.getShort();
        }
      }
      else {
        return (short)this.a.get();
      }
    }
    else
    {
      if (paramBoolean) {
        break label105;
      }
    }
    return paramShort;
    label105:
    throw new goto("require field not exist.");
  }
  
  public final boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return a((byte)paramBoolean1, paramInt, paramBoolean2) != 0;
  }
  
  public final byte[] b(int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      Object localObject = this.a;
      int j = ((ByteBuffer)localObject).get();
      int i = (byte)(j & 0xF);
      if ((j & 0xF0) >> 4 == 15) {
        ((ByteBuffer)localObject).get();
      }
      if (i != 9)
      {
        if (i != 11)
        {
          if (i == 13)
          {
            localObject = this.a;
            int k = ((ByteBuffer)localObject).get();
            j = (byte)(k & 0xF);
            if ((k & 0xF0) >> 4 == 15) {
              ((ByteBuffer)localObject).get();
            }
            if (j == 0)
            {
              k = a(0, 0, true);
              if (k >= 0)
              {
                localObject = new byte[k];
                this.a.get((byte[])localObject);
                return localObject;
              }
              localObject = new StringBuilder("invalid size, tag: ");
              ((StringBuilder)localObject).append(paramInt);
              ((StringBuilder)localObject).append(", type: ");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append(", ");
              ((StringBuilder)localObject).append(j);
              ((StringBuilder)localObject).append(", size: ");
              ((StringBuilder)localObject).append(k);
              throw new goto(((StringBuilder)localObject).toString());
            }
            localObject = new StringBuilder("type mismatch, tag: ");
            ((StringBuilder)localObject).append(paramInt);
            ((StringBuilder)localObject).append(", type: ");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(", ");
            ((StringBuilder)localObject).append(j);
            throw new goto(((StringBuilder)localObject).toString());
          }
          throw new goto("type mismatch.");
        }
      }
      else
      {
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
        throw new goto(aeu.a("size invalid: ", i));
      }
    }
    else
    {
      if (paramBoolean) {
        break label366;
      }
    }
    return null;
    label366:
    throw new goto("require field not exist.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afk
 * JD-Core Version:    0.7.0.1
 */