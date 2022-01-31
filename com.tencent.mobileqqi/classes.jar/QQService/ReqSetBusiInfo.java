package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqSetBusiInfo
  extends JceStruct
{
  static ReqHead cache_stHeader;
  public int iLat = 0;
  public int iLon = 0;
  public long lUIN = 0L;
  public ReqHead stHeader = null;
  public String strAddress = "";
  public String strCertification = "";
  public String strCertificationInfo = "";
  public String strContactName = "";
  public String strContactTelNumber = "";
  public String strCustomTelNumber = "";
  
  public ReqSetBusiInfo() {}
  
  public ReqSetBusiInfo(ReqHead paramReqHead, long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.stHeader = paramReqHead;
    this.lUIN = paramLong;
    this.strCertification = paramString1;
    this.strCertificationInfo = paramString2;
    this.iLat = paramInt1;
    this.iLon = paramInt2;
    this.strAddress = paramString3;
    this.strCustomTelNumber = paramString4;
    this.strContactName = paramString5;
    this.strContactTelNumber = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.lUIN = paramJceInputStream.read(this.lUIN, 1, true);
    this.strCertification = paramJceInputStream.readString(2, true);
    this.strCertificationInfo = paramJceInputStream.readString(3, true);
    this.iLat = paramJceInputStream.read(this.iLat, 4, true);
    this.iLon = paramJceInputStream.read(this.iLon, 5, true);
    this.strAddress = paramJceInputStream.readString(6, false);
    this.strCustomTelNumber = paramJceInputStream.readString(7, false);
    this.strContactName = paramJceInputStream.readString(8, false);
    this.strContactTelNumber = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.lUIN, 1);
    paramJceOutputStream.write(this.strCertification, 2);
    paramJceOutputStream.write(this.strCertificationInfo, 3);
    paramJceOutputStream.write(this.iLat, 4);
    paramJceOutputStream.write(this.iLon, 5);
    if (this.strAddress != null) {
      paramJceOutputStream.write(this.strAddress, 6);
    }
    if (this.strCustomTelNumber != null) {
      paramJceOutputStream.write(this.strCustomTelNumber, 7);
    }
    if (this.strContactName != null) {
      paramJceOutputStream.write(this.strContactName, 8);
    }
    if (this.strContactTelNumber != null) {
      paramJceOutputStream.write(this.strContactTelNumber, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ReqSetBusiInfo
 * JD-Core Version:    0.7.0.1
 */