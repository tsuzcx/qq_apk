package com.tencent.mobileqq.app;

import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RespGetEncounterV2;
import LBSAddrProtocol.RspGetPositionApi;
import NeighborSvc.RespGetNeighbors;
import NeighborSvc.RespGetPoint;
import NeighborSvc.RespGetSwitches;
import NeighborSvc.RespSetStateSwitch;
import NeighborSvc.Switch;
import NeighborSvc.UserDetailLocalInfo;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import appoint.define.appoint_define.Cell;
import appoint.define.appoint_define.GPS;
import appoint.define.appoint_define.LBSInfo;
import appoint.define.appoint_define.Wifi;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.NearbyRecommendTroop;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsReq;
import com.tencent.proto.lbsshare.LBSShare.LocationReq;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsReq;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.fanpaizi.FanPaiZi.BusiReqHead;
import tencent.im.fanpaizi.FanPaiZi.ReqDislike;
import tencent.im.fanpaizi.FanPaiZi.ReqGetList;
import tencent.im.fanpaizi.FanPaiZi.ReqPrise;
import tencent.im.fanpaizi.FanPaiZi.RespDislike;
import tencent.im.fanpaizi.FanPaiZi.RespGetList;
import tencent.im.fanpaizi.FanPaiZi.RespPrise;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.GroupInfo;
import tencent.sso.roam.Roam.RoamQualifyReq;
import tencent.sso.roam.Roam.RoamQualifyRsp;
import tencent.sso.roam.Roam.RoamReqHead;

