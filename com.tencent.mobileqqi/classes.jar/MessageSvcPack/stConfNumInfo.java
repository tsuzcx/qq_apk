package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stConfNumInfo
  extends JceStruct
{
  public long lConfUin = 0L;
  public long uConfMsgSeq = 0L;
  public long uMemberMsgSeq = 0L;
  
  public stConfNumInfo() {}
  
  public stConfNumInfo(long paramLong1, long paramLong2, long paramLong3)
  {
    this.lConfUin = paramLong1;
    this.uConfMsgSeq = paramLong2;
    this.uMemberMsgSeq = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lConfUin = paramJceInputStream.read(this.lConfUin, 0, true);
    this.uConfMsgSeq = paramJceInputStream.read(this.uConfMsgSeq, 1, true);
    this.uMemberMsgSeq = paramJceInputStream.read(this.uMemberMsgSeq, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lConfUin, 0);
    paramJceOutputStream.write(this.uConfMsgSeq, 1);
    paramJceOutputStream.write(this.uMemberMsgSeq, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     MessageSvcPack.stConfNumInfo
 * JD-Core Version:    0.7.0.1
 */