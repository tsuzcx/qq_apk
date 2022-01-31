package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stTroopInfoV2
  extends JceStruct
{
  public byte cGroupOption = 0;
  public long dwCertificationType = 0L;
  public long dwGroupClassExt = 0L;
  public long dwGroupCode = 0L;
  public long dwGroupFlagExt = 0L;
  public long dwGroupOwnerUin = 0L;
  public long dwGroupUin = 0L;
  public int memberNum = 0;
  public String strFingerMemo = "";
  public String strGroupMemo = "";
  public String strGroupName = "";
  public int wGroupFace = 0;
  
  public stTroopInfoV2() {}
  
  public stTroopInfoV2(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3, long paramLong4, int paramInt1, String paramString3, byte paramByte, int paramInt2, long paramLong5, long paramLong6)
  {
    this.dwGroupUin = paramLong1;
    this.dwGroupCode = paramLong2;
    this.strGroupName = paramString1;
    this.strGroupMemo = paramString2;
    this.dwGroupOwnerUin = paramLong3;
    this.dwGroupClassExt = paramLong4;
    this.wGroupFace = paramInt1;
    this.strFingerMemo = paramString3;
    this.cGroupOption = paramByte;
    this.memberNum = paramInt2;
    this.dwGroupFlagExt = paramLong5;
    this.dwCertificationType = paramLong6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwGroupUin = paramJceInputStream.read(this.dwGroupUin, 0, true);
    this.dwGroupCode = paramJceInputStream.read(this.dwGroupCode, 1, true);
    this.strGroupName = paramJceInputStream.readString(2, true);
    this.strGroupMemo = paramJceInputStream.readString(3, true);
    this.dwGroupOwnerUin = paramJceInputStream.read(this.dwGroupOwnerUin, 4, false);
    this.dwGroupClassExt = paramJceInputStream.read(this.dwGroupClassExt, 5, false);
    this.wGroupFace = paramJceInputStream.read(this.wGroupFace, 6, false);
    this.strFingerMemo = paramJceInputStream.readString(7, false);
    this.cGroupOption = paramJceInputStream.read(this.cGroupOption, 8, false);
    this.memberNum = paramJceInputStream.read(this.memberNum, 9, false);
    this.dwGroupFlagExt = paramJceInputStream.read(this.dwGroupFlagExt, 10, false);
    this.dwCertificationType = paramJceInputStream.read(this.dwCertificationType, 11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwGroupUin, 0);
    paramJceOutputStream.write(this.dwGroupCode, 1);
    paramJceOutputStream.write(this.strGroupName, 2);
    paramJceOutputStream.write(this.strGroupMemo, 3);
    paramJceOutputStream.write(this.dwGroupOwnerUin, 4);
    paramJceOutputStream.write(this.dwGroupClassExt, 5);
    paramJceOutputStream.write(this.wGroupFace, 6);
    if (this.strFingerMemo != null) {
      paramJceOutputStream.write(this.strFingerMemo, 7);
    }
    paramJceOutputStream.write(this.cGroupOption, 8);
    paramJceOutputStream.write(this.memberNum, 9);
    paramJceOutputStream.write(this.dwGroupFlagExt, 10);
    paramJceOutputStream.write(this.dwCertificationType, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     friendlist.stTroopInfoV2
 * JD-Core Version:    0.7.0.1
 */