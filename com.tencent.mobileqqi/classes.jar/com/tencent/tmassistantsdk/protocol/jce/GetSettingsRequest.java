package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class GetSettingsRequest
  extends JceStruct
  implements Cloneable
{
  public String reserve = "";
  
  static
  {
    if (!GetSettingsRequest.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public GetSettingsRequest() {}
  
  public GetSettingsRequest(String paramString)
  {
    this.reserve = paramString;
  }
  
  public final String className()
  {
    return "jce.GetSettingsRequest";
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
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    new JceDisplayer(paramStringBuilder, paramInt).display(this.reserve, "reserve");
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    new JceDisplayer(paramStringBuilder, paramInt).displaySimple(this.reserve, false);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (GetSettingsRequest)paramObject;
    return JceUtil.equals(this.reserve, paramObject.reserve);
  }
  
  public final String fullClassName()
  {
    return "com.tencent.tmassistantsdk.protocol.jce.GetSettingsRequest";
  }
  
  public final String getReserve()
  {
    return this.reserve;
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
    this.reserve = paramJceInputStream.readString(0, false);
  }
  
  public final void setReserve(String paramString)
  {
    this.reserve = paramString;
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.reserve != null) {
      paramJceOutputStream.write(this.reserve, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.GetSettingsRequest
 * JD-Core Version:    0.7.0.1
 */