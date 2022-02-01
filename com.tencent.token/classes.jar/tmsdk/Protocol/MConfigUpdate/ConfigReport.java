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
    String str = this.checkSum;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    int i = this.timestamp;
    if (i != -1) {
      paramJceOutputStream.write(i, 2);
    }
    str = this.url;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    byte b = this.success;
    if (b != 1) {
      paramJceOutputStream.write(b, 4);
    }
    i = this.downSize;
    if (i != -1) {
      paramJceOutputStream.write(i, 5);
    }
    i = this.usedTime;
    if (i != -1) {
      paramJceOutputStream.write(i, 6);
    }
    i = this.retryTimes;
    if (i != -1) {
      paramJceOutputStream.write(i, 7);
    }
    b = this.downType;
    if (b != 0) {
      paramJceOutputStream.write(b, 8);
    }
    i = this.errorCode;
    if (i != 0) {
      paramJceOutputStream.write(i, 9);
    }
    i = this.downnetType;
    if (i != 0) {
      paramJceOutputStream.write(i, 10);
    }
    str = this.downNetName;
    if (str != null) {
      paramJceOutputStream.write(str, 11);
    }
    i = this.reportNetType;
    if (i != 0) {
      paramJceOutputStream.write(i, 12);
    }
    str = this.reportNetName;
    if (str != null) {
      paramJceOutputStream.write(str, 13);
    }
    str = this.errorMsg;
    if (str != null) {
      paramJceOutputStream.write(str, 14);
    }
    i = this.rssi;
    if (i != -1) {
      paramJceOutputStream.write(i, 15);
    }
    i = this.sdcardStatus;
    if (i != -1) {
      paramJceOutputStream.write(i, 16);
    }
    i = this.fileSize;
    if (i != 0) {
      paramJceOutputStream.write(i, 17);
    }
    str = this.hostAddress;
    if (str != null) {
      paramJceOutputStream.write(str, 18);
    }
    i = this.isValid;
    if (i != -1) {
      paramJceOutputStream.write(i, 19);
    }
    i = this.rnum;
    if (i != 0) {
      paramJceOutputStream.write(i, 20);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MConfigUpdate.ConfigReport
 * JD-Core Version:    0.7.0.1
 */