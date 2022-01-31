package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetGrpMemberArch
  extends JceStruct
{
  static ReqHeader cache_stHeader;
  public int BeginSeq = 0;
  public long GrpId = 0L;
  public ReqHeader stHeader = null;
  
  public ReqGetGrpMemberArch() {}
  
  public ReqGetGrpMemberArch(ReqHeader paramReqHeader, long paramLong, int paramInt)
  {
    this.stHeader = paramReqHeader;
    this.GrpId = paramLong;
    this.BeginSeq = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    this.GrpId = paramJceInputStream.read(this.GrpId, 1, true);
    this.BeginSeq = paramJceInputStream.read(this.BeginSeq, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.GrpId, 1);
    paramJceOutputStream.write(this.BeginSeq, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ReqGetGrpMemberArch
 * JD-Core Version:    0.7.0.1
 */