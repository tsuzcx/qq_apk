package tmsdk.Protocol.MConfigUpdate;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ConfigReport
  extends JceStruct
{
  public String checkSum = "";
  public String downNetName = "";
  public int downSize = -1;
  public byte downType = 0;
  public int downnetType = 0;
  public int errorCode = 0;
  public String errorMsg = "";
  public int fileId = 0;
  public int fileSize = 0;
  public String hostAddress = "";
  public int isValid = -1;
  public String reportNetName = "";
  public int reportNetType = 0;
  public int retryTimes = -1;
  public int rnum = 0;
  public int rssi = -1;
  public int sdcardStatus = -1;
  public byte success = 1;
  public int timestamp = -1;
  public String url = "";
  public int usedTime = -1;
  
  public JceStruct newInit()
  {
    return new ConfigReport();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fileId = paramJceInputStream.read(this.fileId, 0, true);
    this.checkSum = paramJceInputStream.readString(1, false);
    this.timestamp = paramJceInputStream.read(this.timestamp, 2, false);
    this.url = paramJceInputStream.readString(3, false);
    this.success = paramJceInputStream.read(this.success, 4, false);
    this.downSize = paramJceInputStream.read(this.downSize, 5, false);
    this.usedTime = paramJceInputStream.read(this.usedTime, 6, false);
    this.retryTimes = paramJceInputStream.read(this.retryTimes, 7, false);
    this.downType = paramJceInputStream.read(this.downType, 8, false);
    this.errorCode = paramJceInputStream.read(this.errorCode, 9, false);
    this.downnetType = paramJceInputStream.read(this.downnetType, 10, false);
    this.downNetName = paramJceInputStream.readString(11, false);
    this.reportNetType = paramJceInputStream.read(this.reportNetType, 12, false);
    this.reportNetName = paramJceInputStream.readString(13, false);
    this.errorMsg = paramJceInputStream.readString(14, false);
    this.rssi = paramJceInputStream.read(this.rssi, 15, false);
    this.sdcardStatus = paramJceInputStream.read(this.sdcardStatus, 16, false);
    this.fileSize = paramJceInputStream.read(this.fileSize, 17, false);
    this.hostAddress = paramJceInputStream.readString(18, false);
    this.isValid = paramJceInputStream.read(this.isValid, 19, false);
    this.rnum = paramJceInputStream.read(this.rnum, 20, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fileId, 0);
    if (this.checkSum != null) {
      paramJceOutputStream.write(this.checkSum, 1);
    }
    if (this.timestamp != -1) {
      paramJceOutputStream.write(this.timestamp, 2);
    }
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 3);
    }
    if (this.success != 1) {
      paramJceOutputStream.write(this.success, 4);
    }
    if (this.downSize != -1) {
      paramJceOutputStream.write(this.downSize, 5);
    }
    if (this.usedTime != -1) {
      paramJceOutputStream.write(this.usedTime, 6);
    }
    if (this.retryTimes != -1) {
      paramJceOutputStream.write(this.retryTimes, 7);
    }
    if (this.downType != 0) {
      paramJceOutputStream.write(this.downType, 8);
    }
    if (this.errorCode != 0) {
      paramJceOutputStream.write(this.errorCode, 9);
    }
    if (this.downnetType != 0) {
      paramJceOutputStream.write(this.downnetType, 10);
    }
    if (this.downNetName != null) {
      paramJceOutputStream.write(this.downNetName, 11);
    }
    if (this.reportNetType != 0) {
      paramJceOutputStream.write(this.reportNetType, 12);
    }
    if (this.reportNetName != null) {
      paramJceOutputStream.write(this.reportNetName, 13);
    }
    if (this.errorMsg != null) {
      paramJceOutputStream.write(this.errorMsg, 14);
    }
    if (this.rssi != -1) {
      paramJceOutputStream.write(this.rssi, 15);
    }
    if (this.sdcardStatus != -1) {
      paramJceOutputStream.write(this.sdcardStatus, 16);
    }
    if (this.fileSize != 0) {
      paramJceOutputStream.write(this.fileSize, 17);
    }
    if (this.hostAddress != null) {
      paramJceOutputStream.write(this.hostAddress, 18);
    }
    if (this.isValid != -1) {
      paramJceOutputStream.write(this.isValid, 19);
    }
    if (this.rnum != 0) {
      paramJceOutputStream.write(this.rnum, 20);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MConfigUpdate.ConfigReport
 * JD-Core Version:    0.7.0.1
 */