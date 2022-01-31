package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class URIActionRequest
  extends JceStruct
{
  public String uri = "";
  
  public URIActionRequest() {}
  
  public URIActionRequest(String paramString)
  {
    this.uri = paramString;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.uri = paramJceInputStream.readString(0, true);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uri, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.param.jce.URIActionRequest
 * JD-Core Version:    0.7.0.1
 */