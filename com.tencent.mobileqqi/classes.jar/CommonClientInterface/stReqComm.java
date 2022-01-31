package CommonClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stReqComm
  extends JceStruct
{
  public int iAppId = 0;
  public int iAuthType = 0;
  public int iPlat = 0;
  public String sAppVersion = "";
  public String sDeviceID = "";
  public String sDeviceName = "";
  public String sOSVersion = "";
  public String sReserved1 = "";
  public String sReserved2 = "";
  public String sSessionKey = "";
  public String sUid = "";
  
  public stReqComm() {}
  
  public stReqComm(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.iAppId = paramInt1;
    this.iPlat = paramInt2;
    this.sAppVersion = paramString1;
    this.sDeviceName = paramString2;
    this.sOSVersion = paramString3;
    this.sDeviceID = paramString4;
    this.iAuthType = paramInt3;
    this.sUid = paramString5;
    this.sSessionKey = paramString6;
    this.sReserved1 = paramString7;
    this.sReserved2 = paramString8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAppId = paramJceInputStream.read(this.iAppId, 0, true);
    this.iPlat = paramJceInputStream.read(this.iPlat, 1, true);
    this.sAppVersion = paramJceInputStream.readString(2, true);
    this.sDeviceName = paramJceInputStream.readString(3, true);
    this.sOSVersion = paramJceInputStream.readString(4, true);
    this.sDeviceID = paramJceInputStream.readString(5, true);
    this.iAuthType = paramJceInputStream.read(this.iAuthType, 6, false);
    this.sUid = paramJceInputStream.readString(7, false);
    this.sSessionKey = paramJceInputStream.readString(8, false);
    this.sReserved1 = paramJceInputStream.readString(9, false);
    this.sReserved2 = paramJceInputStream.readString(10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAppId, 0);
    paramJceOutputStream.write(this.iPlat, 1);
    paramJceOutputStream.write(this.sAppVersion, 2);
    paramJceOutputStream.write(this.sDeviceName, 3);
    paramJceOutputStream.write(this.sOSVersion, 4);
    paramJceOutputStream.write(this.sDeviceID, 5);
    paramJceOutputStream.write(this.iAuthType, 6);
    if (this.sUid != null) {
      paramJceOutputStream.write(this.sUid, 7);
    }
    if (this.sSessionKey != null) {
      paramJceOutputStream.write(this.sSessionKey, 8);
    }
    if (this.sReserved1 != null) {
      paramJceOutputStream.write(this.sReserved1, 9);
    }
    if (this.sReserved2 != null) {
      paramJceOutputStream.write(this.sReserved2, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     CommonClientInterface.stReqComm
 * JD-Core Version:    0.7.0.1
 */