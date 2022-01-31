package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UpdateInfoLog
  extends JceStruct
{
  public int actionCode = 0;
  public long appid = 0L;
  public String extra = "";
  public String packageName = "";
  public byte updateType = 0;
  public byte yybExistFlag = 0;
  
  public UpdateInfoLog() {}
  
  public UpdateInfoLog(byte paramByte1, String paramString1, long paramLong, int paramInt, byte paramByte2, String paramString2)
  {
    this.updateType = paramByte1;
    this.packageName = paramString1;
    this.appid = paramLong;
    this.actionCode = paramInt;
    this.yybExistFlag = paramByte2;
    this.extra = paramString2;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.updateType = paramJceInputStream.read(this.updateType, 0, true);
    this.packageName = paramJceInputStream.readString(1, true);
    this.appid = paramJceInputStream.read(this.appid, 2, false);
    this.actionCode = paramJceInputStream.read(this.actionCode, 3, true);
    this.yybExistFlag = paramJceInputStream.read(this.yybExistFlag, 4, false);
    this.extra = paramJceInputStream.readString(5, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.updateType, 0);
    paramJceOutputStream.write(this.packageName, 1);
    paramJceOutputStream.write(this.appid, 2);
    paramJceOutputStream.write(this.actionCode, 3);
    paramJceOutputStream.write(this.yybExistFlag, 4);
    if (this.extra != null) {
      paramJceOutputStream.write(this.extra, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.UpdateInfoLog
 * JD-Core Version:    0.7.0.1
 */