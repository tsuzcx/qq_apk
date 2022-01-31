package PasserbySvc;

import NeighborComm.RespHeader;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetPasserbies
  extends JceStruct
{
  static RespHeader cache_stHeader;
  static UserDetailLocalInfo cache_stUDLinfo;
  static UserData cache_stUserData;
  static ArrayList cache_vPasserbyInfos;
  public long RespTime = 0L;
  public RespHeader stHeader = null;
  public UserDetailLocalInfo stUDLinfo = null;
  public UserData stUserData = null;
  public ArrayList vPasserbyInfos = null;
  
  public RespGetPasserbies() {}
  
  public RespGetPasserbies(RespHeader paramRespHeader, long paramLong, ArrayList paramArrayList, UserData paramUserData, UserDetailLocalInfo paramUserDetailLocalInfo)
  {
    this.stHeader = paramRespHeader;
    this.RespTime = paramLong;
    this.vPasserbyInfos = paramArrayList;
    this.stUserData = paramUserData;
    this.stUDLinfo = paramUserDetailLocalInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    this.RespTime = paramJceInputStream.read(this.RespTime, 1, true);
    if (cache_vPasserbyInfos == null)
    {
      cache_vPasserbyInfos = new ArrayList();
      RespPasserbyInfo localRespPasserbyInfo = new RespPasserbyInfo();
      cache_vPasserbyInfos.add(localRespPasserbyInfo);
    }
    this.vPasserbyInfos = ((ArrayList)paramJceInputStream.read(cache_vPasserbyInfos, 2, false));
    if (cache_stUserData == null) {
      cache_stUserData = new UserData();
    }
    this.stUserData = ((UserData)paramJceInputStream.read(cache_stUserData, 3, false));
    if (cache_stUDLinfo == null) {
      cache_stUDLinfo = new UserDetailLocalInfo();
    }
    this.stUDLinfo = ((UserDetailLocalInfo)paramJceInputStream.read(cache_stUDLinfo, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.RespTime, 1);
    if (this.vPasserbyInfos != null) {
      paramJceOutputStream.write(this.vPasserbyInfos, 2);
    }
    if (this.stUserData != null) {
      paramJceOutputStream.write(this.stUserData, 3);
    }
    if (this.stUDLinfo != null) {
      paramJceOutputStream.write(this.stUDLinfo, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     PasserbySvc.RespGetPasserbies
 * JD-Core Version:    0.7.0.1
 */