package com.tencent.mobileqq.app;

import KQQ.ProfSmpInfoRes;
import QQService.AddDiscussMemberInfo;
import QQService.DiscussInfo;
import QQService.DiscussMemberInfo;
import QQService.DiscussRespHeader;
import QQService.InteRemarkInfo;
import QQService.RespAddDiscussMember;
import QQService.RespChangeDiscussName;
import QQService.RespCreateDiscuss;
import QQService.RespGetDiscuss;
import QQService.RespGetDiscussInfo;
import QQService.RespGetDiscussInteRemark;
import QQService.RespJoinDiscuss;
import QQService.RespQuitDiscuss;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.discussion.DiscussionReceiver.RespPackage;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.protofile.discuss.FlyTicket.DiscussGetUrlRequest;
import com.tencent.protofile.discuss.FlyTicket.DiscussGetUrlResponse;
import com.tencent.protofile.discuss.FlyTicket.DiscussSigDecodeRequest;
import com.tencent.protofile.discuss.FlyTicket.DiscussSigDecodeResponse;
import com.tencent.protofile.discuss.FlyTicket.RetInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.NewIntent;
import tencent.im.oidb.cmd0x921.cmd0x921.GetAtAllRemain;
import tencent.im.oidb.cmd0x921.cmd0x921.GetAtAllRemainRsp;
import tencent.im.oidb.cmd0x921.cmd0x921.ReqBody;
import tencent.im.oidb.cmd0x921.cmd0x921.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class DiscussionHandler
  extends BusinessHandler
{
  private static final int A = 0;
  private static final int B = 1;
  private static final int C = 0;
  public static final int a = 1000;
  private static final long jdField_a_of_type_Long = 120000L;
  public static final String a = "key_cmd";
  public static final int b = 1001;
  private static final String jdField_b_of_type_JavaLangString = "DiscussionHandler";
  public static final int c = 1002;
  private static final String jdField_c_of_type_JavaLangString = "DiscusstionIconVersion";
  public static final int d = 1003;
  public static final int e = 1004;
  public static final int f = 1005;
  public static final int g = 1006;
  public static final int h = 1007;
  public static final int i = 1008;
  public static final int j = 1009;
  public static final int k = 1010;
  public static final int l = 1011;
  public static final int m = 1012;
  public static final int n = 1013;
  public static final int o = 1014;
  public static final int p = 1015;
  public static final int q = 1016;
  public static final int r = 1017;
  public static final int s = 1018;
  public static final int t = 2000;
  public static final int u = 0;
  public static final int v = 10001;
  public static final int w = 10002;
  public static final int x = 0;
  private static final int y = 1;
  private static final int z = -1;
  private DiscussionIconHelper jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = null;
  private long jdField_c_of_type_Long;
  private String d;
  
  DiscussionHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.c = 0L;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)paramQQAppInterface.a(1));
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper = new DiscussionIconHelper(paramQQAppInterface.a(), this);
  }
  
  private ArrayList a(long paramLong)
  {
    Object localObject = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(String.valueOf(paramLong));
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(Long.valueOf((String)((Map.Entry)((Iterator)localObject).next()).getKey()));
      }
    }
    return localArrayList;
  }
  
  private HashMap a(long paramLong)
  {
    Object localObject = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(String.valueOf(paramLong));
    HashMap localHashMap = new HashMap();
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Map.Entry)((Iterator)localObject).next()).getValue();
        localHashMap.put(Long.valueOf(localDiscussionMemberInfo.memberUin), Integer.valueOf((int)localDiscussionMemberInfo.inteRemarkSource));
      }
    }
    return localHashMap;
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1004);
    localMessageRecord.init(paramLong1, paramLong2, paramLong2, paramString, NetConnInfoCenter.getServerTime(), -1004, 3000, NetConnInfoCenter.getServerTime());
    localMessageRecord.isread = true;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "----------addMsgToDB after analysis friendUin: " + paramLong2 + " msgType: " + -1004 + " friendType: " + 3000 + " msgContent: " + Utils.a(paramString));
    }
    paramString = (MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
    if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, String.valueOf(paramLong1));
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleError serviceCmd:" + str);
    }
    if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(str)) {
      j(paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      return;
      if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(str))
      {
        i(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqGetDiscuss".equalsIgnoreCase(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("ProfileService.GetSimpleInfo".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QRCodeSvc.discuss_geturl".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("QRCodeSvc.discuss_decode".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("QQServiceDiscussSvc.ReqJoinDiscuss".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
    } while (!"OidbSvc.0x921_0".equals(str));
    a(1018, false, new Object[] { paramToServiceMsg.extraData.getString("discUid"), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) });
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0);
  }
  
  private boolean a(String paramString, ArrayList paramArrayList, Map paramMap)
  {
    paramString = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList != null) && (paramMap != null))
    {
      long l1 = System.currentTimeMillis();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        DiscussMemberInfo localDiscussMemberInfo = (DiscussMemberInfo)paramArrayList.next();
        if ((localDiscussMemberInfo.StInteRemark != null) && (!TextUtils.isEmpty(localDiscussMemberInfo.StInteRemark.StrValue)))
        {
          String str = String.valueOf(localDiscussMemberInfo.Uin);
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramMap.get(str);
          if (localDiscussionMemberInfo == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("DiscussionHandler", 2, "warning dbMemberInfo is null uin=" + str);
            }
          }
          else if ((!TextUtils.isEmpty(localDiscussionMemberInfo.memberUin)) && (localDiscussionMemberInfo.memberUin.equals(str)) && (!TextUtils.isEmpty(localDiscussionMemberInfo.inteRemark)) && (!localDiscussionMemberInfo.inteRemark.equals(localDiscussMemberInfo.StInteRemark.StrValue)))
          {
            localDiscussionMemberInfo.dataTime = l1;
            localDiscussionMemberInfo.inteRemark = localDiscussMemberInfo.StInteRemark.StrValue;
            localDiscussionMemberInfo.inteRemarkSource = localDiscussMemberInfo.StInteRemark.Source;
            localArrayList.add(localDiscussionMemberInfo);
          }
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (localArrayList.size() > 0) {
        paramString.b(localArrayList);
      }
      return bool;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("discussionUin");
    if ((paramToServiceMsg.extraData.getInt("type") != 3000) || (paramFromServiceMsg == null)) {
      return;
    }
    a(1006, false, paramFromServiceMsg);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1004, false, String.valueOf(paramToServiceMsg.extraData.getLong("discussUin")));
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.extraData.getString("signature") != null) {
      return;
    }
    paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("discussUin"));
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramToServiceMsg);
    this.d = "";
    if (a()) {
      a();
    }
    for (;;)
    {
      a(1001, false, new Object[] { String.valueOf(paramToServiceMsg), Boolean.valueOf(false) });
      return;
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1000, false, null);
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1002, false, Long.valueOf(-1L));
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1005, false, String.valueOf(paramToServiceMsg.extraData.getLong("discussUin")));
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1003, false, new Object[] { String.valueOf(paramToServiceMsg.extraData.getLong("discussUin")), null });
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleTimeOut serviceCmd:" + str);
    }
    if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(str)) {
      z(paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      return;
      if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(str))
      {
        y(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(str))
      {
        x(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqGetDiscuss".equalsIgnoreCase(str))
      {
        w(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(str))
      {
        v(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(str))
      {
        u(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(str))
      {
        t(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(str))
      {
        s(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("ProfileService.GetSimpleInfo".equals(str))
      {
        r(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QRCodeSvc.discuss_geturl".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("QRCodeSvc.discuss_decode".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("QQServiceDiscussSvc.ReqJoinDiscuss".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("OidbSvc.0x865_3".equals(str))
      {
        o(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x870_4".equals(str))
      {
        q(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x870_5".equals(str))
      {
        p(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (!"OidbSvc.0x921_0".equals(str));
    a(1018, false, new Object[] { paramToServiceMsg.extraData.getString("discUid"), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) });
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("dwDelMemberUin");
    a(1015, false, new long[] { Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin")).longValue(), Long.valueOf(l1).longValue() });
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1017, false, Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin")));
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1016, false, Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin")));
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    l(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    m(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    n(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    e(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = (DiscussionReceiver.RespPackage)paramObject;
    paramObject = (RespGetDiscussInteRemark)paramToServiceMsg.b;
    long l1 = paramObject.DiscussUin;
    Object localObject1 = (DiscussRespHeader)paramToServiceMsg.jdField_a_of_type_JavaLangObject;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleGetDiscussInteRemarkResp header.Result" + ((DiscussRespHeader)localObject1).Result);
    }
    if (((DiscussRespHeader)localObject1).Result != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("DiscussionHandler", 2, "header failed code: " + ((DiscussRespHeader)localObject1).Result);
      }
      a(1010, false, Long.valueOf(l1));
    }
    do
    {
      return;
      if ((!paramFromServiceMsg.isSuccess()) || (!paramToServiceMsg.jdField_a_of_type_Boolean))
      {
        a(1010, false, Long.valueOf(l1));
        return;
      }
      paramToServiceMsg = paramObject.InteRemarks;
      paramFromServiceMsg = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
      paramObject = paramFromServiceMsg.a(String.valueOf(l1));
    } while ((paramToServiceMsg == null) || (paramObject == null));
    paramToServiceMsg.keySet();
    localObject1 = paramToServiceMsg.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Long)((Iterator)localObject1).next();
      DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramObject.get(String.valueOf(localObject2));
      if (localDiscussionMemberInfo != null)
      {
        localObject2 = (InteRemarkInfo)paramToServiceMsg.get(localObject2);
        localDiscussionMemberInfo.inteRemark = ((InteRemarkInfo)localObject2).StrValue;
        localDiscussionMemberInfo.inteRemarkSource = ((InteRemarkInfo)localObject2).Source;
        paramFromServiceMsg.a(localDiscussionMemberInfo);
      }
    }
    a(1010, true, Long.valueOf(l1));
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("discUid");
    paramToServiceMsg = new Object[4];
    paramToServiceMsg[0] = paramFromServiceMsg;
    paramToServiceMsg[1] = Boolean.valueOf(false);
    paramToServiceMsg[2] = Integer.valueOf(0);
    paramToServiceMsg[3] = Integer.valueOf(0);
    Object localObject = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
      if ((paramObject == null) || (!paramObject.uint32_result.has()) || (paramObject.uint32_result.get() != 0) || (!paramObject.bytes_bodybuffer.has()) || (paramObject.bytes_bodybuffer.get() == null))
      {
        a(1018, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(1018, false, paramToServiceMsg);
      return;
    }
    localObject = new cmd0x921.RspBody();
    for (;;)
    {
      try
      {
        ((cmd0x921.RspBody)localObject).mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        boolean bool = ((cmd0x921.RspBody)localObject).msg_get_at_all_remain.bool_priviledge.get();
        if (!((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_uin_remain.has()) {
          break label290;
        }
        i1 = ((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_uin_remain.get();
        if (((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_discuss_uin_remain.has())
        {
          i2 = ((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_discuss_uin_remain.get();
          a(1018, true, new Object[] { paramFromServiceMsg, Boolean.valueOf(bool), Integer.valueOf(i1), Integer.valueOf(i2) });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        a(1018, false, paramToServiceMsg);
        return;
      }
      int i2 = 0;
      continue;
      label290:
      int i1 = 0;
    }
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    e(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    f(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    g(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    h(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    i(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i1 < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i1 + 1);
      a(paramToServiceMsg);
      return;
    }
    j(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public Bitmap a(String paramString)
  {
    int i2 = 5;
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    float f1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().density;
    int i4 = (int)(117.0F * f1);
    paramString = paramString.split(";");
    int i1;
    if (paramString.length <= 1)
    {
      i1 = (int)(f1 * 117.0F);
      if (paramString.length <= 5) {
        break label144;
      }
    }
    Bitmap[] arrayOfBitmap;
    for (;;)
    {
      arrayOfBitmap = new Bitmap[i2];
      int i3 = 0;
      while (i3 < i2)
      {
        arrayOfBitmap[i3] = ((Bitmap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString[i3], i1, i1).second);
        i3 += 1;
      }
      if (paramString.length <= 4)
      {
        i1 = (int)(f1 * 53.0F);
        break;
      }
      i1 = (int)(f1 * 34.0F);
      break;
      label144:
      i2 = paramString.length;
    }
    try
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.a(i4, arrayOfBitmap);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) || (paramBoolean))
    {
      try
      {
        return ImageUtil.d();
      }
      catch (Throwable paramString)
      {
        Bitmap localBitmap;
        if (!QLog.isColorLevel()) {
          break label82;
        }
        QLog.e("DiscussionHandler", 2, "getDiscussionFaceIcon error", paramString);
        return null;
        paramString = null;
      }
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(101, paramString, (byte)1, false, (byte)1);
      if (localBitmap == null)
      {
        a(paramString, true);
        if (paramBoolean) {
          return ImageUtil.d();
        }
      }
      else
      {
        a(paramString, false);
        return localBitmap;
      }
    }
    label82:
    return null;
    return paramString;
  }
  
  public Drawable a(String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    Bitmap localBitmap = a(paramString, paramBoolean);
    paramString = localObject;
    if (localBitmap != null) {
      paramString = new BitmapDrawable(localBitmap);
    }
    return paramString;
  }
  
  public DiscussionIconHelper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper;
  }
  
  public FriendListHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  }
  
  public Friends a(String paramString, long paramLong)
  {
    Friends localFriends = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(paramString);
    if (localFriends == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(paramString, 3000, paramLong);
    }
    return localFriends;
  }
  
  protected Class a()
  {
    return DiscussionObserver.class;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
      {
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      long l1 = ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(0)).longValue();
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "startGetDiscussionInfoWork" + l1);
      }
      this.d = String.valueOf(l1);
      ??? = a("QQServiceDiscussSvc.ReqGetDiscussInfo");
      ((ToServiceMsg)???).extraData.putLong("discussUin", l1);
      DiscussionInfo localDiscussionInfo = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(l1 + "");
      if (localDiscussionInfo != null)
      {
        ((ToServiceMsg)???).extraData.putLong("InteRemarkTimeStamp", localDiscussionInfo.timeSec);
        ((ToServiceMsg)???).extraData.putLong("infoSeq", localDiscussionInfo.infoSeq);
      }
      ((ToServiceMsg)???).addAttribute("inteRemarkUinMap", a(l1));
      a((ToServiceMsg)???);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "getDiscussInfo" + paramLong);
    }
    if (a(paramLong)) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (!this.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong))) {
          this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramLong));
        }
        if (!this.jdField_a_of_type_Boolean) {
          a();
        }
        return;
      }
    }
    a(1001, false, new Object[] { String.valueOf(paramLong), Boolean.valueOf(false) });
  }
  
  public void a(long paramLong, byte paramByte)
  {
    ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqSetDiscussFlag");
    localToServiceMsg.extraData.putLong("discussUin", paramLong);
    localToServiceMsg.extraData.putByte("flag", paramByte);
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "--->>set discuss flag uin: " + paramLong + " req: " + localToServiceMsg);
    }
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, int paramInt)
  {
    a(paramLong, new int[] { 0 }, new int[] { paramInt });
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2149);
    localOIDBSSOPkg.uint32_service_type.set(3);
    Object localObject = ByteBuffer.allocate(20);
    ((ByteBuffer)localObject).putInt(Utils.a(paramLong1)).putShort((short)1).putInt(Utils.a(paramLong2));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x865_3");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("dwConfUin", paramLong1);
    ((ToServiceMsg)localObject).extraData.putShort("wUinNum", (short)1);
    ((ToServiceMsg)localObject).extraData.putLong("dwDelMemberUin", paramLong2);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, String paramString)
  {
    if (paramString != null)
    {
      ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqChangeDiscussName");
      localToServiceMsg.extraData.putLong("discussUin", paramLong);
      localToServiceMsg.extraData.putString("newName", paramString);
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "--->>change discuss name uin: " + paramLong + " req: " + localToServiceMsg);
      }
      a(localToServiceMsg);
    }
  }
  
  public void a(long paramLong, String paramString, List paramList, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("notifyMemberChange disUin=").append(paramLong).append(" cmdUin=").append(paramString).append(" opType=").append(paramInt).append(" uinsize=");
      if (paramList != null) {
        break label75;
      }
    }
    label75:
    for (paramInt = -1;; paramInt = paramList.size())
    {
      QLog.d("DiscussionHandler", 2, paramInt);
      return;
    }
  }
  
  public void a(long paramLong, ArrayList paramArrayList)
  {
    if (a(paramLong))
    {
      ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqAddDiscussMember");
      localToServiceMsg.extraData.putLong("discussUin", paramLong);
      int i2 = paramArrayList.size();
      long[] arrayOfLong1 = new long[i2];
      int[] arrayOfInt = new int[i2];
      long[] arrayOfLong2 = new long[i2];
      String[] arrayOfString = new String[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfLong1[i1] = ((AddDiscussMemberInfo)paramArrayList.get(i1)).Uin;
        arrayOfInt[i1] = ((AddDiscussMemberInfo)paramArrayList.get(i1)).Type;
        arrayOfLong2[i1] = ((AddDiscussMemberInfo)paramArrayList.get(i1)).RefUin;
        arrayOfString[i1] = ((AddDiscussMemberInfo)paramArrayList.get(i1)).RefStr;
        i1 += 1;
      }
      localToServiceMsg.extraData.putLongArray("uin", arrayOfLong1);
      localToServiceMsg.extraData.putIntArray("type", arrayOfInt);
      localToServiceMsg.extraData.putLongArray("refUin", arrayOfLong2);
      localToServiceMsg.extraData.putStringArray("refStr", arrayOfString);
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "--->>add discuss member uin: " + paramLong + " req: " + localToServiceMsg);
      }
      a(localToServiceMsg);
      return;
    }
    a(1003, false, new Object[] { String.valueOf(paramLong), null });
  }
  
  public void a(long paramLong, List paramList)
  {
    if (a(paramLong))
    {
      ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqGetDiscussInteRemark");
      localToServiceMsg.extraData.putLong("discussUin", paramLong);
      localToServiceMsg.addAttribute("inteRemarkUinList", paramList);
      a(localToServiceMsg);
      return;
    }
    a(1010, false, Long.valueOf(paramLong));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_b_of_type_Long < 120000L)) {
      return;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    ToServiceMsg localToServiceMsg = a("QRCodeSvc.discuss_geturl");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    localToServiceMsg.extraData.putLong("discussUin", paramLong);
    FlyTicket.DiscussGetUrlRequest localDiscussGetUrlRequest = new FlyTicket.DiscussGetUrlRequest();
    localDiscussGetUrlRequest.conf_uin.set((int)paramLong);
    localDiscussGetUrlRequest.is_need_long_link.set(paramBoolean);
    localToServiceMsg.putWupBuffer(localDiscussGetUrlRequest.toByteArray());
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqSetDiscussAttr");
    localToServiceMsg.extraData.putLong("discussUin", paramLong);
    localToServiceMsg.extraData.putIntArray("infoType", paramArrayOfInt1);
    localToServiceMsg.extraData.putIntArray("attrType", paramArrayOfInt2);
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "--->>set discuss attr uin: " + paramLong + " req: " + localToServiceMsg);
    }
    a(localToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (c(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "cmdfilter error=" + str);
      }
    }
    do
    {
      return;
      if (paramFromServiceMsg.getResultCode() == 1002)
      {
        k(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(str))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(str))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(str))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqGetDiscuss".equalsIgnoreCase(str))
      {
        n(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(str))
      {
        if (paramToServiceMsg.extraData.getString("signature") != null)
        {
          g(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        m(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(str))
      {
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(str))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(str))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("ProfileService.GetSimpleInfo".equals(paramFromServiceMsg.getServiceCmd()))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqGetDiscussInteRemark".equalsIgnoreCase(str))
      {
        r(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QRCodeSvc.discuss_geturl".equalsIgnoreCase(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QRCodeSvc.discuss_decode".equalsIgnoreCase(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqJoinDiscuss".equalsIgnoreCase(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x865_3".equalsIgnoreCase(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x870_4".equalsIgnoreCase(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x870_5".equalsIgnoreCase(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x921_0".equalsIgnoreCase(str));
    s(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.e(paramString);
    ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 3000);
    a(1004, true, paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.c > 0L) && (System.currentTimeMillis() - this.c < 120000L)) {
      return;
    }
    this.c = System.currentTimeMillis();
    ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqJoinDiscuss");
    localToServiceMsg.extraData.putString("signature", paramString);
    localToServiceMsg.extraData.putInt(ScannerActivity.t, paramInt);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2)
  {
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
    DiscussionInfo localDiscussionInfo = localDiscussionManager.a(paramString1);
    if (localDiscussionInfo != null)
    {
      localDiscussionInfo.discussionName = paramString2;
      localDiscussionInfo.DiscussionFlag &= 0xFFFFFFBF;
      localDiscussionManager.a(localDiscussionInfo);
      a(1005, true, paramString1);
    }
  }
  
  public void a(String paramString, ArrayList paramArrayList, int paramInt)
  {
    if ((paramString != null) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqCreateDiscuss");
      int i2 = paramArrayList.size();
      long[] arrayOfLong1 = new long[i2];
      int[] arrayOfInt = new int[i2];
      long[] arrayOfLong2 = new long[i2];
      String[] arrayOfString = new String[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfLong1[i1] = ((AddDiscussMemberInfo)paramArrayList.get(i1)).Uin;
        arrayOfInt[i1] = ((AddDiscussMemberInfo)paramArrayList.get(i1)).Type;
        arrayOfLong2[i1] = ((AddDiscussMemberInfo)paramArrayList.get(i1)).RefUin;
        arrayOfString[i1] = ((AddDiscussMemberInfo)paramArrayList.get(i1)).RefStr;
        i1 += 1;
      }
      localToServiceMsg.extraData.putLongArray("uin", arrayOfLong1);
      localToServiceMsg.extraData.putIntArray("type", arrayOfInt);
      localToServiceMsg.extraData.putLongArray("refUin", arrayOfLong2);
      localToServiceMsg.extraData.putStringArray("refStr", arrayOfString);
      localToServiceMsg.extraData.putString("name", paramString);
      localToServiceMsg.extraData.putInt("from", paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "--->>create discuss name: " + paramString + " req: " + localToServiceMsg);
      }
      a(localToServiceMsg);
    }
  }
  
  public void a(String paramString, HashSet paramHashSet)
  {
    if ((paramString == null) || (paramHashSet == null) || (paramHashSet.size() == 0)) {
      return;
    }
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
    DiscussionInfo localDiscussionInfo = localDiscussionManager.a(paramString);
    if (localDiscussionInfo != null) {
      localDiscussionInfo.DiscussionFlag |= 0x20000000;
    }
    localDiscussionManager.a(paramString, paramHashSet);
    a(1001, true, new Object[] { paramString, Boolean.valueOf(true) });
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b())
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.b(paramString);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.c(paramString);
      return;
    }
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    paramString = new Pair(Boolean.valueOf(paramBoolean), paramString);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramString);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    a(1007, paramBoolean1, Pair.create(Boolean.valueOf(paramBoolean2), paramString));
  }
  
  public void a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), DiscussionServlet.class);
    localNewIntent.putExtra("key_cmd", 0);
    localNewIntent.putExtra("field_id", paramArrayOfString1);
    localNewIntent.putExtra("uin_list", paramArrayOfString2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public boolean a(long paramLong)
  {
    return paramLong > 1000000L;
  }
  
  public boolean a(String paramString)
  {
    return (this.d != null) && (this.d.equals(paramString));
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("addOrUpdateDiscussion ");
      if (paramArrayList == null) {
        break label57;
      }
    }
    long l1;
    label57:
    for (int i1 = paramArrayList.size();; i1 = -1)
    {
      QLog.d("Q.contacttab.dscs", 2, i1);
      l1 = System.currentTimeMillis();
      if (paramArrayList != null) {
        break;
      }
      return true;
    }
    Object localObject2;
    DiscussionManager localDiscussionManager;
    DiscussionInfo localDiscussionInfo;
    try
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      localObject1 = "DiscusstionIconVersion" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      i1 = ((SharedPreferences)localObject2).getInt((String)localObject1, -1);
      DiscussInfo localDiscussInfo;
      if (i1 != 1)
      {
        localObject2 = ((SharedPreferences)localObject2).edit();
        ((SharedPreferences.Editor)localObject2).putInt((String)localObject1, 1);
        ((SharedPreferences.Editor)localObject2).commit();
        if (i1 != -1) {
          try
          {
            localObject1 = new String[2];
            localObject1[0] = AppConstants.aC;
            localObject1[1] = (SystemUtil.a + "head/_hd/");
            int i3 = localObject1.length;
            i1 = 0;
            while (i1 < i3)
            {
              localObject2 = new File(localObject1[i1]);
              if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
              {
                localObject2 = ((File)localObject2).listFiles();
                int i4 = localObject2.length;
                int i2 = 0;
                while (i2 < i4)
                {
                  localDiscussInfo = localObject2[i2];
                  if (localDiscussInfo.getName().startsWith("discussion_"))
                  {
                    localDiscussInfo.delete();
                    if (QLog.isColorLevel()) {
                      QLog.d("DiscussionHandler", 2, "del discussion icon. name=" + localDiscussInfo.getName() + "," + localDiscussInfo.lastModified());
                    }
                  }
                  i2 += 1;
                }
              }
              i1 += 1;
            }
            localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
      localObject2 = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      for (;;)
      {
        if (!paramArrayList.hasNext()) {
          break label527;
        }
        localDiscussInfo = (DiscussInfo)paramArrayList.next();
        localDiscussionInfo = localDiscussionManager.a(String.valueOf(localDiscussInfo.DiscussUin));
        if (localDiscussionInfo != null) {
          break;
        }
        localDiscussionInfo = new DiscussionInfo();
        localDiscussionInfo.uin = String.valueOf(localDiscussInfo.DiscussUin);
        localDiscussionInfo.infoSeq = -1L;
        localDiscussionInfo.timeSec = l1;
        a(Long.parseLong(localDiscussionInfo.uin));
        ((ArrayList)localObject2).add(localDiscussionInfo);
      }
      if (localDiscussionInfo.infoSeq == localDiscussInfo.InfoSeq) {
        break label516;
      }
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
      return false;
    }
    a(Long.parseLong(localDiscussionInfo.uin));
    for (;;)
    {
      localDiscussionInfo.timeSec = l1;
      break;
      label516:
      ((ArrayList)localObject2).add(localDiscussionInfo);
    }
    label527:
    boolean bool = localDiscussionManager.a((ArrayList)localObject2, l1);
    return bool;
  }
  
  public boolean a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("addOrUpdateDiscussionWithCollectData ");
      if (paramArrayList1 == null) {
        break label57;
      }
    }
    long l1;
    label57:
    for (int i1 = paramArrayList1.size();; i1 = -1)
    {
      QLog.d("Q.contacttab.dscs", 2, i1);
      l1 = System.currentTimeMillis();
      if (paramArrayList1 != null) {
        break;
      }
      return true;
    }
    Object localObject2;
    DiscussInfo localDiscussInfo;
    DiscussionManager localDiscussionManager;
    DiscussionInfo localDiscussionInfo;
    for (;;)
    {
      try
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        localObject1 = "DiscusstionIconVersion" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        i1 = ((SharedPreferences)localObject2).getInt((String)localObject1, -1);
        if (i1 != 1)
        {
          localObject2 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject2).putInt((String)localObject1, 1);
          ((SharedPreferences.Editor)localObject2).commit();
          if (i1 != -1) {
            try
            {
              localObject1 = new String[2];
              localObject1[0] = AppConstants.aC;
              localObject1[1] = (SystemUtil.a + "head/_hd/");
              int i3 = localObject1.length;
              i1 = 0;
              if (i1 < i3)
              {
                localObject2 = new File(localObject1[i1]);
                if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
                {
                  localObject2 = ((File)localObject2).listFiles();
                  int i4 = localObject2.length;
                  int i2 = 0;
                  if (i2 < i4)
                  {
                    localDiscussInfo = localObject2[i2];
                    if (localDiscussInfo.getName().startsWith("discussion_"))
                    {
                      localDiscussInfo.delete();
                      if (QLog.isColorLevel()) {
                        QLog.d("DiscussionHandler", 2, "del discussion icon. name=" + localDiscussInfo.getName() + "," + localDiscussInfo.lastModified());
                      }
                    }
                    i2 += 1;
                    continue;
                  }
                }
                i1 += 1;
                continue;
              }
              localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
        localObject2 = new ArrayList();
        paramArrayList1 = paramArrayList1.iterator();
        if (!paramArrayList1.hasNext()) {
          break label592;
        }
        localDiscussInfo = (DiscussInfo)paramArrayList1.next();
        localDiscussionInfo = localDiscussionManager.a(String.valueOf(localDiscussInfo.DiscussUin));
        if (localDiscussionInfo != null) {
          break;
        }
        localDiscussionInfo = new DiscussionInfo();
        localDiscussionInfo.uin = String.valueOf(localDiscussInfo.DiscussUin);
        localDiscussionInfo.infoSeq = -1L;
        localDiscussionInfo.timeSec = l1;
        if (paramArrayList2.contains(Long.valueOf(localDiscussInfo.DiscussUin)))
        {
          localDiscussionInfo.hasCollect = true;
          a(Long.parseLong(localDiscussionInfo.uin));
          ((ArrayList)localObject2).add(localDiscussionInfo);
        }
        else
        {
          localDiscussionInfo.hasCollect = false;
        }
      }
      catch (Exception paramArrayList1)
      {
        paramArrayList1.printStackTrace();
        return false;
      }
    }
    if (paramArrayList2.contains(Long.valueOf(localDiscussInfo.DiscussUin)))
    {
      localDiscussionInfo.hasCollect = true;
      label536:
      if (localDiscussionInfo.infoSeq == localDiscussInfo.InfoSeq) {
        break label581;
      }
      a(Long.parseLong(localDiscussionInfo.uin));
    }
    for (;;)
    {
      localDiscussionInfo.timeSec = l1;
      break;
      localDiscussionInfo.hasCollect = false;
      break label536;
      label581:
      ((ArrayList)localObject2).add(localDiscussionInfo);
    }
    label592:
    boolean bool = localDiscussionManager.a((ArrayList)localObject2, l1);
    return bool;
  }
  
  public void b()
  {
    a(1000, true, null);
  }
  
  public void b(long paramLong)
  {
    if (((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(paramLong + "") == null) {
      a(paramLong);
    }
  }
  
  /* Error */
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 22
    //   8: iconst_2
    //   9: ldc_w 1102
    //   12: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_2
    //   16: invokevirtual 524	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   19: ifeq +392 -> 411
    //   22: aload_3
    //   23: ifnull +388 -> 411
    //   26: iconst_1
    //   27: istore 7
    //   29: aload_1
    //   30: getfield 338	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   33: ldc_w 475
    //   36: invokevirtual 420	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   39: invokestatic 425	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   42: astore_2
    //   43: aload_1
    //   44: getfield 338	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   47: ldc_w 477
    //   50: invokevirtual 420	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   53: invokestatic 425	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   56: astore_1
    //   57: iload 7
    //   59: istore 6
    //   61: iload 7
    //   63: ifeq +389 -> 452
    //   66: new 539	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   69: dup
    //   70: invokespecial 540	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   73: astore 12
    //   75: aload 12
    //   77: aload_3
    //   78: checkcast 542	[B
    //   81: checkcast 542	[B
    //   84: invokevirtual 546	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   87: pop
    //   88: aload 12
    //   90: getfield 550	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   93: invokevirtual 557	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   96: istore 4
    //   98: iload 4
    //   100: ifne +317 -> 417
    //   103: iconst_1
    //   104: istore 6
    //   106: aload_1
    //   107: invokevirtual 480	java/lang/Long:longValue	()J
    //   110: lstore 8
    //   112: aload_2
    //   113: invokevirtual 480	java/lang/Long:longValue	()J
    //   116: lstore 10
    //   118: aload_0
    //   119: getfield 116	com/tencent/mobileqq/app/DiscussionHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   122: bipush 8
    //   124: invokevirtual 120	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   127: checkcast 1104	com/tencent/mobileqq/app/FriendsManagerImp
    //   130: aload_1
    //   131: invokestatic 439	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   134: aload_2
    //   135: invokestatic 439	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   138: invokevirtual 1107	com/tencent/mobileqq/app/FriendsManagerImp:d	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   141: astore_3
    //   142: aload_0
    //   143: getfield 116	com/tencent/mobileqq/app/DiscussionHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   146: invokevirtual 606	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   149: ldc_w 1108
    //   152: iconst_1
    //   153: anewarray 332	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: aload_3
    //   159: aastore
    //   160: invokevirtual 1111	com/tencent/qphone/base/util/BaseApplication:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   163: astore_3
    //   164: aload_0
    //   165: aload_0
    //   166: getfield 116	com/tencent/mobileqq/app/DiscussionHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   169: invokevirtual 106	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   172: invokestatic 1084	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   175: aload_1
    //   176: invokevirtual 480	java/lang/Long:longValue	()J
    //   179: aload_1
    //   180: invokevirtual 480	java/lang/Long:longValue	()J
    //   183: aload_3
    //   184: invokespecial 1113	com/tencent/mobileqq/app/DiscussionHandler:a	(JJJLjava/lang/String;)V
    //   187: aload_0
    //   188: getfield 116	com/tencent/mobileqq/app/DiscussionHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   191: bipush 48
    //   193: invokevirtual 120	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   196: checkcast 122	com/tencent/mobileqq/app/DiscussionManager
    //   199: aload_1
    //   200: invokestatic 439	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   203: invokevirtual 702	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   206: astore_3
    //   207: aload_3
    //   208: ifnull +276 -> 484
    //   211: aload_3
    //   212: getfield 1116	com/tencent/mobileqq/data/DiscussionInfo:faceUinSet	Ljava/lang/String;
    //   215: astore 12
    //   217: aload 12
    //   219: ifnull +265 -> 484
    //   222: aload 12
    //   224: invokevirtual 1119	java/lang/String:trim	()Ljava/lang/String;
    //   227: ldc_w 430
    //   230: invokevirtual 313	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   233: ifne +251 -> 484
    //   236: aload 12
    //   238: ldc_w 627
    //   241: invokevirtual 631	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   244: astore 12
    //   246: aload 12
    //   248: ifnull +236 -> 484
    //   251: aload 12
    //   253: arraylength
    //   254: istore 5
    //   256: iconst_0
    //   257: istore 4
    //   259: iload 4
    //   261: iload 5
    //   263: if_icmpge +221 -> 484
    //   266: aload 12
    //   268: iload 4
    //   270: aaload
    //   271: aload_2
    //   272: invokestatic 439	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   275: invokevirtual 313	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   278: ifeq +197 -> 475
    //   281: iconst_1
    //   282: istore 4
    //   284: aload_1
    //   285: invokestatic 439	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   288: astore 12
    //   290: new 955	java/util/HashSet
    //   293: dup
    //   294: invokespecial 1120	java/util/HashSet:<init>	()V
    //   297: astore 13
    //   299: aload 13
    //   301: new 219	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   308: aload_2
    //   309: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   312: ldc_w 430
    //   315: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokevirtual 1121	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   324: pop
    //   325: aload_0
    //   326: aload 12
    //   328: aload 13
    //   330: invokevirtual 1123	com/tencent/mobileqq/app/DiscussionHandler:a	(Ljava/lang/String;Ljava/util/HashSet;)V
    //   333: new 79	java/util/ArrayList
    //   336: dup
    //   337: invokespecial 82	java/util/ArrayList:<init>	()V
    //   340: astore 12
    //   342: aload 12
    //   344: aload_2
    //   345: invokestatic 439	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   348: invokeinterface 402 2 0
    //   353: pop
    //   354: aload_0
    //   355: aload_1
    //   356: invokevirtual 480	java/lang/Long:longValue	()J
    //   359: aload_0
    //   360: getfield 116	com/tencent/mobileqq/app/DiscussionHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   363: invokevirtual 106	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   366: aload 12
    //   368: iconst_2
    //   369: invokevirtual 1125	com/tencent/mobileqq/app/DiscussionHandler:a	(JLjava/lang/String;Ljava/util/List;I)V
    //   372: iload 4
    //   374: ifeq +14 -> 388
    //   377: aload_0
    //   378: getfield 111	com/tencent/mobileqq/app/DiscussionHandler:jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper	Lcom/tencent/mobileqq/app/DiscussionIconHelper;
    //   381: aload_3
    //   382: getfield 1081	com/tencent/mobileqq/data/DiscussionInfo:uin	Ljava/lang/String;
    //   385: invokevirtual 1127	com/tencent/mobileqq/app/DiscussionIconHelper:d	(Ljava/lang/String;)V
    //   388: aload_0
    //   389: sipush 1015
    //   392: iload 6
    //   394: iconst_2
    //   395: newarray long
    //   397: dup
    //   398: iconst_0
    //   399: lload 8
    //   401: lastore
    //   402: dup
    //   403: iconst_1
    //   404: lload 10
    //   406: lastore
    //   407: invokevirtual 353	com/tencent/mobileqq/app/DiscussionHandler:a	(IZLjava/lang/Object;)V
    //   410: return
    //   411: iconst_0
    //   412: istore 7
    //   414: goto -385 -> 29
    //   417: iconst_0
    //   418: istore 6
    //   420: goto -314 -> 106
    //   423: astore_3
    //   424: iconst_0
    //   425: istore 7
    //   427: iload 7
    //   429: istore 6
    //   431: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +18 -> 452
    //   437: ldc_w 1129
    //   440: iconst_2
    //   441: aload_3
    //   442: invokevirtual 1132	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   445: invokestatic 521	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   448: iload 7
    //   450: istore 6
    //   452: goto -346 -> 106
    //   455: astore_3
    //   456: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq -272 -> 187
    //   462: ldc 22
    //   464: iconst_2
    //   465: ldc_w 1134
    //   468: aload_3
    //   469: invokestatic 1136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   472: goto -285 -> 187
    //   475: iload 4
    //   477: iconst_1
    //   478: iadd
    //   479: istore 4
    //   481: goto -222 -> 259
    //   484: iconst_0
    //   485: istore 4
    //   487: goto -203 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	this	DiscussionHandler
    //   0	490	1	paramToServiceMsg	ToServiceMsg
    //   0	490	2	paramFromServiceMsg	FromServiceMsg
    //   0	490	3	paramObject	Object
    //   96	390	4	i1	int
    //   254	10	5	i2	int
    //   59	392	6	bool1	boolean
    //   27	422	7	bool2	boolean
    //   110	290	8	l1	long
    //   116	289	10	l2	long
    //   73	294	12	localObject	Object
    //   297	32	13	localHashSet	HashSet
    // Exception table:
    //   from	to	target	type
    //   66	98	423	java/lang/Exception
    //   164	187	455	java/lang/NumberFormatException
  }
  
  public void b(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("QRCodeSvc.discuss_decode");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    localToServiceMsg.extraData.putString("signature", paramString);
    FlyTicket.DiscussSigDecodeRequest localDiscussSigDecodeRequest = new FlyTicket.DiscussSigDecodeRequest();
    localDiscussSigDecodeRequest.sig.set(paramString);
    localToServiceMsg.putWupBuffer(localDiscussSigDecodeRequest.toByteArray());
    a(localToServiceMsg);
  }
  
  public void b(String paramString1, String paramString2)
  {
    cmd0x921.ReqBody localReqBody = new cmd0x921.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    try
    {
      cmd0x921.GetAtAllRemain localGetAtAllRemain = new cmd0x921.GetAtAllRemain();
      localGetAtAllRemain.uint64_uin.set(Long.parseLong(paramString1));
      localGetAtAllRemain.uint64_discuss_uin.set(Long.parseLong(paramString2));
      localReqBody.msg_get_at_all_remain.set(localGetAtAllRemain);
      paramString1 = a("OidbSvc.0x921_0", 2337, 0, localReqBody.toByteArray());
      paramString1.extraData.putString("discUid", paramString2);
      b(paramString1);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("DiscussionHandler", 2, "getAnonymousChatNick error, NumberFormatException, uin : " + paramString1 + ", discUin : " + paramString2);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.b();
    }
    super.c();
  }
  
  public void c(long paramLong)
  {
    if (a(paramLong)) {
      a(paramLong, a(paramLong));
    }
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleCollectDisucssionResp");
    }
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin"));
      if (!bool1) {
        break label193;
      }
    }
    label193:
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = bool3;
        if (bool1)
        {
          paramFromServiceMsg = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
          paramObject = paramFromServiceMsg.a(String.valueOf(paramToServiceMsg));
          if (paramObject != null)
          {
            long l1 = System.currentTimeMillis();
            paramObject.hasCollect = true;
            paramObject.timeSec = l1;
            paramFromServiceMsg.a(paramObject);
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("handleCollectDisucssionResp", 2, paramFromServiceMsg.getMessage());
        bool1 = bool2;
        continue;
      }
      a(1016, bool1, paramToServiceMsg);
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  public void c(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqGetDiscussInfo");
    localToServiceMsg.extraData.putString("signature", paramString);
    a(localToServiceMsg);
  }
  
  protected boolean c(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqAddDiscussMember");
      this.jdField_a_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqChangeDiscussName");
      this.jdField_a_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqCreateDiscuss");
      this.jdField_a_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqGetDiscuss");
      this.jdField_a_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqGetDiscussInfo");
      this.jdField_a_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqQuitDiscuss");
      this.jdField_a_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqSetDiscussAttr");
      this.jdField_a_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqSetDiscussFlag");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.GetSimpleInfo");
      this.jdField_a_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqGetDiscussInteRemark");
      this.jdField_a_of_type_JavaUtilSet.add("QRCodeSvc.discuss_geturl");
      this.jdField_a_of_type_JavaUtilSet.add("QRCodeSvc.discuss_decode");
      this.jdField_a_of_type_JavaUtilSet.add("QQServiceDiscussSvc.ReqJoinDiscuss");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x865_3");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x870_4");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x870_5");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x921_0");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void d()
  {
    a(1008, true, null);
  }
  
  public void d(long paramLong)
  {
    if (a(paramLong))
    {
      ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqQuitDiscuss");
      localToServiceMsg.extraData.putLong("discussUin", paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "--->>quit discuss uin: " + paramLong);
      }
      a(localToServiceMsg);
      return;
    }
    a(1004, false, String.valueOf(paramLong));
  }
  
  protected void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleUncollectDisucssionResp");
    }
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin"));
      if (!bool1) {
        break label193;
      }
    }
    label193:
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = bool3;
        if (bool1)
        {
          paramFromServiceMsg = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
          paramObject = paramFromServiceMsg.a(String.valueOf(paramToServiceMsg));
          if (paramObject != null)
          {
            long l1 = System.currentTimeMillis();
            paramObject.hasCollect = false;
            paramObject.timeSec = l1;
            paramFromServiceMsg.a(paramObject);
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("handleUncollectDisucssionResp", 2, paramFromServiceMsg.getMessage());
        bool1 = bool2;
        continue;
      }
      a(1017, bool1, paramToServiceMsg);
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b()) && (this.jdField_b_of_type_JavaUtilArrayList != null) && (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty()))
    {
      int i1 = 0;
      if (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        Pair localPair = (Pair)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
        if ((localPair.first == null) || (localPair.second == null)) {}
        for (;;)
        {
          i1 += 1;
          break;
          if (((Boolean)localPair.first).booleanValue()) {
            a((String)localPair.second, false);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.c((String)localPair.second);
          }
        }
      }
      this.jdField_b_of_type_JavaUtilArrayList = null;
    }
  }
  
  public void e(long paramLong)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2160);
    localOIDBSSOPkg.uint32_service_type.set(4);
    Object localObject = ByteBuffer.allocate(20);
    ((ByteBuffer)localObject).putInt(Utils.a(paramLong)).putInt(0).putShort((short)4).putInt(Utils.a(paramLong));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x870_4");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("dwConfUin", paramLong);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
  }
  
  protected void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleGetFlyTicket");
    }
    this.jdField_b_of_type_Long = 0L;
    paramToServiceMsg = new FlyTicket.DiscussGetUrlResponse();
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = (FlyTicket.DiscussGetUrlResponse)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramToServiceMsg != null) && (paramToServiceMsg.ret_info.get() != null))
        {
          l1 = ((FlyTicket.RetInfo)paramToServiceMsg.ret_info.get()).ret_code.get();
          if (l1 == 0L)
          {
            bool = true;
            a(1011, bool, new Object[] { String.valueOf(l1), paramToServiceMsg });
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        paramToServiceMsg = null;
        continue;
        boolean bool = false;
        continue;
        l1 = -1L;
        continue;
      }
      long l1 = -1L;
    }
  }
  
  public void f(long paramLong)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2160);
    localOIDBSSOPkg.uint32_service_type.set(5);
    Object localObject = ByteBuffer.allocate(20);
    ((ByteBuffer)localObject).putInt(Utils.a(paramLong)).putInt(0).putShort((short)4).putInt(Utils.a(paramLong));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x870_5");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("dwConfUin", paramLong);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
  }
  
  protected void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = null;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleDecodeFlyTicket");
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramObject = new FlyTicket.DiscussSigDecodeResponse();
      try
      {
        paramFromServiceMsg = (FlyTicket.DiscussSigDecodeResponse)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          continue;
          boolean bool1 = false;
        }
      }
      bool1 = bool2;
      if (paramToServiceMsg != null)
      {
        bool1 = bool2;
        if (paramToServiceMsg.ret_info.get() != null)
        {
          if (((FlyTicket.RetInfo)paramToServiceMsg.ret_info.get()).ret_code.get() != 0) {
            break label116;
          }
          bool1 = true;
        }
      }
      a(1012, bool1, paramToServiceMsg);
      return;
    }
    label116:
    a(1012, false, null);
  }
  
  public void g(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "getDiscuss" + paramLong);
    }
    ToServiceMsg localToServiceMsg = a("QQServiceDiscussSvc.ReqGetDiscuss");
    localToServiceMsg.extraData.putLong("uin", paramLong);
    a(localToServiceMsg);
  }
  
  protected void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l2 = -1L;
    DiscussRespHeader localDiscussRespHeader = null;
    paramToServiceMsg = localDiscussRespHeader;
    long l1 = l2;
    if (paramFromServiceMsg != null)
    {
      paramToServiceMsg = localDiscussRespHeader;
      l1 = l2;
      if (paramFromServiceMsg.isSuccess())
      {
        paramToServiceMsg = localDiscussRespHeader;
        l1 = l2;
        if (paramObject != null)
        {
          paramToServiceMsg = (DiscussionReceiver.RespPackage)paramObject;
          localDiscussRespHeader = (DiscussRespHeader)paramToServiceMsg.jdField_a_of_type_JavaLangObject;
          paramObject = (RespGetDiscussInfo)paramToServiceMsg.b;
          paramToServiceMsg = paramObject;
          l1 = l2;
          if (localDiscussRespHeader != null)
          {
            l1 = localDiscussRespHeader.Result;
            paramToServiceMsg = paramObject;
          }
        }
      }
    }
    paramObject = new Object[2];
    paramObject[0] = String.valueOf(l1);
    paramObject[1] = paramToServiceMsg;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (l1 == 0L))
    {
      a(1013, true, paramObject);
      return;
    }
    a(1013, false, paramObject);
  }
  
  protected void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l2 = -1L;
    this.c = 0L;
    long l1;
    long l3;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = (DiscussionReceiver.RespPackage)paramObject;
      paramToServiceMsg = (DiscussRespHeader)paramObject.jdField_a_of_type_JavaLangObject;
      paramObject = (RespJoinDiscuss)paramObject.b;
      if (paramToServiceMsg != null)
      {
        l1 = paramToServiceMsg.Result;
        if (paramObject != null)
        {
          l3 = paramObject.DiscussUin;
          l2 = l1;
          l1 = l3;
        }
      }
    }
    for (;;)
    {
      paramToServiceMsg = new Long[2];
      paramToServiceMsg[0] = Long.valueOf(l2);
      paramToServiceMsg[1] = Long.valueOf(l1);
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (l2 == 0L) && (l1 > 0L))
      {
        a(1014, true, paramToServiceMsg);
        return;
      }
      a(1014, false, paramToServiceMsg);
      return;
      l3 = -1L;
      l2 = l1;
      l1 = l3;
      continue;
      l1 = -1L;
      break;
      l1 = -1L;
    }
  }
  
  protected void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleSetSimpleInfo");
    }
    String str = paramToServiceMsg.extraData.getString("discussionUin");
    if ((paramToServiceMsg.extraData.getInt("type") != 3000) || (str == null)) {
      return;
    }
    paramToServiceMsg = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramObject = (ArrayList)paramObject;
      paramFromServiceMsg = new ArrayList(paramObject.size());
      paramObject = paramObject.iterator();
      while (paramObject.hasNext())
      {
        ProfSmpInfoRes localProfSmpInfoRes = (ProfSmpInfoRes)paramObject.next();
        if (localProfSmpInfoRes != null)
        {
          DiscussionMemberInfo localDiscussionMemberInfo = paramToServiceMsg.a(str, String.valueOf(localProfSmpInfoRes.dwUin));
          if (localDiscussionMemberInfo != null)
          {
            localDiscussionMemberInfo.memberName = localProfSmpInfoRes.strNick;
            paramFromServiceMsg.add(localDiscussionMemberInfo);
          }
        }
      }
      paramToServiceMsg.b(paramFromServiceMsg);
      a(1006, true, str);
      return;
    }
    a(1006, false, str);
  }
  
  protected void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handle set discuss flag req: " + paramToServiceMsg + " ~~resp: " + paramFromServiceMsg + " ~~ data: " + paramObject);
    }
  }
  
  protected void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handle set discuss attr req: " + paramToServiceMsg + " ~~resp: " + paramFromServiceMsg + " ~~ data: " + paramObject);
    }
  }
  
  protected void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleQuitDiscussResp");
    }
    paramObject = (DiscussionReceiver.RespPackage)paramObject;
    Object localObject = (RespQuitDiscuss)paramObject.b;
    localObject = (DiscussRespHeader)paramObject.jdField_a_of_type_JavaLangObject;
    paramToServiceMsg = String.valueOf(paramToServiceMsg.extraData.getLong("discussUin"));
    int i1 = ((DiscussRespHeader)localObject).Result;
    String str = ((DiscussRespHeader)localObject).ResultDesc;
    if (((DiscussRespHeader)localObject).Result != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("DiscussionHandler", 2, "header failed! failed code: " + ((DiscussRespHeader)localObject).Result);
      }
      a(2000, true, new Object[] { paramToServiceMsg, Integer.valueOf(i1), str });
      a(1004, false, paramToServiceMsg);
      return;
    }
    if ((!paramFromServiceMsg.isSuccess()) || (!paramObject.jdField_a_of_type_Boolean))
    {
      a(1004, false, paramToServiceMsg);
      return;
    }
    a(paramToServiceMsg);
    new ArrayList().add(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
  }
  
  protected void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoResp " + paramFromServiceMsg.isSuccess());
    }
    try
    {
      paramObject = (DiscussionReceiver.RespPackage)paramObject;
      localRespGetDiscussInfo = (RespGetDiscussInfo)paramObject.b;
      localObject = (DiscussRespHeader)paramObject.jdField_a_of_type_JavaLangObject;
      localLong = Long.valueOf(paramToServiceMsg.extraData.getLong("discussUin"));
      this.jdField_a_of_type_JavaUtilArrayList.remove(localLong);
      str1 = String.valueOf(localLong);
      arrayOfObject = new Object[2];
      arrayOfObject[0] = str1;
      if ((((DiscussRespHeader)localObject).Result != 0) || (!paramFromServiceMsg.isSuccess()) || (!paramObject.jdField_a_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.w("DiscussionHandler", 2, "get discussin info failed,Header code:" + ((DiscussRespHeader)localObject).Result);
        }
        arrayOfObject[1] = Boolean.valueOf(false);
        a(1001, false, arrayOfObject);
        this.d = "";
        if (a())
        {
          a();
          return;
        }
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      localObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
      paramToServiceMsg = ((DiscussionManager)localObject).a(str1);
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "handleGetDiscussInfoResp disUin=" + str1 + " owner=" + localRespGetDiscussInfo.OwnerUin + " flag=" + localRespGetDiscussInfo.DiscussFlag + " gcode=" + localRespGetDiscussInfo.GroupCode + " guin=" + localRespGetDiscussInfo.GroupUin + " createTime=" + localRespGetDiscussInfo.CreateTime + " disName=" + Utils.a(localRespGetDiscussInfo.Name) + " infoseq=" + localRespGetDiscussInfo.InfoSeq + " timesec=" + localRespGetDiscussInfo.InteRemarkTimeStamp);
      }
      if (paramToServiceMsg != null) {
        break label881;
      }
      paramToServiceMsg = new DiscussionInfo();
      paramToServiceMsg.uin = str1;
      paramToServiceMsg.createTime = localRespGetDiscussInfo.CreateTime;
      paramToServiceMsg.discussionName = localRespGetDiscussInfo.Name;
      paramToServiceMsg.ownerUin = String.valueOf(localRespGetDiscussInfo.OwnerUin);
      paramToServiceMsg.timeSec = localRespGetDiscussInfo.InteRemarkTimeStamp;
      paramToServiceMsg.groupCode = localRespGetDiscussInfo.GroupCode;
      paramToServiceMsg.groupUin = localRespGetDiscussInfo.GroupUin;
      l1 = paramToServiceMsg.DiscussionFlag;
      paramToServiceMsg.DiscussionFlag = localRespGetDiscussInfo.DiscussFlag;
      paramToServiceMsg.DiscussionFlag = (l1 & 0x20000000 | paramToServiceMsg.DiscussionFlag);
      if (!QLog.isColorLevel()) {
        break label1595;
      }
      QLog.d("DiscussionHandler", 2, "handleGetDiscussInfoResp disUin=" + str1 + " no found disInfo new flag=" + paramToServiceMsg.DiscussionFlag);
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        FriendsManagerImp localFriendsManagerImp;
        Map localMap;
        Iterator localIterator;
        if (QLog.isColorLevel()) {
          QLog.d("DiscussionHandler", 2, "handleGetDiscussInfoResp excep", paramToServiceMsg);
        }
        this.d = "";
        if (!a()) {
          break label1575;
        }
        a();
        return;
        if (paramToServiceMsg.infoSeq == localRespGetDiscussInfo.InfoSeq)
        {
          paramFromServiceMsg = ((DiscussionManager)localObject).a(str1);
          arrayOfObject[1] = Boolean.valueOf(a(str1, localRespGetDiscussInfo.Members, paramFromServiceMsg));
          a(1001, true, arrayOfObject);
          int i2;
          if ((localRespGetDiscussInfo.DiscussFlag & 0x40) == 0L)
          {
            if (paramToServiceMsg.discussionName.equals(localRespGetDiscussInfo.Name)) {
              break label1589;
            }
            paramToServiceMsg.DiscussionFlag = (localRespGetDiscussInfo.DiscussFlag | 0x20000000);
            paramToServiceMsg.discussionName = localRespGetDiscussInfo.Name;
            i2 = 1;
            i1 = i2;
            if (QLog.isColorLevel()) {
              QLog.d("DiscussionHandler", 2, "handleGetDiscussInfoResp disUin=" + str1 + " name need server name| local name=" + Utils.a(paramToServiceMsg.discussionName));
            }
          }
          for (i1 = i2;; i1 = 1)
          {
            if (i1 != 0) {
              ((DiscussionManager)localObject).a(paramToServiceMsg);
            }
            this.d = "";
            if (!a()) {
              break;
            }
            a();
            return;
            if (QLog.isColorLevel()) {
              QLog.d("DiscussionHandler", 2, "handleGetDiscussInfoResp disUin=" + str1 + " old flag=" + paramToServiceMsg.DiscussionFlag);
            }
            paramToServiceMsg.DiscussionFlag = localRespGetDiscussInfo.DiscussFlag;
            paramToServiceMsg.DiscussionFlag |= 0x20000000;
            ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, paramToServiceMsg, paramFromServiceMsg, false);
          }
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        if ((paramToServiceMsg.discussionName != null) && (!paramToServiceMsg.discussionName.equals(localRespGetDiscussInfo.Name))) {}
        paramToServiceMsg.createTime = localRespGetDiscussInfo.CreateTime;
        paramToServiceMsg.ownerUin = String.valueOf(localRespGetDiscussInfo.OwnerUin);
        paramToServiceMsg.timeSec = localRespGetDiscussInfo.InteRemarkTimeStamp;
        paramToServiceMsg.groupUin = localRespGetDiscussInfo.GroupUin;
        paramToServiceMsg.groupCode = localRespGetDiscussInfo.GroupCode;
        if ((localRespGetDiscussInfo.DiscussFlag & 0x40) == 0L)
        {
          paramToServiceMsg.discussionName = localRespGetDiscussInfo.Name;
          paramToServiceMsg.DiscussionFlag = (localRespGetDiscussInfo.DiscussFlag | 0x20000000);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "handleGetDiscussInfoResp disUin=" + str1 + " old flag=" + paramToServiceMsg.DiscussionFlag);
          }
          paramToServiceMsg.DiscussionFlag = localRespGetDiscussInfo.DiscussFlag;
          paramToServiceMsg.DiscussionFlag |= 0x20000000;
          paramToServiceMsg.discussionName = localRespGetDiscussInfo.Name;
          continue;
          if (TextUtils.isEmpty(paramObject.inteRemark))
          {
            paramFromServiceMsg = localFriendsManagerImp.a(paramObject.memberUin);
            if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isFriend())) {
              break label1450;
            }
            paramObject.memberName = paramFromServiceMsg.name;
            if (!TextUtils.isEmpty(paramFromServiceMsg.remark)) {
              break;
            }
            paramFromServiceMsg = paramFromServiceMsg.name;
            paramObject.inteRemark = paramFromServiceMsg;
            paramObject.inteRemarkSource = 129L;
          }
        }
      }
    }
    finally
    {
      for (;;)
      {
        RespGetDiscussInfo localRespGetDiscussInfo;
        Object localObject;
        Long localLong;
        String str1;
        Object[] arrayOfObject;
        long l1;
        HashMap localHashMap;
        StringBuffer localStringBuffer;
        this.d = "";
        if (a()) {
          a();
        }
        for (;;)
        {
          throw paramToServiceMsg;
          paramFromServiceMsg = paramFromServiceMsg.remark;
          break label1406;
          paramObject.inteRemarkSource = 0L;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, localStringBuffer.toString());
          }
          if (((DiscussionManager)localObject).a(str1, localHashMap, l1)) {
            paramToServiceMsg.infoSeq = localRespGetDiscussInfo.InfoSeq;
          }
          ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localLong), paramToServiceMsg, localHashMap, false);
          ((DiscussionManager)localObject).a(paramToServiceMsg);
          this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.d(paramToServiceMsg.uin);
          arrayOfObject[1] = Boolean.valueOf(true);
          a(1001, true, arrayOfObject);
          this.d = "";
          if (a())
          {
            a();
            return;
          }
          this.jdField_a_of_type_Boolean = false;
          return;
          this.jdField_a_of_type_Boolean = false;
          return;
          this.jdField_a_of_type_Boolean = false;
        }
        int i1 = 0;
      }
    }
    paramFromServiceMsg = localRespGetDiscussInfo.Members;
    localHashMap = new HashMap();
    l1 = System.currentTimeMillis();
    localMap = ((DiscussionManager)localObject).a(str1);
    localStringBuffer = new StringBuffer();
    localIterator = paramFromServiceMsg.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label1458;
      }
      DiscussMemberInfo localDiscussMemberInfo = (DiscussMemberInfo)localIterator.next();
      String str2 = String.valueOf(localDiscussMemberInfo.Uin);
      if (QLog.isColorLevel())
      {
        localStringBuffer.append("memberUin=");
        localStringBuffer.append(str2.toString());
        localStringBuffer.append("flag=");
        localStringBuffer.append(localDiscussMemberInfo.Flag);
        localStringBuffer.append("inteRemark=");
        localStringBuffer.append(Utils.a(localDiscussMemberInfo.StInteRemark.StrValue));
        localStringBuffer.append("Source=");
        localStringBuffer.append(localDiscussMemberInfo.StInteRemark.Source);
        localStringBuffer.append("\r\n");
      }
      paramFromServiceMsg = null;
      if (localMap != null) {
        paramFromServiceMsg = (DiscussionMemberInfo)localMap.get(str2);
      }
      paramObject = paramFromServiceMsg;
      if (paramFromServiceMsg == null)
      {
        paramObject = new DiscussionMemberInfo();
        paramObject.discussionUin = str1;
        paramObject.memberUin = str2;
      }
      paramObject.flag = localDiscussMemberInfo.Flag;
      paramObject.dataTime = l1;
      if ((localDiscussMemberInfo.StInteRemark == null) || (TextUtils.isEmpty(localDiscussMemberInfo.StInteRemark.StrValue))) {
        break;
      }
      paramObject.inteRemark = localDiscussMemberInfo.StInteRemark.StrValue;
      paramObject.inteRemarkSource = localDiscussMemberInfo.StInteRemark.Source;
      localHashMap.put(paramObject.memberUin, paramObject);
    }
  }
  
  protected void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = (DiscussionReceiver.RespPackage)paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussResp " + paramFromServiceMsg.isSuccess() + ", " + paramToServiceMsg.jdField_a_of_type_Boolean);
    }
    if ((!paramFromServiceMsg.isSuccess()) || (!paramToServiceMsg.jdField_a_of_type_Boolean))
    {
      a(1000, false, null);
      return;
    }
    paramFromServiceMsg = (RespGetDiscuss)paramToServiceMsg.b;
    paramToServiceMsg = paramFromServiceMsg.DiscussList;
    paramObject = paramFromServiceMsg.FavoriteDiscussList;
    paramFromServiceMsg = new ArrayList();
    if (paramObject != null)
    {
      paramObject = paramObject.iterator();
      while (paramObject.hasNext()) {
        paramFromServiceMsg.add(Long.valueOf(((DiscussInfo)paramObject.next()).DiscussUin));
      }
    }
    a(1000, a(paramToServiceMsg, paramFromServiceMsg), null);
  }
  
  protected void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleChangeDiscussNameResp");
    }
    paramObject = (DiscussionReceiver.RespPackage)paramObject;
    paramFromServiceMsg = (RespChangeDiscussName)paramObject.b;
    Object localObject = (DiscussRespHeader)paramObject.jdField_a_of_type_JavaLangObject;
    paramFromServiceMsg = String.valueOf(paramToServiceMsg.extraData.getLong("discussUin"));
    int i1 = ((DiscussRespHeader)localObject).Result;
    String str = ((DiscussRespHeader)localObject).ResultDesc;
    if (((DiscussRespHeader)localObject).Result != 0)
    {
      a(2000, true, new Object[] { paramFromServiceMsg, Integer.valueOf(i1), str });
      a(1005, false, paramFromServiceMsg);
      return;
    }
    if (paramObject.jdField_a_of_type_Boolean)
    {
      paramObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
      localObject = paramObject.a(paramFromServiceMsg);
      if (localObject != null)
      {
        ((DiscussionInfo)localObject).discussionName = paramToServiceMsg.extraData.getString("newName");
        ((DiscussionInfo)localObject).DiscussionFlag &= 0xFFFFFFBF;
        paramObject.a((DiscussionInfo)localObject);
      }
      a(1005, true, paramFromServiceMsg);
      return;
    }
    a(1005, false, paramFromServiceMsg);
  }
  
  protected void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleCreateDiscussResp ");
    }
    paramObject = (DiscussionReceiver.RespPackage)paramObject;
    if ((!paramFromServiceMsg.isSuccess()) || (!paramObject.jdField_a_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "create discussion fail, result code: " + paramFromServiceMsg.getResultCode() + " errMsg: " + paramFromServiceMsg.getBusinessFailMsg() + " respPackage.bSuccess: " + paramObject.jdField_a_of_type_Boolean);
      }
      a(1002, false, Long.valueOf(-1L));
      return;
    }
    paramFromServiceMsg = (RespCreateDiscuss)paramObject.b;
    if (!a(paramFromServiceMsg.DiscussUin))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "create discussion fail: invalid discussion uin");
      }
      a(1002, false, Long.valueOf(-1L));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "create discussion succeeded " + paramFromServiceMsg.DiscussUin);
    }
    paramObject = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
    Object localObject1 = new DiscussionInfo();
    ((DiscussionInfo)localObject1).uin = String.valueOf(paramFromServiceMsg.DiscussUin);
    ((DiscussionInfo)localObject1).discussionName = paramToServiceMsg.extraData.getString("name");
    ((DiscussionInfo)localObject1).infoSeq = -1L;
    localDiscussionManager.a((DiscussionInfo)localObject1);
    a(paramFromServiceMsg.DiscussUin);
    paramToServiceMsg = paramFromServiceMsg.AddResult;
    DiscussionMemberInfo localDiscussionMemberInfo;
    if (paramToServiceMsg != null)
    {
      Object localObject2 = paramToServiceMsg.keySet();
      localObject1 = new ArrayList();
      localObject2 = ((Set)localObject2).iterator();
      int i1 = 0;
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (Long)((Iterator)localObject2).next();
        if (((Integer)paramToServiceMsg.get(localObject3)).intValue() != 0) {
          break label485;
        }
        localDiscussionMemberInfo = new DiscussionMemberInfo();
        localDiscussionMemberInfo.discussionUin = String.valueOf(paramFromServiceMsg.DiscussUin);
        localDiscussionMemberInfo.memberUin = String.valueOf(localObject3);
        localDiscussionMemberInfo.flag = 0;
        localObject3 = paramObject.a(localDiscussionMemberInfo.memberUin);
        if ((localObject3 != null) && (((Friends)localObject3).isFriend()))
        {
          localDiscussionMemberInfo.memberName = ((Friends)localObject3).name;
          label428:
          ((List)localObject1).add(localDiscussionMemberInfo);
          i1 += 1;
        }
      }
    }
    label485:
    for (;;)
    {
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(localDiscussionMemberInfo.memberUin);
      break label428;
      localDiscussionManager.b((List)localObject1);
      a(1002, true, Long.valueOf(paramFromServiceMsg.DiscussUin));
      return;
    }
  }
  
  protected void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleAddDiscussMemberResp");
    }
    paramObject = (DiscussionReceiver.RespPackage)paramObject;
    RespAddDiscussMember localRespAddDiscussMember = (RespAddDiscussMember)paramObject.b;
    Object localObject1 = (DiscussRespHeader)paramObject.jdField_a_of_type_JavaLangObject;
    Object localObject2 = String.valueOf(Long.valueOf(paramToServiceMsg.extraData.getLong("discussUin")));
    int i1 = ((DiscussRespHeader)localObject1).Result;
    paramToServiceMsg = ((DiscussRespHeader)localObject1).ResultDesc;
    if (((DiscussRespHeader)localObject1).Result != 0)
    {
      a(2000, true, new Object[] { localObject2, Integer.valueOf(i1), paramToServiceMsg });
      return;
    }
    paramToServiceMsg = new Object[2];
    paramToServiceMsg[0] = localObject2;
    if ((!paramFromServiceMsg.isSuccess()) || (!paramObject.jdField_a_of_type_Boolean))
    {
      paramToServiceMsg[1] = null;
      a(1003, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    localObject1 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
    localObject2 = ((DiscussionManager)localObject1).a((String)localObject2);
    if (localObject2 == null)
    {
      paramToServiceMsg[0] = String.valueOf(localRespAddDiscussMember.DiscussUin);
      a(1003, false, paramToServiceMsg);
      return;
    }
    Object localObject3 = ((DiscussionInfo)localObject2).faceUinSet;
    int i2 = 0;
    i1 = i2;
    if (localObject3 != null)
    {
      i1 = i2;
      if (!((String)localObject3).trim().equals("")) {
        i1 = ((String)localObject3).split(";").length;
      }
    }
    if (5 - i1 > 0) {}
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    StringBuffer localStringBuffer;
    for (i1 = 1;; i1 = 0)
    {
      localObject3 = localRespAddDiscussMember.AddResult;
      Object localObject4 = ((Map)localObject3).keySet();
      localArrayList1 = new ArrayList(((Set)localObject4).size());
      localArrayList2 = new ArrayList();
      localStringBuffer = new StringBuffer();
      localObject4 = ((Set)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject4).next();
        if (QLog.isColorLevel())
        {
          localStringBuffer.append("discussUin: " + localRespAddDiscussMember.DiscussUin + " memberUin: " + localLong.longValue() + " value: " + ((Integer)((Map)localObject3).get(localLong)).intValue());
          localStringBuffer.append("\n");
        }
        if (((Integer)((Map)localObject3).get(localLong)).intValue() == 0)
        {
          DiscussionMemberInfo localDiscussionMemberInfo = new DiscussionMemberInfo();
          localDiscussionMemberInfo.discussionUin = String.valueOf(localRespAddDiscussMember.DiscussUin);
          localDiscussionMemberInfo.memberUin = String.valueOf(localLong);
          localDiscussionMemberInfo.flag = 0;
          Friends localFriends = paramFromServiceMsg.c(localLong + "");
          if ((localFriends != null) && (localFriends.name != null)) {
            localDiscussionMemberInfo.memberName = localFriends.name;
          }
          localArrayList1.add(String.valueOf(localLong));
          localArrayList2.add(localDiscussionMemberInfo);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, localStringBuffer.toString());
    }
    a(localRespAddDiscussMember.DiscussUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localArrayList1, 1);
    ((DiscussionInfo)localObject2).DiscussionFlag |= 0x20000000;
    ((DiscussionManager)localObject1).b(localArrayList2);
    if (i1 != 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.d(((DiscussionInfo)localObject2).uin);
    }
    paramToServiceMsg[1] = paramObject.b;
    a(1003, true, paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionHandler
 * JD-Core Version:    0.7.0.1
 */