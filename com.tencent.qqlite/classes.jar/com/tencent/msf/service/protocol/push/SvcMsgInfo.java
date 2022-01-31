package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcMsgInfo
  extends JceStruct
{
  public int iMsgType = 0;
  public long lFromUin = 0L;
  public String strOther = "";
  public int tTimeStamp = 0;
  
  public SvcMsgInfo() {}
  
  public SvcMsgInfo(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    this.lFromUin = paramLong;
    this.tTimeStamp = paramInt1;
    this.iMsgType = paramInt2;
    this.strOther = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromUin = paramJceInputStream.read(this.lFromUin, 0, true);
    this.tTimeStamp = paramJceInputStream.read(this.tTimeStamp, 1, true);
    this.iMsgType = paramJceInputStream.read(this.iMsgType, 2, true);
    this.strOther = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromUin, 0);
    paramJceOutputStream.write(this.tTimeStamp, 1);
    paramJceOutputStream.write(this.iMsgType, 2);
    paramJceOutputStream.write(this.strOther, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.SvcMsgInfo
 * JD-Core Version:    0.7.0.1
 */