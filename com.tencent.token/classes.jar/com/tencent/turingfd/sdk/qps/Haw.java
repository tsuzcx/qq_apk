package com.tencent.turingfd.sdk.qps;

import com.tencent.token.afb;
import com.tencent.token.afd;
import com.tencent.token.afj;

public final class Haw
  extends Orion
  implements Cloneable
{
  public int b = 0;
  public String c = "";
  
  public final void a(afb paramafb)
  {
    this.b = paramafb.a(this.b, 0, true);
    this.c = paramafb.a(1, true);
  }
  
  public final void a(afd paramafd)
  {
    paramafd.a(this.b, 0);
    paramafd.a(this.c, 1);
  }
  
  public final void a(StringBuilder paramStringBuilder)
  {
    int i = this.b;
    paramStringBuilder.append("r");
    paramStringBuilder.append(": ");
    paramStringBuilder.append(i);
    paramStringBuilder.append('\n');
    String str = this.c;
    paramStringBuilder.append("d");
    paramStringBuilder.append(": ");
    if (str == null)
    {
      paramStringBuilder.append("null\n");
      return;
    }
    paramStringBuilder.append(str);
    paramStringBuilder.append('\n');
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
    if (a) {
      return null;
    }
    throw new AssertionError();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (Haw)paramObject;
    return (afj.a(this.b, paramObject.b)) && (this.c.equals(paramObject.c));
  }
  
  public final int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Haw
 * JD-Core Version:    0.7.0.1
 */