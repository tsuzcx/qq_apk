package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.TroopAppFlagInfoEntity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
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
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.data.TroopCreateAdvanceData;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateResult;
import com.tencent.mobileqq.troop.data.TroopCreatePermissionData;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.data.pb.CommunityForumLatestPost.ReqBody;
import com.tencent.mobileqq.troop.data.pb.TroopAppFlagInfo.ReqBody;
import com.tencent.mobileqq.troop.data.pb.TroopAppFlagInfo.RspBody;
import com.tencent.mobileqq.troop.utils.HummerParser;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.troop.group_activity_info.GroupActInfo;
import com.tencent.troop.group_activity_info.ReqBody;
import com.tencent.troop.group_activity_info.RspBody;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.ServerConfigManager.ConfigType;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.ReqBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.RspBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpdateItem;
import tencent.im.oidb.cmd0x78f.oidb_0x78f.ReqBody;
import tencent.im.oidb.cmd0x78f.oidb_0x78f.RspBody;
import tencent.im.oidb.cmd0x88c.oidb_0x88c.ReqBody;
import tencent.im.oidb.cmd0x88c.oidb_0x88c.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.cmd0x897.cmd0x897.GroupNextVisitor;
import tencent.im.oidb.cmd0x897.cmd0x897.GroupUinCode;
import tencent.im.oidb.cmd0x897.cmd0x897.ReqBody;
import tencent.im.oidb.cmd0x897.cmd0x897.RspBody;
import tencent.im.oidb.cmd0x897.cmd0x897.VisitorInfo;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.GroupGeoInfo;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.ReqBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.RspBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.ExitPublicGroupReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.JoinPublicGroupReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.ReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.RspBody;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.CreateGroupInfo;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.GroupGeoInfo;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.ReqBody;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.RspBody;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.SelectGroupCodeInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.video_url.video_url.ReqBody;
import tencent.im.video_url.video_url.RspBody;
import tencent.qun.group_activity.group_activity.ReqBody;
import tencent.qun.group_activity.group_activity.RspBody;

