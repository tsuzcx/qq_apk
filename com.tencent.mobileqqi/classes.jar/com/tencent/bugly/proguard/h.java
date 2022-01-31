package com.tencent.bugly.proguard;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class h
{
  private StringBuilder a;
  private int b = 0;
  
  public h(StringBuilder paramStringBuilder, int paramInt)
  {
    this.a = paramStringBuilder;
    this.b = paramInt;
  }
  
  private <T> h a(T paramT, String paramString)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    if (paramT == null)
    {
      this.a.append("null\n");
      return this;
    }
    if ((paramT instanceof Byte))
    {
      i = ((Byte)paramT).byteValue();
      a(paramString);
      this.a.append(i).append('\n');
      return this;
    }
    if ((paramT instanceof Boolean))
    {
      boolean bool = ((Boolean)paramT).booleanValue();
      a(paramString);
      paramT = this.a;
      if (bool) {}
      for (char c = 'T';; c = 'F')
      {
        paramT.append(c).append('\n');
        return this;
      }
    }
    if ((paramT instanceof Short))
    {
      i = ((Short)paramT).shortValue();
      a(paramString);
      this.a.append(i).append('\n');
      return this;
    }
    if ((paramT instanceof Integer))
    {
      i = ((Integer)paramT).intValue();
      a(paramString);
      this.a.append(i).append('\n');
      return this;
    }
    long l;
    if ((paramT instanceof Long))
    {
      l = ((Long)paramT).longValue();
      a(paramString);
      this.a.append(l).append('\n');
      return this;
    }
    float f;
    if ((paramT instanceof Float))
    {
      f = ((Float)paramT).floatValue();
      a(paramString);
      this.a.append(f).append('\n');
      return this;
    }
    double d;
    if ((paramT instanceof Double))
    {
      d = ((Double)paramT).doubleValue();
      a(paramString);
      this.a.append(d).append('\n');
      return this;
    }
    if ((paramT instanceof String))
    {
      a((String)paramT, paramString);
      return this;
    }
    if ((paramT instanceof Map))
    {
      a((Map)paramT, paramString);
      return this;
    }
    if ((paramT instanceof List))
    {
      paramT = (List)paramT;
      if (paramT == null)
      {
        a(paramString);
        this.a.append("null\t");
        return this;
      }
      a(paramT.toArray(), paramString);
      return this;
    }
    if ((paramT instanceof k))
    {
      a((k)paramT, paramString);
      return this;
    }
    if ((paramT instanceof byte[]))
    {
      a((byte[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof boolean[]))
    {
      a((boolean[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof short[]))
    {
      paramT = (short[])paramT;
      a(paramString);
      if (paramT == null)
      {
        this.a.append("null\n");
        return this;
      }
      if (paramT.length == 0)
      {
        this.a.append(paramT.length).append(", []\n");
        return this;
      }
      this.a.append(paramT.length).append(", [\n");
      paramString = new h(this.a, this.b + 1);
      j = paramT.length;
      while (i < j)
      {
        k = paramT[i];
        paramString.a(null);
        paramString.a.append(k).append('\n');
        i += 1;
      }
      a(null);
      this.a.append(']').append('\n');
      return this;
    }
    if ((paramT instanceof int[]))
    {
      paramT = (int[])paramT;
      a(paramString);
      if (paramT == null)
      {
        this.a.append("null\n");
        return this;
      }
      if (paramT.length == 0)
      {
        this.a.append(paramT.length).append(", []\n");
        return this;
      }
      this.a.append(paramT.length).append(", [\n");
      paramString = new h(this.a, this.b + 1);
      k = paramT.length;
      i = j;
      while (i < k)
      {
        j = paramT[i];
        paramString.a(null);
        paramString.a.append(j).append('\n');
        i += 1;
      }
      a(null);
      this.a.append(']').append('\n');
      return this;
    }
    if ((paramT instanceof long[]))
    {
      paramT = (long[])paramT;
      a(paramString);
      if (paramT == null)
      {
        this.a.append("null\n");
        return this;
      }
      if (paramT.length == 0)
      {
        this.a.append(paramT.length).append(", []\n");
        return this;
      }
      this.a.append(paramT.length).append(", [\n");
      paramString = new h(this.a, this.b + 1);
      j = paramT.length;
      i = k;
      while (i < j)
      {
        l = paramT[i];
        paramString.a(null);
        paramString.a.append(l).append('\n');
        i += 1;
      }
      a(null);
      this.a.append(']').append('\n');
      return this;
    }
    if ((paramT instanceof float[]))
    {
      paramT = (float[])paramT;
      a(paramString);
      if (paramT == null)
      {
        this.a.append("null\n");
        return this;
      }
      if (paramT.length == 0)
      {
        this.a.append(paramT.length).append(", []\n");
        return this;
      }
      this.a.append(paramT.length).append(", [\n");
      paramString = new h(this.a, this.b + 1);
      j = paramT.length;
      i = m;
      while (i < j)
      {
        f = paramT[i];
        paramString.a(null);
        paramString.a.append(f).append('\n');
        i += 1;
      }
      a(null);
      this.a.append(']').append('\n');
      return this;
    }
    if ((paramT instanceof double[]))
    {
      paramT = (double[])paramT;
      a(paramString);
      if (paramT == null)
      {
        this.a.append("null\n");
        return this;
      }
      if (paramT.length == 0)
      {
        this.a.append(paramT.length).append(", []\n");
        return this;
      }
      this.a.append(paramT.length).append(", [\n");
      paramString = new h(this.a, this.b + 1);
      j = paramT.length;
      i = n;
      while (i < j)
      {
        d = paramT[i];
        paramString.a(null);
        paramString.a.append(d).append('\n');
        i += 1;
      }
      a(null);
      this.a.append(']').append('\n');
      return this;
    }
    if (paramT.getClass().isArray())
    {
      a((Object[])paramT, paramString);
      return this;
    }
    throw new b("write object error: unsupport type.");
  }
  
  private <T> h a(T[] paramArrayOfT, String paramString)
  {
    a(paramString);
    if (paramArrayOfT == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfT.length == 0)
    {
      this.a.append(paramArrayOfT.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfT.length).append(", [\n");
    paramString = new h(this.a, this.b + 1);
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfT[i], null);
      i += 1;
    }
    a(null);
    this.a.append(']').append('\n');
    return this;
  }
  
  private void a(String paramString)
  {
    int i = 0;
    while (i < this.b)
    {
      this.a.append('\t');
      i += 1;
    }
    if (paramString != null) {
      this.a.append(paramString).append(": ");
    }
  }
  
  public final h a(byte paramByte, String paramString)
  {
    a(paramString);
    this.a.append(paramByte).append('\n');
    return this;
  }
  
  public final h a(int paramInt, String paramString)
  {
    a(paramString);
    this.a.append(paramInt).append('\n');
    return this;
  }
  
  public final h a(long paramLong, String paramString)
  {
    a(paramString);
    this.a.append(paramLong).append('\n');
    return this;
  }
  
  public final h a(k paramk, String paramString)
  {
    a(paramString);
    this.a.append('{').append('\n');
    if (paramk == null) {
      this.a.append('\t').append("null");
    }
    for (;;)
    {
      a(null);
      this.a.append('}').append('\n');
      return this;
      paramk.a(this.a, this.b + 1);
    }
  }
  
  public final h a(String paramString1, String paramString2)
  {
    a(paramString2);
    if (paramString1 == null)
    {
      this.a.append("null\n");
      return this;
    }
    this.a.append(paramString1).append('\n');
    return this;
  }
  
  public final <K, V> h a(Map<K, V> paramMap, String paramString)
  {
    a(paramString);
    if (paramMap == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramMap.isEmpty())
    {
      this.a.append(paramMap.size()).append(", {}\n");
      return this;
    }
    this.a.append(paramMap.size()).append(", {\n");
    paramString = new h(this.a, this.b + 1);
    h localh = new h(this.a, this.b + 2);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramString.a(null);
      paramString.a.append('(').append('\n');
      localh.a(localEntry.getKey(), null);
      localh.a(localEntry.getValue(), null);
      paramString.a(null);
      paramString.a.append(')').append('\n');
    }
    a(null);
    this.a.append('}').append('\n');
    return this;
  }
  
  public final h a(short paramShort, String paramString)
  {
    a(paramString);
    this.a.append(paramShort).append('\n');
    return this;
  }
  
  public final h a(boolean paramBoolean, String paramString)
  {
    a(paramString);
    paramString = this.a;
    if (paramBoolean) {}
    for (char c = 'T';; c = 'F')
    {
      paramString.append(c).append('\n');
      return this;
    }
  }
  
  public final h a(byte[] paramArrayOfByte, String paramString)
  {
    a(paramString);
    if (paramArrayOfByte == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfByte.length == 0)
    {
      this.a.append(paramArrayOfByte.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfByte.length).append(", [\n");
    paramString = new h(this.a, this.b + 1);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      paramString.a(null);
      paramString.a.append(k).append('\n');
      i += 1;
    }
    a(null);
    this.a.append(']').append('\n');
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.h
 * JD-Core Version:    0.7.0.1
 */