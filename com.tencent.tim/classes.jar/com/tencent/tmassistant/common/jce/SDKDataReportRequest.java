package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SDKDataReportRequest
  extends JceStruct
{
  public String appData = "";
  public String qadid = "";
  public String qimei = "";
  public long timeCost = 0L;
  public long uin = 0L;
  
  public SDKDataReportRequest() {}
  
  public SDKDataReportRequest(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3)
  {
    this.appData = paramString1;
    this.timeCost = paramLong1;
    this.uin = paramLong2;
    this.qimei = paramString2;
    this.qadid = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appData = paramJceInputStream.readString(0, false);
    this.timeCost = paramJceInputStream.read(this.timeCost, 1, false);
    this.uin = paramJceInputStream.read(this.uin, 2, false);
    this.qimei = paramJceInputStream.readString(3, false);
    this.qadid = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.appData != null) {
      paramJceOutputStream.write(this.appData, 0);
    }
    paramJceOutputStream.write(this.timeCost, 1);
    paramJceOutputStream.write(this.uin, 2);
    if (this.qimei != null) {
      paramJceOutputStream.write(this.qimei, 3);
    }
    if (this.qadid != null) {
      paramJceOutputStream.write(this.qadid, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.SDKDataReportRequest
 * JD-Core Version:    0.7.0.1
 */