import EncounterSvc.ReqGetEncounterV2;
import EncounterSvc.RespGetEncounterV2;
import EncounterSvc.UserData;
import NearbyPubAcct.ReqGetNearbyPubAcctInfo;
import NeighborComm.LocalInfoType;
import NeighborComm.RespHeader;
import NeighborComm.SOSO_Cell;
import NeighborComm.SOSO_Wifi;
import NeighborSvc.ReqGetPoint;
import NeighborSvc.RespGetPoint;
import NeighborSvc.UserDetailLocalInfo;
import QQService.ReqFavorite;
import QQService.ReqHead;
import QQService.RespFavorite;
import QQService.RespHead;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import appoint.define.appoint_define.InterestTag;
import appoint.define.appoint_define.LocaleInfo;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x5fb.ReqInfo;
import tencent.im.oidb.cmd0x682.ChatInfo;
import tencent.im.oidb.cmd0x682.ReqBody;
import tencent.im.oidb.cmd0x682.RspBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.RspBody;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.ReqBody;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class acic
{
  @NotNull
  private static ReqGetEncounterV2 a(byte paramByte1, boolean paramBoolean, EncounterSvc.ReqUserInfo paramReqUserInfo1, EncounterSvc.ReqUserInfo paramReqUserInfo2, UserData paramUserData, int paramInt1, ArrayList<Long> paramArrayList, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte paramByte2, byte paramByte3, int paramInt2, byte paramByte4, byte paramByte5, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, long paramLong1, byte paramByte6, int paramInt7, long paramLong2, cmd0x5fb.ReqInfo paramReqInfo, int paramInt8)
  {
    if (paramBoolean) {
      return new ReqGetEncounterV2(paramReqUserInfo1, paramUserData, paramInt1, -1, paramArrayList, new byte[1], paramByte1, 2000, -1, 0, paramArrayOfByte1, paramArrayOfByte2, 0, (byte)1, paramByte2, paramByte4, paramByte5, paramInt2, paramInt3, paramInt5, paramInt6, (byte)1, paramInt4, paramReqUserInfo2, 15, paramReqInfo.toByteArray(), (byte)0, (byte)0, paramByte3, paramString, paramLong1, 0L, paramByte6, paramInt8, paramInt7, paramLong2);
    }
    return new ReqGetEncounterV2(paramReqUserInfo1, paramUserData, paramInt1, -1, paramArrayList, new byte[1], (byte)0, 2000, -1, 0, paramArrayOfByte1, paramArrayOfByte2, 0, (byte)1, paramByte2, paramByte4, paramByte5, paramInt2, paramInt3, paramInt5, paramInt6, (byte)1, paramInt4, null, 15, paramReqInfo.toByteArray(), (byte)0, (byte)0, paramByte3, paramString, paramLong1, 0L, paramByte6, paramInt8, paramInt7, paramLong2);
  }
  
  @NotNull
  private static UserData a(UserData paramUserData, boolean paramBoolean)
  {
    Object localObject;
    if (paramUserData != null)
    {
      localObject = paramUserData;
      if (!paramBoolean) {}
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("temp==ull:");
      if (paramUserData != null) {
        break label68;
      }
    }
    label68:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("NearbyCmdHelper", 2, bool + " first:" + paramBoolean);
      localObject = new UserData();
      return localObject;
    }
  }
  
  @Nullable
  private static UserData a(ToServiceMsg paramToServiceMsg, swr paramswr)
  {
    Object localObject = null;
    int i = q(paramToServiceMsg);
    if ((paramswr instanceof anaw))
    {
      paramToServiceMsg = ((anaw)paramswr).a[i];
      if (ajrk.isColorLevel()) {
        if (paramToServiceMsg != null) {
          break label86;
        }
      }
    }
    label86:
    for (paramswr = "user data is null";; paramswr = paramToServiceMsg.strProvince)
    {
      ajrk.m("NearbyCmdHelper", new Object[] { "handleGetEncounter", Integer.valueOf(i), paramswr });
      return paramToServiceMsg;
      paramToServiceMsg = localObject;
      if (!(paramswr instanceof anau)) {
        break;
      }
      paramToServiceMsg = ((anau)paramswr).a[i];
      break;
    }
  }
  
  private static NearbyPubAcct.LBSInfo a(NearbyGroup.LBSInfo paramLBSInfo)
  {
    Object localObject1 = null;
    if (paramLBSInfo != null)
    {
      localObject1 = new NearbyPubAcct.GPS(paramLBSInfo.stGps.iLat, paramLBSInfo.stGps.iLon, paramLBSInfo.stGps.iAlt, paramLBSInfo.stGps.eType);
      NearbyPubAcct.Attr localAttr = new NearbyPubAcct.Attr(paramLBSInfo.stAttr.strImei, paramLBSInfo.stAttr.strImsi, paramLBSInfo.stAttr.strPhonenum);
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = paramLBSInfo.vWifis.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (NearbyGroup.Wifi)((Iterator)localObject2).next();
        localArrayList.add(new NearbyPubAcct.Wifi(((NearbyGroup.Wifi)localObject3).lMac, ((NearbyGroup.Wifi)localObject3).shRssi));
      }
      localObject2 = new ArrayList();
      paramLBSInfo = paramLBSInfo.vCells.iterator();
      while (paramLBSInfo.hasNext())
      {
        localObject3 = (NearbyGroup.Cell)paramLBSInfo.next();
        ((ArrayList)localObject2).add(new NearbyPubAcct.Cell(((NearbyGroup.Cell)localObject3).shMcc, ((NearbyGroup.Cell)localObject3).shMnc, ((NearbyGroup.Cell)localObject3).iLac, ((NearbyGroup.Cell)localObject3).iCellId, ((NearbyGroup.Cell)localObject3).shRssi));
      }
      localObject1 = new NearbyPubAcct.LBSInfo((NearbyPubAcct.GPS)localObject1, localArrayList, (ArrayList)localObject2, localAttr);
    }
    return localObject1;
  }
  
  public static Object a(AppInterface paramAppInterface, FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, swr paramswr)
  {
    RespHeader localRespHeader = (RespHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
    UserData localUserData;
    boolean bool;
    int i;
    if (localRespHeader != null)
    {
      aivn.gB("LBS", "CMD_GET_ENCOUNTER eReplyCode:" + localRespHeader.eReplyCode);
      localUserData = null;
      bool = false;
      if (localRespHeader == null) {
        break label493;
      }
      i = localRespHeader.eReplyCode;
      if ((i != 0) && (i != 300)) {
        break label421;
      }
      paramFromServiceMsg = (RespGetEncounterV2)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetEncounterV2", new RespGetEncounterV2());
      if (paramFromServiceMsg == null) {
        break label502;
      }
      localUserData = paramFromServiceMsg.stUserData;
      i = q(paramToServiceMsg);
      if (!(paramswr instanceof anaw)) {
        break label390;
      }
      ((anaw)paramswr).a[i] = localUserData;
      label140:
      if (ajrk.isColorLevel())
      {
        if (localUserData != null) {
          break label412;
        }
        paramAppInterface = "user data is null";
        label154:
        ajrk.m("NearbyCmdHelper", new Object[] { "decodeGetEncounter", Integer.valueOf(i), paramAppInterface });
      }
      if (localUserData != null)
      {
        afch.c(paramToServiceMsg.extraData.getString("account"), localUserData.iLon, localUserData.iLat, localUserData.lTime);
        if (QLog.isColorLevel()) {
          QLog.d("NearbyCmdHelper", 2, "respone stUserData.lTime=" + localUserData.lTime + " iLat=" + localUserData.iLat + " iLon" + localUserData.iLon + " lOriginGrid=" + localUserData.lOriginGrid + " lNextGrid=" + localUserData.lNextGrid + " strProvince=" + localUserData.strProvince + " strCookie" + localUserData.strCookie);
        }
      }
      bool = true;
      paramAppInterface = paramFromServiceMsg;
    }
    for (;;)
    {
      return new Object[] { localRespHeader, paramAppInterface, Boolean.valueOf(bool) };
      aivn.gB("LBS", "CMD_GET_ENCOUNTER eReplyCode:" + null);
      break;
      label390:
      if (!(paramswr instanceof anau)) {
        break label140;
      }
      ((anau)paramswr).a[i] = localUserData;
      break label140;
      label412:
      paramAppInterface = localUserData.strProvince;
      break label154;
      label421:
      if (QLog.isColorLevel()) {
        QLog.d("NearbyCmdHelper", 2, "cmd = " + paramFromServiceMsg.getServiceCmd() + " ReplyCode = " + i + ",strResult=" + localRespHeader.strResult);
      }
      acig.e(paramAppInterface, i);
      paramAppInterface = localUserData;
      continue;
      label493:
      acig.e(paramAppInterface, -1111);
      return null;
      label502:
      bool = true;
      paramAppInterface = paramFromServiceMsg;
    }
  }
  
  public static Object a(swr paramswr, FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby", 2, "LBSService --> decodeGetPointInfo(), isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramswr = (RespGetPoint)paramswr.decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetPoint", new RespGetPoint());
      if (paramswr != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby", 2, "LBSService --> decodeGetPointInfo(), url: " + new String(paramswr.stUDLinfo.SOSOUrl) + " , cityId = " + paramswr.stUDLinfo.cityId);
        }
        return paramswr;
      }
    }
    return null;
  }
  
  private static void a(int paramInt1, int paramInt2, boolean paramBoolean, SosoInterface.SosoLbsInfo paramSosoLbsInfo, EncounterSvc.ReqUserInfo paramReqUserInfo)
  {
    if (paramBoolean)
    {
      paramReqUserInfo.vCells = new ArrayList(1);
      paramReqUserInfo.vMacs = new ArrayList(1);
      paramReqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
      paramReqUserInfo.stGps = new EncounterSvc.GPS(paramInt1, paramInt2, 0, 1);
    }
    for (;;)
    {
      return;
      paramReqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_SOSO.value();
      paramReqUserInfo.stGps = new EncounterSvc.GPS((int)(paramSosoLbsInfo.a.cf * 1000000.0D), (int)(paramSosoLbsInfo.a.cg * 1000000.0D), -1, 0);
      if (QLog.isColorLevel()) {
        QLog.i("NearbyCmdHelper", 2, "mLat_84=" + paramSosoLbsInfo.a.cf + ",mLon_84" + paramSosoLbsInfo.a.cg);
      }
      paramReqUserInfo.vSOSOCells = new ArrayList();
      Object localObject;
      if (paramSosoLbsInfo.mCells != null)
      {
        localObject = paramSosoLbsInfo.mCells.iterator();
        while (((Iterator)localObject).hasNext())
        {
          SosoInterface.SosoCell localSosoCell = (SosoInterface.SosoCell)((Iterator)localObject).next();
          paramReqUserInfo.vSOSOCells.add(new SOSO_Cell((short)localSosoCell.cAI, (short)localSosoCell.cAJ, localSosoCell.cAK, localSosoCell.cAL, (short)localSosoCell.cAM));
        }
      }
      paramReqUserInfo.vSOSOMac = new ArrayList();
      if (paramSosoLbsInfo.tZ != null)
      {
        paramSosoLbsInfo = paramSosoLbsInfo.tZ.iterator();
        while (paramSosoLbsInfo.hasNext())
        {
          localObject = (SosoInterface.SosoWifi)paramSosoLbsInfo.next();
          paramReqUserInfo.vSOSOMac.add(new SOSO_Wifi(((SosoInterface.SosoWifi)localObject).RK, (short)((SosoInterface.SosoWifi)localObject).mRssi));
        }
      }
    }
  }
  
  public static void a(accg paramaccg, byte paramByte)
  {
    try
    {
      long l = Long.parseLong(paramaccg.getCurrentAccountUin());
      Object localObject = new byte[13];
      aqoj.DWord2Byte((byte[])localObject, 0, l);
      localObject[4] = 0;
      aqoj.Word2Byte((byte[])localObject, 5, (short)1);
      aqoj.q((byte[])localObject, 7, 40493);
      aqoj.Word2Byte((byte[])localObject, 9, (short)2);
      aqoj.Word2Byte((byte[])localObject, 11, (short)paramByte);
      localObject = paramaccg.makeOIDBPkg("OidbSvc.0x4ff_9", 1279, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putByte("session_switch_value", paramByte);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromDatingHandler", true);
      paramaccg.sendPbReq((ToServiceMsg)localObject);
      afck.l("send_oidb_0x4ff_9", new Object[] { Byte.valueOf(paramByte) });
      return;
    }
    catch (Exception paramaccg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.dating", 2, "send_oidb_0x4ff_9 error", paramaccg);
    }
  }
  
  public static void a(accg paramaccg, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ByteBuffer localByteBuffer = null;
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("req_street_view");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("req_current_loc");
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramFromServiceMsg = (RespGetPoint)paramObject;
      paramObject = paramFromServiceMsg.stUDLinfo;
      if (bool1) {
        if ((paramObject != null) && (paramObject.SOSOUrl.length > 0)) {
          paramaccg.notifyUI(paramInt, true, paramObject.SOSOUrl);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (!bool2);
      paramToServiceMsg = localByteBuffer;
      if (paramObject.cityId != null)
      {
        paramToServiceMsg = localByteBuffer;
        if (paramObject.cityId.length == 16)
        {
          localByteBuffer = ByteBuffer.wrap(paramObject.cityId);
          paramToServiceMsg = new String[4];
          paramToServiceMsg[0] = accv.bi(localByteBuffer.getInt());
          paramToServiceMsg[1] = accv.bi(localByteBuffer.getInt());
          paramToServiceMsg[2] = accv.bi(localByteBuffer.getInt());
          paramToServiceMsg[3] = "0";
        }
      }
      paramaccg.notifyUI(paramInt, true, new Object[] { "", paramObject.strProvince, paramObject.strCity, paramObject.strDistrict, paramObject.strTown, "", paramObject.strRoad, "", Integer.valueOf(paramFromServiceMsg.stGps.iLat), Integer.valueOf(paramFromServiceMsg.stGps.iLon), Integer.valueOf(paramFromServiceMsg.stGps.iAlt), paramToServiceMsg });
      return;
      if (bool1)
      {
        paramaccg.notifyUI(paramInt, false, null);
        return;
      }
    } while (!bool2);
    paramaccg.notifyUI(paramInt, false, null);
  }
  
  public static void a(accg paramaccg, int paramInt1, List<ajuu> paramList, int paramInt2, int paramInt3)
  {
    if (paramList == null)
    {
      c(paramaccg, paramInt1, null, null, null);
      return;
    }
    cmd0x9c7.ReqBody localReqBody = new cmd0x9c7.ReqBody();
    localReqBody.uint32_set_mode.set(paramInt2);
    localReqBody.uint32_test_mode.set(paramInt3);
    paramInt1 = 0;
    while (paramInt1 < paramList.size())
    {
      ajuu localajuu = (ajuu)paramList.get(paramInt1);
      if (localajuu != null) {
        localReqBody.rpt_msg_tags.add(localajuu.a());
      }
      paramInt1 += 1;
    }
    paramList = paramaccg.makeOIDBPkg("OidbSvc.0x9c7_0", 2503, 0, localReqBody.toByteArray());
    paramList.extraData.putInt("set_mode", paramInt2);
    paramList.extraData.putInt("test_mode", paramInt3);
    paramaccg.sendPbReq(paramList);
  }
  
  public static void a(accg paramaccg, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = new cmd0x682.ReqBody();
    ((cmd0x682.ReqBody)localObject).rpt_uint64_touinlist.add(Long.valueOf(paramLong));
    localObject = paramaccg.makeOIDBPkg("OidbSvc.0x682", 1666, 0, ((cmd0x682.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putByteArray("showlove_chat_sig", paramArrayOfByte);
    paramaccg.sendPbReq((ToServiceMsg)localObject);
    d(paramaccg.mApp, paramInt);
    afck.n("getShowLove", new Object[] { "from type " + paramInt });
  }
  
  public static void a(accg paramaccg, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramaccg.getCurrentAccountUin(), "NeighborSvc.ReqGetPoint");
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      localToServiceMsg.extraData.putInt("lat", paramInt1);
      localToServiceMsg.extraData.putInt("lon", paramInt2);
    }
    if (paramBoolean1) {
      localToServiceMsg.extraData.putBoolean("req_street_view", true);
    }
    for (;;)
    {
      paramaccg.send(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putBoolean("req_current_loc", true);
    }
  }
  
  private static void a(DatingFilters paramDatingFilters, cmd0x5fb.ReqInfo paramReqInfo)
  {
    PBUInt32Field localPBUInt32Field;
    if (paramDatingFilters != null)
    {
      paramReqInfo.uint32_time.set(paramDatingFilters.cQd);
      paramReqInfo.uint32_subject.set(paramDatingFilters.datingSubject);
      paramReqInfo.uint32_gender.set(paramDatingFilters.gender);
      paramReqInfo.uint32_age_low.set(DatingFilters.kT[paramDatingFilters.age]);
      paramReqInfo.uint32_age_up.set(DatingFilters.kS[paramDatingFilters.age]);
      localPBUInt32Field = paramReqInfo.uint32_profession;
      if (paramDatingFilters.career >= 0) {
        break label126;
      }
    }
    label126:
    for (int i = 0;; i = paramDatingFilters.career)
    {
      localPBUInt32Field.set(i);
      paramReqInfo.bytes_cookie.set(ByteStringMicro.copyFrom(new byte[0]));
      if ((paramDatingFilters.a != null) && (paramDatingFilters.datingSubject == 5)) {
        paramReqInfo.msg_destination.set(paramDatingFilters.a);
      }
      return;
    }
  }
  
  private static void a(ToServiceMsg paramToServiceMsg, EncounterSvc.ReqUserInfo paramReqUserInfo)
  {
    int i = paramToServiceMsg.extraData.getInt("localLat");
    int j = paramToServiceMsg.extraData.getInt("localLon");
    if ((i != 0) && (j != 0))
    {
      paramReqUserInfo.vCells = new ArrayList(1);
      paramReqUserInfo.vMacs = new ArrayList(1);
      paramReqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
      paramReqUserInfo.stGps = new EncounterSvc.GPS(i, j, 0, 1);
    }
  }
  
  public static boolean a(AppInterface paramAppInterface, ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket, swr paramswr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyCmdHelper", 2, "handleGetEncounter start...");
    }
    if (paramToServiceMsg.extraData.getBoolean("isCheckInReq", false)) {
      return b(paramAppInterface, paramToServiceMsg, paramUniPacket, paramswr);
    }
    Object localObject3 = a(paramToServiceMsg, paramswr);
    int m = paramToServiceMsg.extraData.getInt("lat");
    int n = paramToServiceMsg.extraData.getInt("lon");
    int j = paramToServiceMsg.extraData.getInt("roamMode");
    boolean bool1 = false;
    if ((m != 0) && (n != 0))
    {
      bool1 = true;
      paramswr = null;
    }
    while ((paramswr != null) || (bool1))
    {
      boolean bool2 = paramToServiceMsg.extraData.getBoolean("first");
      NeighborComm.ReqHeader localReqHeader = new NeighborComm.ReqHeader();
      localReqHeader.shVersion = 3;
      localReqHeader.lMID = swr.J(Long.parseLong(paramToServiceMsg.getUin()));
      localReqHeader.iAppID = AppSetting.getAppId();
      localReqHeader.eBusiType = 0;
      localReqHeader.eMqqSysType = 2;
      EncounterSvc.ReqUserInfo localReqUserInfo1 = new EncounterSvc.ReqUserInfo();
      localReqUserInfo1.strAuthName = "B1_QQ_Neighbor_android";
      localReqUserInfo1.strAuthPassword = "NzVK_qGE";
      localReqUserInfo1.eListType = 0;
      a(m, n, bool1, paramswr, localReqUserInfo1);
      EncounterSvc.ReqUserInfo localReqUserInfo2 = new EncounterSvc.ReqUserInfo();
      a(paramToServiceMsg, localReqUserInfo2);
      UserData localUserData = a((UserData)localObject3, bool2);
      int k = paramToServiceMsg.extraData.getInt("gender");
      Object localObject4 = paramToServiceMsg.extraData.getLongArray("tags");
      Object localObject2 = null;
      Object localObject1 = localObject2;
      int i;
      if (localObject4 != null)
      {
        localObject1 = localObject2;
        if (localObject4.length > 0)
        {
          localObject2 = new ArrayList();
          i = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (i >= localObject4.length) {
              break;
            }
            ((ArrayList)localObject2).add(Long.valueOf(localObject4[i]));
            i += 1;
          }
          l1 = System.currentTimeMillis();
          SosoInterface.aj(60000L, "NearbyProtocolCoder.Encounter");
          paramswr = SosoInterface.b();
          l2 = System.currentTimeMillis();
          paramToServiceMsg.extraData.putLong("lbsTime", l2 - l1);
          continue;
        }
      }
      localObject2 = a(m, n, bool2);
      byte b1 = paramToServiceMsg.extraData.getByte("constellation");
      byte b2 = paramToServiceMsg.extraData.getByte("neighbor_interest_id");
      m = paramToServiceMsg.extraData.getInt("timeInterval");
      byte b3 = paramToServiceMsg.extraData.getByte("ageLow");
      byte b4 = paramToServiceMsg.extraData.getByte("ageUp");
      n = paramToServiceMsg.extraData.getInt("careerID");
      int i1 = paramToServiceMsg.extraData.getInt("hometownCountry");
      int i2 = paramToServiceMsg.extraData.getInt("hometownProvince");
      int i3 = paramToServiceMsg.extraData.getInt("hometownCity");
      localObject4 = paramToServiceMsg.extraData.getString("adExtra");
      long l1 = paramToServiceMsg.extraData.getLong("adCtrl");
      byte b5 = paramToServiceMsg.extraData.getByte("rankListNum");
      int i4 = paramToServiceMsg.extraData.getInt("neighbor_list_source");
      long l2 = paramToServiceMsg.extraData.getLong("neighbor_sub_interest_id");
      if ((QLog.isColorLevel()) && (localObject3 != null)) {
        QLog.d("NearbyCmdHelper", 2, "request stUserData.lTime=" + ((UserData)localObject3).lTime + " iLat=" + ((UserData)localObject3).iLat + " iLon" + ((UserData)localObject3).iLon + " lOriginGrid=" + ((UserData)localObject3).lOriginGrid + " lNextGrid=" + ((UserData)localObject3).lNextGrid + " strProvince=" + ((UserData)localObject3).strProvince + " strCookie" + ((UserData)localObject3).strCookie);
      }
      if (ajrk.isColorLevel()) {
        ajrk.f("NearbyCmdHelper", "handleGetEncounter interest", new Object[] { Byte.valueOf(b2), Long.valueOf(l2) });
      }
      paramToServiceMsg = (DatingFilters)paramToServiceMsg.extraData.getParcelable("datingFilter");
      localObject3 = new cmd0x5fb.ReqInfo();
      a(paramToServiceMsg, (cmd0x5fb.ReqInfo)localObject3);
      if (((Boolean)ajrb.c(paramAppInterface.getAccount(), "is_nearby_novice", Boolean.valueOf(false))).booleanValue())
      {
        i = 1;
        if (QLog.isColorLevel()) {
          QLog.i("NearbyCmdHelper", 2, "handleGetEncounter isNearbyNovice: " + i);
        }
        paramToServiceMsg = a((byte)j, bool1, localReqUserInfo1, localReqUserInfo2, localUserData, k, localObject1, null, (byte[])localObject2, b1, b2, m, b3, b4, n, i1, i2, i3, (String)localObject4, l1, b5, i4, l2, (cmd0x5fb.ReqInfo)localObject3, i);
        paramUniPacket.setEncodeName("utf-8");
        paramUniPacket.setServantName("EncounterObj");
        paramUniPacket.setFuncName("CMD_GET_ENCOUNTERV2");
        paramUniPacket.put("ReqHeader", localReqHeader);
        paramUniPacket.put("ReqGetEncounterV2", paramToServiceMsg);
        paramUniPacket = new HashMap();
        if (paramswr == null) {
          break label976;
        }
      }
      label976:
      for (paramToServiceMsg = "lbs is not null";; paramToServiceMsg = "isUseGps is true")
      {
        paramUniPacket.put("param_reason", paramToServiceMsg);
        paramUniPacket.put("param_NetType", aqiw.getSystemNetwork(null) + "");
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramAppInterface.getCurrentAccountUin(), "GET_ENCOUNTER_LOCATION", true, 0L, 0L, paramUniPacket, "");
        return true;
        i = 0;
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyCmdHelper", 2, "handleGetEncounter lbsInfo=" + paramswr + ", isUseGps=" + bool1);
    }
    if (paramswr == null) {
      paramToServiceMsg.extraData.putBoolean("isLbsInfoNull", true);
    }
    paramToServiceMsg = new HashMap();
    paramToServiceMsg.put("param_reason", "all is null");
    paramToServiceMsg.put("param_NetType", aqiw.getSystemNetwork(null) + "");
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramAppInterface.getCurrentAccountUin(), "GET_ENCOUNTER_LOCATION", false, 0L, 0L, paramToServiceMsg, "");
    return false;
  }
  
  public static boolean a(swr paramswr, ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("req_street_view");
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("req_current_loc");
    int i = paramToServiceMsg.extraData.getInt("lat");
    int k = paramToServiceMsg.extraData.getInt("lon");
    if (((bool2) && (i != 0) && (k != 0)) || (bool3))
    {
      paramswr = new NeighborSvc.ReqHeader();
      paramswr.shVersion = 2;
      paramswr.lMID = swr.J(Long.parseLong(paramToServiceMsg.getUin()));
      paramswr.iAppID = AppSetting.getAppId();
      paramswr.eBusiType = 0;
      paramswr.eMqqSysType = 2;
      Object localObject1 = new NeighborSvc.ReqUserInfo();
      ((NeighborSvc.ReqUserInfo)localObject1).strAuthName = "B1_QQ_Neighbor_android";
      ((NeighborSvc.ReqUserInfo)localObject1).strAuthPassword = "NzVK_qGE";
      ((NeighborSvc.ReqUserInfo)localObject1).eListType = 0;
      if (bool2)
      {
        ((NeighborSvc.ReqUserInfo)localObject1).vCells = new ArrayList(1);
        ((NeighborSvc.ReqUserInfo)localObject1).vMacs = new ArrayList(1);
        ((NeighborSvc.ReqUserInfo)localObject1).stGps = new NeighborSvc.GPS(i, k, 0, 1);
        ((NeighborSvc.ReqUserInfo)localObject1).eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
        if (!bool2) {
          break label467;
        }
      }
      label297:
      label467:
      for (i = 1;; i = 0) {
        for (;;)
        {
          byte b = (byte)i;
          i = j;
          if (bool3) {
            i = 1;
          }
          localObject1 = new ReqGetPoint((NeighborSvc.ReqUserInfo)localObject1, b, (byte)i);
          paramUniPacket.setServantName("NeighborObj");
          paramUniPacket.setFuncName("CMD_GET_POINT");
          paramUniPacket.put("ReqHeader", paramswr);
          paramUniPacket.put("ReqGetPoint", localObject1);
          paramToServiceMsg.setTimeout(30000L);
          paramToServiceMsg.setServiceCmd("NeighborSvc.ReqGetPoint");
          bool1 = true;
          return bool1;
          if ((bool3 == true) && (i != 0) && (k != 0))
          {
            ((NeighborSvc.ReqUserInfo)localObject1).vCells = new ArrayList(1);
            ((NeighborSvc.ReqUserInfo)localObject1).vMacs = new ArrayList(1);
            ((NeighborSvc.ReqUserInfo)localObject1).stGps = new NeighborSvc.GPS(i, k, 0, 1);
            break;
          }
          aczc.a(new acid("LBSService.Point", paramToServiceMsg));
          try
          {
            paramToServiceMsg.wait();
            Object localObject2 = ajpf.a(true, aczc.a("LBSService.Point"));
            if (localObject2 == null) {
              break label297;
            }
            if (((NearbyGroup.LBSInfo)localObject2).stGps == null) {
              break;
            }
            localObject2 = ((NearbyGroup.LBSInfo)localObject2).stGps;
            ((NeighborSvc.ReqUserInfo)localObject1).stGps = new NeighborSvc.GPS(((NearbyGroup.GPS)localObject2).iLat, ((NearbyGroup.GPS)localObject2).iLon, ((NearbyGroup.GPS)localObject2).iAlt, ((NearbyGroup.GPS)localObject2).eType);
            break;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
          }
          finally {}
        }
      }
    }
    paramswr = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    paramswr.setMsgFail();
    try
    {
      paramToServiceMsg.actionListener.onActionResult(paramswr);
      return false;
    }
    catch (RemoteException paramswr) {}
    return false;
  }
  
  private static byte[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramBoolean)
    {
      if ((paramInt1 == 0) || (paramInt2 == 0)) {
        break label100;
      }
      localObject = new NearbyPubAcct.LBSInfo();
      ((NearbyPubAcct.LBSInfo)localObject).stGps = new NearbyPubAcct.GPS(paramInt1, paramInt2, 0, 1);
    }
    for (;;)
    {
      localObject = new ReqGetNearbyPubAcctInfo((short)2, new byte[0], 2, (NearbyPubAcct.LBSInfo)localObject);
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setRequestId(1);
      localUniPacket.setServantName("PubAccountSvc.nearby_pubacct");
      localUniPacket.setFuncName("nearby_pubacct");
      localUniPacket.put("nearby_pubacct", localObject);
      localObject = localUniPacket.encode();
      return localObject;
      label100:
      localObject = a(ajpf.a());
    }
  }
  
  public static void b(accg paramaccg, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    int i = -1;
    try
    {
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      boolean bool1 = bool2;
      int j;
      if (paramFromServiceMsg != null)
      {
        j = paramFromServiceMsg.uint32_result.get();
        i = j;
        bool1 = bool2;
        if (j == 0)
        {
          bool1 = true;
          i = j;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby", 2, "rspNearbyCharmEvent,result code：" + i + ",isSuccess:" + bool1);
      }
      if (bool1)
      {
        Oidb_0x686.RspBody localRspBody = new Oidb_0x686.RspBody();
        i = paramFromServiceMsg.uint32_service_type.get();
        localRspBody.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (localRspBody.uint32_config_seq.has())
        {
          j = localRspBody.uint32_config_seq.get();
          ajrb.c(paramaccg.mApp.getAccount(), "toplist_hide_boygod_seq", Integer.valueOf(j));
        }
        if (localRspBody.uint32_config_time.has())
        {
          j = localRspBody.uint32_config_time.get();
          ajrb.c(paramaccg.mApp.getAccount(), "key_last_config_time", Integer.valueOf(j));
        }
        paramFromServiceMsg = null;
        paramObject = null;
        Object localObject3 = null;
        Object localObject4 = null;
        if (localRspBody.msg_rank_config.has()) {
          paramFromServiceMsg = (Oidb_0x686.NearbyRankConfig)localRspBody.msg_rank_config.get();
        }
        if (localRspBody.msg_feed_config.has()) {
          paramObject = (Oidb_0x686.NearbyFeedConfig)localRspBody.msg_feed_config.get();
        }
        Object localObject1;
        Object localObject2;
        if ((i == 2) && (localRspBody.msg_charm_event.has()))
        {
          localObject1 = (Oidb_0x686.CharmEvent)localRspBody.msg_charm_event.get();
          localObject2 = localObject4;
          if (!(paramaccg.mApp instanceof NearbyAppInterface)) {
            break label600;
          }
        }
        int k;
        int m;
        int n;
        int i1;
        for (;;)
        {
          if ((localObject1 == null) || (((Oidb_0x686.CharmEvent)localObject1).uint32_pop_flag.get() != 1)) {
            break label637;
          }
          i = ((Oidb_0x686.CharmEvent)localObject1).uint32_old_charm.get();
          j = ((Oidb_0x686.CharmEvent)localObject1).uint32_old_charm_level.get();
          k = ((Oidb_0x686.CharmEvent)localObject1).uint32_new_charm.get();
          m = ((Oidb_0x686.CharmEvent)localObject1).uint32_new_charm_level.get();
          n = ((Oidb_0x686.CharmEvent)localObject1).uint32_cur_level_threshold.get();
          i1 = ((Oidb_0x686.CharmEvent)localObject1).uint32_next_level_threshold.get();
          paramFromServiceMsg = ((Oidb_0x686.CharmEvent)localObject1).str_tips_content.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            paramToServiceMsg = "";
          }
          paramaccg.notifyUI(paramInt, true, new Object[] { Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), paramToServiceMsg });
          paramToServiceMsg = "0X80052B1";
          if (k - i < 0) {
            paramToServiceMsg = "0X80052B2";
          }
          paramaccg.mApp.reportClickEvent("CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
          return;
          localObject1 = localObject3;
          localObject2 = localObject4;
          if (i != 1) {
            break;
          }
          localObject1 = localObject3;
          localObject2 = localObject4;
          if (!localRspBody.msg_notify_event.has()) {
            break;
          }
          localObject2 = (Oidb_0x686.NearbyCharmNotify)localRspBody.msg_notify_event.get();
          localObject1 = localObject3;
          break;
          label600:
          if ((paramaccg.mApp instanceof QQAppInterface)) {
            ((QQAppInterface)paramaccg.mApp).a().a(paramToServiceMsg.getUin(), paramFromServiceMsg, paramObject, (Oidb_0x686.CharmEvent)localObject1, (Oidb_0x686.NearbyCharmNotify)localObject2);
          }
        }
        label637:
        if ((localObject2 != null) && (((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_pop_flag.get() == 1))
        {
          i = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_charm.get();
          j = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_charm_level.get();
          k = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_charm.get();
          m = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_charm_level.get();
          n = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_cur_level_threshold.get();
          i1 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_next_level_threshold.get();
          int i2 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_prof_percent.get();
          int i3 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_prof_percent.get();
          paramFromServiceMsg = ((Oidb_0x686.NearbyCharmNotify)localObject2).str_tips_content.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            paramToServiceMsg = "";
          }
          paramaccg.notifyUI(paramInt, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), paramToServiceMsg });
          paramToServiceMsg = "0X80052AE";
          if (k - i < 0) {
            paramToServiceMsg = "0X80052AF";
          }
          paramaccg.mApp.reportClickEvent("CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
        }
      }
      return;
    }
    catch (Exception paramaccg) {}
  }
  
  public static void b(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespFavorite)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespFavorite", new RespFavorite());
    paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
    switch (paramToServiceMsg.stHeader.iReplyCode)
    {
    default: 
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgSuccess();
  }
  
  protected static boolean b(AppInterface paramAppInterface, ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket, swr paramswr)
  {
    int i = paramToServiceMsg.extraData.getInt("localLat");
    int j = paramToServiceMsg.extraData.getInt("localLon");
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotChatDistance", 2, "NearbyCmdHelper.handleCheckIn,  lat=" + i + ", lon=" + j);
    }
    if ((i != 0) && (j != 0))
    {
      paramAppInterface = new NeighborComm.ReqHeader();
      paramAppInterface.shVersion = 3;
      paramAppInterface.lMID = swr.J(Long.parseLong(paramToServiceMsg.getUin()));
      paramAppInterface.iAppID = AppSetting.getAppId();
      paramAppInterface.eBusiType = 0;
      paramAppInterface.eMqqSysType = 2;
      paramToServiceMsg = new EncounterSvc.ReqUserInfo();
      paramToServiceMsg.strAuthName = "B1_QQ_Neighbor_android";
      paramToServiceMsg.strAuthPassword = "NzVK_qGE";
      paramToServiceMsg.eListType = 0;
      paramToServiceMsg.vCells = new ArrayList(1);
      paramToServiceMsg.vMacs = new ArrayList(1);
      paramToServiceMsg.eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
      paramToServiceMsg.stGps = new EncounterSvc.GPS(i, j, 0, 1);
      paramswr = new ReqGetEncounterV2();
      paramswr.stUserData = new UserData();
      paramswr.stUserInfo = paramToServiceMsg;
      paramswr.eNewListType = 100;
      paramswr.neighbor_list_source = 4;
      paramUniPacket.setEncodeName("utf-8");
      paramUniPacket.setServantName("EncounterObj");
      paramUniPacket.setFuncName("CMD_GET_ENCOUNTERV2");
      paramUniPacket.put("ReqHeader", paramAppInterface);
      paramUniPacket.put("ReqGetEncounterV2", paramswr);
      return true;
    }
    return false;
  }
  
  public static boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfUin");
    long l2 = paramToServiceMsg.extraData.getLong("targetUin");
    Object localObject = paramToServiceMsg.extraData.getByteArray("vCookies");
    int i = paramToServiceMsg.extraData.getInt("favoriteSource");
    int j = paramToServiceMsg.extraData.getInt("iCount");
    localObject = new ReqFavorite(new ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, (byte[])localObject), l2, 0, i, j);
    paramUniPacket.setServantName("VisitorSvc");
    paramUniPacket.setFuncName("ReqFavorite");
    paramUniPacket.put("ReqFavorite", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("VisitorSvc.ReqFavorite");
    return true;
  }
  
  public static void c(accg paramaccg, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      paramaccg.notifyUI(paramInt, false, new Object[] { "", null, acfp.m(2131708672), Integer.valueOf(-1), Integer.valueOf(-1) });
      return;
    }
    int i;
    int j;
    label72:
    cmd0x9c7.RspBody localRspBody;
    int m;
    if (paramToServiceMsg.extraData == null)
    {
      i = -1;
      if (paramToServiceMsg.extraData != null) {
        break label227;
      }
      j = -1;
      localRspBody = new cmd0x9c7.RspBody();
      m = accg.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      if (m != 0) {
        break label472;
      }
      if (!localRspBody.str_test_result_url.has()) {
        break label242;
      }
      paramToServiceMsg = localRspBody.str_test_result_url.get();
      label116:
      if (!localRspBody.rpt_msg_tags.has()) {
        break label249;
      }
    }
    label227:
    label242:
    label249:
    for (paramFromServiceMsg = localRspBody.rpt_msg_tags.get();; paramFromServiceMsg = null)
    {
      paramObject = new ArrayList();
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0)) {
        break label254;
      }
      int k = 0;
      while (k < paramFromServiceMsg.size())
      {
        ajuu localajuu = ajuu.a((appoint_define.InterestTag)paramFromServiceMsg.get(k));
        if (localajuu != null) {
          paramObject.add(localajuu);
        }
        k += 1;
      }
      i = paramToServiceMsg.extraData.getInt("set_mode");
      break;
      j = paramToServiceMsg.extraData.getInt("test_mode");
      break label72;
      paramToServiceMsg = "";
      break label116;
    }
    label254:
    if (paramObject.size() <= 0)
    {
      paramaccg.notifyUI(4, false, new Object[] { "", null, acfp.m(2131708673), Integer.valueOf(i), Integer.valueOf(j) });
      ajrk.f("Q.nearby_people_card.", "handle_oidb_0x9c7_0", new Object[] { Integer.valueOf(m), Boolean.valueOf(true), null, paramToServiceMsg });
      return;
    }
    if ((paramaccg.mApp instanceof NearbyAppInterface)) {
      ((NearbyAppInterface)paramaccg.mApp).a().a(localRspBody);
    }
    for (;;)
    {
      paramaccg.notifyUI(paramInt, true, new Object[] { paramToServiceMsg, paramObject, "", Integer.valueOf(i), Integer.valueOf(j) });
      ajrk.f("Q.nearby_people_card.", "handle_oidb_0x9c7_0", new Object[] { Integer.valueOf(m), Boolean.valueOf(true), paramObject, paramToServiceMsg });
      return;
      if (paramaccg.app != null) {
        paramaccg.app.a().a(localRspBody);
      }
    }
    label472:
    if (localRspBody.str_error.has()) {}
    for (paramToServiceMsg = localRspBody.str_error.get();; paramToServiceMsg = "")
    {
      paramaccg.notifyUI(paramInt, false, new Object[] { "", null, paramToServiceMsg, Integer.valueOf(i), Integer.valueOf(j) });
      return;
    }
  }
  
  public static void d(accg paramaccg, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          int i = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.dating", 2, "handle_oidb_0x4ff_9 ret=" + i);
          }
          if ((i == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
            if (4 <= paramFromServiceMsg.length)
            {
              paramFromServiceMsg = String.valueOf(aqoj.getLongData(paramFromServiceMsg, 0));
              if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.equals(paramaccg.getCurrentAccountUin())))
              {
                if (QLog.isColorLevel()) {
                  QLog.w("Q.dating", 2, "handle_oidb_0x4ff_9 uin error");
                }
                return;
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          paramFromServiceMsg = paramObject;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((paramaccg.mApp instanceof QQAppInterface)) {
        if (paramInt == 7)
        {
          paramInt = paramToServiceMsg.extraData.getByte("session_switch_value", (byte)0).byteValue();
          if (bool1)
          {
            paramToServiceMsg = ((QQAppInterface)paramaccg.mApp).a();
            if (paramInt != 0) {
              break label294;
            }
            paramToServiceMsg.Mj(bool2);
          }
          paramaccg.notifyUI(7, bool1, null);
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label364;
        }
        QLog.d("Q.dating", 2, "handle_oidb_0x4ff_9, isSuccess:" + bool1);
        return;
        label294:
        bool2 = false;
        break;
        if ((paramaccg.mApp instanceof NearbyAppInterface))
        {
          paramFromServiceMsg = (NearbyAppInterface)paramaccg.mApp;
          if (paramInt == 10)
          {
            byte b = paramToServiceMsg.extraData.getByte("session_switch_value", (byte)0).byteValue();
            if (bool1) {
              paramFromServiceMsg.a().l(b);
            }
            paramaccg.notifyUI(10, bool1, null);
          }
        }
      }
      label364:
      break;
      bool1 = true;
      continue;
      bool1 = false;
    }
  }
  
  private static void d(AppInterface paramAppInterface, int paramInt)
  {
    String str = "";
    if ((paramInt & 0x4) == 4)
    {
      str = "0X8005283";
      paramAppInterface.reportClickEvent("CliOper", "", "", str, str, 0, 0, "", "", "", "");
      afck.n("getShowLove", new Object[] { "report value ", str });
      str = "";
      if ((paramInt & 0x1) != 1) {
        break label184;
      }
      str = "0X8005288";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str))
      {
        paramAppInterface.reportClickEvent("CliOper", "", "", str, str, 0, 0, "", "", "", "");
        afck.n("getShowLove", new Object[] { "report value2 ", str });
      }
      return;
      if ((paramInt & 0x8) == 8)
      {
        str = "0X8005284";
        break;
      }
      if ((paramInt & 0x10) == 16)
      {
        str = "0X8005285";
        break;
      }
      if ((paramInt & 0x20) != 32) {
        break;
      }
      str = "0X8005281";
      break;
      label184:
      if ((paramInt & 0x2) == 2) {
        str = "0X8005289";
      }
    }
  }
  
  public static final <T> T decodePacket(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramT);
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    catch (RuntimeException paramArrayOfByte) {}
    return null;
  }
  
  public static void e(accg paramaccg, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0x682.RspBody localRspBody = new cmd0x682.RspBody();
    int i = accg.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    afck.l("getShowLove", new Object[] { "handleGetShowLoveLimit result = " + i });
    int n;
    if ((i == 0) && (localRspBody.rpt_msg_chatinfo.has()) && (localRspBody.rpt_msg_chatinfo.size() > 0))
    {
      paramObject = (cmd0x682.ChatInfo)localRspBody.rpt_msg_chatinfo.get(0);
      long l = paramObject.uint64_touin.get();
      paramInt = paramObject.uint32_chatflag.get();
      int j = paramObject.uint32_goldflag.get();
      int k = paramObject.uint32_totalexpcount.get();
      int m = paramObject.uint32_curexpcount.get();
      n = paramObject.uint32_totalFlag.get();
      int i1 = paramObject.uint32_curdayFlag.get();
      paramFromServiceMsg = paramObject.express_tips_msg.get().toStringUtf8();
      paramObject = paramObject.express_msg.get().toStringUtf8();
      boolean bool1 = false;
      boolean bool3 = false;
      paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("showlove_chat_sig");
      if (((paramInt & 0x2) == 2) || (j == 2)) {
        bool1 = true;
      }
      boolean bool2 = bool3;
      if (j == 1)
      {
        bool2 = bool3;
        if (n == 0)
        {
          bool2 = bool3;
          if (i1 == 0) {
            bool2 = true;
          }
        }
      }
      if ((paramaccg instanceof ajrs)) {
        paramaccg.notifyUI(9, true, new Object[] { Long.valueOf(l), Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramToServiceMsg, paramFromServiceMsg, paramObject });
      }
      if (QLog.isColorLevel()) {
        QLog.d("DatingSayHello", 2, "toUin:" + l + ",chatFlag:" + paramInt + ",godFlag:" + j + ",totalCount:" + k + ",curCount" + m + ",totalFlag:" + n + ",curdayFlag:" + i1 + ",canChat:" + bool1 + ",canShowLove:" + bool2 + ",wordStr:" + paramFromServiceMsg + "showloveStr: " + paramObject);
      }
      if (i1 == 1) {
        paramaccg.mApp.reportClickEvent("CliOper", "", "", "0X8005290", "0X8005290", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_bank", 2, "handleGetShowLoveLimit,result：" + i);
      }
      return;
      if (n == 1)
      {
        paramaccg.mApp.reportClickEvent("CliOper", "", "", "0X8005291", "0X8005291", 0, 0, "", "", "", "");
        continue;
        paramaccg.notifyUI(paramInt, false, null);
      }
    }
  }
  
  public static int q(ToServiceMsg paramToServiceMsg)
  {
    int j = 0;
    int i = j;
    if (paramToServiceMsg != null)
    {
      int k = paramToServiceMsg.extraData.getByte("neighbor_interest_id");
      long l = paramToServiceMsg.extraData.getLong("neighbor_sub_interest_id");
      i = j;
      if (k != 0)
      {
        i = j;
        if (l != 0L) {
          i = 1;
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acic
 * JD-Core Version:    0.7.0.1
 */