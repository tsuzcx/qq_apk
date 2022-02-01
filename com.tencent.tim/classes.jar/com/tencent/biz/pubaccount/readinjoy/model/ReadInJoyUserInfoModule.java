package com.tencent.biz.pubaccount.readinjoy.model;

import acff;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import kxm;
import lbz;
import lcd;
import lir;
import lit;
import lun;
import lup;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.AccountInfo;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.AccountLevelInfo;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.GetUserInfoReq;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.GetUserInfoRsp;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.HeadInfo;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.ReqBody;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.RspBody;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UserInfoItem;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UserInfoOption;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ReadInJoyUserInfoModule
  extends lir
{
  private static Map<Long, String> eo = new HashMap();
  private lit a;
  private ConcurrentHashMap<String, List<a>> bn = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Boolean> bo = new ConcurrentHashMap();
  
  public ReadInJoyUserInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
    this.a = new lit(paramExecutorService, this, paramEntityManager);
  }
  
  public static void C(long paramLong, String paramString)
  {
    if (paramLong <= 0L) {
      return;
    }
    if (eo == null) {
      eo = new HashMap();
    }
    eo.put(Long.valueOf(paramLong), paramString);
  }
  
  public static ReadInJoyUserInfo a(long paramLong, a parama)
  {
    if (paramLong != 0L)
    {
      Object localObject = (QQAppInterface)kxm.getAppRuntime();
      if (localObject != null)
      {
        localObject = ((lcd)((QQAppInterface)localObject).getManager(163)).b().a();
        if (localObject != null) {
          return ((ReadInJoyUserInfoModule)localObject).a(String.valueOf(paramLong), parama);
        }
      }
    }
    return null;
  }
  
  private ToServiceMsg a(Request0xb81Params paramRequest0xb81Params)
  {
    if (paramRequest0xb81Params == null)
    {
      QLog.d("ReadInJoyUserInfoModule", 2, "make0x81bRequestUserInfosPkg failed, params is null.");
      return null;
    }
    oidb_cmd0xb81.ReqBody localReqBody = new oidb_cmd0xb81.ReqBody();
    localReqBody.uint32_client_type.set(Request0xb81Params.a(paramRequest0xb81Params));
    oidb_cmd0xb81.GetUserInfoReq localGetUserInfoReq = new oidb_cmd0xb81.GetUserInfoReq();
    localGetUserInfoReq.uint32_info_priority.set(Request0xb81Params.b(paramRequest0xb81Params));
    Object localObject = new oidb_cmd0xb81.UserInfoOption();
    ((oidb_cmd0xb81.UserInfoOption)localObject).uint32_nick.set(Request0xb81Params.c(paramRequest0xb81Params));
    ((oidb_cmd0xb81.UserInfoOption)localObject).uint32_head_url.set(Request0xb81Params.d(paramRequest0xb81Params));
    ((oidb_cmd0xb81.UserInfoOption)localObject).uint32_account_cc_level.set(2);
    localGetUserInfoReq.msg_user_option.set((MessageMicro)localObject);
    localObject = new ArrayList();
    if ((Request0xb81Params.a(paramRequest0xb81Params) != null) && (Request0xb81Params.a(paramRequest0xb81Params).size() > 0))
    {
      int i = 0;
      while (i < Request0xb81Params.a(paramRequest0xb81Params).size())
      {
        oidb_cmd0xb81.AccountInfo localAccountInfo = new oidb_cmd0xb81.AccountInfo();
        localAccountInfo.uint32_account_type.set(((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)Request0xb81Params.a(paramRequest0xb81Params).get(i)).accountType);
        localAccountInfo.uint64_uin.set(((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)Request0xb81Params.a(paramRequest0xb81Params).get(i)).uin);
        localAccountInfo.uint64_friend_status.set(((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)Request0xb81Params.a(paramRequest0xb81Params).get(i)).friendStatus);
        ((List)localObject).add(localAccountInfo);
        i += 1;
      }
    }
    localGetUserInfoReq.msg_account_info.set((List)localObject);
    localReqBody.msg_get_user_info_req.set(localGetUserInfoReq);
    return makeOIDBPkg("OidbSvc.0xb81", 2945, 1, localReqBody.toByteArray());
  }
  
  public static String a(long paramLong, a parama, String paramString)
  {
    parama = a(paramLong, parama);
    if (parama == null) {
      return paramString;
    }
    return parama.nick;
  }
  
  public static String a(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (paramReadInJoyUserInfo == null) {
      return "";
    }
    if ((paramReadInJoyUserInfo.faceFlag & 0x8) != 0) {
      return paramReadInJoyUserInfo.faceUrl + "140";
    }
    if ((paramReadInJoyUserInfo.faceFlag & 0x4) != 0) {
      return paramReadInJoyUserInfo.faceUrl + "100";
    }
    if ((paramReadInJoyUserInfo.faceFlag & 0x10) != 0) {
      return paramReadInJoyUserInfo.faceUrl + "0";
    }
    return paramReadInJoyUserInfo.faceUrl + "40";
  }
  
  private void a(Request0xb81Params paramRequest0xb81Params)
  {
    QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "request0xb81UserInfo, params = \n", paramRequest0xb81Params });
    ToServiceMsg localToServiceMsg = a(paramRequest0xb81Params);
    if (localToServiceMsg != null)
    {
      localToServiceMsg.addAttribute("user_info_uin_list_key", Request0xb81Params.a(paramRequest0xb81Params));
      localToServiceMsg.addAttribute("retry_request_count_key", Integer.valueOf(0));
      localToServiceMsg.addAttribute("request_begin_time", Long.valueOf(System.currentTimeMillis()));
      sendPbReq(localToServiceMsg);
    }
  }
  
  private void aq(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new oidb_cmd0xb81.RspBody();
    int j = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    long l = System.currentTimeMillis() - ((Long)paramToServiceMsg.getAttribute("request_begin_time")).longValue();
    QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "handle0xb81UserInfo result = ", Integer.valueOf(j), ", cost = ", Long.valueOf(l) });
    paramFromServiceMsg = kxm.getAppRuntime();
    boolean bool;
    int i;
    label182:
    Object localObject2;
    if (j == 0)
    {
      bool = true;
      kxm.b(paramFromServiceMsg, bool, l, j);
      if (j != 0) {
        break label700;
      }
      if ((!((oidb_cmd0xb81.RspBody)localObject1).msg_get_user_info_rsp.has()) || (((oidb_cmd0xb81.RspBody)localObject1).msg_get_user_info_rsp.get() == null)) {
        break label879;
      }
      paramToServiceMsg = (oidb_cmd0xb81.GetUserInfoRsp)((oidb_cmd0xb81.RspBody)localObject1).msg_get_user_info_rsp.get();
      if ((!paramToServiceMsg.rpt_msg_user_info.has()) || (paramToServiceMsg.rpt_msg_user_info.get() == null) || (paramToServiceMsg.rpt_msg_user_info.get().size() <= 0)) {
        break label879;
      }
      paramObject = paramToServiceMsg.rpt_msg_user_info.get();
      i = 0;
      if (i >= paramObject.size()) {
        break label879;
      }
      localObject1 = new ReadInJoyUserInfo();
      localObject2 = (oidb_cmd0xb81.UserInfoItem)paramObject.get(i);
      if ((!((oidb_cmd0xb81.UserInfoItem)localObject2).msg_account_info.has()) || (((oidb_cmd0xb81.UserInfoItem)localObject2).msg_account_info.get() == null)) {
        break label1107;
      }
      ((ReadInJoyUserInfo)localObject1).accountType = ((oidb_cmd0xb81.AccountInfo)((oidb_cmd0xb81.UserInfoItem)localObject2).msg_account_info.get()).uint32_account_type.get();
      ((ReadInJoyUserInfo)localObject1).uin = String.valueOf(((oidb_cmd0xb81.AccountInfo)((oidb_cmd0xb81.UserInfoItem)localObject2).msg_account_info.get()).uint64_uin.get());
    }
    label328:
    label1107:
    for (paramToServiceMsg = String.valueOf(((oidb_cmd0xb81.AccountInfo)((oidb_cmd0xb81.UserInfoItem)localObject2).msg_account_info.get()).uint64_uin.get());; paramToServiceMsg = "")
    {
      if (((oidb_cmd0xb81.UserInfoItem)localObject2).bytes_nick.has())
      {
        paramFromServiceMsg = ((oidb_cmd0xb81.UserInfoItem)localObject2).bytes_nick.get().toStringUtf8();
        ((ReadInJoyUserInfo)localObject1).nick = paramFromServiceMsg;
        if ((((oidb_cmd0xb81.UserInfoItem)localObject2).msg_head_info.has()) && (((oidb_cmd0xb81.UserInfoItem)localObject2).msg_head_info.get() != null))
        {
          paramFromServiceMsg = (oidb_cmd0xb81.HeadInfo)((oidb_cmd0xb81.UserInfoItem)localObject2).msg_head_info.get();
          ((ReadInJoyUserInfo)localObject1).faceType = paramFromServiceMsg.uint32_face_type.get();
          ((ReadInJoyUserInfo)localObject1).timestamp = paramFromServiceMsg.uint64_timestamp.get();
          ((ReadInJoyUserInfo)localObject1).faceFlag = paramFromServiceMsg.uint32_face_flag.get();
          ((ReadInJoyUserInfo)localObject1).systemID = paramFromServiceMsg.uint32_sysid.get();
          if (!paramFromServiceMsg.str_url.has()) {
            break label664;
          }
          paramFromServiceMsg = paramFromServiceMsg.str_url.get();
          ((ReadInJoyUserInfo)localObject1).faceUrl = paramFromServiceMsg;
        }
        if ((!((oidb_cmd0xb81.UserInfoItem)localObject2).account_level_info.has()) || (((oidb_cmd0xb81.UserInfoItem)localObject2).account_level_info.get() == null)) {
          break label682;
        }
        localObject2 = (oidb_cmd0xb81.AccountLevelInfo)((oidb_cmd0xb81.UserInfoItem)localObject2).account_level_info.get();
        ((ReadInJoyUserInfo)localObject1).accountLevel = ((oidb_cmd0xb81.AccountLevelInfo)localObject2).uint32_account_cc_level.get();
        if (!((oidb_cmd0xb81.AccountLevelInfo)localObject2).account_cc_level_icon_s.has()) {
          break label670;
        }
        paramFromServiceMsg = ((oidb_cmd0xb81.AccountLevelInfo)localObject2).account_cc_level_icon_s.get();
        label508:
        ((ReadInJoyUserInfo)localObject1).smallIconUrl = paramFromServiceMsg;
        if (!((oidb_cmd0xb81.AccountLevelInfo)localObject2).account_cc_level_icon_l.has()) {
          break label676;
        }
        paramFromServiceMsg = ((oidb_cmd0xb81.AccountLevelInfo)localObject2).account_cc_level_icon_l.get();
        ((ReadInJoyUserInfo)localObject1).largeIconUrl = paramFromServiceMsg;
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUserInfoModule", 2, "[handle0xb81UserInfo], accountLevel = " + ((ReadInJoyUserInfo)localObject1).accountLevel + ", smallIconUrl = " + ((ReadInJoyUserInfo)localObject1).smallIconUrl + ", largeIconUrl = " + ((ReadInJoyUserInfo)localObject1).largeIconUrl);
        }
      }
      for (;;)
      {
        ((ReadInJoyUserInfo)localObject1).requestFlag = true;
        this.a.a(paramToServiceMsg, (ReadInJoyUserInfo)localObject1, true, true);
        QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "handle0xb81UserInfo succeed, userInfo = ", localObject1 });
        i += 1;
        break label182;
        bool = false;
        break;
        paramFromServiceMsg = "";
        break label328;
        paramFromServiceMsg = "";
        break label434;
        paramFromServiceMsg = "";
        break label508;
        paramFromServiceMsg = "";
        break label534;
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUserInfoModule", 2, "[handle0xb81UserInfo], accountLevelInfo is null.");
        }
      }
      paramObject = (Integer)paramToServiceMsg.getAttributes().get("retry_request_count_key");
      QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "retry_count = ", paramObject, "handle0xb81UserInfo failed." });
      paramFromServiceMsg = (List)paramToServiceMsg.getAttributes().get("user_info_uin_list_key");
      if (paramFromServiceMsg != null)
      {
        QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "accountInfoReqList size = ", Integer.valueOf(paramFromServiceMsg.size()) });
        if (paramFromServiceMsg.size() > 0) {
          QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "retry accountInfoReqList [0] = ", paramFromServiceMsg.get(0) });
        }
      }
      if (paramObject.intValue() < 1)
      {
        paramToServiceMsg.addAttribute("retry_request_count_key", Integer.valueOf(paramObject.intValue() + 1));
        paramToServiceMsg.addAttribute("request_begin_time", Long.valueOf(System.currentTimeMillis()));
        kxm.a("handle0xb81UserInfo", new ReadInJoyUserInfoModule.4(this, paramToServiceMsg), this.mExecutorService);
        label879:
        return;
      }
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
      {
        i = 0;
        if (i < paramFromServiceMsg.size())
        {
          paramToServiceMsg = String.valueOf(((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)paramFromServiceMsg.get(i)).uin);
          if (this.bn == null) {
            break label1095;
          }
          paramObject = new ArrayList();
          localObject1 = (List)this.bn.get(paramToServiceMsg);
          if (localObject1 == null) {
            break label1083;
          }
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            a locala = (a)((Iterator)localObject2).next();
            if (locala != null)
            {
              locala.onLoadUserInfoFailed(paramToServiceMsg, "request0xb81UserInfo result = " + j);
              paramObject.add(locala);
            }
          }
          if (paramObject.size() <= 0) {
            break label1071;
          }
          ((List)localObject1).removeAll(paramObject);
        }
      }
      for (;;)
      {
        this.bo.remove(paramToServiceMsg);
        i += 1;
        break label896;
        break;
        break;
        QLog.d("ReadInJoyUserInfoModule", 1, "handle0xb81UserInfo failed, tempList is null.");
        continue;
        QLog.d("ReadInJoyUserInfoModule", 1, "handle0xb81UserInfo failed, uin callback list is null.");
        continue;
        QLog.d("ReadInJoyUserInfoModule", 1, "handle0xb81UserInfo failed, callback list is null.");
      }
    }
  }
  
  public static String at(long paramLong)
  {
    String str = getDefaultNickName();
    if (paramLong <= 0L) {
      return str;
    }
    if ((eo != null) && (!TextUtils.isEmpty((CharSequence)eo.get(Long.valueOf(paramLong))))) {
      str = (String)eo.get(Long.valueOf(paramLong));
    }
    for (;;)
    {
      return str;
    }
  }
  
  private void b(List<String> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ReadInJoyUserInfoModule", 2, "requestReadInJoyUserInfoWithParams.");
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      AppRuntime localAppRuntime = kxm.getAppRuntime();
      long l = 0L;
      if ((localAppRuntime instanceof QQAppInterface)) {
        if (!((acff)localAppRuntime.getManager(51)).isFriend(str)) {
          break label133;
        }
      }
      label133:
      for (l = 1L;; l = 2L)
      {
        try
        {
          localArrayList.add(new ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.a().a(Long.valueOf(str).longValue()).b(l).a());
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.d("ReadInJoyUserInfoModule", 2, "uin is not a long type.");
        }
        break;
      }
    }
    if (localArrayList.size() <= 0)
    {
      QLog.d("ReadInJoyUserInfoModule", 2, "requestReadInJoyUserInfoWithParams failed, the uinList is empty.");
      return;
    }
    a(new ReadInJoyUserInfoModule.Request0xb81Params.a().a(paramInt1).b(paramInt2).c(paramInt3).a(localArrayList).a());
  }
  
  public static String getDefaultNickName()
  {
    return "";
  }
  
  private ToServiceMsg makeOIDBPkg(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.str_client_version.set(AppSetting.getVersion());
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramString = lup.createToServiceMsg(paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString.setTimeout(30000L);
    return paramString;
  }
  
  public static void np(String paramString)
  {
    QLog.i("ReadInJoyUserInfoModule", 1, "[clearCallbackList], uin = " + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = (QQAppInterface)kxm.getAppRuntime();
      if (localObject != null)
      {
        localObject = (lcd)((QQAppInterface)localObject).getManager(163);
        if (localObject != null)
        {
          localObject = ((lcd)localObject).b().a();
          if ((localObject != null) && (((ReadInJoyUserInfoModule)localObject).f() != null))
          {
            ((ReadInJoyUserInfoModule)localObject).f().remove(paramString);
            QLog.i("ReadInJoyUserInfoModule", 1, "[clearCallbackList] finished.");
          }
        }
      }
    }
  }
  
  public ReadInJoyUserInfo a(String paramString, int paramInt1, int paramInt2, int paramInt3, a parama)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyUserInfoModule", 1, "getSingleReadInJoyUserInfoWithParams uin is null or empty.");
      paramString = null;
    }
    ReadInJoyUserInfo localReadInJoyUserInfo;
    do
    {
      return paramString;
      QLog.d("ReadInJoyUserInfoModule", 1, "load data from 0xb81 userinfo uin" + paramString);
      if (this.a == null) {
        break;
      }
      localReadInJoyUserInfo = this.a.a(paramString);
      if (localReadInJoyUserInfo == null) {
        break;
      }
      paramString = localReadInJoyUserInfo;
    } while (!TextUtils.isEmpty(localReadInJoyUserInfo.nick));
    localReadInJoyUserInfo.nick = getDefaultNickName();
    return localReadInJoyUserInfo;
    if ((parama != null) && (this.bn != null))
    {
      if (this.bn.get(paramString) == null) {
        this.bn.put(paramString, new CopyOnWriteArrayList());
      }
      ((List)this.bn.get(paramString)).add(parama);
    }
    kxm.a("getSingleReadInJoyUserInfoWithParams", new ReadInJoyUserInfoModule.1(this, paramString, paramInt1, paramInt2, paramInt3), this.mExecutorService);
    return null;
  }
  
  public ReadInJoyUserInfo a(String paramString, a parama)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyUserInfoModule", 1, "getSingleReadInJoyUserInfo uin is null or empty.");
      return null;
    }
    return a(paramString, 1, 1, 0, parama);
  }
  
  public lit a()
  {
    return this.a;
  }
  
  public void a(List<String> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (kxm.isInMainThread())
    {
      kxm.a("requestReadInJoyUserInfoWithParamsInSubThread", new ReadInJoyUserInfoModule.3(this, paramList, paramInt1, paramInt2, paramInt3), this.mExecutorService);
      return;
    }
    b(paramList, paramInt1, paramInt2, paramInt3);
  }
  
  public void aEL()
  {
    this.a.clear();
    this.bn.clear();
    this.bo.clear();
    if (eo != null) {
      eo.clear();
    }
  }
  
  public void aMy()
  {
    if (this.a != null) {
      this.a.aMz();
    }
  }
  
  public ConcurrentHashMap<String, List<a>> f()
  {
    return this.bn;
  }
  
  public ConcurrentHashMap<String, Boolean> h()
  {
    return this.bo;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xb81")) {
      aq(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public static class Request0xb81Params
  {
    private int aPo;
    private int aPp;
    private int aPq;
    private List<AccountInfoReq> ih;
    private int nick;
    
    private Request0xb81Params(a parama)
    {
      this.aPo = a.a(parama);
      this.nick = a.b(parama);
      this.aPp = a.c(parama);
      this.aPq = a.d(parama);
      this.ih = a.a(parama);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Request0xb81Params, \nreqClientType = " + this.aPo + '\n' + "nick = " + this.nick + '\n' + "headUrl = " + this.aPp + '\n' + "infoPriority = " + this.aPq + '\n');
      if ((this.ih != null) && (this.ih.size() > 0))
      {
        localStringBuilder.append("accountInfoReqs = \n");
        int i = 0;
        while (i < this.ih.size())
        {
          localStringBuilder.append("[").append(i).append("] ").append(((AccountInfoReq)this.ih.get(i)).toString());
          i += 1;
        }
      }
      return localStringBuilder.toString();
    }
    
    public static class AccountInfoReq
      implements Serializable
    {
      private int accountType;
      private long friendStatus;
      private long uin;
      
      private AccountInfoReq(a parama)
      {
        this.accountType = a.a(parama);
        this.uin = a.a(parama);
        this.friendStatus = a.b(parama);
      }
      
      public String toString()
      {
        return "AccountInfoReq, accountType = " + this.accountType + ", uin = " + this.uin + '\n' + "friendStatus = " + this.friendStatus + '\n';
      }
      
      public static class a
      {
        private int accountType = 1;
        private long friendStatus = 0L;
        private long uin;
        
        public a a(long paramLong)
        {
          this.uin = paramLong;
          return this;
        }
        
        public ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq a()
        {
          return new ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq(this, null);
        }
        
        public a b(long paramLong)
        {
          this.friendStatus = paramLong;
          return this;
        }
      }
    }
    
    public static class a
    {
      private int aPo = 1;
      private int aPp;
      private int aPq;
      private List<ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq> ih;
      private int nick;
      
      public a a(int paramInt)
      {
        this.nick = paramInt;
        return this;
      }
      
      public a a(List<ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq> paramList)
      {
        this.ih = paramList;
        return this;
      }
      
      public ReadInJoyUserInfoModule.Request0xb81Params a()
      {
        return new ReadInJoyUserInfoModule.Request0xb81Params(this, null);
      }
      
      public a b(int paramInt)
      {
        this.aPp = paramInt;
        return this;
      }
      
      public a c(int paramInt)
      {
        this.aPq = paramInt;
        return this;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onLoadUserInfoFailed(String paramString1, String paramString2);
    
    public abstract void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule
 * JD-Core Version:    0.7.0.1
 */