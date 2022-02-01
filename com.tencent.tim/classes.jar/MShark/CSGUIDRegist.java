package MShark;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CSGUIDRegist
  extends JceStruct
{
  public String build_brand = "";
  public String build_version_incremental = "";
  public String build_version_release = "";
  public int buildno;
  public String channelid = "";
  public String imei = "";
  public String imsi = "";
  public boolean isbuildin;
  public String lc = "";
  public String mac = "";
  public String pkgname = "";
  public int platform = 0;
  public int product;
  public int subplatform = 0;
  public String ua = "";
  
  public JceStruct newInit()
  {
    return new CSGUIDRegist();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.imei = paramJceInputStream.readString(0, true);
    this.imsi = paramJceInputStream.readString(1, false);
    this.mac = paramJceInputStream.readString(2, false);
    this.lc = paramJceInputStream.readString(3, false);
    this.buildno = paramJceInputStream.read(this.buildno, 4, false);
    this.channelid = paramJceInputStream.readString(5, false);
    this.pkgname = paramJceInputStream.readString(6, false);
    this.build_brand = paramJceInputStream.readString(7, false);
    this.build_version_incremental = paramJceInputStream.readString(8, false);
    this.build_version_release = paramJceInputStream.readString(9, false);
    this.product = paramJceInputStream.read(this.product, 10, false);
    this.platform = paramJceInputStream.read(this.platform, 11, false);
    this.subplatform = paramJceInputStream.read(this.subplatform, 12, false);
    this.isbuildin = paramJceInputStream.read(this.isbuildin, 13, false);
    this.ua = paramJceInputStream.readString(14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.imei, 0);
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 1);
    }
    if (this.mac != null) {
      paramJceOutputStream.write(this.mac, 2);
    }
    if (this.lc != null) {
      paramJceOutputStream.write(this.lc, 3);
    }
    if (this.buildno != 0) {
      paramJceOutputStream.write(this.buildno, 4);
    }
    if (this.channelid != null) {
      paramJceOutputStream.write(this.channelid, 5);
    }
    if (this.pkgname != null) {
      paramJceOutputStream.write(this.pkgname, 6);
    }
    if (this.build_brand != null) {
      paramJceOutputStream.write(this.build_brand, 7);
    }
    if (this.build_version_incremental != null) {
      paramJceOutputStream.write(this.build_version_incremental, 8);
    }
    if (this.build_version_release != null) {
      paramJceOutputStream.write(this.build_version_release, 9);
    }
    if (this.product != 0) {
      paramJceOutputStream.write(this.product, 10);
    }
    if (this.platform != 0) {
      paramJceOutputStream.write(this.platform, 11);
    }
    if (this.subplatform != 0) {
      paramJceOutputStream.write(this.subplatform, 12);
    }
    paramJceOutputStream.write(this.isbuildin, 13);
    if (this.ua != null) {
      paramJceOutputStream.write(this.ua, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     MShark.CSGUIDRegist
 * JD-Core Version:    0.7.0.1
 */