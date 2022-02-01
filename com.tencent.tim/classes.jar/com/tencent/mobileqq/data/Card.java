package com.tencent.mobileqq.data;

import GameCenter.GameLogoUrl;
import GameCenter.RespLastGameInfo;
import NS_MINI_APP_MISC.MISC.StAppPlayingInfo;
import QQService.EVIPSPEC;
import QQService.PrivilegeInfo;
import QQService.TagInfo;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import SummaryCard.AlbumInfo;
import SummaryCard.PhotoInfo;
import SummaryCard.TPraiseInfo;
import SummaryCardTaf.SLabelInfo;
import SummaryCardTaf.SSummaryCardRsp;
import SummaryCardTaf.SUserLabel;
import SummaryCardTaf.cardDiyComplicatedInfo;
import SummaryCardTaf.cardDiyTextInfo;
import SummaryCardTaf.summaryCardWzryInfo;
import adyr;
import alcx;
import alcz;
import alda;
import aldb;
import aled;
import android.content.Intent;
import android.os.Parcel;
import android.text.TextUtils;
import anpc;
import aqrh;
import aqri;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.CardInfo;
import tencent.im.oidb.cmd0x703.cmd0x703.PhotoInfo;
import tencent.im.oidb.cmd0x703.cmd0x703.UinPhotoListInfo;

