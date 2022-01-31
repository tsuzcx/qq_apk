package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stTroopRemarkInfo
  extends JceStruct
{
  public long MemberUin = 0L;
  public byte cGender = 0;
  public String sEmail = "";
  public String sMemo = "";
  public String sName = "";
  public String sPhone = "";
  public String strAutoRemark = "";
  public String strNick = "";
  public String strRank = "";
  public String strRemark = "";
  
  public stTroopRemarkInfo() {}
  
  public stTroopRemarkInfo(long paramLong, String paramString1, String paramString2, String paramString3, byte paramByte, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.MemberUin = paramLong;
    this.strNick = paramString1;
    this.strRemark = paramString2;
    this.sName = paramString3;
    this.cGender = paramByte;
    this.sPhone = paramString4;
    this.sEmail = paramString5;
    this.sMemo = paramString6;
    this.strAutoRemark = paramString7;
    this.strRank = paramString8;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     friendlist.stTroopRemarkInfo
 * JD-Core Version:    0.7.0.1
 */