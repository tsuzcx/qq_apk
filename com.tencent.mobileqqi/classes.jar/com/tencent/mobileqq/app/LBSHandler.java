package com.tencent.mobileqq.app;

import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RespGetEncounterV2;
import LBSAddrProtocol.GPS;
import LBSAddrProtocol.RspGetPositionApi;
import NeighborSvc.RespGetNeighbors;
import NeighborSvc.RespGetPoint;
import NeighborSvc.RespGetSwitches;
import NeighborSvc.RespHeader;
import NeighborSvc.RespSetStateSwitch;
import NeighborSvc.Switch;
import NeighborSvc.UserDetailLocalInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsReq;
import com.tencent.proto.lbsshare.LBSShare.LocationReq;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsReq;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class LBSHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 10;
  public static final int k = 11;
  public static final int l = 12;
  public static final int m = 13;
  public static final int n = 14;
  public static final int o = 15;
  public static final int p = 16;
  public static final int q = 17;
  public static final int r = 18;
  public static final int s = -11;
  public static final int t = -111;
  public static final int u = -1111;
  public static int v;
  
  LBSHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "Neiggbor", "ReqGetEncounter", 0, paramInt, "", "", "", "");
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, RespGetNeighbors paramRespGetNeighbors)
  {
    Object localObject = null;
    if ((paramRespGetNeighbors != null) && (paramRespGetNeighbors.stHeader != null))
    {
      ReportLog.a("LBS", "CMD_GET_NEIGHBORS eReplyCode:" + paramRespGetNeighbors.stHeader.eReplyCode);
      if ((paramRespGetNeighbors.stHeader.eReplyCode == 0) || (paramRespGetNeighbors.stHeader.eReplyCode == 300))
      {
        StringBuilder localStringBuilder = new StringBuilder().append("CMD_GET_NEIGHBORS size:");
        if (paramRespGetNeighbors.vNeighborInfos == null) {}
        for (;;)
        {
          ReportLog.a("LBS", localObject);
          a(2, true, new Object[] { paramFromServiceMsg.getUin(), paramRespGetNeighbors, Boolean.valueOf(paramToServiceMsg.extraData.getBoolean("first")) });
          return;
          localObject = Integer.valueOf(paramRespGetNeighbors.vNeighborInfos.size());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("svenxu", 2, "cmd = " + paramFromServiceMsg.getServiceCmd() + " replyCode = " + paramRespGetNeighbors.stHeader.eReplyCode);
      }
      a(2, false, Integer.valueOf(paramRespGetNeighbors.stHeader.eReplyCode));
      return;
    }
    ReportLog.a("LBS", "CMD_GET_NEIGHBORS eReplyCode:" + null);
    a(2, false, null);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    if ((paramObject instanceof RespGetEncounterV2))
    {
      RespGetEncounterV2 localRespGetEncounterV2 = (RespGetEncounterV2)paramObject;
      Object localObject2 = new StringBuilder().append("CMD_GET_ENCOUNTER size:");
      if (localRespGetEncounterV2.vEncounterInfos == null) {}
      for (Object localObject1 = null;; localObject1 = Integer.valueOf(localRespGetEncounterV2.vEncounterInfos.size()))
      {
        ReportLog.a("LBS", localObject1);
        paramFromServiceMsg.setMsgSuccess();
        localObject1 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        localObject2 = localRespGetEncounterV2.vEncounterInfos;
        if (localObject2 == null) {
          break;
        }
        paramFromServiceMsg = ((ArrayList)localObject2).iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramObject = (RespEncounterInfo)paramFromServiceMsg.next();
          if (String.valueOf(paramObject.lEctID).equals(paramToServiceMsg.getUin())) {
            ((FriendsManagerImp)localObject1).a(paramToServiceMsg.getUin(), paramObject.vIntroContent, paramObject.shIntroType);
          }
        }
        a(5, true, new Object[] { paramToServiceMsg.getUin(), Integer.valueOf(paramToServiceMsg.extraData.getInt("gender")), localRespGetEncounterV2, Boolean.valueOf(paramToServiceMsg.extraData.getBoolean("first")), Integer.valueOf(paramToServiceMsg.extraData.getInt("classChild")) });
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("svenxu", 2, "cmd = " + paramFromServiceMsg.getServiceCmd() + "list == null");
      }
      a(5, false, new Object[] { paramObject, Integer.valueOf(paramToServiceMsg.extraData.getInt("classChild")) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("svenxu", 2, "cmd = " + paramFromServiceMsg.getServiceCmd() + "type erro");
    }
    a(5, false, new Object[] { paramObject, Integer.valueOf(paramToServiceMsg.extraData.getInt("classChild")) });
  }
  
  protected Class a()
  {
    return LBSObserver.class;
  }
  
  @Deprecated
  public void a()
  {
    a(false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "QzoneService.knrsNew");
    localToServiceMsg.extraData.putInt("ps", paramInt1);
    localToServiceMsg.extraData.putInt("pn", paramInt2);
    a(localToServiceMsg);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt3 < 0) || (paramInt3 > 1)) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "LbsShareSvr.nearby_shops");
    LBSShare.NearByShopsReq localNearByShopsReq = new LBSShare.NearByShopsReq();
    localNearByShopsReq.lat.set(paramInt1);
    localNearByShopsReq.lng.set(paramInt2);
    localNearByShopsReq.coordinate.set(paramInt3);
    localNearByShopsReq.begin.set(paramInt4);
    localNearByShopsReq.limit.set(paramInt5);
    localNearByShopsReq.version.set(1);
    Bundle localBundle = new Bundle();
    localBundle.putInt("latitude", paramInt1);
    localBundle.putInt("longitude", paramInt2);
    localBundle.putInt("coordinate", paramInt3);
    localBundle.putInt("begin", paramInt4);
    localBundle.putInt("count", paramInt5);
    localToServiceMsg.extraData.putBundle("req", localBundle);
    localToServiceMsg.putWupBuffer(localNearByShopsReq.toByteArray());
    b(localToServiceMsg);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt3 < 0) || (paramInt3 > 1) || (paramInt4 < 0) || (paramInt5 < 0) || (paramInt5 > 100)) {
      return;
    }
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString2 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "LbsShareSvr.location");
    LBSShare.LocationReq localLocationReq = new LBSShare.LocationReq();
    localLocationReq.lat.set(paramInt1);
    localLocationReq.lng.set(paramInt2);
    localLocationReq.coordinate.set(paramInt3);
    localLocationReq.keyword.set(str);
    localLocationReq.category.set(paramString1);
    localLocationReq.page.set(paramInt4);
    localLocationReq.count.set(paramInt5);
    localLocationReq.requireMyLbs.set(paramInt6);
    Bundle localBundle = new Bundle();
    localBundle.putInt("latitude", paramInt1);
    localBundle.putInt("longitude", paramInt2);
    localBundle.putInt("coordinate", paramInt3);
    localBundle.putString("keyword", str);
    localBundle.putString("category", paramString1);
    localBundle.putInt("page", paramInt4);
    localBundle.putInt("count", paramInt5);
    localBundle.putInt("requireMyLbs", paramInt6);
    paramString2.extraData.putBundle("req", localBundle);
    paramString2.putWupBuffer(localLocationReq.toByteArray());
    b(paramString2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m()) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "NearbyGroup.ReqGetAreaList");
    localToServiceMsg.extraData.putInt("lat", paramInt1);
    localToServiceMsg.extraData.putInt("lon", paramInt2);
    localToServiceMsg.extraData.putInt("radius", paramInt3);
    localToServiceMsg.extraData.putBoolean("clickable", paramBoolean);
    a(localToServiceMsg);
  }
  
  public void a(int paramInt1, boolean paramBoolean, long[] paramArrayOfLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m()) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "EncounterSvc.ReqGetEncounter");
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putInt("gender", paramInt1);
    localToServiceMsg.extraData.putBoolean("first", paramBoolean);
    localToServiceMsg.extraData.putLongArray("tags", paramArrayOfLong);
    localToServiceMsg.extraData.putInt("roamMode", paramInt4);
    localToServiceMsg.extraData.putInt("classChild", paramInt5);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      localToServiceMsg.extraData.putInt("lat", paramInt2);
      localToServiceMsg.extraData.putInt("lon", paramInt3);
    }
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1384);
    localOIDBSSOPkg.uint32_service_type.set(20);
    Object localObject = ByteBuffer.allocate(5);
    int i1 = 3;
    while (i1 >= 0)
    {
      ((ByteBuffer)localObject).put((byte)(int)(paramLong >> i1 * 8));
      i1 -= 1;
    }
    if (paramBoolean) {}
    for (i1 = 0;; i1 = 1)
    {
      ((ByteBuffer)localObject).put((byte)i1);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = a("OidbSvc.0x568_20");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).extraData.putLong("key_troopuin", paramLong);
      ((ToServiceMsg)localObject).extraData.putBoolean("key_show", paramBoolean);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      b((ToServiceMsg)localObject);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    if (c(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("msgCmdFilter", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    label291:
    label310:
    boolean bool1;
    label604:
    label623:
    do
    {
      do
      {
        return;
        if ("LBS.AddressService".equals(paramFromServiceMsg.getServiceCmd()))
        {
          paramFromServiceMsg = (RspGetPositionApi)paramObject;
          paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("devicedata");
          if (paramFromServiceMsg != null)
          {
            a(1, true, new Object[] { paramToServiceMsg, String.valueOf(paramFromServiceMsg.stUsrLoc.iLat / 1000000.0D), String.valueOf(paramFromServiceMsg.stUsrLoc.iLon / 1000000.0D), paramFromServiceMsg.strCity.trim() + paramFromServiceMsg.strDistrict.trim() + paramFromServiceMsg.strRoad.trim() });
            return;
          }
          a(1, false, paramToServiceMsg);
          return;
        }
        StringBuilder localStringBuilder;
        String str;
        if ("NeighborSvc.ReqGetNeighbors".equals(paramFromServiceMsg.getServiceCmd()))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder().append("cmd = ").append(paramFromServiceMsg.getServiceCmd());
            if (paramObject != null)
            {
              str = " has data";
              QLog.d("svenxu", 2, str);
            }
          }
          else
          {
            if (paramObject != null) {
              break label310;
            }
            if ((paramFromServiceMsg == null) || (paramFromServiceMsg.isSuccess())) {
              break label291;
            }
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -111);
          }
          for (;;)
          {
            a(2, false, null);
            return;
            str = " has no data";
            break;
            if (v != 0) {
              a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, v);
            }
          }
          a(paramFromServiceMsg, paramToServiceMsg, (RespGetNeighbors)paramObject);
          return;
        }
        if ("NeighborSvc.ReqSetUserState".equals(paramFromServiceMsg.getServiceCmd()))
        {
          bool1 = paramToServiceMsg.extraData.getBoolean("k_visible_for_near_people");
          if (paramObject == null)
          {
            bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n();
            if (QLog.isColorLevel()) {
              QLog.i("Q.security", 2, "CMD_SET_PEOPLE_VISIBLE| visible = " + bool1 + ", fail");
            }
            a(3, false, Boolean.valueOf(bool1));
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.security", 2, "CMD_SET_PEOPLE_VISIBLE| visible = " + bool1 + ", suc");
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(bool1, true);
          a(3, true, Boolean.valueOf(bool1));
          return;
        }
        if ("EncounterSvc.ReqGetEncounter".equals(paramFromServiceMsg.getServiceCmd()))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder().append("cmd = ").append(paramFromServiceMsg.getServiceCmd());
            if (paramObject != null)
            {
              str = " has data";
              QLog.d("svenxu", 2, str);
            }
          }
          else
          {
            if (paramObject != null) {
              break label623;
            }
            if ((paramFromServiceMsg == null) || (paramFromServiceMsg.isSuccess())) {
              break label604;
            }
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -111);
          }
          for (;;)
          {
            a(5, false, new Object[] { Integer.valueOf(101), Integer.valueOf(paramToServiceMsg.extraData.getInt("classChild")) });
            return;
            str = " has no data";
            break;
            if (v != 0) {
              a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, v);
            }
          }
          a(paramFromServiceMsg, paramToServiceMsg, paramObject);
          return;
        }
        if ("QzoneService.knrsNew".equals(paramFromServiceMsg.getServiceCmd())) {
          try
          {
            a(7, true, new Object[] { (List)(List)paramFromServiceMsg.getAttributes().get("result"), Integer.valueOf(((Integer)paramFromServiceMsg.getAttributes().get("vc")).intValue()) });
            return;
          }
          catch (Exception paramToServiceMsg)
          {
            a(7, false, new Object[] { null, Integer.valueOf(0) });
            return;
          }
        }
        if ("NearbyGroup.GetGroupList".equals(paramFromServiceMsg.getServiceCmd()))
        {
          bool2 = paramToServiceMsg.extraData.getBoolean("first");
          if (paramObject != null) {}
          for (bool1 = true;; bool1 = false)
          {
            a(8, bool1, new Object[] { Boolean.valueOf(bool2), paramObject });
            return;
          }
        }
        if ("NearbyGroup.ReqGetAreaList".equals(paramFromServiceMsg.getServiceCmd()))
        {
          bool2 = paramToServiceMsg.extraData.getBoolean("clickable");
          if (paramObject != null) {}
          for (bool1 = true;; bool1 = false)
          {
            a(12, bool1, new Object[] { Boolean.valueOf(bool2), paramObject });
            return;
          }
        }
        if ("NearbyGroup.ReqGetGroupInArea".equals(paramFromServiceMsg.getServiceCmd()))
        {
          if (paramObject != null) {}
          for (bool1 = true;; bool1 = false)
          {
            a(13, bool1, new Object[] { paramObject });
            return;
          }
        }
        int i1;
        if ("OidbSvc.0x568_20".equals(paramFromServiceMsg.getServiceCmd()))
        {
          int i2;
          long l1;
          if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
          {
            i2 = 1;
            l1 = paramToServiceMsg.extraData.getLong("key_troopuin", 0L);
            bool1 = paramToServiceMsg.extraData.getBoolean("key_show");
            i1 = i2;
            if (i2 == 0) {}
          }
          for (;;)
          {
            try
            {
              paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
              paramToServiceMsg.mergeFrom((byte[])paramObject);
              i1 = paramToServiceMsg.uint32_result.get();
              if (i1 != 0) {
                continue;
              }
              i1 = 1;
            }
            catch (Exception paramToServiceMsg)
            {
              i1 = 0;
              continue;
              a(14, false, null);
              return;
            }
            if (i1 == 0) {
              continue;
            }
            a(14, true, new Object[] { Long.valueOf(l1), Boolean.valueOf(bool1) });
            return;
            i2 = 0;
            break;
            i1 = 0;
          }
        }
        if ("NeighborSvc.ReqSetStateSwitch".equals(paramFromServiceMsg.getServiceCmd()))
        {
          bool1 = paramToServiceMsg.extraData.getBoolean("k_be_share", false);
          PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if ((paramObject == null) || (((RespSetStateSwitch)paramObject).stHeader.eReplyCode != 0))
          {
            bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o();
            bool2 = false;
          }
          for (;;)
          {
            a(9, bool2, Boolean.valueOf(bool1));
            return;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(bool1, true);
          }
        }
        if ("NeighborSvc.ReqGetSwitches".equals(paramFromServiceMsg.getServiceCmd()))
        {
          if ((paramObject != null) && (((RespGetSwitches)paramObject).stHeader.eReplyCode == 0))
          {
            paramToServiceMsg = ((RespGetSwitches)paramObject).switches;
            PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            paramToServiceMsg = paramToServiceMsg.iterator();
            if (paramToServiceMsg.hasNext())
            {
              paramFromServiceMsg = (Switch)paramToServiceMsg.next();
              if (paramFromServiceMsg.type != 64) {
                break label1299;
              }
              paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramFromServiceMsg.is_open != 1) {
                break label1293;
              }
              bool1 = true;
              paramObject.c(bool1, true);
              i1 = paramFromServiceMsg.type;
              if (paramFromServiceMsg.is_open != 1) {
                break label1339;
              }
            }
            for (bool1 = true;; bool1 = false)
            {
              a(10, true, new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool1) });
              break label1195;
              break;
              bool1 = false;
              break label1239;
              if (paramFromServiceMsg.type != 1) {
                break label1246;
              }
              paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramFromServiceMsg.is_open == 1) {}
              for (bool1 = true;; bool1 = false)
              {
                paramObject.b(bool1, true);
                break;
              }
            }
          }
          a(10, false, null);
          return;
        }
        if (!"NeighborSvc.ReqGetPoint".equals(paramFromServiceMsg.getServiceCmd())) {
          break label1550;
        }
        bool1 = paramToServiceMsg.extraData.getBoolean("req_street_view");
        bool2 = paramToServiceMsg.extraData.getBoolean("req_current_loc");
        if ((paramObject == null) || (!paramFromServiceMsg.isSuccess())) {
          break label1522;
        }
        paramToServiceMsg = ((RespGetPoint)paramObject).stUDLinfo;
        if (!bool1) {
          break;
        }
      } while ((paramToServiceMsg == null) || (paramToServiceMsg.SOSOUrl.length <= 0));
      a(11, true, paramToServiceMsg.SOSOUrl);
      return;
    } while (!bool2);
    label1195:
    label1239:
    label1246:
    if ((paramToServiceMsg.cityId != null) && (paramToServiceMsg.cityId.length == 16))
    {
      paramFromServiceMsg = ByteBuffer.wrap(paramToServiceMsg.cityId);
      paramToServiceMsg = new String[4];
      paramToServiceMsg[0] = ConditionSearchManager.a(paramFromServiceMsg.getInt());
      paramToServiceMsg[1] = ConditionSearchManager.a(paramFromServiceMsg.getInt());
      paramToServiceMsg[2] = ConditionSearchManager.a(paramFromServiceMsg.getInt());
      paramToServiceMsg[3] = "0";
    }
    for (;;)
    {
      label1293:
      label1299:
      label1339:
      a(18, true, paramToServiceMsg);
      return;
      label1522:
      if (bool1)
      {
        a(11, false, null);
        return;
      }
      if (!bool2) {
        break;
      }
      a(18, false, null);
      return;
      label1550:
      if ("LbsShareSvr.location".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          a(15, true, new Object[] { paramToServiceMsg, paramObject });
          return;
        }
        a(15, false, null);
        return;
      }
      if ("LbsShareSvr.nearby_shops".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          a(16, true, new Object[] { paramToServiceMsg, paramObject });
          return;
        }
        a(16, false, null);
        return;
      }
      if (!"LbsShareSvr.get_shops_by_ids".equals(paramFromServiceMsg.getServiceCmd())) {
        break;
      }
      if (paramObject != null)
      {
        a(17, true, new Object[] { paramToServiceMsg, paramObject });
        return;
      }
      a(17, false, null);
      return;
      paramToServiceMsg = null;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m()) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "NearbyGroup.ReqGetGroupInArea");
    localToServiceMsg.extraData.putString("areaName", paramString);
    localToServiceMsg.extraData.putInt("lat", paramInt1);
    localToServiceMsg.extraData.putInt("lon", paramInt2);
    localToServiceMsg.extraData.putInt("startIndex", paramInt3);
    localToServiceMsg.extraData.putInt("count", paramInt4);
    a(localToServiceMsg);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "LbsShareSvr.get_shops_by_ids");
    LBSShare.GetShopsByIdsReq localGetShopsByIdsReq = new LBSShare.GetShopsByIdsReq();
    localGetShopsByIdsReq.ids.set(paramArrayList);
    localToServiceMsg.putWupBuffer(localGetShopsByIdsReq.toByteArray());
    b(localToServiceMsg);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "setPeopleVisibleSwitch| visible = " + paramBoolean);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "NeighborSvc.ReqSetUserState");
    localToServiceMsg.extraData.putBoolean("k_visible_for_near_people", paramBoolean);
    a(localToServiceMsg);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "NearbyGroup.GetGroupList");
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putBoolean("first", paramBoolean);
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      localToServiceMsg.extraData.putInt("lat", paramInt1);
      localToServiceMsg.extraData.putInt("lon", paramInt2);
    }
    a(localToServiceMsg);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    short s2 = 0;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m()) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "NearbyGroup.GetGroupList");
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putBoolean("first", paramBoolean);
    if (!TextUtils.isEmpty(paramString)) {
      localToServiceMsg.extraData.putString("strGroupArea", paramString);
    }
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      localToServiceMsg.extraData.putInt("lat", paramInt1);
      localToServiceMsg.extraData.putInt("lon", paramInt2);
    }
    short s1 = s2;
    switch (paramInt3)
    {
    default: 
      s1 = s2;
    }
    for (;;)
    {
      localToServiceMsg.extraData.putShort("shSortType", s1);
      a(localToServiceMsg);
      return;
      s1 = 1;
      continue;
      s1 = 2;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "NeighborSvc.ReqGetPoint");
    if (paramBoolean1)
    {
      if ((paramInt1 != 0) && (paramInt2 != 0))
      {
        localToServiceMsg.extraData.putInt("lat", paramInt1);
        localToServiceMsg.extraData.putInt("lon", paramInt2);
      }
      localToServiceMsg.extraData.putBoolean("req_street_view", true);
    }
    for (;;)
    {
      a(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putBoolean("req_current_loc", true);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m()) {
      return;
    }
    ToServiceMsg localToServiceMsg = a("LBS.AddressService");
    localToServiceMsg.extraData.putByteArray("devicedata", paramArrayOfByte);
    localToServiceMsg.extraData.putString("account", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    a(localToServiceMsg);
  }
  
  public void b()
  {
    a(new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "NeighborSvc.ReqGetSwitches"));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(true, false, paramInt1, paramInt2);
  }
  
  public void b(boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "NeighborSvc.ReqSetStateSwitch");
    localToServiceMsg.extraData.putBoolean("k_be_share", paramBoolean);
    a(localToServiceMsg);
  }
  
  public void b(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "NeighborSvc.ReqGetNeighbors");
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putBoolean("first", paramBoolean);
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      localToServiceMsg.extraData.putInt("lat", paramInt1);
      localToServiceMsg.extraData.putInt("lon", paramInt2);
    }
    a(localToServiceMsg);
  }
  
  protected boolean c(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("LBS.AddressService");
      this.jdField_a_of_type_JavaUtilSet.add("NeighborSvc.ReqGetNeighbors");
      this.jdField_a_of_type_JavaUtilSet.add("NeighborSvc.ReqSetUserState");
      this.jdField_a_of_type_JavaUtilSet.add("EncounterSvc.ReqGetEncounter");
      this.jdField_a_of_type_JavaUtilSet.add("QzoneService.knrsNew");
      this.jdField_a_of_type_JavaUtilSet.add("NearbyGroup.GetGroupList");
      this.jdField_a_of_type_JavaUtilSet.add("NeighborSvc.ReqSetStateSwitch");
      this.jdField_a_of_type_JavaUtilSet.add("NeighborSvc.ReqGetSwitches");
      this.jdField_a_of_type_JavaUtilSet.add("NeighborSvc.ReqGetPoint");
      this.jdField_a_of_type_JavaUtilSet.add("NearbyGroup.ReqGetAreaList");
      this.jdField_a_of_type_JavaUtilSet.add("NearbyGroup.ReqGetGroupInArea");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x568_20");
      this.jdField_a_of_type_JavaUtilSet.add("LbsShareSvr.location");
      this.jdField_a_of_type_JavaUtilSet.add("LbsShareSvr.nearby_shops");
      this.jdField_a_of_type_JavaUtilSet.add("LbsShareSvr.get_shops_by_ids");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void d()
  {
    a(false, true, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.LBSHandler
 * JD-Core Version:    0.7.0.1
 */