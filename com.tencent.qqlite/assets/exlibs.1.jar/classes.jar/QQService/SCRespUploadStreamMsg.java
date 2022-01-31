package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SCRespUploadStreamMsg
  extends JceStruct
{
  static StreamInfo cache_stStreamInfo;
  public int iSeq = 0;
  public int result = 0;
  public int shMsgSeq = 0;
  public short shResetSeq = 0;
  public short shVersion = 0;
  public StreamInfo stStreamInfo = null;
  public long uDateTime = 0L;
  
  public SCRespUploadStreamMsg() {}
  
  public SCRespUploadStreamMsg(short paramShort1, int paramInt1, StreamInfo paramStreamInfo, short paramShort2, int paramInt2, long paramLong, int paramInt3)
  {
    this.shVersion = paramShort1;
    this.iSeq = paramInt1;
    this.stStreamInfo = paramStreamInfo;
    this.shResetSeq = paramShort2;
    this.shMsgSeq = paramInt2;
    this.uDateTime = paramLong;
    this.result = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.iSeq = paramJceInputStream.read(this.iSeq, 1, true);
    if (cache_stStreamInfo == null) {
      cache_stStreamInfo = new StreamInfo();
    }
    this.stStreamInfo = ((StreamInfo)paramJceInputStream.read(cache_stStreamInfo, 2, true));
    this.shResetSeq = paramJceInputStream.read(this.shResetSeq, 3, true);
    this.shMsgSeq = paramJceInputStream.read(this.shMsgSeq, 4, false);
    this.uDateTime = paramJceInputStream.read(this.uDateTime, 5, false);
    this.result = paramJceInputStream.read(this.result, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.iSeq, 1);
    paramJceOutputStream.write(this.stStreamInfo, 2);
    paramJceOutputStream.write(this.shResetSeq, 3);
    paramJceOutputStream.write(this.shMsgSeq, 4);
    paramJceOutputStream.write(this.uDateTime, 5);
    paramJceOutputStream.write(this.result, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.SCRespUploadStreamMsg
 * JD-Core Version:    0.7.0.1
 */