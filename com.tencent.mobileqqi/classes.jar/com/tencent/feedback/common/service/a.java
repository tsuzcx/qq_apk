package com.tencent.feedback.common.service;

import android.content.Intent;
import com.tencent.feedback.common.e;
import com.tencent.feedback.proguard.b;
import com.tencent.feedback.proguard.j;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
{
  private StringBuilder a;
  private int b = 0;
  
  public a(StringBuilder paramStringBuilder, int paramInt)
  {
    this.a = paramStringBuilder;
    this.b = paramInt;
  }
  
  protected static RQDServiceTask a(Intent paramIntent)
  {
    boolean bool = false;
    if (paramIntent == null) {
      paramIntent = null;
    }
    do
    {
      return paramIntent;
      paramIntent = paramIntent.getParcelableExtra("com.tencent.feedback.104");
      if ((paramIntent == null) && (!RQDServiceTask.class.isInstance(paramIntent))) {
        return null;
      }
      paramIntent = (RQDServiceTask)RQDServiceTask.class.cast(paramIntent);
      if (paramIntent != null) {
        break;
      }
    } while (bool);
    return null;
    switch (paramIntent.getTaskId())
    {
    }
    for (bool = false;; bool = "2000".equals(paramIntent.getTaskName()))
    {
      if (!bool) {
        e.d("verify task fail %s %d", new Object[] { paramIntent.getTaskName(), Integer.valueOf(paramIntent.getTaskId()) });
      }
      break;
    }
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
  
  public a a(byte paramByte, String paramString)
  {
    a(paramString);
    this.a.append(paramByte).append('\n');
    return this;
  }
  
  public a a(char paramChar, String paramString)
  {
    a(paramString);
    this.a.append(paramChar).append('\n');
    return this;
  }
  
  public a a(double paramDouble, String paramString)
  {
    a(paramString);
    this.a.append(paramDouble).append('\n');
    return this;
  }
  
  public a a(float paramFloat, String paramString)
  {
    a(paramString);
    this.a.append(paramFloat).append('\n');
    return this;
  }
  
  public a a(int paramInt, String paramString)
  {
    a(paramString);
    this.a.append(paramInt).append('\n');
    return this;
  }
  
  public a a(long paramLong, String paramString)
  {
    a(paramString);
    this.a.append(paramLong).append('\n');
    return this;
  }
  
  public a a(j paramj, String paramString)
  {
    a('{', paramString);
    if (paramj == null) {
      this.a.append('\t').append("null");
    }
    for (;;)
    {
      a('}', null);
      return this;
      paramj.a(this.a, this.b + 1);
    }
  }
  
  public <T> a a(T paramT, String paramString)
  {
    if (paramT == null)
    {
      this.a.append("null\n");
      return this;
    }
    if ((paramT instanceof Byte))
    {
      a(((Byte)paramT).byteValue(), paramString);
      return this;
    }
    if ((paramT instanceof Boolean))
    {
      a(((Boolean)paramT).booleanValue(), paramString);
      return this;
    }
    if ((paramT instanceof Short))
    {
      a(((Short)paramT).shortValue(), paramString);
      return this;
    }
    if ((paramT instanceof Integer))
    {
      a(((Integer)paramT).intValue(), paramString);
      return this;
    }
    if ((paramT instanceof Long))
    {
      a(((Long)paramT).longValue(), paramString);
      return this;
    }
    if ((paramT instanceof Float))
    {
      a(((Float)paramT).floatValue(), paramString);
      return this;
    }
    if ((paramT instanceof Double))
    {
      a(((Double)paramT).doubleValue(), paramString);
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
      a((List)paramT, paramString);
      return this;
    }
    if ((paramT instanceof j))
    {
      a((j)paramT, paramString);
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
      a((short[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof int[]))
    {
      a((int[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof long[]))
    {
      a((long[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof float[]))
    {
      a((float[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof double[]))
    {
      a((double[])paramT, paramString);
      return this;
    }
    if (paramT.getClass().isArray())
    {
      a((Object[])paramT, paramString);
      return this;
    }
    throw new b("write object error: unsupport type.");
  }
  
  public a a(String paramString1, String paramString2)
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
  
  public <T> a a(Collection<T> paramCollection, String paramString)
  {
    if (paramCollection == null)
    {
      a(paramString);
      this.a.append("null\t");
      return this;
    }
    return a(paramCollection.toArray(), paramString);
  }
  
  public <K, V> a a(Map<K, V> paramMap, String paramString)
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
    paramString = new a(this.a, this.b + 1);
    a locala = new a(this.a, this.b + 2);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramString.a('(', null);
      locala.a(localEntry.getKey(), null);
      locala.a(localEntry.getValue(), null);
      paramString.a(')', null);
    }
    a('}', null);
    return this;
  }
  
  public a a(short paramShort, String paramString)
  {
    a(paramString);
    this.a.append(paramShort).append('\n');
    return this;
  }
  
  public a a(boolean paramBoolean, String paramString)
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
  
  public a a(byte[] paramArrayOfByte, String paramString)
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
    paramString = new a(this.a, this.b + 1);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfByte[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public a a(double[] paramArrayOfDouble, String paramString)
  {
    a(paramString);
    if (paramArrayOfDouble == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfDouble.length == 0)
    {
      this.a.append(paramArrayOfDouble.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfDouble.length).append(", [\n");
    paramString = new a(this.a, this.b + 1);
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfDouble[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public a a(float[] paramArrayOfFloat, String paramString)
  {
    a(paramString);
    if (paramArrayOfFloat == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfFloat.length == 0)
    {
      this.a.append(paramArrayOfFloat.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfFloat.length).append(", [\n");
    paramString = new a(this.a, this.b + 1);
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfFloat[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public a a(int[] paramArrayOfInt, String paramString)
  {
    a(paramString);
    if (paramArrayOfInt == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfInt.length == 0)
    {
      this.a.append(paramArrayOfInt.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfInt.length).append(", [\n");
    paramString = new a(this.a, this.b + 1);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfInt[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public a a(long[] paramArrayOfLong, String paramString)
  {
    a(paramString);
    if (paramArrayOfLong == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfLong.length == 0)
    {
      this.a.append(paramArrayOfLong.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfLong.length).append(", [\n");
    paramString = new a(this.a, this.b + 1);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfLong[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public <T> a a(T[] paramArrayOfT, String paramString)
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
    paramString = new a(this.a, this.b + 1);
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfT[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public a a(short[] paramArrayOfShort, String paramString)
  {
    a(paramString);
    if (paramArrayOfShort == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfShort.length == 0)
    {
      this.a.append(paramArrayOfShort.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfShort.length).append(", [\n");
    paramString = new a(this.a, this.b + 1);
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfShort[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.common.service.a
 * JD-Core Version:    0.7.0.1
 */