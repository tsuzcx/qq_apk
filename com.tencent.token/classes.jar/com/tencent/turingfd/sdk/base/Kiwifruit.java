package com.tencent.turingfd.sdk.base;

public final class Kiwifruit
  extends break
  implements Cloneable
{
  public static Hickory kd = new Hickory();
  public long Jb = 0L;
  public int ld = 0;
  public Hickory md = null;
  
  public void a(cy paramcy)
  {
    this.ld = paramcy.a(this.ld, 0, true);
    this.md = ((Hickory)paramcy.a(kd, 1, false));
    this.Jb = paramcy.a(this.Jb, 2, true);
  }
  
  public void a(db paramdb)
  {
    paramdb.a(this.ld, 0);
    Hickory localHickory = this.md;
    if (localHickory != null) {
      paramdb.a(localHickory, 1);
    }
    paramdb.a(this.Jb, 2);
  }
  
  public Object clone()
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
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (Kiwifruit)paramObject;
    boolean bool1 = bool2;
    if (ce.a(this.ld, paramObject.ld))
    {
      bool1 = bool2;
      if (ce.a(this.md, paramObject.md))
      {
        bool1 = bool2;
        if (ce.a(this.Jb, paramObject.Jb)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
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