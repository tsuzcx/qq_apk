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
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import hcj;
import hck;
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
  public static final String c = "troopUin";
  public static final int d = 2;
  public static final String d = "memberUin";
  public static final int e = 3;
  public static final String e = "timpStamp";
  public static final int f = 4;
  public static final int g = 5;
  public QQAppInterface a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new hck(this);
  Queue jdField_a_of_type_JavaUtilQueue = new LinkedList();
  
  public TroopGagMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(String paramString)
  {
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).e(new TroopGagMgr.GagStatus(this, paramString, a(paramString, false)));
  }
  
  private void a(String paramString, boolean paramBoolean, long paramLong)
  {
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).e(new TroopGagMgr.GagStatus(this, paramString, new TroopGagMgr.GagTroopResult(this, paramBoolean, paramLong)));
  }
  
  private void b(String paramString)
  {
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).e(new TroopGagMgr.GagStatus(this, paramString, a(paramString, false)));
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).e(new TroopGagMgr.GagStatus(this, paramString, a(paramString, paramBoolean)));
  }
  
  private void b(String paramString, boolean paramBoolean, long paramLong)
  {
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).e(new TroopGagMgr.GagStatus(this, paramString, new TroopGagMgr.GagTroopMemberResult(this, paramBoolean, paramLong)));
  }
  
  public TroopGagMgr.SelfGagInfo a(String paramString, boolean paramBoolean)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
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
      return new TroopGagMgr.SelfGagInfo(this, paramString, true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131560664), 60L);
    }
    if ((((TroopInfo)localObject).dwGagTimeStamp_me != 0L) && (l < ((TroopInfo)localObject).dwGagTimeStamp_me + 3L))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("getTroopGagInfo:sUin=%s, self Gag", new Object[] { paramString }));
      }
      Context localContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
      String str = localContext.getString(2131560665);
      l = ((TroopInfo)localObject).dwGagTimeStamp_me + 3L;
      if (paramBoolean) {
        l = ((TroopInfo)localObject).dwGagTimeStamp_me - 30L;
      }
      return new TroopGagMgr.SelfGagInfo(this, paramString, true, String.format(str, new Object[] { a(localContext, l) }), 60L);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("getTroopGagInfo:sUin=%s, not Gag", new Object[] { paramString }));
    }
    return new TroopGagMgr.SelfGagInfo(this, paramString, false, "", 0L);
  }
  
  public TroopGagMgr.TroopGagInfo a(String paramString, boolean paramBoolean)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
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
    long l = NetConnInfoCenter.getServerTime();
    if (paramLong <= l)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("error: gagTimeToString gagTime <= currentTimeMs", new Object[0]));
      }
      return "";
    }
    return b(paramContext, paramLong - l);
  }
  
  public ArrayList a()
  {
    int i = LocaleUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
    Object localObject;
    if ((i == 2) || (i == 3))
    {
      localObject = "[{\"seconds\":600,\"text\":\"10分钟\"},{\"seconds\":3600,\"text\":\"1小时\"},{\"seconds\":43200,\"text\":\"12小时\"},{\"seconds\":86400,\"text\":\"1天\"}]";
      localObject = Base64Util.a(((String)localObject).getBytes(), 0);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "GagMemberConfig");
      if (TextUtils.isEmpty(str)) {
        break label85;
      }
      localObject = str;
    }
    label85:
    for (;;)
    {
      return a(new String(Base64Util.a(((String)localObject).getBytes(), 0)));
      localObject = "[{\"seconds\":600,\"text\":\"10 minutes\"},{\"seconds\":3600,\"text\":\"1 hours\"},{\"seconds\":43200,\"text\":\"12 hours\"},{\"seconds\":86400,\"text\":\"1 day\"}]";
      break;
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
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
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
      if (((TroopInfo)localObject).troopowneruin == String.valueOf(paramLong2)) {}
      paramArrayList = paramArrayList.iterator();
      paramInt = 0;
      if (paramArrayList.hasNext())
      {
        PushParam localPushParam = (PushParam)paramArrayList.next();
        String str3 = localPushParam.jdField_a_of_type_JavaLangString;
        if ((localPushParam.jdField_a_of_type_Long == 0L) || (localPushParam.jdField_a_of_type_Long == -1L))
        {
          paramLong2 = localPushParam.jdField_a_of_type_Long;
          label242:
          if (str3.equals(str2))
          {
            ((TroopInfo)localObject).dwGagTimeStamp_me = paramLong2;
            localFriendsManagerImp.b((TroopInfo)localObject);
            b(str1, true);
          }
          if (!str3.equals("0")) {
            break label327;
          }
          ((TroopInfo)localObject).dwGagTimeStamp = paramLong2;
          localFriendsManagerImp.b((TroopInfo)localObject);
          a(str1);
          b(str1, true);
        }
        for (;;)
        {
          break;
          paramLong2 = paramLong3 + localPushParam.jdField_a_of_type_Long;
          break label242;
          label327:
          localFriendsManagerImp.a(paramLong1 + "", str3, null, -100, null, null, -100, -100, -100, -100L, paramLong2);
          paramInt = 1;
        }
      }
      if (paramInt == 0) {
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
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).a("OidbSvc.0x89a_0", ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray(), (Bundle)localObject1);
  }
  
  public void a(String paramString1, String paramString2)
  {
    b(paramString1, paramString2);
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
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).a("OidbSvc.0x570_8", paramArrayList.toByteArray(), (Bundle)localObject);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Context localContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    int i = localContext.getResources().getDimensionPixelSize(2131427376);
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new hcj(this, paramBoolean, localContext, paramString, i));
      return;
    }
    if (paramBoolean)
    {
      QQToast.a(localContext, 2, paramString, 0).b(i);
      return;
    }
    QQToast.a(localContext, 2130837959, paramString, 0).b(i);
  }
  
  public final boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 2131560672;
    if (!"OidbSvc.0x89a_0".equals(paramFromServiceMsg.getServiceCmd())) {
      return false;
    }
    String str = paramToServiceMsg.extraData.getString("troopUin");
    long l = paramToServiceMsg.extraData.getLong("timpStamp");
    paramToServiceMsg = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(str, false, l);
      if (l == 0L) {}
      for (i = 2131560672;; i = 2131560669)
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
        i = 2131560669;
      }
      if (paramToServiceMsg.uint32_result.get() != 0)
      {
        if (l == 0L) {}
        for (;;)
        {
          a(i, false);
          a(str, false, l);
          return true;
          i = 2131560669;
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
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
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
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
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
  
  public String b(Context paramContext, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    paramContext = ((Context)localObject).getString(2131560666);
    String str = ((Context)localObject).getString(2131560667);
    localObject = ((Context)localObject).getString(2131560668);
    if (paramLong < 60L) {
      return 1 + paramContext;
    }
    if (paramLong <= 3540L)
    {
      paramLong = (59L + paramLong) / 60L;
      return paramLong + paramContext;
    }
    if (paramLong <= 82800L)
    {
      paramLong = (3599L + paramLong) / 3600L;
      return paramLong + str;
    }
    paramLong = (86399L + paramLong) / 86400L;
    return paramLong + (String)localObject;
  }
  
  public final boolean b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"OidbSvc.0x570_8".equals(paramFromServiceMsg.getServiceCmd())) {
      return false;
    }
    String str1 = paramToServiceMsg.extraData.getString("troopUin");
    String str2 = paramToServiceMsg.extraData.getString("memberUin");
    long l = paramToServiceMsg.extraData.getLong("timpStamp");
    paramToServiceMsg = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopGagMgr", 4, String.format("onRspTroopMember:sUin %s sMemberUin=%s, failed", new Object[] { str1, str2 }));
      }
      b(str1, false, l);
      if (paramFromServiceMsg.getResultCode() == 10)
      {
        if (l == 0L) {}
        for (i = 2131560674;; i = 2131560671)
        {
          a(i, false);
          b(str1, false, l);
          return true;
        }
      }
      if (l == 0L) {}
      for (i = 2131560674;; i = 2131560671)
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
      for (i = 2131560674;; i = 2131560671)
      {
        a(i, false);
        return true;
      }
      if (paramToServiceMsg.uint32_result.get() != 0)
      {
        if (paramToServiceMsg.uint32_result.get() == 10)
        {
          if (l == 0L) {}
          for (i = 2131560674;; i = 2131560671)
          {
            a(i, false);
            b(str1, false, l);
            return true;
          }
        }
        if (l == 0L) {}
        for (i = 2131560674;; i = 2131560671)
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
    for (int i = 2131560673;; i = 2131560670)
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
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
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
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGagMgr
 * JD-Core Version:    0.7.0.1
 */