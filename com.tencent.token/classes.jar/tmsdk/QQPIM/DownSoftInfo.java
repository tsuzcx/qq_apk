package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DownSoftInfo
  extends JceStruct
{
  static SoftKey dw;
  public int Networkstandard = 0;
  public int categoryid = 0;
  public String channelId = "";
  public String downnetname = "";
  public int downnettype = 0;
  public int errorcode = 0;
  public String errormsg = "";
  public int filesize = 0;
  public String hostaddress = "";
  public int isvalid = -1;
  public int nAvgSpeed = 0;
  public int nDownSize = 0;
  public byte nDownType = 0;
  public int nFileId = 0;
  public int nMaxSpeed = 0;
  public int nProductId = 0;
  public int nRetryTimes = 0;
  public int nSoftId = 0;
  public byte nSuccess = 0;
  public int nUsedTime = 0;
  public int pos = 0;
  public String reportnetname = "";
  public int reportnettype = 0;
  public int rssi = -1;
  public int sdcardstatus = -1;
  public SoftKey softkey = null;
  public String url = "";
  
  public DownSoftInfo() {}
  
  public DownSoftInfo(int paramInt1, int paramInt2, int paramInt3, byte paramByte1, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, byte paramByte2, SoftKey paramSoftKey, int paramInt9, int paramInt10, String paramString1, int paramInt11, int paramInt12, String paramString2, int paramInt13, String paramString3, String paramString4, int paramInt14, int paramInt15, int paramInt16, String paramString5, int paramInt17, int paramInt18, String paramString6)
  {
    this.nProductId = paramInt1;
    this.nSoftId = paramInt2;
    this.nFileId = paramInt3;
    this.nSuccess = paramByte1;
    this.nDownSize = paramInt4;
    this.nUsedTime = paramInt5;
    this.nMaxSpeed = paramInt6;
    this.nAvgSpeed = paramInt7;
    this.nRetryTimes = paramInt8;
    this.nDownType = paramByte2;
    this.softkey = paramSoftKey;
    this.categoryid = paramInt9;
    this.pos = paramInt10;
    this.url = paramString1;
    this.errorcode = paramInt11;
    this.downnettype = paramInt12;
    this.downnetname = paramString2;
    this.reportnettype = paramInt13;
    this.reportnetname = paramString3;
    this.errormsg = paramString4;
    this.rssi = paramInt14;
    this.sdcardstatus = paramInt15;
    this.filesize = paramInt16;
    this.hostaddress = paramString5;
    this.isvalid = paramInt17;
    this.Networkstandard = paramInt18;
    this.channelId = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nProductId = paramJceInputStream.read(this.nProductId, 0, true);
    this.nSoftId = paramJceInputStream.read(this.nSoftId, 1, true);
    this.nFileId = paramJceInputStream.read(this.nFileId, 2, true);
    this.nSuccess = paramJceInputStream.read(this.nSuccess, 3, true);
    this.nDownSize = paramJceInputStream.read(this.nDownSize, 4, true);
    this.nUsedTime = paramJceInputStream.read(this.nUsedTime, 5, true);
    this.nMaxSpeed = paramJceInputStream.read(this.nMaxSpeed, 6, true);
    this.nAvgSpeed = paramJceInputStream.read(this.nAvgSpeed, 7, true);
    this.nRetryTimes = paramJceInputStream.read(this.nRetryTimes, 8, true);
    this.nDownType = paramJceInputStream.read(this.nDownType, 9, true);
    if (dw == null) {
      dw = new SoftKey();
    }
    this.softkey = ((SoftKey)paramJceInputStream.read(dw, 10, true));
    this.categoryid = paramJceInputStream.read(this.categoryid, 11, false);
    this.pos = paramJceInputStream.read(this.pos, 12, false);
    this.url = paramJceInputStream.readString(13, false);
    this.errorcode = paramJceInputStream.read(this.errorcode, 14, false);
    this.downnettype = paramJceInputStream.read(this.downnettype, 15, false);
    this.downnetname = paramJceInputStream.readString(16, false);
    this.reportnettype = paramJceInputStream.read(this.reportnettype, 17, false);
    this.reportnetname = paramJceInputStream.readString(18, false);
    this.errormsg = paramJceInputStream.readString(19, false);
    this.rssi = paramJceInputStream.read(this.rssi, 20, false);
    this.sdcardstatus = paramJceInputStream.read(this.sdcardstatus, 21, false);
    this.filesize = paramJceInputStream.read(this.filesize, 22, false);
    this.hostaddress = paramJceInputStream.readString(23, false);
    this.isvalid = paramJceInputStream.read(this.isvalid, 24, false);
    this.Networkstandard = paramJceInputStream.read(this.Networkstandard, 25, false);
    this.channelId = paramJceInputStream.readString(26, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nProductId, 0);
    paramJceOutputStream.write(this.nSoftId, 1);
    paramJceOutputStream.write(this.nFileId, 2);
    paramJceOutputStream.write(this.nSuccess, 3);
    paramJceOutputStream.write(this.nDownSize, 4);
    paramJceOutputStream.write(this.nUsedTime, 5);
    paramJceOutputStream.write(this.nMaxSpeed, 6);
    paramJceOutputStream.write(this.nAvgSpeed, 7);
    paramJceOutputStream.write(this.nRetryTimes, 8);
    paramJceOutputStream.write(this.nDownType, 9);
    paramJceOutputStream.write(this.softkey, 10);
    paramJceOutputStream.write(this.categoryid, 11);
    paramJceOutputStream.write(this.pos, 12);
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 13);
    }
    paramJceOutputStream.write(this.errorcode, 14);
    paramJceOutputStream.write(this.downnettype, 15);
    if (this.downnetname != null) {
      paramJceOutputStream.write(this.downnetname, 16);
    }
    paramJceOutputStream.write(this.reportnettype, 17);
    if (this.reportnetname != null) {
      paramJceOutputStream.write(this.reportnetname, 18);
    }
    if (this.errormsg != null) {
      paramJceOutputStream.write(this.errormsg, 19);
    }
    paramJceOutputStream.write(this.rssi, 20);
    paramJceOutputStream.write(this.sdcardstatus, 21);
    paramJceOutputStream.write(this.filesize, 22);
    if (this.hostaddress != null) {
      paramJceOutputStream.write(this.hostaddress, 23);
    }
    paramJceOutputStream.write(this.isvalid, 24);
    paramJceOutputStream.write(this.Networkstandard, 25);
    if (this.channelId != null) {
      paramJceOutputStream.write(this.channelId, 26);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.DownSoftInfo
 * JD-Core Version:    0.7.0.1
 */