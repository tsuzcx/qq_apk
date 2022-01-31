package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AnswerAddedFriendReq
  extends JceStruct
{
  static int cache_myAllowFlag;
  public long adduin = 0L;
  public int myAllowFlag = 0;
  public byte myfriendgroupid = 0;
  public String refuseReason = "";
  public byte refuseReasonLen = 0;
  public long uin = 0L;
  
  public AnswerAddedFriendReq() {}
  
  public AnswerAddedFriendReq(long paramLong1, long paramLong2, int paramInt, byte paramByte1, byte paramByte2, String paramString)
  {
    this.uin = paramLong1;
    this.adduin = paramLong2;
    this.myAllowFlag = paramInt;
    this.myfriendgroupid = paramByte1;
    this.refuseReasonLen = paramByte2;
    this.refuseReason = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.adduin = paramJceInputStream.read(this.adduin, 1, true);
    this.myAllowFlag = paramJceInputStream.read(this.myAllowFlag, 2, true);
    this.myfriendgroupid = paramJceInputStream.read(this.myfriendgroupid, 3, false);
    this.refuseReasonLen = paramJceInputStream.read(this.refuseReasonLen, 4, false);
    this.refuseReason = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.adduin, 1);
    paramJceOutputStream.write(this.myAllowFlag, 2);
    paramJceOutputStream.write(this.myfriendgroupid, 3);
    paramJceOutputStream.write(this.refuseReasonLen, 4);
    if (this.refuseReason != null) {
      paramJceOutputStream.write(this.refuseReason, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     friendlist.AnswerAddedFriendReq
 * JD-Core Version:    0.7.0.1
 */