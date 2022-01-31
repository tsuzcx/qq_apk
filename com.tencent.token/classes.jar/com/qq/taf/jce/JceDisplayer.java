package com.qq.taf.jce;

import java.io.PrintStream;
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
  
  public static void main(String[] paramArrayOfString)
  {
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append(1.2D);
    System.out.println(paramArrayOfString.toString());
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
  
  public <T> JceDisplayer display(T paramT, String paramString)
  {
    if (paramT == null)
    {
      this.sb.append("null").append('\n');
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
  
  public <T> JceDisplayer display(Collection<T> paramCollection, String paramString)
  {
    if (paramCollection == null)
    {
      ps(paramString);
      this.sb.append("null").append('\t');
      return this;
    }
    return display(paramCollection.toArray(), paramString);
  }
  
  public <K, V> JceDisplayer display(Map<K, V> paramMap, String paramString)
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
  
  public <T> JceDisplayer display(T[] paramArrayOfT, String paramString)
  {
    ps(paramString);
    if (paramArrayOfT == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (paramArrayOfT.length == 0)
    {
      this.sb.append(paramArrayOfT.length).append(", []").append('\n');
      return this;
    }
    this.sb.append(paramArrayOfT.length).append(", [").append('\n');
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.qq.taf.jce.JceDisplayer
 * JD-Core Version:    0.7.0.1
 */