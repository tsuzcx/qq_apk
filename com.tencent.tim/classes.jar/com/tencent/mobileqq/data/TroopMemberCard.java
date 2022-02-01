package com.tencent.mobileqq.data;

import com.tencent.mobileqq.richstatus.RichStatus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TroopMemberCard
  implements Serializable
{
  public static final long MEMBER_DISTANCE_DEFAULT = -1L;
  public static final long MEMBER_DISTANCE_UNKOWN = -1000L;
  private static final long serialVersionUID = 1L;
  public int age;
  public String card;
  public String colorCard;
  public int credit;
  public List<CustomEntry> customEntryList;
  public long distance = -1L;
  public int gbarCount;
  public String gbarLinkUrl;
  public List<GBarInfo> gbarList;
  public String gbarTitle;
  public String honorList;
  public boolean isAllowModCard;
  public boolean isConcerned;
  public boolean isFriend;
  public boolean isSuperQQ;
  public boolean isSuperVip;
  public boolean isVip;
  public boolean isYearVip;
  public long joinTime;
  public long lastSpeak;
  public String levelName;
  public String location;
  public ArrayList<String> mCurrAccountOrgIds = new ArrayList();
  public int mGroupType;
  public boolean mHasStory;
  public boolean mIsShield;
  public MemberGameInfo mMemberGameInfo;
  public ArrayList<String> mOrgIds = new ArrayList();
  public String mPosition;
  public String mQzoneFeed;
  public String mRecentSaied;
  public RichStatus mRichSignStatus;
  public ArrayList<StoryInfo> mStoryInfoList;
  public String mUniqueTitle;
  public int mUniqueTitleExpire;
  public int memberRole;
  public long memberUin;
  public String nick;
  public String phoneNumber;
  public int realLevel;
  public String remark;
  public int result;
  public int sex;
  public int titleId;
  public int vipLevel = 26;
  
  public static class CustomEntry
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public String info;
    public boolean isClickable;
    public String label;
    public String linkUrl;
    public long reportId;
  }
  
  public static class GBarInfo
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public int gbarId;
    public String headUrl;
    public int level;
    public String name;
  }
  
  public static class MemberGameInfo
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public ArrayList<String> descInfo;
    public String gameBackGroundColor;
    public String gameFontColor;
    public String gameName;
    public String gameUrl;
    public String levelIcon;
    public String levelName;
  }
  
  public static class StoryInfo
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public String mCoverUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopMemberCard
 * JD-Core Version:    0.7.0.1
 */