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
  
  private int peakHead(JceInputStream.HeadData paramHeadData)
  {
    return readHead(paramHeadData, this.bs.duplicate());
  }
  
  private Object[] readArrayImpl(Object paramObject, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      localObject = new JceInputStream.HeadData();
      readHead((JceInputStream.HeadData)localObject);
    }
    switch (((JceInputStream.HeadData)localObject).type)
    {
    case 10: 
    default: 
      throw new JceDecodeException("type mismatch.");
    case 9: 
      int i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
      Object[] arrayOfObject = (Object[])Array.newInstance(paramObject.getClass(), i);
      paramInt = 0;
      for (;;)
      {
        localObject = arrayOfObject;
        if (paramInt >= i) {
          break;
        }
        arrayOfObject[paramInt] = read(paramObject, 0, true);
        paramInt += 1;
      }
      if (paramBoolean) {
        throw new JceDecodeException("require field not exist.");
      }
      break;
    }
    Object localObject = null;
    return localObject;
  }
  
  public static int readHead(JceInputStream.HeadData paramHeadData, ByteBuffer paramByteBuffer)
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
  
  private Map readMap(Map paramMap1, Map paramMap2, int paramInt, boolean paramBoolean)
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
        JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
        readHead(localHeadData);
        paramMap2 = paramMap1;
        switch (localHeadData.type)
        {
        case 11: 
        case 9: 
        case 10: 
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
    JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
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
      b1 = this.bs.get();
      paramByte = b1;
      if (b1 < 0) {
        paramByte = b1 + 256;
      }
      skip(paramByte);
      return;
    case 7: 
      skip(this.bs.getInt());
      return;
    case 8: 
      b2 = read(0, 0, true);
      paramByte = b1;
      while (paramByte < b2 * 2)
      {
        skipField();
        paramByte += 1;
      }
    case 9: 
      b1 = read(0, 0, true);
      paramByte = b2;
      while (paramByte < b1)
      {
        skipField();
        paramByte += 1;
      }
    case 13: 
      JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
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
    JceInputStream.HeadData localHeadData = null;
    if (skipToTag(paramInt))
    {
      try
      {
        paramJceStruct = paramJceStruct.newInit();
        localHeadData = new JceInputStream.HeadData();
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
      localHeadData = new JceInputStream.HeadData();
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
      JceInputStream.HeadData localHeadData;
      return paramByte;
      return this.bs.get();
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public double read(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      default: 
        throw new JceDecodeException("type mismatch.");
      case 12: 
        paramDouble = 0.0D;
      }
    }
    while (!paramBoolean)
    {
      JceInputStream.HeadData localHeadData;
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
      localHeadData = new JceInputStream.HeadData();
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
      JceInputStream.HeadData localHeadData;
      return paramFloat;
      return this.bs.getFloat();
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public int read(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (skipToTag(paramInt2))
    {
      localHeadData = new JceInputStream.HeadData();
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
      JceInputStream.HeadData localHeadData;
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
      localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      default: 
        throw new JceDecodeException("type mismatch.");
      case 12: 
        paramLong = 0L;
      }
    }
    while (!paramBoolean)
    {
      JceInputStream.HeadData localHeadData;
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
    JceInputStream.HeadData localHeadData = null;
    if (skipToTag(paramInt))
    {
      try
      {
        paramJceStruct = (JceStruct)paramJceStruct.getClass().newInstance();
        localHeadData = new JceInputStream.HeadData();
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
  
  public Object read(Object paramObject, int paramInt, boolean paramBoolean)
  {
    if ((paramObject instanceof Byte)) {
      return Byte.valueOf(read((byte)0, paramInt, paramBoolean));
    }
    if ((paramObject instanceof Boolean)) {
      return Boolean.valueOf(read(false, paramInt, paramBoolean));
    }
    if ((paramObject instanceof Short)) {
      return Short.valueOf(read((short)0, paramInt, paramBoolean));
    }
    if ((paramObject instanceof Integer)) {
      return Integer.valueOf(read(0, paramInt, paramBoolean));
    }
    if ((paramObject instanceof Long)) {
      return Long.valueOf(read(0L, paramInt, paramBoolean));
    }
    if ((paramObject instanceof Float)) {
      return Float.valueOf(read(0.0F, paramInt, paramBoolean));
    }
    if ((paramObject instanceof Double)) {
      return Double.valueOf(read(0.0D, paramInt, paramBoolean));
    }
    if ((paramObject instanceof String)) {
      return readString(paramInt, paramBoolean);
    }
    if ((paramObject instanceof Map)) {
      return readMap((Map)paramObject, paramInt, paramBoolean);
    }
    if ((paramObject instanceof List)) {
      return readArray((List)paramObject, paramInt, paramBoolean);
    }
    if ((paramObject instanceof JceStruct)) {
      return read((JceStruct)paramObject, paramInt, paramBoolean);
    }
    if (paramObject.getClass().isArray())
    {
      if (((paramObject instanceof byte[])) || ((paramObject instanceof Byte[]))) {
        return read((byte[])null, paramInt, paramBoolean);
      }
      if ((paramObject instanceof boolean[])) {
        return read((boolean[])null, paramInt, paramBoolean);
      }
      if ((paramObject instanceof short[])) {
        return read((short[])null, paramInt, paramBoolean);
      }
      if ((paramObject instanceof int[])) {
        return read((int[])null, paramInt, paramBoolean);
      }
      if ((paramObject instanceof long[])) {
        return read((long[])null, paramInt, paramBoolean);
      }
      if ((paramObject instanceof float[])) {
        return read((float[])null, paramInt, paramBoolean);
      }
      if ((paramObject instanceof double[])) {
        return read((double[])null, paramInt, paramBoolean);
      }
      return readArray((Object[])paramObject, paramInt, paramBoolean);
    }
    throw new JceDecodeException("read object error: unsupport type.");
  }
  
  public String read(String paramString, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      Object localObject = new JceInputStream.HeadData();
      readHead((JceInputStream.HeadData)localObject);
      switch (((JceInputStream.HeadData)localObject).type)
      {
      case 8: 
      case 9: 
      case 10: 
      default: 
        throw new JceDecodeException("type mismatch.");
      case 6: 
        int i = this.bs.get();
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
        catch (UnsupportedEncodingException localUnsupportedEncodingException1)
        {
          return new String(paramString);
        }
      case 7: 
        paramInt = this.bs.getInt();
        if ((paramInt > 104857600) || (paramInt < 0)) {
          throw new JceDecodeException("String too long: " + paramInt);
        }
        paramString = new byte[paramInt];
        this.bs.get(paramString);
        try
        {
          String str = new String(paramString, this.sServerEncoding);
          return str;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          return new String(paramString);
        }
      }
      return paramString;
    }
    if (paramBoolean) {
      throw new JceDecodeException("require field not exist.");
    }
    return paramString;
  }
  
  public short read(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      localHeadData = new JceInputStream.HeadData();
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
      JceInputStream.HeadData localHeadData;
      return paramShort;
      return (short)this.bs.get();
      return this.bs.getShort();
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public boolean read(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (int i = 1; read((byte)i, paramInt, paramBoolean2) != 0; i = 0) {
      return true;
    }
    return false;
  }
  
  public byte[] read(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    paramArrayOfByte = null;
    if (skipToTag(paramInt))
    {
      localObject = new JceInputStream.HeadData();
      readHead((JceInputStream.HeadData)localObject);
      switch (((JceInputStream.HeadData)localObject).type)
      {
      case 10: 
      case 12: 
      default: 
        throw new JceDecodeException("type mismatch.");
      case 13: 
        paramArrayOfByte = new JceInputStream.HeadData();
        readHead(paramArrayOfByte);
        if (paramArrayOfByte.type != 0) {
          throw new JceDecodeException("type mismatch, tag: " + paramInt + ", type: " + ((JceInputStream.HeadData)localObject).type + ", " + paramArrayOfByte.type);
        }
        i = read(0, 0, true);
        if (i < 0) {
          throw new JceDecodeException("invalid size, tag: " + paramInt + ", type: " + ((JceInputStream.HeadData)localObject).type + ", " + paramArrayOfByte.type + ", size: " + i);
        }
        paramArrayOfByte = new byte[i];
        this.bs.get(paramArrayOfByte);
      }
    }
    while (!paramBoolean)
    {
      return paramArrayOfByte;
      int i = read(0, 0, true);
      if (i < 0) {
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
    Object localObject;
    if (skipToTag(paramInt))
    {
      localObject = new JceInputStream.HeadData();
      readHead((JceInputStream.HeadData)localObject);
    }
    switch (((JceInputStream.HeadData)localObject).type)
    {
    case 10: 
    default: 
      throw new JceDecodeException("type mismatch.");
    case 9: 
      int i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
      localObject = new double[i];
      paramInt = 0;
      for (;;)
      {
        paramArrayOfDouble = (double[])localObject;
        if (paramInt >= i) {
          break;
        }
        localObject[paramInt] = read(localObject[0], 0, true);
        paramInt += 1;
      }
      if (paramBoolean) {
        throw new JceDecodeException("require field not exist.");
      }
      break;
    }
    return paramArrayOfDouble;
  }
  
  public float[] read(float[] paramArrayOfFloat, int paramInt, boolean paramBoolean)
  {
    paramArrayOfFloat = null;
    Object localObject;
    if (skipToTag(paramInt))
    {
      localObject = new JceInputStream.HeadData();
      readHead((JceInputStream.HeadData)localObject);
    }
    switch (((JceInputStream.HeadData)localObject).type)
    {
    case 10: 
    default: 
      throw new JceDecodeException("type mismatch.");
    case 9: 
      int i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
      localObject = new float[i];
      paramInt = 0;
      for (;;)
      {
        paramArrayOfFloat = (float[])localObject;
        if (paramInt >= i) {
          break;
        }
        localObject[paramInt] = read(localObject[0], 0, true);
        paramInt += 1;
      }
      if (paramBoolean) {
        throw new JceDecodeException("require field not exist.");
      }
      break;
    }
    return paramArrayOfFloat;
  }
  
  public int[] read(int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    paramArrayOfInt = null;
    Object localObject;
    if (skipToTag(paramInt))
    {
      localObject = new JceInputStream.HeadData();
      readHead((JceInputStream.HeadData)localObject);
    }
    switch (((JceInputStream.HeadData)localObject).type)
    {
    case 10: 
    default: 
      throw new JceDecodeException("type mismatch.");
    case 9: 
      int i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
      localObject = new int[i];
      paramInt = 0;
      for (;;)
      {
        paramArrayOfInt = (int[])localObject;
        if (paramInt >= i) {
          break;
        }
        localObject[paramInt] = read(localObject[0], 0, true);
        paramInt += 1;
      }
      if (paramBoolean) {
        throw new JceDecodeException("require field not exist.");
      }
      break;
    }
    return paramArrayOfInt;
  }
  
  public long[] read(long[] paramArrayOfLong, int paramInt, boolean paramBoolean)
  {
    paramArrayOfLong = null;
    Object localObject;
    if (skipToTag(paramInt))
    {
      localObject = new JceInputStream.HeadData();
      readHead((JceInputStream.HeadData)localObject);
    }
    switch (((JceInputStream.HeadData)localObject).type)
    {
    case 10: 
    default: 
      throw new JceDecodeException("type mismatch.");
    case 9: 
      int i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
      localObject = new long[i];
      paramInt = 0;
      for (;;)
      {
        paramArrayOfLong = (long[])localObject;
        if (paramInt >= i) {
          break;
        }
        localObject[paramInt] = read(localObject[0], 0, true);
        paramInt += 1;
      }
      if (paramBoolean) {
        throw new JceDecodeException("require field not exist.");
      }
      break;
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
    Object localObject;
    if (skipToTag(paramInt))
    {
      localObject = new JceInputStream.HeadData();
      readHead((JceInputStream.HeadData)localObject);
    }
    switch (((JceInputStream.HeadData)localObject).type)
    {
    case 10: 
    default: 
      throw new JceDecodeException("type mismatch.");
    case 9: 
      int i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
      localObject = new short[i];
      paramInt = 0;
      for (;;)
      {
        paramArrayOfShort = (short[])localObject;
        if (paramInt >= i) {
          break;
        }
        localObject[paramInt] = read(localObject[0], 0, true);
        paramInt += 1;
      }
      if (paramBoolean) {
        throw new JceDecodeException("require field not exist.");
      }
      break;
    }
    return paramArrayOfShort;
  }
  
  public boolean[] read(boolean[] paramArrayOfBoolean, int paramInt, boolean paramBoolean)
  {
    paramArrayOfBoolean = null;
    Object localObject;
    if (skipToTag(paramInt))
    {
      localObject = new JceInputStream.HeadData();
      readHead((JceInputStream.HeadData)localObject);
    }
    switch (((JceInputStream.HeadData)localObject).type)
    {
    case 10: 
    default: 
      throw new JceDecodeException("type mismatch.");
    case 9: 
      int i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
      localObject = new boolean[i];
      paramInt = 0;
      for (;;)
      {
        paramArrayOfBoolean = (boolean[])localObject;
        if (paramInt >= i) {
          break;
        }
        localObject[paramInt] = read(localObject[0], 0, true);
        paramInt += 1;
      }
      if (paramBoolean) {
        throw new JceDecodeException("require field not exist.");
      }
      break;
    }
    return paramArrayOfBoolean;
  }
  
  public List readArray(List paramList, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    if ((paramList == null) || (paramList.isEmpty())) {
      return new ArrayList();
    }
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
  
  public Object[] readArray(Object[] paramArrayOfObject, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
      throw new JceDecodeException("unable to get type of key and value.");
    }
    return readArrayImpl(paramArrayOfObject[0], paramInt, paramBoolean);
  }
  
  public String readByteString(String paramString, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      case 8: 
      case 9: 
      case 10: 
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
      JceInputStream.HeadData localHeadData;
      int i;
      return paramString;
      paramInt = this.bs.getInt();
      if ((paramInt > 104857600) || (paramInt < 0)) {
        throw new JceDecodeException("String too long: " + paramInt);
      }
      paramString = new byte[paramInt];
      this.bs.get(paramString);
      return HexUtil.bytes2HexStr(paramString);
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public void readHead(JceInputStream.HeadData paramHeadData)
  {
    readHead(paramHeadData, this.bs);
  }
  
  public List readList(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (skipToTag(paramInt))
    {
      Object localObject = new JceInputStream.HeadData();
      readHead((JceInputStream.HeadData)localObject);
      switch (((JceInputStream.HeadData)localObject).type)
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
        localObject = new JceInputStream.HeadData();
        readHead((JceInputStream.HeadData)localObject);
        switch (((JceInputStream.HeadData)localObject).type)
        {
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
  
  public HashMap readMap(Map paramMap, int paramInt, boolean paramBoolean)
  {
    return (HashMap)readMap(new HashMap(), paramMap, paramInt, paramBoolean);
  }
  
  public String readString(int paramInt, boolean paramBoolean)
  {
    String str = null;
    if (skipToTag(paramInt))
    {
      localObject = new JceInputStream.HeadData();
      readHead((JceInputStream.HeadData)localObject);
      switch (((JceInputStream.HeadData)localObject).type)
      {
      case 8: 
      case 9: 
      case 10: 
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
        str = new String((byte[])localObject, this.sServerEncoding);
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        return new String((byte[])localObject);
      }
      paramInt = this.bs.getInt();
      if ((paramInt > 104857600) || (paramInt < 0)) {
        throw new JceDecodeException("String too long: " + paramInt);
      }
      byte[] arrayOfByte = new byte[paramInt];
      this.bs.get(arrayOfByte);
      try
      {
        localObject = new String(arrayOfByte, this.sServerEncoding);
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        return new String(arrayOfByte);
      }
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public Map readStringMap(int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    JceInputStream.HeadData localHeadData;
    if (skipToTag(paramInt))
    {
      localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
    }
    switch (localHeadData.type)
    {
    case 9: 
    case 10: 
    default: 
      throw new JceDecodeException("type mismatch.");
    case 8: 
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
      if (paramBoolean) {
        throw new JceDecodeException("require field not exist.");
      }
      break;
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
    JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
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
    try
    {
      JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
      for (;;)
      {
        int i = peakHead(localHeadData);
        if ((paramInt <= localHeadData.tag) || (localHeadData.type == 11))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.qq.taf.jce.JceInputStream
 * JD-Core Version:    0.7.0.1
 */