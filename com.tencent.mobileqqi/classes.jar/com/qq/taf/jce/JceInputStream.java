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
      localObject = new HeadData();
      readHead((HeadData)localObject);
      switch (((HeadData)localObject).type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      }
      int i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
      Object[] arrayOfObject = (Object[])Array.newInstance(paramT.getClass(), i);
      paramInt = 0;
      for (;;)
      {
        localObject = arrayOfObject;
        if (paramInt >= i) {
          break;
        }
        arrayOfObject[paramInt] = read(paramT, 0, true);
        paramInt += 1;
      }
    }
    if (paramBoolean) {
      throw new JceDecodeException("require field not exist.");
    }
    Object localObject = null;
    return localObject;
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
    if ((paramMap2 == null) || (paramMap2.isEmpty())) {
      paramMap2 = new HashMap();
    }
    do
    {
      return paramMap2;
      paramMap2 = (Map.Entry)paramMap2.entrySet().iterator().next();
      Object localObject1 = paramMap2.getKey();
      Object localObject2 = paramMap2.getValue();
      if (skipToTag(paramInt))
      {
        paramMap2 = new HeadData();
        readHead(paramMap2);
        switch (paramMap2.type)
        {
        default: 
          throw new JceDecodeException("type mismatch.");
        }
        int i = read(0, 0, true);
        if (i < 0) {
          throw new JceDecodeException("size invalid: " + i);
        }
        paramInt = 0;
        for (;;)
        {
          paramMap2 = paramMap1;
          if (paramInt >= i) {
            break;
          }
          paramMap1.put(read(localObject1, 0, true), read(localObject2, 1, true));
          paramInt += 1;
        }
      }
      paramMap2 = paramMap1;
    } while (!paramBoolean);
    throw new JceDecodeException("require field not exist.");
  }
  
  private void skip(int paramInt)
  {
    this.bs.position(this.bs.position() + paramInt);
  }
  
  private void skipField()
  {
    HeadData localHeadData = new HeadData();
    readHead(localHeadData);
    skipField(localHeadData.type);
  }
  
  private void skipField(byte paramByte)
  {
    byte b;
    switch (paramByte)
    {
    default: 
      throw new JceDecodeException("invalid type.");
    case 0: 
      skip(1);
    case 11: 
    case 12: 
      return;
    case 1: 
      skip(2);
      return;
    case 2: 
      skip(4);
      return;
    case 3: 
      skip(8);
      return;
    case 4: 
      skip(4);
      return;
    case 5: 
      skip(8);
      return;
    case 6: 
      b = this.bs.get();
      paramByte = b;
      if (b < 0) {
        paramByte = b + 256;
      }
      skip(paramByte);
      return;
    case 7: 
      skip(this.bs.getInt());
      return;
    case 8: 
      b = read(0, 0, true);
      paramByte = 0;
      while (paramByte < b * 2)
      {
        skipField();
        paramByte += 1;
      }
    case 9: 
      b = read(0, 0, true);
      paramByte = 0;
      while (paramByte < b)
      {
        skipField();
        paramByte += 1;
      }
    case 13: 
      HeadData localHeadData = new HeadData();
      readHead(localHeadData);
      if (localHeadData.type != 0) {
        throw new JceDecodeException("skipField with invalid type, type value: " + paramByte + ", " + localHeadData.type);
      }
      skip(read(0, 0, true));
      return;
    }
    skipToStructEnd();
  }
  
  public JceStruct directRead(JceStruct paramJceStruct, int paramInt, boolean paramBoolean)
  {
    HeadData localHeadData = null;
    if (skipToTag(paramInt))
    {
      try
      {
        paramJceStruct = paramJceStruct.newInit();
        localHeadData = new HeadData();
        readHead(localHeadData);
        if (localHeadData.type != 10) {
          throw new JceDecodeException("type mismatch.");
        }
      }
      catch (Exception paramJceStruct)
      {
        throw new JceDecodeException(paramJceStruct.getMessage());
      }
      paramJceStruct.readFrom(this);
      skipToStructEnd();
    }
    do
    {
      return paramJceStruct;
      paramJceStruct = localHeadData;
    } while (!paramBoolean);
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
      localHeadData = new HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 12: 
        paramByte = 0;
      }
    }
    while (!paramBoolean)
    {
      HeadData localHeadData;
      return paramByte;
      return this.bs.get();
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public double read(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      localHeadData = new HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 12: 
        paramDouble = 0.0D;
      }
    }
    while (!paramBoolean)
    {
      HeadData localHeadData;
      return paramDouble;
      return this.bs.getFloat();
      return this.bs.getDouble();
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public float read(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      localHeadData = new HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 12: 
        paramFloat = 0.0F;
      }
    }
    while (!paramBoolean)
    {
      HeadData localHeadData;
      return paramFloat;
      return this.bs.getFloat();
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public int read(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (skipToTag(paramInt2))
    {
      localHeadData = new HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 12: 
        paramInt1 = 0;
      }
    }
    while (!paramBoolean)
    {
      HeadData localHeadData;
      return paramInt1;
      return this.bs.get();
      return this.bs.getShort();
      return this.bs.getInt();
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public long read(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      localHeadData = new HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 12: 
        paramLong = 0L;
      }
    }
    while (!paramBoolean)
    {
      HeadData localHeadData;
      return paramLong;
      return this.bs.get();
      return this.bs.getShort();
      return this.bs.getInt();
      return this.bs.getLong();
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public JceStruct read(JceStruct paramJceStruct, int paramInt, boolean paramBoolean)
  {
    HeadData localHeadData = null;
    if (skipToTag(paramInt))
    {
      try
      {
        paramJceStruct = (JceStruct)paramJceStruct.getClass().newInstance();
        localHeadData = new HeadData();
        readHead(localHeadData);
        if (localHeadData.type != 10) {
          throw new JceDecodeException("type mismatch.");
        }
      }
      catch (Exception paramJceStruct)
      {
        throw new JceDecodeException(paramJceStruct.getMessage());
      }
      paramJceStruct.readFrom(this);
      skipToStructEnd();
    }
    do
    {
      return paramJceStruct;
      paramJceStruct = localHeadData;
    } while (!paramBoolean);
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
      if (((paramT instanceof byte[])) || ((paramT instanceof Byte[]))) {
        return read((byte[])null, paramInt, paramBoolean);
      }
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
    throw new JceDecodeException("read object error: unsupport type.");
  }
  
  public String read(String paramString, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramString = new HeadData();
      readHead(paramString);
      switch (paramString.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 6: 
        i = this.bs.get();
        paramInt = i;
        if (i < 0) {
          paramInt = i + 256;
        }
        localObject = new byte[paramInt];
        this.bs.get((byte[])localObject);
      }
    }
    while (!paramBoolean)
    {
      Object localObject;
      try
      {
        int i;
        paramString = new String((byte[])localObject, this.sServerEncoding);
        return paramString;
      }
      catch (UnsupportedEncodingException paramString)
      {
        return new String((byte[])localObject);
      }
      paramInt = this.bs.getInt();
      if ((paramInt > 104857600) || (paramInt < 0) || (paramInt > this.bs.capacity())) {
        throw new JceDecodeException("String too long: " + paramInt);
      }
      paramString = new byte[paramInt];
      this.bs.get(paramString);
      try
      {
        localObject = new String(paramString, this.sServerEncoding);
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        return new String(paramString);
      }
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public short read(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      localHeadData = new HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 12: 
        paramShort = 0;
      }
    }
    while (!paramBoolean)
    {
      HeadData localHeadData;
      return paramShort;
      return (short)this.bs.get();
      return this.bs.getShort();
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public boolean read(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    paramBoolean1 = false;
    if (read((byte)0, paramInt, paramBoolean2) != 0) {
      paramBoolean1 = true;
    }
    return paramBoolean1;
  }
  
  public byte[] read(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    paramArrayOfByte = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfByte = new HeadData();
      readHead(paramArrayOfByte);
      switch (paramArrayOfByte.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 13: 
        localObject = new HeadData();
        readHead((HeadData)localObject);
        if (((HeadData)localObject).type != 0) {
          throw new JceDecodeException("type mismatch, tag: " + paramInt + ", type: " + paramArrayOfByte.type + ", " + ((HeadData)localObject).type);
        }
        i = read(0, 0, true);
        if ((i < 0) || (i > this.bs.capacity())) {
          throw new JceDecodeException("invalid size, tag: " + paramInt + ", type: " + paramArrayOfByte.type + ", " + ((HeadData)localObject).type + ", size: " + i);
        }
        paramArrayOfByte = new byte[i];
        this.bs.get(paramArrayOfByte);
      }
    }
    while (!paramBoolean)
    {
      return paramArrayOfByte;
      int i = read(0, 0, true);
      if ((i < 0) || (i > this.bs.capacity())) {
        throw new JceDecodeException("size invalid: " + i);
      }
      Object localObject = new byte[i];
      paramInt = 0;
      for (;;)
      {
        paramArrayOfByte = (byte[])localObject;
        if (paramInt >= i) {
          break;
        }
        localObject[paramInt] = read(localObject[0], 0, true);
        paramInt += 1;
      }
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public double[] read(double[] paramArrayOfDouble, int paramInt, boolean paramBoolean)
  {
    paramArrayOfDouble = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfDouble = new HeadData();
      readHead(paramArrayOfDouble);
      switch (paramArrayOfDouble.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      }
      int i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
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
    if (paramBoolean) {
      throw new JceDecodeException("require field not exist.");
    }
    return paramArrayOfDouble;
  }
  
  public float[] read(float[] paramArrayOfFloat, int paramInt, boolean paramBoolean)
  {
    paramArrayOfFloat = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfFloat = new HeadData();
      readHead(paramArrayOfFloat);
      switch (paramArrayOfFloat.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      }
      int i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
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
    if (paramBoolean) {
      throw new JceDecodeException("require field not exist.");
    }
    return paramArrayOfFloat;
  }
  
  public int[] read(int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    paramArrayOfInt = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfInt = new HeadData();
      readHead(paramArrayOfInt);
      switch (paramArrayOfInt.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      }
      int i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
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
    if (paramBoolean) {
      throw new JceDecodeException("require field not exist.");
    }
    return paramArrayOfInt;
  }
  
  public long[] read(long[] paramArrayOfLong, int paramInt, boolean paramBoolean)
  {
    paramArrayOfLong = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfLong = new HeadData();
      readHead(paramArrayOfLong);
      switch (paramArrayOfLong.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      }
      int i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
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
    if (paramBoolean) {
      throw new JceDecodeException("require field not exist.");
    }
    return paramArrayOfLong;
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
    paramArrayOfShort = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfShort = new HeadData();
      readHead(paramArrayOfShort);
      switch (paramArrayOfShort.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      }
      int i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
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
    if (paramBoolean) {
      throw new JceDecodeException("require field not exist.");
    }
    return paramArrayOfShort;
  }
  
  public boolean[] read(boolean[] paramArrayOfBoolean, int paramInt, boolean paramBoolean)
  {
    paramArrayOfBoolean = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfBoolean = new HeadData();
      readHead(paramArrayOfBoolean);
      switch (paramArrayOfBoolean.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      }
      int i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
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
    if (paramBoolean) {
      throw new JceDecodeException("require field not exist.");
    }
    return paramArrayOfBoolean;
  }
  
  public <T> List<T> readArray(List<T> paramList, int paramInt, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = new ArrayList();
      return paramList;
    }
    Object[] arrayOfObject = readArrayImpl(paramList.get(0), paramInt, paramBoolean);
    if (arrayOfObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramInt = 0;
    for (;;)
    {
      paramList = localArrayList;
      if (paramInt >= arrayOfObject.length) {
        break;
      }
      localArrayList.add(arrayOfObject[paramInt]);
      paramInt += 1;
    }
  }
  
  public <T> T[] readArray(T[] paramArrayOfT, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayOfT == null) || (paramArrayOfT.length == 0)) {
      throw new JceDecodeException("unable to get type of key and value.");
    }
    return readArrayImpl(paramArrayOfT[0], paramInt, paramBoolean);
  }
  
  public String readByteString(String paramString, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramString = new HeadData();
      readHead(paramString);
      switch (paramString.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 6: 
        i = this.bs.get();
        paramInt = i;
        if (i < 0) {
          paramInt = i + 256;
        }
        paramString = new byte[paramInt];
        this.bs.get(paramString);
        paramString = HexUtil.bytes2HexStr(paramString);
      }
    }
    while (!paramBoolean)
    {
      int i;
      return paramString;
      paramInt = this.bs.getInt();
      if ((paramInt > 104857600) || (paramInt < 0) || (paramInt > this.bs.capacity())) {
        throw new JceDecodeException("String too long: " + paramInt);
      }
      paramString = new byte[paramInt];
      this.bs.get(paramString);
      return HexUtil.bytes2HexStr(paramString);
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public void readHead(HeadData paramHeadData)
  {
    readHead(paramHeadData, this.bs);
  }
  
  public List readList(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (skipToTag(paramInt))
    {
      Object localObject = new HeadData();
      readHead((HeadData)localObject);
      switch (((HeadData)localObject).type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      }
      int k = read(0, 0, true);
      if (k < 0) {
        throw new JceDecodeException("size invalid: " + k);
      }
      paramInt = 0;
      if (paramInt < k)
      {
        localObject = new HeadData();
        readHead((HeadData)localObject);
        switch (((HeadData)localObject).type)
        {
        case 11: 
        default: 
          throw new JceDecodeException("type mismatch.");
        case 0: 
          skip(1);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          skip(2);
          continue;
          skip(4);
          continue;
          skip(8);
          continue;
          skip(4);
          continue;
          skip(8);
          continue;
          int j = this.bs.get();
          int i = j;
          if (j < 0) {
            i = j + 256;
          }
          skip(i);
          continue;
          skip(this.bs.getInt());
          continue;
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
            throw new JceDecodeException("type mismatch." + localException);
          }
          localException.add(new Integer(0));
        }
      }
    }
    else if (paramBoolean)
    {
      throw new JceDecodeException("require field not exist.");
    }
    return localException;
  }
  
  public <K, V> HashMap<K, V> readMap(Map<K, V> paramMap, int paramInt, boolean paramBoolean)
  {
    return (HashMap)readMap(new HashMap(), paramMap, paramInt, paramBoolean);
  }
  
  public String readString(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (skipToTag(paramInt))
    {
      localObject1 = new HeadData();
      readHead((HeadData)localObject1);
      switch (((HeadData)localObject1).type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 6: 
        i = this.bs.get();
        paramInt = i;
        if (i < 0) {
          paramInt = i + 256;
        }
        localObject2 = new byte[paramInt];
        this.bs.get((byte[])localObject2);
      }
    }
    while (!paramBoolean)
    {
      Object localObject2;
      try
      {
        int i;
        localObject1 = new String((byte[])localObject2, this.sServerEncoding);
        return localObject1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        return new String((byte[])localObject2);
      }
      paramInt = this.bs.getInt();
      if ((paramInt > 104857600) || (paramInt < 0) || (paramInt > this.bs.capacity())) {
        throw new JceDecodeException("String too long: " + paramInt);
      }
      byte[] arrayOfByte = new byte[paramInt];
      this.bs.get(arrayOfByte);
      try
      {
        localObject2 = new String(arrayOfByte, this.sServerEncoding);
        return localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        return new String(arrayOfByte);
      }
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public Map<String, String> readStringMap(int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (skipToTag(paramInt))
    {
      HeadData localHeadData = new HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      }
      int i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
      paramInt = 0;
      while (paramInt < i)
      {
        localHashMap.put(readString(0, true), readString(1, true));
        paramInt += 1;
      }
    }
    if (paramBoolean) {
      throw new JceDecodeException("require field not exist.");
    }
    return localHashMap;
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
      readHead(localHeadData);
      skipField(localHeadData.type);
    } while (localHeadData.type != 11);
  }
  
  public boolean skipToTag(int paramInt)
  {
    try
    {
      HeadData localHeadData = new HeadData();
      for (;;)
      {
        int i = peakHead(localHeadData);
        if (localHeadData.type == 11) {
          return false;
        }
        if (paramInt <= localHeadData.tag)
        {
          if (paramInt != localHeadData.tag) {
            break;
          }
          return true;
        }
        skip(i);
        skipField(localHeadData.type);
      }
      return false;
    }
    catch (JceDecodeException localJceDecodeException)
    {
      return false;
    }
    catch (BufferUnderflowException localBufferUnderflowException) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.qq.taf.jce.JceInputStream
 * JD-Core Version:    0.7.0.1
 */