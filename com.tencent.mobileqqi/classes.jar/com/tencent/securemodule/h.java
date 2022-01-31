package com.tencent.securemodule;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class h
  extends JceStruct
  implements Cloneable
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private int f = 0;
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = "";
  
  static
  {
    if (!h.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      k = bool;
      return;
    }
  }
  
  public final void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void a(String paramString)
  {
    this.a = paramString;
  }
  
  public final void b(String paramString)
  {
    this.b = paramString;
  }
  
  public final void c(String paramString)
  {
    this.c = paramString;
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
      while (k) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final void d(String paramString)
  {
    this.d = paramString;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void e(String paramString)
  {
    this.e = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (h)paramObject;
    } while ((!JceUtil.equals(this.a, paramObject.a)) || (!JceUtil.equals(this.b, paramObject.b)) || (!JceUtil.equals(this.c, paramObject.c)) || (!JceUtil.equals(this.d, paramObject.d)) || (!JceUtil.equals(this.e, paramObject.e)) || (!JceUtil.equals(this.f, paramObject.f)) || (!JceUtil.equals(this.g, paramObject.g)) || (!JceUtil.equals(this.h, paramObject.h)) || (!JceUtil.equals(this.i, paramObject.i)) || (!JceUtil.equals(this.j, paramObject.j)));
    return true;
  }
  
  public final void f(String paramString)
  {
    this.g = paramString;
  }
  
  public final void g(String paramString)
  {
    this.h = paramString;
  }
  
  public final void h(String paramString)
  {
    this.j = paramString;
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
    this.b = paramJceInputStream.readString(1, false);
    this.c = paramJceInputStream.readString(2, false);
    this.d = paramJceInputStream.readString(3, false);
    this.e = paramJceInputStream.readString(4, false);
    this.f = paramJceInputStream.read(this.f, 5, false);
    this.g = paramJceInputStream.readString(6, false);
    this.h = paramJceInputStream.readString(7, false);
    this.i = paramJceInputStream.readString(8, false);
    this.j = paramJceInputStream.readString(9, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    if (this.b != null) {
      paramJceOutputStream.write(this.b, 1);
    }
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 2);
    }
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 3);
    }
    if (this.e != null) {
      paramJceOutputStream.write(this.e, 4);
    }
    paramJceOutputStream.write(this.f, 5);
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 6);
    }
    if (this.h != null) {
      paramJceOutputStream.write(this.h, 7);
    }
    if (this.i != null) {
      paramJceOutputStream.write(this.i, 8);
    }
    if (this.j != null) {
      paramJceOutputStream.write(this.j, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.h
 * JD-Core Version:    0.7.0.1
 */