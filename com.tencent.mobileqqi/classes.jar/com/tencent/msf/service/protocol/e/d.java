package com.tencent.msf.service.protocol.e;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class d
  extends JceStruct
{
  public int a = 0;
  
  static
  {
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      return;
    }
  }
  
  public d() {}
  
  public d(int paramInt)
  {
    this.a = paramInt;
  }
  
  public String a()
  {
    return "KQQConfig.GrayUinCheckResp";
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
      while (b) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    new JceDisplayer(paramStringBuilder, paramInt).display(this.a, "status");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (d)paramObject;
    return JceUtil.equals(this.a, paramObject.a);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.e.d
 * JD-Core Version:    0.7.0.1
 */