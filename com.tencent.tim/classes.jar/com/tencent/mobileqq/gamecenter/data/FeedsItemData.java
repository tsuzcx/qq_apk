package com.tencent.mobileqq.gamecenter.data;

import java.io.Serializable;
import java.util.List;

public class FeedsItemData
  implements Serializable
{
  public String algorithmId;
  public String authorIcon;
  public String authorName;
  public int commentNum;
  public String coverImgUrl;
  public String feedId;
  public List<FriendInfo> friendList;
  public int friendNum;
  public int friendType;
  public GameInfo gameInfo;
  public List<Gift> giftList;
  public String groupId = "";
  public String jumpUrl;
  public String label = "";
  public int miniType;
  public String msgId;
  public String operateText = "";
  public String rcmdReason = "";
  public String subTitle = "";
  public String title;
  public int type;
  public int videoDuration;
  public String videoSrcImg;
  public String videoSrcName;
  public int videoSrcType;
  public int videoType;
  public String videoUrl;
  public String videoVid;
  public int videoViewers;
  public int viewersNum;
  
  public static class FriendInfo
    implements Serializable
  {
    public String icon;
    public String jumpUrl;
    public long loginTime;
    public String name;
    public String partition;
    public String roleName;
    public String uin;
  }
  
  public static class GameInfo
    implements Serializable
  {
    public String gameApkUrl = "";
    public String gameAppId = "";
    public String gameIcon = "";
    public String gameName = "";
    public String gamePkgName = "";
    public int gamePkgSize;
    public int gameStatus;
    public String gameTicket = "";
    public String gameVersionCode = "";
  }
  
  public static class Gift
    implements Serializable
  {
    public String picture = "";
    public String text = "";
  }
  
  public static class LabelInfo
    implements Serializable
  {
    public String appId;
    public String desc;
    public List<FeedsItemData.FriendInfo> friendList;
    public int friendNum;
    public int friendType;
    public String iconUrl;
    public List<String> icons;
    public boolean isFriend;
    public String jumpUrl;
    public String msgId;
    public String name;
    public FeedsItemData.RedInfo redInfo;
    public String reportId;
    public boolean showFriend;
  }
  
  public static class RedInfo
    implements Serializable
  {
    public long redPointEndTime;
    public String redPointId;
    public long redPointStartTime;
  }
  
  public static class TopCardInfo
    implements Serializable
  {
    public String actionDesc;
    public long bannerBeginTime;
    public long bannerEndTime;
    public int bannerGap;
    public String bannerIconZip;
    public String bannerUrl;
    public int friendType;
    public FeedsItemData.GameInfo gameInfo;
    public List<FeedsItemData.LabelInfo> labelInfos;
    public String msgId;
    public List<String> priorities;
    public int prioritiesIconFlag;
    public boolean showTopCard;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.FeedsItemData
 * JD-Core Version:    0.7.0.1
 */