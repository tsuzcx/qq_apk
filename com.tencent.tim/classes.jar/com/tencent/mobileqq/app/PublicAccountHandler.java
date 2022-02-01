package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowListReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowListRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import accg;
import acci;
import aced;
import acja;
import acjb;
import acjc;
import acjd;
import acje;
import acje.a;
import acje.b;
import acxw;
import aczc;
import andh;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import anot;
import aqft;
import aqgo;
import aqnv;
import avpp;
import avpq;
import com.tencent.biz.pubaccount.AccountDetail.jce.GetRecvMsgStateRsp;
import com.tencent.biz.pubaccount.AccountDetail.jce.SetRecvMsgStateRsp;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.jungle.weather.WeatherReportInfo.GetWeatherMessageRsp;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.UinPair;
import com.tencent.mobileqq.mp.historyMsg.AioHistoryMsgRequest;
import com.tencent.mobileqq.mp.historyMsg.AioHistoryMsgResponse;
import com.tencent.mobileqq.mp.historyMsg.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetMessageConfigurationResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserFollowListRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserFollowListResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SendLBSInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.SendPreMessageStatusResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.SetMessageConfigurationResponse;
import com.tencent.mobileqq.mp.publicaccount_recommend.BusinessRecommendRequest;
import com.tencent.mobileqq.mp.publicaccount_recommend.BusinessRecommendResponse;
import com.tencent.mobileqq.mp.publicaccount_recommend.RetInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vaswebviewplugin.PublicAccountWebReport;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import juk;
import jyl;
import kbs;
import kbt;
import kdm;
import lbz;
import mqq.app.AppActivity;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import msf.msgcomm.msg_comm.Msg;
import nyn;
import oan;
import obt;
import sfx;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.FollowList;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.RspFollowList;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.RspTypeList;

