package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetGrpList
  extends JceStruct
{
  static ReqHeader cache_stHeader;
  public ReqHeader stHeader = null;
  
  public ReqGetGrpList() {}
  
  public ReqGetGrpList(ReqHeader paramReqHeader)
  {
    this.stHeader = paramReqHeader;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ReqGetGrpList
 * JD-Core Version:    0.7.0.1
 */