package com.tencent.securemodule;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class m
  extends JceStruct
  implements Cloneable
{
  private static ArrayList<e> c;
  private ArrayList<e> a = null;
  private int b = 0;
  
  static
  {
    if (!m.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      return;
    }
  }
  
  public final ArrayList<e> a()
  {
    return this.a;
  }
  
  public final Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (d) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (m)paramObject;
    } while ((!JceUtil.equals(this.a, paramObject.a)) || (!JceUtil.equals(this.b, paramObject.b)));
    return true;
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
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    if (c == null)
    {
      c = new ArrayList();
      e locale = new e();
      c.add(locale);
    }
    this.a = ((ArrayList)paramJceInputStream.read(c, 1, true));
    this.b = paramJceInputStream.read(this.b, 2, true);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.m
 * JD-Core Version:    0.7.0.1
 */