package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stTroopRemarkInfo
  extends JceStruct
{
  public long GlamourLevel;
  public long MemberUin;
  public long TorchbearerFlag;
  public String bytes_job = "";
  public byte cGender;
  public byte cRichCardNameVer;
  public String sEmail = "";
  public String sMemo = "";
  public String sName = "";
  public String sPhone = "";
  public String strAutoRemark = "";
  public String strNick = "";
  public String strRank = "";
  public String strRemark = "";
  
  public stTroopRemarkInfo() {}
  
  public stTroopRemarkInfo(long paramLong1, String paramString1, String paramString2, String paramString3, byte paramByte1, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, long paramLong2, long paramLong3, byte paramByte2)
  {
    this.MemberUin = paramLong1;
    this.strNick = paramString1;
    this.strRemark = paramString2;
    this.sName = paramString3;
    this.cGender = paramByte1;
    this.sPhone = paramString4;
    this.sEmail = paramString5;
    this.sMemo = paramString6;
    this.strAutoRemark = paramString7;
    this.strRank = paramString8;
    this.bytes_job = paramString9;
    this.GlamourLevel = paramLong2;
    this.TorchbearerFlag = paramLong3;
    this.cRichCardNameVer = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.MemberUin = paramJceInputStream.read(this.MemberUin, 0, true);
    this.strNick = paramJceInputStream.readString(1, true);
    this.strRemark = paramJceInputStream.readString(2, true);
    this.sName = paramJceInputStream.readString(3, false);
    this.cGender = paramJceInputStream.read(this.cGender, 4, false);
    this.sPhone = paramJceInputStream.readString(5, false);
    this.sEmail = paramJceInputStream.readString(6, false);
    this.sMemo = paramJceInputStream.readString(7, false);
    this.strAutoRemark = paramJceInputStream.readString(8, false);
    this.strRank = paramJceInputStream.readString(9, false);
    this.bytes_job = paramJceInputStream.readString(10, false);
    this.GlamourLevel = paramJceInputStream.read(this.GlamourLevel, 11, false);
    this.TorchbearerFlag = paramJceInputStream.read(this.TorchbearerFlag, 12, false);
    this.cRichCardNameVer = paramJceInputStream.read(this.cRichCardNameVer, 13, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.MemberUin, 0);
    paramJceOutputStream.write(this.strNick, 1);
    paramJceOutputStream.write(this.strRemark, 2);
    if (this.sName != null) {
      paramJceOutputStream.write(this.sName, 3);
    }
    paramJceOutputStream.write(this.cGender, 4);
    if (this.sPhone != null) {
      paramJceOutputStream.write(this.sPhone, 5);
    }
    if (this.sEmail != null) {
      paramJceOutputStream.write(this.sEmail, 6);
    }
    if (this.sMemo != null) {
      paramJceOutputStream.write(this.sMemo, 7);
    }
    if (this.strAutoRemark != null) {
      paramJceOutputStream.write(this.strAutoRemark, 8);
    }
    if (this.strRank != null) {
      paramJceOutputStream.write(this.strRank, 9);
    }
    if (this.bytes_job != null) {
      paramJceOutputStream.write(this.bytes_job, 10);
    }
    paramJceOutputStream.write(this.GlamourLevel, 11);
    paramJceOutputStream.write(this.TorchbearerFlag, 12);
    paramJceOutputStream.write(this.cRichCardNameVer, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     friendlist.stTroopRemarkInfo
 * JD-Core Version:    0.7.0.1
 */