public class PublicAccountHandler
  extends accg
{
  public static String boT = "";
  public static String bov;
  public long QB;
  private boolean bIL;
  private boolean bIM;
  private boolean bIN = true;
  public boolean bIO;
  private Map<Integer, a> jq = new HashMap();
  public List<UinPair> xO;
  
  PublicAccountHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    String str = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "PublicAccount_TotalSwitch");
    if (str != null) {}
    try
    {
      this.bIL = Boolean.parseBoolean(str);
      label43:
      paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "PublicAccount_SearchSwitch");
      if (paramQQAppInterface != null) {}
      try
      {
        this.bIM = Boolean.parseBoolean(paramQQAppInterface);
        return;
      }
      catch (Exception paramQQAppInterface) {}
    }
    catch (Exception localException)
    {
      break label43;
    }
  }
  
  private void EB(String paramString)
  {
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit();
    localEditor.putString("NewProtocolGetFollowListAttachInfo", paramString);
    localEditor.commit();
  }
  
  private void Jw(int paramInt)
  {
    SosoInterface.a(new acjc(this, 0, true, true, 60000L, true, false, "PublicAccountHandler", paramInt));
  }
  
  private int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountHandler", 2, "getUserFollowList() isNewProtocol: " + paramBoolean2 + "   followSeqNo: " + paramLong1 + "   publicAccountSeqNo: " + paramLong2);
    }
    Object localObject;
    if (paramBoolean2)
    {
      NewIntent localNewIntent = new NewIntent(this.app.getApp(), kbt.class);
      localNewIntent.putExtra("cmd", "CertifiedAccountSvc.certified_account_read.GetFollowList");
      localObject = new CertifiedAccountRead.StGetFollowListReq();
      ((CertifiedAccountRead.StGetFollowListReq)localObject).seq.set(aqft.ag(paramLong1));
      ((CertifiedAccountRead.StGetFollowListReq)localObject).count.set(aqft.ag(paramLong4));
      if (!TextUtils.isEmpty(paramString)) {
        ((CertifiedAccountRead.StGetFollowListReq)localObject).attach_info.set(paramString);
      }
      paramString = new PROTOCAL.StQWebReq();
      paramString.Seq.set(-1L);
      paramString.qua.set(avpq.getQUA3());
      paramString.deviceInfo.set(avpp.a().getDeviceInfor());
      paramString.busiBuff.set(ByteStringMicro.copyFrom(((CertifiedAccountRead.StGetFollowListReq)localObject).toByteArray()));
      String str = sfx.getTraceId();
      if (!TextUtils.isEmpty(str)) {
        paramString.traceid.set(str);
      }
      localObject = paramString.toByteArray();
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = new byte[4];
      }
      localNewIntent.putExtra("traceid", str);
      localNewIntent.putExtra("data", paramString);
      localNewIntent.putExtra("get_user_follow_list_begin", paramLong3);
      localNewIntent.putExtra("get_user_follow_list_follow_seq", paramLong1);
      localNewIntent.putExtra("get_user_follow_list_data_seq", paramLong2);
      localNewIntent.putExtra("time_stamp", paramLong5);
      localNewIntent.putExtra("get_user_follow_list_is_increment", paramBoolean1);
      kbt.aL(localNewIntent);
      this.app.startServlet(localNewIntent);
    }
    for (;;)
    {
      return 0;
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountHandler", 2, "getUserFollowList");
      }
      paramString = new NewIntent(this.app.getApp(), kbs.class);
      paramString.putExtra("cmd", "get_follow_list");
      localObject = new mobileqq_mp.GetUserFollowListRequest();
      ((mobileqq_mp.GetUserFollowListRequest)localObject).follow_seqno.set(aqft.ag(paramLong1));
      ((mobileqq_mp.GetUserFollowListRequest)localObject).public_account_seqno.set(aqft.ag(paramLong2));
      ((mobileqq_mp.GetUserFollowListRequest)localObject).begin.set(aqft.ag(paramLong3));
      ((mobileqq_mp.GetUserFollowListRequest)localObject).limit.set(aqft.ag(paramLong4));
      ((mobileqq_mp.GetUserFollowListRequest)localObject).version.set(1);
      ((mobileqq_mp.GetUserFollowListRequest)localObject).is_increment.set(paramBoolean1);
      paramString.putExtra("data", ((mobileqq_mp.GetUserFollowListRequest)localObject).toByteArray());
      paramString.putExtra("get_user_follow_list_begin", paramLong3);
      paramString.putExtra("get_user_follow_list_follow_seq", paramLong1);
      paramString.putExtra("get_user_follow_list_data_seq", paramLong2);
      paramString.putExtra("time_stamp", paramLong5);
      paramString.putExtra("get_user_follow_list_is_increment", paramBoolean1);
      kbs.aL(paramString);
      this.app.startServlet(paramString);
    }
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    acje.b localb = new acje.b();
    int j = 1;
    boolean bool2 = false;
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 2901) && (paramIntent != null))
    {
      i = paramIntent.getIntExtra("k_resend_cnt", 0);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountHandler", 2, "handleGetUserFollowListk_resend_cnt" + i);
      }
      if (i < 2)
      {
        paramIntent.putExtra("k_resend_cnt", i + 1);
        this.app.startServlet((NewIntent)paramIntent);
        return;
      }
    }
    long l1;
    long l2;
    long l3;
    long l4;
    boolean bool3;
    boolean bool1;
    label450:
    label758:
    label895:
    long l5;
    if ((paramIntent != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramArrayOfByte != null))
    {
      localb.mErrCode = 0;
      l1 = paramIntent.getLongExtra("time_stamp", 0L);
      l2 = paramIntent.getLongExtra("get_user_follow_list_begin", 0L);
      l3 = paramIntent.getLongExtra("get_user_follow_list_follow_seq", 0L);
      l4 = paramIntent.getLongExtra("get_user_follow_list_data_seq", 0L);
      bool3 = paramIntent.getBooleanExtra("get_user_follow_list_is_increment", true);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountHandler", 2, "handleGetUserFollowList time:  " + l1 + "  begin: " + l2 + "  preFollowSeq: " + l3 + "  preDataSeq: " + l4);
      }
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          paramFromServiceMsg = new CertifiedAccountRead.StGetFollowListRsp();
          paramFromServiceMsg.mergeFrom(paramArrayOfByte);
          if (paramFromServiceMsg.refresh.get() != 1) {
            continue;
          }
          bool1 = true;
          if (paramFromServiceMsg.has_next.get() != 1) {
            continue;
          }
          bool2 = true;
          l3 = paramFromServiceMsg.seq.get();
          paramIntent = paramFromServiceMsg.attach_info.get();
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountHandler", 2, "handleGetUserFollowList      refresh: " + bool1 + "    has_next: " + bool2);
          }
          if (!bool1) {
            continue;
          }
          a(0L, 0L, 0L, 20L, SystemClock.uptimeMillis(), false, true, paramIntent);
          i = 0;
          paramBoolean = false;
        }
        catch (Exception paramIntent)
        {
          localb.mErrCode = -1;
          localb.fV = true;
          paramBoolean = false;
          i = j;
          continue;
          ak(l3, paramBoolean);
          EB(paramIntent);
          continue;
        }
        if (i == 0) {
          break;
        }
        notifyUI(100, paramBoolean, localb);
        return;
        bool1 = false;
        continue;
        bool2 = false;
        continue;
        paramFromServiceMsg = paramFromServiceMsg.account_list.get();
        l4 = paramFromServiceMsg.size();
        paramFromServiceMsg = PublicAccountInfo.createPublicAccountInfoListCf8(paramFromServiceMsg, l1);
        localb.mList = paramFromServiceMsg;
        if (bool2) {
          break label1301;
        }
        bool1 = true;
        localb.fV = bool1;
        localb.mTotalCount = l4;
        paramArrayOfByte = (acja)this.app.getManager(56);
        a(paramFromServiceMsg, l1, bool3, localb.fV);
        if (localb.fV)
        {
          oan.a().a(this.app, paramArrayOfByte.ec());
          nyn.a().ae(this.app);
          oan.a().at(this.app);
          lbz.a().aJk();
          paramFromServiceMsg = new FolderRefreshRunnable(this.app, paramArrayOfByte);
          ThreadManager.getSubThreadHandler().postDelayed(paramFromServiceMsg, 15000L);
          ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountHandler.2(this), 500L);
        }
        if (!localb.fV)
        {
          if (bool3)
          {
            a(l3, 0L, 0L, 20L, l1, true, true, paramIntent);
            al(0L, paramBoolean);
            paramBoolean = true;
            localb.mErrCode = 0;
            i = 1;
          }
          else
          {
            a(l3, 0L, l2 + 20L, 20L, l1, false, true, paramIntent);
          }
        }
        else
        {
          paramIntent = new mobileqq_mp.GetUserFollowListResponse();
          paramIntent.mergeFrom(paramArrayOfByte);
          if ((!paramIntent.ret_info.has()) || (!((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.has())) {
            break label1307;
          }
          i = ((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.get();
          localb.mErrCode = i;
          if (QLog.isColorLevel())
          {
            if (!paramIntent.has_next.has()) {
              break label1313;
            }
            bool1 = paramIntent.has_next.get();
            label790:
            QLog.d("PublicAccountHandler", 2, "handleGetUserFollowList        errCode: " + i + "    has_next: " + bool1);
          }
          if (i != 0)
          {
            localb.fV = true;
            paramBoolean = bool2;
            i = j;
          }
          else
          {
            if (!paramIntent.follow_seqno.has()) {
              break label1319;
            }
            i = paramIntent.follow_seqno.get();
            label869:
            l4 = aqft.K(i);
            if (!paramIntent.public_account_seqno.has()) {
              break label1325;
            }
            i = paramIntent.public_account_seqno.get();
            l5 = aqft.K(i);
            if ((l4 <= l3) || (l3 == 0L)) {
              break label947;
            }
            a(l4, l5, 0L, 20L, SystemClock.uptimeMillis(), false, paramBoolean, null);
            i = 0;
            paramBoolean = bool2;
          }
        }
      }
      label947:
      if (!paramIntent.total_count.has()) {
        break label1337;
      }
      i = paramIntent.total_count.get();
      label966:
      l3 = aqft.K(i);
      paramFromServiceMsg = PublicAccountInfo.createPublicAccountInfoList(paramIntent.info.get(), l1);
      localb.mList = paramFromServiceMsg;
      if (!paramIntent.has_next.has()) {
        break label1331;
      }
      if (paramIntent.has_next.get()) {
        break label1343;
      }
    }
    for (;;)
    {
      localb.fV = bool1;
      localb.mTotalCount = l3;
      paramIntent = (acja)this.app.getManager(56);
      a(paramFromServiceMsg, l1, bool3, localb.fV);
      if (localb.fV)
      {
        oan.a().a(this.app, paramIntent.ec());
        nyn.a().ae(this.app);
        oan.a().at(this.app);
        lbz.a().aJk();
        paramIntent = new FolderRefreshRunnable(this.app, paramIntent);
        ThreadManager.getSubThreadHandler().postDelayed(paramIntent, 15000L);
        ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountHandler.3(this), 500L);
      }
      if (!localb.fV) {
        if (bool3) {
          a(l4, l5, 0L, 20L, l1, true, paramBoolean, null);
        }
      }
      for (;;)
      {
        al(l5, paramBoolean);
        paramBoolean = true;
        i = j;
        break;
        a(l4, l5, l2 + 20L, 20L, l1, false, paramBoolean, null);
        continue;
        ak(l4, paramBoolean);
      }
      localb.mErrCode = -1;
      localb.fV = true;
      paramBoolean = bool2;
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PublicAccountHandler", 2, "<<---handleGetUserFollowList " + localb.mErrCode);
      paramBoolean = bool2;
      i = j;
      break;
      label1301:
      bool1 = false;
      break label450;
      label1307:
      i = 0;
      break label758;
      label1313:
      bool1 = false;
      break label790;
      label1319:
      i = 0;
      break label869;
      label1325:
      i = 0;
      break label895;
      label1331:
      bool1 = true;
      continue;
      label1337:
      i = 0;
      break label966;
      label1343:
      bool1 = false;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppInterface instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppInterface;
    }
    anot.a(localQQAppInterface, "P_CliOper", paramString2, "", paramString3, paramString4, 0, 0, paramString1, "", "", "");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppInterface instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppInterface;
    }
    anot.a(localQQAppInterface, "P_CliOper", paramString2, "", paramString3, paramString4, paramInt, 0, paramString1, "", "", "");
  }
  
  private void a(List<PublicAccountInfo> paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = ((acja)this.app.getManager(56)).a(paramList, paramLong, paramBoolean1, paramBoolean2);
    paramList = this.app.a();
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (PublicAccountInfo)((Iterator)localObject1).next();
      localObject2 = paramList.a().b(((PublicAccountInfo)localObject2).getUin(), 1008);
      if (localObject2 == null) {
        break label131;
      }
      paramList.a().f((RecentUser)localObject2);
      i = 1;
    }
    label131:
    for (;;)
    {
      break;
      paramList = this.app.getHandler(Conversation.class);
      if ((i != 0) && (paramList != null)) {
        paramList.sendEmptyMessage(1009);
      }
      return;
    }
  }
  
  private void a(SubMsgType0x28.RspFollowList paramRspFollowList)
  {
    int m = 1;
    List localList = paramRspFollowList.rpt_msg_followlist.get();
    long l = Long.parseLong(this.app.getCurrentAccountUin());
    Iterator localIterator = localList.iterator();
    paramRspFollowList = null;
    int j = 0;
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject2 = (SubMsgType0x28.FollowList)localIterator.next();
      Object localObject1;
      if (l == ((SubMsgType0x28.FollowList)localObject2).uint64_uin.get()) {
        localObject1 = String.valueOf(((SubMsgType0x28.FollowList)localObject2).uint64_puin.get());
      }
      int k;
      switch (((SubMsgType0x28.FollowList)localObject2).uint32_type.get())
      {
      default: 
        k = j;
        j = i;
        i = k;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        localObject2 = (acja)this.app.getManager(56);
        ((acja)localObject2).Ez((String)localObject1);
        ((acja)localObject2).Ey((String)localObject1);
        paramRspFollowList = new acje.a();
        paramRspFollowList.a = ((acja)localObject2).a(l + "");
        this.app.b().N((String)localObject1, 1008);
        oan.a().a(this.app, ((acja)localObject2).ec());
        nyn.a().ae(this.app);
        localObject1 = (kdm)this.app.getManager(88);
        if (localObject1 != null) {
          ((kdm)localObject1).bs(l + "", "pushmsg");
        }
        lbz.a().aa(l, 1);
        i = j;
        j = 1;
        continue;
        AF();
        lbz.a().aa(l, 2);
        j = i;
        i = 1;
      }
    }
    if (i != 0)
    {
      notifyUI(103, true, null);
      notifyUI(102, true, paramRspFollowList);
    }
    if (j != 0) {
      notifyUI(101, true, null);
    }
    if (!localList.isEmpty()) {
      if (((SubMsgType0x28.FollowList)localList.get(0)).uint32_type.get() != 1) {
        break label459;
      }
    }
    label459:
    for (boolean bool = true;; bool = false)
    {
      l = ((SubMsgType0x28.FollowList)localList.get(0)).uint64_puin.get();
      ThreadManager.getUIHandler().post(new PublicAccountHandler.1(this, l, bool));
      paramRspFollowList = lbz.a();
      i = m;
      if (bool) {
        i = 2;
      }
      paramRspFollowList.ab(l, i);
      return;
    }
  }
  
  private void a(SubMsgType0x28.RspTypeList paramRspTypeList) {}
  
  private void ak(long paramLong, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit();
    if (paramBoolean) {}
    for (String str = "NewProtocolPublicAccountFollowSeq2";; str = "PublicAccountFollowSeq2")
    {
      localEditor.putLong(str, paramLong);
      localEditor.commit();
      return;
    }
  }
  
  private void al(long paramLong, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit();
    if (paramBoolean) {}
    for (String str = "NewProtocolPublicAccountDataSeq2";; str = "PublicAccountDataSeq2")
    {
      localEditor.putLong(str, paramLong);
      localEditor.commit();
      return;
    }
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = new mobileqq_mp.GetMessageConfigurationResponse();
    long l = paramIntent.getLongExtra("uin", 0L);
    QLog.d("PublicAccountHandler", 1, "handleSubscribesStatusResp, uin : " + l);
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((!paramFromServiceMsg.ret_info.has()) || (!paramFromServiceMsg.ret_info.ret_code.has())) {
          continue;
        }
        int i = paramFromServiceMsg.ret_info.ret_code.get();
        if (i == 0)
        {
          if (paramFromServiceMsg.type.has())
          {
            i = paramFromServiceMsg.type.get();
            paramIntent = new HashMap();
            paramIntent.put("uin", Long.valueOf(l));
            paramIntent.put("status", Integer.valueOf(i));
            notifyUI(111, true, paramIntent);
            QLog.d("PublicAccountHandler", 1, "result:" + i);
          }
        }
        else if (QLog.isColorLevel()) {
          QLog.d("PublicAccountHandler", 2, "request Kandian status fail code:" + i);
        }
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        continue;
      }
      notifyUI(111, false, null);
      return;
      if (QLog.isColorLevel())
      {
        QLog.d("PublicAccountHandler", 2, "request Kandian status wrong resp");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountHandler", 2, "request Kandian status fail data null");
        }
      }
    }
  }
  
  private long g(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
    if (paramBoolean) {}
    for (String str = "NewProtocolPublicAccountFollowSeq2";; str = "PublicAccountFollowSeq2") {
      return localSharedPreferences.getLong(str, 0L);
    }
  }
  
  private long h(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
    if (paramBoolean) {}
    for (String str = "NewProtocolPublicAccountDataSeq2";; str = "PublicAccountDataSeq2") {
      return localSharedPreferences.getLong(str, 0L);
    }
  }
  
  private void h(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      int i;
      try
      {
        paramIntent = new publicaccount_recommend.BusinessRecommendResponse();
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((!paramIntent.ret_info.has()) || (!((publicaccount_recommend.RetInfo)paramIntent.ret_info.get()).ret_code.has())) {
          break label185;
        }
        i = ((publicaccount_recommend.RetInfo)paramIntent.ret_info.get()).ret_code.get();
      }
      catch (Exception paramIntent)
      {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountHandler", 2, "handleGetRecommendList(): package size is " + paramArrayOfByte.length + " Byte");
      }
      if (paramIntent.business.has())
      {
        paramIntent = PublicRecommendAccountInfo.createPublicRecommendAccountInfoList(paramIntent.business.get());
        ((acja)this.app.getManager(56)).jc(paramIntent);
        notifyUI(104, true, null);
        return;
        notifyUI(104, false, null);
        return;
      }
      while (i != 0)
      {
        return;
        label185:
        i = -1;
      }
    }
  }
  
  private String rI()
  {
    return this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).getString("NewProtocolGetFollowListAttachInfo", "");
  }
  
  public int AF()
  {
    boolean bool = obt.GA();
    long l1 = g(bool);
    long l2 = h(bool);
    String str = rI();
    return a(l1, l2, 0L, 20L, SystemClock.uptimeMillis(), true, bool, str);
  }
  
  public void J(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    aczc.a(new acjd(this, "qq_weather", false, paramInt2, paramInt3, paramInt4, paramInt1));
  }
  
  public int a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApp(), kbs.class);
    localNewIntent.putExtra("cmd", "get_business_recommend");
    publicaccount_recommend.BusinessRecommendRequest localBusinessRecommendRequest = new publicaccount_recommend.BusinessRecommendRequest();
    localBusinessRecommendRequest.recomend_count.set(20);
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null)) {
      if ((paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null) || (paramSosoLbsInfo.a.address == null)) {
        break label233;
      }
    }
    label233:
    for (String str = paramSosoLbsInfo.a.address;; str = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountHandler", 2, "getRecommendList() latitude=" + paramSosoLbsInfo.a.cd + " longitude=" + paramSosoLbsInfo.a.ce + ", address=" + str);
      }
      localBusinessRecommendRequest.latitude.set(String.valueOf(paramSosoLbsInfo.a.cd));
      localBusinessRecommendRequest.longitude.set(String.valueOf(paramSosoLbsInfo.a.ce));
      localBusinessRecommendRequest.city_info.set(str);
      localBusinessRecommendRequest.platform.set(109);
      localNewIntent.putExtra("data", localBusinessRecommendRequest.toByteArray());
      kbs.aL(localNewIntent);
      this.app.startServlet(localNewIntent);
      return 0;
    }
  }
  
  public void a(Context paramContext, int paramInt, a parama)
  {
    if (parama != null) {
      this.jq.put(Integer.valueOf(paramInt), parama);
    }
    if (paramInt == 1) {
      J(paramInt, 0, 0, 0);
    }
    while (paramInt != 2) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramContext = (AppActivity)paramContext;
      if (paramContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        paramContext.requestPermissions(new acjb(this, paramInt, paramContext), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      Jw(paramInt);
      return;
    }
    Jw(paramInt);
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = (byte[])paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountHandler", 2, "<<---onReceive " + str);
    }
    if (str.equals("get_follow_list")) {
      a(paramIntent, paramFromServiceMsg, arrayOfByte, false);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (str.equals("CertifiedAccountSvc.certified_account_read.GetFollowList"))
          {
            a(paramIntent, paramFromServiceMsg, arrayOfByte, true);
            return;
          }
        } while (str.equals("secmsg.configs"));
        if (str.equals("get_business_recommend"))
        {
          h(paramIntent, paramFromServiceMsg, arrayOfByte);
          return;
        }
        if (str.equals("send_pre_message_status"))
        {
          i(paramIntent, paramFromServiceMsg, arrayOfByte);
          return;
        }
        if (str.equals("pull_aio_history_msg"))
        {
          e(paramIntent, paramFromServiceMsg, paramObject);
          return;
        }
      } while (str.equals("pull_account_detail_dynamic_list"));
      if (str.equals("PubAccountSvc.net_connect_info"))
      {
        PublicAccountWebReport.handlereportPublicAccountNetInfoResponse(paramIntent, paramFromServiceMsg, paramObject);
        return;
      }
      if (TextUtils.equals(str, "set_message_configuration"))
      {
        c(paramIntent, paramFromServiceMsg, paramObject);
        return;
      }
      if (TextUtils.equals(str, "getGuideFriends"))
      {
        d(paramIntent, paramFromServiceMsg, paramObject);
        return;
      }
      if (TextUtils.equals(str, "get_message_configuration"))
      {
        b(paramIntent, paramFromServiceMsg, paramObject);
        return;
      }
      if (TextUtils.equals(str, "ConfigSvc.getRecvMsgState"))
      {
        i(paramIntent, paramFromServiceMsg);
        return;
      }
    } while (!TextUtils.equals(str, "ConfigSvc.setRecvMsgState"));
    h(paramFromServiceMsg);
  }
  
  public void a(String paramString1, double paramDouble1, double paramDouble2, String paramString2)
  {
    try
    {
      long l = Long.valueOf(paramString1).longValue();
      paramString1 = new mobileqq_mp.SendLBSInfoRequest();
      paramString1.luin.set(l);
      paramString1.latitude.set(paramDouble1);
      paramString1.longitude.set(paramDouble2);
      paramString1.cityinfo.set(paramString2);
      paramString2 = createToServiceMsg("PubAccountSvc.ReportLbs");
      paramString2.putWupBuffer(paramString1.toByteArray());
      sendPbReq(paramString2);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void a(String paramString, long paramLong, int paramInt, BusinessObserver paramBusinessObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApp(), kbs.class);
    localNewIntent.putExtra("cmd", "pull_aio_history_msg");
    historyMsg.AioHistoryMsgRequest localAioHistoryMsgRequest = new historyMsg.AioHistoryMsgRequest();
    localAioHistoryMsgRequest.puin.set(Long.parseLong(paramString));
    localAioHistoryMsgRequest.msg_id.set(paramLong);
    localAioHistoryMsgRequest.msg_cnt.set(paramInt);
    localNewIntent.putExtra("data", localAioHistoryMsgRequest.toByteArray());
    if (paramBusinessObserver != null) {
      localNewIntent.setObserver(paramBusinessObserver);
    }
    for (;;)
    {
      this.app.startServlet(localNewIntent);
      anot.a(this.app, "CliOper", "", "", "0X8006502", "0X8006502", 0, 0, "", "", "", "");
      return;
      kbs.aL(localNewIntent);
    }
  }
  
  public void bb(Object paramObject)
  {
    acje.a locala = new acje.a();
    locala.mErrCode = 0;
    long l = SystemClock.uptimeMillis();
    Object localObject = (acja)this.app.getManager(56);
    if ((paramObject instanceof AccountDetail))
    {
      locala.a = PublicAccountInfo.createPublicAccount((AccountDetail)paramObject, l);
      ((acja)localObject).f((AccountDetail)paramObject);
      ((acja)localObject).c(locala.a);
      oan.a().a(this.app, ((acja)localObject).ec());
      if (((paramObject instanceof AccountDetail)) && (QzoneConfig.getInstance().getConfig("qqsubscribe", "JumpToNewServiceAccount", 1) <= 0)) {
        nyn.a().k(this.app, locala.a.getUin());
      }
      localObject = (kdm)this.app.getManager(88);
      if (localObject != null) {
        if (locala.a != null) {
          break label199;
        }
      }
    }
    label199:
    for (paramObject = null;; paramObject = locala.a.getUin())
    {
      ((kdm)localObject).bs(paramObject, "onFollow");
      notifyUI(101, true, locala);
      return;
      if (!(paramObject instanceof EqqDetail)) {
        break;
      }
      locala.a = PublicAccountInfo.createPublicAccount((EqqDetail)paramObject, l);
      break;
    }
  }
  
  public void bc(Object paramObject)
  {
    acje.a locala = new acje.a();
    locala.mErrCode = 0;
    long l = SystemClock.uptimeMillis();
    Object localObject = (acja)this.app.getManager(56);
    if ((paramObject instanceof AccountDetail))
    {
      locala.a = PublicAccountInfo.createPublicAccount((AccountDetail)paramObject, l);
      ((acja)localObject).g((AccountDetail)paramObject);
      ((acja)localObject).d(locala.a);
      if ((paramObject instanceof EqqDetail))
      {
        aced localaced = (aced)this.app.getManager(69);
        if (localaced != null) {
          localaced.g((EqqDetail)paramObject);
        }
      }
      oan.a().a(this.app, ((acja)localObject).ec());
      if ((paramObject instanceof AccountDetail)) {
        nyn.a().k(this.app, locala.a.getUin());
      }
      localObject = (kdm)this.app.getManager(88);
      if (localObject != null) {
        if (locala.a != null) {
          break label218;
        }
      }
    }
    label218:
    for (paramObject = null;; paramObject = locala.a.getUin())
    {
      ((kdm)localObject).bs(paramObject, "onUnfollow");
      notifyUI(102, true, locala);
      return;
      if (!(paramObject instanceof EqqDetail)) {
        break;
      }
      locala.a = PublicAccountInfo.createPublicAccount((EqqDetail)paramObject, l);
      break;
    }
  }
  
  public void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    int i;
    long l;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      i = paramIntent.getIntExtra("kandian_seq", 0);
      l = paramIntent.getLongExtra("uin", 0L);
      if (!bool1) {
        break label253;
      }
      paramIntent = new mobileqq_mp.SetMessageConfigurationResponse();
    }
    label253:
    for (;;)
    {
      try
      {
        paramIntent.mergeFrom((byte[])paramObject);
        bool1 = bool2;
        if (paramIntent.ret_info.has())
        {
          bool1 = bool2;
          if (paramIntent.ret_info.ret_code.has())
          {
            j = paramIntent.ret_info.ret_code.get();
            if (j != 0) {
              continue;
            }
            bool1 = true;
          }
        }
      }
      catch (Exception paramIntent)
      {
        int j;
        QLog.d("PublicAccountHandler", 1, "handleKandianSubscribe fail:", paramIntent);
        bool1 = bool2;
        continue;
      }
      QLog.d("PublicAccountHandler", 1, "handleSetKandianSubscribeStatusRsp: " + l + ", seq : " + i);
      paramIntent = new HashMap();
      paramIntent.put("uin", Long.valueOf(l));
      paramIntent.put("seq", Integer.valueOf(i));
      notifyUI(108, bool1, paramIntent);
      return;
      bool1 = false;
      break;
      QLog.d("PublicAccountHandler", 1, "handleKandianSubscribe fail code:" + j);
      bool1 = bool2;
    }
  }
  
  public void cLg()
  {
    notifyUI(103, true, null);
  }
  
  public void cLh()
  {
    this.bIN = false;
  }
  
  public void cLi()
  {
    al(0L, true);
    al(0L, false);
    ak(0L, true);
    ak(0L, false);
    EB("");
  }
  
  public void cLj()
  {
    if (this.jq != null) {
      this.jq.clear();
    }
  }
  
  /* Error */
  public void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 6
    //   6: new 1130	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 1131	java/util/ArrayList:<init>	()V
    //   13: astore 8
    //   15: aload_2
    //   16: invokevirtual 375	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   19: ifeq +161 -> 180
    //   22: aload_3
    //   23: ifnull +157 -> 180
    //   26: iconst_1
    //   27: istore 5
    //   29: iload 5
    //   31: ifeq +194 -> 225
    //   34: new 1133	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody
    //   37: dup
    //   38: invokespecial 1134	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:<init>	()V
    //   41: astore_1
    //   42: aload_1
    //   43: aload_3
    //   44: checkcast 759	[B
    //   47: checkcast 759	[B
    //   50: invokevirtual 1135	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   53: pop
    //   54: iload 7
    //   56: istore 5
    //   58: aload_1
    //   59: getfield 1138	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:ret_info	Lcom/tencent/mobileqq/biuGuide/SSOBiuGuide$RetInfo;
    //   62: invokevirtual 1141	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RetInfo:has	()Z
    //   65: ifeq +136 -> 201
    //   68: aload_1
    //   69: getfield 1138	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:ret_info	Lcom/tencent/mobileqq/biuGuide/SSOBiuGuide$RetInfo;
    //   72: getfield 1142	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RetInfo:ret_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   75: invokevirtual 408	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   78: istore 4
    //   80: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +27 -> 110
    //   86: ldc 121
    //   88: iconst_1
    //   89: iconst_2
    //   90: anewarray 1144	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: ldc_w 1146
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: iload 4
    //   103: invokestatic 778	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: aastore
    //   107: invokestatic 1149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   110: iload 7
    //   112: istore 5
    //   114: iload 4
    //   116: ifne +85 -> 201
    //   119: aload_1
    //   120: getfield 1152	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:rpt_msg_uin_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   123: invokevirtual 1153	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   126: ifne +93 -> 219
    //   129: iconst_0
    //   130: istore 4
    //   132: iload 4
    //   134: aload_1
    //   135: getfield 1152	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:rpt_msg_uin_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   138: invokevirtual 1154	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   141: if_icmpge +78 -> 219
    //   144: aload 8
    //   146: aload_1
    //   147: getfield 1152	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:rpt_msg_uin_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   150: iload 4
    //   152: invokevirtual 1157	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   155: checkcast 1159	com/tencent/mobileqq/biuGuide/SSOBiuGuide$UinInfo
    //   158: getfield 1160	com/tencent/mobileqq/biuGuide/SSOBiuGuide$UinInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   161: invokevirtual 663	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   164: invokestatic 767	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   167: invokevirtual 1163	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   170: pop
    //   171: iload 4
    //   173: iconst_1
    //   174: iadd
    //   175: istore 4
    //   177: goto -45 -> 132
    //   180: iconst_0
    //   181: istore 5
    //   183: goto -154 -> 29
    //   186: astore_1
    //   187: iload 6
    //   189: istore 5
    //   191: ldc 121
    //   193: iconst_1
    //   194: ldc_w 1165
    //   197: aload_1
    //   198: invokestatic 1121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   201: aload_0
    //   202: bipush 110
    //   204: iload 5
    //   206: aload 8
    //   208: invokevirtual 433	com/tencent/mobileqq/app/PublicAccountHandler:notifyUI	(IZLjava/lang/Object;)V
    //   211: return
    //   212: astore_1
    //   213: iconst_1
    //   214: istore 5
    //   216: goto -25 -> 191
    //   219: iconst_1
    //   220: istore 5
    //   222: goto -21 -> 201
    //   225: goto -24 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	PublicAccountHandler
    //   0	228	1	paramIntent	Intent
    //   0	228	2	paramFromServiceMsg	FromServiceMsg
    //   0	228	3	paramObject	Object
    //   78	98	4	i	int
    //   27	194	5	bool1	boolean
    //   4	184	6	bool2	boolean
    //   1	110	7	bool3	boolean
    //   13	194	8	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   42	54	186	java/lang/Exception
    //   58	110	186	java/lang/Exception
    //   119	129	212	java/lang/Exception
    //   132	171	212	java/lang/Exception
  }
  
  public void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 1;
    int k = 0;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountHandler", 2, "handleAIOHistoryMsg onReceive :" + bool);
      }
      if (!bool) {}
    }
    for (;;)
    {
      int j;
      try
      {
        paramFromServiceMsg = new historyMsg.AioHistoryMsgResponse();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        j = paramFromServiceMsg.ret_info.ret_code.get();
        if (j != 0) {
          break label385;
        }
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountHandler", 2, "result: " + j);
        }
        if (paramFromServiceMsg.msg_infos.has()) {
          break label363;
        }
        j = 2;
        notifyUI(105, true, Integer.valueOf(j));
        if ((i == 0) || (!paramFromServiceMsg.msg_infos.has()) || (!paramFromServiceMsg.puin.has())) {
          break label378;
        }
        l = paramFromServiceMsg.puin.get();
        paramIntent = new ArrayList();
        paramFromServiceMsg = paramFromServiceMsg.msg_infos.get();
        if (paramFromServiceMsg == null) {
          i = 0;
        } else {
          i = paramFromServiceMsg.size();
        }
      }
      catch (Exception paramIntent)
      {
        long l;
        msg_comm.Msg localMsg;
        if (!QLog.isColorLevel()) {
          break label378;
        }
      }
      if (j < i)
      {
        paramObject = ((ByteStringMicro)paramFromServiceMsg.get(j)).toByteArray();
        localMsg = new msg_comm.Msg();
        localMsg.mergeFrom(aqgo.decode(paramObject, 0));
        paramIntent.add(localMsg);
        j += 1;
      }
      else if ((paramIntent != null) && (paramIntent.size() != 0))
      {
        this.bIO = true;
        this.QB = l;
        new jyl(this.app, this.app.a()).b(l, paramIntent);
        return;
        QLog.e("PublicAccountHandler", 2, "handleGetRecommendList onReceive fail: ", paramIntent);
        return;
        notifyUI(105, true, Integer.valueOf(1));
        return;
        label363:
        j = 0;
        continue;
        j = k;
        if (i > 0) {}
      }
      else
      {
        label378:
        return;
        bool = false;
        break;
        label385:
        i = 0;
      }
    }
  }
  
  public void h(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountHandler", 2, "handleSetRecvMsgState resp.isSuccess() = " + paramFromServiceMsg.isSuccess());
    }
    if (paramFromServiceMsg == null) {}
    boolean bool;
    do
    {
      return;
      bool = paramFromServiceMsg.isSuccess();
    } while (!bool);
    try
    {
      notifyUI(112, bool, Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new SetRecvMsgStateRsp()));
      return;
    }
    catch (Throwable paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
    }
  }
  
  public void i(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {}
    for (;;)
    {
      return;
      long l = paramIntent.getLongExtra("uin", 0L);
      QLog.d("PublicAccountHandler", 1, "handleGetRecvMsgState, uin = " + l + ",resp.isSuccess() = " + paramFromServiceMsg.isSuccess());
      if (paramFromServiceMsg.isSuccess()) {
        try
        {
          paramIntent = Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GetRecvMsgStateRsp());
          if ((paramIntent instanceof GetRecvMsgStateRsp))
          {
            paramIntent = (GetRecvMsgStateRsp)paramIntent;
            this.app.getApp().getSharedPreferences("public_account_detail_setting_status", 0).edit().putInt("setting_result_" + l + "_" + this.app.getCurrentAccountUin(), paramIntent.result).putInt("setting_status_" + l + "_" + this.app.getCurrentAccountUin(), paramIntent.state).commit();
            paramIntent = this.app.getHandler(juk.class);
            if (paramIntent != null)
            {
              paramIntent.sendEmptyMessage(1000);
              return;
            }
          }
        }
        catch (Throwable paramIntent)
        {
          paramIntent.printStackTrace();
        }
      }
    }
  }
  
  public void i(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      try
      {
        paramIntent = new mobileqq_mp.SendPreMessageStatusResponse();
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((!paramIntent.ret_info.has()) || (!((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.has())) {
          break label177;
        }
        i = ((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.get();
        if (i != 0)
        {
          if (!QLog.isColorLevel()) {
            break label176;
          }
          QLog.d("PublicAccountHandler", 2, "handlePreSendMsg error, errcode: " + i);
          return;
        }
        if (!QLog.isColorLevel()) {
          break label176;
        }
        QLog.d("PublicAccountHandler", 2, "handlePreSendMsg success: package size is " + paramArrayOfByte.length + " Byte");
        return;
      }
      catch (Exception paramIntent)
      {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountHandler", 2, "handlePreSendMsg  failed!");
      }
      label176:
      return;
      label177:
      int i = -1;
    }
  }
  
  public boolean isNeedUpdate()
  {
    return this.bIN;
  }
  
  /* Error */
  public void j(long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +33 -> 36
    //   6: ldc 121
    //   8: iconst_2
    //   9: new 137	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1286
    //   19: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: lload_1
    //   23: l2i
    //   24: invokestatic 1290	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   27: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: lload_1
    //   37: l2i
    //   38: lookupswitch	default:+26->64, 40:+27->65, 63:+126->164
    //   65: new 1292	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody
    //   68: dup
    //   69: invokespecial 1293	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:<init>	()V
    //   72: aload_3
    //   73: invokevirtual 1294	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   76: checkcast 1292	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody
    //   79: astore_3
    //   80: aload_3
    //   81: getfield 1297	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   84: invokevirtual 408	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   87: istore 4
    //   89: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +30 -> 122
    //   95: ldc 121
    //   97: iconst_2
    //   98: new 137	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 1299
    //   108: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: iload 4
    //   113: invokevirtual 369	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: iload 4
    //   124: iconst_1
    //   125: if_icmpne +18 -> 143
    //   128: aload_0
    //   129: aload_3
    //   130: getfield 1303	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:msg_rsp_followlist	Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList;
    //   133: invokevirtual 1304	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   136: checkcast 644	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList
    //   139: invokespecial 1306	com/tencent/mobileqq/app/PublicAccountHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList;)V
    //   142: return
    //   143: iload 4
    //   145: iconst_2
    //   146: if_icmpne -82 -> 64
    //   149: aload_0
    //   150: aload_3
    //   151: getfield 1310	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:msg_rsp_typelist	Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList;
    //   154: invokevirtual 1313	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   157: checkcast 1312	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList
    //   160: invokespecial 1315	com/tencent/mobileqq/app/PublicAccountHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList;)V
    //   163: return
    //   164: new 1317	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody
    //   167: dup
    //   168: invokespecial 1318	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody:<init>	()V
    //   171: astore 7
    //   173: aload 7
    //   175: aload_3
    //   176: invokevirtual 1319	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   179: pop
    //   180: aload 7
    //   182: getfield 1322	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody:rpt_msg_pubunikey	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   185: invokevirtual 442	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   188: invokeinterface 603 1 0
    //   193: astore_3
    //   194: aload_3
    //   195: invokeinterface 608 1 0
    //   200: ifeq -136 -> 64
    //   203: aload_3
    //   204: invokeinterface 612 1 0
    //   209: checkcast 1324	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$PubUniKey
    //   212: astore 7
    //   214: aload 7
    //   216: getfield 1327	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$PubUniKey:uint64_fromPubUin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   219: invokevirtual 663	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   222: lstore_1
    //   223: aload 7
    //   225: getfield 1330	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$PubUniKey:uint64_qwMsgId	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   228: invokevirtual 663	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   231: lstore 5
    //   233: lload_1
    //   234: invokestatic 1332	java/lang/Long:toString	(J)Ljava/lang/String;
    //   237: astore 7
    //   239: aload_0
    //   240: getfield 81	com/tencent/mobileqq/app/PublicAccountHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   243: invokevirtual 693	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   246: aload 7
    //   248: sipush 1008
    //   251: aconst_null
    //   252: invokevirtual 1335	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;I[I)Ljava/util/List;
    //   255: invokeinterface 603 1 0
    //   260: astore 8
    //   262: aload 8
    //   264: invokeinterface 608 1 0
    //   269: ifeq -75 -> 194
    //   272: aload 8
    //   274: invokeinterface 612 1 0
    //   279: checkcast 1337	com/tencent/mobileqq/data/MessageRecord
    //   282: astore 9
    //   284: aload 9
    //   286: invokestatic 1342	wna:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/data/PAMessage;
    //   289: astore 10
    //   291: aload 10
    //   293: ifnull +37 -> 330
    //   296: aload 10
    //   298: getfield 1347	com/tencent/mobileqq/data/PAMessage:mMsgId	J
    //   301: lload 5
    //   303: lcmp
    //   304: ifne +26 -> 330
    //   307: aload_0
    //   308: getfield 81	com/tencent/mobileqq/app/PublicAccountHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   311: invokevirtual 693	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   314: aload 7
    //   316: sipush 1008
    //   319: aload 9
    //   321: getfield 1350	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   324: invokevirtual 1354	com/tencent/imcore/message/QQMessageFacade:t	(Ljava/lang/String;IJ)V
    //   327: goto -133 -> 194
    //   330: aload 9
    //   332: ldc_w 1356
    //   335: invokevirtual 1359	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   338: astore 10
    //   340: aload 10
    //   342: ifnull -80 -> 262
    //   345: aload 10
    //   347: invokestatic 656	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   350: lload 5
    //   352: lcmp
    //   353: ifne -91 -> 262
    //   356: aload_0
    //   357: getfield 81	com/tencent/mobileqq/app/PublicAccountHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   360: invokevirtual 693	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   363: aload 7
    //   365: sipush 1008
    //   368: aload 9
    //   370: getfield 1350	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   373: invokevirtual 1354	com/tencent/imcore/message/QQMessageFacade:t	(Ljava/lang/String;IJ)V
    //   376: goto -182 -> 194
    //   379: astore 9
    //   381: goto -119 -> 262
    //   384: astore_3
    //   385: return
    //   386: astore_3
    //   387: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	PublicAccountHandler
    //   0	388	1	paramLong	long
    //   0	388	3	paramArrayOfByte	byte[]
    //   87	60	4	i	int
    //   231	120	5	l	long
    //   171	193	7	localObject1	Object
    //   260	13	8	localIterator	Iterator
    //   282	87	9	localMessageRecord	com.tencent.mobileqq.data.MessageRecord
    //   379	1	9	localException	Exception
    //   289	57	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   345	376	379	java/lang/Exception
    //   65	122	384	java/lang/Exception
    //   128	142	384	java/lang/Exception
    //   149	163	384	java/lang/Exception
    //   164	194	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   194	262	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   262	291	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   296	327	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   330	340	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   345	376	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void m(String paramString, long paramLong, int paramInt)
  {
    a(paramString, paramLong, paramInt, null);
  }
  
  public Class<? extends acci> observerClass()
  {
    return acje.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {}
    for (;;)
    {
      return;
      paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
      if ((paramToServiceMsg == null) || (paramToServiceMsg.length() == 0)) {
        continue;
      }
      if ("PubAccountSvc.ReportLbs".equalsIgnoreCase(paramToServiceMsg))
      {
        if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
          continue;
        }
        return;
      }
      if ((!"QQWeatherReport.getWeatherInfo".equals(paramToServiceMsg)) || (!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
        continue;
      }
      paramToServiceMsg = new WeatherReportInfo.GetWeatherMessageRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        label84:
        if (paramToServiceMsg == null) {
          continue;
        }
        int i = paramToServiceMsg.cmd.get();
        paramToServiceMsg = paramToServiceMsg.string_msg.get();
        if ((i == 1) || (i == 2))
        {
          paramFromServiceMsg = (a)this.jq.get(Integer.valueOf(i));
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.onComplete(paramToServiceMsg);
          }
          this.jq.remove(Integer.valueOf(i));
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PublicAccountHandler", 2, "type = " + i + " msg =" + paramToServiceMsg);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        break label84;
      }
    }
  }
  
  static class FolderRefreshRunnable
    implements Runnable
  {
    private final WeakReference<acja> an;
    private final WeakReference<QQAppInterface> mApp;
    
    public FolderRefreshRunnable(QQAppInterface paramQQAppInterface, acja paramacja)
    {
      this.mApp = new WeakReference(paramQQAppInterface);
      this.an = new WeakReference(paramacja);
    }
    
    public void run()
    {
      Object localObject = (QQAppInterface)this.mApp.get();
      acja localacja = (acja)this.an.get();
      if ((localObject != null) && (localacja != null))
      {
        oan.a().a((QQAppInterface)localObject, localacja.ec());
        nyn.a().ae((QQAppInterface)localObject);
        oan.a().at((QQAppInterface)localObject);
        localObject = lbz.a();
        if (localObject != null) {
          ((lbz)localObject).aJk();
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onComplete(String paramString);
  }
  
  public class b
    implements andh
  {
    public b() {}
    
    public ReqItem a(int paramInt)
    {
      ReqItem localReqItem = new ReqItem();
      localReqItem.cOperType = 0;
      localReqItem.eServiceID = 102;
      boolean bool = obt.GA();
      long l1 = PublicAccountHandler.a(PublicAccountHandler.this, bool);
      long l2 = PublicAccountHandler.b(PublicAccountHandler.this, bool);
      Object localObject2 = PublicAccountHandler.a(PublicAccountHandler.this);
      if (bool)
      {
        localObject1 = new CertifiedAccountRead.StGetFollowListReq();
        ((CertifiedAccountRead.StGetFollowListReq)localObject1).seq.set(aqft.ag(l1));
        ((CertifiedAccountRead.StGetFollowListReq)localObject1).count.set(aqft.ag(1L));
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((CertifiedAccountRead.StGetFollowListReq)localObject1).attach_info.set((String)localObject2);
        }
        localObject2 = new PROTOCAL.StQWebReq();
        ((PROTOCAL.StQWebReq)localObject2).Seq.set(-1L);
        ((PROTOCAL.StQWebReq)localObject2).qua.set(avpq.getQUA3());
        ((PROTOCAL.StQWebReq)localObject2).deviceInfo.set(avpp.a().getDeviceInfor());
        ((PROTOCAL.StQWebReq)localObject2).busiBuff.set(ByteStringMicro.copyFrom(((CertifiedAccountRead.StGetFollowListReq)localObject1).toByteArray()));
        localObject1 = sfx.getTraceId();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((PROTOCAL.StQWebReq)localObject2).traceid.set((String)localObject1);
        }
        localObject2 = ((PROTOCAL.StQWebReq)localObject2).toByteArray();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new byte[4];
        }
        localReqItem.vecParam = aqnv.I((byte[])localObject1);
        return localReqItem;
      }
      Object localObject1 = new mobileqq_mp.GetUserFollowListRequest();
      ((mobileqq_mp.GetUserFollowListRequest)localObject1).follow_seqno.set((int)l1);
      ((mobileqq_mp.GetUserFollowListRequest)localObject1).public_account_seqno.set((int)l2);
      ((mobileqq_mp.GetUserFollowListRequest)localObject1).begin.set(0);
      ((mobileqq_mp.GetUserFollowListRequest)localObject1).limit.set(1);
      ((mobileqq_mp.GetUserFollowListRequest)localObject1).version.set(1);
      ((mobileqq_mp.GetUserFollowListRequest)localObject1).is_increment.set(true);
      localReqItem.vecParam = aqnv.I(((mobileqq_mp.GetUserFollowListRequest)localObject1).toByteArray());
      return localReqItem;
    }
    
    public void a(RespItem paramRespItem)
    {
      if ((paramRespItem.eServiceID == 102) && (paramRespItem.cResult == 0)) {
        PublicAccountHandler.this.cLh();
      }
    }
    
    public int mT()
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler
 * JD-Core Version:    0.7.0.1
 */