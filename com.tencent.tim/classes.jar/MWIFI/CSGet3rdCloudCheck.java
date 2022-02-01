package MWIFI;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CSGet3rdCloudCheck
  extends JceStruct
{
  static ArrayList<String> cache_vecDns;
  static WifiInfo cache_wifiInfo = new WifiInfo();
  public String imei = "";
  public String mac = "";
  public int networkType = 0;
  public int operType = 0;
  public ArrayList<String> vecDns;
  public String vid = "";
  public WifiInfo wifiInfo;
  
  static
  {
    cache_vecDns = new ArrayList();
    cache_vecDns.add("");
  }
  
  public JceStruct newInit()
  {
    return new CSGet3rdCloudCheck();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.networkType = paramJceInputStream.read(this.networkType, 0, false);
    this.operType = paramJceInputStream.read(this.operType, 1, false);
    this.wifiInfo = ((WifiInfo)paramJceInputStream.read(cache_wifiInfo, 2, false));
    this.vecDns = ((ArrayList)paramJceInputStream.read(cache_vecDns, 3, false));
    this.vid = paramJceInputStream.readString(4, false);
    this.mac = paramJceInputStream.readString(5, false);
    this.imei = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.networkType != 0) {
      paramJceOutputStream.write(this.networkType, 0);
    }
    if (this.operType != 0) {
      paramJceOutputStream.write(this.operType, 1);
    }
    if (this.wifiInfo != null) {
      paramJceOutputStream.write(this.wifiInfo, 2);
    }
    if (this.vecDns != null) {
      paramJceOutputStream.write(this.vecDns, 3);
    }
    if (this.vid != null) {
      paramJceOutputStream.write(this.vid, 4);
    }
    if (this.mac != null) {
      paramJceOutputStream.write(this.mac, 5);
    }
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     MWIFI.CSGet3rdCloudCheck
 * JD-Core Version:    0.7.0.1
 */