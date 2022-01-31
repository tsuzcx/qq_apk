package com.tencent.msf.service.protocol.e;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class c
  extends JceStruct
{
  public int a = 0;
  public String b = "";
  
  static
  {
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      return;
    }
  }
  
  public c() {}
  
  public c(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (c) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.a, "appid");
    paramStringBuilder.display(this.b, "uin");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (c)paramObject;
    return (JceUtil.equals(this.a, paramObject.a)) && (JceUtil.equals(this.b, paramObject.b));
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 1, true);
    this.b = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.e.c
 * JD-Core Version:    0.7.0.1
 */