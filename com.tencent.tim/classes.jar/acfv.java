import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HotChatHandler.2;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x62c.oidb_cmd0x62c.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.cmd0x897.cmd0x897.RspBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.ReqBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.RspBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.ExitPublicGroupReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.KickPublicGroupVisitorReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.ReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.RspBody;
import tencent.im.oidb.cmd0x8a7.cmd0x8a7.RspBody;
import tencent.im.oidb.cmd0x8b2.oidb_0x8b2.ReqBody;
import tencent.im.oidb.cmd0x8b2.oidb_0x8b2.RspBody;
import tencent.im.oidb.cmd0x8b3.oidb_0x8b3.ReqBody;
import tencent.im.oidb.cmd0x8b3.oidb_0x8b3.groupinfo;
import tencent.im.oidb.cmd0xa81.oidb_0xa81.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;
import tencent.im.oidb.hotchat.CreateHotChat.ReqBody;
import tencent.im.oidb.hotchat.CreateHotChat.RspBody;
import tencent.im.oidb.hotchat.GetJoinedHotChatList.ReqBody;
import tencent.im.oidb.hotchat.GetJoinedHotChatList.RspBody;
import tencent.im.oidb.hotchat.LBS.Attribute;
import tencent.im.oidb.hotchat.LBS.Cell;
import tencent.im.oidb.hotchat.LBS.GPS;
import tencent.im.oidb.hotchat.LBS.LBSInfo;
import tencent.im.oidb.hotchat.LBS.Wifi;
import tencent.im.oidb.hotchat.oidb_0x81f.GetAuthDataReq;
import tencent.im.oidb.hotchat.oidb_0x81f.ReqBody;
import tencent.im.oidb.hotchat.oidb_0x823.KickPublicGroupVisitorReqBody;
import tencent.im.oidb.hotchat.oidb_0x823.KickPublicGroupVisitorRspBody;
import tencent.im.oidb.hotchat.oidb_0x823.PlayerDeviceInfo;
import tencent.im.oidb.hotchat.oidb_0x823.ReqBody;
import tencent.im.oidb.hotchat.oidb_0x823.RspBody;
import tencent.im.oidb.hotchat.oidb_0x8ab.ReqBody;
import tencent.im.oidb.hotchat.oidb_0x8ab.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class acfv
  extends accg
{
  public static final String bol = acfp.m(2131707211);
  public static final String bom = acfp.m(2131707220);
  public static final String bon = acfp.m(2131707219);
  private volatile boolean bHH;
  
  public acfv(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void O(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleExtHotChatRespErrorOrTimeOut()");
    }
    paramFromServiceMsg = bol;
    notifyUI(1033, false, new Object[] { paramToServiceMsg.extraData.getString("troopUin"), paramFromServiceMsg });
  }
  
  private void P(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (HotChatInfo)paramToServiceMsg.extraData.get("HOT_CHAT_INFO");
    notifyUI(1032, false, new Object[] { paramToServiceMsg.troopUin, acfp.m(2131707223), paramToServiceMsg.name });
  }
  
  private void Q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    System.out.println("-----> handleQuickJoinHotChatErrorOrTimeOut");
  }
  
  private void R(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("uid");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1035, false, new Object[] { paramToServiceMsg, Integer.valueOf(i), "" });
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleSetHotChatAnnounceTimeOutOrError,result= " + i + ",uid=" + paramToServiceMsg);
    }
  }
  
  private void S(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("uid");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("troop_uin");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1036, false, new Object[] { paramToServiceMsg, arrayOfByte, Integer.valueOf(i), "", "", null });
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, "handleGetHotChatAnnounceTimeOutOrError,result= " + i + ",uid=" + arrayOfByte);
    }
  }
  
  private void T(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("groupcode");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1039, false, new Object[] { paramToServiceMsg, Integer.valueOf(i), "", Long.valueOf(0L) });
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleGetUserCreateHotChatAnnounceTimeOutOrError,result= " + i + ",groupcode=" + paramToServiceMsg);
    }
  }
  
  private void U(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("groupcode");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1040, false, new Object[] { paramToServiceMsg, Integer.valueOf(i), "" });
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleSetUserCreateHotChatAnnounce,result= " + i + ",groupcode=" + paramToServiceMsg);
    }
  }
  
  private void V(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.extraData.getString("groupuin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("memberuin");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1037, false, new Object[] { str, Integer.valueOf(i), paramToServiceMsg, null });
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleKickHotChatMemberErrorOrTimeout,result= " + i + ",groupuin=" + str + ",memberUin=" + paramToServiceMsg);
    }
  }
  
  private void W(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.extraData.getString("groupuin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("groupcode");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1038, false, new Object[] { str, Integer.valueOf(i), paramToServiceMsg });
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleDismissHotChatTimeOutOrError,result= " + i + ",groupuin=" + str + ",groupcode=" + paramToServiceMsg);
    }
  }
  
  public static LBS.LBSInfo a(boolean paramBoolean)
  {
    LBS.LBSInfo localLBSInfo = new LBS.LBSInfo();
    SosoInterface.aj(3600000L, acfv.class.getSimpleName());
    Object localObject1 = SosoInterface.b();
    if ((localObject1 == null) || (((SosoInterface.SosoLbsInfo)localObject1).a == null)) {
      return null;
    }
    Object localObject2 = new LBS.GPS();
    ((LBS.GPS)localObject2).latitude.set((int)(((SosoInterface.SosoLbsInfo)localObject1).a.cf * 1000000.0D));
    ((LBS.GPS)localObject2).longitude.set((int)(((SosoInterface.SosoLbsInfo)localObject1).a.cg * 1000000.0D));
    ((LBS.GPS)localObject2).altitude.set(-1);
    ((LBS.GPS)localObject2).coordinate.set(0);
    localLBSInfo.gps.set((MessageMicro)localObject2);
    Object localObject3;
    if (((SosoInterface.SosoLbsInfo)localObject1).tZ != null)
    {
      localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).tZ.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SosoInterface.SosoWifi)((Iterator)localObject2).next();
        LBS.Wifi localWifi = new LBS.Wifi();
        localWifi.mac.set(((SosoInterface.SosoWifi)localObject3).RK);
        localWifi.rssi.set(((SosoInterface.SosoWifi)localObject3).mRssi);
        localLBSInfo.rpt_wifi.add(localWifi);
      }
    }
    if (((SosoInterface.SosoLbsInfo)localObject1).mCells != null)
    {
      localObject1 = ((SosoInterface.SosoLbsInfo)localObject1).mCells.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SosoInterface.SosoCell)((Iterator)localObject1).next();
        localObject3 = new LBS.Cell();
        ((LBS.Cell)localObject3).mcc.set(((SosoInterface.SosoCell)localObject2).cAI);
        ((LBS.Cell)localObject3).mnc.set(((SosoInterface.SosoCell)localObject2).cAJ);
        ((LBS.Cell)localObject3).lac.set(((SosoInterface.SosoCell)localObject2).cAK);
        ((LBS.Cell)localObject3).cellid.set(((SosoInterface.SosoCell)localObject2).cAL);
        ((LBS.Cell)localObject3).rssi.set(((SosoInterface.SosoCell)localObject2).cAM);
        localLBSInfo.rpt_cell.add((MessageMicro)localObject3);
      }
    }
    localObject1 = new LBS.Attribute();
    localObject2 = aqgz.getIMEI();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((LBS.Attribute)localObject1).imei.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
    }
    localObject2 = aqgz.getIMSI();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((LBS.Attribute)localObject1).imsi.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
    }
    localLBSInfo.attribute.set((MessageMicro)localObject1);
    return localLBSInfo;
  }
  
  public static LBS.Wifi a()
  {
    Object localObject1 = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    if (!((WifiManager)localObject1).isWifiEnabled()) {
      return null;
    }
    Object localObject2 = alkz.a((WifiManager)localObject1);
    localObject1 = HotChatManager.a((WifiInfo)localObject2);
    long l = SosoInterface.SosoWifi.ag(((WifiInfo)localObject2).getBSSID());
    int i = ((WifiInfo)localObject2).getRssi();
    localObject2 = new LBS.Wifi();
    ((LBS.Wifi)localObject2).rssi.set(i);
    ((LBS.Wifi)localObject2).essid.set(ByteStringMicro.copyFrom(((String)localObject1).getBytes()));
    ((LBS.Wifi)localObject2).mac.set(l);
    return localObject2;
  }
  
  private void a(Common.WifiPOIInfo paramWifiPOIInfo, boolean paramBoolean, int paramInt)
  {
    int i = 2;
    int j = 0;
    if (QLog.isColorLevel()) {
      ajrk.m("HotChatHandler", new Object[] { "createHotChat", Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramWifiPOIInfo });
    }
    if (paramWifiPOIInfo == null) {
      return;
    }
    Object localObject = paramWifiPOIInfo.uint32_wifi_poi_type;
    if (paramBoolean) {
      i = 1;
    }
    ((PBUInt32Field)localObject).set(i);
    localObject = HotChatInfo.createHotChat(paramWifiPOIInfo, paramBoolean, paramInt);
    CreateHotChat.ReqBody localReqBody = new CreateHotChat.ReqBody();
    localReqBody.create_req_info.setHasFlag(true);
    localReqBody.create_req_info.set(paramWifiPOIInfo);
    paramInt = j;
    if (paramBoolean)
    {
      paramWifiPOIInfo = a(true);
      if (paramWifiPOIInfo != null) {
        localReqBody.lbs_info.set(paramWifiPOIInfo);
      }
      paramInt = 1;
    }
    paramWifiPOIInfo = makeOIDBPkg("OidbSvc.0x8a2", 2210, paramInt, localReqBody.toByteArray(), 10000L);
    paramWifiPOIInfo.extraData.putSerializable("HOT_CHAT_INFO", (Serializable)localObject);
    sendPbReq(paramWifiPOIInfo);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    this.bHH = false;
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleGetMyHostChatListRespError timeOut: " + paramBoolean);
    }
    notifyUI(1031, false, null);
    if (paramBoolean) {
      ((HotChatManager)this.app.getManager(60)).aj(null, false);
    }
  }
  
  private void eB(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("uid");
    String str = paramToServiceMsg.extraData.getString("troop_uin");
    ArrayList localArrayList = paramToServiceMsg.extraData.getStringArrayList("uins");
    int k = paramToServiceMsg.extraData.getInt("serviceType");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      try
      {
        label91:
        label222:
        do
        {
          paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          paramToServiceMsg = (HotChatManager)this.app.getManager(60);
          paramFromServiceMsg = paramToServiceMsg.a(str);
          if (paramFromServiceMsg == null) {
            break label304;
          }
          if ((localArrayList == null) || (localArrayList.size() <= 0)) {
            break label299;
          }
          j = 0;
          for (;;)
          {
            if (j >= localArrayList.size()) {
              break label299;
            }
            paramObject = (String)localArrayList.get(j);
            if ((k != 5) || (paramFromServiceMsg.adminUins.contains(paramObject))) {
              break;
            }
            paramFromServiceMsg.adminUins.add(paramObject);
            j += 1;
          }
          paramObject = paramObject;
          paramToServiceMsg = null;
          paramFromServiceMsg = paramToServiceMsg;
        } while (!QLog.isColorLevel());
        QLog.i("HotChatHandler", 2, paramObject.toString());
        paramFromServiceMsg = paramToServiceMsg;
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
            continue;
            if ((k == 6) && (paramFromServiceMsg.adminUins.contains(paramObject))) {
              paramFromServiceMsg.adminUins.remove(paramObject);
            }
          }
        }
        label299:
        paramToServiceMsg.updateHotChatInfo(paramFromServiceMsg);
        label304:
        notifyUI(1050, true, new Object[] { str, arrayOfByte, Integer.valueOf(i), Integer.valueOf(k), localArrayList });
      }
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandlerQ.hotchat.setadmin", 2, "handleSetHotChatAdminFlag==>,operaUins=" + localArrayList);
      }
      return;
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = paramToServiceMsg;
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
        break label432;
      }
      i = paramFromServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      break label222;
      i = -1;
      break label91;
    }
    if (i == 0) {
      paramToServiceMsg = new oidb_0x8b2.RspBody();
    }
    for (;;)
    {
      int j;
      notifyUI(1050, false, new Object[] { str, arrayOfByte, Integer.valueOf(i), Integer.valueOf(k), localArrayList });
    }
  }
  
  private void eC(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.hotchat.remainCount", 2, "req == null || res == null");
      }
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = str;
    arrayOfObject[1] = Boolean.valueOf(false);
    arrayOfObject[2] = "";
    arrayOfObject[3] = "";
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.hotchat.remainCount", 2, "time out or error");
      }
      notifyUI(1053, false, arrayOfObject);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(1053, false, arrayOfObject);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        notifyUI(1053, false, arrayOfObject);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      notifyUI(1053, false, arrayOfObject);
      return;
    }
    paramObject = new cmd0x8a7.RspBody();
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        boolean bool = paramObject.bool_can_at_all.get();
        if (!paramObject.bytes_prompt_msg_1.has()) {
          break label480;
        }
        paramToServiceMsg = paramObject.bytes_prompt_msg_1.get().toStringUtf8();
        if (!paramObject.bytes_prompt_msg_2.has()) {
          break label474;
        }
        paramFromServiceMsg = paramObject.bytes_prompt_msg_2.get().toStringUtf8();
        if (!paramObject.uint32_remain_at_all_count_for_group.has()) {
          break label468;
        }
        i = paramObject.uint32_remain_at_all_count_for_group.get();
        if (paramObject.uint32_remain_at_all_count_for_uin.has())
        {
          j = paramObject.uint32_remain_at_all_count_for_uin.get();
          if (QLog.isColorLevel())
          {
            paramObject = new StringBuilder();
            paramObject.append("handleGetAtAllRemainCountInfo:").append("troopCode:").append(str).append(",groupRemainCnt:").append(i).append(",memberRemainCount:").append(j).append(", beCanAtAll:").append(bool).append(",tips1:").append(paramToServiceMsg).append(",tips2:").append(paramFromServiceMsg);
            QLog.d("Q.hotchat.remainCount", 2, paramObject.toString());
          }
          notifyUI(1053, true, new Object[] { str, Boolean.valueOf(bool), paramToServiceMsg, paramFromServiceMsg });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        notifyUI(1053, false, arrayOfObject);
        return;
      }
      int j = 0;
      continue;
      label468:
      int i = 0;
      continue;
      label474:
      paramFromServiceMsg = "";
      continue;
      label480:
      paramToServiceMsg = "";
    }
  }
  
  private void em(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleExitHotChatResp()");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str2 = bol;
    String str1 = paramToServiceMsg.extraData.getString("troopUin");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(1033, false, new Object[] { str1, str2 });
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg == null)
      {
        notifyUI(1033, false, new Object[] { str1, str2 });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg = null;
      }
      if (!paramFromServiceMsg.uint32_result.has())
      {
        notifyUI(1033, false, new Object[] { str1, str2 });
        return;
      }
      int i = paramFromServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandler", 2, "handleExitHotChatResp result " + i);
      }
      if (i == 0)
      {
        paramToServiceMsg = (HotChatManager.HotChatStateWrapper)paramToServiceMsg.extraData.getSerializable("targetHotChatState");
        paramFromServiceMsg = (HotChatManager)this.app.getManager(60);
        paramFromServiceMsg.b(paramFromServiceMsg.a(str1), paramToServiceMsg);
        notifyUI(1033, true, new Object[] { str1, bom });
        return;
      }
      notifyUI(1033, false, new Object[] { str1, str2 });
    }
  }
  
  private void en(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = acfp.m(2131707216);
    HotChatInfo localHotChatInfo = (HotChatInfo)paramToServiceMsg.extraData.getSerializable("HOT_CHAT_INFO");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isWifiHotChat", false);
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, str, localHotChatInfo.name });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null)
      {
        notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, str, localHotChatInfo.name });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg = null;
      }
      if (!paramToServiceMsg.uint32_result.has())
      {
        notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, str, localHotChatInfo.name });
        return;
      }
      int i = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandler", 2, "handleCreateHotChatResp result " + i);
      }
      if (i == 0)
      {
        paramFromServiceMsg = new CreateHotChat.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          long l1 = aqft.K(paramFromServiceMsg.uint32_group_code.get());
          long l2 = aqft.K(paramFromServiceMsg.uint32_group_uin.get());
          localHotChatInfo.troopUin = String.valueOf(l1);
          localHotChatInfo.troopCode = String.valueOf(l2);
          localHotChatInfo.state = 0;
          ((HotChatManager)this.app.getManager(60)).a(localHotChatInfo, 4);
          notifyUI(1032, true, new Object[] { acfp.m(2131707206), localHotChatInfo.troopCode, localHotChatInfo.troopUin, localHotChatInfo.name, Boolean.valueOf(bool) });
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, str, localHotChatInfo.name });
          return;
        }
      }
      switch (i)
      {
      case 1284: 
      case 1285: 
      case 1286: 
      case 1287: 
      case 1288: 
      case 1289: 
      default: 
        paramToServiceMsg = acfp.m(2131707225);
      }
    }
    for (;;)
    {
      notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, paramToServiceMsg, localHotChatInfo.name });
      return;
      paramToServiceMsg = acfp.m(2131707218);
      continue;
      paramToServiceMsg = acfp.m(2131707212);
      continue;
      paramToServiceMsg = acfp.m(2131707221);
      continue;
      paramToServiceMsg = acfp.m(2131707222);
      continue;
      paramToServiceMsg = acfp.m(2131707213);
      continue;
      paramToServiceMsg = acfp.m(2131707208);
    }
  }
  
  private void eo(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    this.bHH = false;
    boolean bool2;
    boolean bool1;
    if (paramToServiceMsg.extraData.getInt("serviceType", 0) == 2)
    {
      bool2 = true;
      paramToServiceMsg = new GetJoinedHotChatList.RspBody();
      if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
        break label274;
      }
      bool1 = true;
      label45:
      if (!bool1) {
        break label382;
      }
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (!paramFromServiceMsg.uint32_result.has()) {
          break label376;
        }
        i = paramFromServiceMsg.uint32_result.get();
        if (i != 0) {}
      }
      catch (Exception paramToServiceMsg)
      {
        label274:
        i = 0;
        bool1 = false;
        paramToServiceMsg = null;
        continue;
        boolean bool3 = false;
        continue;
        bool3 = false;
        ((HotChatManager)this.app.getManager(60)).aj(paramToServiceMsg, bool2);
        if (bool2) {
          new Handler(Looper.getMainLooper()).post(new HotChatHandler.2(this, bool3, paramToServiceMsg));
        }
        notifyUI(1031, true, null);
        return;
      }
      try
      {
        paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (QLog.isColorLevel()) {
          QLog.i("HotChatHandler", 2, "handleGetMyHotChatListResp isSuccess: " + bool1 + ", result:" + i + ",resp=" + paramToServiceMsg);
        }
        if (paramToServiceMsg == null) {
          break label359;
        }
        paramFromServiceMsg = paramToServiceMsg.rpt_msg_wifi_poi_info.get();
        paramToServiceMsg = new ArrayList();
        if (paramFromServiceMsg == null) {
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        bool1 = false;
        bool3 = bool1;
        if (!paramFromServiceMsg.hasNext()) {
          continue;
        }
        paramObject = (Common.WifiPOIInfo)paramFromServiceMsg.next();
        if (paramObject.uint32_wifi_poi_type.get() != 1) {
          continue;
        }
        bool3 = true;
        paramObject = HotChatInfo.createHotChat(paramObject, bool3);
        paramToServiceMsg.add(paramObject);
        if (!bool2) {
          break label373;
        }
        paramObject.isGameRoom = true;
        bool1 = true;
        continue;
      }
      catch (Exception paramToServiceMsg)
      {
        continue;
        continue;
      }
      bool2 = false;
      break;
      bool1 = false;
      break label45;
      label359:
      notifyUI(1031, false, null);
      return;
      label373:
      label376:
      int i = 0;
      continue;
      label382:
      i = 0;
    }
  }
  
  private void ep(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("hotnamecode");
    int j = paramToServiceMsg.extraData.getInt("HOTCHAT_EXTRA_FLAG");
    int k = paramToServiceMsg.extraData.getInt("preHotChatState");
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = new oidb_0x8ab.RspBody();
    int m = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject3);
    if (m == 0)
    {
      paramFromServiceMsg = (FromServiceMsg)localObject2;
      paramObject = localObject1;
    }
    for (;;)
    {
      try
      {
        if (((oidb_0x8ab.RspBody)localObject3).poi_info.has())
        {
          paramObject = localObject1;
          paramFromServiceMsg = (Common.WifiPOIInfo)((oidb_0x8ab.RspBody)localObject3).poi_info.get();
        }
        paramObject = paramFromServiceMsg;
        if (!((oidb_0x8ab.RspBody)localObject3).join_poi_status.has()) {
          break label791;
        }
        paramObject = paramFromServiceMsg;
        i = ((oidb_0x8ab.RspBody)localObject3).join_poi_status.get();
      }
      catch (Exception paramFromServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
        i = 0;
        paramFromServiceMsg = paramObject;
        continue;
        if ((((HotChatInfo)localObject2).userCreate != paramObject.userCreate) || (!aqft.equalsWithNullCheck(((HotChatInfo)localObject2).uuid, paramObject.uuid)) || (aqft.equalsWithNullCheck(((HotChatInfo)localObject2).troopUin, paramObject.troopUin))) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        ajrk.m("HotChatHandler", new Object[] { "handleQuickJoinHotChat_check", String.format("userCreate:%d, uuid:%s, local:[%s,%s], server:[%s,%s]", new Object[] { Integer.valueOf(((HotChatInfo)localObject2).userCreate), ((HotChatInfo)localObject2).uuid, ((HotChatInfo)localObject2).troopUin, ((HotChatInfo)localObject2).troopCode, paramObject.troopUin, paramObject.troopCode }) });
        paramToServiceMsg.b((HotChatInfo)localObject2, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL);
        continue;
        if (i != 1) {
          continue;
        }
        paramToServiceMsg.a(paramObject, k);
        if (!paramFromServiceMsg.uint64_exit_group_code.has()) {
          continue;
        }
        l = paramFromServiceMsg.uint64_exit_group_code.get();
        localObject2 = paramToServiceMsg.dX();
        if ((localObject1 == null) || (((List)localObject2).size() <= 0)) {
          continue;
        }
        localObject1 = ((List)localObject2).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        localObject2 = (HotChatInfo)((Iterator)localObject1).next();
        if ((((HotChatInfo)localObject2).adminLevel != 0) || (!String.valueOf(l).equals(((HotChatInfo)localObject2).troopUin))) {
          continue;
        }
        paramToServiceMsg.b((HotChatInfo)localObject2, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_LEFT_OVERCOUNT);
        continue;
        if (i != 2) {
          continue;
        }
        localObject2 = paramToServiceMsg.a(paramObject.troopUin);
        if (localObject2 != null) {
          continue;
        }
        paramToServiceMsg.a(paramObject, 4);
        continue;
        if (k != 1) {
          continue;
        }
        paramToServiceMsg.a(paramObject, k);
        continue;
        ((HotChatInfo)localObject2).updateHotChatInfo(paramObject);
        localObject3 = this.app.a().createEntityManager();
        ((EntityManager)localObject3).update((Entity)localObject2);
        ((EntityManager)localObject3).close();
        continue;
        paramToServiceMsg = paramObject;
      }
      if (paramFromServiceMsg != null)
      {
        paramObject = HotChatInfo.createHotChat(paramFromServiceMsg, false, j);
        j = paramToServiceMsg.extraData.getInt("apolloGameId");
        if (j > 0)
        {
          paramObject.apolloGameId = j;
          if (QLog.isColorLevel()) {
            QLog.d("HotChatHandler", 2, "handleQuickJoinHotChat jionHotChat, apolloGameId:" + j);
          }
        }
        if (QLog.isDevelopLevel()) {
          ajrk.m("PttShow", new Object[] { "handleQuickJoinHotChat", paramObject });
        }
        paramToServiceMsg = (HotChatManager)this.app.getManager(60);
        localObject1 = paramToServiceMsg.dX();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          j = ((List)localObject1).size() - 1;
          if (j >= 0)
          {
            localObject2 = (HotChatInfo)((List)localObject1).get(j);
            if (localObject2 == null)
            {
              j -= 1;
              continue;
            }
          }
        }
      }
      for (;;)
      {
        long l;
        notifyUI(1034, true, new Object[] { paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(i), str });
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("HotChatHandler", 2, "handleQuickJoinHotChat, " + m + "," + paramToServiceMsg + "," + paramFromServiceMsg);
          }
          return;
          notifyUI(1034, false, new Object[] { null, null, Integer.valueOf(m), str });
          paramToServiceMsg = null;
          paramFromServiceMsg = null;
        }
        paramToServiceMsg = null;
      }
      label791:
      int i = 0;
    }
  }
  
  private void eq(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("uid");
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        int j;
        paramObject = paramToServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramObject = paramToServiceMsg;
          j = -1;
          i = j;
          if (paramObject != null)
          {
            i = j;
            if (paramObject.uint32_result.has()) {
              i = paramObject.uint32_result.get();
            }
          }
          if (i != 0) {
            break label171;
          }
          notifyUI(1035, true, new Object[] { arrayOfByte, Integer.valueOf(i), null });
          if (QLog.isColorLevel()) {
            QLog.i("HotChatHandler", 2, "handleSetHotChatAnnounce,result= " + i + ",strErr=" + null);
          }
          return;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          int i;
          break label148;
        }
        paramFromServiceMsg = paramFromServiceMsg;
        paramToServiceMsg = null;
      }
      label148:
      if (QLog.isColorLevel())
      {
        QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
        paramObject = paramToServiceMsg;
        continue;
        label171:
        notifyUI(1035, false, new Object[] { arrayOfByte, Integer.valueOf(i), null });
      }
    }
  }
  
  /* Error */
  private void er(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 56	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc 101
    //   6: invokevirtual 105	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   9: astore 8
    //   11: aload_1
    //   12: getfield 56	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   15: ldc 144
    //   17: invokevirtual 64	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   20: astore 9
    //   22: new 533	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   25: dup
    //   26: invokespecial 534	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   29: astore_1
    //   30: aload_1
    //   31: aload_3
    //   32: checkcast 536	[B
    //   35: checkcast 536	[B
    //   38: invokevirtual 540	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   41: pop
    //   42: aload_1
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull +525 -> 570
    //   48: aload_2
    //   49: getfield 543	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   52: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   55: ifeq +515 -> 570
    //   58: aload_2
    //   59: getfield 543	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   62: invokevirtual 548	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   65: istore 4
    //   67: aconst_null
    //   68: astore 6
    //   70: aconst_null
    //   71: astore 7
    //   73: aconst_null
    //   74: astore_3
    //   75: iload 4
    //   77: ifne +415 -> 492
    //   80: new 550	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody
    //   83: dup
    //   84: invokespecial 551	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:<init>	()V
    //   87: astore 6
    //   89: aload 6
    //   91: aload_2
    //   92: getfield 554	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   95: invokevirtual 557	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   98: invokevirtual 558	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   101: invokevirtual 559	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   104: pop
    //   105: aload 6
    //   107: getfield 871	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_group_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   110: invokevirtual 603	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   113: ifeq +452 -> 565
    //   116: aload 6
    //   118: getfield 871	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_group_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   121: invokevirtual 557	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   124: invokevirtual 621	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   127: astore_1
    //   128: aload 6
    //   130: getfield 874	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_jumping_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   133: invokevirtual 603	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   136: ifeq +424 -> 560
    //   139: aload 6
    //   141: getfield 874	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_jumping_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   144: invokevirtual 557	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   147: invokevirtual 621	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   150: astore_2
    //   151: aload 6
    //   153: getfield 878	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:uint64_administrator_uin	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   156: invokevirtual 881	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   159: ifeq +12 -> 171
    //   162: aload 6
    //   164: getfield 878	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:uint64_administrator_uin	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   167: invokevirtual 882	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   170: astore_3
    //   171: aload_1
    //   172: astore 6
    //   174: aload_3
    //   175: astore_1
    //   176: aload 6
    //   178: astore_3
    //   179: aload_0
    //   180: getfield 504	acfv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   183: bipush 60
    //   185: invokevirtual 510	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   188: checkcast 410	com/tencent/mobileqq/app/HotChatManager
    //   191: astore 6
    //   193: aload 6
    //   195: aload 9
    //   197: invokevirtual 562	com/tencent/mobileqq/app/HotChatManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/HotChatInfo;
    //   200: astore 7
    //   202: aload 7
    //   204: ifnull +181 -> 385
    //   207: aload_3
    //   208: ifnonnull +142 -> 350
    //   211: aload 7
    //   213: getfield 885	com/tencent/mobileqq/data/HotChatInfo:memo	Ljava/lang/String;
    //   216: ifnonnull +146 -> 362
    //   219: aload 7
    //   221: aload_3
    //   222: putfield 885	com/tencent/mobileqq/data/HotChatInfo:memo	Ljava/lang/String;
    //   225: aload 7
    //   227: aload_2
    //   228: putfield 888	com/tencent/mobileqq/data/HotChatInfo:memoUrl	Ljava/lang/String;
    //   231: new 254	java/util/ArrayList
    //   234: dup
    //   235: invokespecial 732	java/util/ArrayList:<init>	()V
    //   238: astore 10
    //   240: aload_1
    //   241: ifnull +130 -> 371
    //   244: aload_1
    //   245: invokeinterface 800 1 0
    //   250: ifle +121 -> 371
    //   253: iconst_0
    //   254: istore 5
    //   256: iload 5
    //   258: aload_1
    //   259: invokeinterface 800 1 0
    //   264: if_icmpge +107 -> 371
    //   267: aload 10
    //   269: aload_1
    //   270: iload 5
    //   272: invokeinterface 801 2 0
    //   277: checkcast 153	java/lang/Long
    //   280: invokestatic 891	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   283: invokevirtual 892	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   286: pop
    //   287: iload 5
    //   289: iconst_1
    //   290: iadd
    //   291: istore 5
    //   293: goto -37 -> 256
    //   296: astore_3
    //   297: aconst_null
    //   298: astore_1
    //   299: aload_1
    //   300: astore_2
    //   301: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq -260 -> 44
    //   307: ldc 42
    //   309: iconst_2
    //   310: aload_3
    //   311: invokevirtual 581	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   314: invokestatic 48	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: aload_1
    //   318: astore_2
    //   319: goto -275 -> 44
    //   322: astore_3
    //   323: aconst_null
    //   324: astore_1
    //   325: aconst_null
    //   326: astore_2
    //   327: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   330: ifeq +13 -> 343
    //   333: ldc 42
    //   335: iconst_2
    //   336: aload_3
    //   337: invokevirtual 582	java/lang/Exception:toString	()Ljava/lang/String;
    //   340: invokestatic 48	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: aload_1
    //   344: astore_3
    //   345: aconst_null
    //   346: astore_1
    //   347: goto -168 -> 179
    //   350: aload_3
    //   351: aload 7
    //   353: getfield 885	com/tencent/mobileqq/data/HotChatInfo:memo	Ljava/lang/String;
    //   356: invokevirtual 836	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   359: ifne -140 -> 219
    //   362: aload 7
    //   364: iconst_0
    //   365: putfield 895	com/tencent/mobileqq/data/HotChatInfo:memoShowed	Z
    //   368: goto -149 -> 219
    //   371: aload 7
    //   373: aload 10
    //   375: putfield 572	com/tencent/mobileqq/data/HotChatInfo:adminUins	Ljava/util/List;
    //   378: aload 6
    //   380: aload 7
    //   382: invokevirtual 589	com/tencent/mobileqq/app/HotChatManager:updateHotChatInfo	(Lcom/tencent/mobileqq/data/HotChatInfo;)V
    //   385: aload_0
    //   386: sipush 1036
    //   389: iconst_1
    //   390: bipush 6
    //   392: anewarray 50	java/lang/Object
    //   395: dup
    //   396: iconst_0
    //   397: aload 9
    //   399: aastore
    //   400: dup
    //   401: iconst_1
    //   402: aload 8
    //   404: aastore
    //   405: dup
    //   406: iconst_2
    //   407: iload 4
    //   409: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   412: aastore
    //   413: dup
    //   414: iconst_3
    //   415: aload_3
    //   416: aastore
    //   417: dup
    //   418: iconst_4
    //   419: aload_2
    //   420: aastore
    //   421: dup
    //   422: iconst_5
    //   423: aload_1
    //   424: aastore
    //   425: invokevirtual 68	acfv:notifyUI	(IZLjava/lang/Object;)V
    //   428: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq +60 -> 491
    //   434: ldc 146
    //   436: iconst_2
    //   437: new 121	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   444: ldc_w 897
    //   447: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: iload 4
    //   452: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   455: ldc_w 899
    //   458: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload_3
    //   462: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: ldc_w 901
    //   468: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: aload_2
    //   472: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: ldc_w 903
    //   478: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: aload_1
    //   482: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokestatic 48	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   491: return
    //   492: aload_0
    //   493: sipush 1036
    //   496: iconst_0
    //   497: bipush 6
    //   499: anewarray 50	java/lang/Object
    //   502: dup
    //   503: iconst_0
    //   504: aload 9
    //   506: aastore
    //   507: dup
    //   508: iconst_1
    //   509: aload 8
    //   511: aastore
    //   512: dup
    //   513: iconst_2
    //   514: iload 4
    //   516: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   519: aastore
    //   520: dup
    //   521: iconst_3
    //   522: aconst_null
    //   523: aastore
    //   524: dup
    //   525: iconst_4
    //   526: aconst_null
    //   527: aastore
    //   528: dup
    //   529: iconst_5
    //   530: aconst_null
    //   531: aastore
    //   532: invokevirtual 68	acfv:notifyUI	(IZLjava/lang/Object;)V
    //   535: aconst_null
    //   536: astore_1
    //   537: aload 7
    //   539: astore_2
    //   540: aload 6
    //   542: astore_3
    //   543: goto -115 -> 428
    //   546: astore_3
    //   547: aconst_null
    //   548: astore_2
    //   549: goto -222 -> 327
    //   552: astore_3
    //   553: goto -226 -> 327
    //   556: astore_3
    //   557: goto -258 -> 299
    //   560: aconst_null
    //   561: astore_2
    //   562: goto -411 -> 151
    //   565: aconst_null
    //   566: astore_1
    //   567: goto -439 -> 128
    //   570: iconst_m1
    //   571: istore 4
    //   573: goto -506 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	576	0	this	acfv
    //   0	576	1	paramToServiceMsg	ToServiceMsg
    //   0	576	2	paramFromServiceMsg	FromServiceMsg
    //   0	576	3	paramObject	Object
    //   65	507	4	i	int
    //   254	38	5	j	int
    //   68	473	6	localObject	Object
    //   71	467	7	localHotChatInfo	HotChatInfo
    //   9	501	8	arrayOfByte	byte[]
    //   20	485	9	str	String
    //   238	136	10	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   22	30	296	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   89	128	322	java/lang/Exception
    //   128	151	546	java/lang/Exception
    //   151	171	552	java/lang/Exception
    //   30	42	556	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void es(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    localObject = paramToServiceMsg.extraData.getString("groupcode");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        try
        {
          label56:
          oidb_0x88d.RspBody localRspBody;
          localRspBody.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          paramFromServiceMsg = paramObject;
          if (localRspBody.stzrspgroupinfo.has()) {
            paramFromServiceMsg = localRspBody.stzrspgroupinfo.get();
          }
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
          {
            paramFromServiceMsg = (oidb_0x88d.RspGroupInfo)paramFromServiceMsg.get(0);
            if (!paramFromServiceMsg.uint32_result.has()) {
              break label637;
            }
            j = paramFromServiceMsg.uint32_result.get();
            i = j;
            if (i != 0) {}
          }
        }
        catch (Exception localException2)
        {
          HotChatInfo localHotChatInfo;
          int j;
          long l;
          paramFromServiceMsg = null;
          continue;
        }
        try
        {
          if (!paramFromServiceMsg.stgroupinfo.has()) {
            break label632;
          }
          paramObject = (oidb_0x88d.GroupInfo)paramFromServiceMsg.stgroupinfo.get();
          if (paramObject == null) {
            break label623;
          }
          paramFromServiceMsg = localHotChatInfo;
          if (paramObject.string_group_memo.has()) {
            paramFromServiceMsg = paramObject.string_group_memo.get().toStringUtf8();
          }
        }
        catch (Exception localException3)
        {
          paramFromServiceMsg = null;
          continue;
        }
        try
        {
          if (!paramObject.uint64_group_owner.has()) {
            break;
          }
          l = paramObject.uint64_group_owner.get();
          paramObject = Long.valueOf(l);
          paramToServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg = paramObject;
          try
          {
            paramObject = (HotChatManager)this.app.getManager(60);
            localHotChatInfo = paramObject.a((String)localObject);
            if (localHotChatInfo != null)
            {
              if (paramToServiceMsg == null)
              {
                if (localHotChatInfo.memo != null) {
                  continue;
                }
                localHotChatInfo.memo = paramToServiceMsg;
                localHotChatInfo.memoUrl = null;
                localHotChatInfo.ownerUin = String.valueOf(paramFromServiceMsg);
                paramObject.updateHotChatInfo(localHotChatInfo);
              }
            }
            else
            {
              notifyUI(1039, true, new Object[] { localObject, Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg });
              j = i;
              localObject = paramToServiceMsg;
              paramObject = paramFromServiceMsg;
              if (QLog.isColorLevel()) {
                QLog.i("HotChatHandler", 2, "handleGetUserCreateHotChatAnnounce,result= " + j + ",memo=" + (String)localObject + ",troopOwner=" + paramObject);
              }
              return;
              paramFromServiceMsg = paramFromServiceMsg;
              paramToServiceMsg = null;
              if (QLog.isColorLevel()) {
                QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
              }
              paramFromServiceMsg = paramToServiceMsg;
              continue;
            }
            if (paramToServiceMsg.equals(localHotChatInfo.memo)) {
              continue;
            }
            localHotChatInfo.memoShowed = false;
            continue;
            paramObject = paramToServiceMsg;
          }
          catch (Exception localException1)
          {
            paramObject = paramFromServiceMsg;
            paramFromServiceMsg = paramToServiceMsg;
            paramToServiceMsg = paramObject;
          }
        }
        catch (Exception localException4)
        {
          continue;
        }
        localObject = paramFromServiceMsg;
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.i("HotChatHandler", 2, localException1.toString());
          paramObject = paramToServiceMsg;
          localObject = paramFromServiceMsg;
          j = i;
          continue;
          notifyUI(1039, false, new Object[] { localObject, Integer.valueOf(i), null, paramToServiceMsg });
          localObject = null;
          paramObject = paramToServiceMsg;
          j = i;
          continue;
          notifyUI(1039, false, new Object[] { localObject, Integer.valueOf(i), null, paramToServiceMsg });
          localObject = null;
          paramObject = paramToServiceMsg;
          j = i;
        }
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = paramToServiceMsg;
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
        break label640;
      }
      i = paramFromServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label413;
      paramObject = paramFromServiceMsg;
      paramFromServiceMsg = paramToServiceMsg;
      paramToServiceMsg = paramObject;
      break label248;
      paramObject = null;
      paramFromServiceMsg = paramToServiceMsg;
      paramToServiceMsg = paramObject;
      break label248;
      paramObject = null;
      break label191;
      break label165;
      i = -1;
      break label56;
    }
    localHotChatInfo = null;
    paramToServiceMsg = Long.valueOf(0L);
    paramObject = null;
    if (i == 0) {
      localRspBody = new oidb_0x88d.RspBody();
    }
  }
  
  private void et(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    str = paramToServiceMsg.extraData.getString("groupcode");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        label54:
        paramToServiceMsg = null;
        if (QLog.isColorLevel()) {
          QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
        }
        continue;
        paramFromServiceMsg = new oidb_0x89a.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          boolean bool = paramFromServiceMsg.str_errorinfo.has();
          if (!bool) {}
        }
        catch (Exception paramToServiceMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
            }
          }
        }
        notifyUI(1040, false, new Object[] { str, Integer.valueOf(i), null });
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
        break label246;
      }
      i = paramToServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label134;
      i = -1;
      break label54;
    }
    if (i == 0)
    {
      notifyUI(1040, true, new Object[] { str, Integer.valueOf(i), null });
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandler", 2, "handleSetUserCreateHotChatAnnounce,result= " + i + ",strErr=" + null);
      }
      return;
    }
  }
  
  private void eu(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    str1 = paramToServiceMsg.extraData.getString("groupuin");
    str2 = paramToServiceMsg.extraData.getString("groupcode");
    str3 = paramToServiceMsg.extraData.getString("memberuin");
    str4 = paramToServiceMsg.extraData.getString("nickname");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      for (;;)
      {
        try
        {
          label90:
          paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (paramToServiceMsg.msg_kick_visitor.has()) {
            paramToServiceMsg = (oidb_0x823.KickPublicGroupVisitorRspBody)paramToServiceMsg.msg_kick_visitor.get();
          }
          acqn.a(this.app, String.valueOf(str2), str4 + BaseApplicationImpl.getContext().getString(2131694671), 1, false, true);
          notifyUI(1052, true, new Object[] { str1, Integer.valueOf(i), str3, null });
          if (QLog.isColorLevel()) {
            QLog.i("HotChatHandlerQ.hotchat.hotchat_kick_mem_by_global_admin", 2, "handleKickHotChatMemberByGlobalAmdminResp,result= " + i + ",groupuin=" + str1 + ",memberUin=" + str3 + ",strErr=" + null);
          }
          return;
          paramObject = paramObject;
          paramToServiceMsg = null;
          paramFromServiceMsg = paramToServiceMsg;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("HotChatHandler", 2, paramObject.toString());
          paramFromServiceMsg = paramToServiceMsg;
        }
        catch (Exception paramToServiceMsg)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
          continue;
        }
        notifyUI(1052, false, new Object[] { str1, Integer.valueOf(i), str3, null });
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = paramToServiceMsg;
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
        break label367;
      }
      i = paramFromServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      break label283;
      i = -1;
      break label90;
    }
    if (i == 0) {
      paramToServiceMsg = new oidb_0x823.RspBody();
    }
  }
  
  private void ev(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    str1 = paramToServiceMsg.extraData.getString("groupuin");
    String str3 = paramToServiceMsg.extraData.getString("groupcode");
    str2 = paramToServiceMsg.extraData.getString("memberuin");
    String str4 = paramToServiceMsg.extraData.getString("nickname");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      for (;;)
      {
        label90:
        paramToServiceMsg = null;
        paramFromServiceMsg = paramToServiceMsg;
        if (QLog.isColorLevel())
        {
          QLog.i("HotChatHandler", 2, paramObject.toString());
          paramFromServiceMsg = paramToServiceMsg;
          continue;
          notifyUI(1037, false, new Object[] { str1, Integer.valueOf(i), str2, null });
          paramToServiceMsg = null;
        }
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = paramToServiceMsg;
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
        break label369;
      }
      i = paramFromServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      break label281;
      i = -1;
      break label90;
    }
    paramToServiceMsg = null;
    if (i == 0)
    {
      paramObject = new oidb_0x89b.RspBody();
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (paramObject.str_err_msg.has()) {
          paramToServiceMsg = paramObject.str_err_msg.get();
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
          }
          paramToServiceMsg = null;
        }
      }
      acqn.a(this.app, String.valueOf(str3), str4 + BaseApplicationImpl.getContext().getString(2131694671), 1, false, true);
      notifyUI(1037, true, new Object[] { str1, Integer.valueOf(i), str2, paramToServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandler", 2, "handleKickHotChatMemberResp,result= " + i + ",groupuin=" + str1 + ",memberUin=" + str2 + ",strErr=" + paramToServiceMsg);
      }
      return;
    }
  }
  
  private void ew(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    str = paramToServiceMsg.extraData.getString("groupcode");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        label56:
        paramToServiceMsg = null;
        if (QLog.isColorLevel()) {
          QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
        }
        continue;
        notifyUI(1038, false, new Object[] { str, Integer.valueOf(i), null });
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = null;
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
        break label292;
      }
      i = paramToServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label215;
      i = -1;
      break label56;
    }
    if (i == 0)
    {
      paramObject = new oidb_0xa81.RspBody();
      try
      {
        paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramToServiceMsg = paramFromServiceMsg;
        if (paramObject.str_err_msg.has()) {
          paramToServiceMsg = paramObject.str_err_msg.get().toStringUtf8();
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
          }
          paramToServiceMsg = null;
        }
      }
      paramFromServiceMsg = (HotChatManager)this.app.getManager(60);
      paramObject = paramFromServiceMsg.a(str);
      if (paramObject != null) {
        paramFromServiceMsg.b(paramObject, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL);
      }
      notifyUI(1038, true, new Object[] { str, Integer.valueOf(i), paramToServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandler", 2, "handleDismissHotChat,result= " + i + ",groupcode=" + str);
      }
      return;
    }
  }
  
  private void ex(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isHotChat");
    paramToServiceMsg = new Object[3];
    paramToServiceMsg[0] = str;
    paramToServiceMsg[1] = Integer.valueOf(-1);
    paramToServiceMsg[2] = Boolean.valueOf(bool);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatHandler", 2, "handleGetTroopInfo isHotChat = " + bool);
    }
    if ((paramObject == null) || (paramFromServiceMsg.getResultCode() != 1000))
    {
      notifyUI(1047, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null))
      {
        notifyUI(1047, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      notifyUI(1047, false, paramToServiceMsg);
      return;
    }
    paramObject = new oidb_0x88d.RspBody();
    int i;
    try
    {
      paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramFromServiceMsg = paramObject.stzrspgroupinfo.get();
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0)) {
        break label364;
      }
      paramFromServiceMsg = (oidb_0x88d.RspGroupInfo)paramFromServiceMsg.get(0);
      i = paramFromServiceMsg.uint32_result.get();
      if (i == 0)
      {
        notifyUI(1047, true, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool), (oidb_0x88d.GroupInfo)paramFromServiceMsg.stgroupinfo.get() });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      notifyUI(1047, false, paramToServiceMsg);
      return;
    }
    notifyUI(1047, false, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
    return;
    label364:
    notifyUI(1047, false, paramToServiceMsg);
  }
  
  private void ey(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("uitag"));
    if ((paramFromServiceMsg == null) || (paramObject == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
      notifyUI(1046, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
    }
    for (;;)
    {
      return;
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramObject == null) || (!paramObject.uint32_result.has()) || (!paramObject.bytes_bodybuffer.has()) || (paramObject.bytes_bodybuffer.get() == null))
        {
          notifyUI(1046, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        notifyUI(1046, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
        return;
      }
      paramFromServiceMsg = new cmd0x897.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        if (paramFromServiceMsg.uint32_result.has()) {
          if (paramFromServiceMsg.uint32_result.get() == 0)
          {
            if (!paramFromServiceMsg.rpt_msg_grp_visitor_info.isEmpty()) {
              notifyUI(1046, true, new Object[] { Integer.valueOf(0), paramFromServiceMsg.rpt_msg_grp_visitor_info.get(), paramToServiceMsg });
            }
            while (QLog.isColorLevel())
            {
              int i = -1;
              if (paramFromServiceMsg.uint32_result.has()) {
                i = paramFromServiceMsg.uint32_result.get();
              }
              QLog.i("HotChatHandler", 2, "handleGetHotChatTroopMemberList.result=" + i);
              return;
              notifyUI(1046, false, new Object[] { Integer.valueOf(2), null, paramToServiceMsg });
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          notifyUI(1046, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
          continue;
          notifyUI(1046, false, new Object[] { Integer.valueOf(3), null, paramToServiceMsg });
          continue;
          notifyUI(1046, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
        }
      }
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("HotChatHandler", 2, "<<---handleError serviceCmd:" + str);
    }
    if ("OidbSvc.0x8a4".equals(str)) {
      c(paramToServiceMsg, paramFromServiceMsg, false);
    }
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!"OidbSvc.0x89b_3".equals(str)) {
                    break;
                  }
                  if (paramToServiceMsg.extraData.getBoolean("kick", false))
                  {
                    V(paramToServiceMsg, paramFromServiceMsg);
                    return;
                  }
                } while (paramToServiceMsg.extraData.getBoolean("isJoin"));
                O(paramToServiceMsg, paramFromServiceMsg);
                return;
              } while ("OidbSvc.0x823_0".equals(str));
              if ("OidbSvc.0x8a2".equals(str))
              {
                P(paramToServiceMsg, paramFromServiceMsg);
                return;
              }
              if ("OidbSvc.0x8ab".equals(str))
              {
                Q(paramToServiceMsg, paramFromServiceMsg);
                return;
              }
              if ("OidbSvc.0x8b3".equals(str))
              {
                R(paramToServiceMsg, paramFromServiceMsg);
                return;
              }
              if (!"OidbSvc.0x8b2".equals(str)) {
                break;
              }
            } while ((paramToServiceMsg == null) || (paramToServiceMsg.extraData == null));
            i = paramToServiceMsg.extraData.getInt("serviceType");
            if (QLog.isColorLevel()) {
              QLog.d("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, "handleError, cmd:" + str + "|serviceType:" + i);
            }
          } while (i != 2);
          S(paramToServiceMsg, paramFromServiceMsg);
          return;
          if ("OidbSvc.0xa81".equals(str))
          {
            W(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
          if ("OidbSvc.0x88d_0".equals(str))
          {
            T(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
          if ("OidbSvc.0x89a_0".equals(str))
          {
            U(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
        } while ("OidbSvc.0xa8b".equals(str));
        if ("OidbSvc.0x897_0".equals(str))
        {
          ey(paramToServiceMsg, paramFromServiceMsg, null);
          return;
        }
        if ("OidbSvc.0x88d_1".equals(str))
        {
          ex(paramToServiceMsg, paramFromServiceMsg, null);
          return;
        }
      } while ("OidbSvc.0x8a3_7".equals(str));
      if ("OidbSvc.0x8a7_0".equals(str))
      {
        eC(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
    } while (!"OidbSvc.0x62c_4".equals(str));
    ez(paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("HotChatHandler", 2, "<<---handleTimeOut serviceCmd:" + str);
    }
    if ("OidbSvc.0x8a4".equals(str)) {
      c(paramToServiceMsg, paramFromServiceMsg, true);
    }
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!"OidbSvc.0x89b_3".equals(str)) {
                  break;
                }
                if (paramToServiceMsg.extraData.getBoolean("kick", false))
                {
                  V(paramToServiceMsg, paramFromServiceMsg);
                  return;
                }
              } while (paramToServiceMsg.extraData.getBoolean("isJoin"));
              O(paramToServiceMsg, paramFromServiceMsg);
              return;
            } while ("OidbSvc.0x823_0".equals(str));
            if ("OidbSvc.0x8a2".equals(str))
            {
              P(paramToServiceMsg, paramFromServiceMsg);
              return;
            }
            if ("OidbSvc.0x8ab".equals(str))
            {
              Q(paramToServiceMsg, paramFromServiceMsg);
              return;
            }
            if ("OidbSvc.0x8b3".equals(str))
            {
              R(paramToServiceMsg, paramFromServiceMsg);
              return;
            }
            if (!"OidbSvc.0x8b2".equals(str)) {
              break;
            }
          } while ((paramToServiceMsg == null) || (paramToServiceMsg.extraData == null));
          i = paramToServiceMsg.extraData.getInt("serviceType");
          if (QLog.isColorLevel()) {
            QLog.d("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, "handleTimeOut, cmd:" + str + "|serviceType:" + i);
          }
        } while (i != 2);
        S(paramToServiceMsg, paramFromServiceMsg);
        return;
        if ("OidbSvc.0xa81".equals(str))
        {
          W(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("OidbSvc.0x88d_0".equals(str))
        {
          T(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("OidbSvc.0x89a_0".equals(str))
        {
          U(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
      } while ("OidbSvc.0xa8b".equals(str));
      if ("OidbSvc.0x897_0".equals(str))
      {
        ey(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("OidbSvc.0x88d_1".equals(str))
      {
        ex(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
    } while (!"OidbSvc.0x8a7_0".equals(str));
    eC(paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void Je(int paramInt)
  {
    if (QLog.isColorLevel()) {
      ajrk.m("HotChatHandler", new Object[] { "getMyHotChatList()", Boolean.valueOf(this.bHH) });
    }
    long l = Long.parseLong(this.app.getAccount());
    Object localObject = new GetJoinedHotChatList.ReqBody();
    ((GetJoinedHotChatList.ReqBody)localObject).uint64_uin.set(l);
    ((GetJoinedHotChatList.ReqBody)localObject).uint32_req_type.set(3);
    localObject = makeOIDBPkg("OidbSvc.0x8a4", 2212, paramInt, ((GetJoinedHotChatList.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).setTimeout(10000L);
    ((ToServiceMsg)localObject).extraData.putInt("serviceType", paramInt);
    sendPbReq((ToServiceMsg)localObject);
    this.bHH = true;
  }
  
  public void R(String paramString1, String paramString2, String paramString3)
  {
    notifyUI(1054, true, new Object[] { paramString1, paramString2, paramString3 });
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, List<Long> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotChatHandlerQ.hotchat.setadmin", 2, "setHotChatAdminFlag:|serviceType:" + paramInt);
    }
    if ((paramList == null) || (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.e("HotChatHandlerQ.hotchat.setadmin", 2, "memberUins is empty!");
      }
    }
    ToServiceMsg localToServiceMsg;
    for (;;)
    {
      return;
      if ((paramInt != 5) && (paramInt != 6))
      {
        if (QLog.isColorLevel()) {
          QLog.e("HotChatHandlerQ.hotchat.setadmin", 2, "serviceType is not correct!");
        }
      }
      else
      {
        oidb_0x8b2.ReqBody localReqBody = new oidb_0x8b2.ReqBody();
        try
        {
          localReqBody.uint64_group_code.set(Long.parseLong(paramString));
          HotChatInfo localHotChatInfo = ((HotChatManager)paramQQAppInterface.getManager(60)).a(paramString);
          localToServiceMsg = null;
          paramQQAppInterface = localToServiceMsg;
          if (localHotChatInfo != null)
          {
            paramQQAppInterface = localToServiceMsg;
            if (localHotChatInfo.uuid != null)
            {
              paramQQAppInterface = localHotChatInfo.uuid.getBytes();
              localReqBody.string_hot_group_id.set(ByteStringMicro.copyFrom(paramQQAppInterface));
            }
          }
          localReqBody.uint64_administrator_uin.set(paramList);
          localToServiceMsg = makeOIDBPkg("OidbSvc.0x8b2", 2226, paramInt, localReqBody.toByteArray());
          localToServiceMsg.extraData.putInt("serviceType", paramInt);
          localToServiceMsg.extraData.putByteArray("uid", paramQQAppInterface);
          localToServiceMsg.extraData.putString("troop_uin", paramString);
          paramQQAppInterface = new ArrayList();
          paramInt = 0;
          while (paramInt < paramList.size())
          {
            paramQQAppInterface.add(paramList.get(paramInt) + "");
            paramInt += 1;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (NumberFormatException paramQQAppInterface) {}
      }
    }
    QLog.e("HotChatHandlerQ.hotchat.setadmin", 2, "NumberFormatException ,troopUinis not correct," + paramString);
    return;
    localToServiceMsg.extraData.putStringArrayList("uins", paramQQAppInterface);
    sendPbReq(localToServiceMsg);
  }
  
  public void a(HotChatInfo paramHotChatInfo, HotChatManager.HotChatStateWrapper paramHotChatStateWrapper)
  {
    if (QLog.isColorLevel()) {
      ajrk.m("HotChatHandler", new Object[] { "exitHotChat", paramHotChatInfo, paramHotChatStateWrapper });
    }
    if (paramHotChatInfo == null)
    {
      notifyUI(1033, false, new Object[] { "", bol });
      return;
    }
    Object localObject = new oidb_0x89b.ExitPublicGroupReqBody();
    ((oidb_0x89b.ExitPublicGroupReqBody)localObject).uint64_visitor_uin.set(accc.Z(this.app.getCurrentAccountUin()));
    oidb_0x89b.ReqBody localReqBody = new oidb_0x89b.ReqBody();
    localReqBody.uint64_group_code.set(accc.Z(paramHotChatInfo.troopUin));
    localReqBody.uint32_req_type.set(5);
    localReqBody.msg_exit_group.set((MessageMicro)localObject);
    localObject = makeOIDBPkg("OidbSvc.0x89b_3", 2203, 3, localReqBody.toByteArray(), 10000L);
    ((ToServiceMsg)localObject).extraData.putBoolean("isJoin", false);
    ((ToServiceMsg)localObject).extraData.putString("troopUin", paramHotChatInfo.troopUin);
    ((ToServiceMsg)localObject).extraData.putSerializable("targetHotChatState", paramHotChatStateWrapper);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(Common.WifiPOIInfo paramWifiPOIInfo, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {}
    try
    {
      QLog.i("HotChatHandler", 2, "joinHotChat() WifiPOIInfo = " + paramWifiPOIInfo.bytes_name.get().toStringUtf8() + ", " + paramWifiPOIInfo.bytes_uid.get().toStringUtf8());
      label60:
      int i = 0;
      String str = null;
      if (paramWifiPOIInfo.uint32_group_uin.has()) {
        str = String.valueOf(aqft.K(paramWifiPOIInfo.uint32_group_uin.get()));
      }
      if ((str == null) || (str.equals("")) || (str.equals("0"))) {
        i = 1;
      }
      if (i != 0)
      {
        a(paramWifiPOIInfo, paramBoolean, paramInt2);
        return;
      }
      try
      {
        a(paramWifiPOIInfo.bytes_uid.get().toStringUtf8(), paramInt2, true, paramInt1);
        return;
      }
      catch (Exception paramWifiPOIInfo)
      {
        paramWifiPOIInfo.printStackTrace();
        return;
      }
    }
    catch (Exception localException)
    {
      break label60;
    }
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return a(paramString, paramInt1, paramBoolean, paramInt2, -1);
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return false;
      localObject2 = a(false);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!paramBoolean) {
          localObject1 = new LBS.LBSInfo();
        }
      }
      if (localObject1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("HotChatHandler", 2, "quickJoinHotChat, lbs is null, needLBS = " + paramBoolean);
    return false;
    Object localObject2 = new oidb_0x8ab.ReqBody();
    ((oidb_0x8ab.ReqBody)localObject2).hotnamecode.set(ByteStringMicro.copyFromUtf8(paramString));
    ((oidb_0x8ab.ReqBody)localObject2).lbs_info.set((MessageMicro)localObject1);
    ((oidb_0x8ab.ReqBody)localObject2).version_flag.set(1);
    Object localObject1 = makeOIDBPkg("OidbSvc.0x8ab", 2219, 0, ((oidb_0x8ab.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("hotnamecode", paramString);
    ((ToServiceMsg)localObject1).extraData.putInt("HOTCHAT_EXTRA_FLAG", paramInt1);
    ((ToServiceMsg)localObject1).extraData.putInt("preHotChatState", paramInt2);
    if (paramInt3 > 0) {
      ((ToServiceMsg)localObject1).extraData.putInt("apolloGameId", paramInt3);
    }
    sendPbReq((ToServiceMsg)localObject1);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandlerQ.hotchat.hotchat_kick_mem_by_global_admin", 2, "kickHotChatMemberByGlobalAdmin.groupcode=" + paramString1 + ",groupuin=" + paramString2 + ",memberuin=" + paramString3);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    Object localObject2 = new ArrayList();
    try
    {
      ((List)localObject2).add(Long.valueOf(Long.parseLong(paramString3)));
      Object localObject1 = new oidb_0x823.KickPublicGroupVisitorReqBody();
      ((oidb_0x823.KickPublicGroupVisitorReqBody)localObject1).rpt_uint64_visitor_uin.set((List)localObject2);
      localObject2 = new oidb_0x823.PlayerDeviceInfo();
      ((oidb_0x823.PlayerDeviceInfo)localObject2).int32_client_type.set(1);
      ((oidb_0x823.PlayerDeviceInfo)localObject2).uint32_portal.set(paramInt);
      oidb_0x823.ReqBody localReqBody = new oidb_0x823.ReqBody();
      localReqBody.msg_kick_visitor.set((MessageMicro)localObject1);
      localReqBody.uint64_group_uin.set(Long.valueOf(paramString2).longValue());
      localReqBody.uint64_group_code.set(Long.valueOf(paramString1).longValue());
      localReqBody.msg_req_info.set((MessageMicro)localObject2);
      localObject1 = makeOIDBPkg("OidbSvc.0x823_0", 2083, 0, localReqBody.toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("groupcode", paramString1);
      ((ToServiceMsg)localObject1).extraData.putString("groupuin", paramString2);
      ((ToServiceMsg)localObject1).extraData.putString("memberuin", paramString3);
      ((ToServiceMsg)localObject1).extraData.putBoolean("kick", true);
      ((ToServiceMsg)localObject1).extraData.putString("nickname", paramString4);
      sendPbReq((ToServiceMsg)localObject1);
      return true;
    }
    catch (NumberFormatException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandlerQ.hotchat.hotchat_kick_mem_by_global_admin", 2, "kickHotChatMemberByGlobalAdmin.NumberFormatException");
      }
    }
    return false;
  }
  
  public boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "setHotChatAnnounce.memo=" + paramString1 + ",url=" + paramString2 + ",uid=" + new String(paramArrayOfByte));
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return false;
    }
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "";
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "";
    }
    paramString2 = new oidb_0x8b3.ReqBody();
    paramString2.string_hot_group_id.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    oidb_0x8b3.groupinfo localgroupinfo = new oidb_0x8b3.groupinfo();
    localgroupinfo.string_group_memo.set(ByteStringMicro.copyFrom(str.getBytes()));
    localgroupinfo.string_jumping_url.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    paramString2.st_group_info.set(localgroupinfo);
    paramString1 = makeOIDBPkg("OidbSvc.0x8b3", 2227, 0, paramString2.toByteArray());
    paramString1.extraData.putByteArray("uid", paramArrayOfByte);
    sendPbReq(paramString1);
    return true;
  }
  
  public void ae(long paramLong, String paramString)
  {
    oidb_0x81f.ReqBody localReqBody = new oidb_0x81f.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    try
    {
      localReqBody.gc.set(Long.parseLong(paramString));
      paramString = new oidb_0x81f.GetAuthDataReq();
      paramString.uint32_auth.set(1);
      localReqBody.msg_auth_data.set(paramString);
      paramString = makeOIDBPkg("OidbSvc.0x81f", 2079, 0, localReqBody.toByteArray());
      paramString.extraData.putLong("uin", paramLong);
      sendPbReq(paramString);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("HotChatHandler", 2, "getGlobalAdmin, NumberFormatException. troopUin:" + paramString);
    }
  }
  
  public void as(String paramString1, String paramString2, String paramString3)
  {
    acqn.a(this.app, String.valueOf(paramString1), paramString3 + BaseApplicationImpl.getContext().getString(2131694671), 1, false, true);
    notifyUI(1037, true, new Object[] { paramString1, Integer.valueOf(0), paramString2, "" });
  }
  
  public boolean aw(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "setUserCreateHotChatAnnounce.groupcode=" + paramString1 + ",memo=" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (paramString2 == null)) {
      return false;
    }
    oidb_0x89a.groupinfo localgroupinfo = new oidb_0x89a.groupinfo();
    localgroupinfo.string_group_memo.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    paramString2 = this.app.getCurrentAccountUin();
    oidb_0x89a.ReqBody localReqBody = new oidb_0x89a.ReqBody();
    localReqBody.uint64_group_code.set(Long.valueOf(paramString1).longValue());
    localReqBody.uint64_original_operator_uin.set(Long.valueOf(paramString2).longValue());
    localReqBody.st_group_info.set(localgroupinfo);
    paramString2 = makeOIDBPkg("OidbSvc.0x89a_0", 2202, 0, localReqBody.toByteArray());
    paramString2.extraData.putString("groupcode", paramString1);
    sendPbReq(paramString2);
    return true;
  }
  
  public boolean b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "kickHotChatMember.groupcode=" + paramString1 + ",groupuin=" + paramString2 + ",memberuin=" + paramString3);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    if (this.app.a(true).aap()) {
      return a(paramString1, paramString2, paramString3, paramString4, paramInt);
    }
    Object localObject = new oidb_0x89b.KickPublicGroupVisitorReqBody();
    ((oidb_0x89b.KickPublicGroupVisitorReqBody)localObject).rpt_uint64_visitor_uin.add(Long.valueOf(paramString3));
    oidb_0x89b.ReqBody localReqBody = new oidb_0x89b.ReqBody();
    localReqBody.uint64_group_uin.set(Long.valueOf(paramString2).longValue());
    localReqBody.uint64_group_code.set(Long.valueOf(paramString1).longValue());
    localReqBody.uint32_req_type.set(6);
    localReqBody.msg_kick_visitor.set((MessageMicro)localObject);
    localObject = makeOIDBPkg("OidbSvc.0x89b_3", 2203, 5, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("groupcode", paramString1);
    ((ToServiceMsg)localObject).extraData.putString("groupuin", paramString2);
    ((ToServiceMsg)localObject).extraData.putString("memberuin", paramString3);
    ((ToServiceMsg)localObject).extraData.putBoolean("kick", true);
    ((ToServiceMsg)localObject).extraData.putString("nickname", paramString4);
    sendPbReq((ToServiceMsg)localObject);
    return true;
  }
  
  public boolean c(byte[] paramArrayOfByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, "getHotChatAnnounce.uid=" + new String(paramArrayOfByte) + ", troopUin=" + paramString);
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return false;
    }
    Object localObject = new oidb_0x8b2.ReqBody();
    ((oidb_0x8b2.ReqBody)localObject).string_hot_group_id.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localObject = makeOIDBPkg("OidbSvc.0x8b2", 2226, 2, ((oidb_0x8b2.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("serviceType", 2);
    ((ToServiceMsg)localObject).extraData.putByteArray("uid", paramArrayOfByte);
    ((ToServiceMsg)localObject).extraData.putString("troop_uin", paramString);
    sendPbReq((ToServiceMsg)localObject);
    return true;
  }
  
  public void cI(String paramString1, String paramString2)
  {
    notifyUI(1055, true, new Object[] { paramString1, paramString2 });
  }
  
  public void cJ(String paramString1, String paramString2)
  {
    notifyUI(1057, true, new Object[] { paramString1, paramString2 });
  }
  
  public void cJk()
  {
    Je(0);
    if (aqmj.aw(this.app.getApplication(), getCurrentAccountUin())) {
      Je(2);
    }
    if (aqmj.av(this.app.getApplication(), getCurrentAccountUin())) {
      ((ardq)this.app.getBusinessHandler(107)).a(new acfw(this));
    }
  }
  
  public void dE(ArrayList<String> paramArrayList)
  {
    oidb_cmd0x62c.ReqBody localReqBody = new oidb_cmd0x62c.ReqBody();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      localArrayList.add(Long.valueOf((String)paramArrayList.get(i)));
      i += 1;
    }
    localReqBody.uint64_tinyid.set(localArrayList);
    sendPbReq(makeOIDBPkg("OidbSvc.0x62c_4", 1580, 4, localReqBody.toByteArray(), 10000L));
  }
  
  /* Error */
  public void eA(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: new 121	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   7: aload_1
    //   8: getfield 56	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   11: ldc_w 1340
    //   14: invokevirtual 1011	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   17: invokevirtual 1440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: ldc 119
    //   22: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 7
    //   30: new 533	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   33: dup
    //   34: invokespecial 534	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   37: astore_1
    //   38: aload_1
    //   39: aload_3
    //   40: checkcast 536	[B
    //   43: checkcast 536	[B
    //   46: invokevirtual 540	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   49: pop
    //   50: aload_1
    //   51: astore_2
    //   52: iconst_m1
    //   53: istore 5
    //   55: iload 5
    //   57: istore 4
    //   59: aload_2
    //   60: ifnull +26 -> 86
    //   63: iload 5
    //   65: istore 4
    //   67: aload_2
    //   68: getfield 543	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   71: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   74: ifeq +12 -> 86
    //   77: aload_2
    //   78: getfield 543	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   81: invokevirtual 548	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   84: istore 4
    //   86: iload 4
    //   88: ifne +233 -> 321
    //   91: new 1442	tencent/im/oidb/hotchat/oidb_0x81f$RspBody
    //   94: dup
    //   95: invokespecial 1443	tencent/im/oidb/hotchat/oidb_0x81f$RspBody:<init>	()V
    //   98: astore_1
    //   99: aload_1
    //   100: aload_2
    //   101: getfield 554	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   104: invokevirtual 557	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   107: invokevirtual 558	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   110: invokevirtual 1444	tencent/im/oidb/hotchat/oidb_0x81f$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   113: pop
    //   114: aload_1
    //   115: getfield 1447	tencent/im/oidb/hotchat/oidb_0x81f$RspBody:msg_auth_data	Ltencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp;
    //   118: invokevirtual 1450	tencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp:has	()Z
    //   121: ifeq +242 -> 363
    //   124: aload_1
    //   125: getfield 1447	tencent/im/oidb/hotchat/oidb_0x81f$RspBody:msg_auth_data	Ltencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp;
    //   128: invokevirtual 1451	tencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   131: checkcast 1449	tencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp
    //   134: astore_1
    //   135: aload_1
    //   136: getfield 1452	tencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp:uint32_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   139: invokevirtual 548	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   142: istore 4
    //   144: aload_0
    //   145: getfield 504	acfv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   148: bipush 60
    //   150: invokevirtual 510	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   153: checkcast 410	com/tencent/mobileqq/app/HotChatManager
    //   156: astore_2
    //   157: iload 4
    //   159: ifne +125 -> 284
    //   162: iconst_1
    //   163: istore 6
    //   165: aload_2
    //   166: iload 6
    //   168: invokevirtual 1455	com/tencent/mobileqq/app/HotChatManager:EX	(Z)V
    //   171: iload 4
    //   173: ifne +14 -> 187
    //   176: aload_2
    //   177: aload_1
    //   178: getfield 1458	tencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp:uint64_timestamp	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   181: invokevirtual 830	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   184: invokevirtual 1461	com/tencent/mobileqq/app/HotChatManager:hv	(J)V
    //   187: aload_0
    //   188: sipush 1051
    //   191: iconst_1
    //   192: iconst_2
    //   193: anewarray 50	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload 7
    //   200: aastore
    //   201: dup
    //   202: iconst_1
    //   203: iload 4
    //   205: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   208: aastore
    //   209: invokevirtual 68	acfv:notifyUI	(IZLjava/lang/Object;)V
    //   212: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +42 -> 257
    //   218: ldc_w 591
    //   221: iconst_2
    //   222: new 121	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 1463
    //   232: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload 7
    //   237: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc_w 1465
    //   243: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: iload 4
    //   248: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   251: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 48	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: return
    //   258: astore_3
    //   259: aconst_null
    //   260: astore_1
    //   261: aload_1
    //   262: astore_2
    //   263: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq -214 -> 52
    //   269: ldc 42
    //   271: iconst_2
    //   272: aload_3
    //   273: invokevirtual 581	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   276: invokestatic 48	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: aload_1
    //   280: astore_2
    //   281: goto -229 -> 52
    //   284: iconst_0
    //   285: istore 6
    //   287: goto -122 -> 165
    //   290: astore_1
    //   291: iconst_0
    //   292: istore 5
    //   294: iload 5
    //   296: istore 4
    //   298: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq -114 -> 187
    //   304: ldc 42
    //   306: iconst_2
    //   307: aload_1
    //   308: invokevirtual 582	java/lang/Exception:toString	()Ljava/lang/String;
    //   311: invokestatic 48	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: iload 5
    //   316: istore 4
    //   318: goto -131 -> 187
    //   321: aload_0
    //   322: sipush 1051
    //   325: iconst_0
    //   326: iconst_2
    //   327: anewarray 50	java/lang/Object
    //   330: dup
    //   331: iconst_0
    //   332: aload 7
    //   334: aastore
    //   335: dup
    //   336: iconst_1
    //   337: iconst_0
    //   338: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   341: aastore
    //   342: invokevirtual 68	acfv:notifyUI	(IZLjava/lang/Object;)V
    //   345: iconst_0
    //   346: istore 4
    //   348: goto -136 -> 212
    //   351: astore_1
    //   352: iload 4
    //   354: istore 5
    //   356: goto -62 -> 294
    //   359: astore_3
    //   360: goto -99 -> 261
    //   363: iconst_0
    //   364: istore 4
    //   366: goto -179 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	acfv
    //   0	369	1	paramToServiceMsg	ToServiceMsg
    //   0	369	2	paramFromServiceMsg	FromServiceMsg
    //   0	369	3	paramObject	Object
    //   57	308	4	i	int
    //   53	302	5	j	int
    //   163	123	6	bool	boolean
    //   28	305	7	str	String
    // Exception table:
    //   from	to	target	type
    //   30	38	258	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   99	144	290	java/lang/Exception
    //   144	157	351	java/lang/Exception
    //   165	171	351	java/lang/Exception
    //   176	187	351	java/lang/Exception
    //   38	50	359	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  /* Error */
  public void ez(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: new 254	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 732	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: new 254	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 732	java/util/ArrayList:<init>	()V
    //   16: astore 6
    //   18: aload_1
    //   19: ifnull +17 -> 36
    //   22: aload_3
    //   23: ifnull +13 -> 36
    //   26: aload_2
    //   27: invokevirtual 111	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   30: sipush 1000
    //   33: if_icmpeq +26 -> 59
    //   36: aload_0
    //   37: sipush 1058
    //   40: iconst_0
    //   41: iconst_2
    //   42: anewarray 50	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload 5
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: aload 6
    //   54: aastore
    //   55: invokevirtual 68	acfv:notifyUI	(IZLjava/lang/Object;)V
    //   58: return
    //   59: new 533	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   62: dup
    //   63: invokespecial 534	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   66: astore_1
    //   67: aload_1
    //   68: aload_3
    //   69: checkcast 536	[B
    //   72: checkcast 536	[B
    //   75: invokevirtual 540	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   78: pop
    //   79: aload_1
    //   80: ifnull +177 -> 257
    //   83: aload_1
    //   84: getfield 543	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   87: invokevirtual 546	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   90: ifeq +167 -> 257
    //   93: aload_1
    //   94: getfield 543	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   97: invokevirtual 548	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   100: ifne -42 -> 58
    //   103: new 1467	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$RspBody
    //   106: dup
    //   107: invokespecial 1468	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$RspBody:<init>	()V
    //   110: astore_2
    //   111: aload_2
    //   112: aload_1
    //   113: getfield 554	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   116: invokevirtual 557	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   119: invokevirtual 558	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   122: invokevirtual 1469	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   125: pop
    //   126: new 254	java/util/ArrayList
    //   129: dup
    //   130: invokespecial 732	java/util/ArrayList:<init>	()V
    //   133: pop
    //   134: aload_2
    //   135: getfield 1472	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$RspBody:msg_tinyid_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   138: invokevirtual 731	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   141: astore_1
    //   142: iconst_0
    //   143: istore 4
    //   145: iload 4
    //   147: aload_1
    //   148: invokeinterface 800 1 0
    //   153: if_icmpge +127 -> 280
    //   156: aload 6
    //   158: aload_1
    //   159: iload 4
    //   161: invokeinterface 801 2 0
    //   166: checkcast 1474	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$TinyIDInfo
    //   169: getfield 1476	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$TinyIDInfo:uint64_tinyid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   172: invokevirtual 830	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   175: invokestatic 692	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   178: invokevirtual 892	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   181: pop
    //   182: aload 5
    //   184: aload_1
    //   185: iload 4
    //   187: invokeinterface 801 2 0
    //   192: checkcast 1474	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$TinyIDInfo
    //   195: getfield 1477	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$TinyIDInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   198: invokevirtual 830	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   201: invokestatic 692	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   204: invokevirtual 892	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   207: pop
    //   208: iload 4
    //   210: iconst_1
    //   211: iadd
    //   212: istore 4
    //   214: goto -69 -> 145
    //   217: astore_1
    //   218: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +13 -> 234
    //   224: ldc 42
    //   226: iconst_2
    //   227: aload_1
    //   228: invokevirtual 581	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   231: invokestatic 48	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload_0
    //   235: sipush 1058
    //   238: iconst_0
    //   239: iconst_2
    //   240: anewarray 50	java/lang/Object
    //   243: dup
    //   244: iconst_0
    //   245: aload 5
    //   247: aastore
    //   248: dup
    //   249: iconst_1
    //   250: aload 6
    //   252: aastore
    //   253: invokevirtual 68	acfv:notifyUI	(IZLjava/lang/Object;)V
    //   256: return
    //   257: aload_0
    //   258: sipush 1058
    //   261: iconst_0
    //   262: iconst_2
    //   263: anewarray 50	java/lang/Object
    //   266: dup
    //   267: iconst_0
    //   268: aload 5
    //   270: aastore
    //   271: dup
    //   272: iconst_1
    //   273: aload 6
    //   275: aastore
    //   276: invokevirtual 68	acfv:notifyUI	(IZLjava/lang/Object;)V
    //   279: return
    //   280: aload_0
    //   281: sipush 1058
    //   284: iconst_1
    //   285: iconst_2
    //   286: anewarray 50	java/lang/Object
    //   289: dup
    //   290: iconst_0
    //   291: aload 5
    //   293: aastore
    //   294: dup
    //   295: iconst_1
    //   296: aload 6
    //   298: aastore
    //   299: invokevirtual 68	acfv:notifyUI	(IZLjava/lang/Object;)V
    //   302: return
    //   303: astore_1
    //   304: aload_0
    //   305: sipush 1058
    //   308: iconst_0
    //   309: iconst_2
    //   310: anewarray 50	java/lang/Object
    //   313: dup
    //   314: iconst_0
    //   315: aload 5
    //   317: aastore
    //   318: dup
    //   319: iconst_1
    //   320: aload 6
    //   322: aastore
    //   323: invokevirtual 68	acfv:notifyUI	(IZLjava/lang/Object;)V
    //   326: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq -271 -> 58
    //   332: ldc 42
    //   334: iconst_2
    //   335: aload_1
    //   336: invokevirtual 581	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   339: invokestatic 48	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   342: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	acfv
    //   0	343	1	paramToServiceMsg	ToServiceMsg
    //   0	343	2	paramFromServiceMsg	FromServiceMsg
    //   0	343	3	paramObject	Object
    //   143	70	4	i	int
    //   7	309	5	localArrayList1	ArrayList
    //   16	305	6	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   59	79	217	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   111	142	303	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   145	208	303	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   280	302	303	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public boolean f(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramBoolean, 4);
  }
  
  public boolean kh(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "getUserCreateHotChatAnnounce.groupcode=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).uint64_group_owner.set(1L);
    ((oidb_0x88d.GroupInfo)localObject2).string_group_memo.set(ByteStringMicro.copyFrom("1".getBytes()));
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.valueOf(paramString).longValue());
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.app.getAppid());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = makeOIDBPkg("OidbSvc.0x88d_0", 2189, 6, ((oidb_0x88d.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("groupcode", paramString);
    ((ToServiceMsg)localObject1).extraData.putInt("serviceType", 6);
    sendPbReq((ToServiceMsg)localObject1);
    return true;
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x8a4");
      this.allowCmdSet.add("OidbSvc.0x89b_3");
      this.allowCmdSet.add("OidbSvc.0x823_0");
      this.allowCmdSet.add("OidbSvc.0x8a2");
      this.allowCmdSet.add("OidbSvc.0x8ab");
      this.allowCmdSet.add("OidbSvc.0x8b3");
      this.allowCmdSet.add("OidbSvc.0x8b2");
      this.allowCmdSet.add("OidbSvc.0x81f");
      this.allowCmdSet.add("OidbSvc.0xa81");
      this.allowCmdSet.add("OidbSvc.0x88d_0");
      this.allowCmdSet.add("OidbSvc.0x89a_0");
      this.allowCmdSet.add("OidbSvc.0x435");
      this.allowCmdSet.add("OidbSvc.0x897_0");
      this.allowCmdSet.add("OidbSvc.0x88d_1");
      this.allowCmdSet.add("OidbSvc.0xa8b");
      this.allowCmdSet.add("OidbSvc.0x8a3_7");
      this.allowCmdSet.add("OidbSvc.0x8a7_0");
      this.allowCmdSet.add("OidbSvc.0x62c_4");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return acgf.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatHandler", 2, "cmdfilter error=" + str);
      }
    }
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (paramFromServiceMsg.getResultCode() == 1002)
                  {
                    v(paramToServiceMsg, paramFromServiceMsg);
                    return;
                  }
                  if (paramFromServiceMsg.getResultCode() != 1000)
                  {
                    n(paramToServiceMsg, paramFromServiceMsg);
                    return;
                  }
                  if ("OidbSvc.0x8a4".equals(str))
                  {
                    eo(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if (!"OidbSvc.0x89b_3".equals(str)) {
                    break;
                  }
                  if (paramToServiceMsg.extraData.getBoolean("kick", false))
                  {
                    ev(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                } while (paramToServiceMsg.extraData.getBoolean("isJoin"));
                em(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
                if ("OidbSvc.0x823_0".equals(str))
                {
                  eu(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if ("OidbSvc.0x8a2".equals(str))
                {
                  en(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if ("OidbSvc.0x8ab".equals(str))
                {
                  ep(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if ("OidbSvc.0x8b3".equals(str))
                {
                  eq(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (!"OidbSvc.0x8b2".equals(str)) {
                  break;
                }
              } while ((paramToServiceMsg == null) || (paramToServiceMsg.extraData == null));
              i = paramToServiceMsg.extraData.getInt("serviceType");
              if (QLog.isColorLevel()) {
                QLog.d("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, "onReceive, cmd:" + str + "|serviceType:" + i);
              }
              if (i == 2)
              {
                er(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
            } while ((i != 5) && (i != 6));
            eB(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
            if ("OidbSvc.0x81f".equals(str))
            {
              eA(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if ("OidbSvc.0xa81".equals(str))
            {
              ew(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (!"OidbSvc.0x88d_0".equals(str)) {
              break;
            }
            i = paramToServiceMsg.extraData.getInt("serviceType");
            if (QLog.isColorLevel()) {
              QLog.d("HotChatHandler", 2, "onReceive, cmd:" + str + "|serviceType:" + i);
            }
          } while (6 != i);
          es(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          if ("OidbSvc.0x89a_0".equals(str))
          {
            et(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
        } while ("OidbSvc.0x435".equals(str));
        if ("OidbSvc.0x897_0".equals(str))
        {
          ey(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x88d_1".equals(str))
        {
          ex(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      } while ("OidbSvc.0x8a3_7".equals(str));
      if ("OidbSvc.0x8a7_0".equals(str))
      {
        eC(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x62c_4".equals(str));
    ez(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void tl(String paramString)
  {
    notifyUI(1056, true, new Object[] { paramString, bom });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acfv
 * JD-Core Version:    0.7.0.1
 */