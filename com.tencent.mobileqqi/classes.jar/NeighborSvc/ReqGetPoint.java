package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetPoint
  extends JceStruct
{
  static ReqUserInfo cache_stUserInfo;
  public byte bGetCityId = 0;
  public byte bJiejingSOSO = 0;
  public ReqUserInfo stUserInfo = null;
  
  public ReqGetPoint() {}
  
  public ReqGetPoint(ReqUserInfo paramReqUserInfo, byte paramByte1, byte paramByte2)
  {
    this.stUserInfo = paramReqUserInfo;
    this.bJiejingSOSO = paramByte1;
    this.bGetCityId = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stUserInfo == null) {
      cache_stUserInfo = new ReqUserInfo();
    }
    this.stUserInfo = ((ReqUserInfo)paramJceInputStream.read(cache_stUserInfo, 0, true));
    this.bJiejingSOSO = paramJceInputStream.read(this.bJiejingSOSO, 1, false);
    this.bGetCityId = paramJceInputStream.read(this.bGetCityId, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stUserInfo, 0);
    paramJceOutputStream.write(this.bJiejingSOSO, 1);
    paramJceOutputStream.write(this.bGetCityId, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborSvc.ReqGetPoint
 * JD-Core Version:    0.7.0.1
 */