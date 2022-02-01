package com.qq.taf.jce;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class JceInputStream
{
  private ByteBuffer bs;
  protected String sServerEncoding = "GBK";
  
  public JceInputStream() {}
  
  public JceInputStream(ByteBuffer paramByteBuffer)
  {
    this.bs = paramByteBuffer;
  }
  
  public JceInputStream(byte[] paramArrayOfByte)
  {
    this.bs = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public JceInputStream(byte[] paramArrayOfByte, int paramInt)
  {
    this.bs = ByteBuffer.wrap(paramArrayOfByte);
    this.bs.position(paramInt);
  }
  
  public static void main(String[] paramArrayOfString) {}
  
  private int peakHead(HeadData paramHeadData)
  {
    return readHead(paramHeadData, this.bs.duplicate());
  }
  
  private <T> T[] readArrayImpl(T paramT, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      Object localObject = new HeadData();
      readHead((HeadData)localObject);
      paramInt = ((HeadData)localObject).type;
      if (paramInt != 9)
      {
        if (paramInt != 11) {
          throw new JceDecodeException("type mismatch.");
        }
      }
      else
      {
        int i = read(0, 0, true);
        if (i >= 0)
        {
          localObject = (Object[])Array.newInstance(paramT.getClass(), i);
          paramInt = 0;
          while (paramInt < i)
          {
            localObject[paramInt] = read(paramT, 0, true);
            paramInt += 1;
          }
          return localObject;
        }
        throw new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
      }
    }
    else
    {
      if (paramBoolean) {
        break label135;
      }
    }
    return null;
    label135:
    throw new JceDecodeException("require field not exist.");
  }
  
  public static int readHead(HeadData paramHeadData, ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.get();
    paramHeadData.type = ((byte)(i & 0xF));
    paramHeadData.tag = ((i & 0xF0) >> 4);
    if (paramHeadData.tag == 15)
    {
      paramHeadData.tag = (paramByteBuffer.get() & 0xFF);
      return 2;
    }
    return 1;
  }
  
  private <K, V> Map<K, V> readMap(Map<K, V> paramMap1, Map<K, V> paramMap2, int paramInt, boolean paramBoolean)
  {
    if ((paramMap2 != null) && (!paramMap2.isEmpty()))
    {
      Object localObject = (Map.Entry)paramMap2.entrySet().iterator().next();
      paramMap2 = ((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if (skipToTag(paramInt))
      {
        HeadData localHeadData = new HeadData();
        readHead(localHeadData);
        paramInt = localHeadData.type;
        if (paramInt != 8)
        {
          if (paramInt == 11) {
            return paramMap1;
          }
          throw new JceDecodeException("type mismatch.");
        }
        int i = read(0, 0, true);
        if (i >= 0)
        {
          paramInt = 0;
          while (paramInt < i)
          {
            paramMap1.put(read(paramMap2, 0, true), read(localObject, 1, true));
            paramInt += 1;
          }
        }
        throw new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
      }
      if (!paramBoolean) {
        return paramMap1;
      }
      throw new JceDecodeException("require field not exist.");
    }
    return new HashMap();
  }
  
  private void skip(int paramInt)
  {
    ByteBuffer localByteBuffer = this.bs;
    localByteBuffer.position(localByteBuffer.position() + paramInt);
  }
  
  private void skipField()
  {
    HeadData localHeadData = new HeadData();
    readHead(localHeadData);
    skipField(localHeadData.type);
  }
  
  private void skipField(byte paramByte)
  {
    byte b2 = 0;
    byte b1 = 0;
    switch (paramByte)
    {
    default: 
      throw new JceDecodeException("invalid type.");
    case 13: 
      HeadData localHeadData = new HeadData();
      readHead(localHeadData);
      if (localHeadData.type == 0)
      {
        skip(read(0, 0, true));
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("skipField with invalid type, type value: ");
      localStringBuilder.append(paramByte);
      localStringBuilder.append(", ");
      localStringBuilder.append(localHeadData.type);
      throw new JceDecodeException(localStringBuilder.toString());
    case 11: 
    case 12: 
      return;
    case 10: 
      skipToStructEnd();
      return;
    case 9: 
      b2 = read(0, 0, true);
      paramByte = b1;
      while (paramByte < b2)
      {
        skipField();
        paramByte += 1;
      }
      return;
    case 8: 
      b1 = read(0, 0, true);
      paramByte = b2;
      while (paramByte < b1 * 2)
      {
        skipField();
        paramByte += 1;
      }
      return;
    case 7: 
      skip(this.bs.getInt());
      return;
    case 6: 
      b1 = this.bs.get();
      paramByte = b1;
      if (b1 < 0) {
        paramByte = b1 + 256;
      }
      skip(paramByte);
      return;
    case 5: 
      skip(8);
      return;
    case 4: 
      skip(4);
      return;
    case 3: 
      skip(8);
      return;
    case 2: 
      skip(4);
      return;
    case 1: 
      skip(2);
      return;
    }
    skip(1);
  }
  
  public final JceStruct directRead(JceStruct paramJceStruct, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt)) {
      try
      {
        paramJceStruct = paramJceStruct.newInit();
        HeadData localHeadData = new HeadData();
        readHead(localHeadData);
        if (localHeadData.type == 10)
        {
          paramJceStruct.readFrom(this);
          skipToStructEnd();
          return paramJceStruct;
        }
        throw new JceDecodeException("type mismatch.");
      }
      catch (Exception paramJceStruct)
      {
        throw new JceDecodeException(paramJceStruct.getMessage());
      }
    }
    if (!paramBoolean) {
      return null;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final ByteBuffer getBs()
  {
    return this.bs;
  }
  
  public final byte read(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      HeadData localHeadData = new HeadData();
      readHead(localHeadData);
      paramInt = localHeadData.type;
      if (paramInt == 0) {}
    }
    switch (paramInt)
    {
    default: 
      throw new JceDecodeException("type mismatch.");
    case 12: 
      return 0;
      return this.bs.get();
      if (paramBoolean) {
        break;
      }
    case 11: 
      return paramByte;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final double read(double paramDouble, int paramInt, boolean paramBoolean)
  {
    HeadData localHeadData;
    if (skipToTag(paramInt))
    {
      localHeadData = new HeadData();
      readHead(localHeadData);
    }
    switch (localHeadData.type)
    {
    default: 
      throw new JceDecodeException("type mismatch.");
    case 12: 
      return 0.0D;
    case 5: 
      return this.bs.getDouble();
    case 4: 
      return this.bs.getFloat();
      if (paramBoolean) {
        break;
      }
    case 11: 
      return paramDouble;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final float read(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      HeadData localHeadData = new HeadData();
      readHead(localHeadData);
      paramInt = localHeadData.type;
      if (paramInt == 4) {}
    }
    switch (paramInt)
    {
    default: 
      throw new JceDecodeException("type mismatch.");
    case 12: 
      return 0.0F;
      return this.bs.getFloat();
      if (paramBoolean) {
        break;
      }
    case 11: 
      return paramFloat;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final int read(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (skipToTag(paramInt2))
    {
      HeadData localHeadData = new HeadData();
      readHead(localHeadData);
      paramInt2 = localHeadData.type;
      switch (paramInt2)
      {
      default: 
        switch (paramInt2)
        {
        default: 
          throw new JceDecodeException("type mismatch.");
        case 12: 
          return 0;
        }
      case 2: 
        return this.bs.getInt();
      case 1: 
        return this.bs.getShort();
      }
      return this.bs.get();
    }
    if (!paramBoolean) {
      return paramInt1;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final long read(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      HeadData localHeadData = new HeadData();
      readHead(localHeadData);
      paramInt = localHeadData.type;
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          throw new JceDecodeException("type mismatch.");
        case 12: 
          return 0L;
        }
      case 3: 
        return this.bs.getLong();
      case 2: 
        return this.bs.getInt();
      case 1: 
        return this.bs.getShort();
      }
      return this.bs.get();
    }
    if (!paramBoolean) {
      return paramLong;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final JceStruct read(JceStruct paramJceStruct, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt)) {
      try
      {
        paramJceStruct = (JceStruct)paramJceStruct.getClass().newInstance();
        HeadData localHeadData = new HeadData();
        readHead(localHeadData);
        if (localHeadData.type == 10)
        {
          paramJceStruct.readFrom(this);
          skipToStructEnd();
          return paramJceStruct;
        }
        throw new JceDecodeException("type mismatch.");
      }
      catch (Exception paramJceStruct)
      {
        throw new JceDecodeException(paramJceStruct.getMessage());
      }
    }
    if (!paramBoolean) {
      return null;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final <T> Object read(T paramT, int paramInt, boolean paramBoolean)
  {
    if ((paramT instanceof Byte)) {
      return Byte.valueOf(read((byte)0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Boolean)) {
      return Boolean.valueOf(read(false, paramInt, paramBoolean));
    }
    if ((paramT instanceof Short)) {
      return Short.valueOf(read((short)0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Integer)) {
      return Integer.valueOf(read(0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Long)) {
      return Long.valueOf(read(0L, paramInt, paramBoolean));
    }
    if ((paramT instanceof Float)) {
      return Float.valueOf(read(0.0F, paramInt, paramBoolean));
    }
    if ((paramT instanceof Double)) {
      return Double.valueOf(read(0.0D, paramInt, paramBoolean));
    }
    if ((paramT instanceof String)) {
      return readString(paramInt, paramBoolean);
    }
    if ((paramT instanceof Map)) {
      return readMap((Map)paramT, paramInt, paramBoolean);
    }
    if ((paramT instanceof List)) {
      return readArray((List)paramT, paramInt, paramBoolean);
    }
    if ((paramT instanceof JceStruct)) {
      return read((JceStruct)paramT, paramInt, paramBoolean);
    }
    if (paramT.getClass().isArray())
    {
      if ((!(paramT instanceof byte[])) && (!(paramT instanceof Byte[])))
      {
        if ((paramT instanceof boolean[])) {
          return read(null, paramInt, paramBoolean);
        }
        if ((paramT instanceof short[])) {
          return read(null, paramInt, paramBoolean);
        }
        if ((paramT instanceof int[])) {
          return read(null, paramInt, paramBoolean);
        }
        if ((paramT instanceof long[])) {
          return read(null, paramInt, paramBoolean);
        }
        if ((paramT instanceof float[])) {
          return read(null, paramInt, paramBoolean);
        }
        if ((paramT instanceof double[])) {
          return read(null, paramInt, paramBoolean);
        }
        return readArray((Object[])paramT, paramInt, paramBoolean);
      }
      return read(null, paramInt, paramBoolean);
    }
    throw new JceDecodeException("read object error: unsupport type.");
  }
  
  public final String read(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (skipToTag(paramInt))
    {
      localObject = new HeadData();
      readHead((HeadData)localObject);
      paramInt = ((HeadData)localObject).type;
      if (paramInt == 11) {
        break label213;
      }
      switch (paramInt)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 7: 
        paramInt = this.bs.getInt();
        if ((paramInt <= 104857600) && (paramInt >= 0))
        {
          paramString = new byte[paramInt];
          this.bs.get(paramString);
        }
        break;
      }
    }
    try
    {
      localObject = new String(paramString, this.sServerEncoding);
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      label119:
      int i;
      break label119;
    }
    return new String(paramString);
    throw new JceDecodeException("String too long: ".concat(String.valueOf(paramInt)));
    i = this.bs.get();
    paramInt = i;
    if (i < 0) {
      paramInt = i + 256;
    }
    paramString = new byte[paramInt];
    this.bs.get(paramString);
    try
    {
      localObject = new String(paramString, this.sServerEncoding);
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      label200:
      label213:
      break label200;
    }
    return new String(paramString);
    if (!paramBoolean) {
      return paramString;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final short read(short paramShort, int paramInt, boolean paramBoolean)
  {
    HeadData localHeadData;
    if (skipToTag(paramInt))
    {
      localHeadData = new HeadData();
      readHead(localHeadData);
    }
    switch (localHeadData.type)
    {
    default: 
      throw new JceDecodeException("type mismatch.");
    case 12: 
      return 0;
    case 1: 
      return this.bs.getShort();
    case 0: 
      return (short)this.bs.get();
      if (paramBoolean) {
        break;
      }
    case 11: 
      return paramShort;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final boolean read(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return read((byte)paramBoolean1, paramInt, paramBoolean2) != 0;
  }
  
  public final byte[] read(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfByte = new HeadData();
      readHead(paramArrayOfByte);
      int i = paramArrayOfByte.type;
      if (i != 9)
      {
        if (i != 11)
        {
          if (i == 13)
          {
            HeadData localHeadData = new HeadData();
            readHead(localHeadData);
            if (localHeadData.type == 0)
            {
              i = read(0, 0, true);
              if (i >= 0)
              {
                paramArrayOfByte = new byte[i];
                this.bs.get(paramArrayOfByte);
                return paramArrayOfByte;
              }
              localStringBuilder = new StringBuilder("invalid size, tag: ");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(", type: ");
              localStringBuilder.append(paramArrayOfByte.type);
              localStringBuilder.append(", ");
              localStringBuilder.append(localHeadData.type);
              localStringBuilder.append(", size: ");
              localStringBuilder.append(i);
              throw new JceDecodeException(localStringBuilder.toString());
            }
            StringBuilder localStringBuilder = new StringBuilder("type mismatch, tag: ");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(", type: ");
            localStringBuilder.append(paramArrayOfByte.type);
            localStringBuilder.append(", ");
            localStringBuilder.append(localHeadData.type);
            throw new JceDecodeException(localStringBuilder.toString());
          }
          throw new JceDecodeException("type mismatch.");
        }
      }
      else
      {
        i = read(0, 0, true);
        if (i >= 0)
        {
          paramArrayOfByte = new byte[i];
          paramInt = 0;
          while (paramInt < i)
          {
            paramArrayOfByte[paramInt] = read(paramArrayOfByte[0], 0, true);
            paramInt += 1;
          }
          return paramArrayOfByte;
        }
        throw new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
      }
    }
    else
    {
      if (paramBoolean) {
        break label340;
      }
    }
    return null;
    label340:
    throw new JceDecodeException("require field not exist.");
  }
  
  public final double[] read(double[] paramArrayOfDouble, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfDouble = new HeadData();
      readHead(paramArrayOfDouble);
      paramInt = paramArrayOfDouble.type;
      if (paramInt != 9)
      {
        if (paramInt != 11) {
          throw new JceDecodeException("type mismatch.");
        }
      }
      else
      {
        int i = read(0, 0, true);
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
            arrayOfDouble[paramInt] = read(arrayOfDouble[0], 0, true);
            paramInt += 1;
          }
        }
        throw new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
      }
    }
    else
    {
      if (paramBoolean) {
        break label129;
      }
    }
    paramArrayOfDouble = null;
    return paramArrayOfDouble;
    label129:
    throw new JceDecodeException("require field not exist.");
  }
  
  public final float[] read(float[] paramArrayOfFloat, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfFloat = new HeadData();
      readHead(paramArrayOfFloat);
      paramInt = paramArrayOfFloat.type;
      if (paramInt != 9)
      {
        if (paramInt != 11) {
          throw new JceDecodeException("type mismatch.");
        }
      }
      else
      {
        int i = read(0, 0, true);
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
            arrayOfFloat[paramInt] = read(arrayOfFloat[0], 0, true);
            paramInt += 1;
          }
        }
        throw new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
      }
    }
    else
    {
      if (paramBoolean) {
        break label129;
      }
    }
    paramArrayOfFloat = null;
    return paramArrayOfFloat;
    label129:
    throw new JceDecodeException("require field not exist.");
  }
  
  public final int[] read(int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfInt = new HeadData();
      readHead(paramArrayOfInt);
      paramInt = paramArrayOfInt.type;
      if (paramInt != 9)
      {
        if (paramInt != 11) {
          throw new JceDecodeException("type mismatch.");
        }
      }
      else
      {
        int i = read(0, 0, true);
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
            arrayOfInt[paramInt] = read(arrayOfInt[0], 0, true);
            paramInt += 1;
          }
        }
        throw new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
      }
    }
    else
    {
      if (paramBoolean) {
        break label129;
      }
    }
    paramArrayOfInt = null;
    return paramArrayOfInt;
    label129:
    throw new JceDecodeException("require field not exist.");
  }
  
  public final long[] read(long[] paramArrayOfLong, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfLong = new HeadData();
      readHead(paramArrayOfLong);
      paramInt = paramArrayOfLong.type;
      if (paramInt != 9)
      {
        if (paramInt != 11) {
          throw new JceDecodeException("type mismatch.");
        }
      }
      else
      {
        int i = read(0, 0, true);
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
            arrayOfLong[paramInt] = read(arrayOfLong[0], 0, true);
            paramInt += 1;
          }
        }
        throw new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
      }
    }
    else
    {
      if (paramBoolean) {
        break label129;
      }
    }
    paramArrayOfLong = null;
    return paramArrayOfLong;
    label129:
    throw new JceDecodeException("require field not exist.");
  }
  
  public final JceStruct[] read(JceStruct[] paramArrayOfJceStruct, int paramInt, boolean paramBoolean)
  {
    return (JceStruct[])readArray(paramArrayOfJceStruct, paramInt, paramBoolean);
  }
  
  public final String[] read(String[] paramArrayOfString, int paramInt, boolean paramBoolean)
  {
    return (String[])readArray(paramArrayOfString, paramInt, paramBoolean);
  }
  
  public final short[] read(short[] paramArrayOfShort, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfShort = new HeadData();
      readHead(paramArrayOfShort);
      paramInt = paramArrayOfShort.type;
      if (paramInt != 9)
      {
        if (paramInt != 11) {
          throw new JceDecodeException("type mismatch.");
        }
      }
      else
      {
        int i = read(0, 0, true);
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
            arrayOfShort[paramInt] = read(arrayOfShort[0], 0, true);
            paramInt += 1;
          }
        }
        throw new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
      }
    }
    else
    {
      if (paramBoolean) {
        break label129;
      }
    }
    paramArrayOfShort = null;
    return paramArrayOfShort;
    label129:
    throw new JceDecodeException("require field not exist.");
  }
  
  public final boolean[] read(boolean[] paramArrayOfBoolean, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfBoolean = new HeadData();
      readHead(paramArrayOfBoolean);
      paramInt = paramArrayOfBoolean.type;
      if (paramInt != 9)
      {
        if (paramInt != 11) {
          throw new JceDecodeException("type mismatch.");
        }
      }
      else
      {
        int i = read(0, 0, true);
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
            arrayOfBoolean[paramInt] = read(arrayOfBoolean[0], 0, true);
            paramInt += 1;
          }
        }
        throw new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
      }
    }
    else
    {
      if (paramBoolean) {
        break label129;
      }
    }
    paramArrayOfBoolean = null;
    return paramArrayOfBoolean;
    label129:
    throw new JceDecodeException("require field not exist.");
  }
  
  public final <T> List<T> readArray(List<T> paramList, int paramInt, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      paramList = readArrayImpl(paramList.get(0), paramInt, paramBoolean);
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
    return new ArrayList();
  }
  
  public final <T> T[] readArray(T[] paramArrayOfT, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayOfT != null) && (paramArrayOfT.length != 0)) {
      return readArrayImpl(paramArrayOfT[0], paramInt, paramBoolean);
    }
    throw new JceDecodeException("unable to get type of key and value.");
  }
  
  public final String readByteString(String paramString, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      HeadData localHeadData = new HeadData();
      readHead(localHeadData);
      paramInt = localHeadData.type;
      if (paramInt != 11)
      {
        switch (paramInt)
        {
        default: 
          throw new JceDecodeException("type mismatch.");
        case 7: 
          paramInt = this.bs.getInt();
          if ((paramInt <= 104857600) && (paramInt >= 0))
          {
            paramString = new byte[paramInt];
            this.bs.get(paramString);
            return HexUtil.bytes2HexStr(paramString);
          }
          throw new JceDecodeException("String too long: ".concat(String.valueOf(paramInt)));
        }
        int i = this.bs.get();
        paramInt = i;
        if (i < 0) {
          paramInt = i + 256;
        }
        paramString = new byte[paramInt];
        this.bs.get(paramString);
        return HexUtil.bytes2HexStr(paramString);
      }
    }
    else
    {
      if (paramBoolean) {
        break label173;
      }
    }
    return paramString;
    label173:
    throw new JceDecodeException("require field not exist.");
  }
  
  public final void readHead(HeadData paramHeadData)
  {
    readHead(paramHeadData, this.bs);
  }
  
  public final List readList(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (skipToTag(paramInt))
    {
      Object localObject = new HeadData();
      readHead((HeadData)localObject);
      if (((HeadData)localObject).type == 9)
      {
        int k = read(0, 0, true);
        if (k >= 0)
        {
          paramInt = 0;
          while (paramInt < k)
          {
            localObject = new HeadData();
            readHead((HeadData)localObject);
            switch (((HeadData)localObject).type)
            {
            default: 
              throw new JceDecodeException("type mismatch.");
            case 12: 
              localArrayList.add(Integer.valueOf(0));
              break;
            case 10: 
              try
              {
                localObject = (JceStruct)Class.forName(JceStruct.class.getName()).getConstructor(new Class[0]).newInstance(new Object[0]);
                ((JceStruct)localObject).readFrom(this);
                skipToStructEnd();
                localArrayList.add(localObject);
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
                throw new JceDecodeException("type mismatch.".concat(String.valueOf(localException)));
              }
            case 7: 
              skip(this.bs.getInt());
              break;
            case 6: 
              int j = this.bs.get();
              int i = j;
              if (j < 0) {
                i = j + 256;
              }
              skip(i);
              break;
            case 5: 
              skip(8);
              break;
            case 4: 
              skip(4);
              break;
            case 3: 
              skip(8);
              break;
            case 2: 
              skip(4);
              break;
            case 1: 
              skip(2);
              break;
            case 0: 
              skip(1);
            }
            paramInt += 1;
          }
        }
        throw new JceDecodeException("size invalid: ".concat(String.valueOf(k)));
      }
      throw new JceDecodeException("type mismatch.");
    }
    if (!paramBoolean) {
      return localException;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final <K, V> HashMap<K, V> readMap(Map<K, V> paramMap, int paramInt, boolean paramBoolean)
  {
    return (HashMap)readMap(new HashMap(), paramMap, paramInt, paramBoolean);
  }
  
  public final String readString(int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      localObject = new HeadData();
      readHead((HeadData)localObject);
      paramInt = ((HeadData)localObject).type;
      if (paramInt == 11) {
        break label217;
      }
      switch (paramInt)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 7: 
        paramInt = this.bs.getInt();
        if ((paramInt <= 104857600) && (paramInt >= 0))
        {
          localObject = new byte[paramInt];
          this.bs.get((byte[])localObject);
        }
        break;
      }
    }
    try
    {
      str = new String((byte[])localObject, this.sServerEncoding);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      String str;
      label122:
      int i;
      break label122;
    }
    return new String((byte[])localObject);
    throw new JceDecodeException("String too long: ".concat(String.valueOf(paramInt)));
    i = this.bs.get();
    paramInt = i;
    if (i < 0) {
      paramInt = i + 256;
    }
    Object localObject = new byte[paramInt];
    this.bs.get((byte[])localObject);
    try
    {
      str = new String((byte[])localObject, this.sServerEncoding);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      label203:
      label217:
      break label203;
    }
    return new String((byte[])localObject);
    if (!paramBoolean) {
      return null;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final Map<String, String> readStringMap(int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (skipToTag(paramInt))
    {
      HeadData localHeadData = new HeadData();
      readHead(localHeadData);
      paramInt = localHeadData.type;
      if (paramInt != 8)
      {
        if (paramInt == 11) {
          return localHashMap;
        }
        throw new JceDecodeException("type mismatch.");
      }
      int i = read(0, 0, true);
      if (i >= 0)
      {
        paramInt = 0;
        while (paramInt < i)
        {
          localHashMap.put(readString(0, true), readString(1, true));
          paramInt += 1;
        }
      }
      throw new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
    }
    if (!paramBoolean) {
      return localHashMap;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final int setServerEncoding(String paramString)
  {
    this.sServerEncoding = paramString;
    return 0;
  }
  
  public final void skipToStructEnd()
  {
    HeadData localHeadData = new HeadData();
    do
    {
      if (this.bs.remaining() == 0) {
        break;
      }
      readHead(localHeadData);
      skipField(localHeadData.type);
    } while (localHeadData.type != 11);
  }
  
  public final boolean skipToTag(int paramInt)
  {
    try
    {
      HeadData localHeadData = new HeadData();
      for (;;)
      {
        i = peakHead(localHeadData);
        if ((paramInt <= localHeadData.tag) || (localHeadData.type == 11)) {
          break;
        }
        skip(i);
        skipField(localHeadData.type);
      }
      int i = localHeadData.tag;
      return paramInt == i;
    }
    catch (JceDecodeException|BufferUnderflowException localJceDecodeException) {}
    return false;
  }
  
  public final void warp(byte[] paramArrayOfByte)
  {
    wrap(paramArrayOfByte);
  }
  
  public final void wrap(byte[] paramArrayOfByte)
  {
    this.bs = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public static class HeadData
  {
    public int tag;
    public byte type;
    
    public void clear()
    {
      this.type = 0;
      this.tag = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.qq.taf.jce.JceInputStream
 * JD-Core Version:    0.7.0.1
 */