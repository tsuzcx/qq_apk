package com.tencent.securemodule;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class b
  extends JceStruct
  implements Cloneable
{
  private int a = 0;
  private int b = 0;
  private String c = "";
  private String d = "";
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      e = bool;
      return;
    }
  }
  
  public b()
  {
    this.a = this.a;
    this.b = this.b;
    this.c = this.c;
    this.d = this.d;
  }
  
  public b(int paramInt, String paramString1, String paramString2)
  {
    this.a = paramInt;
    this.b = 21;
    this.c = paramString1;
    this.d = paramString2;
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
      while (e) {}
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
      paramObject = (b)paramObject;
    } while ((!JceUtil.equals(this.a, paramObject.a)) || (!JceUtil.equals(this.b, paramObject.b)) || (!JceUtil.equals(this.c, paramObject.c)) || (!JceUtil.equals(this.d, paramObject.d)));
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
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.readString(2, false);
    this.d = paramJceInputStream.readString(3, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 2);
    }
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.b
 * JD-Core Version:    0.7.0.1
 */