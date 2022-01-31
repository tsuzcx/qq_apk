package com.tencent.mobileqq.data;

import QQService.EVIPSPEC;
import QQService.TagInfo;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import SummaryCardTaf.SLabelInfo;
import SummaryCardTaf.SSummaryCardRsp;
import SummaryCardTaf.SUserLabel;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.photo.QQGamesPhoto;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Card
  extends Entity
{
  public static final long BIRTHDAY_INVALID = 0L;
  public static final int CONSTELLATION_INVALID = 0;
  public static final short FEMALE = 1;
  public static final short MALE = 0;
  public static final int PROFESSION_DEFAULT = -1;
  public static final short UNKNOWN_MALE = -1;
  public byte age;
  public boolean allowClick;
  public boolean allowPeopleSee;
  public byte bFavorited;
  public byte bQQVipOpen;
  public byte bQzoneInfo;
  public byte bRead = 2;
  public byte bSingle;
  public byte bSuperQQOpen;
  public byte bSuperVipOpen;
  public byte bVoted;
  public byte bWeiboInfo;
  public long backgroundColor = 0L;
  public String backgroundUrl = "";
  public String busiEntry;
  public byte cSqqLevel;
  public int constellation = 0;
  public byte eUserIdentityType;
  public String encId;
  public long feedPreviewTime;
  public int greenLevel = 0;
  public int iFaceNum;
  public int iProfession = -1;
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
  public long lBirthday = 0L;
  public long lCardShowNum;
  public long lCurrentBgId = -1L;
  public long lCurrentStyleId = -1L;
  public long lLoginDays;
  public long lQQMasterLogindays;
  public long lSignModifyTime;
  public long lUserFlag;
  public long lVisitCount;
  public long lVoteCount;
  public byte[] labelInfoBytes;
  public String location;
  public int nFaceID;
  public int nLastGameFlag;
  public int nSameFriendsNum;
  public int nStarFansFlag;
  public String pyFaceUrl;
  public int redLevel = 0;
  @Deprecated
  public short shAge;
  public short shDuration = 0;
  public short shGender = -1;
  public short shType;
  public String starFansJumpUrl;
  public String strAutoRemark;
  public String strCertificationInfo;
  public String strCity;
  public String strCompany;
  public String strCompanySame;
  public String strContactName;
  public String strCountry;
  public String strCurrentBgUrl;
  public String strEmail;
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
  public String strSpaceName;
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
  
  public String getHeadFileHexKey()
  {
    String str = null;
    LinkedList localLinkedList = CardHandler.a(this.strJoinHexAlbumFileKey);
    if (localLinkedList.size() > 0) {
      str = (String)localLinkedList.get(0);
    }
    return str;
  }
  
  public List getLabelList()
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
      localQQGamesPhoto.a = this.strGameLogoKey_1;
      localQQGamesPhoto.b = this.strGameLogoUrl_1;
      localQQGamesPhoto.c = this.strGameName_1;
      localQQGamesPhoto.d = this.strGameAppid_1;
      localArrayList.add(localQQGamesPhoto);
    }
    if ((!TextUtils.isEmpty(this.strGameLogoKey_2)) && (!TextUtils.isEmpty(this.strGameLogoUrl_2)))
    {
      localQQGamesPhoto = new QQGamesPhoto();
      localQQGamesPhoto.a = this.strGameLogoKey_2;
      localQQGamesPhoto.b = this.strGameLogoUrl_2;
      localQQGamesPhoto.c = this.strGameName_2;
      localQQGamesPhoto.d = this.strGameAppid_2;
      localArrayList.add(localQQGamesPhoto);
    }
    if ((!TextUtils.isEmpty(this.strGameLogoKey_3)) && (!TextUtils.isEmpty(this.strGameLogoUrl_3)))
    {
      localQQGamesPhoto = new QQGamesPhoto();
      localQQGamesPhoto.a = this.strGameLogoKey_3;
      localQQGamesPhoto.b = this.strGameLogoUrl_3;
      localQQGamesPhoto.c = this.strGameName_3;
      localQQGamesPhoto.d = this.strGameAppid_3;
      localArrayList.add(localQQGamesPhoto);
    }
    if ((!TextUtils.isEmpty(this.strGameLogoKey_4)) && (!TextUtils.isEmpty(this.strGameLogoUrl_4)))
    {
      localQQGamesPhoto = new QQGamesPhoto();
      localQQGamesPhoto.a = this.strGameLogoKey_4;
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
  
  public void setFeedsShowFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x4;
      return;
    }
    this.ulShowControl &= 0xFFFFFFFB;
  }
  
  public void setLabelList(Map paramMap)
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
  
  public void updateCardTemplate(QQAppInterface paramQQAppInterface, String paramString, SSummaryCardRsp paramSSummaryCardRsp)
  {
    HashMap localHashMap = new HashMap();
    if (paramSSummaryCardRsp != null)
    {
      this.templateRet = paramSSummaryCardRsp.res;
      this.lCurrentStyleId = paramSSummaryCardRsp.styleid;
      this.backgroundUrl = paramSSummaryCardRsp.bgurl;
      this.lCurrentBgId = paramSSummaryCardRsp.bgid;
      this.backgroundColor = paramSSummaryCardRsp.color;
      if ((paramSSummaryCardRsp.label != null) && (paramSSummaryCardRsp.label.label != null)) {
        setLabelList(paramSSummaryCardRsp.label.label);
      }
      localHashMap.put("param_FailCode", "0");
      localHashMap.put("param_templateRet", String.valueOf(paramSSummaryCardRsp.res));
      if (QLog.isColorLevel()) {
        QLog.i("SummaryCard", 2, "updateCardTemplate templateInfo cardid=" + paramSSummaryCardRsp.cardid + ",res=" + paramSSummaryCardRsp.res + ",lCurrentStyleId=" + paramSSummaryCardRsp.styleid + ",backgroundUrl=" + paramSSummaryCardRsp.bgurl + ",lCurrentBgId=" + paramSSummaryCardRsp.bgid + ",backgroundColor=" + paramSSummaryCardRsp.color);
      }
      StatisticCollector.a(paramQQAppInterface.a()).a(paramString, "profileCardGet", true, 0L, 0L, localHashMap, "", false);
      return;
    }
    this.templateRet = 0;
    this.lCurrentStyleId = 0L;
    this.backgroundUrl = "";
    this.lCurrentBgId = 0L;
    this.backgroundColor = 0L;
    if (QLog.isColorLevel()) {
      QLog.i("SummaryCard", 2, "updateCardTemplate templateInfo is null");
    }
    localHashMap.put("param_FailCode", "-101");
    localHashMap.put("param_templateRet", "0");
    StatisticCollector.a(paramQQAppInterface.a()).a(paramString, "profileCardGet", false, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.Card
 * JD-Core Version:    0.7.0.1
 */