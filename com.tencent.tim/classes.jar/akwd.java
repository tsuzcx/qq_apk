import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class akwd
  extends OGAbstractDao
{
  public akwd()
  {
    this.columnLen = 56;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (TroopMemberInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      paramEntity.memberuin = paramCursor.getString(paramCursor.getColumnIndex("memberuin"));
      paramEntity.friendnick = paramCursor.getString(paramCursor.getColumnIndex("friendnick"));
      paramEntity.pyAll_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_friendnick"));
      paramEntity.pyFirst_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_friendnick"));
      paramEntity.troopnick = paramCursor.getString(paramCursor.getColumnIndex("troopnick"));
      paramEntity.troopColorNick = paramCursor.getString(paramCursor.getColumnIndex("troopColorNick"));
      paramEntity.pyAll_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_troopnick"));
      paramEntity.pyFirst_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_troopnick"));
      paramEntity.autoremark = paramCursor.getString(paramCursor.getColumnIndex("autoremark"));
      paramEntity.pyAll_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyAll_autoremark"));
      paramEntity.pyFirst_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_autoremark"));
      paramEntity.troopremark = paramCursor.getString(paramCursor.getColumnIndex("troopremark"));
      paramEntity.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
      paramEntity.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
      paramEntity.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
      paramEntity.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramEntity.sex = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sex")));
      paramEntity.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
      paramEntity.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
      paramEntity.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
      paramEntity.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
      paramEntity.level = paramCursor.getInt(paramCursor.getColumnIndex("level"));
      paramEntity.realLevel = paramCursor.getInt(paramCursor.getColumnIndex("realLevel"));
      paramEntity.mGlamourLevel = paramCursor.getInt(paramCursor.getColumnIndex("mGlamourLevel"));
      paramEntity.hotChatGlamourLevel = paramCursor.getInt(paramCursor.getColumnIndex("hotChatGlamourLevel"));
      paramEntity.globalTroopLevel = paramCursor.getInt(paramCursor.getColumnIndex("globalTroopLevel"));
      paramEntity.join_time = paramCursor.getLong(paramCursor.getColumnIndex("join_time"));
      paramEntity.last_active_time = paramCursor.getLong(paramCursor.getColumnIndex("last_active_time"));
      paramEntity.active_point = paramCursor.getLong(paramCursor.getColumnIndex("active_point"));
      paramEntity.credit_level = paramCursor.getLong(paramCursor.getColumnIndex("credit_level"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isTroopFollowed")))
      {
        paramBoolean = true;
        paramEntity.isTroopFollowed = paramBoolean;
        paramEntity.distance = paramCursor.getInt(paramCursor.getColumnIndex("distance"));
        paramEntity.msgseq = paramCursor.getLong(paramCursor.getColumnIndex("msgseq"));
        paramEntity.gagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("gagTimeStamp"));
        paramEntity.distanceToSelf = paramCursor.getDouble(paramCursor.getColumnIndex("distanceToSelf"));
        paramEntity.distanceToSelfUpdateTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsShielded"))) {
          break label1053;
        }
      }
      label1053:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.mIsShielded = paramBoolean;
        paramEntity.mUniqueTitle = paramCursor.getString(paramCursor.getColumnIndex("mUniqueTitle"));
        paramEntity.mUniqueTitleExpire = paramCursor.getInt(paramCursor.getColumnIndex("mUniqueTitleExpire"));
        paramEntity.tribeLevel = paramCursor.getInt(paramCursor.getColumnIndex("tribeLevel"));
        paramEntity.tribePoint = paramCursor.getInt(paramCursor.getColumnIndex("tribePoint"));
        paramEntity.commonFrdCnt = paramCursor.getInt(paramCursor.getColumnIndex("commonFrdCnt"));
        paramEntity.hwIdentity = paramCursor.getInt(paramCursor.getColumnIndex("hwIdentity"));
        paramEntity.hwCourse = paramCursor.getString(paramCursor.getColumnIndex("hwCourse"));
        paramEntity.hwName = paramCursor.getString(paramCursor.getColumnIndex("hwName"));
        paramEntity.mVipType = paramCursor.getInt(paramCursor.getColumnIndex("mVipType"));
        paramEntity.mVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("mVipLevel"));
        paramEntity.mVipTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("mVipTemplateId"));
        paramEntity.mBigClubVipType = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubVipType"));
        paramEntity.mBigClubVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubVipLevel"));
        paramEntity.mBigClubTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubTemplateId"));
        paramEntity.recommendRemark = paramCursor.getString(paramCursor.getColumnIndex("recommendRemark"));
        paramEntity.isShowQZone = paramCursor.getInt(paramCursor.getColumnIndex("isShowQZone"));
        paramEntity.mIsHideBigClub = paramCursor.getInt(paramCursor.getColumnIndex("mIsHideBigClub"));
        paramEntity.honorList = paramCursor.getString(paramCursor.getColumnIndex("honorList"));
        return paramEntity;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("troopuin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopuin", String.class));
      i = paramCursor.getColumnIndex("memberuin");
      if (i != -1) {
        break label3043;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("memberuin", String.class));
      label1128:
      i = paramCursor.getColumnIndex("friendnick");
      if (i != -1) {
        break label3058;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("friendnick", String.class));
      label1163:
      i = paramCursor.getColumnIndex("pyAll_friendnick");
      if (i != -1) {
        break label3073;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pyAll_friendnick", String.class));
      label1198:
      i = paramCursor.getColumnIndex("pyFirst_friendnick");
      if (i != -1) {
        break label3088;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pyFirst_friendnick", String.class));
      label1233:
      i = paramCursor.getColumnIndex("troopnick");
      if (i != -1) {
        break label3103;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopnick", String.class));
      label1268:
      i = paramCursor.getColumnIndex("troopColorNick");
      if (i != -1) {
        break label3118;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopColorNick", String.class));
      label1303:
      i = paramCursor.getColumnIndex("pyAll_troopnick");
      if (i != -1) {
        break label3133;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pyAll_troopnick", String.class));
      label1338:
      i = paramCursor.getColumnIndex("pyFirst_troopnick");
      if (i != -1) {
        break label3148;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pyFirst_troopnick", String.class));
      label1373:
      i = paramCursor.getColumnIndex("autoremark");
      if (i != -1) {
        break label3163;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("autoremark", String.class));
      label1408:
      i = paramCursor.getColumnIndex("pyAll_autoremark");
      if (i != -1) {
        break label3178;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pyAll_autoremark", String.class));
      label1443:
      i = paramCursor.getColumnIndex("pyFirst_autoremark");
      if (i != -1) {
        break label3193;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pyFirst_autoremark", String.class));
      label1478:
      i = paramCursor.getColumnIndex("troopremark");
      if (i != -1) {
        break label3208;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopremark", String.class));
      label1513:
      i = paramCursor.getColumnIndex("alias");
      if (i != -1) {
        break label3223;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("alias", String.class));
      label1548:
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label3238;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("datetime", Long.TYPE));
      label1583:
      i = paramCursor.getColumnIndex("faceid");
      if (i != -1) {
        break label3253;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceid", Short.TYPE));
      label1618:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label3268;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("age", Byte.TYPE));
      label1653:
      i = paramCursor.getColumnIndex("sex");
      if (i != -1) {
        break label3284;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sex", Byte.TYPE));
      label1688:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label3300;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("status", Byte.TYPE));
      label1723:
      i = paramCursor.getColumnIndex("qqVipInfo");
      if (i != -1) {
        break label3316;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qqVipInfo", Integer.TYPE));
      label1758:
      i = paramCursor.getColumnIndex("superQqInfo");
      if (i != -1) {
        break label3331;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("superQqInfo", Integer.TYPE));
      label1793:
      i = paramCursor.getColumnIndex("superVipInfo");
      if (i != -1) {
        break label3346;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("superVipInfo", Integer.TYPE));
      label1828:
      i = paramCursor.getColumnIndex("level");
      if (i != -1) {
        break label3361;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("level", Integer.TYPE));
      label1863:
      i = paramCursor.getColumnIndex("realLevel");
      if (i != -1) {
        break label3376;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("realLevel", Integer.TYPE));
      label1898:
      i = paramCursor.getColumnIndex("mGlamourLevel");
      if (i != -1) {
        break label3391;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mGlamourLevel", Integer.TYPE));
      label1933:
      i = paramCursor.getColumnIndex("hotChatGlamourLevel");
      if (i != -1) {
        break label3406;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hotChatGlamourLevel", Integer.TYPE));
      label1968:
      i = paramCursor.getColumnIndex("globalTroopLevel");
      if (i != -1) {
        break label3421;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("globalTroopLevel", Integer.TYPE));
      label2003:
      i = paramCursor.getColumnIndex("join_time");
      if (i != -1) {
        break label3436;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("join_time", Long.TYPE));
      label2038:
      i = paramCursor.getColumnIndex("last_active_time");
      if (i != -1) {
        break label3451;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("last_active_time", Long.TYPE));
      label2073:
      i = paramCursor.getColumnIndex("active_point");
      if (i != -1) {
        break label3466;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("active_point", Long.TYPE));
      label2108:
      i = paramCursor.getColumnIndex("credit_level");
      if (i != -1) {
        break label3481;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("credit_level", Long.TYPE));
      label2143:
      i = paramCursor.getColumnIndex("isTroopFollowed");
      if (i != -1) {
        break label3496;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isTroopFollowed", Boolean.TYPE));
      i = paramCursor.getColumnIndex("distance");
      if (i != -1) {
        break label3523;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("distance", Integer.TYPE));
      label2213:
      i = paramCursor.getColumnIndex("msgseq");
      if (i != -1) {
        break label3538;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("msgseq", Long.TYPE));
      label2248:
      i = paramCursor.getColumnIndex("gagTimeStamp");
      if (i != -1) {
        break label3553;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("gagTimeStamp", Long.TYPE));
      label2283:
      i = paramCursor.getColumnIndex("distanceToSelf");
      if (i != -1) {
        break label3568;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("distanceToSelf", Double.TYPE));
      label2318:
      i = paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp");
      if (i != -1) {
        break label3583;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("distanceToSelfUpdateTimeStamp", Long.TYPE));
      label2353:
      i = paramCursor.getColumnIndex("mIsShielded");
      if (i != -1) {
        break label3598;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mIsShielded", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mUniqueTitle");
      if (i != -1) {
        break label3626;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mUniqueTitle", String.class));
      label2423:
      i = paramCursor.getColumnIndex("mUniqueTitleExpire");
      if (i != -1) {
        break label3641;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mUniqueTitleExpire", Integer.TYPE));
      label2458:
      i = paramCursor.getColumnIndex("tribeLevel");
      if (i != -1) {
        break label3656;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tribeLevel", Integer.TYPE));
      label2493:
      i = paramCursor.getColumnIndex("tribePoint");
      if (i != -1) {
        break label3671;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tribePoint", Integer.TYPE));
      label2528:
      i = paramCursor.getColumnIndex("commonFrdCnt");
      if (i != -1) {
        break label3686;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("commonFrdCnt", Integer.TYPE));
      label2563:
      i = paramCursor.getColumnIndex("hwIdentity");
      if (i != -1) {
        break label3701;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hwIdentity", Integer.TYPE));
      label2598:
      i = paramCursor.getColumnIndex("hwCourse");
      if (i != -1) {
        break label3716;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hwCourse", String.class));
      label2633:
      i = paramCursor.getColumnIndex("hwName");
      if (i != -1) {
        break label3731;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hwName", String.class));
      label2668:
      i = paramCursor.getColumnIndex("mVipType");
      if (i != -1) {
        break label3746;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mVipType", Integer.TYPE));
      label2703:
      i = paramCursor.getColumnIndex("mVipLevel");
      if (i != -1) {
        break label3761;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mVipLevel", Integer.TYPE));
      label2738:
      i = paramCursor.getColumnIndex("mVipTemplateId");
      if (i != -1) {
        break label3776;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mVipTemplateId", Integer.TYPE));
      label2773:
      i = paramCursor.getColumnIndex("mBigClubVipType");
      if (i != -1) {
        break label3791;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mBigClubVipType", Integer.TYPE));
      label2808:
      i = paramCursor.getColumnIndex("mBigClubVipLevel");
      if (i != -1) {
        break label3806;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mBigClubVipLevel", Integer.TYPE));
      label2843:
      i = paramCursor.getColumnIndex("mBigClubTemplateId");
      if (i != -1) {
        break label3821;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mBigClubTemplateId", Integer.TYPE));
      label2878:
      i = paramCursor.getColumnIndex("recommendRemark");
      if (i != -1) {
        break label3836;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("recommendRemark", String.class));
      label2915:
      i = paramCursor.getColumnIndex("isShowQZone");
      if (i != -1) {
        break label3851;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isShowQZone", Integer.TYPE));
      label2952:
      i = paramCursor.getColumnIndex("mIsHideBigClub");
      if (i != -1) {
        break label3866;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mIsHideBigClub", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("honorList");
      if (i != -1) {
        break label3881;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("honorList", String.class));
      return paramEntity;
      paramEntity.troopuin = paramCursor.getString(i);
      break;
      label3043:
      paramEntity.memberuin = paramCursor.getString(i);
      break label1128;
      label3058:
      paramEntity.friendnick = paramCursor.getString(i);
      break label1163;
      label3073:
      paramEntity.pyAll_friendnick = paramCursor.getString(i);
      break label1198;
      label3088:
      paramEntity.pyFirst_friendnick = paramCursor.getString(i);
      break label1233;
      label3103:
      paramEntity.troopnick = paramCursor.getString(i);
      break label1268;
      label3118:
      paramEntity.troopColorNick = paramCursor.getString(i);
      break label1303;
      label3133:
      paramEntity.pyAll_troopnick = paramCursor.getString(i);
      break label1338;
      label3148:
      paramEntity.pyFirst_troopnick = paramCursor.getString(i);
      break label1373;
      label3163:
      paramEntity.autoremark = paramCursor.getString(i);
      break label1408;
      label3178:
      paramEntity.pyAll_autoremark = paramCursor.getString(i);
      break label1443;
      label3193:
      paramEntity.pyFirst_autoremark = paramCursor.getString(i);
      break label1478;
      label3208:
      paramEntity.troopremark = paramCursor.getString(i);
      break label1513;
      label3223:
      paramEntity.alias = paramCursor.getString(i);
      break label1548;
      label3238:
      paramEntity.datetime = paramCursor.getLong(i);
      break label1583;
      label3253:
      paramEntity.faceid = paramCursor.getShort(i);
      break label1618;
      label3268:
      paramEntity.age = ((byte)paramCursor.getShort(i));
      break label1653;
      label3284:
      paramEntity.sex = ((byte)paramCursor.getShort(i));
      break label1688;
      label3300:
      paramEntity.status = ((byte)paramCursor.getShort(i));
      break label1723;
      label3316:
      paramEntity.qqVipInfo = paramCursor.getInt(i);
      break label1758;
      label3331:
      paramEntity.superQqInfo = paramCursor.getInt(i);
      break label1793;
      label3346:
      paramEntity.superVipInfo = paramCursor.getInt(i);
      break label1828;
      label3361:
      paramEntity.level = paramCursor.getInt(i);
      break label1863;
      label3376:
      paramEntity.realLevel = paramCursor.getInt(i);
      break label1898;
      label3391:
      paramEntity.mGlamourLevel = paramCursor.getInt(i);
      break label1933;
      label3406:
      paramEntity.hotChatGlamourLevel = paramCursor.getInt(i);
      break label1968;
      label3421:
      paramEntity.globalTroopLevel = paramCursor.getInt(i);
      break label2003;
      label3436:
      paramEntity.join_time = paramCursor.getLong(i);
      break label2038;
      label3451:
      paramEntity.last_active_time = paramCursor.getLong(i);
      break label2073;
      label3466:
      paramEntity.active_point = paramCursor.getLong(i);
      break label2108;
      label3481:
      paramEntity.credit_level = paramCursor.getLong(i);
      break label2143;
      label3496:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isTroopFollowed = paramBoolean;
        break;
      }
      label3523:
      paramEntity.distance = paramCursor.getInt(i);
      break label2213;
      label3538:
      paramEntity.msgseq = paramCursor.getLong(i);
      break label2248;
      label3553:
      paramEntity.gagTimeStamp = paramCursor.getLong(i);
      break label2283;
      label3568:
      paramEntity.distanceToSelf = paramCursor.getDouble(i);
      break label2318;
      label3583:
      paramEntity.distanceToSelfUpdateTimeStamp = paramCursor.getLong(i);
      break label2353;
      label3598:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.mIsShielded = paramBoolean;
        break;
      }
      label3626:
      paramEntity.mUniqueTitle = paramCursor.getString(i);
      break label2423;
      label3641:
      paramEntity.mUniqueTitleExpire = paramCursor.getInt(i);
      break label2458;
      label3656:
      paramEntity.tribeLevel = paramCursor.getInt(i);
      break label2493;
      label3671:
      paramEntity.tribePoint = paramCursor.getInt(i);
      break label2528;
      label3686:
      paramEntity.commonFrdCnt = paramCursor.getInt(i);
      break label2563;
      label3701:
      paramEntity.hwIdentity = paramCursor.getInt(i);
      break label2598;
      label3716:
      paramEntity.hwCourse = paramCursor.getString(i);
      break label2633;
      label3731:
      paramEntity.hwName = paramCursor.getString(i);
      break label2668;
      label3746:
      paramEntity.mVipType = paramCursor.getInt(i);
      break label2703;
      label3761:
      paramEntity.mVipLevel = paramCursor.getInt(i);
      break label2738;
      label3776:
      paramEntity.mVipTemplateId = paramCursor.getInt(i);
      break label2773;
      label3791:
      paramEntity.mBigClubVipType = paramCursor.getInt(i);
      break label2808;
      label3806:
      paramEntity.mBigClubVipLevel = paramCursor.getInt(i);
      break label2843;
      label3821:
      paramEntity.mBigClubTemplateId = paramCursor.getInt(i);
      break label2878;
      label3836:
      paramEntity.recommendRemark = paramCursor.getString(i);
      break label2915;
      label3851:
      paramEntity.isShowQZone = paramCursor.getInt(i);
      break label2952;
      label3866:
      paramEntity.mIsHideBigClub = paramCursor.getInt(i);
    }
    label3881:
    paramEntity.honorList = paramCursor.getString(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (TroopMemberInfo)paramEntity;
    paramContentValues.put("troopuin", paramEntity.troopuin);
    paramContentValues.put("memberuin", paramEntity.memberuin);
    paramContentValues.put("friendnick", paramEntity.friendnick);
    paramContentValues.put("pyAll_friendnick", paramEntity.pyAll_friendnick);
    paramContentValues.put("pyFirst_friendnick", paramEntity.pyFirst_friendnick);
    paramContentValues.put("troopnick", paramEntity.troopnick);
    paramContentValues.put("troopColorNick", paramEntity.troopColorNick);
    paramContentValues.put("pyAll_troopnick", paramEntity.pyAll_troopnick);
    paramContentValues.put("pyFirst_troopnick", paramEntity.pyFirst_troopnick);
    paramContentValues.put("autoremark", paramEntity.autoremark);
    paramContentValues.put("pyAll_autoremark", paramEntity.pyAll_autoremark);
    paramContentValues.put("pyFirst_autoremark", paramEntity.pyFirst_autoremark);
    paramContentValues.put("troopremark", paramEntity.troopremark);
    paramContentValues.put("alias", paramEntity.alias);
    paramContentValues.put("datetime", Long.valueOf(paramEntity.datetime));
    paramContentValues.put("faceid", Short.valueOf(paramEntity.faceid));
    paramContentValues.put("age", Byte.valueOf(paramEntity.age));
    paramContentValues.put("sex", Byte.valueOf(paramEntity.sex));
    paramContentValues.put("status", Byte.valueOf(paramEntity.status));
    paramContentValues.put("qqVipInfo", Integer.valueOf(paramEntity.qqVipInfo));
    paramContentValues.put("superQqInfo", Integer.valueOf(paramEntity.superQqInfo));
    paramContentValues.put("superVipInfo", Integer.valueOf(paramEntity.superVipInfo));
    paramContentValues.put("level", Integer.valueOf(paramEntity.level));
    paramContentValues.put("realLevel", Integer.valueOf(paramEntity.realLevel));
    paramContentValues.put("mGlamourLevel", Integer.valueOf(paramEntity.mGlamourLevel));
    paramContentValues.put("hotChatGlamourLevel", Integer.valueOf(paramEntity.hotChatGlamourLevel));
    paramContentValues.put("globalTroopLevel", Integer.valueOf(paramEntity.globalTroopLevel));
    paramContentValues.put("join_time", Long.valueOf(paramEntity.join_time));
    paramContentValues.put("last_active_time", Long.valueOf(paramEntity.last_active_time));
    paramContentValues.put("active_point", Long.valueOf(paramEntity.active_point));
    paramContentValues.put("credit_level", Long.valueOf(paramEntity.credit_level));
    paramContentValues.put("isTroopFollowed", Boolean.valueOf(paramEntity.isTroopFollowed));
    paramContentValues.put("distance", Integer.valueOf(paramEntity.distance));
    paramContentValues.put("msgseq", Long.valueOf(paramEntity.msgseq));
    paramContentValues.put("gagTimeStamp", Long.valueOf(paramEntity.gagTimeStamp));
    paramContentValues.put("distanceToSelf", Double.valueOf(paramEntity.distanceToSelf));
    paramContentValues.put("distanceToSelfUpdateTimeStamp", Long.valueOf(paramEntity.distanceToSelfUpdateTimeStamp));
    paramContentValues.put("mIsShielded", Boolean.valueOf(paramEntity.mIsShielded));
    paramContentValues.put("mUniqueTitle", paramEntity.mUniqueTitle);
    paramContentValues.put("mUniqueTitleExpire", Integer.valueOf(paramEntity.mUniqueTitleExpire));
    paramContentValues.put("tribeLevel", Integer.valueOf(paramEntity.tribeLevel));
    paramContentValues.put("tribePoint", Integer.valueOf(paramEntity.tribePoint));
    paramContentValues.put("commonFrdCnt", Integer.valueOf(paramEntity.commonFrdCnt));
    paramContentValues.put("hwIdentity", Integer.valueOf(paramEntity.hwIdentity));
    paramContentValues.put("hwCourse", paramEntity.hwCourse);
    paramContentValues.put("hwName", paramEntity.hwName);
    paramContentValues.put("mVipType", Integer.valueOf(paramEntity.mVipType));
    paramContentValues.put("mVipLevel", Integer.valueOf(paramEntity.mVipLevel));
    paramContentValues.put("mVipTemplateId", Integer.valueOf(paramEntity.mVipTemplateId));
    paramContentValues.put("mBigClubVipType", Integer.valueOf(paramEntity.mBigClubVipType));
    paramContentValues.put("mBigClubVipLevel", Integer.valueOf(paramEntity.mBigClubVipLevel));
    paramContentValues.put("mBigClubTemplateId", Integer.valueOf(paramEntity.mBigClubTemplateId));
    paramContentValues.put("recommendRemark", paramEntity.recommendRemark);
    paramContentValues.put("isShowQZone", Integer.valueOf(paramEntity.isShowQZone));
    paramContentValues.put("mIsHideBigClub", Integer.valueOf(paramEntity.mIsHideBigClub));
    paramContentValues.put("honorList", paramEntity.honorList);
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopuin TEXT ,memberuin TEXT ,friendnick TEXT ,pyAll_friendnick TEXT ,pyFirst_friendnick TEXT ,troopnick TEXT ,troopColorNick TEXT ,pyAll_troopnick TEXT ,pyFirst_troopnick TEXT ,autoremark TEXT ,pyAll_autoremark TEXT ,pyFirst_autoremark TEXT ,troopremark TEXT ,alias TEXT ,datetime INTEGER ,faceid INTEGER ,age INTEGER ,sex INTEGER ,status INTEGER ,qqVipInfo INTEGER ,superQqInfo INTEGER ,superVipInfo INTEGER ,level INTEGER ,realLevel INTEGER ,mGlamourLevel INTEGER ,hotChatGlamourLevel INTEGER ,globalTroopLevel INTEGER ,join_time INTEGER ,last_active_time INTEGER ,active_point INTEGER ,credit_level INTEGER ,isTroopFollowed INTEGER ,distance INTEGER ,msgseq INTEGER ,gagTimeStamp INTEGER ,distanceToSelf REAL ,distanceToSelfUpdateTimeStamp INTEGER ,mIsShielded INTEGER ,mUniqueTitle TEXT ,mUniqueTitleExpire INTEGER ,tribeLevel INTEGER ,tribePoint INTEGER ,commonFrdCnt INTEGER ,hwIdentity INTEGER ,hwCourse TEXT ,hwName TEXT ,mVipType INTEGER ,mVipLevel INTEGER ,mVipTemplateId INTEGER ,mBigClubVipType INTEGER ,mBigClubVipLevel INTEGER ,mBigClubTemplateId INTEGER ,recommendRemark TEXT ,isShowQZone INTEGER ,mIsHideBigClub INTEGER ,honorList TEXT,UNIQUE(troopuin,memberuin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     akwd
 * JD-Core Version:    0.7.0.1
 */