package com.tencent.mobileqq.app;

import AvatarInfo.QQHeadInfo;
import AvatarInfo.QQHeadUrlReq;
import AvatarInfo.QQHeadUrlResp;
import GeneralSettings.RespGetSettings;
import GeneralSettings.RespSetSettings;
import KQQ.ChangeFriendNameRes;
import KQQ.CheckUpdateResp;
import KQQ.GetRichSigRes;
import KQQ.ProfSmpInfoRes;
import KQQ.ResRichSigInfo;
import KQQ.RespItem;
import KQQ.SetRichSigRes;
import MessageSvcPack.RequestPushFStatus;
import QQService.BindUinResult;
import QQService.EVIPSPEC;
import QQService.SvcDevLoginInfo;
import QQService.SvcRespKikOut;
import QQService.SvcRspBindUin;
import QQService.SvcRspDelLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import SecurityAccountServer.RespondQueryQQBindingStat;
import SummaryCard.RespCondSearch;
import SummaryCard.RespHead;
import SummaryCard.RespSearch;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlReq;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlRsp;
import com.tencent.avatarinfo.QQHeadUrl.ReqUsrInfo;
import com.tencent.avatarinfo.QQHeadUrl.RspHeadInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.device_lock_confirm_auth.DeviceInfo;
import com.tencent.ims.device_lock_confirm_auth.ReqBody;
import com.tencent.ims.device_lock_recommend_auth.DeviceInfo;
import com.tencent.ims.device_lock_recommend_auth.ReqBody;
import com.tencent.ims.device_lock_recommend_auth.RspBody;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.contact.OnlineStatusIconHelper;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.antiphing.DeviceLockItemInfo;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Ability;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
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
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactConfig;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sc.qzonepush.QQService.SvcRespRegister;
import com.tencent.widget.TraceUtils;
import fcf;
import fcg;
import fch;
import fci;
import fcj;
import fcl;
import ffs;
import friendlist.AddFriendResp;
import friendlist.AddGroupResp;
import friendlist.DelFriendResp;
import friendlist.DelGroupResp;
import friendlist.FriendInfo;
import friendlist.GetFriendListResp;
import friendlist.GetLastLoginInfoResp;
import friendlist.GetOnlineInfoResp;
import friendlist.GetSimpleOnlineFriendInfoResp;
import friendlist.GetUserAddFriendSettingResp;
import friendlist.GroupInfo;
import friendlist.LastLoginInfo;
import friendlist.LastLoginPageInfo;
import friendlist.MovGroupMemResp;
import friendlist.ReSortGroupResp;
import friendlist.RenameGroupResp;
import friendlist.SetGroupResp;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.Constants.Key;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.ServerConfigManager.ConfigType;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpdateItem;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ClearFriendIdReq;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ClearFriendIdRsp;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ReqBody;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.RspBody;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.SetFriendIdReq;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.SetFriendIdRsp;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class FriendListHandler
  extends BusinessHandler
{
  public static final int A = 41;
  public static final int B = 42;
  public static final int C = 43;
  public static final int D = 44;
  public static final int E = 45;
  public static final int F = 47;
  public static final int G = 48;
  public static final int H = 49;
  public static final int I = 50;
  public static final int J = 51;
  public static final int K = 52;
  public static final int L = 53;
  public static final int M = 54;
  public static final int N = 55;
  public static final int O = 56;
  public static final int P = 57;
  public static final int Q = 58;
  public static final int R = 59;
  public static final int S = 60;
  public static final int T = 61;
  public static final int U = 62;
  public static final int V = 63;
  public static final int W = 64;
  public static final int X = 65;
  public static final int Y = 66;
  public static final int Z = 67;
  public static final byte a = 0;
  public static final int a = 1;
  public static final long a = 2048L;
  public static final String a = "get_troop_member";
  private static final boolean jdField_a_of_type_Boolean = true;
  public static final int aA = 2;
  public static final int aB = 3;
  public static final int aC = 4;
  public static final int aD = 0;
  public static final int aE = 1;
  public static final int aF = 2;
  private static final int aG = 20;
  private static final int aH = 200;
  private static final int aI = 100;
  private static final int aL = 0;
  private static final int aN = 15;
  public static final int aa = 68;
  public static final int ab = 69;
  public static final int ac = 70;
  public static final int ad = 71;
  public static final int ae = 72;
  public static final int af = 73;
  public static final int ag = 1;
  public static final int ah = 4;
  public static final int ai = 8;
  public static final int aj = 11;
  public static final int ak = 100;
  public static final int al = 60000;
  public static final int am = 0;
  public static final int an = 9201;
  public static final int ao = 9202;
  public static final int ap = 9203;
  public static final int aq = 9204;
  public static final int ar = 9205;
  public static final int as = 9206;
  public static final int at = 9207;
  public static final int au = 4051;
  public static final int av = 1;
  public static final int aw = 2;
  public static final int ax = 146;
  public static final int ay = 147;
  public static final int az = 1;
  public static final byte b = 1;
  public static final int b = 2;
  public static final long b = 102400L;
  public static final String b = "uin";
  public static final byte c = 0;
  public static final int c = 3;
  private static final long jdField_c_of_type_Long = 60000L;
  public static final String c = "safety_flag";
  public static final byte d = 1;
  public static final int d = 4;
  private static final long jdField_d_of_type_Long = 5000L;
  private static final String jdField_d_of_type_JavaLangString = "FriendListHandler";
  public static final byte e = 2;
  public static final int e = 7;
  private static final long jdField_e_of_type_Long = 8L;
  private static final String jdField_e_of_type_JavaLangString = "Q.qqhead.flh";
  public static final byte f = 0;
  public static final int f = 8;
  private static final long jdField_f_of_type_Long = 1800000L;
  private static final String jdField_f_of_type_JavaLangString = "StatusEntry";
  public static final byte g = 1;
  public static final int g = 9;
  public static final byte h = 2;
  public static final int h = 10;
  public static final byte i = 0;
  public static final int i = 11;
  private static final long i = 15000L;
  public static final byte j = 1;
  public static final int j = 12;
  public static final byte k = 2;
  public static final int k = 13;
  private static final long k = 15000L;
  public static final int l = 14;
  public static final int m = 15;
  public static final int n = 16;
  public static final int o = 18;
  public static final int p = 19;
  public static final int q = 21;
  public static final int r = 22;
  public static final int s = 27;
  public static final int t = 28;
  public static final int u = 30;
  public static final int v = 33;
  public static final int w = 35;
  public static final int x = 37;
  public static final int y = 38;
  public static final int z = 39;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QvipSpecialCareManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager = null;
  private ProxyListener jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener = new fcg(this);
  private ffs jdField_a_of_type_Ffs;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  private int aJ = 0;
  private int aK = -1;
  private int aM = 0;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private Hashtable jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_b_of_type_Boolean;
  private Hashtable jdField_c_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_c_of_type_Boolean = false;
  private Hashtable jdField_d_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_d_of_type_Boolean = false;
  private long g = 0L;
  private long h = 0L;
  private final long j = 86400000L;
  private long l = 15000L;
  private long m = 0L;
  
  public FriendListHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_AndroidOsHandler = new fcf(this, paramQQAppInterface.a().getMainLooper());
    OnlineStatusIconHelper.a();
    try
    {
      this.jdField_b_of_type_Boolean = ContactConfig.a(paramQQAppInterface.a().getApplicationContext(), paramQQAppInterface.getAccount());
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  public static int a(VipBaseInfo paramVipBaseInfo, int paramInt1, int paramInt2)
  {
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(paramInt1));
      if (paramVipBaseInfo != null) {}
    }
    else
    {
      return paramInt2;
    }
    if (paramVipBaseInfo.bOpen) {}
    for (paramInt1 = 1;; paramInt1 = 0) {
      return (paramInt1 << 8 | (byte)paramVipBaseInfo.iVipType & 0xFF) << 16 | (short)paramVipBaseInfo.iVipLevel;
    }
  }
  
  private int a(ToServiceMsg paramToServiceMsg)
  {
    int i1 = 0;
    try
    {
      Object localObject = ByteBuffer.wrap(paramToServiceMsg.getWupBuffer());
      paramToServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
      ((ByteBuffer)localObject).get(paramToServiceMsg);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramToServiceMsg);
      int i2 = ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get();
      i1 = i2;
    }
    catch (Exception paramToServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "getServiceTypeFromToServiceMsg error:" + paramToServiceMsg.getMessage());
    }
    return i1;
    return 0;
  }
  
  private long a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (;;)
    {
      return 0L;
      try
      {
        long l1 = Long.parseLong(paramString);
        if (l1 >= 10000L) {
          return l1;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return 0L;
  }
  
  private Map a(ArrayList paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayList != null)
    {
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        GeneralSettings.Setting localSetting = (GeneralSettings.Setting)paramArrayList.get(i1);
        localHashMap.put(localSetting.Path, Integer.valueOf(Integer.parseInt(localSetting.Value)));
        i1 += 1;
      }
    }
    return localHashMap;
  }
  
  private void a(int paramInt, String paramString1, byte paramByte1, byte paramByte2, String paramString2)
  {
    boolean bool;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.flh", 2, "getQQHead|type=" + paramInt + ", uinOrMobile=" + paramString1 + ",sourceType=" + paramByte1 + ", faceFileType=" + paramByte2 + ", encid=" + paramString2);
      }
      if (paramInt == 1)
      {
        bool = Friends.isValidUin(paramString1);
        if (bool) {}
      }
      for (;;)
      {
        return;
        if ((paramString1 != null) && (!paramString1.equals("")))
        {
          if (d(paramString1)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.flh", 2, "getQQHead|repeat type=" + paramInt + ", uinOrMobile=" + paramString1);
          }
        }
      }
      b(paramString1, false);
    }
    finally {}
    this.aJ += 1;
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(paramInt));
    if (localArrayList == null)
    {
      localArrayList = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashtable.put(Integer.valueOf(paramInt), localArrayList);
    }
    for (;;)
    {
      bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt, paramString1);
      for (;;)
      {
        long l2 = 0L;
        long l1 = l2;
        if (bool)
        {
          Pair localPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt, paramString1);
          l1 = l2;
          if (localPair != null)
          {
            l1 = l2;
            if (localPair.second != null) {
              l1 = ((com.tencent.mobileqq.data.Setting)localPair.second).headImgTimestamp;
            }
          }
        }
        localArrayList.add(new FriendListHandler.QQHeadDetails(paramInt, paramString1, l1, paramByte1, paramString2));
        if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b())) {
          break;
        }
        if (this.aJ >= 10) {
          e();
        }
        d();
        break;
        bool = true;
        continue;
        bool = false;
      }
      switch (paramByte2)
      {
      }
    }
  }
  
  private void a(long paramLong, int paramInt, ArrayList paramArrayList)
  {
    int i2 = 0;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      localObject2 = ((StringBuilder)localObject1).append("realGetQQHead|dstUsrType=").append(paramInt).append(", size=");
      if (paramArrayList != null) {}
      for (i1 = paramArrayList.size();; i1 = 0)
      {
        ((StringBuilder)localObject2).append(i1);
        if (paramArrayList == null) {
          break;
        }
        i1 = 0;
        while (i1 < paramArrayList.size())
        {
          ((StringBuilder)localObject1).append(',').append(paramArrayList.get(i1));
          i1 += 1;
        }
      }
      QLog.d("Q.qqhead.flh", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    Object localObject1 = a("AvatarInfoSvr.QQHeadUrlReq", null);
    Object localObject2 = new ArrayList();
    int i1 = i2;
    while (i1 < paramArrayList.size())
    {
      ((ArrayList)localObject2).add(((FriendListHandler.QQHeadDetails)paramArrayList.get(i1)).a());
      i1 += 1;
    }
    ((ToServiceMsg)localObject1).extraData.putParcelableArrayList("uinList", paramArrayList);
    ((ToServiceMsg)localObject1).extraData.putLong("startTime", System.currentTimeMillis());
    paramArrayList = new QQHeadUrlReq(paramLong, (ArrayList)localObject2, (byte)paramInt);
    localObject2 = new JceOutputStream();
    ((JceOutputStream)localObject2).setServerEncoding("UTF-8");
    paramArrayList.writeTo((JceOutputStream)localObject2);
    ((ToServiceMsg)localObject1).extraData.putByteArray("QQHeadUrlReq", ((JceOutputStream)localObject2).toByteArray());
    a((ToServiceMsg)localObject1);
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3)
  {
    long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ToServiceMsg localToServiceMsg = a("friendlist.GetLastLoginInfoReq");
    localToServiceMsg.extraData.putLong("uin", l1);
    localToServiceMsg.extraData.putLong("total_req_times", paramLong1);
    localToServiceMsg.extraData.putLong("current_req_index", paramLong2);
    localToServiceMsg.extraData.putLong("current_req_uin", paramLong3);
    a(localToServiceMsg);
  }
  
  private void a(FriendsManagerImp paramFriendsManagerImp)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager = new QvipSpecialCareManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a();
    if ((paramFriendsManagerImp != null) && (localObject != null) && (((Set)localObject).size() > 0))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramFriendsManagerImp.b(str))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.b(str);
          if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.b(str)) {
            this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.c(str);
          }
        }
      }
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, DelFriendResp paramDelFriendResp)
  {
    if (paramDelFriendResp.errorCode != 0)
    {
      a(15, false, null);
      return;
    }
    paramFromServiceMsg = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.b();
    }
    ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).d(String.valueOf(paramDelFriendResp.deluin));
    paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = paramFromServiceMsg.a(String.valueOf(paramDelFriendResp.deluin), 0);
    if (localRecentUser != null) {
      paramFromServiceMsg.b(localRecentUser);
    }
    a(15, true, Long.valueOf(paramDelFriendResp.deluin));
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, GetLastLoginInfoResp paramGetLastLoginInfoResp)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramGetLastLoginInfoResp != null) && (paramGetLastLoginInfoResp.errorCode == 0))
    {
      paramFromServiceMsg = paramGetLastLoginInfoResp.stPageInfo;
      ArrayList localArrayList = paramGetLastLoginInfoResp.vecLastLoginInfo;
      FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      a(localArrayList);
      if (paramFromServiceMsg.dwCurrentReqIndex == paramFromServiceMsg.dwTotalReqTimes)
      {
        ContactConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramGetLastLoginInfoResp.iRefreshIntervalMin);
        a(48, true, Boolean.valueOf(true));
      }
      while (paramFromServiceMsg.dwCurrentReqIndex >= paramFromServiceMsg.dwTotalReqTimes) {
        return;
      }
      a(48, true, Boolean.valueOf(false));
      a(paramFromServiceMsg.dwTotalReqTimes, paramFromServiceMsg.dwCurrentReqIndex, paramFromServiceMsg.dwCurrentReqUin);
      return;
    }
    a(48, false, Boolean.valueOf(true));
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, GetUserAddFriendSettingResp paramGetUserAddFriendSettingResp)
  {
    if (paramGetUserAddFriendSettingResp.result == 0)
    {
      paramFromServiceMsg = new Bundle();
      paramFromServiceMsg.putString("uin", b(paramGetUserAddFriendSettingResp.queryuin));
      paramFromServiceMsg.putInt("friend_setting", paramGetUserAddFriendSettingResp.queryuinsetting);
      paramFromServiceMsg.putStringArrayList("user_question", paramGetUserAddFriendSettingResp.vecStrUserQuestion);
      paramFromServiceMsg.putBoolean("contact_bothway", paramGetUserAddFriendSettingResp.contact_bothway_friend);
      if ((paramGetUserAddFriendSettingResp.name != null) && (paramGetUserAddFriendSettingResp.name.length > 0)) {
        paramFromServiceMsg.putString("friend_mobile_number", new String(paramGetUserAddFriendSettingResp.name));
      }
      a(12, true, paramFromServiceMsg);
      return;
    }
    a(12, false, null);
  }
  
  @Deprecated
  private void a(FromServiceMsg paramFromServiceMsg, String[] paramArrayOfString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramFromServiceMsg.getUin()).createEntityManager();
    paramFromServiceMsg = localEntityManager.a();
    paramFromServiceMsg.a();
    for (;;)
    {
      int i1;
      try
      {
        int i2 = paramArrayOfString.length;
        i1 = 0;
        if (i1 < i2)
        {
          String str = paramArrayOfString[i1];
          Ability localAbility = (Ability)localEntityManager.a(Ability.class, str);
          if (localAbility == null)
          {
            localAbility = new Ability();
            localAbility.uin = str;
            localAbility.flags = 2;
            localEntityManager.a(localAbility);
          }
          else
          {
            localAbility.addAbility(2);
            localEntityManager.a(localAbility);
          }
        }
      }
      finally
      {
        paramFromServiceMsg.b();
      }
      paramFromServiceMsg.c();
      paramFromServiceMsg.b();
      return;
      i1 += 1;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    ArrayList localArrayList = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
    Object localObject;
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      localObject = paramToServiceMsg.append("handleGetQQHeadError, result=").append(paramInt).append(", uinListSize=");
      if (localArrayList != null)
      {
        paramInt = localArrayList.size();
        ((StringBuilder)localObject).append(paramInt);
      }
    }
    for (;;)
    {
      if ((localArrayList == null) || (localArrayList.size() == 0)) {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqhead.flh", 2, paramToServiceMsg.toString());
        }
      }
      do
      {
        return;
        paramInt = -1;
        break;
        paramInt = 0;
        while (paramInt < localArrayList.size())
        {
          localObject = (FriendListHandler.QQHeadDetails)localArrayList.get(paramInt);
          String str = ((FriendListHandler.QQHeadDetails)localObject).jdField_a_of_type_JavaLangString;
          b(str, true);
          if ((QLog.isColorLevel()) && (localObject != null)) {
            paramToServiceMsg.append("; uin=").append(str).append(", timestamp=").append(((FriendListHandler.QQHeadDetails)localObject).jdField_a_of_type_Long);
          }
          paramInt += 1;
        }
      } while (!QLog.isColorLevel());
      QLog.w("Q.qqhead.flh", 2, paramToServiceMsg.toString());
      return;
      paramToServiceMsg = null;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.extraData.getInt("setId") == 4051) {
      b(paramToServiceMsg, paramFromServiceMsg);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg arg2, QQHeadUrlResp paramQQHeadUrlResp)
  {
    int i1;
    if ((??? == null) || (???.getResultCode() != 1000) || (paramQQHeadUrlResp == null) || (paramQQHeadUrlResp.result != 0) || (paramQQHeadUrlResp.UserHeadInfoList == null))
    {
      i1 = 65535;
      if (paramQQHeadUrlResp != null)
      {
        i1 = paramQQHeadUrlResp.result;
        a(paramToServiceMsg, i1);
      }
    }
    for (;;)
    {
      return;
      if (??? == null) {
        break;
      }
      i1 = ???.getResultCode();
      break;
      Object localObject = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        ??? = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label236;
          }
          FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)((Iterator)localObject).next();
          Iterator localIterator = paramQQHeadUrlResp.UserHeadInfoList.iterator();
          if (localIterator.hasNext())
          {
            QQHeadInfo localQQHeadInfo = (QQHeadInfo)localIterator.next();
            if (((localQQHeadInfo.dstUsrType == 11) || (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(String.valueOf(localQQHeadInfo.uin)))) && ((localQQHeadInfo.dstUsrType != 11) || (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(localQQHeadInfo.phoneNum)))) {
              break;
            }
            localQQHeadInfo.soruceType = localQQHeadDetails.jdField_a_of_type_Byte;
            ???.add(localQQHeadInfo);
          }
        }
        label236:
        paramQQHeadUrlResp.UserHeadInfoList = ???;
      }
      if (this.jdField_a_of_type_Ffs == null) {}
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Ffs == null) {
          this.jdField_a_of_type_Ffs = new ffs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        i1 = 0;
        if (i1 >= paramQQHeadUrlResp.UserHeadInfoList.size()) {
          continue;
        }
        ??? = (QQHeadInfo)paramQQHeadUrlResp.UserHeadInfoList.get(i1);
        this.jdField_a_of_type_Ffs.a(???, paramToServiceMsg);
        i1 += 1;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, RespGetSettings paramRespGetSettings)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "handleGetGeneralSettingAll cmd=" + paramFromServiceMsg.getMsfCommand() + " resp.isSucc=" + paramFromServiceMsg.isSuccess() + " resultCode=" + paramFromServiceMsg.getResultCode());
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      int i3 = paramToServiceMsg.extraData.getInt("Revision");
      int i2 = paramToServiceMsg.extraData.getInt("respRevision", -1);
      boolean bool = paramToServiceMsg.extraData.getBoolean("needTroopSettings");
      long l1 = paramToServiceMsg.extraData.getLong("Offset");
      paramToServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("Paths");
      if (paramRespGetSettings == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "handlerGetGeneralSettingAll, data == null");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e(false, true);
        a(35, false, new Object[] { Boolean.valueOf(true) });
        return;
      }
      if ((paramRespGetSettings.Settings == null) || (paramRespGetSettings.Settings.size() == 0))
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder().append("handlerGetGeneralSettingAll, data.Settings=");
          if (paramRespGetSettings.Settings != null) {
            break label289;
          }
        }
        label289:
        for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramRespGetSettings.Settings.size()))
        {
          QLog.d("RoamSetting", 2, paramToServiceMsg);
          DBUtils.a().a(paramRespGetSettings.Revision, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e(true, true);
          a(35, true, new Object[] { Boolean.valueOf(true) });
          return;
        }
      }
      if ((i2 != -1) && (i2 < paramRespGetSettings.Revision))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "respRevision != data.Revision, load settings again, respRev=" + i2 + " data.Rev=" + paramRespGetSettings.Revision);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e(false, false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(bool);
        a(35, true, new Object[] { Boolean.valueOf(false) });
        return;
      }
      int i1 = i2;
      if (i2 == -1) {
        i1 = paramRespGetSettings.Revision;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder().append("oldRevision=").append(i3).append(" lastRespRevision=").append(i1).append(" total=").append(paramRespGetSettings.Total).append(" offset=").append(l1).append(" data.settings.size=");
        if (paramRespGetSettings.Settings != null) {
          break label591;
        }
      }
      label591:
      for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramRespGetSettings.Settings.size()))
      {
        QLog.d("RoamSetting", 2, paramToServiceMsg);
        DBUtils.a().a(paramRespGetSettings.Settings, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        l1 += paramRespGetSettings.Settings.size();
        if (paramRespGetSettings.Total <= l1) {
          break;
        }
        ((RoamSettingController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(28)).a(i3, l1, i1, bool, null);
        a(35, true, new Object[] { Boolean.valueOf(false) });
        return;
      }
      DBUtils.a().a(paramRespGetSettings.Revision, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e(true, true);
      a(35, true, new Object[] { Boolean.valueOf(true) });
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e(false, true);
    a(35, false, new Object[] { Boolean.valueOf(true) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, RespSetSettings paramRespSetSettings)
  {
    boolean bool1 = false;
    Object localObject = (ArrayList)paramToServiceMsg.extraData.getSerializable("Settings");
    int i2 = paramToServiceMsg.extraData.getInt("localRevision");
    int i1;
    boolean bool2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("handlerUploadRoamSettingNewValue isSuccess = ").append(paramFromServiceMsg.isSuccess()).append(" reqLocalRevision=").append(i2).append(" data.Revision=");
      if (paramRespSetSettings == null)
      {
        paramToServiceMsg = "null";
        QLog.d("FriendListHandler", 2, paramToServiceMsg);
      }
    }
    else
    {
      paramToServiceMsg = (RoamSettingController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(28);
      if (!paramFromServiceMsg.isSuccess()) {
        break label207;
      }
      if (i2 + 1 != paramRespSetSettings.Revision) {
        break label189;
      }
      DBUtils.a().a((ArrayList)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(true, false);
      i1 = 1;
      bool2 = true;
      label156:
      if (localObject != null) {
        break label225;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RoamSetting", 2, "handlerUploadRoamSettingNewValue  settings is null.");
      }
    }
    label189:
    label207:
    label225:
    do
    {
      return;
      paramToServiceMsg = Integer.valueOf(paramRespSetSettings.Revision);
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(false, true);
      i1 = 0;
      bool2 = true;
      break label156;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(false, false);
      i1 = 1;
      bool2 = false;
      break label156;
      if (i1 != 0) {
        break label278;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RoamSetting", 2, "handlerUploadRoamSettingNewValue, need load data again. reqLocalRevision=" + i2 + " data.revision=" + paramRespSetSettings.Revision);
    return;
    label278:
    paramFromServiceMsg = b((ArrayList)localObject);
    paramRespSetSettings = ((ArrayList)localObject).iterator();
    label291:
    if (paramRespSetSettings.hasNext())
    {
      localObject = (GeneralSettings.Setting)paramRespSetSettings.next();
      if (((GeneralSettings.Setting)localObject).Path == null) {
        break label1061;
      }
      if (!((GeneralSettings.Setting)localObject).Path.startsWith("message.group.policy.")) {
        break label459;
      }
      if ((bool1) || ((!bool2) && ((bool2) || (!paramToServiceMsg.a())))) {
        break label370;
      }
      a(38, bool2, paramFromServiceMsg);
      bool1 = true;
    }
    label459:
    for (;;)
    {
      break label291;
      break;
      label370:
      if (QLog.isColorLevel())
      {
        QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject).Path + " value=" + ((GeneralSettings.Setting)localObject).Value + " hasNotifyTroop=" + bool1 + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
        continue;
        if (((GeneralSettings.Setting)localObject).Path.startsWith("message.ring.switch"))
        {
          if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
            a(43, bool2, paramFromServiceMsg);
          } else if (QLog.isColorLevel()) {
            QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject).Path + " value=" + ((GeneralSettings.Setting)localObject).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
          }
        }
        else if (((GeneralSettings.Setting)localObject).Path.startsWith("message.vibrate.switch"))
        {
          if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
            a(44, bool2, paramFromServiceMsg);
          } else if (QLog.isColorLevel()) {
            QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject).Path + " value=" + ((GeneralSettings.Setting)localObject).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
          }
        }
        else if (((GeneralSettings.Setting)localObject).Path.startsWith("sync.c2c_message"))
        {
          if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
            a(47, bool2, paramFromServiceMsg);
          } else if (QLog.isColorLevel()) {
            QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject).Path + " value=" + ((GeneralSettings.Setting)localObject).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
          }
        }
        else if (((GeneralSettings.Setting)localObject).Path.startsWith("message.group.ring"))
        {
          if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
            a(41, bool2, paramFromServiceMsg);
          } else if (QLog.isColorLevel()) {
            QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject).Path + " value=" + ((GeneralSettings.Setting)localObject).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
          }
        }
        else if (((GeneralSettings.Setting)localObject).Path.startsWith("message.group.vibrate")) {
          if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
            a(42, bool2, paramFromServiceMsg);
          } else if (QLog.isColorLevel()) {
            QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject).Path + " value=" + ((GeneralSettings.Setting)localObject).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
          }
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRespKikOut paramSvcRespKikOut)
  {
    int i1 = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerKickOutDev index = " + i1);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRespKikOut == null)
      {
        a(52, false, new Object[] { Long.valueOf(-1L), Integer.valueOf(-1), Integer.valueOf(i1) });
        return;
      }
      a(52, true, new Object[] { Long.valueOf(paramSvcRespKikOut.appid), Integer.valueOf(paramSvcRespKikOut.result), Integer.valueOf(i1) });
      return;
    }
    if (paramSvcRespKikOut == null)
    {
      a(52, false, new Object[] { Long.valueOf(-1L), Integer.valueOf(-1), Integer.valueOf(i1) });
      return;
    }
    a(52, false, new Object[] { Long.valueOf(-1L), Integer.valueOf(-1), Integer.valueOf(i1) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspBindUin paramSvcRspBindUin)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handlerBindUinStaus success");
      }
      if (paramSvcRspBindUin != null)
      {
        paramToServiceMsg = paramSvcRspBindUin.vecResult;
        if (paramToServiceMsg != null)
        {
          int i1 = 0;
          if (i1 < paramToServiceMsg.size())
          {
            paramFromServiceMsg = (BindUinResult)paramToServiceMsg.get(i1);
            if (paramFromServiceMsg == null) {}
            for (;;)
            {
              i1 += 1;
              break;
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "result iResult = " + paramFromServiceMsg.iResult + "; lUin = " + paramFromServiceMsg.lUin + "; strResult = " + paramFromServiceMsg.strResult);
              }
            }
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("FriendListHandler", 2, "handlerBindUinStaus res no success");
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int i1 = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerDelMultiClient index = " + i1);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        a(61, false, new Object[] { null, Integer.valueOf(i1) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        a(61, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
        return;
      }
      a(61, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      a(61, false, new Object[] { null, Integer.valueOf(i1) });
      return;
    }
    a(61, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(50, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        int i1;
        if ((paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size() > 0))
        {
          i1 = 0;
          if (i1 < paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.get(i1);
            if (paramToServiceMsg != null) {}
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          if (paramToServiceMsg.vecGuid == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, "handlerMultiClientList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
            }
          }
          else
          {
            if (NetConnInfoCenter.GUID == null) {
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerMultiClientList NetConnInfoCenter.GUID is null");
              }
            }
            while (Arrays.equals(paramToServiceMsg.vecGuid, NetConnInfoCenter.GUID))
            {
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.remove(i1);
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.add(0, paramToServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerMultiClientList Arrays true");
              }
              a(50, true, new Object[] { paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo, paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo });
              return;
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerMultiClientList NetConnInfoCenter.GUID =" + PkgTools.b(NetConnInfoCenter.GUID) + "; info.guid = " + PkgTools.b(paramToServiceMsg.vecGuid));
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                paramFromServiceMsg.printStackTrace();
              }
            }
          }
        }
      }
      a(50, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(50, false, null);
      return;
    }
    a(50, false, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetFriendListResp paramGetFriendListResp)
  {
    if ((paramGetFriendListResp.result == 1) || (paramGetFriendListResp.vecFriendInfo == null) || (paramGetFriendListResp.vecFriendInfo.isEmpty())) {
      return;
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
    FriendInfo localFriendInfo = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(0);
    Friends localFriends1 = new Friends();
    localFriends1.name = localFriendInfo.nick;
    if (localFriendInfo.isRemark == 1) {
      paramToServiceMsg = localFriendInfo.remark;
    }
    boolean bool;
    Friends localFriends2;
    for (;;)
    {
      localFriends1.remark = paramToServiceMsg;
      localFriends1.uin = String.valueOf(localFriendInfo.friendUin);
      localFriends1.faceid = localFriendInfo.faceId;
      localFriends1.groupid = localFriendInfo.groupId;
      localFriends1.sqqtype = localFriendInfo.sqqtype;
      localFriends1.status = localFriendInfo.status;
      localFriends1.cSpecialFlag = localFriendInfo.cSpecialFlag;
      if (localFriendInfo.isMqqOnLine == 1)
      {
        bool = true;
        localFriends1.isMqqOnLine = bool;
        localFriends1.sqqOnLineState = localFriendInfo.sqqOnLineState;
        localFriends1.detalStatusFlag = localFriendInfo.detalStatusFlag;
        localFriends1.memberLevel = localFriendInfo.memberLevel;
        localFriends1.alias = localFriendInfo.sShowName;
        localFriends1.isRemark = localFriendInfo.isRemark;
        localFriends1.isIphoneOnline = localFriendInfo.isIphoneOnline;
        localFriends1.iTermType = localFriendInfo.iTermType;
        localFriends1.cNetwork = localFriendInfo.cNetwork;
        localFriends1.abilityBits = localFriendInfo.uAbiFlag;
        localFriends1.netTypeIconId = localFriendInfo.eIconType;
        if (((localFriendInfo.iTermType == 67586) || (localFriendInfo.iTermType == 66566) || (localFriendInfo.iTermType == 72194) || (localFriendInfo.iTermType == 65804) || (localFriendInfo.iTermType == 72706)) && (localFriendInfo.eNetworkType != 1))
        {
          localFriends1.netTypeIconIdIphoneOrWphoneNoWifi = localFriendInfo.eIconType;
          localFriends1.netTypeIphoneOrWphoneNoWifi = localFriendInfo.eNetworkType;
        }
        if (localFriends1.eNetwork != localFriendInfo.eNetworkType)
        {
          localFriends1.eNetwork = localFriendInfo.eNetworkType;
          a(13, true, null);
        }
        localFriends1.setShieldFlag(false);
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "FriendListHandler handleGetFriendDetailInfo uin=" + localFriends1.uin + " | eNetwork=" + localFriends1.eNetwork + " | iTermType=" + localFriends1.iTermType + " | abilityBits=" + localFriends1.abilityBits + " | name=" + localFriends1.name + " | netTypeIconId=" + localFriends1.netTypeIconId + " | detalStatusFlag=" + localFriends1.detalStatusFlag + " | isMqqOnLine=" + localFriends1.isMqqOnLine + " | netTypeIconIdIphoneOrWphoneNoWifi=" + localFriends1.netTypeIconIdIphoneOrWphoneNoWifi);
        }
        paramGetFriendListResp = localFriendInfo.vecRing;
        paramToServiceMsg = new Oidb_0x5d0.SnsUpateBuffer();
      }
      try
      {
        paramToServiceMsg.mergeFrom(paramGetFriendListResp);
        a(paramToServiceMsg, localFriendInfo.friendUin);
        if ((paramToServiceMsg != null) && (paramToServiceMsg.rpt_uin32_idlist.has()))
        {
          paramToServiceMsg = paramToServiceMsg.rpt_uin32_idlist.get().iterator();
          for (;;)
          {
            if (paramToServiceMsg.hasNext()) {
              if (((Integer)paramToServiceMsg.next()).intValue() == 4051)
              {
                localFriends1.setShieldFlag(true);
                continue;
                paramToServiceMsg = "";
                break;
                bool = false;
              }
            }
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          paramToServiceMsg.printStackTrace();
          paramToServiceMsg = null;
        }
        localFriends2 = localFriendsManager.c(localFriends1.uin);
        paramToServiceMsg = localFriendInfo.oVipInfo;
        i2 = EVIPSPEC.E_SP_QQVIP.value();
        if (localFriends2 == null) {
          break label1114;
        }
      }
    }
    int i1 = localFriends2.qqVipInfo;
    localFriends1.qqVipInfo = a(paramToServiceMsg, i2, i1);
    paramToServiceMsg = localFriendInfo.oVipInfo;
    int i2 = EVIPSPEC.E_SP_SUPERQQ.value();
    if (localFriends2 != null)
    {
      i1 = localFriends2.superQqInfo;
      label734:
      localFriends1.superQqInfo = a(paramToServiceMsg, i2, i1);
      paramToServiceMsg = localFriendInfo.oVipInfo;
      i2 = EVIPSPEC.E_SP_SUPERVIP.value();
      if (localFriends2 == null) {
        break label1124;
      }
      i1 = localFriends2.superVipInfo;
      label771:
      localFriends1.superVipInfo = a(paramToServiceMsg, i2, i1);
      if (localFriends2 != null)
      {
        localFriends1.signature = localFriends2.signature;
        localFriends1.setRichBuffer(localFriends2.richBuffer, localFriends2.richTime);
        localFriends1.showLoginClient = localFriends2.showLoginClient;
        localFriends1.datetime = localFriends2.datetime;
        localFriends1.lastLoginType = localFriends2.lastLoginType;
      }
      if (localFriends2 == null) {
        break label1135;
      }
      if (localFriends2.groupid == localFriends1.groupid) {
        break label1129;
      }
      bool = true;
    }
    for (;;)
    {
      localFriendsManager.a(localFriends1, bool);
      if (localFriendsManager != null)
      {
        paramGetFriendListResp = localFriendsManager.a(localFriends2.uin);
        paramToServiceMsg = paramGetFriendListResp;
        if (paramGetFriendListResp == null)
        {
          paramToServiceMsg = new ExtensionInfo();
          paramToServiceMsg.uin = localFriends2.uin;
        }
        paramToServiceMsg.pendantId = localFriendInfo.ulFaceAddonId;
        paramToServiceMsg.uVipFont = localFriendInfo.uVipFont;
        paramToServiceMsg.timestamp = System.currentTimeMillis();
        localFriendsManager.a(paramToServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleGetFriendDetailInfo, Get ExtensionInfo, uin=" + localFriends2.uin + ", id=" + paramToServiceMsg.pendantId + ",font=" + paramToServiceMsg.uVipFont);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "$handleGetFriendDetailInfo | uin = " + localFriends1.uin + " | group = " + localFriends1.groupid);
      }
      if (this.g == 0L) {
        a(1, true, Boolean.valueOf(true));
      }
      paramToServiceMsg = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (paramToServiceMsg != null) {
        paramToServiceMsg.d();
      }
      a(new String[] { localFriends1.uin });
      return;
      label1114:
      i1 = 0;
      break;
      i1 = 0;
      break label734;
      label1124:
      i1 = 0;
      break label771;
      label1129:
      bool = false;
      continue;
      label1135:
      if (localFriends1.groupid != 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, MovGroupMemResp paramMovGroupMemResp)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    String str = paramToServiceMsg.getString("uin");
    byte b1 = paramToServiceMsg.getByte("group_id");
    byte b2 = paramToServiceMsg.getByte("away_group_id");
    if (paramMovGroupMemResp.result == 0)
    {
      ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(str, b1);
      a(9, true, new Object[] { str, Byte.valueOf(b1), Byte.valueOf(b2) });
      return;
    }
    a(9, false, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, SetGroupResp paramSetGroupResp)
  {
    boolean bool;
    int i1;
    if (paramSetGroupResp.result == 0)
    {
      bool = true;
      i1 = paramToServiceMsg.extraData.getInt("set_type", -1);
      if (i1 == paramSetGroupResp.reqtype) {
        break label691;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleSetGroupResp | unmatched reqtype, local = " + i1 + ", remote = " + paramSetGroupResp.reqtype);
      }
      bool = false;
    }
    label691:
    for (;;)
    {
      Object localObject1 = ByteBuffer.wrap(paramSetGroupResp.vecBody);
      Object localObject2 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      Object localObject3 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      switch (i1)
      {
      default: 
        return;
        bool = false;
        break;
      case 0: 
        localObject3 = new AddGroupResp();
        if (bool)
        {
          ((AddGroupResp)localObject3).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((AddGroupResp)localObject3).dwSequence = ((ByteBuffer)localObject1).getInt();
          ((AddGroupResp)localObject3).cGroupId = ((ByteBuffer)localObject1).get();
          ((AddGroupResp)localObject3).cSortId = ((ByteBuffer)localObject1).get();
          localObject1 = ((FriendsManagerImp)localObject2).a(((AddGroupResp)localObject3).cGroupId + "");
          if (localObject1 == null) {
            break label317;
          }
          ((Groups)localObject1).group_id = ((AddGroupResp)localObject3).cGroupId;
          ((Groups)localObject1).seqid = ((AddGroupResp)localObject3).cSortId;
          ((Groups)localObject1).group_name = paramToServiceMsg.extraData.getString("group_name");
        }
        for (paramToServiceMsg = (ToServiceMsg)localObject1;; paramToServiceMsg = (ToServiceMsg)localObject1)
        {
          ((FriendsManagerImp)localObject2).a(paramToServiceMsg);
          a(18, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (AddGroupResp)localObject3));
          return;
          localObject1 = new Groups();
          ((Groups)localObject1).group_id = ((AddGroupResp)localObject3).cGroupId;
          ((Groups)localObject1).seqid = ((AddGroupResp)localObject3).cSortId;
          ((Groups)localObject1).group_name = paramToServiceMsg.extraData.getString("group_name");
        }
      case 1: 
        localObject3 = new RenameGroupResp();
        if (bool)
        {
          ((RenameGroupResp)localObject3).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((RenameGroupResp)localObject3).dwSequence = ((ByteBuffer)localObject1).getInt();
          i1 = ((ByteBuffer)localObject1).get();
          ((RenameGroupResp)localObject3).cLen = ((ByteBuffer)localObject1).get();
          paramToServiceMsg = new byte[((RenameGroupResp)localObject3).cLen];
          ((ByteBuffer)localObject1).get(paramToServiceMsg, 0, ((RenameGroupResp)localObject3).cLen);
          ((RenameGroupResp)localObject3).sGroupName = new String(paramToServiceMsg);
          paramToServiceMsg = ((FriendsManagerImp)localObject2).a(String.valueOf(i1));
          if (paramToServiceMsg == null) {
            break label508;
          }
        }
        for (paramToServiceMsg.group_name = ((RenameGroupResp)localObject3).sGroupName;; paramToServiceMsg.group_name = ((RenameGroupResp)localObject3).sGroupName)
        {
          ((FriendsManagerImp)localObject2).a(paramToServiceMsg);
          a(19, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (RenameGroupResp)localObject3));
          return;
          paramToServiceMsg = new Groups();
          paramToServiceMsg.group_id = ((int)((RenameGroupResp)localObject3).dwSequence);
        }
      case 2: 
        paramToServiceMsg = new DelGroupResp();
        if (bool)
        {
          paramToServiceMsg.dwToUin = ((ByteBuffer)localObject1).getInt();
          paramToServiceMsg.dwSequence = ((ByteBuffer)localObject1).getInt();
          paramToServiceMsg.cGroupid = ((ByteBuffer)localObject1).get();
        }
        a(paramToServiceMsg, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, paramToServiceMsg));
        return;
      case 3: 
        label317:
        label508:
        localObject2 = new ReSortGroupResp();
        if (bool)
        {
          ((ReSortGroupResp)localObject2).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((ReSortGroupResp)localObject2).dwSequence = ((ByteBuffer)localObject1).getInt();
          ((FriendsManager)localObject3).a(paramToServiceMsg.extraData.getByteArray("group_id_list"), paramToServiceMsg.extraData.getByteArray("sort_id_list"));
        }
        a(22, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (ReSortGroupResp)localObject2));
        return;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    Object localObject2 = (GetRichSigRes)paramObject;
    Object localObject1 = (CircleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
    if ((localObject2 == null) || (((GetRichSigRes)localObject2).cResult != 0) || (((GetRichSigRes)localObject2).vstSigInfo == null) || (((GetRichSigRes)localObject2).vstSigInfo.size() == 0) || (localObject1 == null)) {}
    do
    {
      return;
      paramObject = new ArrayList();
      ArrayList localArrayList = new ArrayList(((GetRichSigRes)localObject2).vstSigInfo.size());
      localObject2 = ((GetRichSigRes)localObject2).vstSigInfo.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)((Iterator)localObject2).next();
        String str = Long.toString(localResRichSigInfo.lUin);
        if ((localObject1 != null) && ((localResRichSigInfo.cStatus == 0) || (localResRichSigInfo.cStatus == 1)))
        {
          CircleBuddy localCircleBuddy = ((CircleManager)localObject1).a(String.valueOf(localResRichSigInfo.lUin));
          if (localCircleBuddy != null)
          {
            localCircleBuddy.checkUpdateTime = System.currentTimeMillis();
            if (localResRichSigInfo.cStatus == 1)
            {
              localCircleBuddy.setRichBuffer(localResRichSigInfo.vbSigInfo, localResRichSigInfo.dwTime);
              localArrayList.add(localCircleBuddy);
              paramObject.add(str);
            }
          }
        }
      }
      if (localObject1 != null) {
        ((CircleManager)localObject1).b(localArrayList);
      }
    } while (paramObject.size() <= 0);
    localObject1 = new String[paramObject.size()];
    paramObject.toArray((Object[])localObject1);
    a(64, true, new Object[] { localObject1, paramToServiceMsg.extraData.getBundle("circleBundle") });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Oidb_0x5d1.RspBody paramRspBody)
  {
    Object localObject2 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    int i1 = paramRspBody.uint32_cmd.get();
    long l1 = paramToServiceMsg.extraData.getLong("friendUin");
    Object localObject1 = "";
    long l2;
    int i2;
    boolean bool1;
    label271:
    boolean bool2;
    if ((i1 == 1) && (paramRspBody.msg_set_friend_id.has()))
    {
      paramToServiceMsg = (Oidb_0x5d1.SetFriendIdRsp)paramRspBody.msg_set_friend_id.get();
      l2 = paramToServiceMsg.uint64_seq.get();
      i2 = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendShield : handleSetFriendShieldFlagResp : uin : " + l1 + " cmd:" + i1 + "result : " + i2 + " newSeq:" + l2);
      }
      if (i2 == 0)
      {
        paramRspBody = ((FriendsManagerImp)localObject2).c(String.valueOf(l1));
        paramToServiceMsg = (ToServiceMsg)localObject1;
        if (paramRspBody != null)
        {
          paramRspBody.setShieldFlag(true);
          ((FriendsManagerImp)localObject2).a(paramRspBody);
          paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          paramRspBody = BaseApplicationImpl.getContext().getString(2131559189);
          l2 = MessageCache.a();
          localObject2 = MessageRecordFactory.a(-2012);
          ((MessageRecord)localObject2).init(paramToServiceMsg, String.valueOf(l1), paramToServiceMsg, paramRspBody, l2, 0, 0, l2);
          ((MessageRecord)localObject2).msgtype = -2012;
          ((MessageRecord)localObject2).isread = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject2, paramToServiceMsg);
          paramToServiceMsg = (ToServiceMsg)localObject1;
        }
        if (i2 != 0) {
          break label340;
        }
        bool1 = true;
        if (i2 != 0) {
          break label346;
        }
        bool2 = true;
        label279:
        a(56, bool1, new Object[] { Long.valueOf(l1), Boolean.valueOf(true), Boolean.valueOf(bool2), Boolean.valueOf(false), paramToServiceMsg });
      }
    }
    label340:
    label346:
    do
    {
      return;
      paramToServiceMsg = paramToServiceMsg.bytes_error_msg.get().toStringUtf8();
      break;
      bool1 = false;
      break label271;
      bool2 = false;
      break label279;
      if ((i1 == 2) && (paramRspBody.msg_clear_friend_id.has()))
      {
        paramToServiceMsg = (Oidb_0x5d1.ClearFriendIdRsp)paramRspBody.msg_clear_friend_id.get();
        l2 = paramToServiceMsg.uint64_seq.get();
        i2 = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "FriendShield : handleSetFriendShieldFlagResp : uin : " + l1 + " cmd:" + i1 + "result : " + i2 + " newSeq:" + l2);
        }
        if (i2 == 0)
        {
          paramToServiceMsg = ((FriendsManagerImp)localObject2).c(String.valueOf(l1));
          if (paramToServiceMsg != null)
          {
            paramToServiceMsg.setShieldFlag(false);
            ((FriendsManagerImp)localObject2).a(paramToServiceMsg);
            paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            paramRspBody = BaseApplicationImpl.getContext().getString(2131559190);
            l2 = MessageCache.a();
            localObject1 = MessageRecordFactory.a(-2012);
            ((MessageRecord)localObject1).init(paramToServiceMsg, String.valueOf(l1), paramToServiceMsg, paramRspBody, l2, 0, 0, l2);
            ((MessageRecord)localObject1).msgtype = -2012;
            ((MessageRecord)localObject1).isread = true;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, paramToServiceMsg);
          }
          paramToServiceMsg = "";
          if (i2 != 0) {
            break label651;
          }
          bool1 = true;
          if (i2 != 0) {
            break label657;
          }
        }
        for (bool2 = true;; bool2 = false)
        {
          a(56, bool1, new Object[] { Long.valueOf(l1), Boolean.valueOf(false), Boolean.valueOf(bool2), Boolean.valueOf(false), paramToServiceMsg });
          return;
          paramToServiceMsg = paramToServiceMsg.bytes_error_msg.get().toStringUtf8();
          break;
          bool1 = false;
          break label582;
        }
      }
    } while (!QLog.isColorLevel());
    label582:
    QLog.d("FriendListHandler", 2, "<---handleSetFriendShieldFlagResp : cmd:" + i1);
    label651:
    label657:
    return;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    int i2 = paramToServiceMsg.extraData.getInt("bType");
    long l1 = paramToServiceMsg.extraData.getLong("lToMID");
    int i3 = paramToServiceMsg.extraData.getByte("bGroupId");
    int i1 = i2;
    if (i2 == 1) {
      i1 = 2;
    }
    if (i1 == 0)
    {
      paramToServiceMsg.extraData.getString("strNickName");
      a(paramToServiceMsg.getUin(), String.valueOf(l1), i3);
    }
    String str = l1 + "_answer_added_" + paramToServiceMsg.extraData.getLong("infotime", 0L) + paramToServiceMsg.extraData.getLong("dbid", 0L);
    ContactConfig.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), str, i1);
    a(10, true, new Object[] { paramToServiceMsg.getUin(), Integer.valueOf(i1) });
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, ArrayList paramArrayList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "getFriendGroupList " + paramBoolean + ", " + paramString + ", " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + ", " + paramLong);
    }
    if (!paramBoolean)
    {
      if (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b()) {
        a(1, true, null);
      }
    }
    else {
      a(1, true, Boolean.valueOf(false));
    }
    paramString = a("friendlist.getFriendGroupList");
    paramString.extraData.putLong("timeStamp", paramLong);
    paramString.extraData.putStringArrayList("uinList", paramArrayList);
    paramString.extraData.putShort("friendStartIndex", (short)paramInt1);
    paramString.extraData.putShort("friendCount", (short)paramInt2);
    paramString.extraData.putByte("groupStartIndex", (byte)paramInt3);
    paramString.extraData.getByte("groupCount", (byte)paramInt4);
    paramString.extraData.putLong("startTime", System.currentTimeMillis());
    paramString.extraData.putByte("ifShowTermType", (byte)1);
    a(paramString);
  }
  
  private void a(String paramString, AddFriendResp paramAddFriendResp, ToServiceMsg paramToServiceMsg)
  {
    Bundle localBundle = new Bundle();
    if (paramAddFriendResp.result == 0)
    {
      byte b1 = paramToServiceMsg.extraData.getByte("auto_send", (byte)0).byteValue();
      int i1 = paramToServiceMsg.extraData.getInt("source_id");
      boolean bool = paramToServiceMsg.extraData.getBoolean("contact_bothway");
      if (AutoRemarkActivity.a(paramAddFriendResp.adduinsetting, i1, bool)) {
        a(paramString, String.valueOf(paramAddFriendResp.adduin), paramAddFriendResp.myfriendgroupid);
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("$handleAddFriend|autoSend=").append(b1).append(",sourceId=").append(i1).append(",beBothWay=").append(bool).append(",successDirectly=").append(AutoRemarkActivity.a(paramAddFriendResp.adduinsetting, i1, bool));
        QLog.d("FriendListHandler", 2, paramString.toString());
      }
      localBundle.putString("uin", b(paramAddFriendResp.adduin));
      localBundle.putInt("friend_setting", paramToServiceMsg.extraData.getInt("friend_setting"));
      localBundle.putByteArray("sig", paramAddFriendResp.sig);
      localBundle.putInt("source_id", i1);
      localBundle.putString("friend_mobile_number", paramToServiceMsg.extraData.getString("friend_mobile_number"));
      localBundle.putByte("auto_send", b1);
    }
    for (;;)
    {
      localBundle.putInt("resultCode", paramAddFriendResp.result);
      a(11, true, localBundle);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "ErrorString" + paramAddFriendResp.ErrorString);
      }
      localBundle.putString("ErrorString", paramAddFriendResp.ErrorString);
    }
  }
  
  private void a(String paramString, GetFriendListResp paramGetFriendListResp, long paramLong, ArrayList paramArrayList)
  {
    int i3 = paramGetFriendListResp.startIndex;
    int i4 = paramGetFriendListResp.friend_count;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "handleGetFriendList " + paramGetFriendListResp.result + ", " + paramGetFriendListResp.serverTime + ", " + i3 + ", " + i4 + " totalCount=" + paramGetFriendListResp.totoal_friend_count);
    }
    TraceUtils.a("handleGetFriendList");
    if (paramGetFriendListResp.result == 1)
    {
      a(1, false, Boolean.valueOf(false));
      return;
    }
    if (i3 == 0) {
      paramLong = System.currentTimeMillis();
    }
    long l1 = paramGetFriendListResp.serverTime;
    int i1 = 1;
    while (i1 < 9)
    {
      if (i1 == 5) {
        l1 = 0L;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().contains("inccheckupdatetimeStamp" + i1)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("inccheckupdatetimeStamp" + i1, l1).commit();
      }
      i1 += 1;
    }
    b(paramGetFriendListResp.cShowPcIcon);
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Object localObject1;
    if ((paramGetFriendListResp.stSelfInfo != null) && (i3 == 0))
    {
      localObject3 = paramGetFriendListResp.stSelfInfo;
      localObject2 = localFriendsManagerImp.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = new Friends();
        ((Friends)localObject2).name = ((FriendInfo)localObject3).nick;
        if (((FriendInfo)localObject3).isRemark != 1) {
          break label733;
        }
        localObject1 = ((FriendInfo)localObject3).remark;
        ((Friends)localObject2).remark = ((String)localObject1);
        ((Friends)localObject2).uin = String.valueOf(((FriendInfo)localObject3).friendUin);
        ((Friends)localObject2).faceid = ((FriendInfo)localObject3).faceId;
        ((Friends)localObject2).sqqtype = ((FriendInfo)localObject3).sqqtype;
        ((Friends)localObject2).status = ((FriendInfo)localObject3).status;
        ((Friends)localObject2).cSpecialFlag = ((FriendInfo)localObject3).cSpecialFlag;
        if (((FriendInfo)localObject3).isMqqOnLine != 1) {
          break label741;
        }
      }
    }
    label733:
    label741:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((Friends)localObject2).isMqqOnLine = bool1;
      ((Friends)localObject2).sqqOnLineState = ((FriendInfo)localObject3).sqqOnLineState;
      ((Friends)localObject2).detalStatusFlag = ((FriendInfo)localObject3).detalStatusFlag;
      ((Friends)localObject2).memberLevel = ((FriendInfo)localObject3).memberLevel;
      ((Friends)localObject2).alias = ((FriendInfo)localObject3).sShowName;
      ((Friends)localObject2).isRemark = ((FriendInfo)localObject3).isRemark;
      ((Friends)localObject2).isIphoneOnline = ((FriendInfo)localObject3).isIphoneOnline;
      localObject1 = localObject2;
      ((Friends)localObject1).cNetwork = ((FriendInfo)localObject3).cNetwork;
      ((Friends)localObject1).abilityBits = ((FriendInfo)localObject3).uAbiFlag;
      ((Friends)localObject1).eNetwork = ((FriendInfo)localObject3).eNetworkType;
      ((Friends)localObject1).groupid = -1;
      ((Friends)localObject1).qqVipInfo = a(((FriendInfo)localObject3).oVipInfo, EVIPSPEC.E_SP_QQVIP.value(), ((Friends)localObject1).qqVipInfo);
      ((Friends)localObject1).superQqInfo = a(((FriendInfo)localObject3).oVipInfo, EVIPSPEC.E_SP_SUPERQQ.value(), ((Friends)localObject1).superQqInfo);
      ((Friends)localObject1).superVipInfo = a(((FriendInfo)localObject3).oVipInfo, EVIPSPEC.E_SP_SUPERVIP.value(), ((Friends)localObject1).superVipInfo);
      localFriendsManagerImp.a((Friends)localObject1);
      i2 = paramGetFriendListResp.vecGroupInfo.size();
      localObject1 = new Groups[i2];
      i1 = 0;
      while (i1 < i2)
      {
        localObject2 = (GroupInfo)paramGetFriendListResp.vecGroupInfo.get(i1);
        localObject3 = new Groups();
        ((Groups)localObject3).group_id = ((GroupInfo)localObject2).groupId;
        ((Groups)localObject3).group_name = ((GroupInfo)localObject2).groupname;
        ((Groups)localObject3).group_online_friend_count = ((GroupInfo)localObject2).online_friend_count;
        ((Groups)localObject3).group_friend_count = ((GroupInfo)localObject2).friend_count;
        ((Groups)localObject3).sqqOnLine_count = ((GroupInfo)localObject2).sqqOnLine_count;
        ((Groups)localObject3).seqid = ((GroupInfo)localObject2).seqid;
        ((Groups)localObject3).datetime = paramLong;
        localObject1[i1] = localObject3;
        i1 += 1;
      }
      localObject1 = "";
      break;
    }
    if ((i2 > 0) && (QLog.isColorLevel()))
    {
      localObject2 = (GroupInfo)paramGetFriendListResp.vecGroupInfo.get(0);
      QLog.d("Q.contacttab.friend", 2, "handleGetFriendList " + Utils.a(((GroupInfo)localObject2).groupname) + ", " + ((GroupInfo)localObject2).friend_count + ", " + ((GroupInfo)localObject2).sqqOnLine_count + ", " + ((GroupInfo)localObject2).seqid);
    }
    localFriendsManagerImp.a((Groups[])localObject1);
    int i5 = paramGetFriendListResp.vecFriendInfo.size();
    Object localObject2 = new Friends[i5];
    Object localObject3 = new ArrayList(i5);
    if (i3 + i4 >= paramGetFriendListResp.totoal_friend_count) {
      bool1 = true;
    }
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    HashMap localHashMap;
    ArrayList localArrayList3;
    FriendInfo localFriendInfo;
    Friends localFriends;
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager = new QvipSpecialCareManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      Set localSet = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localHashMap = new HashMap();
      localArrayList3 = new ArrayList();
      i1 = 0;
      if (i1 >= i5) {
        break label1835;
      }
      localFriendInfo = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(i1);
      localFriends = new Friends();
      localFriends.name = localFriendInfo.nick;
      label1022:
      boolean bool2;
      byte[] arrayOfByte;
      if (localFriendInfo.isRemark == 1)
      {
        localObject1 = localFriendInfo.remark;
        localFriends.remark = ((String)localObject1);
        localFriends.uin = String.valueOf(localFriendInfo.friendUin);
        paramArrayList.add(localFriends.uin);
        localFriends.faceid = localFriendInfo.faceId;
        localFriends.groupid = localFriendInfo.groupId;
        localFriends.sqqtype = localFriendInfo.sqqtype;
        localFriends.status = localFriendInfo.status;
        localFriends.cSpecialFlag = localFriendInfo.cSpecialFlag;
        if (localFriendInfo.isMqqOnLine != 1) {
          break label1436;
        }
        bool2 = true;
        localFriends.isMqqOnLine = bool2;
        localFriends.sqqOnLineState = localFriendInfo.sqqOnLineState;
        localFriends.detalStatusFlag = localFriendInfo.detalStatusFlag;
        localFriends.memberLevel = localFriendInfo.memberLevel;
        localFriends.datetime = paramLong;
        localFriends.alias = localFriendInfo.sShowName;
        localFriends.isRemark = localFriendInfo.isRemark;
        localFriends.cNetwork = localFriendInfo.cNetwork;
        localFriends.abilityBits = localFriendInfo.uAbiFlag;
        localFriends.eNetwork = localFriendInfo.eNetworkType;
        localFriends.netTypeIconId = localFriendInfo.eIconType;
        if (((localFriendInfo.iTermType == 67586) || (localFriendInfo.iTermType == 66566) || (localFriendInfo.iTermType == 72194) || (localFriendInfo.iTermType == 65804) || (localFriendInfo.iTermType == 72706)) && (localFriendInfo.eNetworkType != 1))
        {
          localFriends.netTypeIconIdIphoneOrWphoneNoWifi = localFriendInfo.eIconType;
          localFriends.netTypeIphoneOrWphoneNoWifi = localFriendInfo.eNetworkType;
        }
        localFriends.setShieldFlag(false);
        arrayOfByte = localFriendInfo.vecRing;
        localObject1 = new Oidb_0x5d0.SnsUpateBuffer();
      }
      try
      {
        ((Oidb_0x5d0.SnsUpateBuffer)localObject1).mergeFrom(arrayOfByte);
        a((Oidb_0x5d0.SnsUpateBuffer)localObject1, localFriendInfo.friendUin, localSet, localArrayList1, localArrayList2, localHashMap, localArrayList3);
        if ((localObject1 != null) && (((Oidb_0x5d0.SnsUpateBuffer)localObject1).rpt_uin32_idlist.has()))
        {
          localObject1 = ((Oidb_0x5d0.SnsUpateBuffer)localObject1).rpt_uin32_idlist.get().iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext()) {
              if (((Integer)((Iterator)localObject1).next()).intValue() == 4051)
              {
                localFriends.setShieldFlag(true);
                continue;
                bool1 = false;
                break;
                localObject1 = "";
                break label1022;
                label1436:
                bool2 = false;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject1 = null;
          localException.printStackTrace();
        }
        localFriends.isIphoneOnline = localFriendInfo.isIphoneOnline;
        localFriends.iTermType = localFriendInfo.iTermType;
        localObject1 = localFriendsManagerImp.c(localFriends.uin);
        localVipBaseInfo = localFriendInfo.oVipInfo;
        i6 = EVIPSPEC.E_SP_QQVIP.value();
        if (localObject1 == null) {
          break label1752;
        }
      }
    }
    int i2 = ((Friends)localObject1).qqVipInfo;
    label1514:
    localFriends.qqVipInfo = a(localVipBaseInfo, i6, i2);
    VipBaseInfo localVipBaseInfo = localFriendInfo.oVipInfo;
    int i6 = EVIPSPEC.E_SP_SUPERQQ.value();
    if (localObject1 != null)
    {
      i2 = ((Friends)localObject1).superQqInfo;
      label1555:
      localFriends.superQqInfo = a(localVipBaseInfo, i6, i2);
      localVipBaseInfo = localFriendInfo.oVipInfo;
      i6 = EVIPSPEC.E_SP_SUPERVIP.value();
      if (localObject1 == null) {
        break label1764;
      }
      i2 = ((Friends)localObject1).superVipInfo;
      label1596:
      localFriends.superVipInfo = a(localVipBaseInfo, i6, i2);
      if (localObject1 != null)
      {
        localFriends.signature = ((Friends)localObject1).signature;
        localFriends.setRichBuffer(((Friends)localObject1).richBuffer, ((Friends)localObject1).richTime);
        localFriends.showLoginClient = ((Friends)localObject1).showLoginClient;
        localFriends.lastLoginType = ((Friends)localObject1).lastLoginType;
      }
      localObject2[i1] = localFriends;
      localObject1 = localFriendsManagerImp.a(String.valueOf(localFriends.uin));
      if (localObject1 != null) {
        break label1770;
      }
      localObject1 = new ExtensionInfo();
      ((ExtensionInfo)localObject1).uin = String.valueOf(localFriends.uin);
      ((ExtensionInfo)localObject1).pendantId = localFriendInfo.ulFaceAddonId;
      ((ExtensionInfo)localObject1).uVipFont = localFriendInfo.uVipFont;
      ((ExtensionInfo)localObject1).timestamp = paramLong;
      ((ArrayList)localObject3).add(localObject1);
    }
    for (;;)
    {
      i1 += 1;
      break;
      label1752:
      i2 = 0;
      break label1514;
      i2 = 0;
      break label1555;
      label1764:
      i2 = 0;
      break label1596;
      label1770:
      if ((((ExtensionInfo)localObject1).pendantId != localFriendInfo.ulFaceAddonId) || (((ExtensionInfo)localObject1).uVipFont != localFriendInfo.uVipFont))
      {
        ((ExtensionInfo)localObject1).pendantId = localFriendInfo.ulFaceAddonId;
        ((ExtensionInfo)localObject1).uVipFont = localFriendInfo.uVipFont;
        ((ExtensionInfo)localObject1).timestamp = paramLong;
        ((ArrayList)localObject3).add(localObject1);
      }
    }
    label1835:
    if ((i5 > 0) && (QLog.isColorLevel()))
    {
      paramGetFriendListResp = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(0);
      QLog.i("FriendListHandler", 2, "FriendListHandler handleGetFriendList uin=" + paramGetFriendListResp.friendUin + " | eNetwork=" + paramGetFriendListResp.eNetworkType + " | iTermType=" + paramGetFriendListResp.iTermType + " | abilityBits=" + paramGetFriendListResp.uAbiFlag + " | name=" + Utils.a(paramGetFriendListResp.nick) + " | netTypeIconId=" + paramGetFriendListResp.eIconType + " | detalStatusFlag=" + paramGetFriendListResp.detalStatusFlag + " | isMqqOnLine=" + paramGetFriendListResp.isMqqOnLine + " | netTypeIconIdIphoneOrWphoneNoWifi=" + paramGetFriendListResp.eIconType);
      if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
      {
        paramGetFriendListResp = (ExtensionInfo)((ArrayList)localObject3).get(0);
        QLog.d("FriendListHandler", 2, "handleGetFriendList, Get Extension, uin=" + paramGetFriendListResp.uin + ", id=" + paramGetFriendListResp.pendantId + "/font=" + paramGetFriendListResp.uVipFont);
      }
    }
    localFriendsManagerImp.a((Friends[])localObject2, paramLong, bool1);
    localFriendsManagerImp.d((List)localObject3);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(localArrayList1);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.b(localArrayList2);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(localHashMap);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.c(localArrayList3);
    TraceUtils.a();
    if (!bool1)
    {
      a(paramString, i3 + i4, 200, 0, 0, paramLong, paramArrayList, true);
      a(1, true, Boolean.valueOf(false));
      return;
    }
    this.g = 0L;
    paramString = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (paramString != null)
    {
      paramString.d();
      paramString.b();
    }
    a(1, true, Boolean.valueOf(true));
    if (!paramArrayList.isEmpty())
    {
      paramString = new String[paramArrayList.size()];
      paramArrayList.toArray(paramString);
      paramArrayList.clear();
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b()) {
        break label2261;
      }
      a(paramString);
    }
    for (;;)
    {
      a(localFriendsManagerImp);
      return;
      label2261:
      this.jdField_a_of_type_ArrayOfJavaLangString = paramString;
    }
  }
  
  private void a(List paramList)
  {
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("saveLastLoginInfos begin ");
      if (paramList != null)
      {
        i1 = paramList.size();
        QLog.d("FriendListHandler", 2, i1);
      }
    }
    else
    {
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      localObject2 = ((FriendsManager)localObject1).b();
      if ((paramList == null) || (localObject2 == null)) {
        break label335;
      }
      localArrayList = new ArrayList(((ArrayList)localObject2).size());
      if (paramList.size() != 0) {
        break label188;
      }
      paramList = ((ArrayList)localObject2).iterator();
      label102:
      while (paramList.hasNext())
      {
        localObject2 = (Friends)paramList.next();
        if (localObject2 != null)
        {
          if (((Friends)localObject2).lastLoginType == 0L) {
            break label356;
          }
          ((Friends)localObject2).lastLoginType = 0L;
        }
      }
    }
    label188:
    label335:
    label351:
    label356:
    for (int i1 = 1;; i1 = 0)
    {
      if (((Friends)localObject2).showLoginClient != 0L)
      {
        ((Friends)localObject2).showLoginClient = 0L;
        i1 = 1;
      }
      if (i1 == 0) {
        break label102;
      }
      localArrayList.add(localObject2);
      break label102;
      i1 = -1;
      break;
      paramList = paramList.iterator();
      Friends localFriends;
      while (paramList.hasNext())
      {
        localObject2 = (LastLoginInfo)paramList.next();
        localFriends = ((FriendsManager)localObject1).c(String.valueOf(((LastLoginInfo)localObject2).dwFriendUin));
        if (localFriends != null)
        {
          if (localFriends.showLoginClient == ((LastLoginInfo)localObject2).dwClient) {
            break label351;
          }
          localFriends.showLoginClient = ((LastLoginInfo)localObject2).dwClient;
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        if (localFriends.lastLoginType != ((LastLoginInfo)localObject2).dwLastLoginType)
        {
          localFriends.lastLoginType = ((LastLoginInfo)localObject2).dwLastLoginType;
          i1 = 1;
        }
        if (i1 == 0) {
          break;
        }
        localArrayList.add(localFriends);
        break;
        ((FriendsManager)localObject1).a((Friends[])localArrayList.toArray(new Friends[localArrayList.size()]), localArrayList.size());
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "saveLastLoginInfos ends ");
        }
        return;
      }
    }
  }
  
  private void a(Oidb_0x5d0.SnsUpateBuffer paramSnsUpateBuffer, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager = new QvipSpecialCareManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (paramSnsUpateBuffer == null) {}
    do
    {
      for (;;)
      {
        return;
        if (!paramSnsUpateBuffer.rpt_msg_sns_update_item.has()) {
          break;
        }
        Iterator localIterator = paramSnsUpateBuffer.rpt_msg_sns_update_item.get().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Oidb_0x5d0.SnsUpdateItem)localIterator.next();
          if ((localObject != null) && (((Oidb_0x5d0.SnsUpdateItem)localObject).uint32_update_sns_type.has()) && (((Oidb_0x5d0.SnsUpdateItem)localObject).bytes_value.has()) && (((Oidb_0x5d0.SnsUpdateItem)localObject).uint32_update_sns_type.get() == 13568))
          {
            paramLong = paramSnsUpateBuffer.uint64_uin.get();
            localObject = ((Oidb_0x5d0.SnsUpdateItem)localObject).bytes_value.get().toStringUtf8();
            this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(String.valueOf(paramLong), (String)localObject);
          }
        }
      }
      paramSnsUpateBuffer = String.valueOf(paramLong);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(paramSnsUpateBuffer)) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.b(paramSnsUpateBuffer);
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.b(paramSnsUpateBuffer));
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.c(paramSnsUpateBuffer);
  }
  
  private void a(Oidb_0x5d0.SnsUpateBuffer paramSnsUpateBuffer, long paramLong, Set paramSet, List paramList1, List paramList2, Map paramMap, List paramList3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager = new QvipSpecialCareManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (paramSnsUpateBuffer == null) {}
    do
    {
      for (;;)
      {
        return;
        if (!paramSnsUpateBuffer.rpt_msg_sns_update_item.has()) {
          break;
        }
        Iterator localIterator = paramSnsUpateBuffer.rpt_msg_sns_update_item.get().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Oidb_0x5d0.SnsUpdateItem)localIterator.next();
          if ((localObject != null) && (((Oidb_0x5d0.SnsUpdateItem)localObject).uint32_update_sns_type.has()) && (((Oidb_0x5d0.SnsUpdateItem)localObject).bytes_value.has()) && (((Oidb_0x5d0.SnsUpdateItem)localObject).uint32_update_sns_type.get() == 13568))
          {
            String str = String.valueOf(paramSnsUpateBuffer.uint64_uin.get());
            localObject = ((Oidb_0x5d0.SnsUpdateItem)localObject).bytes_value.get().toStringUtf8();
            if ((localObject == null) || (((String)localObject).length() == 0))
            {
              if ((paramSet != null) && (paramSet.contains(str))) {
                paramList2.add(str);
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.b(str)) {
                paramList3.add(str);
              }
            }
            else
            {
              try
              {
                int i1 = Integer.parseInt((String)localObject);
                paramList1.add(str);
                paramMap.put(str, Integer.valueOf(i1));
              }
              catch (Exception localException) {}
              if (QLog.isColorLevel()) {
                QLog.i("FriendListHandler", 2, "dealWithRespSound|exception = " + localException.toString());
              }
            }
          }
        }
      }
      paramSnsUpateBuffer = String.valueOf(paramLong);
      if ((paramSet != null) && (paramSet.contains(paramSnsUpateBuffer))) {
        paramList2.add(paramSnsUpateBuffer);
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.b(paramSnsUpateBuffer));
    paramList3.add(paramSnsUpateBuffer);
  }
  
  private void a(String[] paramArrayOfString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i1;
      if (paramInt1 < paramArrayOfString.length)
      {
        i1 = paramInt1 + 1;
        localArrayList.add(paramArrayOfString[paramInt1]);
        if (localArrayList.size() >= 50) {
          a(paramArrayOfString, i1, paramInt2, paramBundle);
        }
      }
      else
      {
        paramArrayOfString = new String[localArrayList.size()];
        localArrayList.toArray(paramArrayOfString);
        ToServiceMsg localToServiceMsg = a("ProfileService.GetRichSig");
        localToServiceMsg.extraData.putStringArrayList("uinList", localArrayList);
        localToServiceMsg.extraData.putStringArray("sendArray", paramArrayOfString);
        localToServiceMsg.extraData.putInt("reqType", paramInt2);
        localToServiceMsg.extraData.putBundle("circleBundle", paramBundle);
        a(localToServiceMsg);
        return;
      }
      paramInt1 = i1;
    }
  }
  
  private String b(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong < 0L) {
      l1 = paramLong + 4294967296L;
    }
    return String.valueOf(l1);
  }
  
  private Map b(ArrayList paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayList != null)
    {
      int i1 = 0;
      if (i1 < paramArrayList.size())
      {
        GeneralSettings.Setting localSetting = (GeneralSettings.Setting)paramArrayList.get(i1);
        Object localObject = localSetting.Path;
        if ((localObject == null) || (((String)localObject).length() == 0)) {}
        for (;;)
        {
          i1 += 1;
          break;
          localObject = ((String)localObject).split("\\.");
          if ((localObject != null) && (localObject.length != 0)) {
            localHashMap.put(localObject[(localObject.length - 1)], Integer.valueOf(Integer.parseInt(localSetting.Value)));
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void b(byte paramByte)
  {
    boolean bool = true;
    if ((paramByte == 0) || (paramByte == 1)) {
      if (paramByte != 1) {
        break label55;
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Boolean ^ bool))
      {
        this.jdField_b_of_type_Boolean = bool;
        ContactConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_b_of_type_Boolean);
      }
      return;
      label55:
      bool = false;
    }
  }
  
  private void b(long paramLong, int paramInt, ArrayList paramArrayList)
  {
    int i2 = 0;
    Object localObject1;
    Object localObject2;
    int i1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      localObject2 = ((StringBuilder)localObject1).append("realGetQQHead_New|dstUsrType=").append(paramInt).append(", size=");
      if (paramArrayList != null) {}
      for (i1 = paramArrayList.size();; i1 = 0)
      {
        ((StringBuilder)localObject2).append(i1);
        if (paramArrayList == null) {
          break;
        }
        i1 = 0;
        while (i1 < paramArrayList.size())
        {
          ((StringBuilder)localObject1).append(',').append(paramArrayList.get(i1));
          i1 += 1;
        }
      }
      QLog.d("Q.qqhead.flh", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    if (paramInt == 4)
    {
      paramInt = 8;
      i1 = 0;
    }
    for (;;)
    {
      localObject1 = a("IncreaseURLSvr.QQHeadUrlReq", null);
      localObject2 = new QQHeadUrl.QQHeadUrlReq();
      ((QQHeadUrl.QQHeadUrlReq)localObject2).srcUsrType.set(1);
      ((QQHeadUrl.QQHeadUrlReq)localObject2).srcUin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
      ((QQHeadUrl.QQHeadUrlReq)localObject2).dstUsrType.set(paramInt);
      paramInt = i2;
      if (i1 != 0)
      {
        ((QQHeadUrl.QQHeadUrlReq)localObject2).dstEncryptType.set(1);
        paramInt = i2;
      }
      label220:
      if (paramInt < paramArrayList.size())
      {
        FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramArrayList.get(paramInt);
        QQHeadUrl.ReqUsrInfo localReqUsrInfo = new QQHeadUrl.ReqUsrInfo();
        if (i1 != 0)
        {
          localReqUsrInfo.dstUin.set(0L);
          localReqUsrInfo.dstEncid.set(localQQHeadDetails.jdField_b_of_type_JavaLangString);
          localReqUsrInfo.timestamp.set((int)localQQHeadDetails.jdField_a_of_type_Long);
          ((QQHeadUrl.QQHeadUrlReq)localObject2).dstUsrInfos.add(localReqUsrInfo);
        }
        for (;;)
        {
          for (;;)
          {
            paramInt += 1;
            break label220;
            if (paramInt != 100) {
              break label389;
            }
            i1 = 1;
            paramInt = 1;
            break;
            try
            {
              localReqUsrInfo.dstUin.set(Long.parseLong(localQQHeadDetails.jdField_a_of_type_JavaLangString));
            }
            catch (Exception localException) {}
          }
        }
      }
      ((ToServiceMsg)localObject1).extraData.putParcelableArrayList("uinList", paramArrayList);
      ((ToServiceMsg)localObject1).extraData.putLong("startTime", System.currentTimeMillis());
      ((ToServiceMsg)localObject1).putWupBuffer(((QQHeadUrl.QQHeadUrlReq)localObject2).toByteArray());
      b((ToServiceMsg)localObject1);
      return;
      label389:
      i1 = 0;
    }
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject instanceof GetSimpleOnlineFriendInfoResp))
    {
      paramFromServiceMsg = (GetSimpleOnlineFriendInfoResp)paramObject;
      if (paramFromServiceMsg == null) {
        a(13, false, null);
      }
    }
    else
    {
      return;
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.result == 1))
    {
      a(13, false, null);
      return;
    }
    if (paramFromServiceMsg.shClickInterval > 30)
    {
      i1 = paramFromServiceMsg.shClickInterval * 1000;
      QQAppInterface.bh = i1;
      if (paramFromServiceMsg.intervalTimeMin <= 3) {
        break label179;
      }
    }
    label179:
    for (int i1 = paramFromServiceMsg.intervalTimeMin * 60 * 1000;; i1 = 180000)
    {
      QQAppInterface.bg = i1;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "Next Get Online Friend Delay " + QQAppInterface.bg);
      }
      b(paramFromServiceMsg.cShowPcIcon);
      if (paramFromServiceMsg.vecFriendInfo.size() <= 0) {
        break label186;
      }
      ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramFromServiceMsg.vecFriendInfo);
      a(13, true, null);
      return;
      i1 = 30000;
      break;
    }
    label186:
    a(13, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("friendUin");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isSet");
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendShield : handleSetFriendShieldFlagError : uin : " + l1 + " isSet:" + bool);
    }
    a(56, false, new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Boolean.valueOf(false), Boolean.valueOf(false), "" });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int i1 = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerDelMultiClient index = " + i1);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        a(62, false, new Object[] { null, Integer.valueOf(i1) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        a(62, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
        return;
      }
      a(62, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      a(62, false, new Object[] { null, Integer.valueOf(i1) });
      return;
    }
    a(62, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(58, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        int i1;
        if ((paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size() > 0))
        {
          i1 = 0;
          if (i1 < paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.get(i1);
            if (paramToServiceMsg != null) {}
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          if (paramToServiceMsg.vecGuid == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, "handlerLoginDevList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
            }
          }
          else
          {
            if (NetConnInfoCenter.GUID == null) {
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerLoginDevList NetConnInfoCenter.GUID is null");
              }
            }
            while (Arrays.equals(paramToServiceMsg.vecGuid, NetConnInfoCenter.GUID))
            {
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.remove(i1);
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.add(0, paramToServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerMultiClientList Arrays true");
              }
              a(58, true, paramSvcRspGetDevLoginInfo);
              return;
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerLoginDevList NetConnInfoCenter.GUID =" + PkgTools.b(NetConnInfoCenter.GUID) + "; info.guid = " + PkgTools.b(paramToServiceMsg.vecGuid));
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                paramFromServiceMsg.printStackTrace();
              }
            }
          }
        }
      }
      a(58, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(58, false, null);
      return;
    }
    a(58, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(33, true, paramObject);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    Object localObject = (GetRichSigRes)paramObject;
    paramToServiceMsg = paramToServiceMsg.extraData.getStringArray("sendArray");
    if ((localObject == null) || (((GetRichSigRes)localObject).cResult != 0) || (((GetRichSigRes)localObject).vstSigInfo == null) || (((GetRichSigRes)localObject).vstSigInfo.size() == 0))
    {
      a(65, false, new Object[] { paramToServiceMsg, null });
      return;
    }
    paramObject = new HashMap(paramToServiceMsg.length);
    localObject = ((GetRichSigRes)localObject).vstSigInfo.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)((Iterator)localObject).next();
      paramObject.put(Long.toString(localResRichSigInfo.lUin), RichStatus.a(localResRichSigInfo.vbSigInfo));
    }
    a(65, true, new Object[] { paramToServiceMsg, paramObject });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int i1 = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerDelMultiClient index = " + i1);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        a(51, false, new Object[] { null, Integer.valueOf(i1) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        a(51, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
        return;
      }
      a(51, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      a(51, false, new Object[] { null, Integer.valueOf(i1) });
      return;
    }
    a(51, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(59, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        if ((paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.size() > 0))
        {
          int i1 = 0;
          if (i1 < paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.get(i1);
            if (paramToServiceMsg == null) {}
            for (;;)
            {
              i1 += 1;
              break;
              if (paramToServiceMsg.vecGuid == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerRecentLoginDevList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
                }
              }
              else if (NetConnInfoCenter.GUID == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerRecentLoginDevList NetConnInfoCenter.GUID is null");
                }
              }
              else {
                try
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("FriendListHandler", 2, "handlerRecentLoginDevList NetConnInfoCenter.GUID =" + PkgTools.b(NetConnInfoCenter.GUID) + "; info.guid = " + PkgTools.b(paramToServiceMsg.vecGuid));
                  }
                }
                catch (Exception paramToServiceMsg)
                {
                  paramToServiceMsg.printStackTrace();
                }
              }
            }
          }
        }
        a(59, true, paramSvcRspGetDevLoginInfo);
        return;
      }
      a(59, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(59, false, null);
      return;
    }
    a(59, false, null);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      a(66, false, null);
      return;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
          break label113;
        }
        i1 = 1;
        if (i1 != 0) {
          break label119;
        }
        a(66, false, null);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(66, false, null);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.stranger_info", 2, paramToServiceMsg.getMessage());
      return;
      label113:
      i1 = 0;
    }
    label119:
    if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (localByteBuffer.getInt() == -1)
      {
        int i5 = localByteBuffer.getShort();
        paramFromServiceMsg = new ArrayList(i5);
        paramObject = new HashSet(i5);
        FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        int i3 = 0;
        while (i3 < i5)
        {
          i1 = 0;
          long l1 = Utils.a(localByteBuffer.getInt());
          ExtensionInfo localExtensionInfo = localFriendsManagerImp.a(String.valueOf(l1));
          paramToServiceMsg = localExtensionInfo;
          if (localExtensionInfo == null)
          {
            paramToServiceMsg = new ExtensionInfo();
            paramToServiceMsg.uin = String.valueOf(l1);
            i1 = 1;
          }
          int i6 = localByteBuffer.getShort();
          int i2 = i1;
          if (i6 > 0)
          {
            int i4 = 0;
            i2 = i1;
            if (i4 < i6)
            {
              int i7 = localByteBuffer.getShort();
              long l2;
              if (i7 == 27025)
              {
                i2 = i1;
                if (localByteBuffer.getShort() == 8)
                {
                  l2 = localByteBuffer.getLong();
                  i2 = i1;
                  if (paramToServiceMsg.pendantId != l2)
                  {
                    paramToServiceMsg.pendantId = l2;
                    i2 = 1;
                  }
                }
              }
              for (;;)
              {
                i4 += 1;
                i1 = i2;
                break;
                i2 = i1;
                if (i7 == 27032)
                {
                  i2 = i1;
                  if (localByteBuffer.getShort() == 4)
                  {
                    l2 = localByteBuffer.getInt();
                    i2 = i1;
                    if (paramToServiceMsg.uVipFont != l2)
                    {
                      paramToServiceMsg.uVipFont = l2;
                      i2 = 1;
                    }
                  }
                }
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleGetStrangerInfo, uin=" + l1 + ", pendant=" + paramToServiceMsg.pendantId + ",font=" + paramToServiceMsg.uVipFont);
          }
          if (i2 != 0)
          {
            paramToServiceMsg.timestamp = System.currentTimeMillis();
            paramFromServiceMsg.add(paramToServiceMsg);
            paramObject.add(paramToServiceMsg.uin);
          }
          i3 += 1;
        }
        localFriendsManagerImp.d(paramFromServiceMsg);
        paramToServiceMsg = paramObject;
      }
    }
    for (;;)
    {
      a(66, true, paramToServiceMsg);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.stranger_info", 2, "handleGetStrangerInfo. addonId size : " + paramFromServiceMsg.size());
      return;
      paramToServiceMsg = null;
      paramFromServiceMsg = null;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    Object localObject2 = (GetRichSigRes)paramObject;
    paramToServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
    if ((localObject2 == null) || (((GetRichSigRes)localObject2).cResult != 0) || (((GetRichSigRes)localObject2).vstSigInfo == null) || (((GetRichSigRes)localObject2).vstSigInfo.size() == 0) || (paramToServiceMsg == null)) {}
    ArrayList localArrayList1;
    int i1;
    do
    {
      return;
      localObject1 = (CircleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
      paramObject = new Friends[((GetRichSigRes)localObject2).vstSigInfo.size()];
      ArrayList localArrayList2 = new ArrayList(((GetRichSigRes)localObject2).vstSigInfo.size());
      localArrayList1 = new ArrayList();
      localObject2 = ((GetRichSigRes)localObject2).vstSigInfo.iterator();
      i1 = 0;
      while (((Iterator)localObject2).hasNext())
      {
        ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)((Iterator)localObject2).next();
        Object localObject3 = Long.toString(localResRichSigInfo.lUin);
        int i2 = i1;
        if (localResRichSigInfo.cStatus == 1)
        {
          Friends localFriends = paramToServiceMsg.c((String)localObject3);
          i2 = i1;
          if (localFriends != null)
          {
            i2 = i1;
            if (localFriends.richTime != localResRichSigInfo.dwTime)
            {
              localFriends.setRichBuffer(localResRichSigInfo.vbSigInfo, localResRichSigInfo.dwTime);
              paramObject[i1] = localFriends;
              localArrayList1.add(localObject3);
              i2 = i1 + 1;
            }
          }
        }
        i1 = i2;
        if (localObject1 != null) {
          if (localResRichSigInfo.cStatus != 0)
          {
            i1 = i2;
            if (localResRichSigInfo.cStatus != 1) {}
          }
          else
          {
            localObject3 = ((CircleManager)localObject1).a(String.valueOf(localResRichSigInfo.lUin));
            i1 = i2;
            if (localObject3 != null)
            {
              ((CircleBuddy)localObject3).checkUpdateTime = System.currentTimeMillis();
              i1 = i2;
              if (localResRichSigInfo.cStatus == 1)
              {
                ((CircleBuddy)localObject3).setRichBuffer(localResRichSigInfo.vbSigInfo, localResRichSigInfo.dwTime);
                localArrayList2.add(localObject3);
                i1 = i2;
              }
            }
          }
        }
      }
      if (localObject1 != null) {
        ((CircleManager)localObject1).b(localArrayList2);
      }
    } while (localArrayList1.size() <= 0);
    Object localObject1 = new String[localArrayList1.size()];
    localArrayList1.toArray((Object[])localObject1);
    a(2, true, localObject1);
    paramToServiceMsg.a(paramObject, i1);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(60, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        if ((paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.size() > 0))
        {
          int i1 = 0;
          if (i1 < paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.get(i1);
            if (paramToServiceMsg == null) {}
            for (;;)
            {
              i1 += 1;
              break;
              if (paramToServiceMsg.vecGuid == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerAuthLoginDevList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
                }
              }
              else if (NetConnInfoCenter.GUID == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerAuthLoginDevList NetConnInfoCenter.GUID is null");
                }
              }
              else {
                try
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("FriendListHandler", 2, "handlerAuthLoginDevList NetConnInfoCenter.GUID =" + PkgTools.b(NetConnInfoCenter.GUID) + "; info.guid = " + PkgTools.b(paramToServiceMsg.vecGuid));
                  }
                }
                catch (Exception paramToServiceMsg)
                {
                  paramToServiceMsg.printStackTrace();
                }
              }
            }
          }
        }
        a(60, true, paramSvcRspGetDevLoginInfo);
        return;
      }
      a(60, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(60, false, null);
      return;
    }
    a(60, false, null);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg arg2, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (??? != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (???.getResultCode() == 1000)
      {
        localObject1 = localObject2;
        if (paramObject != null)
        {
          localObject1 = new QQHeadUrl.QQHeadUrlRsp();
          ((QQHeadUrl.QQHeadUrlRsp)localObject1).mergeFrom((byte[])paramObject);
        }
      }
      paramObject = localObject1;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        paramObject = null;
        continue;
        if (??? != null) {
          i1 = ???.getResultCode();
        }
      }
      i1 = paramObject.dstUsrType.get();
      if (i1 != 8) {
        break label721;
      }
    }
    if ((??? == null) || (???.getResultCode() != 1000) || (paramObject == null) || (paramObject.result.get() != 0))
    {
      i1 = 65535;
      if (paramObject != null)
      {
        i1 = paramObject.result.get();
        a(paramToServiceMsg, i1);
        return;
      }
    }
    int i1 = 4;
    label281:
    label328:
    label715:
    label719:
    label721:
    for (;;)
    {
      int i3 = (byte)paramObject.dstEncryptType.get();
      localObject2 = new ArrayList();
      localObject1 = new ArrayList();
      ??? = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
      Iterator localIterator1;
      if ((??? != null) && (???.size() > 0))
      {
        paramObject = paramObject.dstHeadInfos.get();
        localIterator1 = ???.iterator();
      }
      for (;;)
      {
        label214:
        FriendListHandler.QQHeadDetails localQQHeadDetails;
        label244:
        QQHeadUrl.RspHeadInfo localRspHeadInfo;
        int i2;
        if (localIterator1.hasNext())
        {
          localQQHeadDetails = (FriendListHandler.QQHeadDetails)localIterator1.next();
          Iterator localIterator2 = paramObject.iterator();
          if (!localIterator2.hasNext()) {
            break label715;
          }
          localRspHeadInfo = (QQHeadUrl.RspHeadInfo)localIterator2.next();
          if (i3 == 1)
          {
            ??? = localRspHeadInfo.dstUid.get();
            if (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(???)) {
              break label442;
            }
            ??? = new QQHeadInfo();
            ???.soruceType = localQQHeadDetails.jdField_a_of_type_Byte;
            if (i3 != 1) {
              break label444;
            }
            ???.phoneNum = localRspHeadInfo.dstUid.get();
            ???.dwTimestamp = localRspHeadInfo.timestamp.get();
            ???.cHeadType = ((byte)localRspHeadInfo.faceType.get());
            ???.dstUsrType = ((byte)i1);
            ???.dwFaceFlgas = ((byte)localRspHeadInfo.faceFlag.get());
            ???.downLoadUrl = localRspHeadInfo.url.get();
            ???.systemHeadID = ((short)localRspHeadInfo.sysid.get());
            ((List)localObject2).add(???);
            i2 = 1;
          }
        }
        for (;;)
        {
          if (i2 != 0) {
            break label719;
          }
          ((List)localObject1).add(localQQHeadDetails);
          break label214;
          ??? = String.valueOf(localRspHeadInfo.dstUin.get());
          break label281;
          break label244;
          ???.uin = localRspHeadInfo.dstUin.get();
          break label328;
          if (this.jdField_a_of_type_Ffs == null) {}
          synchronized (this.jdField_b_of_type_JavaLangObject)
          {
            if (this.jdField_a_of_type_Ffs == null) {
              this.jdField_a_of_type_Ffs = new ffs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
            }
            i2 = 0;
            if (i2 < ((List)localObject2).size())
            {
              ??? = (QQHeadInfo)((List)localObject2).get(i2);
              this.jdField_a_of_type_Ffs.a(???, paramToServiceMsg);
              i2 += 1;
            }
          }
          if (((List)localObject1).size() <= 0) {
            break;
          }
          paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
          ??? = paramObject.a();
          ???.a();
          i2 = 0;
          try
          {
            if (i2 < ((List)localObject1).size())
            {
              localObject2 = (FriendListHandler.QQHeadDetails)((List)localObject1).get(i2);
              if (i1 == 4) {}
              for (paramToServiceMsg = "troop_" + ((FriendListHandler.QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString;; paramToServiceMsg = ((FriendListHandler.QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString)
              {
                paramToServiceMsg = (com.tencent.mobileqq.data.Setting)paramObject.a(com.tencent.mobileqq.data.Setting.class, paramToServiceMsg);
                if (paramToServiceMsg != null)
                {
                  paramToServiceMsg.updateTimestamp = System.currentTimeMillis();
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramToServiceMsg);
                  paramObject.a(paramToServiceMsg);
                }
                b(((FriendListHandler.QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString, true);
                i2 += 1;
                break;
              }
            }
            i2 = 0;
          }
          catch (Exception paramToServiceMsg)
          {
            ???.c();
            ???.b();
            return;
          }
        }
      }
    }
  }
  
  private void e()
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        Object localObject1;
        if (this.aJ > 0)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (localObject1 == null) {
            break label192;
          }
        }
        try
        {
          l1 = Long.valueOf((String)localObject1).longValue();
          if (l1 == -1L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.flh", 2, "doExecuteGetQQHead|myUin error: myUin=" + (String)localObject1);
            }
            return;
          }
        }
        catch (Exception localException)
        {
          l1 = -1L;
          continue;
          localObject1 = this.jdField_a_of_type_JavaUtilHashtable.keys();
          if (!((Enumeration)localObject1).hasMoreElements()) {
            break label177;
          }
        }
        int i1 = ((Integer)((Enumeration)localObject1).nextElement()).intValue();
        ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(i1));
        if (i1 == 11)
        {
          a(l1, i1, localArrayList);
          continue;
        }
        b(l1, i1, localArrayList);
      }
      finally {}
      continue;
      label177:
      this.aJ = 0;
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      continue;
      label192:
      long l1 = -1L;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    int i1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null) && ((paramObject instanceof RespSearch)))
    {
      bool = true;
      if (!bool) {
        break label109;
      }
      paramToServiceMsg = (RespHead)a(paramFromServiceMsg.getWupBuffer(), "RespHead", new RespHead());
      if (paramToServiceMsg == null) {
        break label98;
      }
      i1 = paramToServiceMsg.iResult;
      paramToServiceMsg = paramToServiceMsg.strErrorMsg;
    }
    for (;;)
    {
      a(49, bool, new Object[] { paramObject, Integer.valueOf(i1), paramToServiceMsg });
      return;
      bool = false;
      break;
      label98:
      paramToServiceMsg = null;
      bool = false;
      i1 = 0;
      continue;
      label109:
      paramToServiceMsg = null;
      i1 = 0;
    }
  }
  
  private boolean e(String paramString)
  {
    boolean bool1 = paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    boolean bool2 = bool1;
    long l1;
    if (bool1)
    {
      l1 = ContactConfig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), paramString);
      if (l1 / 86400000L == System.currentTimeMillis() / 86400000L) {
        break label135;
      }
    }
    label135:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("FriendListHandler", 2, "$shouldReqXMan | lastReqTime = " + l1 + " day = " + l1 / 86400000L + " | currentTime = " + System.currentTimeMillis() + " day = " + System.currentTimeMillis() / 86400000L);
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    int i1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null) && ((paramObject instanceof RespCondSearch)))
    {
      bool = true;
      if (!bool) {
        break label119;
      }
      paramFromServiceMsg = (RespHead)a(paramFromServiceMsg.getWupBuffer(), "RespHead", new RespHead());
      if (paramFromServiceMsg == null) {
        break label110;
      }
      i1 = paramFromServiceMsg.iResult;
      paramFromServiceMsg = paramFromServiceMsg.strErrorMsg;
    }
    for (;;)
    {
      a(73, bool, new Object[] { Long.valueOf(paramToServiceMsg.extraData.getLong("search_seq")), paramObject, Integer.valueOf(i1) });
      return;
      bool = false;
      break;
      label110:
      i1 = 0;
      bool = false;
      continue;
      label119:
      i1 = 0;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = paramToServiceMsg.extraData.getLong("dwReqType", 1L);
    if (l1 == 0L)
    {
      paramToServiceMsg = String.valueOf(paramToServiceMsg.extraData.getLong("dwUin"));
      if (paramObject != null) {
        break label76;
      }
      a(68, false, new Object[] { Long.valueOf(l1), paramToServiceMsg });
    }
    label76:
    while (!(paramObject instanceof GetOnlineInfoResp))
    {
      return;
      paramToServiceMsg = paramToServiceMsg.extraData.getString("strMobile");
      break;
    }
    paramFromServiceMsg = (GetOnlineInfoResp)paramObject;
    if ((l1 == 0L) && (paramFromServiceMsg.result == 0)) {
      ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramToServiceMsg, paramFromServiceMsg);
    }
    paramFromServiceMsg.dwInterval *= 1000L;
    if (paramFromServiceMsg.dwInterval < 15000L) {
      paramFromServiceMsg.dwInterval = 15000L;
    }
    this.l = paramFromServiceMsg.dwInterval;
    a(68, true, new Object[] { Long.valueOf(l1), paramToServiceMsg, paramFromServiceMsg });
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("uin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("com_value");
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = str;
    arrayOfObject[1] = paramToServiceMsg;
    if (1000 == paramFromServiceMsg.getResultCode())
    {
      paramFromServiceMsg = (ChangeFriendNameRes)paramObject;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.cResult == 0))
      {
        a(str, paramToServiceMsg, true);
        arrayOfObject[2] = Byte.valueOf(paramFromServiceMsg.cResult);
        a(27, true, arrayOfObject);
        return;
      }
      if (paramFromServiceMsg != null) {
        arrayOfObject[2] = Byte.valueOf(paramFromServiceMsg.cResult);
      }
      for (;;)
      {
        a(27, false, arrayOfObject);
        return;
        arrayOfObject[2] = Byte.valueOf(-1);
      }
    }
    arrayOfObject[2] = Byte.valueOf(-1);
    a(27, false, arrayOfObject);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (SetRichSigRes)paramObject;
      if (paramFromServiceMsg.cResult == 0)
      {
        paramObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
        if (paramObject != null)
        {
          paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("sig_value");
          if (paramFromServiceMsg.dwTime == 0L) {
            paramFromServiceMsg.dwTime = 1L;
          }
          paramObject.a(paramObject.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramToServiceMsg, paramFromServiceMsg.dwTime));
        }
        a(28, true, null);
        return;
      }
      a(28, false, Integer.valueOf(paramFromServiceMsg.cResult));
      return;
    }
    a(28, false, null);
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Oidb_0x5d1.RspBody localRspBody = new Oidb_0x5d1.RspBody();
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013) || (paramFromServiceMsg.getResultCode() != 1000))
    {
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    for (paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();; paramFromServiceMsg = localRspBody)
    {
      label174:
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          i1 = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.troopgetnews.", 2, "handle_oidb_0x5d1_0|oidb_sso.OIDBSSOPkg.result = " + i1);
          }
        }
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
      try
      {
        localRspBody.mergeFrom((byte[])paramFromServiceMsg);
        paramFromServiceMsg = localRspBody;
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = null;
        break label174;
      }
      if (paramFromServiceMsg == null) {
        break;
      }
      int i1 = paramFromServiceMsg.uint32_id.get();
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendShield : setId:" + i1 + "hex:" + "");
      }
      if (i1 != 4051) {
        break;
      }
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.troopgetnews.", 2, "handle_oidb_0x5d1_0| oidb_sso parseFrom byte " + paramToServiceMsg.toString());
      return;
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (a(paramToServiceMsg) == 147) {}
    for (int i1 = 72;; i1 = 71)
    {
      if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
      {
        a(i1, false, null);
        return;
      }
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          long l1 = paramToServiceMsg.getInt();
          paramToServiceMsg.getShort();
          paramFromServiceMsg = new byte[4];
          paramToServiceMsg.get(paramFromServiceMsg);
          l1 = Utils.a(paramFromServiceMsg, 0);
          int i2 = paramToServiceMsg.get();
          paramToServiceMsg = new Bundle();
          paramToServiceMsg.putLong("uin", l1);
          paramToServiceMsg.putInt("safety_flag", i2 & 0x1F);
          a(i1, true, paramToServiceMsg);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handle_oidb_0x476 error:" + paramToServiceMsg.getMessage());
        }
        a(i1, false, null);
        return;
      }
    }
  }
  
  protected Class a()
  {
    return FriendListObserver.class;
  }
  
  public String a(int paramInt, long paramLong, String paramString)
  {
    if (paramInt == 11) {
      return paramString;
    }
    return String.valueOf(paramLong);
  }
  
  public String a(long paramLong)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.app, "offlineTips");
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        try
        {
          localObject1 = ((String)localObject1).split(";");
          int i2 = localObject1.length;
          while (i1 < i2)
          {
            Object localObject2 = localObject1[i1].split(":");
            long l1 = Long.parseLong(localObject2[0]);
            localObject2 = localObject2[1];
            this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l1), localObject2);
            i1 += 1;
          }
          str = null;
        }
        catch (Exception localException) {}
      }
    }
    String str;
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    }
    return str;
  }
  
  public String a(long paramLong, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString;
    }
    return String.valueOf(paramLong);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      a(this.jdField_a_of_type_ArrayOfJavaLangString);
      this.jdField_a_of_type_ArrayOfJavaLangString = null;
    }
  }
  
  public void a(byte paramByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "DeleteFriendGroup :" + paramByte);
    }
    ToServiceMsg localToServiceMsg = a("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 2);
    localToServiceMsg.extraData.putByte("group_id", paramByte);
    a(localToServiceMsg);
  }
  
  public void a(byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "AddFriendGroup :" + paramString);
    }
    ToServiceMsg localToServiceMsg = a("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 0);
    localToServiceMsg.extraData.putByte("sort_id", paramByte);
    localToServiceMsg.extraData.putString("group_name", paramString);
    a(localToServiceMsg);
  }
  
  public void a(byte paramByte, ArrayList paramArrayList)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.BindUin");
    localToServiceMsg.extraData.putByte("cCmd", paramByte);
    localToServiceMsg.addAttribute("vecBindUin", paramArrayList);
    a(localToServiceMsg);
  }
  
  public void a(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("message.group.ring");
    localArrayList2.add(String.valueOf(paramInt));
    a(localArrayList1, localArrayList2, 2);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "getAllGeneralSettings.localRevision=" + paramInt1 + " offset=" + paramLong + " respRevision=" + paramInt2 + " isNeedGetTroopMsgFilter=" + paramBoolean);
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {
      localArrayList.add("message.group.policy.*");
    }
    localArrayList.add("message.group.policy_pc.*");
    localArrayList.add("sync.c2c_message");
    localArrayList.add("message.group.ring");
    localArrayList.add("message.group.vibrate");
    localArrayList.add("message.ring.switch");
    localArrayList.add("message.vibrate.switch");
    a(localArrayList, paramInt1, paramLong, paramInt2, 100, paramBoolean);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, byte[] paramArrayOfByte, byte paramByte, String paramString, long paramLong3, long paramLong4)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "BumpSvc.ReqComfirmContactFriend");
    Object localObject = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
    if (localObject != null)
    {
      String str = ((RespondQueryQQBindingStat)localObject).nationCode + ((RespondQueryQQBindingStat)localObject).mobileNo;
      if ((str != null) && (str.length() > 0))
      {
        localObject = str;
        if (str.startsWith("+")) {
          localObject = str.substring(1);
        }
      }
    }
    for (long l1 = Long.parseLong((String)localObject);; l1 = 0L)
    {
      localToServiceMsg.extraData.putInt("bType", paramInt);
      localToServiceMsg.extraData.putLong("lToMID", paramLong1);
      localToServiceMsg.extraData.putLong("lFromMobile", l1);
      localToServiceMsg.extraData.putLong("lToMobile", paramLong2);
      localToServiceMsg.extraData.putByteArray("vSig", paramArrayOfByte);
      localToServiceMsg.extraData.putByte("bGroupId", paramByte);
      localToServiceMsg.extraData.putString("strNickName", paramString);
      localToServiceMsg.extraData.putLong("infotime", paramLong3);
      localToServiceMsg.extraData.putLong("dbid", paramLong4);
      a(localToServiceMsg);
      return;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, paramString, paramInt2, 0, null, 0);
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    boolean bool;
    if (paramInt1 == 0)
    {
      bool = true;
      if (paramInt2 != 1) {
        break label550;
      }
      if (this.jdField_c_of_type_JavaUtilHashtable.containsKey(paramString1)) {
        this.jdField_c_of_type_JavaUtilHashtable.remove(paramString1);
      }
      paramString2 = new fcl(this);
      paramString2.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_c_of_type_JavaUtilHashtable.put(paramString1, paramString2);
    }
    for (;;)
    {
      Object localObject;
      if (((!bool) || (paramInt2 == 4)) && (paramString2 != null))
      {
        long l3 = paramString2.b - paramString2.jdField_a_of_type_Long;
        long l2 = 0L;
        long l1 = l2;
        if (paramString2.c > paramString2.b)
        {
          l1 = l2;
          if (paramString2.b > 0L) {
            l1 = paramString2.c - paramString2.b;
          }
        }
        l2 = paramString2.d - paramString2.c;
        localObject = new StringBuffer(200);
        ((StringBuffer)localObject).append("===QQHeadStat resultCode=").append(paramInt1);
        ((StringBuffer)localObject).append(", uin=").append(String.format("%11s", new Object[] { paramString1 }));
        ((StringBuffer)localObject).append(", totalTime=").append(String.format("%-5s", new Object[] { Long.valueOf(paramString2.e) }));
        ((StringBuffer)localObject).append(", picSize=").append(String.format("%-6s", new Object[] { Integer.valueOf(paramString2.jdField_a_of_type_Int) }));
        ((StringBuffer)localObject).append(", downInfoTime=").append(l3);
        ((StringBuffer)localObject).append(", intervalTime=").append(l1);
        ((StringBuffer)localObject).append(", downPicTime=").append(l2);
        ((StringBuffer)localObject).append(", reasonCode=").append(paramInt4);
        ((StringBuffer)localObject).append(", downUrl=").append(paramString2.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("QQHeadCostTime", 2, ((StringBuffer)localObject).toString());
        }
        if (NetworkUtil.e(BaseApplication.getContext()))
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("qqhead_uin", paramString1);
          ((HashMap)localObject).put("downInfo_time", String.valueOf(l3));
          ((HashMap)localObject).put("interval_time", String.valueOf(l1));
          ((HashMap)localObject).put("downPic_time", String.valueOf(l2));
          ((HashMap)localObject).put("download_url", paramString2.jdField_a_of_type_JavaLangString);
          ((HashMap)localObject).put("param_FailCode", paramInt1 + "");
          if (paramInt4 != 0) {
            ((HashMap)localObject).put("fail_reason", paramInt4 + "");
          }
          StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actFriendGetQQHead", bool, paramString2.e, paramString2.jdField_a_of_type_Int, (HashMap)localObject, "");
        }
      }
      return;
      bool = false;
      break;
      label550:
      if (this.jdField_c_of_type_JavaUtilHashtable.containsKey(paramString1))
      {
        localObject = (fcl)this.jdField_c_of_type_JavaUtilHashtable.get(paramString1);
        switch (paramInt2)
        {
        }
        for (;;)
        {
          paramString2 = (String)localObject;
          break;
          ((fcl)localObject).b = System.currentTimeMillis();
          if (!bool) {
            this.jdField_c_of_type_JavaUtilHashtable.remove(paramString1);
          }
          ((fcl)localObject).e = (((fcl)localObject).b - ((fcl)localObject).jdField_a_of_type_Long);
          paramString2 = (String)localObject;
          break;
          ((fcl)localObject).c = System.currentTimeMillis();
          paramString2 = (String)localObject;
          break;
          ((fcl)localObject).d = System.currentTimeMillis();
          ((fcl)localObject).jdField_a_of_type_Int = paramInt3;
          ((fcl)localObject).jdField_a_of_type_JavaLangString = paramString2;
          ((fcl)localObject).e = (((fcl)localObject).d - ((fcl)localObject).jdField_a_of_type_Long);
          this.jdField_c_of_type_JavaUtilHashtable.remove(paramString1);
        }
      }
      paramString2 = null;
    }
  }
  
  public void a(int paramInt, ConcurrentHashMap paramConcurrentHashMap)
  {
    if ((paramConcurrentHashMap == null) || (paramConcurrentHashMap.size() == 0)) {
      return;
    }
    Object localObject = new ConcurrentHashMap();
    ((Map)localObject).putAll(paramConcurrentHashMap);
    paramConcurrentHashMap = new ArrayList();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramConcurrentHashMap.add(new GeneralSettings.Setting((String)localEntry.getKey(), ((Integer)localEntry.getValue()).toString()));
    }
    localObject = a("ProfileService.ReqSetSettings");
    ((ToServiceMsg)localObject).extraData.putSerializable("Settings", paramConcurrentHashMap);
    ((ToServiceMsg)localObject).extraData.putSerializable("localRevision", Integer.valueOf(paramInt));
    a((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.SvcReqKikOut");
    localToServiceMsg.extraData.putLong("appid", paramLong);
    localToServiceMsg.extraData.putByte("cKeyType", paramByte);
    localToServiceMsg.extraData.putLong("lUin", Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
    localToServiceMsg.extraData.putByteArray("sKey", paramArrayOfByte);
    localToServiceMsg.extraData.putInt("index", paramInt);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, String paramString, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    ToServiceMsg localToServiceMsg = a("SummaryCard.ReqCondSearch");
    localToServiceMsg.extraData.putLong("search_seq", paramLong1);
    localToServiceMsg.extraData.putInt("param_page", paramInt1);
    localToServiceMsg.extraData.putLong("param_session_id", paramLong2);
    localToServiceMsg.extraData.putString("param_keyword", paramString);
    localToServiceMsg.extraData.putInt("param_sex_index", paramInt2);
    localToServiceMsg.extraData.putInt("param_age_index", ConditionSearchManager.b(paramInt3));
    localToServiceMsg.extraData.putStringArray("param_loc_code", paramArrayOfString1);
    localToServiceMsg.extraData.putStringArray("param_home_code", paramArrayOfString2);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, int paramInt1, String paramString, int paramInt2, ArrayList paramArrayList)
  {
    device_lock_confirm_auth.ReqBody localReqBody = new device_lock_confirm_auth.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
    localReqBody.uint32_appid.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localReqBody.uint32_subappid.set(paramInt1);
    localReqBody.uint32_seq.set(paramInt2);
    localReqBody.bytes_appname.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    int i1 = paramArrayList.size();
    paramString = new ArrayList();
    paramInt2 = 0;
    if (paramInt2 < i1)
    {
      device_lock_confirm_auth.DeviceInfo localDeviceInfo = new device_lock_confirm_auth.DeviceInfo();
      DeviceLockItemInfo localDeviceLockItemInfo = (DeviceLockItemInfo)paramArrayList.get(paramInt2);
      if (localDeviceLockItemInfo == null) {}
      for (;;)
      {
        paramInt2 += 1;
        break;
        localDeviceInfo.bytes_appname.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_c_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_device_name.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_a_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_device_typeinfo.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_b_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_guid.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_a_of_type_ArrayOfByte));
        localDeviceInfo.uint32_appid.set(localDeviceLockItemInfo.jdField_a_of_type_Int);
        localDeviceInfo.uint32_auth_status.set(localDeviceLockItemInfo.jdField_c_of_type_Int);
        localDeviceInfo.uint32_subappid.set(paramInt1);
        paramString.add(localDeviceInfo);
      }
    }
    if (paramString.size() > 0) {
      localReqBody.rpt_msg_devicelist.set(paramString);
    }
    paramString = a("DevLockAuthSvc.ConfirmAuth");
    paramString.putWupBuffer(localReqBody.toByteArray());
    paramString.setTimeout(4000L);
    b(paramString);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    int i1;
    Object localObject1;
    long l1;
    Object localObject2;
    if (paramBoolean)
    {
      i1 = 1;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendShield : send_oidb_0x5d1_0 : uin : " + paramLong + " setId:" + paramInt + " isSet:" + paramBoolean);
      }
      localObject1 = new Oidb_0x5d1.ReqBody();
      ((Oidb_0x5d1.ReqBody)localObject1).uint32_cmd.set(i1);
      ((Oidb_0x5d1.ReqBody)localObject1).uint32_id.set(paramInt);
      l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacts.", 2, "FriendListHandler.send_oidb_0x5d1_0 " + l1);
      }
      if (!paramBoolean) {
        break label321;
      }
      localObject2 = new Oidb_0x5d1.SetFriendIdReq();
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).uint32_if_check_seq.set(0);
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).uint64_seq.set(l1);
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).rpt_uint64_friends.add(Long.valueOf(paramLong));
      ((Oidb_0x5d1.ReqBody)localObject1).msg_set_friend_id.set((MessageMicro)localObject2);
    }
    for (;;)
    {
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1489);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x5d1.ReqBody)localObject1).toByteArray()));
      localObject1 = a("OidbSvc.0x5d1_0");
      ((ToServiceMsg)localObject1).extraData.putLong("friendUin", paramLong);
      ((ToServiceMsg)localObject1).extraData.putBoolean("isSet", paramBoolean);
      ((ToServiceMsg)localObject1).extraData.putInt("setId", paramInt);
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      b((ToServiceMsg)localObject1);
      return;
      i1 = 2;
      break;
      label321:
      localObject2 = new Oidb_0x5d1.ClearFriendIdReq();
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).uint32_if_check_seq.set(0);
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).uint64_seq.set(l1);
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).rpt_uint64_friends.add(Long.valueOf(paramLong));
      ((Oidb_0x5d1.ReqBody)localObject1).msg_clear_friend_id.set((MessageMicro)localObject2);
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", 0L);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    device_lock_recommend_auth.ReqBody localReqBody = new device_lock_recommend_auth.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
    localReqBody.uint32_appid.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localReqBody.uint32_subappid.set(paramInt);
    localReqBody.bytes_appname.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    localReqBody.uint32_seq.set(1);
    paramString = a("DevLockAuthSvc.RecommendAuth");
    paramString.putWupBuffer(localReqBody.toByteArray());
    paramString.setTimeout(4000L);
    b(paramString);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 1L);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    a(paramLong, 4051, paramBoolean);
  }
  
  public void a(CheckUpdateResp paramCheckUpdateResp)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "FriendListHandler::handleCheckUpdate called");
    }
    if ((paramCheckUpdateResp == null) || (paramCheckUpdateResp.result != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("FriendListHandler::handleCheckUpdate called data result = ");
        if (paramCheckUpdateResp == null) {
          break label80;
        }
      }
      label80:
      for (int i1 = paramCheckUpdateResp.result;; i1 = -1)
      {
        QLog.d("ProfileService.CheckUpdateReq", 2, i1 + " decode failed return now");
        return;
      }
    }
    Iterator localIterator = paramCheckUpdateResp.vecResPkg.iterator();
    paramCheckUpdateResp = null;
    if (localIterator.hasNext())
    {
      Object localObject2 = (RespItem)localIterator.next();
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "FriendListHandler::handleCheckUpdate item eServiceId = " + ((RespItem)localObject2).eServiceID + ",result=" + ((RespItem)localObject2).cResult);
      }
      CheckUpdateItemInterface localCheckUpdateItemInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a(((RespItem)localObject2).eServiceID);
      if (localCheckUpdateItemInterface != null) {
        if (((RespItem)localObject2).eServiceID == 101)
        {
          localObject1 = localCheckUpdateItemInterface;
          paramCheckUpdateResp = (CheckUpdateResp)localObject2;
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        localObject1 = paramCheckUpdateResp;
        paramCheckUpdateResp = (CheckUpdateResp)localObject2;
        break;
        localCheckUpdateItemInterface.a((RespItem)localObject2);
        if ((localObject2 != null) && (((RespItem)localObject2).eServiceID == 109) && (2 == ((RespItem)localObject2).cResult)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a().remove(Integer.valueOf(((RespItem)localObject2).eServiceID));
        }
        localObject2 = paramCheckUpdateResp;
        paramCheckUpdateResp = (CheckUpdateResp)localObject1;
        localObject1 = localObject2;
      }
    }
    if ((paramCheckUpdateResp != null) && (localObject1 != null)) {
      paramCheckUpdateResp.a((RespItem)localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b();
  }
  
  public void a(RichStatus paramRichStatus, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.SetRichSig");
    localToServiceMsg.extraData.putByteArray("sig_value", paramRichStatus.a());
    localToServiceMsg.extraData.putInt("key", paramInt);
    a(localToServiceMsg);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess()) {
      if (QLog.isColorLevel()) {
        QLog.d("TAG", 2, "onReceive: onReceive handleRecommendDeviceList");
      }
    }
    for (paramFromServiceMsg = new device_lock_recommend_auth.RspBody();; paramFromServiceMsg = null)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint64_uin.has()) {
          paramFromServiceMsg.uint64_uin.get();
        }
        if (paramFromServiceMsg.uint32_seq.has()) {
          paramFromServiceMsg.uint32_seq.get();
        }
        if (paramFromServiceMsg.uint32_ret.has()) {
          paramFromServiceMsg.uint32_ret.get();
        }
        if (!paramFromServiceMsg.rpt_msg_devicelist.has()) {
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg.rpt_msg_devicelist.get();
        paramObject = new ArrayList();
        if (paramFromServiceMsg == null) {}
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        try
        {
          int i2 = paramFromServiceMsg.size();
          int i1 = 0;
          label137:
          if (i1 < i2)
          {
            device_lock_recommend_auth.DeviceInfo localDeviceInfo = (device_lock_recommend_auth.DeviceInfo)paramFromServiceMsg.get(i1);
            if (localDeviceInfo == null) {}
            for (;;)
            {
              i1 += 1;
              break label137;
              paramObject = paramObject;
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "onReceive: onReceive sec_server package:sigResult parse fail");
              }
              paramObject.printStackTrace();
              break;
              DeviceLockItemInfo localDeviceLockItemInfo = new DeviceLockItemInfo();
              if (localDeviceInfo.bytes_appname.has())
              {
                localDeviceLockItemInfo.jdField_c_of_type_JavaLangString = new String(localDeviceInfo.bytes_appname.get().toByteArray(), "UTF-8");
                if (localDeviceInfo.bytes_guid.has())
                {
                  localDeviceLockItemInfo.jdField_a_of_type_ArrayOfByte = localDeviceInfo.bytes_guid.get().toByteArray();
                  if (localDeviceInfo.bytes_device_typeinfo.has())
                  {
                    localDeviceLockItemInfo.jdField_b_of_type_JavaLangString = new String(localDeviceInfo.bytes_device_typeinfo.get().toByteArray(), "UTF-8");
                    new StringBuffer();
                    if (localDeviceInfo.bytes_device_name.has())
                    {
                      localDeviceLockItemInfo.jdField_a_of_type_JavaLangString = new String(localDeviceInfo.bytes_device_name.get().toByteArray(), "UTF-8");
                      if (localDeviceInfo.uint32_auth_status.has())
                      {
                        localDeviceLockItemInfo.jdField_c_of_type_Int = localDeviceInfo.uint32_auth_status.get();
                        if (localDeviceInfo.uint32_appid.has())
                        {
                          localDeviceLockItemInfo.jdField_a_of_type_Int = localDeviceInfo.uint32_appid.get();
                          if (localDeviceInfo.uint32_subappid.has())
                          {
                            localDeviceLockItemInfo.jdField_b_of_type_Int = localDeviceInfo.uint32_subappid.get();
                            paramObject.add(localDeviceLockItemInfo);
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          if (paramObject.size() <= 0) {
            break label444;
          }
        }
        catch (Exception paramFromServiceMsg) {}
        a(69, true, paramObject);
        return;
      }
      label444:
      a(69, false, null);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (c(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    label1063:
    label1069:
    do
    {
      do
      {
        do
        {
          int i1;
          Object localObject;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (paramFromServiceMsg.getServiceCmd().equals("friendlist.getFriendGroupList"))
                  {
                    if (paramFromServiceMsg.isSuccess())
                    {
                      paramObject = (GetFriendListResp)paramObject;
                      if (paramObject != null)
                      {
                        if (paramToServiceMsg.extraData.getBoolean("getSingleFriend"))
                        {
                          a(paramToServiceMsg, paramObject);
                          return;
                        }
                        a(paramFromServiceMsg.getUin(), paramObject, paramToServiceMsg.extraData.getLong("timeStamp"), paramToServiceMsg.extraData.getStringArrayList("uinList"));
                        return;
                      }
                      this.g = 0L;
                      a(1, false, null);
                      return;
                    }
                    this.g = 0L;
                    a(1, false, null);
                    return;
                  }
                  if (paramFromServiceMsg.getServiceCmd().equals("DevLockAuthSvc.RecommendAuth"))
                  {
                    a(paramFromServiceMsg, paramObject);
                    return;
                  }
                  if (paramFromServiceMsg.getServiceCmd().equals("DevLockAuthSvc.ConfirmAuth"))
                  {
                    c(paramFromServiceMsg.isSuccess());
                    return;
                  }
                  if (paramFromServiceMsg.getServiceCmd().equals("friendlist.GetLastLoginInfoReq"))
                  {
                    a(paramFromServiceMsg, (GetLastLoginInfoResp)paramObject);
                    return;
                  }
                  if (!paramFromServiceMsg.getServiceCmd().equals("ProfileService.GetRichSig")) {
                    break;
                  }
                } while (!paramFromServiceMsg.isSuccess());
                i1 = paramToServiceMsg.extraData.getInt("reqType", 0);
                if (i1 == 1)
                {
                  a(paramToServiceMsg, paramObject);
                  return;
                }
                if (i1 == 0)
                {
                  c(paramToServiceMsg, paramObject);
                  return;
                }
                b(paramToServiceMsg, paramObject);
                return;
                if (!"ProfileService.GetSimpleInfo".equals(paramFromServiceMsg.getServiceCmd())) {
                  break;
                }
                localObject = paramToServiceMsg.extraData.getStringArrayList("uinList");
              } while (!paramFromServiceMsg.isSuccess());
              paramObject = (ArrayList)paramObject;
            } while (paramObject == null);
            a(paramToServiceMsg, (ArrayList)localObject, paramFromServiceMsg, paramObject);
            return;
            if ("OidbSvc.0x4fc_30".equals(paramFromServiceMsg.getServiceCmd()))
            {
              c(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if ("AvatarInfoSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
            {
              a(paramToServiceMsg, paramFromServiceMsg, (QQHeadUrlResp)paramObject);
              return;
            }
            if ("IncreaseURLSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
            {
              d(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if ("StatSvc.GetDevLoginInfo".equals(paramFromServiceMsg.getServiceCmd()))
            {
              if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 1L)
              {
                b(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 2L)
              {
                c(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 4L)
              {
                d(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
                return;
              }
              a(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
              return;
            }
            if ("StatSvc.DelDevLoginInfo".equals(paramFromServiceMsg.getServiceCmd()))
            {
              if (paramToServiceMsg.extraData.getInt("iDelType") == 1)
              {
                b(paramToServiceMsg, paramFromServiceMsg, (SvcRspDelLoginInfo)paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getInt("iDelType") == 2)
              {
                a(paramToServiceMsg, paramFromServiceMsg, (SvcRspDelLoginInfo)paramObject);
                return;
              }
              c(paramToServiceMsg, paramFromServiceMsg, (SvcRspDelLoginInfo)paramObject);
              return;
            }
            if ("StatSvc.SvcReqKikOut".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
            {
              a(paramToServiceMsg, paramFromServiceMsg, (SvcRespKikOut)paramObject);
              return;
            }
            if ("StatSvc.BindUin".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
            {
              a(paramToServiceMsg, paramFromServiceMsg, (SvcRspBindUin)paramObject);
              return;
            }
            if ("ProfileService.ReqGetSettings".equals(paramFromServiceMsg.getServiceCmd()))
            {
              a(paramToServiceMsg, paramFromServiceMsg, (RespGetSettings)paramObject);
              return;
            }
            if ("ProfileService.ReqSetSettings".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
            {
              a(paramToServiceMsg, paramFromServiceMsg, (RespSetSettings)paramObject);
              return;
            }
            if (!"friendlist.MovGroupMemReq".equals(paramFromServiceMsg.getServiceCmd())) {
              break;
            }
            i1 = paramToServiceMsg.extraData.getByte("move_fri_type");
            if (i1 == 0)
            {
              if (paramObject != null)
              {
                a(paramToServiceMsg, (MovGroupMemResp)paramObject);
                return;
              }
              a(9, false, null);
              return;
            }
          } while ((i1 != 1) || (paramObject == null));
          paramToServiceMsg = (MovGroupMemResp)paramObject;
          return;
          if ("BumpSvc.ReqComfirmContactFriend".equals(paramFromServiceMsg.getServiceCmd()))
          {
            if (paramFromServiceMsg.isSuccess())
            {
              a(paramToServiceMsg, true);
              return;
            }
            a(10, false, null);
            return;
          }
          if ("friendlist.addFriend".equals(paramFromServiceMsg.getServiceCmd()))
          {
            if (paramObject != null)
            {
              paramObject = (AddFriendResp)paramObject;
              a(paramFromServiceMsg.getUin(), paramObject, paramToServiceMsg);
              return;
            }
            a(11, false, null);
            return;
          }
          if ("friendlist.getUserAddFriendSetting".equals(paramFromServiceMsg.getServiceCmd()))
          {
            if (paramObject != null)
            {
              a(paramFromServiceMsg, (GetUserAddFriendSettingResp)paramObject);
              return;
            }
            a(12, false, null);
            return;
          }
          if ("friendlist.GetSimpleOnlineFriendInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
          {
            if (paramObject != null)
            {
              b(paramFromServiceMsg, paramObject);
              return;
            }
            a(13, false, null);
            return;
          }
          if ("friendlist.GetOnlineInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
          {
            g(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("friendlist.delFriend".equals(paramFromServiceMsg.getServiceCmd()))
          {
            if (paramObject != null)
            {
              a(paramFromServiceMsg, (DelFriendResp)paramObject);
              return;
            }
            a(15, false, null);
            return;
          }
          if ("friendlist.SetGroupReq".equals(paramFromServiceMsg.getServiceCmd()))
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("onSetGroupCmd :").append(paramToServiceMsg.extraData.getInt("set_type", -1000)).append(", ").append(paramFromServiceMsg.isSuccess()).append(", ");
              if (paramObject == null) {
                break label1063;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              QLog.d("FriendListHandler", 2, bool);
              if (!paramFromServiceMsg.isSuccess()) {
                break label1069;
              }
              paramFromServiceMsg = (SetGroupResp)paramObject;
              if (paramFromServiceMsg == null) {
                break;
              }
              a(paramToServiceMsg, paramFromServiceMsg);
              return;
            }
            switch (paramToServiceMsg.extraData.getInt("set_type", -1))
            {
            default: 
              return;
            case 0: 
              a(18, false, null);
              return;
            case 1: 
              a(19, false, null);
              return;
            case 2: 
              a(21, false, null);
              return;
            }
            a(22, false, null);
            return;
          }
          if ("ProfileService.ChangeFriendName".equals(paramFromServiceMsg.getServiceCmd()))
          {
            h(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("ProfileService.SetRichSig".equals(paramFromServiceMsg.getServiceCmd()))
          {
            i(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if (!"StatSvc.register".equals(paramFromServiceMsg.getServiceCmd())) {
            break;
          }
          paramToServiceMsg = (SvcRespRegister)paramObject;
        } while ((paramObject == null) || (paramToServiceMsg.cReplyCode != 0));
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacts.", 2, "FriendListHandler.onReceive " + paramToServiceMsg.timeStamp + ", " + paramToServiceMsg.bUpdateFlag);
        }
        if (paramToServiceMsg.timeStamp != 0L) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong(Constants.Key.SvcRegister_timeStamp.toString(), paramToServiceMsg.timeStamp).commit();
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L) != 0L) && (paramToServiceMsg.bUpdateFlag != 1));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a(paramToServiceMsg.bUpdateFlag);
      return;
      if (paramFromServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetAutoInfoReq"))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("ProfileService.CheckUpdateReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if ((paramFromServiceMsg.getResultCode() == 1000) && (QLog.isColorLevel())) {
          QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdate ok resultcode = " + paramFromServiceMsg.getResultCode());
        }
        if (((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013)) && (QLog.isColorLevel())) {
          QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdate timeout resultcode = " + paramFromServiceMsg.getResultCode());
        }
        a((CheckUpdateResp)paramObject);
        return;
      }
      if ("SummaryCard.ReqSearch".equals(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5d1_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (("OidbSvc.0x476_146".equals(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0x476_147".equals(paramFromServiceMsg.getServiceCmd())))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"SummaryCard.ReqCondSearch".equals(paramFromServiceMsg.getServiceCmd()));
    f(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, ArrayList paramArrayList1, FromServiceMsg paramFromServiceMsg, ArrayList paramArrayList2)
  {
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    paramFromServiceMsg = localFriendsManagerImp.a();
    for (;;)
    {
      try
      {
        paramFromServiceMsg.a();
        Iterator localIterator = paramArrayList2.iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        localProfSmpInfoRes = (ProfSmpInfoRes)localIterator.next();
        str = String.valueOf(localProfSmpInfoRes.dwUin);
        if (!paramArrayList1.contains(str)) {
          continue;
        }
        if (str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().setProperty(Constants.PropertiesKey.nickName.toString() + str, localProfSmpInfoRes.strNick);
        }
        localFriendsManagerImp.a(String.valueOf(localProfSmpInfoRes.dwUin), localProfSmpInfoRes.wFace, localProfSmpInfoRes.strNick, null);
        localCard = localFriendsManagerImp.b(str);
        localCard.nFaceID = localProfSmpInfoRes.wFace;
        localCard.shGender = ((short)localProfSmpInfoRes.cSex);
        localCard.age = localProfSmpInfoRes.wAge;
        localCard.shAge = ((short)localProfSmpInfoRes.wAge);
        if (localProfSmpInfoRes.strNick != null) {
          localCard.strNick = localProfSmpInfoRes.strNick;
        }
        if (localProfSmpInfoRes.sProvince != null) {
          localCard.strProvince = localProfSmpInfoRes.sProvince;
        }
        if (localProfSmpInfoRes.sCity != null) {
          localCard.strCity = localProfSmpInfoRes.sCity;
        }
        if ((str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (localProfSmpInfoRes.wLevel != 0)) {
          localCard.iQQLevel = localProfSmpInfoRes.wLevel;
        }
        if ((!str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) || (localProfSmpInfoRes.isShowXMan == -1) || (localProfSmpInfoRes.dwLoginDay <= 0L) || (localProfSmpInfoRes.dwPhoneQQXManDay <= 0L)) {
          continue;
        }
        localCard.lLoginDays = localProfSmpInfoRes.dwLoginDay;
        localCard.lQQMasterLogindays = localProfSmpInfoRes.dwPhoneQQXManDay;
        if (localProfSmpInfoRes.isShowXMan != 1) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramArrayList1)
      {
        ProfSmpInfoRes localProfSmpInfoRes;
        String str;
        Card localCard;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("FriendListHandler", 2, "handleFriendInfo err", paramArrayList1);
        if (paramFromServiceMsg == null) {
          continue;
        }
        paramFromServiceMsg.b();
        if (!paramToServiceMsg.extraData.getBoolean("batch_data")) {
          continue;
        }
        a(67, true, paramArrayList2);
        return;
        boolean bool = false;
        continue;
        paramFromServiceMsg.c();
        if (paramFromServiceMsg == null) {
          continue;
        }
        paramFromServiceMsg.b();
        continue;
      }
      finally
      {
        if (paramFromServiceMsg == null) {
          continue;
        }
        paramFromServiceMsg.b();
      }
      localCard.setXManFlag(bool);
      localFriendsManagerImp.a(localCard);
      if (paramToServiceMsg.extraData.getBoolean("reqSelfLevel", false))
      {
        ContactConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "$handleFriendInfo | iQQLevel = " + localProfSmpInfoRes.wLevel);
        }
      }
      if (paramToServiceMsg.extraData.getBoolean("reqXMan", false))
      {
        ContactConfig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "$handleFriendInfo | dwLoginDay = " + localProfSmpInfoRes.dwLoginDay + " | dwPhoneQQXManDay = " + localProfSmpInfoRes.dwPhoneQQXManDay + " | isShowXMan = " + localProfSmpInfoRes.isShowXMan);
        }
      }
      a(3, true, str);
    }
  }
  
  public void a(DelGroupResp paramDelGroupResp, boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (paramBoolean) {
      localFriendsManagerImp.a(paramDelGroupResp.cGroupid);
    }
    a(21, paramBoolean, paramGroupActionResp);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FetchInfoListManager", 2, "uin = " + paramString);
    }
    if ((Friends.isValidUin(paramString)) && (a(paramString)))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramString);
      ToServiceMsg localToServiceMsg = a("ProfileService.GetSimpleInfo");
      localToServiceMsg.extraData.putStringArrayList("uinList", localArrayList);
      localToServiceMsg.extraData.putBoolean("reqSelfLevel", b(paramString));
      localToServiceMsg.extraData.putBoolean("reqXMan", e(paramString));
      a(localToServiceMsg);
    }
  }
  
  public void a(String paramString, byte paramByte)
  {
    a(4, paramString, (byte)0, paramByte, null);
  }
  
  public void a(String paramString, byte paramByte1, byte paramByte2)
  {
    a(1, paramString, paramByte1, paramByte2, null);
  }
  
  public void a(String paramString1, byte paramByte1, byte paramByte2, byte paramByte3, String paramString2)
  {
    if (paramByte1 == 1)
    {
      a(100, paramString1, paramByte2, paramByte3, paramString2);
      return;
    }
    a(1, paramString1, paramByte2, paramByte3, null);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.GetAutoInfoReq");
    localToServiceMsg.extraData.putString("friendUin", paramString);
    localToServiceMsg.extraData.putByte("cType", (byte)1);
    localToServiceMsg.extraData.putInt("source_id", paramInt1);
    localToServiceMsg.extraData.putInt("sub_source_id", paramInt2);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if ((Friends.isValidUin(paramString)) && (a(paramString)))
    {
      a(new String[] { paramString });
      ToServiceMsg localToServiceMsg = a("ProfileService.GetSimpleInfo");
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramString);
      localToServiceMsg.extraData.putStringArrayList("uinList", localArrayList);
      localToServiceMsg.extraData.putInt("type", paramInt);
      localToServiceMsg.extraData.putString("discussionUin", String.valueOf(paramLong));
      a(localToServiceMsg);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.getUserAddFriendSetting");
    localToServiceMsg.extraData.putString("uin", paramString1);
    localToServiceMsg.extraData.putInt("source_id", paramInt);
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      localToServiceMsg.extraData.putString("friend_mobile_number", paramString2);
    }
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, int paramInt1, boolean paramBoolean1, byte paramByte1, String paramString2, int paramInt2, int paramInt3, String paramString3, byte paramByte2, byte[] paramArrayOfByte, String paramString4, boolean paramBoolean2, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "addFriend" + paramString1 + ";friendSetting " + paramInt1 + ";myAllowFlag " + paramBoolean1 + ";groupId " + paramByte1 + ";msg " + paramString2 + ";sourceID " + paramInt2 + ";subSourceId " + paramInt3 + ";mobileNum " + paramString3 + ";autoSend " + paramByte2 + ";troopUin " + paramString4 + ";isContactBothWay " + paramBoolean2 + ";remark " + paramString5);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.addFriend");
    localToServiceMsg.extraData.putString("uin", paramString1);
    localToServiceMsg.extraData.putInt("friend_setting", paramInt1);
    localToServiceMsg.extraData.putBoolean("allow_added", paramBoolean1);
    localToServiceMsg.extraData.putByte("group_id", paramByte1);
    localToServiceMsg.extraData.putString("msg", paramString2);
    localToServiceMsg.extraData.putInt("source_id", paramInt2);
    localToServiceMsg.extraData.putInt("sub_source_id", paramInt3);
    if ((paramString3 != null) && (paramString3.length() > 0)) {
      localToServiceMsg.extraData.putString("friend_mobile_number", paramString3);
    }
    if ((paramString4 != null) && (paramString4.length() > 0)) {
      localToServiceMsg.extraData.putString("troop_uin", paramString4);
    }
    localToServiceMsg.extraData.putByte("auto_send", paramByte2);
    localToServiceMsg.extraData.putByteArray("sig", paramArrayOfByte);
    localToServiceMsg.extraData.putBoolean("contact_bothway", paramBoolean2);
    localToServiceMsg.extraData.putString("remark", paramString5);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ToServiceMsg localToServiceMsg = a("SummaryCard.ReqSearch");
    localToServiceMsg.extraData.putString("param_keyword", paramString1);
    localToServiceMsg.extraData.putString("param_country_code", paramString2);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject;
    if (!paramBoolean)
    {
      localObject = a("ProfileService.ChangeFriendName");
      ((ToServiceMsg)localObject).extraData.putString("com_value", paramString2);
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString1);
      a((ToServiceMsg)localObject);
    }
    do
    {
      return;
      localObject = paramString2;
      if (paramString2 == null) {
        localObject = "";
      }
      paramString2 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      Card localCard = paramString2.b(paramString1);
      localCard.strReMark = ((String)localObject);
      paramString2.a(localCard);
      paramString2.a(paramString1, (String)localObject, (byte)1);
      paramString2.b(paramString1, (String)localObject);
      paramString1 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    } while (paramString1 == null);
    paramString1.d();
  }
  
  public void a(String paramString, ArrayList paramArrayList, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.DelDevLoginInfo");
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.addAttribute("vecDeviceItemDes", paramArrayList);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putInt("index", paramInt);
    localToServiceMsg.extraData.putInt("iDelType", 1);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, ArrayList paramArrayList, int paramInt, boolean paramBoolean, long paramLong)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.DelDevLoginInfo");
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.addAttribute("vecDeviceItemDes", paramArrayList);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putInt("index", paramInt);
    localToServiceMsg.extraData.putInt("iDelType", 2);
    if (paramBoolean) {
      localToServiceMsg.extraData.putInt("iDelMe", 1);
    }
    for (;;)
    {
      localToServiceMsg.extraData.putLong("iAppId", paramLong);
      a(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putInt("iDelMe", 0);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.getFriendGroupList");
    localToServiceMsg.extraData.putBoolean("getSingleFriend", true);
    localToServiceMsg.extraData.putString("targetUin", paramString);
    a(localToServiceMsg);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StatusPush", 2, "handlePushBatchFStatus uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + " at " + System.currentTimeMillis());
    }
    ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramArrayList);
    HashMap localHashMap = new HashMap();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localHashMap.put(String.valueOf(((RequestPushFStatus)paramArrayList.next()).lUin), "");
    }
    a(8, true, localHashMap);
    if (this.aM == 0)
    {
      this.aM = 1;
      new Handler(Looper.getMainLooper()).postDelayed(new fch(this), 15000L);
    }
  }
  
  public void a(ArrayList paramArrayList, int paramInt1, long paramLong1, int paramInt2, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "GeneralSettings getGeneralSettings start offset =" + paramLong1);
    }
    ToServiceMsg localToServiceMsg = a("ProfileService.ReqGetSettings");
    localToServiceMsg.extraData.putSerializable("Paths", paramArrayList);
    localToServiceMsg.extraData.putInt("Revision", paramInt1);
    localToServiceMsg.extraData.putLong("Offset", paramLong1);
    localToServiceMsg.extraData.putLong("Count", paramLong2);
    localToServiceMsg.extraData.putInt("respRevision", paramInt2);
    localToServiceMsg.extraData.putBoolean("needTroopSettings", paramBoolean);
    a(localToServiceMsg);
  }
  
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if ((paramArrayList1 == null) || (paramArrayList2 == null) || (paramArrayList1.size() != paramArrayList2.size())) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList1.size())
    {
      String str = (String)paramArrayList1.get(i1);
      int i2 = ((Integer)paramArrayList2.get(i1)).intValue();
      localArrayList1.add("message.group.policy." + str);
      localArrayList2.add(String.valueOf(i2));
      i1 += 1;
    }
    a(localArrayList1, localArrayList2, 1);
  }
  
  protected void a(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt)
  {
    if ((paramArrayList1 == null) || (paramArrayList2 == null) || (paramArrayList1.size() != paramArrayList2.size())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList1.size())
    {
      localArrayList.add(new GeneralSettings.Setting((String)paramArrayList1.get(i1), (String)paramArrayList2.get(i1)));
      i1 += 1;
    }
    paramArrayList1 = a("ProfileService.ReqSetSettings");
    paramArrayList1.extraData.putSerializable("Settings", localArrayList);
    paramArrayList1.extraData.putInt("local_type", paramInt);
    a(paramArrayList1);
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "getFriendGroupList " + l1 + ", " + this.g);
    }
    if ((this.g > 0L) && (l1 - this.g < 300000L)) {
      return;
    }
    this.g = l1;
    ArrayList localArrayList = new ArrayList();
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0, 20, 0, 100, 0L, localArrayList, paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a().entrySet().iterator();
      Object localObject2 = new ArrayList();
      while (((Iterator)localObject1).hasNext())
      {
        Integer localInteger = (Integer)((Map.Entry)((Iterator)localObject1).next()).getKey();
        if (localInteger.intValue() != 101) {
          ((ArrayList)localObject2).add(localInteger);
        }
      }
      localObject1 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Integer)((Iterator)localObject1).next();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a().remove(localObject2);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdate called CheckUpdateItemInterface count = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a().size());
    }
    Object localObject1 = a("ProfileService.CheckUpdateReq");
    ((ToServiceMsg)localObject1).addAttribute("CheckUpdateType", Integer.valueOf(paramInt));
    a((ToServiceMsg)localObject1);
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 3);
    localToServiceMsg.extraData.putByteArray("group_id_list", paramArrayOfByte1);
    localToServiceMsg.extraData.putByteArray("sort_id_list", paramArrayOfByte2);
    a(localToServiceMsg);
  }
  
  public void a(long[] paramArrayOfLong)
  {
    int i2 = paramArrayOfLong.length;
    Object localObject = ByteBuffer.allocate(i2 * 4 + 8);
    ((ByteBuffer)localObject).putShort((short)2).putShort((short)27025).putShort((short)27032);
    ((ByteBuffer)localObject).putShort((short)i2);
    int i1 = 0;
    while (i1 < i2)
    {
      ((ByteBuffer)localObject).putInt(Utils.a(paramArrayOfLong[i1]));
      i1 += 1;
    }
    paramArrayOfLong = new oidb_sso.OIDBSSOPkg();
    paramArrayOfLong.uint32_command.set(1276);
    paramArrayOfLong.uint32_service_type.set(30);
    paramArrayOfLong.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x4fc_30");
    ((ToServiceMsg)localObject).putWupBuffer(paramArrayOfLong.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(10000L);
    b((ToServiceMsg)localObject);
  }
  
  public void a(String[] paramArrayOfString)
  {
    a(paramArrayOfString, 0, 0, null);
  }
  
  public void a(String[] paramArrayOfString, byte paramByte1, byte paramByte2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.MovGroupMemReq");
    localToServiceMsg.extraData.putByte("move_fri_type", (byte)1);
    localToServiceMsg.extraData.putByte("group_id", paramByte1);
    localToServiceMsg.extraData.putByte("away_group_id", paramByte2);
    int i1 = 0;
    if (i1 < paramArrayOfString.length)
    {
      int i2;
      label85:
      String[] arrayOfString;
      if (paramArrayOfString.length - i1 < 15)
      {
        i2 = paramArrayOfString.length - i1;
        arrayOfString = new String[i2];
        i2 = 0;
      }
      for (;;)
      {
        if ((i2 >= 15) || (i1 + i2 >= paramArrayOfString.length))
        {
          localToServiceMsg.extraData.putStringArray("uins", arrayOfString);
          a(localToServiceMsg);
          i1 += 15;
          break;
          i2 = 15;
          break label85;
        }
        arrayOfString[i2] = paramArrayOfString[(i1 + i2)];
        i2 += 1;
      }
    }
  }
  
  public void a(String[] paramArrayOfString, Bundle paramBundle)
  {
    a(paramArrayOfString, 0, 1, paramBundle);
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis() - this.h;
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "getOnlineFriend  | intervalTime = " + l1 + " | sGetOnlineFriendDelay = " + QQAppInterface.bh);
    }
    return (this.h > 0L) && ((l1 < QQAppInterface.bh) || (l1 > QQAppInterface.bg - QQAppInterface.bh));
  }
  
  public boolean a(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2;
    synchronized (this.jdField_d_of_type_JavaUtilHashtable)
    {
      if (!this.jdField_d_of_type_JavaUtilHashtable.containsKey(paramString)) {
        break label181;
      }
      paramString = (fcj)this.jdField_d_of_type_JavaUtilHashtable.get(paramString);
      l2 = Math.abs(l1 - paramString.jdField_a_of_type_Long);
      if (paramString.c > 0L)
      {
        if (l1 < paramString.c) {
          return false;
        }
        paramString.c = 0L;
        paramString.jdField_a_of_type_Long = l1;
        paramString.b = 1L;
        return true;
      }
    }
    if (l2 < 5000L) {
      return false;
    }
    paramString.b += 1L;
    if (l2 > 60000L)
    {
      if ((paramString.b < 8L) || (l2 >= 120000L)) {
        break label163;
      }
      paramString.c = (l1 + 1800000L);
    }
    for (;;)
    {
      return true;
      label163:
      paramString.c = 0L;
      paramString.jdField_a_of_type_Long = l1;
      paramString.b = 1L;
    }
    label181:
    Object localObject1;
    Object localObject2;
    if (this.jdField_d_of_type_JavaUtilHashtable.size() > 20)
    {
      localObject1 = new ArrayList();
      localObject2 = this.jdField_d_of_type_JavaUtilHashtable.keys();
      while (((Enumeration)localObject2).hasMoreElements())
      {
        String str = (String)((Enumeration)localObject2).nextElement();
        fcj localfcj = (fcj)this.jdField_d_of_type_JavaUtilHashtable.get(str);
        if (((localfcj.c == 0L) && (l1 - localfcj.jdField_a_of_type_Long > 60000L)) || ((localfcj.c > 0L) && (l1 > localfcj.c))) {
          ((ArrayList)localObject1).add(str);
        }
      }
    }
    for (;;)
    {
      int i1;
      if (i1 < ((ArrayList)localObject1).size())
      {
        localObject2 = (String)((ArrayList)localObject1).get(i1);
        this.jdField_d_of_type_JavaUtilHashtable.remove(localObject2);
        i1 += 1;
      }
      else
      {
        localObject1 = new fcj();
        ((fcj)localObject1).jdField_a_of_type_Long = l1;
        ((fcj)localObject1).b = 1L;
        this.jdField_d_of_type_JavaUtilHashtable.put(paramString, localObject1);
        break;
        i1 = 0;
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "addFriendToFriendList " + paramString2 + ", " + paramInt);
    }
    paramString1 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (localPhoneContactManager != null) {
      localPhoneContactManager.b();
    }
    boolean bool1 = paramString1.b(paramString2);
    boolean bool2 = paramString1.a(paramString2, paramInt);
    if (bool2)
    {
      if (this.g == 0L) {
        a(1, true, Boolean.valueOf(true));
      }
      a(63, true, paramString2);
      paramString1 = (CircleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
      if (paramString1 != null) {
        paramString1.a(paramString2);
      }
      a(paramString2, false);
    }
    if (!bool1) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, 0, -1L, false);
    }
    paramString1 = new ArrayList();
    paramString1.add(paramString2);
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), paramString1);
    return bool2;
  }
  
  public void b()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((!TextUtils.isEmpty(str)) && (e(str))) {
      a(str);
    }
  }
  
  public void b(byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "RenameFriendGroup :" + paramByte);
    }
    ToServiceMsg localToServiceMsg = a("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 1);
    localToServiceMsg.extraData.putByte("group_id", paramByte);
    localToServiceMsg.extraData.putString("group_name", paramString);
    a(localToServiceMsg);
  }
  
  public void b(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("message.group.vibrate");
    localArrayList2.add(String.valueOf(paramInt));
    a(localArrayList1, localArrayList2, 3);
  }
  
  public void b(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 2L);
    a(localToServiceMsg);
  }
  
  public void b(String paramString)
  {
    a(1, paramString, (byte)0, (byte)0, null);
  }
  
  public void b(String paramString, byte paramByte)
  {
    a(11, paramString, (byte)0, paramByte, null);
  }
  
  public void b(String paramString, byte paramByte1, byte paramByte2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.MovGroupMemReq");
    localToServiceMsg.extraData.putByte("move_fri_type", (byte)0);
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("group_id", paramByte1);
    localToServiceMsg.extraData.putByte("away_group_id", paramByte2);
    a(localToServiceMsg);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "send_oidb_0x476");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1142);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(6);
    localByteBuffer.putShort((short)1);
    localByteBuffer.putInt(paramInt1);
    localOIDBSSOPkg.bytes_bodybuffer.setHasFlag(true);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramString = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    b(paramString);
  }
  
  public void b(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, false);
  }
  
  public void b(String paramString, ArrayList paramArrayList, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.DelDevLoginInfo");
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.addAttribute("vecDeviceItemDes", paramArrayList);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putInt("index", paramInt);
    a(localToServiceMsg);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (paramBoolean) {
      try
      {
        this.jdField_b_of_type_JavaUtilHashtable.remove(paramString);
        return;
      }
      finally {}
    }
    ArrayList localArrayList;
    Object localObject2;
    if (this.jdField_b_of_type_JavaUtilHashtable.size() > 30)
    {
      long l1 = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localObject2 = this.jdField_b_of_type_JavaUtilHashtable.keys();
      while (((Enumeration)localObject2).hasMoreElements())
      {
        String str = (String)((Enumeration)localObject2).nextElement();
        if (Math.abs(l1 - ((Long)this.jdField_b_of_type_JavaUtilHashtable.get(str)).longValue()) > 60000L) {
          localArrayList.add(str);
        }
      }
    }
    for (;;)
    {
      int i1;
      if (i1 < localArrayList.size())
      {
        localObject2 = (String)localArrayList.get(i1);
        this.jdField_b_of_type_JavaUtilHashtable.remove(localObject2);
        i1 += 1;
      }
      else
      {
        this.jdField_b_of_type_JavaUtilHashtable.put(paramString, Long.valueOf(System.currentTimeMillis()));
        break;
        i1 = 0;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void b(String[] paramArrayOfString)
  {
    a(paramArrayOfString, 0, 2, null);
  }
  
  public boolean b()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.m;
    if ((l2 < this.l) && (l2 > -this.l)) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        this.m = l1;
      }
      return bool;
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool1 = paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    boolean bool2 = bool1;
    long l1;
    if (bool1)
    {
      l1 = ContactConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (Math.abs(System.currentTimeMillis() - l1) <= 86400000L) {
        break label109;
      }
    }
    label109:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("FriendListHandler", 2, "$shouldReqLevel | lastReqTime = " + l1 + " | currentTime = " + System.currentTimeMillis());
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ffs != null) {
      this.jdField_a_of_type_Ffs.a();
    }
    super.c();
  }
  
  public void c(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("message.ring.switch");
    localArrayList2.add(String.valueOf(paramInt));
    a(localArrayList1, localArrayList2, 4);
  }
  
  public void c(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 4L);
    a(localToServiceMsg);
  }
  
  public void c(String paramString)
  {
    a(4, paramString, (byte)0, (byte)0, null);
  }
  
  public void c(String paramString, byte paramByte)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.delFriend");
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("del_type", paramByte);
    a(localToServiceMsg);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramString, "friendlist.GetOnlineInfoReq");
    if (paramBoolean)
    {
      localToServiceMsg.extraData.putLong("dwReqType", 1L);
      localToServiceMsg.extraData.putString("strMobile", paramString);
    }
    for (;;)
    {
      localToServiceMsg.setTimeout(15000L);
      a(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putLong("dwReqType", 0L);
      localToServiceMsg.extraData.putLong("dwUin", Long.parseLong(paramString));
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public void c(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      i2 = paramArrayOfString.length;
      i1 = 0;
      if (i1 < i2)
      {
        String str = paramArrayOfString[i1];
        if (TextUtils.isEmpty(str)) {}
        for (;;)
        {
          i1 += 1;
          break;
          if ((Friends.isValidUin(str)) && (a(str))) {
            localArrayList.add(str);
          }
        }
      }
    } while (localArrayList.size() < 1);
    paramArrayOfString = new String[localArrayList.size()];
    int i2 = localArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      paramArrayOfString[i1] = ((String)localArrayList.get(i1));
      i1 += 1;
    }
    a(paramArrayOfString);
    paramArrayOfString = a("ProfileService.GetSimpleInfo");
    paramArrayOfString.extraData.putStringArrayList("uinList", localArrayList);
    paramArrayOfString.extraData.putBoolean("batch_data", true);
    a(paramArrayOfString);
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected boolean c(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.getFriendGroupList");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.GetLastLoginInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.GetRichSig");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.GetSimpleInfo");
      this.jdField_a_of_type_JavaUtilSet.add("AvatarInfoSvr.QQHeadUrlReq");
      this.jdField_a_of_type_JavaUtilSet.add("IncreaseURLSvr.QQHeadUrlReq");
      this.jdField_a_of_type_JavaUtilSet.add("StatSvc.GetDevLoginInfo");
      this.jdField_a_of_type_JavaUtilSet.add("StatSvc.DelDevLoginInfo");
      this.jdField_a_of_type_JavaUtilSet.add("StatSvc.SvcReqKikOut");
      this.jdField_a_of_type_JavaUtilSet.add("StatSvc.BindUin");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.ReqGetSettings");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.ReqSetSettings");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.MovGroupMemReq");
      this.jdField_a_of_type_JavaUtilSet.add("BumpSvc.ReqComfirmContactFriend");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.addFriend");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.getUserAddFriendSetting");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.GetSimpleOnlineFriendInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.GetOnlineInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.delFriend");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.SetGroupReq");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.ChangeFriendName");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.SetRichSig");
      this.jdField_a_of_type_JavaUtilSet.add("StatSvc.register");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.GetAutoInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.CheckUpdateReq");
      this.jdField_a_of_type_JavaUtilSet.add("SummaryCard.ReqSearch");
      this.jdField_a_of_type_JavaUtilSet.add("SummaryCard.ReqCondSearch");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5d1_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x4fc_30");
      this.jdField_a_of_type_JavaUtilSet.add("DevLockAuthSvc.RecommendAuth");
      this.jdField_a_of_type_JavaUtilSet.add("DevLockAuthSvc.ConfirmAuth");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x476_146");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x476_147");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void d()
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 0;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void d(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("message.vibrate.switch");
    localArrayList2.add(String.valueOf(paramInt));
    a(localArrayList1, localArrayList2, 5);
  }
  
  public void d(String paramString)
  {
    a(11, paramString, (byte)0, (byte)0, null);
  }
  
  public void d(String paramString, byte paramByte)
  {
    if ((paramByte != 0) && (a())) {}
    do
    {
      return;
      this.h = System.currentTimeMillis();
      paramString = new ToServiceMsg("mobileqq.service", paramString, "friendlist.GetSimpleOnlineFriendInfoReq");
      paramString.extraData.putLong("startTime", System.currentTimeMillis());
      paramString.setTimeout(120000L);
      paramString.extraData.putByte("ifShowTermType", (byte)1);
      paramString.extraData.putByte("srcType", paramByte);
      a(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("getOnlineFriend", 2, "send getOnlineFriend");
  }
  
  public void d(String[] paramArrayOfString)
  {
    int i2 = paramArrayOfString.length;
    long[] arrayOfLong = new long[i2];
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2) {
        try
        {
          arrayOfLong[i1] = Long.parseLong(paramArrayOfString[i1]);
          i1 += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            arrayOfLong[i1] = 0L;
          }
        }
      }
    }
    a(arrayOfLong);
  }
  
  public boolean d()
  {
    String str;
    if (this.aK == -1)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.app, "StatusEntry");
      if ((str == null) || (str.length() <= 0)) {}
    }
    try
    {
      this.aK = Integer.parseInt(str);
      if (this.aK == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richstatus.mate", 2, "isStatusEntryVisible " + this.aK + ", " + localException.toString());
        }
      }
    }
    return false;
  }
  
  public boolean d(String paramString)
  {
    for (;;)
    {
      boolean bool1;
      boolean bool3;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (!this.jdField_b_of_type_JavaUtilHashtable.containsKey(paramString)) {
          break label212;
        }
        long l1 = ((Long)this.jdField_b_of_type_JavaUtilHashtable.get(paramString)).longValue();
        if (Math.abs(System.currentTimeMillis() - l1) > 60000L)
        {
          this.jdField_b_of_type_JavaUtilHashtable.remove(paramString);
          bool1 = true;
          bool2 = bool1;
          if (bool1)
          {
            bool3 = SystemUtil.a();
            if (((bool3) && (SystemUtil.a() < 2048L)) || ((!bool3) && (SystemUtil.b() < 102400L)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.flh", 2, "getQQHead|fail, storage is not enough. uinOrMobile=" + paramString + ", isExistSDCard=" + bool3);
              }
              bool2 = false;
            }
          }
          else
          {
            return bool2;
          }
        }
        else
        {
          bool1 = false;
        }
      }
      boolean bool2 = bool1;
      if (!bool3)
      {
        bool2 = bool1;
        if (!this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = true;
          ContactConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), true);
          return bool1;
          label212:
          bool1 = true;
        }
      }
    }
  }
  
  public void e(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("sync.c2c_message");
    localArrayList2.add(String.valueOf(paramInt));
    a(localArrayList1, localArrayList2, 6);
  }
  
  public void e(String paramString)
  {
    new fci(this, "saveSelfSig", paramString).start();
    ToServiceMsg localToServiceMsg = a("ProfileService.SetRichSig");
    localToServiceMsg.extraData.putString("sig_value", paramString);
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    a(localToServiceMsg);
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      return false;
    }
    boolean bool = ContactConfig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if (bool) {
      a(0L, 0L, 0L);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListHandler
 * JD-Core Version:    0.7.0.1
 */