public class BizTroopHandler
  extends BusinessHandler
{
  public static final int A = 28;
  public static final int B = 29;
  public static final int C = 1;
  public static final int D = 2;
  public static final int E = 3;
  protected static final int F = 1282;
  public static final int G = 0;
  public static final int H = 1;
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
  public static final int p = 17;
  public static final int q = 18;
  public static final int r = 19;
  public static final int s = 20;
  public static final int t = 21;
  public static final int u = 22;
  public static final int v = 23;
  public static final int w = 24;
  public static final int x = 25;
  public static final int y = 26;
  public static final int z = 27;
  private String a;
  protected Map a;
  protected Map b = new HashMap();
  
  BizTroopHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = "TroopFileHandler";
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private long a(String paramString)
  {
    try
    {
      long l1 = Long.valueOf(paramString).longValue();
      return l1;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  private String a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("model", Build.MODEL);
    localJSONObject1.put("sdk", Build.VERSION.SDK_INT);
    localJSONObject1.put("os", Build.VERSION.RELEASE);
    localJSONObject1.put("cpu", DeviceInfoUtil.f());
    JSONObject localJSONObject2 = new JSONObject();
    long[] arrayOfLong = DeviceInfoUtil.b();
    localJSONObject2.put("avail", String.valueOf(arrayOfLong[1]) + "MB");
    localJSONObject2.put("total", String.valueOf(arrayOfLong[0]) + "MB");
    localJSONObject1.put("sd", localJSONObject2);
    localJSONObject2 = new JSONObject();
    localJSONObject2.put("avail", String.valueOf(DeviceInfoUtil.d() / 1024L) + "KB");
    localJSONObject2.put("total", MsfSdkUtils.getTotalMemory());
    localJSONObject1.put("memory", localJSONObject2);
    localJSONObject2 = new JSONObject();
    arrayOfLong = DeviceInfoUtil.a();
    localJSONObject2.put("avail", String.valueOf(arrayOfLong[1]) + "MB");
    localJSONObject2.put("total", String.valueOf(arrayOfLong[0]) + "MB");
    localJSONObject1.put("rom", localJSONObject2);
    return localJSONObject1.toString();
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(15, false, new Object[] { str, "update troopApp flagInfo failed!" });
      return;
    }
    for (;;)
    {
      TroopAppFlagInfo.RspBody localRspBody;
      try
      {
        localRspBody = new TroopAppFlagInfo.RspBody();
        localRspBody.mergeFrom((byte[])paramObject);
        paramObject = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
        paramFromServiceMsg = null;
        if (paramObject == null)
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (QLog.isDevelopLevel())
          {
            QLog.d(this.jdField_a_of_type_JavaLangString, 4, "TroopInfoManager is null");
            paramToServiceMsg = paramFromServiceMsg;
          }
          paramFromServiceMsg = paramToServiceMsg;
          if (paramToServiceMsg == null) {
            paramFromServiceMsg = new TroopAppFlagInfoEntity();
          }
          if (!localRspBody.uint32_app_count.has()) {
            paramFromServiceMsg.isNeedToShow = false;
          }
          if ((!localRspBody.uint32_app_count.has()) || (localRspBody.uint32_app_count.get() != 0)) {
            break label224;
          }
          paramFromServiceMsg.isNeedToShow = false;
          if (QLog.isDevelopLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 4, "no need to show TroopApp Icon");
          }
          a(15, true, new Object[] { str, null });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      paramToServiceMsg = paramObject.a(str);
      continue;
      label224:
      paramFromServiceMsg.isNeedToShow = true;
      if (localRspBody.uint64_time.has())
      {
        if ((localRspBody.uint32_tag_red.has()) && (localRspBody.uint32_tag_red.get() > 0)) {
          paramFromServiceMsg.showRedDot = true;
        }
        paramFromServiceMsg.timestamp = localRspBody.uint64_time.get();
        if (localRspBody.str_tag.has()) {
          paramFromServiceMsg.showTag = localRspBody.str_tag.get().toString();
        }
        if (localRspBody.uint64_gcode.has()) {
          paramFromServiceMsg.troopCode = localRspBody.uint64_gcode.get();
        }
      }
      paramFromServiceMsg.isUpdated = true;
      if (paramObject != null) {
        paramObject.a(String.valueOf(str), paramFromServiceMsg);
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131559179);
    String str2 = paramToServiceMsg.extraData.getString("troopCode");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(1, false, new Object[] { str2, str1 });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      label94:
      break label94;
      if (paramToServiceMsg.uint32_result.has()) {
        break label154;
      }
      a(1, false, new Object[] { str2, str1 });
      return;
      i1 = paramToServiceMsg.uint32_result.get();
      if (i1 != 0) {
        break label281;
      }
      paramFromServiceMsg = new oidb_0x89b.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        long l1 = paramFromServiceMsg.uint64_group_uin.get();
        a(1, true, new Object[] { str2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131559180), "" + l1 });
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        a(1, false, new Object[] { str2, str1 });
        return;
      }
      if (i1 != 1281) {
        break label326;
      }
    }
    if (paramToServiceMsg == null)
    {
      a(1, false, new Object[] { str2, str1 });
      return;
    }
    label154:
    int i1;
    label281:
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131559181);
    for (;;)
    {
      a(1, false, new Object[] { str2, paramToServiceMsg });
      return;
      label326:
      if (i1 == 1284) {
        paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131559182);
      } else if (i1 == 1282) {
        paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131559183);
      } else {
        paramToServiceMsg = str1;
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131559184);
    String str1 = paramToServiceMsg.extraData.getString("troopCode");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(5, false, new Object[] { str1, str2 });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      label94:
      break label94;
      if (paramToServiceMsg.uint32_result.has()) {
        break label154;
      }
      a(5, false, new Object[] { str1, str2 });
      return;
      label154:
      if (paramToServiceMsg.uint32_result.get() != 0) {
        break label268;
      }
      paramToServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      paramObject = paramFromServiceMsg.a(str1, 1);
      if (paramObject == null) {
        break label205;
      }
      paramFromServiceMsg.b(paramObject);
      label205:
      paramToServiceMsg.i(str1);
      DBUtils.a().a(str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      a(5, true, new Object[] { str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131559185) });
      return;
      label268:
      a(5, false, new Object[] { str1, str2 });
    }
    if (paramToServiceMsg == null)
    {
      a(5, false, new Object[] { str1, str2 });
      return;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000))
    {
      a(7, false, new Object[] { Integer.valueOf(1), null });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(7, false, new Object[] { Integer.valueOf(1), null });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(7, false, new Object[] { Integer.valueOf(1), null });
      return;
    }
    paramFromServiceMsg = new cmd0x897.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (!paramFromServiceMsg.uint32_result.has()) {
        break label297;
      }
      if (paramFromServiceMsg.uint32_result.get() != 0) {
        break label274;
      }
      if (!paramFromServiceMsg.rpt_msg_grp_visitor_info.isEmpty())
      {
        a(7, true, new Object[] { Integer.valueOf(0), paramFromServiceMsg.rpt_msg_grp_visitor_info.get() });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(7, false, new Object[] { Integer.valueOf(1), null });
      return;
    }
    a(7, false, new Object[] { Integer.valueOf(2), null });
    return;
    label274:
    a(7, false, new Object[] { Integer.valueOf(3), null });
    return;
    label297:
    a(7, false, new Object[] { Integer.valueOf(1), null });
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isFromAIO");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      if (bool) {
        this.jdField_a_of_type_JavaUtilMap.remove(str);
      }
      for (;;)
      {
        a(6, false, new Object[] { str, Boolean.valueOf(bool) });
        return;
        this.b.remove(str);
      }
    }
    paramToServiceMsg = new group_activity_info.RspBody();
    try
    {
      paramObject = (group_activity_info.RspBody)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramObject != null) && (paramObject.error_code.get() == 0)) {
        break label251;
      }
      if (!bool) {
        break label236;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(str);
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        if (bool) {
          this.jdField_a_of_type_JavaUtilMap.remove(str);
        }
        for (;;)
        {
          a(6, false, new Object[] { str, Boolean.valueOf(bool) });
          return;
          this.b.remove(str);
        }
        this.b.remove(str);
      }
      paramToServiceMsg = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      paramFromServiceMsg = paramToServiceMsg.a(str);
      if (paramFromServiceMsg != null) {
        break label334;
      }
      if (!bool) {
        break label319;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(str);
      for (;;)
      {
        a(6, false, new Object[] { str, Boolean.valueOf(bool) });
        return;
        this.b.remove(str);
      }
      paramObject = paramObject.info_list.get();
      if (paramObject != null) {
        break label403;
      }
      if (!bool) {
        break label388;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(str);
      for (;;)
      {
        a(6, false, new Object[] { str, Boolean.valueOf(bool) });
        return;
        this.b.remove(str);
      }
      if ((bool) || (paramObject == null) || (paramObject.size() <= 0)) {
        break label481;
      }
      group_activity_info.GroupActInfo localGroupActInfo = (group_activity_info.GroupActInfo)paramObject.get(0);
      paramFromServiceMsg.troopActInfoTitle = localGroupActInfo.title.get();
      paramFromServiceMsg.troopActInfoSummary = localGroupActInfo.summary.get();
      paramFromServiceMsg.troopActInfoUrl = localGroupActInfo.url.get();
      paramFromServiceMsg.troopActImageUrl = localGroupActInfo.small_pic.get();
      paramToServiceMsg.a(paramFromServiceMsg, false);
      a(6, true, new Object[] { str, Boolean.valueOf(bool), paramObject });
    }
    a(6, false, new Object[] { str, Boolean.valueOf(bool) });
    return;
    label236:
    label251:
    return;
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = str;
    arrayOfObject[1] = Integer.valueOf(-1);
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(3, false, arrayOfObject);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(3, false, arrayOfObject);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(3, false, arrayOfObject);
      return;
    }
    paramFromServiceMsg = new oidb_0x88d.RspBody();
    int i1;
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramToServiceMsg = paramFromServiceMsg.stzrspgroupinfo.get();
      if ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0)) {
        break label465;
      }
      paramToServiceMsg = (oidb_0x88d.RspGroupInfo)paramToServiceMsg.get(0);
      i1 = paramToServiceMsg.uint32_result.get();
      if (i1 == 0)
      {
        paramObject = (oidb_0x88d.GroupInfo)paramToServiceMsg.stgroupinfo.get();
        FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if (paramObject != null)
        {
          paramFromServiceMsg = localFriendManager.a(str);
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null)
          {
            paramToServiceMsg = new OpenTroopInfo();
            paramToServiceMsg.troopCode = str;
          }
          paramToServiceMsg.troopName = paramObject.string_group_name.get().toStringUtf8();
          paramToServiceMsg.troopIntro = paramObject.string_group_finger_memo.get().toStringUtf8();
          paramToServiceMsg.troopMemberNum = paramObject.uint32_group_visitor_cur_num.get();
          paramToServiceMsg.troopClass = paramObject.uint32_group_class_ext.get();
          paramToServiceMsg.troopAIOSkinUrl = new String(paramObject.string_group_aio_skin_url.get().toByteArray());
          paramToServiceMsg.troopBoardSkinUrl = new String(paramObject.string_group_board_skin_url.get().toByteArray());
          paramToServiceMsg.troopCoverSkinUrl = new String(paramObject.string_group_cover_skin_url.get().toByteArray());
          paramToServiceMsg.troopCoverSkinTimestamp = paramObject.uint32_group_cover_skin_timestamp.get();
          localFriendManager.a(paramToServiceMsg, false);
        }
        a(3, true, new Object[] { str, Integer.valueOf(i1) });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(3, false, arrayOfObject);
      return;
    }
    a(3, false, new Object[] { str, Integer.valueOf(i1) });
    return;
    label465:
    a(3, false, arrayOfObject);
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    long l1 = paramToServiceMsg.extraData.getLong("troopUin");
    int i1 = paramToServiceMsg.extraData.getInt("pageIndex");
    int i2 = paramToServiceMsg.extraData.getInt("pageCount");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(12, false, new Object[] { str, Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(paramFromServiceMsg.getResultCode()) });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramObject;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
      }
      i3 = paramToServiceMsg.uint32_result.get();
      if (i3 == 0) {
        break label278;
      }
      a(12, false, new Object[] { str, Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3) });
      return;
      label278:
      paramFromServiceMsg = new oidb_0x78f.RspBody();
    }
    if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()))
    {
      a(12, false, new Object[] { str, Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(paramFromServiceMsg.getResultCode()) });
      return;
    }
    try
    {
      int i3;
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      try
      {
        paramToServiceMsg = HummerParser.a(l1, paramFromServiceMsg.opt_msg_record.get().toByteArray(), paramFromServiceMsg.uint32_cur_cnt.get());
        a(12, true, new Object[] { Integer.valueOf(i1), Integer.valueOf(paramFromServiceMsg.uint32_total_cnt.get()), Integer.valueOf(paramFromServiceMsg.uint32_cur_cnt.get()), paramToServiceMsg });
        return;
      }
      catch (IOException paramToServiceMsg)
      {
        a(12, false, new Object[] { str, Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(-1) });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        a(12, false, new Object[] { str, Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(-1) });
      }
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    paramToServiceMsg = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(19);
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      paramToServiceMsg.b(null);
      a(11, false, null);
      return;
    }
    paramFromServiceMsg = new group_activity.RspBody();
    try
    {
      paramFromServiceMsg = (group_activity.RspBody)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.uint32_error_code.get() != 0))
      {
        paramToServiceMsg.b(null);
        a(11, false, null);
        return;
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      paramToServiceMsg.b(null);
      a(11, false, null);
      return;
    }
    paramObject = paramFromServiceMsg.act_list.get();
    if (paramObject == null)
    {
      paramToServiceMsg.b(null);
      a(11, false, null);
      return;
    }
    paramToServiceMsg.b(paramObject);
    a(11, true, paramObject);
    if (NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()) == 1)
    {
      paramToServiceMsg = new String[3];
      paramToServiceMsg[0] = "param_WIFIRecommendTroopYunYingDownload";
      paramToServiceMsg[1] = "param_WIFIFlow";
      paramToServiceMsg[2] = "param_Flow";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramToServiceMsg, paramFromServiceMsg.getSerializedSize());
      return;
      paramToServiceMsg = new String[3];
      paramToServiceMsg[0] = "param_XGRecommendTroopYunYingDownload";
      paramToServiceMsg[1] = "param_XGFlow";
      paramToServiceMsg[2] = "param_Flow";
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopUin");
    int i1 = paramToServiceMsg.extraData.getInt("reqType");
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = str;
    arrayOfObject[1] = Integer.valueOf(i1);
    arrayOfObject[2] = Integer.valueOf(-1);
    arrayOfObject[3] = null;
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(18, false, arrayOfObject);
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(18, false, arrayOfObject);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(18, false, arrayOfObject);
      return;
    }
    paramObject = new oidb_0x5d6.RspBody();
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramObject = paramObject.str_wording.get();
        int i2 = paramFromServiceMsg.uint32_result.get();
        if (i2 == 0)
        {
          paramFromServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
          if (i1 == 0) {
            paramFromServiceMsg.a(str, paramToServiceMsg.extraData.getLong("timestamp"));
          }
        }
        else
        {
          a(18, true, new Object[] { str, Integer.valueOf(i1), Integer.valueOf(i2), paramObject });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(18, false, arrayOfObject);
        return;
      }
      if (i1 == 1) {
        paramFromServiceMsg.i(str);
      }
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    TroopCreatePermissionData localTroopCreatePermissionData = new TroopCreatePermissionData();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(19, false, localTroopCreatePermissionData);
      return;
    }
    int i1 = paramFromServiceMsg.getResultCode();
    if ((i1 == 1002) || (i1 == 1013))
    {
      a(19, false, localTroopCreatePermissionData);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg != null)
      {
        if (paramToServiceMsg.uint32_result.has()) {
          localTroopCreatePermissionData.d = paramToServiceMsg.uint32_result.get();
        }
        if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
          break label159;
        }
        a(19, false, localTroopCreatePermissionData);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(19, false, localTroopCreatePermissionData);
      return;
    }
    a(19, false, localTroopCreatePermissionData);
    return;
    label159:
    paramFromServiceMsg = new oidb_0x88c.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      localTroopCreatePermissionData.a(paramFromServiceMsg.uint32_uin.get());
      if (localTroopCreatePermissionData.d != 0) {
        localTroopCreatePermissionData.b = paramFromServiceMsg.str_errorinfo.get();
      }
      localTroopCreatePermissionData.f = paramFromServiceMsg.uint32_group_mini.get();
      localTroopCreatePermissionData.g = paramFromServiceMsg.uint32_group_500.get();
      localTroopCreatePermissionData.h = paramFromServiceMsg.uint32_group_1k.get();
      localTroopCreatePermissionData.i = paramFromServiceMsg.uint32_group_2k.get();
      localTroopCreatePermissionData.j = paramFromServiceMsg.uint32_created_group_mini.get();
      localTroopCreatePermissionData.k = paramFromServiceMsg.uint32_created_group_500.get();
      localTroopCreatePermissionData.l = paramFromServiceMsg.uint32_created_group_1k.get();
      localTroopCreatePermissionData.m = paramFromServiceMsg.uint32_created_group_2k.get();
      if ((paramFromServiceMsg.uint32_group_mini_freq_avail.has()) && (paramFromServiceMsg.uint32_group_500_freq_avail.has()) && (paramFromServiceMsg.uint32_group_1k_freq_avail.has()) && (paramFromServiceMsg.uint32_group_2k_freq_avail.has()))
      {
        localTroopCreatePermissionData.n = paramFromServiceMsg.uint32_group_mini_freq_avail.get();
        localTroopCreatePermissionData.o = paramFromServiceMsg.uint32_group_500_freq_avail.get();
        localTroopCreatePermissionData.p = paramFromServiceMsg.uint32_group_1k_freq_avail.get();
        localTroopCreatePermissionData.q = paramFromServiceMsg.uint32_group_2k_freq_avail.get();
      }
      a(19, true, localTroopCreatePermissionData);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(19, false, localTroopCreatePermissionData);
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    TroopCreateAdvanceData localTroopCreateAdvanceData = new TroopCreateAdvanceData();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(27, false, localTroopCreateAdvanceData);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(27, false, localTroopCreateAdvanceData);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null)
      {
        a(27, false, localTroopCreateAdvanceData);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(27, false, localTroopCreateAdvanceData);
      return;
    }
    localTroopCreateAdvanceData.e = paramToServiceMsg.uint32_result.get();
    paramFromServiceMsg = new cmd0x8a1.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.uint32_create_option.get() != 2))
      {
        a(27, false, localTroopCreateAdvanceData);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(27, false, localTroopCreateAdvanceData);
      return;
    }
    localTroopCreateAdvanceData.jdField_a_of_type_Long = (paramFromServiceMsg.uint32_group_uin.get() & 0xFFFFFFFF);
    localTroopCreateAdvanceData.f = paramFromServiceMsg.uint32_group_size.get();
    localTroopCreateAdvanceData.b = paramFromServiceMsg.uint32_group_code.get();
    paramObject = paramFromServiceMsg.string_sign.get().toByteArray();
    localTroopCreateAdvanceData.jdField_a_of_type_ArrayOfByte = paramObject;
    int i1 = 0;
    while (i1 < paramObject.length)
    {
      paramFromServiceMsg = Integer.toHexString(paramObject[i1] & 0xFF);
      paramToServiceMsg = paramFromServiceMsg;
      if (paramFromServiceMsg.length() == 1) {
        paramToServiceMsg = '0' + paramFromServiceMsg;
      }
      localTroopCreateAdvanceData.jdField_a_of_type_JavaLangString += paramToServiceMsg.toUpperCase();
      i1 += 1;
    }
    a(27, true, localTroopCreateAdvanceData);
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    TroopCreateLogic.TroopCreateResult localTroopCreateResult = new TroopCreateLogic.TroopCreateResult();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(28, false, localTroopCreateResult);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(28, false, localTroopCreateResult);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg == null)
      {
        a(28, false, localTroopCreateResult);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(28, false, localTroopCreateResult);
      return;
    }
    int i1 = paramFromServiceMsg.uint32_result.get();
    if ((i1 != 0) && ((i1 != 129) || (i1 != 130)))
    {
      localTroopCreateResult.b = i1;
      a(28, false, localTroopCreateResult);
      return;
    }
    paramToServiceMsg = new cmd0x8a1.RspBody();
    try
    {
      paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_create_option.get() != 1))
      {
        a(28, false, localTroopCreateResult);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(28, false, localTroopCreateResult);
      return;
    }
    paramFromServiceMsg = new TroopInfo();
    paramFromServiceMsg.troopowneruin = String.valueOf(paramToServiceMsg.uint64_owner_uin.get());
    paramFromServiceMsg.troopcode = String.valueOf(paramToServiceMsg.uint32_group_uin.get() & 0xFFFFFFFF);
    paramFromServiceMsg.troopuin = String.valueOf(paramToServiceMsg.uint32_group_code.get());
    paramFromServiceMsg.dwAdditionalFlag = 1L;
    paramToServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (paramToServiceMsg != null) {
      paramToServiceMsg.c(paramFromServiceMsg);
    }
    paramToServiceMsg = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
    if (paramToServiceMsg != null) {
      paramToServiceMsg.a(paramFromServiceMsg.troopuin, (byte)0, paramFromServiceMsg.dwTimeStamp, -1);
    }
    TroopRemindSettingManager.a().b(paramFromServiceMsg.troopuin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(28, true, paramFromServiceMsg);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(29, false, null);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(29, false, null);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null)
      {
        a(29, false, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(29, false, null);
      return;
    }
    int i1 = paramToServiceMsg.uint32_result.get();
    if (i1 != 0)
    {
      a(29, false, new Object[] { Long.valueOf(i1) });
      return;
    }
    paramFromServiceMsg = new oidb_0x89a.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (paramFromServiceMsg == null)
      {
        a(29, false, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(29, false, null);
      return;
    }
    a(29, true, new Object[] { Long.valueOf(paramFromServiceMsg.uint64_group_code.get()) });
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("pageUrl");
    ArrayList localArrayList = new ArrayList();
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(25, false, new Object[] { paramToServiceMsg, localArrayList, Integer.valueOf(-1) });
      return;
    }
    paramFromServiceMsg = new video_url.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg.int32_result.get() != 0)
      {
        a(25, false, new Object[] { paramToServiceMsg, localArrayList, Integer.valueOf(-1) });
        return;
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      a(25, false, new Object[] { paramToServiceMsg, localArrayList, Integer.valueOf(-1) });
      return;
    }
    paramObject = paramFromServiceMsg.rpt_bytes_play_urls.get();
    int i1 = paramFromServiceMsg.uint32_total_time.get();
    paramFromServiceMsg = paramObject.iterator();
    while (paramFromServiceMsg.hasNext()) {
      localArrayList.add(new String(((ByteStringMicro)paramFromServiceMsg.next()).toByteArray()));
    }
    a(25, true, new Object[] { paramToServiceMsg, localArrayList, Integer.valueOf(i1) });
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramToServiceMsg.extraData.getBoolean("hideTroopIsHide", false);
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(26, false, Boolean.valueOf(bool));
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(26, false, Boolean.valueOf(bool));
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(26, false, Boolean.valueOf(bool));
      return;
    }
    if (paramToServiceMsg.uint32_result.get() != 0)
    {
      a(26, false, Boolean.valueOf(bool));
      return;
    }
    a(26, true, Boolean.valueOf(bool));
  }
  
  protected Class a()
  {
    return BizTroopObserver.class;
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = new cmd0x8a1.ReqBody();
    ((cmd0x8a1.ReqBody)localObject1).uint32_create_option.set(2);
    Object localObject2 = new cmd0x8a1.SelectGroupCodeInfo();
    ((cmd0x8a1.SelectGroupCodeInfo)localObject2).uint64_owner_uin.set(paramLong);
    ((cmd0x8a1.ReqBody)localObject1).msg_select_group_code_info.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2209);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8a1.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x8a1_0");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("type", 1);
    b((ToServiceMsg)localObject1);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, int paramInt5, long paramLong3, long paramLong4, int paramInt6, String paramString3, byte[] paramArrayOfByte, int paramInt7, boolean paramBoolean)
  {
    cmd0x8a1.ReqBody localReqBody = new cmd0x8a1.ReqBody();
    localReqBody.uint32_create_option.set(1);
    cmd0x8a1.CreateGroupInfo localCreateGroupInfo = new cmd0x8a1.CreateGroupInfo();
    if ((paramInt4 != 0) || (paramInt7 == 3))
    {
      localCreateGroupInfo.uint32_group_code.set(0);
      localCreateGroupInfo.uint32_group_size.set(paramInt1);
      localCreateGroupInfo.uint64_owner_uin.set(paramLong2);
      localCreateGroupInfo.uint32_group_option.set(paramInt2);
      localCreateGroupInfo.string_group_name.set(ByteStringMicro.copyFromUtf8(paramString1));
      localCreateGroupInfo.string_group_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString2));
      localCreateGroupInfo.string_group_rich_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString2));
      localCreateGroupInfo.uint32_group_class.set(0);
      localCreateGroupInfo.uint32_group_class_ext.set(paramInt3);
      localCreateGroupInfo.uint32_conf_uin.set(paramInt4);
      localCreateGroupInfo.uint32_group_type_flag.set(paramInt5);
      if (!paramBoolean) {
        break label409;
      }
      localCreateGroupInfo.uint32_group_face_flag.set(0);
      label168:
      paramString1 = new cmd0x8a1.GroupGeoInfo();
      paramString1.uint32_city_id.set(paramInt6);
      paramString1.uint64_latitude.set(paramLong3);
      paramString1.uint64_longtitude.set(paramLong4);
      paramString1.string_geo_content.set(ByteStringMicro.copyFromUtf8(paramString3));
      localCreateGroupInfo.msg_group_geo_info.set(paramString1);
      if ((paramInt4 == 0) && (paramInt7 != 3)) {
        localCreateGroupInfo.string_sign.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      if ((paramInt4 == 0) && (paramInt7 != 3)) {
        break label421;
      }
      localCreateGroupInfo.uint64_create_flag.set(128L);
    }
    for (;;)
    {
      localCreateGroupInfo.uint32_group_face.set(0);
      localCreateGroupInfo.uint32_app_id.set(0);
      localReqBody.msg_create_group_info.set(localCreateGroupInfo);
      paramString1 = new oidb_sso.OIDBSSOPkg();
      paramString1.uint32_command.set(2209);
      paramString1.uint32_result.set(0);
      paramString1.uint32_service_type.set(0);
      paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      paramString2 = a("OidbSvc.0x8a1_0");
      paramString2.putWupBuffer(paramString1.toByteArray());
      paramString2.extraData.putInt("type", 2);
      b(paramString2);
      return;
      localCreateGroupInfo.uint32_group_code.set((int)paramLong1);
      break;
      label409:
      localCreateGroupInfo.uint32_group_face_flag.set(1);
      break label168;
      label421:
      localCreateGroupInfo.uint64_create_flag.set(0L);
    }
  }
  
  public void a(long paramLong1, int paramInt1, String paramString1, long paramLong2, List paramList, int paramInt2, long paramLong3, long paramLong4, String paramString2, String paramString3)
  {
    oidb_0x89a.ReqBody localReqBody = new oidb_0x89a.ReqBody();
    localReqBody.uint64_group_code.set(paramLong1);
    oidb_0x89a.groupinfo localgroupinfo = new oidb_0x89a.groupinfo();
    localgroupinfo.uint32_group_type_flag.set(paramInt1);
    localgroupinfo.string_group_name.set(ByteStringMicro.copyFromUtf8(paramString1));
    localgroupinfo.uint32_group_class_ext.set((int)paramLong2);
    paramString1 = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < paramList.size())
    {
      if (!TextUtils.isEmpty((CharSequence)paramList.get(paramInt1))) {
        paramString1.add(ByteStringMicro.copyFromUtf8((String)paramList.get(paramInt1)));
      }
      paramInt1 += 1;
    }
    if (paramString1.size() == 0) {
      paramString1.add(ByteStringMicro.copyFrom("".getBytes()));
    }
    localgroupinfo.rpt_string_group_tag.set(paramString1);
    if ((paramLong3 != 0L) || (paramLong4 != 0L))
    {
      paramString1 = new oidb_0x89a.GroupGeoInfo();
      paramString1.uint32_city_id.set(paramInt2);
      paramString1.uint64_latitude.set(paramLong3);
      paramString1.uint64_longtitude.set(paramLong4);
      paramString1.string_geo_content.set(ByteStringMicro.copyFromUtf8(paramString2));
      localgroupinfo.msg_group_geo_info.set(paramString1);
    }
    localgroupinfo.string_group_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString3));
    localgroupinfo.string_group_rich_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString3));
    localReqBody.st_group_info.set(localgroupinfo);
    paramString1 = new oidb_sso.OIDBSSOPkg();
    paramString1.uint32_command.set(2202);
    paramString1.uint32_result.set(0);
    paramString1.uint32_service_type.set(0);
    paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramList = a("OidbSvc.0x89a_0");
    paramList.putWupBuffer(paramString1.toByteArray());
    paramList.extraData.putInt("methodType", 1);
    b(paramList);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "onReceive");
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "res.getServiceCmd():" + paramFromServiceMsg.getServiceCmd());
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (c(str)) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "cmdfilter error=" + str);
      }
    }
    do
    {
      long l1;
      long l2;
      do
      {
        do
        {
          do
          {
            int i3;
            short s1;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    if ("OidbSvc.0x89b_1".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      if (paramToServiceMsg.extraData.getBoolean("isJoin") == true)
                      {
                        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
                        return;
                      }
                      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
                      return;
                    }
                    if (!"OidbSvc.0x8a1_0".equals(str)) {
                      break;
                    }
                    if (paramToServiceMsg.extraData.getInt("type", 0) == 1)
                    {
                      l(paramToServiceMsg, paramFromServiceMsg, paramObject);
                      return;
                    }
                  } while (paramToServiceMsg.extraData.getInt("type", 0) != 2);
                  m(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                  if (("OidbSvc.0x89a_0".equals(str)) || ("OidbSvc.0x570_8".equals(str)))
                  {
                    if (paramToServiceMsg.extraData.getInt("methodType", -1) == 1)
                    {
                      n(paramToServiceMsg, paramFromServiceMsg, paramObject);
                      return;
                    }
                    ((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44)).a(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if (("GroupFileAppSvr.Upload".equals(str)) || ("GroupFileAppSvr.Resend".equals(str)) || ("GroupFileAppSvr.Download".equals(str)) || ("GroupFileAppSvr.FeedMsgV2".equals(str)) || ("GroupFileAppSvr.CopyTo".equals(str)))
                  {
                    TroopFileTransferManager.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if (("GroupFileAppSvr.DelFile".equals(str)) || ("GroupFileAppSvr.GetFileList".equals(str)) || ("GroupFileAppSvr.GetFileListV2".equals(str)) || ("GroupFileAppSvr.TransFile".equals(str)))
                  {
                    TroopFileManager.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if ("CommunityForum.GetLatestPost".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {}
                    for (bool = true;; bool = false)
                    {
                      a(4, bool, paramObject);
                      return;
                    }
                  }
                  if ("OpenGroupSvc.GroupActivityInfo".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    f(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if ("OidbSvc.0x897_0".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    e(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if ("OidbSvc.0x88d_1".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    g(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if ("GroupActivity.GetList".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    i(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if ("OidbSvc.0x78f_1".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    h(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if ("OidbSvc.0x5d6_1".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    j(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if ("OidbSvc.0x88c_1".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    k(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if ("MobileqqApp.IsHasMoreApp".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if (!"OidbSvc.0x580_1".equals(paramFromServiceMsg.getServiceCmd())) {
                    break;
                  }
                } while (paramFromServiceMsg.getResultCode() != 1000);
                i1 = paramToServiceMsg.extraData.getInt("appId");
                l1 = paramToServiceMsg.extraData.getLong("troopUin");
                l2 = paramToServiceMsg.extraData.getLong("troopCode");
                l3 = paramToServiceMsg.extraData.getLong("userUin");
                paramFromServiceMsg = paramToServiceMsg.extraData.getString("feedsId");
                i2 = paramToServiceMsg.extraData.getInt("time");
                str = paramToServiceMsg.extraData.getString("cmd");
                i3 = paramToServiceMsg.extraData.getInt("feedType");
                bool = paramToServiceMsg.extraData.getBoolean("aioRequest", false);
                paramToServiceMsg = (byte[])paramObject;
                paramToServiceMsg = TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, l1, l2, l3, paramFromServiceMsg, i2, paramToServiceMsg);
              } while ((TextUtils.isEmpty(str)) || (paramToServiceMsg == null));
              s1 = (short)paramToServiceMsg.length;
              if ("OidbSvc.0x852_35".equals(str))
              {
                TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, l1, l2, s1, paramToServiceMsg, l3, paramFromServiceMsg, i2);
                return;
              }
            } while (!"OidbSvc.0x852_48".equals(str));
            TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, l1, l2, s1, paramToServiceMsg, (short)i3, bool);
            return;
            if (!"OidbSvc.0x852_35".equals(paramFromServiceMsg.getServiceCmd())) {
              break;
            }
          } while (paramFromServiceMsg.getResultCode() != 1000);
          i1 = paramToServiceMsg.extraData.getInt("appId");
          l1 = paramToServiceMsg.extraData.getLong("troopUin");
          l2 = paramToServiceMsg.extraData.getLong("troopCode");
          long l3 = paramToServiceMsg.extraData.getLong("userUin");
          paramFromServiceMsg = paramToServiceMsg.extraData.getString("feedsId");
          int i2 = paramToServiceMsg.extraData.getInt("time");
          paramToServiceMsg = (byte[])paramObject;
          TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, l1, l2, l3, paramFromServiceMsg, i2, paramToServiceMsg);
          return;
          if (!"OidbSvc.0x852_48".equals(paramFromServiceMsg.getServiceCmd())) {
            break;
          }
        } while (paramFromServiceMsg.getResultCode() != 1000);
        paramToServiceMsg.extraData.getInt("appId");
        l1 = paramToServiceMsg.extraData.getLong("troopUin");
        l2 = paramToServiceMsg.extraData.getLong("troopCode");
        paramToServiceMsg.extraData.getLong("userUin");
        paramToServiceMsg.extraData.getString("feedsId");
        paramToServiceMsg.extraData.getInt("time");
        i1 = paramToServiceMsg.extraData.getInt("feedType");
        boolean bool = paramToServiceMsg.extraData.getBoolean("aioRequest", false);
        paramToServiceMsg = (byte[])paramObject;
        paramToServiceMsg = TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, l2, paramToServiceMsg, i1);
        if ((paramToServiceMsg != null) && (bool))
        {
          BaseApplicationImpl.getContext().getSharedPreferences("troop_new_guid", 0).edit().putBoolean(String.valueOf(l2), true).commit();
          a(24, true, Long.valueOf(l2));
          return;
        }
        if ((i1 == 23) && (paramToServiceMsg != null))
        {
          a(21, true, paramToServiceMsg);
          return;
        }
      } while ((i1 != 34) || (paramToServiceMsg == null));
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramObject = new ArrayList();
      paramObject.add(paramToServiceMsg);
      int i1 = (int)MessageCache.a();
      paramFromServiceMsg.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1), String.valueOf(l2), paramObject, 34, i1);
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if (paramToServiceMsg != null) {
        paramToServiceMsg.sendEmptyMessage(1009);
      }
      BaseApplicationImpl.getContext().getSharedPreferences("troop_new_guid", 0).edit().putBoolean(String.valueOf(l2), true).commit();
      return;
      if ("VideoShareSrv.get_video_src".equals(paramFromServiceMsg.getServiceCmd()))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x568_21".equals(paramFromServiceMsg.getServiceCmd()));
    p(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(Object paramObject)
  {
    a(9, true, paramObject);
  }
  
  public void a(String paramString)
  {
    Object localObject2 = new oidb_0x89b.JoinPublicGroupReqBody();
    ((oidb_0x89b.JoinPublicGroupReqBody)localObject2).uint64_visitor_uin.set(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    Object localObject1 = new oidb_0x89b.ReqBody();
    ((oidb_0x89b.ReqBody)localObject1).uint64_group_code.set(a(paramString));
    ((oidb_0x89b.ReqBody)localObject1).uint32_req_type.set(1);
    ((oidb_0x89b.ReqBody)localObject1).msg_join_group.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2203);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89b.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x89b_1");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("troopCode", paramString);
    ((ToServiceMsg)localObject1).extraData.putBoolean("isJoin", true);
    b((ToServiceMsg)localObject1);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject2 = new oidb_0x5d6.SnsUpdateItem();
    ((oidb_0x5d6.SnsUpdateItem)localObject2).uint32_update_sns_type.set(13569);
    long l1 = NetConnInfoCenter.getServerTime();
    if (paramInt == 0)
    {
      int i1 = (byte)(int)(l1 >> 24 & 0xFF);
      int i2 = (byte)(int)(l1 >> 16 & 0xFF);
      int i3 = (byte)(int)(l1 >> 8 & 0xFF);
      int i4 = (byte)(int)(l1 & 0xFF);
      ((oidb_0x5d6.SnsUpdateItem)localObject2).bytes_value.set(ByteStringMicro.copyFrom(new byte[] { i1, i2, i3, i4 }));
    }
    for (;;)
    {
      Object localObject1 = new ArrayList();
      ((List)localObject1).add(localObject2);
      localObject2 = new oidb_0x5d6.SnsUpateBuffer();
      ((oidb_0x5d6.SnsUpateBuffer)localObject2).uint64_uin.set(a(paramString));
      ((oidb_0x5d6.SnsUpateBuffer)localObject2).rpt_msg_sns_update_item.set((List)localObject1);
      localObject1 = new ArrayList();
      ((List)localObject1).add(localObject2);
      localObject2 = new oidb_0x5d6.ReqBody();
      ((oidb_0x5d6.ReqBody)localObject2).uint32_domain.set(11);
      ((oidb_0x5d6.ReqBody)localObject2).uint32_seq.set(0);
      ((oidb_0x5d6.ReqBody)localObject2).rpt_msg_update_buffer.set((List)localObject1);
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject2).toByteArray()));
      paramString = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).g(paramString);
      localObject2 = a("OidbSvc.0x5d6_1");
      ((ToServiceMsg)localObject2).extraData.putString("troopUin", paramString);
      ((ToServiceMsg)localObject2).extraData.putInt("reqType", paramInt);
      ((ToServiceMsg)localObject2).extraData.putLong("timestamp", l1);
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      b((ToServiceMsg)localObject2);
      return;
      if (paramInt != 1) {}
    }
  }
  
  public void a(String paramString, int paramInt, int... paramVarArgs)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "OidbSvc.0x897_0");
    Object localObject = new cmd0x897.VisitorInfo();
    ((cmd0x897.VisitorInfo)localObject).uint64_visitor_uin.set(0L);
    ((cmd0x897.VisitorInfo)localObject).uint32_visitor_faceid.set(0);
    ((cmd0x897.VisitorInfo)localObject).string_visitor_nick.set(ByteStringMicro.copyFrom(new byte[0]));
    cmd0x897.GroupUinCode localGroupUinCode = new cmd0x897.GroupUinCode();
    try
    {
      localGroupUinCode.uint64_group_code.set(a(paramString));
      paramString = new cmd0x897.GroupNextVisitor();
      paramString.msg_group_uin_code.set(localGroupUinCode);
      paramString.uint64_next_visitor.set(paramInt);
      paramString.msg_req_field.set((MessageMicro)localObject);
      if ((paramVarArgs.length > 0) && (paramVarArgs[0] > 0))
      {
        paramString.uint32_max_count.set(paramVarArgs[0]);
        paramVarArgs = new cmd0x897.ReqBody();
        localObject = new ArrayList();
        ((List)localObject).add(paramString);
        paramVarArgs.rpt_msg_grp_next_visitor.set((List)localObject);
        paramString = new oidb_sso.OIDBSSOPkg();
        paramString.uint32_command.set(2199);
        paramString.uint32_result.set(0);
        paramString.uint32_service_type.set(0);
        paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramVarArgs.toByteArray()));
        localToServiceMsg.putWupBuffer(paramString.toByteArray());
        b(localToServiceMsg);
        return;
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "get open troop member list, send pb request, params : troopUin / troop Code, NumberFormatException");
          continue;
          paramString.uint32_max_count.set(0);
        }
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject = ByteBuffer.allocate(5);
    ((ByteBuffer)localObject).putInt((int)Long.valueOf(paramString).longValue());
    if (paramBoolean) {
      ((ByteBuffer)localObject).put((byte)1);
    }
    for (;;)
    {
      localObject = ((ByteBuffer)localObject).array();
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(1384);
      paramString.uint32_result.set(0);
      paramString.uint32_service_type.set(21);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
      localObject = a("OidbSvc.0x568_21");
      ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("hideTroopIsHide", paramBoolean);
      b((ToServiceMsg)localObject);
      return;
      ((ByteBuffer)localObject).put((byte)0);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramString = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString);
    paramString.putWupBuffer(paramArrayOfByte);
    if (paramBundle != null) {
      paramString.extraData = paramBundle;
    }
    b(paramString);
  }
  
  public void a(List paramList)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "GroupActivity.GetList");
    group_activity.ReqBody localReqBody = new group_activity.ReqBody();
    if ((paramList != null) && (paramList.size() != 0)) {
      localReqBody.uint32_act_id.addAll(paramList);
    }
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    b(localToServiceMsg);
  }
  
  protected boolean a(String paramString)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "OGroupActiInterval");
    long l1;
    if ((str == null) || ("".equals(str)))
    {
      l1 = 86400L;
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        break label270;
      }
    }
    label270:
    for (long l2 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(paramString)).longValue();; l2 = 0L)
    {
      long l3;
      for (;;)
      {
        l3 = System.currentTimeMillis() / 1000L;
        if ((l2 == 0L) || (l3 - l2 >= l1)) {
          break label115;
        }
        return false;
        try
        {
          l1 = Long.valueOf(str).longValue();
        }
        catch (Exception localException)
        {
          l1 = 86400L;
        }
      }
      break;
      label115:
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(l3));
      group_activity_info.ReqBody localReqBody = new group_activity_info.ReqBody();
      localReqBody.group_code.set(a(paramString));
      localReqBody.type.set(2);
      localReqBody.big_pic.set(true);
      localReqBody.small_pic.set(false);
      localReqBody.title.set(true);
      localReqBody.summary.set(true);
      localReqBody.url.set(true);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "OpenGroupSvc.GroupActivityInfo");
      localToServiceMsg.extraData.putString("troopCode", paramString);
      localToServiceMsg.extraData.putBoolean("isFromAIO", true);
      localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
      b(localToServiceMsg);
      return true;
    }
  }
  
  public boolean a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = new oidb_0x78f.ReqBody();
    ((oidb_0x78f.ReqBody)localObject1).group_code.set(a(paramString));
    ((oidb_0x78f.ReqBody)localObject1).num_per_page.set(paramInt2);
    ((oidb_0x78f.ReqBody)localObject1).page_id.set(paramInt1);
    ((oidb_0x78f.ReqBody)localObject1).time_end.set(paramInt3);
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(Integer.valueOf(3));
    ((oidb_0x78f.ReqBody)localObject1).elem_type_list.set((List)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1935);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x78f.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x78f_1");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("troopCode", paramString);
    ((ToServiceMsg)localObject1).extraData.putInt("pageIndex", paramInt1);
    ((ToServiceMsg)localObject1).extraData.putInt("pageCount", paramInt2);
    ((ToServiceMsg)localObject1).extraData.putLong("troopUin", paramLong);
    b((ToServiceMsg)localObject1);
    return true;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return a(paramString);
    }
    return b(paramString);
  }
  
  public void b(Object paramObject)
  {
    a(13, true, paramObject);
  }
  
  public void b(String paramString)
  {
    Object localObject2 = new oidb_0x89b.ExitPublicGroupReqBody();
    ((oidb_0x89b.ExitPublicGroupReqBody)localObject2).uint64_visitor_uin.set(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    Object localObject1 = new oidb_0x89b.ReqBody();
    ((oidb_0x89b.ReqBody)localObject1).uint64_group_code.set(a(paramString));
    ((oidb_0x89b.ReqBody)localObject1).uint32_req_type.set(2);
    ((oidb_0x89b.ReqBody)localObject1).msg_exit_group.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2203);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89b.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x89b_1");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("troopCode", paramString);
    ((ToServiceMsg)localObject1).extraData.putBoolean("isJoin", false);
    b((ToServiceMsg)localObject1);
  }
  
  protected boolean b(String paramString)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "OGroupActiInterval");
    long l1;
    if ((str == null) || ("".equals(str)))
    {
      l1 = 86400L;
      if (!this.b.containsKey(paramString)) {
        break label270;
      }
    }
    label270:
    for (long l2 = ((Long)this.b.get(paramString)).longValue();; l2 = 0L)
    {
      long l3;
      for (;;)
      {
        l3 = System.currentTimeMillis() / 1000L;
        if ((l2 == 0L) || (l3 - l2 >= l1)) {
          break label115;
        }
        return false;
        try
        {
          l1 = Long.valueOf(str).longValue();
        }
        catch (Exception localException)
        {
          l1 = 86400L;
        }
      }
      break;
      label115:
      this.b.put(paramString, Long.valueOf(l3));
      group_activity_info.ReqBody localReqBody = new group_activity_info.ReqBody();
      localReqBody.group_code.set(a(paramString));
      localReqBody.type.set(1);
      localReqBody.big_pic.set(false);
      localReqBody.small_pic.set(true);
      localReqBody.title.set(true);
      localReqBody.summary.set(true);
      localReqBody.url.set(true);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "OpenGroupSvc.GroupActivityInfo");
      localToServiceMsg.extraData.putString("troopCode", paramString);
      localToServiceMsg.extraData.putBoolean("isFromAIO", false);
      localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
      b(localToServiceMsg);
      return true;
    }
  }
  
  public void c(Object paramObject)
  {
    a(20, true, paramObject);
  }
  
  public void c(String paramString)
  {
    Object localObject1 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(0);
    Object localObject2 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(a(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject2).uint32_last_get_group_name_time.set(0);
    oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
    localGroupInfo.string_group_class_text.set(ByteStringMicro.copyFrom(new byte[0]));
    localGroupInfo.string_group_finger_memo.set(ByteStringMicro.copyFrom(new byte[0]));
    localGroupInfo.string_group_name.set(ByteStringMicro.copyFrom(new byte[0]));
    localGroupInfo.uint32_group_visitor_cur_num.set(0);
    localGroupInfo.uint32_group_class_ext.set(0);
    int i1 = (int)(System.currentTimeMillis() / 1000L);
    localGroupInfo.uint32_group_aio_skin_timestamp.set(i1);
    localGroupInfo.uint32_group_board_skin_timestamp.set(i1);
    localGroupInfo.uint32_group_cover_skin_timestamp.set(i1);
    ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set(localGroupInfo);
    ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
    localObject1 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "OidbSvc.0x88d_1");
    ((ToServiceMsg)localObject1).extraData.putString("troopCode", paramString);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    b((ToServiceMsg)localObject1);
  }
  
  protected boolean c(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x89b_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8a1_0");
      this.jdField_a_of_type_JavaUtilSet.add("GroupFileAppSvr.Upload");
      this.jdField_a_of_type_JavaUtilSet.add("GroupFileAppSvr.Resend");
      this.jdField_a_of_type_JavaUtilSet.add("GroupFileAppSvr.Download");
      this.jdField_a_of_type_JavaUtilSet.add("GroupFileAppSvr.FeedMsgV2");
      this.jdField_a_of_type_JavaUtilSet.add("GroupFileAppSvr.CopyTo");
      this.jdField_a_of_type_JavaUtilSet.add("GroupFileAppSvr.DelFile");
      this.jdField_a_of_type_JavaUtilSet.add("GroupFileAppSvr.GetFileList");
      this.jdField_a_of_type_JavaUtilSet.add("GroupFileAppSvr.GetFileListV2");
      this.jdField_a_of_type_JavaUtilSet.add("GroupFileAppSvr.TransFile");
      this.jdField_a_of_type_JavaUtilSet.add("CommunityForum.GetLatestPost");
      this.jdField_a_of_type_JavaUtilSet.add("OpenGroupSvc.GroupActivityInfo");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x897_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x88d_1");
      this.jdField_a_of_type_JavaUtilSet.add("GroupActivity.GetList");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x78f_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5d6_1");
      this.jdField_a_of_type_JavaUtilSet.add("MobileqqApp.IsHasMoreApp");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x852_35");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x580_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x88c_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x852_48");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x89a_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x570_8");
      this.jdField_a_of_type_JavaUtilSet.add("VideoShareSrv.get_video_src");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x568_21");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void d(Object paramObject)
  {
    a(14, true, paramObject);
  }
  
  public void d(String paramString)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "CommunityForum.GetLatestPost");
    CommunityForumLatestPost.ReqBody localReqBody = new CommunityForumLatestPost.ReqBody();
    try
    {
      localReqBody.troop_uin.set(a(paramString));
      localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
      b(localToServiceMsg);
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "get community forum latest posts, send pb request, params : troopUin, NumberFormatException");
        }
      }
    }
  }
  
  public void e(Object paramObject)
  {
    a(22, true, paramObject);
  }
  
  public void e(String paramString)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "MobileqqApp.IsHasMoreApp");
    TroopAppFlagInfo.ReqBody localReqBody = new TroopAppFlagInfo.ReqBody();
    try
    {
      localReqBody.uint64_gcode.set(a(paramString));
      ByteStringMicro localByteStringMicro = ByteStringMicro.copyFrom("6.0.0".getBytes());
      localReqBody.str_version.set(localByteStringMicro);
      localReqBody.uint32_mobile_ostype.set(0);
      localReqBody.uint64_uin.set(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
      localToServiceMsg.extraData.putString("troopCode", paramString);
      localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
      b(localToServiceMsg);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "get TroopApp Flag Info, send pb request, params : troopCode, NumberFormatException");
        }
      }
    }
  }
  
  public void f(String paramString)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "VideoShareSrv.get_video_src");
    Object localObject = ByteStringMicro.copyFrom(paramString.getBytes());
    video_url.ReqBody localReqBody = new video_url.ReqBody();
    localReqBody.bytes_share_url.set((ByteStringMicro)localObject);
    localReqBody.uint32_platform_type.set(2);
    try
    {
      localObject = a();
      localReqBody.bytes_machine_info.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
      i1 = NetworkUtil.a(BaseApplication.getContext());
      if (i1 == 2)
      {
        localReqBody.uint32_network_type.set(1);
        localReqBody.uint32_cur_play_time.set(0);
        localReqBody.bytes_mobileQ_ver.set(ByteStringMicro.copyFrom("6.0.0".getBytes()));
        localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
        localToServiceMsg.extraData.putString("pageUrl", paramString);
        b(localToServiceMsg);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1;
        String str = "";
        continue;
        if (i1 == 3) {
          localReqBody.uint32_network_type.set(2);
        } else if (i1 == 4) {
          localReqBody.uint32_network_type.set(3);
        } else if (i1 == 1) {
          localReqBody.uint32_network_type.set(4);
        } else {
          localReqBody.uint32_network_type.set(255);
        }
      }
    }
  }
  
  public void g(String paramString)
  {
    Object localObject = new oidb_0x88c.ReqBody();
    ((oidb_0x88c.ReqBody)localObject).uint32_appid.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((oidb_0x88c.ReqBody)localObject).uint32_uin.set((int)Long.parseLong(paramString));
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(2188);
    paramString.uint32_result.set(0);
    paramString.uint32_service_type.set(1);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88c.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x88c_1");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    b((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BizTroopHandler
 * JD-Core Version:    0.7.0.1
 */