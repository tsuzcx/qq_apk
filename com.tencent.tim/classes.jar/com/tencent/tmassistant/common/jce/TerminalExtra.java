package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TerminalExtra
  extends JceStruct
{
  public String abiList = "";
  public short apiLevel = 0;
  public int cpuCoresNum = 0;
  public int cpuMaxFreq = 0;
  public int cpuMinFreq = 0;
  public String cpuName = "";
  public String fingerprint = "";
  public int flashRemainSize = 0;
  public int flashTotalSize = 0;
  public String model = "";
  public int ramRemainSize = 0;
  public long ramTotalSize = 0L;
  public String romName = "";
  public String romVersion = "";
  public short storageSpeed = 0;
  
  public TerminalExtra() {}
  
  public TerminalExtra(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, short paramShort1, short paramShort2, String paramString6, int paramInt4, int paramInt5, int paramInt6)
  {
    this.cpuName = paramString1;
    this.cpuCoresNum = paramInt1;
    this.cpuMaxFreq = paramInt2;
    this.cpuMinFreq = paramInt3;
    this.ramTotalSize = paramLong;
    this.romName = paramString2;
    this.romVersion = paramString3;
    this.fingerprint = paramString4;
    this.model = paramString5;
    this.apiLevel = paramShort1;
    this.storageSpeed = paramShort2;
    this.abiList = paramString6;
    this.ramRemainSize = paramInt4;
    this.flashTotalSize = paramInt5;
    this.flashRemainSize = paramInt6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cpuName = paramJceInputStream.readString(0, false);
    this.cpuCoresNum = paramJceInputStream.read(this.cpuCoresNum, 1, false);
    this.cpuMaxFreq = paramJceInputStream.read(this.cpuMaxFreq, 2, false);
    this.cpuMinFreq = paramJceInputStream.read(this.cpuMinFreq, 3, false);
    this.ramTotalSize = paramJceInputStream.read(this.ramTotalSize, 4, false);
    this.romName = paramJceInputStream.readString(5, false);
    this.romVersion = paramJceInputStream.readString(6, false);
    this.fingerprint = paramJceInputStream.readString(7, false);
    this.model = paramJceInputStream.readString(8, false);
    this.apiLevel = paramJceInputStream.read(this.apiLevel, 9, false);
    this.storageSpeed = paramJceInputStream.read(this.storageSpeed, 10, false);
    this.abiList = paramJceInputStream.readString(11, false);
    this.ramRemainSize = paramJceInputStream.read(this.ramRemainSize, 12, false);
    this.flashTotalSize = paramJceInputStream.read(this.flashTotalSize, 13, false);
    this.flashRemainSize = paramJceInputStream.read(this.flashRemainSize, 14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.cpuName != null) {
      paramJceOutputStream.write(this.cpuName, 0);
    }
    paramJceOutputStream.write(this.cpuCoresNum, 1);
    paramJceOutputStream.write(this.cpuMaxFreq, 2);
    paramJceOutputStream.write(this.cpuMinFreq, 3);
    paramJceOutputStream.write(this.ramTotalSize, 4);
    if (this.romName != null) {
      paramJceOutputStream.write(this.romName, 5);
    }
    if (this.romVersion != null) {
      paramJceOutputStream.write(this.romVersion, 6);
    }
    if (this.fingerprint != null) {
      paramJceOutputStream.write(this.fingerprint, 7);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 8);
    }
    paramJceOutputStream.write(this.apiLevel, 9);
    paramJceOutputStream.write(this.storageSpeed, 10);
    if (this.abiList != null) {
      paramJceOutputStream.write(this.abiList, 11);
    }
    paramJceOutputStream.write(this.ramRemainSize, 12);
    paramJceOutputStream.write(this.flashTotalSize, 13);
    paramJceOutputStream.write(this.flashRemainSize, 14);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.TerminalExtra
 * JD-Core Version:    0.7.0.1
 */