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
import QQService.EVIPSPEC;
import QQService.SvcDevLoginInfo;
import QQService.SvcRespKikOut;
import QQService.SvcRspDelLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import SecurityAccountServer.RespondQueryQQBindingStat;
import SummaryCard.RespCondSearch;
import SummaryCard.RespHead;
import SummaryCard.RespSearch;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlReq;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlRsp;
import com.tencent.avatarinfo.MultiHeadUrl.ReqUsrInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspHeadInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspUsrHeadInfo;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlReq;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlRsp;
import com.tencent.avatarinfo.QQHeadUrl.ReqUsrInfo;
import com.tencent.avatarinfo.QQHeadUrl.RspHeadInfo;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.ims.device_lock_confirm_auth.DeviceInfo;
import com.tencent.ims.device_lock_confirm_auth.ReqBody;
import com.tencent.ims.device_lock_recommend_auth.DeviceInfo;
import com.tencent.ims.device_lock_recommend_auth.ReqBody;
import com.tencent.ims.device_lock_recommend_auth.RspBody;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.contact.OnlineStatusIconHelper;
import com.tencent.mobileqq.antiphing.DeviceLockItemInfo;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.Ability;
import com.tencent.mobileqq.data.Card;
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
import com.tencent.mobileqq.persistence.Entity;
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
import com.tencent.widget.TraceUtils;
import csw;
import csx;
import csy;
import csz;
import ctb;
import cvl;
import friendlist.AddFriendResp;
import friendlist.AddGroupResp;
import friendlist.DelFriendResp;
import friendlist.DelGroupResp;
import friendlist.FriendInfo;
import friendlist.GetAutoInfoResp;
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
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ClearFriendIdReq;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ClearFriendIdRsp;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ReqBody;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.RspBody;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.SetFriendIdReq;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.SetFriendIdRsp;
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.ReqBody;
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.RspBody;
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class FriendListHandler
  extends BusinessHandler
{
  public static final int A = 39;
  public static final int B = 41;
  public static final int C = 42;
  public static final int D = 43;
  public static final int E = 44;
  public static final int F = 45;
  public static final int G = 47;
  public static final int H = 48;
  public static final int I = 49;
  public static final int J = 50;
  public static final int K = 51;
  public static final int L = 52;
  public static final int M = 53;
  public static final int N = 54;
  public static final int O = 55;
  public static final int P = 56;
  public static final int Q = 57;
  public static final int R = 58;
  public static final int S = 59;
  public static final int T = 60;
  public static final int U = 61;
  public static final int V = 62;
  public static final int W = 63;
  public static final int X = 64;
  public static final int Y = 65;
  public static final int Z = 66;
  public static final byte a = 0;
  public static final int a = 1;
  public static final long a = 2048L;
  public static final String a = "FriendListHandler";
  private static final short jdField_a_of_type_Short = 20002;
  private static final boolean jdField_a_of_type_Boolean = true;
  public static final int aA = 8;
  public static final int aB = 11;
  public static final int aC = 32;
  public static final int aD = 200;
  public static final int aE = 202;
  public static final int aF = 204;
  public static final int aG = 100;
  public static final int aH = 3000;
  public static final int aI = 3001;
  public static final int aJ = 3002;
  public static final int aK = 60000;
  public static final int aL = 0;
  public static final int aM = 9201;
  public static final int aN = 9202;
  public static final int aO = 9203;
  public static final int aP = 9204;
  public static final int aQ = 9205;
  public static final int aR = 9206;
  public static final int aS = 9207;
  public static final int aT = 4051;
  public static final int aU = 1;
  public static final int aV = 2;
  public static final int aW = 146;
  public static final int aX = 147;
  public static final int aY = 1;
  public static final int aZ = 2;
  public static final int aa = 67;
  public static final int ab = 68;
  public static final int ac = 69;
  public static final int ad = 70;
  public static final int ae = 71;
  public static final int af = 72;
  public static final int ag = 73;
  public static final int ah = 74;
  public static final int ai = 75;
  public static final int aj = 76;
  public static final int ak = 77;
  public static final int al = 78;
  public static final int am = 79;
  public static final int an = 80;
  public static final int ao = 81;
  public static final int ap = 82;
  public static final int aq = 83;
  public static final int ar = 84;
  public static final int as = 85;
  public static final int at = 86;
  public static final int au = 87;
  public static final int av = 88;
  public static final int aw = 89;
  public static final int ax = 90;
  public static final int ay = 1;
  public static final int az = 4;
  public static final byte b = 1;
  public static final int b = 2;
  public static final long b = 102400L;
  public static final String b = "get_troop_member";
  public static final int ba = 3;
  public static final int bb = 4;
  public static final int bc = 20059;
  public static final int bd = 27032;
  public static final int be = 0;
  public static final int bf = 1;
  public static final int bg = 2;
  public static final int bh = 4;
  private static final int bi = 20;
  private static final int bj = 200;
  private static final int bk = 100;
  private static final int bn = 0;
  private static final int bp = 15;
  private static int bq = 100;
  public static final byte c = 0;
  public static final int c = 3;
  private static final long jdField_c_of_type_Long = 60000L;
  public static final String c = "uin";
  private static final short jdField_c_of_type_Short = 500;
  public static final byte d = 1;
  public static final int d = 4;
  private static final long jdField_d_of_type_Long = 5000L;
  public static final String d = "safety_flag";
  public static final byte e = 2;
  public static final int e = 5;
  private static final long jdField_e_of_type_Long = 8L;
  private static final String jdField_e_of_type_JavaLangString = "Q.qqhead.flh";
  public static final byte f = 0;
  public static final int f = 7;
  private static final long jdField_f_of_type_Long = 1800000L;
  private static final String jdField_f_of_type_JavaLangString = "StatusEntry";
  public static final byte g = 1;
  public static final int g = 8;
  public static final byte h = 2;
  public static final int h = 9;
  public static final byte i = 0;
  public static final int i = 10;
  private static final long i = 15000L;
  public static final byte j = 1;
  public static final int j = 11;
  public static final byte k = 2;
  public static final int k = 12;
  private static final long k = 15000L;
  public static final int l = 13;
  public static final int m = 14;
  public static final int n = 15;
  public static final int o = 16;
  public static final int p = 18;
  public static final int q = 19;
  public static final int r = 21;
  public static final int s = 22;
  public static final int t = 27;
  public static final int u = 28;
  public static final int v = 30;
  public static final int w = 33;
  public static final int x = 35;
  public static final int y = 37;
  public static final int z = 38;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private cvl jdField_a_of_type_Cvl;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private Hashtable jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  private short jdField_b_of_type_Short = 20002;
  private boolean jdField_b_of_type_Boolean;
  private int bl = 0;
  private int bm = -1;
  private int bo = 0;
  private Hashtable jdField_c_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_c_of_type_Boolean = false;
  private Hashtable jdField_d_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_d_of_type_Boolean = false;
  private long g = 0L;
  private long h = 0L;
  private final long j = 86400000L;
  private long l = 15000L;
  private long m = 0L;
  private long n = 0L;
  
  public FriendListHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_AndroidOsHandler = new csw(this, paramQQAppInterface.a().getMainLooper());
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
  
  private static oidb_sso.OIDBSSOPkg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
      paramToServiceMsg = null;
    }
    for (;;)
    {
      return paramToServiceMsg;
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg.bytes_bodybuffer.get() != null) {
            continue;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "parseSSOPkg: oidb_sso ssoPkg.uint32_result.get() " + paramFromServiceMsg.uint32_result.get());
        }
        return null;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
          }
        }
      }
    }
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, byte paramByte1, byte paramByte2, String paramString2, boolean paramBoolean)
  {
    label148:
    Object localObject;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "getQQHead|type=" + paramInt1 + ", uinOrMobile=" + paramString1 + ",uinType=" + paramInt2 + ",sourceType=" + paramByte1 + ", faceFileType=" + paramByte2 + ", encid=" + paramString2 + ",isGetStrangerHead=" + paramBoolean);
        }
        if (paramInt1 == 1)
        {
          paramBoolean = Friends.isValidUin(paramString1);
          if (!paramBoolean) {
            return;
          }
        }
        if ((paramString1 == null) || (paramString1.equals(""))) {
          continue;
        }
        if (paramInt1 != 32) {
          break label540;
        }
        if (paramInt2 == 3000)
        {
          paramInt2 = 200;
          localObject = paramInt1 + "_" + paramString1;
          if (paramInt1 == 32) {
            localObject = "stranger_" + String.valueOf(paramInt2) + "_" + paramString1;
          }
          if (d((String)localObject)) {
            break;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.qqhead.flh", 2, "getQQHead|repeat type=" + paramInt1 + ", uinOrMobile=" + (String)localObject);
          continue;
        }
        if (paramInt2 != 3001) {
          break label289;
        }
      }
      finally {}
      paramInt2 = 202;
      continue;
      label289:
      if (paramInt2 != 3002) {
        break label540;
      }
      paramInt2 = 204;
    }
    c((String)localObject, false);
    int i1;
    if (paramInt1 == 32)
    {
      i1 = paramInt2;
      label319:
      this.bl += 1;
      localObject = (ArrayList)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(i1));
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.jdField_a_of_type_JavaUtilHashtable.put(Integer.valueOf(i1), localObject);
        break label545;
      }
    }
    for (;;)
    {
      paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1, paramString1, paramInt2);
      for (;;)
      {
        long l2 = 0L;
        long l1 = l2;
        if (paramBoolean)
        {
          Pair localPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1, paramString1, paramInt2);
          l1 = l2;
          if (localPair != null)
          {
            l1 = l2;
            if (localPair.second != null) {
              l1 = ((com.tencent.mobileqq.data.Setting)localPair.second).headImgTimestamp;
            }
          }
        }
        ((ArrayList)localObject).add(new FriendListHandler.QQHeadDetails(paramInt1, paramString1, l1, paramByte1, paramString2));
        if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b())) {
          break;
        }
        if (this.bl >= 10) {
          e();
        }
        b();
        break;
        paramBoolean = true;
        continue;
        paramBoolean = false;
      }
      break label545;
      i1 = paramInt1;
      break label319;
      label540:
      paramInt2 = 0;
      break label148;
      label545:
      switch (paramByte2)
      {
      }
    }
  }
  
  private void a(int paramInt, ArrayList paramArrayList)
  {
    int i3 = 0;
    Object localObject1;
    int i1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      localObject2 = ((StringBuilder)localObject1).append("realGetQQHead_Stranger").append(", size=");
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
    int i2;
    label227:
    MultiHeadUrl.ReqUsrInfo localReqUsrInfo;
    switch (paramInt)
    {
    case 201: 
    case 203: 
    default: 
      i1 = 0;
      localObject1 = new MultiHeadUrl.MultiBusidUrlReq();
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).srcUidType.set(0);
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).srcUin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUsrType.add(Integer.valueOf(1));
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUsrType.add(Integer.valueOf(32));
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUidType.set(i1);
      i2 = 0;
      if (i2 >= paramArrayList.size()) {
        break label355;
      }
      localObject2 = (FriendListHandler.QQHeadDetails)paramArrayList.get(i2);
      localReqUsrInfo = new MultiHeadUrl.ReqUsrInfo();
      if (i1 != 0) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        localReqUsrInfo.dstUin.set(Long.parseLong(((FriendListHandler.QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString));
        ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUsrInfos.add(localReqUsrInfo);
      }
      catch (Exception localException)
      {
        continue;
      }
      i2 += 1;
      break label227;
      i1 = 0;
      break;
      i1 = 2;
      break;
      i1 = 1;
      break;
      if (i1 == 1) {
        localReqUsrInfo.dstTid.set(Long.parseLong(((FriendListHandler.QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString));
      } else if (i1 == 2) {
        localReqUsrInfo.dstOpenid.set(((FriendListHandler.QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString);
      }
    }
    label355:
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("QQHead_Stranger request.srcUidType=" + ((MultiHeadUrl.MultiBusidUrlReq)localObject1).srcUidType.get()).append(";srcUin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).append("\n\n").append(";dstUsrType=" + ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUsrType.get()).append(";dstUidType=" + ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUidType.get()).append("\n\n").append(";uinset={");
      if (paramArrayList != null)
      {
        i1 = i3;
        while (i1 < paramArrayList.size())
        {
          ((StringBuilder)localObject2).append(paramArrayList.get(i1) + ",");
          i1 += 1;
        }
      }
      ((StringBuilder)localObject2).append("}");
      QLog.d("headstranger", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = a("MultibusidURLSvr.HeadUrlReq", null);
    ((ToServiceMsg)localObject2).extraData.putParcelableArrayList("uinList", paramArrayList);
    ((ToServiceMsg)localObject2).extraData.putLong("startTime", System.currentTimeMillis());
    ((ToServiceMsg)localObject2).extraData.putInt("subtype", paramInt);
    ((ToServiceMsg)localObject2).putWupBuffer(((MultiHeadUrl.MultiBusidUrlReq)localObject1).toByteArray());
    b((ToServiceMsg)localObject2);
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
  
  private void a(FromServiceMsg paramFromServiceMsg, DelFriendResp paramDelFriendResp)
  {
    if (paramDelFriendResp.errorCode != 0)
    {
      a(15, false, null);
      return;
    }
    paramFromServiceMsg = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.c();
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
    StringBuilder localStringBuilder;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localObject = localStringBuilder.append("handleGetQQHeadError, result=").append(paramInt).append(", uinListSize=");
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
          QLog.w("Q.qqhead.flh", 2, localStringBuilder.toString());
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
          FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)localArrayList.get(paramInt);
          String str = localQQHeadDetails.jdField_a_of_type_Int + "_" + localQQHeadDetails.jdField_a_of_type_JavaLangString;
          localObject = str;
          if (localQQHeadDetails.jdField_a_of_type_Int == 32)
          {
            int i1 = paramToServiceMsg.extraData.getInt("subtype");
            localObject = "stranger_" + i1 + "_" + str;
          }
          c((String)localObject, true);
          if ((QLog.isColorLevel()) && (localQQHeadDetails != null)) {
            localStringBuilder.append("; uin=").append((String)localObject).append(", timestamp=").append(localQQHeadDetails.jdField_a_of_type_Long);
          }
          paramInt += 1;
        }
      } while (!QLog.isColorLevel());
      QLog.w("Q.qqhead.flh", 2, localStringBuilder.toString());
      return;
      localStringBuilder = null;
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
      if (this.jdField_a_of_type_Cvl == null) {}
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Cvl == null) {
          this.jdField_a_of_type_Cvl = new cvl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        i1 = 0;
        if (i1 >= paramQQHeadUrlResp.UserHeadInfoList.size()) {
          continue;
        }
        ??? = (QQHeadInfo)paramQQHeadUrlResp.UserHeadInfoList.get(i1);
        this.jdField_a_of_type_Cvl.a(???, paramToServiceMsg);
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(false, true);
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
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(true, true);
          a(35, true, new Object[] { Boolean.valueOf(true) });
          return;
        }
      }
      if ((i2 != -1) && (i2 < paramRespGetSettings.Revision))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "respRevision != data.Revision, load settings again, respRev=" + i2 + " data.Rev=" + paramRespGetSettings.Revision);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(false, false);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(true, true);
      a(35, true, new Object[] { Boolean.valueOf(true) });
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(false, true);
    a(35, false, new Object[] { Boolean.valueOf(true) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, RespSetSettings paramRespSetSettings)
  {
    boolean bool1 = false;
    Object localObject = (ArrayList)paramToServiceMsg.extraData.getSerializable("Settings");
    int i1 = paramToServiceMsg.extraData.getInt("localRevision");
    boolean bool2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("handlerUploadRoamSettingNewValue isSuccess = ").append(paramFromServiceMsg.isSuccess()).append(" reqLocalRevision=").append(i1).append(" data.Revision=");
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
        break label201;
      }
      if (i1 + 1 != paramRespSetSettings.Revision) {
        break label186;
      }
      DBUtils.a().a((ArrayList)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.g(true, false);
      bool2 = true;
    }
    for (;;)
    {
      if (localObject != null) {
        break label216;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RoamSetting", 2, "handlerUploadRoamSettingNewValue  settings is null.");
      }
      return;
      paramToServiceMsg = Integer.valueOf(paramRespSetSettings.Revision);
      break;
      label186:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.g(true, true);
      bool2 = true;
      continue;
      label201:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.g(false, false);
      bool2 = false;
    }
    label216:
    paramFromServiceMsg = b((ArrayList)localObject);
    paramRespSetSettings = ((ArrayList)localObject).iterator();
    label229:
    if (paramRespSetSettings.hasNext())
    {
      localObject = (GeneralSettings.Setting)paramRespSetSettings.next();
      if (((GeneralSettings.Setting)localObject).Path == null) {
        break label999;
      }
      if (!((GeneralSettings.Setting)localObject).Path.startsWith("message.group.policy.")) {
        break label397;
      }
      if ((bool1) || ((!bool2) && ((bool2) || (!paramToServiceMsg.a())))) {
        break label308;
      }
      a(38, bool2, paramFromServiceMsg);
      bool1 = true;
    }
    label308:
    label999:
    for (;;)
    {
      break label229;
      break;
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
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    bool2 = false;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleInfoOpenId ").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramArrayOfByte == null) {
        break label225;
      }
    }
    label225:
    for (int i1 = paramArrayOfByte.length;; i1 = -1)
    {
      QLog.d("FriendListHandler", 2, i1);
      paramToServiceMsg = paramToServiceMsg.extraData;
      bool1 = bool2;
      if (paramFromServiceMsg.isSuccess()) {}
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if ((!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0)) {
          break;
        }
        paramArrayOfByte = new oidb_0x5e1.RspBody();
        paramArrayOfByte.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (paramArrayOfByte.rpt_msg_uin_data.size() <= 0) {
          break;
        }
        paramFromServiceMsg = new String(((oidb_0x5e1.UdcUinData)paramArrayOfByte.rpt_msg_uin_data.get(0)).bytes_nick.get().toByteArray());
        paramToServiceMsg.putString("nick_name", paramFromServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleInfoOpenId " + paramFromServiceMsg);
        }
        bool1 = true;
      }
      catch (Throwable paramFromServiceMsg)
      {
        for (;;)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("FriendListHandler", 2, "", paramFromServiceMsg);
            bool1 = bool2;
            continue;
            bool1 = false;
          }
        }
      }
      a(74, bool1, paramToServiceMsg);
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetFriendListResp paramGetFriendListResp)
  {
    if ((paramGetFriendListResp.result == 1) || (paramGetFriendListResp.vecFriendInfo == null) || (paramGetFriendListResp.vecFriendInfo.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleGetFriendDetailInfo failed");
      }
      return;
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
    FriendInfo localFriendInfo = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(0);
    Friends localFriends1 = new Friends();
    localFriends1.name = localFriendInfo.nick;
    if (localFriendInfo.isRemark == 1) {
      paramToServiceMsg = localFriendInfo.remark;
    }
    boolean bool;
    label183:
    label440:
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
        localFriends1.strTermDesc = localFriendInfo.strTermDesc;
        if (((localFriendInfo.iTermType == 67586) || (localFriendInfo.iTermType == 66566) || (localFriendInfo.iTermType == 72194) || (localFriendInfo.iTermType == 65804) || (localFriendInfo.iTermType == 72706)) && (localFriendInfo.eNetworkType != 1)) {
          localFriends1.netTypeIconIdIphoneOrWphoneNoWifi = localFriendInfo.eIconType;
        }
        if (localFriends1.eNetwork != localFriendInfo.eNetworkType)
        {
          localFriends1.eNetwork = localFriendInfo.eNetworkType;
          a(13, true, null);
        }
        localFriends1.setShieldFlag(false);
        paramToServiceMsg = localFriendsManager.c(localFriends1.uin);
        if (paramToServiceMsg != null)
        {
          if (paramToServiceMsg.gathtertype != 1) {
            break label652;
          }
          localFriends1.gathtertype = 1;
          localFriends1.age = paramToServiceMsg.age;
          localFriends1.smartRemark = paramToServiceMsg.smartRemark;
          localFriends1.gender = paramToServiceMsg.gender;
          localFriends1.recommReason = paramToServiceMsg.recommReason;
          if (((paramToServiceMsg.gathtertype == 1) || (paramToServiceMsg.gathtertype == 2)) && (QLog.isColorLevel())) {
            QLog.i("FriendListHandler", 2, "FriendListHandler handleGetFriendDetailInfo  friend.gathtertype = " + localFriends1.gathtertype + " | friend.age = " + localFriends1.age + " | friend.recommReason = " + localFriends1.recommReason);
          }
        }
        paramGetFriendListResp = localFriendInfo.vecRing;
        paramToServiceMsg = new Oidb_0x5d0.SnsUpateBuffer();
      }
      try
      {
        paramToServiceMsg.mergeFrom(paramGetFriendListResp);
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
                break label183;
                label652:
                if (paramToServiceMsg.gathtertype != 2) {
                  break label440;
                }
                localFriends1.gathtertype = 2;
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
          break label1191;
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
      label753:
      localFriends1.superQqInfo = a(paramToServiceMsg, i2, i1);
      paramToServiceMsg = localFriendInfo.oVipInfo;
      i2 = EVIPSPEC.E_SP_SUPERVIP.value();
      if (localFriends2 == null) {
        break label1201;
      }
      i1 = localFriends2.superVipInfo;
      label790:
      localFriends1.superVipInfo = a(paramToServiceMsg, i2, i1);
      if (localFriends2 != null)
      {
        localFriends1.signature = localFriends2.signature;
        localFriends1.setRichBuffer(localFriends2.richBuffer, localFriends2.richTime);
        localFriends1.showLoginClient = localFriends2.showLoginClient;
        localFriends1.datetime = localFriends2.datetime;
        localFriends1.lastLoginType = localFriends2.lastLoginType;
        if (localFriends2.gathtertype == 1)
        {
          localFriends1.gender = localFriends2.gender;
          localFriends1.age = localFriends2.age;
          localFriends1.smartRemark = localFriends2.smartRemark;
          localFriends1.recommReason = localFriends2.recommReason;
        }
      }
      if (localFriends2 == null) {
        break label1212;
      }
      if (localFriends2.groupid == localFriends1.groupid) {
        break label1206;
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
        paramToServiceMsg.colorRingId = localFriendInfo.uColorRing;
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
        paramToServiceMsg.e();
      }
      a(new String[] { localFriends1.uin });
      return;
      label1191:
      i1 = 0;
      break;
      i1 = 0;
      break label753;
      label1201:
      i1 = 0;
      break label790;
      label1206:
      bool = false;
      continue;
      label1212:
      if (localFriends1.groupid != 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetUserAddFriendSettingResp paramGetUserAddFriendSettingResp)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    if ((paramGetUserAddFriendSettingResp != null) && (paramGetUserAddFriendSettingResp.result == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleAddFriendSetting " + paramGetUserAddFriendSettingResp.queryuinsetting + ", " + paramGetUserAddFriendSettingResp.contact_bothway_friend + ", " + paramGetUserAddFriendSettingResp.vecStrUserQuestion);
      }
      paramToServiceMsg.putInt("friend_setting", paramGetUserAddFriendSettingResp.queryuinsetting);
      paramToServiceMsg.putStringArrayList("user_question", paramGetUserAddFriendSettingResp.vecStrUserQuestion);
      paramToServiceMsg.putBoolean("contact_bothway", paramGetUserAddFriendSettingResp.contact_bothway_friend);
      a(12, true, paramToServiceMsg);
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleAddFriendSetting ");
      if (paramGetUserAddFriendSettingResp == null) {
        break label173;
      }
    }
    label173:
    for (int i1 = paramGetUserAddFriendSettingResp.result;; i1 = -10000)
    {
      QLog.d("FriendListHandler", 2, i1);
      a(12, false, paramToServiceMsg);
      return;
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
      Object localObject3 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
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
  
  private void a(ToServiceMsg paramToServiceMsg, Oidb_0x5d1.RspBody paramRspBody)
  {
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    int i1 = paramRspBody.uint32_cmd.get();
    long l1 = paramToServiceMsg.extraData.getLong("friendUin");
    String str = "";
    long l2;
    int i2;
    boolean bool1;
    label258:
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
        paramRspBody = localFriendsManagerImp.c(String.valueOf(l1));
        paramToServiceMsg = str;
        if (paramRspBody != null)
        {
          paramRspBody.setShieldFlag(true);
          localFriendsManagerImp.a(paramRspBody);
          paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          l2 = MessageCache.a();
          paramRspBody = MessageRecordFactory.a(-2012);
          paramRspBody.init(paramToServiceMsg, String.valueOf(l1), paramToServiceMsg, "你已屏蔽%s的会话", l2, 0, 0, l2);
          paramRspBody.msgtype = -2012;
          paramRspBody.isread = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramRspBody, paramToServiceMsg);
          paramToServiceMsg = str;
        }
        if (i2 != 0) {
          break label327;
        }
        bool1 = true;
        if (i2 != 0) {
          break label333;
        }
        bool2 = true;
        label266:
        a(56, bool1, new Object[] { Long.valueOf(l1), Boolean.valueOf(true), Boolean.valueOf(bool2), Boolean.valueOf(false), paramToServiceMsg });
      }
    }
    label327:
    label333:
    label625:
    label631:
    do
    {
      return;
      paramToServiceMsg = paramToServiceMsg.bytes_error_msg.get().toStringUtf8();
      break;
      bool1 = false;
      break label258;
      bool2 = false;
      break label266;
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
          paramToServiceMsg = localFriendsManagerImp.c(String.valueOf(l1));
          if (paramToServiceMsg != null)
          {
            paramToServiceMsg.setShieldFlag(false);
            localFriendsManagerImp.a(paramToServiceMsg);
            paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            l2 = MessageCache.a();
            paramRspBody = MessageRecordFactory.a(-2012);
            paramRspBody.init(paramToServiceMsg, String.valueOf(l1), paramToServiceMsg, "你已允许接收%s的会话", l2, 0, 0, l2);
            paramRspBody.msgtype = -2012;
            paramRspBody.isread = true;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramRspBody, paramToServiceMsg);
          }
          paramToServiceMsg = "";
          if (i2 != 0) {
            break label625;
          }
          bool1 = true;
          if (i2 != 0) {
            break label631;
          }
        }
        for (bool2 = true;; bool2 = false)
        {
          a(56, bool1, new Object[] { Long.valueOf(l1), Boolean.valueOf(false), Boolean.valueOf(bool2), Boolean.valueOf(false), paramToServiceMsg });
          return;
          paramToServiceMsg = paramToServiceMsg.bytes_error_msg.get().toStringUtf8();
          break;
          bool1 = false;
          break label556;
        }
      }
    } while (!QLog.isColorLevel());
    label556:
    QLog.d("FriendListHandler", 2, "<---handleSetFriendShieldFlagResp : cmd:" + i1);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    int i1 = paramToServiceMsg.extraData.getInt("bType");
    long l1 = paramToServiceMsg.extraData.getLong("lToMID");
    int i2 = paramToServiceMsg.extraData.getByte("bGroupId");
    if (i1 == 1) {
      i1 = 2;
    }
    for (;;)
    {
      if (i1 == 0)
      {
        paramToServiceMsg.extraData.getString("strNickName");
        a(String.valueOf(l1), i2, 10004, null, false, false);
      }
      String str = l1 + "_answer_added_" + paramToServiceMsg.extraData.getLong("infotime", 0L) + paramToServiceMsg.extraData.getLong("dbid", 0L);
      ContactConfig.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), str, i1);
      a(10, true, new Object[] { paramToServiceMsg.getUin(), Integer.valueOf(i1) });
      return;
    }
  }
  
  private void a(AddFriendResp paramAddFriendResp, ToServiceMsg paramToServiceMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putAll(paramToServiceMsg.extraData);
    if (paramAddFriendResp == null)
    {
      a(11, false, localBundle);
      return;
    }
    localBundle.putInt("resultCode", paramAddFriendResp.result);
    localBundle.putString("ErrorString", paramAddFriendResp.ErrorString);
    if (paramAddFriendResp.result == 0)
    {
      paramToServiceMsg = paramToServiceMsg.extraData;
      boolean bool1 = paramToServiceMsg.getBoolean("auto_send", false);
      int i2 = paramToServiceMsg.getInt("source_id");
      boolean bool2 = paramToServiceMsg.getBoolean("contact_bothway");
      int i1;
      if ((bool1) && (AutoRemarkActivity.a(paramAddFriendResp.adduinsetting, i2, bool2)))
      {
        i1 = 1;
        if ((bool1) && (i1 != 0) && (paramAddFriendResp.adduin != 0L)) {
          a(String.valueOf(paramAddFriendResp.adduin), paramAddFriendResp.myfriendgroupid, i2, paramToServiceMsg.getString("src_name"), true, false);
        }
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("$handleAddFriend|autoSend=").append(bool1).append(",uin").append(paramAddFriendResp.adduin).append(",sourceId=").append(i2).append(",beBothWay=").append(bool2).append(",successDirectly=").append(AutoRemarkActivity.a(paramAddFriendResp.adduinsetting, i2, bool2));
          QLog.d("FriendListHandler", 2, paramToServiceMsg.toString());
        }
        localBundle.putByteArray("sig", paramAddFriendResp.sig);
        localBundle.putString("result_uin", String.valueOf(paramAddFriendResp.adduin));
        if ((!bool1) || (i1 == 0)) {
          break label318;
        }
      }
      label318:
      for (bool1 = true;; bool1 = false)
      {
        localBundle.putBoolean("addDirect", bool1);
        a(11, true, localBundle);
        return;
        i1 = 0;
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "ErrorString" + paramAddFriendResp.ErrorString);
    }
    a(11, true, localBundle);
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
    for (;;)
    {
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
            break label617;
          }
          localObject1 = ((FriendInfo)localObject3).remark;
          ((Friends)localObject2).remark = ((String)localObject1);
          ((Friends)localObject2).uin = String.valueOf(((FriendInfo)localObject3).friendUin);
          ((Friends)localObject2).faceid = ((FriendInfo)localObject3).faceId;
          ((Friends)localObject2).sqqtype = ((FriendInfo)localObject3).sqqtype;
          ((Friends)localObject2).status = ((FriendInfo)localObject3).status;
          ((Friends)localObject2).cSpecialFlag = ((FriendInfo)localObject3).cSpecialFlag;
          if (((FriendInfo)localObject3).isMqqOnLine != 1) {
            break label625;
          }
        }
      }
      int i1;
      label617:
      label625:
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
      FriendInfo localFriendInfo;
      Friends localFriends;
      for (;;)
      {
        i1 = 0;
        if (i1 >= i5) {
          break label1755;
        }
        localFriendInfo = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(i1);
        localFriends = new Friends();
        localFriends.name = localFriendInfo.nick;
        label839:
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
            break label1232;
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
          localFriends.strTermDesc = localFriendInfo.strTermDesc;
          if (((localFriendInfo.iTermType == 67586) || (localFriendInfo.iTermType == 66566) || (localFriendInfo.iTermType == 72194) || (localFriendInfo.iTermType == 65804) || (localFriendInfo.iTermType == 72706)) && (localFriendInfo.eNetworkType != 1)) {
            localFriends.netTypeIconIdIphoneOrWphoneNoWifi = localFriendInfo.eIconType;
          }
          localFriends.setShieldFlag(false);
          arrayOfByte = localFriendInfo.vecRing;
          localObject1 = new Oidb_0x5d0.SnsUpateBuffer();
        }
        try
        {
          ((Oidb_0x5d0.SnsUpateBuffer)localObject1).mergeFrom(arrayOfByte);
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
                  break label839;
                  label1232:
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
            break label1630;
          }
        }
      }
      int i2 = ((Friends)localObject1).qqVipInfo;
      label1310:
      localFriends.qqVipInfo = a(localVipBaseInfo, i6, i2);
      VipBaseInfo localVipBaseInfo = localFriendInfo.oVipInfo;
      int i6 = EVIPSPEC.E_SP_SUPERQQ.value();
      if (localObject1 != null)
      {
        i2 = ((Friends)localObject1).superQqInfo;
        label1351:
        localFriends.superQqInfo = a(localVipBaseInfo, i6, i2);
        localVipBaseInfo = localFriendInfo.oVipInfo;
        i6 = EVIPSPEC.E_SP_SUPERVIP.value();
        if (localObject1 == null) {
          break label1642;
        }
        i2 = ((Friends)localObject1).superVipInfo;
        label1392:
        localFriends.superVipInfo = a(localVipBaseInfo, i6, i2);
        if (localObject1 != null)
        {
          localFriends.signature = ((Friends)localObject1).signature;
          localFriends.setRichBuffer(((Friends)localObject1).richBuffer, ((Friends)localObject1).richTime);
          localFriends.showLoginClient = ((Friends)localObject1).showLoginClient;
          localFriends.lastLoginType = ((Friends)localObject1).lastLoginType;
        }
        localObject1 = localFriendsManagerImp.c(localFriends.uin);
        if (localObject1 != null)
        {
          if (((Friends)localObject1).gathtertype != 1) {
            break label1648;
          }
          localFriends.gathtertype = 1;
          label1488:
          localFriends.age = ((Friends)localObject1).age;
          localFriends.smartRemark = ((Friends)localObject1).smartRemark;
          localFriends.gender = ((Friends)localObject1).gender;
          localFriends.recommReason = ((Friends)localObject1).recommReason;
        }
        localObject2[i1] = localFriends;
        localObject1 = localFriendsManagerImp.a(String.valueOf(localFriends.uin));
        if (localObject1 != null) {
          break label1666;
        }
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = String.valueOf(localFriends.uin);
        ((ExtensionInfo)localObject1).pendantId = localFriendInfo.ulFaceAddonId;
        ((ExtensionInfo)localObject1).uVipFont = localFriendInfo.uVipFont;
        ((ExtensionInfo)localObject1).colorRingId = localFriendInfo.uColorRing;
        ((ExtensionInfo)localObject1).timestamp = paramLong;
        ((ArrayList)localObject3).add(localObject1);
      }
      for (;;)
      {
        i1 += 1;
        break;
        label1630:
        i2 = 0;
        break label1310;
        i2 = 0;
        break label1351;
        label1642:
        i2 = 0;
        break label1392;
        label1648:
        if (((Friends)localObject1).gathtertype != 2) {
          break label1488;
        }
        localFriends.gathtertype = 2;
        break label1488;
        label1666:
        if ((((ExtensionInfo)localObject1).pendantId != localFriendInfo.ulFaceAddonId) || (((ExtensionInfo)localObject1).uVipFont != localFriendInfo.uVipFont) || (((ExtensionInfo)localObject1).colorRingId != localFriendInfo.uColorRing))
        {
          ((ExtensionInfo)localObject1).pendantId = localFriendInfo.ulFaceAddonId;
          ((ExtensionInfo)localObject1).uVipFont = localFriendInfo.uVipFont;
          ((ExtensionInfo)localObject1).colorRingId = localFriendInfo.uColorRing;
          ((ExtensionInfo)localObject1).timestamp = paramLong;
          ((ArrayList)localObject3).add(localObject1);
        }
      }
      label1755:
      if ((i5 > 0) && (QLog.isColorLevel()))
      {
        localObject1 = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(0);
        QLog.i("FriendListHandler", 2, "FriendListHandler handleGetFriendList uin=" + ((FriendInfo)localObject1).friendUin + " | eNetwork=" + ((FriendInfo)localObject1).eNetworkType + " | iTermType=" + ((FriendInfo)localObject1).iTermType + " | abilityBits=" + ((FriendInfo)localObject1).uAbiFlag + " | name=" + Utils.a(((FriendInfo)localObject1).nick) + " | netTypeIconId=" + ((FriendInfo)localObject1).eIconType + " | detalStatusFlag=" + ((FriendInfo)localObject1).detalStatusFlag + " | isMqqOnLine=" + ((FriendInfo)localObject1).isMqqOnLine + " | netTypeIconIdIphoneOrWphoneNoWifi=" + ((FriendInfo)localObject1).eIconType);
        if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
        {
          localObject1 = (ExtensionInfo)((ArrayList)localObject3).get(0);
          QLog.d("FriendListHandler", 2, "handleGetFriendList, Get Extension, uin=" + ((ExtensionInfo)localObject1).uin + ", id=" + ((ExtensionInfo)localObject1).pendantId + "/font=" + ((ExtensionInfo)localObject1).uVipFont);
        }
      }
      localFriendsManagerImp.a((Friends[])localObject2, paramLong, bool1);
      localFriendsManagerImp.d((List)localObject3);
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
        paramString.e();
        paramString.c();
      }
      a(1, true, Boolean.valueOf(true));
      if (!paramArrayList.isEmpty())
      {
        paramString = new String[paramArrayList.size()];
        paramArrayList.toArray(paramString);
        paramArrayList.clear();
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b()) {
          break label2228;
        }
        a(paramString);
      }
      for (;;)
      {
        paramLong = paramGetFriendListResp.serverTime;
        i1 = 1;
        while (i1 < 12)
        {
          if (i1 != 8) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("inccheckupdatetimeStamp" + i1, paramLong).commit();
          }
          i1 += 1;
        }
        label2228:
        this.jdField_a_of_type_ArrayOfJavaLangString = paramString;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FriendListHandler", 2, "FriendListHandler in handleGetFriendList() to getGatheredContactsList()");
      return;
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
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
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
  
  private void a(String[] paramArrayOfString, int paramInt1, int paramInt2, Bundle paramBundle, boolean paramBoolean)
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
          a(paramArrayOfString, i1, paramInt2, paramBundle, paramBoolean);
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
        localToServiceMsg.extraData.putBoolean("showDateNickname", paramBoolean);
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
      QQAppInterface.bj = i1;
      if (paramFromServiceMsg.intervalTimeMin <= 3) {
        break label179;
      }
    }
    label179:
    for (int i1 = paramFromServiceMsg.intervalTimeMin * 60 * 1000;; i1 = 180000)
    {
      QQAppInterface.bi = i1;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "Next Get Online Friend Delay " + QQAppInterface.bi);
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
    paramToServiceMsg = paramToServiceMsg.extraData;
    paramObject = (GetAutoInfoResp)paramObject;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null) && (paramObject.errorCode == 0))
    {
      paramToServiceMsg.putInt("group_id", paramObject.cGroupID);
      paramToServiceMsg.putString("nick_name", paramObject.strRemark);
      a(33, true, paramToServiceMsg);
      return;
    }
    a(33, false, paramToServiceMsg);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    Object localObject = (GetRichSigRes)paramObject;
    paramToServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
    if ((localObject == null) || (((GetRichSigRes)localObject).cResult != 0) || (((GetRichSigRes)localObject).vstSigInfo == null) || (((GetRichSigRes)localObject).vstSigInfo.size() == 0) || (paramToServiceMsg == null)) {}
    label238:
    label239:
    for (;;)
    {
      return;
      int i1 = 0;
      paramObject = new Friends[((GetRichSigRes)localObject).vstSigInfo.size()];
      ArrayList localArrayList = new ArrayList();
      localObject = ((GetRichSigRes)localObject).vstSigInfo.iterator();
      if (((Iterator)localObject).hasNext())
      {
        ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)((Iterator)localObject).next();
        String str = Long.toString(localResRichSigInfo.lUin);
        if (localResRichSigInfo.cStatus != 1) {
          break label238;
        }
        Friends localFriends = paramToServiceMsg.c(str);
        if ((localFriends == null) || (localFriends.richTime == localResRichSigInfo.dwTime)) {
          break label238;
        }
        localFriends.setRichBuffer(localResRichSigInfo.vbSigInfo, localResRichSigInfo.dwTime);
        int i2 = i1 + 1;
        paramObject[i1] = localFriends;
        localArrayList.add(str);
        i1 = i2;
      }
      for (;;)
      {
        break;
        if (localArrayList.size() <= 0) {
          break label239;
        }
        localObject = new String[localArrayList.size()];
        localArrayList.toArray((Object[])localObject);
        a(2, true, localObject);
        paramToServiceMsg.a(paramObject, i1);
        return;
      }
    }
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
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch success=" + bool);
      }
      if (!bool) {
        break label793;
      }
    }
    label793:
    label799:
    label809:
    label815:
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramToServiceMsg == null)
        {
          return;
          bool = false;
          break;
        }
        if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
          break label809;
        }
        bool = true;
        i2 = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch result=" + bool);
        }
        if ((bool) && (paramToServiceMsg.bytes_bodybuffer != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          i1 = paramToServiceMsg.get();
          int i3 = paramToServiceMsg.getInt();
          i2 = paramToServiceMsg.getShort();
          paramFromServiceMsg = new HashMap(i2);
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch cNickCut=" + i1 + " dwNextUin=" + i3 + " wSimpleInfoNum=" + i2);
          }
          if (i3 == -1)
          {
            paramObject = new StringBuffer();
            i1 = 0;
            if (i1 < i2)
            {
              String str = String.valueOf(Utils.a(paramToServiceMsg.getInt()));
              i3 = paramToServiceMsg.getShort();
              if (QLog.isColorLevel())
              {
                paramObject.append(" wFieldNum=");
                paramObject.append(i3);
              }
              if (i3 != 1) {
                break label799;
              }
              i3 = paramToServiceMsg.getShort();
              if (QLog.isColorLevel())
              {
                paramObject.append(" wFieldID=");
                paramObject.append(i3);
              }
              if (i3 != this.jdField_b_of_type_Short) {
                break label799;
              }
              Object localObject = new byte[paramToServiceMsg.getShort()];
              paramToServiceMsg.get((byte[])localObject);
              localObject = new String((byte[])localObject);
              if (QLog.isColorLevel())
              {
                paramObject.append(" uin=");
                paramObject.append(str.substring(0, 4));
                paramObject.append(" nick=");
                paramObject.append(Utils.a((String)localObject));
              }
              paramFromServiceMsg.put(str, localObject);
              break label799;
            }
            if (!QLog.isColorLevel()) {
              break label815;
            }
            QLog.d("FriendListHandler", 2, paramObject.toString());
            break label815;
            a(75, bool, paramFromServiceMsg);
            return;
          }
          bool = false;
          continue;
        }
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
          i1 = i2;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i2 = 1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("FriendListHandler", 2, "handleGetFriendNickBatch e", paramToServiceMsg);
        i1 = i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
        i1 = i2;
        continue;
      }
      catch (Exception paramToServiceMsg)
      {
        i2 = 1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("FriendListHandler", 2, "handleGetFriendNickBatch ex", paramToServiceMsg);
        i1 = i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
        i1 = i2;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
      }
      a(75, false, Integer.valueOf(i1));
      return;
      int i2 = 0;
      continue;
      int i1 = (short)(i1 + 1);
      continue;
      bool = false;
    }
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
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
          long l1 = Utils.a(localByteBuffer.getInt());
          paramToServiceMsg = localFriendsManagerImp.a(String.valueOf(l1));
          if (paramToServiceMsg != null) {
            break label731;
          }
          paramToServiceMsg = new ExtensionInfo();
          paramToServiceMsg.uin = String.valueOf(l1);
          i1 = 1;
          int i6 = localByteBuffer.getShort();
          int i2;
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
                if (localByteBuffer.getShort() != 8) {
                  break label728;
                }
                l2 = localByteBuffer.getLong();
                if (paramToServiceMsg.pendantId == l2) {
                  break label728;
                }
                paramToServiceMsg.pendantId = l2;
                i1 = 1;
                i2 = i1;
              }
              for (;;)
              {
                i4 += 1;
                i1 = i2;
                break;
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
                else if (i7 == 27041)
                {
                  i2 = i1;
                  if (localByteBuffer.getShort() == 4)
                  {
                    i7 = localByteBuffer.getInt();
                    i2 = i1;
                    if (paramToServiceMsg.colorRingId != i7)
                    {
                      paramToServiceMsg.colorRingId = i7;
                      i2 = 1;
                    }
                  }
                }
                else
                {
                  i2 = i1;
                  if (i7 == 20059)
                  {
                    i2 = i1;
                    if (localByteBuffer.getShort() == 4)
                    {
                      i7 = localByteBuffer.getInt();
                      i2 = i1;
                      if (i7 >= 0)
                      {
                        i2 = i1;
                        if (String.valueOf(l1).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
                        {
                          ((BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(40)).a(i7, true);
                          ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(i7);
                          i2 = i1;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          else
          {
            i2 = i1;
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
      label259:
      label336:
      a(66, true, paramToServiceMsg);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.stranger_info", 2, "handleGetStrangerInfo. addonId size : " + paramFromServiceMsg.size());
      return;
      label728:
      break label336;
      label731:
      i1 = 0;
      break label259;
      paramToServiceMsg = null;
      paramFromServiceMsg = null;
    }
  }
  
  private void e()
  {
    for (;;)
    {
      int i1;
      ArrayList localArrayList;
      try
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        Object localObject1;
        if (this.bl > 0)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (localObject1 == null) {
            break label209;
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
            break label194;
          }
        }
        i1 = ((Integer)((Enumeration)localObject1).nextElement()).intValue();
        localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(i1));
        if (i1 == 11)
        {
          a(l1, i1, localArrayList);
          continue;
        }
        if (i1 < 200) {
          break label183;
        }
      }
      finally {}
      a(i1, localArrayList);
      continue;
      label183:
      b(l1, i1, localArrayList);
      continue;
      label194:
      this.bl = 0;
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      continue;
      label209:
      long l1 = -1L;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg arg2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger ....");
    }
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (??? != null) {
      localObject1 = localObject3;
    }
    int i1;
    Object localObject2;
    label813:
    label832:
    List localList;
    ArrayList localArrayList;
    try
    {
      if (???.getResultCode() == 1000)
      {
        localObject1 = localObject3;
        if (paramObject != null)
        {
          localObject1 = new MultiHeadUrl.MultiBusidUrlRsp();
          ((MultiHeadUrl.MultiBusidUrlRsp)localObject1).mergeFrom((byte[])paramObject);
        }
      }
      paramObject = localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramObject = null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger multiBusidUrlRsp mergeFrom exception..." + localException.getMessage());
        }
        localException.printStackTrace();
        continue;
        if (??? != null) {
          i1 = ???.getResultCode();
        }
      }
      if (!QLog.isColorLevel()) {
        break label832;
      }
      ??? = new StringBuilder();
      ???.append("start ====================================================================================\n\n");
      ???.append("QQHead_Stranger response.srcUidType=" + paramObject.srcUidType.get()).append(";srcUin=" + paramObject.srcUin.get()).append("\n\n").append(";srcTid=" + paramObject.srcTid.get()).append(";srcOpenid=" + paramObject.srcOpenid.get()).append("\n\n").append(";dstUidType=" + paramObject.dstUidType.get()).append(";result=" + paramObject.result.get()).append("\n\n");
      localObject2 = paramObject.dstUsrHeadInfos.get();
      if (localObject2 == null) {
        break label813;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MultiHeadUrl.RspUsrHeadInfo)((Iterator)localObject2).next();
        ???.append("-------------------------------------------------------------------------------------\n\n");
        ???.append("RspUsrHeadInfo.dstUin=" + ((MultiHeadUrl.RspUsrHeadInfo)localObject3).dstUin.get()).append(";dstTid=" + ((MultiHeadUrl.RspUsrHeadInfo)localObject3).dstTid.get()).append(";dstOpenid=" + ((MultiHeadUrl.RspUsrHeadInfo)localObject3).dstOpenid.get()).append("\n\n");
        localObject3 = ((MultiHeadUrl.RspUsrHeadInfo)localObject3).dstHeadInfos.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (MultiHeadUrl.RspHeadInfo)((Iterator)localObject3).next();
          ???.append("RspHeadInfo.usrType=" + ((MultiHeadUrl.RspHeadInfo)localObject4).usrType.get()).append("\n\n").append(";faceType=" + ((MultiHeadUrl.RspHeadInfo)localObject4).faceType.get()).append("\n\n").append(";timestamp=" + ((MultiHeadUrl.RspHeadInfo)localObject4).timestamp.get()).append("\n\n").append(";faceFlag=" + ((MultiHeadUrl.RspHeadInfo)localObject4).faceFlag.get()).append("\n\n").append(";url=" + ((MultiHeadUrl.RspHeadInfo)localObject4).url.get()).append("\n\n").append(";sysid=" + ((MultiHeadUrl.RspHeadInfo)localObject4).sysid.get()).append("\n\n");
        }
      }
      ???.append("end ====================================================================================\n\n");
      QLog.d("headstranger", 2, ???.toString());
      localList = paramObject.dstUsrHeadInfos.get();
      localObject4 = new ArrayList();
      ??? = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
      localArrayList = new ArrayList();
      i3 = paramObject.dstUidType.get();
      i2 = paramToServiceMsg.extraData.getInt("subtype");
      localIterator1 = ???.iterator();
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
    Object localObject4;
    int i3;
    int i2;
    Iterator localIterator1;
    FriendListHandler.QQHeadDetails localQQHeadDetails;
    if (localIterator1.hasNext())
    {
      localQQHeadDetails = (FriendListHandler.QQHeadDetails)localIterator1.next();
      Iterator localIterator2 = localList.iterator();
      label928:
      if (localIterator2.hasNext())
      {
        ??? = (MultiHeadUrl.RspUsrHeadInfo)localIterator2.next();
        if (i3 == 0)
        {
          localObject2 = String.valueOf(???.dstUin.get());
          label966:
          if (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(localObject2)) {
            break label1076;
          }
          localObject3 = ???.dstHeadInfos.get();
          paramObject = null;
          ??? = null;
          Iterator localIterator3 = ((List)localObject3).iterator();
          label1001:
          if (!localIterator3.hasNext()) {
            break label1102;
          }
          localObject3 = (MultiHeadUrl.RspHeadInfo)localIterator3.next();
          i1 = ((MultiHeadUrl.RspHeadInfo)localObject3).usrType.get();
          if (i1 != 1) {
            break label1078;
          }
          paramObject = localObject3;
        }
      }
    }
    label1296:
    for (;;)
    {
      break label1001;
      if (i3 == 1)
      {
        localObject2 = String.valueOf(???.dstTid.get());
        break label966;
      }
      localObject2 = ???.dstOpenid.get();
      break label966;
      label1076:
      break label928;
      label1078:
      if ((i1 == 32) && (((MultiHeadUrl.RspHeadInfo)localObject3).faceType.get() != 0))
      {
        ??? = (FromServiceMsg)localObject3;
        continue;
        label1102:
        if (??? != null)
        {
          label1106:
          paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(32, (String)localObject2, i2);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(32, (String)localObject2, i2)) {
            break label1296;
          }
          i1 = 1;
        }
        for (;;)
        {
          if (i1 == 0) {
            break label1360;
          }
          paramObject = new QQHeadInfo();
          paramObject.soruceType = localQQHeadDetails.jdField_a_of_type_Byte;
          paramObject.subType = i2;
          paramObject.phoneNum = ((String)localObject2);
          paramObject.dwTimestamp = ???.timestamp.get();
          paramObject.cHeadType = ((byte)???.faceType.get());
          paramObject.dstUsrType = 32;
          paramObject.dwFaceFlgas = ((byte)???.faceFlag.get());
          paramObject.downLoadUrl = ???.url.get();
          paramObject.systemHeadID = ((short)???.sysid.get());
          localArrayList.add(paramObject);
          break label928;
          if (paramObject != null)
          {
            ??? = paramObject;
            break label1106;
          }
          if (!QLog.isColorLevel()) {
            break label928;
          }
          QLog.d("headstranger", 2, "there is no headinfo uin=" + (String)localObject2);
          break label928;
          break;
          if (paramObject != null)
          {
            paramObject = (com.tencent.mobileqq.data.Setting)paramObject.second;
            if (paramObject == null)
            {
              i1 = 1;
            }
            else if (paramObject.headImgTimestamp != ???.timestamp.get())
            {
              i1 = 1;
            }
            else
            {
              ((List)localObject4).add(localQQHeadDetails);
              i1 = 0;
            }
          }
          else
          {
            i1 = 1;
          }
        }
        label1360:
        break label928;
        if (this.jdField_a_of_type_Cvl == null) {}
        synchronized (this.jdField_b_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_Cvl == null) {
            this.jdField_a_of_type_Cvl = new cvl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          i1 = 0;
          if (i1 < localArrayList.size())
          {
            ??? = (QQHeadInfo)localArrayList.get(i1);
            this.jdField_a_of_type_Cvl.a(???, paramToServiceMsg);
            i1 += 1;
          }
        }
        if (((List)localObject4).size() <= 0) {
          break;
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        paramToServiceMsg = ???.a();
        paramToServiceMsg.a();
        i1 = 0;
        try
        {
          while (i1 < ((List)localObject4).size())
          {
            paramObject = (FriendListHandler.QQHeadDetails)((List)localObject4).get(i1);
            paramObject = "stranger_" + String.valueOf(i2) + "_" + paramObject.jdField_a_of_type_JavaLangString;
            localObject2 = (com.tencent.mobileqq.data.Setting)???.a(com.tencent.mobileqq.data.Setting.class, paramObject);
            if (localObject2 != null)
            {
              ((com.tencent.mobileqq.data.Setting)localObject2).updateTimestamp = System.currentTimeMillis();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((com.tencent.mobileqq.data.Setting)localObject2);
              ???.a((Entity)localObject2);
            }
            c(paramObject, true);
            i1 += 1;
          }
        }
        catch (Exception ???)
        {
          paramToServiceMsg.c();
          paramToServiceMsg.b();
          return;
        }
      }
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
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg arg2, Object paramObject)
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
        break label745;
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
    label214:
    label739:
    label743:
    label745:
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
        FriendListHandler.QQHeadDetails localQQHeadDetails;
        label244:
        QQHeadUrl.RspHeadInfo localRspHeadInfo;
        int i2;
        if (localIterator1.hasNext())
        {
          localQQHeadDetails = (FriendListHandler.QQHeadDetails)localIterator1.next();
          Iterator localIterator2 = paramObject.iterator();
          if (!localIterator2.hasNext()) {
            break label739;
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
            break label743;
          }
          ((List)localObject1).add(localQQHeadDetails);
          break label214;
          ??? = String.valueOf(localRspHeadInfo.dstUin.get());
          break label281;
          break label244;
          ???.uin = localRspHeadInfo.dstUin.get();
          break label328;
          if (this.jdField_a_of_type_Cvl == null) {}
          synchronized (this.jdField_b_of_type_JavaLangObject)
          {
            if (this.jdField_a_of_type_Cvl == null) {
              this.jdField_a_of_type_Cvl = new cvl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
            }
            i2 = 0;
            if (i2 < ((List)localObject2).size())
            {
              ??? = (QQHeadInfo)((List)localObject2).get(i2);
              this.jdField_a_of_type_Cvl.a(???, paramToServiceMsg);
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
                c(i1 + "_" + ((FriendListHandler.QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString, true);
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
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = paramToServiceMsg.extraData.getInt("search_version");
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (i1 != 2) {
        break label130;
      }
      bool &= paramObject instanceof RespSearch;
      i1 = 86;
    }
    for (;;)
    {
      label45:
      int i2;
      if (bool)
      {
        paramToServiceMsg = (RespHead)a(paramFromServiceMsg.getWupBuffer(), "RespHead", new RespHead());
        if (paramToServiceMsg != null)
        {
          i2 = paramToServiceMsg.iResult;
          paramToServiceMsg = paramToServiceMsg.strErrorMsg;
        }
      }
      for (;;)
      {
        a(49, bool, new Object[] { Integer.valueOf(i1), paramObject, Integer.valueOf(i2), paramToServiceMsg });
        return;
        bool = false;
        break;
        label130:
        if (i1 != 3) {
          break label171;
        }
        bool &= paramObject instanceof ArrayList;
        i1 = 87;
        break label45;
        paramToServiceMsg = null;
        bool = false;
        i2 = 0;
        continue;
        paramToServiceMsg = null;
        i2 = 0;
      }
      label171:
      i1 = -1;
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (SetRichSigRes)paramObject;
      if (paramFromServiceMsg.cResult == 0)
      {
        paramObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
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
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = a(paramToServiceMsg);
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramToServiceMsg.extraData.getLong("uin"));
    if (i1 == 147) {}
    for (i1 = 72;; i1 = 71)
    {
      if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
      {
        a(i1, false, localBundle);
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
          localBundle.putLong("uin", l1);
          localBundle.putInt("safety_flag", i2 & 0x1F);
          a(i1, true, localBundle);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handle_oidb_0x476 error:" + paramToServiceMsg.getMessage());
        }
        a(i1, false, localBundle);
        return;
      }
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      bool2 = paramToServiceMsg.extraData.getBoolean("key_show_to_friends", true);
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "set network switch isSuccess = " + bool1 + "; isShowedToFriends = " + bool2);
      }
      if (!bool1) {
        break label192;
      }
    }
    label192:
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        if (bool1) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d(bool2, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("handleSetShowNetworkToFriendResp", 2, paramToServiceMsg.getMessage());
        bool1 = false;
        continue;
        continue;
      }
      if (!bool1)
      {
        bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(false);
        a(76, bool1, Boolean.valueOf(bool2));
        return;
        bool1 = false;
        break;
        bool1 = false;
        continue;
      }
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool4 = true;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool3 = true;
      bool1 = bool5;
      bool2 = bool3;
      if (bool3) {
        bool2 = bool6;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool2 = bool6;
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        bool2 = bool6;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool3 = true;
        bool1 = bool5;
        bool2 = bool3;
        if (bool3)
        {
          bool2 = bool6;
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          bool2 = bool6;
          long l1 = paramToServiceMsg.getInt();
          bool2 = bool6;
          if (paramToServiceMsg.get() != 0) {
            continue;
          }
          bool1 = bool4;
          bool2 = bool1;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d(bool1, false);
          bool2 = bool3;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("handleGetShowNetworkToFriendResp", 2, paramToServiceMsg.getMessage());
        bool3 = false;
        bool1 = bool2;
        bool2 = bool3;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "get network switch isSuccess = " + bool2 + "; isShowedToFriends = " + bool1);
      }
      if (!bool2) {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(false);
      }
      a(77, bool2, Boolean.valueOf(bool1));
      return;
      bool3 = false;
      break;
      bool3 = false;
      continue;
      bool1 = false;
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
      paramString2 = new ctb(this);
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
        localObject = (ctb)this.jdField_c_of_type_JavaUtilHashtable.get(paramString1);
        switch (paramInt2)
        {
        }
        for (;;)
        {
          paramString2 = (String)localObject;
          break;
          ((ctb)localObject).b = System.currentTimeMillis();
          if (!bool) {
            this.jdField_c_of_type_JavaUtilHashtable.remove(paramString1);
          }
          ((ctb)localObject).e = (((ctb)localObject).b - ((ctb)localObject).jdField_a_of_type_Long);
          paramString2 = (String)localObject;
          break;
          ((ctb)localObject).c = System.currentTimeMillis();
          paramString2 = (String)localObject;
          break;
          ((ctb)localObject).d = System.currentTimeMillis();
          ((ctb)localObject).jdField_a_of_type_Int = paramInt3;
          ((ctb)localObject).jdField_a_of_type_JavaLangString = paramString2;
          ((ctb)localObject).e = (((ctb)localObject).d - ((ctb)localObject).jdField_a_of_type_Long);
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
    boolean bool = true;
    if (c(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    label1039:
    label1045:
    do
    {
      Object localObject;
      int i1;
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
                    if (paramToServiceMsg.extraData.getByte("ifShowTermType", (byte)0).byteValue() == 1)
                    {
                      a(paramFromServiceMsg.getUin(), paramObject, paramToServiceMsg.extraData.getLong("timeStamp"), paramToServiceMsg.extraData.getStringArrayList("uinList"));
                      return;
                    }
                    QLog.d("FriendListHandler", 1, "handleGetFriendList unknow request!");
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
            if (paramToServiceMsg.extraData.getInt("reqType", 0) == 0)
            {
              b(paramToServiceMsg, paramObject);
              return;
            }
            a(paramToServiceMsg, paramObject);
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
          d(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("AvatarInfoSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
        {
          a(paramToServiceMsg, paramFromServiceMsg, (QQHeadUrlResp)paramObject);
          return;
        }
        if ("IncreaseURLSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
        {
          f(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("MultibusidURLSvr.HeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
        {
          e(paramToServiceMsg, paramFromServiceMsg, paramObject);
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
        a((AddFriendResp)paramObject, paramToServiceMsg);
        return;
      }
      if ("friendlist.getUserAddFriendSetting".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, (GetUserAddFriendSettingResp)paramObject);
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
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
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
            break label1039;
          }
        }
        for (;;)
        {
          QLog.d("FriendListHandler", 2, bool);
          if (!paramFromServiceMsg.isSuccess()) {
            break label1045;
          }
          paramFromServiceMsg = (SetGroupResp)paramObject;
          if (paramFromServiceMsg == null) {
            break;
          }
          a(paramToServiceMsg, paramFromServiceMsg);
          return;
          bool = false;
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
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("ProfileService.SetRichSig".equals(paramFromServiceMsg.getServiceCmd()))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
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
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5d1_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (("OidbSvc.0x476_146".equals(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0x476_147".equals(paramFromServiceMsg.getServiceCmd())))
      {
        m(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("SummaryCard.ReqCondSearch".equals(paramFromServiceMsg.getServiceCmd()))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x491_107".equals(paramFromServiceMsg.getServiceCmd()))
      {
        n(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x490_107".equals(paramFromServiceMsg.getServiceCmd()))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5e1_8".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
        return;
      }
    } while (!"OidbSvc.0x49d_107".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()));
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, ArrayList paramArrayList1, FromServiceMsg paramFromServiceMsg, ArrayList paramArrayList2)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
    localEntityTransaction = localFriendsManager.a();
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
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
        if (255 == localProfSmpInfoRes.cSpecialFlag) {
          localProfSmpInfoRes.cSpecialFlag = 0;
        }
        int i1 = localProfSmpInfoRes.cSpecialFlag;
        if (1 == i1) {
          try
          {
            paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 0);
            if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
            {
              paramFromServiceMsg = paramFromServiceMsg.iterator();
              if (paramFromServiceMsg.hasNext())
              {
                localObject = (MessageRecord)paramFromServiceMsg.next();
                if (((MessageRecord)localObject).msgtype != -1013) {
                  continue;
                }
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, 0, ((MessageRecord)localObject).uniseq);
                continue;
              }
            }
            localFriendsManager.a(String.valueOf(localProfSmpInfoRes.dwUin), localProfSmpInfoRes.wFace, localProfSmpInfoRes.strNick, null, localProfSmpInfoRes.cSpecialFlag, (short)localProfSmpInfoRes.cSex, localProfSmpInfoRes.wAge);
          }
          catch (Exception paramFromServiceMsg)
          {
            paramFromServiceMsg.printStackTrace();
          }
        }
        paramFromServiceMsg = localFriendsManager.b(str);
        paramFromServiceMsg.nFaceID = localProfSmpInfoRes.wFace;
        paramFromServiceMsg.shGender = ((short)localProfSmpInfoRes.cSex);
        paramFromServiceMsg.age = localProfSmpInfoRes.wAge;
        paramFromServiceMsg.shAge = ((short)localProfSmpInfoRes.wAge);
        if (localProfSmpInfoRes.strNick != null) {
          paramFromServiceMsg.strNick = localProfSmpInfoRes.strNick;
        }
        if (localProfSmpInfoRes.sProvince != null) {
          paramFromServiceMsg.strProvince = localProfSmpInfoRes.sProvince;
        }
        if (localProfSmpInfoRes.sCity != null) {
          paramFromServiceMsg.strCity = localProfSmpInfoRes.sCity;
        }
        if ((str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (localProfSmpInfoRes.wLevel != 0)) {
          paramFromServiceMsg.iQQLevel = localProfSmpInfoRes.wLevel;
        }
        if ((localProfSmpInfoRes.isShowXMan == -1) || (localProfSmpInfoRes.dwLoginDay < 0L) || (localProfSmpInfoRes.dwPhoneQQXManDay <= 0L)) {
          continue;
        }
        if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
          continue;
        }
        paramFromServiceMsg.lLoginDays = localProfSmpInfoRes.dwLoginDay;
        paramFromServiceMsg.lQQMasterLogindays = localProfSmpInfoRes.dwPhoneQQXManDay;
        if (localProfSmpInfoRes.isShowXMan != 1) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramArrayList1)
      {
        ProfSmpInfoRes localProfSmpInfoRes;
        String str;
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("FriendListHandler", 2, "handleFriendInfo err", paramArrayList1);
        if (localEntityTransaction == null) {
          continue;
        }
        localEntityTransaction.b();
        if (!paramToServiceMsg.extraData.getBoolean("batch_data")) {
          continue;
        }
        a(67, true, paramArrayList2);
        return;
        boolean bool = false;
        continue;
        localEntityTransaction.c();
        if (localEntityTransaction == null) {
          continue;
        }
        localEntityTransaction.b();
        continue;
      }
      finally
      {
        if (localEntityTransaction == null) {
          continue;
        }
        localEntityTransaction.b();
      }
      paramFromServiceMsg.setXManFlag(bool);
      if (paramArrayList1.size() == 1)
      {
        if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
          paramFromServiceMsg.allowPeopleSee = localProfSmpInfoRes.bOpenLoginDays;
        }
        paramFromServiceMsg.allowClick = localProfSmpInfoRes.bXManIconClick;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "card.allowClick=" + paramFromServiceMsg.allowClick + ";card.allowPeopleSee= " + paramFromServiceMsg.allowPeopleSee);
      }
      localFriendsManager.a(paramFromServiceMsg);
      if (paramToServiceMsg.extraData.getBoolean("reqDateNick", false))
      {
        localObject = localProfSmpInfoRes.sDateNick;
        paramFromServiceMsg = (FromServiceMsg)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramFromServiceMsg = localProfSmpInfoRes.strNick;
        }
        localObject = paramFromServiceMsg;
        if (TextUtils.isEmpty(paramFromServiceMsg)) {
          localObject = str;
        }
        localFriendsManager.b(str, (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "$handleFriendInfo | uin=" + str + " | datenick = " + localProfSmpInfoRes.sDateNick + " | nick=" + localProfSmpInfoRes.strNick);
        }
        a(88, true, new Object[] { str, localObject });
      }
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
    b(paramString, false);
  }
  
  public void a(String paramString, byte paramByte)
  {
    a(4, paramString, 3000, (byte)0, paramByte, null, false);
  }
  
  public void a(String paramString, byte paramByte1, byte paramByte2)
  {
    a(1, paramString, 3000, paramByte1, paramByte2, null, false);
  }
  
  public void a(String paramString1, byte paramByte1, byte paramByte2, byte paramByte3, String paramString2)
  {
    if (paramByte1 == 1)
    {
      a(100, paramString1, 3000, paramByte2, paramByte3, paramString2, false);
      return;
    }
    a(1, paramString1, 3000, paramByte2, paramByte3, null, false);
  }
  
  public void a(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    a(32, paramString, paramInt, paramByte1, paramByte2, null, true);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.GetAutoInfoReq");
    localToServiceMsg.extraData.putString("uin", paramString);
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
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "getUserAddFriendSetting " + paramString1 + ", " + paramInt + ", " + paramString2);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.getUserAddFriendSetting");
    localToServiceMsg.extraData.putString("uin", paramString1);
    localToServiceMsg.extraData.putInt("source_id", paramInt);
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      localToServiceMsg.extraData.putString("extra", paramString2);
    }
    a(localToServiceMsg);
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "send_oidb_0x476 " + paramLong + paramInt);
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1142);
    localOIDBSSOPkg.uint32_service_type.set(paramInt);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(6);
    localByteBuffer.putShort((short)1);
    localByteBuffer.putInt((int)paramLong);
    localOIDBSSOPkg.bytes_bodybuffer.setHasFlag(true);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramString = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString.extraData.putLong("uin", paramLong);
    b(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "infoOpenId " + paramString1 + ", " + paramString2);
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1505);
    localOIDBSSOPkg.uint32_service_type.set(8);
    oidb_0x5e1.ReqBody localReqBody = new oidb_0x5e1.ReqBody();
    localReqBody.rpt_bytes_openid.add(ByteStringMicro.copyFrom(paramString1.getBytes()));
    localReqBody.uint32_appid.set((int)Long.parseLong(paramString2));
    localReqBody.uint32_req_nick.set(1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramString2 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "OidbSvc.0x5e1_8");
    paramString2.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString2.extraData.putString("uin", paramString1);
    b(paramString2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, byte paramByte, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "addFriend" + paramString1 + ";friendSetting " + paramInt1 + ";groupId " + paramByte + ";msg " + paramString3 + ";sourceID " + paramInt2 + ";subSourceId " + paramInt3 + ";autoSend " + paramBoolean1 + ";extraUin " + paramString2 + ";isContactBothWay " + paramBoolean2 + ";remark " + paramString4 + ";srcName " + paramString5);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.addFriend");
    Bundle localBundle = localToServiceMsg.extraData;
    localBundle.putString("uin", paramString1);
    localBundle.putInt("friend_setting", paramInt1);
    localBundle.putByte("group_id", paramByte);
    localBundle.putString("msg", paramString3);
    localBundle.putInt("source_id", paramInt2);
    localBundle.putInt("sub_source_id", paramInt3);
    localBundle.putString("extra", paramString2);
    localBundle.putBoolean("auto_send", paramBoolean1);
    localBundle.putByteArray("sig", paramArrayOfByte);
    localBundle.putBoolean("contact_bothway", paramBoolean2);
    localBundle.putString("remark", paramString4);
    localBundle.putString("src_name", paramString5);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    ToServiceMsg localToServiceMsg = a("SummaryCard.ReqSearch");
    localToServiceMsg.extraData.putString("param_keyword", paramString1);
    localToServiceMsg.extraData.putString("param_country_code", paramString2);
    localToServiceMsg.extraData.putInt("search_page", paramInt2);
    localToServiceMsg.extraData.putIntArray("search_list", paramArrayOfInt);
    localToServiceMsg.extraData.putInt("search_version", paramInt1);
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
    paramString1.e();
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
    if (this.bo == 0)
    {
      this.bo = 1;
      new Handler(Looper.getMainLooper()).postDelayed(new csx(this), 15000L);
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
  
  public void a(long[] paramArrayOfLong, int[] paramArrayOfInt)
  {
    int i2 = 0;
    if ((paramArrayOfLong == null) || (paramArrayOfInt == null)) {
      return;
    }
    int i3 = paramArrayOfLong.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfInt.length * 2 + 4 + i3 * 4);
    localByteBuffer.putShort((short)paramArrayOfInt.length);
    int i1 = 0;
    while (i1 < paramArrayOfInt.length)
    {
      localByteBuffer.putShort((short)paramArrayOfInt[i1]);
      i1 += 1;
    }
    localByteBuffer.putShort((short)i3);
    i1 = i2;
    while (i1 < i3)
    {
      localByteBuffer.putInt(Utils.a(paramArrayOfLong[i1]));
      i1 += 1;
    }
    paramArrayOfLong = new oidb_sso.OIDBSSOPkg();
    paramArrayOfLong.uint32_command.set(1276);
    paramArrayOfLong.uint32_service_type.set(30);
    paramArrayOfLong.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramArrayOfInt = a("OidbSvc.0x4fc_30");
    paramArrayOfInt.putWupBuffer(paramArrayOfLong.toByteArray());
    paramArrayOfInt.setTimeout(10000L);
    b(paramArrayOfInt);
  }
  
  public void a(String[] paramArrayOfString)
  {
    a(paramArrayOfString, 0, 0, null, false);
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
  
  public void a(String[] paramArrayOfString, boolean paramBoolean)
  {
    a(paramArrayOfString, 0, 2, null, paramBoolean);
  }
  
  public void a(String[] paramArrayOfString, int[] paramArrayOfInt)
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
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      a(arrayOfLong, paramArrayOfInt);
    }
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis() - this.h;
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "getOnlineFriend  | intervalTime = " + l1 + " | sGetOnlineFriendDelay = " + QQAppInterface.bj);
    }
    return (this.h > 0L) && ((l1 < QQAppInterface.bj) || (l1 > QQAppInterface.bi - QQAppInterface.bj));
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
      paramString = (csz)this.jdField_d_of_type_JavaUtilHashtable.get(paramString);
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
        csz localcsz = (csz)this.jdField_d_of_type_JavaUtilHashtable.get(str);
        if (((localcsz.c == 0L) && (l1 - localcsz.jdField_a_of_type_Long > 60000L)) || ((localcsz.c > 0L) && (l1 > localcsz.c))) {
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
        localObject1 = new csz();
        ((csz)localObject1).jdField_a_of_type_Long = l1;
        ((csz)localObject1).b = 1L;
        this.jdField_d_of_type_JavaUtilHashtable.put(paramString, localObject1);
        break;
        i1 = 0;
      }
    }
  }
  
  public boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "addFriendToFriendList " + paramString1 + ", " + paramInt1 + ", " + paramInt2 + ", " + paramString2 + ", " + paramBoolean1);
    }
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (localPhoneContactManager != null) {
      localPhoneContactManager.c();
    }
    boolean bool = localFriendsManagerImp.b(paramString1);
    paramBoolean2 = localFriendsManagerImp.a(paramString1, paramInt1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler addFriendToFriendList flag = " + paramBoolean2);
    }
    if (paramBoolean2)
    {
      if (this.g == 0L) {
        a(1, true, Boolean.valueOf(true));
      }
      a(63, true, paramString1);
      a(paramString1, false);
      localFriendsManagerImp.a(paramString1, false);
    }
    if ((!bool) && (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)) && (!CrmUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        break label300;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 0, -1L, paramInt2, false, paramString2, paramBoolean1);
    }
    for (;;)
    {
      paramString2 = new ArrayList();
      paramString2.add(paramString1);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), paramString2);
      return paramBoolean2;
      label300:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 0, -1L, paramInt2, false);
    }
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    short s1;
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "getFriendNickByBatch|uinsize = " + paramArrayList.size() + " time=" + System.currentTimeMillis());
      }
      s1 = (short)paramArrayList.size();
    } while (s1 > 500);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1181);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(s1 * 4 + 7);
    ((ByteBuffer)localObject).put((byte)0).putShort((short)1).putShort(this.jdField_b_of_type_Short).putShort(s1);
    short s2 = 0;
    for (;;)
    {
      if (s2 < s1) {
        try
        {
          ((ByteBuffer)localObject).putInt(Utils.a(Long.parseLong((String)paramArrayList.get(s2))));
          s2 = (short)(s2 + 1);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, "getFriendNickByBatch parseLong err uin=" + (String)paramArrayList.get(s2), localException);
            }
          }
        }
      }
    }
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x49d_107");
    ((ToServiceMsg)localObject).extraData.putStringArrayList("batchuin", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putShort("uincount", s1);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
    return true;
  }
  
  public void b()
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 0;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
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
    a(1, paramString, 3000, (byte)0, (byte)0, null, false);
  }
  
  public void b(String paramString, byte paramByte)
  {
    a(11, paramString, 3000, (byte)0, paramByte, null, false);
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
      localToServiceMsg.extraData.putBoolean("reqDateNick", paramBoolean);
      a(localToServiceMsg);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void b(String[] paramArrayOfString)
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
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1168);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x490_107");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
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
    a(4, paramString, 3000, (byte)0, (byte)0, null, false);
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
  
  public void c(boolean paramBoolean) {}
  
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
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x490_107");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x491_107");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5e1_8");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x49d_107");
      this.jdField_a_of_type_JavaUtilSet.add("MultibusidURLSvr.HeadUrlReq");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Cvl != null) {
      this.jdField_a_of_type_Cvl.a();
    }
    super.d();
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
    a(11, paramString, 3000, (byte)0, (byte)0, null, false);
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
  
  public void d(String paramString, boolean paramBoolean)
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
  
  public void d(boolean paramBoolean)
  {
    int i1 = 1;
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1169);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(1);
    if (paramBoolean) {
      i1 = 0;
    }
    ((ByteBuffer)localObject).put((byte)i1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x491_107");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("key_show_to_friends", paramBoolean);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    b((ToServiceMsg)localObject);
  }
  
  public boolean d()
  {
    String str;
    if (this.bm == -1)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.app, "StatusEntry");
      if ((str == null) || (str.length() <= 0)) {}
    }
    try
    {
      this.bm = Integer.parseInt(str);
      if (this.bm == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richstatus.mate", 2, "isStatusEntryVisible " + this.bm + ", " + localException.toString());
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
    new csy(this, "saveSelfSig", paramString).start();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListHandler
 * JD-Core Version:    0.7.0.1
 */