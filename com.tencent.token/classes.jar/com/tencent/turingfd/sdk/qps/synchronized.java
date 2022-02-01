package com.tencent.turingfd.sdk.qps;

import java.math.BigDecimal;

public final class synchronized
  extends Number
{
  public final String a;
  
  public synchronized(String paramString)
  {
    this.a = paramString;
  }
  
  public final double doubleValue()
  {
    return Double.parseDouble(this.a);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof synchronized))
    {
      Object localObject = (synchronized)paramObject;
      paramObject = this.a;
      localObject = ((synchronized)localObject).a;
      return (paramObject == localObject) || (paramObject.equals(localObject));
    }
    return false;
  }
  
  public final float floatValue()
  {
    return Float.parseFloat(this.a);
  }
  
  public final int hashCode()
  {
    return this.a.hashCode();
  }
  
  public final int intValue()
  {
    try
    {
      int i = Integer.parseInt(this.a);
      return i;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      label10:
      long l;
      label21:
      break label10;
    }
    try
    {
      l = Long.parseLong(this.a);
      return (int)l;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label21;
    }
    return new BigDecimal(this.a).intValue();
  }
  
  public final long longValue()
  {
    try
    {
      long l = Long.parseLong(this.a);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label10:
      break label10;
    }
    return new BigDecimal(this.a).longValue();
  }
  
  public final String toString()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.synchronized
 * JD-Core Version:    0.7.0.1
 */