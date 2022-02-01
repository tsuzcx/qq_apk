package com.tencent.token.global.taiji;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CSReportProfile
  extends JceStruct
{
  static ArrayList<byte[]> cache_param = new ArrayList();
  public int actionID = 0;
  public long getTime = 0L;
  public boolean isCheckKey = false;
  public int lastVerifyKey = 0;
  public ArrayList<byte[]> param = null;
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
    int i = this.actionID;
    if (i != 0) {
      paramJceOutputStream.write(i, 4);
    }
    paramJceOutputStream.write(this.isCheckKey, 5);
    i = this.reportType;
    if (i != 0) {
      paramJceOutputStream.write(i, 6);
    }
    i = this.reportTime;
    if (i != 0) {
      paramJceOutputStream.write(i, 7);
    }
    i = this.profileSource;
    if (i != 0) {
      paramJceOutputStream.write(i, 8);
    }
    long l = this.getTime;
    if (l != 0L) {
      paramJceOutputStream.write(l, 9);
    }
    i = this.sdcardState;
    if (i != 0) {
      paramJceOutputStream.write(i, 10);
    }
    i = this.sdcardNum;
    if (i != -1) {
      paramJceOutputStream.write(i, 11);
    }
    i = this.reportProfileVer;
    if (i != 0) {
      paramJceOutputStream.write(i, 12);
    }
    i = this.tryCount;
    if (i != 0) {
      paramJceOutputStream.write(i, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.CSReportProfile
 * JD-Core Version:    0.7.0.1
 */