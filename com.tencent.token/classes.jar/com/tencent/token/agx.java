package com.tencent.token;

import com.tencent.turingfd.sdk.qps.synchronized;
import java.math.BigInteger;

public final class agx
  extends ahu
{
  public final Object a;
  
  public agx(Boolean paramBoolean)
  {
    this.a = ahr.a(paramBoolean);
  }
  
  public agx(Number paramNumber)
  {
    this.a = ahr.a(paramNumber);
  }
  
  public agx(String paramString)
  {
    this.a = ahr.a(paramString);
  }
  
  private static boolean a(agx paramagx)
  {
    paramagx = paramagx.a;
    if ((paramagx instanceof Number))
    {
      paramagx = (Number)paramagx;
      return ((paramagx instanceof BigInteger)) || ((paramagx instanceof Long)) || ((paramagx instanceof Integer)) || ((paramagx instanceof Short)) || ((paramagx instanceof Byte));
    }
    return false;
  }
  
  public final Number a()
  {
    Object localObject = this.a;
    if ((localObject instanceof String)) {
      return new synchronized((String)localObject);
    }
    return (Number)localObject;
  }
  
  public final String b()
  {
    Object localObject = this.a;
    if ((localObject instanceof Number)) {
      return a().toString();
    }
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).toString();
    }
    return (String)localObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (agx.class == paramObject.getClass()))
    {
      paramObject = (agx)paramObject;
      if (this.a == null) {
        return paramObject.a == null;
      }
      if ((a(this)) && (a(paramObject))) {
        return a().longValue() == paramObject.a().longValue();
      }
      Object localObject = this.a;
      if (((localObject instanceof Number)) && ((paramObject.a instanceof Number)))
      {
        double d1 = a().doubleValue();
        double d2 = paramObject.a().doubleValue();
        return (d1 == d2) || ((Double.isNaN(d1)) && (Double.isNaN(d2)));
      }
      return localObject.equals(paramObject.a);
    }
    return false;
  }
  
  public final int hashCode()
  {
    if (this.a == null) {
      return 31;
    }
    long l;
    if (a(this))
    {
      l = a().longValue();
      return (int)(l >>> 32 ^ l);
    }
    Object localObject = this.a;
    if ((localObject instanceof Number))
    {
      l = Double.doubleToLongBits(a().doubleValue());
      return (int)(l >>> 32 ^ l);
    }
    return localObject.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.agx
 * JD-Core Version:    0.7.0.1
 */