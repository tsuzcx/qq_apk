package PasserbySvc;

import NeighborComm.ReqHeader;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetPasserbies
  extends JceStruct
{
  static ReqHeader cache_stHeader;
  static UserData cache_stUserData;
  public ReqHeader stHeader = null;
  public UserData stUserData = null;
  
  public ReqGetPasserbies() {}
  
  public ReqGetPasserbies(ReqHeader paramReqHeader, UserData paramUserData)
  {
    this.stHeader = paramReqHeader;
    this.stUserData = paramUserData;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stUserData == null) {
      cache_stUserData = new UserData();
    }
    this.stUserData = ((UserData)paramJceInputStream.read(cache_stUserData, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    if (this.stUserData != null) {
      paramJceOutputStream.write(this.stUserData, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     PasserbySvc.ReqGetPasserbies
 * JD-Core Version:    0.7.0.1
 */