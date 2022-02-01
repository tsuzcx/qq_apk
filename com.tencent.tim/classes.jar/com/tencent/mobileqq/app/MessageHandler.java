package com.tencent.mobileqq.app;

import AccostSvc.RespClientMsg;
import AccostSvc.RespGetBlackList;
import AccostSvc.RespHeader;
import AccostSvc.SvrMsg;
import GeneralSettings.Setting;
import MessageSvcPack.GroupInfo;
import MessageSvcPack.MsgFilter;
import MessageSvcPack.PullGroupSeqParam;
import MessageSvcPack.RequestPushStatus;
import MessageSvcPack.SvcRequestGetMsgV2;
import MessageSvcPack.SvcRequestPullDisMsgSeq;
import MessageSvcPack.SvcRequestPullGroupMsgSeq;
import MessageSvcPack.SvcResponseDelRoamMsg;
import MessageSvcPack.SvcResponsePullDisMsgSeq;
import MessageSvcPack.SvcResponsePullGroupMsgSeq;
import MessageSvcPack.SvcResponseSetRoamMsg;
import MessageSvcPack.stConfNumInfo;
import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.DeviceInfo;
import PushAdMsg.AdMsgInfo;
import PushNotifyPack.C2CMsgReadedNotify;
import PushNotifyPack.DisMsgReadedNotify;
import PushNotifyPack.GroupMsgReadedNotify;
import PushNotifyPack.RequestPushNotify;
import PushNotifyPack.SvcRequestPushReadedNotify;
import QQService.DiscussInfo;
import QQService.StreamData;
import QQService.StreamInfo;
import QQService.SvcReqMSFLoginNotify;
import RegisterProxySvcPack.RegisterPushNotice;
import RegisterProxySvcPack.SvcRequestPullDisGroupSeq;
import RegisterProxySvcPack.SvcResponsePullDisGroupSeq;
import RegisterProxySvcPack.stDisGroupInfo;
import SharpSvrPack.MultiVideoMsg;
import acbn;
import accg;
import acci;
import acde;
import acdt;
import acdu;
import acfd;
import acff;
import acfp;
import acfx;
import achn;
import acho;
import achp;
import achq;
import achq.a;
import acjq;
import ackv;
import aclo;
import acql;
import acql.a;
import acqn;
import acqs;
import acqt;
import acqw;
import acrc;
import acrg;
import acrh;
import acri;
import acrl;
import acrp;
import acsb;
import acsd;
import acxw;
import aegu;
import aehj;
import aehk;
import afke;
import ahlj;
import ahwa;
import ahwb;
import aiyy;
import ajdg;
import ajkw;
import ajlc;
import ajrk;
import alip;
import aluu;
import amja;
import amzo;
import amzq;
import anae;
import anaz;
import anaz.c;
import anaz.e;
import anbb;
import anbd.b;
import anbd.c;
import anbh;
import anbi;
import anbk;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.Pair;
import angb;
import anot;
import anpc;
import anqo;
import anxk;
import anxr;
import aomq;
import aooi;
import apdd;
import apde;
import apsa;
import apsw;
import aqcu;
import aqel;
import aqft;
import aqgb;
import aqge;
import aqgv;
import aqgx;
import aqgz;
import aqiw;
import aqoj;
import aqxg;
import aqxh;
import ashy;
import auqw;
import avhq;
import aviq;
import azcl;
import com.tencent.av.VideoConstants;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.FunnyFaceMessage;
import com.tencent.mobileqq.data.FunnyFaceMessage.Turntable;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.microapp.sdk.MiniAppController;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
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
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.pb.onlinepush.OnlinePushTrans.ExtGroupKeyInfo;
import com.tencent.pb.onlinepush.OnlinePushTrans.PbMsgInfo;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import jnm;
import jnm.d;
import kbp;
import kct;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbC2CReadedReportResp;
import msf.msgsvc.msg_svc.PbDiscussReadedReportResp;
import msf.msgsvc.msg_svc.PbGetDiscussMsgReq;
import msf.msgsvc.msg_svc.PbGetDiscussMsgResp;
import msf.msgsvc.msg_svc.PbGetGroupMsgReq;
import msf.msgsvc.msg_svc.PbGetGroupMsgResp;
import msf.msgsvc.msg_svc.PbGetMsgReq;
import msf.msgsvc.msg_svc.PbGetOneDayRoamMsgReq;
import msf.msgsvc.msg_svc.PbGetRoamMsgReq;
import msf.msgsvc.msg_svc.PbGroupReadedReportResp;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportResp;
import msf.msgsvc.msg_svc.PbPullGroupMsgSeqReq;
import msf.msgsvc.msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq;
import msf.msgsvc.msg_svc.PbPullGroupMsgSeqResp;
import msf.msgsvc.msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp;
import msf.msgsvc.msg_svc.PbSearchRoamMsgInCloudReq;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.PbSendMsgResp;
import msf.msgsvc.msg_svc.PbUnReadMsgSeqReq;
import msf.msgsvc.msg_svc.PbUnReadMsgSeqResp;
import msf.msgsvc.msg_svc.TransSvrInfo;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import msf.registerproxy.register_proxy.DiscussList;
import msf.registerproxy.register_proxy.GroupList;
import msf.registerproxy.register_proxy.SvcPbResponsePullDisMsgProxy;
import msf.registerproxy.register_proxy.SvcRegisterProxyMsgResp;
import msf.registerproxy.register_proxy.SvcResponseMsgInfo;
import msf.registerproxy.register_proxy.SvcResponsePbPullGroupMsgProxy;
import obt;
import oec;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import protocol.KQQConfig.GetResourceReqInfo;
import rwp;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_receipt.MsgInfo;
import tencent.im.msg.im_receipt.ReceiptInfo;
import tencent.im.msg.im_receipt.ReceiptReq;
import tencent.im.msg.im_receipt.ReceiptResp;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x9db.cmd0x9db.ReqBody;
import tencent.im.oidb.cmd0x9db.cmd0x9db.RspBody;
import tencent.im.oidb.cmd0xa89.oidb_0xa89.ReqBody;
import tencent.im.oidb.cmd0xa89.oidb_0xa89.RspBody;
import tencent.im.oidb.cmd0xb31.oidb_0xb31.RspBody;
import tencent.im.oidb.cmd0xb31.oidb_0xb31.SimilarItem;
import tencent.im.oidb.cmd0xbad.oidb_0xbad.ReqBody;
import tencent.im.oidb.oidb_0xd55.CheckAppSignReq;
import tencent.im.oidb.oidb_0xd55.CheckMiniAppReq;
import tencent.im.oidb.oidb_0xd55.CheckUserReq;
import tencent.im.oidb.oidb_0xd55.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.oidb.qqconnect.ConnectClientInfo;
import tencent.im.oidb.searcher.oidb_c2c_searcher.Iterator;
import tencent.im.oidb.searcher.oidb_c2c_searcher.MsgKey;
import tencent.im.oidb.searcher.oidb_c2c_searcher.ReqBody;
import tnt;
import tnv;
import tob;
import tog;
import top;
import tos;
import toy;
import tpu;
import tpv;
import ujt;
import wja;
import wte;
import ysf;
import zxj;

public class MessageHandler
  extends accg
  implements acrh
{
  public static boolean bIk;
  public static boolean bIl = true;
  public static boolean bIp = true;
  public static int cwL = 200;
  public static int cwM = 500;
  static int first = 1;
  public long Qj;
  private long Qk;
  private long Ql;
  private long Qm;
  public anaz a;
  e jdField_a_of_type_ComTencentMobileqqAppMessageHandler$e;
  private MessageHandleThread[] jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread;
  private final HashSet<String> aB = new HashSet();
  private Object bE = new Object();
  public boolean bIm;
  protected boolean bIn;
  protected boolean bIo;
  private boolean bIq;
  private boolean bIr;
  private boolean bIs;
  private boolean bIt;
  private boolean bIu;
  private final Object cA = new Object();
  private AtomicBoolean cE = new AtomicBoolean(false);
  protected int cwB;
  private int cwC;
  private int cwD;
  protected int cwE;
  protected int cwF;
  private int cwG;
  private int cwH;
  private final int cwI = 450000;
  private final int cwJ = 9;
  private final int cwK = 3;
  private int cwN;
  private final int cwO = 2;
  private int cwP;
  private final int cwQ = 3;
  public int cwR;
  private final int cwS = 6;
  private Object cy = new Object();
  Object cz = new Object();
  private ConcurrentHashMap<String, Object> ef = new ConcurrentHashMap();
  private String[] ei;
  private String[] ej;
  private EntityManager em;
  private Runnable fJ;
  private Runnable fK;
  private HashMap<String, Boolean> iQ = new HashMap();
  private HashMap<String, Boolean> iR = new HashMap();
  private final HashMap<Long, SendMessageHandler> iS = new HashMap();
  private HashMap<String, b> iT = new HashMap(10);
  public final HashMap<String, List<msg_comm.Msg>> iU = new HashMap();
  private boolean isDestroyed;
  private volatile Pair<RegisterPushNotice, Long> j;
  private Map<String, tnv> jn = new ConcurrentHashMap();
  private final int[] kk = new int[0];
  private final int[] kl = new int[0];
  private acfd jdField_l_of_type_Acfd = new acho(this);
  private Thread jdField_l_of_type_JavaLangThread;
  private Thread m;
  private ArrayList<Setting> tj;
  private ArrayList<c> tk;
  private ArrayList<c> tl;
  ArrayList<String> tm = new ArrayList();
  protected List<register_proxy.GroupList> xG;
  
  public MessageHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    paramQQAppInterface.addObserver(this.jdField_l_of_type_Acfd, true);
    this.jdField_a_of_type_Anaz = paramQQAppInterface.a();
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("mobileQQ", 0);
    AppSetting.aNX = paramQQAppInterface.getBoolean(AppSetting.aHQ, true);
    AppSetting.aNY = paramQQAppInterface.getBoolean("c2c_del_msg_oper_enable", true);
  }
  
  private void DO(String paramString)
  {
    ((acff)this.app.getManager(51)).DO(paramString);
  }
  
  private void DP(String paramString)
  {
    ((acff)this.app.getManager(51)).DP(paramString);
  }
  
  private void Em(String paramString)
  {
    eR(paramString, "closeDisOnlineMsgCache");
  }
  
  private void En(String paramString)
  {
    this.app.getCurrentAccountUin();
    eN(paramString, "closeTroopOnlineMsgCache");
  }
  
  private void F(int paramInt, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.equals(""))) {
      return;
    }
    String str = this.app.getCurrentAccountUin();
    long l1 = System.currentTimeMillis() / 1000L;
    ArrayList localArrayList = new ArrayList();
    MessageRecord localMessageRecord = anbi.d(-2013);
    localMessageRecord.init(str, paramString2, str, paramString1, l1, 0, paramInt, 0L);
    localMessageRecord.msgtype = -2013;
    localMessageRecord.isread = true;
    localArrayList.add(localMessageRecord);
    this.app.b().c(localArrayList, String.valueOf(str), false);
  }
  
  private void Ff(boolean paramBoolean)
  {
    this.bIr = paramBoolean;
  }
  
  private void Jq(int paramInt)
  {
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    if (paramInt == 0)
    {
      localQQNotificationManager.cancel("Q.msg.MessageHandler_OfflineNotifition", 264);
      this.bIt = false;
      if (this.fK != null)
      {
        ThreadManager.remove(this.fK);
        this.fK = null;
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 1);
      localQQNotificationManager.cancel("Q.msg.MessageHandler_OfflineNotifition", 263);
      this.bIu = false;
    } while (this.fJ == null);
    ThreadManager.remove(this.fJ);
    this.fJ = null;
  }
  
  private void Js(int paramInt)
  {
    if ((paramInt & 0x2) == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleFirstEnding! isPullCircleStop: " + this.bIm);
      }
      this.bIn = true;
      if (aaJ()) {
        notifyUI(4017, true, null);
      }
    }
  }
  
  private void N(ToServiceMsg paramToServiceMsg)
  {
    cKa();
    if (this.cwR < 6)
    {
      aY(paramToServiceMsg.extraData.getBoolean("isPullRoamMsg"), paramToServiceMsg.extraData.getInt("pullMsgType"));
      this.cwR += 1;
      return;
    }
    O(paramToServiceMsg);
  }
  
  private void O(ToServiceMsg paramToServiceMsg)
  {
    cKa();
    this.cwR = 0;
    Fg(false);
    int i = paramToServiceMsg.extraData.getInt("pullMsgType");
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleGetBuddyMessageError ,pullMsgType:" + i);
    }
    switch (i)
    {
    default: 
      return;
    case 0: 
      notifyUI(4001, false, null);
      notifyUI(4016, false, null);
      return;
    case 1: 
      notifyUI(4001, false, null);
      return;
    }
    notifyUI(4016, false, null);
  }
  
  private void S(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForStructing))) {
      MiniAppController.tryReportShare((MessageForStructing)paramMessageRecord);
    }
  }
  
  private void X(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (this.cwN < 2)
    {
      send(paramToServiceMsg);
      this.cwN += 1;
      return;
    }
    f(5002, false, null);
    this.cwN = 0;
  }
  
  private void Y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(paramToServiceMsg, 3012, false, null);
  }
  
  private void Z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    String str = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    long l2 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l3 = paramToServiceMsg.extraData.getLong("timeOut");
    int n = paramToServiceMsg.extraData.getInt("msgtype");
    int i1 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    int i = paramToServiceMsg.extraData.getInt("retryIndex");
    int k = anbh.b(i1, this.app);
    wte.a().h(this.app, l1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><E><---handleSendC2CMessageError: ---cmd:" + (String)localObject + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + ",sendC2CMessage error : peerUin:" + str + " uniseq:" + l1 + " msgSeq:" + l2 + " msgType:" + n + " uinType:" + k + " routingType:" + i1 + " retryIndex:" + i);
    }
    ae(paramToServiceMsg, paramFromServiceMsg);
    localObject = a(l2);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label296;
      }
      localObject.getClass();
      if (!a((SendMessageHandler)localObject, "msf")) {
        break label296;
      }
    }
    label296:
    while ((480000L != l3) && (!((SendMessageHandler)localObject).aFa())) {
      return;
    }
    n = gy(i1);
    localObject = new Object[6];
    localObject[0] = str;
    localObject[1] = Integer.valueOf(k);
    localObject[2] = Integer.valueOf(0);
    localObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
    localObject[4] = Long.valueOf(l3);
    localObject[5] = Long.valueOf(l1);
    a((Object[])localObject, paramFromServiceMsg.getUin(), paramFromServiceMsg.getResultCode());
    f(n, false, localObject);
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      localObject = new achq.a();
      ((achq.a)localObject).errCode = paramFromServiceMsg.getResultCode();
      ((achq.a)localObject).retryCount = i;
      ((achq.a)localObject).timeoutReason = b(paramFromServiceMsg);
      a(paramToServiceMsg, 5006, false, new Object[] { Long.valueOf(l1), localObject });
      e(str, k, l1, false);
    }
    e(paramToServiceMsg, paramFromServiceMsg, false);
    hB(l2);
  }
  
  private int a(SendMessageHandler paramSendMessageHandler)
  {
    int i;
    do
    {
      i = amzq.seq;
      amzq.seq = i + 1;
    } while (!a(i, paramSendMessageHandler));
    return i;
  }
  
  private Pair<Long, Long> a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "getPullMsgLowSeq uin = " + paramString + " ,type = " + paramInt + " ,lastSeq = " + paramLong1 + " ,expiredSeq = " + paramLong2 + " ,delSeq = " + paramLong3 + " ,svrSeq = " + paramLong4);
    }
    paramString = top.d(this.app.b().k(paramString, paramInt), false);
    long l2 = paramLong1;
    long l3 = paramLong4;
    if (paramString != null)
    {
      l2 = paramLong1;
      l3 = paramLong4;
      if (!paramString.isEmpty())
      {
        long l1 = paramLong1;
        if (((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq < paramLong1) {
          l1 = ((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq;
        }
        l2 = l1;
        l3 = paramLong4;
        if (((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq > paramLong4)
        {
          l3 = ((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq;
          l2 = l1;
        }
      }
    }
    paramLong1 = Math.max(paramLong3, paramLong2);
    paramLong2 = Math.max(paramLong1, l2);
    paramLong3 = Math.max(paramLong1, l3);
    if (paramLong1 >= paramLong2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return lowSeq >= lastSeq");
      }
      return new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong3));
    }
    if (l3 - l2 >= 10L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return pullCount >= 10");
      }
      return new Pair(Long.valueOf(paramLong2), Long.valueOf(paramLong3));
    }
    if ((paramString == null) || (paramString.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return local is null! ");
      }
      return new Pair(Long.valueOf(paramLong2), Long.valueOf(paramLong3));
    }
    paramLong4 = ((MessageRecord)paramString.get(0)).shmsgseq;
    if (1L + paramLong1 >= paramLong4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return lowSeq >= lastBreakSeq");
      }
      return new Pair(Long.valueOf(paramLong2), Long.valueOf(paramLong3));
    }
    if (paramLong3 - paramLong4 >= 10L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return svrSeq - lastBreakSeq >= 10");
      }
      return new Pair(Long.valueOf(paramLong2), Long.valueOf(paramLong3));
    }
    if (paramLong3 > paramLong2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return ok svrSeq > lastSeq , (" + Math.max(paramLong3 - 10L, paramLong1) + "," + paramLong3 + ")");
      }
      return new Pair(Long.valueOf(Math.max(paramLong3 - 10L, paramLong1)), Long.valueOf(paramLong3));
    }
    if (paramLong3 == paramLong2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return ok svrSeq == lastSeq , (" + Math.max(paramLong3 - 10L, paramLong1) + "," + Math.max(paramLong4 - 1L, paramLong1) + ")");
      }
      return new Pair(Long.valueOf(Math.max(paramLong3 - 10L, paramLong1)), Long.valueOf(Math.max(paramLong4 - 1L, paramLong1)));
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "return svrSeq < lastSeq");
    }
    return new Pair(Long.valueOf(paramLong2), Long.valueOf(paramLong3));
  }
  
  private e a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler$e == null) {}
    synchronized (this.cz)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler$e == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler$e = new e(ThreadManager.getSubThreadLooper());
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler$e;
    }
  }
  
  @NotNull
  private ToServiceMsg a(byte paramByte1, byte[] paramArrayOfByte1, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt2, Object paramObject, byte[] paramArrayOfByte2, byte paramByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "createGetOfflineMsgRequest");
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.PbGetMsg");
    localToServiceMsg.extraData.putByte("cChannel", paramByte1);
    localToServiceMsg.extraData.putByteArray("vCookies", paramArrayOfByte1);
    localToServiceMsg.extraData.putInt("cSyncFlag", paramInt1);
    localToServiceMsg.extraData.putByteArray("vSyncCookie", paramArrayOfByte2);
    localToServiceMsg.extraData.putByte("onlineSyncFlag", paramByte2);
    localToServiceMsg.extraData.putBoolean("needNofityConversation", paramBoolean2);
    localToServiceMsg.extraData.putBoolean("isPullRoamMsg", paramBoolean1);
    if (paramString != null) {
      localToServiceMsg.addAttribute("sso_push_timestamp", paramString + "|" + System.currentTimeMillis());
    }
    localToServiceMsg.extraData.putInt("pullMsgType", paramInt2);
    localToServiceMsg.putWupBuffer(a(paramInt1, paramInt2, paramObject, paramArrayOfByte2, paramByte2).toByteArray());
    return localToServiceMsg;
  }
  
  @NotNull
  private ToServiceMsg a(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, long paramLong, int paramInt, acci paramacci, boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    long l1;
    if (paramMessageRecord.msg == null)
    {
      l1 = 0L;
      paramacci = createToServiceMsg("MessageSvc.PbSendMsg", paramacci);
      a(paramMessageRecord, paramacci);
      int i = anbh.c(paramMessageRecord.istroop, this.app);
      long l3 = paramMessageRecord.msgUid;
      int k = (short)(int)paramMessageRecord.msgseq;
      int n = anbk.ab(l3);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, String.format("<PbSendMsg><S> --->createSendRichTextMsgReq, uint32Seq:%d, random:%d, routingType:%d, %s", new Object[] { Integer.valueOf(0xFFFF & k), Integer.valueOf(n), Integer.valueOf(i), paramMessageRecord.getBaseInfoString() }));
      }
      paramacci.extraData.putString("uin", paramMessageRecord.frienduin);
      paramacci.extraData.putLong("msgsize", l1);
      paramacci.extraData.putLong("uniseq", paramMessageRecord.uniseq);
      paramacci.extraData.putLong("timeOut", paramLong);
      paramacci.extraData.putLong("msgSeq", paramMessageRecord.msgseq);
      paramacci.extraData.putLong("startTime", l2);
      paramacci.extraData.putInt("retryIndex", paramInt);
      paramacci.extraData.putInt("uintype", paramMessageRecord.istroop);
      paramacci.extraData.putInt("msgtype", paramMessageRecord.msgtype);
      paramacci.extraData.putInt("ROUNTING_TYPE", i);
      paramacci.extraData.putInt("send_msg_req_size", paramacci.getWupBuffer().length);
      paramacci.putWupBuffer(paramPbSendMsgReq.toByteArray());
      paramacci.setTimeout(paramLong);
      paramacci.addAttribute("msgtype", Integer.valueOf(paramMessageRecord.msgtype));
      paramacci.addAttribute("msgSeq", Long.valueOf(paramMessageRecord.msgseq));
      paramacci.addAttribute("resend_by_user", Boolean.valueOf(paramBoolean));
      paramacci.addAttribute("retryIndex", Integer.valueOf(paramInt));
      if (paramMessageRecord.frienduin != null) {
        break label428;
      }
      paramPbSendMsgReq = "";
      label367:
      paramacci.addAttribute("uin", paramPbSendMsgReq);
      if (paramMessageRecord.senderuin != null) {
        break label436;
      }
    }
    label428:
    label436:
    for (paramMessageRecord = "";; paramMessageRecord = paramMessageRecord.senderuin)
    {
      paramacci.addAttribute("fromUin", paramMessageRecord);
      paramacci.addAttribute("normal_msg", Boolean.valueOf(true));
      return paramacci;
      l1 = paramMessageRecord.msg.getBytes().length;
      break;
      paramPbSendMsgReq = paramMessageRecord.frienduin;
      break label367;
    }
  }
  
  @NotNull
  private msg_svc.PbGetMsgReq a(int paramInt1, int paramInt2, Object paramObject, byte[] paramArrayOfByte, byte paramByte)
  {
    msg_svc.PbGetMsgReq localPbGetMsgReq = new msg_svc.PbGetMsgReq();
    switch (paramInt2)
    {
    }
    for (;;)
    {
      localPbGetMsgReq.sync_flag.set(paramInt1);
      localPbGetMsgReq.ramble_flag.set(0);
      localPbGetMsgReq.context_flag.set(1);
      localPbGetMsgReq.online_sync_flag.set(paramByte);
      localPbGetMsgReq.latest_ramble_number.set(20);
      localPbGetMsgReq.other_ramble_number.set(3);
      if ((paramObject != null) && ((paramObject instanceof RequestPushNotify)))
      {
        paramObject = (RequestPushNotify)paramObject;
        if (paramObject.bytes_server_buf != null)
        {
          localPbGetMsgReq.bytes_server_buf.set(ByteStringMicro.copyFrom(paramObject.bytes_server_buf));
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, new Object[] { "--->>getC2CMessage (PushNotify getMsg) pb:", "MessageSvc.PbGetMsg", ", fill bytes_server_buf=", paramObject.bytes_server_buf.toString() });
          }
        }
      }
      return localPbGetMsgReq;
      localPbGetMsgReq.msg_req_type.set(0);
      if (paramArrayOfByte != null)
      {
        localPbGetMsgReq.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
        continue;
        localPbGetMsgReq.msg_req_type.set(1);
        if (paramArrayOfByte != null)
        {
          localPbGetMsgReq.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
          continue;
          localPbGetMsgReq.msg_req_type.set(2);
          paramArrayOfByte = this.jdField_a_of_type_Anaz.an();
          if (paramArrayOfByte != null) {
            localPbGetMsgReq.pubaccount_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
          }
        }
      }
    }
  }
  
  @NonNull
  private msg_svc.PbSendMsgReq a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3)
  {
    msg_svc.PbSendMsgReq localPbSendMsgReq = new msg_svc.PbSendMsgReq();
    im_receipt.ReceiptReq localReceiptReq = new im_receipt.ReceiptReq();
    localReceiptReq.command.set(paramInt1);
    im_receipt.MsgInfo localMsgInfo = new im_receipt.MsgInfo();
    localMsgInfo.uint64_from_uin.set(paramLong1);
    localMsgInfo.uint64_to_uin.set(paramLong2);
    localMsgInfo.uint32_msg_seq.set(paramInt2);
    localMsgInfo.uint32_msg_random.set(paramInt3);
    localReceiptReq.msg_info.set(localMsgInfo);
    localPbSendMsgReq.receipt_req.set(localReceiptReq);
    return localPbSendMsgReq;
  }
  
  private register_proxy.SvcRegisterProxyMsgResp a(byte[] paramArrayOfByte)
  {
    Object localObject = new register_proxy.SvcRegisterProxyMsgResp();
    try
    {
      paramArrayOfByte = (register_proxy.SvcRegisterProxyMsgResp)((register_proxy.SvcRegisterProxyMsgResp)localObject).mergeFrom(paramArrayOfByte);
      if ((paramArrayOfByte == null) || (!paramArrayOfByte.result.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg package error!");
        }
        notifyUI(4004, false, null);
        localObject = null;
        return localObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg : decode SvcRegisterProxyMsgResp pb:", paramArrayOfByte);
              }
              paramArrayOfByte = null;
            }
            localObject = paramArrayOfByte;
          } while (!paramArrayOfByte.seq.has());
          localObject = paramArrayOfByte;
        } while (paramArrayOfByte.seq.get() == this.cwB);
        localObject = paramArrayOfByte;
      } while (paramArrayOfByte.seq.get() == this.cwC);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).setLength(0);
        ((StringBuilder)localObject).append("handleNewRegisterProxyMsg endSeq wrong! seq=").append(paramArrayOfByte.seq.get()).append(" registerProxyEndSeq=").append(this.cwB).append(" registerProxyEndSeq_numTroop=").append(this.cwC);
        QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public static void a(d paramd, QQAppInterface paramQQAppInterface)
  {
    int i = 2;
    Object localObject = new StringBuilder(256);
    if (QLog.isColorLevel())
    {
      ((StringBuilder)localObject).append("msg send cost per phase--->>").append("send_request:").append(paramd.Qr).append(" ,request_reponse:").append(paramd.Qs).append(" ,netSend_netRecv:").append(paramd.Qt).append(" ,notifyUi_reflash:").append(paramd.Qv).append(" ,mUinType:").append(paramd.mUinType).append(" ,isCrossOper:").append(paramd.bIy);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new HashMap();
    long l1 = paramd.Qr;
    ((HashMap)localObject).put("param_net", String.valueOf(aqiw.getSystemNetwork(BaseApplication.getContext())));
    ((HashMap)localObject).put("param_send_req", String.valueOf(paramd.Qr));
    ((HashMap)localObject).put("param_req_resp", String.valueOf(paramd.Qs));
    ((HashMap)localObject).put("param_netSend_netRecv", String.valueOf(paramd.Qt));
    ((HashMap)localObject).put("param_notifyUi_reflash", String.valueOf(paramd.Qv));
    ((HashMap)localObject).put("param_uin_type", String.valueOf(paramd.mUinType));
    ((HashMap)localObject).put("param_msg_tag", paramd.boD);
    if (paramd.bIy) {
      ((HashMap)localObject).put("param_cross_oper", String.valueOf(paramd.bIy));
    }
    if (paramd.bIz) {
      ((HashMap)localObject).put("param_sent_by_xg", String.valueOf(paramd.bIz));
    }
    if (paramd.bIA) {
      ((HashMap)localObject).put("param_weaknet", String.valueOf(paramd.bIA));
    }
    if (paramd.bIy) {}
    for (;;)
    {
      if (paramd.bIz) {
        i = 4;
      }
      if (paramd.bIA) {
        i = 8;
      }
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      anpc.a(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "msgSendCostPerPhase", true, l1, 0L, (HashMap)localObject, "");
      return;
      i = 0;
    }
  }
  
  private void a(MessageRecord paramMessageRecord, ToServiceMsg paramToServiceMsg)
  {
    if (((paramMessageRecord instanceof MessageForLongTextMsg)) && (((MessageForLongTextMsg)paramMessageRecord).structingMsg != null)) {
      paramToServiceMsg.extraData.putString("fileName", ((MessageForLongTextMsg)paramMessageRecord).structingMsg.mFileName);
    }
    if ((paramMessageRecord instanceof MessageForMarketFace))
    {
      MarkFaceMessage localMarkFaceMessage = ((MessageForMarketFace)paramMessageRecord).mMarkFaceMessage;
      if ((localMarkFaceMessage != null) && (((localMarkFaceMessage.mobileparam != null) && (localMarkFaceMessage.mobileparam.length > 0)) || (localMarkFaceMessage.mediaType == 3))) {
        paramToServiceMsg.extraData.putInt("mediaType", 2);
      }
    }
    if ((paramMessageRecord instanceof MessageForText))
    {
      paramToServiceMsg.extraData.putInt("msg_signal_sum", ((MessageForText)paramMessageRecord).mMsgSignalSum);
      paramToServiceMsg.extraData.putInt("msg_signal_count", ((MessageForText)paramMessageRecord).mMsgSignalCount);
      paramToServiceMsg.extraData.putBoolean("msg_signal_open", ((MessageForText)paramMessageRecord).mIsMsgSignalOpen);
      paramToServiceMsg.extraData.putInt("msg_signal_net_type", ((MessageForText)paramMessageRecord).mMsgSignalNetType);
      paramToServiceMsg.extraData.putLong("msg_send_time", ((MessageForText)paramMessageRecord).mMsgSendTime);
    }
    if ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 1026)) {
      paramToServiceMsg.extraData.putString("groupuin", paramMessageRecord.frienduin);
    }
    for (;;)
    {
      if (top.fI(paramMessageRecord.msgtype)) {
        paramToServiceMsg.extraData.putBoolean("RichNotify", true);
      }
      return;
      if (paramMessageRecord.istroop == 3000) {
        paramToServiceMsg.extraData.putString("uToUin", paramMessageRecord.frienduin);
      } else if (top.eD(paramMessageRecord.istroop) == 1032) {
        paramToServiceMsg.extraData.putInt("key_confess_topicid", paramMessageRecord.getConfessTopicId());
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, long paramLong, int paramInt, acci paramacci, boolean paramBoolean)
  {
    if (paramMessageRecord.istroop == 1026)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.MessageHandler", 2, "sendRichTextMessageInner");
      }
      b(paramMessageRecord, paramPbSendMsgReq, paramLong, paramInt, paramacci, paramBoolean);
      return;
    }
    o(a(paramMessageRecord, paramPbSendMsgReq, paramLong, paramInt, paramacci, paramBoolean));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponseDelRoamMsg paramSvcResponseDelRoamMsg)
  {
    boolean bool;
    if ((paramSvcResponseDelRoamMsg == null) || (paramSvcResponseDelRoamMsg.cReplyCode != 0))
    {
      bool = false;
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder().append("handleDelRoamResp isSuccess = ").append(bool).append(" , cReplyCode = ");
        if (paramSvcResponseDelRoamMsg != null) {
          break label85;
        }
      }
    }
    label85:
    for (paramToServiceMsg = "null";; paramToServiceMsg = Byte.valueOf(paramSvcResponseDelRoamMsg.cReplyCode))
    {
      QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg);
      f(1003, bool, null);
      return;
      bool = true;
      break;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponsePullDisMsgSeq paramSvcResponsePullDisMsgSeq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyDisMsgSeq.");
    }
    eQ(paramToServiceMsg, paramFromServiceMsg, paramSvcResponsePullDisMsgSeq);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponsePullGroupMsgSeq paramSvcResponsePullGroupMsgSeq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyTroopMsgSeq.");
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramSvcResponsePullGroupMsgSeq);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponseSetRoamMsg paramSvcResponseSetRoamMsg)
  {
    if ((paramSvcResponseSetRoamMsg == null) || (paramSvcResponseSetRoamMsg.cReplyCode != 0)) {}
    for (boolean bool = false;; bool = true)
    {
      f(1005, bool, null);
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, AdMsgInfo paramAdMsgInfo)
  {
    long l1;
    if ((paramAdMsgInfo != null) && (String.valueOf(paramAdMsgInfo.uDstUin).equalsIgnoreCase(paramToServiceMsg.getUin())))
    {
      l1 = paramAdMsgInfo.utime;
      paramToServiceMsg = paramAdMsgInfo.strMsgContent;
      if (paramAdMsgInfo.uMsgType != 9) {
        break label174;
      }
      paramFromServiceMsg = anbi.d(-2003);
      paramFromServiceMsg.selfuin = this.app.getCurrentAccountUin();
      paramFromServiceMsg.frienduin = String.valueOf(acbn.bkG);
      paramFromServiceMsg.senderuin = String.valueOf(acbn.bkG);
      paramFromServiceMsg.msg = paramToServiceMsg;
      paramFromServiceMsg.time = l1;
      paramFromServiceMsg.msgtype = -2003;
      paramFromServiceMsg.istroop = 0;
      if (!achp.a(this.app, paramFromServiceMsg, false))
      {
        this.app.b().b(paramFromServiceMsg, this.app.getCurrentAccountUin());
        a("handlePushADMessageResp", 1000, true, "0_" + String.valueOf(paramAdMsgInfo.uSrcUin), 1, true, false, null);
      }
    }
    label174:
    do
    {
      do
      {
        do
        {
          return;
        } while (paramAdMsgInfo.uMsgType != 513);
        int i = aehk.cK(paramToServiceMsg);
        paramFromServiceMsg = aehk.kg(paramToServiceMsg);
        switch (i)
        {
        case 1: 
        case 3: 
        default: 
          return;
        }
      } while ((paramFromServiceMsg == null) || ((!paramFromServiceMsg.equals("WAP")) && (!paramFromServiceMsg.equals("WAPI")) && (!paramFromServiceMsg.equals("TMTWAP")) && (!paramFromServiceMsg.equals("TMTWAPI")) && (!paramFromServiceMsg.equals("LOCAL"))));
      paramFromServiceMsg = anbi.d(-2004);
      paramFromServiceMsg.selfuin = this.app.getCurrentAccountUin();
      paramFromServiceMsg.frienduin = String.valueOf(acbn.bkG);
      paramFromServiceMsg.senderuin = String.valueOf(acbn.bkG);
      paramFromServiceMsg.msg = paramToServiceMsg;
      paramFromServiceMsg.time = l1;
      paramFromServiceMsg.msgtype = -2004;
      paramFromServiceMsg.istroop = 0;
    } while (achp.a(this.app, paramFromServiceMsg, false));
    this.app.b().b(paramFromServiceMsg, this.app.getCurrentAccountUin());
    a("handlePushADMessageResp", 1000, true, "0_" + String.valueOf(paramAdMsgInfo.uSrcUin), 1, true, false, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRequestPushReadedNotify paramSvcRequestPushReadedNotify)
  {
    paramToServiceMsg = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handlePushReadedNotify() vC2CReadedNotify=" + paramSvcRequestPushReadedNotify.vC2CReadedNotify + ", vGroupReadedNotify=" + paramSvcRequestPushReadedNotify.vGroupReadedNotify + ", vDisMsgReadedNotify=" + paramSvcRequestPushReadedNotify.vDisReadedNotify);
    }
    boolean bool1 = false;
    if ((paramSvcRequestPushReadedNotify.cNotifyType & 0x8) == 8)
    {
      boolean bool2 = true;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("SUB_ACCOUNT", 2, "handlePushReadedNotify() isSubAccount=true");
        bool1 = bool2;
      }
    }
    Object localObject1;
    Object localObject2;
    if ((paramSvcRequestPushReadedNotify.vC2CReadedNotify != null) && (paramSvcRequestPushReadedNotify.vC2CReadedNotify.size() > 0))
    {
      if (bool1)
      {
        paramFromServiceMsg = (anxr)this.app.getManager(61);
        localObject1 = paramSvcRequestPushReadedNotify.vC2CReadedNotify.iterator();
        int i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (C2CMsgReadedNotify)((Iterator)localObject1).next();
          String str1 = Long.toString(((C2CMsgReadedNotify)localObject2).lPeerUin);
          String str2 = Long.toString(((C2CMsgReadedNotify)localObject2).lBindedUin);
          int k = paramFromServiceMsg.Y(str2, str1);
          i += k;
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "handlePushReadedNotify C2CMsgReadedNotify curFriendUin is " + ((C2CMsgReadedNotify)localObject2).lPeerUin + ", lLastReadTime  is " + ((C2CMsgReadedNotify)localObject2).lLastReadTime + " isSubAccount=" + bool1 + " changed=" + k);
          }
          if (i != 0)
          {
            this.app.a().G(str2, 7000, i);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "handlePushReadedNotify subUin=" + str2 + "increaseUnread=" + i);
            }
          }
          this.app.b().as(new String[] { acbn.bku, str2 });
        }
      }
      paramToServiceMsg.addAll(paramSvcRequestPushReadedNotify.vC2CReadedNotify);
      paramFromServiceMsg = paramSvcRequestPushReadedNotify.vC2CReadedNotify.iterator();
      while (paramFromServiceMsg.hasNext())
      {
        localObject1 = (C2CMsgReadedNotify)paramFromServiceMsg.next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "C2CMsgReadedNotify curFriendUin is " + ((C2CMsgReadedNotify)localObject1).lPeerUin + ", lLastReadTime  is " + ((C2CMsgReadedNotify)localObject1).lLastReadTime + " isSubAccount=" + bool1);
        }
        ((tob)a("c2c_processor")).a((C2CMsgReadedNotify)localObject1);
      }
    }
    if ((paramSvcRequestPushReadedNotify.vGroupReadedNotify != null) && (paramSvcRequestPushReadedNotify.vGroupReadedNotify.size() > 0))
    {
      paramToServiceMsg.addAll(paramSvcRequestPushReadedNotify.vGroupReadedNotify);
      paramFromServiceMsg = paramSvcRequestPushReadedNotify.vGroupReadedNotify.iterator();
      while (paramFromServiceMsg.hasNext())
      {
        localObject1 = (GroupMsgReadedNotify)paramFromServiceMsg.next();
        localObject2 = String.valueOf(((GroupMsgReadedNotify)localObject1).lGroupCode);
        if (this.app.a().eb((String)localObject2) == 1)
        {
          this.app.a().a((String)localObject2, (GroupMsgReadedNotify)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "GroupMsgReadedNotify unfinished groupUin=" + (String)localObject2);
          }
        }
        else
        {
          ((apde)a("troop_processor")).a((GroupMsgReadedNotify)localObject1);
        }
      }
    }
    if ((paramSvcRequestPushReadedNotify.vDisReadedNotify != null) && (paramSvcRequestPushReadedNotify.vDisReadedNotify.size() > 0))
    {
      paramToServiceMsg.addAll(paramSvcRequestPushReadedNotify.vDisReadedNotify);
      paramFromServiceMsg = paramSvcRequestPushReadedNotify.vDisReadedNotify.iterator();
      while (paramFromServiceMsg.hasNext())
      {
        paramSvcRequestPushReadedNotify = (DisMsgReadedNotify)paramFromServiceMsg.next();
        localObject1 = String.valueOf(paramSvcRequestPushReadedNotify.lDisUin);
        if (this.app.a().ec((String)localObject1) == 1)
        {
          this.app.a().a((String)localObject1, paramSvcRequestPushReadedNotify);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "DisMsgReadedNotify unfinished discussionUin=" + (String)localObject1);
          }
        }
        else
        {
          ((acqs)a("disc_processor")).a(paramSvcRequestPushReadedNotify);
        }
      }
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0)) {
      notifyUI(6004, true, paramToServiceMsg.toArray());
    }
  }
  
  @Deprecated
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponsePullDisGroupSeq paramSvcResponsePullDisGroupSeq)
  {
    SvcResponsePullDisMsgSeq localSvcResponsePullDisMsgSeq = null;
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (QLog.isColorLevel()) {
      localStringBuilder.append("registerproxy->handleMsgProxyDisGroupMsgSeq.");
    }
    if ((!paramFromServiceMsg.isSuccess()) || ((paramSvcResponsePullDisGroupSeq != null) && (paramSvcResponsePullDisGroupSeq.cReplyCode != 0)))
    {
      notifyUI(1000, false, null);
      return;
    }
    if (paramSvcResponsePullDisGroupSeq != null)
    {
      acdt localacdt = (acdt)this.app.getBusinessHandler(6);
      localSvcResponsePullDisMsgSeq = new SvcResponsePullDisMsgSeq();
      localSvcResponsePullDisMsgSeq.cReplyCode = paramSvcResponsePullDisGroupSeq.cReplyCode;
      localSvcResponsePullDisMsgSeq.strResult = paramSvcResponsePullDisGroupSeq.strResult;
      if (paramSvcResponsePullDisGroupSeq.vDisInfo != null)
      {
        zxj localzxj = (zxj)this.app.getManager(125);
        HashMap localHashMap = new HashMap();
        localSvcResponsePullDisMsgSeq.vConfNumInfo = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        if (QLog.isColorLevel()) {
          localStringBuilder.append(", size=").append(paramSvcResponsePullDisGroupSeq.vDisInfo.size());
        }
        int i = 0;
        if (i < paramSvcResponsePullDisGroupSeq.vDisInfo.size())
        {
          stDisGroupInfo localstDisGroupInfo = (stDisGroupInfo)paramSvcResponsePullDisGroupSeq.vDisInfo.get(i);
          if (QLog.isColorLevel()) {
            localStringBuilder.append("\nlDisCode=").append(localstDisGroupInfo.lDisCode).append(", eInfoFlag=").append(localstDisGroupInfo.eInfoFlag).append(", infoSeq=").append(localstDisGroupInfo.uInfoSeq);
          }
          switch (localstDisGroupInfo.eInfoFlag)
          {
          }
          for (;;)
          {
            i += 1;
            break;
            Object localObject = new stConfNumInfo();
            ((stConfNumInfo)localObject).lConfUin = localstDisGroupInfo.lDisCode;
            ((stConfNumInfo)localObject).uConfMsgSeq = localstDisGroupInfo.uDisMsgSeq;
            ((stConfNumInfo)localObject).uMemberMsgSeq = localstDisGroupInfo.uMemberMsgSeq;
            localSvcResponsePullDisMsgSeq.vConfNumInfo.add(localObject);
            localObject = new DiscussInfo();
            ((DiscussInfo)localObject).DiscussUin = localstDisGroupInfo.lDisCode;
            ((DiscussInfo)localObject).InfoSeq = localstDisGroupInfo.uInfoSeq;
            localArrayList.add(localObject);
            if (localstDisGroupInfo.lRedPackTime > 0L)
            {
              localHashMap.put(String.valueOf(localstDisGroupInfo.lDisCode), String.valueOf(localstDisGroupInfo.lRedPackTime));
              continue;
              localacdt.Dz(String.valueOf(localstDisGroupInfo.lDisCode));
            }
          }
        }
        localzxj.z(localHashMap);
        localacdt.D(localArrayList);
      }
    }
    if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    eQ(paramToServiceMsg, paramFromServiceMsg, localSvcResponsePullDisMsgSeq);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, anbd.b paramb)
  {
    if (paramb == null)
    {
      n(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    this.app.d(paramb.vkey, paramb.vSig);
    f(5002, true, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object arg3, boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    msg_svc.PbGetGroupMsgResp localPbGetGroupMsgResp1 = new msg_svc.PbGetGroupMsgResp();
    msg_svc.PbGetGroupMsgResp localPbGetGroupMsgResp2;
    int i;
    boolean bool1;
    boolean bool2;
    Object localObject;
    long l1;
    try
    {
      localPbGetGroupMsgResp1 = (msg_svc.PbGetGroupMsgResp)localPbGetGroupMsgResp1.mergeFrom((byte[])???);
      if (localPbGetGroupMsgResp1 == null) {
        anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
      }
      if ((localPbGetGroupMsgResp1 == null) || (??? == null))
      {
        n(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgResp_PB : Exception occurs whitl parsing the bytes.");
        }
        localPbGetGroupMsgResp2 = null;
      }
      i = paramToServiceMsg.extraData.getInt("doSome", 0);
      bool1 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
      bool2 = paramToServiceMsg.extraData.getBoolean("used_new_register_proxy", false);
      label189:
      boolean bool3;
      StringBuilder localStringBuilder1;
      if (paramToServiceMsg.getUin() == null)
      {
        paramFromServiceMsg = this.app.getCurrentAccountUin();
        localObject = paramToServiceMsg.extraData.getString("groupuin");
        if (localObject == null) {
          break label483;
        }
        l1 = Long.valueOf((String)localObject).longValue();
        bool3 = paramToServiceMsg.extraData.getBoolean("isRefreshHead", false);
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder(128);
          StringBuilder localStringBuilder2 = localStringBuilder1.append("handleGetPullTroopMsgResp msgStruct.cReplyCode = ");
          if (localPbGetGroupMsgResp2 != null) {
            break label496;
          }
          localObject = "null";
          label240:
          localStringBuilder2.append(localObject).append(" troopUin: ").append(l1).append(",isRefreshHead:").append(bool3).append(", dataHash=").append(???.hashCode()).append(" rtnBeginSeq:").append(localPbGetGroupMsgResp2.return_begin_seq.get()).append(" rtnEndSeq:").append(localPbGetGroupMsgResp2.return_end_seq.get()).append(",doSome:").append(i);
          if (!paramBoolean) {
            localStringBuilder1.append(",costTime:").append(System.currentTimeMillis() - apdd.aqY);
          }
          localStringBuilder1.append(" ThreadId:" + Thread.currentThread().getId());
          if (localPbGetGroupMsgResp2.msg.get() == null) {
            break label512;
          }
          localStringBuilder1.append(" msgSize:").append(localPbGetGroupMsgResp2.msg.get().size());
          label419:
          if (QLog.isColorLevel()) {
            if (!paramBoolean) {
              break label524;
            }
          }
        }
      }
      label512:
      label524:
      for (??? = "Q.msg.MessageHandler.troop.register_proxy_pull_msg";; ??? = "Q.msg.MessageHandler.trooptroop_pull_msg")
      {
        QLog.d(???, 2, localStringBuilder1.toString());
        synchronized (a(String.valueOf(l1), 1))
        {
          if (!a(paramToServiceMsg, localPbGetGroupMsgResp2)) {
            break label531;
          }
          return;
        }
        paramFromServiceMsg = paramToServiceMsg.getUin();
        break;
        label483:
        l1 = localPbGetGroupMsgResp2.group_code.get();
        break label189;
        label496:
        localObject = Integer.valueOf(localPbGetGroupMsgResp2.result.get());
        break label240;
        localStringBuilder1.append(" msg:null.");
        break label419;
      }
      label531:
      localObject = this.jdField_a_of_type_Anaz.o(l1);
      if (!bool3) {}
    }
    for (;;)
    {
      try
      {
        a("troop_processor").f(1003, new Object[] { paramToServiceMsg, localPbGetGroupMsgResp2, localObject, paramFromServiceMsg });
        this.jdField_a_of_type_Anaz.lj(l1);
        ((apde)a("troop_processor")).b("" + l1, localPbGetGroupMsgResp2, i);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.trooptroop_pull_msg", 2, "handleGetPullGroupMsgResp_PB, cost:" + (System.currentTimeMillis() - l2));
        }
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgResp_PB refreshTroopHead exception ! ", paramToServiceMsg);
        continue;
      }
      try
      {
        a("troop_processor").f(1002, new Object[] { paramToServiceMsg, localObject, localPbGetGroupMsgResp2, paramFromServiceMsg });
        if (bool2)
        {
          this.cwG += 1;
          this.jdField_a_of_type_Anaz.fR(String.valueOf(l1), 2);
        }
        for (;;)
        {
          if (!bool1) {
            break label957;
          }
          if (!this.jdField_a_of_type_Anaz.awu()) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgResp_PB notify NOTIFY_TYPE_GET_TROOP_MSG_FIN ");
          }
          paramToServiceMsg = "" + l1;
          MsgAutoMonitorUtil.getInstance().markGrpFinishTime();
          notifyUI(4003, true, new String[] { paramToServiceMsg });
          break;
          eN(String.valueOf(l1), "handleGetPullGroupMsgResp_PB");
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgResp_PB initGetPullTroopMsg exception ! ", paramToServiceMsg);
          }
          if (bool2)
          {
            this.cwG += 1;
            this.jdField_a_of_type_Anaz.fR(String.valueOf(l1), 2);
          }
          else
          {
            eN(String.valueOf(l1), "handleGetPullGroupMsgResp_PB");
          }
        }
      }
      finally
      {
        if (bool2)
        {
          this.cwG += 1;
          this.jdField_a_of_type_Anaz.fR(String.valueOf(l1), 2);
        }
        for (;;)
        {
          throw paramToServiceMsg;
          eN(String.valueOf(l1), "handleGetPullGroupMsgResp_PB");
        }
        label957:
        if (bool2)
        {
          if ((this.cwE != 0) && (this.cwG >= this.cwE))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgResp_PB notify NOTIFY_TYPE_GET_TROOP_MSG_FIN , troopNum:" + this.cwE + " , recvTroopNum:" + this.cwG);
            }
            MsgAutoMonitorUtil.getInstance().markGrpFinishTime();
            notifyUI(4003, true, null);
          }
        }
        else {
          notifyUI(4003, true, new String[] { "" + l1 });
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    if (paramSvcRegisterProxyMsgResp.discuss_msg.has())
    {
      paramSvcRegisterProxyMsgResp = paramSvcRegisterProxyMsgResp.discuss_msg.get();
      int k = paramSvcRegisterProxyMsgResp.size();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleDiscussMsgResp_PB, discuss_msg size:" + k);
      }
      int i = 0;
      if (i < k)
      {
        register_proxy.SvcPbResponsePullDisMsgProxy localSvcPbResponsePullDisMsgProxy = (register_proxy.SvcPbResponsePullDisMsgProxy)paramSvcRegisterProxyMsgResp.get(i);
        if (this.bIn) {
          a(3, paramToServiceMsg, paramFromServiceMsg, localSvcPbResponsePullDisMsgProxy, false);
        }
        for (;;)
        {
          i += 1;
          break;
          a(3, paramToServiceMsg, paramFromServiceMsg, localSvcPbResponsePullDisMsgProxy, true);
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, msg_svc.PbSendMsgResp paramPbSendMsgResp)
  {
    if ((paramPbSendMsgResp != null) && (paramPbSendMsgResp.errtype.has())) {
      switch (paramPbSendMsgResp.errtype.get())
      {
      }
    }
    do
    {
      return;
    } while (!paramPbSendMsgResp.trans_svr_info.has());
    paramPbSendMsgResp = (msg_svc.TransSvrInfo)paramPbSendMsgResp.trans_svr_info.get();
    a(paramToServiceMsg, 8036, true, new Object[] { Integer.valueOf(paramPbSendMsgResp.int32_ret_code.get()), paramPbSendMsgResp.bytes_trans_info.get().toByteArray() });
  }
  
  private void a(String paramString, int paramInt1, boolean paramBoolean1, Object paramObject, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, MessageRecord paramMessageRecord)
  {
    if ((paramInt1 == 1000) && (paramString != null) && (QLog.isColorLevel())) {
      QLog.d("notification", 2, "funName:" + paramString + ",isSuccess:" + paramBoolean1);
    }
    if ((paramBoolean2) && (paramInt1 == 1000) && (paramBoolean1 == true))
    {
      if (paramInt2 <= 0) {
        break label359;
      }
      if (paramMessageRecord != null) {
        break label305;
      }
    }
    try
    {
      paramString = this.app;
      if (paramBoolean3) {
        break label299;
      }
      paramBoolean2 = true;
      paramString.q(paramInt2, true, paramBoolean2);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        label103:
        if (QLog.isColorLevel())
        {
          QLog.w("notification", 2, "notification exception", paramString);
          continue;
          paramBoolean2 = false;
        }
      }
    }
    notifyUI(paramInt1, paramBoolean1, paramObject);
    if (paramInt1 == 3001) {
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        if ((paramObject != null) && (paramObject.length > 2))
        {
          paramString = (String)paramObject[0];
          ((Integer)paramObject[1]).intValue();
          if (((Integer)paramObject[2]).intValue() == 58)
          {
            anbk.aI(this.app, paramString);
            paramObject = (acff)this.app.getManager(51);
            if (!paramObject.ke(paramString))
            {
              paramMessageRecord = paramObject.e(String.valueOf(paramString));
              if (paramMessageRecord != null)
              {
                paramMessageRecord.setShieldFlag(true);
                paramObject.a(paramMessageRecord);
                this.app.getBusinessHandler(1).notifyUI(56, true, new Object[] { Long.valueOf(Long.parseLong(paramString)), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), "" });
              }
            }
          }
        }
      }
    }
    label299:
    label305:
    label359:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramBoolean2 = false;
              break;
              paramString = this.app;
              if (!paramBoolean3)
              {
                paramBoolean2 = true;
                paramString.a(paramInt2, true, paramBoolean2, paramMessageRecord);
                break label103;
              }
              if (!QLog.isColorLevel()) {
                break label103;
              }
              QLog.d("notification", 2, "notification size = 0");
              break label103;
              if ((paramInt1 != 6000) && (paramInt1 != 8002) && (paramInt1 != 7000) && (paramInt1 != 8005) && (paramInt1 != 8006) && (paramInt1 != 6010) && (paramInt1 != 6012) && (paramInt1 != 6013) && (paramInt1 != 8008) && (paramInt1 != 8010) && (paramInt1 != 8012) && (paramInt1 != 8014) && (paramInt1 != 3022) && (paramInt1 != 8035) && (paramInt1 != 8028) && (paramInt1 != 8037) && (paramInt1 != 8032) && (paramInt1 != 8040) && (paramInt1 != 8041) && (paramInt1 != 8043)) {
                break label605;
              }
            } while (!(paramObject instanceof Object[]));
            paramString = (Object[])paramObject;
          } while ((paramString == null) || (paramString.length <= 2));
          paramObject = (String)paramString[0];
          paramInt2 = ((Integer)paramString[1]).intValue();
        } while ((((Integer)paramString[2]).intValue() != 55) || (paramInt1 == 8035));
        ((aclo)this.app.getBusinessHandler(18)).dI(paramObject, paramInt2);
        return;
      } while (((paramInt1 != 3002) && (paramInt1 != 3013) && (paramInt1 != 3008)) || (!(paramObject instanceof Object[])));
      paramString = (Object[])paramObject;
    } while ((paramString == null) || (paramString.length <= 2));
    label605:
    ((Integer)paramString[2]).intValue();
  }
  
  private void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, PBBytesField paramPBBytesField)
  {
    if (paramPBBytesField.has()) {}
    try
    {
      paramPBBytesField = paramPBBytesField.get().toByteArray();
      int i = paramPBBytesField.length - 4;
      byte[] arrayOfByte = new byte[i];
      aqoj.copyData(arrayOfByte, 0, paramPBBytesField, 4, i);
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> decode " + paramString + ", hashCode:" + arrayOfByte.hashCode());
      }
      a(1, paramToServiceMsg, paramFromServiceMsg, arrayOfByte);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> decode " + paramString + "error:", paramToServiceMsg);
    }
  }
  
  private void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(acrg.jA(paramString)).f(acrg.cD(paramString), new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
  }
  
  private void a(String paramString1, String paramString2, byte paramByte, boolean paramBoolean, String paramString3, long paramLong1, long paramLong2, long paramLong3)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("AccostSvc.ClientMsg");
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putLong("to", Long.valueOf(paramString1).longValue());
    localToServiceMsg.extraData.putString("msg", paramString2);
    localToServiceMsg.extraData.putByte("cType", paramByte);
    localToServiceMsg.extraData.putBoolean("hello", paramBoolean);
    localToServiceMsg.extraData.putString("pyNickname", paramString3);
    localToServiceMsg.extraData.putLong("uniseq", paramLong2);
    localToServiceMsg.extraData.putLong("msgSeq", paramLong1);
    localToServiceMsg.extraData.putLong("timeOut", paramLong3);
    localToServiceMsg.setTimeout(paramLong3);
    send(localToServiceMsg);
  }
  
  private void a(String paramString, boolean paramBoolean, long paramLong, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    HashMap localHashMap = new HashMap();
    long l2 = paramFromServiceMsg.getResultCode();
    long l3 = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 0L);
    long l1 = l2;
    if (l3 != 0L)
    {
      l1 = l2;
      if (l3 != 241L)
      {
        l1 = 2900L;
        localHashMap.put("param_ServerReplyCode", paramFromServiceMsg.extraData.getLong("ServerReplyCode") + "");
      }
    }
    localHashMap.put("param_FailCode", l1 + "");
    long l4 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    localHashMap.put("param_retryIndex", Long.toString(l4));
    l1 = paramToServiceMsg.extraData.getLong("startTime", 0L);
    l2 = System.currentTimeMillis();
    Object localObject;
    String str;
    if (l1 < 1L)
    {
      l1 = 0L;
      if (!paramToServiceMsg.extraData.containsKey("msgSeq")) {
        break label935;
      }
      localObject = a(paramToServiceMsg.extraData.getLong("msgSeq"));
      if (localObject == null) {
        break label935;
      }
      str = ((SendMessageHandler)localObject).toString();
      localHashMap.put("param_retryInfo", str);
    }
    for (l3 = ((SendMessageHandler)localObject).Y(l2);; l3 = l1)
    {
      localObject = b(paramFromServiceMsg);
      if (localObject != null) {
        localHashMap.put("param_reason", localObject);
      }
      l1 = 0L;
      l2 = l1;
      if (paramFromServiceMsg.getAttribute("__timestamp_msf2net") != null)
      {
        l2 = l1;
        if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null)
        {
          l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)paramFromServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
          l1 = l2;
          if (l2 < 0L) {
            l1 = 0L;
          }
          l2 = l1;
          if (l1 <= 2147483647L) {}
        }
      }
      for (l1 = 0L;; l1 = l2)
      {
        int i = paramToServiceMsg.extraData.getInt("msg_signal_sum");
        int k = paramToServiceMsg.extraData.getInt("msg_signal_count");
        boolean bool1 = paramToServiceMsg.extraData.getBoolean("msg_signal_open");
        int n = paramToServiceMsg.extraData.getInt("msgtype", -1);
        int i1 = paramToServiceMsg.extraData.getInt("msg_signal_net_type", -1);
        localHashMap.put("pm_signal_sum", String.valueOf(i));
        localHashMap.put("pm_signal_count", String.valueOf(k));
        localHashMap.put("pm_signal_open", String.valueOf(bool1));
        localHashMap.put("pm_msgtype", String.valueOf(n));
        localHashMap.put("pm_nettype", String.valueOf(i1));
        localHashMap.put("pm_msftime", String.valueOf(l1));
        int i2 = paramToServiceMsg.extraData.getInt("send_msg_req_size", 0);
        boolean bool2 = paramToServiceMsg.extraData.getBoolean("isJuhuaExist");
        localHashMap.put("pm_req_size", String.valueOf(i2));
        localHashMap.put("isJuhuaExist", String.valueOf(bool2));
        bool2 = ((Boolean)paramFromServiceMsg.getAttribute("conn_cross_oper_flag", Boolean.valueOf(false))).booleanValue();
        boolean bool3 = ((Boolean)paramFromServiceMsg.getAttribute("attr_quick_send_by_xg", Boolean.valueOf(false))).booleanValue();
        boolean bool4 = ((Boolean)paramFromServiceMsg.getAttribute("attr_weaknet_sent_flag", Boolean.valueOf(false))).booleanValue();
        localHashMap.put("isCrossOper", String.valueOf(bool2));
        localHashMap.put("isSentByXG", String.valueOf(bool3));
        localHashMap.put("isWeaknet", String.valueOf(bool4));
        l2 = paramFromServiceMsg.extraData.getLong(anbb.ccK, 0L);
        int i3 = paramFromServiceMsg.extraData.getInt(anbb.ccJ, 0);
        if (l2 == 0L) {}
        for (l2 = 0L;; l2 = System.currentTimeMillis() - l2)
        {
          localHashMap.put("pm_queueTime", String.valueOf(l2));
          localHashMap.put("pm_respLen", String.valueOf(i3));
          anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), paramString, paramBoolean, l3, paramLong, localHashMap, "");
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, String.format("Statistics TAG:%s, success:%s, duration:%dms, retryNum:%d, detail:%s, msgSignal [Sum:%d Count:%d, Open:%s msgType:%d netType:%d msfTime:%d reqSize:%d queueHandleTime:%d respWaitLen:%d]", new Object[] { paramString, Boolean.valueOf(paramBoolean), Long.valueOf(l3), Long.valueOf(l4), str, Integer.valueOf(i), Integer.valueOf(k), Boolean.valueOf(bool1), Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(l1), Integer.valueOf(i2), Long.valueOf(l2), Integer.valueOf(i3) }));
          }
          return;
          l1 = l2 - l1;
          break;
        }
      }
      label935:
      str = "";
    }
  }
  
  private void a(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1006) {
      if ((paramPbSendMsgResp.errmsg.has()) && ((paramInt2 == 1600) || (paramInt2 == 1601) || (paramInt2 == 1602) || (paramInt2 == 1603))) {
        F(paramInt1, paramPbSendMsgResp.errmsg.get(), paramString);
      }
    }
    for (;;)
    {
      if ((paramPbSendMsgResp.errmsg.has()) && (paramInt2 == 201)) {
        F(paramInt1, paramPbSendMsgResp.errmsg.get(), paramString);
      }
      return;
      if (paramInt1 == 1022)
      {
        if ((paramPbSendMsgResp.errmsg.has()) && (paramInt2 == 201)) {
          F(paramInt1, paramPbSendMsgResp.errmsg.get(), paramString);
        }
      }
      else if (paramInt1 == 1010)
      {
        if ((paramPbSendMsgResp.errmsg.has()) && ((paramInt2 == 54) || (paramInt2 == 61) || (paramInt2 == 62) || (paramInt2 == 63) || (paramInt2 == 64) || (paramInt2 == 65)))
        {
          acqn.a(this.app, paramString, paramPbSendMsgResp.errmsg.get(), paramInt1, false, false);
          switch (paramInt2)
          {
          default: 
            break;
          case 63: 
            anot.a(this.app, "CliOper", "", "", "0X80052A8", "0X80052A8", 0, 0, "", "", "", "");
            break;
          case 64: 
            anot.a(this.app, "CliOper", "", "", "0X80052A9", "0X80052A9", 0, 0, "", "", "", "");
            break;
          case 65: 
            anot.a(this.app, "CliOper", "", "", "0X80052AA", "0X80052AA", 0, 0, "", "", "", "");
            break;
          }
        }
      }
      else
      {
        label468:
        Object localObject2;
        Object localObject1;
        if ((paramInt1 == 1001) || (paramInt1 == 10002))
        {
          if ((paramPbSendMsgResp.errmsg.has()) && ((paramInt2 == 63) || (paramInt2 == 64) || (paramInt2 == 65) || ((paramInt2 >= 10000) && (paramInt2 < 20000))))
          {
            acqn.a(this.app, paramString, paramPbSendMsgResp.errmsg.get(), paramInt1, false, false);
            switch (paramInt2)
            {
            default: 
              if ((paramInt2 >= 10000) && (paramInt2 < 20000))
              {
                localObject2 = this.app;
                if (paramInt1 != 1001) {
                  break label673;
                }
              }
              break;
            }
            label673:
            for (localObject1 = "0";; localObject1 = "1")
            {
              anot.a((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "c2c_tmp", "no_send", 0, 0, (String)localObject1, "" + paramInt2, "", "");
              break;
              anot.a(this.app, "CliOper", "", "", "0X80052A8", "0X80052A8", 0, 0, "", "", "", "");
              break label468;
              anot.a(this.app, "CliOper", "", "", "0X80052A9", "0X80052A9", 0, 0, "", "", "", "");
              break label468;
              anot.a(this.app, "CliOper", "", "", "0X80052AA", "0X80052AA", 0, 0, "", "", "", "");
              break label468;
              break;
            }
          }
        }
        else if ((paramInt1 == 0) && (paramInt2 == 16))
        {
          localObject2 = paramPbSendMsgResp.errmsg.get();
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = acfp.m(2131708205);
          }
          localObject1 = new ahwa(paramString, this.app.getCurrentAccountUin(), (String)localObject1, paramInt1, -5020, 1376257, anaz.gQ());
          localObject2 = new MessageForUniteGrayTip();
          ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.app, (ahwa)localObject1);
          ahwb.a(this.app, (MessageForUniteGrayTip)localObject2);
        }
      }
    }
  }
  
  private void a(register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramSvcRegisterProxyMsgResp.discuss_list_flag.has())
    {
      bool1 = bool2;
      if (paramSvcRegisterProxyMsgResp.discuss_list_flag.get() == 1) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg needDealDiscussList=" + bool1);
    }
    if (bool1)
    {
      Object localObject1;
      int i;
      Object localObject2;
      if (paramSvcRegisterProxyMsgResp.discuss_list.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleDiscussList!");
        }
        paramSvcRegisterProxyMsgResp = paramSvcRegisterProxyMsgResp.discuss_list.get();
        localObject1 = this.jdField_a_of_type_Anaz;
        anaz.a.Gs = paramSvcRegisterProxyMsgResp;
        i = 0;
        if (i < paramSvcRegisterProxyMsgResp.size())
        {
          localObject1 = (register_proxy.DiscussList)paramSvcRegisterProxyMsgResp.get(i);
          if (localObject1 == null) {}
          for (;;)
          {
            i += 1;
            break;
            localObject2 = String.valueOf(((register_proxy.DiscussList)localObject1).discuss_code.get());
            Object localObject3 = this.jdField_a_of_type_Anaz.d((String)localObject2);
            long l3 = this.jdField_a_of_type_Anaz.aH((String)localObject2);
            long l2 = 0L;
            long l1 = l2;
            if (localObject3 != null)
            {
              l1 = l2;
              if (localObject3.length > 0) {
                l1 = ((Long)localObject3[0]).longValue();
              }
            }
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).setLength(0);
              ((StringBuilder)localObject3).append("handleNewRegisterProxyMsg getDiscussList discussCode=").append(((register_proxy.DiscussList)localObject1).discuss_code.get()).append(" discussSeq=").append(((register_proxy.DiscussList)localObject1).discuss_seq.get()).append(" memberSeq=").append(((register_proxy.DiscussList)localObject1).member_seq.get()).append(" info_seq=").append(((register_proxy.DiscussList)localObject1).info_seq.get()).append(" isHotDiscuss=").append(((register_proxy.DiscussList)localObject1).bHotGroup.get()).append(" localMemberMsgSeq=").append(l1).append(" localLastSeq=").append(l3).append(" redpack_time=").append(((register_proxy.DiscussList)localObject1).redpack_time.get()).append(" hasMsg=").append(((register_proxy.DiscussList)localObject1).has_msg.get());
              QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject3).toString());
            }
            this.jdField_a_of_type_Anaz.r((String)localObject2, new Object[] { Long.valueOf(((register_proxy.DiscussList)localObject1).member_seq.get()), Long.valueOf(((register_proxy.DiscussList)localObject1).discuss_seq.get()) });
            if (((register_proxy.DiscussList)localObject1).member_seq.get() > l1) {
              if (((register_proxy.DiscussList)localObject1).discuss_seq.get() <= l3) {
                a(5, null, null, localObject1);
              } else {
                this.jdField_a_of_type_Anaz.fS((String)localObject2, 1);
              }
            }
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleDiscussList! noDiscussList return...");
        }
        localObject1 = (acdu)this.app.getManager(53);
        paramSvcRegisterProxyMsgResp = (acdt)this.app.getBusinessHandler(6);
        localObject1 = ((acdu)localObject1).getDiscussList();
        new ArrayList();
        localObject1 = ((ArrayList)localObject1).iterator();
        i = 1;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> should be deleted discussion" + i + ":" + ((DiscussionInfo)localObject2).uin);
          }
          paramSvcRegisterProxyMsgResp.Dz(((DiscussionInfo)localObject2).uin);
          if (this.jdField_a_of_type_Anaz.V(((DiscussionInfo)localObject2).uin) != null) {
            this.jdField_a_of_type_Anaz.Qi(((DiscussionInfo)localObject2).uin);
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(Object[] paramArrayOfObject, String paramString, int paramInt)
  {
    paramString = (String)paramArrayOfObject[0];
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    long l1 = ((Long)paramArrayOfObject[5]).longValue();
    paramArrayOfObject = this.app.b().a(paramString, i);
    this.app.a().e(paramString, i, l1);
    if ((paramArrayOfObject != null) && (paramArrayOfObject.uniseq == l1)) {
      paramArrayOfObject.extraflag = 32768;
    }
    this.app.b().b(paramString, i, l1, 32768, paramInt);
  }
  
  private boolean a(MessageRecord paramMessageRecord, achq paramachq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "the values of disable big data channel is" + obt.aef);
    }
    if (obt.aef) {}
    do
    {
      do
      {
        return false;
        if (!(paramMessageRecord instanceof MessageForStructing)) {
          break;
        }
        AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramMessageRecord).structingMsg;
        if ((localAbsStructMsg != null) && (oec.b(localAbsStructMsg)))
        {
          String str1 = paramMessageRecord.getExtInfoFromExtStr("send_by_struct_long_message");
          String str2 = oec.a(localAbsStructMsg);
          String str3 = oec.dX(str2);
          if (!"1".equals(str1))
          {
            paramMessageRecord.saveExtInfoToExtStr("send_by_struct_long_message", "1");
            c(paramMessageRecord, paramachq);
            kbp.a(null, localAbsStructMsg.source_puin, "0X8007A26", "0X8007A26", 0, 0, str3, str2, "", "", false);
            return true;
          }
          paramMessageRecord.saveExtInfoToExtStr("send_by_struct_long_message", "0");
          kbp.a(null, localAbsStructMsg.source_puin, "0X8007A27", "0X8007A27", 0, 0, str3, str2, "", "", false);
          return false;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.MessageHandler", 2, "struct msg is null");
      return false;
      if ((paramMessageRecord instanceof MessageForArkApp))
      {
        ujt.a(this.app, (MessageForArkApp)paramMessageRecord, false);
        return true;
      }
      if ((paramMessageRecord instanceof MessageForArkBabyqReply))
      {
        QLog.e("Q.msg.MessageHandler", 1, "MessageForArkBabyqReply no longer supported from 8.2.6");
        return true;
      }
      if ((paramMessageRecord instanceof MessageForReplyText))
      {
        ((ajkw)this.app.getManager(166)).b(this.app, paramMessageRecord, true);
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "it is not message for structing");
    return false;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, msg_svc.PbGetDiscussMsgResp paramPbGetDiscussMsgResp)
  {
    if ((paramPbGetDiscussMsgResp.msg.get() != null) && (paramPbGetDiscussMsgResp.msg.get().size() > 0))
    {
      boolean bool1 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
      boolean bool2 = paramToServiceMsg.extraData.getBoolean("used_new_register_proxy", false);
      long l1 = paramToServiceMsg.extraData.getLong("lBeginSeq");
      long l2 = paramPbGetDiscussMsgResp.return_begin_seq.get();
      long l3 = paramToServiceMsg.extraData.getLong("lDisUin", paramPbGetDiscussMsgResp.discuss_uin.get());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pullNextDisMsg disUin: ").append(l3).append(" res.cReplyCode: ").append(paramPbGetDiscussMsgResp.result.get()).append(" srcBegSeq: ").append(l1).append(" srcEndSeq: ").append(paramToServiceMsg.extraData.getLong("lEndSeq")).append(" res.lReturnBeginSeq: ").append(l2).append(" res.lReturnEndSeq: ").append(paramPbGetDiscussMsgResp.return_end_seq.get()).append(" res.vMsgs.size(): ").append(paramPbGetDiscussMsgResp.msg.get().size());
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_Anaz.g(l3, paramPbGetDiscussMsgResp.msg.get());
      if ((!bool1) && (!bool2) && (l1 <= l2 - 1L) && (paramPbGetDiscussMsgResp.return_begin_seq.get() <= paramPbGetDiscussMsgResp.return_end_seq.get())) {
        return a(l3, l1, l2 - 1L, paramToServiceMsg.extraData.getBoolean("isRefreshHead"), paramToServiceMsg.extraData.getBundle("context"));
      }
    }
    return false;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp)
  {
    if ((paramPbGetGroupMsgResp.msg.get() != null) && (paramPbGetGroupMsgResp.msg.get().size() > 0))
    {
      boolean bool1 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
      boolean bool2 = paramToServiceMsg.extraData.getBoolean("used_new_register_proxy", false);
      Object localObject2 = paramToServiceMsg.extraData.getString("groupuin");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = String.valueOf(paramPbGetGroupMsgResp.group_code.get());
      }
      long l1 = paramToServiceMsg.extraData.getLong("lBeginSeq", 0L);
      long l2 = paramPbGetGroupMsgResp.return_begin_seq.get();
      int i;
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      if (paramPbGetGroupMsgResp.msg.get() != null)
      {
        i = 1;
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder(128);
          localStringBuilder2 = localStringBuilder1.append("pullNextTroopMsg troopUin: ").append((String)localObject1).append(" msgStruct.cReplyCode: ").append(paramPbGetGroupMsgResp.result.get()).append(" lBeginSeq: ").append(l1).append(" lEndSeq: ").append(paramToServiceMsg.extraData.getLong("lEndSeq")).append(" res.lReturnBeginSeq: ").append(l2).append(" res.lReturnEndSeq: ").append(paramPbGetGroupMsgResp.return_end_seq.get()).append(" msg.size(): ");
          if (i == 0) {
            break label380;
          }
        }
      }
      label380:
      for (localObject2 = Integer.valueOf(paramPbGetGroupMsgResp.msg.get().size());; localObject2 = "null")
      {
        localStringBuilder2.append(localObject2);
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder1.toString());
        this.jdField_a_of_type_Anaz.h(paramPbGetGroupMsgResp.group_code.get(), paramPbGetGroupMsgResp.msg.get());
        l2 -= 1L;
        if ((bool1) || (bool2) || (l1 > l2) || (paramPbGetGroupMsgResp.return_begin_seq.get() > paramPbGetGroupMsgResp.return_end_seq.get())) {
          break label388;
        }
        return a((String)localObject1, l1, l2, paramToServiceMsg.extraData.getBoolean("isRefreshHead"), paramToServiceMsg.extraData.getBundle("context"), paramToServiceMsg.extraData.getInt("doSome"));
        i = 0;
        break;
      }
    }
    label388:
    return false;
  }
  
  private boolean a(register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    boolean bool = true;
    int i = paramSvcRegisterProxyMsgResp.result.get();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyResultCode resultCode = " + i);
    }
    if (i != 0)
    {
      paramSvcRegisterProxyMsgResp = new HashMap();
      paramSvcRegisterProxyMsgResp.put("param_FailCode", String.valueOf(i));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "prxyRegFailCode", true, 0L, 0L, paramSvcRegisterProxyMsgResp, null);
    }
    switch (i)
    {
    default: 
      bool = false;
    case 0: 
      return bool;
    case 1: 
      notifyUI(4001, false, null);
      notifyUI(4016, false, null);
      notifyUI(4003, false, null);
      notifyUI(4002, false, null);
      return false;
    case 99: 
    case 101: 
      RegisterProxy.cyK |= 0x1;
      i = new Random().nextInt(3000);
      ThreadManager.getSubThreadHandler().postDelayed(new MessageHandler.13(this), i);
      return false;
    case 100: 
      bIl = false;
      BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("new_regprxy_switch", false).commit();
      notifyUI(4004, false, null);
      return false;
    case 102: 
      Fg(false);
      aY(true, 1);
      return true;
    case 103: 
      Fh(false);
      aY(true, 2);
      return true;
    }
    Fg(false);
    aY(true, 0);
    return true;
  }
  
  private long[] a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (QLog.isColorLevel()) {
      localStringBuilder.append("--->>initBeforGetPullTroopMsgNumber, troopUinArray.length=").append(paramArrayOfString.length).append(", list=");
    }
    long[] arrayOfLong = new long[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      this.jdField_a_of_type_Anaz.fR(paramArrayOfString[i], 0);
      this.jdField_a_of_type_Anaz.Qj(paramArrayOfString[i]);
      arrayOfLong[i] = this.jdField_a_of_type_Anaz.aI(paramArrayOfString[i]);
      if (QLog.isColorLevel()) {
        localStringBuilder.append(paramArrayOfString[i]).append(":").append(arrayOfLong[i]).append(", ");
      }
      i += 1;
    }
    if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    return arrayOfLong;
  }
  
  private boolean aN(boolean paramBoolean)
  {
    synchronized (this.kk)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "----------handleMsgGetting: " + this.bIq);
      }
      if (!this.bIq)
      {
        Fg(true);
        Ff(paramBoolean);
        return false;
      }
      return true;
    }
  }
  
  private void aa(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    String str = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    long l3 = paramToServiceMsg.extraData.getLong("uniseq");
    int i = paramToServiceMsg.extraData.getInt("msgtype");
    int k = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    int n = paramToServiceMsg.extraData.getInt("retryIndex");
    int i1 = anbh.b(k, this.app);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><E><---handleSendGrpMessageError: ---cmd:" + (String)localObject + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + ",sendC2CMessage error : peerUin:" + str + " uniseq:" + l3 + " msgSeq:" + l1 + " msgType:" + i + " uinType:" + i1 + " routingType:" + k + " retryIndex:" + n);
    }
    ae(paramToServiceMsg, paramFromServiceMsg);
    wte.a().h(this.app, l3);
    localObject = a(l1);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label296;
      }
      localObject.getClass();
      if (!a((SendMessageHandler)localObject, "msf")) {
        break label296;
      }
    }
    label296:
    while ((480000L != l2) && (!((SendMessageHandler)localObject).aFa())) {
      return;
    }
    localObject = new Object[6];
    localObject[0] = paramToServiceMsg.extraData.getString("groupuin");
    localObject[1] = Integer.valueOf(1);
    localObject[2] = Integer.valueOf(0);
    localObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
    localObject[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
    localObject[5] = Long.valueOf(l3);
    a((Object[])localObject, paramFromServiceMsg.getUin(), paramFromServiceMsg.getResultCode());
    f(3002, false, localObject);
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      localObject = new achq.a();
      ((achq.a)localObject).errCode = paramFromServiceMsg.getResultCode();
      ((achq.a)localObject).retryCount = i;
      ((achq.a)localObject).timeoutReason = b(paramFromServiceMsg);
      a(paramToServiceMsg, 5006, false, new Object[] { Long.valueOf(l3), localObject });
    }
    g(paramToServiceMsg, paramFromServiceMsg, false);
    hB(l1);
  }
  
  private boolean aaI()
  {
    synchronized (this.kl)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "----------handlePAMsgGetting: " + this.bIs);
      }
      if (!this.bIs)
      {
        Fh(true);
        return false;
      }
      return true;
    }
  }
  
  private boolean aaJ()
  {
    if ((this.bIn) && (!this.bIm)) {
      if (this.tk == null) {
        return true;
      }
    }
    for (;;)
    {
      synchronized (this.tk)
      {
        Iterator localIterator = this.tk.iterator();
        if (!localIterator.hasNext()) {
          break label117;
        }
        if (!((c)localIterator.next()).isFirstMsg) {
          continue;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "hasFirstGroupMsg flag =" + bool);
        }
        if (!bool)
        {
          this.bIn = false;
          return true;
        }
      }
      return false;
      label117:
      boolean bool = false;
    }
  }
  
  private boolean aaL()
  {
    for (;;)
    {
      synchronized (this.cy)
      {
        if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread.length > 1)) {
          break label77;
        }
        return true;
        if (i >= this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread.length) {
          break label73;
        }
        if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i] != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i].aaP())) {
          return false;
        }
      }
      i += 1;
      continue;
      label73:
      return true;
      label77:
      int i = 1;
    }
  }
  
  private boolean aaM()
  {
    if (this.tk == null) {
      return true;
    }
    for (;;)
    {
      try
      {
        synchronized (this.tk)
        {
          if (this.tk.size() == 0)
          {
            bool = true;
            return bool;
          }
        }
        boolean bool = false;
      }
      catch (Exception localException)
      {
        return true;
      }
    }
  }
  
  private void ab(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("uniseq");
    long l3 = paramToServiceMsg.extraData.getLong("to");
    long l4 = paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg = l3 + "";
    this.app.b().b(paramToServiceMsg, 1001, l2, 32768, paramFromServiceMsg.getResultCode());
    f(3001, false, new Object[] { String.valueOf(l3), Integer.valueOf(1001), Integer.valueOf(0), null, Long.valueOf(l4), Long.valueOf(l2) });
    if ((480000L == l4) && (a(l1) != null)) {
      hB(l1);
    }
  }
  
  private void ac(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    String str = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    long l3 = paramToServiceMsg.extraData.getLong("uniseq");
    int i = paramToServiceMsg.extraData.getInt("msgtype");
    int k = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    int n = paramToServiceMsg.extraData.getInt("retryIndex");
    int i1 = anbh.b(k, this.app);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><E><---handleSendDisMessageError: ---cmd:" + (String)localObject + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + ",sendC2CMessage error : peerUin:" + str + " uniseq:" + l3 + " msgSeq:" + l1 + " msgType:" + i + " uinType:" + i1 + " routingType:" + k + " retryIndex:" + n);
    }
    wte.a().h(this.app, l3);
    ae(paramToServiceMsg, paramFromServiceMsg);
    localObject = a(l1);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label296;
      }
      localObject.getClass();
      if (!a((SendMessageHandler)localObject, "msf")) {
        break label296;
      }
    }
    label296:
    while ((480000L != l2) && (!((SendMessageHandler)localObject).aFa())) {
      return;
    }
    localObject = new Object[6];
    localObject[0] = paramToServiceMsg.extraData.getString("uToUin");
    localObject[1] = Integer.valueOf(3000);
    localObject[2] = Integer.valueOf(0);
    localObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
    localObject[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
    localObject[5] = Long.valueOf(l3);
    a((Object[])localObject, paramFromServiceMsg.getUin(), paramFromServiceMsg.getResultCode());
    f(3008, false, localObject);
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      localObject = new achq.a();
      ((achq.a)localObject).errCode = paramFromServiceMsg.getResultCode();
      ((achq.a)localObject).retryCount = i;
      ((achq.a)localObject).timeoutReason = b(paramFromServiceMsg);
      a(paramToServiceMsg, 5006, false, new Object[] { Long.valueOf(l3), localObject });
    }
    d(paramToServiceMsg, paramFromServiceMsg, false);
    hB(l1);
  }
  
  private void ad(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    if (achp.a(i, this.app)) {
      Z(paramToServiceMsg, paramFromServiceMsg);
    }
    for (;;)
    {
      b(paramToServiceMsg, String.valueOf(paramFromServiceMsg.getResultCode()));
      return;
      if (i == 9) {
        a().aB(paramToServiceMsg, paramFromServiceMsg);
      } else if (i == 13) {
        a().aC(paramToServiceMsg, paramFromServiceMsg);
      } else if (i == 4) {
        ac(paramToServiceMsg, paramFromServiceMsg);
      } else if (i == 2) {
        aa(paramToServiceMsg, paramFromServiceMsg);
      }
    }
  }
  
  private void af(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    f(1005, false, null);
  }
  
  private void ag(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    f(1005, false, null);
  }
  
  private void ah(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    f(1003, false, null);
  }
  
  private void ai(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    f(1003, false, null);
  }
  
  private void aj(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = 0;
    if (paramToServiceMsg.extraData.getBoolean("used_register_proxy", false))
    {
      paramToServiceMsg = this.ei;
      this.ei = null;
    }
    for (;;)
    {
      this.cwP = 0;
      notifyUI(4003, false, paramToServiceMsg);
      label44:
      if ((paramToServiceMsg != null) && (i < paramToServiceMsg.length)) {
        try
        {
          eN(paramToServiceMsg[i], "handleGetPullTroopMsgNumError");
          i += 1;
          break label44;
          paramToServiceMsg = paramToServiceMsg.extraData.getStringArray("array_groupuin");
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            paramFromServiceMsg.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumError exception ! ", paramFromServiceMsg);
            }
          }
        }
      }
    }
  }
  
  private void ak(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (this.cwP < 3)
    {
      paramFromServiceMsg = new msg_svc.PbUnReadMsgSeqReq();
      try
      {
        msg_svc.PbUnReadMsgSeqReq localPbUnReadMsgSeqReq = (msg_svc.PbUnReadMsgSeqReq)paramFromServiceMsg.mergeFrom((byte[])paramToServiceMsg.getWupBuffer());
        paramFromServiceMsg = localPbUnReadMsgSeqReq;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.MessageHandler", 2, "<---handleGetPullTroopMsgNumTimeOut : decode pb:", localException);
          }
        }
        this.cwP += 1;
        return;
      }
      paramFromServiceMsg = ((msg_svc.PbPullGroupMsgSeqReq)paramFromServiceMsg.group_unread_info.get()).group_info_req.get().iterator();
      while (paramFromServiceMsg.hasNext()) {
        dC(String.valueOf(((msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq)paramFromServiceMsg.next()).group_code.get()), paramToServiceMsg.extraData.getInt("doSome"));
      }
    }
    aj(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void al(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("isRefreshHead", false);
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("groupuin");
    if (bool1)
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
      if (paramToServiceMsg != null)
      {
        paramToServiceMsg.putBoolean("success", false);
        this.app.b().b(paramFromServiceMsg, 1, null, null, paramToServiceMsg);
      }
      return;
    }
    try
    {
      eN(paramFromServiceMsg, "handleGetPullTroopMsgError");
      if (bool2) {
        if (this.jdField_a_of_type_Anaz.awu())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgError notify NOTIFY_TYPE_GET_TROOP_MSG_FIN ");
          }
          notifyUI(4003, false, new String[] { paramFromServiceMsg });
          return;
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgError exception ! ", paramToServiceMsg);
        }
      }
      this.jdField_a_of_type_Anaz.dOQ();
      return;
    }
    notifyUI(4003, false, new String[] { paramFromServiceMsg });
  }
  
  private void am(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (!paramToServiceMsg.extraData.getBoolean("used_register_proxy", false))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumError isUsedRegisterProxy = false ! ");
      }
      return;
    }
    paramToServiceMsg = this.ej;
    this.ej = null;
    this.app.getCurrentAccountUin();
    int i;
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder().append("handleGetPullDiscussionMsgNumError size = ");
      if (paramToServiceMsg != null) {
        break label125;
      }
      i = 0;
    }
    for (;;)
    {
      QLog.d("Q.msg.MessageHandler", 2, i);
      if (paramToServiceMsg == null) {
        break label168;
      }
      int k = paramToServiceMsg.length;
      i = 0;
      label100:
      if (i < k)
      {
        paramFromServiceMsg = paramToServiceMsg[i];
        try
        {
          eR(paramFromServiceMsg, "handleGetPullDiscussionMsgNumError");
          i += 1;
          break label100;
          label125:
          i = paramToServiceMsg.length;
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            paramFromServiceMsg.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumError exception ! ", paramFromServiceMsg);
            }
          }
        }
      }
    }
    this.jdField_a_of_type_Anaz.Y(paramToServiceMsg);
    cKg();
    label168:
    notifyUI(4002, false, null);
  }
  
  private void an(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = paramToServiceMsg.extraData.getBoolean("isRefreshHead", false);
    paramFromServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("lDisUin"));
    if (bool)
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
      if (paramToServiceMsg != null) {
        paramToServiceMsg.putBoolean("success", false);
      }
      this.app.b().b(String.valueOf(paramFromServiceMsg), 3000, null, null, paramToServiceMsg);
      return;
    }
    paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
    try
    {
      eR(String.valueOf(paramFromServiceMsg), "handleGetPullDiscussionMsgError");
      if (this.jdField_a_of_type_Anaz.awv())
      {
        notifyUI(4002, false, null);
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgError exception ! ", paramToServiceMsg);
        }
      }
      this.jdField_a_of_type_Anaz.dOR();
    }
  }
  
  private void ao(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    ae(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = a(l1);
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label99;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<ReadReport_All>handleMsgReadedReportError_PB: reqSeq " + l1);
      }
      paramToServiceMsg.getClass();
      if (!a(paramToServiceMsg, "msf")) {
        break label99;
      }
    }
    label99:
    while ((480000L != l2) && (!paramToServiceMsg.aFa())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<ReadReport_All>handleMsgReadedReportError_PB, all retry: reqSeq " + l1);
    }
    hB(l1);
  }
  
  private void aq(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.MessageHandler", 2, "handleSendHotchatTopicMessageError");
    }
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    long l3 = paramToServiceMsg.extraData.getLong("uniseq");
    ae(paramToServiceMsg, paramFromServiceMsg);
    Object localObject = a(l1);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label100;
      }
      localObject.getClass();
      if (!a((SendMessageHandler)localObject, "msf")) {
        break label100;
      }
    }
    label100:
    while ((480000L != l2) && (!((SendMessageHandler)localObject).aFa())) {
      return;
    }
    localObject = new Object[6];
    localObject[0] = paramToServiceMsg.extraData.getString("groupuin");
    localObject[1] = Integer.valueOf(1026);
    localObject[2] = Integer.valueOf(0);
    localObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
    localObject[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
    localObject[5] = Long.valueOf(l3);
    a((Object[])localObject, paramFromServiceMsg.getUin(), paramFromServiceMsg.getResultCode());
    f(3013, false, localObject);
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      localObject = new achq.a();
      ((achq.a)localObject).errCode = paramFromServiceMsg.getResultCode();
      ((achq.a)localObject).retryCount = i;
      ((achq.a)localObject).timeoutReason = b(paramFromServiceMsg);
      a(paramToServiceMsg, 5006, false, new Object[] { Long.valueOf(l3), localObject });
    }
    hB(l1);
  }
  
  private void ar(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    int i = paramToServiceMsg.extraData.getInt("msgtype");
    int k = paramToServiceMsg.extraData.getInt("retryIndex");
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbReceiptRead><E><---handleC2CReceiptMessageError: ---cmd:MessageSvc.PbReceiptRead ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + ",sendC2CMessage error : peerUin:" + str + " msgseq::" + l1 + " msgType:" + i + " retryIndex:" + k + " resultCode:" + paramFromServiceMsg.getResultCode() + " timeout:" + l2);
    }
    ae(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = a(l1);
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label219;
      }
      paramToServiceMsg.getClass();
      if (!a(paramToServiceMsg, "msf")) {
        break label219;
      }
    }
    label219:
    while (!paramToServiceMsg.aFa()) {
      return;
    }
    f(3021, false, new Long[] { Long.valueOf(i), Long.valueOf(l1), Long.valueOf(paramFromServiceMsg.getResultCode()) });
    hB(l1);
  }
  
  private void ax(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 21)) {}
    long l2;
    long l3;
    long l4;
    long l5;
    Object localObject;
    do
    {
      do
      {
        return;
      } while (paramArrayOfByte[0] != 3);
      long l1 = aqoj.getLongData(paramArrayOfByte, 1);
      l2 = aqoj.getLongData(paramArrayOfByte, 5);
      l3 = aqoj.getLongData(paramArrayOfByte, 9);
      l4 = aqoj.getLongData(paramArrayOfByte, 13);
      l5 = aqoj.getLongData(paramArrayOfByte, 17);
      if (QLog.isColorLevel()) {
        QLog.d("Emoticon", 2, "uin:" + l1 + " epId=" + l2 + " expireTime=" + l3 + " flag=" + l4);
      }
      localObject = (ajdg)this.app.getManager(14);
    } while (((ajdg)localObject).c(Long.toString(l2), 0) != null);
    paramArrayOfByte = new EmoticonPackage();
    paramArrayOfByte.epId = Long.toString(l2);
    paramArrayOfByte.wordingId = l5;
    if (l4 == 1L) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfByte.valid = bool;
      paramArrayOfByte.expiretime = l3;
      paramArrayOfByte.aio = true;
      ((ajdg)localObject).m(paramArrayOfByte);
      ((ajdg)localObject).ff(paramArrayOfByte.epId, 0);
      localObject = (afke)this.app.getManager(43);
      ((afke)localObject).ex(paramArrayOfByte.epId, afke.cRu);
      ((afke)localObject).i(paramArrayOfByte);
      return;
    }
  }
  
  public static String b(FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013)))
    {
      if (paramFromServiceMsg.getAttribute("_tag_socket") != null) {
        return "timeout_reason_SERVER_NO_RESPONSE";
      }
      return (String)paramFromServiceMsg.getAttribute("_tag_socket_connerror", String.valueOf(paramFromServiceMsg.getResultCode()));
    }
    return null;
  }
  
  private void b(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, long paramLong, int paramInt, acci paramacci, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "sendHCTopicMessageInner");
    }
    long l2 = System.currentTimeMillis();
    long l1;
    if (paramMessageRecord.msg == null)
    {
      l1 = 0L;
      HotChatInfo localHotChatInfo = ((HotChatManager)this.app.getManager(60)).a(paramMessageRecord.frienduin);
      oidb_0xa89.ReqBody localReqBody = new oidb_0xa89.ReqBody();
      localReqBody.bytes_msg_body.set(ByteStringMicro.copyFrom(paramPbSendMsgReq.toByteArray()));
      localReqBody.bytes_poid.set(ByteStringMicro.copyFrom(localHotChatInfo.uuid.getBytes()));
      paramacci = makeOIDBPkg("OidbSvc.0xa89", 2697, 1, localReqBody.toByteArray(), paramLong, paramacci, false);
      paramacci.extraData.putString("uin", paramMessageRecord.frienduin);
      paramacci.extraData.putLong("msgsize", l1);
      paramacci.extraData.putLong("uniseq", paramMessageRecord.uniseq);
      paramacci.extraData.putLong("timeOut", paramLong);
      paramacci.extraData.putLong("msgSeq", paramMessageRecord.msgseq);
      paramacci.extraData.putLong("startTime", l2);
      paramacci.extraData.putInt("retryIndex", paramInt);
      paramacci.extraData.putInt("uintype", paramMessageRecord.istroop);
      paramacci.extraData.putInt("msgtype", paramMessageRecord.msgtype);
      paramacci.extraData.putString("groupuin", paramMessageRecord.frienduin);
      if (top.fI(paramMessageRecord.msgtype)) {
        paramacci.extraData.putBoolean("RichNotify", true);
      }
      paramacci.extraData.putInt("ROUNTING_TYPE", 21);
      paramacci.extraData.putInt("send_msg_req_size", paramacci.getWupBuffer().length);
      paramacci.extraData.putLong("msg_request_time", paramMessageRecord.time);
      paramacci.addAttribute("msgtype", Integer.valueOf(paramMessageRecord.msgtype));
      paramacci.addAttribute("msgSeq", Long.valueOf(paramMessageRecord.msgseq));
      paramacci.addAttribute("resend_by_user", Boolean.valueOf(paramBoolean));
      paramacci.addAttribute("retryIndex", Integer.valueOf(paramInt));
      if (paramMessageRecord.frienduin != null) {
        break label461;
      }
      paramPbSendMsgReq = "";
      label396:
      paramacci.addAttribute("uin", paramPbSendMsgReq);
      if (paramMessageRecord.senderuin != null) {
        break label469;
      }
    }
    label461:
    label469:
    for (paramMessageRecord = "";; paramMessageRecord = paramMessageRecord.senderuin)
    {
      paramacci.addAttribute("fromUin", paramMessageRecord);
      paramacci.addAttribute("normal_msg", Boolean.valueOf(true));
      o(paramacci);
      return;
      l1 = paramMessageRecord.msg.getBytes().length;
      break;
      paramPbSendMsgReq = paramMessageRecord.frienduin;
      break label396;
    }
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    if ((paramInt & 0x8) == 8)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleRestEnding!");
      }
      this.bIo = true;
      if ((!this.bIo) || (!aaL()) || (!aaM())) {}
    }
    synchronized (this.cE)
    {
      if (!this.cE.get())
      {
        this.cE.set(true);
        this.cE.notifyAll();
      }
      long l1 = ((Long)paramFromServiceMsg.getAttribute("infoSync_timestamp")).longValue();
      paramFromServiceMsg = createToServiceMsg("RegPrxySvc.PbSyncMsg", null);
      paramFromServiceMsg.addAttribute("infoSync_timestamp", Long.valueOf(l1));
      paramFromServiceMsg.setMsfCommand(MsfCommand.msf_pbSyncMsg);
      send(paramFromServiceMsg);
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponsePullGroupMsgSeq paramSvcResponsePullGroupMsgSeq)
  {
    if (paramSvcResponsePullGroupMsgSeq == null)
    {
      n(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    int k = paramToServiceMsg.extraData.getInt("doSome", 0);
    boolean bool = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
    StringBuilder localStringBuilder = new StringBuilder();
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("<<---handleGetPullTroopMsgNumResp msgStruct.cReplyCode: ").append(paramSvcResponsePullGroupMsgSeq.cReplyCode).append(",isUsedRegisterProxy: ").append(bool).append(",doSome: ").append(k);
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    if (paramSvcResponsePullGroupMsgSeq.cReplyCode != 0)
    {
      aj(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    String[] arrayOfString = this.ei;
    this.ei = null;
    this.cwP = 0;
    ArrayList localArrayList = new ArrayList();
    if (bool) {}
    for (HashMap localHashMap1 = new HashMap(this.jdField_a_of_type_Anaz.w());; localHashMap1 = null)
    {
      zxj localzxj = (zxj)this.app.getManager(125);
      HashMap localHashMap2 = new HashMap();
      int i = 0;
      if (i < paramSvcResponsePullGroupMsgSeq.vGroupInfo.size())
      {
        Object localObject1 = (GroupInfo)paramSvcResponsePullGroupMsgSeq.vGroupInfo.get(i);
        String str = String.valueOf(((GroupInfo)localObject1).lGroupCode);
        if (((GroupInfo)localObject1).lRedPackTime > 0L) {
          localHashMap2.put(str, String.valueOf(((GroupInfo)localObject1).lRedPackTime));
        }
        Object localObject2 = this.jdField_a_of_type_Anaz.e(str);
        long l2 = this.jdField_a_of_type_Anaz.aI(str);
        long l1;
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          l1 = ((Long)localObject2[0]).longValue();
          label295:
          if (QLog.isColorLevel())
          {
            localStringBuilder.setLength(0);
            localStringBuilder.append("handleGetPullTroopMsgNumResp getGroupMsgMemberSeq groupUin=").append(((GroupInfo)localObject1).lGroupCode).append(" memberseq=").append(((GroupInfo)localObject1).lMemberSeq).append(" groupSeq=").append(((GroupInfo)localObject1).lGroupSeq).append(" lMask=").append(((GroupInfo)localObject1).lMask).append(" localMemberMsgSeq=").append(l1).append(" localLastSeq=").append(l2);
            QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
          }
          if (!bool) {
            break label688;
          }
          if (((((GroupInfo)localObject1).lMask != 2L) && (((GroupInfo)localObject1).lMask != 3L)) || (this.app.a.abU())) {
            break label562;
          }
          En(str);
          label448:
          if (localHashMap1 != null) {
            localHashMap1.remove(str);
          }
          if (((GroupInfo)localObject1).lMask != 0L)
          {
            if (this.tj == null) {
              this.tj = new ArrayList();
            }
            localObject2 = new Setting();
            ((Setting)localObject2).Path = ("message.group.policy." + str);
            ((Setting)localObject2).Value = String.valueOf(((GroupInfo)localObject1).lMask);
            this.tj.add(localObject2);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          l1 = 0L;
          break label295;
          label562:
          this.jdField_a_of_type_Anaz.s(str, new Object[] { Long.valueOf(((GroupInfo)localObject1).lMemberSeq), Long.valueOf(((GroupInfo)localObject1).lGroupSeq) });
          if (((GroupInfo)localObject1).lGroupSeq <= l2)
          {
            En(str);
            if (l1 >= ((GroupInfo)localObject1).lMemberSeq) {
              break label448;
            }
            if (bIp)
            {
              a(4, paramToServiceMsg, paramFromServiceMsg, localObject1);
              break label448;
            }
            this.app.b().s(str, 1, ((GroupInfo)localObject1).lMemberSeq);
            break label448;
          }
          if (l1 >= ((GroupInfo)localObject1).lMemberSeq) {
            break label448;
          }
          this.jdField_a_of_type_Anaz.fR(str, 1);
          break label448;
          label688:
          this.jdField_a_of_type_Anaz.s(str, new Object[] { Long.valueOf(((GroupInfo)localObject1).lMemberSeq), Long.valueOf(((GroupInfo)localObject1).lGroupSeq) });
          if (l1 < ((GroupInfo)localObject1).lMemberSeq) {
            this.app.b().s(String.valueOf(((GroupInfo)localObject1).lGroupCode), 1, ((GroupInfo)localObject1).lMemberSeq);
          }
          l1 = this.jdField_a_of_type_Anaz.j(str, 1);
          localObject1 = a(str, 1, this.jdField_a_of_type_Anaz.aA(str), this.jdField_a_of_type_Anaz.aB(str), l1, ((GroupInfo)localObject1).lGroupSeq);
          int n = (int)(((Long)((Pair)localObject1).second).longValue() - ((Long)((Pair)localObject1).first).longValue());
          l1 = ((Long)((Pair)localObject1).first).longValue();
          l2 = ((Long)((Pair)localObject1).second).longValue();
          l1 = l2 - (1L + l1);
          if (l1 > 10) {}
          for (l1 = l2 - 10 + 1L;; l1 = l2 - l1)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder.setLength(0);
              localStringBuilder.append("---------handleGetPullTroopMsgNumResp troopUin: ").append(str).append(" msg count: ").append(n);
              QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
            }
            if (n > 0) {
              break label969;
            }
            ((apde)a("troop_processor")).b(str, null, k);
            break;
          }
          label969:
          localArrayList.add(str);
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            localObject1 = localArrayList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              a(str, l1, l2, false, null, k);
            }
          }
          else
          {
            notifyUI(4003, true, paramToServiceMsg.extraData.getStringArray("array_groupuin"));
          }
        }
      }
      localzxj.y(localHashMap2);
      if (!bool) {
        break;
      }
      if ((localHashMap1 != null) && (!localHashMap1.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp  RegisterProxyTroopSeq FailedTroopSize=" + localHashMap1.size());
        }
        paramToServiceMsg = localHashMap1.keySet().iterator();
        while (paramToServiceMsg.hasNext()) {
          En((String)paramToServiceMsg.next());
        }
      }
      if (!this.jdField_a_of_type_Anaz.awu()) {
        break;
      }
      notifyUI(4003, true, arrayOfString);
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    if (paramSvcRegisterProxyMsgResp.gourp_msg.has())
    {
      paramSvcRegisterProxyMsgResp = paramSvcRegisterProxyMsgResp.gourp_msg.get();
      int k = paramSvcRegisterProxyMsgResp.size();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleTroopMsgResp_PB, gourp_msg size:" + k);
      }
      int i = 0;
      if (i < k)
      {
        register_proxy.SvcResponsePbPullGroupMsgProxy localSvcResponsePbPullGroupMsgProxy = (register_proxy.SvcResponsePbPullGroupMsgProxy)paramSvcRegisterProxyMsgResp.get(i);
        if (this.bIn) {
          a(2, paramToServiceMsg, paramFromServiceMsg, localSvcResponsePbPullGroupMsgProxy, false);
        }
        for (;;)
        {
          i += 1;
          break;
          a(2, paramToServiceMsg, paramFromServiceMsg, localSvcResponsePbPullGroupMsgProxy, true);
        }
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, String paramString)
  {
    if ((paramToServiceMsg.extraData != null) && (paramToServiceMsg.extraData.getInt("msgtype") == -2007))
    {
      if (paramToServiceMsg.extraData.getInt("mediaType") == 2) {
        ajdg.fc(paramString, 7);
      }
    }
    else {
      return;
    }
    ajdg.fc(paramString, 6);
  }
  
  private void b(register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    if (paramSvcRegisterProxyMsgResp.msg_info.has())
    {
      this.cwE = ((register_proxy.SvcResponseMsgInfo)paramSvcRegisterProxyMsgResp.msg_info.get()).group_num.get();
      this.cwF = ((register_proxy.SvcResponseMsgInfo)paramSvcRegisterProxyMsgResp.msg_info.get()).discuss_num.get();
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg ,groupNum=" + this.cwE + ",discussionNum=" + this.cwF);
      }
      if ((this.cwE == 0) || (this.cwG >= this.cwE)) {
        notifyUI(4003, true, null);
      }
      if ((this.cwF == 0) || (this.cwH >= this.cwF)) {
        notifyUI(4002, true, null);
      }
    }
  }
  
  private boolean bG(long paramLong)
  {
    synchronized (this.iS)
    {
      if (this.iS.containsKey(Long.valueOf(paramLong)))
      {
        this.iS.remove(Long.valueOf(paramLong));
        return true;
      }
      return false;
    }
  }
  
  private Pair<Long, Long> c(String paramString, int paramInt)
  {
    long l1;
    long l2;
    long l3;
    Object localObject;
    if (paramInt == 3000)
    {
      l1 = this.jdField_a_of_type_Anaz.aG(paramString);
      l2 = this.jdField_a_of_type_Anaz.aC(paramString);
      l3 = this.jdField_a_of_type_Anaz.j(paramString, paramInt);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder(128);
        ((StringBuilder)localObject).append("guessPullMsgStartSeq uin = ").append(paramString).append(" ,type = ").append(paramInt).append(" ,lastSeq = ").append(l1).append(" ,expiredSeq = ").append(l2).append(" ,delSeq = ").append(l3);
        QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
      }
      List localList = this.app.b().k(paramString, paramInt);
      localObject = top.d(localList, false);
      l2 = Math.max(l3, l2);
      boolean bool1 = top.b(paramString, paramInt, (List)localObject);
      boolean bool2 = top.V((List)localObject);
      if ((!bool1) && (!bool2)) {
        break label776;
      }
      paramString = top.a(localList, false, 25);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "getRePullMsgSeqRange : pull more long msg");
      }
    }
    for (paramInt = 25;; paramInt = 10)
    {
      if ((paramString == null) || (paramString.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "return local is null!");
        }
        return new Pair(Long.valueOf(l1), Long.valueOf(l1));
        if (paramInt == 1)
        {
          l1 = this.jdField_a_of_type_Anaz.aA(paramString);
          l2 = this.jdField_a_of_type_Anaz.aB(paramString);
          break;
        }
        return null;
      }
      l3 = ((MessageRecord)paramString.get(0)).shmsgseq;
      long l4 = Math.max(l2, ((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq);
      l1 = Math.max(l2, l1);
      if (1L + l2 >= l3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "return seq = " + Math.max(l1 - paramInt, l4) + "," + l1 + ",lowSeq >= lastBreakSeq ");
        }
        return new Pair(Long.valueOf(Math.max(l1 - paramInt, l4)), Long.valueOf(l1));
      }
      if (l1 - l3 >= paramInt)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "return seq = " + Math.max(l1 - paramInt, l4) + "," + l1 + ",continuedList >= " + paramInt);
        }
        return new Pair(Long.valueOf(Math.max(l1 - paramInt, l4)), Long.valueOf(l1));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return seq = " + Math.max(l1 - paramInt, l2));
      }
      if (l1 > l4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "return ok lastSeq > lastLocalSeq , (" + Math.max(l1 - paramInt, l2) + "," + l1 + ")");
        }
        return new Pair(Long.valueOf(Math.max(l1 - paramInt, l2)), Long.valueOf(l1));
      }
      if (l1 == l4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "return ok lastSeq == lastLocalSeq , (" + Math.max(l1 - paramInt, l2) + "," + Math.max(l3 - 1L, l2) + ")");
        }
        return new Pair(Long.valueOf(Math.max(l1 - paramInt, l2)), Long.valueOf(l3 - 1L));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return lastSeq < lastLocalSeq");
      }
      return new Pair(Long.valueOf(l1), Long.valueOf(l1));
      label776:
      paramString = (String)localObject;
    }
  }
  
  public static String c(FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() == 1013) {
        paramFromServiceMsg = String.valueOf(1013);
      }
      String str;
      do
      {
        return paramFromServiceMsg;
        if (paramFromServiceMsg.getResultCode() != 1002) {
          break;
        }
        str = (String)paramFromServiceMsg.getAttribute("_tag_socket_connerror", "timeout_reason_UNKNOWN");
        paramFromServiceMsg = str;
      } while (!str.equals("conSucc"));
      return "timeout_reason_SERVER_NO_RESPONSE";
    }
    return null;
  }
  
  private void c(MessageRecord paramMessageRecord, achq paramachq)
  {
    oec.a().a(this.app, paramMessageRecord, paramachq, false);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, register_proxy.SvcRegisterProxyMsgResp paramSvcRegisterProxyMsgResp)
  {
    if (paramSvcRegisterProxyMsgResp.group_list.has())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> handleTroopList!");
      }
      apsa localapsa = (apsa)this.app.getManager(132);
      paramSvcRegisterProxyMsgResp = paramSvcRegisterProxyMsgResp.group_list.get();
      this.xG = paramSvcRegisterProxyMsgResp;
      Object localObject1 = this.jdField_a_of_type_Anaz;
      anaz.a.Gr = paramSvcRegisterProxyMsgResp;
      int i = 0;
      if (i < paramSvcRegisterProxyMsgResp.size())
      {
        localObject1 = (register_proxy.GroupList)paramSvcRegisterProxyMsgResp.get(i);
        if (localObject1 == null) {}
        label566:
        label577:
        for (;;)
        {
          i += 1;
          break;
          String str = String.valueOf(((register_proxy.GroupList)localObject1).group_code.get());
          Object localObject2 = this.jdField_a_of_type_Anaz.e(str);
          long l3 = this.jdField_a_of_type_Anaz.aI(str);
          long l2 = 0L;
          long l1 = l2;
          if (localObject2 != null)
          {
            l1 = l2;
            if (localObject2.length > 0) {
              l1 = ((Long)localObject2[0]).longValue();
            }
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).setLength(0);
            ((StringBuilder)localObject2).append("handleNewRegisterProxyMsg getGroupList groupCode=").append(((register_proxy.GroupList)localObject1).group_code.get()).append(" groupSeq=").append(((register_proxy.GroupList)localObject1).group_seq.get()).append(" memberSeq=").append(((register_proxy.GroupList)localObject1).member_seq.get()).append(" mask=").append(((register_proxy.GroupList)localObject1).mask.get()).append(" localMemberMsgSeq=").append(l1).append(" localLastSeq=").append(l3).append(" redpack_time=").append(((register_proxy.GroupList)localObject1).redpack_time.get()).append(" hasMsg=").append(((register_proxy.GroupList)localObject1).has_msg.get());
            QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject2).toString());
          }
          if ((((register_proxy.GroupList)localObject1).mask.get() == 1L) || (((register_proxy.GroupList)localObject1).mask.get() == 4L) || ((((register_proxy.GroupList)localObject1).mask.get() == 3L) && (str.equals(localapsa.BB()))))
          {
            this.jdField_a_of_type_Anaz.s(str, new Object[] { Long.valueOf(((register_proxy.GroupList)localObject1).member_seq.get()), Long.valueOf(((register_proxy.GroupList)localObject1).group_seq.get()) });
            if (l1 < ((register_proxy.GroupList)localObject1).member_seq.get())
            {
              if (((register_proxy.GroupList)localObject1).group_seq.get() > l3) {
                break label566;
              }
              a(4, paramToServiceMsg, paramFromServiceMsg, localObject1);
            }
          }
          for (;;)
          {
            if (((register_proxy.GroupList)localObject1).mask.get() == 0L) {
              break label577;
            }
            if (this.tj == null) {
              this.tj = new ArrayList();
            }
            localObject2 = new Setting();
            ((Setting)localObject2).Path = ("message.group.policy." + str);
            ((Setting)localObject2).Value = String.valueOf(((register_proxy.GroupList)localObject1).mask.get());
            this.tj.add(localObject2);
            break;
            this.jdField_a_of_type_Anaz.fR(str, 1);
          }
        }
      }
    }
  }
  
  private void cKc()
  {
    if (this.bIt) {
      return;
    }
    anot.a(this.app, "CliOper", "", "", "My_eq", "PC_Online_exp", 0, 0, "", "", "", "");
    this.bIt = true;
    Object localObject1 = BaseApplication.getContext();
    Object localObject3 = ((Context)localObject1).getString(2131696491);
    String str = ((Context)localObject1).getString(2131696491);
    Object localObject2 = aqcu.decodeResource(((Context)localObject1).getResources(), 2130845073);
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    localObject3 = new NotificationCompat.Builder((Context)localObject1).setContentTitle(str).setContentText("").setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker((CharSequence)localObject3).setWhen(System.currentTimeMillis());
    if (localObject2 != null) {
      ((NotificationCompat.Builder)localObject3).setLargeIcon((Bitmap)localObject2);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 11) {
        ((NotificationCompat.Builder)localObject3).setSmallIcon(2130845074);
      }
      localObject2 = new Intent("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION");
      ((Intent)localObject2).setPackage(MobileQQ.getContext().getPackageName());
      ((Intent)localObject2).putExtra("param_notifyid", 264);
      ((NotificationCompat.Builder)localObject3).setContentIntent(PendingIntent.getBroadcast((Context)localObject1, 0, (Intent)localObject2, 0));
      localObject1 = ((NotificationCompat.Builder)localObject3).build();
      if (localQQNotificationManager == null) {
        break;
      }
      localQQNotificationManager.cancel("Q.msg.MessageHandler_PcOnlineNotifition", 264);
      auqw.setMIUI6Badge(this.app.getApp(), 0, (Notification)localObject1);
      QQNotificationManager.addChannelIfNeed((Notification)localObject1, "CHANNEL_ID_OTHER");
      localQQNotificationManager.notify("Q.msg.MessageHandler_PcOnlineNotifition", 264, (Notification)localObject1);
      this.fK = new MessageHandler.9(this, localQQNotificationManager);
      ThreadManager.post(this.fK, 5, null, false);
      return;
      ((NotificationCompat.Builder)localObject3).setLargeIcon(aqcu.decodeResource(((Context)localObject1).getResources(), 2130845073));
    }
  }
  
  private void cKd()
  {
    if (this.bIu) {
      return;
    }
    anot.a(this.app, "CliOper", "", "", "My_eq", "PC_Online_exp", 0, 0, "", "", "", "");
    this.bIu = true;
    Object localObject1 = BaseApplication.getContext();
    Object localObject3 = ((Context)localObject1).getString(2131696487);
    String str = ((Context)localObject1).getString(2131696487);
    Object localObject2 = aqcu.decodeResource(((Context)localObject1).getResources(), 2130845070);
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    localObject3 = new NotificationCompat.Builder((Context)localObject1).setContentTitle(str).setContentText("").setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker((CharSequence)localObject3).setWhen(System.currentTimeMillis());
    if (localObject2 != null) {
      ((NotificationCompat.Builder)localObject3).setLargeIcon((Bitmap)localObject2);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 11) {
        ((NotificationCompat.Builder)localObject3).setSmallIcon(2130845071);
      }
      localObject2 = new Intent("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION");
      ((Intent)localObject2).setPackage(MobileQQ.getContext().getPackageName());
      ((Intent)localObject2).putExtra("param_notifyid", 263);
      ((NotificationCompat.Builder)localObject3).setContentIntent(PendingIntent.getBroadcast((Context)localObject1, 0, (Intent)localObject2, 0));
      localObject1 = ((NotificationCompat.Builder)localObject3).build();
      if (localQQNotificationManager == null) {
        break;
      }
      localQQNotificationManager.cancel("Q.msg.MessageHandler_IpadOnlineNotifition", 263);
      QQNotificationManager.addChannelIfNeed((Notification)localObject1, "CHANNEL_ID_OTHER");
      localQQNotificationManager.notify("Q.msg.MessageHandler_IpadOnlineNotifition", 263, (Notification)localObject1);
      this.fJ = new MessageHandler.10(this, localQQNotificationManager);
      ThreadManager.post(this.fJ, 5, null, false);
      return;
      ((NotificationCompat.Builder)localObject3).setLargeIcon(aqcu.decodeResource(((Context)localObject1).getResources(), 2130845070));
    }
  }
  
  private void cKg()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumberFinish");
    }
    if (this.jdField_a_of_type_Anaz.awt())
    {
      localObject2 = this.jdField_a_of_type_Anaz.dE();
      this.jdField_a_of_type_Anaz.dOM();
      localStringBuilder = null;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumberFinish vConfNumInfo size = " + ((List)localObject2).size());
        }
        localStringBuilder = new StringBuilder();
        localObject1 = new HashMap(this.jdField_a_of_type_Anaz.y());
        localObject2 = ((List)localObject2).iterator();
        label395:
        label418:
        label439:
        while (((Iterator)localObject2).hasNext())
        {
          localstConfNumInfo = (stConfNumInfo)((Iterator)localObject2).next();
          if (localstConfNumInfo != null)
          {
            str = String.valueOf(localstConfNumInfo.lConfUin);
            arrayOfObject = this.jdField_a_of_type_Anaz.d(str);
            l2 = this.jdField_a_of_type_Anaz.aH(str);
            if ((arrayOfObject != null) && (arrayOfObject.length > 0))
            {
              l1 = ((Long)arrayOfObject[0]).longValue();
              label213:
              if (QLog.isColorLevel())
              {
                localStringBuilder.setLength(0);
                localStringBuilder.append("addDisMsgMemberSeq uin = ").append(localstConfNumInfo.lConfUin).append(" memberseq = ").append(localstConfNumInfo.uMemberMsgSeq).append(" confMsgSeq =").append(localstConfNumInfo.uConfMsgSeq).append(" localLastSeq =").append(l2);
                QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
              }
              this.jdField_a_of_type_Anaz.r(String.valueOf(localstConfNumInfo.lConfUin), new Object[] { Long.valueOf(localstConfNumInfo.uMemberMsgSeq), Long.valueOf(localstConfNumInfo.uConfMsgSeq) });
              if (localstConfNumInfo.uConfMsgSeq > l2) {
                break label418;
              }
              Em(str);
              if (l1 < localstConfNumInfo.uMemberMsgSeq)
              {
                if (!bIp) {
                  break label395;
                }
                a(5, null, null, localstConfNumInfo);
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label439;
              }
              ((HashMap)localObject1).remove(str);
              break;
              l1 = 0L;
              break label213;
              this.app.b().s(str, 3000, localstConfNumInfo.uMemberMsgSeq);
              continue;
              if (l1 < localstConfNumInfo.uMemberMsgSeq) {
                this.jdField_a_of_type_Anaz.fS(str, 1);
              }
            }
          }
        }
      }
      while ((localObject1 != null) && (!((HashMap)localObject1).isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumberFinish  RegisterProxyDiscSeq FailedDiscSize=" + ((HashMap)localObject1).size());
        }
        localObject1 = ((HashMap)localObject1).keySet().iterator();
        while (((Iterator)localObject1).hasNext()) {
          Em((String)((Iterator)localObject1).next());
        }
        localObject1 = localStringBuilder;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumberFinish vConfNumInfo is null ! ");
          localObject1 = localStringBuilder;
        }
      }
      if (this.jdField_a_of_type_Anaz.awv()) {
        notifyUI(4002, true, null);
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject2;
      StringBuilder localStringBuilder;
      Object localObject1;
      stConfNumInfo localstConfNumInfo;
      String str;
      Object[] arrayOfObject;
      long l2;
      long l1;
      return;
    }
    QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumber waitting ... ");
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    do
    {
      return;
      paramToServiceMsg.extraData.getByte("cBodyType", (byte)-1).byteValue();
    } while (paramToServiceMsg.extraData.getInt("msgtype", -1) != -1000);
    a("actSendDiscussProcess", paramBoolean, paramToServiceMsg.extraData.getLong("msgsize", 0L), paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void d(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(acrg.jA(paramString)).a(acrg.cD(paramString), paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void dH(ArrayList<Long> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(aqgb.bM(((Long)paramArrayList.next()).longValue()));
    }
    cM(localArrayList);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    int i = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    if (i == 1) {
      f(paramToServiceMsg, paramFromServiceMsg, paramBoolean);
    }
    do
    {
      return;
      if ((i == 3) || (i == 14) || (i == 22))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramBoolean);
        return;
      }
    } while (i != 6);
    i(paramToServiceMsg, paramFromServiceMsg, paramBoolean);
  }
  
  private void e(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Anaz.awx()) && (this.jdField_a_of_type_Anaz.f(paramString, paramInt, paramLong)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "handleRevokingRichMsgCacheAndNotify, in revoking cache, isSuc:" + paramBoolean);
      }
      if (paramBoolean) {
        this.jdField_a_of_type_Anaz.aB(null);
      }
      this.app.b().a(paramInt).bEl();
    }
  }
  
  private void e(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(acrg.jA(paramString)).b(acrg.cD(paramString), paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void eH(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendC2CMessageResp_PB.");
    }
    Object localObject2 = paramToServiceMsg.getServiceCmd();
    String str1 = paramToServiceMsg.extraData.getString("uin");
    long l3 = paramToServiceMsg.extraData.getLong("uniseq");
    String str2 = paramToServiceMsg.extraData.getString("fileName");
    long l4 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l1 = paramToServiceMsg.extraData.getLong("timeOut");
    int i3 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    int i2 = paramToServiceMsg.extraData.getInt("msgtype");
    int i4 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    int k = anbh.b(i4, this.app);
    if (k == 1024) {
      k = paramToServiceMsg.extraData.getInt("uintype", k);
    }
    label543:
    label943:
    label1465:
    for (;;)
    {
      if (top.eD(k) == 1032) {}
      boolean bool1;
      label590:
      label1491:
      label2020:
      for (int n = paramToServiceMsg.extraData.getInt("key_confess_topicid", 0);; n = 0)
      {
        bool1 = paramToServiceMsg.extraData.getBoolean("RichNotify", false);
        Object localObject1 = new msg_svc.PbSendMsgResp();
        try
        {
          localObject1 = (msg_svc.PbSendMsgResp)((msg_svc.PbSendMsgResp)localObject1).mergeFrom((byte[])paramObject);
          paramObject = localObject1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i;
            StringBuilder localStringBuilder;
            if (QLog.isColorLevel())
            {
              QLog.e("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB : invalid.", localException);
              localStringBuilder = new StringBuilder().append("<---handleSendC2CMessageResp_PB : data:");
              if (paramObject != null) {
                break label543;
              }
            }
            for (paramObject = "null";; paramObject = Arrays.toString((byte[])paramObject))
            {
              QLog.e("Q.msg.MessageHandler", 2, paramObject);
              paramObject = new msg_svc.PbSendMsgResp();
              break;
            }
            if (paramObject.result.get() != 0)
            {
              i = paramObject.result.get();
              continue;
              if (i == 255)
              {
                i1 = 1;
                if (i1 != 0)
                {
                  localStringBuilder.getClass();
                  if (a(localStringBuilder, "server")) {
                    continue;
                  }
                }
                if (((k != 10002) && (k != 1001)) || (!ajrk.kE(i))) {
                  break label2020;
                }
                if (i == 48)
                {
                  if (k != 10002) {
                    break label1465;
                  }
                  i1 = 1;
                  this.app.a().t(str1, null);
                  ajrk.A(this.app, str1, i1);
                }
                anot.a(this.app, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_sig_expire", 0, 0, str1, String.valueOf(k), String.valueOf(i), "");
                if (QLog.isColorLevel()) {
                  QLog.e("Q.msg.MessageHandlerQ.nearby.nearby_sig", 2, "handleSendC2CMessageResp_PB, 部落、附近的人临时会话因为签名失败, uinType:" + k + "|replyCode:" + i);
                }
              }
              for (int i1 = 0;; i1 = i)
              {
                if ((i1 == 0) || (i1 == 241))
                {
                  boolean bool2 = this.app.a().e(str1, k, l3);
                  paramToServiceMsg.extraData.putBoolean("isJuhuaExist", bool2);
                  if (paramObject.send_time.has())
                  {
                    l1 = paramObject.send_time.get() & 0xFFFFFFFF;
                    c(str1, k, l3, l1, str2);
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB updateSendMsgTime: sendBuddyPb: respData.uSendTime:" + l1 + ",peerUin:" + str1);
                    }
                  }
                  localObject2 = this.app.b().b(str1, k, l3);
                  if ((localObject2 instanceof RecommendCommonMessage))
                  {
                    if ((paramObject.text_analysis_result.has()) && (paramObject.text_analysis_result.get() == 1))
                    {
                      paramObject = "1";
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB text_analysis_result=" + paramObject);
                      }
                      ((MessageRecord)localObject2).saveExtInfoToExtStr("ark_text_analysis_flag", paramObject);
                    }
                  }
                  else
                  {
                    long l5 = paramToServiceMsg.extraData.getLong("msg_request_time", 0L);
                    if ((l5 <= 0L) || (k != 0)) {
                      break label1491;
                    }
                    l1 = 0L;
                    long l2 = l1;
                    if (paramFromServiceMsg.getAttribute("__timestamp_msf2net") != null)
                    {
                      l2 = l1;
                      if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null)
                      {
                        l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)paramFromServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
                        l1 = l2;
                        if (l2 < 0L) {
                          l1 = 0L;
                        }
                        l2 = l1;
                        if (l1 > 2147483647L) {
                          l2 = 0L;
                        }
                      }
                    }
                    paramObject = new d();
                    paramObject.Qt = l2;
                    paramObject.Qu = System.currentTimeMillis();
                    paramObject.Qs = (paramObject.Qu - l5);
                    paramObject.Qr = paramToServiceMsg.extraData.getLong("msg_send_to_request_cost", 0L);
                    paramObject.mUinType = 0;
                    paramObject.bIy = ((Boolean)paramFromServiceMsg.getAttribute("conn_cross_oper_flag", Boolean.valueOf(false))).booleanValue();
                    paramObject.bIz = ((Boolean)paramFromServiceMsg.getAttribute("attr_quick_send_by_xg", Boolean.valueOf(false))).booleanValue();
                    paramObject.bIA = ((Boolean)paramFromServiceMsg.getAttribute("attr_weaknet_sent_flag", Boolean.valueOf(false))).booleanValue();
                    notifyUI(6003, true, new Object[] { str1, l3 + "", paramObject });
                  }
                  for (;;)
                  {
                    if (bool1)
                    {
                      paramObject = new achq.a();
                      paramObject.retryCount = (i3 + 1);
                      a(paramToServiceMsg, 5006, true, new Object[] { Long.valueOf(l3), paramObject });
                      e(str1, k, l3, true);
                    }
                    e(paramToServiceMsg, paramFromServiceMsg, true);
                    hB(l4);
                    if ((k == 1025) || (k == 1024))
                    {
                      l1 = localStringBuilder.Y(System.currentTimeMillis());
                      ((ashy)this.app.getBusinessHandler(85)).bB(str1, l1);
                    }
                    S((MessageRecord)localObject2);
                    n = 0;
                    ((ajkw)this.app.getManager(166)).a(str1, k, l3, i1, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("startTime", 0L));
                    kct.a(this.app, i2, str1, k, l3);
                    if (n != 0) {
                      break;
                    }
                    wte.a().h(this.app, l3);
                    return;
                    i1 = 0;
                    break label590;
                    i1 = 0;
                    this.app.a().s(str1, null);
                    break label668;
                    paramObject = "0";
                    break label943;
                    if (top.eD(k) == 1032) {
                      notifyUI(8035, true, new Object[] { str1, Integer.valueOf(k), Long.valueOf(l3), Integer.valueOf(n) });
                    } else {
                      notifyUI(6003, true, new String[] { str1, l3 + "" });
                    }
                  }
                }
                a(paramObject, str1, k, i1);
                if ((i1 == 10) || (i1 == 34)) {
                  if (a(this.app.b().b(str1, k, l3), removeMessageObserver(paramToServiceMsg)))
                  {
                    hB(l4);
                    return;
                  }
                }
                for (i = 1;; i = 0)
                {
                  a(paramToServiceMsg, paramObject);
                  i4 = gy(i4);
                  localObject2 = new Object[8];
                  localObject2[0] = str1;
                  localObject2[1] = Integer.valueOf(k);
                  localObject2[2] = Integer.valueOf(i1);
                  localObject2[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
                  localObject2[4] = Long.valueOf(l1);
                  localObject2[5] = Long.valueOf(l3);
                  if (paramObject.errmsg.has()) {}
                  for (paramObject = paramObject.errmsg.get();; paramObject = "")
                  {
                    localObject2[6] = paramObject;
                    a((Object[])localObject2, paramFromServiceMsg.getUin(), i1);
                    if (top.eD(k) == 1032) {
                      localObject2[7] = Integer.valueOf(n);
                    }
                    f(i4, true, localObject2);
                    if (bool1)
                    {
                      paramObject = new achq.a();
                      paramObject.errCode = 2900;
                      paramObject.Qw = i1;
                      paramObject.retryCount = (i3 + 1);
                      paramObject.timeoutReason = b(paramFromServiceMsg);
                      paramObject.cwV = 1;
                      a(paramToServiceMsg, 5006, false, new Object[] { Long.valueOf(l3), paramObject });
                      e(str1, k, l3, false);
                    }
                    if ((i2 == -7005) && (QLog.isColorLevel())) {
                      QLog.e("Q.msg.MessageHandler", 2, "ExtendFriendLimitChat SendC2CMessageResp_PB MessageForLimitChatConfirm Uniseq = " + l3 + " replyCode = " + i1);
                    }
                    e(paramToServiceMsg, paramFromServiceMsg, true);
                    hB(l4);
                    ap(paramToServiceMsg, paramFromServiceMsg);
                    if (k != 1025)
                    {
                      n = i;
                      if (k != 1024) {
                        break;
                      }
                    }
                    l1 = localStringBuilder.Y(System.currentTimeMillis());
                    ((ashy)this.app.getBusinessHandler(85)).K(str1, i1, l1);
                    n = i;
                    break;
                  }
                }
              }
            }
            else
            {
              i = 0;
            }
          }
        }
        if ((paramObject == null) || (!paramObject.result.has()))
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB : server did not return a valid result code, use 4 instead.");
          }
          i = 4;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendC2CMessageResp_PB : ---cmd:" + (String)localObject2 + "----replyCode:" + i + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + " peerUin:" + str1 + " uniseq:" + l3 + " msgSeq:" + l4 + " msgType:" + i2 + " uinType:" + k + " routingType:" + i4);
          }
          paramFromServiceMsg.extraData.putLong("ServerReplyCode", i);
          ae(paramToServiceMsg, paramFromServiceMsg);
          localObject1 = a(l4);
          if (localObject1 != null) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendC2CMessageResp_PB : ---cmd:" + (String)localObject2 + ",no SendMessageHandler found.");
          }
          wte.a().h(this.app, l3);
        }
      }
    }
  }
  
  private void eI(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleSendTroopMessageRespPB enter");
    }
    str = paramToServiceMsg.extraData.getString("groupuin");
    n = paramToServiceMsg.extraData.getInt("msgtype");
    localObject3 = paramToServiceMsg.getServiceCmd();
    Object localObject1 = new msg_svc.PbSendMsgResp();
    try
    {
      localObject1 = (msg_svc.PbSendMsgResp)((msg_svc.PbSendMsgResp)localObject1).mergeFrom((byte[])paramObject);
      paramObject = localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        long l3;
        long l4;
        Object localObject4;
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder().append("<---handleSendTroopMessageRespPB:");
          if (paramObject != null) {
            break label335;
          }
        }
        for (paramObject = "null";; paramObject = Arrays.toString((byte[])paramObject))
        {
          QLog.e("Q.msg.MessageHandler", 2, paramObject, localException);
          paramObject = null;
          break;
        }
        if (paramObject.result.get() != 0)
        {
          i = paramObject.result.get();
          continue;
          int k;
          Object localObject2;
          boolean bool1;
          if (i == 255)
          {
            k = 1;
            if (k != 0)
            {
              localException.getClass();
              if (a(localException, "server")) {
                continue;
              }
            }
            localObject4 = (TroopManager)this.app.getManager(52);
            ((TroopManager)localObject4).Fv(str);
            localObject3 = new Object[7];
            localObject3[0] = str;
            localObject3[1] = Integer.valueOf(1);
            localObject3[2] = Integer.valueOf(i);
            localObject3[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
            localObject3[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
            localObject3[5] = Long.valueOf(l4);
            if (paramObject == null) {
              break label1186;
            }
            localObject2 = paramObject.errmsg.get();
            localObject3[6] = localObject2;
            localObject2 = ((HotChatManager)this.app.getManager(60)).a(str);
            if (localObject2 == null) {
              break label1275;
            }
            if ((i != 108) && (i != 102)) {
              break label1264;
            }
            if (localObject2 == null) {
              break label1194;
            }
            acfx.a(this.app, (HotChatInfo)localObject2);
            bool1 = false;
          }
          for (;;)
          {
            int i1 = anbh.b(paramToServiceMsg.extraData.getInt("ROUNTING_TYPE"), this.app);
            long l1;
            long l2;
            if (bool1)
            {
              localObject2 = this.app.b().b(str, i1, l4);
              if ((localObject2 instanceof RecommendCommonMessage))
              {
                if ((paramObject.text_analysis_result.has()) && (paramObject.text_analysis_result.get() == 1))
                {
                  paramObject = "1";
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB text_analysis_result=" + paramObject);
                  }
                  ((MessageRecord)localObject2).saveExtInfoToExtStr("ark_text_analysis_flag", paramObject);
                }
              }
              else
              {
                boolean bool2 = this.app.a().e(paramToServiceMsg.extraData.getString("groupuin"), 1, l4);
                paramToServiceMsg.extraData.putBoolean("isJuhuaExist", bool2);
                long l5 = paramToServiceMsg.extraData.getLong("msg_request_time", 0L);
                if (l5 <= 0L) {
                  break label1424;
                }
                l1 = 0L;
                l2 = l1;
                if (paramFromServiceMsg.getAttribute("__timestamp_msf2net") != null)
                {
                  l2 = l1;
                  if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null)
                  {
                    l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)paramFromServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
                    l1 = l2;
                    if (l2 < 0L) {
                      l1 = 0L;
                    }
                    l2 = l1;
                    if (l1 > 2147483647L) {
                      l2 = 0L;
                    }
                  }
                }
                paramObject = new d();
                paramObject.Qt = l2;
                paramObject.Qu = System.currentTimeMillis();
                paramObject.Qs = (paramObject.Qu - l5);
                paramObject.Qr = paramToServiceMsg.extraData.getLong("msg_send_to_request_cost", 0L);
                paramObject.mUinType = 1;
                paramObject.bIy = ((Boolean)paramFromServiceMsg.getAttribute("conn_cross_oper_flag", Boolean.valueOf(false))).booleanValue();
                paramObject.bIz = ((Boolean)paramFromServiceMsg.getAttribute("attr_quick_send_by_xg", Boolean.valueOf(false))).booleanValue();
                paramObject.bIA = ((Boolean)paramFromServiceMsg.getAttribute("attr_weaknet_sent_flag", Boolean.valueOf(false))).booleanValue();
                notifyUI(6003, true, new Object[] { paramToServiceMsg.extraData.getString("groupuin"), String.valueOf(l4), paramObject });
                S((MessageRecord)localObject2);
                k = 0;
                if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
                {
                  i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
                  paramObject = new achq.a();
                  if (!bool1) {
                    break label1903;
                  }
                  paramObject.errCode = paramFromServiceMsg.getResultCode();
                  paramObject.retryCount = (i1 + 1);
                }
              }
            }
            for (;;)
            {
              paramObject.cwV = 1;
              a(paramToServiceMsg, 5006, bool1, new Object[] { Long.valueOf(l4), paramObject });
              g(paramToServiceMsg, paramFromServiceMsg, true);
              hB(l3);
              ap(paramToServiceMsg, paramFromServiceMsg);
              ((ajkw)this.app.getManager(166)).a(paramToServiceMsg.extraData.getString("groupuin"), 1, l4, i, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("startTime", 0L));
              kct.a(this.app, n, str, 1, l4);
              if (k != 0) {
                break;
              }
              wte.a().h(this.app, l4);
              return;
              k = 0;
              break label382;
              localObject2 = "";
              break label506;
              localObject2 = this.app.a().a();
              localObject4 = ((acxw)localObject2).a(str, 1);
              if (localObject4 != null) {
                ((acxw)localObject2).f((RecentUser)localObject4);
              }
              f(1002, true, localObject3);
              f(2001, true, localObject3);
              f(2002, true, localObject3);
              bool1 = false;
              break label568;
              if (i != 0) {
                break label1936;
              }
              bool1 = true;
              break label568;
              switch (i)
              {
              default: 
                bool1 = false;
                break;
              case 0: 
              case 241: 
                bool1 = true;
                break;
              case 101: 
              case 102: 
              case 103: 
                ((TroopManager)localObject4).Fr(str);
                localObject2 = this.app.a().a();
                localObject4 = ((acxw)localObject2).a(str, 1);
                if (localObject4 != null) {
                  ((acxw)localObject2).f((RecentUser)localObject4);
                }
                f(1002, true, localObject3);
                f(2001, true, localObject3);
                f(2002, true, localObject3);
                bool1 = false;
                break;
                paramObject = "0";
                break label643;
                notifyUI(6003, true, new String[] { paramToServiceMsg.extraData.getString("groupuin"), String.valueOf(l4) });
                break label987;
                if ((i == 10) || (i == 34))
                {
                  k = 1;
                  if (a(this.app.b().b(str, i1, l4), removeMessageObserver(paramToServiceMsg))) {
                    hB(l3);
                  }
                }
                else
                {
                  k = 0;
                }
                if (i == 299)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB MessageRecord send fail uinseq = " + l4 + ", msgseq = " + l3);
                  }
                  localObject2 = this.app.b().b(str, i1, l4);
                  hB(l3);
                  this.app.a().e(str, 1, l4);
                  if (localObject2 == null) {
                    break label1768;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB MessageRecord send fail, MessageRecord=" + ((MessageRecord)localObject2).toString());
                  }
                  l2 = ((MessageRecord)localObject2).shmsgseq;
                  l1 = ((MessageRecord)localObject2).time;
                }
                for (;;)
                {
                  localObject2 = new MessageForUniteGrayTip();
                  localObject4 = new ahwa(str, str, localObject3[6].toString(), 1, -5040, 131082, l1);
                  ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.app, (ahwa)localObject4);
                  ((MessageForUniteGrayTip)localObject2).isread = true;
                  ((MessageForUniteGrayTip)localObject2).shmsgseq = l2;
                  ahwb.a(this.app, (MessageForUniteGrayTip)localObject2);
                  a(paramToServiceMsg, paramObject);
                  a((Object[])localObject3, paramFromServiceMsg.getUin(), i);
                  f(3002, false, localObject3);
                  break;
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB MessageRecord send fail, uniseq not match !");
                  }
                  localObject2 = this.app.b().k(str, 1);
                  if ((localObject2 != null) && (!((List)localObject2).isEmpty()) && (((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1)).shmsgseq > 0L))
                  {
                    l2 = ((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1)).shmsgseq;
                    l1 = ((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1)).time;
                  }
                  else
                  {
                    l1 = anaz.gQ();
                    l2 = 0L;
                  }
                }
                paramObject.errCode = 2900;
                paramObject.Qw = i;
                paramObject.retryCount = (i1 + 1);
                paramObject.timeoutReason = b(paramFromServiceMsg);
              }
            }
            bool1 = false;
          }
        }
        else
        {
          i = 0;
        }
      }
    }
    if ((paramObject == null) || (!paramObject.result.has()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB:server did not return a valid result code, use 4 instead.");
      }
      i = 4;
      paramFromServiceMsg.extraData.putLong("ServerReplyCode", i);
      ae(paramToServiceMsg, paramFromServiceMsg);
      l3 = paramToServiceMsg.extraData.getLong("msgSeq");
      l4 = paramToServiceMsg.extraData.getLong("uniseq");
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendTroopMessageRespPB: ---cmd:" + (String)localObject3 + "----replyCode:" + i + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + ",SendTroopMessageResp : peerUin:" + str + ",uniseq:" + l4 + ",msgSeq:" + l3);
      }
      localObject1 = a(l3);
      if (localObject1 != null) {
        break label371;
      }
      wte.a().h(this.app, l4);
    }
  }
  
  private void eJ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    if (achp.a(i, this.app)) {
      eH(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    for (;;)
    {
      b(paramToServiceMsg, "0");
      return;
      if (i == 9) {
        a().f(7002, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
      } else if (i == 13) {
        a().f(7003, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
      } else if (i == 4) {
        eN(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (i == 2) {
        eI(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  private void eL(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = paramFromServiceMsg.getWupBuffer();
    byte[] arrayOfByte = new byte[paramObject.length - 4];
    aqoj.copyData(arrayOfByte, 0, paramObject, 4, paramObject.length - 4);
    paramObject = new OnlinePushTrans.PbMsgInfo();
    try
    {
      paramObject.mergeFrom(arrayOfByte);
      if (paramObject != null)
      {
        if ((paramObject.uint32_general_flag.get() & 0x20) == 32)
        {
          aqel.setMute(true);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, new Object[] { "PbPushTransMsg muteGeneralFlag:", Integer.valueOf(paramObject.uint32_general_flag.get()) });
          }
          if (paramObject.msg_type.get() != 207) {
            break label221;
          }
          ax(paramObject.msg_data.get().toByteArray());
        }
      }
      else
      {
        paramToServiceMsg = createToServiceMsg("OnlinePush.RespPush");
        if (paramObject != null)
        {
          i = paramFromServiceMsg.getRequestSsoSeq();
          paramToServiceMsg.extraData.putInt("svrip", paramObject.svr_ip.get());
          paramToServiceMsg.extraData.putInt("seq", i);
        }
        paramToServiceMsg.extraData.putLong("lUin", Long.parseLong(this.app.getCurrentAccountUin()));
        paramToServiceMsg.setNeedCallback(false);
        send(paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      for (;;)
      {
        int i;
        paramObject.printStackTrace();
        paramObject = null;
        continue;
        aqel.setMute(false);
        continue;
        label221:
        if ((paramObject.msg_type.get() == 44) || (paramObject.msg_type.get() == 34))
        {
          a().y(3, 1, false);
          long l1;
          long l2;
          if (paramObject.msg_type.get() == 34)
          {
            paramToServiceMsg = (apsw)this.app.getManager(48);
            paramToServiceMsg = paramObject.msg_data.get().toByteArray();
            l1 = aqoj.getLongData(paramToServiceMsg, 0);
            i = paramToServiceMsg[4];
            l2 = aqoj.getLongData(paramToServiceMsg, 5);
            paramObject.from_uin.get();
            ((TroopManager)this.app.getManager(52)).I(String.valueOf(l1), String.valueOf(l2), i);
            paramToServiceMsg = (OnlinePushTrans.ExtGroupKeyInfo)paramObject.ext_group_key_info.get();
            if (paramToServiceMsg != null)
            {
              l1 = paramToServiceMsg.cur_max_seq.get();
              l2 = paramToServiceMsg.cur_time.get();
              if (QLog.isColorLevel()) {
                QLog.d("GrayTipsForTroop", 2, "OnlinePushTrans 0x22 maxseq = " + l1 + ", maxTime = " + l2);
              }
            }
          }
          else if (paramObject.msg_type.get() == 44)
          {
            paramToServiceMsg = paramObject.msg_data.get().toByteArray();
            long l3 = aqoj.getLongData(paramToServiceMsg, 0);
            i = paramToServiceMsg[4];
            i = paramToServiceMsg[5];
            if ((i == 0) || (i == 1)) {
              l2 = aqoj.getLongData(paramToServiceMsg, 6);
            }
            for (l1 = 0L;; l1 = aqoj.getLongData(paramToServiceMsg, 10))
            {
              if (QLog.isColorLevel()) {
                QLog.d(".troop.push_msg", 2, new Object[] { "GroupCode: ", Long.valueOf(l3) });
              }
              wja.a(".troop.push_msg", this.app, 86, 0, 0, Arrays.asList(new Long[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l1) }), 500);
              break;
              l2 = aqoj.getLongData(paramToServiceMsg, 6);
            }
          }
        }
        else if ((paramObject.msg_type.get() == 529) && (paramObject.msg_subtype.get() == 11))
        {
          a("video_processor").f(3001, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject.msg_data.get().toByteArray() });
        }
      }
    }
  }
  
  private void eM(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (RespClientMsg)paramObject;
    if (paramObject == null)
    {
      ab(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    paramToServiceMsg.extraData.getLong("startTime", 0L);
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("uniseq");
    long l3 = paramToServiceMsg.extraData.getLong("to");
    long l4 = paramToServiceMsg.extraData.getLong("timeOut");
    hB(l1);
    if (paramObject.stHeader.eReplyCode == 0)
    {
      this.app.a().e(String.valueOf(paramToServiceMsg.extraData.getLong("to")), 1001, l2);
      notifyUI(6003, true, new String[] { String.valueOf(paramToServiceMsg.extraData.getLong("to")), l2 + "" });
      return;
    }
    int i = paramObject.stHeader.eReplyCode;
    paramToServiceMsg = l3 + "";
    this.app.b().b(paramToServiceMsg, 1001, l2, 32768, paramFromServiceMsg.getResultCode());
    f(3001, false, new Object[] { String.valueOf(l3), Integer.valueOf(1001), Integer.valueOf(i), null, Long.valueOf(l4), Long.valueOf(l2) });
  }
  
  private void eN(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleSendDiscussionMsgRespPB enter");
    }
    if (paramObject == null) {}
    int i;
    long l3;
    long l4;
    int n;
    Object localObject2;
    label343:
    label379:
    int k;
    label390:
    do
    {
      return;
      Object localObject1 = new msg_svc.PbSendMsgResp();
      try
      {
        localObject1 = (msg_svc.PbSendMsgResp)((msg_svc.PbSendMsgResp)localObject1).mergeFrom((byte[])paramObject);
        paramObject = localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("<---handleSendDiscussionMsgRespPB:");
            if (paramObject != null) {
              break label343;
            }
          }
          for (paramObject = "null";; paramObject = Arrays.toString((byte[])paramObject))
          {
            QLog.e("Q.msg.MessageHandler", 2, paramObject, localException);
            paramObject = null;
            break;
          }
          if (paramObject.result.get() != 0) {
            i = paramObject.result.get();
          }
        }
      }
      i = 0;
      if ((paramObject == null) || (!paramObject.result.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<---handleSendDiscussionMsgRespPB did not return a valid result code, use 4 instead.");
        }
        i = 4;
        paramFromServiceMsg.extraData.putLong("ServerReplyCode", i);
        ae(paramToServiceMsg, paramFromServiceMsg);
        l3 = paramToServiceMsg.extraData.getLong("uniseq");
        l4 = paramToServiceMsg.extraData.getLong("msgSeq");
        n = paramToServiceMsg.extraData.getInt("msgtype");
        localObject1 = paramToServiceMsg.extraData.getString("uToUin");
        localObject2 = paramToServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendDiscussionMsgRespPB: ---cmd:" + (String)localObject2 + "----replyCode:" + i + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + "SendDiscussionMsgResp : peerUin:" + (String)localObject1 + ",uniseq:" + l3 + ",msgSeq:" + l4);
        }
        localObject2 = a(l4);
        if (localObject2 != null) {
          break label379;
        }
        wte.a().h(this.app, l3);
      }
      if (i != 255) {
        break label1103;
      }
      k = 1;
      if (k == 0) {
        break;
      }
      localObject2.getClass();
    } while (a((SendMessageHandler)localObject2, "server"));
    boolean bool1;
    label483:
    int i1;
    switch (i)
    {
    default: 
      bool1 = false;
      i1 = anbh.b(paramToServiceMsg.extraData.getInt("ROUNTING_TYPE"), this.app);
      if (bool1)
      {
        localObject2 = this.app.b().b(localException, i1, l3);
        if ((localObject2 instanceof RecommendCommonMessage))
        {
          if ((paramObject.text_analysis_result.has()) && (paramObject.text_analysis_result.get() == 1))
          {
            paramObject = "1";
            label558:
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<---handleSendDiscussionMsgRespPB text_analysis_result=" + paramObject);
            }
            ((MessageRecord)localObject2).saveExtInfoToExtStr("ark_text_analysis_flag", paramObject);
          }
        }
        else
        {
          boolean bool2 = this.app.a().e(paramToServiceMsg.extraData.getString("uToUin"), 3000, l3);
          paramToServiceMsg.extraData.putBoolean("isJuhuaExist", bool2);
          long l5 = paramToServiceMsg.extraData.getLong("msg_request_time", 0L);
          if (l5 <= 0L) {
            break label1128;
          }
          long l1 = 0L;
          long l2 = l1;
          if (paramFromServiceMsg.getAttribute("__timestamp_msf2net") != null)
          {
            l2 = l1;
            if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null)
            {
              l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)paramFromServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
              l1 = l2;
              if (l2 < 0L) {
                l1 = 0L;
              }
              l2 = l1;
              if (l1 > 2147483647L) {
                l2 = 0L;
              }
            }
          }
          paramObject = new d();
          paramObject.Qt = l2;
          paramObject.Qu = System.currentTimeMillis();
          paramObject.Qs = (paramObject.Qu - l5);
          paramObject.Qr = paramToServiceMsg.extraData.getLong("msg_send_to_request_cost", 0L);
          paramObject.mUinType = 3000;
          paramObject.bIy = ((Boolean)paramFromServiceMsg.getAttribute("conn_cross_oper_flag", Boolean.valueOf(false))).booleanValue();
          paramObject.bIz = ((Boolean)paramFromServiceMsg.getAttribute("attr_quick_send_by_xg", Boolean.valueOf(false))).booleanValue();
          paramObject.bIA = ((Boolean)paramFromServiceMsg.getAttribute("attr_weaknet_sent_flag", Boolean.valueOf(false))).booleanValue();
          notifyUI(6003, true, new Object[] { paramToServiceMsg.extraData.getString("uToUin"), String.valueOf(l3), paramObject });
          label906:
          S((MessageRecord)localObject2);
          k = 0;
          label915:
          if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
          {
            i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
            paramObject = new achq.a();
            if (!bool1) {
              break label1394;
            }
            paramObject.errCode = paramFromServiceMsg.getResultCode();
            paramObject.retryCount = (i1 + 1);
          }
        }
      }
      break;
    }
    for (;;)
    {
      paramObject.cwV = 1;
      a(paramToServiceMsg, 5006, bool1, new Object[] { Long.valueOf(l3), paramObject });
      d(paramToServiceMsg, paramFromServiceMsg, true);
      hB(l4);
      ap(paramToServiceMsg, paramFromServiceMsg);
      ((ajkw)this.app.getManager(166)).a(paramToServiceMsg.extraData.getString("uToUin"), 3000, l3, i, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("startTime", 0L));
      kct.a(this.app, n, localException, 3000, l3);
      if (k != 0) {
        break;
      }
      wte.a().h(this.app, l3);
      return;
      label1103:
      k = 0;
      break label390;
      bool1 = true;
      break label483;
      bool1 = false;
      break label483;
      paramObject = "0";
      break label558;
      label1128:
      notifyUI(6003, true, new String[] { paramToServiceMsg.extraData.getString("uToUin"), String.valueOf(l3) });
      break label906;
      if ((i == 10) || (i == 34))
      {
        k = 1;
        if (a(this.app.b().b(localException, i1, l3), removeMessageObserver(paramToServiceMsg))) {
          hB(l4);
        }
      }
      else
      {
        k = 0;
      }
      a(paramToServiceMsg, paramObject);
      localObject2 = paramToServiceMsg.extraData;
      Object[] arrayOfObject = new Object[6];
      arrayOfObject[0] = ((Bundle)localObject2).getString("uToUin");
      arrayOfObject[1] = Integer.valueOf(3000);
      arrayOfObject[2] = Integer.valueOf(i);
      arrayOfObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
      arrayOfObject[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
      arrayOfObject[5] = Long.valueOf(l3);
      a(arrayOfObject, paramFromServiceMsg.getUin(), i);
      f(3008, false, arrayOfObject);
      if ((paramObject != null) && (paramObject.errmsg.has()) && (paramObject.errmsg.get() != null) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.MessageHandler", 2, "send dicussion msg failed: " + paramObject.errmsg.get());
      }
      break label915;
      label1394:
      paramObject.errCode = 2900;
      paramObject.retryCount = (i1 + 1);
      paramObject.Qw = i;
      paramObject.timeoutReason = b(paramFromServiceMsg);
    }
  }
  
  private void eN(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Anaz.fR(paramString1, 2);
    Object localObject = this.jdField_a_of_type_Anaz.U(paramString1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "----------handleTroopMsgResponseFinishedAndNotify troopUin: " + paramString1 + ", funcName:" + paramString2);
    }
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      this.jdField_a_of_type_Anaz.Qg(paramString1);
      paramString2 = ((ArrayList)localObject).iterator();
      while (paramString2.hasNext())
      {
        localObject = (Object[])paramString2.next();
        if ((localObject != null) && (localObject.length >= 2)) {
          a("troop_processor").f(1001, new Object[] { localObject, null, Boolean.valueOf(false) });
        }
      }
    }
    paramString1 = this.jdField_a_of_type_Anaz.a(paramString1);
    if (paramString1 != null) {
      ((apde)a("troop_processor")).a(paramString1);
    }
  }
  
  private void eO(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int k = 0;
    int i1 = 0;
    cmd0x9db.RspBody localRspBody = new cmd0x9db.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    long l2 = 0L;
    int n = -1;
    if (localRspBody.int32_result.has()) {
      n = localRspBody.int32_result.get();
    }
    long l1;
    if ((i == 0) && (n == 0))
    {
      k = 1;
      i = 1;
      l1 = l2;
      if (localRspBody.rpt_uint64_uin.has())
      {
        paramFromServiceMsg = localRspBody.rpt_uint64_uin.get();
        l1 = l2;
        if (paramFromServiceMsg.size() > 0) {
          l1 = ((Long)paramFromServiceMsg.get(0)).longValue();
        }
      }
      l2 = l1;
      if (!localRspBody.uint32_sequence.has()) {
        break label388;
      }
      i1 = localRspBody.uint32_sequence.get();
      paramFromServiceMsg = null;
      k = i;
      i = i1;
    }
    for (;;)
    {
      i1 = paramToServiceMsg.extraData.getInt("fromType");
      if ((k != 0) && (l1 > 0L))
      {
        DO(Long.toString(l1));
        l2 = paramToServiceMsg.extraData.getLong("insertTinnyid");
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleInsertBlackList success, tinnyid:" + l2);
        }
        notifyUI(8017, true, new Object[] { Integer.valueOf(i1), Long.valueOf(l2), Long.toString(l1), Integer.valueOf(i) });
        return;
        if (localRspBody.str_errormessage.has())
        {
          paramFromServiceMsg = localRspBody.str_errormessage.get();
          i = 0;
          l1 = 0L;
          k = i1;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleInsertBlackList failed :" + paramFromServiceMsg + " code:" + n);
        }
        notifyUI(8017, false, new Object[] { Integer.valueOf(i1), Integer.valueOf(n), paramFromServiceMsg });
        return;
      }
      label388:
      i = 0;
      paramFromServiceMsg = null;
      l1 = l2;
    }
  }
  
  private void eP(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          int i;
          boolean bool2;
          paramFromServiceMsg.printStackTrace();
        }
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()))
      {
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.MessageHandler", 2, "handle_oidb_0x4ff_42024 ret=" + i);
        }
        if ((i == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          i = paramToServiceMsg.length;
          bool2 = true;
          bool1 = bool2;
          if (4 > i) {
            break label205;
          }
          paramToServiceMsg = String.valueOf(aqoj.getLongData(paramToServiceMsg, 0));
          if (paramToServiceMsg != null)
          {
            bool1 = bool2;
            if (paramToServiceMsg.equals(this.app.getAccount())) {
              break label205;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.MessageHandler", 2, "handle_oidb_0x4ff_42024 uin error");
          }
        }
      }
    }
    label205:
    while (!QLog.isColorLevel())
    {
      return;
      bool1 = false;
    }
    QLog.i("Q.msg.MessageHandler", 2, "handle_oidb_0x4ff_42024 suc=" + bool1);
  }
  
  private void eQ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!paramToServiceMsg.extraData.getBoolean("used_register_proxy", false))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandler", 2, "<<---handlegetPullDiscussionMsgNumber ERROR isUsedRegisterProxy = false ! ");
      }
      return;
    }
    paramObject = (SvcResponsePullDisMsgSeq)paramObject;
    this.app.getCurrentAccountUin();
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<<---handlegetPullDiscussionMsgNumber is null");
      }
      am(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    int i = paramObject.cReplyCode;
    Object localObject = paramObject.strResult;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<<---handleGetDiscussionMsgNum resp.cReplyCode: " + i);
    }
    if (i != 0)
    {
      am(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    paramObject = paramObject.vConfNumInfo;
    paramToServiceMsg = this.ej;
    this.ej = null;
    if (paramObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<<---handleGetDiscussionMsgNum add cache " + paramObject.size());
      }
      this.jdField_a_of_type_Anaz.mo(paramObject);
    }
    if ((paramToServiceMsg != null) && (paramObject != null))
    {
      paramFromServiceMsg = new HashSet();
      paramObject = paramObject.iterator();
      while (paramObject.hasNext())
      {
        localObject = (stConfNumInfo)paramObject.next();
        if (localObject != null) {
          paramFromServiceMsg.add(String.valueOf(((stConfNumInfo)localObject).lConfUin));
        }
      }
      int k = paramToServiceMsg.length;
      i = 0;
      while (i < k)
      {
        paramObject = paramToServiceMsg[i];
        if (!paramFromServiceMsg.contains(paramObject))
        {
          this.jdField_a_of_type_Anaz.fS(paramObject, 2);
          if (this.jdField_a_of_type_Anaz.V(paramObject) != null) {
            this.jdField_a_of_type_Anaz.Qi(paramObject);
          }
        }
        i += 1;
      }
    }
    this.jdField_a_of_type_Anaz.Y(paramToServiceMsg);
    cKg();
  }
  
  private void eR(ToServiceMsg paramToServiceMsg, FromServiceMsg arg2, Object paramObject)
  {
    String str = (String)???.getAttribute("_tag_LOGSTR");
    msg_svc.PbGetDiscussMsgResp localPbGetDiscussMsgResp1 = new msg_svc.PbGetDiscussMsgResp();
    msg_svc.PbGetDiscussMsgResp localPbGetDiscussMsgResp2;
    boolean bool1;
    boolean bool2;
    long l1;
    try
    {
      localPbGetDiscussMsgResp1 = (msg_svc.PbGetDiscussMsgResp)localPbGetDiscussMsgResp1.mergeFrom((byte[])paramObject);
      if (localPbGetDiscussMsgResp1 == null)
      {
        anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
        an(paramToServiceMsg, ???);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "Exception occurs while parsing the byte array.");
        }
        localPbGetDiscussMsgResp2 = null;
      }
      bool1 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
      bool2 = paramToServiceMsg.extraData.getBoolean("used_new_register_proxy", false);
      new ArrayList();
      boolean bool3 = paramToServiceMsg.extraData.getBoolean("isRefreshHead", false);
      l1 = paramToServiceMsg.extraData.getLong("lDisUin", localPbGetDiscussMsgResp2.discuss_uin.get());
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("handleGetPullDiscussionMsgResp_PB res.cReplyCode = ").append(localPbGetDiscussMsgResp2.result.get()).append(" discussUin: ").append(l1).append(" isRefreshHead: ").append(bool3).append(", dataHash=").append(paramObject.hashCode()).append(" rtnBeginSeq:").append(localPbGetDiscussMsgResp2.return_begin_seq.get()).append(" rtnEndSeq:").append(localPbGetDiscussMsgResp2.return_end_seq.get());
        if (localPbGetDiscussMsgResp2.msg.get() == null) {
          break label360;
        }
        ???.append(" msgSize:").append(localPbGetDiscussMsgResp2.msg.get().size());
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, ???.toString());
        }
        synchronized (a(String.valueOf(l1), 3000))
        {
          if (!a(paramToServiceMsg, localPbGetDiscussMsgResp2)) {
            break;
          }
          return;
        }
        label360:
        ???.append(" msg:null.");
      }
      paramObject = this.jdField_a_of_type_Anaz.n(localPbGetDiscussMsgResp2.discuss_uin.get());
      this.jdField_a_of_type_Anaz.q(String.valueOf(l1), localPbGetDiscussMsgResp2.discuss_info_seq.get(), localPbGetDiscussMsgResp2.last_get_time.get());
      if (!bool3) {}
    }
    for (;;)
    {
      try
      {
        a("disc_processor").f(1003, new Object[] { paramToServiceMsg, paramObject, localPbGetDiscussMsgResp2, str });
        this.jdField_a_of_type_Anaz.li(localPbGetDiscussMsgResp2.discuss_uin.get());
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgResp refreshDiscussionHead exception ! ", paramToServiceMsg);
        continue;
      }
      for (;;)
      {
        try
        {
          a("disc_processor").f(1002, new Object[] { paramToServiceMsg, paramObject, localPbGetDiscussMsgResp2 });
          if (!bool2) {
            continue;
          }
          this.cwH += 1;
          this.jdField_a_of_type_Anaz.fS(String.valueOf(l1), 2);
        }
        catch (Exception paramToServiceMsg)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgResp initGetPullDiscussionMsg exception ! ", paramToServiceMsg);
          if (!bool2) {
            continue;
          }
          this.cwH += 1;
          this.jdField_a_of_type_Anaz.fS(String.valueOf(l1), 2);
          continue;
          eR(String.valueOf(l1), "handleGetPullDiscussionMsgResp");
          continue;
        }
        finally
        {
          if (!bool2) {
            continue;
          }
          this.cwH += 1;
          this.jdField_a_of_type_Anaz.fS(String.valueOf(l1), 2);
          throw paramToServiceMsg;
          eR(String.valueOf(l1), "handleGetPullDiscussionMsgResp");
          continue;
        }
        if ((!bool1) || (!this.jdField_a_of_type_Anaz.awv())) {
          break label726;
        }
        MsgAutoMonitorUtil.getInstance().markDisFinishTime();
        notifyUI(4002, true, null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgResp notify NOTIFY_TYPE_GET_DISCUSSION_MSG_FIN ");
        break;
        eR(String.valueOf(l1), "handleGetPullDiscussionMsgResp");
      }
      label726:
      if ((bool2) && (this.cwF != 0) && (this.cwH >= this.cwF))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<--- handleGetPullDiscussionMsgResp notify NOTIFY_TYPE_GET_DISCUSSION_MSG_FIN , discussionNum:" + this.cwF + " , recvDiscNum:" + this.cwH);
        }
        MsgAutoMonitorUtil.getInstance().markDisFinishTime();
        notifyUI(4002, true, null);
      }
    }
  }
  
  private void eR(String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(128);
      ((StringBuilder)localObject).append("handleDiscMsgResponseFinishAndNotify uin = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", funcName=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_Anaz.fS(paramString1, 2);
    paramString2 = this.jdField_a_of_type_Anaz.V(paramString1);
    if ((paramString2 != null) && (!paramString2.isEmpty()))
    {
      paramString2 = new ArrayList(paramString2);
      this.jdField_a_of_type_Anaz.Qi(paramString1);
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        localObject = (Object[])paramString2.next();
        if ((localObject != null) && (localObject.length >= 3)) {
          a("disc_processor").f(1001, new Object[] { localObject[0], localObject[1], localObject[2], Boolean.valueOf(false) });
        }
      }
    }
    paramString1 = this.jdField_a_of_type_Anaz.a(paramString1);
    if (paramString1 != null) {
      ((acqs)a("disc_processor")).a(paramString1);
    }
  }
  
  private void eS(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyC2CMsgResp.");
    }
    if (bIp)
    {
      a(1, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    a("c2c_processor").f(1002, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
  }
  
  private void eT(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyTroopMsgResp_PB.");
    }
    if (bIp)
    {
      a(2, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    eV(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void eU(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof RegisterPushNotice)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleRegisterProxyEndResp RegPrxySvc.NoticeEnd ERROR");
      }
      return;
    }
    paramFromServiceMsg = (RegisterPushNotice)paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, new Object[] { "registerproxy->handleRegisterProxyEndResp RegPrxySvc.NoticeEnd endseq=" + paramFromServiceMsg.uEndSeq + ",timeoutflag=" + paramFromServiceMsg.ulTimeOutFlag, ", uInterval_forbid_pulldown=", Long.valueOf(paramFromServiceMsg.uInterval_forbid_pulldown) });
    }
    long l1;
    if (paramFromServiceMsg.uEndSeq == this.cwB)
    {
      l1 = 0L;
      this.j = new Pair(paramFromServiceMsg, Long.valueOf(0L));
      this.Qk = SystemClock.uptimeMillis();
      hD(paramFromServiceMsg.uInterval_forbid_pulldown);
    }
    for (;;)
    {
      if ((this.cwD != 0) && (paramFromServiceMsg.uEndSeq == this.cwD))
      {
        this.app.a().PF(false);
        this.cwD = 0;
      }
      if (((!aaL()) || (!aaM())) && (bIp)) {
        break;
      }
      synchronized (this.cE)
      {
        if (this.j != null)
        {
          this.j = null;
          if ((l1 == 1L) || (!this.jdField_a_of_type_Anaz.awv()) || (!this.jdField_a_of_type_Anaz.awu()))
          {
            cKl();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyEndResp RegPrxySvc.NoticeEnd notify");
            }
            notifyUI(4013, true, new Long[] { Long.valueOf(paramFromServiceMsg.ulTimeOutFlag), Long.valueOf(l1) });
          }
          this.cE.set(true);
          this.cE.notifyAll();
        }
        return;
      }
      if (paramFromServiceMsg.uEndSeq != this.cwC) {
        break;
      }
      this.j = new Pair(paramFromServiceMsg, Long.valueOf(1L));
      l1 = 1L;
    }
  }
  
  private void eV(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {
      QLog.e("Q.msg.MessageHandler", 1, "doMsgProxyTroopMsgResp_PB return by null data");
    }
    label218:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyTroopMsgResp_PB.");
      }
      Object localObject1;
      if ((paramObject instanceof register_proxy.SvcResponsePbPullGroupMsgProxy)) {
        localObject1 = (register_proxy.SvcResponsePbPullGroupMsgProxy)paramObject;
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label218;
        }
        try
        {
          localObject1 = ((register_proxy.SvcResponsePbPullGroupMsgProxy)localObject1).msg_content.get().toByteArray();
          int i = localObject1.length - 4;
          byte[] arrayOfByte = new byte[i];
          aqoj.copyData(arrayOfByte, 0, (byte[])localObject1, 4, i);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyTroopMsgResp_PB. dataHash=" + paramObject.hashCode() + ", newDataHash=" + arrayOfByte.hashCode());
          }
          a(paramToServiceMsg, paramFromServiceMsg, arrayOfByte, true);
          return;
        }
        catch (Exception paramToServiceMsg) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.msg.MessageHandler", 2, "<---handleMsgProxyTroopMsgResp_PB : decode pb:", paramToServiceMsg);
        return;
        localObject1 = new register_proxy.SvcResponsePbPullGroupMsgProxy();
        try
        {
          localObject1 = (register_proxy.SvcResponsePbPullGroupMsgProxy)((register_proxy.SvcResponsePbPullGroupMsgProxy)localObject1).mergeFrom((byte[])paramObject);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.MessageHandler", 2, "<---handleMsgProxyTroopMsgResp_PB : decode SvcResponsePbPullGroupMsgProxy:", localException);
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  private void eW(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyDiscussMsgResp_PB.");
    }
    if (bIp)
    {
      a(3, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    eX(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void eX(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {
      QLog.e("Q.msg.MessageHandler", 1, "doMsgProxyDiscussMsgResp_PB return by null data");
    }
    label201:
    for (;;)
    {
      return;
      Object localObject1;
      if ((paramObject instanceof register_proxy.SvcPbResponsePullDisMsgProxy)) {
        localObject1 = (register_proxy.SvcPbResponsePullDisMsgProxy)paramObject;
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label201;
        }
        try
        {
          localObject1 = ((register_proxy.SvcPbResponsePullDisMsgProxy)localObject1).msg_content.get().toByteArray();
          int i = localObject1.length - 4;
          byte[] arrayOfByte = new byte[i];
          aqoj.copyData(arrayOfByte, 0, (byte[])localObject1, 4, i);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyDiscussMsgResp_PB. dataHash=" + paramObject.hashCode() + ", newDataHash=" + arrayOfByte.hashCode());
          }
          eR(paramToServiceMsg, paramFromServiceMsg, arrayOfByte);
          return;
        }
        catch (Exception paramToServiceMsg) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.msg.MessageHandler", 2, "<---handleMsgProxyDiscussMsgResp_PB : decode pb:", paramToServiceMsg);
        return;
        localObject1 = new register_proxy.SvcPbResponsePullDisMsgProxy();
        try
        {
          localObject1 = (register_proxy.SvcPbResponsePullDisMsgProxy)((register_proxy.SvcPbResponsePullDisMsgProxy)localObject1).mergeFrom((byte[])paramObject);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.MessageHandler", 2, "<---handleMsgProxyDiscussMsgResp_PB : decode SvcPbResponsePullDisMsgProxy:", localException);
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  private void eY(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {
      n(paramToServiceMsg, paramFromServiceMsg);
    }
    Object localObject1;
    do
    {
      for (;;)
      {
        return;
        localObject1 = new msg_svc.PbUnReadMsgSeqResp();
        try
        {
          paramObject = (msg_svc.PbUnReadMsgSeqResp)((msg_svc.PbUnReadMsgSeqResp)localObject1).mergeFrom((byte[])paramObject);
          if ((paramObject.group_unread_info.has()) && (paramObject.group_unread_info.get() != null)) {
            break label91;
          }
          if (QLog.isColorLevel())
          {
            QLog.e("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp_PB: server did not return group_unread_info");
            return;
          }
        }
        catch (Exception paramToServiceMsg) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp_PB: server did not return a valid response");
    return;
    label91:
    paramObject = (msg_svc.PbPullGroupMsgSeqResp)paramObject.group_unread_info.get();
    if (paramObject.result.get() != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<<---handleGetPullTroopMsgNumResp_PB groupMsgSeqResp.result: " + paramObject.result.get() + " ,groupMsgSeqResp.errmsg: " + paramObject.errmsg.get());
      }
      aj(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    int k = paramToServiceMsg.extraData.getInt("doSome", 0);
    paramToServiceMsg = new StringBuilder();
    if (QLog.isColorLevel())
    {
      paramToServiceMsg.append("<<---handleGetPullTroopMsgNumResp_PB groupMsgSeqResp.result: ").append(paramObject.result.get()).append(" ,doSome: ").append(k);
      QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg.toString());
    }
    this.cwP = 0;
    int i = 0;
    label249:
    long l2;
    long l1;
    label340:
    boolean bool;
    label371:
    long l3;
    if (i < paramObject.group_info_resp.get().size())
    {
      localObject1 = (msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)paramObject.group_info_resp.get().get(i);
      paramFromServiceMsg = String.valueOf(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_code.get());
      Object localObject2 = this.jdField_a_of_type_Anaz.e(paramFromServiceMsg);
      l2 = this.jdField_a_of_type_Anaz.aI(paramFromServiceMsg);
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        break label859;
      }
      l1 = ((Long)localObject2[0]).longValue();
      localObject2 = (HotChatManager)this.app.getManager(60);
      if ((localObject2 == null) || (!((HotChatManager)localObject2).kj(paramFromServiceMsg))) {
        break label865;
      }
      bool = true;
      if (!bool)
      {
        this.jdField_a_of_type_Anaz.s(paramFromServiceMsg, new Object[] { Long.valueOf(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).member_seq.get()), Long.valueOf(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_seq.get()) });
        if (l1 < ((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).member_seq.get()) {
          this.app.b().s(String.valueOf(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_code.get()), 1, ((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).member_seq.get());
        }
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg.setLength(0);
        paramToServiceMsg.append("handleGetPullTroopMsgNumResp_PB getGroupMsgMemberSeq groupUin=").append(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_code.get()).append(" ,memberseq=").append(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).member_seq.get()).append(" ,groupSeq=").append(((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_seq.get()).append(" ,localMemberMsgSeq=").append(l1).append(" ,localLastSeq=").append(l2).append(", isHotChat=").append(bool);
        QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg.toString());
      }
      l2 = this.jdField_a_of_type_Anaz.j(paramFromServiceMsg, 1);
      localObject1 = a(paramFromServiceMsg, 1, this.jdField_a_of_type_Anaz.aA(paramFromServiceMsg), this.jdField_a_of_type_Anaz.aB(paramFromServiceMsg), l2, ((msg_svc.PbPullGroupMsgSeqResp.GroupInfoResp)localObject1).group_seq.get());
      int n = (int)(((Long)((Pair)localObject1).second).longValue() - ((Long)((Pair)localObject1).first).longValue());
      l2 = ((Long)((Pair)localObject1).first).longValue();
      l3 = ((Long)((Pair)localObject1).second).longValue();
      l2 = l3 - (l2 + 1L);
      if (l2 <= 10) {
        break label871;
      }
      l2 = l3 - 10 + 1L;
      label693:
      if (QLog.isColorLevel())
      {
        paramToServiceMsg.setLength(0);
        paramToServiceMsg.append("---------handleGetPullTroopMsgNumResp_PB troopUin: ").append(paramFromServiceMsg).append(" ,msg count: ").append(n);
        QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg.toString());
      }
      if ((n <= 0) && (k == 8))
      {
        if (QLog.isColorLevel()) {
          QLog.d(".troop.joinSplitMsg", 2, "handleGetPullTroopMsgNumResp_PB doSome=" + k + "  beginSeq:" + (l1 - 10L) + " endSeq:" + l1);
        }
        a(paramFromServiceMsg, l1 - 10L, l1, false, null, k);
      }
      if (n > 0) {
        break label881;
      }
      ((apde)a("troop_processor")).b(paramFromServiceMsg, null, k);
    }
    for (;;)
    {
      i += 1;
      break label249;
      break;
      label859:
      l1 = 0L;
      break label340;
      label865:
      bool = false;
      break label371;
      label871:
      l2 = l3 - l2;
      break label693;
      label881:
      a(paramFromServiceMsg, l2, l3, false, null, k);
    }
  }
  
  private void eZ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int k = 1;
    if (paramObject != null)
    {
      paramToServiceMsg = (RequestPushStatus)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "RequestPushStatus status:" + paramToServiceMsg.cStatus + "supportdataline:" + paramToServiceMsg.cDataLine);
      }
      paramFromServiceMsg = (ackv)this.app.getBusinessHandler(10);
      if (paramToServiceMsg.cStatus == 1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.msg.MessageHandler", 4, "PConline now");
        }
        cKc();
        i = 1;
        if (!((rwp)this.app.getManager(335)).w(paramToServiceMsg.vecInstanceList)) {
          break label269;
        }
        k = (byte)k;
        paramFromServiceMsg.aa(i);
        paramFromServiceMsg.ac(paramToServiceMsg.cDataLine);
        paramFromServiceMsg.ad(paramToServiceMsg.cPrintable);
        paramFromServiceMsg.ae(paramToServiceMsg.cViewFile);
        paramFromServiceMsg.k(paramToServiceMsg.nPCVer);
        paramFromServiceMsg.hK(paramToServiceMsg.nClientType);
        paramFromServiceMsg.hL(paramToServiceMsg.nInstanceId);
        paramFromServiceMsg.JG(k);
        paramFromServiceMsg.cMg();
        ((acde)this.app.getBusinessHandler(8)).a().b(i, paramToServiceMsg.cDataLine, paramToServiceMsg.cPrintable, paramToServiceMsg.cViewFile, paramToServiceMsg.nPCVer);
      }
    }
    label269:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        if (paramToServiceMsg.cStatus == 2)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.msg.MessageHandler", 4, "PCoffline now");
          }
          Jq(0);
        }
        int i = 0;
        continue;
        k = 0;
      }
    }
    QLog.d("Q.msg.MessageHandler", 2, "RequestPushStatus ret, but data is null");
  }
  
  private void f(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleC2CMessagePush");
    }
    synchronized (this.kk)
    {
      Ff(true);
      a((byte)1, null, 0, false, false, false, (String)paramFromServiceMsg.getAttribute("sso_push_timestamp"), 0, paramObject);
      return;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    while (paramToServiceMsg.extraData.getByte("binaryPic", (byte)0).byteValue() == 1) {
      return;
    }
    a("actSendC2CProcess", paramBoolean, paramToServiceMsg.extraData.getLong("msgsize", 0L), paramToServiceMsg, paramFromServiceMsg);
  }
  
  private Object[] f()
  {
    Object localObject = ((acdu)this.mApp.getManager(53)).getDiscussList();
    String[] arrayOfString = new String[((ArrayList)localObject).size()];
    long[] arrayOfLong = new long[((ArrayList)localObject).size()];
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (QLog.isColorLevel()) {
      localStringBuilder.append("--->>initBeforGetPullDiscussionMsgNum: discussLength:").append(((ArrayList)localObject).size()).append(", discussionUinArray: ");
    }
    localObject = ((ArrayList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = ((DiscussionInfo)((Iterator)localObject).next()).uin;
      arrayOfString[i] = str;
      arrayOfLong[i] = this.jdField_a_of_type_Anaz.aH(str);
      this.jdField_a_of_type_Anaz.fS(str, 0);
      this.jdField_a_of_type_Anaz.Ql(str);
      this.jdField_a_of_type_Anaz.Qh(str);
      if (QLog.isColorLevel()) {
        localStringBuilder.append(str).append(":").append(arrayOfLong[i]).append(", ");
      }
      i += 1;
    }
    if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    if ((arrayOfString == null) || (i == 0))
    {
      notifyUI(4002, true, null);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>initBeforGetPullDiscussionMsgNum, get discussionUin is null or length is 0, notifyUI NOTIFY_TYPE_GET_DISCUSSION_MSG_FIN ");
      }
      return null;
    }
    return new Object[] { arrayOfString, arrayOfLong, Integer.valueOf(i) };
  }
  
  private void fa(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramObject = new Bundle();
      paramObject.putParcelable("ToServiceMsg", paramToServiceMsg);
      paramObject.putParcelable("FromServiceMsg", paramFromServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleInfoSyncResp request success!");
      }
      notifyUI(4004, true, paramObject);
      return;
    }
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleInfoSyncResp request timeout!");
      }
      notifyUI(4004, false, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleInfoSyncResp request error!");
    }
    notifyUI(4004, false, null);
  }
  
  private void fb(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg begin!");
    long l1 = System.currentTimeMillis();
    paramObject = a((byte[])paramObject);
    if (paramObject == null) {}
    do
    {
      do
      {
        return;
      } while (!a(paramObject));
      if ((!paramObject.flag.has()) || (paramObject.flag.get() == 0)) {
        break;
      }
      int i = paramObject.flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<---handleNewRegisterProxyMsg flag = " + i);
      }
      anaz localanaz = this.jdField_a_of_type_Anaz;
      if (anaz.a == null)
      {
        localanaz = this.jdField_a_of_type_Anaz;
        anaz.a = new anaz.e();
      }
      b(paramObject);
      a("c2c_msg", paramToServiceMsg, paramFromServiceMsg, paramObject.c2c_msg);
      a("pub_account_msg", paramToServiceMsg, paramFromServiceMsg, paramObject.pub_account_msg);
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      a(paramObject);
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      Js(i);
      b(paramFromServiceMsg, i);
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg end! cost :" + (System.currentTimeMillis() - l1));
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---handleNewRegisterProxyMsg-->flag error!");
    }
    notifyUI(4004, false, null);
  }
  
  private void fc(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    if (a(l1) == null) {}
    do
    {
      return;
      paramToServiceMsg = new msg_svc.PbMsgReadedReportResp();
      try
      {
        paramToServiceMsg = (msg_svc.PbMsgReadedReportResp)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (QLog.isColorLevel())
        {
          if (paramToServiceMsg.c2c_read_report.result.has()) {
            QLog.d("Q.msg.MessageHandler", 2, "<ReadReport_All>C2C replyCode:" + paramToServiceMsg.c2c_read_report.result.get() + "reqSeq:" + l1);
          }
          if ((paramToServiceMsg.dis_read_report.has()) && (((msg_svc.PbDiscussReadedReportResp)paramToServiceMsg.dis_read_report.get(0)).result.has())) {
            QLog.d("Q.msg.MessageHandler", 2, "<ReadReport_All>Dis replyCode:" + ((msg_svc.PbDiscussReadedReportResp)paramToServiceMsg.dis_read_report.get(0)).result.get() + "reqSeq:" + l1);
          }
          if ((paramToServiceMsg.grp_read_report.has()) && (((msg_svc.PbGroupReadedReportResp)paramToServiceMsg.grp_read_report.get(0)).result.has())) {
            QLog.d("Q.msg.MessageHandler", 2, "<ReadReport_All>GRP replyCode:" + ((msg_svc.PbGroupReadedReportResp)paramToServiceMsg.grp_read_report.get(0)).result.get() + " reqSeq:" + l1);
          }
        }
        hB(l1);
        return;
      }
      catch (Exception paramToServiceMsg) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q.msg.MessageHandler", 2, "<ReadReport>handleMsgReadedReportResp_PB : server did not return a valid response,reqSeq " + l1);
  }
  
  private void ff(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleSendHotchatTopicMessageRespPB enter");
    }
    String str = paramToServiceMsg.extraData.getString("groupuin");
    long l4 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l5 = paramToServiceMsg.extraData.getLong("uniseq");
    long l1 = 0L;
    Object localObject1 = null;
    try
    {
      Object localObject2 = new oidb_0xa89.RspBody();
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject2);
      if (localObject2 != null)
      {
        l1 = ((oidb_0xa89.RspBody)localObject2).uint64_msg_seq.get();
        localObject1 = ((oidb_0xa89.RspBody)localObject2).bytes_poid.get().toStringUtf8();
        ((oidb_0xa89.RspBody)localObject2).bytes_msg_error_info.get().toStringUtf8();
        if (((oidb_0xa89.RspBody)localObject2).bytes_rsp_msg_body.has())
        {
          localObject2 = new msg_svc.PbSendMsgResp();
          try
          {
            paramObject = (msg_svc.PbSendMsgResp)((msg_svc.PbSendMsgResp)localObject2).mergeFrom((byte[])paramObject);
            localObject2 = localObject1;
            localObject1 = paramObject;
            paramObject = localObject2;
          }
          catch (Exception paramObject)
          {
            for (;;)
            {
              arrayOfObject = null;
              paramObject = localObject1;
              localObject1 = arrayOfObject;
            }
          }
          paramFromServiceMsg.extraData.putLong("ServerReplyCode", i);
          ae(paramToServiceMsg, paramFromServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, String.format("%s, troopUin = %s, replycode=%d, msgSeq=%d, uniseq=%d, shmsgseq=%d, uuid=%s", new Object[] { "handleSendHotchatTopicMessageRespPB", str, Integer.valueOf(i), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l1), paramObject }));
          }
          paramObject = a(l4);
          if (paramObject == null) {
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int i = 4;
        Object[] arrayOfObject = null;
        continue;
        int k;
        label410:
        boolean bool;
        if (i == 255)
        {
          k = 1;
          if (k != 0)
          {
            paramObject.getClass();
            if (a(paramObject, "server")) {
              continue;
            }
          }
          arrayOfObject = new Object[7];
          arrayOfObject[0] = str;
          arrayOfObject[1] = Integer.valueOf(1026);
          arrayOfObject[2] = Integer.valueOf(i);
          arrayOfObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
          arrayOfObject[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
          arrayOfObject[5] = Long.valueOf(l5);
          if (localObject1 == null) {
            break label664;
          }
          paramObject = ((msg_svc.PbSendMsgResp)localObject1).errmsg.get();
          arrayOfObject[6] = paramObject;
          bool = false;
          if ((i != 108) && (i != 102)) {
            break label738;
          }
          paramObject = ((HotChatManager)this.app.getManager(60)).a(str);
          if (paramObject == null) {
            break label671;
          }
          acfx.a(this.app, paramObject);
          bool = false;
          label466:
          if (!bool) {
            break label749;
          }
          this.app.a().e(str, 1026, l5);
          long l3 = paramToServiceMsg.extraData.getLong("msg_request_time", 0L);
          notifyUI(6003, true, new String[] { str, String.valueOf(l5) });
          long l2 = l3;
          if (l3 == 0L) {
            l2 = anaz.gQ();
          }
          b(str, 1026, l5, l1, l2);
          label558:
          if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
          {
            k = paramToServiceMsg.extraData.getInt("retryIndex", 0);
            paramObject = new achq.a();
            if (!bool) {
              break label774;
            }
            paramObject.errCode = paramFromServiceMsg.getResultCode();
            paramObject.retryCount = (k + 1);
          }
        }
        for (;;)
        {
          paramObject.cwV = 1;
          a(paramToServiceMsg, 5006, bool, new Object[] { Long.valueOf(l5), paramObject });
          hB(l4);
          ap(paramToServiceMsg, paramFromServiceMsg);
          return;
          k = 0;
          break;
          label664:
          paramObject = "";
          break label410;
          label671:
          paramObject = this.app.a().a();
          localObject1 = paramObject.a(str, 1);
          if (localObject1 != null) {
            paramObject.f((RecentUser)localObject1);
          }
          f(1002, true, arrayOfObject);
          f(2001, true, arrayOfObject);
          f(2002, true, arrayOfObject);
          bool = false;
          break label466;
          label738:
          if (i != 0) {
            break label466;
          }
          bool = true;
          break label466;
          label749:
          a(arrayOfObject, paramFromServiceMsg.getUin(), i);
          f(3013, false, arrayOfObject);
          break label558;
          label774:
          paramObject.errCode = 2900;
          paramObject.Qw = i;
          paramObject.retryCount = (k + 1);
          paramObject.timeoutReason = b(paramFromServiceMsg);
        }
        paramObject = localObject1;
        localObject1 = null;
        continue;
        arrayOfObject = null;
        paramObject = localObject1;
        localObject1 = arrayOfObject;
      }
    }
  }
  
  private void fg(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbReceiptRead><R><---handleC2CReceiptMessageResp.");
    }
    String str = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    int n = paramToServiceMsg.extraData.getInt("msgtype");
    msg_svc.PbSendMsgResp localPbSendMsgResp = new msg_svc.PbSendMsgResp();
    try
    {
      localPbSendMsgResp = (msg_svc.PbSendMsgResp)localPbSendMsgResp.mergeFrom((byte[])paramObject);
      paramObject = localPbSendMsgResp;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("Q.msg.MessageHandler", 2, "<---handleC2CReceiptMessageResp : invalid.", localException);
          localStringBuilder = new StringBuilder().append("<---handleC2CReceiptMessageResp : data:");
          if (paramObject != null) {
            break label323;
          }
        }
        label323:
        for (paramObject = "null";; paramObject = Arrays.toString((byte[])paramObject))
        {
          QLog.e("Q.msg.MessageHandler", 2, paramObject);
          paramObject = new msg_svc.PbSendMsgResp();
          break;
        }
        if (paramObject.result.get() != 0) {
          i = paramObject.result.get();
        }
      }
    }
    int i = 0;
    if (!paramObject.result.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---handleC2CReceiptMessageResp : server did not return a valid result code, use 4 instead.");
      }
      i = 4;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<PbReceiptRead><R><---handleC2CReceiptMessageResp : ---cmd:MessageSvc.PbReceiptRead----replyCode:" + i + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + " peerUin:" + str + " msgseq:" + l1 + " msgType:" + n);
      }
      paramFromServiceMsg.extraData.putLong("ServerReplyCode", i);
      ae(paramToServiceMsg, paramFromServiceMsg);
      paramFromServiceMsg = a(l1);
      if (paramFromServiceMsg != null) {
        break label359;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<PbReceiptRead><R><---handleC2CReceiptMessageResp : ---cmd:MessageSvc.PbReceiptRead,no SendMessageHandler found.");
      }
    }
    label359:
    int k;
    do
    {
      return;
      StringBuilder localStringBuilder;
      if (i != 255) {
        break label446;
      }
      k = 1;
      if (k == 0) {
        break;
      }
      paramFromServiceMsg.getClass();
    } while (a(paramFromServiceMsg, "server"));
    if ((i == 0) || (i == 241)) {
      if (n == 1) {
        f(6015, true, new Long[] { Long.valueOf(n), Long.valueOf(l1) });
      }
    }
    for (;;)
    {
      hB(l1);
      return;
      label446:
      k = 0;
      break;
      f(6015, true, new Long[] { Long.valueOf(n), Long.valueOf(l1), Long.valueOf(paramObject.receipt_resp.receipt_info.uint64_read_time.get()) });
      continue;
      a(paramToServiceMsg, paramObject);
      f(3021, true, new Long[] { Long.valueOf(n), Long.valueOf(l1), Long.valueOf(i) });
    }
  }
  
  private void fh(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow.");
    }
    long l1 = paramToServiceMsg.extraData.getLong("toUin");
    paramToServiceMsg = new oidb_0xb31.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0)
    {
      if (!paramToServiceMsg.items.has()) {
        break label486;
      }
      paramToServiceMsg = paramToServiceMsg.items.get();
      if ((paramToServiceMsg == null) || (paramToServiceMsg.isEmpty())) {
        break label467;
      }
      paramToServiceMsg = (oidb_0xb31.SimilarItem)paramToServiceMsg.get(0);
      if (paramToServiceMsg == null) {
        break label448;
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new JSONObject();
        if (paramToServiceMsg.icon_url.has()) {
          paramFromServiceMsg.put("icon_url", paramToServiceMsg.icon_url.get());
        }
        if (paramToServiceMsg.jump_url.has()) {
          paramFromServiceMsg.put("jump_url", paramToServiceMsg.jump_url.get());
        }
        if (paramToServiceMsg.name.has()) {
          paramFromServiceMsg.put("name", paramToServiceMsg.name.get());
        }
        if (paramToServiceMsg.sub_title.has()) {
          paramFromServiceMsg.put("sub_title", paramToServiceMsg.sub_title.get());
        }
        if (paramToServiceMsg.title.has()) {
          paramFromServiceMsg.put("title", paramToServiceMsg.title.get());
        }
        if (paramToServiceMsg.type.has()) {
          paramFromServiceMsg.put("type", paramToServiceMsg.type.get());
        }
        if (paramToServiceMsg.url.has()) {
          paramFromServiceMsg.put("url", paramToServiceMsg.url.get());
        }
        if (paramToServiceMsg.show_both_head.has()) {
          paramFromServiceMsg.put("show_both_head", paramToServiceMsg.show_both_head.get());
        }
        paramFromServiceMsg.put("friend_uin", l1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow content is: " + paramFromServiceMsg.toString());
        }
        ((ysf)this.mApp.getManager(34)).dO(paramFromServiceMsg.toString(), String.valueOf(l1));
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow exception: " + QLog.getStackTraceString(paramToServiceMsg));
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow. result is: " + i);
      }
      return;
      label448:
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow index == 0 item is null.");
        continue;
        label467:
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow items is empty.");
          continue;
          label486:
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow items not has.");
          }
        }
      }
    }
  }
  
  private void g(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new msg_onlinepush.PbPushMsg();
    try
    {
      paramObject = (msg_onlinepush.PbPushMsg)((msg_onlinepush.PbPushMsg)localObject).mergeFrom((byte[])paramObject);
      if (paramObject == null) {
        anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
      }
      if ((paramObject == null) || (!paramObject.msg.has())) {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("<---handleMessagePush_PB: pushMsg is null or doesn't has msg:");
          if (paramObject == null)
          {
            paramFromServiceMsg = " null ";
            QLog.d("Q.msg.MessageHandler", 2, paramFromServiceMsg);
          }
        }
        else
        {
          return;
        }
      }
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<---handleMessagePush_PB: exception occurs while parsing the pb bytes.", paramObject);
        }
        paramObject = null;
        continue;
        paramFromServiceMsg = "noMsg";
      }
      localObject = (msg_comm.Msg)paramObject.msg.get();
      int i = ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).msg_type.get();
      if ((paramObject.uint32_general_flag.get() & 0x20) == 32) {
        aqel.setMute(true);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, new Object[] { "<---handleMessagePush_PB: msgType:", Integer.valueOf(i), " ,muteGeneralFlag:", Integer.valueOf(paramObject.uint32_general_flag.get()) });
        }
        if (!"OnlinePush.PbC2CMsgSync".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
          break;
        }
        a("c2c_processor").f(2003, new Object[] { localObject, paramFromServiceMsg, paramObject });
        return;
        aqel.setMute(false);
      }
      if ("OnlinePush.PbPushBindUinGroupMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        a().f(4004, new Object[] { localObject, paramFromServiceMsg, paramObject });
        return;
      }
      switch (i)
      {
      default: 
        return;
      }
    }
    a("disc_processor").f(1001, new Object[] { localObject, paramFromServiceMsg, paramObject, Boolean.valueOf(true) });
    return;
    tnv localtnv = a("troop_processor");
    if (paramObject.ping_flag.get() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localtnv.f(1001, new Object[] { localObject, paramFromServiceMsg, paramObject, Boolean.valueOf(bool) });
      return;
    }
    a("c2c_processor").f(1001, new Object[] { localObject, paramFromServiceMsg, paramObject });
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    int i;
    long l1;
    do
    {
      return;
      i = paramToServiceMsg.extraData.getInt("msgtype", -1);
      l1 = paramToServiceMsg.extraData.getLong("msgsize", 0L);
    } while (i != -1000);
    a("actSendGroupProcess", paramBoolean, l1, paramToServiceMsg, paramFromServiceMsg);
  }
  
  private int gy(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    case 9: 
    case 13: 
    default: 
      return ((tpu)this.app.b().a().a().get(Integer.valueOf(paramInt))).vg();
    case 1: 
      return 3001;
    case 3: 
      return 6000;
    case 5: 
      return 8002;
    case 6: 
      return 7000;
    case 8: 
      return 7001;
    case 10: 
      return 8005;
    case 11: 
      return 8006;
    case 2: 
      return 3002;
    case 4: 
      return 3008;
    case 14: 
      return 6009;
    case 12: 
      return 6010;
    case 23: 
      return 8028;
    case 25: 
    case 26: 
      return 8035;
    case 24: 
      return 8032;
    case 16: 
      return 6012;
    case 17: 
      return 6013;
    case 18: 
      return 8008;
    case 15: 
      return 8010;
    case 19: 
      return 8012;
    case 20: 
      return 8014;
    case 21: 
      return 3013;
    case 22: 
      return 3014;
    case 27: 
      return 3022;
    case 28: 
      return 8037;
    case 29: 
      return 8040;
    case 30: 
      return 8041;
    case 31: 
      return 8042;
    }
    return 8043;
  }
  
  public static int gz(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 3001;
    case 1: 
      return 3002;
    case 3000: 
      return 3008;
    case 1000: 
      return 6000;
    case 1004: 
      return 8002;
    case 1005: 
      return 7000;
    case 1006: 
      return 8005;
    case 1009: 
      return 8006;
    case 1023: 
      return 8008;
    case 1024: 
      return 8010;
    case 1010: 
      return 8012;
    case 1026: 
      return 3013;
    }
    return 8043;
  }
  
  private void h(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      notifyUI(4004, true, null);
      return;
    }
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleMsgProxyCmdResp request timeout!");
      }
      notifyUI(4004, false, null);
      return;
    }
    if (paramFromServiceMsg.getResultCode() == -20009)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleMsgProxyCmdResp request overload protection!");
      }
      notifyUI(4004, false, null);
      notifyUI(4001, false, null);
      notifyUI(4016, false, null);
      notifyUI(4003, false, null);
      notifyUI(4002, false, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleMsgProxyCmdResp request error!");
    }
    notifyUI(4004, false, null);
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    long l1 = 0L;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", paramFromServiceMsg.getResultCode() + "");
    long l2 = paramToServiceMsg.extraData.getLong("msgsize", 0L);
    long l4 = paramToServiceMsg.extraData.getLong("startTime");
    long l3 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    if (l4 < 1L) {}
    for (;;)
    {
      localHashMap.put("param_retryIndex", Long.toString(l3));
      anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "dim.actSendGrpTmpMsg", paramBoolean, l1, l2, localHashMap, "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.MessageHandler", 2, "TAG[" + "dim.actSendGrpTmpMsg" + "]  success[" + paramBoolean + "] duration[" + l1 + "ms] retryNum[" + l3 + "]");
      return;
      l1 = System.currentTimeMillis() - l4;
    }
  }
  
  private void hD(long paramLong)
  {
    this.Ql = paramLong;
    if (this.Ql < 0L) {
      this.Ql = 0L;
    }
    if (this.Ql > 300L) {
      this.Ql = 300L;
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    long l1 = 0L;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", paramFromServiceMsg.getResultCode() + "");
    long l2 = paramToServiceMsg.extraData.getLong("msgsize", 0L);
    long l4 = paramToServiceMsg.extraData.getLong("startTime");
    long l3 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    if (l4 < 1L) {}
    for (;;)
    {
      localHashMap.put("param_retryIndex", Long.toString(l3));
      anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "dim.actSendWpaMsg", paramBoolean, l1, l2, localHashMap, "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.MessageHandler", 2, "TAG[" + "dim.actSendWpaMsg" + "]  success[" + paramBoolean + "] duration[" + l1 + "ms] retryNum[" + l3 + "]");
      return;
      l1 = System.currentTimeMillis() - l4;
    }
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<<---handleTimeOut serviceCmd:" + paramFromServiceMsg.getServiceCmd());
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (acrg.af().containsKey(str)) {
      e(str, paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      do
      {
        return;
        if ("MessageSvc.PbGetMsg".equalsIgnoreCase(str))
        {
          N(paramToServiceMsg);
          return;
        }
        if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(str))
        {
          Y(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("TransService.ReqGetSign".equalsIgnoreCase(str))
        {
          X(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("MessageSvc.PbSendMsg".equalsIgnoreCase(str))
        {
          ad(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("OidbSvc.0xa89".equalsIgnoreCase(str))
        {
          aq(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("AccostSvc.ClientMsg".equalsIgnoreCase(str))
        {
          ab(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (!"PbMessageSvc.PbUnReadMsgSeq".equalsIgnoreCase(str)) {
          break;
        }
      } while ((paramToServiceMsg == null) || (paramToServiceMsg.extraData == null));
      if ("getThirdQQUnreadNum".equals(paramToServiceMsg.extraData.getString("action")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<<---handle timeout - get thirdqq unread number");
        }
        a().aD(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      ak(paramToServiceMsg, paramFromServiceMsg);
      return;
      if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(str))
      {
        af(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(str))
      {
        ah(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (("RegPrxySvc.infoLogin".equalsIgnoreCase(str)) || ("RegPrxySvc.getOffMsg".equalsIgnoreCase(str)))
      {
        h(paramFromServiceMsg, null);
        return;
      }
      if ("PbMessageSvc.PbMsgReadedReport".equalsIgnoreCase(str))
      {
        ao(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("RegPrxySvc.infoSync".equalsIgnoreCase(str))
      {
        fa(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
    } while (!"MessageSvc.PbReceiptRead".equalsIgnoreCase(str));
    ar(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void C(ArrayList<MessageRecord> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    paramArrayList = paramArrayList.iterator();
    label17:
    MessageRecord localMessageRecord;
    label66:
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      if (paramArrayList.hasNext())
      {
        localMessageRecord = (MessageRecord)paramArrayList.next();
        if ((!(localMessageRecord instanceof MessageForPic)) && (!(localMessageRecord instanceof MessageForMixedMsg))) {
          break label231;
        }
        this.app.a().e(localMessageRecord, 3);
        if (!(localMessageRecord instanceof MessageForStructing)) {
          break label449;
        }
        localObject2 = (MessageForStructing)localMessageRecord;
        if (((MessageForStructing)localObject2).structingMsg != null)
        {
          if ((localMessageRecord.isread) || (((MessageForStructing)localObject2).structingMsg.mMsgServiceID != 38) || (TextUtils.isEmpty(((MessageForStructing)localObject2).structingMsg.mResid))) {
            break label451;
          }
          localObject1 = (aqxh)this.app.getManager(76);
          paramBoolean = ((aqxh)localObject1).f((MessageForStructing)localObject2);
          localObject2 = ((aqxh)localObject1).a();
          if ((paramBoolean) && (this.app.a != null) && (this.app.a.abT()) && (localObject2 != null) && (((aqxg)localObject2).status == 0L) && (((aqxg)localObject2).uniseq != 0L)) {
            ((aqxh)localObject1).me(((aqxg)localObject2).uniseq);
          }
        }
      }
    }
    for (;;)
    {
      this.app.a().e(localMessageRecord, 1);
      break label17;
      break;
      label231:
      if ((localMessageRecord instanceof MessageForShortVideo))
      {
        this.app.a().m((MessageForShortVideo)localMessageRecord);
        break label66;
      }
      if ((localMessageRecord instanceof MessageForPtt))
      {
        alip.a(this.app).e((MessageForPtt)localMessageRecord);
        int i = 4;
        if (localMessageRecord.istroop == 0) {
          i = 1;
        }
        for (;;)
        {
          aomq.b(this.app, i, false, 3);
          break;
          if (localMessageRecord.istroop == 1) {
            i = 3;
          } else if (localMessageRecord.istroop == 3000) {
            i = 2;
          }
        }
      }
      if (((localMessageRecord instanceof MessageForLongTextMsg)) && (localMessageRecord.getExtInfoFromExtStr("long_text_recv_state").equals("3")))
      {
        ((MessageForLongTextMsg)localMessageRecord).loading = true;
        localObject1 = localMessageRecord.getExtInfoFromExtStr("long_text_msg_resid");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          QLog.e("Q.msg.MessageHandler", 1, "LongTextMsg resid is null!");
        }
        ajkw.a(this.app, localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq, (String)localObject1);
        break label66;
      }
      if (!(localMessageRecord instanceof MessageForScribble)) {
        break label66;
      }
      this.app.a().d((MessageForScribble)localMessageRecord);
      break label66;
      label449:
      break label17;
      label451:
      if (((MessageForStructing)localObject2).structingMsg.mMsgServiceID == 35) {
        ajlc.a().a((MessageForStructing)localObject2, this.app);
      } else if (((MessageForStructing)localObject2).structingMsg.mMsgServiceID == 107) {
        ajlc.a().a((MessageForStructing)localObject2, this.app);
      }
    }
  }
  
  public void D(long paramLong, int paramInt1, int paramInt2)
  {
    a(paramLong, paramInt1, paramInt2, null, 1, aqgz.a());
  }
  
  public void E(long paramLong, int paramInt1, int paramInt2)
  {
    a(paramLong, paramInt1, paramInt2, null, -1, null);
  }
  
  public void Ej(String paramString)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("AccostSvc.ReqInsertBlackList");
    localToServiceMsg.extraData.putString("insertUin", paramString);
    send(localToServiceMsg);
  }
  
  public void Ek(String paramString)
  {
    dB(paramString, 0);
  }
  
  public void El(String paramString)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.DelRoamMsg");
    localToServiceMsg.extraData.putString("uin", paramString);
    send(localToServiceMsg);
  }
  
  public void Eo(String paramString)
  {
    if (a(paramString) != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("openid", 2, "get openid key = " + paramString);
    }
    AccountManager localAccountManager = (AccountManager)this.app.getManager(0);
    HashMap localHashMap = new HashMap();
    RequestCustomSig localRequestCustomSig = new RequestCustomSig();
    localRequestCustomSig.ulCustumFlag = 8192L;
    localRequestCustomSig.ulSType = 1L;
    localRequestCustomSig.reserved = new byte[0];
    localHashMap.put("RequestCustomSig", localRequestCustomSig);
    localHashMap.put("OpenAppid", paramString);
    localAccountManager.changeToken(localHashMap, new achn(this, paramString));
  }
  
  public void F(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = new cmd0x9db.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    ((cmd0x9db.ReqBody)localObject).rpt_uint64_id.set(localArrayList);
    ((cmd0x9db.ReqBody)localObject).uint32_sequence.set(paramInt1);
    localObject = makeOIDBPkg("OidbSvc.0x9db", 2523, 0, ((cmd0x9db.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("insertTinnyid", paramLong);
    ((ToServiceMsg)localObject).extraData.putInt("fromType", paramInt2);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void Fe(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "Msg Pull Finish picPreDownloadOn");
    }
    this.app.a().dDR();
    this.app.a().dDR();
    this.app.a().dDR();
    aiyy.a().Qv(3);
    notifyUI(6005, paramBoolean, null, true);
  }
  
  public void Fg(boolean paramBoolean)
  {
    synchronized (this.kk)
    {
      this.bIq = paramBoolean;
      return;
    }
  }
  
  public void Fh(boolean paramBoolean)
  {
    synchronized (this.kl)
    {
      this.bIs = paramBoolean;
      return;
    }
  }
  
  public void Fi(boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      ThreadManager.post(new MessageHandler.16(this, paramBoolean), 10, null, false);
      return;
    }
    aegu.B(this.app, false);
    aegu.A(this.app, false);
    Fj(paramBoolean);
  }
  
  public void Fj(boolean paramBoolean)
  {
    int n = 0;
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = this.app.b().a(paramBoolean);
    if ((localPbMsgReadedReportReq == null) || (localPbMsgReadedReportReq.toByteArray() == null)) {
      return;
    }
    int i = amzo.seq;
    amzo.seq = i + 1;
    long l1 = i;
    long l2 = System.currentTimeMillis();
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    a(l1, localSendMessageHandler);
    i = 0;
    int k;
    for (;;)
    {
      k = n;
      if (i >= 9) {
        break;
      }
      localSendMessageHandler.a(new MessageHandler.17(this, localPbMsgReadedReportReq, l2, l1));
      i += 1;
    }
    label104:
    if (k < 3) {
      if (k != 0) {
        break label154;
      }
    }
    label154:
    for (l1 = 480000L;; l1 = (3 - k) * 480000 / 3 - k * 2000)
    {
      l2 = k * 480000 / 3;
      localSendMessageHandler.getClass();
      localSendMessageHandler.b(l2, l1, "period");
      k += 1;
      break label104;
      break;
    }
  }
  
  public void Fk(boolean paramBoolean)
  {
    Object localObject = ByteBuffer.allocate(13);
    long l1 = Long.parseLong(this.app.getCurrentAccountUin());
    if (paramBoolean) {}
    for (short s = 1;; s = 2)
    {
      ((ByteBuffer)localObject).putInt(aqft.ag(l1)).put((byte)0).putShort((short)1).putShort((short)-23463).putShort((short)2).putShort(s);
      localObject = makeOIDBPkg("OidbSvc.0x4ff_42073", 1279, 9, ((ByteBuffer)localObject).array());
      ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
  }
  
  public void Jr(int paramInt)
  {
    Object localObject;
    label65:
    HashMap localHashMap;
    String[] arrayOfString1;
    String[] arrayOfString2;
    if (paramInt == 1)
    {
      localObject = (String[])this.app.a(-2).get(Integer.valueOf(-2));
      a((String[])localObject);
      this.ei = ((String[])localObject);
      localObject = f();
      if (localObject != null)
      {
        this.ej = ((String[])localObject[0]);
        if (paramInt == 1) {
          cKr();
        }
      }
    }
    else
    {
      localHashMap = this.app.a(-1);
      arrayOfString1 = (String[])localHashMap.get(Integer.valueOf(1));
      arrayOfString2 = (String[])localHashMap.get(Integer.valueOf(4));
      if (arrayOfString1 == null) {
        break label332;
      }
    }
    label168:
    label332:
    for (int i = arrayOfString1.length + 0;; i = 0)
    {
      int k = i;
      if (arrayOfString2 != null) {
        k = i + arrayOfString2.length;
      }
      if (k > 0)
      {
        localObject = new String[k];
        if (arrayOfString1 != null)
        {
          System.arraycopy(arrayOfString1, 0, localObject, 0, arrayOfString1.length);
          i = arrayOfString1.length;
          if (arrayOfString2 != null) {
            System.arraycopy(arrayOfString2, 0, localObject, i, arrayOfString2.length);
          }
          a((String[])localObject);
        }
      }
      for (;;)
      {
        this.ei = ((String[])localObject);
        localObject = (String[])localHashMap.get(Integer.valueOf(2));
        if ((localObject != null) && (localObject.length > 0) && (this.jdField_a_of_type_Anaz != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "enableTroopMsgPushCache type=2, 1st uin=" + localObject[0]);
          }
          i = 0;
          while (i < localObject.length)
          {
            this.jdField_a_of_type_Anaz.fR(localObject[i], 0);
            i += 1;
          }
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.msg.MessageHandler", 2, "enableTroopMsgPushCache num troop list is empty!");
        break;
        this.ej = null;
        break label65;
        i = 0;
        break label168;
        localObject = null;
      }
    }
  }
  
  public byte[] Q()
  {
    Object localObject = new msg_svc.PbGetMsgReq();
    byte[] arrayOfByte = this.jdField_a_of_type_Anaz.am();
    if (arrayOfByte != null) {
      ((msg_svc.PbGetMsgReq)localObject).sync_cookie.set(ByteStringMicro.copyFrom(arrayOfByte));
    }
    ((msg_svc.PbGetMsgReq)localObject).sync_flag.set(0);
    ((msg_svc.PbGetMsgReq)localObject).ramble_flag.set(0);
    ((msg_svc.PbGetMsgReq)localObject).context_flag.set(1);
    ((msg_svc.PbGetMsgReq)localObject).online_sync_flag.set(0);
    ((msg_svc.PbGetMsgReq)localObject).latest_ramble_number.set(20);
    ((msg_svc.PbGetMsgReq)localObject).other_ramble_number.set(3);
    localObject = ((msg_svc.PbGetMsgReq)localObject).toByteArray();
    arrayOfByte = new byte[localObject.length + 4];
    aqoj.copyData(arrayOfByte, 4, (byte[])localObject, 0, localObject.length);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "--->>createGetMsgReq");
    }
    return arrayOfByte;
  }
  
  public void T(MessageRecord paramMessageRecord)
  {
    this.app.b().b(paramMessageRecord, this.app.getCurrentAccountUin());
    new ArrayList().add(paramMessageRecord);
    if (!paramMessageRecord.isread) {}
    for (boolean bool = true;; bool = false)
    {
      a("addMessageAndNotify", 1000, true, null, 1, aO(bool), false, null);
      return;
    }
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    int i = a(localSendMessageHandler);
    msg_svc.PbSendMsgReq localPbSendMsgReq = a(1, paramLong1, paramLong2, paramInt1, paramInt2);
    paramInt1 = 0;
    while (paramInt1 < 3)
    {
      localSendMessageHandler.a(new MessageHandler.1(this, localPbSendMsgReq, i, paramLong2));
      paramInt1 += 1;
    }
    paramInt1 = 0;
    while (paramInt1 <= 3)
    {
      paramLong1 = paramInt1 * 30000L / 3L;
      localSendMessageHandler.getClass();
      localSendMessageHandler.b(paramLong1, 10000L, "period");
      paramInt1 += 1;
    }
    return i;
  }
  
  public SvcRequestGetMsgV2 a()
  {
    SvcRequestGetMsgV2 localSvcRequestGetMsgV2 = new SvcRequestGetMsgV2();
    localSvcRequestGetMsgV2.lUin = Long.parseLong(this.app.getCurrentAccountUin());
    localSvcRequestGetMsgV2.uDateTime = this.jdField_a_of_type_Anaz.Jg();
    localSvcRequestGetMsgV2.cRecivePic = 1;
    localSvcRequestGetMsgV2.shAbility = 15;
    byte[] arrayOfByte = this.jdField_a_of_type_Anaz.am();
    localSvcRequestGetMsgV2.cChannel = 4;
    localSvcRequestGetMsgV2.cInst = 1;
    localSvcRequestGetMsgV2.cChannelEx = 1;
    localSvcRequestGetMsgV2.cSyncFlag = 0;
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
      localSvcRequestGetMsgV2.vSyncCookie = arrayOfByte;
    }
    localSvcRequestGetMsgV2.cRambleFlag = 0;
    localSvcRequestGetMsgV2.lGeneralAbi = 1L;
    arrayOfByte = this.jdField_a_of_type_Anaz.an();
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
      localSvcRequestGetMsgV2.vPubAccountCookie = arrayOfByte;
    }
    return localSvcRequestGetMsgV2;
  }
  
  public SvcRequestPullDisMsgSeq a(int paramInt)
  {
    int i = 0;
    SvcRequestPullDisMsgSeq localSvcRequestPullDisMsgSeq = new SvcRequestPullDisMsgSeq(new ArrayList(), (byte)0);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramInt == 4)
    {
      if ((this.ej == null) || (this.ej.length == 0))
      {
        notifyUI(4002, true, null);
        return null;
      }
      int k = this.ej.length;
      localObject1 = new StringBuilder();
      paramInt = i;
      while (paramInt < k)
      {
        localObject2 = this.ej[paramInt];
        localObject3 = new MessageSvcPack.PullDisSeqParam();
        ((MessageSvcPack.PullDisSeqParam)localObject3).lDisCode = Long.parseLong((String)localObject2);
        ((MessageSvcPack.PullDisSeqParam)localObject3).lLastSeqId = this.jdField_a_of_type_Anaz.aH((String)localObject2);
        localSvcRequestPullDisMsgSeq.vDisInfo.add(localObject3);
        if (QLog.isColorLevel()) {
          ((StringBuilder)localObject1).append((String)localObject2).append(",");
        }
        paramInt += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>getSvcRequestPullDisMsgSeq disUinArray: " + ((StringBuilder)localObject1).toString());
      }
    }
    for (;;)
    {
      return localSvcRequestPullDisMsgSeq;
      localObject1 = ((acdu)this.mApp.getManager(53)).getDiscussList();
      if (((ArrayList)localObject1).size() == 0)
      {
        this.ej = null;
        notifyUI(4002, true, null);
        return null;
      }
      i = ((ArrayList)localObject1).size();
      this.ej = new String[i];
      localObject2 = new StringBuilder();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject3 = (DiscussionInfo)((ArrayList)localObject1).get(paramInt);
        MessageSvcPack.PullDisSeqParam localPullDisSeqParam = new MessageSvcPack.PullDisSeqParam();
        localPullDisSeqParam.lDisCode = Long.parseLong(((DiscussionInfo)localObject3).uin);
        localPullDisSeqParam.lLastSeqId = this.jdField_a_of_type_Anaz.aH(((DiscussionInfo)localObject3).uin);
        this.ej[paramInt] = ((DiscussionInfo)localObject3).uin;
        localSvcRequestPullDisMsgSeq.vDisInfo.add(localPullDisSeqParam);
        if (QLog.isColorLevel()) {
          ((StringBuilder)localObject2).append(((DiscussionInfo)localObject3).uin).append(",");
        }
        paramInt += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>getSvcRequestPullDisMsgSeq disUinArray: " + ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public SvcRequestPullGroupMsgSeq a(int paramInt)
  {
    int i = 0;
    Object localObject = new ArrayList();
    int k = MsgFilter.LIMIT_10_AND_IN_3_DAYS.value();
    String[] arrayOfString;
    if (paramInt == 3)
    {
      arrayOfString = this.app.g(2);
      this.ei = arrayOfString;
    }
    while ((arrayOfString == null) || (arrayOfString.length == 0))
    {
      notifyUI(4003, true, arrayOfString);
      return null;
      arrayOfString = this.ei;
    }
    localObject = new SvcRequestPullGroupMsgSeq((ArrayList)localObject, (byte)0, k);
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = i;
    while (paramInt < arrayOfString.length)
    {
      PullGroupSeqParam localPullGroupSeqParam = new PullGroupSeqParam();
      try
      {
        localPullGroupSeqParam.lGroupCode = Long.parseLong(arrayOfString[paramInt]);
        localPullGroupSeqParam.lLastSeqId = this.jdField_a_of_type_Anaz.aI(arrayOfString[paramInt]);
        ((SvcRequestPullGroupMsgSeq)localObject).vGroupInfo.add(localPullGroupSeqParam);
        if (QLog.isColorLevel()) {
          localStringBuilder.append("; troopUin=").append(arrayOfString[paramInt]).append(",").append(" lastSeqId=").append(localPullGroupSeqParam.lLastSeqId);
        }
      }
      catch (Exception localException)
      {
        label192:
        break label192;
      }
      paramInt += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "--->>getSvcRequestPullGroupMsgSeq troopUinArray: " + localStringBuilder.toString());
    }
    return localObject;
  }
  
  public SvcRequestPullDisGroupSeq a()
  {
    Object localObject;
    if ((this.ej == null) || (this.ej.length == 0))
    {
      notifyUI(4002, true, null);
      localObject = null;
    }
    SvcRequestPullDisGroupSeq localSvcRequestPullDisGroupSeq;
    StringBuilder localStringBuilder;
    label199:
    do
    {
      return localObject;
      new ArrayList();
      localSvcRequestPullDisGroupSeq = new SvcRequestPullDisGroupSeq();
      localObject = new ArrayList();
      int k = this.ej.length;
      localStringBuilder = new StringBuilder();
      int i = 0;
      for (;;)
      {
        if (i >= k) {
          break label199;
        }
        try
        {
          RegisterProxySvcPack.PullDisSeqParam localPullDisSeqParam = new RegisterProxySvcPack.PullDisSeqParam();
          localPullDisSeqParam.lDisCode = Long.parseLong(this.ej[i]);
          localPullDisSeqParam.lLastSeqId = this.jdField_a_of_type_Anaz.aH(this.ej[i]);
          ((ArrayList)localObject).add(localPullDisSeqParam);
          if (QLog.isColorLevel()) {
            localStringBuilder.append(this.ej[i]).append(",");
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.MessageHandler", 2, "--->>getSvcRequestPullDisGroupSeq Exception: disUin=" + this.ej[i], localException);
            }
          }
        }
        i += 1;
      }
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        notifyUI(4002, true, null);
        return null;
      }
      localSvcRequestPullDisGroupSeq.setVDisInfo((ArrayList)localObject);
      localObject = localSvcRequestPullDisGroupSeq;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "--->>getSvcRequestPullDisGroupSeq disUinArray: " + localStringBuilder.toString());
    return localSvcRequestPullDisGroupSeq;
  }
  
  public acrc a()
  {
    return (acrc)a("offlinefile_processor");
  }
  
  public acrl a()
  {
    return (acrl)a("sub_account_processor");
  }
  
  public acrp a()
  {
    return (acrp)a("system_processor");
  }
  
  public acsb a()
  {
    return (acsb)a("uncommon_msg_processor");
  }
  
  public anaz a()
  {
    return this.jdField_a_of_type_Anaz;
  }
  
  public AppShareID a(String paramString)
  {
    return this.jdField_a_of_type_Anaz.a(paramString);
  }
  
  public OpenID a(String paramString)
  {
    return this.jdField_a_of_type_Anaz.a(paramString);
  }
  
  public SendMessageHandler a(long paramLong)
  {
    return (SendMessageHandler)this.iS.get(Long.valueOf(paramLong));
  }
  
  public ToServiceMsg a(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageHandler", 2, "sendNewRegisterProxy , isGetPassword = " + paramBoolean + " ,randomSeq" + paramInt);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("RegPrxySvc.infoSync");
    localToServiceMsg.extraData.putLong("requestOptional", 0x80 | 0L | 0x40 | 0x100 | 0x2 | 0x2000 | 0x4000);
    localToServiceMsg.extraData.putInt("endSeq", paramInt);
    localToServiceMsg.extraData.putInt("type", 1);
    localToServiceMsg.extraData.putBoolean("isGetPassword", paramBoolean);
    if (paramLong != 0L)
    {
      localToServiceMsg.getAttributes().put("_attr_regprxy_random_code", Long.valueOf(paramLong));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "[ReSendProxy] currentRegisterProxyRandom = " + paramLong);
      }
    }
    return localToServiceMsg;
  }
  
  public Object a(String arg1, int paramInt)
  {
    String str = ??? + "_" + paramInt;
    if (!this.ef.containsKey(str)) {}
    synchronized (this.ef)
    {
      if (!this.ef.containsKey(str)) {
        this.ef.put(str, new Object());
      }
      return this.ef.get(str);
    }
  }
  
  public tnv a(String paramString)
  {
    if (this.jn == null) {
      return null;
    }
    if (!this.jn.containsKey(paramString)) {}
    for (;;)
    {
      Object localObject;
      synchronized (this.jn)
      {
        if (this.jn.containsKey(paramString)) {
          break label433;
        }
        if ("c2c_processor".equals(paramString))
        {
          localObject = new tob(this.app, this);
          if (localObject != null) {
            break label416;
          }
          return null;
        }
      }
      if ("troop_processor".equals(paramString))
      {
        localObject = new apde(this.app, this);
      }
      else if ("disc_processor".equals(paramString))
      {
        localObject = new acqs(this.app, this);
      }
      else if ("businessbase_processor".equals(paramString))
      {
        localObject = new tos(this.app, this);
      }
      else if ("sub_account_processor".equals(paramString))
      {
        localObject = new acrl(this.app, this);
      }
      else if ("accost_processor".equals(paramString))
      {
        localObject = new acql(this.app, this);
      }
      else if ("offlinefile_processor".equals(paramString))
      {
        localObject = new acrc(this.app, this);
      }
      else if ("system_processor".equals(paramString))
      {
        localObject = new acrp(this.app, this);
      }
      else if ("uncommon_msg_processor".equals(paramString))
      {
        localObject = new acsb(this.app, this);
      }
      else if ("video_processor".equals(paramString))
      {
        localObject = new acsd(this.app, this);
      }
      else if ("discuss_update_processor".equals(paramString))
      {
        localObject = new acqs(this.app, this);
      }
      else if ("info_update_processor".equals(paramString))
      {
        localObject = new acri(this.app, this);
      }
      else if ("slave_master_processor".equals(paramString))
      {
        localObject = new acqt(this.app, this);
      }
      else if ("hctopic_processor".equals(paramString))
      {
        localObject = new acqw(this.app, this);
        continue;
        label416:
        ((tnv)localObject).a(this);
        this.jn.put(paramString, localObject);
        label433:
        return (tnv)this.jn.get(paramString);
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  public void a(byte paramByte, byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, int paramInt2, Object paramObject)
  {
    Object localObject = new StringBuilder();
    if (QLog.isColorLevel())
    {
      ((StringBuilder)localObject).setLength(0);
      ((StringBuilder)localObject).append("<PbGetMsg><S>--->>getC2CMessage:cChannel:").append(paramByte).append(",syncFlag:").append(paramInt1).append(",isPullRoamMsg:").append(paramBoolean1).append(",newMsgInSync:").append(paramBoolean3).append(",ssoTimeStamp:").append(paramString).append(",pullMsgType:").append(paramInt2);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (((paramInt2 != 2) && (!aN(paramBoolean3))) || ((paramInt2 == 2) && (!aaI())))
    {
      this.jdField_a_of_type_Anaz.PD(false);
      localObject = this.jdField_a_of_type_Anaz.am();
      if (!paramBoolean1) {
        break label254;
      }
    }
    label254:
    for (byte b = 0;; b = 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>getC2CMessage cChannel: " + paramByte + "vCookies: " + paramArrayOfByte + ",cSyncFlag:" + paramInt1 + ",pullRoamMsg:" + paramBoolean1 + ",onlineSyncFlag:" + b);
      }
      o(a(paramByte, paramArrayOfByte, paramInt1, paramBoolean1, paramBoolean2, paramString, paramInt2, paramObject, (byte[])localObject, b));
      return;
    }
  }
  
  protected void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg arg3, Object paramObject)
  {
    cKn();
    paramToServiceMsg = new c(paramInt, paramToServiceMsg, ???, paramObject);
    if (paramInt == 1) {
      synchronized (this.tl)
      {
        this.tl.add(paramToServiceMsg);
        this.tl.notify();
        return;
      }
    }
    synchronized (this.tk)
    {
      this.tk.add(paramToServiceMsg);
      this.tk.notify();
      return;
    }
  }
  
  protected void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg arg3, Object paramObject, boolean paramBoolean)
  {
    cKn();
    paramToServiceMsg = new c(paramInt, paramToServiceMsg, ???, paramObject, paramBoolean);
    if (paramInt == 1) {
      synchronized (this.tl)
      {
        this.tl.add(paramToServiceMsg);
        this.tl.notify();
        return;
      }
    }
    synchronized (this.tk)
    {
      this.tk.add(paramToServiceMsg);
      this.tk.notify();
      return;
    }
  }
  
  public void a(int paramInt1, List<String> paramList, String paramString, long paramLong1, List<oidb_c2c_searcher.Iterator> paramList1, int paramInt2, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("PbMessageSvc.PbSearchRoamMsgInCloud");
    localToServiceMsg.setTimeout(5000L);
    localToServiceMsg.extraData.putString("keyword", paramString);
    localToServiceMsg.extraData.putLong("sequence", paramLong1);
    localToServiceMsg.extraData.putInt("retryIndex", paramInt2);
    localToServiceMsg.extraData.putInt("loadType", paramInt1);
    msg_svc.PbSearchRoamMsgInCloudReq localPbSearchRoamMsgInCloudReq = new msg_svc.PbSearchRoamMsgInCloudReq();
    oidb_c2c_searcher.ReqBody localReqBody = new oidb_c2c_searcher.ReqBody();
    localReqBody.query.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    localReqBody.max_cnt.set(20);
    localReqBody.type.set(1);
    ArrayList localArrayList = new ArrayList();
    if (paramList1 == null)
    {
      if (paramList != null)
      {
        paramInt1 = 0;
        if (paramInt1 < paramList.size())
        {
          paramList1 = new oidb_c2c_searcher.Iterator();
          oidb_c2c_searcher.MsgKey localMsgKey = new oidb_c2c_searcher.MsgKey();
          if (paramLong2 != 0L) {
            localMsgKey.time.set(paramLong2);
          }
          for (;;)
          {
            paramList1.key.set(localMsgKey);
            paramList1.uin.set(Long.parseLong((String)paramList.get(paramInt1)));
            localArrayList.add(paramList1);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "--->>searchRoamMsgInCloud friendUin: " + (String)paramList.get(paramInt1) + " beginTime: " + paramList1.key.time.get() + ", searchkey: " + paramString + ",lastDatelineTime:" + paramLong2);
            }
            paramInt1 += 1;
            break;
            localMsgKey.time.set(NetConnInfoCenter.getServerTime());
          }
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>searchRoamMsgInCloud  beginTime: " + ((oidb_c2c_searcher.Iterator)paramList1.get(0)).key.time.get() + ", searchkey: " + paramString + ",retryIndex" + paramInt2);
      }
      localArrayList.addAll(paramList1);
    }
    if (localArrayList.size() <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>searchRoamMsgInCloud listSize 0: it should not happen, check why");
      }
      return;
    }
    VipUtils.a(this.app, "chat_history", "ChatSearch", "Send_require", 0, 0, new String[0]);
    localReqBody.friends.set(localArrayList);
    localReqBody.set(localReqBody);
    localPbSearchRoamMsgInCloudReq.serialize_reqbody.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localToServiceMsg.putWupBuffer(localPbSearchRoamMsgInCloudReq.toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    cKp();
    int i = Math.abs(new Random(System.currentTimeMillis()).nextInt());
    if (QLog.isColorLevel()) {
      QLog.d("MessageHandler", 2, "sendRegisterProxy , type = " + paramInt + " , needEndPkg = " + paramBoolean1 + " , registerProxyRandom = " + paramLong + " , isGetPassword = " + paramBoolean2);
    }
    long l2 = 0L | 0x80;
    long l1;
    if ((paramInt == 1) || (paramInt == 2))
    {
      l2 = l2 | 0x40 | 0x100 | 0x2;
      l1 = l2;
      if (!paramBoolean1) {
        break label350;
      }
      this.cwB = i;
      l1 = l2;
      if (paramInt != 1) {
        break label353;
      }
    }
    label350:
    label353:
    for (Object localObject = "RegPrxySvc.infoLogin";; localObject = "RegPrxySvc.getOffMsg")
    {
      localObject = createToServiceMsg((String)localObject);
      ((ToServiceMsg)localObject).extraData.putLong("requestOptional", l1);
      if (paramBoolean1) {
        ((ToServiceMsg)localObject).extraData.putInt("endSeq", i);
      }
      if (paramLong != 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "[ReSendProxy] RegisterProxyRandom = " + paramLong);
        }
        this.Qj = paramLong;
        ((ToServiceMsg)localObject).getAttributes().put("_attr_regprxy_random_code", Long.valueOf(paramLong));
      }
      ((ToServiceMsg)localObject).extraData.putInt("type", paramInt);
      ((ToServiceMsg)localObject).extraData.putBoolean("isGetPassword", paramBoolean2);
      send((ToServiceMsg)localObject);
      return;
      if ((paramInt == 3) && (paramBoolean1))
      {
        this.cwC = i;
        l1 = l2;
        break;
      }
      l1 = l2;
      if (paramInt == 4)
      {
        l2 |= 0x100;
        this.cwB = i;
        l1 = l2;
        if (this.app.a().bl(false))
        {
          this.cwD = i;
          l1 = l2;
        }
      }
      break;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    a(paramLong, paramInt1, paramInt2, paramPbPushMsg, 1, aqgz.a());
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, msg_onlinepush.PbPushMsg paramPbPushMsg, int paramInt3, DeviceInfo paramDeviceInfo)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("OnlinePush.RespPush");
    localToServiceMsg.extraData.putInt("svrip", paramInt1);
    localToServiceMsg.extraData.putInt("seq", paramInt2);
    localToServiceMsg.extraData.putLong("lUin", paramLong);
    if (paramInt3 != -1) {
      localToServiceMsg.extraData.putInt("service_type", paramInt3);
    }
    if (paramDeviceInfo != null) {
      localToServiceMsg.extraData.putSerializable("deviceInfo", paramDeviceInfo);
    }
    if ((paramPbPushMsg != null) && (paramPbPushMsg.bytes_push_token.has())) {
      localToServiceMsg.extraData.putByteArray("bytes_push_token", (byte[])paramPbPushMsg.bytes_push_token.get().toByteArray().clone());
    }
    localToServiceMsg.setNeedCallback(false);
    send(localToServiceMsg);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, jnm.d paramd)
  {
    oidb_0xbad.ReqBody localReqBody = new oidb_0xbad.ReqBody();
    localReqBody.bytes_openid.set(ByteStringMicro.copyFromUtf8(paramString));
    localReqBody.uint64_appid.set(paramLong2);
    localReqBody.uint64_uin.set(paramLong1);
    jnm.a(this.app, paramd, localReqBody.toByteArray(), "OidbSvc.0xbad", 2989, 0);
  }
  
  public void a(long paramLong, ArrayList<DelMsgInfo> paramArrayList, int paramInt1, int paramInt2, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("OnlinePush.RespPush");
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localToServiceMsg.extraData.putSerializable("delMsgInfos", paramArrayList);
      localToServiceMsg.extraData.putInt("svrip", paramInt1);
      localToServiceMsg.extraData.putInt("seq", paramInt2);
      localToServiceMsg.extraData.putLong("lUin", paramLong);
      if ((paramPbPushMsg != null) && (paramPbPushMsg.bytes_push_token.has())) {
        localToServiceMsg.extraData.putByteArray("bytes_push_token", (byte[])paramPbPushMsg.bytes_push_token.get().toByteArray().clone());
      }
      localToServiceMsg.setNeedCallback(false);
      send(localToServiceMsg);
    }
  }
  
  public void a(long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt) {}
  
  public void a(long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = ((acff)this.app.getManager(51)).e(String.valueOf(paramLong2));
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((Friends)localObject1).name;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).trim().length() != 0) {
          break label61;
        }
      }
    }
    for (localObject1 = String.valueOf(paramLong2);; localObject1 = String.valueOf(paramLong2))
    {
      label61:
      long l1 = this.app.eV();
      localObject2 = new Intent("tencent.video.q2v.RecvSharpVideoCall");
      ((Intent)localObject2).setClassName(this.app.getApplication().getPackageName(), "com.tencent.av.VideoMsgBroadcastReceiver");
      ((Intent)localObject2).putExtra("uin", String.valueOf(paramLong1));
      ((Intent)localObject2).putExtra("fromUin", String.valueOf(paramLong2));
      ((Intent)localObject2).putExtra("buffer", paramArrayOfByte);
      ((Intent)localObject2).putExtra("time", paramInt);
      ((Intent)localObject2).putExtra("name", (String)localObject1);
      ((Intent)localObject2).putExtra("isPttRecordingOrPlaying", this.app.abz());
      ((Intent)localObject2).putExtra("isRequest", paramBoolean);
      ((Intent)localObject2).putExtra("onLineStatus", l1);
      ((Intent)localObject2).putExtra("msf_timestamp", System.currentTimeMillis());
      QLog.d("shanezhaiSHARP", 1, "avideo handleSharpVideoMessageResp sendBroadcast!!");
      this.app.getApp().sendBroadcast((Intent)localObject2);
      return;
    }
  }
  
  public void a(SvrMsg paramSvrMsg)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("AccostSvc.SvrMsg");
    localToServiceMsg.extraData.putSerializable("SvrMsg", paramSvrMsg);
    send(localToServiceMsg);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "sendRevokeMsgReq, timeout: " + paramLong);
    }
    if (!this.app.a().awx())
    {
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "sendRevokeMsgReq error, isMsgRevoking: false");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramMessageRecord.isLongMsg()) && ((paramMessageRecord instanceof MessageForLongMsg))) {
      localArrayList.addAll(((MessageForLongMsg)paramMessageRecord).longMsgFragmentList);
    }
    for (;;)
    {
      paramMessageRecord = a().a(localArrayList, 1);
      if (paramMessageRecord == null) {
        break;
      }
      paramMessageRecord.setTimeout(paramLong);
      o(paramMessageRecord);
      return;
      localArrayList.add(paramMessageRecord);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, acci paramacci, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, new Object[] { "--->sendRichTextMessageWith_MR : msgseq=", Long.valueOf(paramMessageRecord.msgseq) });
    }
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    boolean bool2 = a(paramMessageRecord.msgseq, localSendMessageHandler);
    msg_svc.PbSendMsgReq localPbSendMsgReq = achp.a(this.app, paramMessageRecord);
    MessageForStructing localMessageForStructing;
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      localMessageForStructing = (MessageForStructing)paramMessageRecord;
      if (localMessageForStructing.structingMsg == null) {}
    }
    for (boolean bool1 = oec.c(localMessageForStructing.structingMsg);; bool1 = false)
    {
      if ((MessageForRichText.class.isInstance(paramMessageRecord)) && (!bool1)) {
        ((MessageForRichText)paramMessageRecord).richText = null;
      }
      if (localPbSendMsgReq == null) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, new Object[] { "--->sendRichTextMessageWith_MR : the richText is null!", paramMessageRecord.getBaseInfoString() });
        }
      }
      int i;
      do
      {
        do
        {
          return;
          a(paramMessageRecord, localPbSendMsgReq, 480000L, 0, paramacci, paramBoolean);
          localSendMessageHandler.postDelayed(new MessageHandler.3(this, paramMessageRecord), cwL);
          if (bool2)
          {
            i = 0;
            while (i < 8)
            {
              localSendMessageHandler.a(new MessageHandler.4(this, paramMessageRecord, localPbSendMsgReq, paramacci, paramBoolean));
              i += 1;
            }
            i = 1;
            while (i < 3)
            {
              long l1 = (3 - i) * 480000 / 3 - i * 2000;
              long l2 = 480000 * i / 3;
              localSendMessageHandler.getClass();
              localSendMessageHandler.b(l2, l1, "period");
              i += 1;
            }
          }
        } while (paramMessageRecord.istroop != 1);
        this.jdField_a_of_type_Anaz.Gq.add(paramMessageRecord);
        i = this.jdField_a_of_type_Anaz.Gq.size();
        paramMessageRecord = this.jdField_a_of_type_Anaz;
      } while (i <= anaz.dES);
      this.jdField_a_of_type_Anaz.Gq.remove(0);
      return;
    }
  }
  
  public void a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if ((paramMessageRecord1 == null) || (paramMessageRecord2 == null)) {}
    do
    {
      for (;;)
      {
        return;
        paramMessageRecord2.extStr = paramMessageRecord1.extStr;
        paramMessageRecord2.mExJsonObject = paramMessageRecord1.mExJsonObject;
        paramMessageRecord2.extLong = paramMessageRecord1.extLong;
        if ((paramMessageRecord1 instanceof MessageForFunnyFace))
        {
          Object localObject = (MessageForFunnyFace)paramMessageRecord1;
          if ((((MessageForFunnyFace)localObject).mFunnyFaceMessage != null) && (((MessageForFunnyFace)localObject).mFunnyFaceMessage.faceId == 1)) {
            try
            {
              paramMessageRecord2 = (MessageForFunnyFace)paramMessageRecord2;
              localObject = ((MessageForFunnyFace)localObject).mFunnyFaceMessage.turntable.hitNickName;
              if ((localObject != null) && (((String)localObject).length() > 0) && (!((String)localObject).equals(paramMessageRecord2.mFunnyFaceMessage.turntable.hitNickName)))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "updateGroupMsgContent, funnyface, change " + paramMessageRecord2.mFunnyFaceMessage.turntable.hitNickName + " to " + (String)localObject);
                }
                paramMessageRecord2.mFunnyFaceMessage.turntable.hitNickName = ((String)localObject);
                this.app.b().c(paramMessageRecord1.frienduin, paramMessageRecord1.istroop, paramMessageRecord1.uniseq, paramMessageRecord2.mFunnyFaceMessage.getBytes());
                return;
              }
            }
            catch (Exception paramMessageRecord1) {}
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.msg.MessageHandler", 2, paramMessageRecord1.toString());
  }
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, boolean paramBoolean, Object paramObject)
  {
    notifyUI(paramToServiceMsg, paramInt, paramBoolean, paramObject);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3, short paramShort, long paramLong4, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
  {
    a(paramString, paramLong1, paramLong2, paramLong3, paramShort, paramLong4, paramInt1, paramArrayOfByte, paramInt2, paramBoolean1, paramInt3, paramBoolean2, true);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3, short paramShort, long paramLong4, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject;
    int i;
    msg_svc.PbGetRoamMsgReq localPbGetRoamMsgReq;
    if (QLog.isColorLevel())
    {
      QLog.d("Q.msg.MessageHandler", 2, "--->>getRoamMsgByTime friendUin: " + paramString + " beginTime: " + paramLong1 + " endTime: " + paramLong3 + " middleTime: " + paramLong2 + " maxCnt: " + paramShort + " random: " + paramLong4 + " subcmd：" + paramInt1);
      localObject = new StringBuilder().append("--->>getRoamMsgByTime req_type: ").append(paramInt2).append(", ticket length: ");
      if (paramArrayOfByte == null)
      {
        i = 0;
        QLog.d("Q.msg.MessageHandler", 2, i + ", fetchMore: " + paramBoolean1 + ", fetchNum: " + paramInt3 + ", isPreloadType: " + paramBoolean2 + ", notify: " + paramBoolean3);
        QLog.e("Q.msg.MessageHandler", 2, new Exception("getRoamMsgByTime"), new Object[0]);
      }
    }
    else
    {
      if ((paramLong4 == 0L) && (this.iU.containsKey(paramString))) {
        this.iU.remove(paramString);
      }
      localObject = createToServiceMsg("MessageSvc.PbGetRoamMsg");
      ((ToServiceMsg)localObject).extraData.putLong("lBeginTime", paramLong1);
      ((ToServiceMsg)localObject).extraData.putLong("lEndTime", paramLong3);
      ((ToServiceMsg)localObject).extraData.putBoolean("fetchMore", paramBoolean1);
      ((ToServiceMsg)localObject).extraData.putInt("fetchNum", paramInt3);
      ((ToServiceMsg)localObject).extraData.putString("peerUin", paramString);
      ((ToServiceMsg)localObject).extraData.putBoolean("preloadType", paramBoolean2);
      ((ToServiceMsg)localObject).extraData.putBoolean("notify", paramBoolean3);
      localPbGetRoamMsgReq = new msg_svc.PbGetRoamMsgReq();
      if ((paramLong4 != 0L) || (paramLong2 != 0L)) {
        break label497;
      }
      localPbGetRoamMsgReq.last_msgtime.set(paramLong3);
      label372:
      localPbGetRoamMsgReq.peer_uin.set(Long.parseLong(paramString));
      localPbGetRoamMsgReq.random.set(paramLong4);
      paramString = localPbGetRoamMsgReq.read_cnt;
      if (paramShort == 0) {
        break label510;
      }
      label405:
      paramString.set(paramShort);
      localPbGetRoamMsgReq.subcmd.set(paramInt1);
      localPbGetRoamMsgReq.begin_msgtime.set(paramLong1);
      localPbGetRoamMsgReq.check_pwd.set(1);
      localPbGetRoamMsgReq.req_type.set(paramInt2);
      if (paramArrayOfByte != null)
      {
        if (paramInt2 != 0) {
          break label518;
        }
        localPbGetRoamMsgReq.pwd.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).putWupBuffer(localPbGetRoamMsgReq.toByteArray());
      sendPbReq((ToServiceMsg)localObject);
      return;
      i = paramArrayOfByte.length;
      break;
      label497:
      localPbGetRoamMsgReq.last_msgtime.set(paramLong2);
      break label372;
      label510:
      paramShort = 1000;
      break label405;
      label518:
      localPbGetRoamMsgReq.sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
  }
  
  public void a(String paramString, long paramLong1, short paramShort, Bundle paramBundle, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "--->>getRoamMsgInOneDay friendUin: " + paramString + " reqLastMsgTime: " + paramLong1 + " readCnt: " + paramShort + " random: " + paramLong2);
    }
    long l1 = paramLong2;
    Object localObject;
    if (paramLong2 == 0L)
    {
      localObject = this.jdField_a_of_type_Anaz.h(paramString);
      if (localObject != null) {
        break label236;
      }
      l1 = 0L;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "getRoamMsgInOneDay:" + paramLong1);
      }
      paramLong2 = paramLong1;
      if (paramLong1 == 0L) {
        paramLong2 = anaz.gQ();
      }
      localObject = createToServiceMsg("MessageSvc.PbGetOneDayRoamMsg");
      msg_svc.PbGetOneDayRoamMsgReq localPbGetOneDayRoamMsgReq = new msg_svc.PbGetOneDayRoamMsgReq();
      localPbGetOneDayRoamMsgReq.last_msgtime.set(paramLong2);
      localPbGetOneDayRoamMsgReq.peer_uin.set(Long.parseLong(paramString));
      localPbGetOneDayRoamMsgReq.random.set(l1);
      localPbGetOneDayRoamMsgReq.read_cnt.set(paramShort);
      ((ToServiceMsg)localObject).putWupBuffer(localPbGetOneDayRoamMsgReq.toByteArray());
      if (paramBundle != null) {
        ((ToServiceMsg)localObject).extraData.putBundle("context", paramBundle);
      }
      sendPbReq((ToServiceMsg)localObject);
      return;
      label236:
      paramLong2 = ((Long)((Pair)localObject).second).longValue();
      l1 = paramLong2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.MessageHandler", 2, "getRoamMsgInOneDay rand=" + paramLong2);
        l1 = paramLong2;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, byte paramByte, acci paramacci)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      return;
    }
    paramacci = createToServiceMsg("TransService.ReqTmpChatPicDownload", paramacci);
    paramacci.extraData.putString("selfuin", paramString1);
    paramacci.extraData.putString("filekey", paramString2);
    paramacci.extraData.putByte("picscale", paramByte);
    send(paramacci);
  }
  
  public void a(String paramString1, String paramString2, byte paramByte, String paramString3, long paramLong1, long paramLong2)
  {
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    for (long l1 = 0L; l1 < 3L; l1 += 1L) {
      localSendMessageHandler.postDelayed(new MessageHandler.12(this, l1, paramString1, paramString2, paramByte, paramString3, paramLong1, paramLong2), 30000L * l1);
    }
    a(paramLong1, localSendMessageHandler);
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2, int paramInt1, int paramInt2, long paramLong3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "addGreetingMsg | uin is empty");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, String.format(Locale.getDefault(), "addGreetingMsg uin=%s, mobile=%s, addationMsg=%s, sourceid=%s, subSourceid=%s, requin=%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong3) }));
    }
    synchronized (this.cA)
    {
      if (paramLong2 == this.Qm) {
        return;
      }
    }
    Object localObject1;
    int i;
    Object localObject4;
    Object localObject3;
    if (((acff)this.app.getManager(51)).isFriend(paramString1))
    {
      localObject1 = this.app.b().k(paramString1, 0);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        paramString3 = new ahwa(paramString1, this.app.getCurrentUin(), this.app.getApp().getString(2131690294), 0, -5040, 655362, paramLong2);
        localObject1 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.app, paramString3);
        ahwb.a(this.app, (MessageForUniteGrayTip)localObject1);
        break label1066;
        if (i == 0) {
          break label1088;
        }
        localObject1 = acfp.m(2131708208);
        localObject4 = acfp.m(2131708203);
        localObject3 = acfp.m(2131708206);
        paramString3 = new ahwa(paramString1, this.app.getCurrentUin(), (String)localObject1, 0, -5040, 135179, paramLong2);
        paramString3.wording = ((String)localObject1);
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_action", 14);
        localBundle.putString("key_action_DATA", "from_batch_add_frd_for_troop");
        i = ((String)localObject1).indexOf((String)localObject4);
        int k = ((String)localObject1).indexOf((String)localObject4);
        paramString3.addHightlightItem(i, ((String)localObject4).length() + k, localBundle);
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("key_action", 13);
        ((Bundle)localObject4).putString("key_action_DATA", "from_batch_add_frd_for_troop");
        paramString3.addHightlightItem(((String)localObject1).indexOf((String)localObject3), ((String)localObject1).indexOf((String)localObject3) + ((String)localObject3).length(), (Bundle)localObject4);
        localObject1 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.app, paramString3);
        ahwb.a(this.app, (MessageForUniteGrayTip)localObject1);
        break label1088;
      }
    }
    for (;;)
    {
      label456:
      boolean bool = azcl.oD(paramInt1);
      if (i != 0)
      {
        paramString3 = (MessageForGrayTips)anbi.d(-1013);
        paramString3.init(this.app.getCurrentAccountUin(), paramString1, paramString1, this.app.getApp().getString(2131690293), paramLong2, -1013, 3, paramLong2);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("key_action", 14);
        paramString3.addHightlightItem(18, 22, (Bundle)localObject1);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("key_action", 13);
        paramString3.addHightlightItem(23, 27, (Bundle)localObject1);
        paramString3.isread = true;
        T(paramString3);
        anot.a(this.app, "dc00898", "", "", "0X8007978", "0X8007978", 0, 0, "", "", "", "");
      }
      if ((bool) && (!TextUtils.isEmpty(paramString2)))
      {
        bool = ((PhoneContactManagerImp)this.app.getManager(11)).ii(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "addGreetingMsg | deleted = " + bool);
        }
        if (bool) {
          notifyUI(8030, true, paramString2);
        }
      }
      aluu.a(this.app, paramString1, paramLong2, paramInt1, paramInt2);
      if (this.iT.get(paramString1) != null) {
        this.iT.remove(paramString1);
      }
      this.Qm = paramLong2;
      label740:
      return;
      localObject3 = (MessageForText)anbi.d(-1000);
      ((MessageForText)localObject3).frienduin = paramString1;
      localObject1 = this.app.getApp().getString(2131690296);
      if (paramLong3 == this.app.getLongAccountUin())
      {
        paramString3 = acfp.m(2131708198);
        label797:
        localObject4 = this.app.getCurrentAccountUin();
        if (!TextUtils.isEmpty(paramString3)) {
          break label1110;
        }
      }
      for (;;)
      {
        ((MessageForText)localObject3).init((String)localObject4, paramString1, paramString1, (String)localObject1, paramLong2, -1000, 0, paramLong2);
        ((MessageForText)localObject3).isread = true;
        if (paramLong1 != -1L) {
          ((MessageForText)localObject3).vipBubbleID = paramLong1;
        }
        T((MessageRecord)localObject3);
        if ((!TextUtils.isEmpty(paramString3)) && (paramLong3 != this.app.getLongAccountUin()))
        {
          localObject1 = aqgv.A(this.app, paramString1);
          paramString3 = (String)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramString3 = paramString1;
          }
          localObject1 = (MessageForGrayTips)anbi.d(-1013);
          ((MessageForGrayTips)localObject1).init(this.app.getCurrentAccountUin(), paramString1, paramString1, String.format(acfp.m(2131708207), new Object[] { paramString3 }), paramLong2, -1013, 0, paramLong2);
          ((MessageForGrayTips)localObject1).isread = true;
          T((MessageRecord)localObject1);
        }
        ((ysf)this.app.getManager(34)).zj(paramString1);
        break label1066;
        localObject1 = new b();
        ((b)localObject1).uin = paramString1;
        ((b)localObject1).boC = paramString3;
        ((b)localObject1).Qp = paramLong1;
        ((b)localObject1).time = paramLong2;
        ((b)localObject1).sourceId = paramInt1;
        ((b)localObject1).cwU = paramInt2;
        ((b)localObject1).mobile = paramString2;
        ((b)localObject1).Qq = paramLong3;
        this.iT.put(paramString1, localObject1);
        break label740;
        break label797;
        label1066:
        if ((paramInt1 != 2093) && (paramInt1 != 3093)) {
          break label1117;
        }
        i = 1;
        break;
        label1088:
        if ((paramInt1 != 3078) && (paramInt1 != 3079)) {
          break label1123;
        }
        i = 1;
        break label456;
        label1110:
        localObject1 = paramString3;
      }
      label1117:
      i = 0;
      break;
      label1123:
      i = 0;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, short paramShort, int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Bundle paramBundle)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0)) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramString1, "StreamSvr.UploadStreamMsg");
    localToServiceMsg.extraData.putString("selfuin", paramString1);
    localToServiceMsg.extraData.putString("uin", paramString2);
    localToServiceMsg.extraData.putString("filepath", paramString3);
    localToServiceMsg.extraData.putShort("PackSeq", paramShort);
    localToServiceMsg.extraData.putShort("flowLayer", anqo.a(paramString3));
    localToServiceMsg.extraData.putInt("msgseq", paramInt);
    localToServiceMsg.extraData.putLong("random", paramLong1);
    localToServiceMsg.extraData.putLong("VoiceType", paramLong2);
    localToServiceMsg.extraData.putLong("VoiceLength", paramLong3);
    localToServiceMsg.extraData.putLong("SubBubbleId", paramLong4);
    localToServiceMsg.extraData.putInt("DiyTextId", paramBundle.getInt("DiyTextId", 0));
    localToServiceMsg.setTimeout(60000L);
    localToServiceMsg.setNeedRemindSlowNetwork(true);
    send(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, short paramShort, long paramLong)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0)) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramString1, "StreamSvr.RespPushStreamMsg");
    localToServiceMsg.extraData.putString("selfuin", paramString1);
    localToServiceMsg.extraData.putString("uin", paramString2);
    localToServiceMsg.extraData.putString("filepath", paramString3);
    localToServiceMsg.extraData.putShort("PackSeq", paramShort);
    localToServiceMsg.extraData.putLong("lkey", paramLong);
    send(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramString1 + "." + paramString2, 1000, paramBoolean1, null, paramInt, paramBoolean2, paramBoolean3, null);
  }
  
  public void a(short paramShort, byte paramByte)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.SetRoamMsgAllUser");
    localToServiceMsg.extraData.putShort("shType", paramShort);
    localToServiceMsg.extraData.putByte("cValue", paramByte);
    send(localToServiceMsg);
  }
  
  public void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean3, long paramLong3, jnm.d paramd)
  {
    oidb_0xd55.ReqBody localReqBody = new oidb_0xd55.ReqBody();
    localReqBody.check_app_sign_req.setHasFlag(true);
    localReqBody.check_app_sign_req.client_info.setHasFlag(true);
    if (!TextUtils.isEmpty(paramString2)) {
      localReqBody.check_app_sign_req.client_info.android_package_name.set(paramString2);
    }
    localReqBody.check_app_sign_req.client_info.platform.set(1);
    paramString2 = ahlj.z(BaseApplicationImpl.getContext(), paramString2);
    if (!TextUtils.isEmpty(paramString2)) {
      localReqBody.check_app_sign_req.client_info.android_signature.set(paramString2);
    }
    localReqBody.check_app_sign_req.client_info.sdk_version.set("0.0.0");
    localReqBody.check_user_req.setHasFlag(true);
    localReqBody.check_user_req.openid.set(paramString1);
    paramString1 = localReqBody.check_user_req.need_check_same_user;
    int i;
    if (paramBoolean1)
    {
      i = 1;
      paramString1.set(i);
      if (paramBoolean2)
      {
        localReqBody.check_mini_app_req.setHasFlag(true);
        localReqBody.check_mini_app_req.mini_app_appid.set(paramLong1);
        localReqBody.check_mini_app_req.need_check_bind.set(1);
      }
      localReqBody.appid.set(paramLong2);
      localReqBody.app_type.set(paramInt1);
      localReqBody.src_id.set(paramInt2);
      paramString1 = localReqBody.is_need_appinfo;
      if (!paramBoolean3) {
        break label282;
      }
    }
    label282:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString1.set(paramInt1);
      jnm.a(this.app, paramd, localReqBody.toByteArray(), "OidbSvc.0xd55", 3413, 0, null, paramLong3);
      return;
      i = 0;
      break;
    }
  }
  
  public boolean a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, Bundle paramBundle)
  {
    long l1 = this.jdField_a_of_type_Anaz.j(String.valueOf(paramLong1), 3000);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "--->>getPullDiscussionMsg uin: " + paramLong1 + " beginSeq: " + paramLong2 + " endSeq: " + paramLong3 + " delSeq: " + l1);
    }
    if ((paramLong2 < 0L) || (paramLong3 < 0L)) {
      return false;
    }
    Pair localPair = this.jdField_a_of_type_Anaz.g(String.valueOf(paramLong1));
    if (localPair == null) {
      return false;
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.PbGetDiscussMsg");
    localToServiceMsg.extraData.putLong("lDisUin", paramLong1);
    localToServiceMsg.extraData.putLong("lBeginSeq", paramLong2);
    localToServiceMsg.extraData.putLong("lEndSeq", paramLong3);
    localToServiceMsg.extraData.putBoolean("isRefreshHead", paramBoolean);
    localToServiceMsg.extraData.putBundle("context", paramBundle);
    localToServiceMsg.extraData.putLong("dwLastInfoSeq", ((Long)localPair.first).longValue());
    localToServiceMsg.extraData.putLong("dwLastGetTime", ((Long)localPair.second).longValue());
    paramBundle = new msg_svc.PbGetDiscussMsgReq();
    paramBundle.begin_seq.set(paramLong2);
    paramBundle.end_seq.set(paramLong3);
    paramBundle.discuss_uin.set(paramLong1);
    paramBundle.discuss_info_seq.set(((Long)localPair.first).longValue());
    paramBundle.last_get_time.set(((Long)localPair.second).longValue());
    localToServiceMsg.putWupBuffer(paramBundle.toByteArray());
    o(localToServiceMsg);
    return true;
  }
  
  public boolean a(long paramLong, SendMessageHandler paramSendMessageHandler)
  {
    synchronized (this.iS)
    {
      if (!this.iS.containsKey(Long.valueOf(paramLong)))
      {
        this.iS.put(Long.valueOf(paramLong), paramSendMessageHandler);
        paramSendMessageHandler.msgSeq = paramLong;
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "sendQueue alread has msgSeq[" + paramLong + "]");
      }
      return false;
    }
  }
  
  public boolean a(SendMessageHandler paramSendMessageHandler, String paramString)
  {
    boolean bool2 = false;
    long l1 = paramSendMessageHandler.Y(System.currentTimeMillis());
    boolean bool3;
    if (l1 < 450000L)
    {
      l1 = 480000L - l1 - 5000L;
      bool3 = paramSendMessageHandler.b(0L, l1, paramString);
      bool1 = bool3;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<<<---retrySendMessage scheduleSuccess[" + bool3 + "] msgSeq[" + paramSendMessageHandler.msgSeq + "] timeout[" + l1 + "] reason[" + paramString + "]");
      }
    }
    for (boolean bool1 = bool3;; bool1 = false)
    {
      if ((bool1) || (!paramSendMessageHandler.aFa()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<<<---retrySendMessage Wait SendMessage Retry");
        }
        bool1 = true;
      }
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.MessageHandler", 2, "<<<---retrySendMessage No unfinished retry attampt.");
      return false;
    }
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean, Bundle paramBundle, int paramInt)
  {
    long l1 = this.jdField_a_of_type_Anaz.j(paramString, 1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler.trooptroop_pull_msg", 2, "--->>getPullTroopMsg troopUin2: " + paramString + " beginSeq: " + paramLong1 + " endSeq: " + paramLong2 + " delSeq: " + l1 + " pull num : " + (paramLong2 - paramLong1 + 1L) + " doSome:" + paramInt + " ThreadId:" + Thread.currentThread().getId());
    }
    if ((paramLong1 < 0L) || (paramLong2 < 0L)) {
      return false;
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.PbGetGroupMsg");
    localToServiceMsg.extraData.putString("groupuin", paramString);
    localToServiceMsg.extraData.putLong("lBeginSeq", paramLong1);
    localToServiceMsg.extraData.putLong("lEndSeq", paramLong2);
    localToServiceMsg.extraData.putBoolean("isRefreshHead", paramBoolean);
    localToServiceMsg.extraData.putBundle("context", paramBundle);
    localToServiceMsg.extraData.putInt("doSome", paramInt);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    Object localObject = localToServiceMsg.extraData;
    if ((paramBundle != null) && (paramBundle.getBoolean("key_from_parallel_pull", false))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((Bundle)localObject).putBoolean("key_from_parallel_pull", paramBoolean);
      paramBundle = new msg_svc.PbGetGroupMsgReq();
      paramBundle.group_code.set(Long.valueOf(paramString).longValue());
      paramBundle.begin_seq.set(paramLong1);
      paramBundle.end_seq.set(paramLong2);
      localObject = (HotChatManager)this.app.getManager(60);
      paramBundle.public_group.set(((HotChatManager)localObject).ki(paramString));
      localToServiceMsg.putWupBuffer(paramBundle.toByteArray());
      o(localToServiceMsg);
      return true;
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if ((!paramBoolean2) && (aO(paramBoolean1))) {}
    for (paramBoolean1 = true; (paramBoolean1) && (paramList != null) && (paramList.size() > 0) && ((top.b(this.app, (MessageRecord)paramList.get(0))) || (top.c(this.app, (MessageRecord)paramList.get(0))) || (aehj.g(this.app, (MessageRecord)paramList.get(0)))); paramBoolean1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenTroopDebug", 2, "opentroop and hotchattroop msg not notify.");
      }
      return false;
    }
    return paramBoolean1;
  }
  
  public byte[] a(boolean paramBoolean)
  {
    Object localObject = new msg_svc.PbGetMsgReq();
    byte[] arrayOfByte;
    if (paramBoolean)
    {
      arrayOfByte = this.jdField_a_of_type_Anaz.an();
      if (arrayOfByte != null) {
        ((msg_svc.PbGetMsgReq)localObject).pubaccount_cookie.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      ((msg_svc.PbGetMsgReq)localObject).msg_req_type.set(2);
    }
    for (;;)
    {
      ((msg_svc.PbGetMsgReq)localObject).sync_flag.set(0);
      ((msg_svc.PbGetMsgReq)localObject).ramble_flag.set(0);
      ((msg_svc.PbGetMsgReq)localObject).context_flag.set(1);
      ((msg_svc.PbGetMsgReq)localObject).online_sync_flag.set(0);
      ((msg_svc.PbGetMsgReq)localObject).latest_ramble_number.set(20);
      ((msg_svc.PbGetMsgReq)localObject).other_ramble_number.set(3);
      localObject = ((msg_svc.PbGetMsgReq)localObject).toByteArray();
      arrayOfByte = new byte[localObject.length + 4];
      aqoj.copyData(arrayOfByte, 4, (byte[])localObject, 0, localObject.length);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>createGetMsgReq ,isPubAccount:" + paramBoolean);
      }
      return arrayOfByte;
      arrayOfByte = this.jdField_a_of_type_Anaz.am();
      if (arrayOfByte != null) {
        ((msg_svc.PbGetMsgReq)localObject).sync_cookie.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      ((msg_svc.PbGetMsgReq)localObject).msg_req_type.set(1);
    }
  }
  
  public boolean aO(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public void aY(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "getC2CMessage:isPullRoamMsg:" + paramBoolean + " ,pullMsgType:" + paramInt);
    }
    a((byte)3, null, 0, paramBoolean, true, false, null, paramInt, null);
  }
  
  public boolean aaH()
  {
    synchronized (this.kk)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "----------handleMsgNew: " + this.bIr);
      }
      return this.bIr;
    }
  }
  
  public boolean aaK()
  {
    boolean bool = false;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("saveTroopMsgFilter. troopSettingList size=");
      if (this.tj != null) {
        break label76;
      }
    }
    label76:
    for (int i = 0;; i = this.tj.size())
    {
      QLog.d("Q.msg.MessageHandler", 2, i);
      if (this.tj != null)
      {
        aqgx.a().c(this.tj, this.app);
        this.tj = null;
        bool = true;
      }
      return bool;
    }
  }
  
  public boolean aaN()
  {
    return ((aaL()) && (aaM())) || (!bIp);
  }
  
  public boolean aaO()
  {
    long l1 = SystemClock.uptimeMillis() - this.Qk;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "canRefreshMessage() elapsed=[" + (float)l1 * 1.0F / 1000.0F + "]s,mIntervalForbidPulldown=[" + this.Ql + "]s");
    }
    return l1 >= this.Ql * 1000L;
  }
  
  public void ae(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "req or resp is null");
      }
    }
    do
    {
      do
      {
        return;
        if (paramToServiceMsg.extraData.containsKey("msgSeq")) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.MessageHandler", 2, "no msgSeq");
      return;
      long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
      int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      long l2 = paramFromServiceMsg.getResultCode();
      long l3 = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 9223372036854775807L);
      SendMessageHandler localSendMessageHandler = a(l1);
      if (localSendMessageHandler != null)
      {
        paramFromServiceMsg = achp.a(paramToServiceMsg, paramFromServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<---TimeConsume---> cmd[" + paramToServiceMsg.getServiceCmd() + "] seq[" + l1 + "] retryIndex[" + i + "] " + paramFromServiceMsg[0] + "");
        }
        localSendMessageHandler.a(i, l2, l3, paramFromServiceMsg);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "can not found handler");
  }
  
  public void aj(long paramLong, boolean paramBoolean)
  {
    this.cE.set(false);
    cKp();
    int i = Math.abs(new Random(System.currentTimeMillis()).nextInt());
    this.cwB = i;
    if (paramLong != 0L) {
      this.Qj = paramLong;
    }
    send(a(paramBoolean, i, paramLong));
  }
  
  public void ap(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    HashMap localHashMap = new HashMap();
    long l2 = 0L;
    long l3 = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 0L);
    int i;
    if ((l3 == 10L) || (l3 == 34L))
    {
      i = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
      if (paramFromServiceMsg != null) {
        break label348;
      }
      paramFromServiceMsg = "0";
    }
    label338:
    label348:
    for (;;)
    {
      int k = paramToServiceMsg.extraData.getInt("send_msg_req_size", 0);
      localHashMap.put("pm_peer_uin", paramFromServiceMsg);
      localHashMap.put("pm_route_type", String.valueOf(i));
      localHashMap.put("pm_req_size", String.valueOf(k));
      localHashMap.put("pm_srv_reply", String.valueOf(l3));
      long l1 = l2;
      if (i != 13)
      {
        l1 = l2;
        if (i != 9)
        {
          l1 = paramToServiceMsg.extraData.getLong("startTime", 0L);
          l2 = System.currentTimeMillis();
          if (l1 >= 1L) {
            break label338;
          }
        }
      }
      for (l1 = 0L;; l1 = l2 - l1)
      {
        int n = paramToServiceMsg.extraData.getInt("msgtype");
        int i1 = anbh.b(i, this.app);
        localHashMap.put("pm_msg_type", String.valueOf(n));
        localHashMap.put("pm_uin_type", String.valueOf(i1));
        paramToServiceMsg = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
        anpc.a(BaseApplication.getContext()).collectPerformance(paramToServiceMsg.getCurrentAccountUin(), "sendMsgTooLargeErrorTag", false, l1, k, localHashMap, "");
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, String.format("Statistics TAG:%s, duration:%dms, peerUin:%s, replyCode:%d, routingType:%s, msgReqSize:%d", new Object[] { "sendMsgTooLargeErrorTag", Long.valueOf(l1), paramFromServiceMsg, Long.valueOf(l3), Integer.valueOf(i), Integer.valueOf(k) }));
        }
        return;
      }
    }
  }
  
  public int b(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    int i = a(localSendMessageHandler);
    msg_svc.PbSendMsgReq localPbSendMsgReq = a(2, paramLong1, paramLong2, paramInt1, paramInt2);
    paramInt1 = 0;
    while (paramInt1 < 3)
    {
      localSendMessageHandler.a(new MessageHandler.2(this, localPbSendMsgReq, i, paramLong2));
      paramInt1 += 1;
    }
    paramInt1 = 0;
    while (paramInt1 <= 3)
    {
      paramLong1 = paramInt1 * 30000L / 3L;
      localSendMessageHandler.getClass();
      localSendMessageHandler.b(paramLong1, 10000L, "period");
      paramInt1 += 1;
    }
    return i;
  }
  
  public EntityManager b()
  {
    if ((this.em == null) || (!this.em.isOpen())) {}
    synchronized (this.bE)
    {
      if ((this.em == null) || (!this.em.isOpen())) {
        this.em = this.app.a().createEntityManager();
      }
      return this.em;
    }
  }
  
  public void b(Message paramMessage, boolean paramBoolean)
  {
    if (!a().o(paramMessage))
    {
      a().aM(paramMessage);
      if (paramBoolean)
      {
        a().sendMessage(paramMessage);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "sendWorkMessage doNow=" + paramBoolean);
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        a().aN(paramMessage);
        if (!a().hasMessages(2)) {
          a().sendEmptyMessageDelayed(2, 5000L);
        }
      }
    }
    QLog.d("Q.msg.MessageHandler", 2, "return! caused by hasSameUnreadWorker");
  }
  
  public void b(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    this.app.b().a(paramString, paramInt, paramLong1, paramLong2, paramLong3);
    if (this.app.a().c(paramInt, paramString, paramLong1))
    {
      paramString = this.app.a().a(paramInt, paramString, paramLong1);
      paramString.shmsgseq = paramLong2;
      paramString.time = paramLong3;
      paramString.extraflag = 0;
      a().Y(paramString);
    }
  }
  
  public void bn(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, 0L, false);
  }
  
  public void bz(boolean paramBoolean1, boolean paramBoolean2)
  {
    List localList = this.app.a().a().q(true);
    int i;
    if ((localList != null) && (!localList.isEmpty()))
    {
      i = 0;
      if ((i < localList.size()) && (i < 40)) {}
    }
    else
    {
      Fg(false);
      Fh(false);
      if (!aaH()) {
        break label475;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "checkBreakPoint getNewPushMsg");
      }
      aY(false, 0);
    }
    label475:
    do
    {
      return;
      RecentUser localRecentUser = (RecentUser)localList.get(i);
      int k;
      if (localRecentUser.getType() == 1)
      {
        k = this.app.cs(localRecentUser.uin);
        if (((k == 1) || (k == 4)) && (this.app.b().z(localRecentUser.uin, 1))) {}
      }
      for (;;)
      {
        i += 1;
        break;
        Pair localPair = c(localRecentUser.uin, 1);
        k = (int)(((Long)localPair.second).longValue() - ((Long)localPair.first).longValue());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "checkBreakPoint troopUin: " + localRecentUser.uin + " msg count: " + k);
        }
        if (k > 0)
        {
          try
          {
            a(localRecentUser.uin, ((Long)localPair.first).longValue() + 1L, ((Long)localPair.second).longValue(), false, null, 0);
          }
          catch (Exception localException1) {}
          continue;
          if ((localException1.getType() == 3000) && (this.app.b().z(localException1.uin, 3000)))
          {
            localPair = c(localException1.uin, 3000);
            k = (int)(((Long)localPair.second).longValue() - ((Long)localPair.first).longValue());
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "checkBreakPoint discUin: " + localException1.uin + " msg count: " + k);
            }
            if (k > 0) {
              try
              {
                a(Long.valueOf(localException1.uin).longValue(), 1L + ((Long)localPair.first).longValue(), ((Long)localPair.second).longValue(), false, null);
              }
              catch (Exception localException2) {}
            }
          }
        }
      }
      if (paramBoolean1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "checkBreakPoint syncC2CMsg");
        }
        aY(true, 1);
      }
    } while (!paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "checkBreakPoint syncPAMsg");
    }
    aY(true, 2);
  }
  
  public void c(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    if (this.app.a().c(paramInt, paramString1, paramLong1))
    {
      paramString1 = this.app.a().a(paramInt, paramString1, paramLong1);
      paramString1.time = paramLong2;
      paramString1.extraflag = 0;
      a().Y(paramString1);
      return;
    }
    this.app.b().b(paramString1, paramInt, paramLong1, paramLong2, paramString2);
  }
  
  public void cJZ()
  {
    notifyUI(6006, true, null, true);
  }
  
  public void cKa()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "----------resetGetMsgFlag ");
    }
    this.bIq = false;
    this.bIr = false;
    this.bIs = false;
  }
  
  public void cKb()
  {
    if (a().hasMessages(2)) {
      a().removeMessages(2);
    }
    a().cKu();
  }
  
  public void cKe()
  {
    this.cwR = 0;
    this.cwP = 0;
  }
  
  public void cKf()
  {
    this.jdField_a_of_type_Anaz.PD(false);
    Fg(false);
    aN(false);
    Fh(false);
    aaI();
  }
  
  public void cKh()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handlePullLackGroupMsg-> New RegisterProxy End!");
      }
      cKi();
      synchronized (this.cE)
      {
        if (!this.cE.get())
        {
          long l1 = System.currentTimeMillis();
          this.cE.wait(10000L);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "AllMsgThreadEndLock wait = " + (System.currentTimeMillis() - l1));
          }
        }
        this.bIo = false;
        this.bIn = false;
        cKj();
        this.cE.set(false);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Q.msg.MessageHandler", 1, "handlePullLackGroupMsg exception!");
    }
  }
  
  public void cKi()
  {
    Object localObject1 = this.jdField_a_of_type_Anaz;
    if (anaz.a != null)
    {
      long l1 = System.currentTimeMillis();
      localObject1 = (zxj)this.app.getManager(125);
      Object localObject2 = this.jdField_a_of_type_Anaz;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      if (anaz.a.Gr != null)
      {
        localObject2 = this.jdField_a_of_type_Anaz;
        if (anaz.a.Gr.size() > 0)
        {
          localObject2 = new HashMap();
          localObject3 = this.jdField_a_of_type_Anaz;
          localObject3 = anaz.a.Gr.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (register_proxy.GroupList)((Iterator)localObject3).next();
            if (localObject4 != null)
            {
              localObject5 = String.valueOf(((register_proxy.GroupList)localObject4).group_code.get());
              this.iQ.put(localObject5, Boolean.valueOf(((register_proxy.GroupList)localObject4).has_msg.get()));
              if (((register_proxy.GroupList)localObject4).redpack_time.get() > 0L) {
                ((HashMap)localObject2).put(localObject5, String.valueOf(((register_proxy.GroupList)localObject4).redpack_time.get()));
              }
            }
          }
          ((zxj)localObject1).y((HashMap)localObject2);
        }
      }
      localObject2 = this.jdField_a_of_type_Anaz;
      if (anaz.a.Gs != null)
      {
        localObject2 = this.jdField_a_of_type_Anaz;
        if (anaz.a.Gs.size() > 0)
        {
          localObject3 = ((acdu)this.app.getManager(53)).getDiscussList();
          localObject2 = new ArrayList();
          localObject3 = ((ArrayList)localObject3).iterator();
          int i = 1;
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (DiscussionInfo)((Iterator)localObject3).next();
            ((ArrayList)localObject2).add(((DiscussionInfo)localObject4).uin);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "handleRegPrxyCache--> discussion" + i + ":" + ((DiscussionInfo)localObject4).uin);
            }
            i += 1;
          }
          localObject3 = (acdt)this.app.getBusinessHandler(6);
          localObject4 = new ArrayList();
          localObject5 = new ArrayList();
          HashMap localHashMap = new HashMap();
          Object localObject6 = this.jdField_a_of_type_Anaz;
          localObject6 = anaz.a.Gs.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            register_proxy.DiscussList localDiscussList = (register_proxy.DiscussList)((Iterator)localObject6).next();
            if (localDiscussList != null)
            {
              String str = String.valueOf(localDiscussList.discuss_code.get());
              this.iR.put(str, Boolean.valueOf(localDiscussList.has_msg.get()));
              if (localDiscussList.redpack_time.get() > 0L) {
                localHashMap.put(str, String.valueOf(localDiscussList.redpack_time.get()));
              }
              DiscussionInfo localDiscussionInfo = new DiscussionInfo();
              localDiscussionInfo.uin = String.valueOf(localDiscussList.discuss_code.get());
              localDiscussionInfo.infoSeq = localDiscussList.info_seq.get();
              ((ArrayList)localObject4).add(localDiscussionInfo);
              if (localDiscussList.bHotGroup.get()) {
                ((ArrayList)localObject5).add(localDiscussionInfo.uin);
              }
              ((ArrayList)localObject2).remove(str);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("DiscussionVerify", 2, "REG_PROXY dis_cnt=" + ((ArrayList)localObject4).size() + " fav_cnt=" + ((ArrayList)localObject5).size());
          }
          i = 1;
          if (((ArrayList)localObject4).size() >= 100)
          {
            ((acdt)localObject3).hp(this.app.getLongAccountUin());
            i = 0;
          }
          if ((!((ArrayList)localObject2).isEmpty()) && (i != 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "handleRegPrxyCache deleteDiscussList=" + ((ArrayList)localObject2).toArray());
            }
            localObject2 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject6 = (String)((Iterator)localObject2).next();
              ((acdt)localObject3).Dz((String)localObject6);
              if (this.jdField_a_of_type_Anaz.V((String)localObject6) != null) {
                this.jdField_a_of_type_Anaz.Qi((String)localObject6);
              }
            }
          }
          notifyUI(1000, ((acdt)localObject3).e((ArrayList)localObject4, (ArrayList)localObject5), null);
          ((zxj)localObject1).z(localHashMap);
        }
      }
      localObject1 = this.jdField_a_of_type_Anaz;
      anaz.a.Gr = null;
      localObject1 = this.jdField_a_of_type_Anaz;
      anaz.a.Gs = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleRegPrxyCache end! cost:" + (System.currentTimeMillis() - l1));
      }
    }
  }
  
  public void cKj()
  {
    Object localObject1 = new StringBuilder();
    if (QLog.isColorLevel())
    {
      ((StringBuilder)localObject1).setLength(0);
      ((StringBuilder)localObject1).append("checkGroupMsgComplete-> troopNum:").append(this.cwE).append(" ,discussionNum:").append(this.cwF).append(" ,recvTroopNum:").append(this.cwG).append(" ,recvDiscNum").append(this.cwH);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if ((!this.app.a().bl(false)) && (this.cwE == 0) && (this.cwF == 0)) {
      return;
    }
    int n = 0;
    this.ei = null;
    this.ej = null;
    Object localObject2;
    int k;
    Iterator localIterator;
    String str;
    long l2;
    Object[] arrayOfObject;
    long l1;
    label359:
    int i;
    if ((this.iQ != null) && (this.iQ.size() > 0))
    {
      localObject2 = new ArrayList();
      k = this.iQ.size();
      localIterator = this.iQ.keySet().iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        l2 = this.jdField_a_of_type_Anaz.aI(str);
        arrayOfObject = this.jdField_a_of_type_Anaz.e(str);
        if ((arrayOfObject != null) && (arrayOfObject.length > 0)) {}
        for (l1 = ((Long)arrayOfObject[1]).longValue();; l1 = 0L)
        {
          if (((!this.app.a().bl(false)) && (!((Boolean)this.iQ.get(str)).booleanValue())) || (l2 >= l1)) {
            break label359;
          }
          if (QLog.isColorLevel())
          {
            ((StringBuilder)localObject1).setLength(0);
            ((StringBuilder)localObject1).append("---------checkGroupMsgComplete needToPullTroop troopUin: ").append(str).append(",lastSeq:").append(l2).append(",svrSeq:").append(l1);
            QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
          }
          ((ArrayList)localObject2).add(str);
          break;
        }
      }
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        n = ((ArrayList)localObject2).size();
        this.ei = new String[n];
        i = 0;
        while (i < n)
        {
          this.ei[i] = ((String)((ArrayList)localObject2).get(i));
          i += 1;
        }
        i = n;
        this.iQ.clear();
        n = i;
      }
    }
    for (;;)
    {
      int i1;
      if ((this.iR != null) && (this.iR.size() > 0))
      {
        localObject2 = new ArrayList();
        i1 = this.iR.size();
        localIterator = this.iR.keySet().iterator();
        label659:
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          l2 = this.jdField_a_of_type_Anaz.aH(str);
          arrayOfObject = this.jdField_a_of_type_Anaz.d(str);
          if ((arrayOfObject != null) && (arrayOfObject.length > 0)) {}
          for (l1 = ((Long)arrayOfObject[1]).longValue();; l1 = 0L)
          {
            if (((!this.app.a().bl(false)) && (!((Boolean)this.iR.get(str)).booleanValue())) || (l2 >= l1)) {
              break label659;
            }
            if (QLog.isColorLevel())
            {
              ((StringBuilder)localObject1).setLength(0);
              ((StringBuilder)localObject1).append("---------checkGroupMsgComplete needToPullDiscuss discussUin: ").append(str).append(",lastSeq:").append(l2).append(",svrSeq:").append(l1);
              QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
            }
            ((ArrayList)localObject2).add(str);
            break;
          }
        }
        if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
        {
          int i2 = ((ArrayList)localObject2).size();
          this.ej = new String[i2];
          i = 0;
          while (i < i2)
          {
            this.ej[i] = ((String)((ArrayList)localObject2).get(i));
            i += 1;
          }
          i = i2;
          this.iR.clear();
        }
      }
      for (;;)
      {
        if ((this.ei != null) || (this.ej != null))
        {
          bn(4, true);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "needPullTroopNum:" + n + " ,needPullDiscNum:" + i + " ,regPrxyError:" + this.app.a().bl(false));
          }
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("param_needpulltroop", String.valueOf(n));
          ((HashMap)localObject1).put("param_needpulldisc", String.valueOf(i));
          ((HashMap)localObject1).put("param_trooptotalnum", String.valueOf(k));
          ((HashMap)localObject1).put("param_disctotalnum", String.valueOf(i1));
          localObject2 = anpc.a(BaseApplication.getContext());
          if (this.app.a().bl(false)) {
            break label937;
          }
        }
        label937:
        for (boolean bool = true;; bool = false)
        {
          ((anpc)localObject2).collectPerformance(null, "prxyRegNeedPullGroup", bool, 0L, 0L, (HashMap)localObject1, null);
          this.cwE = 0;
          this.cwF = 0;
          this.cwG = 0;
          this.cwH = 0;
          return;
        }
        i = 0;
        break;
        i1 = 0;
        i = 0;
      }
      i = 0;
      break;
      k = 0;
    }
  }
  
  public void cKk()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleGroupMsgAfterSyncMsg");
    }
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_Anaz.x();
    Iterator localIterator;
    Object localObject1;
    Object localObject2;
    Object[] arrayOfObject;
    if (!localConcurrentHashMap.isEmpty())
    {
      localIterator = localConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleGroupMsgAfterSyncMsg --> troopUin:" + (String)localObject1);
        }
        localObject2 = (ArrayList)localConcurrentHashMap.get(localObject1);
        if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            arrayOfObject = (Object[])((Iterator)localObject2).next();
            this.jdField_a_of_type_Anaz.Qg((String)localObject1);
            if ((arrayOfObject != null) && (arrayOfObject.length >= 2)) {
              a("troop_processor").f(1001, new Object[] { arrayOfObject, null, Boolean.valueOf(false) });
            }
          }
        }
        localObject1 = this.jdField_a_of_type_Anaz.a((String)localObject1);
        if (localObject1 != null) {
          ((apde)a("troop_processor")).a((GroupMsgReadedNotify)localObject1);
        }
      }
    }
    localConcurrentHashMap = this.jdField_a_of_type_Anaz.z();
    if (!localConcurrentHashMap.isEmpty())
    {
      localIterator = localConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleGroupMsgAfterSyncMsg --> discUin:" + (String)localObject1);
        }
        localObject2 = (ArrayList)localConcurrentHashMap.get(localObject1);
        if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
        {
          this.jdField_a_of_type_Anaz.Qi((String)localObject1);
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            arrayOfObject = (Object[])((Iterator)localObject2).next();
            if ((arrayOfObject != null) && (arrayOfObject.length >= 3)) {
              a("disc_processor").f(1001, new Object[] { arrayOfObject[0], arrayOfObject[1], arrayOfObject[2], Boolean.valueOf(false) });
            }
          }
        }
        localObject1 = this.jdField_a_of_type_Anaz.a((String)localObject1);
        if (localObject1 != null) {
          ((acqs)a("disc_processor")).a((DisMsgReadedNotify)localObject1);
        }
      }
    }
  }
  
  public void cKl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "flushDiscussionAndTroopMsg begin.");
    }
    ConcurrentHashMap localConcurrentHashMap1 = this.jdField_a_of_type_Anaz.w();
    ArrayList localArrayList;
    Enumeration localEnumeration;
    String str;
    boolean bool;
    if ((localConcurrentHashMap1 != null) && (localConcurrentHashMap1.size() > 0))
    {
      try
      {
        localArrayList = new ArrayList();
        localEnumeration = localConcurrentHashMap1.keys();
        for (;;)
        {
          if (!localEnumeration.hasMoreElements()) {
            break label241;
          }
          str = (String)localEnumeration.nextElement();
          if (((Integer)localConcurrentHashMap1.get(str)).intValue() != 2) {
            break;
          }
          bool = true;
          if (!Boolean.valueOf(bool).booleanValue()) {
            localArrayList.add(str);
          }
        }
        localConcurrentHashMap2 = this.jdField_a_of_type_Anaz.y();
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
    else
    {
      label114:
      ConcurrentHashMap localConcurrentHashMap2;
      if ((localConcurrentHashMap2 != null) && (localConcurrentHashMap2.size() > 0)) {
        try
        {
          localArrayList = new ArrayList();
          localEnumeration = localConcurrentHashMap2.keys();
          for (;;)
          {
            if (localEnumeration.hasMoreElements())
            {
              str = (String)localEnumeration.nextElement();
              if (((Integer)localConcurrentHashMap2.get(str)).intValue() == 2)
              {
                bool = true;
                label187:
                if (Boolean.valueOf(bool).booleanValue()) {
                  continue;
                }
                localArrayList.add(str);
                continue;
                if (!QLog.isColorLevel()) {
                  break;
                }
              }
            }
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
    }
    for (;;)
    {
      QLog.d("Q.msg.MessageHandler", 2, "flushDiscussionAndTroopMsg end.");
      this.jdField_a_of_type_Anaz.dON();
      return;
      bool = false;
      break;
      label241:
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "flushDiscussionAndTroopMsg, troopSize=" + localArrayList.size());
      }
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext()) {
        eN((String)localIterator.next(), "flushDiscussionAndTroopMsg");
      }
      break label114;
      bool = false;
      break label187;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "flushDiscussionAndTroopMsg, disSize=" + localArrayList.size());
      }
      localIterator = localArrayList.iterator();
      while (localIterator.hasNext()) {
        eR((String)localIterator.next(), "flushDiscussionAndTroopMsg");
      }
    }
  }
  
  public void cKm()
  {
    send(createToServiceMsg("RegPrxySvc.getExtinfo"));
  }
  
  public void cKn()
  {
    if (!bIp) {
      return;
    }
    for (;;)
    {
      synchronized (this.cy)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread != null) {
          break label193;
        }
        this.tk = new ArrayList(20);
        this.tl = new ArrayList(10);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread = new MessageHandleThread[6];
        break label193;
        if (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread.length)
        {
          if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i] != null) && (!this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i].pP())) {
            break label198;
          }
          if (i == 0)
          {
            this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i] = new MessageHandleThread(this.tl);
            this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i].setName("MessageHandleThread" + (i + 1));
            this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i].setPriority(5);
            this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i].start();
            break label198;
          }
          this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i] = new MessageHandleThread(this.tk);
        }
      }
      return;
      label193:
      int i = 0;
      continue;
      label198:
      i += 1;
    }
  }
  
  public void cKo()
  {
    synchronized (this.cy)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread != null)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread.length)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread[i].close();
          i += 1;
        }
      }
      synchronized (this.tk)
      {
        this.tk.notifyAll();
        this.tl = null;
        this.tk = null;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppMessageHandler$MessageHandleThread = null;
        return;
      }
    }
  }
  
  public void cKp()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "[ReSendProxy] cleanRegisterProxyRandom");
    }
    this.Qj = 0L;
  }
  
  public void cKq()
  {
    ConcurrentHashMap localConcurrentHashMap;
    Object localObject1;
    Object localObject2;
    int i;
    Object localObject3;
    String str;
    int k;
    long l1;
    if (!this.app.a().aww())
    {
      localConcurrentHashMap = this.app.a().A();
      localObject1 = new ArrayList();
      localObject2 = localConcurrentHashMap.entrySet().iterator();
      i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        Iterator localIterator = ((ConcurrentHashMap)((Map.Entry)((Iterator)localObject2).next()).getValue()).entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (anaz.c)((Map.Entry)localIterator.next()).getValue();
          str = ((anaz.c)localObject3).frienduin;
          k = ((anaz.c)localObject3).istroop;
          l1 = ((anaz.c)localObject3).uniseq;
          localObject3 = this.app.b().b(str, k, l1);
          if (localObject3 == null)
          {
            this.app.a().e(str, k, l1);
          }
          else
          {
            if (!(localObject3 instanceof ChatMessage)) {
              break label784;
            }
            ((ChatMessage)localObject3).parse();
            if (!(localObject3 instanceof MessageForStructing)) {
              break label784;
            }
            MessageForStructing localMessageForStructing = (MessageForStructing)localObject3;
            if (localMessageForStructing.structingMsg == null) {
              break label784;
            }
            int n = localMessageForStructing.structingMsg.mMsgServiceID;
            if ((n != 35) && (n != 107)) {
              break label784;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "current mr is multimsg, uniseq: " + l1);
            }
            i = 1;
          }
        }
      }
    }
    label784:
    for (;;)
    {
      long l2 = ((MessageRecord)localObject3).time;
      long l3 = anaz.gQ();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "msgSending:setMsgSendingInfo, uin:" + str + " istroop:" + k + " uniseq:" + l1 + " time:" + l2 + " currentServerTime:" + l3);
      }
      if ((i != 0) || ((l3 - l2) * 1000L + 30000L >= 480000L) || (l3 - l2 < 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "msgSending:msg sending flag set to failed");
        }
        localObject3 = this.app.b().a(str, k);
        this.app.a().e(str, k, l1);
        if ((localObject3 != null) && (((QQMessageFacade.Message)localObject3).uniseq == l1)) {
          ((QQMessageFacade.Message)localObject3).extraflag = 32768;
        }
        this.app.b().b(str, k, l1, 32768, 1002);
        notifyUI(6003, false, new String[] { str, String.valueOf(l1) });
      }
      for (;;)
      {
        break;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "msgSending:resend msg, key =" + ((MessageRecord)localObject3).uniseq + "+" + ((MessageRecord)localObject3).frienduin + "+" + ((MessageRecord)localObject3).istroop);
        }
        top.b((List)localObject1, (MessageRecord)localObject3, true);
      }
      break;
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          this.app.a().az((MessageRecord)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "msgSending:addSendingCache suc");
          }
          this.app.b().as(localObject2);
          if ((((MessageRecord)localObject2).msgtype == -1051) && ((localObject2 instanceof MessageForLongTextMsg)) && (((MessageForLongTextMsg)localObject2).structingMsg == null)) {
            ((ajkw)this.app.getManager(166)).b(this.app, (MessageRecord)localObject2, true);
          } else {
            a((MessageRecord)localObject2, null, true);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "msgSending:last, msgSendingTemp:" + localConcurrentHashMap);
      }
      localConcurrentHashMap.clear();
      return;
    }
  }
  
  public void cKr()
  {
    int i = 0;
    SharedPreferences localSharedPreferences;
    Object localObject1;
    if (this.app.getCurrentAccountUin() != null)
    {
      localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
      localObject1 = localSharedPreferences.getString("msgSending", null);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "msgSending:init,read msgSending file," + (String)localObject1 + " msgCache:" + this.app.a().hashCode());
      }
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        if (i < ((JSONArray)localObject1).length())
        {
          if (((JSONArray)localObject1).isNull(i)) {
            break label351;
          }
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          String str = ((JSONObject)localObject2).getString("uin");
          int k = ((JSONObject)localObject2).getInt("type");
          long l1 = ((JSONObject)localObject2).getLong("uniseq");
          this.app.a().I(str, k, l1);
          localObject2 = this.app.b().b(str, k, l1);
          if (localObject2 == null) {
            break label351;
          }
          this.app.a().az((MessageRecord)localObject2);
          this.app.b().as(localObject2);
          if ((((MessageRecord)localObject2).msgtype != -1035) || (!(localObject2 instanceof MessageForMixedMsg))) {
            break label351;
          }
          this.app.b().b(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, 32768, ((MessageRecord)localObject2).sendFailCode);
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "msgSending:init,read msgSending file," + localException.getMessage());
        }
        localException.printStackTrace();
        localSharedPreferences.edit().remove("msgSending").commit();
      }
      return;
      label351:
      i += 1;
    }
  }
  
  public void cKs()
  {
    try
    {
      localList = this.xG;
      if (localList == null) {
        break label206;
      }
      if (localList.size() == 0) {
        return;
      }
      if (!QLog.isColorLevel()) {
        break label201;
      }
      l1 = System.currentTimeMillis();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        List localList;
        long l1;
        apsa localapsa;
        int k;
        if (QLog.isColorLevel())
        {
          QLog.e(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg exception ", localException);
          continue;
          label201:
          l1 = 0L;
        }
      }
    }
    localapsa = (apsa)this.app.getManager(132);
    k = localList.size();
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        register_proxy.GroupList localGroupList = (register_proxy.GroupList)localList.get(i);
        String str = String.valueOf(localGroupList.group_code.get());
        long l2 = localGroupList.group_seq.get();
        if (!str.equals(localapsa.BB())) {
          top.b(this.app, str, l2);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg: " + k + "," + (System.currentTimeMillis() - l1));
        }
        this.xG = null;
        return;
        label206:
        return;
      }
      i += 1;
    }
  }
  
  public void cKt()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.MessageHandler", 2, "send_oidb_0x5eb_42073");
    }
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(Long.valueOf(Long.parseLong(this.app.getAccount())));
      localReqBody.rpt_uint64_uins.set(localArrayList);
      localReqBody.uint32_preload_disable_flag.set(1);
      sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_42073", 1515, 22, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.msg.MessageHandler", 2, "send_oidb_0x5eb_42073 error", localException);
    }
  }
  
  public void cM(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        Object localObject = a(str);
        if (((localObject == null) || (System.currentTimeMillis() - ((AppShareID)localObject).updateTime >= 86400000L)) && (this.aB.add(str)))
        {
          localObject = new GetResourceReqInfo();
          ((GetResourceReqInfo)localObject).uiResID = 0L;
          ((GetResourceReqInfo)localObject).strPkgName = str;
          ((GetResourceReqInfo)localObject).uiCurVer = 0L;
          ((GetResourceReqInfo)localObject).sResType = 4;
          ((GetResourceReqInfo)localObject).sLanType = 0;
          ((GetResourceReqInfo)localObject).sReqType = 1;
          localArrayList.add(localObject);
          if (QLog.isColorLevel()) {
            QLog.d("share_appid", 2, "Request list add appid = " + str);
          }
        }
      }
      if (localArrayList.size() > 0) {
        anae.a(this.app, this.app.getCurrentAccountUin(), localArrayList);
      }
    }
  }
  
  public void d(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    c(paramString, paramInt, paramLong1, paramLong2, null);
  }
  
  public void dA(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "----------addFriendTipsMr friendUin: " + paramString + ", sourceId=" + paramInt);
    }
    if ((paramInt == 2007) || (paramInt == 3007) || (paramInt == 4007) || (paramInt == 2017) || (paramInt == 3017)) {
      this.app.a().e(Long.valueOf(paramString).longValue(), true, paramInt);
    }
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.cA)
      {
        paramString = (b)this.iT.get(paramString);
        if (paramString != null) {
          a(paramString.uin, paramString.mobile, paramString.Qp, paramString.boC, paramString.time, paramString.sourceId, paramString.cwU, paramString.Qq);
        }
        return;
      }
    }
  }
  
  public void dB(String paramString, int paramInt)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("AccostSvc.ReqDeleteBlackList");
    localToServiceMsg.extraData.putString("deleteUin", paramString);
    localToServiceMsg.extraData.putInt("fromType", paramInt);
    send(localToServiceMsg);
  }
  
  public void dC(String paramString, int paramInt)
  {
    int i = 0;
    Object localObject = new String[1];
    localObject[0] = paramString;
    long[] arrayOfLong = new long[1];
    arrayOfLong[0] = this.jdField_a_of_type_Anaz.aI(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "getPullTroopMsgNumber_PB troopUinArray.length: " + localObject.length + " troopUinArray:" + Arrays.toString((Object[])localObject) + ", lastSeqAry:" + Arrays.toString(arrayOfLong) + ", doSome:" + paramInt);
    }
    paramString = new msg_svc.PbUnReadMsgSeqReq();
    msg_svc.PbPullGroupMsgSeqReq localPbPullGroupMsgSeqReq = new msg_svc.PbPullGroupMsgSeqReq();
    for (;;)
    {
      if (i < localObject.length)
      {
        msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq localGroupInfoReq = new msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq();
        try
        {
          long l1 = Long.parseLong(localObject[i]);
          localGroupInfoReq.group_code.set(l1);
          localGroupInfoReq.last_seq.set(arrayOfLong[i]);
          localPbPullGroupMsgSeqReq.group_info_req.add(localGroupInfoReq);
          i += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            localNumberFormatException.printStackTrace();
          }
        }
      }
    }
    paramString.group_unread_info.set(localPbPullGroupMsgSeqReq);
    localObject = createToServiceMsg("PbMessageSvc.PbUnReadMsgSeq");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("doSome", paramInt);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void dI(ArrayList<MessageRecord> paramArrayList)
  {
    C(paramArrayList, true);
  }
  
  public void e(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "addMessageAndNotifyForQAV:" + paramMessageRecord.toString());
    }
    this.app.b().b(paramMessageRecord, this.app.getCurrentAccountUin());
    new ArrayList().add(paramMessageRecord);
    if ((paramMessageRecord.msgtype == -4008) || (paramMessageRecord.msgtype == -2016))
    {
      if ((paramMessageRecord.istroop == 3000) && (paramMessageRecord.msgtype == -4008)) {
        a("addMessageAndNotify", 1000, true, null, 1, true, false, paramMessageRecord);
      }
    }
    else if ((paramMessageRecord.msgtype == -2009) && ((paramMessageRecord.istroop == 0) || (paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 10004) || (paramMessageRecord.istroop == 1004) || (paramMessageRecord.istroop == 1006) || (paramMessageRecord.istroop == 1021) || (paramMessageRecord.istroop == 1010) || (paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)))
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        a("addMessageAndNotify", 1000, true, null, 1, aO(paramBoolean), false, paramMessageRecord);
        return;
      }
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      a("addMessageAndNotify", 1000, true, null, 1, aO(paramBoolean), false, null);
      return;
    }
  }
  
  public void eK(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && (paramObject != null))
    {
      paramToServiceMsg = (RespGetBlackList)paramObject;
      if (paramToServiceMsg.stHeader.eReplyCode == 0)
      {
        int k = paramToServiceMsg.vBlackListUin.size();
        if (k > 0)
        {
          paramFromServiceMsg = (acff)this.app.getManager(51);
          int i = 0;
          while (i < k)
          {
            paramObject = ((Long)paramToServiceMsg.vBlackListUin.get(i)).longValue() + "";
            if (!paramFromServiceMsg.isFriend(paramObject)) {
              paramFromServiceMsg.DO(paramObject);
            }
            i += 1;
          }
        }
        if (paramToServiceMsg.lNextMid != -1L) {
          break label135;
        }
      }
    }
    return;
    label135:
    hC(paramToServiceMsg.lNextMid);
  }
  
  public void eO(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      acff localacff = (acff)this.app.getManager(51);
      localacff.a(localacff.a(paramString1, paramString2));
    }
  }
  
  public void eP(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      ((acff)this.app.getManager(51)).b(paramString1, paramString2);
    }
  }
  
  public void eQ(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
      localTroopManager.a(localTroopManager.a(paramString1, paramString2));
    }
  }
  
  public void f(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(null, paramInt, paramBoolean, paramObject, 0, false, false, null);
  }
  
  /* Error */
  public void fd(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_3
    //   1: checkcast 1579	[B
    //   4: checkcast 1579	[B
    //   7: astore 7
    //   9: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +56 -> 68
    //   15: new 381	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 382	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 6012
    //   25: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_2
    //   29: invokevirtual 1475	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   32: invokevirtual 393	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   35: ldc_w 2303
    //   38: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: astore_1
    //   42: aload 7
    //   44: ifnull +345 -> 389
    //   47: aload 7
    //   49: arraylength
    //   50: istore 4
    //   52: ldc_w 379
    //   55: iconst_2
    //   56: aload_1
    //   57: iload 4
    //   59: invokevirtual 449	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 399	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: invokestatic 6017	aqap:a	()Laqap;
    //   71: astore_3
    //   72: aload_3
    //   73: invokevirtual 6020	aqap:b	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   76: astore_1
    //   77: aload_2
    //   78: ifnull +335 -> 413
    //   81: aload_2
    //   82: invokevirtual 1475	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   85: ifeq +328 -> 413
    //   88: aload 7
    //   90: ifnull +323 -> 413
    //   93: new 3394	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   96: dup
    //   97: invokespecial 3395	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   100: astore_2
    //   101: aload_2
    //   102: aload 7
    //   104: invokevirtual 3396	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   107: pop
    //   108: aload_2
    //   109: getfield 3399	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   112: invokevirtual 990	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   115: ifeq +298 -> 413
    //   118: aload_2
    //   119: getfield 3399	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   122: invokevirtual 1001	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   125: ifne +288 -> 413
    //   128: new 6022	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   131: dup
    //   132: invokespecial 6023	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   135: astore 7
    //   137: aload 7
    //   139: aload_2
    //   140: getfield 3404	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   143: invokevirtual 1762	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   146: invokevirtual 1763	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   149: invokevirtual 6024	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   152: pop
    //   153: aload 7
    //   155: getfield 6027	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   158: invokevirtual 6028	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   161: ifle +252 -> 413
    //   164: aload 7
    //   166: getfield 6027	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   169: iconst_0
    //   170: invokevirtual 3809	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   173: checkcast 6030	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   176: getfield 6031	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_preload_disable_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   179: invokevirtual 1001	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   182: istore 4
    //   184: aload_1
    //   185: monitorenter
    //   186: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +31 -> 220
    //   192: ldc_w 6033
    //   195: iconst_2
    //   196: new 381	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 382	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 6035
    //   206: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: iload 4
    //   211: invokevirtual 449	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 399	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_1
    //   221: iconst_1
    //   222: putfield 6040	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:cTt	Z
    //   225: iload 4
    //   227: iconst_1
    //   228: if_icmpne +191 -> 419
    //   231: iconst_1
    //   232: istore 5
    //   234: aload_1
    //   235: getfield 6043	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   238: ifnull +210 -> 448
    //   241: iload 4
    //   243: ifne +242 -> 485
    //   246: aload_1
    //   247: getfield 6046	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:dYl	I
    //   250: iconst_1
    //   251: if_icmpne +183 -> 434
    //   254: iconst_1
    //   255: istore 5
    //   257: iload 5
    //   259: istore 6
    //   261: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +35 -> 299
    //   267: ldc_w 6033
    //   270: iconst_2
    //   271: new 381	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 382	java/lang/StringBuilder:<init>	()V
    //   278: ldc_w 6048
    //   281: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: iload 5
    //   286: invokevirtual 393	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   289: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 399	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: iload 5
    //   297: istore 6
    //   299: aload_0
    //   300: getfield 262	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   303: iload 6
    //   305: invokestatic 6052	accy:t	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   308: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq +13 -> 324
    //   314: ldc_w 6054
    //   317: iconst_2
    //   318: ldc_w 6056
    //   321: invokestatic 399	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload_1
    //   325: getfield 6043	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   328: ifnull +133 -> 461
    //   331: aload_1
    //   332: getfield 6059	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig	Lcom/tencent/mobileqq/upgrade/NewUpgradeConfig;
    //   335: ifnull +126 -> 461
    //   338: aload_1
    //   339: getfield 6043	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   342: getfield 6064	protocol/KQQConfig/UpgradeInfo:iUpgradeType	I
    //   345: ifeq +116 -> 461
    //   348: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   351: ifeq +13 -> 364
    //   354: ldc_w 6054
    //   357: iconst_2
    //   358: ldc_w 6066
    //   361: invokestatic 399	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: aload_0
    //   365: getfield 262	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   368: iconst_4
    //   369: invokevirtual 1482	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   372: checkcast 6050	accy
    //   375: astore_2
    //   376: aload_3
    //   377: aload_1
    //   378: getfield 6043	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   381: aload_2
    //   382: invokevirtual 6069	aqap:a	(Lprotocol/KQQConfig/UpgradeInfo;Laqap$b;)Z
    //   385: pop
    //   386: aload_1
    //   387: monitorexit
    //   388: return
    //   389: iconst_m1
    //   390: istore 4
    //   392: goto -340 -> 52
    //   395: astore_2
    //   396: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: ifeq +14 -> 413
    //   402: ldc_w 379
    //   405: iconst_2
    //   406: ldc_w 294
    //   409: aload_2
    //   410: invokestatic 6071	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   413: iconst_0
    //   414: istore 4
    //   416: goto -232 -> 184
    //   419: iload 4
    //   421: iconst_2
    //   422: if_icmpne +66 -> 488
    //   425: invokestatic 6017	aqap:a	()Laqap;
    //   428: invokevirtual 6074	aqap:ecZ	()V
    //   431: goto +57 -> 488
    //   434: aload_1
    //   435: getfield 6046	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:dYl	I
    //   438: iconst_2
    //   439: if_icmpne +46 -> 485
    //   442: iconst_0
    //   443: istore 5
    //   445: goto -188 -> 257
    //   448: aload_1
    //   449: iload 4
    //   451: putfield 6077	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:dYm	I
    //   454: iload 5
    //   456: istore 6
    //   458: goto -159 -> 299
    //   461: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   464: ifeq -78 -> 386
    //   467: ldc_w 6054
    //   470: iconst_2
    //   471: ldc_w 6079
    //   474: invokestatic 399	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: goto -91 -> 386
    //   480: astore_2
    //   481: aload_1
    //   482: monitorexit
    //   483: aload_2
    //   484: athrow
    //   485: goto -228 -> 257
    //   488: iconst_0
    //   489: istore 5
    //   491: goto -257 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	494	0	this	MessageHandler
    //   0	494	1	paramToServiceMsg	ToServiceMsg
    //   0	494	2	paramFromServiceMsg	FromServiceMsg
    //   0	494	3	paramObject	Object
    //   50	400	4	i	int
    //   232	258	5	bool1	boolean
    //   259	198	6	bool2	boolean
    //   7	158	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   93	184	395	java/lang/Throwable
    //   186	220	480	finally
    //   220	225	480	finally
    //   234	241	480	finally
    //   246	254	480	finally
    //   261	295	480	finally
    //   299	324	480	finally
    //   324	364	480	finally
    //   364	386	480	finally
    //   386	388	480	finally
    //   425	431	480	finally
    //   434	442	480	finally
    //   448	454	480	finally
    //   461	477	480	finally
    //   481	483	480	finally
  }
  
  public void fe(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg.extraData.getBoolean("switch", true);
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000)) {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.printStackTrace();
        continue;
        int i = 1;
      }
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
    {
      paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      if (4 > paramToServiceMsg.length) {
        break label169;
      }
      paramToServiceMsg = String.valueOf(aqoj.getLongData(paramToServiceMsg, 0));
      if ((paramToServiceMsg != null) && (paramToServiceMsg.equals(this.app.getAccount()))) {
        break label169;
      }
      i = 0;
      if ((i != 0) && (QLog.isDevelopLevel())) {
        QLog.d("Q.msg.MessageHandler", 4, "toggle update value success");
      }
    }
  }
  
  public HashSet<String> g()
  {
    return this.aB;
  }
  
  public void g(int paramInt, boolean paramBoolean, Object paramObject)
  {
    notifyUI(paramInt, paramBoolean, paramObject);
  }
  
  public void h(int paramInt, boolean paramBoolean, Object paramObject)
  {
    f(paramInt, paramBoolean, paramObject);
  }
  
  public void hB(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "removeSendMessageHandler msgseq=" + paramLong);
    }
    SendMessageHandler localSendMessageHandler = a(paramLong);
    if (localSendMessageHandler != null)
    {
      localSendMessageHandler.een();
      bG(paramLong);
    }
  }
  
  public void hC(long paramLong)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("AccostSvc.ReqGetBlackList");
    localToServiceMsg.extraData.putLong("lNextMid", paramLong);
    send(localToServiceMsg);
  }
  
  public void iX(List<Long> paramList)
  {
    if (paramList != null)
    {
      acff localacff = (acff)this.app.getManager(51);
      int i = 0;
      while (i < paramList.size())
      {
        String str = String.valueOf(paramList.get(i));
        if (!TextUtils.isEmpty(str))
        {
          boolean bool = localacff.kb(str);
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.MessageHandler", 2, "removeFriendFromBlackList:" + str + " isBlack:" + bool);
          }
          if (bool) {
            DP(str);
          }
        }
        i += 1;
      }
    }
  }
  
  public void iY(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    msg_svc.PbUnReadMsgSeqReq localPbUnReadMsgSeqReq = new msg_svc.PbUnReadMsgSeqReq();
    msg_svc.PbPullGroupMsgSeqReq localPbPullGroupMsgSeqReq = new msg_svc.PbPullGroupMsgSeqReq();
    int k = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq localGroupInfoReq = new msg_svc.PbPullGroupMsgSeqReq.GroupInfoReq();
        try
        {
          long l1 = Long.parseLong((String)paramList.get(i));
          localGroupInfoReq.group_code.set(l1);
          localGroupInfoReq.last_seq.set(this.jdField_a_of_type_Anaz.aI((String)paramList.get(i)));
          localPbPullGroupMsgSeqReq.group_info_req.add(localGroupInfoReq);
          i += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            localNumberFormatException.printStackTrace();
          }
        }
      }
    }
    localPbUnReadMsgSeqReq.group_unread_info.set(localPbPullGroupMsgSeqReq);
    paramList = createToServiceMsg("PbMessageSvc.PbUnReadMsgSeq");
    paramList.putWupBuffer(localPbUnReadMsgSeqReq.toByteArray());
    paramList.extraData.putBoolean("RequestFromPublicAccountChatPie", true);
    sendPbReq(paramList);
  }
  
  public void j(Long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramLong);
    dH(localArrayList);
  }
  
  public void k(String paramString, int paramInt, boolean paramBoolean)
  {
    int k = 0;
    if (top.eD(paramInt) == 1032) {}
    do
    {
      do
      {
        return;
      } while (!top.x(paramString, paramInt));
      paramString = this.app.b().a(paramString, paramInt, paramBoolean);
    } while ((paramString == null) || (paramString.toByteArray() == null));
    paramInt = amzo.seq;
    amzo.seq = paramInt + 1;
    long l1 = paramInt;
    long l2 = System.currentTimeMillis();
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    a(l1, localSendMessageHandler);
    paramInt = 0;
    int i;
    for (;;)
    {
      i = k;
      if (paramInt >= 9) {
        break;
      }
      localSendMessageHandler.a(new MessageHandler.18(this, paramString, l2, l1));
      paramInt += 1;
    }
    label121:
    if (i < 3) {
      if (i != 0) {
        break label176;
      }
    }
    label176:
    for (l1 = 480000L;; l1 = (3 - i) * 480000 / 3 - i * 2000)
    {
      l2 = i * 480000 / 3;
      localSendMessageHandler.getClass();
      localSendMessageHandler.b(l2, l1, "period");
      i += 1;
      break label121;
      break;
    }
  }
  
  public void m(ArrayList<a> paramArrayList, ArrayList<acql.a> paramArrayList1)
  {
    int k = 0;
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.DelMsgV2");
    long[] arrayOfLong;
    Object localObject;
    short[] arrayOfShort;
    int i;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      arrayOfLong = new long[paramArrayList.size()];
      localObject = new int[paramArrayList.size()];
      arrayOfShort = new short[paramArrayList.size()];
      i = 0;
      while (i < paramArrayList.size())
      {
        arrayOfLong[i] = ((a)paramArrayList.get(i)).fromUin;
        localObject[i] = ((a)paramArrayList.get(i)).msgTime;
        arrayOfShort[i] = ((a)paramArrayList.get(i)).W;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "--->>delC2CMessage i: " + i + " fromUin:" + arrayOfLong[i] + " msgTime: " + localObject[i] + " msgSeq:" + arrayOfShort[i]);
        }
        i += 1;
      }
      localToServiceMsg.extraData.putLongArray("fromUin", arrayOfLong);
      localToServiceMsg.extraData.putIntArray("msgTime", (int[])localObject);
      localToServiceMsg.extraData.putShortArray("msgSeq", arrayOfShort);
    }
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      paramArrayList = new long[paramArrayList1.size()];
      arrayOfLong = new long[paramArrayList1.size()];
      localObject = new long[paramArrayList1.size()];
      arrayOfShort = new short[paramArrayList1.size()];
      i = k;
      while (i < paramArrayList1.size())
      {
        paramArrayList[i] = ((acql.a)paramArrayList1.get(i)).fromUin;
        arrayOfLong[i] = ((acql.a)paramArrayList1.get(i)).toUin;
        localObject[i] = ((acql.a)paramArrayList1.get(i)).msgId;
        arrayOfShort[i] = ((acql.a)paramArrayList1.get(i)).X;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "--->>delC2CMessage i: " + i + " fromUin:" + paramArrayList[i] + " msgId: " + localObject[i] + " msgType:" + arrayOfShort[i]);
        }
        i += 1;
      }
      localToServiceMsg.extraData.putLongArray("accostFromUin", paramArrayList);
      localToServiceMsg.extraData.putLongArray("accostToUin", arrayOfLong);
      localToServiceMsg.extraData.putLongArray("accostMsgId", (long[])localObject);
      localToServiceMsg.extraData.putShortArray("accostMsgType", arrayOfShort);
    }
    send(localToServiceMsg);
  }
  
  public boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("MessageSvc.GetMsgV4");
      this.allowCmdSet.add("MessageSvc.PbGetMsg");
      this.allowCmdSet.add("MessageSvc.PbBindUinGetMsg");
      this.allowCmdSet.add("PbMessageSvc.PbBindUinMsgReadedConfirm");
      this.allowCmdSet.add("OidbSvc.0x5d0_1");
      this.allowCmdSet.add("MessageSvc.DelMsgV2");
      this.allowCmdSet.add("TransService.ReqOffFilePack");
      this.allowCmdSet.add("MessageSvc.PushNotify");
      this.allowCmdSet.add("MessageSvc.SetRoamMsgAllUser");
      this.allowCmdSet.add("MessageSvc.DelRoamMsg");
      this.allowCmdSet.add("PbMessageSvc.PbMsgReadedReport");
      this.allowCmdSet.add("ADMsgSvc.PushMsg");
      this.allowCmdSet.add("VideoSvc.Send");
      this.allowCmdSet.add("VideoCCSvc.Adaptation");
      this.allowCmdSet.add("SharpSvr.c2sack");
      this.allowCmdSet.add("SharpSvr.s2c");
      this.allowCmdSet.add("MultiVideo.c2sack");
      this.allowCmdSet.add("MultiVideo.s2c");
      this.allowCmdSet.add("OnlinePush.RespPush");
      this.allowCmdSet.add("OnlinePush.ReqPush");
      this.allowCmdSet.add("MessageSvc.PushReaded");
      this.allowCmdSet.add("TransService.ReqTmpChatPicDownload");
      this.allowCmdSet.add("TransService.ReqGetSign");
      this.allowCmdSet.add("OnlinePush.PbPushTransMsg");
      this.allowCmdSet.add("MessageSvc.PbSendMsg");
      this.allowCmdSet.add("OidbSvc.0xa89");
      this.allowCmdSet.add("MessageSvc.PbMultiMsgSend");
      this.allowCmdSet.add("SecSvcBlessingHelper.blessing_helper");
      this.allowCmdSet.add("StreamSvr.RespUploadStreamMsg");
      this.allowCmdSet.add("StreamSvr.PushStreamMsg");
      this.allowCmdSet.add("AccostSvc.ClientMsg");
      this.allowCmdSet.add("AccostSvc.SvrMsg");
      this.allowCmdSet.add("AccostSvc.ReqInsertBlackList");
      this.allowCmdSet.add("OidbSvc.0x9db");
      this.allowCmdSet.add("AccostSvc.ReqGetBlackList");
      this.allowCmdSet.add("OidbSvc.0x4ff_42024");
      this.allowCmdSet.add("AccostSvc.ReqDeleteBlackList");
      this.allowCmdSet.add("MessageSvc.PbGetDiscussMsg");
      this.allowCmdSet.add("MessageSvc.PbGetGroupMsg");
      this.allowCmdSet.add("MessageSvc.PullGroupMsgSeq");
      this.allowCmdSet.add("PbMessageSvc.PbUnReadMsgSeq");
      this.allowCmdSet.add("MessageSvc.RequestPushStatus");
      this.allowCmdSet.add("OnlinePush.PbPushGroupMsg");
      this.allowCmdSet.add("OnlinePush.PbPushBindUinGroupMsg");
      this.allowCmdSet.add("OnlinePush.PbPushDisMsg");
      this.allowCmdSet.add("OnlinePush.PbPushC2CMsg");
      this.allowCmdSet.add("OnlinePush.PbC2CMsgSync");
      this.allowCmdSet.add("RegPrxySvc.PbGetMsg");
      this.allowCmdSet.add("RegPrxySvc.GetMsgV2");
      this.allowCmdSet.add("RegPrxySvc.PullGroupMsgSeq");
      this.allowCmdSet.add("RegPrxySvc.PullDisMsgSeq");
      this.allowCmdSet.add("RegPrxySvc.PullDisGroupSeq");
      this.allowCmdSet.add("RegPrxySvc.NoticeEnd");
      this.allowCmdSet.add("RegPrxySvc.PbGetGroupMsg");
      this.allowCmdSet.add("RegPrxySvc.PbGetDiscussMsg");
      this.allowCmdSet.add("RegPrxySvc.getOffMsg");
      this.allowCmdSet.add("RegPrxySvc.infoLogin");
      this.allowCmdSet.add("RegPrxySvc.infoSync");
      this.allowCmdSet.add("RegPrxySvc.PbSyncMsg");
      this.allowCmdSet.add("StatSvc.SvcReqMSFLoginNotify");
      this.allowCmdSet.add("MessageSvc.PbGetRoamMsg");
      this.allowCmdSet.add("MessageSvc.PbGetOneDayRoamMsg");
      this.allowCmdSet.add("PbMessageSvc.PbSearchRoamMsgInCloud");
      this.allowCmdSet.add("PbMessageSvc.PbDelOneRoamMsg");
      this.allowCmdSet.add("PbMessageSvc.PbMsgWithDraw");
      this.allowCmdSet.add("ProfileService.Pb.ReqSystemMsgRead");
      this.allowCmdSet.add("ProfileService.Pb.ReqSystemMsgAction");
      this.allowCmdSet.add("NearFieldTranFileSvr.NotifyList");
      this.allowCmdSet.add("ProfileService.Pb.ReqSystemMsgNew");
      this.allowCmdSet.add("ProfileService.Pb.ReqSystemMsgNew.Friend");
      this.allowCmdSet.add("ProfileService.Pb.ReqSystemMsgNew.Group");
      this.allowCmdSet.add("OidbSvc.0x5cf_0");
      this.allowCmdSet.add("OidbSvc.0x5cf_1");
      this.allowCmdSet.add("OidbSvc.0x5eb_42073");
      this.allowCmdSet.add("OidbSvc.0x4ff_42073");
      this.allowCmdSet.add("MessageSvc.PbReceiptRead");
      this.allowCmdSet.add("OidbSvc.0xb31");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<<---handleError serviceCmd:" + paramFromServiceMsg.getServiceCmd());
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (acrg.af().containsKey(str)) {
      d(str, paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      do
      {
        return;
        if (("MessageSvc.PbGetMsg".equalsIgnoreCase(str)) || ("RegPrxySvc.PbGetMsg".equalsIgnoreCase(str)))
        {
          if ("RegPrxySvc.PbGetMsg".equalsIgnoreCase(str)) {
            bIk = true;
          }
          O(paramToServiceMsg);
          return;
        }
        if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(str))
        {
          Y(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("TransService.ReqGetSign".equalsIgnoreCase(str))
        {
          X(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("MessageSvc.PbSendMsg".equalsIgnoreCase(str))
        {
          ad(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("OidbSvc.0xa89".equalsIgnoreCase(str))
        {
          aq(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("AccostSvc.ClientMsg".equalsIgnoreCase(str))
        {
          ab(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("PbMessageSvc.PbMsgReadedReport".equalsIgnoreCase(str))
        {
          ao(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ((!"MessageSvc.PullGroupMsgSeq".equalsIgnoreCase(str)) && (!"PbMessageSvc.PbUnReadMsgSeq".equalsIgnoreCase(str))) {
          break;
        }
      } while ((paramToServiceMsg == null) || (paramToServiceMsg.extraData == null));
      if ("getThirdQQUnreadNum".equals(paramToServiceMsg.extraData.getString("action")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<<---handleError - get thirdqq unread number");
        }
        a().aE(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      aj(paramToServiceMsg, paramFromServiceMsg);
      return;
      if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(str))
      {
        ag(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(str))
      {
        ai(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (("RegPrxySvc.infoLogin".equalsIgnoreCase(str)) || ("RegPrxySvc.getOffMsg".equalsIgnoreCase(str)))
      {
        h(paramFromServiceMsg, null);
        return;
      }
      if ("RegPrxySvc.infoSync".equalsIgnoreCase(str))
      {
        fa(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("MessageSvc.PbReceiptRead".equalsIgnoreCase(str))
      {
        ar(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (!"StreamSvr.UploadStreamMsg".equals(str));
    short s = paramToServiceMsg.extraData.getShort("PackSeq");
    notifyUI(3011, false, new Object[] { new anbd.c(paramToServiceMsg.extraData.getString("filepath"), s, paramToServiceMsg.extraData.getShort("flowLayer"), null, 0) });
  }
  
  public void o(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg.setNeedRemindSlowNetwork(true);
    sendPbReq(paramToServiceMsg);
  }
  
  public Class<? extends acci> observerClass()
  {
    return achq.class;
  }
  
  public void onDestroy()
  {
    this.app.removeObserver(this.jdField_l_of_type_Acfd);
    this.isDestroyed = true;
    cKe();
    cKa();
    this.jdField_a_of_type_Anaz.cmT();
    aqge.bVz();
    this.aB.clear();
    cKo();
    synchronized (this.iS)
    {
      Iterator localIterator = this.iS.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() != null) {
          ((SendMessageHandler)localEntry.getValue()).een();
        }
      }
    }
    this.iS.clear();
    if ((this.em != null) && (this.em.isOpen())) {
      this.em.close();
    }
    ((acqs)a("disc_processor")).onDestory();
    this.jn.clear();
    ThreadManager.post(new MessageHandler.11(this), 8, null, false);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    long l1 = System.currentTimeMillis();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(128);
      ((StringBuilder)localObject).append("onReceive success ssoSeq:").append(paramToServiceMsg.getRequestSsoSeq()).append(" serviceCmd: ").append(str).append(", resultCode:").append(paramFromServiceMsg.getResultCode());
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    if ("OidbSvc.0x4ff_42073".equals(str)) {
      fe(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    label142:
    do
    {
      break label142;
      break label142;
      while (msgCmdFilter(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "cmdfilter error=" + str);
        }
        return;
        if ("OidbSvc.0x5eb_42073".equals(str)) {
          fd(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      }
      if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
      {
        v(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        n(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (this.isDestroyed);
    if (acrg.af().containsKey(str)) {
      a(str, paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.MessageHandler", 2, "handle [cmd]=" + str + " , cost =" + (l2 - l1));
      return;
      if ("RegPrxySvc.PullGroupMsgSeq".equalsIgnoreCase(str))
      {
        l2 = System.currentTimeMillis();
        a(paramToServiceMsg, paramFromServiceMsg, (SvcResponsePullGroupMsgSeq)paramObject);
        MsgAutoMonitorUtil.getInstance().addProxySeqTime_Grp(System.currentTimeMillis() - l2);
      }
      else if ("RegPrxySvc.PullDisMsgSeq".equalsIgnoreCase(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, (SvcResponsePullDisMsgSeq)paramObject);
      }
      else if ("RegPrxySvc.PullDisGroupSeq".equalsIgnoreCase(str))
      {
        l2 = System.currentTimeMillis();
        a(paramToServiceMsg, paramFromServiceMsg, (SvcResponsePullDisGroupSeq)paramObject);
        MsgAutoMonitorUtil.getInstance().addProxySeqTime_Dis(System.currentTimeMillis() - l2);
      }
      else if ("RegPrxySvc.NoticeEnd".equalsIgnoreCase(str))
      {
        eU(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.PbGetMsg".equalsIgnoreCase(str))
      {
        eS(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.PbGetGroupMsg".equalsIgnoreCase(str))
      {
        eT(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.PbGetDiscussMsg".equalsIgnoreCase(str))
      {
        eW(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.infoLogin".equalsIgnoreCase(str))
      {
        h(paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.getOffMsg".equalsIgnoreCase(str))
      {
        h(paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.infoSync".equalsIgnoreCase(str))
      {
        fa(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.PbSyncMsg".equalsIgnoreCase(str))
      {
        fb(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      else if ("MessageSvc.PbGetMsg".equalsIgnoreCase(str))
      {
        try
        {
          if (this.app.a.abU()) {
            break label627;
          }
          eS(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
        catch (Exception paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.MessageHandler", 2, "handleGetC2CMessageResp_PB exception ! ", paramFromServiceMsg);
          }
          O(paramToServiceMsg);
        }
        continue;
        label627:
        a("c2c_processor").f(1002, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
      }
      else if (!"MessageSvc.DelMsgV2".equalsIgnoreCase(str))
      {
        if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(str))
        {
          if (paramObject == null) {
            Y(paramToServiceMsg, paramFromServiceMsg);
          } else {
            a(paramToServiceMsg, 3012, true, new Object[] { paramObject });
          }
        }
        else
        {
          boolean bool1;
          if ("MessageSvc.PushNotify".equalsIgnoreCase(str))
          {
            boolean bool2 = false;
            bool1 = false;
            localObject = null;
            paramToServiceMsg = null;
            RequestPushNotify localRequestPushNotify;
            if ((paramObject instanceof RequestPushNotify))
            {
              localRequestPushNotify = (RequestPushNotify)paramObject;
              this.app.cxj = localRequestPushNotify.wUserActive;
              if ((localRequestPushNotify.wGeneralFlag & 0x8) == 8)
              {
                bool2 = true;
                localObject = Long.toString(localRequestPushNotify.lBindedUin);
                paramToServiceMsg = (ToServiceMsg)localObject;
                bool1 = bool2;
                if ((localRequestPushNotify.wGeneralFlag & 0x10) == 16)
                {
                  this.app.a().a().a(localRequestPushNotify);
                  bool1 = bool2;
                  paramToServiceMsg = (ToServiceMsg)localObject;
                }
              }
              if (localRequestPushNotify.ping_flag == 1L) {
                D(localRequestPushNotify.lUin, localRequestPushNotify.svrip, paramFromServiceMsg.getRequestSsoSeq());
              }
              if ((localRequestPushNotify.wGeneralFlag & 0x20) != 32) {
                break label1036;
              }
              aqel.setMute(true);
              label874:
              localObject = paramToServiceMsg;
              bool2 = bool1;
              if (QLog.isColorLevel()) {
                if (!bool1) {
                  break label1043;
                }
              }
            }
            label1036:
            label1043:
            for (localObject = "SUB_ACCOUNT";; localObject = "Q.msg.MessageHandler")
            {
              QLog.d((String)localObject, 2, String.format("MessageSvc.PushNotify, notify.wUserActive: %d isSubAccount: %s, cmd: %s, wGeneralFlag:%d, bytesServerBuf: %s, ping_flag%d", new Object[] { Integer.valueOf(localRequestPushNotify.wUserActive), Boolean.valueOf(bool1), localRequestPushNotify.strCmd, Integer.valueOf(localRequestPushNotify.wGeneralFlag), localRequestPushNotify.bytes_server_buf, Long.valueOf(localRequestPushNotify.ping_flag) }));
              bool2 = bool1;
              localObject = paramToServiceMsg;
              if (!bool2) {
                break label1051;
              }
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "subaccount push and start get subaccount msg, subUin=" + (String)localObject);
              }
              if (localObject == null) {
                break;
              }
              anxk.d(this.app, (String)localObject, true);
              break;
              aqel.setMute(false);
              break label874;
            }
            label1051:
            if (this.app.a.abS()) {
              f(paramFromServiceMsg, paramObject);
            }
          }
          else if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(str))
          {
            a(paramToServiceMsg, paramFromServiceMsg, (SvcResponseSetRoamMsg)paramObject);
          }
          else if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(str))
          {
            a(paramToServiceMsg, paramFromServiceMsg, (SvcResponseDelRoamMsg)paramObject);
          }
          else if ("PbMessageSvc.PbMsgReadedReport".equalsIgnoreCase(str))
          {
            fc(paramToServiceMsg, paramFromServiceMsg, paramObject);
          }
          else if ("ADMsgSvc.PushMsg".equalsIgnoreCase(str))
          {
            a(paramToServiceMsg, paramFromServiceMsg, (AdMsgInfo)paramObject);
          }
          else if ("MessageSvc.PushReaded".equalsIgnoreCase(str))
          {
            a(paramToServiceMsg, paramFromServiceMsg, (SvcRequestPushReadedNotify)paramObject);
          }
          else if ("TransService.ReqGetSign".equalsIgnoreCase(str))
          {
            a(paramToServiceMsg, paramFromServiceMsg, (anbd.b)paramObject);
          }
          else if ("StreamSvr.RespUploadStreamMsg".equalsIgnoreCase(str))
          {
            if (paramObject == null) {
              notifyUI(3011, false, null);
            } else {
              notifyUI(3011, true, new Object[] { (anbd.c)paramObject });
            }
          }
          else if ("MessageSvc.PbSendMsg".equalsIgnoreCase(str))
          {
            eJ(paramToServiceMsg, paramFromServiceMsg, paramObject);
          }
          else if ("OidbSvc.0xa89".equalsIgnoreCase(str))
          {
            ff(paramToServiceMsg, paramFromServiceMsg, paramObject);
          }
          else if ("StreamSvr.PushStreamMsg".equalsIgnoreCase(str))
          {
            if (paramObject != null)
            {
              paramObject = (Object[])paramObject;
              l2 = ((Long)paramObject[0]).longValue();
              paramToServiceMsg = (StreamInfo)paramObject[1];
              paramFromServiceMsg = (StreamData)paramObject[2];
              long l3 = ((Long)paramObject[3]).longValue();
              long l4 = ((Long)paramObject[4]).longValue();
              long l5 = ((Long)paramObject[5]).longValue();
              paramObject = new ptt_reserve.ReserveStruct();
              if ((paramToServiceMsg != null) && (paramToServiceMsg.vPbData != null)) {}
              try
              {
                paramObject.mergeFrom(paramToServiceMsg.vPbData);
                if (paramToServiceMsg == null) {
                  continue;
                }
                this.app.a().a(paramToServiceMsg, paramFromServiceMsg, l2, l3, l4, l5, paramObject);
              }
              catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
              {
                for (;;)
                {
                  QLog.e("Q.msg.MessageHandler", 1, "parse streaminfo.vPbData failed.", localInvalidProtocolBufferMicroException);
                }
              }
            }
          }
          else if ("AccostSvc.ClientMsg".equalsIgnoreCase(str))
          {
            eM(paramToServiceMsg, paramFromServiceMsg, paramObject);
          }
          else if ("AccostSvc.ReqGetBlackList".equalsIgnoreCase(str))
          {
            eK(paramToServiceMsg, paramFromServiceMsg, paramObject);
          }
          else if ("OnlinePush.PbPushTransMsg".equalsIgnoreCase(str))
          {
            eL(paramToServiceMsg, paramFromServiceMsg, paramObject);
          }
          else
          {
            if ("AccostSvc.ReqInsertBlackList".equals(paramFromServiceMsg.getServiceCmd()))
            {
              paramToServiceMsg = paramToServiceMsg.extraData.getString("insertUin");
              if (paramFromServiceMsg.getResultCode() == 1000) {
                DO(paramToServiceMsg);
              }
              if (paramFromServiceMsg.getResultCode() == 1000) {}
              for (bool1 = true;; bool1 = false)
              {
                notifyUI(6001, bool1, paramToServiceMsg);
                break;
              }
            }
            if ("OidbSvc.0x9db".equals(paramFromServiceMsg.getServiceCmd()))
            {
              eO(paramToServiceMsg, paramFromServiceMsg, paramObject);
            }
            else
            {
              int i;
              if ("AccostSvc.ReqDeleteBlackList".equals(paramFromServiceMsg.getServiceCmd()))
              {
                paramObject = paramToServiceMsg.extraData.getString("deleteUin");
                i = paramToServiceMsg.extraData.getInt("fromType");
                if (paramFromServiceMsg.getResultCode() == 1000) {
                  DP(paramObject);
                }
                if (paramFromServiceMsg.getResultCode() == 1000) {}
                for (bool1 = true;; bool1 = false)
                {
                  notifyUI(6002, bool1, new Object[] { paramObject, Integer.valueOf(i) });
                  break;
                }
              }
              if ("OidbSvc.0x4ff_42024".equals(paramFromServiceMsg.getServiceCmd()))
              {
                eP(paramToServiceMsg, paramFromServiceMsg, paramObject);
              }
              else if (("MessageSvc.PullGroupMsgSeq".equalsIgnoreCase(str)) || ("PbMessageSvc.PbUnReadMsgSeq".equalsIgnoreCase(str)))
              {
                if ((paramToServiceMsg != null) && (paramToServiceMsg.extraData != null)) {
                  if ("getThirdQQUnreadNum".equals(paramToServiceMsg.extraData.getString("action")))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "<<---handle response - get thirdqq unread number");
                    }
                    try
                    {
                      a().iq(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    }
                    catch (Exception paramObject)
                    {
                      paramObject.printStackTrace();
                      if (QLog.isColorLevel()) {
                        QLog.w("Q.msg.MessageHandler", 2, "handle response - get thirdqq unread number exception ! ", paramObject);
                      }
                      a().aE(paramToServiceMsg, paramFromServiceMsg);
                    }
                  }
                  else
                  {
                    try
                    {
                      if (!isPbReq(paramToServiceMsg)) {
                        break label1901;
                      }
                      eY(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    }
                    catch (Exception paramObject)
                    {
                      paramObject.printStackTrace();
                      if (QLog.isColorLevel()) {
                        QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp exception ! ", paramObject);
                      }
                      aj(paramToServiceMsg, paramFromServiceMsg);
                    }
                    continue;
                    label1901:
                    b(paramToServiceMsg, paramFromServiceMsg, (SvcResponsePullGroupMsgSeq)paramObject);
                  }
                }
              }
              else if ("MessageSvc.PbGetGroupMsg".equalsIgnoreCase(str))
              {
                if (paramToServiceMsg.extraData.getBoolean("key_from_parallel_pull", false)) {
                  ThreadManager.post(new MessageHandler.8(this, paramToServiceMsg, paramFromServiceMsg, paramObject), 8, null, false);
                } else {
                  try
                  {
                    a(paramToServiceMsg, paramFromServiceMsg, paramObject, false);
                  }
                  catch (Exception paramObject)
                  {
                    paramObject.printStackTrace();
                    if (QLog.isColorLevel()) {
                      QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgResp_PB exception ! ", paramObject);
                    }
                    al(paramToServiceMsg, paramFromServiceMsg);
                  }
                }
              }
              else if ("MessageSvc.PbGetDiscussMsg".equalsIgnoreCase(str))
              {
                try
                {
                  eR(paramToServiceMsg, paramFromServiceMsg, paramObject);
                }
                catch (Exception paramObject)
                {
                  paramObject.printStackTrace();
                  if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgResp_PB exception ! ", paramObject);
                  }
                  an(paramToServiceMsg, paramFromServiceMsg);
                }
              }
              else if ("MessageSvc.RequestPushStatus".equalsIgnoreCase(str))
              {
                eZ(paramToServiceMsg, paramFromServiceMsg, paramObject);
              }
              else if ("StatSvc.SvcReqMSFLoginNotify".equalsIgnoreCase(str))
              {
                paramToServiceMsg = (SvcReqMSFLoginNotify)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcReqMSFLoginNotify", new SvcReqMSFLoginNotify());
                if (paramToServiceMsg != null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "SvcReqMSFLoginNotify status:" + paramToServiceMsg.cStatus + "iPlatform:" + paramToServiceMsg.iPlatform);
                  }
                  paramFromServiceMsg = (ackv)this.app.getBusinessHandler(10);
                  int k = 0;
                  int n = 0;
                  i = 0;
                  if ((paramToServiceMsg.iPlatform == 110L) && (paramToServiceMsg.cTablet == 1)) {
                    if (paramToServiceMsg.cStatus == 1)
                    {
                      i = 1;
                      if (QLog.isDevelopLevel()) {
                        QLog.d("Q.msg.MessageHandler", 4, "ipad online now");
                      }
                      cKd();
                      label2233:
                      paramFromServiceMsg.JH(i);
                      if (first == 1) {
                        first = 1;
                      }
                      label2250:
                      if (!((rwp)this.app.getManager(335)).w(paramToServiceMsg.vecInstanceList)) {
                        break label2509;
                      }
                    }
                  }
                  label2507:
                  label2509:
                  for (i = 1;; i = 0)
                  {
                    notifyUI(6016, true, new Object[] { Byte.valueOf((byte)i) });
                    break;
                    if (paramToServiceMsg.cStatus != 2) {
                      break label2233;
                    }
                    i = 0;
                    if (QLog.isDevelopLevel()) {
                      QLog.d("Q.msg.MessageHandler", 4, "ipad offline now");
                    }
                    Jq(1);
                    break label2233;
                    if (paramToServiceMsg.iPlatform == 1029L)
                    {
                      if (paramToServiceMsg.cStatus == 1) {
                        i = 1;
                      }
                      for (;;)
                      {
                        if (!QLog.isColorLevel()) {
                          break label2420;
                        }
                        QLog.d("Q.msg.MessageHandler", 2, "mac online push status:" + i + ",cDataline:" + 1);
                        break;
                        i = k;
                        if (paramToServiceMsg.cStatus == 2) {
                          i = 0;
                        }
                      }
                      label2420:
                      break label2250;
                    }
                    if (paramToServiceMsg.iClientType != 78082L) {
                      break label2250;
                    }
                    if (paramToServiceMsg.cStatus == 1) {
                      i = 1;
                    }
                    for (;;)
                    {
                      if (!QLog.isColorLevel()) {
                        break label2507;
                      }
                      QLog.d("Q.msg.MessageHandler", 2, "watch online push status:" + i + ",cDataline:" + 1);
                      break;
                      i = n;
                      if (paramToServiceMsg.cStatus == 2) {
                        i = 0;
                      }
                    }
                    break label2250;
                  }
                }
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "RequestPushStatus ret, but data is null");
                }
              }
              else if (("OnlinePush.PbPushGroupMsg".equalsIgnoreCase(str)) || ("OnlinePush.PbPushDisMsg".equalsIgnoreCase(str)) || ("OnlinePush.PbC2CMsgSync".equalsIgnoreCase(str)) || ("OnlinePush.PbPushC2CMsg".equalsIgnoreCase(str)) || ("OnlinePush.PbPushBindUinGroupMsg".equalsIgnoreCase(str)))
              {
                try
                {
                  g(paramFromServiceMsg, paramObject);
                }
                catch (Exception paramToServiceMsg) {}
                if (QLog.isColorLevel()) {
                  QLog.w("Q.msg.MessageHandler", 2, "handleMessagePush_PB exception ! ", paramToServiceMsg);
                }
              }
              else
              {
                if ("MultiVideo.s2c".equalsIgnoreCase(str))
                {
                  if (!VideoConstants.Ov) {
                    continue;
                  }
                  paramToServiceMsg = (MultiVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
                  if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.MessageHandler", 2, String.format("onReceive multi video msg s2c, type=0x%X csCmd=0x%X", new Object[] { Byte.valueOf(paramToServiceMsg.type), Short.valueOf(paramToServiceMsg.csCmd) }));
                  }
                  if (paramToServiceMsg.type >= 32) {
                    break;
                  }
                  this.app.a().aA(paramToServiceMsg.video_buff);
                  if (paramToServiceMsg.type == 10) {
                    continue;
                  }
                  paramFromServiceMsg = createToServiceMsg("MultiVideo.s2cack");
                  paramFromServiceMsg.extraData.putByte("ver", paramToServiceMsg.ver);
                  paramFromServiceMsg.extraData.putByte("type", paramToServiceMsg.type);
                  paramFromServiceMsg.extraData.putShort("cscmd", paramToServiceMsg.csCmd);
                  paramFromServiceMsg.extraData.putShort("subcmd", paramToServiceMsg.subCmd);
                  paramFromServiceMsg.extraData.putLong("from_uin", paramToServiceMsg.from_uin);
                  paramFromServiceMsg.extraData.putLong("to_uin", ((Long)paramToServiceMsg.to_uin.get(0)).longValue());
                  paramFromServiceMsg.extraData.putLong("msg_seq", paramToServiceMsg.msg_seq);
                  paramFromServiceMsg.extraData.putLong("msg_uid", paramToServiceMsg.msg_uid);
                  paramFromServiceMsg.extraData.putLong("msg_type", paramToServiceMsg.msg_type);
                  paramFromServiceMsg.extraData.putLong("msg_time", paramToServiceMsg.msg_time);
                  paramFromServiceMsg.extraData.putByteArray("video_buff", paramToServiceMsg.video_buff);
                  paramFromServiceMsg.extraData.putLong("msg_dataflag", paramToServiceMsg.msg_dataflag);
                  send(paramFromServiceMsg);
                  continue;
                }
                if ("MultiVideo.c2sack".equalsIgnoreCase(str))
                {
                  if (!VideoConstants.Ov) {
                    continue;
                  }
                  paramToServiceMsg = (MultiVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, String.format("onReceive multi video msg c2sack, type=0x%X csCmd=0x%X", new Object[] { Byte.valueOf(paramToServiceMsg.type), Short.valueOf(paramToServiceMsg.csCmd) }));
                  }
                  if (paramToServiceMsg.type >= 32) {
                    break;
                  }
                  this.app.a().aB(paramToServiceMsg.video_buff);
                  continue;
                }
                if ("NearFieldTranFileSvr.NotifyList".equalsIgnoreCase(str)) {
                  this.app.a().C((byte[])paramObject);
                } else if ("MessageSvc.PbReceiptRead".equalsIgnoreCase(str)) {
                  fg(paramToServiceMsg, paramFromServiceMsg, paramObject);
                } else if ("OidbSvc.0xb31".equalsIgnoreCase(str)) {
                  fh(paramToServiceMsg, paramFromServiceMsg, paramObject);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void x(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION".equals(paramContext)) || ("com.tencent.mobileqq.IPADONLINE_CLICK_NOTIFICATION".equals(paramContext)))
    {
      paramContext = QQNotificationManager.getInstance();
      paramContext.cancel("Q.msg.MessageHandler_onReceivePCONLINE_CLICK_NOTIFICATION", 264);
      this.bIt = false;
      if (this.jdField_l_of_type_JavaLangThread != null) {
        this.jdField_l_of_type_JavaLangThread.interrupt();
      }
      paramContext.cancel("Q.msg.MessageHandler_onReceivePCONLINE_CLICK_NOTIFICATION", 263);
      this.bIu = false;
      if (this.m != null) {
        this.m.interrupt();
      }
      paramContext = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningTasks(1);
      if ((paramContext != null) && (!paramContext.isEmpty()))
      {
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity;
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.msg.MessageHandler", 4, "PConline BroadcastReceiver clicked " + paramContext.getClassName());
        }
        if (!paramContext.getClassName().equals(LoginInfoActivity.class.getName()))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.msg.MessageHandler", 4, "PConline BroadcastReceiver clicked startActivity" + LoginInfoActivity.class.getName());
          }
          paramContext = new Intent(BaseApplication.getContext(), LoginInfoActivity.class);
          paramContext.addFlags(268435456);
          BaseApplication.getContext().startActivity(paramContext);
          anot.a(this.app, "CliOper", "", "", "My_eq", "PC_Online_notice", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  class MessageHandleThread
    extends Thread
  {
    public volatile boolean bIx;
    public boolean isRunning = true;
    ArrayList<MessageHandler.c> tn;
    
    public MessageHandleThread()
    {
      Object localObject;
      this.tn = localObject;
    }
    
    public boolean aaP()
    {
      return this.bIx;
    }
    
    public void close()
    {
      this.isRunning = false;
      synchronized (this.tn)
      {
        this.tn.notifyAll();
        return;
      }
    }
    
    public boolean pP()
    {
      return !this.isRunning;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   3: ifeq +31 -> 34
      //   6: ldc 50
      //   8: iconst_2
      //   9: new 52	java/lang/StringBuilder
      //   12: dup
      //   13: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   16: ldc 55
      //   18: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   21: aload_0
      //   22: invokevirtual 63	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:getName	()Ljava/lang/String;
      //   25: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   28: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   31: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   34: iconst_0
      //   35: istore_1
      //   36: aload_0
      //   37: getfield 24	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:isRunning	Z
      //   40: ifeq +1267 -> 1307
      //   43: iload_1
      //   44: iconst_2
      //   45: if_icmplt +13 -> 58
      //   48: aload_0
      //   49: getfield 26	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:tn	Ljava/util/ArrayList;
      //   52: invokevirtual 76	java/util/ArrayList:size	()I
      //   55: ifle +1252 -> 1307
      //   58: ldc 78
      //   60: invokestatic 84	auvk:traceBegin	(Ljava/lang/String;)V
      //   63: iload_1
      //   64: istore_2
      //   65: aload_0
      //   66: getfield 26	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:tn	Ljava/util/ArrayList;
      //   69: astore 12
      //   71: iload_1
      //   72: istore_2
      //   73: aload 12
      //   75: monitorenter
      //   76: iload_1
      //   77: istore_2
      //   78: aload_0
      //   79: getfield 26	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:tn	Ljava/util/ArrayList;
      //   82: invokevirtual 76	java/util/ArrayList:size	()I
      //   85: ifle +579 -> 664
      //   88: iload_1
      //   89: istore_2
      //   90: aload_0
      //   91: getfield 26	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:tn	Ljava/util/ArrayList;
      //   94: iconst_0
      //   95: invokevirtual 88	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   98: checkcast 90	com/tencent/mobileqq/app/MessageHandler$c
      //   101: astore 11
      //   103: iconst_0
      //   104: istore_1
      //   105: aload 12
      //   107: monitorexit
      //   108: aload_0
      //   109: iconst_1
      //   110: putfield 33	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:bIx	Z
      //   113: aload 11
      //   115: ifnull +204 -> 319
      //   118: lconst_0
      //   119: lstore 4
      //   121: iconst_0
      //   122: istore_3
      //   123: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   126: ifeq +81 -> 207
      //   129: invokestatic 96	java/lang/System:currentTimeMillis	()J
      //   132: lstore 6
      //   134: aload 11
      //   136: getfield 100	com/tencent/mobileqq/app/MessageHandler$c:data	Ljava/lang/Object;
      //   139: ifnull +605 -> 744
      //   142: aload 11
      //   144: getfield 100	com/tencent/mobileqq/app/MessageHandler$c:data	Ljava/lang/Object;
      //   147: invokevirtual 103	java/lang/Object:hashCode	()I
      //   150: istore_2
      //   151: iload_2
      //   152: istore_3
      //   153: lload 6
      //   155: lstore 4
      //   157: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   160: ifeq +47 -> 207
      //   163: ldc 50
      //   165: iconst_2
      //   166: new 52	java/lang/StringBuilder
      //   169: dup
      //   170: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   173: ldc 105
      //   175: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   178: aload 11
      //   180: getfield 109	com/tencent/mobileqq/app/MessageHandler$c:type	I
      //   183: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   186: ldc 114
      //   188: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   191: iload_2
      //   192: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   195: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   198: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   201: lload 6
      //   203: lstore 4
      //   205: iload_2
      //   206: istore_3
      //   207: aload 11
      //   209: getfield 109	com/tencent/mobileqq/app/MessageHandler$c:type	I
      //   212: tableswitch	default:+1140 -> 1352, 1:+537->749, 2:+583->795, 3:+616->828, 4:+641->853, 5:+852->1064
      //   249: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   252: getfield 118	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
      //   255: getfield 124	com/tencent/mobileqq/app/QQAppInterface:a	Lcom/tencent/mobileqq/app/automator/Automator;
      //   258: invokevirtual 129	com/tencent/mobileqq/app/automator/Automator:cNs	()V
      //   261: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   264: ifeq +55 -> 319
      //   267: ldc 50
      //   269: iconst_2
      //   270: new 52	java/lang/StringBuilder
      //   273: dup
      //   274: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   277: ldc 131
      //   279: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   282: aload 11
      //   284: getfield 109	com/tencent/mobileqq/app/MessageHandler$c:type	I
      //   287: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   290: ldc 114
      //   292: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   295: iload_3
      //   296: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   299: ldc 133
      //   301: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   304: invokestatic 96	java/lang/System:currentTimeMillis	()J
      //   307: lload 4
      //   309: lsub
      //   310: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   313: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   316: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   319: aload_0
      //   320: iconst_0
      //   321: putfield 33	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:bIx	Z
      //   324: aload_0
      //   325: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   328: invokestatic 139	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Landroid/util/Pair;
      //   331: ifnull +223 -> 554
      //   334: aload_0
      //   335: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   338: invokestatic 142	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Z
      //   341: ifeq +213 -> 554
      //   344: aload_0
      //   345: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   348: invokestatic 145	com/tencent/mobileqq/app/MessageHandler:b	(Lcom/tencent/mobileqq/app/MessageHandler;)Z
      //   351: ifeq +203 -> 554
      //   354: aload_0
      //   355: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   358: invokestatic 148	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Ljava/util/concurrent/atomic/AtomicBoolean;
      //   361: astore 11
      //   363: aload 11
      //   365: monitorenter
      //   366: aload_0
      //   367: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   370: invokestatic 139	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Landroid/util/Pair;
      //   373: ifnull +178 -> 551
      //   376: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   379: ifeq +11 -> 390
      //   382: ldc 50
      //   384: iconst_2
      //   385: ldc 150
      //   387: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   390: iconst_2
      //   391: anewarray 152	java/lang/Long
      //   394: astore 12
      //   396: aload 12
      //   398: iconst_0
      //   399: aload_0
      //   400: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   403: invokestatic 139	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Landroid/util/Pair;
      //   406: getfield 157	android/util/Pair:first	Ljava/lang/Object;
      //   409: checkcast 159	RegisterProxySvcPack/RegisterPushNotice
      //   412: getfield 163	RegisterProxySvcPack/RegisterPushNotice:ulTimeOutFlag	J
      //   415: invokestatic 167	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   418: aastore
      //   419: aload 12
      //   421: iconst_1
      //   422: aload_0
      //   423: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   426: invokestatic 139	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Landroid/util/Pair;
      //   429: getfield 170	android/util/Pair:second	Ljava/lang/Object;
      //   432: checkcast 152	java/lang/Long
      //   435: aastore
      //   436: aload_0
      //   437: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   440: invokestatic 139	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Landroid/util/Pair;
      //   443: getfield 157	android/util/Pair:first	Ljava/lang/Object;
      //   446: checkcast 159	RegisterProxySvcPack/RegisterPushNotice
      //   449: getfield 173	RegisterProxySvcPack/RegisterPushNotice:uFlag	J
      //   452: lconst_1
      //   453: land
      //   454: lconst_1
      //   455: lcmp
      //   456: ifne +829 -> 1285
      //   459: iconst_1
      //   460: istore 10
      //   462: aload_0
      //   463: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   466: aconst_null
      //   467: invokestatic 176	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;Landroid/util/Pair;)Landroid/util/Pair;
      //   470: pop
      //   471: aload 12
      //   473: iconst_1
      //   474: aaload
      //   475: invokevirtual 179	java/lang/Long:longValue	()J
      //   478: lconst_1
      //   479: lcmp
      //   480: ifeq +29 -> 509
      //   483: aload_0
      //   484: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   487: getfield 182	com/tencent/mobileqq/app/MessageHandler:a	Lanaz;
      //   490: invokevirtual 187	anaz:awv	()Z
      //   493: ifeq +16 -> 509
      //   496: aload_0
      //   497: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   500: getfield 182	com/tencent/mobileqq/app/MessageHandler:a	Lanaz;
      //   503: invokevirtual 190	anaz:awu	()Z
      //   506: ifne +24 -> 530
      //   509: aload_0
      //   510: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   513: invokevirtual 193	com/tencent/mobileqq/app/MessageHandler:cKl	()V
      //   516: aload_0
      //   517: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   520: sipush 4013
      //   523: iload 10
      //   525: aload 12
      //   527: invokevirtual 197	com/tencent/mobileqq/app/MessageHandler:notifyUI	(IZLjava/lang/Object;)V
      //   530: aload_0
      //   531: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   534: invokestatic 148	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Ljava/util/concurrent/atomic/AtomicBoolean;
      //   537: iconst_1
      //   538: invokevirtual 203	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   541: aload_0
      //   542: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   545: invokestatic 148	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Ljava/util/concurrent/atomic/AtomicBoolean;
      //   548: invokevirtual 39	java/lang/Object:notifyAll	()V
      //   551: aload 11
      //   553: monitorexit
      //   554: aload_0
      //   555: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   558: invokestatic 206	com/tencent/mobileqq/app/MessageHandler:c	(Lcom/tencent/mobileqq/app/MessageHandler;)Z
      //   561: ifeq +15 -> 576
      //   564: aload_0
      //   565: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   568: sipush 4017
      //   571: iconst_1
      //   572: aconst_null
      //   573: invokevirtual 197	com/tencent/mobileqq/app/MessageHandler:notifyUI	(IZLjava/lang/Object;)V
      //   576: aload_0
      //   577: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   580: getfield 209	com/tencent/mobileqq/app/MessageHandler:bIo	Z
      //   583: ifeq +72 -> 655
      //   586: aload_0
      //   587: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   590: invokestatic 142	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Z
      //   593: ifeq +62 -> 655
      //   596: aload_0
      //   597: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   600: invokestatic 145	com/tencent/mobileqq/app/MessageHandler:b	(Lcom/tencent/mobileqq/app/MessageHandler;)Z
      //   603: ifeq +52 -> 655
      //   606: aload_0
      //   607: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   610: invokestatic 148	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Ljava/util/concurrent/atomic/AtomicBoolean;
      //   613: astore 11
      //   615: aload 11
      //   617: monitorenter
      //   618: aload_0
      //   619: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   622: invokestatic 148	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Ljava/util/concurrent/atomic/AtomicBoolean;
      //   625: invokevirtual 212	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   628: ifne +24 -> 652
      //   631: aload_0
      //   632: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   635: invokestatic 148	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Ljava/util/concurrent/atomic/AtomicBoolean;
      //   638: iconst_1
      //   639: invokevirtual 203	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   642: aload_0
      //   643: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   646: invokestatic 148	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Ljava/util/concurrent/atomic/AtomicBoolean;
      //   649: invokevirtual 39	java/lang/Object:notifyAll	()V
      //   652: aload 11
      //   654: monitorexit
      //   655: invokestatic 215	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:yield	()V
      //   658: invokestatic 218	auvk:traceEnd	()V
      //   661: goto -625 -> 36
      //   664: iload_1
      //   665: istore_2
      //   666: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   669: ifeq +33 -> 702
      //   672: iload_1
      //   673: istore_2
      //   674: ldc 50
      //   676: iconst_2
      //   677: new 52	java/lang/StringBuilder
      //   680: dup
      //   681: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   684: ldc 220
      //   686: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   689: aload_0
      //   690: invokevirtual 63	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:getName	()Ljava/lang/String;
      //   693: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   696: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   699: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   702: iload_1
      //   703: istore_2
      //   704: aload_0
      //   705: getfield 26	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:tn	Ljava/util/ArrayList;
      //   708: ldc2_w 221
      //   711: invokevirtual 226	java/lang/Object:wait	(J)V
      //   714: iload_1
      //   715: iconst_1
      //   716: iadd
      //   717: istore_1
      //   718: aconst_null
      //   719: astore 11
      //   721: goto -616 -> 105
      //   724: iload_1
      //   725: istore_2
      //   726: aload 12
      //   728: monitorexit
      //   729: iload_1
      //   730: istore_2
      //   731: aload 11
      //   733: athrow
      //   734: astore 11
      //   736: iload_2
      //   737: istore_1
      //   738: invokestatic 218	auvk:traceEnd	()V
      //   741: goto -80 -> 661
      //   744: iconst_0
      //   745: istore_2
      //   746: goto -595 -> 151
      //   749: aload_0
      //   750: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   753: ldc 228
      //   755: invokevirtual 231	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;)Ltnv;
      //   758: sipush 1002
      //   761: iconst_3
      //   762: anewarray 36	java/lang/Object
      //   765: dup
      //   766: iconst_0
      //   767: aload 11
      //   769: getfield 235	com/tencent/mobileqq/app/MessageHandler$c:h	Lcom/tencent/qphone/base/remote/ToServiceMsg;
      //   772: aastore
      //   773: dup
      //   774: iconst_1
      //   775: aload 11
      //   777: getfield 239	com/tencent/mobileqq/app/MessageHandler$c:g	Lcom/tencent/qphone/base/remote/FromServiceMsg;
      //   780: aastore
      //   781: dup
      //   782: iconst_2
      //   783: aload 11
      //   785: getfield 100	com/tencent/mobileqq/app/MessageHandler$c:data	Ljava/lang/Object;
      //   788: aastore
      //   789: invokevirtual 245	tnv:f	(I[Ljava/lang/Object;)V
      //   792: goto -544 -> 248
      //   795: aload_0
      //   796: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   799: aload 11
      //   801: getfield 235	com/tencent/mobileqq/app/MessageHandler$c:h	Lcom/tencent/qphone/base/remote/ToServiceMsg;
      //   804: aload 11
      //   806: getfield 239	com/tencent/mobileqq/app/MessageHandler$c:g	Lcom/tencent/qphone/base/remote/FromServiceMsg;
      //   809: aload 11
      //   811: getfield 100	com/tencent/mobileqq/app/MessageHandler$c:data	Ljava/lang/Object;
      //   814: invokestatic 248	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)V
      //   817: goto -569 -> 248
      //   820: astore 11
      //   822: invokestatic 218	auvk:traceEnd	()V
      //   825: aload 11
      //   827: athrow
      //   828: aload_0
      //   829: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   832: aload 11
      //   834: getfield 235	com/tencent/mobileqq/app/MessageHandler$c:h	Lcom/tencent/qphone/base/remote/ToServiceMsg;
      //   837: aload 11
      //   839: getfield 239	com/tencent/mobileqq/app/MessageHandler$c:g	Lcom/tencent/qphone/base/remote/FromServiceMsg;
      //   842: aload 11
      //   844: getfield 100	com/tencent/mobileqq/app/MessageHandler$c:data	Ljava/lang/Object;
      //   847: invokestatic 250	com/tencent/mobileqq/app/MessageHandler:b	(Lcom/tencent/mobileqq/app/MessageHandler;Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)V
      //   850: goto -602 -> 248
      //   853: aload 11
      //   855: getfield 100	com/tencent/mobileqq/app/MessageHandler$c:data	Ljava/lang/Object;
      //   858: ifnull +96 -> 954
      //   861: aload 11
      //   863: getfield 100	com/tencent/mobileqq/app/MessageHandler$c:data	Ljava/lang/Object;
      //   866: instanceof 252
      //   869: ifeq +85 -> 954
      //   872: aload 11
      //   874: getfield 100	com/tencent/mobileqq/app/MessageHandler$c:data	Ljava/lang/Object;
      //   877: checkcast 252	MessageSvcPack/GroupInfo
      //   880: astore 12
      //   882: aload_0
      //   883: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   886: getfield 118	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
      //   889: invokevirtual 255	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
      //   892: astore 13
      //   894: aload 12
      //   896: getfield 258	MessageSvcPack/GroupInfo:lGroupCode	J
      //   899: lstore 6
      //   901: aload 12
      //   903: getfield 261	MessageSvcPack/GroupInfo:lMemberSeq	J
      //   906: lstore 8
      //   908: aload_0
      //   909: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   912: getfield 118	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
      //   915: invokevirtual 264	com/tencent/mobileqq/app/QQAppInterface:a	()Lanaz;
      //   918: aload 12
      //   920: getfield 258	MessageSvcPack/GroupInfo:lGroupCode	J
      //   923: invokestatic 269	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   926: invokevirtual 273	anaz:eb	(Ljava/lang/String;)I
      //   929: iconst_2
      //   930: if_icmpne +437 -> 1367
      //   933: iconst_1
      //   934: istore 10
      //   936: aload 13
      //   938: lload 6
      //   940: invokestatic 269	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   943: iconst_1
      //   944: lload 8
      //   946: iload 10
      //   948: invokevirtual 278	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJZ)V
      //   951: goto -703 -> 248
      //   954: aload 11
      //   956: getfield 100	com/tencent/mobileqq/app/MessageHandler$c:data	Ljava/lang/Object;
      //   959: ifnull -711 -> 248
      //   962: aload 11
      //   964: getfield 100	com/tencent/mobileqq/app/MessageHandler$c:data	Ljava/lang/Object;
      //   967: instanceof 280
      //   970: ifeq -722 -> 248
      //   973: aload 11
      //   975: getfield 100	com/tencent/mobileqq/app/MessageHandler$c:data	Ljava/lang/Object;
      //   978: checkcast 280	msf/registerproxy/register_proxy$GroupList
      //   981: astore 12
      //   983: aload_0
      //   984: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   987: getfield 118	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
      //   990: invokevirtual 255	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
      //   993: astore 13
      //   995: aload 12
      //   997: getfield 284	msf/registerproxy/register_proxy$GroupList:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
      //   1000: invokevirtual 288	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
      //   1003: lstore 6
      //   1005: aload 12
      //   1007: getfield 291	msf/registerproxy/register_proxy$GroupList:member_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
      //   1010: invokevirtual 288	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
      //   1013: lstore 8
      //   1015: aload_0
      //   1016: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   1019: getfield 118	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
      //   1022: invokevirtual 264	com/tencent/mobileqq/app/QQAppInterface:a	()Lanaz;
      //   1025: aload 12
      //   1027: getfield 284	msf/registerproxy/register_proxy$GroupList:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
      //   1030: invokevirtual 288	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
      //   1033: invokestatic 269	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   1036: invokevirtual 273	anaz:eb	(Ljava/lang/String;)I
      //   1039: iconst_2
      //   1040: if_icmpne +333 -> 1373
      //   1043: iconst_1
      //   1044: istore 10
      //   1046: aload 13
      //   1048: lload 6
      //   1050: invokestatic 269	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   1053: iconst_1
      //   1054: lload 8
      //   1056: iload 10
      //   1058: invokevirtual 278	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJZ)V
      //   1061: goto -813 -> 248
      //   1064: aload 11
      //   1066: getfield 100	com/tencent/mobileqq/app/MessageHandler$c:data	Ljava/lang/Object;
      //   1069: ifnull +98 -> 1167
      //   1072: aload 11
      //   1074: getfield 100	com/tencent/mobileqq/app/MessageHandler$c:data	Ljava/lang/Object;
      //   1077: instanceof 293
      //   1080: ifeq +87 -> 1167
      //   1083: aload 11
      //   1085: getfield 100	com/tencent/mobileqq/app/MessageHandler$c:data	Ljava/lang/Object;
      //   1088: checkcast 293	MessageSvcPack/stConfNumInfo
      //   1091: astore 12
      //   1093: aload_0
      //   1094: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   1097: getfield 118	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
      //   1100: invokevirtual 255	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
      //   1103: astore 13
      //   1105: aload 12
      //   1107: getfield 296	MessageSvcPack/stConfNumInfo:lConfUin	J
      //   1110: lstore 6
      //   1112: aload 12
      //   1114: getfield 299	MessageSvcPack/stConfNumInfo:uMemberMsgSeq	J
      //   1117: lstore 8
      //   1119: aload_0
      //   1120: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   1123: getfield 118	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
      //   1126: invokevirtual 264	com/tencent/mobileqq/app/QQAppInterface:a	()Lanaz;
      //   1129: aload 12
      //   1131: getfield 296	MessageSvcPack/stConfNumInfo:lConfUin	J
      //   1134: invokestatic 269	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   1137: invokevirtual 302	anaz:ec	(Ljava/lang/String;)I
      //   1140: iconst_2
      //   1141: if_icmpne +238 -> 1379
      //   1144: iconst_1
      //   1145: istore 10
      //   1147: aload 13
      //   1149: lload 6
      //   1151: invokestatic 269	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   1154: sipush 3000
      //   1157: lload 8
      //   1159: iload 10
      //   1161: invokevirtual 278	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJZ)V
      //   1164: goto -916 -> 248
      //   1167: aload 11
      //   1169: getfield 100	com/tencent/mobileqq/app/MessageHandler$c:data	Ljava/lang/Object;
      //   1172: ifnull -924 -> 248
      //   1175: aload 11
      //   1177: getfield 100	com/tencent/mobileqq/app/MessageHandler$c:data	Ljava/lang/Object;
      //   1180: instanceof 304
      //   1183: ifeq -935 -> 248
      //   1186: aload 11
      //   1188: getfield 100	com/tencent/mobileqq/app/MessageHandler$c:data	Ljava/lang/Object;
      //   1191: checkcast 304	msf/registerproxy/register_proxy$DiscussList
      //   1194: astore 12
      //   1196: aload_0
      //   1197: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   1200: getfield 118	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
      //   1203: invokevirtual 255	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
      //   1206: astore 13
      //   1208: aload 12
      //   1210: getfield 307	msf/registerproxy/register_proxy$DiscussList:discuss_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
      //   1213: invokevirtual 288	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
      //   1216: lstore 6
      //   1218: aload 12
      //   1220: getfield 308	msf/registerproxy/register_proxy$DiscussList:member_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
      //   1223: invokevirtual 288	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
      //   1226: lstore 8
      //   1228: aload_0
      //   1229: getfield 19	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
      //   1232: getfield 118	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
      //   1235: invokevirtual 264	com/tencent/mobileqq/app/QQAppInterface:a	()Lanaz;
      //   1238: aload 12
      //   1240: getfield 307	msf/registerproxy/register_proxy$DiscussList:discuss_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
      //   1243: invokevirtual 288	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
      //   1246: invokestatic 269	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   1249: invokevirtual 302	anaz:ec	(Ljava/lang/String;)I
      //   1252: iconst_2
      //   1253: if_icmpne +26 -> 1279
      //   1256: iconst_1
      //   1257: istore 10
      //   1259: aload 13
      //   1261: lload 6
      //   1263: invokestatic 269	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   1266: sipush 3000
      //   1269: lload 8
      //   1271: iload 10
      //   1273: invokevirtual 278	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJZ)V
      //   1276: goto -1028 -> 248
      //   1279: iconst_0
      //   1280: istore 10
      //   1282: goto -23 -> 1259
      //   1285: iconst_0
      //   1286: istore 10
      //   1288: goto -826 -> 462
      //   1291: astore 12
      //   1293: aload 11
      //   1295: monitorexit
      //   1296: aload 12
      //   1298: athrow
      //   1299: astore 12
      //   1301: aload 11
      //   1303: monitorexit
      //   1304: aload 12
      //   1306: athrow
      //   1307: aload_0
      //   1308: invokevirtual 310	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:close	()V
      //   1311: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1314: ifeq +32 -> 1346
      //   1317: ldc 50
      //   1319: iconst_2
      //   1320: new 52	java/lang/StringBuilder
      //   1323: dup
      //   1324: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   1327: ldc_w 312
      //   1330: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1333: aload_0
      //   1334: invokevirtual 63	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:getName	()Ljava/lang/String;
      //   1337: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1340: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1343: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1346: return
      //   1347: astore 11
      //   1349: goto -625 -> 724
      //   1352: goto -1104 -> 248
      //   1355: astore 11
      //   1357: iload_2
      //   1358: istore_1
      //   1359: goto -635 -> 724
      //   1362: astore 11
      //   1364: goto -626 -> 738
      //   1367: iconst_0
      //   1368: istore 10
      //   1370: goto -434 -> 936
      //   1373: iconst_0
      //   1374: istore 10
      //   1376: goto -330 -> 1046
      //   1379: iconst_0
      //   1380: istore 10
      //   1382: goto -235 -> 1147
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1385	0	this	MessageHandleThread
      //   35	1324	1	i	int
      //   64	1294	2	j	int
      //   122	174	3	k	int
      //   119	189	4	l1	long
      //   132	1130	6	l2	long
      //   906	364	8	l3	long
      //   460	921	10	bool	boolean
      //   734	76	11	localException1	Exception
      //   820	482	11	localObject2	Object
      //   1347	1	11	localObject3	Object
      //   1355	1	11	localObject4	Object
      //   1362	1	11	localException2	Exception
      //   69	1170	12	localObject5	Object
      //   1291	6	12	localObject6	Object
      //   1299	6	12	localObject7	Object
      //   892	368	13	localQQMessageFacade	QQMessageFacade
      // Exception table:
      //   from	to	target	type
      //   65	71	734	java/lang/Exception
      //   73	76	734	java/lang/Exception
      //   731	734	734	java/lang/Exception
      //   65	71	820	finally
      //   73	76	820	finally
      //   108	113	820	finally
      //   123	151	820	finally
      //   157	201	820	finally
      //   207	248	820	finally
      //   248	319	820	finally
      //   319	366	820	finally
      //   554	576	820	finally
      //   576	618	820	finally
      //   655	658	820	finally
      //   731	734	820	finally
      //   749	792	820	finally
      //   795	817	820	finally
      //   828	850	820	finally
      //   853	933	820	finally
      //   936	951	820	finally
      //   954	1043	820	finally
      //   1046	1061	820	finally
      //   1064	1144	820	finally
      //   1147	1164	820	finally
      //   1167	1256	820	finally
      //   1259	1276	820	finally
      //   1296	1299	820	finally
      //   1304	1307	820	finally
      //   366	390	1291	finally
      //   390	459	1291	finally
      //   462	509	1291	finally
      //   509	530	1291	finally
      //   530	551	1291	finally
      //   551	554	1291	finally
      //   1293	1296	1291	finally
      //   618	652	1299	finally
      //   652	655	1299	finally
      //   1301	1304	1299	finally
      //   105	108	1347	finally
      //   78	88	1355	finally
      //   90	103	1355	finally
      //   666	672	1355	finally
      //   674	702	1355	finally
      //   704	714	1355	finally
      //   726	729	1355	finally
      //   108	113	1362	java/lang/Exception
      //   123	151	1362	java/lang/Exception
      //   157	201	1362	java/lang/Exception
      //   207	248	1362	java/lang/Exception
      //   248	319	1362	java/lang/Exception
      //   319	366	1362	java/lang/Exception
      //   554	576	1362	java/lang/Exception
      //   576	618	1362	java/lang/Exception
      //   655	658	1362	java/lang/Exception
      //   749	792	1362	java/lang/Exception
      //   795	817	1362	java/lang/Exception
      //   828	850	1362	java/lang/Exception
      //   853	933	1362	java/lang/Exception
      //   936	951	1362	java/lang/Exception
      //   954	1043	1362	java/lang/Exception
      //   1046	1061	1362	java/lang/Exception
      //   1064	1144	1362	java/lang/Exception
      //   1147	1164	1362	java/lang/Exception
      //   1167	1256	1362	java/lang/Exception
      //   1259	1276	1362	java/lang/Exception
      //   1296	1299	1362	java/lang/Exception
      //   1304	1307	1362	java/lang/Exception
    }
  }
  
  static class a
  {
    short W;
    long fromUin;
    int msgTime;
  }
  
  public static class b
  {
    public long Qp;
    public long Qq;
    public String boC;
    public int cwU;
    public String mobile;
    public int sourceId;
    public long time;
    public String uin;
  }
  
  static class c
  {
    public Object data;
    public FromServiceMsg g;
    public ToServiceMsg h;
    public boolean isFirstMsg;
    public int type;
    
    public c(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
    {
      this.type = paramInt;
      this.h = paramToServiceMsg;
      this.g = paramFromServiceMsg;
      this.data = paramObject;
    }
    
    public c(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, boolean paramBoolean)
    {
      this.type = paramInt;
      this.h = paramToServiceMsg;
      this.g = paramFromServiceMsg;
      this.data = paramObject;
      this.isFirstMsg = paramBoolean;
    }
  }
  
  public static class d
  {
    public long Qr;
    public long Qs;
    public long Qt;
    public long Qu;
    public long Qv;
    public boolean bIA;
    public boolean bIy;
    public boolean bIz;
    public String boD;
    public int mUinType;
  }
  
  class e
    extends Handler
  {
    private HashSet<String> aT = new HashSet();
    private List<Message> xH = new ArrayList();
    
    public e(Looper paramLooper)
    {
      super();
    }
    
    void A(String paramString, int paramInt, long paramLong)
    {
      synchronized (this.aT)
      {
        if (this.aT.contains(top.u(paramString, paramInt) + "&" + paramLong)) {
          this.aT.remove(top.u(paramString, paramInt) + "&" + paramLong);
        }
        return;
      }
    }
    
    void aM(Message paramMessage)
    {
      synchronized (this.aT)
      {
        paramMessage = paramMessage.getData();
        if ((paramMessage != null) && (paramMessage.containsKey("update_unread_uin")) && (paramMessage.containsKey("update_unread_time")))
        {
          String str = paramMessage.getString("update_unread_uin");
          int i = paramMessage.getInt("update_unread_type", 0);
          long l = paramMessage.getLong("update_unread_time");
          this.aT.add(top.u(str, i) + "&" + l);
        }
        return;
      }
    }
    
    void aN(Message paramMessage)
    {
      synchronized (this.xH)
      {
        this.xH.add(paramMessage);
        return;
      }
    }
    
    void cKu()
    {
      synchronized (this.xH)
      {
        if (this.xH.size() <= 0) {
          break label69;
        }
        Iterator localIterator = this.xH.iterator();
        if (localIterator.hasNext()) {
          sendMessage((Message)localIterator.next());
        }
      }
      this.xH.clear();
      label69:
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "updateUnreadWorker doC2CUpdateNow");
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
      case 1: 
        do
        {
          return;
          paramMessage = paramMessage.getData();
        } while ((paramMessage == null) || (!paramMessage.containsKey("update_unread_uin")) || (!paramMessage.containsKey("update_unread_time")));
        String str = paramMessage.getString("update_unread_uin");
        int i = paramMessage.getInt("update_unread_type", 0);
        long l = paramMessage.getLong("update_unread_time");
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "msg update_c2c_unread-->uin:" + str + ", uinType:" + i + ", lastReadTime:" + l);
        }
        A(str, i, l);
        MessageHandler.this.app.b().s(str, i, l);
        MessageHandler.this.f(2002, true, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "updateUnreadWorker C2CWorkerTimeout");
      }
      cKu();
    }
    
    boolean o(Message paramMessage)
    {
      synchronized (this.aT)
      {
        paramMessage = paramMessage.getData();
        if ((paramMessage != null) && (paramMessage.containsKey("update_unread_uin")) && (paramMessage.containsKey("update_unread_time")))
        {
          String str = paramMessage.getString("update_unread_uin");
          int i = paramMessage.getInt("update_unread_type", 0);
          long l = paramMessage.getLong("update_unread_time");
          boolean bool = this.aT.contains(top.u(str, i) + "&" + l);
          return bool;
        }
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler
 * JD-Core Version:    0.7.0.1
 */