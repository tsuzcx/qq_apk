package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stTroopMemberInfo
  extends JceStruct
{
  public byte Age = 0;
  public short FaceId = 0;
  public byte Gender = 0;
  public long MemberUin = 0L;
  public String Nick = "";
  public byte Status = 20;
  public byte cConcerned = 0;
  public byte cGender = 0;
  public long dwCreditLevel = 0L;
  public long dwFlag = 0L;
  public long dwFlagExt = 0L;
  public long dwJoinTime = 0L;
  public long dwLastSpeakTime = 0L;
  public long dwMemberLevel = 0L;
  public long dwPoint = 0L;
  public String sEmail = "";
  public String sMemo = "";
  public String sName = "";
  public String sPhone = "";
  public String sShowName = "";
  public String strAutoRemark = "";
  
  public stTroopMemberInfo() {}
  
  public stTroopMemberInfo(long paramLong1, short paramShort, byte paramByte1, byte paramByte2, String paramString1, byte paramByte3, String paramString2, String paramString3, byte paramByte4, String paramString4, String paramString5, String paramString6, String paramString7, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, byte paramByte5)
  {
    this.MemberUin = paramLong1;
    this.FaceId = paramShort;
    this.Age = paramByte1;
    this.Gender = paramByte2;
    this.Nick = paramString1;
    this.Status = paramByte3;
    this.sShowName = paramString2;
    this.sName = paramString3;
    this.cGender = paramByte4;
    this.sPhone = paramString4;
    this.sEmail = paramString5;
    this.sMemo = paramString6;
    this.strAutoRemark = paramString7;
    this.dwMemberLevel = paramLong2;
    this.dwJoinTime = paramLong3;
    this.dwLastSpeakTime = paramLong4;
    this.dwCreditLevel = paramLong5;
    this.dwFlag = paramLong6;
    this.dwFlagExt = paramLong7;
    this.dwPoint = paramLong8;
    this.cConcerned = paramByte5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.MemberUin = paramJceInputStream.read(this.MemberUin, 0, true);
    this.FaceId = paramJceInputStream.read(this.FaceId, 1, true);
    this.Age = paramJceInputStream.read(this.Age, 2, true);
    this.Gender = paramJceInputStream.read(this.Gender, 3, true);
    this.Nick = paramJceInputStream.readString(4, true);
    this.Status = paramJceInputStream.read(this.Status, 5, true);
    this.sShowName = paramJceInputStream.readString(6, false);
    this.sName = paramJceInputStream.readString(8, false);
    this.cGender = paramJceInputStream.read(this.cGender, 9, false);
    this.sPhone = paramJceInputStream.readString(10, false);
    this.sEmail = paramJceInputStream.readString(11, false);
    this.sMemo = paramJceInputStream.readString(12, false);
    this.strAutoRemark = paramJceInputStream.readString(13, false);
    this.dwMemberLevel = paramJceInputStream.read(this.dwMemberLevel, 14, false);
    this.dwJoinTime = paramJceInputStream.read(this.dwJoinTime, 15, false);
    this.dwLastSpeakTime = paramJceInputStream.read(this.dwLastSpeakTime, 16, false);
    this.dwCreditLevel = paramJceInputStream.read(this.dwCreditLevel, 17, false);
    this.dwFlag = paramJceInputStream.read(this.dwFlag, 18, false);
    this.dwFlagExt = paramJceInputStream.read(this.dwFlagExt, 19, false);
    this.dwPoint = paramJceInputStream.read(this.dwPoint, 20, false);
    this.cConcerned = paramJceInputStream.read(this.cConcerned, 21, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.MemberUin, 0);
    paramJceOutputStream.write(this.FaceId, 1);
    paramJceOutputStream.write(this.Age, 2);
    paramJceOutputStream.write(this.Gender, 3);
    paramJceOutputStream.write(this.Nick, 4);
    paramJceOutputStream.write(this.Status, 5);
    if (this.sShowName != null) {
      paramJceOutputStream.write(this.sShowName, 6);
    }
    if (this.sName != null) {
      paramJceOutputStream.write(this.sName, 8);
    }
    paramJceOutputStream.write(this.cGender, 9);
    if (this.sPhone != null) {
      paramJceOutputStream.write(this.sPhone, 10);
    }
    if (this.sEmail != null) {
      paramJceOutputStream.write(this.sEmail, 11);
    }
    if (this.sMemo != null) {
      paramJceOutputStream.write(this.sMemo, 12);
    }
    if (this.strAutoRemark != null) {
      paramJceOutputStream.write(this.strAutoRemark, 13);
    }
    paramJceOutputStream.write(this.dwMemberLevel, 14);
    paramJceOutputStream.write(this.dwJoinTime, 15);
    paramJceOutputStream.write(this.dwLastSpeakTime, 16);
    paramJceOutputStream.write(this.dwCreditLevel, 17);
    paramJceOutputStream.write(this.dwFlag, 18);
    paramJceOutputStream.write(this.dwFlagExt, 19);
    paramJceOutputStream.write(this.dwPoint, 20);
    paramJceOutputStream.write(this.cConcerned, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     friendlist.stTroopMemberInfo
 * JD-Core Version:    0.7.0.1
 */