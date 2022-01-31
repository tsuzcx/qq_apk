package com.tencent.securemodule;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class n
  extends JceStruct
  implements Cloneable
{
  private static l j;
  private static j k;
  private String a = "";
  private int b = 0;
  private l c = null;
  private int d = 0;
  private int e = 0;
  private String f = "";
  private String g = "";
  private j h = null;
  private String i = "";
  
  static
  {
    if (!n.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      l = bool;
      return;
    }
  }
  
  public final String a()
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
      while (l) {}
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
      paramObject = (n)paramObject;
    } while ((!JceUtil.equals(this.a, paramObject.a)) || (!JceUtil.equals(this.b, paramObject.b)) || (!JceUtil.equals(this.c, paramObject.c)) || (!JceUtil.equals(this.d, paramObject.d)) || (!JceUtil.equals(this.e, paramObject.e)) || (!JceUtil.equals(this.f, paramObject.f)) || (!JceUtil.equals(this.g, paramObject.g)) || (!JceUtil.equals(this.h, paramObject.h)) || (!JceUtil.equals(this.i, paramObject.i)));
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
    this.a = paramJceInputStream.readString(0, true);
    this.b = paramJceInputStream.read(this.b, 1, false);
    if (j == null) {
      j = new l();
    }
    this.c = ((l)paramJceInputStream.read(j, 2, false));
    this.d = paramJceInputStream.read(this.d, 3, false);
    this.e = paramJceInputStream.read(this.e, 4, false);
    this.f = paramJceInputStream.readString(5, false);
    this.g = paramJceInputStream.readString(6, false);
    if (k == null) {
      k = new j();
    }
    this.h = ((j)paramJceInputStream.read(k, 7, false));
    this.i = paramJceInputStream.readString(8, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 2);
    }
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
    if (this.f != null) {
      paramJceOutputStream.write(this.f, 5);
    }
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 6);
    }
    if (this.h != null) {
      paramJceOutputStream.write(this.h, 7);
    }
    if (this.i != null) {
      paramJceOutputStream.write(this.i, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.n
 * JD-Core Version:    0.7.0.1
 */