package com.tencent.token;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class aoq
  extends JceStruct
  implements Cloneable
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  
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
    if (i) {
      return null;
    }
    throw new AssertionError();
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.a, "data1");
    paramStringBuilder.display(this.b, "data2");
    paramStringBuilder.display(this.c, "data3");
    paramStringBuilder.display(this.d, "data4");
    paramStringBuilder.display(this.e, "data5");
    paramStringBuilder.display(this.f, "data6");
    paramStringBuilder.display(this.g, "data7");
    paramStringBuilder.display(this.h, "data8");
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (aoq)paramObject;
    return (JceUtil.equals(this.a, paramObject.a)) && (JceUtil.equals(this.b, paramObject.b)) && (JceUtil.equals(this.c, paramObject.c)) && (JceUtil.equals(this.d, paramObject.d)) && (JceUtil.equals(this.e, paramObject.e)) && (JceUtil.equals(this.f, paramObject.f)) && (JceUtil.equals(this.g, paramObject.g)) && (JceUtil.equals(this.h, paramObject.h));
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
    this.a = paramJceInputStream.readString(0, false);
    this.b = paramJceInputStream.readString(1, false);
    this.c = paramJceInputStream.readString(3, false);
    this.d = paramJceInputStream.readString(4, false);
    this.e = paramJceInputStream.readString(5, false);
    this.f = paramJceInputStream.readString(6, false);
    this.g = paramJceInputStream.readString(7, false);
    this.h = paramJceInputStream.readString(8, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.a;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.b;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.c;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.d;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.e;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.f;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.g;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    str = this.h;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aoq
 * JD-Core Version:    0.7.0.1
 */