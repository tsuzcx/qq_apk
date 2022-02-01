package SummaryCard;

import QQService.PrivilegeBaseInfo;
import QQService.VipBaseInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class RespSummaryCard
  extends JceStruct
{
  static int cache_eAddOption;
  static Map<String, String> cache_mapQzoneEx;
  static AlbumInfo cache_oLatestPhotos = new AlbumInfo();
  static AddFrdSrcInfo cache_stAddFrdSrcInfo;
  static QQApolloInfo cache_stApollo;
  static BindPhoneInfo cache_stBindPhoneInfo;
  static TCampusCircleInfo cache_stCampusCircleInfo;
  static TCoverInfo cache_stCoverInfo;
  static DateCard cache_stDateCard;
  static VipBaseInfo cache_stDiamonds;
  static TEIMInfo cache_stEimInfo;
  static GiftInfo cache_stGiftInfo;
  static HeartInfo cache_stHeartInfo;
  static InterestTagInfo cache_stInterestTag;
  static TMedalWallInfo cache_stMedalWallInfo;
  static TNearbyGodInfo cache_stNearbyGodInfo;
  static TNowBroadcastInfo cache_stNowBroadcastInfo;
  static OlympicInfo cache_stOlympicInfo;
  static PanSocialInfo cache_stPanSocialInfo;
  static PrivilegeBaseInfo cache_stPrivInfo;
  static QCallInfo cache_stQCallInfo;
  static TQimInfo cache_stQimInfo;
  static QiqiVideoInfo cache_stQiqiVideoInfo;
  static TTimInfo cache_stTimInfo;
  static UserFeed cache_stUserFeed;
  static TVideoHeadInfo cache_stVideoHeadInfo;
  static QQVideoInfo cache_stVideoInfo;
  static VipBaseInfo cache_stVipInfo;
  static VoiceInfo cache_stVoiceInfo;
  static WeishiInfo cache_stWeishiInfo;
  static ArrayList<String> cache_vAddQuestion;
  static byte[] cache_vCommLabel;
  static byte[] cache_vExtendCard;
  static byte[] cache_vHotChatInfo;
  static byte[] cache_vLongNickTopicInfo;
  static byte[] cache_vNearbyTaskInfo;
  static byte[] cache_vNowInfo;
  static ArrayList<TPraiseInfo> cache_vPraiseList;
  static byte[] cache_vQzoneCoverInfo;
  static byte[] cache_vResp0x5ebInfo;
  static byte[] cache_vRespCustomLabelInfo;
  static byte[] cache_vRespKandianInfo;
  static byte[] cache_vRespLastGameInfo;
  static byte[] cache_vRespQQStoryInfo;
  static byte[] cache_vRespStarInfo;
  static byte[] cache_vRespTemplateInfo;
  static byte[] cache_vRichSign;
  static byte[] cache_vSeed;
  static byte[] cache_vTempChatSig;
  static byte[] cache_vVisitingCardInfo;
  static ArrayList<byte[]> cache_vvRespServices;
  static ArrayList<byte[]> cache_vvRespServicesBigOrder;
  public byte bAge;
  public short bAvailVoteCnt;
  public short bHaveVotedCnt;
  public byte bSex;
  public byte bValid4Vote;
  public int eAddOption = 101;
  public int i0x6d4Success;
  public int iBirthday;
  public int iContactNotBindQQ;
  public int iFace;
  public int iLastestVoteCount;
  public int iLevel;
  public int iPhotoCount;
  public int iVoteCount;
  public long lCacheControl;
  public long lUIN;
  public long lUserFlag;
  public Map<String, String> mapQzoneEx;
  public AlbumInfo oLatestPhotos;
  public AddFrdSrcInfo stAddFrdSrcInfo;
  public QQApolloInfo stApollo;
  public BindPhoneInfo stBindPhoneInfo;
  public TCampusCircleInfo stCampusCircleInfo;
  public TCoverInfo stCoverInfo;
  public DateCard stDateCard;
  public VipBaseInfo stDiamonds;
  public TEIMInfo stEimInfo;
  public GiftInfo stGiftInfo;
  public HeartInfo stHeartInfo;
  public InterestTagInfo stInterestTag;
  public TMedalWallInfo stMedalWallInfo;
  public TNearbyGodInfo stNearbyGodInfo;
  public TNowBroadcastInfo stNowBroadcastInfo;
  public OlympicInfo stOlympicInfo;
  public PanSocialInfo stPanSocialInfo;
  public PrivilegeBaseInfo stPrivInfo;
  public QCallInfo stQCallInfo;
  public TQimInfo stQimInfo;
  public QiqiVideoInfo stQiqiVideoInfo;
  public TTimInfo stTimInfo;
  public UserFeed stUserFeed;
  public TVideoHeadInfo stVideoHeadInfo;
  public QQVideoInfo stVideoInfo;
  public VipBaseInfo stVipInfo;
  public VoiceInfo stVoiceInfo;
  public WeishiInfo stWeishiInfo;
  public String strAutoRemark = "";
  public String strCity = "";
  public String strContactName = "";
  public String strCountry = "";
  public String strDiscussName = "";
  public String strEIMBindPhoneNum = "";
  public String strEIMId = "";
  public String strEmail = "";
  public String strGroupName = "";
  public String strGroupNick = "";
  public String strLoginDesc = "";
  public String strMobile = "";
  public String strNick = "";
  public String strPersonal = "";
  public String strProvince = "";
  public String strQzoneFeedsDesc = "";
  public String strQzoneHeader = "";
  public String strRemark = "";
  public String strRespMusicInfo = "";
  public String strShowName = "";
  public String strSign = "";
  public String strSpaceName = "";
  public String strStatus = "";
  public String strVoteLimitedNotice = "";
  public long uAccelerateMultiple;
  public long uCareer;
  public long uCurMulType;
  public long uFriendGroupId;
  public long uLoginDays;
  public long uQQMasterLoginDays = 20L;
  public long uRichCardNameVer;
  public long uSignModifyTime;
  public long uTemplateId;
  public long ulFaceAddonId;
  public long ulShowControl;
  public ArrayList<String> vAddQuestion;
  public byte[] vCommLabel;
  public byte[] vExtendCard;
  public byte[] vHotChatInfo;
  public byte[] vLongNickTopicInfo;
  public byte[] vNearbyTaskInfo;
  public byte[] vNowInfo;
  public ArrayList<TPraiseInfo> vPraiseList;
  public byte[] vQzoneCoverInfo;
  public byte[] vResp0x5ebInfo;
  public byte[] vRespCustomLabelInfo;
  public byte[] vRespKandianInfo;
  public byte[] vRespLastGameInfo;
  public byte[] vRespQQStoryInfo;
  public byte[] vRespStarInfo;
  public byte[] vRespTemplateInfo;
  public byte[] vRichSign;
  public byte[] vSeed;
  public byte[] vTempChatSig;
  public byte[] vVisitingCardInfo;
  public ArrayList<byte[]> vvRespServices;
  public ArrayList<byte[]> vvRespServicesBigOrder;
  
  static
  {
    cache_eAddOption = 0;
    cache_vAddQuestion = new ArrayList();
    cache_vAddQuestion.add("");
    cache_vSeed = (byte[])new byte[1];
    ((byte[])cache_vSeed)[0] = 0;
    cache_stVipInfo = new VipBaseInfo();
    cache_stVoiceInfo = new VoiceInfo();
    cache_vRichSign = (byte[])new byte[1];
    ((byte[])cache_vRichSign)[0] = 0;
    cache_vRespLastGameInfo = (byte[])new byte[1];
    ((byte[])cache_vRespLastGameInfo)[0] = 0;
    cache_vRespTemplateInfo = (byte[])new byte[1];
    ((byte[])cache_vRespTemplateInfo)[0] = 0;
    cache_vRespStarInfo = (byte[])new byte[1];
    ((byte[])cache_vRespStarInfo)[0] = 0;
    cache_stDiamonds = new VipBaseInfo();
    cache_vvRespServices = new ArrayList();
    Object localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_vvRespServices.add(localObject);
    cache_stDateCard = new DateCard();
    cache_stQCallInfo = new QCallInfo();
    cache_stGiftInfo = new GiftInfo();
    cache_stPanSocialInfo = new PanSocialInfo();
    cache_stVideoInfo = new QQVideoInfo();
    cache_vTempChatSig = (byte[])new byte[1];
    ((byte[])cache_vTempChatSig)[0] = 0;
    cache_stInterestTag = new InterestTagInfo();
    cache_stUserFeed = new UserFeed();
    cache_stQiqiVideoInfo = new QiqiVideoInfo();
    cache_stPrivInfo = new PrivilegeBaseInfo();
    cache_stApollo = new QQApolloInfo();
    cache_stAddFrdSrcInfo = new AddFrdSrcInfo();
    cache_stBindPhoneInfo = new BindPhoneInfo();
    cache_vVisitingCardInfo = (byte[])new byte[1];
    ((byte[])cache_vVisitingCardInfo)[0] = 0;
    cache_vHotChatInfo = (byte[])new byte[1];
    ((byte[])cache_vHotChatInfo)[0] = 0;
    cache_stOlympicInfo = new OlympicInfo();
    cache_stCoverInfo = new TCoverInfo();
    cache_stNowBroadcastInfo = new TNowBroadcastInfo();
    cache_stEimInfo = new TEIMInfo();
    cache_stVideoHeadInfo = new TVideoHeadInfo();
    cache_stMedalWallInfo = new TMedalWallInfo();
    cache_vvRespServicesBigOrder = new ArrayList();
    localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_vvRespServicesBigOrder.add(localObject);
    cache_vResp0x5ebInfo = (byte[])new byte[1];
    ((byte[])cache_vResp0x5ebInfo)[0] = 0;
    cache_stNearbyGodInfo = new TNearbyGodInfo();
    cache_vRespQQStoryInfo = (byte[])new byte[1];
    ((byte[])cache_vRespQQStoryInfo)[0] = 0;
    cache_vRespCustomLabelInfo = (byte[])new byte[1];
    ((byte[])cache_vRespCustomLabelInfo)[0] = 0;
    cache_vPraiseList = new ArrayList();
    localObject = new TPraiseInfo();
    cache_vPraiseList.add(localObject);
    cache_stCampusCircleInfo = new TCampusCircleInfo();
    cache_stTimInfo = new TTimInfo();
    cache_stQimInfo = new TQimInfo();
    cache_stHeartInfo = new HeartInfo();
    cache_vQzoneCoverInfo = (byte[])new byte[1];
    ((byte[])cache_vQzoneCoverInfo)[0] = 0;
    cache_vNearbyTaskInfo = (byte[])new byte[1];
    ((byte[])cache_vNearbyTaskInfo)[0] = 0;
    cache_vNowInfo = (byte[])new byte[1];
    ((byte[])cache_vNowInfo)[0] = 0;
    cache_vCommLabel = (byte[])new byte[1];
    ((byte[])cache_vCommLabel)[0] = 0;
    cache_vExtendCard = (byte[])new byte[1];
    ((byte[])cache_vExtendCard)[0] = 0;
    cache_mapQzoneEx = new HashMap();
    cache_mapQzoneEx.put("", "");
    cache_vRespKandianInfo = (byte[])new byte[1];
    ((byte[])cache_vRespKandianInfo)[0] = 0;
    cache_stWeishiInfo = new WeishiInfo();
    cache_vLongNickTopicInfo = (byte[])new byte[1];
    ((byte[])cache_vLongNickTopicInfo)[0] = 0;
  }
  
  public RespSummaryCard() {}
  
  public RespSummaryCard(int paramInt1, byte paramByte1, byte paramByte2, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, long paramLong1, String paramString10, AlbumInfo paramAlbumInfo, int paramInt3, int paramInt4, byte paramByte3, String paramString11, String paramString12, String paramString13, long paramLong2, long paramLong3, int paramInt5, int paramInt6, ArrayList<String> paramArrayList, byte[] paramArrayOfByte1, String paramString14, VipBaseInfo paramVipBaseInfo1, String paramString15, VoiceInfo paramVoiceInfo, byte[] paramArrayOfByte2, long paramLong4, byte[] paramArrayOfByte3, long paramLong5, long paramLong6, String paramString16, long paramLong7, long paramLong8, long paramLong9, byte[] paramArrayOfByte4, String paramString17, byte[] paramArrayOfByte5, VipBaseInfo paramVipBaseInfo2, long paramLong10, ArrayList<byte[]> paramArrayList1, String paramString18, DateCard paramDateCard, int paramInt7, QCallInfo paramQCallInfo, GiftInfo paramGiftInfo, PanSocialInfo paramPanSocialInfo, QQVideoInfo paramQQVideoInfo, byte[] paramArrayOfByte6, InterestTagInfo paramInterestTagInfo, UserFeed paramUserFeed, QiqiVideoInfo paramQiqiVideoInfo, PrivilegeBaseInfo paramPrivilegeBaseInfo, QQApolloInfo paramQQApolloInfo, AddFrdSrcInfo paramAddFrdSrcInfo, BindPhoneInfo paramBindPhoneInfo, byte[] paramArrayOfByte7, String paramString19, short paramShort1, short paramShort2, String paramString20, String paramString21, String paramString22, long paramLong11, String paramString23, byte[] paramArrayOfByte8, OlympicInfo paramOlympicInfo, TCoverInfo paramTCoverInfo, TNowBroadcastInfo paramTNowBroadcastInfo, TEIMInfo paramTEIMInfo, TVideoHeadInfo paramTVideoHeadInfo, int paramInt8, TMedalWallInfo paramTMedalWallInfo, ArrayList<byte[]> paramArrayList2, byte[] paramArrayOfByte9, TNearbyGodInfo paramTNearbyGodInfo, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, ArrayList<TPraiseInfo> paramArrayList3, TCampusCircleInfo paramTCampusCircleInfo, TTimInfo paramTTimInfo, TQimInfo paramTQimInfo, HeartInfo paramHeartInfo, byte[] paramArrayOfByte12, byte[] paramArrayOfByte13, byte[] paramArrayOfByte14, long paramLong12, byte[] paramArrayOfByte15, byte[] paramArrayOfByte16, String paramString24, Map<String, String> paramMap, byte[] paramArrayOfByte17, WeishiInfo paramWeishiInfo, long paramLong13, long paramLong14, byte[] paramArrayOfByte18, int paramInt9)
  {
    this.iFace = paramInt1;
    this.bSex = paramByte1;
    this.bAge = paramByte2;
    this.strNick = paramString1;
    this.strRemark = paramString2;
    this.iLevel = paramInt2;
    this.strProvince = paramString3;
    this.strCity = paramString4;
    this.strSign = paramString5;
    this.strGroupName = paramString6;
    this.strGroupNick = paramString7;
    this.strMobile = paramString8;
    this.strContactName = paramString9;
    this.ulShowControl = paramLong1;
    this.strQzoneFeedsDesc = paramString10;
    this.oLatestPhotos = paramAlbumInfo;
    this.iVoteCount = paramInt3;
    this.iLastestVoteCount = paramInt4;
    this.bValid4Vote = paramByte3;
    this.strCountry = paramString11;
    this.strStatus = paramString12;
    this.strAutoRemark = paramString13;
    this.lCacheControl = paramLong2;
    this.lUIN = paramLong3;
    this.iPhotoCount = paramInt5;
    this.eAddOption = paramInt6;
    this.vAddQuestion = paramArrayList;
    this.vSeed = paramArrayOfByte1;
    this.strDiscussName = paramString14;
    this.stVipInfo = paramVipBaseInfo1;
    this.strShowName = paramString15;
    this.stVoiceInfo = paramVoiceInfo;
    this.vRichSign = paramArrayOfByte2;
    this.uSignModifyTime = paramLong4;
    this.vRespLastGameInfo = paramArrayOfByte3;
    this.lUserFlag = paramLong5;
    this.uLoginDays = paramLong6;
    this.strLoginDesc = paramString16;
    this.uTemplateId = paramLong7;
    this.uQQMasterLoginDays = paramLong8;
    this.ulFaceAddonId = paramLong9;
    this.vRespTemplateInfo = paramArrayOfByte4;
    this.strRespMusicInfo = paramString17;
    this.vRespStarInfo = paramArrayOfByte5;
    this.stDiamonds = paramVipBaseInfo2;
    this.uAccelerateMultiple = paramLong10;
    this.vvRespServices = paramArrayList1;
    this.strSpaceName = paramString18;
    this.stDateCard = paramDateCard;
    this.iBirthday = paramInt7;
    this.stQCallInfo = paramQCallInfo;
    this.stGiftInfo = paramGiftInfo;
    this.stPanSocialInfo = paramPanSocialInfo;
    this.stVideoInfo = paramQQVideoInfo;
    this.vTempChatSig = paramArrayOfByte6;
    this.stInterestTag = paramInterestTagInfo;
    this.stUserFeed = paramUserFeed;
    this.stQiqiVideoInfo = paramQiqiVideoInfo;
    this.stPrivInfo = paramPrivilegeBaseInfo;
    this.stApollo = paramQQApolloInfo;
    this.stAddFrdSrcInfo = paramAddFrdSrcInfo;
    this.stBindPhoneInfo = paramBindPhoneInfo;
    this.vVisitingCardInfo = paramArrayOfByte7;
    this.strVoteLimitedNotice = paramString19;
    this.bHaveVotedCnt = paramShort1;
    this.bAvailVoteCnt = paramShort2;
    this.strEIMBindPhoneNum = paramString20;
    this.strEIMId = paramString21;
    this.strEmail = paramString22;
    this.uCareer = paramLong11;
    this.strPersonal = paramString23;
    this.vHotChatInfo = paramArrayOfByte8;
    this.stOlympicInfo = paramOlympicInfo;
    this.stCoverInfo = paramTCoverInfo;
    this.stNowBroadcastInfo = paramTNowBroadcastInfo;
    this.stEimInfo = paramTEIMInfo;
    this.stVideoHeadInfo = paramTVideoHeadInfo;
    this.iContactNotBindQQ = paramInt8;
    this.stMedalWallInfo = paramTMedalWallInfo;
    this.vvRespServicesBigOrder = paramArrayList2;
    this.vResp0x5ebInfo = paramArrayOfByte9;
    this.stNearbyGodInfo = paramTNearbyGodInfo;
    this.vRespQQStoryInfo = paramArrayOfByte10;
    this.vRespCustomLabelInfo = paramArrayOfByte11;
    this.vPraiseList = paramArrayList3;
    this.stCampusCircleInfo = paramTCampusCircleInfo;
    this.stTimInfo = paramTTimInfo;
    this.stQimInfo = paramTQimInfo;
    this.stHeartInfo = paramHeartInfo;
    this.vQzoneCoverInfo = paramArrayOfByte12;
    this.vNearbyTaskInfo = paramArrayOfByte13;
    this.vNowInfo = paramArrayOfByte14;
    this.uFriendGroupId = paramLong12;
    this.vCommLabel = paramArrayOfByte15;
    this.vExtendCard = paramArrayOfByte16;
    this.strQzoneHeader = paramString24;
    this.mapQzoneEx = paramMap;
    this.vRespKandianInfo = paramArrayOfByte17;
    this.stWeishiInfo = paramWeishiInfo;
    this.uRichCardNameVer = paramLong13;
    this.uCurMulType = paramLong14;
    this.vLongNickTopicInfo = paramArrayOfByte18;
    this.i0x6d4Success = paramInt9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iFace = paramJceInputStream.read(this.iFace, 0, false);
    this.bSex = paramJceInputStream.read(this.bSex, 1, false);
    this.bAge = paramJceInputStream.read(this.bAge, 2, false);
    this.strNick = paramJceInputStream.readString(3, false);
    this.strRemark = paramJceInputStream.readString(4, false);
    this.iLevel = paramJceInputStream.read(this.iLevel, 5, false);
    this.strProvince = paramJceInputStream.readString(6, false);
    this.strCity = paramJceInputStream.readString(7, false);
    this.strSign = paramJceInputStream.readString(8, false);
    this.strGroupName = paramJceInputStream.readString(9, false);
    this.strGroupNick = paramJceInputStream.readString(10, false);
    this.strMobile = paramJceInputStream.readString(11, false);
    this.strContactName = paramJceInputStream.readString(12, false);
    this.ulShowControl = paramJceInputStream.read(this.ulShowControl, 13, false);
    this.strQzoneFeedsDesc = paramJceInputStream.readString(14, false);
    this.oLatestPhotos = ((AlbumInfo)paramJceInputStream.read(cache_oLatestPhotos, 15, false));
    this.iVoteCount = paramJceInputStream.read(this.iVoteCount, 16, false);
    this.iLastestVoteCount = paramJceInputStream.read(this.iLastestVoteCount, 17, false);
    this.bValid4Vote = paramJceInputStream.read(this.bValid4Vote, 18, false);
    this.strCountry = paramJceInputStream.readString(19, false);
    this.strStatus = paramJceInputStream.readString(20, false);
    this.strAutoRemark = paramJceInputStream.readString(21, false);
    this.lCacheControl = paramJceInputStream.read(this.lCacheControl, 22, false);
    this.lUIN = paramJceInputStream.read(this.lUIN, 23, false);
    this.iPhotoCount = paramJceInputStream.read(this.iPhotoCount, 24, false);
    this.eAddOption = paramJceInputStream.read(this.eAddOption, 25, false);
    this.vAddQuestion = ((ArrayList)paramJceInputStream.read(cache_vAddQuestion, 26, false));
    this.vSeed = ((byte[])paramJceInputStream.read(cache_vSeed, 27, false));
    this.strDiscussName = paramJceInputStream.readString(28, false);
    this.stVipInfo = ((VipBaseInfo)paramJceInputStream.read(cache_stVipInfo, 29, false));
    this.strShowName = paramJceInputStream.readString(30, false);
    this.stVoiceInfo = ((VoiceInfo)paramJceInputStream.read(cache_stVoiceInfo, 31, false));
    this.vRichSign = ((byte[])paramJceInputStream.read(cache_vRichSign, 32, false));
    this.uSignModifyTime = paramJceInputStream.read(this.uSignModifyTime, 33, false);
    this.vRespLastGameInfo = ((byte[])paramJceInputStream.read(cache_vRespLastGameInfo, 34, false));
    this.lUserFlag = paramJceInputStream.read(this.lUserFlag, 35, false);
    this.uLoginDays = paramJceInputStream.read(this.uLoginDays, 36, false);
    this.strLoginDesc = paramJceInputStream.readString(37, false);
    this.uTemplateId = paramJceInputStream.read(this.uTemplateId, 38, false);
    this.uQQMasterLoginDays = paramJceInputStream.read(this.uQQMasterLoginDays, 39, false);
    this.ulFaceAddonId = paramJceInputStream.read(this.ulFaceAddonId, 40, false);
    this.vRespTemplateInfo = ((byte[])paramJceInputStream.read(cache_vRespTemplateInfo, 41, false));
    this.strRespMusicInfo = paramJceInputStream.readString(42, false);
    this.vRespStarInfo = ((byte[])paramJceInputStream.read(cache_vRespStarInfo, 43, false));
    this.stDiamonds = ((VipBaseInfo)paramJceInputStream.read(cache_stDiamonds, 44, false));
    this.uAccelerateMultiple = paramJceInputStream.read(this.uAccelerateMultiple, 45, false);
    this.vvRespServices = ((ArrayList)paramJceInputStream.read(cache_vvRespServices, 46, false));
    this.strSpaceName = paramJceInputStream.readString(47, false);
    this.stDateCard = ((DateCard)paramJceInputStream.read(cache_stDateCard, 48, false));
    this.iBirthday = paramJceInputStream.read(this.iBirthday, 49, false);
    this.stQCallInfo = ((QCallInfo)paramJceInputStream.read(cache_stQCallInfo, 50, false));
    this.stGiftInfo = ((GiftInfo)paramJceInputStream.read(cache_stGiftInfo, 51, false));
    this.stPanSocialInfo = ((PanSocialInfo)paramJceInputStream.read(cache_stPanSocialInfo, 52, false));
    this.stVideoInfo = ((QQVideoInfo)paramJceInputStream.read(cache_stVideoInfo, 53, false));
    this.vTempChatSig = ((byte[])paramJceInputStream.read(cache_vTempChatSig, 54, false));
    this.stInterestTag = ((InterestTagInfo)paramJceInputStream.read(cache_stInterestTag, 55, false));
    this.stUserFeed = ((UserFeed)paramJceInputStream.read(cache_stUserFeed, 56, false));
    this.stQiqiVideoInfo = ((QiqiVideoInfo)paramJceInputStream.read(cache_stQiqiVideoInfo, 57, false));
    this.stPrivInfo = ((PrivilegeBaseInfo)paramJceInputStream.read(cache_stPrivInfo, 58, false));
    this.stApollo = ((QQApolloInfo)paramJceInputStream.read(cache_stApollo, 59, false));
    this.stAddFrdSrcInfo = ((AddFrdSrcInfo)paramJceInputStream.read(cache_stAddFrdSrcInfo, 60, false));
    this.stBindPhoneInfo = ((BindPhoneInfo)paramJceInputStream.read(cache_stBindPhoneInfo, 61, false));
    this.vVisitingCardInfo = ((byte[])paramJceInputStream.read(cache_vVisitingCardInfo, 62, false));
    this.strVoteLimitedNotice = paramJceInputStream.readString(63, false);
    this.bHaveVotedCnt = paramJceInputStream.read(this.bHaveVotedCnt, 64, false);
    this.bAvailVoteCnt = paramJceInputStream.read(this.bAvailVoteCnt, 65, false);
    this.strEIMBindPhoneNum = paramJceInputStream.readString(66, false);
    this.strEIMId = paramJceInputStream.readString(67, false);
    this.strEmail = paramJceInputStream.readString(68, false);
    this.uCareer = paramJceInputStream.read(this.uCareer, 69, false);
    this.strPersonal = paramJceInputStream.readString(70, false);
    this.vHotChatInfo = ((byte[])paramJceInputStream.read(cache_vHotChatInfo, 71, false));
    this.stOlympicInfo = ((OlympicInfo)paramJceInputStream.read(cache_stOlympicInfo, 72, false));
    this.stCoverInfo = ((TCoverInfo)paramJceInputStream.read(cache_stCoverInfo, 73, false));
    this.stNowBroadcastInfo = ((TNowBroadcastInfo)paramJceInputStream.read(cache_stNowBroadcastInfo, 74, false));
    this.stEimInfo = ((TEIMInfo)paramJceInputStream.read(cache_stEimInfo, 75, false));
    this.stVideoHeadInfo = ((TVideoHeadInfo)paramJceInputStream.read(cache_stVideoHeadInfo, 78, false));
    this.iContactNotBindQQ = paramJceInputStream.read(this.iContactNotBindQQ, 79, false);
    this.stMedalWallInfo = ((TMedalWallInfo)paramJceInputStream.read(cache_stMedalWallInfo, 80, false));
    this.vvRespServicesBigOrder = ((ArrayList)paramJceInputStream.read(cache_vvRespServicesBigOrder, 81, false));
    this.vResp0x5ebInfo = ((byte[])paramJceInputStream.read(cache_vResp0x5ebInfo, 82, false));
    this.stNearbyGodInfo = ((TNearbyGodInfo)paramJceInputStream.read(cache_stNearbyGodInfo, 83, false));
    this.vRespQQStoryInfo = ((byte[])paramJceInputStream.read(cache_vRespQQStoryInfo, 84, false));
    this.vRespCustomLabelInfo = ((byte[])paramJceInputStream.read(cache_vRespCustomLabelInfo, 85, false));
    this.vPraiseList = ((ArrayList)paramJceInputStream.read(cache_vPraiseList, 86, false));
    this.stCampusCircleInfo = ((TCampusCircleInfo)paramJceInputStream.read(cache_stCampusCircleInfo, 87, false));
    this.stTimInfo = ((TTimInfo)paramJceInputStream.read(cache_stTimInfo, 88, false));
    this.stQimInfo = ((TQimInfo)paramJceInputStream.read(cache_stQimInfo, 89, false));
    this.stHeartInfo = ((HeartInfo)paramJceInputStream.read(cache_stHeartInfo, 90, false));
    this.vQzoneCoverInfo = ((byte[])paramJceInputStream.read(cache_vQzoneCoverInfo, 91, false));
    this.vNearbyTaskInfo = ((byte[])paramJceInputStream.read(cache_vNearbyTaskInfo, 92, false));
    this.vNowInfo = ((byte[])paramJceInputStream.read(cache_vNowInfo, 93, false));
    this.uFriendGroupId = paramJceInputStream.read(this.uFriendGroupId, 94, false);
    this.vCommLabel = ((byte[])paramJceInputStream.read(cache_vCommLabel, 95, false));
    this.vExtendCard = ((byte[])paramJceInputStream.read(cache_vExtendCard, 96, false));
    this.strQzoneHeader = paramJceInputStream.readString(97, false);
    this.mapQzoneEx = ((Map)paramJceInputStream.read(cache_mapQzoneEx, 98, false));
    this.vRespKandianInfo = ((byte[])paramJceInputStream.read(cache_vRespKandianInfo, 99, false));
    this.stWeishiInfo = ((WeishiInfo)paramJceInputStream.read(cache_stWeishiInfo, 100, false));
    this.uRichCardNameVer = paramJceInputStream.read(this.uRichCardNameVer, 101, false);
    this.uCurMulType = paramJceInputStream.read(this.uCurMulType, 102, false);
    this.vLongNickTopicInfo = ((byte[])paramJceInputStream.read(cache_vLongNickTopicInfo, 103, false));
    this.i0x6d4Success = paramJceInputStream.read(this.i0x6d4Success, 104, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iFace, 0);
    paramJceOutputStream.write(this.bSex, 1);
    paramJceOutputStream.write(this.bAge, 2);
    if (this.strNick != null) {
      paramJceOutputStream.write(this.strNick, 3);
    }
    if (this.strRemark != null) {
      paramJceOutputStream.write(this.strRemark, 4);
    }
    paramJceOutputStream.write(this.iLevel, 5);
    if (this.strProvince != null) {
      paramJceOutputStream.write(this.strProvince, 6);
    }
    if (this.strCity != null) {
      paramJceOutputStream.write(this.strCity, 7);
    }
    if (this.strSign != null) {
      paramJceOutputStream.write(this.strSign, 8);
    }
    if (this.strGroupName != null) {
      paramJceOutputStream.write(this.strGroupName, 9);
    }
    if (this.strGroupNick != null) {
      paramJceOutputStream.write(this.strGroupNick, 10);
    }
    if (this.strMobile != null) {
      paramJceOutputStream.write(this.strMobile, 11);
    }
    if (this.strContactName != null) {
      paramJceOutputStream.write(this.strContactName, 12);
    }
    paramJceOutputStream.write(this.ulShowControl, 13);
    if (this.strQzoneFeedsDesc != null) {
      paramJceOutputStream.write(this.strQzoneFeedsDesc, 14);
    }
    if (this.oLatestPhotos != null) {
      paramJceOutputStream.write(this.oLatestPhotos, 15);
    }
    paramJceOutputStream.write(this.iVoteCount, 16);
    paramJceOutputStream.write(this.iLastestVoteCount, 17);
    paramJceOutputStream.write(this.bValid4Vote, 18);
    if (this.strCountry != null) {
      paramJceOutputStream.write(this.strCountry, 19);
    }
    if (this.strStatus != null) {
      paramJceOutputStream.write(this.strStatus, 20);
    }
    if (this.strAutoRemark != null) {
      paramJceOutputStream.write(this.strAutoRemark, 21);
    }
    paramJceOutputStream.write(this.lCacheControl, 22);
    paramJceOutputStream.write(this.lUIN, 23);
    paramJceOutputStream.write(this.iPhotoCount, 24);
    paramJceOutputStream.write(this.eAddOption, 25);
    if (this.vAddQuestion != null) {
      paramJceOutputStream.write(this.vAddQuestion, 26);
    }
    if (this.vSeed != null) {
      paramJceOutputStream.write(this.vSeed, 27);
    }
    if (this.strDiscussName != null) {
      paramJceOutputStream.write(this.strDiscussName, 28);
    }
    if (this.stVipInfo != null) {
      paramJceOutputStream.write(this.stVipInfo, 29);
    }
    if (this.strShowName != null) {
      paramJceOutputStream.write(this.strShowName, 30);
    }
    if (this.stVoiceInfo != null) {
      paramJceOutputStream.write(this.stVoiceInfo, 31);
    }
    if (this.vRichSign != null) {
      paramJceOutputStream.write(this.vRichSign, 32);
    }
    paramJceOutputStream.write(this.uSignModifyTime, 33);
    if (this.vRespLastGameInfo != null) {
      paramJceOutputStream.write(this.vRespLastGameInfo, 34);
    }
    paramJceOutputStream.write(this.lUserFlag, 35);
    paramJceOutputStream.write(this.uLoginDays, 36);
    if (this.strLoginDesc != null) {
      paramJceOutputStream.write(this.strLoginDesc, 37);
    }
    paramJceOutputStream.write(this.uTemplateId, 38);
    paramJceOutputStream.write(this.uQQMasterLoginDays, 39);
    paramJceOutputStream.write(this.ulFaceAddonId, 40);
    if (this.vRespTemplateInfo != null) {
      paramJceOutputStream.write(this.vRespTemplateInfo, 41);
    }
    if (this.strRespMusicInfo != null) {
      paramJceOutputStream.write(this.strRespMusicInfo, 42);
    }
    if (this.vRespStarInfo != null) {
      paramJceOutputStream.write(this.vRespStarInfo, 43);
    }
    if (this.stDiamonds != null) {
      paramJceOutputStream.write(this.stDiamonds, 44);
    }
    paramJceOutputStream.write(this.uAccelerateMultiple, 45);
    if (this.vvRespServices != null) {
      paramJceOutputStream.write(this.vvRespServices, 46);
    }
    if (this.strSpaceName != null) {
      paramJceOutputStream.write(this.strSpaceName, 47);
    }
    if (this.stDateCard != null) {
      paramJceOutputStream.write(this.stDateCard, 48);
    }
    paramJceOutputStream.write(this.iBirthday, 49);
    if (this.stQCallInfo != null) {
      paramJceOutputStream.write(this.stQCallInfo, 50);
    }
    if (this.stGiftInfo != null) {
      paramJceOutputStream.write(this.stGiftInfo, 51);
    }
    if (this.stPanSocialInfo != null) {
      paramJceOutputStream.write(this.stPanSocialInfo, 52);
    }
    if (this.stVideoInfo != null) {
      paramJceOutputStream.write(this.stVideoInfo, 53);
    }
    if (this.vTempChatSig != null) {
      paramJceOutputStream.write(this.vTempChatSig, 54);
    }
    if (this.stInterestTag != null) {
      paramJceOutputStream.write(this.stInterestTag, 55);
    }
    if (this.stUserFeed != null) {
      paramJceOutputStream.write(this.stUserFeed, 56);
    }
    if (this.stQiqiVideoInfo != null) {
      paramJceOutputStream.write(this.stQiqiVideoInfo, 57);
    }
    if (this.stPrivInfo != null) {
      paramJceOutputStream.write(this.stPrivInfo, 58);
    }
    if (this.stApollo != null) {
      paramJceOutputStream.write(this.stApollo, 59);
    }
    if (this.stAddFrdSrcInfo != null) {
      paramJceOutputStream.write(this.stAddFrdSrcInfo, 60);
    }
    if (this.stBindPhoneInfo != null) {
      paramJceOutputStream.write(this.stBindPhoneInfo, 61);
    }
    if (this.vVisitingCardInfo != null) {
      paramJceOutputStream.write(this.vVisitingCardInfo, 62);
    }
    if (this.strVoteLimitedNotice != null) {
      paramJceOutputStream.write(this.strVoteLimitedNotice, 63);
    }
    paramJceOutputStream.write(this.bHaveVotedCnt, 64);
    paramJceOutputStream.write(this.bAvailVoteCnt, 65);
    if (this.strEIMBindPhoneNum != null) {
      paramJceOutputStream.write(this.strEIMBindPhoneNum, 66);
    }
    if (this.strEIMId != null) {
      paramJceOutputStream.write(this.strEIMId, 67);
    }
    if (this.strEmail != null) {
      paramJceOutputStream.write(this.strEmail, 68);
    }
    paramJceOutputStream.write(this.uCareer, 69);
    if (this.strPersonal != null) {
      paramJceOutputStream.write(this.strPersonal, 70);
    }
    if (this.vHotChatInfo != null) {
      paramJceOutputStream.write(this.vHotChatInfo, 71);
    }
    if (this.stOlympicInfo != null) {
      paramJceOutputStream.write(this.stOlympicInfo, 72);
    }
    if (this.stCoverInfo != null) {
      paramJceOutputStream.write(this.stCoverInfo, 73);
    }
    if (this.stNowBroadcastInfo != null) {
      paramJceOutputStream.write(this.stNowBroadcastInfo, 74);
    }
    if (this.stEimInfo != null) {
      paramJceOutputStream.write(this.stEimInfo, 75);
    }
    if (this.stVideoHeadInfo != null) {
      paramJceOutputStream.write(this.stVideoHeadInfo, 78);
    }
    paramJceOutputStream.write(this.iContactNotBindQQ, 79);
    if (this.stMedalWallInfo != null) {
      paramJceOutputStream.write(this.stMedalWallInfo, 80);
    }
    if (this.vvRespServicesBigOrder != null) {
      paramJceOutputStream.write(this.vvRespServicesBigOrder, 81);
    }
    if (this.vResp0x5ebInfo != null) {
      paramJceOutputStream.write(this.vResp0x5ebInfo, 82);
    }
    if (this.stNearbyGodInfo != null) {
      paramJceOutputStream.write(this.stNearbyGodInfo, 83);
    }
    if (this.vRespQQStoryInfo != null) {
      paramJceOutputStream.write(this.vRespQQStoryInfo, 84);
    }
    if (this.vRespCustomLabelInfo != null) {
      paramJceOutputStream.write(this.vRespCustomLabelInfo, 85);
    }
    if (this.vPraiseList != null) {
      paramJceOutputStream.write(this.vPraiseList, 86);
    }
    if (this.stCampusCircleInfo != null) {
      paramJceOutputStream.write(this.stCampusCircleInfo, 87);
    }
    if (this.stTimInfo != null) {
      paramJceOutputStream.write(this.stTimInfo, 88);
    }
    if (this.stQimInfo != null) {
      paramJceOutputStream.write(this.stQimInfo, 89);
    }
    if (this.stHeartInfo != null) {
      paramJceOutputStream.write(this.stHeartInfo, 90);
    }
    if (this.vQzoneCoverInfo != null) {
      paramJceOutputStream.write(this.vQzoneCoverInfo, 91);
    }
    if (this.vNearbyTaskInfo != null) {
      paramJceOutputStream.write(this.vNearbyTaskInfo, 92);
    }
    if (this.vNowInfo != null) {
      paramJceOutputStream.write(this.vNowInfo, 93);
    }
    paramJceOutputStream.write(this.uFriendGroupId, 94);
    if (this.vCommLabel != null) {
      paramJceOutputStream.write(this.vCommLabel, 95);
    }
    if (this.vExtendCard != null) {
      paramJceOutputStream.write(this.vExtendCard, 96);
    }
    if (this.strQzoneHeader != null) {
      paramJceOutputStream.write(this.strQzoneHeader, 97);
    }
    if (this.mapQzoneEx != null) {
      paramJceOutputStream.write(this.mapQzoneEx, 98);
    }
    if (this.vRespKandianInfo != null) {
      paramJceOutputStream.write(this.vRespKandianInfo, 99);
    }
    if (this.stWeishiInfo != null) {
      paramJceOutputStream.write(this.stWeishiInfo, 100);
    }
    paramJceOutputStream.write(this.uRichCardNameVer, 101);
    paramJceOutputStream.write(this.uCurMulType, 102);
    if (this.vLongNickTopicInfo != null) {
      paramJceOutputStream.write(this.vLongNickTopicInfo, 103);
    }
    paramJceOutputStream.write(this.i0x6d4Success, 104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SummaryCard.RespSummaryCard
 * JD-Core Version:    0.7.0.1
 */