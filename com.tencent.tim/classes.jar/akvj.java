import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class akvj
  extends OGAbstractDao
{
  public akvj()
  {
    this.columnLen = 65;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (Friends)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
      paramEntity.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
      paramEntity.sqqtype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqtype")));
      paramEntity.cSpecialFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSpecialFlag")));
      paramEntity.groupid = paramCursor.getInt(paramCursor.getColumnIndex("groupid"));
      paramEntity.memberLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("memberLevel")));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isMqqOnLine")))
      {
        paramBoolean = true;
        paramEntity.isMqqOnLine = paramBoolean;
        paramEntity.sqqOnLineState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqOnLineState")));
        paramEntity.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
        paramEntity.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
        paramEntity.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
        paramEntity.gathtertype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gathtertype")));
        paramEntity.smartRemark = paramCursor.getString(paramCursor.getColumnIndex("smartRemark"));
        paramEntity.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
        paramEntity.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
        paramEntity.recommReason = paramCursor.getString(paramCursor.getColumnIndex("recommReason"));
        paramEntity.signature = paramCursor.getString(paramCursor.getColumnIndex("signature"));
        paramEntity.isIphoneOnline = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isIphoneOnline")));
        paramEntity.isRemark = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isRemark")));
        paramEntity.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
        paramEntity.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
        paramEntity.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
        paramEntity.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
        paramEntity.hollywoodVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("hollywoodVipInfo"));
        paramEntity.lastLoginType = paramCursor.getLong(paramCursor.getColumnIndex("lastLoginType"));
        paramEntity.showLoginClient = paramCursor.getLong(paramCursor.getColumnIndex("showLoginClient"));
        paramEntity.medalsInfo = paramCursor.getString(paramCursor.getColumnIndex("medalsInfo"));
        paramEntity.nameplateCfgInfo = paramCursor.getString(paramCursor.getColumnIndex("nameplateCfgInfo"));
        paramEntity.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
        paramEntity.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
        paramEntity.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramEntity.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramEntity.cNetwork = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cNetwork")));
        paramEntity.eNetwork = paramCursor.getInt(paramCursor.getColumnIndex("eNetwork"));
        paramEntity.namePlateOfKingGameId = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingGameId"));
        paramEntity.namePlateOfKingLoginTime = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingLoginTime"));
        paramEntity.namePlateOfKingDan = paramCursor.getInt(paramCursor.getColumnIndex("namePlateOfKingDan"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch"))) {
          break label1232;
        }
      }
      label1232:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.namePlateOfKingDanDisplatSwitch = paramBoolean;
        paramEntity.strMasterUin = paramCursor.getString(paramCursor.getColumnIndex("strMasterUin"));
        paramEntity.multiFlags = paramCursor.getInt(paramCursor.getColumnIndex("multiFlags"));
        paramEntity.friendType = paramCursor.getInt(paramCursor.getColumnIndex("friendType"));
        paramEntity.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
        paramEntity.bigClubInfo = paramCursor.getInt(paramCursor.getColumnIndex("bigClubInfo"));
        paramEntity.superVipTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("superVipTemplateId"));
        paramEntity.bigClubTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("bigClubTemplateId"));
        paramEntity.nameplateVipType = paramCursor.getInt(paramCursor.getColumnIndex("nameplateVipType"));
        paramEntity.grayNameplateFlag = paramCursor.getInt(paramCursor.getColumnIndex("grayNameplateFlag"));
        paramEntity.cNewLoverDiamondFlag = paramCursor.getInt(paramCursor.getColumnIndex("cNewLoverDiamondFlag"));
        paramEntity.relationIconFlag = paramCursor.getInt(paramCursor.getColumnIndex("relationIconFlag"));
        paramEntity.uExtOnlineStatus = paramCursor.getLong(paramCursor.getColumnIndex("uExtOnlineStatus"));
        paramEntity.iBatteryStatus = paramCursor.getInt(paramCursor.getColumnIndex("iBatteryStatus"));
        paramEntity.customModel = paramCursor.getString(paramCursor.getColumnIndex("customModel"));
        paramEntity.songId = paramCursor.getString(paramCursor.getColumnIndex("songId"));
        paramEntity.songName = paramCursor.getString(paramCursor.getColumnIndex("songName"));
        paramEntity.singerName = paramCursor.getString(paramCursor.getColumnIndex("singerName"));
        paramEntity.songEndTime = paramCursor.getLong(paramCursor.getColumnIndex("songEndTime"));
        paramEntity.songSourceType = paramCursor.getInt(paramCursor.getColumnIndex("songSourceType"));
        paramEntity.poiName = paramCursor.getString(paramCursor.getColumnIndex("poiName"));
        paramEntity.poiUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("poiUpdateTime"));
        paramEntity.latitude = paramCursor.getDouble(paramCursor.getColumnIndex("latitude"));
        paramEntity.longitude = paramCursor.getDouble(paramCursor.getColumnIndex("longitude"));
        paramEntity.poiFlag = paramCursor.getInt(paramCursor.getColumnIndex("poiFlag"));
        return paramEntity;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label3555;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("remark", String.class));
      label1307:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label3570;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("name", String.class));
      label1342:
      i = paramCursor.getColumnIndex("faceid");
      if (i != -1) {
        break label3585;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceid", Short.TYPE));
      label1377:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label3600;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("status", Byte.TYPE));
      label1412:
      i = paramCursor.getColumnIndex("sqqtype");
      if (i != -1) {
        break label3616;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sqqtype", Byte.TYPE));
      label1447:
      i = paramCursor.getColumnIndex("cSpecialFlag");
      if (i != -1) {
        break label3632;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cSpecialFlag", Byte.TYPE));
      label1482:
      i = paramCursor.getColumnIndex("groupid");
      if (i != -1) {
        break label3648;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("groupid", Integer.TYPE));
      label1517:
      i = paramCursor.getColumnIndex("memberLevel");
      if (i != -1) {
        break label3663;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("memberLevel", Byte.TYPE));
      label1552:
      i = paramCursor.getColumnIndex("isMqqOnLine");
      if (i != -1) {
        break label3679;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isMqqOnLine", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sqqOnLineState");
      if (i != -1) {
        break label3706;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sqqOnLineState", Byte.TYPE));
      label1622:
      i = paramCursor.getColumnIndex("detalStatusFlag");
      if (i != -1) {
        break label3722;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("detalStatusFlag", Byte.TYPE));
      label1657:
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label3738;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("datetime", Long.TYPE));
      label1692:
      i = paramCursor.getColumnIndex("alias");
      if (i != -1) {
        break label3753;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("alias", String.class));
      label1727:
      i = paramCursor.getColumnIndex("gathtertype");
      if (i != -1) {
        break label3768;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("gathtertype", Byte.TYPE));
      label1762:
      i = paramCursor.getColumnIndex("smartRemark");
      if (i != -1) {
        break label3784;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("smartRemark", String.class));
      label1797:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label3799;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("age", Integer.TYPE));
      label1832:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label3814;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("gender", Byte.TYPE));
      label1867:
      i = paramCursor.getColumnIndex("recommReason");
      if (i != -1) {
        break label3830;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("recommReason", String.class));
      label1902:
      i = paramCursor.getColumnIndex("signature");
      if (i != -1) {
        break label3845;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("signature", String.class));
      label1937:
      i = paramCursor.getColumnIndex("isIphoneOnline");
      if (i != -1) {
        break label3860;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isIphoneOnline", Byte.TYPE));
      label1972:
      i = paramCursor.getColumnIndex("isRemark");
      if (i != -1) {
        break label3876;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isRemark", Byte.TYPE));
      label2007:
      i = paramCursor.getColumnIndex("iTermType");
      if (i != -1) {
        break label3892;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iTermType", Integer.TYPE));
      label2042:
      i = paramCursor.getColumnIndex("qqVipInfo");
      if (i != -1) {
        break label3907;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qqVipInfo", Integer.TYPE));
      label2077:
      i = paramCursor.getColumnIndex("superQqInfo");
      if (i != -1) {
        break label3922;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("superQqInfo", Integer.TYPE));
      label2112:
      i = paramCursor.getColumnIndex("superVipInfo");
      if (i != -1) {
        break label3937;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("superVipInfo", Integer.TYPE));
      label2147:
      i = paramCursor.getColumnIndex("hollywoodVipInfo");
      if (i != -1) {
        break label3952;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hollywoodVipInfo", Integer.TYPE));
      label2182:
      i = paramCursor.getColumnIndex("lastLoginType");
      if (i != -1) {
        break label3967;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastLoginType", Long.TYPE));
      label2217:
      i = paramCursor.getColumnIndex("showLoginClient");
      if (i != -1) {
        break label3982;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showLoginClient", Long.TYPE));
      label2252:
      i = paramCursor.getColumnIndex("medalsInfo");
      if (i != -1) {
        break label3997;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("medalsInfo", String.class));
      label2287:
      i = paramCursor.getColumnIndex("nameplateCfgInfo");
      if (i != -1) {
        break label4012;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nameplateCfgInfo", String.class));
      label2322:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label4027;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("richTime", Long.TYPE));
      label2357:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label4042;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("richBuffer", [B.class));
      label2392:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label4057;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mComparePartInt", Integer.TYPE));
      label2427:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label4072;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mCompareSpell", String.class));
      label2462:
      i = paramCursor.getColumnIndex("cNetwork");
      if (i != -1) {
        break label4087;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cNetwork", Byte.TYPE));
      label2497:
      i = paramCursor.getColumnIndex("eNetwork");
      if (i != -1) {
        break label4103;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("eNetwork", Integer.TYPE));
      label2532:
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label4118;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      label2567:
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label4133;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      label2602:
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label4148;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      label2637:
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label4163;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("strMasterUin");
      if (i != -1) {
        break label4191;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strMasterUin", String.class));
      label2707:
      i = paramCursor.getColumnIndex("multiFlags");
      if (i != -1) {
        break label4206;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("multiFlags", Integer.TYPE));
      label2742:
      i = paramCursor.getColumnIndex("friendType");
      if (i != -1) {
        break label4221;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("friendType", Integer.TYPE));
      label2777:
      i = paramCursor.getColumnIndex("abilityBits");
      if (i != -1) {
        break label4236;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("abilityBits", Long.TYPE));
      label2812:
      i = paramCursor.getColumnIndex("bigClubInfo");
      if (i != -1) {
        break label4251;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bigClubInfo", Integer.TYPE));
      label2847:
      i = paramCursor.getColumnIndex("superVipTemplateId");
      if (i != -1) {
        break label4266;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("superVipTemplateId", Integer.TYPE));
      label2882:
      i = paramCursor.getColumnIndex("bigClubTemplateId");
      if (i != -1) {
        break label4281;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bigClubTemplateId", Integer.TYPE));
      label2917:
      i = paramCursor.getColumnIndex("nameplateVipType");
      if (i != -1) {
        break label4296;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nameplateVipType", Integer.TYPE));
      label2952:
      i = paramCursor.getColumnIndex("grayNameplateFlag");
      if (i != -1) {
        break label4311;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("grayNameplateFlag", Integer.TYPE));
      label2987:
      i = paramCursor.getColumnIndex("cNewLoverDiamondFlag");
      if (i != -1) {
        break label4326;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cNewLoverDiamondFlag", Integer.TYPE));
      label3022:
      i = paramCursor.getColumnIndex("relationIconFlag");
      if (i != -1) {
        break label4341;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("relationIconFlag", Integer.TYPE));
      label3057:
      i = paramCursor.getColumnIndex("uExtOnlineStatus");
      if (i != -1) {
        break label4356;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uExtOnlineStatus", Long.TYPE));
      label3094:
      i = paramCursor.getColumnIndex("iBatteryStatus");
      if (i != -1) {
        break label4371;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iBatteryStatus", Integer.TYPE));
      label3131:
      i = paramCursor.getColumnIndex("customModel");
      if (i != -1) {
        break label4386;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("customModel", String.class));
      label3168:
      i = paramCursor.getColumnIndex("songId");
      if (i != -1) {
        break label4401;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("songId", String.class));
      label3205:
      i = paramCursor.getColumnIndex("songName");
      if (i != -1) {
        break label4416;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("songName", String.class));
      label3242:
      i = paramCursor.getColumnIndex("singerName");
      if (i != -1) {
        break label4431;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("singerName", String.class));
      label3279:
      i = paramCursor.getColumnIndex("songEndTime");
      if (i != -1) {
        break label4446;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("songEndTime", Long.TYPE));
      label3316:
      i = paramCursor.getColumnIndex("songSourceType");
      if (i != -1) {
        break label4461;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("songSourceType", Integer.TYPE));
      label3353:
      i = paramCursor.getColumnIndex("poiName");
      if (i != -1) {
        break label4476;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("poiName", String.class));
      label3390:
      i = paramCursor.getColumnIndex("poiUpdateTime");
      if (i != -1) {
        break label4491;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("poiUpdateTime", Long.TYPE));
      label3427:
      i = paramCursor.getColumnIndex("latitude");
      if (i != -1) {
        break label4506;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("latitude", Double.TYPE));
      label3464:
      i = paramCursor.getColumnIndex("longitude");
      if (i != -1) {
        break label4521;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("longitude", Double.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("poiFlag");
      if (i != -1) {
        break label4536;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("poiFlag", Integer.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label3555:
      paramEntity.remark = paramCursor.getString(i);
      break label1307;
      label3570:
      paramEntity.name = paramCursor.getString(i);
      break label1342;
      label3585:
      paramEntity.faceid = paramCursor.getShort(i);
      break label1377;
      label3600:
      paramEntity.status = ((byte)paramCursor.getShort(i));
      break label1412;
      label3616:
      paramEntity.sqqtype = ((byte)paramCursor.getShort(i));
      break label1447;
      label3632:
      paramEntity.cSpecialFlag = ((byte)paramCursor.getShort(i));
      break label1482;
      label3648:
      paramEntity.groupid = paramCursor.getInt(i);
      break label1517;
      label3663:
      paramEntity.memberLevel = ((byte)paramCursor.getShort(i));
      break label1552;
      label3679:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isMqqOnLine = paramBoolean;
        break;
      }
      label3706:
      paramEntity.sqqOnLineState = ((byte)paramCursor.getShort(i));
      break label1622;
      label3722:
      paramEntity.detalStatusFlag = ((byte)paramCursor.getShort(i));
      break label1657;
      label3738:
      paramEntity.datetime = paramCursor.getLong(i);
      break label1692;
      label3753:
      paramEntity.alias = paramCursor.getString(i);
      break label1727;
      label3768:
      paramEntity.gathtertype = ((byte)paramCursor.getShort(i));
      break label1762;
      label3784:
      paramEntity.smartRemark = paramCursor.getString(i);
      break label1797;
      label3799:
      paramEntity.age = paramCursor.getInt(i);
      break label1832;
      label3814:
      paramEntity.gender = ((byte)paramCursor.getShort(i));
      break label1867;
      label3830:
      paramEntity.recommReason = paramCursor.getString(i);
      break label1902;
      label3845:
      paramEntity.signature = paramCursor.getString(i);
      break label1937;
      label3860:
      paramEntity.isIphoneOnline = ((byte)paramCursor.getShort(i));
      break label1972;
      label3876:
      paramEntity.isRemark = ((byte)paramCursor.getShort(i));
      break label2007;
      label3892:
      paramEntity.iTermType = paramCursor.getInt(i);
      break label2042;
      label3907:
      paramEntity.qqVipInfo = paramCursor.getInt(i);
      break label2077;
      label3922:
      paramEntity.superQqInfo = paramCursor.getInt(i);
      break label2112;
      label3937:
      paramEntity.superVipInfo = paramCursor.getInt(i);
      break label2147;
      label3952:
      paramEntity.hollywoodVipInfo = paramCursor.getInt(i);
      break label2182;
      label3967:
      paramEntity.lastLoginType = paramCursor.getLong(i);
      break label2217;
      label3982:
      paramEntity.showLoginClient = paramCursor.getLong(i);
      break label2252;
      label3997:
      paramEntity.medalsInfo = paramCursor.getString(i);
      break label2287;
      label4012:
      paramEntity.nameplateCfgInfo = paramCursor.getString(i);
      break label2322;
      label4027:
      paramEntity.richTime = paramCursor.getLong(i);
      break label2357;
      label4042:
      paramEntity.richBuffer = paramCursor.getBlob(i);
      break label2392;
      label4057:
      paramEntity.mComparePartInt = paramCursor.getInt(i);
      break label2427;
      label4072:
      paramEntity.mCompareSpell = paramCursor.getString(i);
      break label2462;
      label4087:
      paramEntity.cNetwork = ((byte)paramCursor.getShort(i));
      break label2497;
      label4103:
      paramEntity.eNetwork = paramCursor.getInt(i);
      break label2532;
      label4118:
      paramEntity.namePlateOfKingGameId = paramCursor.getLong(i);
      break label2567;
      label4133:
      paramEntity.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label2602;
      label4148:
      paramEntity.namePlateOfKingDan = paramCursor.getInt(i);
      break label2637;
      label4163:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label4191:
      paramEntity.strMasterUin = paramCursor.getString(i);
      break label2707;
      label4206:
      paramEntity.multiFlags = paramCursor.getInt(i);
      break label2742;
      label4221:
      paramEntity.friendType = paramCursor.getInt(i);
      break label2777;
      label4236:
      paramEntity.abilityBits = paramCursor.getLong(i);
      break label2812;
      label4251:
      paramEntity.bigClubInfo = paramCursor.getInt(i);
      break label2847;
      label4266:
      paramEntity.superVipTemplateId = paramCursor.getInt(i);
      break label2882;
      label4281:
      paramEntity.bigClubTemplateId = paramCursor.getInt(i);
      break label2917;
      label4296:
      paramEntity.nameplateVipType = paramCursor.getInt(i);
      break label2952;
      label4311:
      paramEntity.grayNameplateFlag = paramCursor.getInt(i);
      break label2987;
      label4326:
      paramEntity.cNewLoverDiamondFlag = paramCursor.getInt(i);
      break label3022;
      label4341:
      paramEntity.relationIconFlag = paramCursor.getInt(i);
      break label3057;
      label4356:
      paramEntity.uExtOnlineStatus = paramCursor.getLong(i);
      break label3094;
      label4371:
      paramEntity.iBatteryStatus = paramCursor.getInt(i);
      break label3131;
      label4386:
      paramEntity.customModel = paramCursor.getString(i);
      break label3168;
      label4401:
      paramEntity.songId = paramCursor.getString(i);
      break label3205;
      label4416:
      paramEntity.songName = paramCursor.getString(i);
      break label3242;
      label4431:
      paramEntity.singerName = paramCursor.getString(i);
      break label3279;
      label4446:
      paramEntity.songEndTime = paramCursor.getLong(i);
      break label3316;
      label4461:
      paramEntity.songSourceType = paramCursor.getInt(i);
      break label3353;
      label4476:
      paramEntity.poiName = paramCursor.getString(i);
      break label3390;
      label4491:
      paramEntity.poiUpdateTime = paramCursor.getLong(i);
      break label3427;
      label4506:
      paramEntity.latitude = paramCursor.getDouble(i);
      break label3464;
      label4521:
      paramEntity.longitude = paramCursor.getDouble(i);
    }
    label4536:
    paramEntity.poiFlag = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (Friends)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("remark", paramEntity.remark);
    paramContentValues.put("name", paramEntity.name);
    paramContentValues.put("faceid", Short.valueOf(paramEntity.faceid));
    paramContentValues.put("status", Byte.valueOf(paramEntity.status));
    paramContentValues.put("sqqtype", Byte.valueOf(paramEntity.sqqtype));
    paramContentValues.put("cSpecialFlag", Byte.valueOf(paramEntity.cSpecialFlag));
    paramContentValues.put("groupid", Integer.valueOf(paramEntity.groupid));
    paramContentValues.put("memberLevel", Byte.valueOf(paramEntity.memberLevel));
    paramContentValues.put("isMqqOnLine", Boolean.valueOf(paramEntity.isMqqOnLine));
    paramContentValues.put("sqqOnLineState", Byte.valueOf(paramEntity.sqqOnLineState));
    paramContentValues.put("detalStatusFlag", Byte.valueOf(paramEntity.detalStatusFlag));
    paramContentValues.put("datetime", Long.valueOf(paramEntity.datetime));
    paramContentValues.put("alias", paramEntity.alias);
    paramContentValues.put("gathtertype", Byte.valueOf(paramEntity.gathtertype));
    paramContentValues.put("smartRemark", paramEntity.smartRemark);
    paramContentValues.put("age", Integer.valueOf(paramEntity.age));
    paramContentValues.put("gender", Byte.valueOf(paramEntity.gender));
    paramContentValues.put("recommReason", paramEntity.recommReason);
    paramContentValues.put("signature", paramEntity.signature);
    paramContentValues.put("isIphoneOnline", Byte.valueOf(paramEntity.isIphoneOnline));
    paramContentValues.put("isRemark", Byte.valueOf(paramEntity.isRemark));
    paramContentValues.put("iTermType", Integer.valueOf(paramEntity.iTermType));
    paramContentValues.put("qqVipInfo", Integer.valueOf(paramEntity.qqVipInfo));
    paramContentValues.put("superQqInfo", Integer.valueOf(paramEntity.superQqInfo));
    paramContentValues.put("superVipInfo", Integer.valueOf(paramEntity.superVipInfo));
    paramContentValues.put("hollywoodVipInfo", Integer.valueOf(paramEntity.hollywoodVipInfo));
    paramContentValues.put("lastLoginType", Long.valueOf(paramEntity.lastLoginType));
    paramContentValues.put("showLoginClient", Long.valueOf(paramEntity.showLoginClient));
    paramContentValues.put("medalsInfo", paramEntity.medalsInfo);
    paramContentValues.put("nameplateCfgInfo", paramEntity.nameplateCfgInfo);
    paramContentValues.put("richTime", Long.valueOf(paramEntity.richTime));
    paramContentValues.put("richBuffer", paramEntity.richBuffer);
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramEntity.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramEntity.mCompareSpell);
    paramContentValues.put("cNetwork", Byte.valueOf(paramEntity.cNetwork));
    paramContentValues.put("eNetwork", Integer.valueOf(paramEntity.eNetwork));
    paramContentValues.put("namePlateOfKingGameId", Long.valueOf(paramEntity.namePlateOfKingGameId));
    paramContentValues.put("namePlateOfKingLoginTime", Long.valueOf(paramEntity.namePlateOfKingLoginTime));
    paramContentValues.put("namePlateOfKingDan", Integer.valueOf(paramEntity.namePlateOfKingDan));
    paramContentValues.put("namePlateOfKingDanDisplatSwitch", Boolean.valueOf(paramEntity.namePlateOfKingDanDisplatSwitch));
    paramContentValues.put("strMasterUin", paramEntity.strMasterUin);
    paramContentValues.put("multiFlags", Integer.valueOf(paramEntity.multiFlags));
    paramContentValues.put("friendType", Integer.valueOf(paramEntity.friendType));
    paramContentValues.put("abilityBits", Long.valueOf(paramEntity.abilityBits));
    paramContentValues.put("bigClubInfo", Integer.valueOf(paramEntity.bigClubInfo));
    paramContentValues.put("superVipTemplateId", Integer.valueOf(paramEntity.superVipTemplateId));
    paramContentValues.put("bigClubTemplateId", Integer.valueOf(paramEntity.bigClubTemplateId));
    paramContentValues.put("nameplateVipType", Integer.valueOf(paramEntity.nameplateVipType));
    paramContentValues.put("grayNameplateFlag", Integer.valueOf(paramEntity.grayNameplateFlag));
    paramContentValues.put("cNewLoverDiamondFlag", Integer.valueOf(paramEntity.cNewLoverDiamondFlag));
    paramContentValues.put("relationIconFlag", Integer.valueOf(paramEntity.relationIconFlag));
    paramContentValues.put("uExtOnlineStatus", Long.valueOf(paramEntity.uExtOnlineStatus));
    paramContentValues.put("iBatteryStatus", Integer.valueOf(paramEntity.iBatteryStatus));
    paramContentValues.put("customModel", paramEntity.customModel);
    paramContentValues.put("songId", paramEntity.songId);
    paramContentValues.put("songName", paramEntity.songName);
    paramContentValues.put("singerName", paramEntity.singerName);
    paramContentValues.put("songEndTime", Long.valueOf(paramEntity.songEndTime));
    paramContentValues.put("songSourceType", Integer.valueOf(paramEntity.songSourceType));
    paramContentValues.put("poiName", paramEntity.poiName);
    paramContentValues.put("poiUpdateTime", Long.valueOf(paramEntity.poiUpdateTime));
    paramContentValues.put("latitude", Double.valueOf(paramEntity.latitude));
    paramContentValues.put("longitude", Double.valueOf(paramEntity.longitude));
    paramContentValues.put("poiFlag", Integer.valueOf(paramEntity.poiFlag));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,remark TEXT ,name TEXT ,faceid INTEGER ,status INTEGER ,sqqtype INTEGER ,cSpecialFlag INTEGER ,groupid INTEGER ,memberLevel INTEGER ,isMqqOnLine INTEGER ,sqqOnLineState INTEGER ,detalStatusFlag INTEGER ,datetime INTEGER ,alias TEXT ,gathtertype INTEGER ,smartRemark TEXT ,age INTEGER ,gender INTEGER ,recommReason TEXT ,signature TEXT ,isIphoneOnline INTEGER ,isRemark INTEGER ,iTermType INTEGER ,qqVipInfo INTEGER ,superQqInfo INTEGER ,superVipInfo INTEGER ,hollywoodVipInfo INTEGER ,lastLoginType INTEGER ,showLoginClient INTEGER ,medalsInfo TEXT ,nameplateCfgInfo TEXT ,richTime INTEGER ,richBuffer BLOB ,mComparePartInt INTEGER ,mCompareSpell TEXT ,cNetwork INTEGER ,eNetwork INTEGER ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,strMasterUin TEXT ,multiFlags INTEGER ,friendType INTEGER ,abilityBits INTEGER ,bigClubInfo INTEGER ,superVipTemplateId INTEGER ,bigClubTemplateId INTEGER ,nameplateVipType INTEGER ,grayNameplateFlag INTEGER ,cNewLoverDiamondFlag INTEGER ,relationIconFlag INTEGER ,uExtOnlineStatus INTEGER ,iBatteryStatus INTEGER ,customModel TEXT ,songId TEXT ,songName TEXT ,singerName TEXT ,songEndTime INTEGER ,songSourceType INTEGER ,poiName TEXT ,poiUpdateTime INTEGER ,latitude REAL ,longitude REAL ,poiFlag INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     akvj
 * JD-Core Version:    0.7.0.1
 */