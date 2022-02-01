package com.tencent.turingfd.sdk.base;

import com.tencent.token.aeq;
import com.tencent.token.afk;
import com.tencent.token.afn;

public final class Kiwifruit
  extends break
  implements Cloneable
{
  public static Hickory kd = new Hickory();
  public long Jb = 0L;
  public int ld = 0;
  public Hickory md = null;
  
  public final void a(afk paramafk)
  {
    this.ld = paramafk.a(this.ld, 0, true);
    this.md = ((Hickory)paramafk.a(kd, 1, false));
    this.Jb = paramafk.a(this.Jb, 2, true);
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.ld, 0);
    Hickory localHickory = this.md;
    if (localHickory != null) {
      paramafn.a(localHickory, 1);
    }
    paramafn.a(this.Jb, 2);
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
    if (cd) {
      return null;
    }
    throw new AssertionError();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (Kiwifruit)paramObject;
    return (aeq.a(this.ld, paramObject.ld)) && (aeq.a(this.md, paramObject.md)) && (aeq.a(this.Jb, paramObject.Jb));
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
 * Qualified Name:     com.tencent.turingfd.sdk.base.Kiwifruit
 * JD-Core Version:    0.7.0.1
 */