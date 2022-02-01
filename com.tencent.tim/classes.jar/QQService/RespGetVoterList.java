package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetVoterList
  extends JceStruct
{
  static RespHead cache_stHeader = new RespHead();
  static UserCntlData cache_stUserData;
  static ArrayList<UserProfile> cache_vTodayFavoriteInfos;
  static ArrayList<UserProfile> cache_vVoterInfos = new ArrayList();
  public long RespTime;
  public int iMaxFriendFavoriteCount = 50;
  public int iMaxStrangerFavoriteCount = 50;
  public int iTodayVoteCount;
  public int iTodayVoteRank = -1;
  public int iTotalVoteCount;
  public RespHead stHeader;
  public UserCntlData stUserData;
  public ArrayList<UserProfile> vTodayFavoriteInfos;
  public ArrayList<UserProfile> vVoterInfos;
  
  static
  {
    UserProfile localUserProfile = new UserProfile();
    cache_vVoterInfos.add(localUserProfile);
    cache_stUserData = new UserCntlData();
    cache_vTodayFavoriteInfos = new ArrayList();
    localUserProfile = new UserProfile();
    cache_vTodayFavoriteInfos.add(localUserProfile);
  }
  
  public RespGetVoterList() {}
  
  public RespGetVoterList(RespHead paramRespHead, long paramLong, ArrayList<UserProfile> paramArrayList1, UserCntlData paramUserCntlData, ArrayList<UserProfile> paramArrayList2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.stHeader = paramRespHead;
    this.RespTime = paramLong;
    this.vVoterInfos = paramArrayList1;
    this.stUserData = paramUserCntlData;
    this.vTodayFavoriteInfos = paramArrayList2;
    this.iMaxFriendFavoriteCount = paramInt1;
    this.iMaxStrangerFavoriteCount = paramInt2;
    this.iTodayVoteCount = paramInt3;
    this.iTodayVoteRank = paramInt4;
    this.iTotalVoteCount = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.RespTime = paramJceInputStream.read(this.RespTime, 1, true);
    this.vVoterInfos = ((ArrayList)paramJceInputStream.read(cache_vVoterInfos, 2, false));
    this.stUserData = ((UserCntlData)paramJceInputStream.read(cache_stUserData, 3, false));
    this.vTodayFavoriteInfos = ((ArrayList)paramJceInputStream.read(cache_vTodayFavoriteInfos, 4, false));
    this.iMaxFriendFavoriteCount = paramJceInputStream.read(this.iMaxFriendFavoriteCount, 5, false);
    this.iMaxStrangerFavoriteCount = paramJceInputStream.read(this.iMaxStrangerFavoriteCount, 6, false);
    this.iTodayVoteCount = paramJceInputStream.read(this.iTodayVoteCount, 7, false);
    this.iTodayVoteRank = paramJceInputStream.read(this.iTodayVoteRank, 8, false);
    this.iTotalVoteCount = paramJceInputStream.read(this.iTotalVoteCount, 9, false);
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
    if (this.vTodayFavoriteInfos != null) {
      paramJceOutputStream.write(this.vTodayFavoriteInfos, 4);
    }
    paramJceOutputStream.write(this.iMaxFriendFavoriteCount, 5);
    paramJceOutputStream.write(this.iMaxStrangerFavoriteCount, 6);
    paramJceOutputStream.write(this.iTodayVoteCount, 7);
    paramJceOutputStream.write(this.iTodayVoteRank, 8);
    paramJceOutputStream.write(this.iTotalVoteCount, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.RespGetVoterList
 * JD-Core Version:    0.7.0.1
 */