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
    Object localObject = this.qq;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.phone;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.ip;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.lc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.channelid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.ua;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    int i = this.ct;
    if (i != 0) {
      paramJceOutputStream.write(i, 7);
    }
    i = this.product;
    if (i != 0) {
      paramJceOutputStream.write(i, 8);
    }
    localObject = this.version;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    localObject = this.guid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.imsi;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    i = this.isbuildin;
    if (i != 0) {
      paramJceOutputStream.write(i, 12);
    }
    i = this.isroot;
    if (i != 0) {
      paramJceOutputStream.write(i, 13);
    }
    i = this.sdkversion;
    if (i != 0) {
      paramJceOutputStream.write(i, 14);
    }
    i = this.buildno;
    if (i != 0) {
      paramJceOutputStream.write(i, 15);
    }
    localObject = this.uuid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 16);
    }
    short s = this.lang;
    if (s != 0) {
      paramJceOutputStream.write(s, 17);
    }
    double d = this.longitude;
    if (d != 0.0D) {
      paramJceOutputStream.write(d, 18);
    }
    d = this.latitude;
    if (d != 0.0D) {
      paramJceOutputStream.write(d, 19);
    }
    localObject = this.newguid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 20);
    }
    i = this.language;
    if (i != 0) {
      paramJceOutputStream.write(i, 21);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.UserInfo
 * JD-Core Version:    0.7.0.1
 */