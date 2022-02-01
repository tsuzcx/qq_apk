package com.tencent.turingfd.sdk.qps;

import com.tencent.token.agd;
import com.tencent.token.age;
import com.tencent.token.agu;

public final class Gooseberry
  extends final
  implements Cloneable
{
  public static Ginkgo a = new Ginkgo();
  public int c = 0;
  public Ginkgo d = null;
  public long e = 0L;
  
  public final void a(agd paramagd)
  {
    this.c = paramagd.a(this.c, 0, true);
    this.d = ((Ginkgo)paramagd.a(a, 1, false));
    this.e = paramagd.a(this.e, 2, true);
  }
  
  public final void a(age paramage)
  {
    paramage.a(this.c, 0);
    Ginkgo localGinkgo = this.d;
    if (localGinkgo != null) {
      paramage.a(localGinkgo, 1);
    }
    paramage.a(this.e, 2);
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
    paramObject = (Gooseberry)paramObject;
    int i = this.c;
    int j = paramObject.c;
    int k = agu.a;
    if (i == j) {
      i = 1;
    } else {
      i = 0;
    }
    return (i != 0) && (this.d.equals(paramObject.d)) && (agu.a(this.e, paramObject.e));
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
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Gooseberry
 * JD-Core Version:    0.7.0.1
 */