public class Card
  extends Entity
{
  public static final long BIRTHDAY_INVALID = 0L;
  public static final int CONSTELLATION_INVALID = 0;
  public static final short FEMALE = 1;
  public static final short MALE = 0;
  public static final int PROFESSION_DEFAULT = -1;
  public static final short UNKNOWN_MALE = -1;
  public String StrPresentDesc;
  public long addSrcId;
  public String addSrcName;
  public long addSubSrcId;
  public byte age;
  public boolean allowCalInteractive;
  public boolean allowClick;
  public boolean allowPeopleSee;
  public List<MISC.StAppPlayingInfo> appPlayingInfos;
  public long authState;
  public boolean autoPlayMusicPendant;
  public short bAvailVoteCnt;
  public byte bBigClubVipOpen;
  public byte[] bCardInfo;
  public byte bFavorited;
  public short bHaveVotedCnt;
  public byte bHollywoodVipOpen;
  public byte bQQVipOpen;
  public byte bQzoneInfo;
  public byte bRead = 2;
  public byte bSingle;
  public byte bSuperQQOpen;
  public byte bSuperVipOpen;
  public byte bVoted;
  public byte bWeiboInfo;
  public boolean babyQSwitch;
  public long backgroundColor;
  public String backgroundUrl = "";
  public byte[] bgType;
  public String bindPhoneInfo;
  public String busiEntry;
  public byte cSqqLevel;
  public long cardId;
  public int cardType;
  public int category;
  public int clothesId;
  public int constellation = 0;
  @notColumn
  public String coverUrl;
  public String declaration;
  public int defaultCardId;
  public String diyComplicatedInfo;
  public String diyDefaultText;
  public String diyText;
  public float diyTextDegree;
  public int diyTextFontId;
  public float diyTextHeight;
  public float diyTextLocX;
  public float diyTextLocY;
  public float diyTextScale = 1.0F;
  public float diyTextTransparency;
  public float diyTextWidth;
  public int dynamicCardFlag;
  public byte eUserIdentityType;
  public String encId;
  public int enlargeQzonePic;
  public short extendFriendEntryAddFriend;
  public short extendFriendEntryContact;
  public int extendFriendFlag;
  public short extendFriendQuestion;
  public int extendFriendVoiceDuration;
  public int favoriteSource;
  public long feedPreviewTime;
  public int fontId;
  public int fontType;
  public int grayNameplateFlag;
  public int greenLevel;
  public int guestAppTotal;
  public String guestJumpUrl;
  public boolean hasFakeData;
  public String hobbyEntry;
  public int iBigClubVipLevel;
  public int iBigClubVipType;
  public int iFaceNum;
  public int iHollywoodVipLevel;
  public int iHollywoodVipType;
  public int iMedalCount;
  public int iNewCount;
  public int iProfession = -1;
  public int iQQLevel;
  public int iQQVipLevel;
  public int iQQVipType;
  public int iSuperQQLevel;
  public int iSuperQQType;
  public int iSuperVipLevel;
  public int iSuperVipType;
  public int iUpgradeCount;
  public int iVoteIncrement;
  public int iXManScene1DelayTime;
  public int iXManScene2DelayTime;
  public int idx;
  public boolean isGreenDiamond;
  public boolean isHidePrettyGroutIdentity;
  public boolean isPrettyGroupOwner;
  public boolean isRedDiamond;
  public boolean isShowCard;
  public boolean isShowMiniPlaying;
  public boolean isSuperGreenDiamond;
  public boolean isSuperRedDiamond;
  public boolean isSuperYellowDiamond;
  public boolean isYellowDiamond;
  public long lBigClubTemplateId;
  public long lBirthday = 0L;
  public long lCardShowNum;
  public long lCurrentBgId = -1L;
  public long lCurrentStyleId = -1L;
  public long lLoginDays;
  public long lQQMasterLogindays;
  public long lSignModifyTime;
  public long lSuperVipTemplateId;
  public long lUserFlag;
  public long lVisitCount;
  public long lVoteCount;
  public byte[] labelInfoBytes;
  public byte[] lastPraiseInfoList;
  @notColumn
  public ArrayList<TPraiseInfo> lastPraiseInfos;
  @notColumn
  public String lifeAchievementOpenId;
  @notColumn
  public int lifeAchievementTotalCount;
  @notColumn
  public ArrayList<aled> lifeAchivementList;
  public String lightalkId;
  public String lightalkNick;
  public String location;
  public int mNowShowFlag;
  public String mNowShowIconUrl;
  public String mNowShowJumpUrl;
  @notColumn
  public cmd0x703.UinPhotoListInfo mPhotoListInfo;
  public int mQQLevelType;
  public boolean medalSwitchDisable;
  public ArrayList<MiniAppInfo> miniAppInfoArrayList;
  public int nFaceID;
  public int nLastGameFlag;
  public int nSameFriendsNum;
  public int nStarFansFlag;
  public int namePlateOfKingDan;
  public boolean namePlateOfKingDanDisplatSwitch;
  public long namePlateOfKingGameId;
  public long namePlateOfKingLoginTime;
  public int nameplateVipType;
  @notColumn
  public int newSchoolStatusFlagForGuide = 1;
  public byte olympicTorch;
  @notColumn
  public PersonalityLabel personalityLabel;
  public int popularity;
  public String presentCustourl;
  public String presentDesc;
  public boolean presentSwitch;
  public List<String> presentUrl;
  public String privilegeJumpUrl;
  public String privilegePromptStr;
  public String pyFaceUrl;
  @notColumn
  public ArrayList<PhotoInfo> qzonePhotoList = new ArrayList();
  public int redLevel;
  public String schoolId;
  public String schoolName;
  public boolean schoolVerifiedFlag;
  @Deprecated
  public short shAge;
  public short shDuration;
  public short shGender = -1;
  public short shType;
  public boolean showLightalk;
  public boolean showMusicBox;
  public boolean showOnlineFriends;
  public boolean showPresent;
  public boolean showPublishButton;
  public boolean showRedPointMusicPendant;
  @notColumn
  public String singer;
  @notColumn
  public long songDuration;
  @notColumn
  public String songId;
  @notColumn
  public String songName;
  public String starFansJumpUrl;
  public String strActiveUrl = "";
  public String strAutoRemark;
  public String strCertificationInfo;
  public String strCity;
  public String strCompany;
  public String strCompanySame;
  public String strContactName;
  public String strCountry;
  public String strCurrentBgUrl;
  public String strDrawerCardUrl = "";
  public String strEmail;
  public String strExtInfo;
  public String strGameAppid_1;
  public String strGameAppid_2;
  public String strGameAppid_3;
  public String strGameAppid_4;
  public String strGameLogoKey_1;
  public String strGameLogoKey_2;
  public String strGameLogoKey_3;
  public String strGameLogoKey_4;
  public String strGameLogoUrl_1;
  public String strGameLogoUrl_2;
  public String strGameLogoUrl_3;
  public String strGameLogoUrl_4;
  public String strGameName_1;
  public String strGameName_2;
  public String strGameName_3;
  public String strGameName_4;
  public String strHometownCodes;
  public String strHometownDesc;
  public String strJoinHexAlbumFileKey;
  public String strLocationCodes;
  public String strLocationDesc;
  public String strLoginDaysDesc;
  public String strMobile;
  public String strNick;
  public String strPersonalNote;
  public String strProfileUrl;
  public String strPromptParams;
  public String strProvince;
  public String strQzoneFeedsDesc;
  public String strQzoneHeader;
  public String strReMark;
  public String strRespMusicInfo;
  public String strSchool;
  public String strSchoolSame;
  public String strShowName;
  public String strSign;
  public String strSpaceName;
  public String strStarLogoUrl;
  public String strStarLvUrl_0;
  public String strStarLvUrl_1;
  public String strStarLvUrl_2;
  public String strStarPicUrl_0;
  public String strStarPicUrl_1;
  public String strStarPicUrl_2;
  public String strStatus;
  @Deprecated
  public String strTroopName;
  @Deprecated
  public String strTroopNick;
  public String strUrl = "";
  public String strVoiceFilekey;
  public String strVoteLimitedNotice;
  public String strWzryHeroUrl = "";
  public String strZipUrl = "";
  public boolean strangerInviteMeGroupOpen = true;
  public boolean strangerVoteOpen;
  @notColumn
  public List<alda> summaryEntrys;
  @notColumn
  public short switch_disable_personality_label = -1;
  @notColumn
  public short switch_interest = -1;
  @notColumn
  public short switch_life_achievement = -1;
  @notColumn
  public short switch_miniapp = -1;
  @notColumn
  public short switch_music = -1;
  @notColumn
  public short switch_musicbox = -1;
  @notColumn
  public short switch_present = -1;
  @notColumn
  public short switch_qqcircle = -1;
  @notColumn
  public short switch_sticky_note = -1;
  public String tabJumpUrl;
  public byte[] tagInfosByte;
  public byte[] tempChatSig;
  public int templateRet;
  public boolean troopHonorSwitch = true;
  public long uAccelerateMultiple;
  public long uCurMulType;
  public int uFaceTimeStamp;
  @unique
  public String uin;
  public int ulShowControl;
  public long updateTime;
  public byte[] vBackground;
  public byte[] vClosePriv;
  public byte[] vContent;
  public byte[] vCookies;
  public byte[] vCoverInfo;
  public byte[] vLongNickTopicInfo;
  public byte[] vOpenPriv;
  public byte[] vPersonalityLabelV2;
  public byte[] vQQFaceID;
  public byte[] vQzoneCoverInfo;
  public byte[] vQzonePhotos;
  public byte[] vRichSign;
  public byte[] vSeed;
  public boolean videoHeadFlag;
  public String videoHeadUrl;
  public boolean visibleMusicPendant;
  public String voiceUrl;
  public byte[] wzryHonorInfo;
  public int yellowLevel;
  
  public void addHeadPortrait(byte[] paramArrayOfByte)
  {
    String str2 = HexUtil.bytes2HexStr(paramArrayOfByte);
    if (noAlbumPics()) {}
    for (String str1 = ""; !noAlbumPics(); str1 = this.strJoinHexAlbumFileKey)
    {
      this.strJoinHexAlbumFileKey = (HexUtil.bytes2HexStr(paramArrayOfByte) + ";" + str1);
      return;
    }
    this.strJoinHexAlbumFileKey = str2;
  }
  
  public void addQzonePhotoList(AlbumInfo paramAlbumInfo)
  {
    int i = 0;
    while (i < paramAlbumInfo.vPhotos.size())
    {
      this.qzonePhotoList.add(paramAlbumInfo.vPhotos.get(i));
      i += 1;
    }
    if (this.qzonePhotoList.size() != 0)
    {
      paramAlbumInfo = Parcel.obtain();
      paramAlbumInfo.setDataPosition(0);
      paramAlbumInfo.writeList(this.qzonePhotoList);
      this.vQzonePhotos = paramAlbumInfo.marshall();
      paramAlbumInfo.recycle();
    }
    while (this.hasFakeData) {
      return;
    }
    this.vQzonePhotos = null;
  }
  
  public void addQzonePhotoList(ArrayList<String> paramArrayList, Intent paramIntent)
  {
    int i = 0;
    if ((i < paramArrayList.size()) && (i < 3))
    {
      PhotoInfo localPhotoInfo = new PhotoInfo();
      localPhotoInfo.strPicUrl = ((String)paramArrayList.get(i));
      localPhotoInfo.mapEx = new HashMap();
      Map localMap = localPhotoInfo.mapEx;
      if (paramIntent.getBooleanExtra("isVideo" + i, false)) {}
      for (String str = "1";; str = "0")
      {
        localMap.put("isVideo", str);
        this.qzonePhotoList.add(i, localPhotoInfo);
        i += 1;
        break;
      }
    }
    if (this.qzonePhotoList.size() != 0)
    {
      paramArrayList = Parcel.obtain();
      paramArrayList.setDataPosition(0);
      paramArrayList.writeList(this.qzonePhotoList);
      this.vQzonePhotos = paramArrayList.marshall();
      paramArrayList.recycle();
    }
    while (this.hasFakeData) {
      return;
    }
    this.vQzonePhotos = null;
  }
  
  public void appendPortrait(List<String> paramList)
  {
    if (!noAlbumPics())
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        this.strJoinHexAlbumFileKey = (this.strJoinHexAlbumFileKey + ";" + str);
      }
    }
    this.strJoinHexAlbumFileKey = CardHandler.A(paramList);
  }
  
  public boolean checkCoverUrl(byte[] paramArrayOfByte)
  {
    cmd0x703.UinPhotoListInfo localUinPhotoListInfo = new cmd0x703.UinPhotoListInfo();
    try
    {
      localUinPhotoListInfo.mergeFrom(paramArrayOfByte);
      return true;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SummaryCard", 2, "checkCoverUrl " + paramArrayOfByte.toString());
      }
    }
    return false;
  }
  
  public ArrayList<Integer> getBgTypeArray()
  {
    if (this.bgType != null) {
      try
      {
        ArrayList localArrayList = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(this.bgType)).readObject();
        return localArrayList;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return new ArrayList();
  }
  
  public List<alda> getBigOrderEntrys()
  {
    if (this.summaryEntrys == null)
    {
      this.summaryEntrys = new ArrayList();
      if (TextUtils.isEmpty(this.hobbyEntry)) {}
    }
    for (;;)
    {
      int i;
      JSONObject localJSONObject1;
      alda localalda;
      Object localObject1;
      try
      {
        JSONArray localJSONArray1 = new JSONArray(this.hobbyEntry);
        i = 0;
        if (i < localJSONArray1.length())
        {
          localJSONObject1 = localJSONArray1.getJSONObject(i);
          if (localJSONObject1 == null) {
            break label1151;
          }
          localalda = new alda();
          Iterator localIterator1 = localJSONObject1.keys();
          if (!localIterator1.hasNext()) {
            break label1139;
          }
          localObject1 = (String)localIterator1.next();
          if (((String)localObject1).equals("strName"))
          {
            localalda.strName = localJSONObject1.getString((String)localObject1);
            continue;
          }
        }
        else
        {
          return this.summaryEntrys;
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, localJSONException.toString());
        }
      }
      if (((String)localObject1).equals("serviceType"))
      {
        localalda.serviceType = localJSONObject1.getInt((String)localObject1);
      }
      else if (((String)localObject1).equals("strServiceUrl"))
      {
        localalda.bVJ = localJSONObject1.getString((String)localObject1);
      }
      else if (((String)localObject1).equals("strServiceType"))
      {
        localalda.bVK = localJSONObject1.getString((String)localObject1);
      }
      else if (((String)localObject1).equals("sProfileSummaryHobbiesItem"))
      {
        localObject1 = localJSONObject1.getString((String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new JSONArray((String)localObject1);
          ArrayList localArrayList = new ArrayList();
          int j = 0;
          while (j < ((JSONArray)localObject1).length())
          {
            JSONObject localJSONObject2 = ((JSONArray)localObject1).getJSONObject(j);
            Iterator localIterator2 = localJSONObject2.keys();
            aldb localaldb = new aldb();
            while (localIterator2.hasNext())
            {
              Object localObject2 = (String)localIterator2.next();
              if (((String)localObject2).equals("strTitle"))
              {
                localaldb.strTitle = localJSONObject2.getString((String)localObject2);
              }
              else if (((String)localObject2).equals("strCoverUrl"))
              {
                localaldb.strCoverUrl = localJSONObject2.getString((String)localObject2);
              }
              else if (((String)localObject2).equals("strSubInfo"))
              {
                localaldb.bVL = localJSONObject2.getString((String)localObject2);
              }
              else if (((String)localObject2).equals("strDesc"))
              {
                localaldb.strDesc = localJSONObject2.getString((String)localObject2);
              }
              else if (((String)localObject2).equals("serviceType"))
              {
                localaldb.serviceType = localJSONObject2.getInt((String)localObject2);
              }
              else if (((String)localObject2).equals("service"))
              {
                localaldb.drY = localJSONObject2.getInt((String)localObject2);
              }
              else if (((String)localObject2).equals("strTitleIconUrl"))
              {
                localaldb.bVM = localJSONObject2.getString((String)localObject2);
              }
              else if (((String)localObject2).equals("strJmpUrl"))
              {
                localaldb.strJmpUrl = localJSONObject2.getString((String)localObject2);
              }
              else if (((String)localObject2).equals("uint64_group_code"))
              {
                localaldb.agt = localJSONObject2.getLong((String)localObject2);
              }
              else if ((((String)localObject2).equals("labels")) && (!TextUtils.isEmpty(localJSONObject2.getString((String)localObject2))))
              {
                localObject2 = new ArrayList();
                JSONArray localJSONArray2 = new JSONArray(localJSONObject2.getString("labels"));
                int k = 0;
                while (k < localJSONArray2.length())
                {
                  JSONObject localJSONObject3 = localJSONArray2.getJSONObject(k);
                  alcz localalcz = new alcz();
                  Iterator localIterator3 = localJSONObject3.keys();
                  while (localIterator3.hasNext())
                  {
                    Object localObject3 = (String)localIterator3.next();
                    if (((String)localObject3).equals("strWording"))
                    {
                      localalcz.strWording = localJSONObject3.getString((String)localObject3);
                    }
                    else if (((String)localObject3).equals("attr"))
                    {
                      localalcz.ags = localJSONObject3.getLong((String)localObject3);
                    }
                    else if (((String)localObject3).equals("type"))
                    {
                      localalcz.type = localJSONObject3.getLong((String)localObject3);
                    }
                    else
                    {
                      alcx localalcx;
                      Iterator localIterator4;
                      String str;
                      if (((String)localObject3).equals("text_color"))
                      {
                        localObject3 = localJSONObject3.getString((String)localObject3);
                        if (!TextUtils.isEmpty((CharSequence)localObject3))
                        {
                          localObject3 = new JSONObject((String)localObject3);
                          localalcx = new alcx();
                          localIterator4 = ((JSONObject)localObject3).keys();
                          while (localIterator4.hasNext())
                          {
                            str = (String)localIterator4.next();
                            if (str.equals("R")) {
                              localalcx.R = ((JSONObject)localObject3).getLong(str);
                            } else if (str.equals("G")) {
                              localalcx.G = ((JSONObject)localObject3).getLong(str);
                            } else if (str.equals("B")) {
                              localalcx.B = ((JSONObject)localObject3).getLong(str);
                            }
                          }
                          localalcz.a = localalcx;
                        }
                      }
                      else if (((String)localObject3).equals("edging_color"))
                      {
                        localObject3 = localJSONObject3.getString((String)localObject3);
                        if (!TextUtils.isEmpty((CharSequence)localObject3))
                        {
                          localObject3 = new JSONObject((String)localObject3);
                          localalcx = new alcx();
                          localIterator4 = ((JSONObject)localObject3).keys();
                          while (localIterator4.hasNext())
                          {
                            str = (String)localIterator4.next();
                            if (str.equals("R")) {
                              localalcx.R = ((JSONObject)localObject3).getLong(str);
                            } else if (str.equals("G")) {
                              localalcx.G = ((JSONObject)localObject3).getLong(str);
                            } else if (str.equals("B")) {
                              localalcx.B = ((JSONObject)localObject3).getLong(str);
                            }
                          }
                          localalcz.b = localalcx;
                        }
                      }
                    }
                  }
                  ((ArrayList)localObject2).add(localalcz);
                  k += 1;
                }
                localaldb.labels = ((ArrayList)localObject2);
              }
            }
            localArrayList.add(localaldb);
            j += 1;
          }
          localalda.yC = localArrayList;
          continue;
          label1139:
          this.summaryEntrys.add(localalda);
          label1151:
          i += 1;
        }
      }
    }
  }
  
  public BusinessCard getCardInfo()
  {
    Oidb_0x43c.CardInfo localCardInfo = new Oidb_0x43c.CardInfo();
    BusinessCard localBusinessCard = new BusinessCard();
    if (this.bCardInfo != null) {}
    try
    {
      localCardInfo.mergeFrom(this.bCardInfo);
      adyr.a(localBusinessCard, localCardInfo);
      return localBusinessCard;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SummaryCard", 2, "getCardInfo " + localInvalidProtocolBufferMicroException.toString());
      }
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
    return localBusinessCard;
  }
  
  public Object[] getCoverData(int paramInt)
  {
    Object localObject1 = null;
    int m = -1;
    Object localObject2 = this.mPhotoListInfo;
    if ((this.mPhotoListInfo == null) && (this.vCoverInfo != null)) {
      localObject2 = new cmd0x703.UinPhotoListInfo();
    }
    for (;;)
    {
      try
      {
        ((cmd0x703.UinPhotoListInfo)localObject2).mergeFrom(this.vCoverInfo);
        this.mPhotoListInfo = ((cmd0x703.UinPhotoListInfo)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("SummaryCard", 2, String.format("getCoverData uin: %s, cover_flag[%s,%s]", new Object[] { this.uin, Boolean.valueOf(((cmd0x703.UinPhotoListInfo)localObject2).cover_flag.has()), Integer.valueOf(((cmd0x703.UinPhotoListInfo)localObject2).cover_flag.get()) }));
        }
        if ((localObject2 != null) && (((cmd0x703.UinPhotoListInfo)localObject2).rpt_msg_photo_info.get() != null))
        {
          Object localObject3 = ((cmd0x703.UinPhotoListInfo)localObject2).rpt_msg_photo_info.get();
          localObject1 = ((cmd0x703.UinPhotoListInfo)localObject2).rpt_selected_id_list.get();
          if (QLog.isColorLevel()) {
            QLog.d("SummaryCard", 2, "getCoverData infoList:" + ((List)localObject3).size());
          }
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localObject1 = (Integer)((List)localObject1).get(0);
            if (localObject1 == null) {
              continue;
            }
            i = ((Integer)localObject1).intValue();
            j = 0;
            if (j >= ((List)localObject3).size()) {
              continue;
            }
            cmd0x703.PhotoInfo localPhotoInfo = (cmd0x703.PhotoInfo)((List)localObject3).get(j);
            k = localPhotoInfo.uint32_timestamp.get();
            if ((localPhotoInfo.uint32_id.get() != i) || ((paramInt >= k) && (k != 0))) {
              continue;
            }
            localObject1 = localPhotoInfo.str_url.get();
            j = localPhotoInfo.uint32_timestamp.get();
            if ((!((cmd0x703.UinPhotoListInfo)localObject2).str_default_photo.has()) || (TextUtils.isEmpty(((cmd0x703.UinPhotoListInfo)localObject2).str_default_photo.get()))) {
              continue;
            }
            localObject1 = ((cmd0x703.UinPhotoListInfo)localObject2).str_default_photo.get();
            m = i;
            k = j;
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              m = i;
              k = j;
              localObject2 = localObject1;
              if (((List)localObject3).size() > 0)
              {
                localObject3 = (cmd0x703.PhotoInfo)((List)localObject3).get(((List)localObject3).size() - 1);
                m = i;
                k = j;
                localObject2 = localObject1;
                if (paramInt < ((cmd0x703.PhotoInfo)localObject3).uint32_timestamp.get())
                {
                  localObject2 = ((cmd0x703.PhotoInfo)localObject3).str_url.get();
                  k = ((cmd0x703.PhotoInfo)localObject3).uint32_timestamp.get();
                  m = i;
                }
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("SummaryCard", 2, "getCoverData selectedId:" + m + " retTime:" + k + " retUrl:" + (String)localObject2);
            }
            return new Object[] { localObject2, Integer.valueOf(k) };
          }
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        int i;
        int j;
        int k;
        if (QLog.isColorLevel())
        {
          QLog.d("SummaryCard", 2, "getCoverData " + localInvalidProtocolBufferMicroException.toString());
          continue;
          i = m;
          if (QLog.isColorLevel())
          {
            QLog.d("SummaryCard", 2, "getCoverData idList is empty!");
            i = m;
            continue;
            j += 1;
            continue;
            continue;
            j = 0;
            localObject1 = null;
            continue;
            i = -1;
            continue;
            k = 0;
            localObject2 = localObject1;
          }
        }
      }
    }
  }
  
  public List<ProfileLabelInfo> getLabelList()
  {
    Object localObject2 = null;
    if (this.labelInfoBytes != null) {}
    for (;;)
    {
      try
      {
        ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.labelInfoBytes);
        ObjectInputStream localObjectInputStream = new ObjectInputStream(localByteArrayInputStream);
        localObject1 = (ArrayList)localObjectInputStream.readObject();
        localObject2.printStackTrace();
      }
      catch (Exception localException2)
      {
        try
        {
          localByteArrayInputStream.close();
          localObjectInputStream.close();
          localByteArrayInputStream.close();
          localObjectInputStream.close();
          if (localObject1 == null) {
            break label76;
          }
          return localObject1;
        }
        catch (Exception localException1)
        {
          break label69;
        }
        localException2 = localException2;
        localObject1 = localObject2;
        localObject2 = localException2;
      }
      label69:
      continue;
      label76:
      return new ArrayList();
      Object localObject1 = null;
    }
  }
  
  public ArrayList<TPraiseInfo> getLastPraiseInfoList()
  {
    if (this.lastPraiseInfos != null) {
      return this.lastPraiseInfos;
    }
    if (this.lastPraiseInfoList != null) {
      try
      {
        this.lastPraiseInfos = ((ArrayList)new ObjectInputStream(new ByteArrayInputStream(this.lastPraiseInfoList)).readObject());
        ArrayList localArrayList = this.lastPraiseInfos;
        return localArrayList;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return new ArrayList();
  }
  
  public int getLocalPicKeysCount()
  {
    if ((this.strJoinHexAlbumFileKey == null) || (this.strJoinHexAlbumFileKey.length() == 0)) {
      return 0;
    }
    return CardHandler.a(this.strJoinHexAlbumFileKey).size();
  }
  
  public PersonalityLabel getPersonalityLabel()
  {
    if ((this.personalityLabel == null) && (this.vPersonalityLabelV2 != null))
    {
      this.personalityLabel = PersonalityLabel.convertFromBytes(this.vPersonalityLabelV2);
      if (this.personalityLabel == null) {
        this.vPersonalityLabelV2 = null;
      }
    }
    return this.personalityLabel;
  }
  
  public int getPicCountInAlbum()
  {
    return this.iFaceNum;
  }
  
  public List<PrivilegeInfo> getPrivilegeCloseInfo()
  {
    Object localObject2 = null;
    if (this.vClosePriv != null) {}
    for (;;)
    {
      try
      {
        ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.vClosePriv);
        ObjectInputStream localObjectInputStream = new ObjectInputStream(localByteArrayInputStream);
        localObject1 = (ArrayList)localObjectInputStream.readObject();
        localObject2.printStackTrace();
      }
      catch (Exception localException2)
      {
        try
        {
          localByteArrayInputStream.close();
          localObjectInputStream.close();
          localByteArrayInputStream.close();
          localObjectInputStream.close();
          if (localObject1 == null) {
            break label76;
          }
          return localObject1;
        }
        catch (Exception localException1)
        {
          break label69;
        }
        localException2 = localException2;
        localObject1 = localObject2;
        localObject2 = localException2;
      }
      label69:
      continue;
      label76:
      return new ArrayList();
      Object localObject1 = null;
    }
  }
  
  /* Error */
  public List<PrivilegeInfo> getPrivilegeOpenInfo()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 881	com/tencent/mobileqq/data/Card:vOpenPriv	[B
    //   6: ifnull +171 -> 177
    //   9: new 546	java/io/ObjectInputStream
    //   12: dup
    //   13: new 548	java/io/ByteArrayInputStream
    //   16: dup
    //   17: aload_0
    //   18: getfield 881	com/tencent/mobileqq/data/Card:vOpenPriv	[B
    //   21: invokespecial 550	java/io/ByteArrayInputStream:<init>	([B)V
    //   24: invokespecial 553	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: invokevirtual 556	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   34: checkcast 365	java/util/ArrayList
    //   37: astore_3
    //   38: aload_3
    //   39: astore_1
    //   40: aload_2
    //   41: ifnull +9 -> 50
    //   44: aload_2
    //   45: invokevirtual 842	java/io/ObjectInputStream:close	()V
    //   48: aload_3
    //   49: astore_1
    //   50: aload_1
    //   51: ifnull +102 -> 153
    //   54: aload_1
    //   55: areturn
    //   56: astore_1
    //   57: aload_1
    //   58: invokevirtual 559	java/lang/Exception:printStackTrace	()V
    //   61: aload_3
    //   62: astore_1
    //   63: goto -13 -> 50
    //   66: astore_3
    //   67: aconst_null
    //   68: astore_2
    //   69: aload_2
    //   70: astore_1
    //   71: aload_3
    //   72: invokevirtual 559	java/lang/Exception:printStackTrace	()V
    //   75: aload_2
    //   76: ifnull +101 -> 177
    //   79: aload_2
    //   80: invokevirtual 842	java/io/ObjectInputStream:close	()V
    //   83: aconst_null
    //   84: astore_1
    //   85: goto -35 -> 50
    //   88: astore_1
    //   89: aload_1
    //   90: invokevirtual 559	java/lang/Exception:printStackTrace	()V
    //   93: aconst_null
    //   94: astore_1
    //   95: goto -45 -> 50
    //   98: astore_3
    //   99: aconst_null
    //   100: astore_2
    //   101: aload_2
    //   102: astore_1
    //   103: aload_3
    //   104: invokevirtual 882	java/lang/OutOfMemoryError:printStackTrace	()V
    //   107: aload_2
    //   108: ifnull +69 -> 177
    //   111: aload_2
    //   112: invokevirtual 842	java/io/ObjectInputStream:close	()V
    //   115: aconst_null
    //   116: astore_1
    //   117: goto -67 -> 50
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 559	java/lang/Exception:printStackTrace	()V
    //   125: aconst_null
    //   126: astore_1
    //   127: goto -77 -> 50
    //   130: astore_3
    //   131: aload_1
    //   132: astore_2
    //   133: aload_3
    //   134: astore_1
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 842	java/io/ObjectInputStream:close	()V
    //   143: aload_1
    //   144: athrow
    //   145: astore_2
    //   146: aload_2
    //   147: invokevirtual 559	java/lang/Exception:printStackTrace	()V
    //   150: goto -7 -> 143
    //   153: new 365	java/util/ArrayList
    //   156: dup
    //   157: invokespecial 366	java/util/ArrayList:<init>	()V
    //   160: areturn
    //   161: astore_3
    //   162: aload_1
    //   163: astore_2
    //   164: aload_3
    //   165: astore_1
    //   166: goto -31 -> 135
    //   169: astore_3
    //   170: goto -69 -> 101
    //   173: astore_3
    //   174: goto -105 -> 69
    //   177: aconst_null
    //   178: astore_1
    //   179: goto -129 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	Card
    //   1	54	1	localObject1	Object
    //   56	2	1	localException1	Exception
    //   62	23	1	localObject2	Object
    //   88	2	1	localException2	Exception
    //   94	23	1	localObject3	Object
    //   120	2	1	localException3	Exception
    //   126	53	1	localObject4	Object
    //   27	113	2	localObject5	Object
    //   145	2	2	localException4	Exception
    //   163	1	2	localObject6	Object
    //   37	25	3	localArrayList	ArrayList
    //   66	6	3	localException5	Exception
    //   98	6	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   130	4	3	localObject7	Object
    //   161	4	3	localObject8	Object
    //   169	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   173	1	3	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   44	48	56	java/lang/Exception
    //   9	28	66	java/lang/Exception
    //   79	83	88	java/lang/Exception
    //   9	28	98	java/lang/OutOfMemoryError
    //   111	115	120	java/lang/Exception
    //   9	28	130	finally
    //   139	143	145	java/lang/Exception
    //   30	38	161	finally
    //   71	75	161	finally
    //   103	107	161	finally
    //   30	38	169	java/lang/OutOfMemoryError
    //   30	38	173	java/lang/Exception
  }
  
  public String getProfileCardDesc()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-->templateRet=" + this.templateRet);
    localStringBuilder.append(",styleId=" + this.lCurrentStyleId);
    localStringBuilder.append(",backgroundId=" + this.lCurrentBgId);
    localStringBuilder.append(",backgroundUrl=" + this.backgroundUrl);
    localStringBuilder.append(",backgroundColor=" + this.backgroundColor);
    localStringBuilder.append(",ActiveUrl= " + this.strActiveUrl);
    return localStringBuilder.toString();
  }
  
  public List<PhotoInfo> getQZonePhotoList()
  {
    if ((this.qzonePhotoList.size() == 0) && (this.vQzonePhotos != null)) {}
    try
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(this.vQzonePhotos, 0, this.vQzonePhotos.length);
      localParcel.setDataPosition(0);
      this.qzonePhotoList = localParcel.readArrayList(getClass().getClassLoader());
      localParcel.recycle();
      return this.qzonePhotoList;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SummaryCard", 2, localException.toString());
        }
      }
    }
    catch (Error localError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SummaryCard", 2, localError.toString());
        }
      }
    }
  }
  
  public RichStatus getRichStatus()
  {
    if ((this.vRichSign == null) || (this.vRichSign.length == 0))
    {
      if ((this.lSignModifyTime <= 0L) && (!TextUtils.isEmpty(this.strSign)))
      {
        localRichStatus = new RichStatus(this.strSign);
        localRichStatus.time = this.lSignModifyTime;
        return localRichStatus;
      }
      return null;
    }
    RichStatus localRichStatus = RichStatus.parseStatus(this.vRichSign);
    localRichStatus.time = this.lSignModifyTime;
    return localRichStatus;
  }
  
  public ArrayList<TagInfo> getTagInfoArray()
  {
    if (this.tagInfosByte != null) {
      try
      {
        ArrayList localArrayList3 = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(this.tagInfosByte)).readObject();
        if (localArrayList3 != null)
        {
          int i = 0;
          for (;;)
          {
            ArrayList localArrayList1 = localArrayList3;
            if (i >= localArrayList3.size()) {
              break;
            }
            ((TagInfo)localArrayList3.get(i)).iTagId = new BigInteger(Long.toString(((TagInfo)localArrayList3.get(i)).iTagId)).longValue();
            i += 1;
          }
        }
        localArrayList2 = new ArrayList();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    ArrayList localArrayList2;
    return localArrayList2;
  }
  
  public int getVipLevel(EVIPSPEC paramEVIPSPEC)
  {
    int i = -1;
    if (paramEVIPSPEC == EVIPSPEC.E_SP_QQVIP) {
      i = this.iQQVipLevel;
    }
    do
    {
      return i;
      if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERQQ) {
        return this.iSuperQQLevel;
      }
      if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERVIP) {
        return this.iSuperVipLevel;
      }
    } while (paramEVIPSPEC != EVIPSPEC.E_SP_QQVIDEO_HOLLYWOOD);
    return this.iHollywoodVipLevel;
  }
  
  public int getVipType(EVIPSPEC paramEVIPSPEC)
  {
    int i = -1;
    if (paramEVIPSPEC == EVIPSPEC.E_SP_QQVIP) {
      i = this.iQQVipType;
    }
    do
    {
      return i;
      if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERQQ) {
        return this.iSuperQQType;
      }
      if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERVIP) {
        return this.iSuperVipType;
      }
    } while (paramEVIPSPEC != EVIPSPEC.E_SP_QQVIDEO_HOLLYWOOD);
    return this.iHollywoodVipType;
  }
  
  public ArrayList<summaryCardWzryInfo> getWzryHonorInfo()
  {
    if (this.wzryHonorInfo != null) {
      try
      {
        ArrayList localArrayList = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(this.wzryHonorInfo)).readObject();
        return localArrayList;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return new ArrayList();
  }
  
  public boolean hasCardInfo()
  {
    return this.bCardInfo != null;
  }
  
  public boolean hasGotPhotoUrl()
  {
    return this.vQzonePhotos != null;
  }
  
  public boolean isNewSchoolStatusWriteForGuide()
  {
    return this.newSchoolStatusFlagForGuide != 0;
  }
  
  public boolean isNoCover()
  {
    cmd0x703.UinPhotoListInfo localUinPhotoListInfo2 = this.mPhotoListInfo;
    cmd0x703.UinPhotoListInfo localUinPhotoListInfo1 = localUinPhotoListInfo2;
    if (localUinPhotoListInfo2 == null)
    {
      getCoverData(0);
      localUinPhotoListInfo1 = this.mPhotoListInfo;
    }
    if ((localUinPhotoListInfo1 != null) && (localUinPhotoListInfo1.cover_flag.has()) && (localUinPhotoListInfo1.cover_flag.get() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SummaryCard", 2, String.format("isNoCover uin: %s, ret: %s", new Object[] { this.uin, Boolean.valueOf(bool) }));
      }
      return bool;
    }
  }
  
  public boolean isPhotoUseCache()
  {
    return (this.ulShowControl & 0x20) != 0;
  }
  
  public boolean isShowFeeds()
  {
    return (this.ulShowControl & 0x4) != 0;
  }
  
  public boolean isShowPhoto()
  {
    return (this.ulShowControl & 0x10) != 0;
  }
  
  public boolean isShowXMan()
  {
    return (this.ulShowControl & 0x40) != 0;
  }
  
  public boolean isShowZan()
  {
    return (this.ulShowControl & 0x1) != 0;
  }
  
  public boolean isVipOpen(EVIPSPEC paramEVIPSPEC)
  {
    if (paramEVIPSPEC == EVIPSPEC.E_SP_QQVIP) {
      if (this.bQQVipOpen != 1) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            return false;
            if (paramEVIPSPEC != EVIPSPEC.E_SP_SUPERQQ) {
              break;
            }
          } while (this.bSuperQQOpen == 1);
          return false;
          if (paramEVIPSPEC != EVIPSPEC.E_SP_SUPERVIP) {
            break;
          }
        } while (this.bSuperVipOpen == 1);
        return false;
        if (paramEVIPSPEC != EVIPSPEC.E_SP_QQVIDEO_HOLLYWOOD) {
          break;
        }
      } while (this.bHollywoodVipOpen == 1);
      return false;
      if (paramEVIPSPEC != EVIPSPEC.E_SP_BIGCLUB) {
        break;
      }
    } while (this.bBigClubVipOpen == 1);
    return false;
    return false;
  }
  
  public boolean noAlbumPics()
  {
    return getPicCountInAlbum() == 0;
  }
  
  public void removePortrait(byte[] paramArrayOfByte)
  {
    LinkedList localLinkedList = CardHandler.a(this.strJoinHexAlbumFileKey);
    if (localLinkedList.remove(HexUtil.bytes2HexStr(paramArrayOfByte)))
    {
      this.iFaceNum -= 1;
      this.strJoinHexAlbumFileKey = CardHandler.A(localLinkedList);
    }
  }
  
  public void saveBigOrderEntrys(List<alda> paramList)
  {
    JSONStringer localJSONStringer1 = new JSONStringer();
    this.hobbyEntry = "";
    JSONStringer localJSONStringer2;
    label139:
    JSONStringer localJSONStringer3;
    try
    {
      localJSONStringer1.array();
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        Object localObject1 = (alda)localIterator.next();
        localJSONStringer1.object().key("strName").value(((alda)localObject1).strName).key("strServiceUrl").value(((alda)localObject1).bVJ).key("strServiceType").value(((alda)localObject1).bVK).key("serviceType").value(((alda)localObject1).serviceType);
        if (((alda)localObject1).yC != null)
        {
          localJSONStringer2 = new JSONStringer().array();
          localObject1 = ((alda)localObject1).yC.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (aldb)((Iterator)localObject1).next();
            localJSONStringer2.object().key("strTitle").value(((aldb)localObject2).strTitle).key("strCoverUrl").value(((aldb)localObject2).strCoverUrl).key("strJmpUrl").value(((aldb)localObject2).strJmpUrl).key("strSubInfo").value(((aldb)localObject2).bVL).key("strDesc").value(((aldb)localObject2).strDesc).key("serviceType").value(((aldb)localObject2).serviceType).key("service").value(((aldb)localObject2).drY).key("strTitleIconUrl").value(((aldb)localObject2).bVM).key("uint64_group_code").value(((aldb)localObject2).agt);
            if (((aldb)localObject2).labels != null)
            {
              localJSONStringer3 = new JSONStringer().array();
              localObject2 = ((aldb)localObject2).labels.iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  alcz localalcz = (alcz)((Iterator)localObject2).next();
                  JSONStringer localJSONStringer4 = new JSONStringer().object();
                  localJSONStringer4.key("R").value(localalcz.a.R).key("G").value(localalcz.a.G).key("B").value(localalcz.a.B);
                  localJSONStringer4.endObject();
                  JSONStringer localJSONStringer5 = new JSONStringer().object();
                  localJSONStringer5.key("R").value(localalcz.b.R).key("G").value(localalcz.b.G).key("B").value(localalcz.b.B);
                  localJSONStringer5.endObject();
                  localJSONStringer3.object().key("strWording").value(localalcz.strWording).key("type").value(localalcz.type).key("attr").value(localalcz.ags).key("text_color").value(localJSONStringer4).key("edging_color").value(localJSONStringer5).endObject();
                  continue;
                  if (this.summaryEntrys == null) {
                    break;
                  }
                }
              }
            }
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      this.hobbyEntry = "";
      localJSONException.printStackTrace();
    }
    for (;;)
    {
      this.summaryEntrys.clear();
      if ((paramList != null) && (paramList.size() > 0)) {
        this.summaryEntrys.addAll(paramList);
      }
      return;
      localJSONStringer3.endArray();
      localJSONStringer2.key("labels").value(localJSONStringer3);
      localJSONStringer2.endObject();
      break label139;
      localJSONStringer2.endArray();
      localJSONException.key("sProfileSummaryHobbiesItem").value(localJSONStringer2);
      localJSONException.endObject();
      break;
      localJSONException.endArray();
      this.hobbyEntry = localJSONException.toString();
    }
  }
  
  public void savePrivilegeClosedInfo(List<PrivilegeInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramList);
      this.vClosePriv = localByteArrayOutputStream.toByteArray();
      localObjectOutputStream.flush();
      localByteArrayOutputStream.close();
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      localObjectOutputStream.close();
      return;
    }
    catch (IOException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void savePrivilegeOpenedInfo(List<PrivilegeInfo> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = new ByteArrayOutputStream();
        ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
        localObjectOutputStream.writeObject(paramList);
        this.vOpenPriv = ((ByteArrayOutputStream)localObject).toByteArray();
        localObjectOutputStream.flush();
        ((ByteArrayOutputStream)localObject).close();
        localObjectOutputStream.close();
        ((ByteArrayOutputStream)localObject).close();
        localObjectOutputStream.close();
        paramList = paramList.iterator();
        do
        {
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (PrivilegeInfo)paramList.next();
        } while (((PrivilegeInfo)localObject).iType != 113);
        this.bBigClubVipOpen = 1;
        this.iBigClubVipType = ((PrivilegeInfo)localObject).iFeeType;
        this.iBigClubVipLevel = ((PrivilegeInfo)localObject).iLevel;
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  public byte[] setBgType(Object paramObject)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      this.bgType = localByteArrayOutputStream.toByteArray();
      paramObject = this.bgType;
      return paramObject;
    }
    catch (IOException paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  public void setFeedsShowFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x4;
      return;
    }
    this.ulShowControl &= 0xFFFFFFFB;
  }
  
  public void setLabelList(Map<Long, SLabelInfo> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject2 = (Map.Entry)paramMap.next();
        localObject1 = (Long)((Map.Entry)localObject2).getKey();
        localObject2 = (SLabelInfo)((Map.Entry)localObject2).getValue();
        localArrayList.add(new ProfileLabelInfo((Long)localObject1, Long.valueOf(((SLabelInfo)localObject2).likeit), ((SLabelInfo)localObject2).name));
      }
    }
    try
    {
      paramMap = new ByteArrayOutputStream();
      localObject1 = new ObjectOutputStream(paramMap);
      ((ObjectOutputStream)localObject1).writeObject(localArrayList);
      this.labelInfoBytes = paramMap.toByteArray();
      ((ObjectOutputStream)localObject1).flush();
      paramMap.close();
      ((ObjectOutputStream)localObject1).close();
      paramMap.close();
      ((ObjectOutputStream)localObject1).close();
      return;
    }
    catch (IOException paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  public void setLastPraiseInfoList(ArrayList<TPraiseInfo> paramArrayList)
  {
    if (paramArrayList != null) {}
    try
    {
      this.lastPraiseInfos = paramArrayList;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramArrayList);
      localObjectOutputStream.flush();
      this.lastPraiseInfoList = localByteArrayOutputStream.toByteArray();
      return;
    }
    catch (IOException paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  public void setPhotoShowFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x10;
      return;
    }
    this.ulShowControl &= 0xFFFFFFEF;
  }
  
  public void setPhotoUseCacheFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x20;
      return;
    }
    this.ulShowControl &= 0xFFFFFFDF;
  }
  
  public void setStrJoinHexAlbumFileKey(String paramString)
  {
    this.strJoinHexAlbumFileKey = paramString;
    if ((paramString == null) || ("".equals(paramString))) {
      this.strJoinHexAlbumFileKey = ";";
    }
  }
  
  public void setVipInfo(VipBaseInfo paramVipBaseInfo)
  {
    byte b2 = 1;
    label102:
    int i;
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      VipOpenInfo localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
      if (localVipOpenInfo != null)
      {
        if (!localVipOpenInfo.bOpen) {
          break label413;
        }
        b1 = 1;
        this.bQQVipOpen = b1;
        this.iQQVipType = localVipOpenInfo.iVipType;
        this.iQQVipLevel = localVipOpenInfo.iVipLevel;
      }
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(2));
      if (localVipOpenInfo != null)
      {
        if (!localVipOpenInfo.bOpen) {
          break label418;
        }
        b1 = 1;
        this.bSuperQQOpen = b1;
        this.iSuperQQType = localVipOpenInfo.iVipType;
        this.iSuperQQLevel = localVipOpenInfo.iVipLevel;
      }
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      if (localVipOpenInfo != null)
      {
        if (!localVipOpenInfo.bOpen) {
          break label423;
        }
        b1 = 1;
        label158:
        this.bSuperVipOpen = b1;
        this.iSuperVipType = localVipOpenInfo.iVipType;
        this.iSuperVipLevel = localVipOpenInfo.iVipLevel;
        this.lSuperVipTemplateId = localVipOpenInfo.lNameplateId;
        this.lBigClubTemplateId = this.lSuperVipTemplateId;
      }
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(7));
      if (localVipOpenInfo != null)
      {
        if (!localVipOpenInfo.bOpen) {
          break label428;
        }
        i = 1;
        label233:
        this.bBigClubVipOpen = ((byte)i);
        this.iBigClubVipType = localVipOpenInfo.iVipType;
        this.iBigClubVipLevel = localVipOpenInfo.iVipLevel;
        this.lSuperVipTemplateId = localVipOpenInfo.lNameplateId;
        this.lBigClubTemplateId = localVipOpenInfo.lNameplateId;
      }
      if (QLog.isColorLevel()) {
        QLog.d("card", 2, "setVipInfo bSuperVipOpen=" + this.bSuperVipOpen + ",bQQVipOpen=" + this.bQQVipOpen + ",VipLevel=" + this.iQQVipLevel + "card = " + this + ",uin = " + this.uin);
      }
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(4));
      if (paramVipBaseInfo != null) {
        if (!paramVipBaseInfo.bOpen) {
          break label434;
        }
      }
    }
    label413:
    label418:
    label423:
    label428:
    label434:
    for (byte b1 = b2;; b1 = 0)
    {
      this.bHollywoodVipOpen = b1;
      this.iHollywoodVipType = paramVipBaseInfo.iVipType;
      this.iHollywoodVipLevel = paramVipBaseInfo.iVipLevel;
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label102;
      b1 = 0;
      break label158;
      i = 0;
      break label233;
    }
  }
  
  public byte[] setWzryHonorInfo(Object paramObject)
  {
    if (paramObject == null) {
      this.wzryHonorInfo = new byte[0];
    }
    for (;;)
    {
      return null;
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
        localObjectOutputStream.writeObject(paramObject);
        localObjectOutputStream.flush();
        this.wzryHonorInfo = localByteArrayOutputStream.toByteArray();
        paramObject = this.wzryHonorInfo;
        return paramObject;
      }
      catch (IOException paramObject)
      {
        paramObject.printStackTrace();
      }
    }
  }
  
  public void setXManFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x40;
      return;
    }
    this.ulShowControl &= 0xFFFFFFBF;
  }
  
  public void updateCardTemplate(QQAppInterface paramQQAppInterface, String paramString, SSummaryCardRsp paramSSummaryCardRsp)
  {
    HashMap localHashMap = new HashMap();
    if (paramSSummaryCardRsp != null)
    {
      if (paramSSummaryCardRsp.res < 0)
      {
        QLog.e("DIYProfileTemplate.SummaryCard", 1, "getSummaryCard template error! res =" + paramSSummaryCardRsp.res);
        aqri.a(paramQQAppInterface, "individual_v2_personalcard_get_fail", "" + paramSSummaryCardRsp.res, "personalcard get template = null", null, 0.0F);
        aqrh.is("individual_v2_personalcard_get_fail", "" + paramSSummaryCardRsp.res);
        return;
      }
      if (!QLog.isColorLevel()) {}
      for (;;)
      {
        this.templateRet = paramSSummaryCardRsp.res;
        this.lCurrentStyleId = paramSSummaryCardRsp.styleid;
        this.backgroundUrl = paramSSummaryCardRsp.bgurl;
        this.lCurrentBgId = paramSSummaryCardRsp.bgid;
        this.backgroundColor = paramSSummaryCardRsp.color;
        this.dynamicCardFlag = paramSSummaryCardRsp.dynamicCardFlag;
        this.strZipUrl = paramSSummaryCardRsp.strZipUrl;
        this.strActiveUrl = paramSSummaryCardRsp.strActiveCardUrl;
        this.strDrawerCardUrl = paramSSummaryCardRsp.strDrawerCard;
        this.strWzryHeroUrl = paramSSummaryCardRsp.strWzryHeroUrl;
        this.strExtInfo = paramSSummaryCardRsp.extInfo;
        this.cardType = paramSSummaryCardRsp.cardType;
        this.diyDefaultText = paramSSummaryCardRsp.strDiyDefaultText;
        this.defaultCardId = paramSSummaryCardRsp.profileid;
        Object localObject;
        if (paramSSummaryCardRsp.stDiyComplicated == null)
        {
          localObject = "";
          this.diyComplicatedInfo = ((String)localObject);
          this.cardId = paramSSummaryCardRsp.cardid;
          localObject = paramSSummaryCardRsp.bgtype;
          if (localObject != null) {
            setBgType(localObject);
          }
          if ((paramSSummaryCardRsp.label != null) && (paramSSummaryCardRsp.label.label != null)) {
            setLabelList(paramSSummaryCardRsp.label.label);
          }
          setWzryHonorInfo(paramSSummaryCardRsp.wzryInfo);
          if (paramSSummaryCardRsp.stDiyText != null)
          {
            this.diyTextFontId = paramSSummaryCardRsp.stDiyText.iFontId;
            this.diyText = paramSSummaryCardRsp.stDiyText.strText;
            this.diyTextScale = paramSSummaryCardRsp.stDiyText.fScaling;
            this.diyTextDegree = paramSSummaryCardRsp.stDiyText.fRotationAngle;
            this.diyTextTransparency = paramSSummaryCardRsp.stDiyText.fTransparency;
            if (!TextUtils.isEmpty(paramSSummaryCardRsp.stDiyText.strPoint))
            {
              localObject = paramSSummaryCardRsp.stDiyText.strPoint.split("_");
              if (localObject.length < 4) {}
            }
          }
        }
        try
        {
          this.diyTextLocX = Float.parseFloat(localObject[0]);
          this.diyTextLocY = Float.parseFloat(localObject[1]);
          this.diyTextWidth = Float.parseFloat(localObject[2]);
          this.diyTextHeight = Float.parseFloat(localObject[3]);
          localHashMap.put("param_FailCode", "0");
          localHashMap.put("param_templateRet", String.valueOf(paramSSummaryCardRsp.res));
          if (QLog.isColorLevel()) {
            QLog.i("SummaryCard", 2, "updateCardTemplate templateInfo-->" + getProfileCardDesc());
          }
          anpc.a(paramQQAppInterface.getApp()).collectPerformance(paramString, "profileCardGet", true, 0L, 0L, localHashMap, "", false);
          return;
          QLog.w("DIYProfileTemplate.SummaryCard", 1, "updateCardTemplate res=" + paramSSummaryCardRsp.res + " styleid=" + paramSSummaryCardRsp.styleid + " bgid=" + paramSSummaryCardRsp.bgid + " strDrawerCardUrl=" + paramSSummaryCardRsp.strDrawerCard);
          if ((paramSSummaryCardRsp.stDiyComplicated != null) && (paramSSummaryCardRsp.stDiyComplicated.detail != null) && (paramSSummaryCardRsp.stDiyComplicated.detail.length() > 850))
          {
            QLog.w("DIYProfileTemplate.SummaryCard", 1, "stDiyComplicated(1)=" + paramSSummaryCardRsp.stDiyComplicated.detail.substring(0, 840));
            QLog.w("DIYProfileTemplate.SummaryCard", 1, "stDiyComplicated(2)=" + paramSSummaryCardRsp.stDiyComplicated.detail.substring(830, paramSSummaryCardRsp.stDiyComplicated.detail.length() - 1));
          }
          else
          {
            QLog.w("DIYProfileTemplate.SummaryCard", 1, "stDiyComplicated=" + paramSSummaryCardRsp.stDiyComplicated);
            continue;
            localObject = paramSSummaryCardRsp.stDiyComplicated.detail;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("Card", 1, "set card with diy text response:", localException);
          }
        }
      }
    }
    QLog.i("SummaryCard", 1, "updateCardTemplate templateInfo is null");
    aqri.a(paramQQAppInterface, "individual_v2_personalcard_get_fail", "personalcard_get_template_null", "personalcard get template = null", null, 0.0F);
    aqrh.is("individual_v2_personalcard_get_fail", "personalcard_get_template_null");
    localHashMap.put("param_FailCode", "-101");
    localHashMap.put("param_templateRet", "0");
    anpc.a(paramQQAppInterface.getApp()).collectPerformance(paramString, "profileCardGet", false, 0L, 0L, localHashMap, "", false);
  }
  
  public void updateCoverData(byte[] paramArrayOfByte)
  {
    this.vCoverInfo = paramArrayOfByte;
    this.mPhotoListInfo = null;
    if (QLog.isColorLevel()) {
      if (paramArrayOfByte != null) {
        break label46;
      }
    }
    label46:
    for (paramArrayOfByte = "null";; paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length))
    {
      QLog.d("SummaryCard", 2, String.format("updateCoverData len: %s", new Object[] { paramArrayOfByte }));
      return;
    }
  }
  
  public void updateLastGameInfo(RespLastGameInfo paramRespLastGameInfo)
  {
    int k = 0;
    if ((paramRespLastGameInfo == null) || (paramRespLastGameInfo.iResult != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SummaryCard", 2, "handleGetSummaryCard|updateLastGameInfo|info = null or info.iResult = 0");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SummaryCard", 2, "updateLastGameInfo|info.bShowGameLogo = " + paramRespLastGameInfo.bShowGameLogo);
    }
    if (paramRespLastGameInfo.bShowGameLogo)
    {
      this.nLastGameFlag |= 0x1;
      if (paramRespLastGameInfo.bNative) {
        this.nLastGameFlag |= 0x2;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SummaryCard", 2, "updateLastGameInfo|info.bNative = " + paramRespLastGameInfo.bNative);
        }
        this.strProfileUrl = paramRespLastGameInfo.sProfileUrl;
        if (QLog.isColorLevel()) {
          QLog.i("SummaryCard", 2, "updateLastGameInfo|info.stGameLogoInfo = " + paramRespLastGameInfo.stGameLogoInfo);
        }
        int i;
        label196:
        int j;
        label271:
        GameLogoUrl localGameLogoUrl;
        label294:
        String str1;
        String str2;
        String str3;
        String str4;
        if (paramRespLastGameInfo.stGameLogoInfo != null)
        {
          i = paramRespLastGameInfo.stGameLogoInfo.size();
          if (QLog.isColorLevel()) {
            QLog.i("SummaryCard", 2, "updateLastGameInfo|size = " + i);
          }
          j = k;
          if (QLog.isColorLevel())
          {
            QLog.i("SummaryCard", 2, "updateLastGameInfo|info.sLogoUrl = " + paramRespLastGameInfo.sLogoUrl);
            j = k;
          }
          if (j >= 4) {
            break;
          }
          if (j >= i) {
            break label526;
          }
          localGameLogoUrl = (GameLogoUrl)paramRespLastGameInfo.stGameLogoInfo.get(j);
          k = j + 1;
          str1 = "strGameLogoUrl_" + String.valueOf(k);
          str2 = "strGameLogoKey_" + String.valueOf(k);
          str3 = "strGameName_" + String.valueOf(k);
          str4 = "strGameAppid_" + String.valueOf(k);
          if (localGameLogoUrl == null) {
            break label532;
          }
        }
        try
        {
          getClass().getField(str1).set(this, paramRespLastGameInfo.sLogoUrl + localGameLogoUrl.sLogoName);
          getClass().getField(str2).set(this, localGameLogoUrl.sLogoMd5);
          getClass().getField(str3).set(this, localGameLogoUrl.sGameName);
          getClass().getField(str4).set(this, localGameLogoUrl.sAppid);
          for (;;)
          {
            j += 1;
            break label271;
            this.nLastGameFlag &= 0xFFFFFFFD;
            break;
            i = 0;
            break label196;
            label526:
            localGameLogoUrl = null;
            break label294;
            label532:
            if (QLog.isColorLevel()) {
              QLog.i("SummaryCard", 2, "updateLastGameInfo index" + j + "logo is null reset game info");
            }
            getClass().getField(str1).set(this, "");
            getClass().getField(str2).set(this, "");
            getClass().getField(str3).set(this, "");
            getClass().getField(str4).set(this, "");
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("SummaryCard", 2, "updateLastGameInfo get logo index=" + j + " exception");
            }
            localException.printStackTrace();
          }
        }
      }
    }
    this.nLastGameFlag &= 0xFFFFFFFE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.Card
 * JD-Core Version:    0.7.0.1
 */