package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetGrpAlterInfo
  extends JceStruct
{
  static ReqHeader cache_stHeader;
  public int BeginSeq = 0;
  public ReqHeader stHeader = null;
  
  public ReqGetGrpAlterInfo() {}
  
  public ReqGetGrpAlterInfo(ReqHeader paramReqHeader, int paramInt)
  {
    this.stHeader = paramReqHeader;
    this.BeginSeq = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    this.BeginSeq = paramJceInputStream.read(this.BeginSeq, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.BeginSeq, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ReqGetGrpAlterInfo
 * JD-Core Version:    0.7.0.1
 */