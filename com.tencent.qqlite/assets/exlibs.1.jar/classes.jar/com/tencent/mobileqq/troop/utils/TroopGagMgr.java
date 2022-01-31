package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.MemberGagInfo;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.PushParam;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import eoz;
import epa;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager.ConfigType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.ReqBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopGagMgr
  implements Manager
{
  public static final int a = 10;
  public static final String a = "TroopGagMgr";
  public static final int b = 5;
  public static final String b = "GagMemberConfig";
  public static final int c = 1;
  public static final String c = "GagMemberCustomConfig";
  public static final int d = 2;
  public static final String d = "troopUin";
  public static final int e = 3;
  public static final String e = "memberUin";
  public static final int f = 4;
  public static final String f = "timpStamp";
  public static final int g = 5;
  public QQAppInterface a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new epa(this);
  Queue jdField_a_of_type_JavaUtilQueue = new LinkedList();
  
  public TroopGagMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(String paramString)
  {
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).e(new TroopGagMgr.GagStatus(this, paramString, a(paramString, false)));
  }
  
  private void a(String paramString, boolean paramBoolean, long paramLong)
  {
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).e(new TroopGagMgr.GagStatus(this, paramString, new TroopGagMgr.GagTroopResult(this, paramBoolean, paramLong)));
  }
  
  private void b(String paramString)
  {
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).e(new TroopGagMgr.GagStatus(this, paramString, a(paramString, false)));
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).e(new TroopGagMgr.GagStatus(this, paramString, a(paramString, paramBoolean)));
  }
  
  private void b(String paramString, boolean paramBoolean, long paramLong)
  {
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).e(new TroopGagMgr.GagStatus(this, paramString, new TroopGagMgr.GagTroopMemberResult(this, paramBoolean, paramLong)));
  }
  
  public TroopGagMgr.GagCustomConfig a()
  {
    Object localObject = Base64Util.a("{\"defday\":2,\"defhour\":0,\"defminute\":0,\"maxday\":30}".getBytes(), 0);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "GagMemberCustomConfig");
    if (!TextUtils.isEmpty(str)) {
      localObject = str;
    }
    for (;;)
    {
      return a(new String(Base64Util.a(((String)localObject).getBytes(), 0)));
    }
  }
  
  public TroopGagMgr.GagCustomConfig a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("parseGagCustomConfig = %s", new Object[] { paramString }));
    }
    try
    {
      paramString = new JSONObject(paramString);
      paramString = new TroopGagMgr.GagCustomConfig(this, paramString.optInt("defday"), paramString.optInt("defhour"), paramString.optInt("defminute"), paramString.optInt("maxday"));
      return paramString;
    }
    catch (JSONException paramString)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopGagMgr", 4, "parseGagCustomConfig failed");
      }
    }
    return null;
  }
  
  public TroopGagMgr.GagItem a(String paramString, int paramInt)
  {
    if (paramString != null) {
      return new TroopGagMgr.GagItem(this, paramString, paramInt);
    }
    return null;
  }
  
  public TroopGagMgr.SelfGagInfo a(String paramString, boolean paramBoolean)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44);
    if (localObject == null) {
      return new TroopGagMgr.SelfGagInfo(this, paramString, false, "", 0L);
    }
    localObject = ((TroopManager)localObject).b(paramString);
    if (localObject == null) {
      return new TroopGagMgr.SelfGagInfo(this, paramString, false, "", 0L);
    }
    long l = NetConnInfoCenter.getServerTime();
    boolean bool = a(paramString);
    if ((((TroopInfo)localObject).dwGagTimeStamp != 0L) && (!bool) && (l < ((TroopInfo)localObject).dwGagTimeStamp))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("getTroopGagInfo:sUin=%s, Troop Gag", new Object[] { paramString }));
      }
      return new TroopGagMgr.SelfGagInfo(this, paramString, true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131362546), 60L);
    }
    if ((((TroopInfo)localObject).dwGagTimeStamp_me != 0L) && (l < ((TroopInfo)localObject).dwGagTimeStamp_me + 3L))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("getTroopGagInfo:sUin=%s, self Gag", new Object[] { paramString }));
      }
      Context localContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
      String str = localContext.getString(2131362547);
      l = ((TroopInfo)localObject).dwGagTimeStamp_me + 3L;
      if (paramBoolean) {
        l = ((TroopInfo)localObject).dwGagTimeStamp_me - 30L;
      }
      return new TroopGagMgr.SelfGagInfo(this, paramString, true, String.format(str, new Object[] { b(localContext, l) }), 60L);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("getTroopGagInfo:sUin=%s, not Gag", new Object[] { paramString }));
    }
    return new TroopGagMgr.SelfGagInfo(this, paramString, false, "", 0L);
  }
  
  public TroopGagMgr.TroopGagInfo a(String paramString, boolean paramBoolean)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44);
    if (localObject == null) {
      return new TroopGagMgr.TroopGagInfo(this, paramString, 0L);
    }
    localObject = ((TroopManager)localObject).b(paramString);
    if (localObject == null) {
      return new TroopGagMgr.TroopGagInfo(this, paramString, 0L);
    }
    return new TroopGagMgr.TroopGagInfo(this, paramString, ((TroopInfo)localObject).dwGagTimeStamp);
  }
  
  public String a(long paramLong)
  {
    int i = 1;
    long l = NetConnInfoCenter.getServerTime();
    paramLong = l + paramLong;
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(l * 1000L);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong);
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6))) {}
    for (;;)
    {
      if (i != 0) {
        return new SimpleDateFormat("MM-dd HH:mm").format(new Date(paramLong));
      }
      return new SimpleDateFormat("HH:mm").format(new Date(paramLong));
      i = 0;
    }
  }
  
  public String a(Context paramContext, long paramLong)
  {
    return String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131362548), new Object[] { b(paramContext, paramLong) });
  }
  
  public String a(Context paramContext, long paramLong1, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    paramContext = ((Context)localObject).getString(2131362549);
    String str = ((Context)localObject).getString(2131362550);
    localObject = ((Context)localObject).getString(2131362551);
    if (paramLong1 < 60L) {
      return String.format("约%d%s", new Object[] { Integer.valueOf(1), paramContext });
    }
    if (paramLong1 <= 3540L) {
      return String.format("约%d%s", new Object[] { Long.valueOf((59L + paramLong1) / 60L), paramContext });
    }
    if (paramLong1 <= 84600L) {
      return String.format("约%d%s", new Object[] { Long.valueOf(Math.round((float)paramLong1 * 1.0F / 3600.0F)), str });
    }
    return String.format("约%d%s", new Object[] { Long.valueOf(Math.round((float)paramLong1 * 1.0F / 86400.0F)), localObject });
  }
  
  public String a(String paramString)
  {
    FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localFriendManager == null) {
      return "";
    }
    paramString = localFriendManager.a(paramString);
    if (paramString == null) {
      return "";
    }
    if (paramString.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
      return "1";
    }
    return "2";
  }
  
  public ArrayList a()
  {
    Object localObject = Base64Util.a("[{\"seconds\":600,\"text\":\"10分钟\"},{\"seconds\":3600,\"text\":\"1小时\"},{\"seconds\":43200,\"text\":\"12小时\"},{\"seconds\":86400,\"text\":\"1天\"}]".getBytes(), 0);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "GagMemberConfig");
    if (!TextUtils.isEmpty(str)) {
      localObject = str;
    }
    for (;;)
    {
      return a(new String(Base64Util.a(((String)localObject).getBytes(), 0)));
    }
  }
  
  public ArrayList a(String paramString)
  {
    int i = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("parseGagConfig = %s", new Object[] { paramString }));
    }
    localArrayList = new ArrayList();
    try
    {
      paramString = new JSONArray(paramString);
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        localArrayList.add(new TroopGagMgr.GagItem(this, localJSONObject.optString("text"), localJSONObject.optInt("seconds")));
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopGagMgr", 4, "parseGagConfig failed");
      }
    }
  }
  
  public ArrayList a(String paramString, boolean paramBoolean)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44);
    if (localObject == null) {
      localObject = null;
    }
    ArrayList localArrayList;
    do
    {
      return localObject;
      localArrayList = ((TroopManager)localObject).a(paramString);
      localObject = localArrayList;
    } while (!paramBoolean);
    b(paramString, null);
    return localArrayList;
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt2)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilQueue.iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (paramInt1 == ((Integer)((Iterator)localObject1).next()).intValue())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopGagMgr", 4, String.format("Discard message", new Object[0]));
        }
        return;
      }
    }
    if (this.jdField_a_of_type_JavaUtilQueue.size() > 30) {
      this.jdField_a_of_type_JavaUtilQueue.poll();
    }
    this.jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(paramInt1));
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    localObject1 = String.valueOf(paramLong1);
    if (TextUtils.isEmpty(paramString)) {
      if (paramLong3 == 0L) {
        paramString = ((Context)localObject2).getResources().getString(2131362624);
      }
    }
    for (;;)
    {
      localObject2 = (MessageForGrayTips)MessageRecordFactory.a(-1013);
      ((MessageForGrayTips)localObject2).frienduin = ((String)localObject1);
      ((MessageForGrayTips)localObject2).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (String)localObject1, (String)localObject1, paramString, paramLong2, -1013, 1, paramInt1);
      ((MessageForGrayTips)localObject2).isread = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      return;
      paramString = ((Context)localObject2).getResources().getString(2131362625);
      continue;
      if (paramLong3 == 0L) {
        paramString = ((Context)localObject2).getResources().getString(2131362623, new Object[] { paramString });
      } else {
        paramString = ((Context)localObject2).getResources().getString(2131362622, new Object[] { paramString, d((Context)localObject2, paramLong3) });
      }
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, long paramLong3, ArrayList paramArrayList)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilQueue.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramInt == ((Integer)((Iterator)localObject).next()).intValue())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopGagMgr", 4, String.format("Discard message", new Object[0]));
        }
        return;
      }
    }
    if (this.jdField_a_of_type_JavaUtilQueue.size() > 30) {
      this.jdField_a_of_type_JavaUtilQueue.poll();
    }
    this.jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(paramInt));
    String str1 = String.valueOf(paramLong1);
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    localObject = localFriendsManagerImp.a(String.valueOf(paramLong1));
    if (localObject == null)
    {
      localObject = new TroopInfo();
      ((TroopInfo)localObject).troopuin = String.valueOf(paramLong1);
    }
    for (;;)
    {
      String str3 = String.valueOf(paramLong2);
      boolean bool = ((TroopInfo)localObject).troopowneruin.equalsIgnoreCase(str3);
      paramArrayList = paramArrayList.iterator();
      int i = 0;
      if (paramArrayList.hasNext())
      {
        PushParam localPushParam = (PushParam)paramArrayList.next();
        String str4 = localPushParam.jdField_a_of_type_JavaLangString;
        if ((localPushParam.jdField_a_of_type_Long == 0L) || (localPushParam.jdField_a_of_type_Long == 4294967295L))
        {
          paramLong2 = localPushParam.jdField_a_of_type_Long;
          label249:
          if (str4.equals(str2))
          {
            ((TroopInfo)localObject).dwGagTimeStamp_me = paramLong2;
            localFriendsManagerImp.b((TroopInfo)localObject);
            b(str1, true);
            a(str1, str3, paramLong3, localPushParam.jdField_a_of_type_Long, paramInt, false, bool);
          }
          if (!str4.equals("0")) {
            break label372;
          }
          ((TroopInfo)localObject).dwGagTimeStamp = paramLong2;
          localFriendsManagerImp.b((TroopInfo)localObject);
          a(str1);
          b(str1, true);
          a(str1, str3, paramLong3, localPushParam.jdField_a_of_type_Long, paramInt, true, bool);
        }
        for (;;)
        {
          break;
          paramLong2 = paramLong3 + localPushParam.jdField_a_of_type_Long;
          break label249;
          label372:
          if (!str4.equals(str2)) {
            a(str1, paramLong3, localPushParam.jdField_a_of_type_Long, paramInt, str3, str4, bool);
          }
          i = 1;
          localFriendsManagerImp.a(paramLong1 + "", str4, null, -100, null, null, -100, -100, -100, -100L, paramLong2);
        }
      }
      if (i == 0) {
        break;
      }
      b(str1);
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(paramInt), paramBoolean);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((!a(paramToServiceMsg, paramFromServiceMsg, paramObject)) && (!b(paramToServiceMsg, paramFromServiceMsg, paramObject))) {}
    for (int i = 0;; i = 1)
    {
      if ((i == 0) && (QLog.isDevelopLevel())) {
        QLog.i("TroopGagMgr", 4, "bad subcmd" + paramFromServiceMsg.getServiceCmd());
      }
      return;
    }
  }
  
  public final void a(String paramString, long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("doGagTroop : sUin = %s", new Object[] { paramString }));
    }
    Object localObject1 = new oidb_0x89a.ReqBody();
    ((oidb_0x89a.ReqBody)localObject1).uint64_group_code.set(Long.valueOf(paramString).longValue());
    Object localObject2 = new oidb_0x89a.groupinfo();
    ((oidb_0x89a.groupinfo)localObject2).uint32_shutup_time.set((int)paramLong);
    ((oidb_0x89a.ReqBody)localObject1).st_group_info.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2202);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89a.ReqBody)localObject1).toByteArray()));
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("troopUin", paramString);
    ((Bundle)localObject1).putLong("timpStamp", paramLong);
    ((Bundle)localObject1).putInt("key_subcmd", 2);
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a("OidbSvc.0x89a_0", ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray(), (Bundle)localObject1);
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagMgr", 2, "----------addTroopGagTipsMr friendUin: " + paramString1);
    }
    boolean bool = a(paramString1);
    Context localContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    int i;
    Object localObject1;
    label87:
    Object localObject4;
    Object localObject3;
    Object localObject2;
    int j;
    Object localObject5;
    if ((paramBoolean) && (bool))
    {
      i = 2131362559;
      localObject1 = localContext.getString(i);
      if (paramLong2 == 0L) {
        break label515;
      }
      i = 2131362562;
      localObject4 = localContext.getString(i);
      localObject3 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      localObject2 = ((FriendsManagerImp)localObject3).a(paramString1, paramString2);
      localObject3 = ((FriendsManagerImp)localObject3).a(paramString1, paramString3);
      j = 0;
      i = 0;
      localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (((String)localObject5).equalsIgnoreCase(paramString2))
      {
        localObject1 = " 被你";
        localObject2 = "";
        i = 1;
      }
      if (!((String)localObject5).equalsIgnoreCase(paramString3)) {
        break label611;
      }
      localObject1 = "你" + (String)localObject1;
      localObject3 = "";
      j = 1;
    }
    label515:
    label611:
    for (;;)
    {
      if ((!bool) || (i != 0))
      {
        localObject5 = "";
        localObject2 = localObject1;
        localObject1 = localObject5;
        localObject5 = (String)localObject3 + (String)localObject2 + (String)localObject1 + (String)localObject4;
        localObject4 = localObject5;
        if (paramLong2 != 0L) {
          localObject4 = (String)localObject5 + d(localContext, paramLong2);
        }
        localObject5 = (MessageForGrayTips)MessageRecordFactory.a(-1013);
        ((MessageForGrayTips)localObject5).frienduin = paramString1;
        ((MessageForGrayTips)localObject5).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1, paramString1, (String)localObject4, paramLong1, -1013, 1, paramInt);
        if (!StringUtil.b((String)localObject3))
        {
          paramString1 = new Bundle();
          paramString1.putInt("key_action", 5);
          paramString1.putString("troop_mem_uin", paramString3);
          paramString1.putBoolean("need_update_nick", true);
          ((MessageForGrayTips)localObject5).addHightlightItem(0, ((String)localObject3).length(), paramString1);
        }
        paramString1 = (String)localObject3 + (String)localObject2;
        if (!StringUtil.b((String)localObject1))
        {
          paramString3 = new Bundle();
          paramString3.putInt("key_action", 5);
          paramString3.putString("troop_mem_uin", paramString2);
          paramString3.putBoolean("need_update_nick", true);
          ((MessageForGrayTips)localObject5).addHightlightItem(paramString1.length(), paramString1.length() + ((String)localObject1).length(), paramString3);
        }
        ((MessageForGrayTips)localObject5).isread = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        return;
        i = 2131362560;
        break;
        i = 2131362563;
        break label87;
      }
      if (j == 0) {
        localObject1 = " " + (String)localObject1;
      }
      for (;;)
      {
        localObject5 = (String)localObject1 + " ";
        localObject4 = " " + (String)localObject4;
        localObject1 = localObject2;
        localObject2 = localObject5;
        break;
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    b(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagMgr", 2, "----------addTroopGagTipsMr friendUin: " + paramString1);
    }
    boolean bool = a(paramString1);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    Object localObject1;
    Object localObject2;
    if (!paramBoolean1)
    {
      localObject1 = ((Context)localObject3).getString(2131362561);
      if ((paramBoolean2) && (bool))
      {
        localObject2 = (String)localObject1 + ((Context)localObject3).getString(2131362559);
        if (!paramBoolean1) {
          break label425;
        }
        if (paramLong2 == 0L) {
          break label412;
        }
        localObject1 = ((Context)localObject3).getString(2131362566);
      }
    }
    label412:
    label425:
    label555:
    for (;;)
    {
      label126:
      localObject3 = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramString1, paramString2);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equalsIgnoreCase(paramString2)) {
        localObject2 = "你";
      }
      for (int i = 1;; i = 0)
      {
        String str;
        if ((!bool) || (i != 0))
        {
          str = "";
          localObject3 = localObject2;
          localObject2 = str;
        }
        for (;;)
        {
          str = (String)localObject3 + (String)localObject2 + (String)localObject1;
          localObject1 = (MessageForGrayTips)MessageRecordFactory.a(-1013);
          ((MessageForGrayTips)localObject1).frienduin = paramString1;
          ((MessageForGrayTips)localObject1).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1, paramString1, str, paramLong1, -1013, 1, paramInt);
          if (!StringUtil.b((String)localObject2))
          {
            paramString1 = new Bundle();
            paramString1.putInt("key_action", 5);
            paramString1.putString("troop_mem_uin", paramString2);
            paramString1.putBoolean("need_update_nick", true);
            ((MessageForGrayTips)localObject1).addHightlightItem(((String)localObject3).length(), ((String)localObject3).length() + ((String)localObject2).length(), paramString1);
          }
          ((MessageForGrayTips)localObject1).isread = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          return;
          localObject2 = (String)localObject1 + ((Context)localObject3).getString(2131362560);
          break;
          if ((paramBoolean2) && (bool))
          {
            localObject2 = ((Context)localObject3).getString(2131362565);
            break;
          }
          localObject2 = ((Context)localObject3).getString(2131362564);
          break;
          localObject1 = ((Context)localObject3).getString(2131362567);
          break label126;
          if (paramLong2 != 0L) {}
          for (i = 2131362562;; i = 2131362563)
          {
            localObject1 = ((Context)localObject3).getString(i);
            if (paramLong2 == 0L) {
              break label555;
            }
            localObject1 = (String)localObject1 + d((Context)localObject3, paramLong2);
            break;
          }
          str = (String)localObject2 + " ";
          localObject1 = " " + (String)localObject1;
          localObject2 = localObject3;
          localObject3 = str;
        }
      }
    }
  }
  
  public final void a(String paramString, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopGagMgr", 4, String.format("doGagTroopMember:sUin=%s, empty arList error", new Object[] { paramString }));
      }
      return;
    }
    int i = 0;
    String str = "";
    while (i < paramArrayList.size())
    {
      localObject = (TroopGagMgr.GagMemberParam)paramArrayList.get(i);
      str = str + ((TroopGagMgr.GagMemberParam)localObject).jdField_a_of_type_JavaLangString + ((TroopGagMgr.GagMemberParam)localObject).jdField_a_of_type_Long + "|";
      i += 1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("doGagTroopMember:sUin=%s sMemberUins=%s", new Object[] { paramString, str }));
    }
    Object localObject = ByteBuffer.allocate(paramArrayList.size() * 8 + 7);
    ((ByteBuffer)localObject).putInt((int)Long.valueOf(paramString).longValue());
    ((ByteBuffer)localObject).put((byte)32);
    ((ByteBuffer)localObject).putShort((short)paramArrayList.size());
    i = 0;
    str = null;
    long l = 0L;
    while (i < paramArrayList.size())
    {
      TroopGagMgr.GagMemberParam localGagMemberParam = (TroopGagMgr.GagMemberParam)paramArrayList.get(i);
      ((ByteBuffer)localObject).putInt((int)Long.valueOf(localGagMemberParam.jdField_a_of_type_JavaLangString).longValue());
      ((ByteBuffer)localObject).putInt((int)localGagMemberParam.jdField_a_of_type_Long);
      str = localGagMemberParam.jdField_a_of_type_JavaLangString;
      l = localGagMemberParam.jdField_a_of_type_Long;
      i += 1;
    }
    localObject = ((ByteBuffer)localObject).array();
    paramArrayList = new oidb_sso.OIDBSSOPkg();
    paramArrayList.uint32_command.set(1392);
    paramArrayList.uint32_result.set(0);
    paramArrayList.uint32_service_type.set(8);
    paramArrayList.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
    localObject = new Bundle();
    ((Bundle)localObject).putString("troopUin", paramString);
    ((Bundle)localObject).putString("memberUin", str);
    ((Bundle)localObject).putLong("timpStamp", l);
    ((Bundle)localObject).putInt("key_subcmd", 2);
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a("OidbSvc.0x570_8", paramArrayList.toByteArray(), (Bundle)localObject);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Context localContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    int i = localContext.getResources().getDimensionPixelSize(2131492887);
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new eoz(this, paramBoolean, localContext, paramString, i));
      return;
    }
    if (paramBoolean)
    {
      QQToast.a(localContext, 2, paramString, 0).b(i);
      return;
    }
    QQToast.a(localContext, 2130837991, paramString, 0).b(i);
  }
  
  public final boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 2131362555;
    if (!"OidbSvc.0x89a_0".equals(paramFromServiceMsg.getServiceCmd())) {
      return false;
    }
    String str = paramToServiceMsg.extraData.getString("troopUin");
    long l = paramToServiceMsg.extraData.getLong("timpStamp");
    paramToServiceMsg = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(str, false, l);
      if (l == 0L) {}
      for (i = 2131362555;; i = 2131362552)
      {
        a(i, false);
        if (QLog.isDevelopLevel()) {
          QLog.e("TroopGagMgr", 4, String.format("onRspGagTroop : sUin = %s, failed", new Object[] { str }));
        }
        return true;
      }
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(str, false, l);
        return true;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(str, false, l);
      if (l == 0L) {}
      for (;;)
      {
        a(i, false);
        return true;
        i = 2131362552;
      }
      if (paramToServiceMsg.uint32_result.get() != 0)
      {
        if (l == 0L) {}
        for (;;)
        {
          a(i, false);
          a(str, false, l);
          return true;
          i = 2131362552;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("onRspGagTroop : sUin = %s, succeeded", new Object[] { str }));
      }
      a(str, true, l);
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44);
    if (localObject == null) {}
    do
    {
      return false;
      localObject = ((TroopManager)localObject).a(paramString);
    } while (localObject == null);
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    boolean bool;
    if ((!TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)) && (paramString.equals(((TroopInfo)localObject).troopowneruin))) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (!TextUtils.isEmpty(((TroopInfo)localObject).Administrator))
      {
        localObject = ((TroopInfo)localObject).Administrator.split("\\|");
        if (localObject != null)
        {
          int j = localObject.length;
          int i = 0;
          for (;;)
          {
            if (i >= j) {
              break label135;
            }
            if (localObject[i].equalsIgnoreCase(paramString))
            {
              bool = true;
              break;
            }
            i += 1;
          }
        }
      }
      label135:
      bool = false;
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("gagTroop: sUin=%s", new Object[] { paramString }));
    }
    a(paramString, paramLong);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44);
    if (localTroopManager == null) {
      return false;
    }
    paramString1 = localTroopManager.a(paramString1, paramString2);
    NetConnInfoCenter.getServerTime();
    if ((paramString1.jdField_a_of_type_Long != 0L) && (paramString1.jdField_a_of_type_Long > NetConnInfoCenter.getServerTime())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new TroopGagMgr.GagMemberParam(this, paramString2, paramLong));
    a(paramString1, localArrayList);
    return true;
  }
  
  public boolean a(String paramString, ArrayList paramArrayList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("gagTroopMember:sUin=%s ", new Object[] { paramString }));
    }
    a(paramString, paramArrayList);
    return true;
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = PkgTools.a(paramArrayOfByte, 0);
    int i = paramArrayOfByte[4];
    long l2;
    long l3;
    if (i == 12)
    {
      i = paramArrayOfByte[5];
      l2 = PkgTools.a(paramArrayOfByte, 6);
      PkgTools.a(paramArrayOfByte, 10);
      l3 = NetConnInfoCenter.getServerTime();
      int k = PkgTools.a(paramArrayOfByte, 14);
      int j = 16;
      ArrayList localArrayList = new ArrayList();
      i = 0;
      while (i < k)
      {
        long l4 = PkgTools.a(paramArrayOfByte, j);
        j += 4;
        long l5 = PkgTools.a(paramArrayOfByte, j);
        j += 4;
        localArrayList.add(new PushParam(String.valueOf(l4), l5));
        i += 1;
      }
      a(paramInt, l1, l2, l3, localArrayList);
      return true;
    }
    if (i == 14)
    {
      i = paramArrayOfByte[5];
      PkgTools.a(paramArrayOfByte, 6);
      l2 = NetConnInfoCenter.getServerTime();
      l3 = PkgTools.a(paramArrayOfByte, 10);
      i = paramArrayOfByte[14];
      a(paramInt, l1, l2, l3, PkgTools.a(paramArrayOfByte, 15, i), paramArrayOfByte[(i + 15)]);
    }
    return false;
  }
  
  public String b(Context paramContext, long paramLong)
  {
    long l = NetConnInfoCenter.getServerTime();
    if (paramLong <= l)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("error: gagTimeToStringCountDown gagTime <= currentTimeMs", new Object[0]));
      }
      return "";
    }
    return a(paramContext, paramLong - l, paramLong);
  }
  
  public final boolean b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"OidbSvc.0x570_8".equals(paramFromServiceMsg.getServiceCmd())) {
      return false;
    }
    String str1 = paramToServiceMsg.extraData.getString("troopUin");
    String str2 = paramToServiceMsg.extraData.getString("memberUin");
    long l = paramToServiceMsg.extraData.getLong("timpStamp");
    paramToServiceMsg = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopGagMgr", 4, String.format("onRspTroopMember:sUin %s sMemberUin=%s, failed", new Object[] { str1, str2 }));
      }
      b(str1, false, l);
      if (paramFromServiceMsg.getResultCode() == 10)
      {
        if (l == 0L) {}
        for (i = 2131362557;; i = 2131362554)
        {
          a(i, false);
          b(str1, false, l);
          return true;
        }
      }
      if (l == 0L) {}
      for (i = 2131362557;; i = 2131362554)
      {
        a(i, false);
        break;
      }
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        b(str1, false, l);
        return true;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      b(str1, false, l);
      if (l == 0L) {}
      for (i = 2131362557;; i = 2131362554)
      {
        a(i, false);
        return true;
      }
      if (paramToServiceMsg.uint32_result.get() != 0)
      {
        if (paramToServiceMsg.uint32_result.get() == 10)
        {
          if (l == 0L) {}
          for (i = 2131362557;; i = 2131362554)
          {
            a(i, false);
            b(str1, false, l);
            return true;
          }
        }
        if (l == 0L) {}
        for (i = 2131362557;; i = 2131362554)
        {
          a(i, false);
          break;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("onRspTroopMember:sUin=%s sMemberUin=%s, succeeded", new Object[] { str1, str2 }));
      }
      b(str1, true, l);
      if (l != 0L) {}
    }
    for (int i = 2131362556;; i = 2131362553)
    {
      a(i, true);
      return true;
    }
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("fetchGagTroopList:sUin=%s", new Object[] { paramString1 }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17);
    if (localTroopHandler != null)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2))
        {
          localTroopHandler.b(Long.parseLong(paramString1), 0L, 6, null, 0, 0);
        }
        else
        {
          long l1 = Long.parseLong(paramString1);
          long l2 = Long.parseLong(paramString2);
          paramString1 = new ArrayList();
          paramString1.add(Long.valueOf(l2));
          localTroopHandler.b(l1, 0L, 3, paramString1, 0, 0);
        }
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopGagMgr", 2, paramString1.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break label198;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    label198:
    return true;
  }
  
  public String c(Context paramContext, long paramLong)
  {
    long l = NetConnInfoCenter.getServerTime();
    if (paramLong <= l)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("error: gagTimeToString gagTime <= currentTimeMs", new Object[0]));
      }
      return "";
    }
    return d(paramContext, paramLong - l);
  }
  
  public String d(Context paramContext, long paramLong)
  {
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    String str1 = paramContext.getString(2131362549);
    String str2 = paramContext.getString(2131362550);
    Object localObject = paramContext.getString(2131362551);
    if (paramLong < 60L) {
      paramContext = 1 + str1;
    }
    long l2;
    do
    {
      return paramContext;
      l2 = 59L + paramLong;
      paramLong = l2 / 86400L;
      long l1 = (l2 - 86400L * paramLong) / 3600L;
      l2 = (l2 - 86400L * paramLong - 3600L * l1) / 60L;
      paramContext = "";
      if (paramLong > 0L) {
        paramContext = "" + paramLong + (String)localObject;
      }
      localObject = paramContext;
      if (l1 > 0L) {
        localObject = paramContext + l1 + str2;
      }
      paramContext = (Context)localObject;
    } while (l2 <= 0L);
    return (String)localObject + l2 + str1;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGagMgr
 * JD-Core Version:    0.7.0.1
 */