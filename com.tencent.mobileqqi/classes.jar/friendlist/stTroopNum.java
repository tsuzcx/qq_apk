package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stTroopNum
  extends JceStruct
{
  public long GroupCode = 0L;
  public long GroupUin = 0L;
  public byte cFlag = 0;
  public long dwAdditionalFlag = 0L;
  public long dwCertificationType = 0L;
  public long dwCmdUinUinFlag = 0L;
  public long dwGroupFlagExt = 0L;
  public long dwGroupInfoSeq = 0L;
  public long dwGroupRankSeq = 0L;
  public long dwMyShutupTimestamp = 0L;
  public long dwShutupTimestamp = 0L;
  public String strGroupMemo = "";
  public String strGroupName = "";
  
  public stTroopNum() {}
  
  public stTroopNum(long paramLong1, long paramLong2, byte paramByte, long paramLong3, String paramString1, String paramString2, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10)
  {
    this.GroupUin = paramLong1;
    this.GroupCode = paramLong2;
    this.cFlag = paramByte;
    this.dwGroupInfoSeq = paramLong3;
    this.strGroupName = paramString1;
    this.strGroupMemo = paramString2;
    this.dwGroupFlagExt = paramLong4;
    this.dwGroupRankSeq = paramLong5;
    this.dwCertificationType = paramLong6;
    this.dwShutupTimestamp = paramLong7;
    this.dwMyShutupTimestamp = paramLong8;
    this.dwCmdUinUinFlag = paramLong9;
    this.dwAdditionalFlag = paramLong10;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.GroupUin = paramJceInputStream.read(this.GroupUin, 0, true);
    this.GroupCode = paramJceInputStream.read(this.GroupCode, 1, true);
    this.cFlag = paramJceInputStream.read(this.cFlag, 2, false);
    this.dwGroupInfoSeq = paramJceInputStream.read(this.dwGroupInfoSeq, 3, false);
    this.strGroupName = paramJceInputStream.readString(4, false);
    this.strGroupMemo = paramJceInputStream.readString(5, false);
    this.dwGroupFlagExt = paramJceInputStream.read(this.dwGroupFlagExt, 6, false);
    this.dwGroupRankSeq = paramJceInputStream.read(this.dwGroupRankSeq, 7, false);
    this.dwCertificationType = paramJceInputStream.read(this.dwCertificationType, 8, false);
    this.dwShutupTimestamp = paramJceInputStream.read(this.dwShutupTimestamp, 9, false);
    this.dwMyShutupTimestamp = paramJceInputStream.read(this.dwMyShutupTimestamp, 10, false);
    this.dwCmdUinUinFlag = paramJceInputStream.read(this.dwCmdUinUinFlag, 11, false);
    this.dwAdditionalFlag = paramJceInputStream.read(this.dwAdditionalFlag, 12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.GroupUin, 0);
    paramJceOutputStream.write(this.GroupCode, 1);
    paramJceOutputStream.write(this.cFlag, 2);
    paramJceOutputStream.write(this.dwGroupInfoSeq, 3);
    if (this.strGroupName != null) {
      paramJceOutputStream.write(this.strGroupName, 4);
    }
    if (this.strGroupMemo != null) {
      paramJceOutputStream.write(this.strGroupMemo, 5);
    }
    paramJceOutputStream.write(this.dwGroupFlagExt, 6);
    paramJceOutputStream.write(this.dwGroupRankSeq, 7);
    paramJceOutputStream.write(this.dwCertificationType, 8);
    paramJceOutputStream.write(this.dwShutupTimestamp, 9);
    paramJceOutputStream.write(this.dwMyShutupTimestamp, 10);
    paramJceOutputStream.write(this.dwCmdUinUinFlag, 11);
    paramJceOutputStream.write(this.dwAdditionalFlag, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     friendlist.stTroopNum
 * JD-Core Version:    0.7.0.1
 */