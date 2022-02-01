package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetFavoriteList
  extends JceStruct
{
  static RespHead cache_stHeader;
  static UserCntlData cache_stUserData;
  static ArrayList<UserProfile> cache_vFavoriteInfos;
  static byte[] cache_vNotice;
  public long RespTime;
  public RespHead stHeader;
  public UserCntlData stUserData;
  public ArrayList<UserProfile> vFavoriteInfos;
  public byte[] vNotice;
  
  public RespGetFavoriteList() {}
  
  public RespGetFavoriteList(RespHead paramRespHead, long paramLong, ArrayList<UserProfile> paramArrayList, UserCntlData paramUserCntlData, byte[] paramArrayOfByte)
  {
    this.stHeader = paramRespHead;
    this.RespTime = paramLong;
    this.vFavoriteInfos = paramArrayList;
    this.stUserData = paramUserCntlData;
    this.vNotice = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.RespTime = paramJceInputStream.read(this.RespTime, 1, true);
    if (cache_vFavoriteInfos == null)
    {
      cache_vFavoriteInfos = new ArrayList();
      UserProfile localUserProfile = new UserProfile();
      cache_vFavoriteInfos.add(localUserProfile);
    }
    this.vFavoriteInfos = ((ArrayList)paramJceInputStream.read(cache_vFavoriteInfos, 2, false));
    if (cache_stUserData == null) {
      cache_stUserData = new UserCntlData();
    }
    this.stUserData = ((UserCntlData)paramJceInputStream.read(cache_stUserData, 3, false));
    if (cache_vNotice == null)
    {
      cache_vNotice = (byte[])new byte[1];
      ((byte[])cache_vNotice)[0] = 0;
    }
    this.vNotice = ((byte[])paramJceInputStream.read(cache_vNotice, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.RespTime, 1);
    if (this.vFavoriteInfos != null) {
      paramJceOutputStream.write(this.vFavoriteInfos, 2);
    }
    if (this.stUserData != null) {
      paramJceOutputStream.write(this.stUserData, 3);
    }
    if (this.vNotice != null) {
      paramJceOutputStream.write(this.vNotice, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.RespGetFavoriteList
 * JD-Core Version:    0.7.0.1
 */