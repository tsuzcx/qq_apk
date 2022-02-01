package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GuanjiaReportReq
  extends JceStruct
{
  public boolean bKingCard = true;
  public boolean bReportFlag = true;
  public int iCardStatus;
  public int iCardType;
  public int iImplat;
  public String sIdfa = "";
  public String sIdfv = "";
  public String sMac = "";
  public String sMachine = "";
  public String sOsVersion = "";
  public String sPhoneNum = "";
  public String sPkgName = "";
  public long uin;
  
  public GuanjiaReportReq() {}
  
  public GuanjiaReportReq(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, int paramInt1, String paramString7, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    this.sIdfa = paramString1;
    this.sIdfv = paramString2;
    this.sMac = paramString3;
    this.sMachine = paramString4;
    this.sOsVersion = paramString5;
    this.sPkgName = paramString6;
    this.uin = paramLong;
    this.iImplat = paramInt1;
    this.sPhoneNum = paramString7;
    this.bKingCard = paramBoolean1;
    this.iCardType = paramInt2;
    this.iCardStatus = paramInt3;
    this.bReportFlag = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sIdfa = paramJceInputStream.readString(0, false);
    this.sIdfv = paramJceInputStream.readString(1, false);
    this.sMac = paramJceInputStream.readString(2, false);
    this.sMachine = paramJceInputStream.readString(3, false);
    this.sOsVersion = paramJceInputStream.readString(4, false);
    this.sPkgName = paramJceInputStream.readString(5, false);
    this.uin = paramJceInputStream.read(this.uin, 6, false);
    this.iImplat = paramJceInputStream.read(this.iImplat, 7, false);
    this.sPhoneNum = paramJceInputStream.readString(8, false);
    this.bKingCard = paramJceInputStream.read(this.bKingCard, 9, false);
    this.iCardType = paramJceInputStream.read(this.iCardType, 10, false);
    this.iCardStatus = paramJceInputStream.read(this.iCardStatus, 11, false);
    this.bReportFlag = paramJceInputStream.read(this.bReportFlag, 12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sIdfa != null) {
      paramJceOutputStream.write(this.sIdfa, 0);
    }
    if (this.sIdfv != null) {
      paramJceOutputStream.write(this.sIdfv, 1);
    }
    if (this.sMac != null) {
      paramJceOutputStream.write(this.sMac, 2);
    }
    if (this.sMachine != null) {
      paramJceOutputStream.write(this.sMachine, 3);
    }
    if (this.sOsVersion != null) {
      paramJceOutputStream.write(this.sOsVersion, 4);
    }
    if (this.sPkgName != null) {
      paramJceOutputStream.write(this.sPkgName, 5);
    }
    paramJceOutputStream.write(this.uin, 6);
    paramJceOutputStream.write(this.iImplat, 7);
    if (this.sPhoneNum != null) {
      paramJceOutputStream.write(this.sPhoneNum, 8);
    }
    paramJceOutputStream.write(this.bKingCard, 9);
    paramJceOutputStream.write(this.iCardType, 10);
    paramJceOutputStream.write(this.iCardStatus, 11);
    paramJceOutputStream.write(this.bReportFlag, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     MQQ.GuanjiaReportReq
 * JD-Core Version:    0.7.0.1
 */