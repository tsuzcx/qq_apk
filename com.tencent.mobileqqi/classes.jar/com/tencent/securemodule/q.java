package com.tencent.securemodule;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class q
  extends JceStruct
  implements Cloneable
{
  private static l s;
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private int h = 0;
  private int i = 0;
  private l j = null;
  private String k = "";
  private String l = "";
  private int m = 0;
  private int n = 0;
  private int o = 0;
  private int p = 0;
  private String q = "";
  private short r = 0;
  
  static
  {
    if (!q.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      t = bool;
      return;
    }
  }
  
  public final void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final void a(l paraml)
  {
    this.j = paraml;
  }
  
  public final void a(String paramString)
  {
    this.a = paramString;
  }
  
  public final void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public final void b(String paramString)
  {
    this.b = paramString;
  }
  
  public final void c(int paramInt)
  {
    this.m = paramInt;
  }
  
  public final void c(String paramString)
  {
    this.e = paramString;
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
      while (t) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final void d(int paramInt)
  {
    this.n = paramInt;
  }
  
  public final void d(String paramString)
  {
    this.f = paramString;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void e(int paramInt)
  {
    this.o = paramInt;
  }
  
  public final void e(String paramString)
  {
    this.g = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (q)paramObject;
    } while ((!JceUtil.equals(this.a, paramObject.a)) || (!JceUtil.equals(this.b, paramObject.b)) || (!JceUtil.equals(this.c, paramObject.c)) || (!JceUtil.equals(this.d, paramObject.d)) || (!JceUtil.equals(this.e, paramObject.e)) || (!JceUtil.equals(this.f, paramObject.f)) || (!JceUtil.equals(this.g, paramObject.g)) || (!JceUtil.equals(this.h, paramObject.h)) || (!JceUtil.equals(this.i, paramObject.i)) || (!JceUtil.equals(this.j, paramObject.j)) || (!JceUtil.equals(this.k, paramObject.k)) || (!JceUtil.equals(this.l, paramObject.l)) || (!JceUtil.equals(this.m, paramObject.m)) || (!JceUtil.equals(this.n, paramObject.n)) || (!JceUtil.equals(this.o, paramObject.o)) || (!JceUtil.equals(this.p, paramObject.p)) || (!JceUtil.equals(this.q, paramObject.q)) || (!JceUtil.equals(this.r, paramObject.r)));
    return true;
  }
  
  public final void f(int paramInt)
  {
    this.p = paramInt;
  }
  
  public final void f(String paramString)
  {
    this.k = paramString;
  }
  
  public final void g(String paramString)
  {
    this.l = paramString;
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
    this.f = paramJceInputStream.readString(5, false);
    this.g = paramJceInputStream.readString(6, false);
    this.h = paramJceInputStream.read(this.h, 7, false);
    this.i = paramJceInputStream.read(this.i, 8, false);
    if (s == null) {
      s = new l();
    }
    this.j = ((l)paramJceInputStream.read(s, 9, false));
    this.k = paramJceInputStream.readString(10, false);
    this.l = paramJceInputStream.readString(11, false);
    this.m = paramJceInputStream.read(this.m, 12, false);
    this.n = paramJceInputStream.read(this.n, 13, false);
    this.o = paramJceInputStream.read(this.o, 14, false);
    this.p = paramJceInputStream.read(this.p, 15, false);
    this.q = paramJceInputStream.readString(16, false);
    this.r = paramJceInputStream.read(this.r, 17, false);
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
    if (this.f != null) {
      paramJceOutputStream.write(this.f, 5);
    }
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 6);
    }
    paramJceOutputStream.write(this.h, 7);
    paramJceOutputStream.write(this.i, 8);
    if (this.j != null) {
      paramJceOutputStream.write(this.j, 9);
    }
    if (this.k != null) {
      paramJceOutputStream.write(this.k, 10);
    }
    if (this.l != null) {
      paramJceOutputStream.write(this.l, 11);
    }
    paramJceOutputStream.write(this.m, 12);
    paramJceOutputStream.write(this.n, 13);
    paramJceOutputStream.write(this.o, 14);
    paramJceOutputStream.write(this.p, 15);
    if (this.q != null) {
      paramJceOutputStream.write(this.q, 16);
    }
    paramJceOutputStream.write(this.r, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.q
 * JD-Core Version:    0.7.0.1
 */