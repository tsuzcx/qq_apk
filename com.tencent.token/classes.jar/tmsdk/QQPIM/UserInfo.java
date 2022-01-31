package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserInfo
  extends JceStruct
{
  static ProductVersion dX = new ProductVersion();
  public int buildno = 0;
  public String channelid = "";
  public int ct = 0;
  public String guid = "";
  public String imei = "";
  public String imsi = "";
  public String ip = "";
  public int isbuildin = 0;
  public int isroot = 0;
  public short lang = 0;
  public int language = 0;
  public double latitude = 0.0D;
  public String lc = "";
  public double longitude = 0.0D;
  public String newguid = "";
  public String phone = "";
  public int product = 0;
  public String qq = "";
  public int sdkversion = 0;
  public String ua = "";
  public String uuid = "";
  public ProductVersion version = null;
  
  public JceStruct newInit()
  {
    return new UserInfo();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.imei = paramJceInputStream.readString(0, true);
    this.qq = paramJceInputStream.readString(1, false);
    this.phone = paramJceInputStream.readString(2, false);
    this.ip = paramJceInputStream.readString(3, false);
    this.lc = paramJceInputStream.readString(4, false);
    this.channelid = paramJceInputStream.readString(5, false);
    this.ua = paramJceInputStream.readString(6, false);
    this.ct = paramJceInputStream.read(this.ct, 7, false);
    this.product = paramJceInputStream.read(this.product, 8, false);
    this.version = ((ProductVersion)paramJceInputStream.read(dX, 9, false));
    this.guid = paramJceInputStream.readString(10, false);
    this.imsi = paramJceInputStream.readString(11, false);
    this.isbuildin = paramJceInputStream.read(this.isbuildin, 12, false);
    this.isroot = paramJceInputStream.read(this.isroot, 13, false);
    this.sdkversion = paramJceInputStream.read(this.sdkversion, 14, false);
    this.buildno = paramJceInputStream.read(this.buildno, 15, false);
    this.uuid = paramJceInputStream.readString(16, false);
    this.lang = paramJceInputStream.read(this.lang, 17, false);
    this.longitude = paramJceInputStream.read(this.longitude, 18, false);
    this.latitude = paramJceInputStream.read(this.latitude, 19, false);
    this.newguid = paramJceInputStream.readString(20, false);
    this.language = paramJceInputStream.read(this.language, 21, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.imei, 0);
    if (this.qq != null) {
      paramJceOutputStream.write(this.qq, 1);
    }
    if (this.phone != null) {
      paramJceOutputStream.write(this.phone, 2);
    }
    if (this.ip != null) {
      paramJceOutputStream.write(this.ip, 3);
    }
    if (this.lc != null) {
      paramJceOutputStream.write(this.lc, 4);
    }
    if (this.channelid != null) {
      paramJceOutputStream.write(this.channelid, 5);
    }
    if (this.ua != null) {
      paramJceOutputStream.write(this.ua, 6);
    }
    if (this.ct != 0) {
      paramJceOutputStream.write(this.ct, 7);
    }
    if (this.product != 0) {
      paramJceOutputStream.write(this.product, 8);
    }
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 9);
    }
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 10);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 11);
    }
    if (this.isbuildin != 0) {
      paramJceOutputStream.write(this.isbuildin, 12);
    }
    if (this.isroot != 0) {
      paramJceOutputStream.write(this.isroot, 13);
    }
    if (this.sdkversion != 0) {
      paramJceOutputStream.write(this.sdkversion, 14);
    }
    if (this.buildno != 0) {
      paramJceOutputStream.write(this.buildno, 15);
    }
    if (this.uuid != null) {
      paramJceOutputStream.write(this.uuid, 16);
    }
    if (this.lang != 0) {
      paramJceOutputStream.write(this.lang, 17);
    }
    if (this.longitude != 0.0D) {
      paramJceOutputStream.write(this.longitude, 18);
    }
    if (this.latitude != 0.0D) {
      paramJceOutputStream.write(this.latitude, 19);
    }
    if (this.newguid != null) {
      paramJceOutputStream.write(this.newguid, 20);
    }
    if (this.language != 0) {
      paramJceOutputStream.write(this.language, 21);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.UserInfo
 * JD-Core Version:    0.7.0.1
 */