package NS_QBOSS_GATEWAY_PROTO;

import BOSSStrategyCenter.tPullADVRequest;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class QbossGateWayReq
  extends JceStruct
{
  static Map<String, String> cache_mapExtInfo;
  static tPullADVRequest cache_stAdvReq = new tPullADVRequest();
  static LoginInfo cache_stLoginInfo = new LoginInfo();
  public int iAppID;
  public Map<String, String> mapExtInfo;
  public tPullADVRequest stAdvReq;
  public LoginInfo stLoginInfo;
  
  static
  {
    cache_mapExtInfo = new HashMap();
    cache_mapExtInfo.put("", "");
  }
  
  public QbossGateWayReq() {}
  
  public QbossGateWayReq(tPullADVRequest paramtPullADVRequest, LoginInfo paramLoginInfo, int paramInt, Map<String, String> paramMap)
  {
    this.stAdvReq = paramtPullADVRequest;
    this.stLoginInfo = paramLoginInfo;
    this.iAppID = paramInt;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stAdvReq = ((tPullADVRequest)paramJceInputStream.read(cache_stAdvReq, 0, true));
    this.stLoginInfo = ((LoginInfo)paramJceInputStream.read(cache_stLoginInfo, 1, false));
    this.iAppID = paramJceInputStream.read(this.iAppID, 2, false);
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stAdvReq, 0);
    if (this.stLoginInfo != null) {
      paramJceOutputStream.write(this.stLoginInfo, 1);
    }
    paramJceOutputStream.write(this.iAppID, 2);
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QBOSS_GATEWAY_PROTO.QbossGateWayReq
 * JD-Core Version:    0.7.0.1
 */