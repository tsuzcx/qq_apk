package com.qq.taf.jce;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class JceDisplayer
{
  private int _level = 0;
  private StringBuilder sb;
  
  public JceDisplayer(StringBuilder paramStringBuilder)
  {
    this.sb = paramStringBuilder;
  }
  
  public JceDisplayer(StringBuilder paramStringBuilder, int paramInt)
  {
    this.sb = paramStringBuilder;
    this._level = paramInt;
  }
  
  private void ps(String paramString)
  {
    int i = 0;
    while (i < this._level)
    {
      this.sb.append('\t');
      i += 1;
    }
    if (paramString != null) {
      this.sb.append(paramString).append(": ");
    }
  }
  
  public JceDisplayer display(byte paramByte, String paramString)
  {
    ps(paramString);
    this.sb.append(paramByte).append('\n');
    return this;
  }
  
  public JceDisplayer display(char paramChar, String paramString)
  {
    ps(paramString);
    this.sb.append(paramChar).append('\n');
    return this;
  }
  
  public JceDisplayer display(double paramDouble, String paramString)
  {
    ps(paramString);
    this.sb.append(paramDouble).append('\n');
    return this;
  }
  
  public JceDisplayer display(float paramFloat, String paramString)
  {
    ps(paramString);
    this.sb.append(paramFloat).append('\n');
    return this;
  }
  
  public JceDisplayer display(int paramInt, String paramString)
  {
    ps(paramString);
    this.sb.append(paramInt).append('\n');
    return this;
  }
  
  public JceDisplayer display(long paramLong, String paramString)
  {
    ps(paramString);
    this.sb.append(paramLong).append('\n');
    return this;
  }
  
  public JceDisplayer display(JceStruct paramJceStruct, String paramString)
  {
    display('{', paramString);
    if (paramJceStruct == null) {
      this.sb.append('\t').append("null");
    }
    for (;;)
    {
      display('}', null);
      return this;
      paramJceStruct.display(this.sb, this._level + 1);
    }
  }
  
  public JceDisplayer display(Object paramObject, String paramString)
  {
    if (paramObject == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if ((paramObject instanceof Byte))
    {
      display(((Byte)paramObject).byteValue(), paramString);
      return this;
    }
    if ((paramObject instanceof Boolean))
    {
      display(((Boolean)paramObject).booleanValue(), paramString);
      return this;
    }
    if ((paramObject instanceof Short))
    {
      display(((Short)paramObject).shortValue(), paramString);
      return this;
    }
    if ((paramObject instanceof Integer))
    {
      display(((Integer)paramObject).intValue(), paramString);
      return this;
    }
    if ((paramObject instanceof Long))
    {
      display(((Long)paramObject).longValue(), paramString);
      return this;
    }
    if ((paramObject instanceof Float))
    {
      display(((Float)paramObject).floatValue(), paramString);
      return this;
    }
    if ((paramObject instanceof Double))
    {
      display(((Double)paramObject).doubleValue(), paramString);
      return this;
    }
    if ((paramObject instanceof String))
    {
      display((String)paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof Map))
    {
      display((Map)paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof List))
    {
      display((List)paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof JceStruct))
    {
      display((JceStruct)paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof byte[]))
    {
      display((byte[])paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof boolean[]))
    {
      display((boolean[])paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof short[]))
    {
      display((short[])paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof int[]))
    {
      display((int[])paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof long[]))
    {
      display((long[])paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof float[]))
    {
      display((float[])paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof double[]))
    {
      display((double[])paramObject, paramString);
      return this;
    }
    if (paramObject.getClass().isArray())
    {
      display((Object[])paramObject, paramString);
      return this;
    }
    throw new JceEncodeException("write object error: unsupport type.");
  }
  
  public JceDisplayer display(String paramString1, String paramString2)
  {
    ps(paramString2);
    if (paramString1 == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    this.sb.append(paramString1).append('\n');
    return this;
  }
  
  public JceDisplayer display(Collection paramCollection, String paramString)
  {
    if (paramCollection == null)
    {
      ps(paramString);
      this.sb.append("null").append('\t');
      return this;
    }
    return display(paramCollection.toArray(), paramString);
  }
  
  public JceDisplayer display(Map paramMap, String paramString)
  {
    ps(paramString);
    if (paramMap == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (paramMap.isEmpty())
    {
      this.sb.append(paramMap.size()).append(", {}").append('\n');
      return this;
    }
    this.sb.append(paramMap.size()).append(", {").append('\n');
    paramString = new JceDisplayer(this.sb, this._level + 1);
    JceDisplayer localJceDisplayer = new JceDisplayer(this.sb, this._level + 2);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramString.display('(', null);
      localJceDisplayer.display(localEntry.getKey(), null);
      localJceDisplayer.display(localEntry.getValue(), null);
      paramString.display(')', null);
    }
    display('}', null);
    return this;
  }
  
  public JceDisplayer display(short paramShort, String paramString)
  {
    ps(paramString);
    this.sb.append(paramShort).append('\n');
    return this;
  }
  
  public JceDisplayer display(boolean paramBoolean, String paramString)
  {
    ps(paramString);
    paramString = this.sb;
    if (paramBoolean) {}
    for (char c = 'T';; c = 'F')
    {
      paramString.append(c).append('\n');
      return this;
    }
  }
  
  public JceDisplayer display(byte[] paramArrayOfByte, String paramString)
  {
    ps(paramString);
    if (paramArrayOfByte == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (paramArrayOfByte.length == 0)
    {
      this.sb.append(paramArrayOfByte.length).append(", []").append('\n');
      return this;
    }
    this.sb.append(paramArrayOfByte.length).append(", [").append('\n');
    paramString = new JceDisplayer(this.sb, this._level + 1);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramString.display(paramArrayOfByte[i], null);
      i += 1;
    }
    display(']', null);
    return this;
  }
  
  public JceDisplayer display(char[] paramArrayOfChar, String paramString)
  {
    ps(paramString);
    if (paramArrayOfChar == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (paramArrayOfChar.length == 0)
    {
      this.sb.append(paramArrayOfChar.length).append(", []").append('\n');
      return this;
    }
    this.sb.append(paramArrayOfChar.length).append(", [").append('\n');
    paramString = new JceDisplayer(this.sb, this._level + 1);
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      paramString.display(paramArrayOfChar[i], null);
      i += 1;
    }
    display(']', null);
    return this;
  }
  
  public JceDisplayer display(double[] paramArrayOfDouble, String paramString)
  {
    ps(paramString);
    if (paramArrayOfDouble == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (paramArrayOfDouble.length == 0)
    {
      this.sb.append(paramArrayOfDouble.length).append(", []").append('\n');
      return this;
    }
    this.sb.append(paramArrayOfDouble.length).append(", [").append('\n');
    paramString = new JceDisplayer(this.sb, this._level + 1);
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      paramString.display(paramArrayOfDouble[i], null);
      i += 1;
    }
    display(']', null);
    return this;
  }
  
  public JceDisplayer display(float[] paramArrayOfFloat, String paramString)
  {
    ps(paramString);
    if (paramArrayOfFloat == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (paramArrayOfFloat.length == 0)
    {
      this.sb.append(paramArrayOfFloat.length).append(", []").append('\n');
      return this;
    }
    this.sb.append(paramArrayOfFloat.length).append(", [").append('\n');
    paramString = new JceDisplayer(this.sb, this._level + 1);
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      paramString.display(paramArrayOfFloat[i], null);
      i += 1;
    }
    display(']', null);
    return this;
  }
  
  public JceDisplayer display(int[] paramArrayOfInt, String paramString)
  {
    ps(paramString);
    if (paramArrayOfInt == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (paramArrayOfInt.length == 0)
    {
      this.sb.append(paramArrayOfInt.length).append(", []").append('\n');
      return this;
    }
    this.sb.append(paramArrayOfInt.length).append(", [").append('\n');
    paramString = new JceDisplayer(this.sb, this._level + 1);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramString.display(paramArrayOfInt[i], null);
      i += 1;
    }
    display(']', null);
    return this;
  }
  
  public JceDisplayer display(long[] paramArrayOfLong, String paramString)
  {
    ps(paramString);
    if (paramArrayOfLong == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (paramArrayOfLong.length == 0)
    {
      this.sb.append(paramArrayOfLong.length).append(", []").append('\n');
      return this;
    }
    this.sb.append(paramArrayOfLong.length).append(", [").append('\n');
    paramString = new JceDisplayer(this.sb, this._level + 1);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramString.display(paramArrayOfLong[i], null);
      i += 1;
    }
    display(']', null);
    return this;
  }
  
  public JceDisplayer display(Object[] paramArrayOfObject, String paramString)
  {
    ps(paramString);
    if (paramArrayOfObject == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (paramArrayOfObject.length == 0)
    {
      this.sb.append(paramArrayOfObject.length).append(", []").append('\n');
      return this;
    }
    this.sb.append(paramArrayOfObject.length).append(", [").append('\n');
    paramString = new JceDisplayer(this.sb, this._level + 1);
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      paramString.display(paramArrayOfObject[i], null);
      i += 1;
    }
    display(']', null);
    return this;
  }
  
  public JceDisplayer display(short[] paramArrayOfShort, String paramString)
  {
    ps(paramString);
    if (paramArrayOfShort == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (paramArrayOfShort.length == 0)
    {
      this.sb.append(paramArrayOfShort.length).append(", []").append('\n');
      return this;
    }
    this.sb.append(paramArrayOfShort.length).append(", [").append('\n');
    paramString = new JceDisplayer(this.sb, this._level + 1);
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramString.display(paramArrayOfShort[i], null);
      i += 1;
    }
    display(']', null);
    return this;
  }
  
  public JceDisplayer displaySimple(byte paramByte, boolean paramBoolean)
  {
    this.sb.append(paramByte);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer displaySimple(char paramChar, boolean paramBoolean)
  {
    this.sb.append(paramChar);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer displaySimple(double paramDouble, boolean paramBoolean)
  {
    this.sb.append(paramDouble);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer displaySimple(float paramFloat, boolean paramBoolean)
  {
    this.sb.append(paramFloat);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer displaySimple(int paramInt, boolean paramBoolean)
  {
    this.sb.append(paramInt);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer displaySimple(long paramLong, boolean paramBoolean)
  {
    this.sb.append(paramLong);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer displaySimple(JceStruct paramJceStruct, boolean paramBoolean)
  {
    this.sb.append("{");
    if (paramJceStruct == null) {
      this.sb.append('\t').append("null");
    }
    for (;;)
    {
      this.sb.append("}");
      if (paramBoolean) {
        this.sb.append("|");
      }
      return this;
      paramJceStruct.displaySimple(this.sb, this._level + 1);
    }
  }
  
  public JceDisplayer displaySimple(Object paramObject, boolean paramBoolean)
  {
    if (paramObject == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if ((paramObject instanceof Byte))
    {
      displaySimple(((Byte)paramObject).byteValue(), paramBoolean);
      return this;
    }
    if ((paramObject instanceof Boolean))
    {
      displaySimple(((Boolean)paramObject).booleanValue(), paramBoolean);
      return this;
    }
    if ((paramObject instanceof Short))
    {
      displaySimple(((Short)paramObject).shortValue(), paramBoolean);
      return this;
    }
    if ((paramObject instanceof Integer))
    {
      displaySimple(((Integer)paramObject).intValue(), paramBoolean);
      return this;
    }
    if ((paramObject instanceof Long))
    {
      displaySimple(((Long)paramObject).longValue(), paramBoolean);
      return this;
    }
    if ((paramObject instanceof Float))
    {
      displaySimple(((Float)paramObject).floatValue(), paramBoolean);
      return this;
    }
    if ((paramObject instanceof Double))
    {
      displaySimple(((Double)paramObject).doubleValue(), paramBoolean);
      return this;
    }
    if ((paramObject instanceof String))
    {
      displaySimple((String)paramObject, paramBoolean);
      return this;
    }
    if ((paramObject instanceof Map))
    {
      displaySimple((Map)paramObject, paramBoolean);
      return this;
    }
    if ((paramObject instanceof List))
    {
      displaySimple((List)paramObject, paramBoolean);
      return this;
    }
    if ((paramObject instanceof JceStruct))
    {
      displaySimple((JceStruct)paramObject, paramBoolean);
      return this;
    }
    if ((paramObject instanceof byte[]))
    {
      displaySimple((byte[])paramObject, paramBoolean);
      return this;
    }
    if ((paramObject instanceof boolean[]))
    {
      displaySimple((boolean[])paramObject, paramBoolean);
      return this;
    }
    if ((paramObject instanceof short[]))
    {
      displaySimple((short[])paramObject, paramBoolean);
      return this;
    }
    if ((paramObject instanceof int[]))
    {
      displaySimple((int[])paramObject, paramBoolean);
      return this;
    }
    if ((paramObject instanceof long[]))
    {
      displaySimple((long[])paramObject, paramBoolean);
      return this;
    }
    if ((paramObject instanceof float[]))
    {
      displaySimple((float[])paramObject, paramBoolean);
      return this;
    }
    if ((paramObject instanceof double[]))
    {
      displaySimple((double[])paramObject, paramBoolean);
      return this;
    }
    if (paramObject.getClass().isArray())
    {
      displaySimple((Object[])paramObject, paramBoolean);
      return this;
    }
    throw new JceEncodeException("write object error: unsupport type.");
  }
  
  public JceDisplayer displaySimple(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      this.sb.append("null");
    }
    for (;;)
    {
      if (paramBoolean) {
        this.sb.append("|");
      }
      return this;
      this.sb.append(paramString);
    }
  }
  
  public JceDisplayer displaySimple(Collection paramCollection, boolean paramBoolean)
  {
    if (paramCollection == null)
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
      return this;
    }
    return displaySimple(paramCollection.toArray(), paramBoolean);
  }
  
  public JceDisplayer displaySimple(Map paramMap, boolean paramBoolean)
  {
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      this.sb.append("{}");
      if (paramBoolean) {
        this.sb.append("|");
      }
    }
    do
    {
      return this;
      this.sb.append("{");
      JceDisplayer localJceDisplayer = new JceDisplayer(this.sb, this._level + 2);
      paramMap = paramMap.entrySet().iterator();
      for (int i = 1; paramMap.hasNext(); i = 0)
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (i == 0) {
          this.sb.append(",");
        }
        localJceDisplayer.displaySimple(localEntry.getKey(), true);
        localJceDisplayer.displaySimple(localEntry.getValue(), false);
      }
      this.sb.append("}");
    } while (!paramBoolean);
    this.sb.append("|");
    return this;
  }
  
  public JceDisplayer displaySimple(short paramShort, boolean paramBoolean)
  {
    this.sb.append(paramShort);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer displaySimple(boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = this.sb;
    if (paramBoolean1) {}
    for (char c = 'T';; c = 'F')
    {
      localStringBuilder.append(c);
      if (paramBoolean2) {
        this.sb.append("|");
      }
      return this;
    }
  }
  
  public JceDisplayer displaySimple(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      if (paramBoolean) {
        this.sb.append("|");
      }
    }
    do
    {
      return this;
      this.sb.append(HexUtil.bytes2HexStr(paramArrayOfByte));
    } while (!paramBoolean);
    this.sb.append("|");
    return this;
  }
  
  public JceDisplayer displaySimple(char[] paramArrayOfChar, boolean paramBoolean)
  {
    if ((paramArrayOfChar == null) || (paramArrayOfChar.length == 0)) {
      if (paramBoolean) {
        this.sb.append("|");
      }
    }
    do
    {
      return this;
      this.sb.append(new String(paramArrayOfChar));
    } while (!paramBoolean);
    this.sb.append("|");
    return this;
  }
  
  public JceDisplayer displaySimple(double[] paramArrayOfDouble, boolean paramBoolean)
  {
    if ((paramArrayOfDouble == null) || (paramArrayOfDouble.length == 0))
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
    }
    do
    {
      return this;
      this.sb.append("[");
      JceDisplayer localJceDisplayer = new JceDisplayer(this.sb, this._level + 1);
      int i = 0;
      while (i < paramArrayOfDouble.length)
      {
        double d = paramArrayOfDouble[i];
        if (i != 0) {
          this.sb.append("|");
        }
        localJceDisplayer.displaySimple(d, false);
        i += 1;
      }
      this.sb.append("[");
    } while (!paramBoolean);
    this.sb.append("|");
    return this;
  }
  
  public JceDisplayer displaySimple(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0))
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
    }
    do
    {
      return this;
      this.sb.append("[");
      JceDisplayer localJceDisplayer = new JceDisplayer(this.sb, this._level + 1);
      int i = 0;
      while (i < paramArrayOfFloat.length)
      {
        float f = paramArrayOfFloat[i];
        if (i != 0) {
          this.sb.append("|");
        }
        localJceDisplayer.displaySimple(f, false);
        i += 1;
      }
      this.sb.append("]");
    } while (!paramBoolean);
    this.sb.append("|");
    return this;
  }
  
  public JceDisplayer displaySimple(int[] paramArrayOfInt, boolean paramBoolean)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
    }
    do
    {
      return this;
      this.sb.append("[");
      JceDisplayer localJceDisplayer = new JceDisplayer(this.sb, this._level + 1);
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        int j = paramArrayOfInt[i];
        if (i != 0) {
          this.sb.append("|");
        }
        localJceDisplayer.displaySimple(j, false);
        i += 1;
      }
      this.sb.append("]");
    } while (!paramBoolean);
    this.sb.append("|");
    return this;
  }
  
  public JceDisplayer displaySimple(long[] paramArrayOfLong, boolean paramBoolean)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0))
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
    }
    do
    {
      return this;
      this.sb.append("[");
      JceDisplayer localJceDisplayer = new JceDisplayer(this.sb, this._level + 1);
      int i = 0;
      while (i < paramArrayOfLong.length)
      {
        long l = paramArrayOfLong[i];
        if (i != 0) {
          this.sb.append("|");
        }
        localJceDisplayer.displaySimple(l, false);
        i += 1;
      }
      this.sb.append("]");
    } while (!paramBoolean);
    this.sb.append("|");
    return this;
  }
  
  public JceDisplayer displaySimple(Object[] paramArrayOfObject, boolean paramBoolean)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0))
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
    }
    do
    {
      return this;
      this.sb.append("[");
      JceDisplayer localJceDisplayer = new JceDisplayer(this.sb, this._level + 1);
      int i = 0;
      while (i < paramArrayOfObject.length)
      {
        Object localObject = paramArrayOfObject[i];
        if (i != 0) {
          this.sb.append("|");
        }
        localJceDisplayer.displaySimple(localObject, false);
        i += 1;
      }
      this.sb.append("]");
    } while (!paramBoolean);
    this.sb.append("|");
    return this;
  }
  
  public JceDisplayer displaySimple(short[] paramArrayOfShort, boolean paramBoolean)
  {
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0))
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
    }
    do
    {
      return this;
      this.sb.append("[");
      JceDisplayer localJceDisplayer = new JceDisplayer(this.sb, this._level + 1);
      int i = 0;
      while (i < paramArrayOfShort.length)
      {
        short s = paramArrayOfShort[i];
        if (i != 0) {
          this.sb.append("|");
        }
        localJceDisplayer.displaySimple(s, false);
        i += 1;
      }
      this.sb.append("]");
    } while (!paramBoolean);
    this.sb.append("|");
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.qq.taf.jce.JceDisplayer
 * JD-Core Version:    0.7.0.1
 */