package PasserbySvc;

import NeighborComm.ReqHeader;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqCheckIn
  extends JceStruct
{
  static ReqHeader cache_stHeader;
  static ReqUserInfo cache_stUserInfo;
  public ReqHeader stHeader = null;
  public ReqUserInfo stUserInfo = null;
  
  public ReqCheckIn() {}
  
  public ReqCheckIn(ReqHeader paramReqHeader, ReqUserInfo paramReqUserInfo)
  {
    this.stHeader = paramReqHeader;
    this.stUserInfo = paramReqUserInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stUserInfo == null) {
      cache_stUserInfo = new ReqUserInfo();
    }
    this.stUserInfo = ((ReqUserInfo)paramJceInputStream.read(cache_stUserInfo, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.stUserInfo, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     PasserbySvc.ReqCheckIn
 * JD-Core Version:    0.7.0.1
 */