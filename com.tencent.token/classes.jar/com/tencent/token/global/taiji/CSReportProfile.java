package com.tencent.token.global.taiji;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CSReportProfile
  extends JceStruct
{
  static ArrayList cache_param = new ArrayList();
  public int actionID = 0;
  public long getTime = 0L;
  public boolean isCheckKey = false;
  public int lastVerifyKey = 0;
  public ArrayList param = null;
  public int presentVerifyKey = 0;
  public int profileID = 0;
  public int profileSource = 0;
  public int reportProfileVer = 0;
  public int reportTime = 0;
  public int reportType = 0;
  public int sdcardNum = -1;
  public int sdcardState = 0;
  public int tryCount = 0;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_param.add(arrayOfByte);
  }
  
  public JceStruct newInit()
  {
    return new CSReportProfile();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.profileID = paramJceInputStream.read(this.profileID, 0, true);
    this.lastVerifyKey = paramJceInputStream.read(this.lastVerifyKey, 1, true);
    this.presentVerifyKey = paramJceInputStream.read(this.presentVerifyKey, 2, true);
    this.param = ((ArrayList)paramJceInputStream.read(cache_param, 3, true));
    this.actionID = paramJceInputStream.read(this.actionID, 4, false);
    this.isCheckKey = paramJceInputStream.read(this.isCheckKey, 5, false);
    this.reportType = paramJceInputStream.read(this.reportType, 6, false);
    this.reportTime = paramJceInputStream.read(this.reportTime, 7, false);
    this.profileSource = paramJceInputStream.read(this.profileSource, 8, false);
    this.getTime = paramJceInputStream.read(this.getTime, 9, false);
    this.sdcardState = paramJceInputStream.read(this.sdcardState, 10, false);
    this.sdcardNum = paramJceInputStream.read(this.sdcardNum, 11, false);
    this.reportProfileVer = paramJceInputStream.read(this.reportProfileVer, 12, false);
    this.tryCount = paramJceInputStream.read(this.tryCount, 13, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.profileID, 0);
    paramJceOutputStream.write(this.lastVerifyKey, 1);
    paramJceOutputStream.write(this.presentVerifyKey, 2);
    paramJceOutputStream.write(this.param, 3);
    if (this.actionID != 0) {
      paramJceOutputStream.write(this.actionID, 4);
    }
    paramJceOutputStream.write(this.isCheckKey, 5);
    if (this.reportType != 0) {
      paramJceOutputStream.write(this.reportType, 6);
    }
    if (this.reportTime != 0) {
      paramJceOutputStream.write(this.reportTime, 7);
    }
    if (this.profileSource != 0) {
      paramJceOutputStream.write(this.profileSource, 8);
    }
    if (this.getTime != 0L) {
      paramJceOutputStream.write(this.getTime, 9);
    }
    if (this.sdcardState != 0) {
      paramJceOutputStream.write(this.sdcardState, 10);
    }
    if (this.sdcardNum != -1) {
      paramJceOutputStream.write(this.sdcardNum, 11);
    }
    if (this.reportProfileVer != 0) {
      paramJceOutputStream.write(this.reportProfileVer, 12);
    }
    if (this.tryCount != 0) {
      paramJceOutputStream.write(this.tryCount, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.CSReportProfile
 * JD-Core Version:    0.7.0.1
 */