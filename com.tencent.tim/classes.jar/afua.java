import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.util.List;

public class afua
{
  public static final int FOOTER_TYPE_LOADING = 0;
  public static final int FOOTER_TYPE_LOAD_FAIL = 1;
  public static final int FOOTER_TYPE_LOAD_OVER = 2;
  public static final int TYPE_CAMPUS_VERIFY = 7;
  public static final int TYPE_EMTPY = 2;
  public static final int TYPE_FEED = 0;
  public static final int TYPE_FEED_ADV = 4;
  public static final int TYPE_FEED_BANNER = 6;
  public static final int TYPE_FOOTER = 1;
  public static final int TYPE_MINI_RECOMM = 5;
  public int clothesId;
  public int fontId;
  public int fontType;
  public boolean mAddFriendVerified;
  public int mAge;
  public AlumBasicData mAlumbasicdata;
  public int mAvailLikeCount;
  public boolean mBigVipHide;
  public int mBigVipLevel;
  public String mDeclaration;
  public int mFooterType;
  public int mGender;
  public boolean mIsMyFeed;
  public List<afua.a> mLabelInfos;
  public boolean mLiked;
  public String mNickName;
  public int mPopularity;
  public List<afua.b> mSchoolInfos;
  public String mStrRecomTrace;
  public int mTemplateId;
  public int mType;
  public String mUin;
  public boolean mVipHide;
  public int mVipLevel;
  public int mVipType;
  public int mVoiceDuration;
  public String mVoiceUrl;
  public boolean mbAllowStrangerVote;
  public byte[] voiceCode;
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof afua)) && (aqft.equalsWithNullCheck(((afua)paramObject).mUin, this.mUin));
  }
  
  public static class a
  {
    public long XM;
    public String labelName;
  }
  
  public static class b
  {
    public long authState;
    public String schoolId;
    public String schoolName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afua
 * JD-Core Version:    0.7.0.1
 */