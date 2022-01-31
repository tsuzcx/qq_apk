package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetGrpOffLMsg
  extends JceStruct
{
  static ReqHeader cache_stHeader;
  public long GrpId = 0L;
  public int MsgNum = 0;
  public long OffMsgSeek = 0L;
  public ReqHeader stHeader = null;
  
  public ReqGetGrpOffLMsg() {}
  
  public ReqGetGrpOffLMsg(ReqHeader paramReqHeader, long paramLong1, int paramInt, long paramLong2)
  {
    this.stHeader = paramReqHeader;
    this.GrpId = paramLong1;
    this.MsgNum = paramInt;
    this.OffMsgSeek = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    this.GrpId = paramJceInputStream.read(this.GrpId, 1, true);
    this.MsgNum = paramJceInputStream.read(this.MsgNum, 2, true);
    this.OffMsgSeek = paramJceInputStream.read(this.OffMsgSeek, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.GrpId, 1);
    paramJceOutputStream.write(this.MsgNum, 2);
    paramJceOutputStream.write(this.OffMsgSeek, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ReqGetGrpOffLMsg
 * JD-Core Version:    0.7.0.1
 */