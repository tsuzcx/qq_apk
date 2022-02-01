import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class akwc
  extends OGAbstractDao
{
  public akwc()
  {
    this.columnLen = 118;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (TroopInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      paramEntity.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      paramEntity.troopcode = paramCursor.getString(paramCursor.getColumnIndex("troopcode"));
      paramEntity.troopowneruin = paramCursor.getString(paramCursor.getColumnIndex("troopowneruin"));
      paramEntity.troopname = paramCursor.getString(paramCursor.getColumnIndex("troopname"));
      paramEntity.newTroopName = paramCursor.getString(paramCursor.getColumnIndex("newTroopName"));
      paramEntity.newTroopNameTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("newTroopNameTimeStamp"));
      paramEntity.troopface = paramCursor.getShort(paramCursor.getColumnIndex("troopface"));
      paramEntity.troopmemo = paramCursor.getString(paramCursor.getColumnIndex("troopmemo"));
      paramEntity.fingertroopmemo = paramCursor.getString(paramCursor.getColumnIndex("fingertroopmemo"));
      paramEntity.mRichFingerMemo = paramCursor.getString(paramCursor.getColumnIndex("mRichFingerMemo"));
      paramEntity.troopmask = paramCursor.getInt(paramCursor.getColumnIndex("troopmask"));
      paramEntity.trooptype = paramCursor.getInt(paramCursor.getColumnIndex("trooptype"));
      paramEntity.troopCreateTime = paramCursor.getLong(paramCursor.getColumnIndex("troopCreateTime"));
      paramEntity.dwGroupFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlag"));
      paramEntity.cGroupOption = paramCursor.getShort(paramCursor.getColumnIndex("cGroupOption"));
      paramEntity.wMemberMax = paramCursor.getInt(paramCursor.getColumnIndex("wMemberMax"));
      paramEntity.maxAdminNum = paramCursor.getInt(paramCursor.getColumnIndex("maxAdminNum"));
      paramEntity.wSpecialClass = paramCursor.getInt(paramCursor.getColumnIndex("wSpecialClass"));
      paramEntity.cGroupLevel = paramCursor.getShort(paramCursor.getColumnIndex("cGroupLevel"));
      paramEntity.wMemberNum = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNum"));
      paramEntity.wMemberNumClient = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNumClient"));
      paramEntity.Administrator = paramCursor.getString(paramCursor.getColumnIndex("Administrator"));
      paramEntity.dwGroupClassExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupClassExt"));
      paramEntity.mGroupClassExtText = paramCursor.getString(paramCursor.getColumnIndex("mGroupClassExtText"));
      paramEntity.dwGroupFlagExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt"));
      paramEntity.dwAuthGroupType = paramCursor.getLong(paramCursor.getColumnIndex("dwAuthGroupType"));
      paramEntity.troopAuthenticateInfo = paramCursor.getString(paramCursor.getColumnIndex("troopAuthenticateInfo"));
      paramEntity.dwGroupInfoSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupInfoSeq"));
      paramEntity.mMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberNumSeq"));
      paramEntity.mOldMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberNumSeq"));
      paramEntity.mMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberCardSeq"));
      paramEntity.mOldMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberCardSeq"));
      paramEntity.dwGroupLevelSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupLevelSeq"));
      paramEntity.cGroupRankSysFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankSysFlag")));
      paramEntity.cGroupRankUserFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankUserFlag")));
      paramEntity.troopLevelMap = paramCursor.getString(paramCursor.getColumnIndex("troopLevelMap"));
      paramEntity.joinTroopQuestion = paramCursor.getString(paramCursor.getColumnIndex("joinTroopQuestion"));
      paramEntity.joinTroopAnswer = paramCursor.getString(paramCursor.getColumnIndex("joinTroopAnswer"));
      paramEntity.cAlbumResult = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cAlbumResult")));
      paramEntity.dwTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwTimeStamp"));
      paramEntity.strQZonePhotoUrls = paramCursor.getString(paramCursor.getColumnIndex("strQZonePhotoUrls"));
      paramEntity.mQZonePhotoNum = paramCursor.getInt(paramCursor.getColumnIndex("mQZonePhotoNum"));
      paramEntity.strLocation = paramCursor.getString(paramCursor.getColumnIndex("strLocation"));
      paramEntity.troopLat = paramCursor.getInt(paramCursor.getColumnIndex("troopLat"));
      paramEntity.troopLon = paramCursor.getInt(paramCursor.getColumnIndex("troopLon"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("mMemberInvitingFlag")))
      {
        paramBoolean = true;
        paramEntity.mMemberInvitingFlag = paramBoolean;
        paramEntity.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramEntity.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramEntity.mSomeMemberUins = paramCursor.getString(paramCursor.getColumnIndex("mSomeMemberUins"));
        paramEntity.mHeaderUinsOld = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsOld"));
        paramEntity.mHeaderUinsNew = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsNew"));
        paramEntity.mTags = paramCursor.getString(paramCursor.getColumnIndex("mTags"));
        paramEntity.mTroopAvatarId = paramCursor.getInt(paramCursor.getColumnIndex("mTroopAvatarId"));
        paramEntity.mTroopPicListJson = paramCursor.getString(paramCursor.getColumnIndex("mTroopPicListJson"));
        paramEntity.nTroopGrade = paramCursor.getInt(paramCursor.getColumnIndex("nTroopGrade"));
        paramEntity.isShowInNearbyTroops = paramCursor.getInt(paramCursor.getColumnIndex("isShowInNearbyTroops"));
        paramEntity.dwGagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp"));
        paramEntity.dwGagTimeStamp_me = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp_me"));
        paramEntity.dwCmdUinUinFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinUinFlag"));
        paramEntity.dwAdditionalFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAdditionalFlag"));
        paramEntity.troopTypeExt = paramCursor.getInt(paramCursor.getColumnIndex("troopTypeExt"));
        paramEntity.ownerNameShow = paramCursor.getString(paramCursor.getColumnIndex("ownerNameShow"));
        paramEntity.adminNameShow = paramCursor.getString(paramCursor.getColumnIndex("adminNameShow"));
        paramEntity.dwOfficeMode = paramCursor.getLong(paramCursor.getColumnIndex("dwOfficeMode"));
        paramEntity.dwGroupFlagExt3 = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt3"));
        paramEntity.cmdUinFlagEx2 = paramCursor.getLong(paramCursor.getColumnIndex("cmdUinFlagEx2"));
        paramEntity.udwCmdUinRingtoneID = paramCursor.getLong(paramCursor.getColumnIndex("udwCmdUinRingtoneID"));
        paramEntity.memberListToShow = paramCursor.getString(paramCursor.getColumnIndex("memberListToShow"));
        paramEntity.troopPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("troopPrivilegeFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isNewTroop"))) {
          break label2258;
        }
        paramBoolean = true;
        label1343:
        paramEntity.isNewTroop = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSetNewTroopHead"))) {
          break label2263;
        }
        paramBoolean = true;
        label1369:
        paramEntity.hasSetNewTroopHead = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSetNewTroopName"))) {
          break label2268;
        }
        paramBoolean = true;
        label1395:
        paramEntity.hasSetNewTroopName = paramBoolean;
        paramEntity.maxInviteMemNum = paramCursor.getInt(paramCursor.getColumnIndex("maxInviteMemNum"));
        paramEntity.lastMsgTime = paramCursor.getLong(paramCursor.getColumnIndex("lastMsgTime"));
        paramEntity.allowMemberModifTroopName = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberModifTroopName"));
        paramEntity.allowMemberKick = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberKick"));
        paramEntity.allowMemberAtAll = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberAtAll"));
        paramEntity.oldTroopName = paramCursor.getString(paramCursor.getColumnIndex("oldTroopName"));
        paramEntity.hlGuildAppid = paramCursor.getLong(paramCursor.getColumnIndex("hlGuildAppid"));
        paramEntity.hlGuildSubType = paramCursor.getLong(paramCursor.getColumnIndex("hlGuildSubType"));
        paramEntity.hlGuildOrgid = paramCursor.getInt(paramCursor.getColumnIndex("hlGuildOrgid"));
        paramEntity.hlGuildBinary = paramCursor.getInt(paramCursor.getColumnIndex("hlGuildBinary"));
        paramEntity.gameSwitchStatus = paramCursor.getInt(paramCursor.getColumnIndex("gameSwitchStatus"));
        paramEntity.showGameSwitchStatus = paramCursor.getInt(paramCursor.getColumnIndex("showGameSwitchStatus"));
        paramEntity.lastShareLbsMsgUniseq = paramCursor.getLong(paramCursor.getColumnIndex("lastShareLbsMsgUniseq"));
        paramEntity.mTroopNeedPayNumber = paramCursor.getFloat(paramCursor.getColumnIndex("mTroopNeedPayNumber"));
        paramEntity.troopCreditLevel = paramCursor.getLong(paramCursor.getColumnIndex("troopCreditLevel"));
        paramEntity.troopCreditLevelInfo = paramCursor.getLong(paramCursor.getColumnIndex("troopCreditLevelInfo"));
        paramEntity.dwAppPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAppPrivilegeFlag"));
        paramEntity.topicId = paramCursor.getString(paramCursor.getColumnIndex("topicId"));
        paramEntity.associatePubAccount = paramCursor.getLong(paramCursor.getColumnIndex("associatePubAccount"));
        paramEntity.mTroopFileVideoReqInterval = paramCursor.getLong(paramCursor.getColumnIndex("mTroopFileVideoReqInterval"));
        paramEntity.mTroopFileVideoIsWhite = paramCursor.getInt(paramCursor.getColumnIndex("mTroopFileVideoIsWhite"));
        paramEntity.mTribeStatus = paramCursor.getInt(paramCursor.getColumnIndex("mTribeStatus"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mCanSearchByKeywords"))) {
          break label2273;
        }
        paramBoolean = true;
        label1839:
        paramEntity.mCanSearchByKeywords = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mCanSearchByTroopUin"))) {
          break label2278;
        }
      }
      label2258:
      label2263:
      label2268:
      label2273:
      label2278:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.mCanSearchByTroopUin = paramBoolean;
        paramEntity.dwCmdUinJoinTime = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinJoinTime"));
        paramEntity.dwLastInsertBAFTipTime = paramCursor.getLong(paramCursor.getColumnIndex("dwLastInsertBAFTipTime"));
        paramEntity.wInsertBAFTipCount = paramCursor.getInt(paramCursor.getColumnIndex("wInsertBAFTipCount"));
        paramEntity.wClickBAFTipCount = paramCursor.getInt(paramCursor.getColumnIndex("wClickBAFTipCount"));
        paramEntity.dwLastBAFTipMsgUniSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq"));
        paramEntity.dwLastBAFTipMsgUniSeq2 = paramCursor.getLong(paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq2"));
        paramEntity.dailyNewMemberUins = paramCursor.getString(paramCursor.getColumnIndex("dailyNewMemberUins"));
        paramEntity.exitTroopReason = paramCursor.getInt(paramCursor.getColumnIndex("exitTroopReason"));
        paramEntity.eliminated = paramCursor.getInt(paramCursor.getColumnIndex("eliminated"));
        paramEntity.mIsFreezed = paramCursor.getInt(paramCursor.getColumnIndex("mIsFreezed"));
        paramEntity.strLastAnnouncement = paramCursor.getString(paramCursor.getColumnIndex("strLastAnnouncement"));
        paramEntity.nMsgLimitFreq = paramCursor.getInt(paramCursor.getColumnIndex("nMsgLimitFreq"));
        paramEntity.mAtOrReplyMeUins = paramCursor.getString(paramCursor.getColumnIndex("mAtOrReplyMeUins"));
        paramEntity.groupFlagExt4 = paramCursor.getInt(paramCursor.getColumnIndex("groupFlagExt4"));
        paramEntity.groupFreezeReason = paramCursor.getInt(paramCursor.getColumnIndex("groupFreezeReason"));
        paramEntity.troopHonorGrayFlag = paramCursor.getInt(paramCursor.getColumnIndex("troopHonorGrayFlag"));
        paramEntity.isAllowHistoryMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("isAllowHistoryMsgFlag"));
        paramEntity.troopRepeatType = paramCursor.getInt(paramCursor.getColumnIndex("troopRepeatType"));
        paramEntity.feeds_id = paramCursor.getString(paramCursor.getColumnIndex("feeds_id"));
        paramEntity.myHonorList = paramCursor.getString(paramCursor.getColumnIndex("myHonorList"));
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1343;
        paramBoolean = false;
        break label1369;
        paramBoolean = false;
        break label1395;
        paramBoolean = false;
        break label1839;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("timeSec");
      if (i != -1) {
        break label6560;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("timeSec", Long.TYPE));
      label2353:
      i = paramCursor.getColumnIndex("troopuin");
      if (i != -1) {
        break label6575;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopuin", String.class));
      label2388:
      i = paramCursor.getColumnIndex("troopcode");
      if (i != -1) {
        break label6590;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopcode", String.class));
      label2423:
      i = paramCursor.getColumnIndex("troopowneruin");
      if (i != -1) {
        break label6605;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopowneruin", String.class));
      label2458:
      i = paramCursor.getColumnIndex("troopname");
      if (i != -1) {
        break label6620;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopname", String.class));
      label2493:
      i = paramCursor.getColumnIndex("newTroopName");
      if (i != -1) {
        break label6635;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("newTroopName", String.class));
      label2528:
      i = paramCursor.getColumnIndex("newTroopNameTimeStamp");
      if (i != -1) {
        break label6650;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("newTroopNameTimeStamp", Long.TYPE));
      label2563:
      i = paramCursor.getColumnIndex("troopface");
      if (i != -1) {
        break label6665;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopface", Short.TYPE));
      label2598:
      i = paramCursor.getColumnIndex("troopmemo");
      if (i != -1) {
        break label6680;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopmemo", String.class));
      label2633:
      i = paramCursor.getColumnIndex("fingertroopmemo");
      if (i != -1) {
        break label6695;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("fingertroopmemo", String.class));
      label2668:
      i = paramCursor.getColumnIndex("mRichFingerMemo");
      if (i != -1) {
        break label6710;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mRichFingerMemo", String.class));
      label2703:
      i = paramCursor.getColumnIndex("troopmask");
      if (i != -1) {
        break label6725;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopmask", Integer.TYPE));
      label2738:
      i = paramCursor.getColumnIndex("trooptype");
      if (i != -1) {
        break label6740;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("trooptype", Integer.TYPE));
      label2773:
      i = paramCursor.getColumnIndex("troopCreateTime");
      if (i != -1) {
        break label6755;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopCreateTime", Long.TYPE));
      label2808:
      i = paramCursor.getColumnIndex("dwGroupFlag");
      if (i != -1) {
        break label6770;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupFlag", Long.TYPE));
      label2843:
      i = paramCursor.getColumnIndex("cGroupOption");
      if (i != -1) {
        break label6785;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cGroupOption", Short.TYPE));
      label2878:
      i = paramCursor.getColumnIndex("wMemberMax");
      if (i != -1) {
        break label6800;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wMemberMax", Integer.TYPE));
      label2913:
      i = paramCursor.getColumnIndex("maxAdminNum");
      if (i != -1) {
        break label6815;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("maxAdminNum", Integer.TYPE));
      label2948:
      i = paramCursor.getColumnIndex("wSpecialClass");
      if (i != -1) {
        break label6830;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wSpecialClass", Integer.TYPE));
      label2983:
      i = paramCursor.getColumnIndex("cGroupLevel");
      if (i != -1) {
        break label6845;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cGroupLevel", Short.TYPE));
      label3018:
      i = paramCursor.getColumnIndex("wMemberNum");
      if (i != -1) {
        break label6860;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wMemberNum", Integer.TYPE));
      label3053:
      i = paramCursor.getColumnIndex("wMemberNumClient");
      if (i != -1) {
        break label6875;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wMemberNumClient", Integer.TYPE));
      label3088:
      i = paramCursor.getColumnIndex("Administrator");
      if (i != -1) {
        break label6890;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("Administrator", String.class));
      label3123:
      i = paramCursor.getColumnIndex("dwGroupClassExt");
      if (i != -1) {
        break label6905;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupClassExt", Long.TYPE));
      label3158:
      i = paramCursor.getColumnIndex("mGroupClassExtText");
      if (i != -1) {
        break label6920;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mGroupClassExtText", String.class));
      label3193:
      i = paramCursor.getColumnIndex("dwGroupFlagExt");
      if (i != -1) {
        break label6935;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupFlagExt", Long.TYPE));
      label3228:
      i = paramCursor.getColumnIndex("dwAuthGroupType");
      if (i != -1) {
        break label6950;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwAuthGroupType", Long.TYPE));
      label3263:
      i = paramCursor.getColumnIndex("troopAuthenticateInfo");
      if (i != -1) {
        break label6965;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopAuthenticateInfo", String.class));
      label3298:
      i = paramCursor.getColumnIndex("dwGroupInfoSeq");
      if (i != -1) {
        break label6980;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupInfoSeq", Long.TYPE));
      label3333:
      i = paramCursor.getColumnIndex("mMemberNumSeq");
      if (i != -1) {
        break label6995;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mMemberNumSeq", Long.TYPE));
      label3368:
      i = paramCursor.getColumnIndex("mOldMemberNumSeq");
      if (i != -1) {
        break label7010;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mOldMemberNumSeq", Long.TYPE));
      label3403:
      i = paramCursor.getColumnIndex("mMemberCardSeq");
      if (i != -1) {
        break label7025;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mMemberCardSeq", Long.TYPE));
      label3438:
      i = paramCursor.getColumnIndex("mOldMemberCardSeq");
      if (i != -1) {
        break label7040;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mOldMemberCardSeq", Long.TYPE));
      label3473:
      i = paramCursor.getColumnIndex("dwGroupLevelSeq");
      if (i != -1) {
        break label7055;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupLevelSeq", Long.TYPE));
      label3508:
      i = paramCursor.getColumnIndex("cGroupRankSysFlag");
      if (i != -1) {
        break label7070;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cGroupRankSysFlag", Byte.TYPE));
      label3543:
      i = paramCursor.getColumnIndex("cGroupRankUserFlag");
      if (i != -1) {
        break label7086;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cGroupRankUserFlag", Byte.TYPE));
      label3578:
      i = paramCursor.getColumnIndex("troopLevelMap");
      if (i != -1) {
        break label7102;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopLevelMap", String.class));
      label3613:
      i = paramCursor.getColumnIndex("joinTroopQuestion");
      if (i != -1) {
        break label7117;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("joinTroopQuestion", String.class));
      label3648:
      i = paramCursor.getColumnIndex("joinTroopAnswer");
      if (i != -1) {
        break label7132;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("joinTroopAnswer", String.class));
      label3683:
      i = paramCursor.getColumnIndex("cAlbumResult");
      if (i != -1) {
        break label7147;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cAlbumResult", Byte.TYPE));
      label3718:
      i = paramCursor.getColumnIndex("dwTimeStamp");
      if (i != -1) {
        break label7163;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwTimeStamp", Long.TYPE));
      label3753:
      i = paramCursor.getColumnIndex("strQZonePhotoUrls");
      if (i != -1) {
        break label7178;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strQZonePhotoUrls", String.class));
      label3788:
      i = paramCursor.getColumnIndex("mQZonePhotoNum");
      if (i != -1) {
        break label7193;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mQZonePhotoNum", Integer.TYPE));
      label3823:
      i = paramCursor.getColumnIndex("strLocation");
      if (i != -1) {
        break label7208;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLocation", String.class));
      label3858:
      i = paramCursor.getColumnIndex("troopLat");
      if (i != -1) {
        break label7223;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopLat", Integer.TYPE));
      label3893:
      i = paramCursor.getColumnIndex("troopLon");
      if (i != -1) {
        break label7238;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopLon", Integer.TYPE));
      label3928:
      i = paramCursor.getColumnIndex("mMemberInvitingFlag");
      if (i != -1) {
        break label7253;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mMemberInvitingFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label7280;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mComparePartInt", Integer.TYPE));
      label3998:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label7295;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mCompareSpell", String.class));
      label4033:
      i = paramCursor.getColumnIndex("mSomeMemberUins");
      if (i != -1) {
        break label7310;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mSomeMemberUins", String.class));
      label4068:
      i = paramCursor.getColumnIndex("mHeaderUinsOld");
      if (i != -1) {
        break label7325;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mHeaderUinsOld", String.class));
      label4103:
      i = paramCursor.getColumnIndex("mHeaderUinsNew");
      if (i != -1) {
        break label7340;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mHeaderUinsNew", String.class));
      label4138:
      i = paramCursor.getColumnIndex("mTags");
      if (i != -1) {
        break label7355;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTags", String.class));
      label4175:
      i = paramCursor.getColumnIndex("mTroopAvatarId");
      if (i != -1) {
        break label7370;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTroopAvatarId", Integer.TYPE));
      label4212:
      i = paramCursor.getColumnIndex("mTroopPicListJson");
      if (i != -1) {
        break label7385;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTroopPicListJson", String.class));
      label4249:
      i = paramCursor.getColumnIndex("nTroopGrade");
      if (i != -1) {
        break label7400;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nTroopGrade", Integer.TYPE));
      label4286:
      i = paramCursor.getColumnIndex("isShowInNearbyTroops");
      if (i != -1) {
        break label7415;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isShowInNearbyTroops", Integer.TYPE));
      label4323:
      i = paramCursor.getColumnIndex("dwGagTimeStamp");
      if (i != -1) {
        break label7430;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGagTimeStamp", Long.TYPE));
      label4360:
      i = paramCursor.getColumnIndex("dwGagTimeStamp_me");
      if (i != -1) {
        break label7445;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGagTimeStamp_me", Long.TYPE));
      label4397:
      i = paramCursor.getColumnIndex("dwCmdUinUinFlag");
      if (i != -1) {
        break label7460;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwCmdUinUinFlag", Long.TYPE));
      label4434:
      i = paramCursor.getColumnIndex("dwAdditionalFlag");
      if (i != -1) {
        break label7475;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwAdditionalFlag", Long.TYPE));
      label4471:
      i = paramCursor.getColumnIndex("troopTypeExt");
      if (i != -1) {
        break label7490;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopTypeExt", Integer.TYPE));
      label4508:
      i = paramCursor.getColumnIndex("ownerNameShow");
      if (i != -1) {
        break label7505;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ownerNameShow", String.class));
      label4545:
      i = paramCursor.getColumnIndex("adminNameShow");
      if (i != -1) {
        break label7520;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("adminNameShow", String.class));
      label4582:
      i = paramCursor.getColumnIndex("dwOfficeMode");
      if (i != -1) {
        break label7535;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwOfficeMode", Long.TYPE));
      label4619:
      i = paramCursor.getColumnIndex("dwGroupFlagExt3");
      if (i != -1) {
        break label7550;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupFlagExt3", Long.TYPE));
      label4656:
      i = paramCursor.getColumnIndex("cmdUinFlagEx2");
      if (i != -1) {
        break label7565;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cmdUinFlagEx2", Long.TYPE));
      label4693:
      i = paramCursor.getColumnIndex("udwCmdUinRingtoneID");
      if (i != -1) {
        break label7580;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("udwCmdUinRingtoneID", Long.TYPE));
      label4730:
      i = paramCursor.getColumnIndex("memberListToShow");
      if (i != -1) {
        break label7595;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("memberListToShow", String.class));
      label4767:
      i = paramCursor.getColumnIndex("troopPrivilegeFlag");
      if (i != -1) {
        break label7610;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopPrivilegeFlag", Long.TYPE));
      label4804:
      i = paramCursor.getColumnIndex("isNewTroop");
      if (i != -1) {
        break label7625;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isNewTroop", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasSetNewTroopHead");
      if (i != -1) {
        break label7652;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasSetNewTroopHead", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasSetNewTroopName");
      if (i != -1) {
        break label7679;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasSetNewTroopName", Boolean.TYPE));
      i = paramCursor.getColumnIndex("maxInviteMemNum");
      if (i != -1) {
        break label7706;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("maxInviteMemNum", Integer.TYPE));
      label4952:
      i = paramCursor.getColumnIndex("lastMsgTime");
      if (i != -1) {
        break label7721;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastMsgTime", Long.TYPE));
      label4989:
      i = paramCursor.getColumnIndex("allowMemberModifTroopName");
      if (i != -1) {
        break label7736;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowMemberModifTroopName", Integer.TYPE));
      label5026:
      i = paramCursor.getColumnIndex("allowMemberKick");
      if (i != -1) {
        break label7751;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowMemberKick", Integer.TYPE));
      label5063:
      i = paramCursor.getColumnIndex("allowMemberAtAll");
      if (i != -1) {
        break label7766;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowMemberAtAll", Integer.TYPE));
      label5100:
      i = paramCursor.getColumnIndex("oldTroopName");
      if (i != -1) {
        break label7781;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("oldTroopName", String.class));
      label5137:
      i = paramCursor.getColumnIndex("hlGuildAppid");
      if (i != -1) {
        break label7796;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hlGuildAppid", Long.TYPE));
      label5174:
      i = paramCursor.getColumnIndex("hlGuildSubType");
      if (i != -1) {
        break label7811;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hlGuildSubType", Long.TYPE));
      label5211:
      i = paramCursor.getColumnIndex("hlGuildOrgid");
      if (i != -1) {
        break label7826;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hlGuildOrgid", Integer.TYPE));
      label5248:
      i = paramCursor.getColumnIndex("hlGuildBinary");
      if (i != -1) {
        break label7841;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hlGuildBinary", Integer.TYPE));
      label5285:
      i = paramCursor.getColumnIndex("gameSwitchStatus");
      if (i != -1) {
        break label7856;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("gameSwitchStatus", Integer.TYPE));
      label5322:
      i = paramCursor.getColumnIndex("showGameSwitchStatus");
      if (i != -1) {
        break label7871;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showGameSwitchStatus", Integer.TYPE));
      label5359:
      i = paramCursor.getColumnIndex("lastShareLbsMsgUniseq");
      if (i != -1) {
        break label7886;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastShareLbsMsgUniseq", Long.TYPE));
      label5396:
      i = paramCursor.getColumnIndex("mTroopNeedPayNumber");
      if (i != -1) {
        break label7901;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTroopNeedPayNumber", Float.TYPE));
      label5433:
      i = paramCursor.getColumnIndex("troopCreditLevel");
      if (i != -1) {
        break label7916;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopCreditLevel", Long.TYPE));
      label5470:
      i = paramCursor.getColumnIndex("troopCreditLevelInfo");
      if (i != -1) {
        break label7931;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopCreditLevelInfo", Long.TYPE));
      label5507:
      i = paramCursor.getColumnIndex("dwAppPrivilegeFlag");
      if (i != -1) {
        break label7946;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwAppPrivilegeFlag", Long.TYPE));
      label5544:
      i = paramCursor.getColumnIndex("topicId");
      if (i != -1) {
        break label7961;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("topicId", String.class));
      label5581:
      i = paramCursor.getColumnIndex("associatePubAccount");
      if (i != -1) {
        break label7976;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("associatePubAccount", Long.TYPE));
      label5618:
      i = paramCursor.getColumnIndex("mTroopFileVideoReqInterval");
      if (i != -1) {
        break label7991;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTroopFileVideoReqInterval", Long.TYPE));
      label5655:
      i = paramCursor.getColumnIndex("mTroopFileVideoIsWhite");
      if (i != -1) {
        break label8006;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTroopFileVideoIsWhite", Integer.TYPE));
      label5692:
      i = paramCursor.getColumnIndex("mTribeStatus");
      if (i != -1) {
        break label8021;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTribeStatus", Integer.TYPE));
      label5729:
      i = paramCursor.getColumnIndex("mCanSearchByKeywords");
      if (i != -1) {
        break label8036;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mCanSearchByKeywords", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mCanSearchByTroopUin");
      if (i != -1) {
        break label8063;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mCanSearchByTroopUin", Boolean.TYPE));
      i = paramCursor.getColumnIndex("dwCmdUinJoinTime");
      if (i != -1) {
        break label8091;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwCmdUinJoinTime", Long.TYPE));
      label5840:
      i = paramCursor.getColumnIndex("dwLastInsertBAFTipTime");
      if (i != -1) {
        break label8106;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwLastInsertBAFTipTime", Long.TYPE));
      label5877:
      i = paramCursor.getColumnIndex("wInsertBAFTipCount");
      if (i != -1) {
        break label8121;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wInsertBAFTipCount", Integer.TYPE));
      label5914:
      i = paramCursor.getColumnIndex("wClickBAFTipCount");
      if (i != -1) {
        break label8136;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wClickBAFTipCount", Integer.TYPE));
      label5951:
      i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq");
      if (i != -1) {
        break label8151;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwLastBAFTipMsgUniSeq", Long.TYPE));
      label5988:
      i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq2");
      if (i != -1) {
        break label8166;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwLastBAFTipMsgUniSeq2", Long.TYPE));
      label6025:
      i = paramCursor.getColumnIndex("dailyNewMemberUins");
      if (i != -1) {
        break label8181;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dailyNewMemberUins", String.class));
      label6062:
      i = paramCursor.getColumnIndex("exitTroopReason");
      if (i != -1) {
        break label8196;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("exitTroopReason", Integer.TYPE));
      label6099:
      i = paramCursor.getColumnIndex("eliminated");
      if (i != -1) {
        break label8211;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("eliminated", Integer.TYPE));
      label6136:
      i = paramCursor.getColumnIndex("mIsFreezed");
      if (i != -1) {
        break label8226;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mIsFreezed", Integer.TYPE));
      label6173:
      i = paramCursor.getColumnIndex("strLastAnnouncement");
      if (i != -1) {
        break label8241;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLastAnnouncement", String.class));
      label6210:
      i = paramCursor.getColumnIndex("nMsgLimitFreq");
      if (i != -1) {
        break label8256;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nMsgLimitFreq", Integer.TYPE));
      label6247:
      i = paramCursor.getColumnIndex("mAtOrReplyMeUins");
      if (i != -1) {
        break label8271;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mAtOrReplyMeUins", String.class));
      label6284:
      i = paramCursor.getColumnIndex("groupFlagExt4");
      if (i != -1) {
        break label8286;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("groupFlagExt4", Integer.TYPE));
      label6321:
      i = paramCursor.getColumnIndex("groupFreezeReason");
      if (i != -1) {
        break label8301;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("groupFreezeReason", Integer.TYPE));
      label6358:
      i = paramCursor.getColumnIndex("troopHonorGrayFlag");
      if (i != -1) {
        break label8316;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopHonorGrayFlag", Integer.TYPE));
      label6395:
      i = paramCursor.getColumnIndex("isAllowHistoryMsgFlag");
      if (i != -1) {
        break label8331;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isAllowHistoryMsgFlag", Integer.TYPE));
      label6432:
      i = paramCursor.getColumnIndex("troopRepeatType");
      if (i != -1) {
        break label8346;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopRepeatType", Integer.TYPE));
      label6469:
      i = paramCursor.getColumnIndex("feeds_id");
      if (i != -1) {
        break label8361;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feeds_id", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("myHonorList");
      if (i != -1) {
        break label8376;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("myHonorList", String.class));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label6560:
      paramEntity.timeSec = paramCursor.getLong(i);
      break label2353;
      label6575:
      paramEntity.troopuin = paramCursor.getString(i);
      break label2388;
      label6590:
      paramEntity.troopcode = paramCursor.getString(i);
      break label2423;
      label6605:
      paramEntity.troopowneruin = paramCursor.getString(i);
      break label2458;
      label6620:
      paramEntity.troopname = paramCursor.getString(i);
      break label2493;
      label6635:
      paramEntity.newTroopName = paramCursor.getString(i);
      break label2528;
      label6650:
      paramEntity.newTroopNameTimeStamp = paramCursor.getLong(i);
      break label2563;
      label6665:
      paramEntity.troopface = paramCursor.getShort(i);
      break label2598;
      label6680:
      paramEntity.troopmemo = paramCursor.getString(i);
      break label2633;
      label6695:
      paramEntity.fingertroopmemo = paramCursor.getString(i);
      break label2668;
      label6710:
      paramEntity.mRichFingerMemo = paramCursor.getString(i);
      break label2703;
      label6725:
      paramEntity.troopmask = paramCursor.getInt(i);
      break label2738;
      label6740:
      paramEntity.trooptype = paramCursor.getInt(i);
      break label2773;
      label6755:
      paramEntity.troopCreateTime = paramCursor.getLong(i);
      break label2808;
      label6770:
      paramEntity.dwGroupFlag = paramCursor.getLong(i);
      break label2843;
      label6785:
      paramEntity.cGroupOption = paramCursor.getShort(i);
      break label2878;
      label6800:
      paramEntity.wMemberMax = paramCursor.getInt(i);
      break label2913;
      label6815:
      paramEntity.maxAdminNum = paramCursor.getInt(i);
      break label2948;
      label6830:
      paramEntity.wSpecialClass = paramCursor.getInt(i);
      break label2983;
      label6845:
      paramEntity.cGroupLevel = paramCursor.getShort(i);
      break label3018;
      label6860:
      paramEntity.wMemberNum = paramCursor.getInt(i);
      break label3053;
      label6875:
      paramEntity.wMemberNumClient = paramCursor.getInt(i);
      break label3088;
      label6890:
      paramEntity.Administrator = paramCursor.getString(i);
      break label3123;
      label6905:
      paramEntity.dwGroupClassExt = paramCursor.getLong(i);
      break label3158;
      label6920:
      paramEntity.mGroupClassExtText = paramCursor.getString(i);
      break label3193;
      label6935:
      paramEntity.dwGroupFlagExt = paramCursor.getLong(i);
      break label3228;
      label6950:
      paramEntity.dwAuthGroupType = paramCursor.getLong(i);
      break label3263;
      label6965:
      paramEntity.troopAuthenticateInfo = paramCursor.getString(i);
      break label3298;
      label6980:
      paramEntity.dwGroupInfoSeq = paramCursor.getLong(i);
      break label3333;
      label6995:
      paramEntity.mMemberNumSeq = paramCursor.getLong(i);
      break label3368;
      label7010:
      paramEntity.mOldMemberNumSeq = paramCursor.getLong(i);
      break label3403;
      label7025:
      paramEntity.mMemberCardSeq = paramCursor.getLong(i);
      break label3438;
      label7040:
      paramEntity.mOldMemberCardSeq = paramCursor.getLong(i);
      break label3473;
      label7055:
      paramEntity.dwGroupLevelSeq = paramCursor.getLong(i);
      break label3508;
      label7070:
      paramEntity.cGroupRankSysFlag = ((byte)paramCursor.getShort(i));
      break label3543;
      label7086:
      paramEntity.cGroupRankUserFlag = ((byte)paramCursor.getShort(i));
      break label3578;
      label7102:
      paramEntity.troopLevelMap = paramCursor.getString(i);
      break label3613;
      label7117:
      paramEntity.joinTroopQuestion = paramCursor.getString(i);
      break label3648;
      label7132:
      paramEntity.joinTroopAnswer = paramCursor.getString(i);
      break label3683;
      label7147:
      paramEntity.cAlbumResult = ((byte)paramCursor.getShort(i));
      break label3718;
      label7163:
      paramEntity.dwTimeStamp = paramCursor.getLong(i);
      break label3753;
      label7178:
      paramEntity.strQZonePhotoUrls = paramCursor.getString(i);
      break label3788;
      label7193:
      paramEntity.mQZonePhotoNum = paramCursor.getInt(i);
      break label3823;
      label7208:
      paramEntity.strLocation = paramCursor.getString(i);
      break label3858;
      label7223:
      paramEntity.troopLat = paramCursor.getInt(i);
      break label3893;
      label7238:
      paramEntity.troopLon = paramCursor.getInt(i);
      break label3928;
      label7253:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.mMemberInvitingFlag = paramBoolean;
        break;
      }
      label7280:
      paramEntity.mComparePartInt = paramCursor.getInt(i);
      break label3998;
      label7295:
      paramEntity.mCompareSpell = paramCursor.getString(i);
      break label4033;
      label7310:
      paramEntity.mSomeMemberUins = paramCursor.getString(i);
      break label4068;
      label7325:
      paramEntity.mHeaderUinsOld = paramCursor.getString(i);
      break label4103;
      label7340:
      paramEntity.mHeaderUinsNew = paramCursor.getString(i);
      break label4138;
      label7355:
      paramEntity.mTags = paramCursor.getString(i);
      break label4175;
      label7370:
      paramEntity.mTroopAvatarId = paramCursor.getInt(i);
      break label4212;
      label7385:
      paramEntity.mTroopPicListJson = paramCursor.getString(i);
      break label4249;
      label7400:
      paramEntity.nTroopGrade = paramCursor.getInt(i);
      break label4286;
      label7415:
      paramEntity.isShowInNearbyTroops = paramCursor.getInt(i);
      break label4323;
      label7430:
      paramEntity.dwGagTimeStamp = paramCursor.getLong(i);
      break label4360;
      label7445:
      paramEntity.dwGagTimeStamp_me = paramCursor.getLong(i);
      break label4397;
      label7460:
      paramEntity.dwCmdUinUinFlag = paramCursor.getLong(i);
      break label4434;
      label7475:
      paramEntity.dwAdditionalFlag = paramCursor.getLong(i);
      break label4471;
      label7490:
      paramEntity.troopTypeExt = paramCursor.getInt(i);
      break label4508;
      label7505:
      paramEntity.ownerNameShow = paramCursor.getString(i);
      break label4545;
      label7520:
      paramEntity.adminNameShow = paramCursor.getString(i);
      break label4582;
      label7535:
      paramEntity.dwOfficeMode = paramCursor.getLong(i);
      break label4619;
      label7550:
      paramEntity.dwGroupFlagExt3 = paramCursor.getLong(i);
      break label4656;
      label7565:
      paramEntity.cmdUinFlagEx2 = paramCursor.getLong(i);
      break label4693;
      label7580:
      paramEntity.udwCmdUinRingtoneID = paramCursor.getLong(i);
      break label4730;
      label7595:
      paramEntity.memberListToShow = paramCursor.getString(i);
      break label4767;
      label7610:
      paramEntity.troopPrivilegeFlag = paramCursor.getLong(i);
      break label4804;
      label7625:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isNewTroop = paramBoolean;
        break;
      }
      label7652:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasSetNewTroopHead = paramBoolean;
        break;
      }
      label7679:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasSetNewTroopName = paramBoolean;
        break;
      }
      label7706:
      paramEntity.maxInviteMemNum = paramCursor.getInt(i);
      break label4952;
      label7721:
      paramEntity.lastMsgTime = paramCursor.getLong(i);
      break label4989;
      label7736:
      paramEntity.allowMemberModifTroopName = paramCursor.getInt(i);
      break label5026;
      label7751:
      paramEntity.allowMemberKick = paramCursor.getInt(i);
      break label5063;
      label7766:
      paramEntity.allowMemberAtAll = paramCursor.getInt(i);
      break label5100;
      label7781:
      paramEntity.oldTroopName = paramCursor.getString(i);
      break label5137;
      label7796:
      paramEntity.hlGuildAppid = paramCursor.getLong(i);
      break label5174;
      label7811:
      paramEntity.hlGuildSubType = paramCursor.getLong(i);
      break label5211;
      label7826:
      paramEntity.hlGuildOrgid = paramCursor.getInt(i);
      break label5248;
      label7841:
      paramEntity.hlGuildBinary = paramCursor.getInt(i);
      break label5285;
      label7856:
      paramEntity.gameSwitchStatus = paramCursor.getInt(i);
      break label5322;
      label7871:
      paramEntity.showGameSwitchStatus = paramCursor.getInt(i);
      break label5359;
      label7886:
      paramEntity.lastShareLbsMsgUniseq = paramCursor.getLong(i);
      break label5396;
      label7901:
      paramEntity.mTroopNeedPayNumber = paramCursor.getFloat(i);
      break label5433;
      label7916:
      paramEntity.troopCreditLevel = paramCursor.getLong(i);
      break label5470;
      label7931:
      paramEntity.troopCreditLevelInfo = paramCursor.getLong(i);
      break label5507;
      label7946:
      paramEntity.dwAppPrivilegeFlag = paramCursor.getLong(i);
      break label5544;
      label7961:
      paramEntity.topicId = paramCursor.getString(i);
      break label5581;
      label7976:
      paramEntity.associatePubAccount = paramCursor.getLong(i);
      break label5618;
      label7991:
      paramEntity.mTroopFileVideoReqInterval = paramCursor.getLong(i);
      break label5655;
      label8006:
      paramEntity.mTroopFileVideoIsWhite = paramCursor.getInt(i);
      break label5692;
      label8021:
      paramEntity.mTribeStatus = paramCursor.getInt(i);
      break label5729;
      label8036:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.mCanSearchByKeywords = paramBoolean;
        break;
      }
      label8063:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.mCanSearchByTroopUin = paramBoolean;
        break;
      }
      label8091:
      paramEntity.dwCmdUinJoinTime = paramCursor.getLong(i);
      break label5840;
      label8106:
      paramEntity.dwLastInsertBAFTipTime = paramCursor.getLong(i);
      break label5877;
      label8121:
      paramEntity.wInsertBAFTipCount = paramCursor.getInt(i);
      break label5914;
      label8136:
      paramEntity.wClickBAFTipCount = paramCursor.getInt(i);
      break label5951;
      label8151:
      paramEntity.dwLastBAFTipMsgUniSeq = paramCursor.getLong(i);
      break label5988;
      label8166:
      paramEntity.dwLastBAFTipMsgUniSeq2 = paramCursor.getLong(i);
      break label6025;
      label8181:
      paramEntity.dailyNewMemberUins = paramCursor.getString(i);
      break label6062;
      label8196:
      paramEntity.exitTroopReason = paramCursor.getInt(i);
      break label6099;
      label8211:
      paramEntity.eliminated = paramCursor.getInt(i);
      break label6136;
      label8226:
      paramEntity.mIsFreezed = paramCursor.getInt(i);
      break label6173;
      label8241:
      paramEntity.strLastAnnouncement = paramCursor.getString(i);
      break label6210;
      label8256:
      paramEntity.nMsgLimitFreq = paramCursor.getInt(i);
      break label6247;
      label8271:
      paramEntity.mAtOrReplyMeUins = paramCursor.getString(i);
      break label6284;
      label8286:
      paramEntity.groupFlagExt4 = paramCursor.getInt(i);
      break label6321;
      label8301:
      paramEntity.groupFreezeReason = paramCursor.getInt(i);
      break label6358;
      label8316:
      paramEntity.troopHonorGrayFlag = paramCursor.getInt(i);
      break label6395;
      label8331:
      paramEntity.isAllowHistoryMsgFlag = paramCursor.getInt(i);
      break label6432;
      label8346:
      paramEntity.troopRepeatType = paramCursor.getInt(i);
      break label6469;
      label8361:
      paramEntity.feeds_id = paramCursor.getString(i);
    }
    label8376:
    paramEntity.myHonorList = paramCursor.getString(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (TroopInfo)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("timeSec", Long.valueOf(paramEntity.timeSec));
    paramContentValues.put("troopuin", paramEntity.troopuin);
    paramContentValues.put("troopcode", paramEntity.troopcode);
    paramContentValues.put("troopowneruin", paramEntity.troopowneruin);
    paramContentValues.put("troopname", paramEntity.troopname);
    paramContentValues.put("newTroopName", paramEntity.newTroopName);
    paramContentValues.put("newTroopNameTimeStamp", Long.valueOf(paramEntity.newTroopNameTimeStamp));
    paramContentValues.put("troopface", Short.valueOf(paramEntity.troopface));
    paramContentValues.put("troopmemo", paramEntity.troopmemo);
    paramContentValues.put("fingertroopmemo", paramEntity.fingertroopmemo);
    paramContentValues.put("mRichFingerMemo", paramEntity.mRichFingerMemo);
    paramContentValues.put("troopmask", Integer.valueOf(paramEntity.troopmask));
    paramContentValues.put("trooptype", Integer.valueOf(paramEntity.trooptype));
    paramContentValues.put("troopCreateTime", Long.valueOf(paramEntity.troopCreateTime));
    paramContentValues.put("dwGroupFlag", Long.valueOf(paramEntity.dwGroupFlag));
    paramContentValues.put("cGroupOption", Short.valueOf(paramEntity.cGroupOption));
    paramContentValues.put("wMemberMax", Integer.valueOf(paramEntity.wMemberMax));
    paramContentValues.put("maxAdminNum", Integer.valueOf(paramEntity.maxAdminNum));
    paramContentValues.put("wSpecialClass", Integer.valueOf(paramEntity.wSpecialClass));
    paramContentValues.put("cGroupLevel", Short.valueOf(paramEntity.cGroupLevel));
    paramContentValues.put("wMemberNum", Integer.valueOf(paramEntity.wMemberNum));
    paramContentValues.put("wMemberNumClient", Integer.valueOf(paramEntity.wMemberNumClient));
    paramContentValues.put("Administrator", paramEntity.Administrator);
    paramContentValues.put("dwGroupClassExt", Long.valueOf(paramEntity.dwGroupClassExt));
    paramContentValues.put("mGroupClassExtText", paramEntity.mGroupClassExtText);
    paramContentValues.put("dwGroupFlagExt", Long.valueOf(paramEntity.dwGroupFlagExt));
    paramContentValues.put("dwAuthGroupType", Long.valueOf(paramEntity.dwAuthGroupType));
    paramContentValues.put("troopAuthenticateInfo", paramEntity.troopAuthenticateInfo);
    paramContentValues.put("dwGroupInfoSeq", Long.valueOf(paramEntity.dwGroupInfoSeq));
    paramContentValues.put("mMemberNumSeq", Long.valueOf(paramEntity.mMemberNumSeq));
    paramContentValues.put("mOldMemberNumSeq", Long.valueOf(paramEntity.mOldMemberNumSeq));
    paramContentValues.put("mMemberCardSeq", Long.valueOf(paramEntity.mMemberCardSeq));
    paramContentValues.put("mOldMemberCardSeq", Long.valueOf(paramEntity.mOldMemberCardSeq));
    paramContentValues.put("dwGroupLevelSeq", Long.valueOf(paramEntity.dwGroupLevelSeq));
    paramContentValues.put("cGroupRankSysFlag", Byte.valueOf(paramEntity.cGroupRankSysFlag));
    paramContentValues.put("cGroupRankUserFlag", Byte.valueOf(paramEntity.cGroupRankUserFlag));
    paramContentValues.put("troopLevelMap", paramEntity.troopLevelMap);
    paramContentValues.put("joinTroopQuestion", paramEntity.joinTroopQuestion);
    paramContentValues.put("joinTroopAnswer", paramEntity.joinTroopAnswer);
    paramContentValues.put("cAlbumResult", Byte.valueOf(paramEntity.cAlbumResult));
    paramContentValues.put("dwTimeStamp", Long.valueOf(paramEntity.dwTimeStamp));
    paramContentValues.put("strQZonePhotoUrls", paramEntity.strQZonePhotoUrls);
    paramContentValues.put("mQZonePhotoNum", Integer.valueOf(paramEntity.mQZonePhotoNum));
    paramContentValues.put("strLocation", paramEntity.strLocation);
    paramContentValues.put("troopLat", Integer.valueOf(paramEntity.troopLat));
    paramContentValues.put("troopLon", Integer.valueOf(paramEntity.troopLon));
    paramContentValues.put("mMemberInvitingFlag", Boolean.valueOf(paramEntity.mMemberInvitingFlag));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramEntity.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramEntity.mCompareSpell);
    paramContentValues.put("mSomeMemberUins", paramEntity.mSomeMemberUins);
    paramContentValues.put("mHeaderUinsOld", paramEntity.mHeaderUinsOld);
    paramContentValues.put("mHeaderUinsNew", paramEntity.mHeaderUinsNew);
    paramContentValues.put("mTags", paramEntity.mTags);
    paramContentValues.put("mTroopAvatarId", Integer.valueOf(paramEntity.mTroopAvatarId));
    paramContentValues.put("mTroopPicListJson", paramEntity.mTroopPicListJson);
    paramContentValues.put("nTroopGrade", Integer.valueOf(paramEntity.nTroopGrade));
    paramContentValues.put("isShowInNearbyTroops", Integer.valueOf(paramEntity.isShowInNearbyTroops));
    paramContentValues.put("dwGagTimeStamp", Long.valueOf(paramEntity.dwGagTimeStamp));
    paramContentValues.put("dwGagTimeStamp_me", Long.valueOf(paramEntity.dwGagTimeStamp_me));
    paramContentValues.put("dwCmdUinUinFlag", Long.valueOf(paramEntity.dwCmdUinUinFlag));
    paramContentValues.put("dwAdditionalFlag", Long.valueOf(paramEntity.dwAdditionalFlag));
    paramContentValues.put("troopTypeExt", Integer.valueOf(paramEntity.troopTypeExt));
    paramContentValues.put("ownerNameShow", paramEntity.ownerNameShow);
    paramContentValues.put("adminNameShow", paramEntity.adminNameShow);
    paramContentValues.put("dwOfficeMode", Long.valueOf(paramEntity.dwOfficeMode));
    paramContentValues.put("dwGroupFlagExt3", Long.valueOf(paramEntity.dwGroupFlagExt3));
    paramContentValues.put("cmdUinFlagEx2", Long.valueOf(paramEntity.cmdUinFlagEx2));
    paramContentValues.put("udwCmdUinRingtoneID", Long.valueOf(paramEntity.udwCmdUinRingtoneID));
    paramContentValues.put("memberListToShow", paramEntity.memberListToShow);
    paramContentValues.put("troopPrivilegeFlag", Long.valueOf(paramEntity.troopPrivilegeFlag));
    paramContentValues.put("isNewTroop", Boolean.valueOf(paramEntity.isNewTroop));
    paramContentValues.put("hasSetNewTroopHead", Boolean.valueOf(paramEntity.hasSetNewTroopHead));
    paramContentValues.put("hasSetNewTroopName", Boolean.valueOf(paramEntity.hasSetNewTroopName));
    paramContentValues.put("maxInviteMemNum", Integer.valueOf(paramEntity.maxInviteMemNum));
    paramContentValues.put("lastMsgTime", Long.valueOf(paramEntity.lastMsgTime));
    paramContentValues.put("allowMemberModifTroopName", Integer.valueOf(paramEntity.allowMemberModifTroopName));
    paramContentValues.put("allowMemberKick", Integer.valueOf(paramEntity.allowMemberKick));
    paramContentValues.put("allowMemberAtAll", Integer.valueOf(paramEntity.allowMemberAtAll));
    paramContentValues.put("oldTroopName", paramEntity.oldTroopName);
    paramContentValues.put("hlGuildAppid", Long.valueOf(paramEntity.hlGuildAppid));
    paramContentValues.put("hlGuildSubType", Long.valueOf(paramEntity.hlGuildSubType));
    paramContentValues.put("hlGuildOrgid", Integer.valueOf(paramEntity.hlGuildOrgid));
    paramContentValues.put("hlGuildBinary", Integer.valueOf(paramEntity.hlGuildBinary));
    paramContentValues.put("gameSwitchStatus", Integer.valueOf(paramEntity.gameSwitchStatus));
    paramContentValues.put("showGameSwitchStatus", Integer.valueOf(paramEntity.showGameSwitchStatus));
    paramContentValues.put("lastShareLbsMsgUniseq", Long.valueOf(paramEntity.lastShareLbsMsgUniseq));
    paramContentValues.put("mTroopNeedPayNumber", Float.valueOf(paramEntity.mTroopNeedPayNumber));
    paramContentValues.put("troopCreditLevel", Long.valueOf(paramEntity.troopCreditLevel));
    paramContentValues.put("troopCreditLevelInfo", Long.valueOf(paramEntity.troopCreditLevelInfo));
    paramContentValues.put("dwAppPrivilegeFlag", Long.valueOf(paramEntity.dwAppPrivilegeFlag));
    paramContentValues.put("topicId", paramEntity.topicId);
    paramContentValues.put("associatePubAccount", Long.valueOf(paramEntity.associatePubAccount));
    paramContentValues.put("mTroopFileVideoReqInterval", Long.valueOf(paramEntity.mTroopFileVideoReqInterval));
    paramContentValues.put("mTroopFileVideoIsWhite", Integer.valueOf(paramEntity.mTroopFileVideoIsWhite));
    paramContentValues.put("mTribeStatus", Integer.valueOf(paramEntity.mTribeStatus));
    paramContentValues.put("mCanSearchByKeywords", Boolean.valueOf(paramEntity.mCanSearchByKeywords));
    paramContentValues.put("mCanSearchByTroopUin", Boolean.valueOf(paramEntity.mCanSearchByTroopUin));
    paramContentValues.put("dwCmdUinJoinTime", Long.valueOf(paramEntity.dwCmdUinJoinTime));
    paramContentValues.put("dwLastInsertBAFTipTime", Long.valueOf(paramEntity.dwLastInsertBAFTipTime));
    paramContentValues.put("wInsertBAFTipCount", Integer.valueOf(paramEntity.wInsertBAFTipCount));
    paramContentValues.put("wClickBAFTipCount", Integer.valueOf(paramEntity.wClickBAFTipCount));
    paramContentValues.put("dwLastBAFTipMsgUniSeq", Long.valueOf(paramEntity.dwLastBAFTipMsgUniSeq));
    paramContentValues.put("dwLastBAFTipMsgUniSeq2", Long.valueOf(paramEntity.dwLastBAFTipMsgUniSeq2));
    paramContentValues.put("dailyNewMemberUins", paramEntity.dailyNewMemberUins);
    paramContentValues.put("exitTroopReason", Integer.valueOf(paramEntity.exitTroopReason));
    paramContentValues.put("eliminated", Integer.valueOf(paramEntity.eliminated));
    paramContentValues.put("mIsFreezed", Integer.valueOf(paramEntity.mIsFreezed));
    paramContentValues.put("strLastAnnouncement", paramEntity.strLastAnnouncement);
    paramContentValues.put("nMsgLimitFreq", Integer.valueOf(paramEntity.nMsgLimitFreq));
    paramContentValues.put("mAtOrReplyMeUins", paramEntity.mAtOrReplyMeUins);
    paramContentValues.put("groupFlagExt4", Integer.valueOf(paramEntity.groupFlagExt4));
    paramContentValues.put("groupFreezeReason", Integer.valueOf(paramEntity.groupFreezeReason));
    paramContentValues.put("troopHonorGrayFlag", Integer.valueOf(paramEntity.troopHonorGrayFlag));
    paramContentValues.put("isAllowHistoryMsgFlag", Integer.valueOf(paramEntity.isAllowHistoryMsgFlag));
    paramContentValues.put("troopRepeatType", Integer.valueOf(paramEntity.troopRepeatType));
    paramContentValues.put("feeds_id", paramEntity.feeds_id);
    paramContentValues.put("myHonorList", paramEntity.myHonorList);
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,timeSec INTEGER ,troopuin TEXT UNIQUE ,troopcode TEXT ,troopowneruin TEXT ,troopname TEXT ,newTroopName TEXT ,newTroopNameTimeStamp INTEGER ,troopface INTEGER ,troopmemo TEXT ,fingertroopmemo TEXT ,mRichFingerMemo TEXT ,troopmask INTEGER ,trooptype INTEGER ,troopCreateTime INTEGER ,dwGroupFlag INTEGER ,cGroupOption INTEGER ,wMemberMax INTEGER ,maxAdminNum INTEGER ,wSpecialClass INTEGER ,cGroupLevel INTEGER ,wMemberNum INTEGER ,wMemberNumClient INTEGER ,Administrator TEXT ,dwGroupClassExt INTEGER ,mGroupClassExtText TEXT ,dwGroupFlagExt INTEGER ,dwAuthGroupType INTEGER ,troopAuthenticateInfo TEXT ,dwGroupInfoSeq INTEGER ,mMemberNumSeq INTEGER ,mOldMemberNumSeq INTEGER ,mMemberCardSeq INTEGER ,mOldMemberCardSeq INTEGER ,dwGroupLevelSeq INTEGER ,cGroupRankSysFlag INTEGER ,cGroupRankUserFlag INTEGER ,troopLevelMap TEXT ,joinTroopQuestion TEXT ,joinTroopAnswer TEXT ,cAlbumResult INTEGER ,dwTimeStamp INTEGER ,strQZonePhotoUrls TEXT ,mQZonePhotoNum INTEGER ,strLocation TEXT ,troopLat INTEGER ,troopLon INTEGER ,mMemberInvitingFlag INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,mSomeMemberUins TEXT ,mHeaderUinsOld TEXT ,mHeaderUinsNew TEXT ,mTags TEXT ,mTroopAvatarId INTEGER ,mTroopPicListJson TEXT ,nTroopGrade INTEGER ,isShowInNearbyTroops INTEGER ,dwGagTimeStamp INTEGER ,dwGagTimeStamp_me INTEGER ,dwCmdUinUinFlag INTEGER ,dwAdditionalFlag INTEGER ,troopTypeExt INTEGER ,ownerNameShow TEXT ,adminNameShow TEXT ,dwOfficeMode INTEGER ,dwGroupFlagExt3 INTEGER ,cmdUinFlagEx2 INTEGER ,udwCmdUinRingtoneID INTEGER ,memberListToShow TEXT ,troopPrivilegeFlag INTEGER ,isNewTroop INTEGER ,hasSetNewTroopHead INTEGER ,hasSetNewTroopName INTEGER ,maxInviteMemNum INTEGER ,lastMsgTime INTEGER ,allowMemberModifTroopName INTEGER ,allowMemberKick INTEGER ,allowMemberAtAll INTEGER ,oldTroopName TEXT ,hlGuildAppid INTEGER ,hlGuildSubType INTEGER ,hlGuildOrgid INTEGER ,hlGuildBinary INTEGER ,gameSwitchStatus INTEGER ,showGameSwitchStatus INTEGER ,lastShareLbsMsgUniseq INTEGER ,mTroopNeedPayNumber REAL ,troopCreditLevel INTEGER ,troopCreditLevelInfo INTEGER ,dwAppPrivilegeFlag INTEGER ,topicId TEXT ,associatePubAccount INTEGER ,mTroopFileVideoReqInterval INTEGER ,mTroopFileVideoIsWhite INTEGER ,mTribeStatus INTEGER ,mCanSearchByKeywords INTEGER ,mCanSearchByTroopUin INTEGER ,dwCmdUinJoinTime INTEGER ,dwLastInsertBAFTipTime INTEGER ,wInsertBAFTipCount INTEGER ,wClickBAFTipCount INTEGER ,dwLastBAFTipMsgUniSeq INTEGER ,dwLastBAFTipMsgUniSeq2 INTEGER ,dailyNewMemberUins TEXT ,exitTroopReason INTEGER ,eliminated INTEGER ,mIsFreezed INTEGER ,strLastAnnouncement TEXT ,nMsgLimitFreq INTEGER ,mAtOrReplyMeUins TEXT ,groupFlagExt4 INTEGER ,groupFreezeReason INTEGER ,troopHonorGrayFlag INTEGER ,isAllowHistoryMsgFlag INTEGER ,troopRepeatType INTEGER ,feeds_id TEXT ,myHonorList TEXT)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     akwc
 * JD-Core Version:    0.7.0.1
 */