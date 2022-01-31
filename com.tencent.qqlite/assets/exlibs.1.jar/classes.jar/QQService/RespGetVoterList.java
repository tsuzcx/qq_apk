package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetVoterList
  extends JceStruct
{
  static RespHead cache_stHeader;
  static UserCntlData cache_stUserData;
  static ArrayList cache_vVoterInfos;
  public long RespTime = 0L;
  public RespHead stHeader = null;
  public UserCntlData stUserData = null;
  public ArrayList vVoterInfos = null;
  
  public RespGetVoterList() {}
  
  public RespGetVoterList(RespHead paramRespHead, long paramLong, ArrayList paramArrayList, UserCntlData paramUserCntlData)
  {
    this.stHeader = paramRespHead;
    this.RespTime = paramLong;
    this.vVoterInfos = paramArrayList;
    this.stUserData = paramUserCntlData;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.RespTime = paramJceInputStream.read(this.RespTime, 1, true);
    if (cache_vVoterInfos == null)
    {
      cache_vVoterInfos = new ArrayList();
      UserProfile localUserProfile = new UserProfile();
      cache_vVoterInfos.add(localUserProfile);
    }
    this.vVoterInfos = ((ArrayList)paramJceInputStream.read(cache_vVoterInfos, 2, false));
    if (cache_stUserData == null) {
      cache_stUserData = new UserCntlData();
    }
    this.stUserData = ((UserCntlData)paramJceInputStream.read(cache_stUserData, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.RespTime, 1);
    if (this.vVoterInfos != null) {
      paramJceOutputStream.write(this.vVoterInfos, 2);
    }
    if (this.stUserData != null) {
      paramJceOutputStream.write(this.stUserData, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.RespGetVoterList
 * JD-Core Version:    0.7.0.1
 */