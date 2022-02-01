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
    if (paramString != null)
    {
      StringBuilder localStringBuilder = this.sb;
      localStringBuilder.append(paramString);
      localStringBuilder.append(": ");
    }
  }
  
  public final JceDisplayer display(byte paramByte, String paramString)
  {
    ps(paramString);
    paramString = this.sb;
    paramString.append(paramByte);
    paramString.append('\n');
    return this;
  }
  
  public final JceDisplayer display(char paramChar, String paramString)
  {
    ps(paramString);
    paramString = this.sb;
    paramString.append(paramChar);
    paramString.append('\n');
    return this;
  }
  
  public final JceDisplayer display(double paramDouble, String paramString)
  {
    ps(paramString);
    paramString = this.sb;
    paramString.append(paramDouble);
    paramString.append('\n');
    return this;
  }
  
  public final JceDisplayer display(float paramFloat, String paramString)
  {
    ps(paramString);
    paramString = this.sb;
    paramString.append(paramFloat);
    paramString.append('\n');
    return this;
  }
  
  public final JceDisplayer display(int paramInt, String paramString)
  {
    ps(paramString);
    paramString = this.sb;
    paramString.append(paramInt);
    paramString.append('\n');
    return this;
  }
  
  public final JceDisplayer display(long paramLong, String paramString)
  {
    ps(paramString);
    paramString = this.sb;
    paramString.append(paramLong);
    paramString.append('\n');
    return this;
  }
  
  public final JceDisplayer display(JceStruct paramJceStruct, String paramString)
  {
    display('{', paramString);
    if (paramJceStruct == null)
    {
      paramJceStruct = this.sb;
      paramJceStruct.append('\t');
      paramJceStruct.append("null");
    }
    else
    {
      paramJceStruct.display(this.sb, this._level + 1);
    }
    display('}', null);
    return this;
  }
  
  public final <T> JceDisplayer display(T paramT, String paramString)
  {
    if (paramT == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if ((paramT instanceof Byte))
    {
      display(((Byte)paramT).byteValue(), paramString);
      return this;
    }
    if ((paramT instanceof Boolean))
    {
      display(((Boolean)paramT).booleanValue(), paramString);
      return this;
    }
    if ((paramT instanceof Short))
    {
      display(((Short)paramT).shortValue(), paramString);
      return this;
    }
    if ((paramT instanceof Integer))
    {
      display(((Integer)paramT).intValue(), paramString);
      return this;
    }
    if ((paramT instanceof Long))
    {
      display(((Long)paramT).longValue(), paramString);
      return this;
    }
    if ((paramT instanceof Float))
    {
      display(((Float)paramT).floatValue(), paramString);
      return this;
    }
    if ((paramT instanceof Double))
    {
      display(((Double)paramT).doubleValue(), paramString);
      return this;
    }
    if ((paramT instanceof String))
    {
      display((String)paramT, paramString);
      return this;
    }
    if ((paramT instanceof Map))
    {
      display((Map)paramT, paramString);
      return this;
    }
    if ((paramT instanceof List))
    {
      display((List)paramT, paramString);
      return this;
    }
    if ((paramT instanceof JceStruct))
    {
      display((JceStruct)paramT, paramString);
      return this;
    }
    if ((paramT instanceof byte[]))
    {
      display((byte[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof boolean[]))
    {
      display((boolean[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof short[]))
    {
      display((short[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof int[]))
    {
      display((int[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof long[]))
    {
      display((long[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof float[]))
    {
      display((float[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof double[]))
    {
      display((double[])paramT, paramString);
      return this;
    }
    if (paramT.getClass().isArray())
    {
      display((Object[])paramT, paramString);
      return this;
    }
    throw new JceEncodeException("write object error: unsupport type.");
  }
  
  public final JceDisplayer display(String paramString1, String paramString2)
  {
    ps(paramString2);
    if (paramString1 == null)
    {
      this.sb.append("null\n");
      return this;
    }
    paramString2 = this.sb;
    paramString2.append(paramString1);
    paramString2.append('\n');
    return this;
  }
  
  public final <T> JceDisplayer display(Collection<T> paramCollection, String paramString)
  {
    if (paramCollection == null)
    {
      ps(paramString);
      this.sb.append("null\t");
      return this;
    }
    return display(paramCollection.toArray(), paramString);
  }
  
  public final <K, V> JceDisplayer display(Map<K, V> paramMap, String paramString)
  {
    ps(paramString);
    if (paramMap == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if (paramMap.isEmpty())
    {
      paramString = this.sb;
      paramString.append(paramMap.size());
      paramString.append(", {}\n");
      return this;
    }
    paramString = this.sb;
    paramString.append(paramMap.size());
    paramString.append(", {\n");
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
  
  public final JceDisplayer display(short paramShort, String paramString)
  {
    ps(paramString);
    paramString = this.sb;
    paramString.append(paramShort);
    paramString.append('\n');
    return this;
  }
  
  public final JceDisplayer display(boolean paramBoolean, String paramString)
  {
    ps(paramString);
    paramString = this.sb;
    char c;
    if (paramBoolean) {
      c = 'T';
    } else {
      c = 'F';
    }
    paramString.append(c);
    paramString.append('\n');
    return this;
  }
  
  public final JceDisplayer display(byte[] paramArrayOfByte, String paramString)
  {
    ps(paramString);
    if (paramArrayOfByte == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if (paramArrayOfByte.length == 0)
    {
      paramString = this.sb;
      paramString.append(paramArrayOfByte.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.sb;
    paramString.append(paramArrayOfByte.length);
    paramString.append(", [\n");
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
  
  public final JceDisplayer display(char[] paramArrayOfChar, String paramString)
  {
    ps(paramString);
    if (paramArrayOfChar == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if (paramArrayOfChar.length == 0)
    {
      paramString = this.sb;
      paramString.append(paramArrayOfChar.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.sb;
    paramString.append(paramArrayOfChar.length);
    paramString.append(", [\n");
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
  
  public final JceDisplayer display(double[] paramArrayOfDouble, String paramString)
  {
    ps(paramString);
    if (paramArrayOfDouble == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if (paramArrayOfDouble.length == 0)
    {
      paramString = this.sb;
      paramString.append(paramArrayOfDouble.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.sb;
    paramString.append(paramArrayOfDouble.length);
    paramString.append(", [\n");
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
  
  public final JceDisplayer display(float[] paramArrayOfFloat, String paramString)
  {
    ps(paramString);
    if (paramArrayOfFloat == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if (paramArrayOfFloat.length == 0)
    {
      paramString = this.sb;
      paramString.append(paramArrayOfFloat.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.sb;
    paramString.append(paramArrayOfFloat.length);
    paramString.append(", [\n");
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
  
  public final JceDisplayer display(int[] paramArrayOfInt, String paramString)
  {
    ps(paramString);
    if (paramArrayOfInt == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if (paramArrayOfInt.length == 0)
    {
      paramString = this.sb;
      paramString.append(paramArrayOfInt.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.sb;
    paramString.append(paramArrayOfInt.length);
    paramString.append(", [\n");
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
  
  public final JceDisplayer display(long[] paramArrayOfLong, String paramString)
  {
    ps(paramString);
    if (paramArrayOfLong == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if (paramArrayOfLong.length == 0)
    {
      paramString = this.sb;
      paramString.append(paramArrayOfLong.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.sb;
    paramString.append(paramArrayOfLong.length);
    paramString.append(", [\n");
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
  
  public final <T> JceDisplayer display(T[] paramArrayOfT, String paramString)
  {
    ps(paramString);
    if (paramArrayOfT == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if (paramArrayOfT.length == 0)
    {
      paramString = this.sb;
      paramString.append(paramArrayOfT.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.sb;
    paramString.append(paramArrayOfT.length);
    paramString.append(", [\n");
    paramString = new JceDisplayer(this.sb, this._level + 1);
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramString.display(paramArrayOfT[i], null);
      i += 1;
    }
    display(']', null);
    return this;
  }
  
  public final JceDisplayer display(short[] paramArrayOfShort, String paramString)
  {
    ps(paramString);
    if (paramArrayOfShort == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if (paramArrayOfShort.length == 0)
    {
      paramString = this.sb;
      paramString.append(paramArrayOfShort.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.sb;
    paramString.append(paramArrayOfShort.length);
    paramString.append(", [\n");
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
  
  public final JceDisplayer displaySimple(byte paramByte, boolean paramBoolean)
  {
    this.sb.append(paramByte);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(char paramChar, boolean paramBoolean)
  {
    this.sb.append(paramChar);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(double paramDouble, boolean paramBoolean)
  {
    this.sb.append(paramDouble);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(float paramFloat, boolean paramBoolean)
  {
    this.sb.append(paramFloat);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(int paramInt, boolean paramBoolean)
  {
    this.sb.append(paramInt);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(long paramLong, boolean paramBoolean)
  {
    this.sb.append(paramLong);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(JceStruct paramJceStruct, boolean paramBoolean)
  {
    this.sb.append("{");
    if (paramJceStruct == null)
    {
      paramJceStruct = this.sb;
      paramJceStruct.append('\t');
      paramJceStruct.append("null");
    }
    else
    {
      paramJceStruct.displaySimple(this.sb, this._level + 1);
    }
    this.sb.append("}");
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final <T> JceDisplayer displaySimple(T paramT, boolean paramBoolean)
  {
    if (paramT == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if ((paramT instanceof Byte))
    {
      displaySimple(((Byte)paramT).byteValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Boolean))
    {
      displaySimple(((Boolean)paramT).booleanValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Short))
    {
      displaySimple(((Short)paramT).shortValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Integer))
    {
      displaySimple(((Integer)paramT).intValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Long))
    {
      displaySimple(((Long)paramT).longValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Float))
    {
      displaySimple(((Float)paramT).floatValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Double))
    {
      displaySimple(((Double)paramT).doubleValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof String))
    {
      displaySimple((String)paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof Map))
    {
      displaySimple((Map)paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof List))
    {
      displaySimple((List)paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof JceStruct))
    {
      displaySimple((JceStruct)paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof byte[]))
    {
      displaySimple((byte[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof boolean[]))
    {
      displaySimple((boolean[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof short[]))
    {
      displaySimple((short[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof int[]))
    {
      displaySimple((int[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof long[]))
    {
      displaySimple((long[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof float[]))
    {
      displaySimple((float[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof double[]))
    {
      displaySimple((double[])paramT, paramBoolean);
      return this;
    }
    if (paramT.getClass().isArray())
    {
      displaySimple((Object[])paramT, paramBoolean);
      return this;
    }
    throw new JceEncodeException("write object error: unsupport type.");
  }
  
  public final JceDisplayer displaySimple(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      this.sb.append("null");
    } else {
      this.sb.append(paramString);
    }
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final <T> JceDisplayer displaySimple(Collection<T> paramCollection, boolean paramBoolean)
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
  
  public final <K, V> JceDisplayer displaySimple(Map<K, V> paramMap, boolean paramBoolean)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
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
      if (paramBoolean) {
        this.sb.append("|");
      }
      return this;
    }
    this.sb.append("{}");
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(short paramShort, boolean paramBoolean)
  {
    this.sb.append(paramShort);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = this.sb;
    char c;
    if (paramBoolean1) {
      c = 'T';
    } else {
      c = 'F';
    }
    localStringBuilder.append(c);
    if (paramBoolean2) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      this.sb.append(HexUtil.bytes2HexStr(paramArrayOfByte));
      if (paramBoolean) {
        this.sb.append("|");
      }
      return this;
    }
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(char[] paramArrayOfChar, boolean paramBoolean)
  {
    if ((paramArrayOfChar != null) && (paramArrayOfChar.length != 0))
    {
      this.sb.append(new String(paramArrayOfChar));
      if (paramBoolean) {
        this.sb.append("|");
      }
      return this;
    }
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(double[] paramArrayOfDouble, boolean paramBoolean)
  {
    if ((paramArrayOfDouble != null) && (paramArrayOfDouble.length != 0))
    {
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
      if (paramBoolean) {
        this.sb.append("|");
      }
      return this;
    }
    this.sb.append("[]");
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != 0))
    {
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
      if (paramBoolean) {
        this.sb.append("|");
      }
      return this;
    }
    this.sb.append("[]");
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(int[] paramArrayOfInt, boolean paramBoolean)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0))
    {
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
      if (paramBoolean) {
        this.sb.append("|");
      }
      return this;
    }
    this.sb.append("[]");
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(long[] paramArrayOfLong, boolean paramBoolean)
  {
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length != 0))
    {
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
      if (paramBoolean) {
        this.sb.append("|");
      }
      return this;
    }
    this.sb.append("[]");
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final <T> JceDisplayer displaySimple(T[] paramArrayOfT, boolean paramBoolean)
  {
    if ((paramArrayOfT != null) && (paramArrayOfT.length != 0))
    {
      this.sb.append("[");
      JceDisplayer localJceDisplayer = new JceDisplayer(this.sb, this._level + 1);
      int i = 0;
      while (i < paramArrayOfT.length)
      {
        T ? = paramArrayOfT[i];
        if (i != 0) {
          this.sb.append("|");
        }
        localJceDisplayer.displaySimple(?, false);
        i += 1;
      }
      this.sb.append("]");
      if (paramBoolean) {
        this.sb.append("|");
      }
      return this;
    }
    this.sb.append("[]");
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(short[] paramArrayOfShort, boolean paramBoolean)
  {
    if ((paramArrayOfShort != null) && (paramArrayOfShort.length != 0))
    {
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
      if (paramBoolean) {
        this.sb.append("|");
      }
      return this;
    }
    this.sb.append("[]");
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.qq.taf.jce.JceDisplayer
 * JD-Core Version:    0.7.0.1
 */