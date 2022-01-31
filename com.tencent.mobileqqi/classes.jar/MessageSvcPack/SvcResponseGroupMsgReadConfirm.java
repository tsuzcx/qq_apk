package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcResponseGroupMsgReadConfirm
  extends JceStruct
{
  public byte cReplyCode = 0;
  public String strResult = "";
  public long uGroupMsgSeq = 0L;
  public long uMemberSeq = 0L;
  
  public SvcResponseGroupMsgReadConfirm() {}
  
  public SvcResponseGroupMsgReadConfirm(byte paramByte, String paramString, long paramLong1, long paramLong2)
  {
    this.cReplyCode = paramByte;
    this.strResult = paramString;
    this.uMemberSeq = paramLong1;
    this.uGroupMsgSeq = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cReplyCode = paramJceInputStream.read(this.cReplyCode, 0, true);
    this.strResult = paramJceInputStream.readString(1, false);
    this.uMemberSeq = paramJceInputStream.read(this.uMemberSeq, 2, true);
    this.uGroupMsgSeq = paramJceInputStream.read(this.uGroupMsgSeq, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cReplyCode, 0);
    if (this.strResult != null) {
      paramJceOutputStream.write(this.strResult, 1);
    }
    paramJceOutputStream.write(this.uMemberSeq, 2);
    paramJceOutputStream.write(this.uGroupMsgSeq, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcResponseGroupMsgReadConfirm
 * JD-Core Version:    0.7.0.1
 */