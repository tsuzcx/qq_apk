package com.tencent.securemodule;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class g
  extends JceStruct
  implements Cloneable
{
  private String a = "";
  private String b = "";
  private int c = 0;
  private String d = "";
  private int e = 0;
  private String f = "";
  private boolean g = false;
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      h = bool;
      return;
    }
  }
  
  public g()
  {
    this.a = this.a;
    this.b = this.b;
    this.c = this.c;
    this.d = this.d;
    this.e = this.e;
    this.f = this.f;
    this.g = this.g;
  }
  
  public g(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt1;
    this.d = paramString3;
    this.e = paramInt2;
    this.f = paramString4;
    this.g = paramBoolean;
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
      while (h) {}
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
      paramObject = (g)paramObject;
    } while ((!JceUtil.equals(this.a, paramObject.a)) || (!JceUtil.equals(this.b, paramObject.b)) || (!JceUtil.equals(this.c, paramObject.c)) || (!JceUtil.equals(this.d, paramObject.d)) || (!JceUtil.equals(this.e, paramObject.e)) || (!JceUtil.equals(this.f, paramObject.f)) || (!JceUtil.equals(this.g, paramObject.g)));
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
    this.b = paramJceInputStream.readString(1, true);
    this.c = paramJceInputStream.read(this.c, 2, true);
    this.d = paramJceInputStream.readString(3, true);
    this.e = paramJceInputStream.read(this.e, 4, false);
    this.f = paramJceInputStream.readString(5, false);
    this.g = paramJceInputStream.read(this.g, 6, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
    if (this.f != null) {
      paramJceOutputStream.write(this.f, 5);
    }
    paramJceOutputStream.write(this.g, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.g
 * JD-Core Version:    0.7.0.1
 */