public class LBSHandler
  extends BusinessHandler
{
  public static int A = 0;
  public static final int a = 1;
  public static final String a = "LBSHandler";
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
  public static final int s = 19;
  public static final int t = 20;
  public static final int u = 21;
  public static final int v = 22;
  public static final int w = 23;
  public static final int x = -11;
  public static final int y = -111;
  public static final int z = -1111;
  
  LBSHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static Dialog a(Activity paramActivity, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = DialogUtil.a(paramActivity, 230, null, paramString, 2131362794, 2131363080, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131296925)).setVisibility(8);
      paramOnClickListener1 = (TextView)paramString.findViewById(2131296470);
      paramOnClickListener2 = new LinearLayout.LayoutParams(-2, -2);
      paramOnClickListener2.gravity = 17;
      paramOnClickListener1.setLayoutParams(paramOnClickListener2);
      paramOnClickListener1.setMinHeight(Utils.a(paramActivity, 35.0F));
      paramOnClickListener1.setGravity(17);
    }
    return paramString;
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
    if (paramObject != null)
    {
      paramObject = (Object[])paramObject;
      NeighborComm.RespHeader localRespHeader = (NeighborComm.RespHeader)paramObject[0];
      RespGetEncounterV2 localRespGetEncounterV2 = (RespGetEncounterV2)paramObject[1];
      if ((localRespGetEncounterV2 != null) && (localRespHeader != null) && (localRespHeader.eReplyCode == 0))
      {
        Object localObject = new StringBuilder().append("CMD_GET_ENCOUNTER size:");
        EntityManager localEntityManager;
        if (localRespGetEncounterV2.vEncounterInfos == null)
        {
          paramObject = null;
          ReportLog.a("LBS", paramObject);
          paramFromServiceMsg.setMsgSuccess();
          paramFromServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
          localObject = localRespGetEncounterV2.vEncounterInfos;
          if (localObject == null) {
            break label495;
          }
          paramObject = ((ArrayList)localObject).iterator();
          RespEncounterInfo localRespEncounterInfo;
          while (paramObject.hasNext())
          {
            localRespEncounterInfo = (RespEncounterInfo)paramObject.next();
            if (String.valueOf(localRespEncounterInfo.lEctID).equals(paramToServiceMsg.getUin())) {
              paramFromServiceMsg.a(paramToServiceMsg.getUin(), localRespEncounterInfo.vIntroContent, localRespEncounterInfo.shIntroType);
            }
          }
          if (((ArrayList)localObject).size() > 0)
          {
            localRespEncounterInfo = (RespEncounterInfo)((ArrayList)localObject).get(0);
            if ((localRespEncounterInfo != null) && (localRespEncounterInfo.lEctID > 0L) && (String.valueOf(localRespEncounterInfo.lEctID).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
            {
              localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
              if (localEntityManager != null)
              {
                paramObject = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() });
                paramFromServiceMsg = paramObject;
                if (paramObject == null)
                {
                  paramFromServiceMsg = paramObject;
                  if (localRespEncounterInfo.tiny_id > 0L) {
                    paramFromServiceMsg = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "tinyId=?", new String[] { String.valueOf(localRespEncounterInfo.tiny_id) });
                  }
                }
                paramObject = paramFromServiceMsg;
                if (paramFromServiceMsg == null) {
                  paramObject = new NearbyPeopleCard();
                }
                if (localRespEncounterInfo.tiny_id > 0L)
                {
                  paramObject.tinyId = localRespEncounterInfo.tiny_id;
                  paramObject.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                  if (paramObject.getStatus() != 1000) {
                    break label465;
                  }
                  localEntityManager.b(paramObject);
                }
              }
            }
          }
        }
        for (;;)
        {
          localEntityManager.a();
          if (QLog.isColorLevel()) {
            QLog.d("LBSHandler", 2, "handleGetEncounter isSuccess=true,list size=" + ((ArrayList)localObject).size());
          }
          a(5, true, new Object[] { localRespHeader, localRespGetEncounterV2, paramToServiceMsg });
          return;
          paramObject = Integer.valueOf(localRespGetEncounterV2.vEncounterInfos.size());
          break;
          label465:
          if ((paramObject.getStatus() == 1001) || (paramObject.getStatus() == 1002)) {
            localEntityManager.a(paramObject);
          }
        }
      }
      label495:
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder().append("handleGetEncounter eReplyCode=");
        if (localRespHeader == null) {
          break label568;
        }
      }
      label568:
      for (paramFromServiceMsg = Integer.valueOf(localRespHeader.eReplyCode);; paramFromServiceMsg = "null")
      {
        QLog.d("LBSHandler", 2, paramFromServiceMsg);
        a(5, false, new Object[] { localRespHeader, localRespGetEncounterV2, paramToServiceMsg });
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LBSHandler", 2, "handleGetEncounter isSuccess=false, data is null");
    }
    a(5, false, new Object[] { null, null, paramToServiceMsg });
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return true;
    }
    return paramQQAppInterface.a().a(paramString, 1001).hasReply;
  }
  
  public long a(int paramInt1, boolean paramBoolean, long[] paramArrayOfLong, GeoPoint paramGeoPoint1, int paramInt2, byte paramByte1, int paramInt3, byte paramByte2, byte paramByte3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, GeoPoint paramGeoPoint2)
  {
    long l1 = System.currentTimeMillis();
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "EncounterSvc.ReqGetEncounter");
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putInt("gender", paramInt1);
    localToServiceMsg.extraData.putBoolean("first", paramBoolean);
    localToServiceMsg.extraData.putLongArray("tags", paramArrayOfLong);
    localToServiceMsg.extraData.putInt("roamMode", paramInt2);
    localToServiceMsg.extraData.putByte("constellation", paramByte1);
    localToServiceMsg.extraData.putInt("timeInterval", paramInt3);
    localToServiceMsg.extraData.putByte("ageLow", paramByte2);
    localToServiceMsg.extraData.putByte("ageUp", paramByte3);
    localToServiceMsg.extraData.putLong("requestId", l1);
    localToServiceMsg.extraData.putInt("careerID", paramInt4);
    localToServiceMsg.extraData.putInt("hometownCountry", paramInt5);
    localToServiceMsg.extraData.putInt("hometownProvince", paramInt6);
    localToServiceMsg.extraData.putInt("hometownCity", paramInt7);
    if (paramGeoPoint1 != null)
    {
      paramInt1 = paramGeoPoint1.getLatitudeE6();
      paramInt2 = paramGeoPoint1.getLongitudeE6();
      if ((paramInt1 != 0) && (paramInt2 != 0))
      {
        localToServiceMsg.extraData.putInt("lat", paramInt1);
        localToServiceMsg.extraData.putInt("lon", paramInt2);
      }
    }
    if (paramGeoPoint2 != null)
    {
      paramInt1 = paramGeoPoint2.getLatitudeE6();
      paramInt2 = paramGeoPoint2.getLongitudeE6();
      if ((paramInt1 != 0) && (paramInt2 != 0))
      {
        localToServiceMsg.extraData.putInt("localLat", paramInt1);
        localToServiceMsg.extraData.putInt("localLon", paramInt2);
      }
    }
    a(localToServiceMsg);
    return l1;
  }
  
  public appoint_define.LBSInfo a()
  {
    appoint_define.LBSInfo localLBSInfo = null;
    SosoInterface.SosoLbsInfo localSosoLbsInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((localSosoLbsInfo == null) || (localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null) || (localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Int == 0) || (localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localSosoLbsInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
    for (;;)
    {
      if (localSosoLbsInfo != null)
      {
        localLBSInfo = new appoint_define.LBSInfo();
        Object localObject1;
        Object localObject2;
        Object localObject3;
        if (localSosoLbsInfo.b != null)
        {
          localObject1 = localSosoLbsInfo.b.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SosoInterface.SosoWifi)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              localObject3 = new appoint_define.Wifi();
              ((appoint_define.Wifi)localObject3).uint64_mac.set(((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Long);
              ((appoint_define.Wifi)localObject3).int32_rssi.set(((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Int);
              localLBSInfo.rpt_msg_wifis.add((MessageMicro)localObject3);
            }
          }
        }
        if (localSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList != null)
        {
          localObject1 = localSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SosoInterface.SosoCell)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              localObject3 = new appoint_define.Cell();
              ((appoint_define.Cell)localObject3).int32_cellid.set(((SosoInterface.SosoCell)localObject2).d);
              ((appoint_define.Cell)localObject3).int32_lac.set(((SosoInterface.SosoCell)localObject2).c);
              ((appoint_define.Cell)localObject3).int32_rssi.set(((SosoInterface.SosoCell)localObject2).e);
              ((appoint_define.Cell)localObject3).int32_mcc.set(((SosoInterface.SosoCell)localObject2).jdField_a_of_type_Int);
              ((appoint_define.Cell)localObject3).int32_mnc.set(((SosoInterface.SosoCell)localObject2).b);
              localLBSInfo.rpt_msg_cells.add((MessageMicro)localObject3);
            }
          }
        }
        if (localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null)
        {
          localObject1 = new appoint_define.GPS();
          ((appoint_define.GPS)localObject1).int32_lon.set(localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b);
          ((appoint_define.GPS)localObject1).int32_lat.set(localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Int);
          ((appoint_define.GPS)localObject1).int32_type.set(-1);
          ((appoint_define.GPS)localObject1).int32_type.set(0);
          localLBSInfo.msg_gps.set((MessageMicro)localObject1);
        }
      }
      return localLBSInfo;
    }
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
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "NearbyGroup.ReqGetAreaList");
    localToServiceMsg.extraData.putInt("lat", paramInt1);
    localToServiceMsg.extraData.putInt("lon", paramInt2);
    localToServiceMsg.extraData.putInt("radius", paramInt3);
    localToServiceMsg.extraData.putBoolean("clickable", paramBoolean);
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
    Object localObject;
    label291:
    label310:
    boolean bool1;
    label578:
    label1259:
    label1265:
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
        if ("NeighborSvc.ReqGetNeighbors".equals(paramFromServiceMsg.getServiceCmd()))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder().append("cmd = ").append(paramFromServiceMsg.getServiceCmd());
            if (paramObject != null)
            {
              localObject = " has data";
              QLog.d("svenxu", 2, (String)localObject);
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
            localObject = " has no data";
            break;
            if (A != 0) {
              a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, A);
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
            bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o();
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
              localObject = " has data";
              QLog.d("LBSHandler", 2, (String)localObject);
            }
          }
          else if (paramObject == null)
          {
            if ((paramFromServiceMsg == null) || (paramFromServiceMsg.isSuccess())) {
              break label578;
            }
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -111);
          }
          for (;;)
          {
            a(paramFromServiceMsg, paramToServiceMsg, paramObject);
            return;
            localObject = " has no data";
            break;
            if (A != 0) {
              a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, A);
            }
          }
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
            bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.p();
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
                break label1265;
              }
              paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramFromServiceMsg.is_open != 1) {
                break label1259;
              }
              bool1 = true;
              paramObject.c(bool1, true);
              i1 = paramFromServiceMsg.type;
              if (paramFromServiceMsg.is_open != 1) {
                break label1305;
              }
            }
            for (bool1 = true;; bool1 = false)
            {
              a(10, true, new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool1) });
              break label1161;
              break;
              bool1 = false;
              break label1205;
              if (paramFromServiceMsg.type != 1) {
                break label1212;
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
          break label1625;
        }
        bool1 = paramToServiceMsg.extraData.getBoolean("req_street_view");
        bool2 = paramToServiceMsg.extraData.getBoolean("req_current_loc");
        if ((paramObject == null) || (!paramFromServiceMsg.isSuccess())) {
          break label1597;
        }
        paramFromServiceMsg = (RespGetPoint)paramObject;
        paramObject = paramFromServiceMsg.stUDLinfo;
        if (!bool1) {
          break;
        }
      } while ((paramObject == null) || (paramObject.SOSOUrl.length <= 0));
      a(11, true, paramObject.SOSOUrl);
      return;
    } while (!bool2);
    label1161:
    label1205:
    label1212:
    if ((paramObject.cityId != null) && (paramObject.cityId.length == 16))
    {
      localObject = ByteBuffer.wrap(paramObject.cityId);
      paramToServiceMsg = new String[4];
      paramToServiceMsg[0] = ConditionSearchManager.a(((ByteBuffer)localObject).getInt());
      paramToServiceMsg[1] = ConditionSearchManager.a(((ByteBuffer)localObject).getInt());
      paramToServiceMsg[2] = ConditionSearchManager.a(((ByteBuffer)localObject).getInt());
      paramToServiceMsg[3] = "0";
    }
    for (;;)
    {
      label1305:
      a(18, true, new Object[] { "", paramObject.strProvince, paramObject.strCity, paramObject.strDistrict, paramObject.strTown, "", paramObject.strRoad, "", Integer.valueOf(paramFromServiceMsg.stGps.iLat), Integer.valueOf(paramFromServiceMsg.stGps.iLon), Integer.valueOf(paramFromServiceMsg.stGps.iAlt), paramToServiceMsg });
      return;
      label1597:
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
      label1625:
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
      if ("LbsShareSvr.get_shops_by_ids".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          a(17, true, new Object[] { paramToServiceMsg, paramObject });
          return;
        }
        a(17, false, null);
        return;
      }
      if ("FanpaiziSvc.ReqGetList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          paramToServiceMsg = new FanPaiZi.RespGetList();
          try
          {
            paramToServiceMsg.mergeFrom((byte[])paramObject);
            a(20, true, new Object[] { paramToServiceMsg });
            return;
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg)
          {
            if (QLog.isColorLevel()) {
              QLog.e("RespGetTurnBrandUserList", 2, "error: " + paramToServiceMsg.getMessage());
            }
            paramToServiceMsg.printStackTrace();
            return;
          }
        }
        a(20, false, null);
        return;
      }
      if ("FanpaiziSvc.Prise".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          paramToServiceMsg = new FanPaiZi.RespPrise();
          try
          {
            paramToServiceMsg.mergeFrom((byte[])paramObject);
            a(21, true, new Object[] { paramToServiceMsg });
            return;
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg)
          {
            if (QLog.isColorLevel()) {
              QLog.e("respRespPrise", 2, "error: " + paramToServiceMsg.getMessage());
            }
            paramToServiceMsg.printStackTrace();
            return;
          }
        }
        a(21, false, null);
        return;
      }
      if ("FanpaiziSvc.Dislike".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          paramToServiceMsg = new FanPaiZi.RespDislike();
          try
          {
            paramToServiceMsg.mergeFrom((byte[])paramObject);
            a(22, true, new Object[] { paramToServiceMsg });
            return;
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg)
          {
            if (QLog.isColorLevel()) {
              QLog.e("respRespDislike", 2, "error: " + paramToServiceMsg.getMessage());
            }
            paramToServiceMsg.printStackTrace();
            return;
          }
        }
        a(22, false, null);
        return;
      }
      if (!"RoamClientSvr.GetQualify".equals(paramFromServiceMsg.getServiceCmd())) {
        break;
      }
      bool1 = paramFromServiceMsg.isSuccess();
      if ((bool1) && (paramObject != null))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder().append("handleGetRoamQualify isSuccess=").append(bool1).append(",data is ");
        if (paramObject == null) {
          break label2173;
        }
      }
      label2173:
      for (paramToServiceMsg = "not null";; paramToServiceMsg = "null")
      {
        QLog.d("LBSHandler", 2, paramToServiceMsg);
        a(23, false, null);
        return;
      }
      paramToServiceMsg = null;
    }
  }
  
  public void a(String paramString)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "FanpaiziSvc.ReqGetList");
    FanPaiZi.ReqGetList localReqGetList = new FanPaiZi.ReqGetList();
    localReqGetList.setHasFlag(true);
    Object localObject = new FanPaiZi.BusiReqHead();
    ((FanPaiZi.BusiReqHead)localObject).setHasFlag(true);
    ((FanPaiZi.BusiReqHead)localObject).int32_version.set(1);
    ((FanPaiZi.BusiReqHead)localObject).int32_seq.set(0);
    localReqGetList.msg_head.set((MessageMicro)localObject);
    appoint_define.LBSInfo localLBSInfo = a();
    localObject = localLBSInfo;
    if (localLBSInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("getLbsTurnBrandUserList", 2, "lbsInfo is null");
      }
      localObject = new appoint_define.LBSInfo();
    }
    localReqGetList.msg_lbs_info.set((MessageMicro)localObject);
    localReqGetList.bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramString));
    localToServiceMsg.putWupBuffer(localReqGetList.toByteArray());
    b(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
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
  
  public void a(List paramList)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "FanpaiziSvc.Dislike");
    FanPaiZi.ReqDislike localReqDislike = new FanPaiZi.ReqDislike();
    localReqDislike.setHasFlag(true);
    FanPaiZi.BusiReqHead localBusiReqHead = new FanPaiZi.BusiReqHead();
    localBusiReqHead.setHasFlag(true);
    localBusiReqHead.int32_version.set(1);
    localBusiReqHead.int32_seq.set(0);
    localReqDislike.msg_head.set(localBusiReqHead);
    localReqDislike.rpt_uint64_peer_tinyid.set(paramList);
    localToServiceMsg.putWupBuffer(localReqDislike.toByteArray());
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
      a(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putBoolean("req_current_loc", true);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
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
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSHandler", 2, "handleGetRoamQualify");
    }
    try
    {
      paramToServiceMsg = (Roam.RoamQualifyRsp)new Roam.RoamQualifyRsp().mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.head != null))
      {
        a(23, true, paramToServiceMsg.head);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "handleGetRoamQualify RoamQualifyRsp.head error");
      }
      a(23, false, null);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "handleGetRoamQualify exception msg=" + paramToServiceMsg.getMessage());
      }
      paramToServiceMsg.printStackTrace();
      a(23, false, null);
    }
  }
  
  public void b(String paramString)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "FanpaiziSvc.Prise");
    FanPaiZi.ReqPrise localReqPrise = new FanPaiZi.ReqPrise();
    localReqPrise.setHasFlag(true);
    FanPaiZi.BusiReqHead localBusiReqHead = new FanPaiZi.BusiReqHead();
    localBusiReqHead.setHasFlag(true);
    localBusiReqHead.int32_version.set(1);
    localBusiReqHead.int32_seq.set(0);
    localReqPrise.msg_head.set(localBusiReqHead);
    localReqPrise.uint64_peer_tinyid.set(Long.parseLong(paramString));
    localToServiceMsg.putWupBuffer(localReqPrise.toByteArray());
    b(localToServiceMsg);
  }
  
  public void b(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      a(19, false, Integer.valueOf(0));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("nearbyTroopPush", 2, "handleNearbyRecommendTroopPush:" + paramList.size());
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.a();
    localEntityTransaction.a();
    int i1 = 0;
    try
    {
      while (i1 < paramList.size())
      {
        submsgtype0x67.GroupInfo localGroupInfo = (submsgtype0x67.GroupInfo)paramList.get(i1);
        NearbyRecommendTroop localNearbyRecommendTroop = new NearbyRecommendTroop();
        localNearbyRecommendTroop.uin = (localGroupInfo.uint64_group_code.get() + "");
        localNearbyRecommendTroop.name = localGroupInfo.str_group_name.get();
        localNearbyRecommendTroop.intro = localGroupInfo.str_group_memo.get();
        localNearbyRecommendTroop.memberNum = localGroupInfo.uint32_member_num.get();
        localNearbyRecommendTroop.troopType = localGroupInfo.uint32_group_type.get();
        localNearbyRecommendTroop.isRead = false;
        localEntityManager.b(localNearbyRecommendTroop);
        i1 += 1;
      }
      localEntityTransaction.c();
      a(19, true, Integer.valueOf(paramList.size()));
      return;
    }
    catch (Exception paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("recommendTroopPush", 2, "handleNearbyRecommendTroopPush exception" + paramList.toString());
      }
      return;
    }
    finally
    {
      localEntityTransaction.b();
    }
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
  
  public void c()
  {
    a(false, true, 0, 0);
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
      this.jdField_a_of_type_JavaUtilSet.add("FanpaiziSvc.ReqGetList");
      this.jdField_a_of_type_JavaUtilSet.add("FanpaiziSvc.Prise");
      this.jdField_a_of_type_JavaUtilSet.add("FanpaiziSvc.Dislike");
      this.jdField_a_of_type_JavaUtilSet.add("RoamClientSvr.GetQualify");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void e()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", str, "RoamClientSvr.GetQualify");
    Roam.RoamReqHead localRoamReqHead = new Roam.RoamReqHead();
    localRoamReqHead.protocol_ver.set(1);
    localRoamReqHead.client_plat_id.set(109);
    localRoamReqHead.client_ver.set("3.4.0");
    localRoamReqHead.os_ver.set(Build.VERSION.RELEASE);
    Object localObject = localRoamReqHead.uin;
    if (TextUtils.isDigitsOnly(str)) {}
    for (long l1 = Long.parseLong(str);; l1 = 0L)
    {
      ((PBUInt64Field)localObject).set(l1);
      localObject = new Roam.RoamQualifyReq();
      ((Roam.RoamQualifyReq)localObject).head.set(localRoamReqHead);
      localToServiceMsg.putWupBuffer(((Roam.RoamQualifyReq)localObject).toByteArray());
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "getRoamQualify client_ver=3.4.0,os_ver=" + Build.VERSION.RELEASE + ",uin=" + str);
      }
      b(localToServiceMsg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.LBSHandler
 * JD-Core Version:    0.7.0.1
 */