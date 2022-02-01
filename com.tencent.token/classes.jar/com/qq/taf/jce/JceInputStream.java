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
        paramT = new StringBuilder();
        paramT.append("size invalid: ");
        paramT.append(i);
        throw new JceDecodeException(paramT.toString());
      }
    }
    else
    {
      if (paramBoolean) {
        break label151;
      }
    }
    return null;
    label151:
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
        paramMap1 = new StringBuilder();
        paramMap1.append("size invalid: ");
        paramMap1.append(i);
        throw new JceDecodeException(paramMap1.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("skipField with invalid type, type value: ");
      localStringBuilder.append(paramByte);
      localStringBuilder.append(", ");
      localStringBuilder.append(localHeadData.type);
      throw new JceDecodeException(localStringBuilder.toString());
    case 10: 
      skipToStructEnd();
      return;
    case 9: 
      b2 = read(0, 0, true);
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
        skipField();
        paramByte += 1;
        continue;
        b1 = read(0, 0, true);
        paramByte = b2;
        while (paramByte < b1 * 2)
        {
          skipField();
          paramByte += 1;
          continue;
          skip(this.bs.getInt());
          return;
          b1 = this.bs.get();
          paramByte = b1;
          if (b1 < 0) {
            paramByte = b1 + 256;
          }
          skip(paramByte);
          return;
          skip(8);
          return;
          skip(4);
          return;
          skip(8);
          return;
          skip(4);
          return;
          skip(2);
          return;
          skip(1);
        }
      }
    }
  }
  
  public JceStruct directRead(JceStruct paramJceStruct, int paramInt, boolean paramBoolean)
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
  
  public ByteBuffer getBs()
  {
    return this.bs;
  }
  
  public byte read(byte paramByte, int paramInt, boolean paramBoolean)
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
  
  public double read(double paramDouble, int paramInt, boolean paramBoolean)
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
  
  public float read(float paramFloat, int paramInt, boolean paramBoolean)
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
  
  public int read(int paramInt1, int paramInt2, boolean paramBoolean)
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
  
  public long read(long paramLong, int paramInt, boolean paramBoolean)
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
  
  public JceStruct read(JceStruct paramJceStruct, int paramInt, boolean paramBoolean)
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
  
  public <T> Object read(T paramT, int paramInt, boolean paramBoolean)
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
          return read((boolean[])null, paramInt, paramBoolean);
        }
        if ((paramT instanceof short[])) {
          return read((short[])null, paramInt, paramBoolean);
        }
        if ((paramT instanceof int[])) {
          return read((int[])null, paramInt, paramBoolean);
        }
        if ((paramT instanceof long[])) {
          return read((long[])null, paramInt, paramBoolean);
        }
        if ((paramT instanceof float[])) {
          return read((float[])null, paramInt, paramBoolean);
        }
        if ((paramT instanceof double[])) {
          return read((double[])null, paramInt, paramBoolean);
        }
        return readArray((Object[])paramT, paramInt, paramBoolean);
      }
      return read((byte[])null, paramInt, paramBoolean);
    }
    throw new JceDecodeException("read object error: unsupport type.");
  }
  
  public String read(String paramString, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      localObject = new HeadData();
      readHead((HeadData)localObject);
      paramInt = ((HeadData)localObject).type;
      if (paramInt == 11) {
        break label239;
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
      paramString = new String((byte[])localObject, this.sServerEncoding);
    }
    catch (UnsupportedEncodingException paramString)
    {
      label121:
      int i;
      break label121;
    }
    paramString = new String((byte[])localObject);
    return paramString;
    paramString = new StringBuilder();
    paramString.append("String too long: ");
    paramString.append(paramInt);
    throw new JceDecodeException(paramString.toString());
    i = this.bs.get();
    paramInt = i;
    if (i < 0) {
      paramInt = i + 256;
    }
    Object localObject = new byte[paramInt];
    this.bs.get((byte[])localObject);
    try
    {
      paramString = new String((byte[])localObject, this.sServerEncoding);
    }
    catch (UnsupportedEncodingException paramString)
    {
      label223:
      label239:
      break label223;
    }
    paramString = new String((byte[])localObject);
    return paramString;
    if (!paramBoolean) {
      return paramString;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public short read(short paramShort, int paramInt, boolean paramBoolean)
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
  
  public boolean read(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return read((byte)paramBoolean1, paramInt, paramBoolean2) != 0;
  }
  
  public byte[] read(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
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
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("invalid size, tag: ");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(", type: ");
              localStringBuilder.append(paramArrayOfByte.type);
              localStringBuilder.append(", ");
              localStringBuilder.append(localHeadData.type);
              localStringBuilder.append(", size: ");
              localStringBuilder.append(i);
              throw new JceDecodeException(localStringBuilder.toString());
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("type mismatch, tag: ");
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
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("size invalid: ");
        paramArrayOfByte.append(i);
        throw new JceDecodeException(paramArrayOfByte.toString());
      }
    }
    else
    {
      if (paramBoolean) {
        break label368;
      }
    }
    return null;
    label368:
    throw new JceDecodeException("require field not exist.");
  }
  
  public double[] read(double[] paramArrayOfDouble, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfDouble = new HeadData();
      readHead(paramArrayOfDouble);
      paramInt = paramArrayOfDouble.type;
      if (paramInt != 9)
      {
        if (paramInt == 11) {
          return null;
        }
        throw new JceDecodeException("type mismatch.");
      }
      int i = read(0, 0, true);
      if (i >= 0)
      {
        paramArrayOfDouble = new double[i];
        paramInt = 0;
        while (paramInt < i)
        {
          paramArrayOfDouble[paramInt] = read(paramArrayOfDouble[0], 0, true);
          paramInt += 1;
        }
        return paramArrayOfDouble;
      }
      paramArrayOfDouble = new StringBuilder();
      paramArrayOfDouble.append("size invalid: ");
      paramArrayOfDouble.append(i);
      throw new JceDecodeException(paramArrayOfDouble.toString());
    }
    if (!paramBoolean) {
      return null;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public float[] read(float[] paramArrayOfFloat, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfFloat = new HeadData();
      readHead(paramArrayOfFloat);
      paramInt = paramArrayOfFloat.type;
      if (paramInt != 9)
      {
        if (paramInt == 11) {
          return null;
        }
        throw new JceDecodeException("type mismatch.");
      }
      int i = read(0, 0, true);
      if (i >= 0)
      {
        paramArrayOfFloat = new float[i];
        paramInt = 0;
        while (paramInt < i)
        {
          paramArrayOfFloat[paramInt] = read(paramArrayOfFloat[0], 0, true);
          paramInt += 1;
        }
        return paramArrayOfFloat;
      }
      paramArrayOfFloat = new StringBuilder();
      paramArrayOfFloat.append("size invalid: ");
      paramArrayOfFloat.append(i);
      throw new JceDecodeException(paramArrayOfFloat.toString());
    }
    if (!paramBoolean) {
      return null;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public int[] read(int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfInt = new HeadData();
      readHead(paramArrayOfInt);
      paramInt = paramArrayOfInt.type;
      if (paramInt != 9)
      {
        if (paramInt == 11) {
          return null;
        }
        throw new JceDecodeException("type mismatch.");
      }
      int i = read(0, 0, true);
      if (i >= 0)
      {
        paramArrayOfInt = new int[i];
        paramInt = 0;
        while (paramInt < i)
        {
          paramArrayOfInt[paramInt] = read(paramArrayOfInt[0], 0, true);
          paramInt += 1;
        }
        return paramArrayOfInt;
      }
      paramArrayOfInt = new StringBuilder();
      paramArrayOfInt.append("size invalid: ");
      paramArrayOfInt.append(i);
      throw new JceDecodeException(paramArrayOfInt.toString());
    }
    if (!paramBoolean) {
      return null;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public long[] read(long[] paramArrayOfLong, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfLong = new HeadData();
      readHead(paramArrayOfLong);
      paramInt = paramArrayOfLong.type;
      if (paramInt != 9)
      {
        if (paramInt == 11) {
          return null;
        }
        throw new JceDecodeException("type mismatch.");
      }
      int i = read(0, 0, true);
      if (i >= 0)
      {
        paramArrayOfLong = new long[i];
        paramInt = 0;
        while (paramInt < i)
        {
          paramArrayOfLong[paramInt] = read(paramArrayOfLong[0], 0, true);
          paramInt += 1;
        }
        return paramArrayOfLong;
      }
      paramArrayOfLong = new StringBuilder();
      paramArrayOfLong.append("size invalid: ");
      paramArrayOfLong.append(i);
      throw new JceDecodeException(paramArrayOfLong.toString());
    }
    if (!paramBoolean) {
      return null;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public JceStruct[] read(JceStruct[] paramArrayOfJceStruct, int paramInt, boolean paramBoolean)
  {
    return (JceStruct[])readArray(paramArrayOfJceStruct, paramInt, paramBoolean);
  }
  
  public String[] read(String[] paramArrayOfString, int paramInt, boolean paramBoolean)
  {
    return (String[])readArray(paramArrayOfString, paramInt, paramBoolean);
  }
  
  public short[] read(short[] paramArrayOfShort, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfShort = new HeadData();
      readHead(paramArrayOfShort);
      paramInt = paramArrayOfShort.type;
      if (paramInt != 9)
      {
        if (paramInt == 11) {
          return null;
        }
        throw new JceDecodeException("type mismatch.");
      }
      int i = read(0, 0, true);
      if (i >= 0)
      {
        paramArrayOfShort = new short[i];
        paramInt = 0;
        while (paramInt < i)
        {
          paramArrayOfShort[paramInt] = read(paramArrayOfShort[0], 0, true);
          paramInt += 1;
        }
        return paramArrayOfShort;
      }
      paramArrayOfShort = new StringBuilder();
      paramArrayOfShort.append("size invalid: ");
      paramArrayOfShort.append(i);
      throw new JceDecodeException(paramArrayOfShort.toString());
    }
    if (!paramBoolean) {
      return null;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public boolean[] read(boolean[] paramArrayOfBoolean, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfBoolean = new HeadData();
      readHead(paramArrayOfBoolean);
      paramInt = paramArrayOfBoolean.type;
      if (paramInt != 9)
      {
        if (paramInt == 11) {
          return null;
        }
        throw new JceDecodeException("type mismatch.");
      }
      int i = read(0, 0, true);
      if (i >= 0)
      {
        paramArrayOfBoolean = new boolean[i];
        paramInt = 0;
        while (paramInt < i)
        {
          paramArrayOfBoolean[paramInt] = read(paramArrayOfBoolean[0], 0, true);
          paramInt += 1;
        }
        return paramArrayOfBoolean;
      }
      paramArrayOfBoolean = new StringBuilder();
      paramArrayOfBoolean.append("size invalid: ");
      paramArrayOfBoolean.append(i);
      throw new JceDecodeException(paramArrayOfBoolean.toString());
    }
    if (!paramBoolean) {
      return null;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public <T> List<T> readArray(List<T> paramList, int paramInt, boolean paramBoolean)
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
  
  public <T> T[] readArray(T[] paramArrayOfT, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayOfT != null) && (paramArrayOfT.length != 0)) {
      return readArrayImpl(paramArrayOfT[0], paramInt, paramBoolean);
    }
    throw new JceDecodeException("unable to get type of key and value.");
  }
  
  public String readByteString(String paramString, int paramInt, boolean paramBoolean)
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
          paramString = new StringBuilder();
          paramString.append("String too long: ");
          paramString.append(paramInt);
          throw new JceDecodeException(paramString.toString());
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
        break label189;
      }
    }
    return paramString;
    label189:
    throw new JceDecodeException("require field not exist.");
  }
  
  public void readHead(HeadData paramHeadData)
  {
    readHead(paramHeadData, this.bs);
  }
  
  public List readList(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder;
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
              localArrayList.add(new Integer(0));
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
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("type mismatch.");
                ((StringBuilder)localObject).append(localException);
                throw new JceDecodeException(((StringBuilder)localObject).toString());
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
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("size invalid: ");
        localStringBuilder.append(k);
        throw new JceDecodeException(localStringBuilder.toString());
      }
      throw new JceDecodeException("type mismatch.");
    }
    if (!paramBoolean) {
      return localStringBuilder;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public <K, V> HashMap<K, V> readMap(Map<K, V> paramMap, int paramInt, boolean paramBoolean)
  {
    return (HashMap)readMap(new HashMap(), paramMap, paramInt, paramBoolean);
  }
  
  public String readString(int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      localObject = new HeadData();
      readHead((HeadData)localObject);
      paramInt = ((HeadData)localObject).type;
      if (paramInt == 11) {
        break label245;
      }
      switch (paramInt)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 7: 
        paramInt = this.bs.getInt();
        if ((paramInt <= 104857600) && (paramInt >= 0))
        {
          arrayOfByte = new byte[paramInt];
          this.bs.get(arrayOfByte);
        }
        break;
      }
    }
    try
    {
      localObject = new String(arrayOfByte, this.sServerEncoding);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      label122:
      int i;
      break label122;
    }
    Object localObject = new String(arrayOfByte);
    return localObject;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("String too long: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new JceDecodeException(((StringBuilder)localObject).toString());
    i = this.bs.get();
    paramInt = i;
    if (i < 0) {
      paramInt = i + 256;
    }
    byte[] arrayOfByte = new byte[paramInt];
    this.bs.get(arrayOfByte);
    try
    {
      localObject = new String(arrayOfByte, this.sServerEncoding);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      label227:
      label245:
      break label227;
    }
    localObject = new String(arrayOfByte);
    return localObject;
    if (!paramBoolean) {
      return null;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public Map<String, String> readStringMap(int paramInt, boolean paramBoolean)
  {
    Object localObject = new HashMap();
    if (skipToTag(paramInt))
    {
      HeadData localHeadData = new HeadData();
      readHead(localHeadData);
      paramInt = localHeadData.type;
      if (paramInt != 8)
      {
        if (paramInt == 11) {
          return localObject;
        }
        throw new JceDecodeException("type mismatch.");
      }
      int i = read(0, 0, true);
      if (i >= 0)
      {
        paramInt = 0;
        while (paramInt < i)
        {
          ((HashMap)localObject).put(readString(0, true), readString(1, true));
          paramInt += 1;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("size invalid: ");
      ((StringBuilder)localObject).append(i);
      throw new JceDecodeException(((StringBuilder)localObject).toString());
    }
    if (!paramBoolean) {
      return localObject;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public int setServerEncoding(String paramString)
  {
    this.sServerEncoding = paramString;
    return 0;
  }
  
  public void skipToStructEnd()
  {
    HeadData localHeadData = new HeadData();
    do
    {
      if (this.bs.remaining() == 0) {
        return;
      }
      readHead(localHeadData);
      skipField(localHeadData.type);
    } while (localHeadData.type != 11);
  }
  
  public boolean skipToTag(int paramInt)
  {
    boolean bool = false;
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
      if (paramInt == i) {
        bool = true;
      }
      return bool;
    }
    catch (JceDecodeException|BufferUnderflowException localJceDecodeException) {}
    return false;
  }
  
  public void warp(byte[] paramArrayOfByte)
  {
    wrap(paramArrayOfByte);
  }
  
  public void wrap(byte[] paramArrayOfByte)
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