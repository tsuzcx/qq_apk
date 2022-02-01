package com.tencent.turingfd.sdk.qps;

import com.tencent.token.afb;
import com.tencent.token.afd;
import com.tencent.token.afj;

public final class Grape
  extends Orion
  implements Cloneable
{
  public static Gooseberry a = new Gooseberry();
  public int c = 0;
  public Gooseberry d = null;
  public long e = 0L;
  
  public final void a(afb paramafb)
  {
    this.c = paramafb.a(this.c, 0, true);
    this.d = ((Gooseberry)paramafb.a(a, 1, false));
    this.e = paramafb.a(this.e, 2, true);
  }
  
  public final void a(afd paramafd)
  {
    paramafd.a(this.c, 0);
    Gooseberry localGooseberry = this.d;
    if (localGooseberry != null) {
      paramafd.a(localGooseberry, 1);
    }
    paramafd.a(this.e, 2);
  }
  
  public final Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    if (b) {
      return null;
    }
    throw new AssertionError();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (Grape)paramObject;
    return (afj.a(this.c, paramObject.c)) && (this.d.equals(paramObject.d)) && (afj.a(this.e, paramObject.e));
  }
  
  public final int hashCode()
  {
    try
    {
      throw new Exception("");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Grape
 * JD-Core Version:    0.7.0.1
 */