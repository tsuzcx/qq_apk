package com.tencent.mobileqq.data;

import GameCenter.GameLogoUrl;
import GameCenter.RespLastGameInfo;
import QQService.EVIPSPEC;
import QQService.TagInfo;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import SummaryCardTaf.SSummaryCardRsp;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.photo.QQGamesPhoto;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class Card
  extends Entity
{
  public byte age;
  public byte bFavorited;
  public byte bQQVipOpen;
  public byte bQzoneInfo;
  public byte bRead = 2;
  public byte bSingle;
  public byte bSuperQQOpen;
  public byte bSuperVipOpen;
  public byte bVoted;
  public byte bWeiboInfo;
  public String busiEntry;
  public byte cSqqLevel;
  public byte eUserIdentityType;
  public String encId;
  public long feedPreviewTime;
  public int greenLevel = 0;
  public int iFaceNum;
  public int iQQLevel;
  public int iQQVipLevel;
  public int iQQVipType;
  public int iSuperQQLevel;
  public int iSuperQQType;
  public int iSuperVipLevel;
  public int iSuperVipType;
  public int iVoteIncrement;
  public boolean isGreenDiamond = false;
  public boolean isRedDiamond = false;
  public boolean isSuperGreenDiamond = false;
  public boolean isSuperRedDiamond = false;
  public boolean isSuperYellowDiamond = false;
  public boolean isYellowDiamond = false;
  public long lBirthday;
  public long lCardShowNum;
  public long lCurrentTemplateId = -1L;
  public long lLoginDays;
  public long lQQMasterLogindays;
  public long lSignModifyTime;
  public long lUserFlag;
  public long lVisitCount;
  public long lVoteCount;
  public String location;
  public int nFaceID;
  public int nLastGameFlag;
  public int nSameFriendsNum;
  public int nStarFansFlag;
  @notColumn
  public List profileBusiEntry;
  public String pyFaceUrl;
  public int redLevel = 0;
  public short shAge;
  public short shDuration = 0;
  public short shGender;
  public short shType;
  public String starFansJumpUrl;
  public String strAutoRemark;
  public String strCertificationInfo;
  public String strCity;
  public String strCompany;
  public String strCompanySame;
  public String strContactName;
  public String strCountry;
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
  public String strJoinHexAlbumFileKey;
  public String strLoginDaysDesc;
  public String strMobile;
  public String strNick;
  public String strProfileUrl;
  public String strProvince;
  public String strQzoneFeedsDesc;
  public String strQzonePicUrl1;
  public String strQzonePicUrl2;
  public String strQzonePicUrl3;
  public String strReMark;
  public String strRespMusicInfo;
  public String strSchool;
  public String strSchoolSame;
  public String strShowName;
  public String strSign;
  public String strStarLogoUrl;
  public String strStarLvUrl_0;
  public String strStarLvUrl_1;
  public String strStarLvUrl_2;
  public String strStarPicUrl_0;
  public String strStarPicUrl_1;
  public String strStarPicUrl_2;
  public String strStatus;
  public String strTroopName;
  public String strTroopNick;
  public String strUrl = "";
  public String strVoiceFilekey = null;
  public byte[] tagInfosByte;
  public int templateRet = 0;
  public long uAccelerateMultiple;
  public int uFaceTimeStamp;
  @unique
  public String uin;
  public int ulShowControl;
  public byte[] vBackground;
  public byte[] vContent;
  public byte[] vCookies;
  public byte[] vQQFaceID;
  public byte[] vRichSign;
  public byte[] vSeed;
  public int yellowLevel = 0;
  
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
  
  public void appendPortrait(List paramList)
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
    this.strJoinHexAlbumFileKey = CardHandler.b(paramList);
  }
  
  public void appendPortrait(byte[] paramArrayOfByte)
  {
    String str2 = HexUtil.bytes2HexStr(paramArrayOfByte);
    if (noAlbumPics()) {}
    for (String str1 = ""; !noAlbumPics(); str1 = this.strJoinHexAlbumFileKey)
    {
      this.strJoinHexAlbumFileKey = (str1 + ";" + HexUtil.bytes2HexStr(paramArrayOfByte));
      return;
    }
    this.strJoinHexAlbumFileKey = str2;
  }
  
  public List getBusiEntrys()
  {
    if (this.profileBusiEntry == null)
    {
      this.profileBusiEntry = new ArrayList();
      if (TextUtils.isEmpty(this.busiEntry)) {}
    }
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(this.busiEntry);
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if (localJSONObject == null) {
            break label178;
          }
          ProfileBusiEntry localProfileBusiEntry = new ProfileBusiEntry();
          localProfileBusiEntry.jdField_a_of_type_Int = localJSONObject.getInt("nBusiEntryType");
          localProfileBusiEntry.jdField_a_of_type_JavaLangString = localJSONObject.getString("strLogoUrl");
          localProfileBusiEntry.b = localJSONObject.getString("strTitle");
          localProfileBusiEntry.c = localJSONObject.getString("strContent");
          localProfileBusiEntry.d = localJSONObject.getString("strJumpUrl");
          if (localProfileBusiEntry.a()) {
            break label178;
          }
          this.profileBusiEntry.add(localProfileBusiEntry);
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, localJSONException.toString());
        }
      }
      return this.profileBusiEntry;
      label178:
      i += 1;
    }
  }
  
  public String getHeadFileHexKey()
  {
    String str = null;
    LinkedList localLinkedList = CardHandler.a(this.strJoinHexAlbumFileKey);
    if (localLinkedList.size() > 0) {
      str = (String)localLinkedList.get(0);
    }
    return str;
  }
  
  public int getLocalPicKeysCount()
  {
    if ((this.strJoinHexAlbumFileKey == null) || (this.strJoinHexAlbumFileKey.length() == 0)) {
      return 0;
    }
    return CardHandler.a(this.strJoinHexAlbumFileKey).size();
  }
  
  public int getPicCountInAlbum()
  {
    return this.iFaceNum;
  }
  
  public List getQZonePhotoList()
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.strQzonePicUrl1)) {
      localArrayList.add(this.strQzonePicUrl1);
    }
    if (!TextUtils.isEmpty(this.strQzonePicUrl2)) {
      localArrayList.add(this.strQzonePicUrl2);
    }
    if (!TextUtils.isEmpty(this.strQzonePicUrl3)) {
      localArrayList.add(this.strQzonePicUrl3);
    }
    return localArrayList;
  }
  
  public List getRecentPlayingGamesPhotoList()
  {
    ArrayList localArrayList = new ArrayList();
    QQGamesPhoto localQQGamesPhoto;
    if ((!TextUtils.isEmpty(this.strGameLogoKey_1)) && (!TextUtils.isEmpty(this.strGameLogoUrl_1)))
    {
      localQQGamesPhoto = new QQGamesPhoto();
      localQQGamesPhoto.jdField_a_of_type_JavaLangString = this.strGameLogoKey_1;
      localQQGamesPhoto.b = this.strGameLogoUrl_1;
      localQQGamesPhoto.c = this.strGameName_1;
      localQQGamesPhoto.d = this.strGameAppid_1;
      localArrayList.add(localQQGamesPhoto);
    }
    if ((!TextUtils.isEmpty(this.strGameLogoKey_2)) && (!TextUtils.isEmpty(this.strGameLogoUrl_2)))
    {
      localQQGamesPhoto = new QQGamesPhoto();
      localQQGamesPhoto.jdField_a_of_type_JavaLangString = this.strGameLogoKey_2;
      localQQGamesPhoto.b = this.strGameLogoUrl_2;
      localQQGamesPhoto.c = this.strGameName_2;
      localQQGamesPhoto.d = this.strGameAppid_2;
      localArrayList.add(localQQGamesPhoto);
    }
    if ((!TextUtils.isEmpty(this.strGameLogoKey_3)) && (!TextUtils.isEmpty(this.strGameLogoUrl_3)))
    {
      localQQGamesPhoto = new QQGamesPhoto();
      localQQGamesPhoto.jdField_a_of_type_JavaLangString = this.strGameLogoKey_3;
      localQQGamesPhoto.b = this.strGameLogoUrl_3;
      localQQGamesPhoto.c = this.strGameName_3;
      localQQGamesPhoto.d = this.strGameAppid_3;
      localArrayList.add(localQQGamesPhoto);
    }
    if ((!TextUtils.isEmpty(this.strGameLogoKey_4)) && (!TextUtils.isEmpty(this.strGameLogoUrl_4)))
    {
      localQQGamesPhoto = new QQGamesPhoto();
      localQQGamesPhoto.jdField_a_of_type_JavaLangString = this.strGameLogoKey_4;
      localQQGamesPhoto.b = this.strGameLogoUrl_4;
      localQQGamesPhoto.c = this.strGameName_4;
      localQQGamesPhoto.d = this.strGameAppid_4;
      localArrayList.add(localQQGamesPhoto);
    }
    return localArrayList;
  }
  
  public RichStatus getRichStatus()
  {
    if ((this.vRichSign == null) || (this.vRichSign.length == 0))
    {
      if ((this.lSignModifyTime <= 0L) && (!TextUtils.isEmpty(this.strSign)))
      {
        localRichStatus = new RichStatus(this.strSign);
        localRichStatus.a = this.lSignModifyTime;
        return localRichStatus;
      }
      return null;
    }
    RichStatus localRichStatus = RichStatus.a(this.vRichSign);
    localRichStatus.a = this.lSignModifyTime;
    return localRichStatus;
  }
  
  public String getStrJoinHexAlbumFileKey()
  {
    return this.strJoinHexAlbumFileKey;
  }
  
  public ArrayList getTagInfoArray()
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
    } while (paramEVIPSPEC != EVIPSPEC.E_SP_SUPERVIP);
    return this.iSuperVipLevel;
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
    } while (paramEVIPSPEC != EVIPSPEC.E_SP_SUPERVIP);
    return this.iSuperVipType;
  }
  
  public boolean hasGotPhotoUrl()
  {
    return ((this.strQzonePicUrl1 != null) && (this.strQzonePicUrl1.length() != 0)) || ((this.strQzonePicUrl2 != null) && (this.strQzonePicUrl2.length() != 0)) || ((this.strQzonePicUrl3 != null) && (this.strQzonePicUrl3.length() != 0));
  }
  
  public boolean isOpenRecentPlayingGamesByNative()
  {
    return (this.nLastGameFlag & 0x2) == 2;
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
  
  public boolean isShowQStarFans()
  {
    return true;
  }
  
  public boolean isShowRecentPlayingGames()
  {
    return (this.nLastGameFlag & 0x1) == 1;
  }
  
  public boolean isShowVoice()
  {
    return (this.ulShowControl & 0x8) != 0;
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
      this.strJoinHexAlbumFileKey = CardHandler.b(localLinkedList);
    }
  }
  
  public void saveBusiEntrys(List paramList)
  {
    JSONStringer localJSONStringer = new JSONStringer();
    int i;
    if (paramList == null)
    {
      i = 0;
      if (i <= 0) {
        break label210;
      }
    }
    for (;;)
    {
      try
      {
        localJSONStringer.array();
        int j = 0;
        if (j < i)
        {
          ProfileBusiEntry localProfileBusiEntry = (ProfileBusiEntry)paramList.get(j);
          if ((localProfileBusiEntry != null) && (!localProfileBusiEntry.a())) {
            localJSONStringer.object().key("nBusiEntryType").value(localProfileBusiEntry.jdField_a_of_type_Int).key("strLogoUrl").value(localProfileBusiEntry.jdField_a_of_type_JavaLangString).key("strTitle").value(localProfileBusiEntry.b).key("strContent").value(localProfileBusiEntry.c).key("strJumpUrl").value(localProfileBusiEntry.d).endObject();
          }
          j += 1;
          continue;
          i = paramList.size();
          break;
        }
        localJSONStringer.endArray();
        this.busiEntry = localJSONStringer.toString();
      }
      catch (JSONException localJSONException)
      {
        label210:
        this.busiEntry = "";
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.profilecard.SummaryCard", 2, localJSONException.toString());
        continue;
      }
      if (this.profileBusiEntry != null)
      {
        this.profileBusiEntry.clear();
        if ((paramList != null) && (paramList.size() > 0)) {
          this.profileBusiEntry.addAll(paramList);
        }
      }
      return;
      this.busiEntry = "";
    }
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
  
  public byte[] setTagInfosByte(Object paramObject)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      this.tagInfosByte = localByteArrayOutputStream.toByteArray();
      paramObject = this.tagInfosByte;
      return paramObject;
    }
    catch (IOException paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  public void setVipInfo(VipBaseInfo paramVipBaseInfo)
  {
    byte b2 = 1;
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      VipOpenInfo localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
      if (localVipOpenInfo != null)
      {
        if (!localVipOpenInfo.bOpen) {
          break label177;
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
          break label182;
        }
        b1 = 1;
        label102:
        this.bSuperQQOpen = b1;
        this.iSuperQQType = localVipOpenInfo.iVipType;
        this.iSuperQQLevel = localVipOpenInfo.iVipLevel;
      }
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      if (paramVipBaseInfo != null) {
        if (!paramVipBaseInfo.bOpen) {
          break label187;
        }
      }
    }
    label177:
    label182:
    label187:
    for (byte b1 = b2;; b1 = 0)
    {
      this.bSuperVipOpen = b1;
      this.iSuperVipType = paramVipBaseInfo.iVipType;
      this.iSuperVipLevel = paramVipBaseInfo.iVipLevel;
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label102;
    }
  }
  
  public void setVoiceShowFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x8;
      return;
    }
    this.ulShowControl &= 0xFFFFFFF7;
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
  
  public void setZanShowFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x1;
      return;
    }
    this.ulShowControl &= 0xFFFFFFFE;
  }
  
  public void updateCardTemplate(SSummaryCardRsp paramSSummaryCardRsp)
  {
    if (paramSSummaryCardRsp != null)
    {
      this.lCurrentTemplateId = paramSSummaryCardRsp.cardid;
      this.templateRet = paramSSummaryCardRsp.res;
      if (QLog.isColorLevel()) {
        QLog.i("SummaryCard", 2, "updateCardTemplate templateInfo cardid=" + paramSSummaryCardRsp.cardid + ",res=" + paramSSummaryCardRsp.res);
      }
    }
    do
    {
      return;
      this.lCurrentTemplateId = 0L;
      this.templateRet = 0;
    } while (!QLog.isColorLevel());
    QLog.i("SummaryCard", 2, "updateCardTemplate templateInfo is null");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.Card
 * JD-Core Version:    0.7.0.1
 */