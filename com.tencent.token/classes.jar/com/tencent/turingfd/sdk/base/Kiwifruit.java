package com.tencent.turingfd.sdk.base;

import com.tencent.token.aer;
import com.tencent.token.afl;
import com.tencent.token.afo;

public final class Kiwifruit
  extends break
  implements Cloneable
{
  public static Hickory kd = new Hickory();
  public long Jb = 0L;
  public int ld = 0;
  public Hickory md = null;
  
  public final void a(afl paramafl)
  {
    this.ld = paramafl.a(this.ld, 0, true);
    this.md = ((Hickory)paramafl.a(kd, 1, false));
    this.Jb = paramafl.a(this.Jb, 2, true);
  }
  
  public final void a(afo paramafo)
  {
    paramafo.a(this.ld, 0);
    Hickory localHickory = this.md;
    if (localHickory != null) {
      paramafo.a(localHickory, 1);
    }
    paramafo.a(this.Jb, 2);
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
    return (aer.a(this.ld, paramObject.ld)) && (aer.a(this.md, paramObject.md)) && (aer.a(this.Jb, paramObject.Jb));
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