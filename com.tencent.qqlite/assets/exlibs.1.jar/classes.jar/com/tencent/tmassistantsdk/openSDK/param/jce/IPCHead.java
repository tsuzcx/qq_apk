package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class IPCHead
  extends JceStruct
{
  public int cmdId = 0;
  public String hostPackageName = "";
  public String hostVersionCode = "";
  public int requestId = 0;
  
  public IPCHead() {}
  
  public IPCHead(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.requestId = paramInt1;
    this.cmdId = paramInt2;
    this.hostPackageName = paramString1;
    this.hostVersionCode = paramString2;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.requestId = paramJceInputStream.read(this.requestId, 0, true);
    this.cmdId = paramJceInputStream.read(this.cmdId, 1, true);
    this.hostPackageName = paramJceInputStream.readString(2, true);
    this.hostVersionCode = paramJceInputStream.readString(3, true);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.requestId, 0);
    paramJceOutputStream.write(this.cmdId, 1);
    paramJceOutputStream.write(this.hostPackageName, 2);
    paramJceOutputStream.write(this.hostVersionCode, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.param.jce.IPCHead
 * JD-Core Version:    0.7.0.1
 */