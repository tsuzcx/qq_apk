import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class akux
  extends OGAbstractDao
{
  public akux()
  {
    this.columnLen = 248;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (Card)paramEntity;
    label1330:
    label2484:
    label2742:
    label4921:
    label4926:
    label5056:
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.strNick = paramCursor.getString(paramCursor.getColumnIndex("strNick"));
      paramEntity.shGender = paramCursor.getShort(paramCursor.getColumnIndex("shGender"));
      paramEntity.shAge = paramCursor.getShort(paramCursor.getColumnIndex("shAge"));
      paramEntity.nFaceID = paramCursor.getInt(paramCursor.getColumnIndex("nFaceID"));
      paramEntity.strCertificationInfo = paramCursor.getString(paramCursor.getColumnIndex("strCertificationInfo"));
      paramEntity.shType = paramCursor.getShort(paramCursor.getColumnIndex("shType"));
      paramEntity.vContent = paramCursor.getBlob(paramCursor.getColumnIndex("vContent"));
      paramEntity.strSign = paramCursor.getString(paramCursor.getColumnIndex("strSign"));
      paramEntity.strCompany = paramCursor.getString(paramCursor.getColumnIndex("strCompany"));
      paramEntity.strSchool = paramCursor.getString(paramCursor.getColumnIndex("strSchool"));
      paramEntity.uFaceTimeStamp = paramCursor.getInt(paramCursor.getColumnIndex("uFaceTimeStamp"));
      paramEntity.vQQFaceID = paramCursor.getBlob(paramCursor.getColumnIndex("vQQFaceID"));
      paramEntity.strReMark = paramCursor.getString(paramCursor.getColumnIndex("strReMark"));
      paramEntity.bWeiboInfo = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bWeiboInfo")));
      paramEntity.bQzoneInfo = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bQzoneInfo")));
      paramEntity.nSameFriendsNum = paramCursor.getInt(paramCursor.getColumnIndex("nSameFriendsNum"));
      paramEntity.strCompanySame = paramCursor.getString(paramCursor.getColumnIndex("strCompanySame"));
      paramEntity.strSchoolSame = paramCursor.getString(paramCursor.getColumnIndex("strSchoolSame"));
      paramEntity.lCardShowNum = paramCursor.getLong(paramCursor.getColumnIndex("lCardShowNum"));
      paramEntity.bSingle = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSingle")));
      paramEntity.lVisitCount = paramCursor.getLong(paramCursor.getColumnIndex("lVisitCount"));
      paramEntity.lVoteCount = paramCursor.getLong(paramCursor.getColumnIndex("lVoteCount"));
      paramEntity.tagInfosByte = paramCursor.getBlob(paramCursor.getColumnIndex("tagInfosByte"));
      paramEntity.eUserIdentityType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("eUserIdentityType")));
      paramEntity.vBackground = paramCursor.getBlob(paramCursor.getColumnIndex("vBackground"));
      paramEntity.labelInfoBytes = paramCursor.getBlob(paramCursor.getColumnIndex("labelInfoBytes"));
      paramEntity.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramEntity.constellation = paramCursor.getInt(paramCursor.getColumnIndex("constellation"));
      paramEntity.pyFaceUrl = paramCursor.getString(paramCursor.getColumnIndex("pyFaceUrl"));
      paramEntity.location = paramCursor.getString(paramCursor.getColumnIndex("location"));
      paramEntity.bVoted = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bVoted")));
      paramEntity.bFavorited = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bFavorited")));
      paramEntity.iVoteIncrement = paramCursor.getInt(paramCursor.getColumnIndex("iVoteIncrement"));
      paramEntity.strJoinHexAlbumFileKey = paramCursor.getString(paramCursor.getColumnIndex("strJoinHexAlbumFileKey"));
      paramEntity.iFaceNum = paramCursor.getInt(paramCursor.getColumnIndex("iFaceNum"));
      paramEntity.cSqqLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSqqLevel")));
      paramEntity.iQQLevel = paramCursor.getInt(paramCursor.getColumnIndex("iQQLevel"));
      paramEntity.uCurMulType = paramCursor.getLong(paramCursor.getColumnIndex("uCurMulType"));
      paramEntity.strProvince = paramCursor.getString(paramCursor.getColumnIndex("strProvince"));
      paramEntity.strCity = paramCursor.getString(paramCursor.getColumnIndex("strCity"));
      paramEntity.strCountry = paramCursor.getString(paramCursor.getColumnIndex("strCountry"));
      paramEntity.lBirthday = paramCursor.getLong(paramCursor.getColumnIndex("lBirthday"));
      paramEntity.strLocationCodes = paramCursor.getString(paramCursor.getColumnIndex("strLocationCodes"));
      paramEntity.strLocationDesc = paramCursor.getString(paramCursor.getColumnIndex("strLocationDesc"));
      paramEntity.strHometownCodes = paramCursor.getString(paramCursor.getColumnIndex("strHometownCodes"));
      paramEntity.strHometownDesc = paramCursor.getString(paramCursor.getColumnIndex("strHometownDesc"));
      paramEntity.strEmail = paramCursor.getString(paramCursor.getColumnIndex("strEmail"));
      paramEntity.strPersonalNote = paramCursor.getString(paramCursor.getColumnIndex("strPersonalNote"));
      paramEntity.iProfession = paramCursor.getInt(paramCursor.getColumnIndex("iProfession"));
      paramEntity.bindPhoneInfo = paramCursor.getString(paramCursor.getColumnIndex("bindPhoneInfo"));
      paramEntity.bCardInfo = paramCursor.getBlob(paramCursor.getColumnIndex("bCardInfo"));
      paramEntity.strTroopName = paramCursor.getString(paramCursor.getColumnIndex("strTroopName"));
      paramEntity.strTroopNick = paramCursor.getString(paramCursor.getColumnIndex("strTroopNick"));
      paramEntity.strMobile = paramCursor.getString(paramCursor.getColumnIndex("strMobile"));
      paramEntity.strContactName = paramCursor.getString(paramCursor.getColumnIndex("strContactName"));
      paramEntity.ulShowControl = paramCursor.getInt(paramCursor.getColumnIndex("ulShowControl"));
      paramEntity.feedPreviewTime = paramCursor.getLong(paramCursor.getColumnIndex("feedPreviewTime"));
      paramEntity.strQzoneFeedsDesc = paramCursor.getString(paramCursor.getColumnIndex("strQzoneFeedsDesc"));
      paramEntity.StrPresentDesc = paramCursor.getString(paramCursor.getColumnIndex("StrPresentDesc"));
      paramEntity.strSpaceName = paramCursor.getString(paramCursor.getColumnIndex("strSpaceName"));
      paramEntity.strQzoneHeader = paramCursor.getString(paramCursor.getColumnIndex("strQzoneHeader"));
      paramEntity.vQzonePhotos = paramCursor.getBlob(paramCursor.getColumnIndex("vQzonePhotos"));
      paramEntity.vQzoneCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vQzoneCoverInfo"));
      paramEntity.enlargeQzonePic = paramCursor.getInt(paramCursor.getColumnIndex("enlargeQzonePic"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("showPublishButton")))
      {
        paramBoolean = true;
        paramEntity.showPublishButton = paramBoolean;
        paramEntity.strStatus = paramCursor.getString(paramCursor.getColumnIndex("strStatus"));
        paramEntity.strAutoRemark = paramCursor.getString(paramCursor.getColumnIndex("strAutoRemark"));
        paramEntity.vSeed = paramCursor.getBlob(paramCursor.getColumnIndex("vSeed"));
        paramEntity.vCookies = paramCursor.getBlob(paramCursor.getColumnIndex("vCookies"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasFakeData"))) {
          break label4916;
        }
        paramBoolean = true;
        paramEntity.hasFakeData = paramBoolean;
        paramEntity.bQQVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bQQVipOpen")));
        paramEntity.iQQVipType = paramCursor.getInt(paramCursor.getColumnIndex("iQQVipType"));
        paramEntity.iQQVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iQQVipLevel"));
        paramEntity.nameplateVipType = paramCursor.getInt(paramCursor.getColumnIndex("nameplateVipType"));
        paramEntity.grayNameplateFlag = paramCursor.getInt(paramCursor.getColumnIndex("grayNameplateFlag"));
        paramEntity.bSuperVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSuperVipOpen")));
        paramEntity.iSuperVipType = paramCursor.getInt(paramCursor.getColumnIndex("iSuperVipType"));
        paramEntity.iSuperVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iSuperVipLevel"));
        paramEntity.bSuperQQOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSuperQQOpen")));
        paramEntity.iSuperQQType = paramCursor.getInt(paramCursor.getColumnIndex("iSuperQQType"));
        paramEntity.iSuperQQLevel = paramCursor.getInt(paramCursor.getColumnIndex("iSuperQQLevel"));
        paramEntity.bHollywoodVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bHollywoodVipOpen")));
        paramEntity.iHollywoodVipType = paramCursor.getInt(paramCursor.getColumnIndex("iHollywoodVipType"));
        paramEntity.iHollywoodVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iHollywoodVipLevel"));
        paramEntity.strShowName = paramCursor.getString(paramCursor.getColumnIndex("strShowName"));
        paramEntity.strVoiceFilekey = paramCursor.getString(paramCursor.getColumnIndex("strVoiceFilekey"));
        paramEntity.shDuration = paramCursor.getShort(paramCursor.getColumnIndex("shDuration"));
        paramEntity.bRead = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bRead")));
        paramEntity.strUrl = paramCursor.getString(paramCursor.getColumnIndex("strUrl"));
        paramEntity.vRichSign = paramCursor.getBlob(paramCursor.getColumnIndex("vRichSign"));
        paramEntity.lSignModifyTime = paramCursor.getLong(paramCursor.getColumnIndex("lSignModifyTime"));
        paramEntity.vLongNickTopicInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vLongNickTopicInfo"));
        paramEntity.nLastGameFlag = paramCursor.getInt(paramCursor.getColumnIndex("nLastGameFlag"));
        paramEntity.strGameLogoUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_1"));
        paramEntity.strGameLogoUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_2"));
        paramEntity.strGameLogoUrl_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_3"));
        paramEntity.strGameLogoUrl_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_4"));
        paramEntity.strGameLogoKey_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_1"));
        paramEntity.strGameLogoKey_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_2"));
        paramEntity.strGameLogoKey_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_3"));
        paramEntity.strGameLogoKey_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_4"));
        paramEntity.strGameName_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_1"));
        paramEntity.strGameName_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_2"));
        paramEntity.strGameName_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_3"));
        paramEntity.strGameName_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_4"));
        paramEntity.strGameAppid_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_1"));
        paramEntity.strGameAppid_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_2"));
        paramEntity.strGameAppid_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_3"));
        paramEntity.strGameAppid_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_4"));
        paramEntity.strProfileUrl = paramCursor.getString(paramCursor.getColumnIndex("strProfileUrl"));
        paramEntity.nStarFansFlag = paramCursor.getInt(paramCursor.getColumnIndex("nStarFansFlag"));
        paramEntity.strStarPicUrl_0 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_0"));
        paramEntity.strStarPicUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_1"));
        paramEntity.strStarPicUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_2"));
        paramEntity.strStarLvUrl_0 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_0"));
        paramEntity.strStarLvUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_1"));
        paramEntity.strStarLvUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_2"));
        paramEntity.strStarLogoUrl = paramCursor.getString(paramCursor.getColumnIndex("strStarLogoUrl"));
        paramEntity.starFansJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("starFansJumpUrl"));
        paramEntity.lUserFlag = paramCursor.getLong(paramCursor.getColumnIndex("lUserFlag"));
        paramEntity.lLoginDays = paramCursor.getLong(paramCursor.getColumnIndex("lLoginDays"));
        paramEntity.strLoginDaysDesc = paramCursor.getString(paramCursor.getColumnIndex("strLoginDaysDesc"));
        paramEntity.lQQMasterLogindays = paramCursor.getLong(paramCursor.getColumnIndex("lQQMasterLogindays"));
        paramEntity.iXManScene1DelayTime = paramCursor.getInt(paramCursor.getColumnIndex("iXManScene1DelayTime"));
        paramEntity.iXManScene2DelayTime = paramCursor.getInt(paramCursor.getColumnIndex("iXManScene2DelayTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowPeopleSee"))) {
          break label4921;
        }
        paramBoolean = true;
        label2406:
        paramEntity.allowPeopleSee = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowCalInteractive"))) {
          break label4926;
        }
        paramBoolean = true;
        paramEntity.allowCalInteractive = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showOnlineFriends"))) {
          break label4931;
        }
        paramBoolean = true;
        paramEntity.showOnlineFriends = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowClick"))) {
          break label4936;
        }
        paramBoolean = true;
        paramEntity.allowClick = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("babyQSwitch"))) {
          break label4941;
        }
        paramBoolean = true;
        label2510:
        paramEntity.babyQSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showLightalk"))) {
          break label4946;
        }
        paramBoolean = true;
        label2536:
        paramEntity.showLightalk = paramBoolean;
        paramEntity.lightalkNick = paramCursor.getString(paramCursor.getColumnIndex("lightalkNick"));
        paramEntity.lightalkId = paramCursor.getString(paramCursor.getColumnIndex("lightalkId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperRedDiamond"))) {
          break label4951;
        }
        paramBoolean = true;
        paramEntity.isSuperRedDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRedDiamond"))) {
          break label4956;
        }
        paramBoolean = true;
        label2626:
        paramEntity.isRedDiamond = paramBoolean;
        paramEntity.redLevel = paramCursor.getInt(paramCursor.getColumnIndex("redLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperYellowDiamond"))) {
          break label4961;
        }
        paramBoolean = true;
        label2671:
        paramEntity.isSuperYellowDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isYellowDiamond"))) {
          break label4966;
        }
        paramBoolean = true;
        paramEntity.isYellowDiamond = paramBoolean;
        paramEntity.yellowLevel = paramCursor.getInt(paramCursor.getColumnIndex("yellowLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperGreenDiamond"))) {
          break label4971;
        }
        paramBoolean = true;
        paramEntity.isSuperGreenDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isGreenDiamond"))) {
          break label4976;
        }
        paramBoolean = true;
        label2768:
        paramEntity.isGreenDiamond = paramBoolean;
        paramEntity.greenLevel = paramCursor.getInt(paramCursor.getColumnIndex("greenLevel"));
        paramEntity.uAccelerateMultiple = paramCursor.getLong(paramCursor.getColumnIndex("uAccelerateMultiple"));
        paramEntity.strRespMusicInfo = paramCursor.getString(paramCursor.getColumnIndex("strRespMusicInfo"));
        paramEntity.templateRet = paramCursor.getInt(paramCursor.getColumnIndex("templateRet"));
        paramEntity.lCurrentStyleId = paramCursor.getLong(paramCursor.getColumnIndex("lCurrentStyleId"));
        paramEntity.lCurrentBgId = paramCursor.getLong(paramCursor.getColumnIndex("lCurrentBgId"));
        paramEntity.backgroundUrl = paramCursor.getString(paramCursor.getColumnIndex("backgroundUrl"));
        paramEntity.backgroundColor = paramCursor.getLong(paramCursor.getColumnIndex("backgroundColor"));
        paramEntity.dynamicCardFlag = paramCursor.getInt(paramCursor.getColumnIndex("dynamicCardFlag"));
        paramEntity.strZipUrl = paramCursor.getString(paramCursor.getColumnIndex("strZipUrl"));
        paramEntity.strActiveUrl = paramCursor.getString(paramCursor.getColumnIndex("strActiveUrl"));
        paramEntity.strDrawerCardUrl = paramCursor.getString(paramCursor.getColumnIndex("strDrawerCardUrl"));
        paramEntity.strWzryHeroUrl = paramCursor.getString(paramCursor.getColumnIndex("strWzryHeroUrl"));
        paramEntity.wzryHonorInfo = paramCursor.getBlob(paramCursor.getColumnIndex("wzryHonorInfo"));
        paramEntity.strExtInfo = paramCursor.getString(paramCursor.getColumnIndex("strExtInfo"));
        paramEntity.strCurrentBgUrl = paramCursor.getString(paramCursor.getColumnIndex("strCurrentBgUrl"));
        paramEntity.bgType = paramCursor.getBlob(paramCursor.getColumnIndex("bgType"));
        paramEntity.encId = paramCursor.getString(paramCursor.getColumnIndex("encId"));
        paramEntity.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
        paramEntity.favoriteSource = paramCursor.getInt(paramCursor.getColumnIndex("favoriteSource"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("visibleMusicPendant"))) {
          break label4981;
        }
        paramBoolean = true;
        label3174:
        paramEntity.visibleMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("autoPlayMusicPendant"))) {
          break label4986;
        }
        paramBoolean = true;
        paramEntity.autoPlayMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showRedPointMusicPendant"))) {
          break label4991;
        }
        paramBoolean = true;
        paramEntity.showRedPointMusicPendant = paramBoolean;
        paramEntity.privilegePromptStr = paramCursor.getString(paramCursor.getColumnIndex("privilegePromptStr"));
        paramEntity.privilegeJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("privilegeJumpUrl"));
        paramEntity.vOpenPriv = paramCursor.getBlob(paramCursor.getColumnIndex("vOpenPriv"));
        paramEntity.vClosePriv = paramCursor.getBlob(paramCursor.getColumnIndex("vClosePriv"));
        paramEntity.presentDesc = paramCursor.getString(paramCursor.getColumnIndex("presentDesc"));
        paramEntity.presentCustourl = paramCursor.getString(paramCursor.getColumnIndex("presentCustourl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("presentSwitch"))) {
          break label4996;
        }
        paramBoolean = true;
        paramEntity.presentSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showPresent"))) {
          break label5001;
        }
        paramBoolean = true;
        label3392:
        paramEntity.showPresent = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showMusicBox"))) {
          break label5006;
        }
        paramBoolean = true;
        label3418:
        paramEntity.showMusicBox = paramBoolean;
        paramEntity.addSrcName = paramCursor.getString(paramCursor.getColumnIndex("addSrcName"));
        paramEntity.addSrcId = paramCursor.getLong(paramCursor.getColumnIndex("addSrcId"));
        paramEntity.addSubSrcId = paramCursor.getLong(paramCursor.getColumnIndex("addSubSrcId"));
        paramEntity.strVoteLimitedNotice = paramCursor.getString(paramCursor.getColumnIndex("strVoteLimitedNotice"));
        paramEntity.bHaveVotedCnt = paramCursor.getShort(paramCursor.getColumnIndex("bHaveVotedCnt"));
        paramEntity.bAvailVoteCnt = paramCursor.getShort(paramCursor.getColumnIndex("bAvailVoteCnt"));
        paramEntity.olympicTorch = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("olympicTorch")));
        paramEntity.mNowShowFlag = paramCursor.getInt(paramCursor.getColumnIndex("mNowShowFlag"));
        paramEntity.mNowShowIconUrl = paramCursor.getString(paramCursor.getColumnIndex("mNowShowIconUrl"));
        paramEntity.mNowShowJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("mNowShowJumpUrl"));
        paramEntity.vCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vCoverInfo"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("videoHeadFlag"))) {
          break label5011;
        }
        paramBoolean = true;
        label3654:
        paramEntity.videoHeadFlag = paramBoolean;
        paramEntity.videoHeadUrl = paramCursor.getString(paramCursor.getColumnIndex("videoHeadUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("medalSwitchDisable"))) {
          break label5016;
        }
        paramBoolean = true;
        label3699:
        paramEntity.medalSwitchDisable = paramBoolean;
        paramEntity.iMedalCount = paramCursor.getInt(paramCursor.getColumnIndex("iMedalCount"));
        paramEntity.iNewCount = paramCursor.getInt(paramCursor.getColumnIndex("iNewCount"));
        paramEntity.iUpgradeCount = paramCursor.getInt(paramCursor.getColumnIndex("iUpgradeCount"));
        paramEntity.strPromptParams = paramCursor.getString(paramCursor.getColumnIndex("strPromptParams"));
        paramEntity.hobbyEntry = paramCursor.getString(paramCursor.getColumnIndex("hobbyEntry"));
        paramEntity.lastPraiseInfoList = paramCursor.getBlob(paramCursor.getColumnIndex("lastPraiseInfoList"));
        paramEntity.tempChatSig = paramCursor.getBlob(paramCursor.getColumnIndex("tempChatSig"));
        paramEntity.namePlateOfKingGameId = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingGameId"));
        paramEntity.namePlateOfKingLoginTime = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingLoginTime"));
        paramEntity.namePlateOfKingDan = paramCursor.getInt(paramCursor.getColumnIndex("namePlateOfKingDan"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch"))) {
          break label5021;
        }
        paramBoolean = true;
        label3915:
        paramEntity.namePlateOfKingDanDisplatSwitch = paramBoolean;
        paramEntity.vPersonalityLabelV2 = paramCursor.getBlob(paramCursor.getColumnIndex("vPersonalityLabelV2"));
        paramEntity.cardType = paramCursor.getInt(paramCursor.getColumnIndex("cardType"));
        paramEntity.diyText = paramCursor.getString(paramCursor.getColumnIndex("diyText"));
        paramEntity.diyTextFontId = paramCursor.getInt(paramCursor.getColumnIndex("diyTextFontId"));
        paramEntity.diyTextWidth = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextWidth"));
        paramEntity.diyTextHeight = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextHeight"));
        paramEntity.diyTextLocX = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextLocX"));
        paramEntity.diyTextLocY = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextLocY"));
        paramEntity.diyTextDegree = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextDegree"));
        paramEntity.diyTextScale = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextScale"));
        paramEntity.diyTextTransparency = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextTransparency"));
        paramEntity.diyDefaultText = paramCursor.getString(paramCursor.getColumnIndex("diyDefaultText"));
        paramEntity.popularity = paramCursor.getInt(paramCursor.getColumnIndex("popularity"));
        paramEntity.declaration = paramCursor.getString(paramCursor.getColumnIndex("declaration"));
        paramEntity.voiceUrl = paramCursor.getString(paramCursor.getColumnIndex("voiceUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShowCard"))) {
          break label5026;
        }
        paramBoolean = true;
        paramEntity.isShowCard = paramBoolean;
        paramEntity.updateTime = paramCursor.getLong(paramCursor.getColumnIndex("updateTime"));
        paramEntity.extendFriendFlag = paramCursor.getInt(paramCursor.getColumnIndex("extendFriendFlag"));
        paramEntity.extendFriendVoiceDuration = paramCursor.getInt(paramCursor.getColumnIndex("extendFriendVoiceDuration"));
        paramEntity.extendFriendEntryContact = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendEntryContact"));
        paramEntity.extendFriendEntryAddFriend = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendEntryAddFriend"));
        paramEntity.extendFriendQuestion = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendQuestion"));
        paramEntity.fontId = paramCursor.getInt(paramCursor.getColumnIndex("fontId"));
        paramEntity.fontType = paramCursor.getInt(paramCursor.getColumnIndex("fontType"));
        paramEntity.clothesId = paramCursor.getInt(paramCursor.getColumnIndex("clothesId"));
        paramEntity.schoolId = paramCursor.getString(paramCursor.getColumnIndex("schoolId"));
        paramEntity.schoolName = paramCursor.getString(paramCursor.getColumnIndex("schoolName"));
        paramEntity.authState = paramCursor.getLong(paramCursor.getColumnIndex("authState"));
        paramEntity.idx = paramCursor.getInt(paramCursor.getColumnIndex("idx"));
        paramEntity.category = paramCursor.getInt(paramCursor.getColumnIndex("category"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShowMiniPlaying"))) {
          break label5031;
        }
        paramBoolean = true;
        paramEntity.isShowMiniPlaying = paramBoolean;
        paramEntity.tabJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("tabJumpUrl"));
        paramEntity.guestJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("guestJumpUrl"));
        paramEntity.guestAppTotal = paramCursor.getInt(paramCursor.getColumnIndex("guestAppTotal"));
        paramEntity.defaultCardId = paramCursor.getInt(paramCursor.getColumnIndex("defaultCardId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("strangerVoteOpen"))) {
          break label5036;
        }
        paramBoolean = true;
        paramEntity.strangerVoteOpen = paramBoolean;
        paramEntity.lSuperVipTemplateId = paramCursor.getLong(paramCursor.getColumnIndex("lSuperVipTemplateId"));
        paramEntity.bBigClubVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bBigClubVipOpen")));
        paramEntity.iBigClubVipType = paramCursor.getInt(paramCursor.getColumnIndex("iBigClubVipType"));
        paramEntity.iBigClubVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iBigClubVipLevel"));
        paramEntity.lBigClubTemplateId = paramCursor.getLong(paramCursor.getColumnIndex("lBigClubTemplateId"));
        paramEntity.diyComplicatedInfo = paramCursor.getString(paramCursor.getColumnIndex("diyComplicatedInfo"));
        paramEntity.cardId = paramCursor.getLong(paramCursor.getColumnIndex("cardId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("strangerInviteMeGroupOpen"))) {
          break label5041;
        }
        paramBoolean = true;
        paramEntity.strangerInviteMeGroupOpen = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isPrettyGroupOwner"))) {
          break label5046;
        }
        paramBoolean = true;
        label4806:
        paramEntity.isPrettyGroupOwner = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isHidePrettyGroutIdentity"))) {
          break label5051;
        }
        paramBoolean = true;
        label4832:
        paramEntity.isHidePrettyGroutIdentity = paramBoolean;
        paramEntity.mQQLevelType = paramCursor.getInt(paramCursor.getColumnIndex("mQQLevelType"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("schoolVerifiedFlag"))) {
          break label5056;
        }
        paramBoolean = true;
        paramEntity.schoolVerifiedFlag = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("troopHonorSwitch"))) {
          break label5061;
        }
      }
      label4931:
      label5061:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.troopHonorSwitch = paramBoolean;
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1330;
        paramBoolean = false;
        break label2406;
        paramBoolean = false;
        break label2432;
        paramBoolean = false;
        break label2458;
        label4936:
        paramBoolean = false;
        break label2484;
        label4941:
        paramBoolean = false;
        break label2510;
        label4946:
        paramBoolean = false;
        break label2536;
        label4951:
        paramBoolean = false;
        break label2600;
        label4956:
        paramBoolean = false;
        break label2626;
        label4961:
        paramBoolean = false;
        break label2671;
        label4966:
        paramBoolean = false;
        break label2697;
        label4971:
        paramBoolean = false;
        break label2742;
        label4976:
        paramBoolean = false;
        break label2768;
        label4981:
        paramBoolean = false;
        break label3174;
        label4986:
        paramBoolean = false;
        break label3200;
        label4991:
        paramBoolean = false;
        break label3226;
        paramBoolean = false;
        break label3366;
        paramBoolean = false;
        break label3392;
        paramBoolean = false;
        break label3418;
        paramBoolean = false;
        break label3654;
        paramBoolean = false;
        break label3699;
        paramBoolean = false;
        break label3915;
        paramBoolean = false;
        break label4226;
        paramBoolean = false;
        break label4518;
        paramBoolean = false;
        break label4620;
        paramBoolean = false;
        break label4780;
        paramBoolean = false;
        break label4806;
        paramBoolean = false;
        break label4832;
        paramBoolean = false;
        break label4877;
      }
    }
    label2432:
    label2458:
    label2600:
    label4780:
    label4916:
    label5046:
    label5051:
    int i = paramCursor.getColumnIndex("uin");
    label2697:
    label3226:
    label3366:
    label5031:
    label5036:
    label5041:
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("strNick");
      if (i != -1) {
        break label14155;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strNick", String.class));
      i = paramCursor.getColumnIndex("shGender");
      if (i != -1) {
        break label14170;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("shGender", Short.TYPE));
      label5171:
      i = paramCursor.getColumnIndex("shAge");
      if (i != -1) {
        break label14185;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("shAge", Short.TYPE));
      label5206:
      i = paramCursor.getColumnIndex("nFaceID");
      if (i != -1) {
        break label14200;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nFaceID", Integer.TYPE));
      label5241:
      i = paramCursor.getColumnIndex("strCertificationInfo");
      if (i != -1) {
        break label14215;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCertificationInfo", String.class));
      i = paramCursor.getColumnIndex("shType");
      if (i != -1) {
        break label14230;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("shType", Short.TYPE));
      label5311:
      i = paramCursor.getColumnIndex("vContent");
      if (i != -1) {
        break label14245;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vContent", [B.class));
      label5346:
      i = paramCursor.getColumnIndex("strSign");
      if (i != -1) {
        break label14260;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strSign", String.class));
      i = paramCursor.getColumnIndex("strCompany");
      if (i != -1) {
        break label14275;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCompany", String.class));
      i = paramCursor.getColumnIndex("strSchool");
      if (i != -1) {
        break label14290;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strSchool", String.class));
      label5451:
      i = paramCursor.getColumnIndex("uFaceTimeStamp");
      if (i != -1) {
        break label14305;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uFaceTimeStamp", Integer.TYPE));
      label5486:
      i = paramCursor.getColumnIndex("vQQFaceID");
      if (i != -1) {
        break label14320;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vQQFaceID", [B.class));
      i = paramCursor.getColumnIndex("strReMark");
      if (i != -1) {
        break label14335;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strReMark", String.class));
      label5556:
      i = paramCursor.getColumnIndex("bWeiboInfo");
      if (i != -1) {
        break label14350;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bWeiboInfo", Byte.TYPE));
      label5591:
      i = paramCursor.getColumnIndex("bQzoneInfo");
      if (i != -1) {
        break label14366;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bQzoneInfo", Byte.TYPE));
      label5626:
      i = paramCursor.getColumnIndex("nSameFriendsNum");
      if (i != -1) {
        break label14382;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nSameFriendsNum", Integer.TYPE));
      i = paramCursor.getColumnIndex("strCompanySame");
      if (i != -1) {
        break label14397;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCompanySame", String.class));
      label5696:
      i = paramCursor.getColumnIndex("strSchoolSame");
      if (i != -1) {
        break label14412;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strSchoolSame", String.class));
      label5731:
      i = paramCursor.getColumnIndex("lCardShowNum");
      if (i != -1) {
        break label14427;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lCardShowNum", Long.TYPE));
      i = paramCursor.getColumnIndex("bSingle");
      if (i != -1) {
        break label14442;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bSingle", Byte.TYPE));
      i = paramCursor.getColumnIndex("lVisitCount");
      if (i != -1) {
        break label14458;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lVisitCount", Long.TYPE));
      label5836:
      i = paramCursor.getColumnIndex("lVoteCount");
      if (i != -1) {
        break label14473;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lVoteCount", Long.TYPE));
      label5871:
      i = paramCursor.getColumnIndex("tagInfosByte");
      if (i != -1) {
        break label14488;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tagInfosByte", [B.class));
      i = paramCursor.getColumnIndex("eUserIdentityType");
      if (i != -1) {
        break label14503;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("eUserIdentityType", Byte.TYPE));
      label5941:
      i = paramCursor.getColumnIndex("vBackground");
      if (i != -1) {
        break label14519;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vBackground", [B.class));
      label5976:
      i = paramCursor.getColumnIndex("labelInfoBytes");
      if (i != -1) {
        break label14534;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("labelInfoBytes", [B.class));
      label6011:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label14549;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("age", Byte.TYPE));
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label14565;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("constellation", Integer.TYPE));
      label6081:
      i = paramCursor.getColumnIndex("pyFaceUrl");
      if (i != -1) {
        break label14580;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pyFaceUrl", String.class));
      label6116:
      i = paramCursor.getColumnIndex("location");
      if (i != -1) {
        break label14595;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("location", String.class));
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label14610;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bVoted", Byte.TYPE));
      i = paramCursor.getColumnIndex("bFavorited");
      if (i != -1) {
        break label14626;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bFavorited", Byte.TYPE));
      label6221:
      i = paramCursor.getColumnIndex("iVoteIncrement");
      if (i != -1) {
        break label14642;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iVoteIncrement", Integer.TYPE));
      label6256:
      i = paramCursor.getColumnIndex("strJoinHexAlbumFileKey");
      if (i != -1) {
        break label14657;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strJoinHexAlbumFileKey", String.class));
      i = paramCursor.getColumnIndex("iFaceNum");
      if (i != -1) {
        break label14672;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iFaceNum", Integer.TYPE));
      label6326:
      i = paramCursor.getColumnIndex("cSqqLevel");
      if (i != -1) {
        break label14687;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cSqqLevel", Byte.TYPE));
      label6361:
      i = paramCursor.getColumnIndex("iQQLevel");
      if (i != -1) {
        break label14703;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iQQLevel", Integer.TYPE));
      label6396:
      i = paramCursor.getColumnIndex("uCurMulType");
      if (i != -1) {
        break label14718;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uCurMulType", Long.TYPE));
      i = paramCursor.getColumnIndex("strProvince");
      if (i != -1) {
        break label14733;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strProvince", String.class));
      label6466:
      i = paramCursor.getColumnIndex("strCity");
      if (i != -1) {
        break label14748;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCity", String.class));
      label6501:
      i = paramCursor.getColumnIndex("strCountry");
      if (i != -1) {
        break label14763;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCountry", String.class));
      i = paramCursor.getColumnIndex("lBirthday");
      if (i != -1) {
        break label14778;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lBirthday", Long.TYPE));
      i = paramCursor.getColumnIndex("strLocationCodes");
      if (i != -1) {
        break label14793;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLocationCodes", String.class));
      label6606:
      i = paramCursor.getColumnIndex("strLocationDesc");
      if (i != -1) {
        break label14808;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLocationDesc", String.class));
      label6641:
      i = paramCursor.getColumnIndex("strHometownCodes");
      if (i != -1) {
        break label14823;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHometownCodes", String.class));
      i = paramCursor.getColumnIndex("strHometownDesc");
      if (i != -1) {
        break label14838;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHometownDesc", String.class));
      label6711:
      i = paramCursor.getColumnIndex("strEmail");
      if (i != -1) {
        break label14853;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strEmail", String.class));
      label6746:
      i = paramCursor.getColumnIndex("strPersonalNote");
      if (i != -1) {
        break label14868;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strPersonalNote", String.class));
      label6781:
      i = paramCursor.getColumnIndex("iProfession");
      if (i != -1) {
        break label14883;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iProfession", Integer.TYPE));
      i = paramCursor.getColumnIndex("bindPhoneInfo");
      if (i != -1) {
        break label14898;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bindPhoneInfo", String.class));
      label6851:
      i = paramCursor.getColumnIndex("bCardInfo");
      if (i != -1) {
        break label14913;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bCardInfo", [B.class));
      label6886:
      i = paramCursor.getColumnIndex("strTroopName");
      if (i != -1) {
        break label14928;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strTroopName", String.class));
      i = paramCursor.getColumnIndex("strTroopNick");
      if (i != -1) {
        break label14943;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strTroopNick", String.class));
      i = paramCursor.getColumnIndex("strMobile");
      if (i != -1) {
        break label14958;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strMobile", String.class));
      label6997:
      i = paramCursor.getColumnIndex("strContactName");
      if (i != -1) {
        break label14973;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strContactName", String.class));
      label7034:
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label14988;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ulShowControl", Integer.TYPE));
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label15003;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feedPreviewTime", Long.TYPE));
      label7108:
      i = paramCursor.getColumnIndex("strQzoneFeedsDesc");
      if (i != -1) {
        break label15018;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strQzoneFeedsDesc", String.class));
      label7145:
      i = paramCursor.getColumnIndex("StrPresentDesc");
      if (i != -1) {
        break label15033;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("StrPresentDesc", String.class));
      i = paramCursor.getColumnIndex("strSpaceName");
      if (i != -1) {
        break label15048;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strSpaceName", String.class));
      label7219:
      i = paramCursor.getColumnIndex("strQzoneHeader");
      if (i != -1) {
        break label15063;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strQzoneHeader", String.class));
      label7256:
      i = paramCursor.getColumnIndex("vQzonePhotos");
      if (i != -1) {
        break label15078;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vQzonePhotos", [B.class));
      label7293:
      i = paramCursor.getColumnIndex("vQzoneCoverInfo");
      if (i != -1) {
        break label15093;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vQzoneCoverInfo", [B.class));
      i = paramCursor.getColumnIndex("enlargeQzonePic");
      if (i != -1) {
        break label15108;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("enlargeQzonePic", Integer.TYPE));
      label7367:
      i = paramCursor.getColumnIndex("showPublishButton");
      if (i != -1) {
        break label15123;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showPublishButton", Boolean.TYPE));
      i = paramCursor.getColumnIndex("strStatus");
      if (i != -1) {
        break label15150;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strStatus", String.class));
      i = paramCursor.getColumnIndex("strAutoRemark");
      if (i != -1) {
        break label15165;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strAutoRemark", String.class));
      label7478:
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label15180;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vSeed", [B.class));
      label7515:
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label15195;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vCookies", [B.class));
      i = paramCursor.getColumnIndex("hasFakeData");
      if (i != -1) {
        break label15210;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasFakeData", Boolean.TYPE));
      i = paramCursor.getColumnIndex("bQQVipOpen");
      if (i != -1) {
        break label15237;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bQQVipOpen", Byte.TYPE));
      label7626:
      i = paramCursor.getColumnIndex("iQQVipType");
      if (i != -1) {
        break label15253;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iQQVipType", Integer.TYPE));
      label7663:
      i = paramCursor.getColumnIndex("iQQVipLevel");
      if (i != -1) {
        break label15268;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iQQVipLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("nameplateVipType");
      if (i != -1) {
        break label15283;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nameplateVipType", Integer.TYPE));
      label7737:
      i = paramCursor.getColumnIndex("grayNameplateFlag");
      if (i != -1) {
        break label15298;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("grayNameplateFlag", Integer.TYPE));
      label7774:
      i = paramCursor.getColumnIndex("bSuperVipOpen");
      if (i != -1) {
        break label15313;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bSuperVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iSuperVipType");
      if (i != -1) {
        break label15329;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iSuperVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iSuperVipLevel");
      if (i != -1) {
        break label15344;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iSuperVipLevel", Integer.TYPE));
      label7885:
      i = paramCursor.getColumnIndex("bSuperQQOpen");
      if (i != -1) {
        break label15359;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bSuperQQOpen", Byte.TYPE));
      label7922:
      i = paramCursor.getColumnIndex("iSuperQQType");
      if (i != -1) {
        break label15375;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iSuperQQType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iSuperQQLevel");
      if (i != -1) {
        break label15390;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iSuperQQLevel", Integer.TYPE));
      label7996:
      i = paramCursor.getColumnIndex("bHollywoodVipOpen");
      if (i != -1) {
        break label15405;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bHollywoodVipOpen", Byte.TYPE));
      label8033:
      i = paramCursor.getColumnIndex("iHollywoodVipType");
      if (i != -1) {
        break label15421;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iHollywoodVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iHollywoodVipLevel");
      if (i != -1) {
        break label15436;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iHollywoodVipLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("strShowName");
      if (i != -1) {
        break label15451;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strShowName", String.class));
      label8144:
      i = paramCursor.getColumnIndex("strVoiceFilekey");
      if (i != -1) {
        break label15466;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strVoiceFilekey", String.class));
      label8181:
      i = paramCursor.getColumnIndex("shDuration");
      if (i != -1) {
        break label15481;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("shDuration", Short.TYPE));
      i = paramCursor.getColumnIndex("bRead");
      if (i != -1) {
        break label15496;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bRead", Byte.TYPE));
      label8255:
      i = paramCursor.getColumnIndex("strUrl");
      if (i != -1) {
        break label15512;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strUrl", String.class));
      label8292:
      i = paramCursor.getColumnIndex("vRichSign");
      if (i != -1) {
        break label15527;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vRichSign", [B.class));
      i = paramCursor.getColumnIndex("lSignModifyTime");
      if (i != -1) {
        break label15542;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lSignModifyTime", Long.TYPE));
      i = paramCursor.getColumnIndex("vLongNickTopicInfo");
      if (i != -1) {
        break label15557;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vLongNickTopicInfo", [B.class));
      label8403:
      i = paramCursor.getColumnIndex("nLastGameFlag");
      if (i != -1) {
        break label15572;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nLastGameFlag", Integer.TYPE));
      label8440:
      i = paramCursor.getColumnIndex("strGameLogoUrl_1");
      if (i != -1) {
        break label15587;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGameLogoUrl_1", String.class));
      i = paramCursor.getColumnIndex("strGameLogoUrl_2");
      if (i != -1) {
        break label15602;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGameLogoUrl_2", String.class));
      label8514:
      i = paramCursor.getColumnIndex("strGameLogoUrl_3");
      if (i != -1) {
        break label15617;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGameLogoUrl_3", String.class));
      label8551:
      i = paramCursor.getColumnIndex("strGameLogoUrl_4");
      if (i != -1) {
        break label15632;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGameLogoUrl_4", String.class));
      i = paramCursor.getColumnIndex("strGameLogoKey_1");
      if (i != -1) {
        break label15647;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGameLogoKey_1", String.class));
      label8625:
      i = paramCursor.getColumnIndex("strGameLogoKey_2");
      if (i != -1) {
        break label15662;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGameLogoKey_2", String.class));
      label8662:
      i = paramCursor.getColumnIndex("strGameLogoKey_3");
      if (i != -1) {
        break label15677;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGameLogoKey_3", String.class));
      label8699:
      i = paramCursor.getColumnIndex("strGameLogoKey_4");
      if (i != -1) {
        break label15692;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGameLogoKey_4", String.class));
      i = paramCursor.getColumnIndex("strGameName_1");
      if (i != -1) {
        break label15707;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGameName_1", String.class));
      label8773:
      i = paramCursor.getColumnIndex("strGameName_2");
      if (i != -1) {
        break label15722;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGameName_2", String.class));
      label8810:
      i = paramCursor.getColumnIndex("strGameName_3");
      if (i != -1) {
        break label15737;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGameName_3", String.class));
      i = paramCursor.getColumnIndex("strGameName_4");
      if (i != -1) {
        break label15752;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGameName_4", String.class));
      label8884:
      i = paramCursor.getColumnIndex("strGameAppid_1");
      if (i != -1) {
        break label15767;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGameAppid_1", String.class));
      label8921:
      i = paramCursor.getColumnIndex("strGameAppid_2");
      if (i != -1) {
        break label15782;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGameAppid_2", String.class));
      label8958:
      i = paramCursor.getColumnIndex("strGameAppid_3");
      if (i != -1) {
        break label15797;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGameAppid_3", String.class));
      i = paramCursor.getColumnIndex("strGameAppid_4");
      if (i != -1) {
        break label15812;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGameAppid_4", String.class));
      label9032:
      i = paramCursor.getColumnIndex("strProfileUrl");
      if (i != -1) {
        break label15827;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strProfileUrl", String.class));
      label9069:
      i = paramCursor.getColumnIndex("nStarFansFlag");
      if (i != -1) {
        break label15842;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nStarFansFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("strStarPicUrl_0");
      if (i != -1) {
        break label15857;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strStarPicUrl_0", String.class));
      label9143:
      i = paramCursor.getColumnIndex("strStarPicUrl_1");
      if (i != -1) {
        break label15872;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strStarPicUrl_1", String.class));
      label9180:
      i = paramCursor.getColumnIndex("strStarPicUrl_2");
      if (i != -1) {
        break label15887;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strStarPicUrl_2", String.class));
      i = paramCursor.getColumnIndex("strStarLvUrl_0");
      if (i != -1) {
        break label15902;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strStarLvUrl_0", String.class));
      i = paramCursor.getColumnIndex("strStarLvUrl_1");
      if (i != -1) {
        break label15917;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strStarLvUrl_1", String.class));
      label9291:
      i = paramCursor.getColumnIndex("strStarLvUrl_2");
      if (i != -1) {
        break label15932;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strStarLvUrl_2", String.class));
      label9328:
      i = paramCursor.getColumnIndex("strStarLogoUrl");
      if (i != -1) {
        break label15947;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strStarLogoUrl", String.class));
      i = paramCursor.getColumnIndex("starFansJumpUrl");
      if (i != -1) {
        break label15962;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("starFansJumpUrl", String.class));
      label9402:
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label15977;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lUserFlag", Long.TYPE));
      label9439:
      i = paramCursor.getColumnIndex("lLoginDays");
      if (i != -1) {
        break label15992;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lLoginDays", Long.TYPE));
      i = paramCursor.getColumnIndex("strLoginDaysDesc");
      if (i != -1) {
        break label16007;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLoginDaysDesc", String.class));
      i = paramCursor.getColumnIndex("lQQMasterLogindays");
      if (i != -1) {
        break label16022;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lQQMasterLogindays", Long.TYPE));
      label9550:
      i = paramCursor.getColumnIndex("iXManScene1DelayTime");
      if (i != -1) {
        break label16037;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iXManScene1DelayTime", Integer.TYPE));
      label9587:
      i = paramCursor.getColumnIndex("iXManScene2DelayTime");
      if (i != -1) {
        break label16052;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iXManScene2DelayTime", Integer.TYPE));
      i = paramCursor.getColumnIndex("allowPeopleSee");
      if (i != -1) {
        break label16067;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowPeopleSee", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowCalInteractive");
      if (i != -1) {
        break label16094;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowCalInteractive", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showOnlineFriends");
      if (i != -1) {
        break label16121;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showOnlineFriends", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowClick");
      if (i != -1) {
        break label16148;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowClick", Boolean.TYPE));
      i = paramCursor.getColumnIndex("babyQSwitch");
      if (i != -1) {
        break label16175;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("babyQSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showLightalk");
      if (i != -1) {
        break label16202;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showLightalk", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lightalkNick");
      if (i != -1) {
        break label16229;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lightalkNick", String.class));
      i = paramCursor.getColumnIndex("lightalkId");
      if (i != -1) {
        break label16244;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lightalkId", String.class));
      label9920:
      i = paramCursor.getColumnIndex("isSuperRedDiamond");
      if (i != -1) {
        break label16259;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSuperRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRedDiamond");
      if (i != -1) {
        break label16286;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("redLevel");
      if (i != -1) {
        break label16313;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("redLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("isSuperYellowDiamond");
      if (i != -1) {
        break label16328;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSuperYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isYellowDiamond");
      if (i != -1) {
        break label16355;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("yellowLevel");
      if (i != -1) {
        break label16382;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("yellowLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("isSuperGreenDiamond");
      if (i != -1) {
        break label16397;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSuperGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isGreenDiamond");
      if (i != -1) {
        break label16424;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("greenLevel");
      if (i != -1) {
        break label16451;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("greenLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("uAccelerateMultiple");
      if (i != -1) {
        break label16466;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uAccelerateMultiple", Long.TYPE));
      label10290:
      i = paramCursor.getColumnIndex("strRespMusicInfo");
      if (i != -1) {
        break label16481;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strRespMusicInfo", String.class));
      label10327:
      i = paramCursor.getColumnIndex("templateRet");
      if (i != -1) {
        break label16496;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("templateRet", Integer.TYPE));
      label10364:
      i = paramCursor.getColumnIndex("lCurrentStyleId");
      if (i != -1) {
        break label16511;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lCurrentStyleId", Long.TYPE));
      i = paramCursor.getColumnIndex("lCurrentBgId");
      if (i != -1) {
        break label16526;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lCurrentBgId", Long.TYPE));
      label10438:
      i = paramCursor.getColumnIndex("backgroundUrl");
      if (i != -1) {
        break label16541;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("backgroundUrl", String.class));
      label10475:
      i = paramCursor.getColumnIndex("backgroundColor");
      if (i != -1) {
        break label16556;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("backgroundColor", Long.TYPE));
      i = paramCursor.getColumnIndex("dynamicCardFlag");
      if (i != -1) {
        break label16571;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dynamicCardFlag", Integer.TYPE));
      label10549:
      i = paramCursor.getColumnIndex("strZipUrl");
      if (i != -1) {
        break label16586;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strZipUrl", String.class));
      label10586:
      i = paramCursor.getColumnIndex("strActiveUrl");
      if (i != -1) {
        break label16601;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strActiveUrl", String.class));
      label10623:
      i = paramCursor.getColumnIndex("strDrawerCardUrl");
      if (i != -1) {
        break label16616;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strDrawerCardUrl", String.class));
      i = paramCursor.getColumnIndex("strWzryHeroUrl");
      if (i != -1) {
        break label16631;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strWzryHeroUrl", String.class));
      label10697:
      i = paramCursor.getColumnIndex("wzryHonorInfo");
      if (i != -1) {
        break label16646;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wzryHonorInfo", [B.class));
      label10734:
      i = paramCursor.getColumnIndex("strExtInfo");
      if (i != -1) {
        break label16661;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strExtInfo", String.class));
      i = paramCursor.getColumnIndex("strCurrentBgUrl");
      if (i != -1) {
        break label16676;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCurrentBgUrl", String.class));
      label10808:
      i = paramCursor.getColumnIndex("bgType");
      if (i != -1) {
        break label16691;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bgType", [B.class));
      label10845:
      i = paramCursor.getColumnIndex("encId");
      if (i != -1) {
        break label16706;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("encId", String.class));
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label16721;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("busiEntry", String.class));
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label16736;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("favoriteSource", Integer.TYPE));
      label10956:
      i = paramCursor.getColumnIndex("visibleMusicPendant");
      if (i != -1) {
        break label16751;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("visibleMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("autoPlayMusicPendant");
      if (i != -1) {
        break label16778;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("autoPlayMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showRedPointMusicPendant");
      if (i != -1) {
        break label16805;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showRedPointMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("privilegePromptStr");
      if (i != -1) {
        break label16832;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("privilegePromptStr", String.class));
      label11104:
      i = paramCursor.getColumnIndex("privilegeJumpUrl");
      if (i != -1) {
        break label16847;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("privilegeJumpUrl", String.class));
      i = paramCursor.getColumnIndex("vOpenPriv");
      if (i != -1) {
        break label16862;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vOpenPriv", [B.class));
      i = paramCursor.getColumnIndex("vClosePriv");
      if (i != -1) {
        break label16877;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vClosePriv", [B.class));
      label11215:
      i = paramCursor.getColumnIndex("presentDesc");
      if (i != -1) {
        break label16892;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("presentDesc", String.class));
      label11252:
      i = paramCursor.getColumnIndex("presentCustourl");
      if (i != -1) {
        break label16907;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("presentCustourl", String.class));
      i = paramCursor.getColumnIndex("presentSwitch");
      if (i != -1) {
        break label16922;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("presentSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showPresent");
      if (i != -1) {
        break label16949;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showPresent", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showMusicBox");
      if (i != -1) {
        break label16976;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showMusicBox", Boolean.TYPE));
      i = paramCursor.getColumnIndex("addSrcName");
      if (i != -1) {
        break label17003;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("addSrcName", String.class));
      i = paramCursor.getColumnIndex("addSrcId");
      if (i != -1) {
        break label17018;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("addSrcId", Long.TYPE));
      label11474:
      i = paramCursor.getColumnIndex("addSubSrcId");
      if (i != -1) {
        break label17033;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("addSubSrcId", Long.TYPE));
      label11511:
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label17048;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strVoteLimitedNotice", String.class));
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label17063;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label11585:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label17078;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      label11622:
      i = paramCursor.getColumnIndex("olympicTorch");
      if (i != -1) {
        break label17093;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("olympicTorch", Byte.TYPE));
      i = paramCursor.getColumnIndex("mNowShowFlag");
      if (i != -1) {
        break label17109;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mNowShowFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("mNowShowIconUrl");
      if (i != -1) {
        break label17124;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mNowShowIconUrl", String.class));
      label11733:
      i = paramCursor.getColumnIndex("mNowShowJumpUrl");
      if (i != -1) {
        break label17139;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mNowShowJumpUrl", String.class));
      label11770:
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label17154;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vCoverInfo", [B.class));
      i = paramCursor.getColumnIndex("videoHeadFlag");
      if (i != -1) {
        break label17169;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("videoHeadFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("videoHeadUrl");
      if (i != -1) {
        break label17196;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("videoHeadUrl", String.class));
      label11881:
      i = paramCursor.getColumnIndex("medalSwitchDisable");
      if (i != -1) {
        break label17211;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("medalSwitchDisable", Boolean.TYPE));
      i = paramCursor.getColumnIndex("iMedalCount");
      if (i != -1) {
        break label17238;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iMedalCount", Integer.TYPE));
      label11955:
      i = paramCursor.getColumnIndex("iNewCount");
      if (i != -1) {
        break label17253;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iNewCount", Integer.TYPE));
      label11992:
      i = paramCursor.getColumnIndex("iUpgradeCount");
      if (i != -1) {
        break label17268;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iUpgradeCount", Integer.TYPE));
      label12029:
      i = paramCursor.getColumnIndex("strPromptParams");
      if (i != -1) {
        break label17283;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strPromptParams", String.class));
      i = paramCursor.getColumnIndex("hobbyEntry");
      if (i != -1) {
        break label17298;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hobbyEntry", String.class));
      label12103:
      i = paramCursor.getColumnIndex("lastPraiseInfoList");
      if (i != -1) {
        break label17313;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastPraiseInfoList", [B.class));
      label12140:
      i = paramCursor.getColumnIndex("tempChatSig");
      if (i != -1) {
        break label17328;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tempChatSig", [B.class));
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label17343;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      label12214:
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label17358;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      label12251:
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label17373;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label17388;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vPersonalityLabelV2");
      if (i != -1) {
        break label17415;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vPersonalityLabelV2", [B.class));
      label12362:
      i = paramCursor.getColumnIndex("cardType");
      if (i != -1) {
        break label17430;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cardType", Integer.TYPE));
      label12399:
      i = paramCursor.getColumnIndex("diyText");
      if (i != -1) {
        break label17445;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyText", String.class));
      i = paramCursor.getColumnIndex("diyTextFontId");
      if (i != -1) {
        break label17460;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextFontId", Integer.TYPE));
      label12473:
      i = paramCursor.getColumnIndex("diyTextWidth");
      if (i != -1) {
        break label17475;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextWidth", Float.TYPE));
      label12510:
      i = paramCursor.getColumnIndex("diyTextHeight");
      if (i != -1) {
        break label17490;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextHeight", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextLocX");
      if (i != -1) {
        break label17505;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextLocX", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextLocY");
      if (i != -1) {
        break label17520;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextLocY", Float.TYPE));
      label12621:
      i = paramCursor.getColumnIndex("diyTextDegree");
      if (i != -1) {
        break label17535;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextDegree", Float.TYPE));
      label12658:
      i = paramCursor.getColumnIndex("diyTextScale");
      if (i != -1) {
        break label17550;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextScale", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextTransparency");
      if (i != -1) {
        break label17565;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextTransparency", Float.TYPE));
      label12732:
      i = paramCursor.getColumnIndex("diyDefaultText");
      if (i != -1) {
        break label17580;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyDefaultText", String.class));
      label12769:
      i = paramCursor.getColumnIndex("popularity");
      if (i != -1) {
        break label17595;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("popularity", Integer.TYPE));
      i = paramCursor.getColumnIndex("declaration");
      if (i != -1) {
        break label17610;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("declaration", String.class));
      i = paramCursor.getColumnIndex("voiceUrl");
      if (i != -1) {
        break label17625;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("voiceUrl", String.class));
      label12880:
      i = paramCursor.getColumnIndex("isShowCard");
      if (i != -1) {
        break label17640;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isShowCard", Boolean.TYPE));
      i = paramCursor.getColumnIndex("updateTime");
      if (i != -1) {
        break label17667;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("updateTime", Long.TYPE));
      i = paramCursor.getColumnIndex("extendFriendFlag");
      if (i != -1) {
        break label17682;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendFlag", Integer.TYPE));
      label12991:
      i = paramCursor.getColumnIndex("extendFriendVoiceDuration");
      if (i != -1) {
        break label17697;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendVoiceDuration", Integer.TYPE));
      label13028:
      i = paramCursor.getColumnIndex("extendFriendEntryContact");
      if (i != -1) {
        break label17712;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendEntryContact", Short.TYPE));
      i = paramCursor.getColumnIndex("extendFriendEntryAddFriend");
      if (i != -1) {
        break label17727;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendEntryAddFriend", Short.TYPE));
      i = paramCursor.getColumnIndex("extendFriendQuestion");
      if (i != -1) {
        break label17742;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendQuestion", Short.TYPE));
      label13139:
      i = paramCursor.getColumnIndex("fontId");
      if (i != -1) {
        break label17757;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("fontId", Integer.TYPE));
      label13176:
      i = paramCursor.getColumnIndex("fontType");
      if (i != -1) {
        break label17772;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("fontType", Integer.TYPE));
      i = paramCursor.getColumnIndex("clothesId");
      if (i != -1) {
        break label17787;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("clothesId", Integer.TYPE));
      label13250:
      i = paramCursor.getColumnIndex("schoolId");
      if (i != -1) {
        break label17802;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("schoolId", String.class));
      label13287:
      i = paramCursor.getColumnIndex("schoolName");
      if (i != -1) {
        break label17817;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("schoolName", String.class));
      i = paramCursor.getColumnIndex("authState");
      if (i != -1) {
        break label17832;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("authState", Long.TYPE));
      label13361:
      i = paramCursor.getColumnIndex("idx");
      if (i != -1) {
        break label17847;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("idx", Integer.TYPE));
      label13398:
      i = paramCursor.getColumnIndex("category");
      if (i != -1) {
        break label17862;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("category", Integer.TYPE));
      label13435:
      i = paramCursor.getColumnIndex("isShowMiniPlaying");
      if (i != -1) {
        break label17877;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isShowMiniPlaying", Boolean.TYPE));
      i = paramCursor.getColumnIndex("tabJumpUrl");
      if (i != -1) {
        break label17904;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tabJumpUrl", String.class));
      label13509:
      i = paramCursor.getColumnIndex("guestJumpUrl");
      if (i != -1) {
        break label17919;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guestJumpUrl", String.class));
      label13546:
      i = paramCursor.getColumnIndex("guestAppTotal");
      if (i != -1) {
        break label17934;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guestAppTotal", Integer.TYPE));
      i = paramCursor.getColumnIndex("defaultCardId");
      if (i != -1) {
        break label17949;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("defaultCardId", Integer.TYPE));
      label13620:
      i = paramCursor.getColumnIndex("strangerVoteOpen");
      if (i != -1) {
        break label17964;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strangerVoteOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lSuperVipTemplateId");
      if (i != -1) {
        break label17991;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lSuperVipTemplateId", Long.TYPE));
      label13694:
      i = paramCursor.getColumnIndex("bBigClubVipOpen");
      if (i != -1) {
        break label18006;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bBigClubVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iBigClubVipType");
      if (i != -1) {
        break label18022;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iBigClubVipType", Integer.TYPE));
      label13768:
      i = paramCursor.getColumnIndex("iBigClubVipLevel");
      if (i != -1) {
        break label18037;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iBigClubVipLevel", Integer.TYPE));
      label13805:
      i = paramCursor.getColumnIndex("lBigClubTemplateId");
      if (i != -1) {
        break label18052;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lBigClubTemplateId", Long.TYPE));
      i = paramCursor.getColumnIndex("diyComplicatedInfo");
      if (i != -1) {
        break label18067;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyComplicatedInfo", String.class));
      label13879:
      i = paramCursor.getColumnIndex("cardId");
      if (i != -1) {
        break label18082;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cardId", Long.TYPE));
      label13916:
      i = paramCursor.getColumnIndex("strangerInviteMeGroupOpen");
      if (i != -1) {
        break label18097;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strangerInviteMeGroupOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isPrettyGroupOwner");
      if (i != -1) {
        break label18124;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isPrettyGroupOwner", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isHidePrettyGroutIdentity");
      if (i != -1) {
        break label18151;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isHidePrettyGroutIdentity", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mQQLevelType");
      if (i != -1) {
        break label18178;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mQQLevelType", Integer.TYPE));
    }
    for (;;)
    {
      label3200:
      label4226:
      label4518:
      label5416:
      label5801:
      label6186:
      label6571:
      label6960:
      i = paramCursor.getColumnIndex("schoolVerifiedFlag");
      label4620:
      label4877:
      label5006:
      label5011:
      label5016:
      label5021:
      label5026:
      label7330:
      label7848:
      label8107:
      label8366:
      label10031:
      label11696:
      if (i != -1) {
        break label18193;
      }
      label4996:
      label5001:
      label5136:
      label5276:
      label5661:
      label6046:
      label6431:
      label6816:
      label8995:
      label9254:
      label9513:
      label11178:
      label11437:
      label13102:
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("schoolVerifiedFlag", Boolean.TYPE));
      label5381:
      label5521:
      label5906:
      label6291:
      label6676:
      label7071:
      label8736:
      label10401:
      label10660:
      label10919:
      label12584:
      label12843:
      i = paramCursor.getColumnIndex("troopHonorSwitch");
      label5766:
      label6151:
      label6536:
      label6923:
      label7182:
      label7441:
      label7700:
      label7959:
      label8218:
      label8477:
      label10142:
      label11807:
      label12066:
      label13731:
      if (i != -1) {
        break label18220;
      }
      label7552:
      label7811:
      label8070:
      label8329:
      label8588:
      label8847:
      label9106:
      label9365:
      label9624:
      label9883:
      label11548:
      label13213:
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopHonorSwitch", Boolean.TYPE));
      label9217:
      label9476:
      label10253:
      label10512:
      label10771:
      label11289:
      label12954:
      return paramEntity;
      label10882:
      label11141:
      label11659:
      label12177:
      label12436:
      label12695:
      paramEntity.uin = paramCursor.getString(i);
      label12288:
      label12547:
      label12806:
      label13065:
      label13324:
      label13583:
      label13842:
      break;
      label14155:
      paramEntity.strNick = paramCursor.getString(i);
      break label5136;
      label14170:
      paramEntity.shGender = paramCursor.getShort(i);
      break label5171;
      label14185:
      paramEntity.shAge = paramCursor.getShort(i);
      break label5206;
      label14200:
      paramEntity.nFaceID = paramCursor.getInt(i);
      break label5241;
      label14215:
      paramEntity.strCertificationInfo = paramCursor.getString(i);
      break label5276;
      label14230:
      paramEntity.shType = paramCursor.getShort(i);
      break label5311;
      label14245:
      paramEntity.vContent = paramCursor.getBlob(i);
      break label5346;
      label14260:
      paramEntity.strSign = paramCursor.getString(i);
      break label5381;
      label14275:
      paramEntity.strCompany = paramCursor.getString(i);
      break label5416;
      label14290:
      paramEntity.strSchool = paramCursor.getString(i);
      break label5451;
      label14305:
      paramEntity.uFaceTimeStamp = paramCursor.getInt(i);
      break label5486;
      label14320:
      paramEntity.vQQFaceID = paramCursor.getBlob(i);
      break label5521;
      label14335:
      paramEntity.strReMark = paramCursor.getString(i);
      break label5556;
      label14350:
      paramEntity.bWeiboInfo = ((byte)paramCursor.getShort(i));
      break label5591;
      label14366:
      paramEntity.bQzoneInfo = ((byte)paramCursor.getShort(i));
      break label5626;
      label14382:
      paramEntity.nSameFriendsNum = paramCursor.getInt(i);
      break label5661;
      label14397:
      paramEntity.strCompanySame = paramCursor.getString(i);
      break label5696;
      label14412:
      paramEntity.strSchoolSame = paramCursor.getString(i);
      break label5731;
      label14427:
      paramEntity.lCardShowNum = paramCursor.getLong(i);
      break label5766;
      label14442:
      paramEntity.bSingle = ((byte)paramCursor.getShort(i));
      break label5801;
      label14458:
      paramEntity.lVisitCount = paramCursor.getLong(i);
      break label5836;
      label14473:
      paramEntity.lVoteCount = paramCursor.getLong(i);
      break label5871;
      label14488:
      paramEntity.tagInfosByte = paramCursor.getBlob(i);
      break label5906;
      label14503:
      paramEntity.eUserIdentityType = ((byte)paramCursor.getShort(i));
      break label5941;
      label14519:
      paramEntity.vBackground = paramCursor.getBlob(i);
      break label5976;
      label14534:
      paramEntity.labelInfoBytes = paramCursor.getBlob(i);
      break label6011;
      label14549:
      paramEntity.age = ((byte)paramCursor.getShort(i));
      break label6046;
      label14565:
      paramEntity.constellation = paramCursor.getInt(i);
      break label6081;
      label14580:
      paramEntity.pyFaceUrl = paramCursor.getString(i);
      break label6116;
      label14595:
      paramEntity.location = paramCursor.getString(i);
      break label6151;
      label14610:
      paramEntity.bVoted = ((byte)paramCursor.getShort(i));
      break label6186;
      label14626:
      paramEntity.bFavorited = ((byte)paramCursor.getShort(i));
      break label6221;
      label14642:
      paramEntity.iVoteIncrement = paramCursor.getInt(i);
      break label6256;
      label14657:
      paramEntity.strJoinHexAlbumFileKey = paramCursor.getString(i);
      break label6291;
      label14672:
      paramEntity.iFaceNum = paramCursor.getInt(i);
      break label6326;
      label14687:
      paramEntity.cSqqLevel = ((byte)paramCursor.getShort(i));
      break label6361;
      label14703:
      paramEntity.iQQLevel = paramCursor.getInt(i);
      break label6396;
      label14718:
      paramEntity.uCurMulType = paramCursor.getLong(i);
      break label6431;
      label14733:
      paramEntity.strProvince = paramCursor.getString(i);
      break label6466;
      label14748:
      paramEntity.strCity = paramCursor.getString(i);
      break label6501;
      label14763:
      paramEntity.strCountry = paramCursor.getString(i);
      break label6536;
      label14778:
      paramEntity.lBirthday = paramCursor.getLong(i);
      break label6571;
      label14793:
      paramEntity.strLocationCodes = paramCursor.getString(i);
      break label6606;
      label14808:
      paramEntity.strLocationDesc = paramCursor.getString(i);
      break label6641;
      label14823:
      paramEntity.strHometownCodes = paramCursor.getString(i);
      break label6676;
      label14838:
      paramEntity.strHometownDesc = paramCursor.getString(i);
      break label6711;
      label14853:
      paramEntity.strEmail = paramCursor.getString(i);
      break label6746;
      label14868:
      paramEntity.strPersonalNote = paramCursor.getString(i);
      break label6781;
      label14883:
      paramEntity.iProfession = paramCursor.getInt(i);
      break label6816;
      label14898:
      paramEntity.bindPhoneInfo = paramCursor.getString(i);
      break label6851;
      label14913:
      paramEntity.bCardInfo = paramCursor.getBlob(i);
      break label6886;
      label14928:
      paramEntity.strTroopName = paramCursor.getString(i);
      break label6923;
      label14943:
      paramEntity.strTroopNick = paramCursor.getString(i);
      break label6960;
      label14958:
      paramEntity.strMobile = paramCursor.getString(i);
      break label6997;
      label14973:
      paramEntity.strContactName = paramCursor.getString(i);
      break label7034;
      label14988:
      paramEntity.ulShowControl = paramCursor.getInt(i);
      break label7071;
      label15003:
      paramEntity.feedPreviewTime = paramCursor.getLong(i);
      break label7108;
      label15018:
      paramEntity.strQzoneFeedsDesc = paramCursor.getString(i);
      break label7145;
      label15033:
      paramEntity.StrPresentDesc = paramCursor.getString(i);
      break label7182;
      label15048:
      paramEntity.strSpaceName = paramCursor.getString(i);
      break label7219;
      label15063:
      paramEntity.strQzoneHeader = paramCursor.getString(i);
      break label7256;
      label15078:
      paramEntity.vQzonePhotos = paramCursor.getBlob(i);
      break label7293;
      label15093:
      paramEntity.vQzoneCoverInfo = paramCursor.getBlob(i);
      break label7330;
      label15108:
      paramEntity.enlargeQzonePic = paramCursor.getInt(i);
      break label7367;
      label15123:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showPublishButton = paramBoolean;
        break;
      }
      label15150:
      paramEntity.strStatus = paramCursor.getString(i);
      break label7441;
      label15165:
      paramEntity.strAutoRemark = paramCursor.getString(i);
      break label7478;
      label15180:
      paramEntity.vSeed = paramCursor.getBlob(i);
      break label7515;
      label15195:
      paramEntity.vCookies = paramCursor.getBlob(i);
      break label7552;
      label15210:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasFakeData = paramBoolean;
        break;
      }
      label15237:
      paramEntity.bQQVipOpen = ((byte)paramCursor.getShort(i));
      break label7626;
      label15253:
      paramEntity.iQQVipType = paramCursor.getInt(i);
      break label7663;
      label15268:
      paramEntity.iQQVipLevel = paramCursor.getInt(i);
      break label7700;
      label15283:
      paramEntity.nameplateVipType = paramCursor.getInt(i);
      break label7737;
      label15298:
      paramEntity.grayNameplateFlag = paramCursor.getInt(i);
      break label7774;
      label15313:
      paramEntity.bSuperVipOpen = ((byte)paramCursor.getShort(i));
      break label7811;
      label15329:
      paramEntity.iSuperVipType = paramCursor.getInt(i);
      break label7848;
      label15344:
      paramEntity.iSuperVipLevel = paramCursor.getInt(i);
      break label7885;
      label15359:
      paramEntity.bSuperQQOpen = ((byte)paramCursor.getShort(i));
      break label7922;
      label15375:
      paramEntity.iSuperQQType = paramCursor.getInt(i);
      break label7959;
      label15390:
      paramEntity.iSuperQQLevel = paramCursor.getInt(i);
      break label7996;
      label15405:
      paramEntity.bHollywoodVipOpen = ((byte)paramCursor.getShort(i));
      break label8033;
      label15421:
      paramEntity.iHollywoodVipType = paramCursor.getInt(i);
      break label8070;
      label15436:
      paramEntity.iHollywoodVipLevel = paramCursor.getInt(i);
      break label8107;
      label15451:
      paramEntity.strShowName = paramCursor.getString(i);
      break label8144;
      label15466:
      paramEntity.strVoiceFilekey = paramCursor.getString(i);
      break label8181;
      label15481:
      paramEntity.shDuration = paramCursor.getShort(i);
      break label8218;
      label15496:
      paramEntity.bRead = ((byte)paramCursor.getShort(i));
      break label8255;
      label15512:
      paramEntity.strUrl = paramCursor.getString(i);
      break label8292;
      label15527:
      paramEntity.vRichSign = paramCursor.getBlob(i);
      break label8329;
      label15542:
      paramEntity.lSignModifyTime = paramCursor.getLong(i);
      break label8366;
      label15557:
      paramEntity.vLongNickTopicInfo = paramCursor.getBlob(i);
      break label8403;
      label15572:
      paramEntity.nLastGameFlag = paramCursor.getInt(i);
      break label8440;
      label15587:
      paramEntity.strGameLogoUrl_1 = paramCursor.getString(i);
      break label8477;
      label15602:
      paramEntity.strGameLogoUrl_2 = paramCursor.getString(i);
      break label8514;
      label15617:
      paramEntity.strGameLogoUrl_3 = paramCursor.getString(i);
      break label8551;
      label15632:
      paramEntity.strGameLogoUrl_4 = paramCursor.getString(i);
      break label8588;
      label15647:
      paramEntity.strGameLogoKey_1 = paramCursor.getString(i);
      break label8625;
      label15662:
      paramEntity.strGameLogoKey_2 = paramCursor.getString(i);
      break label8662;
      label15677:
      paramEntity.strGameLogoKey_3 = paramCursor.getString(i);
      break label8699;
      label15692:
      paramEntity.strGameLogoKey_4 = paramCursor.getString(i);
      break label8736;
      label15707:
      paramEntity.strGameName_1 = paramCursor.getString(i);
      break label8773;
      label15722:
      paramEntity.strGameName_2 = paramCursor.getString(i);
      break label8810;
      label15737:
      paramEntity.strGameName_3 = paramCursor.getString(i);
      break label8847;
      label15752:
      paramEntity.strGameName_4 = paramCursor.getString(i);
      break label8884;
      label15767:
      paramEntity.strGameAppid_1 = paramCursor.getString(i);
      break label8921;
      label15782:
      paramEntity.strGameAppid_2 = paramCursor.getString(i);
      break label8958;
      label15797:
      paramEntity.strGameAppid_3 = paramCursor.getString(i);
      break label8995;
      label15812:
      paramEntity.strGameAppid_4 = paramCursor.getString(i);
      break label9032;
      label15827:
      paramEntity.strProfileUrl = paramCursor.getString(i);
      break label9069;
      label15842:
      paramEntity.nStarFansFlag = paramCursor.getInt(i);
      break label9106;
      label15857:
      paramEntity.strStarPicUrl_0 = paramCursor.getString(i);
      break label9143;
      label15872:
      paramEntity.strStarPicUrl_1 = paramCursor.getString(i);
      break label9180;
      label15887:
      paramEntity.strStarPicUrl_2 = paramCursor.getString(i);
      break label9217;
      label15902:
      paramEntity.strStarLvUrl_0 = paramCursor.getString(i);
      break label9254;
      label15917:
      paramEntity.strStarLvUrl_1 = paramCursor.getString(i);
      break label9291;
      label15932:
      paramEntity.strStarLvUrl_2 = paramCursor.getString(i);
      break label9328;
      label15947:
      paramEntity.strStarLogoUrl = paramCursor.getString(i);
      break label9365;
      label15962:
      paramEntity.starFansJumpUrl = paramCursor.getString(i);
      break label9402;
      label15977:
      paramEntity.lUserFlag = paramCursor.getLong(i);
      break label9439;
      label15992:
      paramEntity.lLoginDays = paramCursor.getLong(i);
      break label9476;
      label16007:
      paramEntity.strLoginDaysDesc = paramCursor.getString(i);
      break label9513;
      label16022:
      paramEntity.lQQMasterLogindays = paramCursor.getLong(i);
      break label9550;
      label16037:
      paramEntity.iXManScene1DelayTime = paramCursor.getInt(i);
      break label9587;
      label16052:
      paramEntity.iXManScene2DelayTime = paramCursor.getInt(i);
      break label9624;
      label16067:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowPeopleSee = paramBoolean;
        break;
      }
      label16094:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowCalInteractive = paramBoolean;
        break;
      }
      label16121:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showOnlineFriends = paramBoolean;
        break;
      }
      label16148:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowClick = paramBoolean;
        break;
      }
      label16175:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.babyQSwitch = paramBoolean;
        break;
      }
      label16202:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showLightalk = paramBoolean;
        break;
      }
      label16229:
      paramEntity.lightalkNick = paramCursor.getString(i);
      break label9883;
      label16244:
      paramEntity.lightalkId = paramCursor.getString(i);
      break label9920;
      label16259:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperRedDiamond = paramBoolean;
        break;
      }
      label16286:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isRedDiamond = paramBoolean;
        break;
      }
      label16313:
      paramEntity.redLevel = paramCursor.getInt(i);
      break label10031;
      label16328:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperYellowDiamond = paramBoolean;
        break;
      }
      label16355:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isYellowDiamond = paramBoolean;
        break;
      }
      label16382:
      paramEntity.yellowLevel = paramCursor.getInt(i);
      break label10142;
      label16397:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperGreenDiamond = paramBoolean;
        break;
      }
      label16424:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isGreenDiamond = paramBoolean;
        break;
      }
      label16451:
      paramEntity.greenLevel = paramCursor.getInt(i);
      break label10253;
      label16466:
      paramEntity.uAccelerateMultiple = paramCursor.getLong(i);
      break label10290;
      label16481:
      paramEntity.strRespMusicInfo = paramCursor.getString(i);
      break label10327;
      label16496:
      paramEntity.templateRet = paramCursor.getInt(i);
      break label10364;
      label16511:
      paramEntity.lCurrentStyleId = paramCursor.getLong(i);
      break label10401;
      label16526:
      paramEntity.lCurrentBgId = paramCursor.getLong(i);
      break label10438;
      label16541:
      paramEntity.backgroundUrl = paramCursor.getString(i);
      break label10475;
      label16556:
      paramEntity.backgroundColor = paramCursor.getLong(i);
      break label10512;
      label16571:
      paramEntity.dynamicCardFlag = paramCursor.getInt(i);
      break label10549;
      label16586:
      paramEntity.strZipUrl = paramCursor.getString(i);
      break label10586;
      label16601:
      paramEntity.strActiveUrl = paramCursor.getString(i);
      break label10623;
      label16616:
      paramEntity.strDrawerCardUrl = paramCursor.getString(i);
      break label10660;
      label16631:
      paramEntity.strWzryHeroUrl = paramCursor.getString(i);
      break label10697;
      label16646:
      paramEntity.wzryHonorInfo = paramCursor.getBlob(i);
      break label10734;
      label16661:
      paramEntity.strExtInfo = paramCursor.getString(i);
      break label10771;
      label16676:
      paramEntity.strCurrentBgUrl = paramCursor.getString(i);
      break label10808;
      label16691:
      paramEntity.bgType = paramCursor.getBlob(i);
      break label10845;
      label16706:
      paramEntity.encId = paramCursor.getString(i);
      break label10882;
      label16721:
      paramEntity.busiEntry = paramCursor.getString(i);
      break label10919;
      label16736:
      paramEntity.favoriteSource = paramCursor.getInt(i);
      break label10956;
      label16751:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.visibleMusicPendant = paramBoolean;
        break;
      }
      label16778:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.autoPlayMusicPendant = paramBoolean;
        break;
      }
      label16805:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showRedPointMusicPendant = paramBoolean;
        break;
      }
      label16832:
      paramEntity.privilegePromptStr = paramCursor.getString(i);
      break label11104;
      label16847:
      paramEntity.privilegeJumpUrl = paramCursor.getString(i);
      break label11141;
      label16862:
      paramEntity.vOpenPriv = paramCursor.getBlob(i);
      break label11178;
      label16877:
      paramEntity.vClosePriv = paramCursor.getBlob(i);
      break label11215;
      label16892:
      paramEntity.presentDesc = paramCursor.getString(i);
      break label11252;
      label16907:
      paramEntity.presentCustourl = paramCursor.getString(i);
      break label11289;
      label16922:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.presentSwitch = paramBoolean;
        break;
      }
      label16949:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showPresent = paramBoolean;
        break;
      }
      label16976:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showMusicBox = paramBoolean;
        break;
      }
      label17003:
      paramEntity.addSrcName = paramCursor.getString(i);
      break label11437;
      label17018:
      paramEntity.addSrcId = paramCursor.getLong(i);
      break label11474;
      label17033:
      paramEntity.addSubSrcId = paramCursor.getLong(i);
      break label11511;
      label17048:
      paramEntity.strVoteLimitedNotice = paramCursor.getString(i);
      break label11548;
      label17063:
      paramEntity.bHaveVotedCnt = paramCursor.getShort(i);
      break label11585;
      label17078:
      paramEntity.bAvailVoteCnt = paramCursor.getShort(i);
      break label11622;
      label17093:
      paramEntity.olympicTorch = ((byte)paramCursor.getShort(i));
      break label11659;
      label17109:
      paramEntity.mNowShowFlag = paramCursor.getInt(i);
      break label11696;
      label17124:
      paramEntity.mNowShowIconUrl = paramCursor.getString(i);
      break label11733;
      label17139:
      paramEntity.mNowShowJumpUrl = paramCursor.getString(i);
      break label11770;
      label17154:
      paramEntity.vCoverInfo = paramCursor.getBlob(i);
      break label11807;
      label17169:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.videoHeadFlag = paramBoolean;
        break;
      }
      label17196:
      paramEntity.videoHeadUrl = paramCursor.getString(i);
      break label11881;
      label17211:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.medalSwitchDisable = paramBoolean;
        break;
      }
      label17238:
      paramEntity.iMedalCount = paramCursor.getInt(i);
      break label11955;
      label17253:
      paramEntity.iNewCount = paramCursor.getInt(i);
      break label11992;
      label17268:
      paramEntity.iUpgradeCount = paramCursor.getInt(i);
      break label12029;
      label17283:
      paramEntity.strPromptParams = paramCursor.getString(i);
      break label12066;
      label17298:
      paramEntity.hobbyEntry = paramCursor.getString(i);
      break label12103;
      label17313:
      paramEntity.lastPraiseInfoList = paramCursor.getBlob(i);
      break label12140;
      label17328:
      paramEntity.tempChatSig = paramCursor.getBlob(i);
      break label12177;
      label17343:
      paramEntity.namePlateOfKingGameId = paramCursor.getLong(i);
      break label12214;
      label17358:
      paramEntity.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label12251;
      label17373:
      paramEntity.namePlateOfKingDan = paramCursor.getInt(i);
      break label12288;
      label17388:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label17415:
      paramEntity.vPersonalityLabelV2 = paramCursor.getBlob(i);
      break label12362;
      label17430:
      paramEntity.cardType = paramCursor.getInt(i);
      break label12399;
      label17445:
      paramEntity.diyText = paramCursor.getString(i);
      break label12436;
      label17460:
      paramEntity.diyTextFontId = paramCursor.getInt(i);
      break label12473;
      label17475:
      paramEntity.diyTextWidth = paramCursor.getFloat(i);
      break label12510;
      label17490:
      paramEntity.diyTextHeight = paramCursor.getFloat(i);
      break label12547;
      label17505:
      paramEntity.diyTextLocX = paramCursor.getFloat(i);
      break label12584;
      label17520:
      paramEntity.diyTextLocY = paramCursor.getFloat(i);
      break label12621;
      label17535:
      paramEntity.diyTextDegree = paramCursor.getFloat(i);
      break label12658;
      label17550:
      paramEntity.diyTextScale = paramCursor.getFloat(i);
      break label12695;
      label17565:
      paramEntity.diyTextTransparency = paramCursor.getFloat(i);
      break label12732;
      label17580:
      paramEntity.diyDefaultText = paramCursor.getString(i);
      break label12769;
      label17595:
      paramEntity.popularity = paramCursor.getInt(i);
      break label12806;
      label17610:
      paramEntity.declaration = paramCursor.getString(i);
      break label12843;
      label17625:
      paramEntity.voiceUrl = paramCursor.getString(i);
      break label12880;
      label17640:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isShowCard = paramBoolean;
        break;
      }
      label17667:
      paramEntity.updateTime = paramCursor.getLong(i);
      break label12954;
      label17682:
      paramEntity.extendFriendFlag = paramCursor.getInt(i);
      break label12991;
      label17697:
      paramEntity.extendFriendVoiceDuration = paramCursor.getInt(i);
      break label13028;
      label17712:
      paramEntity.extendFriendEntryContact = paramCursor.getShort(i);
      break label13065;
      label17727:
      paramEntity.extendFriendEntryAddFriend = paramCursor.getShort(i);
      break label13102;
      label17742:
      paramEntity.extendFriendQuestion = paramCursor.getShort(i);
      break label13139;
      label17757:
      paramEntity.fontId = paramCursor.getInt(i);
      break label13176;
      label17772:
      paramEntity.fontType = paramCursor.getInt(i);
      break label13213;
      label17787:
      paramEntity.clothesId = paramCursor.getInt(i);
      break label13250;
      label17802:
      paramEntity.schoolId = paramCursor.getString(i);
      break label13287;
      label17817:
      paramEntity.schoolName = paramCursor.getString(i);
      break label13324;
      label17832:
      paramEntity.authState = paramCursor.getLong(i);
      break label13361;
      label17847:
      paramEntity.idx = paramCursor.getInt(i);
      break label13398;
      label17862:
      paramEntity.category = paramCursor.getInt(i);
      break label13435;
      label17877:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isShowMiniPlaying = paramBoolean;
        break;
      }
      label17904:
      paramEntity.tabJumpUrl = paramCursor.getString(i);
      break label13509;
      label17919:
      paramEntity.guestJumpUrl = paramCursor.getString(i);
      break label13546;
      label17934:
      paramEntity.guestAppTotal = paramCursor.getInt(i);
      break label13583;
      label17949:
      paramEntity.defaultCardId = paramCursor.getInt(i);
      break label13620;
      label17964:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.strangerVoteOpen = paramBoolean;
        break;
      }
      label17991:
      paramEntity.lSuperVipTemplateId = paramCursor.getLong(i);
      break label13694;
      label18006:
      paramEntity.bBigClubVipOpen = ((byte)paramCursor.getShort(i));
      break label13731;
      label18022:
      paramEntity.iBigClubVipType = paramCursor.getInt(i);
      break label13768;
      label18037:
      paramEntity.iBigClubVipLevel = paramCursor.getInt(i);
      break label13805;
      label18052:
      paramEntity.lBigClubTemplateId = paramCursor.getLong(i);
      break label13842;
      label18067:
      paramEntity.diyComplicatedInfo = paramCursor.getString(i);
      break label13879;
      label18082:
      paramEntity.cardId = paramCursor.getLong(i);
      break label13916;
      label18097:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.strangerInviteMeGroupOpen = paramBoolean;
        break;
      }
      label18124:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isPrettyGroupOwner = paramBoolean;
        break;
      }
      label18151:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isHidePrettyGroutIdentity = paramBoolean;
        break;
      }
      label18178:
      paramEntity.mQQLevelType = paramCursor.getInt(i);
    }
    label18193:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramEntity.schoolVerifiedFlag = paramBoolean;
      break;
    }
    label18220:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramEntity.troopHonorSwitch = paramBoolean;
      return paramEntity;
    }
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (Card)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("strNick", paramEntity.strNick);
    paramContentValues.put("shGender", Short.valueOf(paramEntity.shGender));
    paramContentValues.put("shAge", Short.valueOf(paramEntity.shAge));
    paramContentValues.put("nFaceID", Integer.valueOf(paramEntity.nFaceID));
    paramContentValues.put("strCertificationInfo", paramEntity.strCertificationInfo);
    paramContentValues.put("shType", Short.valueOf(paramEntity.shType));
    paramContentValues.put("vContent", paramEntity.vContent);
    paramContentValues.put("strSign", paramEntity.strSign);
    paramContentValues.put("strCompany", paramEntity.strCompany);
    paramContentValues.put("strSchool", paramEntity.strSchool);
    paramContentValues.put("uFaceTimeStamp", Integer.valueOf(paramEntity.uFaceTimeStamp));
    paramContentValues.put("vQQFaceID", paramEntity.vQQFaceID);
    paramContentValues.put("strReMark", paramEntity.strReMark);
    paramContentValues.put("bWeiboInfo", Byte.valueOf(paramEntity.bWeiboInfo));
    paramContentValues.put("bQzoneInfo", Byte.valueOf(paramEntity.bQzoneInfo));
    paramContentValues.put("nSameFriendsNum", Integer.valueOf(paramEntity.nSameFriendsNum));
    paramContentValues.put("strCompanySame", paramEntity.strCompanySame);
    paramContentValues.put("strSchoolSame", paramEntity.strSchoolSame);
    paramContentValues.put("lCardShowNum", Long.valueOf(paramEntity.lCardShowNum));
    paramContentValues.put("bSingle", Byte.valueOf(paramEntity.bSingle));
    paramContentValues.put("lVisitCount", Long.valueOf(paramEntity.lVisitCount));
    paramContentValues.put("lVoteCount", Long.valueOf(paramEntity.lVoteCount));
    paramContentValues.put("tagInfosByte", paramEntity.tagInfosByte);
    paramContentValues.put("eUserIdentityType", Byte.valueOf(paramEntity.eUserIdentityType));
    paramContentValues.put("vBackground", paramEntity.vBackground);
    paramContentValues.put("labelInfoBytes", paramEntity.labelInfoBytes);
    paramContentValues.put("age", Byte.valueOf(paramEntity.age));
    paramContentValues.put("constellation", Integer.valueOf(paramEntity.constellation));
    paramContentValues.put("pyFaceUrl", paramEntity.pyFaceUrl);
    paramContentValues.put("location", paramEntity.location);
    paramContentValues.put("bVoted", Byte.valueOf(paramEntity.bVoted));
    paramContentValues.put("bFavorited", Byte.valueOf(paramEntity.bFavorited));
    paramContentValues.put("iVoteIncrement", Integer.valueOf(paramEntity.iVoteIncrement));
    paramContentValues.put("strJoinHexAlbumFileKey", paramEntity.strJoinHexAlbumFileKey);
    paramContentValues.put("iFaceNum", Integer.valueOf(paramEntity.iFaceNum));
    paramContentValues.put("cSqqLevel", Byte.valueOf(paramEntity.cSqqLevel));
    paramContentValues.put("iQQLevel", Integer.valueOf(paramEntity.iQQLevel));
    paramContentValues.put("uCurMulType", Long.valueOf(paramEntity.uCurMulType));
    paramContentValues.put("strProvince", paramEntity.strProvince);
    paramContentValues.put("strCity", paramEntity.strCity);
    paramContentValues.put("strCountry", paramEntity.strCountry);
    paramContentValues.put("lBirthday", Long.valueOf(paramEntity.lBirthday));
    paramContentValues.put("strLocationCodes", paramEntity.strLocationCodes);
    paramContentValues.put("strLocationDesc", paramEntity.strLocationDesc);
    paramContentValues.put("strHometownCodes", paramEntity.strHometownCodes);
    paramContentValues.put("strHometownDesc", paramEntity.strHometownDesc);
    paramContentValues.put("strEmail", paramEntity.strEmail);
    paramContentValues.put("strPersonalNote", paramEntity.strPersonalNote);
    paramContentValues.put("iProfession", Integer.valueOf(paramEntity.iProfession));
    paramContentValues.put("bindPhoneInfo", paramEntity.bindPhoneInfo);
    paramContentValues.put("bCardInfo", paramEntity.bCardInfo);
    paramContentValues.put("strTroopName", paramEntity.strTroopName);
    paramContentValues.put("strTroopNick", paramEntity.strTroopNick);
    paramContentValues.put("strMobile", paramEntity.strMobile);
    paramContentValues.put("strContactName", paramEntity.strContactName);
    paramContentValues.put("ulShowControl", Integer.valueOf(paramEntity.ulShowControl));
    paramContentValues.put("feedPreviewTime", Long.valueOf(paramEntity.feedPreviewTime));
    paramContentValues.put("strQzoneFeedsDesc", paramEntity.strQzoneFeedsDesc);
    paramContentValues.put("StrPresentDesc", paramEntity.StrPresentDesc);
    paramContentValues.put("strSpaceName", paramEntity.strSpaceName);
    paramContentValues.put("strQzoneHeader", paramEntity.strQzoneHeader);
    paramContentValues.put("vQzonePhotos", paramEntity.vQzonePhotos);
    paramContentValues.put("vQzoneCoverInfo", paramEntity.vQzoneCoverInfo);
    paramContentValues.put("enlargeQzonePic", Integer.valueOf(paramEntity.enlargeQzonePic));
    paramContentValues.put("showPublishButton", Boolean.valueOf(paramEntity.showPublishButton));
    paramContentValues.put("strStatus", paramEntity.strStatus);
    paramContentValues.put("strAutoRemark", paramEntity.strAutoRemark);
    paramContentValues.put("vSeed", paramEntity.vSeed);
    paramContentValues.put("vCookies", paramEntity.vCookies);
    paramContentValues.put("hasFakeData", Boolean.valueOf(paramEntity.hasFakeData));
    paramContentValues.put("bQQVipOpen", Byte.valueOf(paramEntity.bQQVipOpen));
    paramContentValues.put("iQQVipType", Integer.valueOf(paramEntity.iQQVipType));
    paramContentValues.put("iQQVipLevel", Integer.valueOf(paramEntity.iQQVipLevel));
    paramContentValues.put("nameplateVipType", Integer.valueOf(paramEntity.nameplateVipType));
    paramContentValues.put("grayNameplateFlag", Integer.valueOf(paramEntity.grayNameplateFlag));
    paramContentValues.put("bSuperVipOpen", Byte.valueOf(paramEntity.bSuperVipOpen));
    paramContentValues.put("iSuperVipType", Integer.valueOf(paramEntity.iSuperVipType));
    paramContentValues.put("iSuperVipLevel", Integer.valueOf(paramEntity.iSuperVipLevel));
    paramContentValues.put("bSuperQQOpen", Byte.valueOf(paramEntity.bSuperQQOpen));
    paramContentValues.put("iSuperQQType", Integer.valueOf(paramEntity.iSuperQQType));
    paramContentValues.put("iSuperQQLevel", Integer.valueOf(paramEntity.iSuperQQLevel));
    paramContentValues.put("bHollywoodVipOpen", Byte.valueOf(paramEntity.bHollywoodVipOpen));
    paramContentValues.put("iHollywoodVipType", Integer.valueOf(paramEntity.iHollywoodVipType));
    paramContentValues.put("iHollywoodVipLevel", Integer.valueOf(paramEntity.iHollywoodVipLevel));
    paramContentValues.put("strShowName", paramEntity.strShowName);
    paramContentValues.put("strVoiceFilekey", paramEntity.strVoiceFilekey);
    paramContentValues.put("shDuration", Short.valueOf(paramEntity.shDuration));
    paramContentValues.put("bRead", Byte.valueOf(paramEntity.bRead));
    paramContentValues.put("strUrl", paramEntity.strUrl);
    paramContentValues.put("vRichSign", paramEntity.vRichSign);
    paramContentValues.put("lSignModifyTime", Long.valueOf(paramEntity.lSignModifyTime));
    paramContentValues.put("vLongNickTopicInfo", paramEntity.vLongNickTopicInfo);
    paramContentValues.put("nLastGameFlag", Integer.valueOf(paramEntity.nLastGameFlag));
    paramContentValues.put("strGameLogoUrl_1", paramEntity.strGameLogoUrl_1);
    paramContentValues.put("strGameLogoUrl_2", paramEntity.strGameLogoUrl_2);
    paramContentValues.put("strGameLogoUrl_3", paramEntity.strGameLogoUrl_3);
    paramContentValues.put("strGameLogoUrl_4", paramEntity.strGameLogoUrl_4);
    paramContentValues.put("strGameLogoKey_1", paramEntity.strGameLogoKey_1);
    paramContentValues.put("strGameLogoKey_2", paramEntity.strGameLogoKey_2);
    paramContentValues.put("strGameLogoKey_3", paramEntity.strGameLogoKey_3);
    paramContentValues.put("strGameLogoKey_4", paramEntity.strGameLogoKey_4);
    paramContentValues.put("strGameName_1", paramEntity.strGameName_1);
    paramContentValues.put("strGameName_2", paramEntity.strGameName_2);
    paramContentValues.put("strGameName_3", paramEntity.strGameName_3);
    paramContentValues.put("strGameName_4", paramEntity.strGameName_4);
    paramContentValues.put("strGameAppid_1", paramEntity.strGameAppid_1);
    paramContentValues.put("strGameAppid_2", paramEntity.strGameAppid_2);
    paramContentValues.put("strGameAppid_3", paramEntity.strGameAppid_3);
    paramContentValues.put("strGameAppid_4", paramEntity.strGameAppid_4);
    paramContentValues.put("strProfileUrl", paramEntity.strProfileUrl);
    paramContentValues.put("nStarFansFlag", Integer.valueOf(paramEntity.nStarFansFlag));
    paramContentValues.put("strStarPicUrl_0", paramEntity.strStarPicUrl_0);
    paramContentValues.put("strStarPicUrl_1", paramEntity.strStarPicUrl_1);
    paramContentValues.put("strStarPicUrl_2", paramEntity.strStarPicUrl_2);
    paramContentValues.put("strStarLvUrl_0", paramEntity.strStarLvUrl_0);
    paramContentValues.put("strStarLvUrl_1", paramEntity.strStarLvUrl_1);
    paramContentValues.put("strStarLvUrl_2", paramEntity.strStarLvUrl_2);
    paramContentValues.put("strStarLogoUrl", paramEntity.strStarLogoUrl);
    paramContentValues.put("starFansJumpUrl", paramEntity.starFansJumpUrl);
    paramContentValues.put("lUserFlag", Long.valueOf(paramEntity.lUserFlag));
    paramContentValues.put("lLoginDays", Long.valueOf(paramEntity.lLoginDays));
    paramContentValues.put("strLoginDaysDesc", paramEntity.strLoginDaysDesc);
    paramContentValues.put("lQQMasterLogindays", Long.valueOf(paramEntity.lQQMasterLogindays));
    paramContentValues.put("iXManScene1DelayTime", Integer.valueOf(paramEntity.iXManScene1DelayTime));
    paramContentValues.put("iXManScene2DelayTime", Integer.valueOf(paramEntity.iXManScene2DelayTime));
    paramContentValues.put("allowPeopleSee", Boolean.valueOf(paramEntity.allowPeopleSee));
    paramContentValues.put("allowCalInteractive", Boolean.valueOf(paramEntity.allowCalInteractive));
    paramContentValues.put("showOnlineFriends", Boolean.valueOf(paramEntity.showOnlineFriends));
    paramContentValues.put("allowClick", Boolean.valueOf(paramEntity.allowClick));
    paramContentValues.put("babyQSwitch", Boolean.valueOf(paramEntity.babyQSwitch));
    paramContentValues.put("showLightalk", Boolean.valueOf(paramEntity.showLightalk));
    paramContentValues.put("lightalkNick", paramEntity.lightalkNick);
    paramContentValues.put("lightalkId", paramEntity.lightalkId);
    paramContentValues.put("isSuperRedDiamond", Boolean.valueOf(paramEntity.isSuperRedDiamond));
    paramContentValues.put("isRedDiamond", Boolean.valueOf(paramEntity.isRedDiamond));
    paramContentValues.put("redLevel", Integer.valueOf(paramEntity.redLevel));
    paramContentValues.put("isSuperYellowDiamond", Boolean.valueOf(paramEntity.isSuperYellowDiamond));
    paramContentValues.put("isYellowDiamond", Boolean.valueOf(paramEntity.isYellowDiamond));
    paramContentValues.put("yellowLevel", Integer.valueOf(paramEntity.yellowLevel));
    paramContentValues.put("isSuperGreenDiamond", Boolean.valueOf(paramEntity.isSuperGreenDiamond));
    paramContentValues.put("isGreenDiamond", Boolean.valueOf(paramEntity.isGreenDiamond));
    paramContentValues.put("greenLevel", Integer.valueOf(paramEntity.greenLevel));
    paramContentValues.put("uAccelerateMultiple", Long.valueOf(paramEntity.uAccelerateMultiple));
    paramContentValues.put("strRespMusicInfo", paramEntity.strRespMusicInfo);
    paramContentValues.put("templateRet", Integer.valueOf(paramEntity.templateRet));
    paramContentValues.put("lCurrentStyleId", Long.valueOf(paramEntity.lCurrentStyleId));
    paramContentValues.put("lCurrentBgId", Long.valueOf(paramEntity.lCurrentBgId));
    paramContentValues.put("backgroundUrl", paramEntity.backgroundUrl);
    paramContentValues.put("backgroundColor", Long.valueOf(paramEntity.backgroundColor));
    paramContentValues.put("dynamicCardFlag", Integer.valueOf(paramEntity.dynamicCardFlag));
    paramContentValues.put("strZipUrl", paramEntity.strZipUrl);
    paramContentValues.put("strActiveUrl", paramEntity.strActiveUrl);
    paramContentValues.put("strDrawerCardUrl", paramEntity.strDrawerCardUrl);
    paramContentValues.put("strWzryHeroUrl", paramEntity.strWzryHeroUrl);
    paramContentValues.put("wzryHonorInfo", paramEntity.wzryHonorInfo);
    paramContentValues.put("strExtInfo", paramEntity.strExtInfo);
    paramContentValues.put("strCurrentBgUrl", paramEntity.strCurrentBgUrl);
    paramContentValues.put("bgType", paramEntity.bgType);
    paramContentValues.put("encId", paramEntity.encId);
    paramContentValues.put("busiEntry", paramEntity.busiEntry);
    paramContentValues.put("favoriteSource", Integer.valueOf(paramEntity.favoriteSource));
    paramContentValues.put("visibleMusicPendant", Boolean.valueOf(paramEntity.visibleMusicPendant));
    paramContentValues.put("autoPlayMusicPendant", Boolean.valueOf(paramEntity.autoPlayMusicPendant));
    paramContentValues.put("showRedPointMusicPendant", Boolean.valueOf(paramEntity.showRedPointMusicPendant));
    paramContentValues.put("privilegePromptStr", paramEntity.privilegePromptStr);
    paramContentValues.put("privilegeJumpUrl", paramEntity.privilegeJumpUrl);
    paramContentValues.put("vOpenPriv", paramEntity.vOpenPriv);
    paramContentValues.put("vClosePriv", paramEntity.vClosePriv);
    paramContentValues.put("presentDesc", paramEntity.presentDesc);
    paramContentValues.put("presentCustourl", paramEntity.presentCustourl);
    paramContentValues.put("presentSwitch", Boolean.valueOf(paramEntity.presentSwitch));
    paramContentValues.put("showPresent", Boolean.valueOf(paramEntity.showPresent));
    paramContentValues.put("showMusicBox", Boolean.valueOf(paramEntity.showMusicBox));
    paramContentValues.put("addSrcName", paramEntity.addSrcName);
    paramContentValues.put("addSrcId", Long.valueOf(paramEntity.addSrcId));
    paramContentValues.put("addSubSrcId", Long.valueOf(paramEntity.addSubSrcId));
    paramContentValues.put("strVoteLimitedNotice", paramEntity.strVoteLimitedNotice);
    paramContentValues.put("bHaveVotedCnt", Short.valueOf(paramEntity.bHaveVotedCnt));
    paramContentValues.put("bAvailVoteCnt", Short.valueOf(paramEntity.bAvailVoteCnt));
    paramContentValues.put("olympicTorch", Byte.valueOf(paramEntity.olympicTorch));
    paramContentValues.put("mNowShowFlag", Integer.valueOf(paramEntity.mNowShowFlag));
    paramContentValues.put("mNowShowIconUrl", paramEntity.mNowShowIconUrl);
    paramContentValues.put("mNowShowJumpUrl", paramEntity.mNowShowJumpUrl);
    paramContentValues.put("vCoverInfo", paramEntity.vCoverInfo);
    paramContentValues.put("videoHeadFlag", Boolean.valueOf(paramEntity.videoHeadFlag));
    paramContentValues.put("videoHeadUrl", paramEntity.videoHeadUrl);
    paramContentValues.put("medalSwitchDisable", Boolean.valueOf(paramEntity.medalSwitchDisable));
    paramContentValues.put("iMedalCount", Integer.valueOf(paramEntity.iMedalCount));
    paramContentValues.put("iNewCount", Integer.valueOf(paramEntity.iNewCount));
    paramContentValues.put("iUpgradeCount", Integer.valueOf(paramEntity.iUpgradeCount));
    paramContentValues.put("strPromptParams", paramEntity.strPromptParams);
    paramContentValues.put("hobbyEntry", paramEntity.hobbyEntry);
    paramContentValues.put("lastPraiseInfoList", paramEntity.lastPraiseInfoList);
    paramContentValues.put("tempChatSig", paramEntity.tempChatSig);
    paramContentValues.put("namePlateOfKingGameId", Long.valueOf(paramEntity.namePlateOfKingGameId));
    paramContentValues.put("namePlateOfKingLoginTime", Long.valueOf(paramEntity.namePlateOfKingLoginTime));
    paramContentValues.put("namePlateOfKingDan", Integer.valueOf(paramEntity.namePlateOfKingDan));
    paramContentValues.put("namePlateOfKingDanDisplatSwitch", Boolean.valueOf(paramEntity.namePlateOfKingDanDisplatSwitch));
    paramContentValues.put("vPersonalityLabelV2", paramEntity.vPersonalityLabelV2);
    paramContentValues.put("cardType", Integer.valueOf(paramEntity.cardType));
    paramContentValues.put("diyText", paramEntity.diyText);
    paramContentValues.put("diyTextFontId", Integer.valueOf(paramEntity.diyTextFontId));
    paramContentValues.put("diyTextWidth", Float.valueOf(paramEntity.diyTextWidth));
    paramContentValues.put("diyTextHeight", Float.valueOf(paramEntity.diyTextHeight));
    paramContentValues.put("diyTextLocX", Float.valueOf(paramEntity.diyTextLocX));
    paramContentValues.put("diyTextLocY", Float.valueOf(paramEntity.diyTextLocY));
    paramContentValues.put("diyTextDegree", Float.valueOf(paramEntity.diyTextDegree));
    paramContentValues.put("diyTextScale", Float.valueOf(paramEntity.diyTextScale));
    paramContentValues.put("diyTextTransparency", Float.valueOf(paramEntity.diyTextTransparency));
    paramContentValues.put("diyDefaultText", paramEntity.diyDefaultText);
    paramContentValues.put("popularity", Integer.valueOf(paramEntity.popularity));
    paramContentValues.put("declaration", paramEntity.declaration);
    paramContentValues.put("voiceUrl", paramEntity.voiceUrl);
    paramContentValues.put("isShowCard", Boolean.valueOf(paramEntity.isShowCard));
    paramContentValues.put("updateTime", Long.valueOf(paramEntity.updateTime));
    paramContentValues.put("extendFriendFlag", Integer.valueOf(paramEntity.extendFriendFlag));
    paramContentValues.put("extendFriendVoiceDuration", Integer.valueOf(paramEntity.extendFriendVoiceDuration));
    paramContentValues.put("extendFriendEntryContact", Short.valueOf(paramEntity.extendFriendEntryContact));
    paramContentValues.put("extendFriendEntryAddFriend", Short.valueOf(paramEntity.extendFriendEntryAddFriend));
    paramContentValues.put("extendFriendQuestion", Short.valueOf(paramEntity.extendFriendQuestion));
    paramContentValues.put("fontId", Integer.valueOf(paramEntity.fontId));
    paramContentValues.put("fontType", Integer.valueOf(paramEntity.fontType));
    paramContentValues.put("clothesId", Integer.valueOf(paramEntity.clothesId));
    paramContentValues.put("schoolId", paramEntity.schoolId);
    paramContentValues.put("schoolName", paramEntity.schoolName);
    paramContentValues.put("authState", Long.valueOf(paramEntity.authState));
    paramContentValues.put("idx", Integer.valueOf(paramEntity.idx));
    paramContentValues.put("category", Integer.valueOf(paramEntity.category));
    paramContentValues.put("isShowMiniPlaying", Boolean.valueOf(paramEntity.isShowMiniPlaying));
    paramContentValues.put("tabJumpUrl", paramEntity.tabJumpUrl);
    paramContentValues.put("guestJumpUrl", paramEntity.guestJumpUrl);
    paramContentValues.put("guestAppTotal", Integer.valueOf(paramEntity.guestAppTotal));
    paramContentValues.put("defaultCardId", Integer.valueOf(paramEntity.defaultCardId));
    paramContentValues.put("strangerVoteOpen", Boolean.valueOf(paramEntity.strangerVoteOpen));
    paramContentValues.put("lSuperVipTemplateId", Long.valueOf(paramEntity.lSuperVipTemplateId));
    paramContentValues.put("bBigClubVipOpen", Byte.valueOf(paramEntity.bBigClubVipOpen));
    paramContentValues.put("iBigClubVipType", Integer.valueOf(paramEntity.iBigClubVipType));
    paramContentValues.put("iBigClubVipLevel", Integer.valueOf(paramEntity.iBigClubVipLevel));
    paramContentValues.put("lBigClubTemplateId", Long.valueOf(paramEntity.lBigClubTemplateId));
    paramContentValues.put("diyComplicatedInfo", paramEntity.diyComplicatedInfo);
    paramContentValues.put("cardId", Long.valueOf(paramEntity.cardId));
    paramContentValues.put("strangerInviteMeGroupOpen", Boolean.valueOf(paramEntity.strangerInviteMeGroupOpen));
    paramContentValues.put("isPrettyGroupOwner", Boolean.valueOf(paramEntity.isPrettyGroupOwner));
    paramContentValues.put("isHidePrettyGroutIdentity", Boolean.valueOf(paramEntity.isHidePrettyGroutIdentity));
    paramContentValues.put("mQQLevelType", Integer.valueOf(paramEntity.mQQLevelType));
    paramContentValues.put("schoolVerifiedFlag", Boolean.valueOf(paramEntity.schoolVerifiedFlag));
    paramContentValues.put("troopHonorSwitch", Boolean.valueOf(paramEntity.troopHonorSwitch));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,strNick TEXT ,shGender INTEGER ,shAge INTEGER ,nFaceID INTEGER ,strCertificationInfo TEXT ,shType INTEGER ,vContent BLOB ,strSign TEXT ,strCompany TEXT ,strSchool TEXT ,uFaceTimeStamp INTEGER ,vQQFaceID BLOB ,strReMark TEXT ,bWeiboInfo INTEGER ,bQzoneInfo INTEGER ,nSameFriendsNum INTEGER ,strCompanySame TEXT ,strSchoolSame TEXT ,lCardShowNum INTEGER ,bSingle INTEGER ,lVisitCount INTEGER ,lVoteCount INTEGER ,tagInfosByte BLOB ,eUserIdentityType INTEGER ,vBackground BLOB ,labelInfoBytes BLOB ,age INTEGER ,constellation INTEGER ,pyFaceUrl TEXT ,location TEXT ,bVoted INTEGER ,bFavorited INTEGER ,iVoteIncrement INTEGER ,strJoinHexAlbumFileKey TEXT ,iFaceNum INTEGER ,cSqqLevel INTEGER ,iQQLevel INTEGER ,uCurMulType INTEGER ,strProvince TEXT ,strCity TEXT ,strCountry TEXT ,lBirthday INTEGER ,strLocationCodes TEXT ,strLocationDesc TEXT ,strHometownCodes TEXT ,strHometownDesc TEXT ,strEmail TEXT ,strPersonalNote TEXT ,iProfession INTEGER ,bindPhoneInfo TEXT ,bCardInfo BLOB ,strTroopName TEXT ,strTroopNick TEXT ,strMobile TEXT ,strContactName TEXT ,ulShowControl INTEGER ,feedPreviewTime INTEGER ,strQzoneFeedsDesc TEXT ,StrPresentDesc TEXT ,strSpaceName TEXT ,strQzoneHeader TEXT ,vQzonePhotos BLOB ,vQzoneCoverInfo BLOB ,enlargeQzonePic INTEGER ,showPublishButton INTEGER ,strStatus TEXT ,strAutoRemark TEXT ,vSeed BLOB ,vCookies BLOB ,hasFakeData INTEGER ,bQQVipOpen INTEGER ,iQQVipType INTEGER ,iQQVipLevel INTEGER ,nameplateVipType INTEGER ,grayNameplateFlag INTEGER ,bSuperVipOpen INTEGER ,iSuperVipType INTEGER ,iSuperVipLevel INTEGER ,bSuperQQOpen INTEGER ,iSuperQQType INTEGER ,iSuperQQLevel INTEGER ,bHollywoodVipOpen INTEGER ,iHollywoodVipType INTEGER ,iHollywoodVipLevel INTEGER ,strShowName TEXT ,strVoiceFilekey TEXT ,shDuration INTEGER ,bRead INTEGER ,strUrl TEXT ,vRichSign BLOB ,lSignModifyTime INTEGER ,vLongNickTopicInfo BLOB ,nLastGameFlag INTEGER ,strGameLogoUrl_1 TEXT ,strGameLogoUrl_2 TEXT ,strGameLogoUrl_3 TEXT ,strGameLogoUrl_4 TEXT ,strGameLogoKey_1 TEXT ,strGameLogoKey_2 TEXT ,strGameLogoKey_3 TEXT ,strGameLogoKey_4 TEXT ,strGameName_1 TEXT ,strGameName_2 TEXT ,strGameName_3 TEXT ,strGameName_4 TEXT ,strGameAppid_1 TEXT ,strGameAppid_2 TEXT ,strGameAppid_3 TEXT ,strGameAppid_4 TEXT ,strProfileUrl TEXT ,nStarFansFlag INTEGER ,strStarPicUrl_0 TEXT ,strStarPicUrl_1 TEXT ,strStarPicUrl_2 TEXT ,strStarLvUrl_0 TEXT ,strStarLvUrl_1 TEXT ,strStarLvUrl_2 TEXT ,strStarLogoUrl TEXT ,starFansJumpUrl TEXT ,lUserFlag INTEGER ,lLoginDays INTEGER ,strLoginDaysDesc TEXT ,lQQMasterLogindays INTEGER ,iXManScene1DelayTime INTEGER ,iXManScene2DelayTime INTEGER ,allowPeopleSee INTEGER ,allowCalInteractive INTEGER ,showOnlineFriends INTEGER ,allowClick INTEGER ,babyQSwitch INTEGER ,showLightalk INTEGER ,lightalkNick TEXT ,lightalkId TEXT ,isSuperRedDiamond INTEGER ,isRedDiamond INTEGER ,redLevel INTEGER ,isSuperYellowDiamond INTEGER ,isYellowDiamond INTEGER ,yellowLevel INTEGER ,isSuperGreenDiamond INTEGER ,isGreenDiamond INTEGER ,greenLevel INTEGER ,uAccelerateMultiple INTEGER ,strRespMusicInfo TEXT ,templateRet INTEGER ,lCurrentStyleId INTEGER ,lCurrentBgId INTEGER ,backgroundUrl TEXT ,backgroundColor INTEGER ,dynamicCardFlag INTEGER ,strZipUrl TEXT ,strActiveUrl TEXT ,strDrawerCardUrl TEXT ,strWzryHeroUrl TEXT ,wzryHonorInfo BLOB ,strExtInfo TEXT ,strCurrentBgUrl TEXT ,bgType BLOB ,encId TEXT ,busiEntry TEXT ,favoriteSource INTEGER ,visibleMusicPendant INTEGER ,autoPlayMusicPendant INTEGER ,showRedPointMusicPendant INTEGER ,privilegePromptStr TEXT ,privilegeJumpUrl TEXT ,vOpenPriv BLOB ,vClosePriv BLOB ,presentDesc TEXT ,presentCustourl TEXT ,presentSwitch INTEGER ,showPresent INTEGER ,showMusicBox INTEGER ,addSrcName TEXT ,addSrcId INTEGER ,addSubSrcId INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,olympicTorch INTEGER ,mNowShowFlag INTEGER ,mNowShowIconUrl TEXT ,mNowShowJumpUrl TEXT ,vCoverInfo BLOB ,videoHeadFlag INTEGER ,videoHeadUrl TEXT ,medalSwitchDisable INTEGER ,iMedalCount INTEGER ,iNewCount INTEGER ,iUpgradeCount INTEGER ,strPromptParams TEXT ,hobbyEntry TEXT ,lastPraiseInfoList BLOB ,tempChatSig BLOB ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,vPersonalityLabelV2 BLOB ,cardType INTEGER ,diyText TEXT ,diyTextFontId INTEGER ,diyTextWidth REAL ,diyTextHeight REAL ,diyTextLocX REAL ,diyTextLocY REAL ,diyTextDegree REAL ,diyTextScale REAL ,diyTextTransparency REAL ,diyDefaultText TEXT ,popularity INTEGER ,declaration TEXT ,voiceUrl TEXT ,isShowCard INTEGER ,updateTime INTEGER ,extendFriendFlag INTEGER ,extendFriendVoiceDuration INTEGER ,extendFriendEntryContact INTEGER ,extendFriendEntryAddFriend INTEGER ,extendFriendQuestion INTEGER ,fontId INTEGER ,fontType INTEGER ,clothesId INTEGER ,schoolId TEXT ,schoolName TEXT ,authState INTEGER ,idx INTEGER ,category INTEGER ,isShowMiniPlaying INTEGER ,tabJumpUrl TEXT ,guestJumpUrl TEXT ,guestAppTotal INTEGER ,defaultCardId INTEGER ,strangerVoteOpen INTEGER ,lSuperVipTemplateId INTEGER ,bBigClubVipOpen INTEGER ,iBigClubVipType INTEGER ,iBigClubVipLevel INTEGER ,lBigClubTemplateId INTEGER ,diyComplicatedInfo TEXT ,cardId INTEGER ,strangerInviteMeGroupOpen INTEGER ,isPrettyGroupOwner INTEGER ,isHidePrettyGroutIdentity INTEGER ,mQQLevelType INTEGER ,schoolVerifiedFlag INTEGER ,troopHonorSwitch INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     akux
 * JD-Core Version:    0.7.0.1
 */