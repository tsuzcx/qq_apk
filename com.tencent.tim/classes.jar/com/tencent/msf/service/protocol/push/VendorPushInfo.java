package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class VendorPushInfo
  extends JceStruct
{
  public long uVendorType = 0L;
  
  public VendorPushInfo() {}
  
  public VendorPushInfo(long paramLong)
  {
    this.uVendorType = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uVendorType = paramJceInputStream.read(this.uVendorType, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uVendorType, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.VendorPushInfo
 * JD-Core Version:    0.7.0.1
 */