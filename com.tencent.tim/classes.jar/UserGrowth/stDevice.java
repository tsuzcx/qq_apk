package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stDevice
  extends JceStruct
{
  public String encrypted_deviceid = "";
  public String idfa = "";
  public String imei = "";
  public String qimei = "";
  
  public stDevice() {}
  
  public stDevice(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.encrypted_deviceid = paramString1;
    this.imei = paramString2;
    this.idfa = paramString3;
    this.qimei = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.encrypted_deviceid = paramJceInputStream.readString(0, false);
    this.imei = paramJceInputStream.readString(1, false);
    this.idfa = paramJceInputStream.readString(2, false);
    this.qimei = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.encrypted_deviceid != null) {
      paramJceOutputStream.write(this.encrypted_deviceid, 0);
    }
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 1);
    }
    if (this.idfa != null) {
      paramJceOutputStream.write(this.idfa, 2);
    }
    if (this.qimei != null) {
      paramJceOutputStream.write(this.qimei, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.stDevice
 * JD-Core Version:    0.7.0.1
 */