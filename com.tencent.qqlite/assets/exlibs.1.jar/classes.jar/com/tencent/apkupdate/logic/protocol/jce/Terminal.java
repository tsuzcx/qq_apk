package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Terminal
  extends JceStruct
{
  public String androidId = "";
  public String androidIdSdCard = "";
  public String imei = "";
  public String imsi = "";
  public String macAdress = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.imei = paramJceInputStream.readString(0, false);
    this.macAdress = paramJceInputStream.readString(1, false);
    this.androidId = paramJceInputStream.readString(2, false);
    this.androidIdSdCard = paramJceInputStream.readString(3, false);
    this.imsi = paramJceInputStream.readString(4, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 0);
    }
    if (this.macAdress != null) {
      paramJceOutputStream.write(this.macAdress, 1);
    }
    if (this.androidId != null) {
      paramJceOutputStream.write(this.androidId, 2);
    }
    if (this.androidIdSdCard != null) {
      paramJceOutputStream.write(this.androidIdSdCard, 3);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.jce.Terminal
 * JD-Core Version:    0.7.0.1
 */