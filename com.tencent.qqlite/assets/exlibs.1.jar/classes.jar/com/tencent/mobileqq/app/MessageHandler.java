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
import PushAdMsg.AdMsgInfo;
import PushNotifyPack.C2CMsgReadedNotify;
import PushNotifyPack.DisMsgReadedNotify;
import PushNotifyPack.GroupMsgReadedNotify;
import PushNotifyPack.RequestPushNotify;
import PushNotifyPack.SvcRequestPushReadedNotify;
import QQService.DiscussInfo;
import QQService.StreamData;
import QQService.StreamInfo;
import QQService.SvcRespRegister;
import RegisterProxySvcPack.RegisterPushNotice;
import RegisterProxySvcPack.SvcRequestPullDisGroupSeq;
import RegisterProxySvcPack.SvcResponsePullDisGroupSeq;
import RegisterProxySvcPack.stDisGroupInfo;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.AccostMessageProcessor;
import com.tencent.mobileqq.app.message.AccostMessageProcessor.DelAccostMsg;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.app.message.BaseMessageProcessor;
import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.app.message.DiscMessageProcessor;
import com.tencent.mobileqq.app.message.FileSlaveMasterMessageProcessor;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.app.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.message.ProcessorDispatcher;
import com.tencent.mobileqq.app.message.ProcessorDispatcherInterface;
import com.tencent.mobileqq.app.message.ProcessorObserver;
import com.tencent.mobileqq.app.message.ProfileCardMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.config.ADParser;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.FunnyFaceMessage;
import com.tencent.mobileqq.data.FunnyFaceMessage.Turntable;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.config.ConfigUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCache.MsgSendingInfo;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.SigStruct;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.data.TroopMessageProcessor;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.msf.service.protocol.pb.SubMsgType0x51.MsgBody;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.pb.onlinepush.OnlinePushTrans.PbMsgInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import ctn;
import cto;
import ctp;
import ctq;
import ctr;
import cts;
import ctt;
import ctu;
import ctv;
import ctx;
import cty;
import cua;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.AccountManager;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import msf.msgsvc.msg_svc.PbC2CReadedReportResp;
import msf.msgsvc.msg_svc.PbDelRoamMsgReq;
import msf.msgsvc.msg_svc.PbDelRoamMsgReq.C2CMsg;
import msf.msgsvc.msg_svc.PbDelRoamMsgReq.DisMsg;
import msf.msgsvc.msg_svc.PbDelRoamMsgReq.GrpMsg;
import msf.msgsvc.msg_svc.PbDelRoamMsgResp;
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
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.PbSendMsgResp;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import msf.registerproxy.register_proxy.SvcPbResponsePullDisMsgProxy;
import msf.registerproxy.register_proxy.SvcResponsePbPullGroupMsgProxy;
import org.json.JSONArray;
import org.json.JSONObject;
import protocol.KQQConfig.GetResourceReqInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.FanpaiziNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MsgBody;

public class MessageHandler
  extends BusinessHandler
  implements ProcessorDispatcherInterface, ProcessorObserver
{
  public static final int A = 1002;
  public static final int B = 1003;
  public static final int C = 1004;
  public static final int D = 1005;
  public static final int E = 2000;
  public static final int F = 2001;
  public static final int G = 2002;
  public static final int H = 3001;
  public static final int I = 3002;
  public static final int J = 3003;
  public static final int K = 3004;
  public static final int L = 3005;
  public static final int M = 3100;
  public static final int N = 3006;
  public static final int O = 3007;
  public static final int P = 3008;
  public static final int Q = 3009;
  public static final int R = 3010;
  public static final int S = 3011;
  public static final int T = 3012;
  public static final int U = 4001;
  public static final int V = 4002;
  public static final int W = 4003;
  public static final int X = 4004;
  public static final int Y = 4005;
  public static final int Z = 4006;
  public static final byte a = 1;
  public static final int a = 9;
  public static final long a = 4294967295L;
  public static final String a = "Q.msg.MessageHandler";
  public static boolean a = false;
  public static final int aA = 6012;
  public static final int aB = 6013;
  public static final int aC = 7000;
  public static final int aD = 7001;
  public static final int aE = 8000;
  public static final int aF = 8001;
  public static final int aG = 8002;
  public static final int aH = 8003;
  public static final int aI = 8004;
  public static final int aJ = 8005;
  public static final int aK = 8006;
  public static final int aL = 8007;
  public static final int aM = 8008;
  public static final int aN = 8010;
  public static final int aO = 8011;
  public static final int aP = 8012;
  public static final int aQ = 60;
  public static final int aR = 1000;
  public static final int aS = 1001;
  public static final int aT = 1002;
  public static final int aU = 1003;
  public static final int aV = 1004;
  public static final int aW = 1005;
  public static final int aX = 1006;
  public static final int aY = 1007;
  public static final int aZ = 1008;
  public static final int aa = 4011;
  public static final int ab = 4012;
  public static final int ac = 4013;
  public static final int ad = 5001;
  public static final int ae = 5002;
  public static final int af = 5003;
  public static final int ag = 5004;
  public static final int ah = 5005;
  public static final int ai = 5006;
  public static final int aj = 5007;
  public static final int ak = 5008;
  public static final int al = 5009;
  public static final int am = 5010;
  public static final int an = 5011;
  public static final int ao = 5012;
  public static final int ap = 6000;
  public static final int aq = 6001;
  public static final int ar = 6002;
  public static final int as = 6003;
  public static final int at = 6004;
  public static final int au = 6005;
  public static final int av = 6006;
  public static final int aw = 6007;
  public static final int ax = 6008;
  public static final int ay = 6009;
  public static final int az = 6010;
  public static final byte b = 3;
  public static final int b = 8;
  public static final long b = 30000L;
  public static final String b = "RichNotify";
  public static final int bA = -1;
  public static final int bB = 1;
  public static final int bC = 2;
  public static int bE = 10103;
  public static final int bF = 1080;
  private static final int bI = 6;
  private static final int bR = 604800;
  private static final int bS = 360000;
  public static final int ba = 1009;
  public static final int bb = 1010;
  public static final int bc = 1011;
  public static final int bd = 1012;
  public static final int be = 1013;
  public static final int bf = 1014;
  public static final int bg = 1015;
  public static final int bh = 1016;
  public static final int bi = 1020;
  public static final int bj = 1017;
  public static final int bk = 1018;
  public static final int bl = 1019;
  public static final int bm = 1021;
  public static final int bn = 1022;
  public static final int bo = 1023;
  public static final int bp = 1024;
  public static final int bq = 1025;
  public static final int br = 1026;
  public static final int bs = 1027;
  public static final int bt = 1028;
  public static final int bu = 1029;
  public static final int bv = 1030;
  public static final int bw = 1031;
  public static final int bx = 1034;
  public static final int by = 480;
  public static final int bz = 480000;
  public static final byte c = 0;
  public static final int c = 166;
  private static final long jdField_c_of_type_Long = 180000L;
  public static final String c = "update_unread_uin";
  public static boolean c = false;
  private static final byte jdField_d_of_type_Byte = 2;
  public static final int d = 169;
  public static final String d = "update_unread_type";
  public static final int e = 193;
  public static final String e = "update_unread_time";
  public static final int f = 734;
  public static final String f = "com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION";
  public static final int g = 519;
  public static final int h = 127;
  public static final int i = 230;
  public static final int j = 42;
  public static final int k = 83;
  public static final int l = 524;
  public static final int m = 528;
  public static final int n = 529;
  public static final int o = 736;
  public static final int p = 526;
  public static final int q = 141;
  public static final int r = 529;
  public static final int s = 132;
  private static String s = MessageHandler.class.getSimpleName();
  public static final int t = 732;
  public static final int u = 207;
  public static final int v = 528;
  public static final int w = 44;
  public static final int x = 34;
  public static final int y = 999;
  public static final int z = 1000;
  private volatile Pair jdField_a_of_type_AndroidUtilPair = null;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cts(this);
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
  public MessageCache a;
  cua jdField_a_of_type_Cua;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Thread jdField_a_of_type_JavaLangThread = null;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public final HashMap a;
  private final HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private Map jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private ctx[] jdField_a_of_type_ArrayOfCtx = null;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private ArrayList jdField_b_of_type_JavaUtilArrayList = null;
  private final HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  public boolean b;
  private String[] jdField_b_of_type_ArrayOfJavaLangString = null;
  public int bD;
  private int bG = 0;
  private int bH = 0;
  private final int bJ = 450000;
  private final int bK = 9;
  private final int bL = 3;
  private int bM = 0;
  private final int bN = 2;
  private int bO = 0;
  private final int bP = 3;
  private final int bQ = 6;
  private final int bT = 12;
  private final int bU = 6;
  private final int bV = 1080000;
  private Object jdField_c_of_type_JavaLangObject = new Object();
  private ArrayList jdField_c_of_type_JavaUtilArrayList = null;
  private ArrayList jdField_d_of_type_JavaUtilArrayList = null;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e;
  private boolean f = false;
  private boolean g = false;
  private final String t = "Q.msg.MessageHandler";
  private final String u = "Q.msg.MessageHandler";
  private final String v = "Q.msg.MessageHandler";
  private final String w = "Q.msg.MessageHandler";
  private final String x = "Q.msg.MessageHandler";
  private final String y = "Q.msg.MessageHandler";
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_c_of_type_Boolean = true;
  }
  
  MessageHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache = paramQQAppInterface.a();
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences("QQLite", 0);
    AppSetting.l = paramQQAppInterface.getBoolean(AppSetting.o, true);
    AppSetting.n = paramQQAppInterface.getBoolean("c2c_del_msg_oper_enable", true);
  }
  
  public static int a(int paramInt)
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
    }
    return 8010;
  }
  
  private Pair a(String paramString, int paramInt)
  {
    long l1;
    long l2;
    long l3;
    Object localObject;
    if (paramInt == 3000)
    {
      l1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.g(paramString);
      l2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c(paramString);
      l3 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString, paramInt);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder(128);
        ((StringBuilder)localObject).append("guessPullMsgStartSeq uin = ").append(paramString).append(" ,type = ").append(paramInt).append(" ,lastSeq = ").append(l1).append(" ,expiredSeq = ").append(l2).append(" ,delSeq = ").append(l3);
        QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
      }
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
      localObject = MsgProxyUtils.a(localList, false);
      l2 = Math.max(l3, l2);
      if (!MsgProxyUtils.a(paramString, paramInt, (List)localObject)) {
        break label756;
      }
      paramString = MsgProxyUtils.a(localList, false, 25);
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
          l1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString);
          l2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramString);
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
        return new Pair(Long.valueOf(Math.max(l1 - paramInt, l2)), Long.valueOf(Math.max(l3 - 1L, l2)));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "return lastSeq < lastLocalSeq");
      }
      return new Pair(Long.valueOf(l1), Long.valueOf(l1));
      label756:
      paramString = (String)localObject;
    }
  }
  
  private Pair a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "getPullMsgLowSeq uin = " + paramString + " ,type = " + paramInt + " ,lastSeq = " + paramLong1 + " ,expiredSeq = " + paramLong2 + " ,delSeq = " + paramLong3 + " ,svrSeq = " + paramLong4);
    }
    paramString = MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt), false);
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
  
  private cua a()
  {
    if (this.jdField_a_of_type_Cua == null) {
      this.jdField_a_of_type_Cua = new cua(this, ThreadManager.b());
    }
    return this.jdField_a_of_type_Cua;
  }
  
  public static String a(FromServiceMsg paramFromServiceMsg)
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
  
  private void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg arg3, Object paramObject)
  {
    g();
    paramToServiceMsg = new cty(paramInt, paramToServiceMsg, ???, paramObject);
    if (paramInt == 1) {
      synchronized (this.jdField_d_of_type_JavaUtilArrayList)
      {
        this.jdField_d_of_type_JavaUtilArrayList.add(paramToServiceMsg);
        this.jdField_d_of_type_JavaUtilArrayList.notify();
        return;
      }
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      this.jdField_c_of_type_JavaUtilArrayList.add(paramToServiceMsg);
      this.jdField_c_of_type_JavaUtilArrayList.notify();
      return;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.equals(""))) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    long l1 = System.currentTimeMillis() / 1000L;
    ArrayList localArrayList = new ArrayList();
    MessageRecord localMessageRecord = MessageRecordFactory.a(-2013);
    localMessageRecord.init(str, paramString2, str, paramString1, l1, 0, paramInt, 0L);
    localMessageRecord.msgtype = -2013;
    localMessageRecord.isread = true;
    localArrayList.add(localMessageRecord);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList, String.valueOf(str), false);
  }
  
  private void a(MessageRecord paramMessageRecord, long paramLong1, long paramLong2, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    int i2 = paramMessageRecord.istroop;
    int i1 = MessageUtils.b(paramMessageRecord.msgUid);
    if (!MsgProxyUtils.c(paramMessageRecord.msgtype)) {
      i1 = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<DELMSG><S>--->deleteMsgFromServerInner : uinType:" + paramMessageRecord.istroop + " peerUin:" + paramMessageRecord.frienduin + " msgType:" + paramMessageRecord.msgtype + " uniseq:" + paramMessageRecord.uniseq + " reqSeq:" + paramLong1 + " msgSeq:" + paramMessageRecord.shmsgseq + " random:" + i1 + " msgTime:" + paramMessageRecord.time + " msgUid:" + paramMessageRecord.msgUid + " mr.longMsgCount:" + paramMessageRecord.longMsgCount + " longMsgIndex:" + paramMessageRecord.longMsgIndex + " longMsgId:" + paramMessageRecord.longMsgId);
    }
    ToServiceMsg localToServiceMsg = a("PbMessageSvc.PbDelOneRoamMsg");
    localToServiceMsg.extraData.putLong("timeOut", paramLong2);
    localToServiceMsg.extraData.putLong("startTime", l1);
    localToServiceMsg.extraData.putInt("retryIndex", paramInt);
    localToServiceMsg.extraData.putInt("uintype", i2);
    localToServiceMsg.extraData.putString("peeruin", paramMessageRecord.frienduin);
    localToServiceMsg.extraData.putLong("uniseq", paramMessageRecord.uniseq);
    localToServiceMsg.extraData.putLong("seq", paramMessageRecord.shmsgseq);
    localToServiceMsg.extraData.putLong("msgSeq", paramLong1);
    msg_svc.PbDelRoamMsgReq localPbDelRoamMsgReq = new msg_svc.PbDelRoamMsgReq();
    Object localObject;
    if (i2 == 0)
    {
      paramInt = (short)(int)paramMessageRecord.shmsgseq;
      localToServiceMsg.extraData.putInt("msgrandom", i1);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject = new msg_svc.PbDelRoamMsgReq.C2CMsg();
      ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject).peer_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject).from_uin.set(Long.valueOf(str).longValue());
      ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject).msg_time.set((int)paramMessageRecord.time);
      ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject).msg_seq.set(paramInt & 0xFFFFFFFF);
      ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject).msg_random.set(i1);
      localPbDelRoamMsgReq.c2c_msg.set((MessageMicro)localObject);
      if (paramMessageRecord.msgtype == -2005)
      {
        paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, 0);
        if ((paramMessageRecord != null) && (paramMessageRecord.nOLfileSessionId != 0L))
        {
          ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject).msg_time.set((int)paramMessageRecord.msgTime);
          paramInt = (short)(int)paramMessageRecord.msgSeq;
          ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject).msg_seq.set(paramInt & 0xFFFFFFFF);
          ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject).msg_random.set(MessageUtils.b(paramMessageRecord.msgUid));
        }
      }
    }
    for (;;)
    {
      localToServiceMsg.putWupBuffer(localPbDelRoamMsgReq.toByteArray());
      localToServiceMsg.setTimeout(paramLong2);
      localToServiceMsg.setEnableFastResend(true);
      c(localToServiceMsg);
      return;
      if (i2 == 1)
      {
        localObject = new msg_svc.PbDelRoamMsgReq.GrpMsg();
        ((msg_svc.PbDelRoamMsgReq.GrpMsg)localObject).group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        ((msg_svc.PbDelRoamMsgReq.GrpMsg)localObject).msg_seq.set(Long.valueOf(paramMessageRecord.shmsgseq).longValue());
        localPbDelRoamMsgReq.grp_msg.set((MessageMicro)localObject);
      }
      else if (i2 == 3000)
      {
        localObject = new msg_svc.PbDelRoamMsgReq.DisMsg();
        ((msg_svc.PbDelRoamMsgReq.DisMsg)localObject).discuss_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        ((msg_svc.PbDelRoamMsgReq.DisMsg)localObject).msg_seq.set(paramMessageRecord.shmsgseq);
        localPbDelRoamMsgReq.dis_msg.set((MessageMicro)localObject);
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, long paramLong, int paramInt, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    long l1;
    if (paramMessageRecord.msg == null)
    {
      l1 = 0L;
      paramBusinessObserver = a("MessageSvc.PbSendMsg", paramBusinessObserver);
      paramBusinessObserver.extraData.putString("uin", paramMessageRecord.frienduin);
      paramBusinessObserver.extraData.putLong("msgsize", l1);
      paramBusinessObserver.extraData.putLong("uniseq", paramMessageRecord.uniseq);
      paramBusinessObserver.extraData.putLong("timeOut", paramLong);
      paramBusinessObserver.extraData.putLong("msgSeq", paramMessageRecord.msgseq);
      paramBusinessObserver.extraData.putLong("startTime", l2);
      paramBusinessObserver.extraData.putInt("retryIndex", paramInt);
      paramBusinessObserver.extraData.putInt("uintype", paramMessageRecord.istroop);
      paramBusinessObserver.extraData.putInt("msgtype", paramMessageRecord.msgtype);
      paramBusinessObserver.extraData.putBoolean("resend_by_user", paramBoolean);
      if (paramMessageRecord.istroop != 1) {
        break label566;
      }
      paramBusinessObserver.extraData.putString("groupuin", paramMessageRecord.frienduin);
      label188:
      if (paramMessageRecord.msgtype != -2000) {
        break label594;
      }
      paramBusinessObserver.extraData.putBoolean("RichNotify", true);
      label209:
      int i1 = MessageProtoCodec.b(paramMessageRecord.istroop);
      l1 = paramMessageRecord.msgUid;
      int i2 = (short)(int)paramMessageRecord.msgseq;
      int i3 = MessageUtils.a(l1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><S> --->createSendRichTextMsgReq : mr_friendUin:" + paramMessageRecord.frienduin + " mr_senderUin:" + paramMessageRecord.senderuin + "mr_uniseq:" + paramMessageRecord.uniseq + ",msgSeq:" + paramMessageRecord.msgseq + " mr_shMsgseq:" + paramMessageRecord.shmsgseq + " uint32Seq:" + (0xFFFF & i2) + " mr_msgUid:" + paramMessageRecord.msgUid + " random:" + i3 + " routingType:" + i1 + " mr_longMsgCtn:" + paramMessageRecord.longMsgCount + " mr_longMsgSeq" + paramMessageRecord.longMsgId + " mr_longMsgIndex:" + paramMessageRecord.longMsgIndex);
      }
      paramBusinessObserver.extraData.putInt("ROUNTING_TYPE", i1);
      paramBusinessObserver.putWupBuffer(paramPbSendMsgReq.toByteArray());
      paramBusinessObserver.setTimeout(paramLong);
      paramBusinessObserver.addAttribute("msgtype", Integer.valueOf(paramMessageRecord.msgtype));
      paramBusinessObserver.addAttribute("msgSeq", Long.valueOf(paramMessageRecord.msgseq));
      paramBusinessObserver.addAttribute("resend_by_user", Boolean.valueOf(paramBoolean));
      paramBusinessObserver.addAttribute("retryIndex", Integer.valueOf(paramInt));
      if (paramMessageRecord.frienduin != null) {
        break label714;
      }
      paramPbSendMsgReq = "";
      label514:
      paramBusinessObserver.addAttribute("uin", paramPbSendMsgReq);
      if (paramMessageRecord.senderuin != null) {
        break label722;
      }
    }
    label566:
    label714:
    label722:
    for (paramMessageRecord = "";; paramMessageRecord = paramMessageRecord.senderuin)
    {
      paramBusinessObserver.addAttribute("fromUin", paramMessageRecord);
      c(paramBusinessObserver);
      return;
      l1 = paramMessageRecord.msg.getBytes().length;
      break;
      if (paramMessageRecord.istroop != 3000) {
        break label188;
      }
      paramBusinessObserver.extraData.putString("uToUin", paramMessageRecord.frienduin);
      break label188;
      label594:
      if (paramMessageRecord.msgtype == -2002)
      {
        paramBusinessObserver.extraData.putBoolean("RichNotify", true);
        break label209;
      }
      if (paramMessageRecord.msgtype == -2007)
      {
        paramBusinessObserver.extraData.putBoolean("RichNotify", true);
        break label209;
      }
      if (paramMessageRecord.msgtype == -2011)
      {
        paramBusinessObserver.extraData.putBoolean("RichNotify", true);
        break label209;
      }
      if (paramMessageRecord.msgtype == -2020)
      {
        paramBusinessObserver.extraData.putBoolean("RichNotify", true);
        break label209;
      }
      if (paramMessageRecord.msgtype != -2022) {
        break label209;
      }
      paramBusinessObserver.extraData.putBoolean("RichNotify", true);
      break label209;
      paramPbSendMsgReq = paramMessageRecord.frienduin;
      break label514;
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (SvcRespRegister)paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyCmdResp. register=" + paramObject);
    }
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      a(4004, false, null);
      return;
    }
    if ((!this.jdField_b_of_type_Boolean) || ((this.jdField_b_of_type_Boolean) && (paramObject != null) && (paramObject.cReplyCode == 0)))
    {
      a(4004, true, null);
      ((SaveTrafficHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(16)).b();
      return;
    }
    a(4004, false, null);
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
          break label84;
        }
      }
    }
    label84:
    for (paramToServiceMsg = "null";; paramToServiceMsg = Byte.valueOf(paramSvcResponseDelRoamMsg.cReplyCode))
    {
      QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg);
      d(1003, bool, null);
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
    i(paramToServiceMsg, paramFromServiceMsg, paramSvcResponsePullDisMsgSeq);
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
      d(1005, bool, null);
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
        break label173;
      }
      paramFromServiceMsg = MessageRecordFactory.a(-2003);
      paramFromServiceMsg.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramFromServiceMsg.frienduin = String.valueOf(AppConstants.aa);
      paramFromServiceMsg.senderuin = String.valueOf(AppConstants.aa);
      paramFromServiceMsg.msg = paramToServiceMsg;
      paramFromServiceMsg.time = l1;
      paramFromServiceMsg.msgtype = -2003;
      paramFromServiceMsg.istroop = 0;
      if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFromServiceMsg, false))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFromServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        a("handlePushADMessageResp", 1000, true, "0_" + String.valueOf(paramAdMsgInfo.uSrcUin), 1, true, false);
      }
    }
    label173:
    do
    {
      do
      {
        do
        {
          return;
        } while (paramAdMsgInfo.uMsgType != 513);
        int i1 = ADParser.a(paramToServiceMsg);
        paramFromServiceMsg = ADParser.b(paramToServiceMsg);
        switch (i1)
        {
        case 1: 
        case 3: 
        default: 
          return;
        }
      } while ((paramFromServiceMsg == null) || ((!paramFromServiceMsg.equals("WAP")) && (!paramFromServiceMsg.equals("WAPI")) && (!paramFromServiceMsg.equals("TMTWAP")) && (!paramFromServiceMsg.equals("TMTWAPI")) && (!paramFromServiceMsg.equals("LOCAL"))));
      paramFromServiceMsg = MessageRecordFactory.a(-2004);
      paramFromServiceMsg.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramFromServiceMsg.frienduin = String.valueOf(AppConstants.aa);
      paramFromServiceMsg.senderuin = String.valueOf(AppConstants.aa);
      paramFromServiceMsg.msg = paramToServiceMsg;
      paramFromServiceMsg.time = l1;
      paramFromServiceMsg.msgtype = -2004;
      paramFromServiceMsg.istroop = 0;
    } while (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFromServiceMsg, false));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFromServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    a("handlePushADMessageResp", 1000, true, "0_" + String.valueOf(paramAdMsgInfo.uSrcUin), 1, true, false);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRequestPushReadedNotify paramSvcRequestPushReadedNotify)
  {
    paramToServiceMsg = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handlePushReadedNotify() " + paramSvcRequestPushReadedNotify.vC2CReadedNotify + "," + paramSvcRequestPushReadedNotify.vGroupReadedNotify + "," + paramSvcRequestPushReadedNotify.vDisReadedNotify + ",vC2CReadedNotify=" + paramSvcRequestPushReadedNotify.vC2CReadedNotify + ", vGroupReadedNotify=" + paramSvcRequestPushReadedNotify.vGroupReadedNotify + ", vDisMsgReadedNotify=" + paramSvcRequestPushReadedNotify.vDisReadedNotify);
    }
    if ((paramSvcRequestPushReadedNotify.cNotifyType & 0x8) == 8) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "handlePushReadedNotify() isSubAccount=true");
      }
    }
    for (boolean bool = true;; bool = false)
    {
      Object localObject;
      if ((paramSvcRequestPushReadedNotify.vC2CReadedNotify == null) || (paramSvcRequestPushReadedNotify.vC2CReadedNotify.size() <= 0) || (bool))
      {
        if ((paramSvcRequestPushReadedNotify.vGroupReadedNotify != null) && (paramSvcRequestPushReadedNotify.vGroupReadedNotify.size() > 0))
        {
          paramToServiceMsg.addAll(paramSvcRequestPushReadedNotify.vGroupReadedNotify);
          paramFromServiceMsg = paramSvcRequestPushReadedNotify.vGroupReadedNotify.iterator();
        }
      }
      else {
        for (;;)
        {
          if (!paramFromServiceMsg.hasNext()) {
            break label459;
          }
          localObject = (GroupMsgReadedNotify)paramFromServiceMsg.next();
          String str = String.valueOf(((GroupMsgReadedNotify)localObject).lGroupCode);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str) == 1)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, (GroupMsgReadedNotify)localObject);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.msg.MessageHandler", 2, "GroupMsgReadedNotify unfinished groupUin=" + str);
            continue;
            paramToServiceMsg.addAll(paramSvcRequestPushReadedNotify.vC2CReadedNotify);
            paramFromServiceMsg = paramSvcRequestPushReadedNotify.vC2CReadedNotify.iterator();
            while (paramFromServiceMsg.hasNext())
            {
              localObject = (C2CMsgReadedNotify)paramFromServiceMsg.next();
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "C2CMsgReadedNotify curFriendUin is " + ((C2CMsgReadedNotify)localObject).lPeerUin + ", lLastReadTime  is " + ((C2CMsgReadedNotify)localObject).lLastReadTime + " isSubAccount=" + bool);
              }
              str = String.valueOf(((C2CMsgReadedNotify)localObject).lPeerUin);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 0, ((C2CMsgReadedNotify)localObject).lLastReadTime);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str, ((C2CMsgReadedNotify)localObject).lLastReadTime);
            }
            break;
          }
          ((TroopMessageProcessor)a("troop_processor")).a((GroupMsgReadedNotify)localObject);
        }
      }
      label459:
      if ((paramSvcRequestPushReadedNotify.vDisReadedNotify != null) && (paramSvcRequestPushReadedNotify.vDisReadedNotify.size() > 0))
      {
        paramToServiceMsg.addAll(paramSvcRequestPushReadedNotify.vDisReadedNotify);
        paramFromServiceMsg = paramSvcRequestPushReadedNotify.vDisReadedNotify.iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramSvcRequestPushReadedNotify = (DisMsgReadedNotify)paramFromServiceMsg.next();
          localObject = String.valueOf(paramSvcRequestPushReadedNotify.lDisUin);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject) == 1)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, paramSvcRequestPushReadedNotify);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "DisMsgReadedNotify unfinished discussionUin=" + (String)localObject);
            }
          }
          else
          {
            ((DiscMessageProcessor)a("disc_processor")).a(paramSvcRequestPushReadedNotify);
          }
        }
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0)) {
        a(6004, true, paramToServiceMsg.toArray());
      }
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponsePullDisGroupSeq paramSvcResponsePullDisGroupSeq)
  {
    SvcResponsePullDisMsgSeq localSvcResponsePullDisMsgSeq = null;
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (QLog.isColorLevel()) {
      localStringBuilder.append("registerproxy->handleMsgProxyDisGroupMsgSeq.");
    }
    if ((!paramFromServiceMsg.isSuccess()) || ((paramSvcResponsePullDisGroupSeq != null) && (paramSvcResponsePullDisGroupSeq.cReplyCode != 0)))
    {
      a(1000, false, null);
      return;
    }
    if (paramSvcResponsePullDisGroupSeq != null)
    {
      DiscussionHandler localDiscussionHandler = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
      localSvcResponsePullDisMsgSeq = new SvcResponsePullDisMsgSeq();
      localSvcResponsePullDisMsgSeq.cReplyCode = paramSvcResponsePullDisGroupSeq.cReplyCode;
      localSvcResponsePullDisMsgSeq.strResult = paramSvcResponsePullDisGroupSeq.strResult;
      if (paramSvcResponsePullDisGroupSeq.vDisInfo != null)
      {
        localSvcResponsePullDisMsgSeq.vConfNumInfo = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        if (QLog.isColorLevel()) {
          localStringBuilder.append(", size=").append(paramSvcResponsePullDisGroupSeq.vDisInfo.size());
        }
        int i1 = 0;
        if (i1 < paramSvcResponsePullDisGroupSeq.vDisInfo.size())
        {
          stDisGroupInfo localstDisGroupInfo = (stDisGroupInfo)paramSvcResponsePullDisGroupSeq.vDisInfo.get(i1);
          if (QLog.isColorLevel()) {
            localStringBuilder.append("\nlDisCode=").append(localstDisGroupInfo.lDisCode).append(", eInfoFlag=").append(localstDisGroupInfo.eInfoFlag).append(", infoSeq=").append(localstDisGroupInfo.uInfoSeq);
          }
          switch (localstDisGroupInfo.eInfoFlag)
          {
          }
          for (;;)
          {
            i1 += 1;
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
            continue;
            localDiscussionHandler.a(String.valueOf(localstDisGroupInfo.lDisCode));
          }
        }
        localDiscussionHandler.a(localArrayList);
      }
    }
    if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    i(paramToServiceMsg, paramFromServiceMsg, localSvcResponsePullDisMsgSeq);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.SigStruct paramSigStruct)
  {
    if (paramSigStruct == null) {
      a(paramToServiceMsg, paramFromServiceMsg);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramSigStruct.a, paramSigStruct.b);
    d(5002, true, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    do
    {
      return;
      paramToServiceMsg.extraData.getByte("cBodyType", (byte)-1).byteValue();
    } while (paramToServiceMsg.extraData.getInt("msgtype", -1) != -1000);
    a("actSendDiscussProcess", paramBoolean, paramToServiceMsg.extraData.getLong("msgsize", 0L), paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void a(String paramString, int paramInt1, boolean paramBoolean1, Object paramObject, int paramInt2, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt1 == 1000) && (paramString != null) && (QLog.isColorLevel())) {
      QLog.d("notification", 2, "funName:" + paramString + ",isSuccess:" + paramBoolean1);
    }
    if ((!paramBoolean2) || (paramInt1 != 1000) || (paramBoolean1 != true) || (paramInt2 > 0))
    {
      try
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramBoolean3) {
          break label294;
        }
        paramBoolean2 = true;
        paramString.a(paramInt2, true, paramBoolean2);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label98:
          Friends localFriends;
          if (QLog.isColorLevel()) {
            QLog.w("notification", 2, "notification exception", paramString);
          }
        }
      }
      a(paramInt1, paramBoolean1, paramObject);
      if (paramInt1 != 3001) {
        break label340;
      }
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        if ((paramObject != null) && (paramObject.length > 2))
        {
          paramString = (String)paramObject[0];
          ((Integer)paramObject[1]).intValue();
          if (((Integer)paramObject[2]).intValue() == 58)
          {
            MessageUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
            paramObject = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
            if (!paramObject.g(paramString))
            {
              localFriends = paramObject.c(String.valueOf(paramString));
              if (localFriends != null)
              {
                localFriends.setShieldFlag(true);
                paramObject.a(localFriends);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(56, true, new Object[] { Long.valueOf(Long.parseLong(paramString)), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), "" });
              }
            }
          }
        }
      }
    }
    label294:
    label340:
    do
    {
      do
      {
        do
        {
          return;
          paramBoolean2 = false;
          break;
          if (!QLog.isColorLevel()) {
            break label98;
          }
          QLog.d("notification", 2, "notification size = 0");
          break label98;
        } while (((paramInt1 != 6000) && (paramInt1 != 8002) && (paramInt1 != 7000) && (paramInt1 != 8005) && (paramInt1 != 8006) && (paramInt1 != 6010) && (paramInt1 != 6012) && (paramInt1 != 6013) && (paramInt1 != 8008) && (paramInt1 != 8010) && (paramInt1 != 8012)) || (!(paramObject instanceof Object[])));
        paramString = (Object[])paramObject;
      } while ((paramString == null) || (paramString.length <= 2));
      paramObject = (String)paramString[0];
      paramInt1 = ((Integer)paramString[1]).intValue();
    } while (((Integer)paramString[2]).intValue() != 55);
    ((ShieldListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(15)).a(paramObject, paramInt1);
  }
  
  private void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(ProcessorDispatcher.a(paramString)).a(ProcessorDispatcher.a(paramString), paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(ProcessorDispatcher.a(paramString)).a(ProcessorDispatcher.a(paramString), new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
  }
  
  private void a(String paramString1, String paramString2, byte paramByte, boolean paramBoolean, String paramString3, long paramLong1, long paramLong2, long paramLong3)
  {
    ToServiceMsg localToServiceMsg = a("AccostSvc.ClientMsg");
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
    a(localToServiceMsg);
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
    l2 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    localHashMap.put("param_retryIndex", Long.toString(l2));
    l1 = paramToServiceMsg.extraData.getLong("startTime", 0L);
    l3 = System.currentTimeMillis();
    if (l1 < 1L)
    {
      l1 = 0L;
      if (!paramToServiceMsg.extraData.containsKey("msgSeq")) {
        break label391;
      }
      SendMessageHandler localSendMessageHandler = a(paramToServiceMsg.extraData.getLong("msgSeq"));
      if (localSendMessageHandler == null) {
        break label391;
      }
      paramToServiceMsg = localSendMessageHandler.toString();
      localHashMap.put("param_retryInfo", paramToServiceMsg);
      l1 = localSendMessageHandler.a(l3);
    }
    for (;;)
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
      if (paramFromServiceMsg != null) {
        localHashMap.put("param_reason", paramFromServiceMsg);
      }
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString, paramBoolean, l1, paramLong, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "Statistics TAG[" + paramString + "]  success[" + paramBoolean + "] duration[" + l1 + "ms] retryNum[" + l2 + "] detail[" + paramToServiceMsg + "]");
      }
      return;
      l1 = l3 - l1;
      break;
      label391:
      paramToServiceMsg = "";
    }
  }
  
  private void a(Object[] paramArrayOfObject, String paramString, int paramInt)
  {
    paramString = (String)paramArrayOfObject[0];
    int i1 = ((Integer)paramArrayOfObject[1]).intValue();
    long l1 = ((Long)paramArrayOfObject[5]).longValue();
    paramArrayOfObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, i1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString, i1, l1);
    if ((paramArrayOfObject != null) && (paramArrayOfObject.uniseq == l1)) {
      paramArrayOfObject.extraflag = 32768;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, i1, l1, 32768, paramInt);
  }
  
  private boolean a(long paramLong)
  {
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
      {
        this.jdField_b_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
        return true;
      }
      return false;
    }
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, msg_svc.PbGetDiscussMsgResp paramPbGetDiscussMsgResp)
  {
    if ((paramPbGetDiscussMsgResp.msg.get() != null) && (paramPbGetDiscussMsgResp.msg.get().size() > 0))
    {
      boolean bool = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
      long l1 = paramToServiceMsg.extraData.getLong("lBeginSeq");
      long l2 = paramPbGetDiscussMsgResp.return_begin_seq.get();
      long l3 = paramToServiceMsg.extraData.getLong("lDisUin", paramPbGetDiscussMsgResp.discuss_uin.get());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pullNextDisMsg disUin: ").append(l3).append(" res.cReplyCode: ").append(paramPbGetDiscussMsgResp.result.get()).append(" srcBegSeq: ").append(l1).append(" srcEndSeq: ").append(paramToServiceMsg.extraData.getLong("lEndSeq")).append(" res.lReturnBeginSeq: ").append(l2).append(" res.lReturnEndSeq: ").append(paramPbGetDiscussMsgResp.return_end_seq.get()).append(" res.vMsgs.size(): ").append(paramPbGetDiscussMsgResp.msg.get().size());
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(l3, paramPbGetDiscussMsgResp.msg.get());
      if ((!bool) && (l1 <= l2 - 1L) && (paramPbGetDiscussMsgResp.return_begin_seq.get() <= paramPbGetDiscussMsgResp.return_end_seq.get())) {
        return a(l3, l1, l2 - 1L, paramToServiceMsg.extraData.getBoolean("isRefreshHead"), paramToServiceMsg.extraData.getBundle("context"));
      }
    }
    return false;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    boolean bool3;
    Object localObject1;
    long l1;
    long l2;
    int i1;
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    if (paramPbGetGroupMsgResp.msg.get() != null)
    {
      bool1 = bool2;
      if (paramPbGetGroupMsgResp.msg.get().size() > 0)
      {
        bool3 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
        localObject2 = paramToServiceMsg.extraData.getString("groupuin");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = String.valueOf(paramPbGetGroupMsgResp.group_code.get());
        }
        l1 = paramToServiceMsg.extraData.getLong("lBeginSeq", 0L);
        l2 = paramPbGetGroupMsgResp.return_begin_seq.get();
        if (paramPbGetGroupMsgResp.msg.get() == null) {
          break label383;
        }
        i1 = 1;
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder(128);
          localStringBuilder2 = localStringBuilder1.append("pullNextTroopMsg troopUin: ").append((String)localObject1).append(" msgStruct.cReplyCode: ").append(paramPbGetGroupMsgResp.result.get()).append(" lBeginSeq: ").append(l1).append(" lEndSeq: ").append(paramToServiceMsg.extraData.getLong("lEndSeq")).append(" res.lReturnBeginSeq: ").append(l2).append(" res.lReturnEndSeq: ").append(paramPbGetGroupMsgResp.return_end_seq.get()).append(" msg.size(): ");
          if (i1 == 0) {
            break label388;
          }
        }
      }
    }
    label388:
    for (Object localObject2 = Integer.valueOf(paramPbGetGroupMsgResp.msg.get().size());; localObject2 = "null")
    {
      localStringBuilder2.append(localObject2);
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder1.toString());
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramPbGetGroupMsgResp.group_code.get(), paramPbGetGroupMsgResp.msg.get());
      l2 -= 1L;
      bool1 = bool2;
      if (!bool3)
      {
        bool1 = bool2;
        if (l1 <= l2)
        {
          bool1 = bool2;
          if (paramPbGetGroupMsgResp.return_begin_seq.get() <= paramPbGetGroupMsgResp.return_end_seq.get()) {
            bool1 = a((String)localObject1, l1, l2, paramToServiceMsg.extraData.getBoolean("isRefreshHead"), paramToServiceMsg.extraData.getBundle("context"), paramToServiceMsg.extraData.getInt("doSome"));
          }
        }
      }
      return bool1;
      label383:
      i1 = 0;
      break;
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "----------handleMsgGetting: " + this.jdField_d_of_type_Boolean);
      }
      if (!this.jdField_d_of_type_Boolean)
      {
        c(true);
        e(paramBoolean);
        return false;
      }
      return true;
    }
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
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramArrayOfString[i1], 0);
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.e(paramArrayOfString[i1]);
      arrayOfLong[i1] = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramArrayOfString[i1]);
      if (QLog.isColorLevel()) {
        localStringBuilder.append(paramArrayOfString[i1]).append(":").append(arrayOfLong[i1]).append(", ");
      }
      i1 += 1;
    }
    if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    return arrayOfLong;
  }
  
  private Object[] a()
  {
    Object localObject = ((ContactFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a("-1004");
    String[] arrayOfString = new String[((ArrayList)localObject).size()];
    long[] arrayOfLong = new long[((ArrayList)localObject).size()];
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (QLog.isColorLevel()) {
      localStringBuilder.append("--->>initBeforGetPullDiscussionMsgNum: discussLength:").append(((ArrayList)localObject).size()).append(", discussionUinArray: ");
    }
    localObject = ((ArrayList)localObject).iterator();
    int i1 = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = ((DiscussionInfo)((Iterator)localObject).next()).uin;
      arrayOfString[i1] = str;
      arrayOfLong[i1] = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.g(str);
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(str, 0);
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.g(str);
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c(str);
      if (QLog.isColorLevel()) {
        localStringBuilder.append(str).append(":").append(arrayOfLong[i1]).append(", ");
      }
      i1 += 1;
    }
    if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    if ((arrayOfString == null) || (i1 == 0))
    {
      a(4002, true, null);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>initBeforGetPullDiscussionMsgNum, get discussionUin is null or length is 0, notifyUI NOTIFY_TYPE_GET_DISCUSSION_MSG_FIN ");
      }
      return null;
    }
    return new Object[] { arrayOfString, arrayOfLong, Integer.valueOf(i1) };
  }
  
  private static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 7: 
    case 9: 
    case 13: 
    default: 
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
    case 16: 
      return 6012;
    case 17: 
      return 6013;
    case 18: 
      return 8008;
    }
    return 8010;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponsePullGroupMsgSeq paramSvcResponsePullGroupMsgSeq)
  {
    if (paramSvcResponsePullGroupMsgSeq == null)
    {
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    int i2 = paramToServiceMsg.extraData.getInt("doSome", 0);
    boolean bool = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
    StringBuilder localStringBuilder = new StringBuilder();
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("<<---handleGetPullTroopMsgNumResp msgStruct.cReplyCode: ").append(paramSvcResponsePullGroupMsgSeq.cReplyCode).append(",isUsedRegisterProxy: ").append(bool).append(",doSome: ").append(i2);
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    if (paramSvcResponsePullGroupMsgSeq.cReplyCode != 0)
    {
      m(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.bO = 0;
    ArrayList localArrayList = new ArrayList();
    if (bool) {}
    for (HashMap localHashMap = new HashMap(this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a());; localHashMap = null)
    {
      int i1 = 0;
      if (i1 < paramSvcResponsePullGroupMsgSeq.vGroupInfo.size())
      {
        Object localObject1 = (GroupInfo)paramSvcResponsePullGroupMsgSeq.vGroupInfo.get(i1);
        String str = String.valueOf(((GroupInfo)localObject1).lGroupCode);
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(str);
        long l2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.i(str);
        long l1;
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          l1 = ((Long)localObject2[0]).longValue();
          label245:
          if (QLog.isColorLevel())
          {
            localStringBuilder.setLength(0);
            localStringBuilder.append("handleGetPullTroopMsgNumResp getGroupMsgMemberSeq groupUin=").append(((GroupInfo)localObject1).lGroupCode).append(" memberseq=").append(((GroupInfo)localObject1).lMemberSeq).append(" groupSeq=").append(((GroupInfo)localObject1).lGroupSeq).append(" lMask=").append(((GroupInfo)localObject1).lMask).append(" localMemberMsgSeq=").append(l1).append(" localLastSeq=").append(l2);
            QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c(str, new Object[] { Long.valueOf(((GroupInfo)localObject1).lMemberSeq), Long.valueOf(((GroupInfo)localObject1).lGroupSeq) });
          if (!bool) {
            break label624;
          }
          if ((((GroupInfo)localObject1).lMask != 2L) && (((GroupInfo)localObject1).lMask != 3L)) {
            break label533;
          }
          g(str);
          label419:
          if (localHashMap != null) {
            localHashMap.remove(str);
          }
          if (((GroupInfo)localObject1).lMask != 0L)
          {
            if (this.jdField_b_of_type_JavaUtilArrayList == null) {
              this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
            }
            localObject2 = new Setting();
            ((Setting)localObject2).Path = ("message.group.policy." + str);
            ((Setting)localObject2).Value = String.valueOf(((GroupInfo)localObject1).lMask);
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          l1 = 0L;
          break label245;
          label533:
          if (((GroupInfo)localObject1).lGroupSeq <= l2)
          {
            g(str);
            if (l1 >= ((GroupInfo)localObject1).lMemberSeq) {
              break label419;
            }
            if (jdField_a_of_type_Boolean)
            {
              a(4, paramToServiceMsg, paramFromServiceMsg, localObject1);
              break label419;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 1, ((GroupInfo)localObject1).lMemberSeq);
            break label419;
          }
          if (l1 >= ((GroupInfo)localObject1).lMemberSeq) {
            break label419;
          }
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(str, 1);
          break label419;
          label624:
          if (l1 < ((GroupInfo)localObject1).lMemberSeq) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(((GroupInfo)localObject1).lGroupCode), 1, ((GroupInfo)localObject1).lMemberSeq);
          }
          l1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(str, 1);
          localObject1 = a(str, 1, this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(str), this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(str), l1, ((GroupInfo)localObject1).lGroupSeq);
          int i3 = (int)(((Long)((Pair)localObject1).second).longValue() - ((Long)((Pair)localObject1).first).longValue());
          l1 = ((Long)((Pair)localObject1).first).longValue();
          l2 = ((Long)((Pair)localObject1).second).longValue();
          l1 = l2 - (1L + l1);
          if (l1 > 10) {}
          for (l1 = l2 - 10 + 1L;; l1 = l2 - l1)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder.setLength(0);
              localStringBuilder.append("---------handleGetPullTroopMsgNumResp troopUin: ").append(str).append(" msg count: ").append(i3);
              QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
            }
            if (i3 > 0) {
              break label868;
            }
            ((TroopMessageProcessor)a("troop_processor")).b(str, i2);
            break;
          }
          label868:
          localArrayList.add(str);
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            localObject1 = localArrayList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              a(str, l1, l2, false, null, i2);
            }
          }
          else
          {
            a(4003, true, paramToServiceMsg.extraData.getStringArray("array_groupuin"));
          }
        }
      }
      if (!bool) {
        break;
      }
      if ((localHashMap != null) && (!localHashMap.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp  RegisterProxyTroopSeq FailedTroopSize=" + localHashMap.size());
        }
        paramToServiceMsg = localHashMap.keySet().iterator();
        while (paramToServiceMsg.hasNext()) {
          g((String)paramToServiceMsg.next());
        }
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d()) {
        break;
      }
      a(4003, true, arrayOfString);
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    int i1 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    if (i1 == 1) {
      c(paramToServiceMsg, paramFromServiceMsg, paramBoolean);
    }
    do
    {
      return;
      if ((i1 == 3) || (i1 == 14))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramBoolean);
        return;
      }
    } while (i1 != 6);
    f(paramToServiceMsg, paramFromServiceMsg, paramBoolean);
  }
  
  private void b(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(ProcessorDispatcher.a(paramString)).b(ProcessorDispatcher.a(paramString), paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void b(byte[] paramArrayOfByte)
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
      long l1 = PkgTools.a(paramArrayOfByte, 1);
      l2 = PkgTools.a(paramArrayOfByte, 5);
      l3 = PkgTools.a(paramArrayOfByte, 9);
      l4 = PkgTools.a(paramArrayOfByte, 13);
      l5 = PkgTools.a(paramArrayOfByte, 17);
      if (QLog.isColorLevel()) {
        QLog.d("Emoticon", 2, "uin:" + l1 + " epId=" + l2 + " expireTime=" + l3 + " flag=" + l4);
      }
      localObject = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    } while (((EmoticonManager)localObject).b(Long.toString(l2)) != null);
    paramArrayOfByte = new EmoticonPackage();
    paramArrayOfByte.epId = Long.toString(l2);
    paramArrayOfByte.wordingId = l5;
    if (l4 == 1L) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfByte.valid = bool;
      paramArrayOfByte.expiretime = l3;
      ((EmoticonManager)localObject).a(paramArrayOfByte);
      ((EmoticonManager)localObject).a(paramArrayOfByte.epId);
      localObject = (EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(39);
      ((EmojiManager)localObject).a(paramArrayOfByte.epId, EmojiManager.c);
      ((EmojiManager)localObject).a(paramArrayOfByte);
      return;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg.setNeedRemindSlowNetwork(true);
    b(paramToServiceMsg);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (this.bM < 2)
    {
      a(paramToServiceMsg);
      this.bM += 1;
      return;
    }
    d(5002, false, null);
    this.bM = 0;
  }
  
  private void c(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      e(true);
      a((byte)1, null, 0, false, false, false);
      return;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    while (paramToServiceMsg.extraData.getByte("binaryPic", (byte)0).byteValue() == 1) {
      return;
    }
    a("actSendC2CProcess", paramBoolean, paramToServiceMsg.extraData.getLong("msgsize", 0L), paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void c(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(AppShareIDUtil.a(((Long)paramArrayList.next()).longValue()));
    }
    a(localArrayList);
  }
  
  private boolean c()
  {
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_ArrayOfCtx != null) && (this.jdField_a_of_type_ArrayOfCtx.length > 1)) {
          break label77;
        }
        return true;
        if (i1 >= this.jdField_a_of_type_ArrayOfCtx.length) {
          break label73;
        }
        if ((this.jdField_a_of_type_ArrayOfCtx[i1] != null) && (this.jdField_a_of_type_ArrayOfCtx[i1].b())) {
          return false;
        }
      }
      i1 += 1;
      continue;
      label73:
      return true;
      label77:
      int i1 = 1;
    }
  }
  
  private void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(null, paramInt, paramBoolean, paramObject, 0, false, false);
  }
  
  private void d(ToServiceMsg paramToServiceMsg)
  {
    b();
    if (this.bD < 6)
    {
      b(paramToServiceMsg.extraData.getBoolean("isPullRoamMsg"));
      this.bD += 1;
      return;
    }
    l();
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    b(paramToServiceMsg, 3012, false, null);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendC2CMessageResp_PB.");
    }
    String str2 = paramToServiceMsg.getServiceCmd();
    String str1 = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    long l2 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l3 = paramToServiceMsg.extraData.getLong("timeOut");
    int i3 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    int i2 = paramToServiceMsg.extraData.getInt("msgtype");
    int i5 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    int i4 = MessageProtoCodec.a(i5);
    boolean bool = paramToServiceMsg.extraData.getBoolean("RichNotify", false);
    int i1 = 0;
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
          QLog.e("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB : invalid.", localException);
          localObject2 = new StringBuilder().append("<---handleSendC2CMessageResp_PB : data:");
          if (paramObject != null) {
            break label459;
          }
        }
        label459:
        for (paramObject = "null";; paramObject = Arrays.toString((byte[])paramObject))
        {
          QLog.e("Q.msg.MessageHandler", 2, paramObject);
          paramObject = null;
          break;
        }
        if (paramObject.result.get() != 0) {
          i1 = paramObject.result.get();
        }
      }
      label495:
      if (i1 != 255) {
        break label707;
      }
      label707:
      for (i2 = 1;; i2 = 0)
      {
        if (i2 != 0)
        {
          localObject2.getClass();
          if (a((SendMessageHandler)localObject2, "server")) {
            break;
          }
        }
        if ((i1 != 0) && (i1 != 241)) {
          break label713;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(str1, i4, l1);
        if (paramObject.send_time.has())
        {
          l3 = paramObject.send_time.get() & 0xFFFFFFFF;
          a(str1, i4, l1, l3);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB updateSendMsgTime: sendBuddyPb: respData.uSendTime:" + l3 + ",peerUin:" + str1);
          }
        }
        a(6003, true, new String[] { str1 });
        if (bool)
        {
          paramObject = new MessageObserver.StatictisInfo();
          paramObject.c = (i3 + 1);
          b(paramToServiceMsg, 5006, true, new Object[] { paramObject });
        }
        b(paramToServiceMsg, paramFromServiceMsg, true);
        a(l2);
        return;
      }
      label713:
      i2 = b(i5);
      Object localObject2 = new Object[6];
      localObject2[0] = str1;
      localObject2[1] = Integer.valueOf(i4);
      localObject2[2] = Integer.valueOf(i1);
      localObject2[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
      localObject2[4] = Long.valueOf(l3);
      localObject2[5] = Long.valueOf(l1);
      a((Object[])localObject2, paramFromServiceMsg.getUin(), i1);
      if ((i4 != 1006) || (!paramObject.errmsg.has()) || ((i1 != 1600) && (i1 != 1601) && (i1 != 1602) && (i1 != 1603))) {
        break label862;
      }
      a(i4, paramObject.errmsg.get(), (String)localObject2[0]);
      label862:
      if ((i4 != 1022) || (!paramObject.errmsg.has()) || (i1 != 201)) {
        break label908;
      }
      a(i4, paramObject.errmsg.get(), (String)localObject2[0]);
      label908:
      d(i2, true, localObject2);
      if (!bool) {
        break label977;
      }
      paramObject = new MessageObserver.StatictisInfo();
      paramObject.b = 2900;
      paramObject.d = i1;
      paramObject.c = (i3 + 1);
      paramObject.jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
      b(paramToServiceMsg, 5006, false, new Object[] { paramObject });
      label977:
      b(paramToServiceMsg, paramFromServiceMsg, true);
      a(l2);
    }
    if ((paramObject == null) || (!paramObject.result.has()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB : server did not return a valid result code, use 4 instead.");
      }
      i1 = 4;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendC2CMessageResp_PB : ---cmd:" + str2 + "----replyCode:" + i1 + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + " peerUin:" + str1 + " uniseq:" + l1 + " msgSeq:" + l2 + " msgType:" + i2 + " uinType:" + i4 + " routingType:" + i5);
      }
      paramFromServiceMsg.extraData.putLong("ServerReplyCode", i1);
      b(paramToServiceMsg, paramFromServiceMsg);
      localObject1 = a(l2);
      if (localObject1 != null) {
        break label495;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendC2CMessageResp_PB : ---cmd:" + str2 + ",no SendMessageHandler found.");
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    int i1;
    long l1;
    do
    {
      return;
      i1 = paramToServiceMsg.extraData.getInt("msgtype", -1);
      l1 = paramToServiceMsg.extraData.getLong("msgsize", 0L);
    } while (i1 != -1000);
    a("actSendGroupProcess", paramBoolean, l1, paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void d(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString1, 2);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "----------handleTroopMsgResponseFinishedAndNotify troopUin: " + paramString1 + ", funcName:" + paramString2);
    }
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramString1);
      paramString2 = ((ArrayList)localObject).iterator();
      while (paramString2.hasNext())
      {
        localObject = (Object[])paramString2.next();
        if ((localObject != null) && (localObject.length >= 2)) {
          a("troop_processor").a(1001, (Object[])localObject);
        }
      }
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString1);
    if (paramString1 != null) {
      ((TroopMessageProcessor)a("troop_processor")).a(paramString1);
    }
  }
  
  private boolean d()
  {
    if (this.jdField_c_of_type_JavaUtilArrayList == null) {
      return true;
    }
    for (;;)
    {
      try
      {
        synchronized (this.jdField_c_of_type_JavaUtilArrayList)
        {
          if (this.jdField_c_of_type_JavaUtilArrayList.size() == 0)
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
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject2 = paramToServiceMsg.getServiceCmd();
    Object localObject1 = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    long l2 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l3 = paramToServiceMsg.extraData.getLong("timeOut");
    int i3 = paramToServiceMsg.extraData.getInt("msgtype");
    int i4 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    int i1 = paramToServiceMsg.extraData.getInt("retryIndex");
    int i2 = MessageProtoCodec.a(i4);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><E><---handleSendC2CMessageError: ---cmd:" + (String)localObject2 + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + ",sendC2CMessage error : peerUin:" + (String)localObject1 + " uniseq:" + l1 + " msgSeq:" + l2 + " msgType:" + i3 + " uinType:" + i2 + " routingType:" + i4 + " retryIndex:" + i1);
    }
    b(paramToServiceMsg, paramFromServiceMsg);
    localObject2 = a(l2);
    if (localObject2 != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label279;
      }
      localObject2.getClass();
      if (!a((SendMessageHandler)localObject2, "msf")) {
        break label279;
      }
    }
    label279:
    while ((480000L != l3) && (!((SendMessageHandler)localObject2).a())) {
      return;
    }
    i3 = b(i4);
    localObject2 = new Object[6];
    localObject2[0] = localObject1;
    localObject2[1] = Integer.valueOf(i2);
    localObject2[2] = Integer.valueOf(0);
    localObject2[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
    localObject2[4] = Long.valueOf(l3);
    localObject2[5] = Long.valueOf(l1);
    a((Object[])localObject2, paramFromServiceMsg.getUin(), paramFromServiceMsg.getResultCode());
    d(i3, false, localObject2);
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      localObject1 = new MessageObserver.StatictisInfo();
      ((MessageObserver.StatictisInfo)localObject1).b = paramFromServiceMsg.getResultCode();
      ((MessageObserver.StatictisInfo)localObject1).c = i1;
      ((MessageObserver.StatictisInfo)localObject1).jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
      b(paramToServiceMsg, 5006, false, new Object[] { localObject1 });
    }
    b(paramToServiceMsg, paramFromServiceMsg, false);
    a(l2);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("don", 2, "handleSendTroopMessageRespPB enter");
    }
    localObject2 = paramToServiceMsg.extraData.getString("groupuin");
    String str = paramToServiceMsg.getServiceCmd();
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
        int i1;
        long l1;
        long l2;
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("<---handleSendTroopMessageRespPB:");
          if (paramObject != null) {
            break label308;
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
          i1 = paramObject.result.get();
          continue;
          int i2;
          Object[] arrayOfObject;
          boolean bool;
          if (i1 == 255)
          {
            i2 = 1;
            if (i2 != 0)
            {
              localException.getClass();
              if (a(localException, "server")) {
                continue;
              }
            }
            arrayOfObject = new Object[7];
            arrayOfObject[0] = localObject2;
            arrayOfObject[1] = Integer.valueOf(1);
            arrayOfObject[2] = Integer.valueOf(i1);
            arrayOfObject[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
            arrayOfObject[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
            arrayOfObject[5] = Long.valueOf(l2);
            arrayOfObject[6] = paramObject.errmsg.get();
            paramObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
            switch (i1)
            {
            default: 
              bool = false;
              if (bool)
              {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramToServiceMsg.extraData.getString("groupuin"), 1, l2);
                a(6003, true, new String[] { paramToServiceMsg.extraData.getString("groupuin") });
                if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
                {
                  i2 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
                  paramObject = new MessageObserver.StatictisInfo();
                  if (!bool) {
                    break label788;
                  }
                  paramObject.b = paramFromServiceMsg.getResultCode();
                  paramObject.c = (i2 + 1);
                }
              }
              break;
            }
          }
          for (;;)
          {
            b(paramToServiceMsg, 5006, bool, new Object[] { paramObject });
            d(paramToServiceMsg, paramFromServiceMsg, true);
            a(l1);
            return;
            i2 = 0;
            break;
            bool = true;
            break label527;
            ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).e((String)localObject2);
            paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
            localObject2 = paramObject.a((String)localObject2, 1);
            if (localObject2 != null) {
              paramObject.b((RecentUser)localObject2);
            }
            d(1002, true, arrayOfObject);
            d(2001, true, arrayOfObject);
            d(2002, true, arrayOfObject);
            bool = false;
            break label527;
            a(arrayOfObject, paramFromServiceMsg.getUin(), i1);
            d(3002, false, arrayOfObject);
            break label580;
            paramObject.b = 2900;
            paramObject.d = i1;
            paramObject.c = (i2 + 1);
            paramObject.jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
          }
        }
        else
        {
          i1 = 0;
        }
      }
    }
    if ((paramObject == null) || (!paramObject.result.has()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB:server did not return a valid result code, use 4 instead.");
      }
      i1 = 4;
      paramFromServiceMsg.extraData.putLong("ServerReplyCode", i1);
      b(paramToServiceMsg, paramFromServiceMsg);
      l1 = paramToServiceMsg.extraData.getLong("msgSeq");
      l2 = paramToServiceMsg.extraData.getLong("uniseq");
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendTroopMessageRespPB: ---cmd:" + str + "----replyCode:" + i1 + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + ",SendTroopMessageResp : peerUin:" + (String)localObject2 + ",uniseq:" + l2 + ",msgSeq:" + l1);
      }
      localObject1 = a(l1);
      if (localObject1 != null) {
        break label344;
      }
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
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
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dim.actSendGrpTmpMsg", paramBoolean, l1, l2, localHashMap, "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.MessageHandler", 2, "TAG[" + "dim.actSendGrpTmpMsg" + "]  success[" + paramBoolean + "] duration[" + l1 + "ms] retryNum[" + l3 + "]");
      return;
      l1 = System.currentTimeMillis() - l4;
    }
  }
  
  private void e(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleDiscMsgResponseFinishAndNotify uin = " + paramString1 + ", funcName=" + paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramString1, 2);
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramString1);
    if ((paramString2 != null) && (!paramString2.isEmpty()))
    {
      paramString2 = new ArrayList(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d(paramString1);
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        Object[] arrayOfObject = (Object[])paramString2.next();
        if ((arrayOfObject != null) && (arrayOfObject.length >= 3)) {
          a("disc_processor").a(1001, new Object[] { arrayOfObject[0], arrayOfObject[1], arrayOfObject[2], Boolean.valueOf(false) });
        }
      }
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString1);
    if (paramString1 != null) {
      ((DiscMessageProcessor)a("disc_processor")).a(paramString1);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    String str = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    long l3 = paramToServiceMsg.extraData.getLong("uniseq");
    int i1 = paramToServiceMsg.extraData.getInt("msgtype");
    int i2 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    int i3 = paramToServiceMsg.extraData.getInt("retryIndex");
    int i4 = MessageProtoCodec.a(i2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><E><---handleSendGrpMessageError: ---cmd:" + (String)localObject + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + ",sendC2CMessage error : peerUin:" + str + " uniseq:" + l3 + " msgSeq:" + l1 + " msgType:" + i1 + " uinType:" + i4 + " routingType:" + i2 + " retryIndex:" + i3);
    }
    b(paramToServiceMsg, paramFromServiceMsg);
    localObject = a(l1);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label279;
      }
      localObject.getClass();
      if (!a((SendMessageHandler)localObject, "msf")) {
        break label279;
      }
    }
    label279:
    while ((480000L != l2) && (!((SendMessageHandler)localObject).a())) {
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
    d(3002, false, localObject);
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      localObject = new MessageObserver.StatictisInfo();
      ((MessageObserver.StatictisInfo)localObject).b = paramFromServiceMsg.getResultCode();
      ((MessageObserver.StatictisInfo)localObject).c = i1;
      ((MessageObserver.StatictisInfo)localObject).jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
      b(paramToServiceMsg, 5006, false, new Object[] { localObject });
    }
    d(paramToServiceMsg, paramFromServiceMsg, false);
    a(l1);
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new msg_onlinepush.PbPushMsg();
    try
    {
      paramToServiceMsg = (msg_onlinepush.PbPushMsg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null) {
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
      }
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.msg.has())) {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder().append("<---handleMessagePush_PB: pushMsg is null or doesn't has msg:");
          if (paramToServiceMsg == null)
          {
            paramToServiceMsg = " null ";
            QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg);
          }
        }
        else
        {
          return;
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<---handleMessagePush_PB: exception occurs while parsing the pb bytes.", paramToServiceMsg);
        }
        paramToServiceMsg = null;
        continue;
        paramToServiceMsg = "noMsg";
      }
      paramObject = (msg_comm.Msg)paramToServiceMsg.msg.get();
      int i1 = ((msg_comm.MsgHead)paramObject.msg_head.get()).msg_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<---handleMessagePush_PB: msgType:" + i1);
      }
      if ("OnlinePush.PbC2CMsgSync".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        a("c2c_processor").a(2003, new Object[] { paramObject, paramFromServiceMsg, paramToServiceMsg });
        return;
      }
      switch (i1)
      {
      default: 
        return;
      }
    }
    a("disc_processor").a(1001, new Object[] { paramObject, paramFromServiceMsg, paramToServiceMsg, Boolean.valueOf(true) });
    return;
    a("troop_processor").a(1001, new Object[] { paramObject, paramFromServiceMsg });
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
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
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dim.actSendWpaMsg", paramBoolean, l1, l2, localHashMap, "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.MessageHandler", 2, "TAG[" + "dim.actSendWpaMsg" + "]  success[" + paramBoolean + "] duration[" + l1 + "ms] retryNum[" + l3 + "]");
      return;
      l1 = System.currentTimeMillis() - l4;
    }
  }
  
  private void f(String paramString)
  {
    e(paramString, "closeDisOnlineMsgCache");
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("uniseq");
    long l3 = paramToServiceMsg.extraData.getLong("to");
    long l4 = paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg = l3 + "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramToServiceMsg, 1001, l2, 32768, paramFromServiceMsg.getResultCode());
    d(3001, false, new Object[] { String.valueOf(l3), Integer.valueOf(1001), Integer.valueOf(0), null, Long.valueOf(l4), Long.valueOf(l2) });
    if ((480000L == l4) && (a(l1) != null)) {
      a(l1);
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (RespClientMsg)paramObject;
    if (paramObject == null) {
      g(paramToServiceMsg, paramFromServiceMsg);
    }
    paramToServiceMsg.extraData.getLong("startTime", 0L);
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("uniseq");
    long l3 = paramToServiceMsg.extraData.getLong("to");
    long l4 = paramToServiceMsg.extraData.getLong("timeOut");
    a(l1);
    if (paramObject.stHeader.eReplyCode == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(String.valueOf(paramToServiceMsg.extraData.getLong("to")), 1001, l2);
      a(6003, true, new String[] { String.valueOf(paramToServiceMsg.extraData.getLong("to")) });
      return;
    }
    int i1 = paramObject.stHeader.eReplyCode;
    paramToServiceMsg = l3 + "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramToServiceMsg, 1001, l2, 32768, paramFromServiceMsg.getResultCode());
    d(3001, false, new Object[] { String.valueOf(l3), Integer.valueOf(1001), Integer.valueOf(i1), null, Long.valueOf(l4), Long.valueOf(l2) });
  }
  
  private void g(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    d(paramString, "closeTroopOnlineMsgCache");
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    String str = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    long l3 = paramToServiceMsg.extraData.getLong("uniseq");
    int i1 = paramToServiceMsg.extraData.getInt("msgtype");
    int i2 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    int i3 = paramToServiceMsg.extraData.getInt("retryIndex");
    int i4 = MessageProtoCodec.a(i2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><E><---handleSendDisMessageError: ---cmd:" + (String)localObject + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + ",sendC2CMessage error : peerUin:" + str + " uniseq:" + l3 + " msgSeq:" + l1 + " msgType:" + i1 + " uinType:" + i4 + " routingType:" + i2 + " retryIndex:" + i3);
    }
    b(paramToServiceMsg, paramFromServiceMsg);
    localObject = a(l1);
    if (localObject != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label279;
      }
      localObject.getClass();
      if (!a((SendMessageHandler)localObject, "msf")) {
        break label279;
      }
    }
    label279:
    while ((480000L != l2) && (!((SendMessageHandler)localObject).a())) {
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
    d(3008, false, localObject);
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      localObject = new MessageObserver.StatictisInfo();
      ((MessageObserver.StatictisInfo)localObject).b = paramFromServiceMsg.getResultCode();
      ((MessageObserver.StatictisInfo)localObject).c = i1;
      ((MessageObserver.StatictisInfo)localObject).jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
      b(paramToServiceMsg, 5006, false, new Object[] { localObject });
    }
    a(paramToServiceMsg, paramFromServiceMsg, false);
    a(l1);
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject1 = new msg_svc.PbSendMsgResp();
        try
        {
          localObject1 = (msg_svc.PbSendMsgResp)((msg_svc.PbSendMsgResp)localObject1).mergeFrom((byte[])paramObject);
          paramObject = localObject1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i1;
            long l1;
            long l2;
            Object localObject2;
            int i2;
            boolean bool;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder().append("<---handleSendDiscussionMsgRespPB:");
              if (paramObject != null) {
                break label546;
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
              i1 = paramObject.result.get();
              continue;
              i2 = 0;
              continue;
              bool = true;
              continue;
              bool = false;
              continue;
              Bundle localBundle = paramToServiceMsg.extraData;
              localObject2 = new Object[6];
              localObject2[0] = localBundle.getString("uToUin");
              localObject2[1] = Integer.valueOf(3000);
              localObject2[2] = Integer.valueOf(i1);
              localObject2[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
              localObject2[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
              localObject2[5] = Long.valueOf(l1);
              a((Object[])localObject2, paramFromServiceMsg.getUin(), i1);
              d(3008, false, localObject2);
              if ((paramObject.errmsg.has()) && (paramObject.errmsg.get() != null) && (QLog.isColorLevel()))
              {
                QLog.d("Q.msg.MessageHandler", 2, "send dicussion msg failed: " + paramObject.errmsg.get());
                continue;
                paramObject.b = 2900;
                paramObject.c = (i2 + 1);
                paramObject.d = i1;
                paramObject.jdField_a_of_type_JavaLangString = a(paramFromServiceMsg);
              }
            }
          }
        }
        i1 = 0;
        if ((paramObject != null) && (paramObject.result.has())) {
          break label560;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<---handleSendDiscussionMsgRespPB did not return a valid result code, use 4 instead.");
        }
        i1 = 4;
        paramFromServiceMsg.extraData.putLong("ServerReplyCode", i1);
        b(paramToServiceMsg, paramFromServiceMsg);
        l1 = paramToServiceMsg.extraData.getLong("uniseq");
        l2 = paramToServiceMsg.extraData.getLong("msgSeq");
        localObject1 = paramToServiceMsg.extraData.getString("uToUin");
        localObject2 = paramToServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendDiscussionMsgRespPB: ---cmd:" + (String)localObject2 + "----replyCode:" + i1 + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + "SendDiscussionMsgResp : peerUin:" + (String)localObject1 + ",uniseq:" + l1 + ",msgSeq:" + l2);
        }
        localObject1 = a(l2);
      } while (localObject1 == null);
      if (i1 != 255) {
        break label582;
      }
      i2 = 1;
      if (i2 == 0) {
        break;
      }
      localObject1.getClass();
    } while (a((SendMessageHandler)localObject1, "server"));
    switch (i1)
    {
    default: 
      bool = false;
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramToServiceMsg.extraData.getString("uToUin"), 3000, l1);
        a(6003, true, new String[] { paramToServiceMsg.extraData.getString("uToUin") });
        if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
        {
          i2 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
          paramObject = new MessageObserver.StatictisInfo();
          if (!bool) {
            break label764;
          }
          paramObject.b = paramFromServiceMsg.getResultCode();
          paramObject.c = (i2 + 1);
          b(paramToServiceMsg, 5006, bool, new Object[] { paramObject });
        }
        a(paramToServiceMsg, paramFromServiceMsg, true);
        a(l2);
      }
      break;
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<<---handleTimeOut serviceCmd:" + paramFromServiceMsg.getServiceCmd());
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (ProcessorDispatcher.a().containsKey(str)) {
      b(str, paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      int i1;
      do
      {
        return;
        if ("MessageSvc.PbGetMsg".equalsIgnoreCase(str))
        {
          d(paramToServiceMsg);
          return;
        }
        if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(str))
        {
          d(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("TransService.ReqGetSign".equalsIgnoreCase(str))
        {
          c(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (!"MessageSvc.PbSendMsg".equalsIgnoreCase(str)) {
          break;
        }
        i1 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
        if ((i1 == 1) || (i1 == 3) || (i1 == 14) || (i1 == 5) || (i1 == 6) || (i1 == 10) || (i1 == 11) || (i1 == 12) || (i1 == 8) || (i1 == 16) || (i1 == 17) || (i1 == 18) || (i1 == 15))
        {
          e(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (i1 == 9)
        {
          a().b(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (i1 == 13)
        {
          a().c(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (i1 == 4)
        {
          h(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
      } while (i1 != 2);
      f(paramToServiceMsg, paramFromServiceMsg);
      return;
      if ("AccostSvc.ClientMsg".equalsIgnoreCase(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("PbMessageSvc.PbDelOneRoamMsg".equalsIgnoreCase(str))
      {
        r(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("MessageSvc.PullGroupMsgSeq".equalsIgnoreCase(str))
      {
        n(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(str)) || ("MessageSvc.SetRoamMsg".equalsIgnoreCase(str)))
      {
        j(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(str))
      {
        l(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (("RegPrxySvc.infoLogin".equalsIgnoreCase(str)) || ("RegPrxySvc.getOffMsg".equalsIgnoreCase(str)))
      {
        a(paramFromServiceMsg, null);
        return;
      }
    } while (!"PbMessageSvc.PbMsgReadedReport".equalsIgnoreCase(str));
    s(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!paramToServiceMsg.extraData.getBoolean("used_register_proxy", false))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandler", 2, "<<---handlegetPullDiscussionMsgNumber ERROR isUsedRegisterProxy = false ! ");
      }
      return;
    }
    paramObject = (SvcResponsePullDisMsgSeq)paramObject;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<<---handlegetPullDiscussionMsgNumber is null");
      }
      p(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    int i1 = paramObject.cReplyCode;
    Object localObject = paramObject.strResult;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<<---handleGetDiscussionMsgNum resp.cReplyCode: " + i1);
    }
    if (i1 != 0)
    {
      p(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    paramObject = paramObject.vConfNumInfo;
    paramToServiceMsg = this.jdField_b_of_type_ArrayOfJavaLangString;
    this.jdField_b_of_type_ArrayOfJavaLangString = null;
    if (paramObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<<---handleGetDiscussionMsgNum add cache " + paramObject.size());
      }
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramObject);
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
      int i2 = paramToServiceMsg.length;
      i1 = 0;
      while (i1 < i2)
      {
        paramObject = paramToServiceMsg[i1];
        if (!paramFromServiceMsg.contains(paramObject))
        {
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramObject, 2);
          if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramObject) != null) {
            this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d(paramObject);
          }
        }
        i1 += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramToServiceMsg);
    o();
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    d(1005, false, null);
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg arg2, Object paramObject)
  {
    String str = (String)???.getAttribute("_tag_LOGSTR");
    msg_svc.PbGetDiscussMsgResp localPbGetDiscussMsgResp1 = new msg_svc.PbGetDiscussMsgResp();
    try
    {
      localPbGetDiscussMsgResp1 = (msg_svc.PbGetDiscussMsgResp)localPbGetDiscussMsgResp1.mergeFrom((byte[])paramObject);
      if (localPbGetDiscussMsgResp1 == null)
      {
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
        q(paramToServiceMsg, ???);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      msg_svc.PbGetDiscussMsgResp localPbGetDiscussMsgResp2;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "Exception occurs while parsing the byte array.");
        }
        localPbGetDiscussMsgResp2 = null;
      }
      boolean bool1 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
      new ArrayList();
      boolean bool2 = paramToServiceMsg.extraData.getBoolean("isRefreshHead", false);
      l1 = paramToServiceMsg.extraData.getLong("lDisUin", localPbGetDiscussMsgResp2.discuss_uin.get());
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("handleGetPullDiscussionMsgResp_PB res.cReplyCode = ").append(localPbGetDiscussMsgResp2.result.get()).append(" discussUin: ").append(l1).append(" isRefreshHead: ").append(bool2).append(", dataHash=").append(paramObject.hashCode()).append(" rtnBeginSeq:").append(localPbGetDiscussMsgResp2.return_begin_seq.get()).append(" rtnEndSeq:").append(localPbGetDiscussMsgResp2.return_end_seq.get());
        if (localPbGetDiscussMsgResp2.msg.get() == null) {
          break label345;
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
        label345:
        ???.append(" msg:null.");
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(localPbGetDiscussMsgResp2.discuss_uin.get());
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(String.valueOf(l1), localPbGetDiscussMsgResp2.discuss_info_seq.get(), localPbGetDiscussMsgResp2.last_get_time.get());
      if (bool2) {}
      for (;;)
      {
        try
        {
          a("disc_processor").a(1003, new Object[] { paramToServiceMsg, paramObject, localPbGetDiscussMsgResp2, str });
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(localPbGetDiscussMsgResp2.discuss_uin.get());
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
        try
        {
          a("disc_processor").a(1002, new Object[] { paramToServiceMsg, paramObject, localPbGetDiscussMsgResp2 });
        }
        catch (Exception paramToServiceMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgResp initGetPullDiscussionMsg exception ! ", paramToServiceMsg);
            }
            e(String.valueOf(l1), "handleGetPullDiscussionMsgResp");
          }
        }
        finally
        {
          e(String.valueOf(l1), "handleGetPullDiscussionMsgResp");
        }
        if ((bool1) && (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.e()))
        {
          MsgAutoMonitorUtil.a().i();
          a(4002, true, null);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgResp notify NOTIFY_TYPE_GET_DISCUSSION_MSG_FIN ");
          }
        }
      }
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    d(1005, false, null);
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyC2CMsgResp.");
    }
    if (jdField_a_of_type_Boolean)
    {
      a(1, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    a("c2c_processor").a(1002, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
  }
  
  private void l()
  {
    b();
    this.bD = 0;
    c(false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleGetBuddyMessageError ");
    }
    a(4001, false, null);
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    d(1003, false, null);
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyTroopMsgResp_PB.");
    }
    if (jdField_a_of_type_Boolean)
    {
      a(2, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    n(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void m()
  {
    ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(bE);
    this.f = false;
    if (this.jdField_a_of_type_JavaLangThread != null) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = 0;
    if (paramToServiceMsg.extraData.getBoolean("used_register_proxy", false))
    {
      paramToServiceMsg = this.jdField_a_of_type_ArrayOfJavaLangString;
      this.jdField_a_of_type_ArrayOfJavaLangString = null;
    }
    for (;;)
    {
      this.bO = 0;
      a(4003, false, paramToServiceMsg);
      label44:
      if ((paramToServiceMsg != null) && (i1 < paramToServiceMsg.length)) {
        try
        {
          d(paramToServiceMsg[i1], "handleGetPullTroopMsgNumError");
          i1 += 1;
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
  
  private void m(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof RegisterPushNotice))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleRegisterProxyEndResp RegPrxySvc.NoticeEnd ERROR");
      }
    }
    label268:
    for (;;)
    {
      return;
      paramFromServiceMsg = (RegisterPushNotice)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleRegisterProxyEndResp RegPrxySvc.NoticeEnd endseq=" + paramFromServiceMsg.uEndSeq + ",timeoutflag=" + paramFromServiceMsg.ulTimeOutFlag);
      }
      long l1;
      if (paramFromServiceMsg.uEndSeq == this.bG)
      {
        l1 = 0L;
        this.jdField_a_of_type_AndroidUtilPair = new Pair(paramFromServiceMsg, Long.valueOf(0L));
      }
      for (;;)
      {
        if (((!c()) || (!d())) && (jdField_a_of_type_Boolean)) {
          break label268;
        }
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_AndroidUtilPair != null)
          {
            this.jdField_a_of_type_AndroidUtilPair = null;
            if ((l1 == 1L) || (!this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.e()) || (!this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d()))
            {
              f();
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyEndResp RegPrxySvc.NoticeEnd notify");
              }
              a(4013, true, new Long[] { Long.valueOf(paramFromServiceMsg.ulTimeOutFlag), Long.valueOf(l1) });
            }
          }
          return;
        }
        if (paramFromServiceMsg.uEndSeq != this.bH) {
          break;
        }
        this.jdField_a_of_type_AndroidUtilPair = new Pair(paramFromServiceMsg, Long.valueOf(1L));
        l1 = 1L;
      }
    }
  }
  
  private void n()
  {
    if (this.f) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_eq", "PC_Online_exp", 0, 0, "", "", "", "");
    this.f = true;
    Object localObject1 = BaseApplication.getContext();
    Object localObject2 = ((Context)localObject1).getString(2131364258);
    String str = ((Context)localObject1).getString(2131364258);
    Bitmap localBitmap = BitmapManager.a(((Context)localObject1).getResources(), 2130838527);
    NotificationManager localNotificationManager = (NotificationManager)((Context)localObject1).getSystemService("notification");
    localObject2 = new NotificationCompat.Builder((Context)localObject1).setContentTitle(str).setContentText("").setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker((CharSequence)localObject2).setWhen(System.currentTimeMillis());
    if (localBitmap != null) {
      ((NotificationCompat.Builder)localObject2).setLargeIcon(localBitmap);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 11) {
        ((NotificationCompat.Builder)localObject2).setSmallIcon(2130838527);
      }
      ((NotificationCompat.Builder)localObject2).setContentIntent(PendingIntent.getBroadcast((Context)localObject1, 0, new Intent("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION"), 0));
      localObject1 = ((NotificationCompat.Builder)localObject2).build();
      if (localNotificationManager == null) {
        break;
      }
      localNotificationManager.cancel(bE);
      localNotificationManager.notify(bE, (Notification)localObject1);
      this.jdField_a_of_type_JavaLangThread = new Thread(new cto(this, localNotificationManager));
      this.jdField_a_of_type_JavaLangThread.start();
      return;
      ((NotificationCompat.Builder)localObject2).setLargeIcon(BitmapManager.a(((Context)localObject1).getResources(), 2130838527));
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (this.bO < 3)
    {
      paramFromServiceMsg = paramToServiceMsg.extraData.getStringArray("array_groupuin");
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.length > 0))
      {
        int i2 = paramFromServiceMsg.length;
        int i1 = 0;
        while (i1 < i2)
        {
          a(paramFromServiceMsg[i1], paramToServiceMsg.extraData.getInt("doSome"));
          i1 += 1;
        }
      }
      this.bO += 1;
      return;
    }
    m(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyTroopMsgResp_PB.");
    }
    Object localObject = new register_proxy.SvcResponsePbPullGroupMsgProxy();
    try
    {
      localObject = ((register_proxy.SvcResponsePbPullGroupMsgProxy)((register_proxy.SvcResponsePbPullGroupMsgProxy)localObject).mergeFrom((byte[])paramObject)).msg_content.get().toByteArray();
      int i1 = localObject.length - 4;
      byte[] arrayOfByte = new byte[i1];
      PkgTools.a(arrayOfByte, 0, (byte[])localObject, 4, i1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyTroopMsgResp_PB. dataHash=" + paramObject.hashCode() + ", newDataHash=" + arrayOfByte.hashCode());
      }
      q(paramToServiceMsg, paramFromServiceMsg, arrayOfByte);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.MessageHandler", 2, "<---handleMsgProxyTroopMsgResp_PB : decode pb:", paramToServiceMsg);
    }
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumberFinish");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c())
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b();
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a();
      localStringBuilder = null;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumberFinish vConfNumInfo size = " + ((List)localObject2).size());
        }
        localStringBuilder = new StringBuilder();
        localObject1 = new HashMap(this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b());
        localObject2 = ((List)localObject2).iterator();
        label392:
        label415:
        label436:
        while (((Iterator)localObject2).hasNext())
        {
          localstConfNumInfo = (stConfNumInfo)((Iterator)localObject2).next();
          if (localstConfNumInfo != null)
          {
            str = String.valueOf(localstConfNumInfo.lConfUin);
            arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(str);
            l2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.h(str);
            if ((arrayOfObject != null) && (arrayOfObject.length > 0))
            {
              l1 = ((Long)arrayOfObject[0]).longValue();
              label211:
              if (QLog.isColorLevel())
              {
                localStringBuilder.setLength(0);
                localStringBuilder.append("addDisMsgMemberSeq uin = ").append(localstConfNumInfo.lConfUin).append(" memberseq = ").append(localstConfNumInfo.uMemberMsgSeq).append(" confMsgSeq =").append(localstConfNumInfo.uConfMsgSeq).append(" localLastSeq =").append(l2);
                QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
              }
              this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(String.valueOf(localstConfNumInfo.lConfUin), new Object[] { Long.valueOf(localstConfNumInfo.uMemberMsgSeq), Long.valueOf(localstConfNumInfo.uConfMsgSeq) });
              if (localstConfNumInfo.uConfMsgSeq > l2) {
                break label415;
              }
              f(str);
              if (l1 < localstConfNumInfo.uMemberMsgSeq)
              {
                if (!jdField_a_of_type_Boolean) {
                  break label392;
                }
                a(5, null, null, localstConfNumInfo);
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label436;
              }
              ((HashMap)localObject1).remove(str);
              break;
              l1 = 0L;
              break label211;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 3000, localstConfNumInfo.uMemberMsgSeq);
              continue;
              if (l1 < localstConfNumInfo.uMemberMsgSeq) {
                this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(str, 1);
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
          f((String)((Iterator)localObject1).next());
        }
        localObject1 = localStringBuilder;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumberFinish vConfNumInfo is null ! ");
          localObject1 = localStringBuilder;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.e()) {
        a(4002, true, null);
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
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("isRefreshHead", false);
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("groupuin");
    if (bool1)
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
      if (paramToServiceMsg != null) {
        paramToServiceMsg.putBoolean("success", false);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFromServiceMsg, 1, null, null, paramToServiceMsg);
      return;
    }
    try
    {
      d(paramFromServiceMsg, "handleGetPullTroopMsgError");
      if (bool2) {
        if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgError notify NOTIFY_TYPE_GET_TROOP_MSG_FIN ");
          }
          a(4003, false, new String[] { paramFromServiceMsg });
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
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.f();
      return;
    }
    a(4003, false, new String[] { paramFromServiceMsg });
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyDiscussMsgResp_PB.");
    }
    if (jdField_a_of_type_Boolean)
    {
      a(3, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    p(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (!paramToServiceMsg.extraData.getBoolean("used_register_proxy", false))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgNumError isUsedRegisterProxy = false ! ");
      }
      return;
    }
    paramToServiceMsg = this.jdField_b_of_type_ArrayOfJavaLangString;
    this.jdField_b_of_type_ArrayOfJavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int i1;
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder().append("handleGetPullDiscussionMsgNumError size = ");
      if (paramToServiceMsg != null) {
        break label123;
      }
      i1 = 0;
    }
    for (;;)
    {
      QLog.d("Q.msg.MessageHandler", 2, i1);
      if (paramToServiceMsg == null) {
        break label165;
      }
      int i2 = paramToServiceMsg.length;
      i1 = 0;
      label98:
      if (i1 < i2)
      {
        paramFromServiceMsg = paramToServiceMsg[i1];
        try
        {
          e(paramFromServiceMsg, "handleGetPullDiscussionMsgNumError");
          i1 += 1;
          break label98;
          label123:
          i1 = paramToServiceMsg.length;
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
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramToServiceMsg);
    o();
    label165:
    a(4002, false, null);
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new register_proxy.SvcPbResponsePullDisMsgProxy();
    try
    {
      localObject = ((register_proxy.SvcPbResponsePullDisMsgProxy)((register_proxy.SvcPbResponsePullDisMsgProxy)localObject).mergeFrom((byte[])paramObject)).msg_content.get().toByteArray();
      int i1 = localObject.length - 4;
      byte[] arrayOfByte = new byte[i1];
      PkgTools.a(arrayOfByte, 0, (byte[])localObject, 4, i1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyDiscussMsgResp_PB. dataHash=" + paramObject.hashCode() + ", newDataHash=" + arrayOfByte.hashCode());
      }
      j(paramToServiceMsg, paramFromServiceMsg, arrayOfByte);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.MessageHandler", 2, "<---handleMsgProxyDiscussMsgResp_PB : decode pb:", paramToServiceMsg);
    }
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = paramToServiceMsg.extraData.getBoolean("isRefreshHead", false);
    paramFromServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("lDisUin"));
    if (bool)
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
      if (paramToServiceMsg != null) {
        paramToServiceMsg.putBoolean("success", false);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramFromServiceMsg), 3000, null, null, paramToServiceMsg);
      return;
    }
    paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
    try
    {
      e(String.valueOf(paramFromServiceMsg), "handleGetPullDiscussionMsgError");
      if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.e())
      {
        a(4002, false, null);
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
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.g();
    }
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object arg3)
  {
    msg_svc.PbGetGroupMsgResp localPbGetGroupMsgResp1 = new msg_svc.PbGetGroupMsgResp();
    msg_svc.PbGetGroupMsgResp localPbGetGroupMsgResp2;
    int i1;
    boolean bool1;
    Object localObject;
    long l1;
    try
    {
      localPbGetGroupMsgResp1 = (msg_svc.PbGetGroupMsgResp)localPbGetGroupMsgResp1.mergeFrom((byte[])???);
      if (localPbGetGroupMsgResp1 == null) {
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
      }
      if ((localPbGetGroupMsgResp1 == null) || (??? == null))
      {
        a(paramToServiceMsg, paramFromServiceMsg);
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
      i1 = paramToServiceMsg.extraData.getInt("doSome", 0);
      bool1 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
      label170:
      boolean bool2;
      StringBuilder localStringBuilder1;
      if (paramToServiceMsg.getUin() == null)
      {
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject = paramToServiceMsg.extraData.getString("groupuin");
        if (localObject == null) {
          break label401;
        }
        l1 = Long.valueOf((String)localObject).longValue();
        bool2 = paramToServiceMsg.extraData.getBoolean("isRefreshHead", false);
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder(128);
          StringBuilder localStringBuilder2 = localStringBuilder1.append("handleGetPullTroopMsgResp msgStruct.cReplyCode = ");
          if (localPbGetGroupMsgResp2 != null) {
            break label414;
          }
          localObject = "null";
          label221:
          localStringBuilder2.append(localObject).append(" troopUin: ").append(l1).append(",isRefreshHead:").append(bool2).append(", dataHash=").append(???.hashCode()).append(" rtnBeginSeq:").append(localPbGetGroupMsgResp2.return_begin_seq.get()).append(" rtnEndSeq:").append(localPbGetGroupMsgResp2.return_end_seq.get()).append(",doSome:").append(i1);
          if (localPbGetGroupMsgResp2.msg.get() == null) {
            break label430;
          }
          localStringBuilder1.append(" msgSize:").append(localPbGetGroupMsgResp2.msg.get().size());
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, localStringBuilder1.toString());
        }
        synchronized (a(String.valueOf(l1), 1))
        {
          if (!a(paramToServiceMsg, localPbGetGroupMsgResp2)) {
            break label442;
          }
          return;
        }
        paramFromServiceMsg = paramToServiceMsg.getUin();
        break;
        label401:
        l1 = localPbGetGroupMsgResp2.group_code.get();
        break label170;
        label414:
        localObject = Integer.valueOf(localPbGetGroupMsgResp2.result.get());
        break label221;
        label430:
        localStringBuilder1.append(" msg:null.");
      }
      label442:
      localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(l1);
      if (!bool2) {}
    }
    for (;;)
    {
      try
      {
        a("troop_processor").a(1003, new Object[] { paramToServiceMsg, localPbGetGroupMsgResp2, localObject, paramFromServiceMsg });
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(l1);
        ((TroopMessageProcessor)a("troop_processor")).b("" + l1, i1);
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
        a("troop_processor").a(1002, new Object[] { paramToServiceMsg, localObject, localPbGetGroupMsgResp2, paramFromServiceMsg });
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgResp_PB initGetPullTroopMsg exception ! ", paramToServiceMsg);
          }
          d(String.valueOf(l1), "handleGetPullGroupMsgResp_PB");
        }
      }
      finally
      {
        d(String.valueOf(l1), "handleGetPullGroupMsgResp_PB");
      }
      if (bool1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgResp_PB notify NOTIFY_TYPE_GET_TROOP_MSG_FIN ");
          }
          paramToServiceMsg = "" + l1;
          MsgAutoMonitorUtil.a().g();
          a(4003, true, new String[] { paramToServiceMsg });
        }
      }
      else {
        a(4003, true, new String[] { "" + l1 });
      }
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("seq");
    long l2 = paramToServiceMsg.extraData.getLong("uniseq");
    long l3 = paramToServiceMsg.extraData.getLong("timeOut");
    int i1 = paramToServiceMsg.extraData.getInt("uintype");
    int i2 = paramToServiceMsg.extraData.getInt("msgrandom");
    String str = paramToServiceMsg.extraData.getString("peeruin");
    long l4 = paramToServiceMsg.extraData.getLong("msgSeq");
    MessageUtils.a(i2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<DELMSG><E><---handleDeleteMsgError : uinType :" + i1 + " uin:" + str + " seq:" + l1 + " uniseq:" + l2 + " random:" + i2 + " timeOut:" + l3 + " reqSeq:" + l4);
    }
    b(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = a(l4);
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label231;
      }
      paramToServiceMsg.getClass();
      if (!a(paramToServiceMsg, "msf")) {
        break label231;
      }
    }
    label231:
    while ((1080000L != l3) && (!paramToServiceMsg.a())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---handleDeleteMsgError : Failed at last.");
    }
    a(l4);
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = paramToServiceMsg.extraData.getLong("seq");
    long l2 = paramToServiceMsg.extraData.getLong("uniseq");
    paramToServiceMsg.extraData.getLong("timeOut");
    int i1 = paramToServiceMsg.extraData.getInt("uintype");
    int i2 = paramToServiceMsg.extraData.getInt("msgrandom");
    Object localObject = paramToServiceMsg.extraData.getString("peeruin");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l4 = MessageUtils.a(i2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<DELMSG><R><---handleDeleteMsgResp : uinType :" + i1 + " uin:" + (String)localObject + " seq:" + l1 + " uniseq:" + l2 + " msgUid:" + l4 + " random:" + i2 + " reqSeq:" + l3);
    }
    localObject = new msg_svc.PbDelRoamMsgResp();
    try
    {
      paramObject = (msg_svc.PbDelRoamMsgResp)((msg_svc.PbDelRoamMsgResp)localObject).mergeFrom((byte[])paramObject);
      b(paramToServiceMsg, paramFromServiceMsg);
      paramToServiceMsg = a(l3);
      if (paramToServiceMsg == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<DELMSG><R><---handleSendC2CMessageResp_PB : ---cmd:" + paramFromServiceMsg.getServiceCmd() + ",no SendMessageHandler found.");
        }
        return;
      }
    }
    catch (Exception paramObject)
    {
      do
      {
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.MessageHandler", 2, "<---handleDeleteMsgResp : ParseFrom PbDelRoamMsgResp Error.");
            }
            paramObject = null;
          }
        } while ((paramObject == null) || (!paramObject.result.has()));
        i1 = paramObject.result.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<DELMSG><R><---handleDeleteMsgResp : result :" + i1);
        }
        if (i1 == 0)
        {
          a(l3);
          return;
        }
        if ((i1 != 17) && (i1 != -102) && (i1 != 255)) {
          break;
        }
        paramToServiceMsg.getClass();
      } while (!a(paramToServiceMsg, "server"));
      return;
      if (i1 == 19)
      {
        a(l3);
        return;
      }
      a(l3);
    }
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    b(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = a(l1);
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label66;
      }
      paramToServiceMsg.getClass();
      if (!a(paramToServiceMsg, "msf")) {
        break label66;
      }
    }
    label66:
    while ((480000L != l2) && (!paramToServiceMsg.a())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<ReadReport_All>handleMsgReadedReportError_PB: reqSeq " + l1);
    }
    a(l1);
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    b(paramToServiceMsg, paramFromServiceMsg);
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
            QLog.d("Q.msg.MessageHandler", 2, "<ReadReport_All>GRP replyCode:" + ((msg_svc.PbGroupReadedReportResp)paramToServiceMsg.grp_read_report.get(0)).result.get() + "reqSeq:" + l1);
          }
        }
        a(l1);
        return;
      }
      catch (Exception paramToServiceMsg) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q.msg.MessageHandler", 2, "<ReadReport>handleMsgReadedReportResp_PB : server did not return a valid response,reqSeq " + l1);
  }
  
  public SvcRequestGetMsgV2 a()
  {
    SvcRequestGetMsgV2 localSvcRequestGetMsgV2 = new SvcRequestGetMsgV2();
    localSvcRequestGetMsgV2.lUin = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localSvcRequestGetMsgV2.uDateTime = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b();
    localSvcRequestGetMsgV2.cRecivePic = 1;
    localSvcRequestGetMsgV2.shAbility = 15;
    byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a();
    localSvcRequestGetMsgV2.cChannel = 4;
    localSvcRequestGetMsgV2.cInst = 1;
    localSvcRequestGetMsgV2.cChannelEx = 1;
    localSvcRequestGetMsgV2.cSyncFlag = 0;
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
      localSvcRequestGetMsgV2.vSyncCookie = arrayOfByte;
    }
    localSvcRequestGetMsgV2.cRambleFlag = 0;
    localSvcRequestGetMsgV2.lGeneralAbi = 1L;
    return localSvcRequestGetMsgV2;
  }
  
  public SvcRequestPullDisMsgSeq a()
  {
    SvcRequestPullDisMsgSeq localSvcRequestPullDisMsgSeq = new SvcRequestPullDisMsgSeq(new ArrayList(), (byte)0);
    Object localObject = (ContactFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
    if (localObject != null) {}
    for (localObject = ((ContactFacade)localObject).a("-1004");; localObject = null)
    {
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        this.jdField_b_of_type_ArrayOfJavaLangString = null;
        a(4002, true, null);
        return null;
      }
      int i2 = ((ArrayList)localObject).size();
      this.jdField_b_of_type_ArrayOfJavaLangString = new String[i2];
      StringBuilder localStringBuilder = new StringBuilder();
      int i1 = 0;
      while (i1 < i2)
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((ArrayList)localObject).get(i1);
        MessageSvcPack.PullDisSeqParam localPullDisSeqParam = new MessageSvcPack.PullDisSeqParam();
        localPullDisSeqParam.lDisCode = Long.parseLong(localDiscussionInfo.uin);
        localPullDisSeqParam.lLastSeqId = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.h(localDiscussionInfo.uin);
        this.jdField_b_of_type_ArrayOfJavaLangString[i1] = localDiscussionInfo.uin;
        localSvcRequestPullDisMsgSeq.vDisInfo.add(localPullDisSeqParam);
        if (QLog.isColorLevel()) {
          localStringBuilder.append(localDiscussionInfo.uin).append(",");
        }
        i1 += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>getSvcRequestPullDisMsgSeq disUinArray: " + localStringBuilder.toString());
      }
      return localSvcRequestPullDisMsgSeq;
    }
  }
  
  public SvcRequestPullGroupMsgSeq a(int paramInt)
  {
    int i1 = 0;
    Object localObject = new ArrayList();
    int i2 = MsgFilter.LIMIT_10_AND_IN_3_DAYS.value();
    String[] arrayOfString;
    if (paramInt == 3)
    {
      arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      this.jdField_a_of_type_ArrayOfJavaLangString = arrayOfString;
    }
    while ((arrayOfString == null) || (arrayOfString.length == 0))
    {
      a(4003, true, arrayOfString);
      return null;
      arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    }
    localObject = new SvcRequestPullGroupMsgSeq((ArrayList)localObject, (byte)0, i2);
    StringBuilder localStringBuilder = new StringBuilder();
    while (i1 < arrayOfString.length)
    {
      PullGroupSeqParam localPullGroupSeqParam = new PullGroupSeqParam();
      try
      {
        localPullGroupSeqParam.lGroupCode = Long.parseLong(arrayOfString[i1]);
        localPullGroupSeqParam.lLastSeqId = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.i(arrayOfString[i1]);
        ((SvcRequestPullGroupMsgSeq)localObject).vGroupInfo.add(localPullGroupSeqParam);
        if (QLog.isColorLevel()) {
          localStringBuilder.append("; troopUin=").append(arrayOfString[i1]).append(",").append(" lastSeqId=").append(localPullGroupSeqParam.lLastSeqId);
        }
      }
      catch (Exception localException)
      {
        label190:
        break label190;
      }
      i1 += 1;
    }
    if (paramInt == 3) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c("pull_num_group_msg", 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "--->>getSvcRequestPullGroupMsgSeq troopUinArray: " + localStringBuilder.toString());
    }
    return localObject;
  }
  
  public SvcRequestPullDisGroupSeq a()
  {
    Object localObject;
    if ((this.jdField_b_of_type_ArrayOfJavaLangString == null) || (this.jdField_b_of_type_ArrayOfJavaLangString.length == 0))
    {
      a(4002, true, null);
      localObject = null;
    }
    SvcRequestPullDisGroupSeq localSvcRequestPullDisGroupSeq;
    StringBuilder localStringBuilder;
    label198:
    do
    {
      return localObject;
      new ArrayList();
      localSvcRequestPullDisGroupSeq = new SvcRequestPullDisGroupSeq();
      localObject = new ArrayList();
      int i2 = this.jdField_b_of_type_ArrayOfJavaLangString.length;
      localStringBuilder = new StringBuilder();
      int i1 = 0;
      for (;;)
      {
        if (i1 >= i2) {
          break label198;
        }
        try
        {
          RegisterProxySvcPack.PullDisSeqParam localPullDisSeqParam = new RegisterProxySvcPack.PullDisSeqParam();
          localPullDisSeqParam.lDisCode = Long.parseLong(this.jdField_b_of_type_ArrayOfJavaLangString[i1]);
          localPullDisSeqParam.lLastSeqId = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.h(this.jdField_b_of_type_ArrayOfJavaLangString[i1]);
          ((ArrayList)localObject).add(localPullDisSeqParam);
          if (QLog.isColorLevel()) {
            localStringBuilder.append(this.jdField_b_of_type_ArrayOfJavaLangString[i1]).append(",");
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.MessageHandler", 2, "--->>getSvcRequestPullDisGroupSeq Exception: disUin=" + this.jdField_b_of_type_ArrayOfJavaLangString[i1], localException);
            }
          }
        }
        i1 += 1;
      }
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        a(4002, true, null);
        return null;
      }
      localSvcRequestPullDisGroupSeq.setVDisInfo((ArrayList)localObject);
      localObject = localSvcRequestPullDisGroupSeq;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "--->>getSvcRequestPullDisGroupSeq disUinArray: " + localStringBuilder.toString());
    return localSvcRequestPullDisGroupSeq;
  }
  
  public BaseMessageProcessor a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      return null;
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {}
    for (;;)
    {
      Object localObject;
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
          break label329;
        }
        if ("c2c_processor".equals(paramString))
        {
          localObject = new C2CMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          if (localObject != null) {
            break label312;
          }
          return null;
        }
      }
      if ("troop_processor".equals(paramString))
      {
        localObject = new TroopMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("disc_processor".equals(paramString))
      {
        localObject = new DiscMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("businessbase_processor".equals(paramString))
      {
        localObject = new OnLinePushMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("accost_processor".equals(paramString))
      {
        localObject = new AccostMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("offlinefile_processor".equals(paramString))
      {
        localObject = new OfflineFileMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("system_processor".equals(paramString))
      {
        localObject = new SystemMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("discuss_update_processor".equals(paramString))
      {
        localObject = new DiscMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("info_update_processor".equals(paramString))
      {
        localObject = new ProfileCardMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      else if ("slave_master_processor".equals(paramString))
      {
        localObject = new FileSlaveMasterMessageProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        continue;
        label312:
        ((BaseMessageProcessor)localObject).a(this);
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
        label329:
        return (BaseMessageProcessor)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  public OfflineFileMessageProcessor a()
  {
    return (OfflineFileMessageProcessor)a("offlinefile_processor");
  }
  
  public SystemMessageProcessor a()
  {
    return (SystemMessageProcessor)a("system_processor");
  }
  
  public AppShareID a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString);
  }
  
  public OpenID a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString);
  }
  
  public EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {}
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  public MessageCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
  }
  
  public SendMessageHandler a(long paramLong)
  {
    return (SendMessageHandler)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  protected Class a()
  {
    return MessageObserver.class;
  }
  
  public Object a(String arg1, int paramInt)
  {
    String str = ??? + "_" + paramInt;
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {}
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, new Object());
      }
      return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    }
  }
  
  public HashSet a()
  {
    return this.jdField_a_of_type_JavaUtilHashSet;
  }
  
  public void a()
  {
    a(6006, true, null, true);
  }
  
  public void a(byte paramByte, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbGetMsg><S>--->>getC2CMessage:cChannel:" + paramByte + ",syncFlag:" + paramInt + ",isPullRoamMsg:" + paramBoolean1 + ",newMsgInSync:" + paramBoolean3);
    }
    byte[] arrayOfByte;
    if (!a(paramBoolean3))
    {
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(false);
      arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a();
      if (!paramBoolean1) {
        break label360;
      }
    }
    label360:
    for (byte b1 = 0;; b1 = 1)
    {
      ToServiceMsg localToServiceMsg = a("MessageSvc.PbGetMsg");
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->>getC2CMessage cChannel: " + paramByte + "vCookies: " + paramArrayOfByte + ",cSyncFlag:" + paramInt + ",pullRoamMsg:" + paramBoolean1 + ",onlineSyncFlag:" + b1);
      }
      localToServiceMsg.extraData.putByte("cChannel", paramByte);
      localToServiceMsg.extraData.putByteArray("vCookies", paramArrayOfByte);
      localToServiceMsg.extraData.putInt("cSyncFlag", paramInt);
      localToServiceMsg.extraData.putByteArray("vSyncCookie", arrayOfByte);
      localToServiceMsg.extraData.putByte("onlineSyncFlag", b1);
      localToServiceMsg.extraData.putBoolean("needNofityConversation", paramBoolean2);
      localToServiceMsg.extraData.putBoolean("isPullRoamMsg", paramBoolean1);
      paramArrayOfByte = new msg_svc.PbGetMsgReq();
      if (arrayOfByte != null) {
        paramArrayOfByte.sync_cookie.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      paramArrayOfByte.sync_flag.set(paramInt);
      paramArrayOfByte.ramble_flag.set(0);
      paramArrayOfByte.context_flag.set(1);
      paramArrayOfByte.online_sync_flag.set(b1);
      paramArrayOfByte.latest_ramble_number.set(20);
      paramArrayOfByte.other_ramble_number.set(3);
      localToServiceMsg.putWupBuffer(paramArrayOfByte.toByteArray());
      c(localToServiceMsg);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    label65:
    HashMap localHashMap;
    String[] arrayOfString1;
    String[] arrayOfString2;
    if (paramInt == 1)
    {
      localObject = (String[])this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(-2).get(Integer.valueOf(-2));
      a((String[])localObject);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject);
      localObject = a();
      if (localObject != null)
      {
        this.jdField_b_of_type_ArrayOfJavaLangString = ((String[])localObject[0]);
        if (paramInt == 1) {
          j();
        }
      }
    }
    else
    {
      localHashMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(-1);
      arrayOfString1 = (String[])localHashMap.get(Integer.valueOf(1));
      arrayOfString2 = (String[])localHashMap.get(Integer.valueOf(4));
      if (arrayOfString1 == null) {
        break label330;
      }
    }
    label168:
    label330:
    for (int i1 = arrayOfString1.length + 0;; i1 = 0)
    {
      int i2 = i1;
      if (arrayOfString2 != null) {
        i2 = i1 + arrayOfString2.length;
      }
      if (i2 > 0)
      {
        localObject = new String[i2];
        if (arrayOfString1 != null)
        {
          System.arraycopy(arrayOfString1, 0, localObject, 0, arrayOfString1.length);
          i1 = arrayOfString1.length;
          if (arrayOfString2 != null) {
            System.arraycopy(arrayOfString2, 0, localObject, i1, arrayOfString2.length);
          }
          a((String[])localObject);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject);
        localObject = (String[])localHashMap.get(Integer.valueOf(2));
        if ((localObject != null) && (localObject.length > 0) && (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "enableTroopMsgPushCache type=2, 1st uin=" + localObject[0]);
          }
          i1 = 0;
          while (i1 < localObject.length)
          {
            this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(localObject[i1], 0);
            i1 += 1;
          }
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.msg.MessageHandler", 2, "enableTroopMsgPushCache num troop list is empty!");
        break;
        this.jdField_b_of_type_ArrayOfJavaLangString = null;
        break label65;
        i1 = 0;
        break label168;
        localObject = null;
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i1 = Math.abs(new Random(System.currentTimeMillis()).nextInt());
    long l2 = 0L | 0x80;
    long l1;
    if ((paramInt == 1) || (paramInt == 2))
    {
      l2 = l2 | 0x40 | 0x100 | 0x2;
      l1 = l2;
      if (!paramBoolean) {
        break label155;
      }
      this.bG = i1;
      if (paramInt != 1) {
        break label162;
      }
    }
    label155:
    label162:
    for (Object localObject = "RegPrxySvc.infoLogin";; localObject = "RegPrxySvc.getOffMsg")
    {
      localObject = a((String)localObject);
      ((ToServiceMsg)localObject).extraData.putLong("requestOptional", l2);
      if (paramBoolean) {
        ((ToServiceMsg)localObject).extraData.putInt("endSeq", i1);
      }
      ((ToServiceMsg)localObject).extraData.putInt("type", paramInt);
      a((ToServiceMsg)localObject);
      return;
      l1 = l2;
      if (paramInt == 3)
      {
        l1 = l2;
        if (paramBoolean)
        {
          this.bH = i1;
          l1 = l2;
        }
      }
      l2 = l1;
      break;
    }
  }
  
  public void a(long paramLong)
  {
    SendMessageHandler localSendMessageHandler = a(paramLong);
    if (localSendMessageHandler != null)
    {
      localSendMessageHandler.a();
      a(paramLong);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = a("OnlinePush.RespPush");
    localToServiceMsg.extraData.putInt("svrip", paramInt1);
    localToServiceMsg.extraData.putInt("seq", paramInt2);
    localToServiceMsg.extraData.putLong("lUin", paramLong);
    localToServiceMsg.setNeedCallback(false);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = a("OnlinePush.RespPush");
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localToServiceMsg.extraData.putSerializable("delMsgInfos", paramArrayList);
      localToServiceMsg.extraData.putInt("svrip", paramInt1);
      localToServiceMsg.extraData.putInt("seq", paramInt2);
      localToServiceMsg.extraData.putLong("lUin", paramLong);
      localToServiceMsg.setNeedCallback(false);
      a(localToServiceMsg);
    }
  }
  
  public void a(SvrMsg paramSvrMsg)
  {
    ToServiceMsg localToServiceMsg = a("AccostSvc.SvrMsg");
    localToServiceMsg.extraData.putSerializable("SvrMsg", paramSvrMsg);
    a(localToServiceMsg);
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION".equals(paramIntent.getAction()))
    {
      ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(bE);
      this.f = false;
      if (this.jdField_a_of_type_JavaLangThread != null) {
        this.jdField_a_of_type_JavaLangThread.interrupt();
      }
      paramContext = ((ActivityManager.RunningTaskInfo)((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
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
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_eq", "PC_Online_notice", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(Message paramMessage)
  {
    a().sendMessage(paramMessage);
  }
  
  public void a(MessageForText paramMessageForText)
  {
    if ((paramMessageForText.frienduin != null) && (paramMessageForText.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
      return;
    }
    a(paramMessageForText.frienduin, paramMessageForText.msg, (byte)1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramMessageForText.msgseq, paramMessageForText.uniseq);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject;
    if ((paramMessageRecord == null) || ((paramMessageRecord.istroop != 0) && (paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 3000))) {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("<DELMSG><S>--->deleteMsgFromServerInner:");
        if (paramMessageRecord != null) {
          break label74;
        }
        paramMessageRecord = "mr is Null.";
        QLog.d("Q.msg.MessageHandler", 2, paramMessageRecord);
      }
    }
    label167:
    label433:
    for (;;)
    {
      return;
      label74:
      paramMessageRecord = " isTroop:" + paramMessageRecord.istroop;
      break;
      if ((!MsgProxyUtils.i(paramMessageRecord.msgtype)) && (MsgProxyUtils.b(paramMessageRecord.msgtype)))
      {
        localObject = new ArrayList();
        int i3;
        int i1;
        if ((paramMessageRecord instanceof MessageForLongMsg))
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.MessageHandler", 2, "--->deleteMsgFromServer : is long msg, sent from local, find the prepare slice to del.");
          }
          ((List)localObject).addAll(((MessageForLongMsg)paramMessageRecord).longMsgFragmentList);
          i3 = ((List)localObject).size();
          i1 = 0;
        }
        for (;;)
        {
          if (i1 >= i3) {
            break label433;
          }
          MessageRecord localMessageRecord = (MessageRecord)((List)localObject).get(i1);
          if (localMessageRecord.isSendFromLocal())
          {
            if (paramMessageRecord.extraflag == 32772)
            {
              if (paramMessageRecord.istroop == 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "--->deleteMsgFromServer : delete a sending C2C msg, waitting for the response to complete.");
                }
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord);
                return;
                ((List)localObject).add(paramMessageRecord);
                break label167;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.msg.MessageHandler", 2, "--->deleteMsgFromServer : delete a sending group/dics msg, waitting for the push to complete.");
              return;
            }
            if (paramMessageRecord.extraflag == 32768) {
              break;
            }
          }
          int i2 = MobileQQService.c;
          MobileQQService.c = i2 + 1;
          long l1 = i2;
          SendMessageHandler localSendMessageHandler = new SendMessageHandler();
          a(l1, localSendMessageHandler);
          i2 = 0;
          while (i2 < 12)
          {
            localSendMessageHandler.a(new ctq(this, localMessageRecord, l1));
            i2 += 1;
          }
          i2 = 0;
          if (i2 < 6)
          {
            if (i2 == 0) {}
            for (l1 = 1080000L;; l1 = (6 - i2) * 1080000 / 6 - i2 * 2000)
            {
              long l2 = i2 * 1080000 / 6;
              localSendMessageHandler.getClass();
              localSendMessageHandler.a(l2, l1, "period");
              i2 += 1;
              break;
            }
          }
          i1 += 1;
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver)
  {
    a(paramMessageRecord, paramBusinessObserver, false);
  }
  
  public void a(MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    int i3 = 0;
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    a(paramMessageRecord.msgseq, localSendMessageHandler);
    msg_svc.PbSendMsgReq localPbSendMsgReq = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord);
    if ((paramMessageRecord instanceof MessageForPic)) {
      ((MessageForPic)paramMessageRecord).richText = null;
    }
    while (localPbSendMsgReq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "--->sendRichTextMessageWith_MR : the richText is null!" + paramMessageRecord.getBaseInfoString());
      }
      return;
      if ((paramMessageRecord instanceof MessageForPtt)) {
        ((MessageForPtt)paramMessageRecord).richText = null;
      }
    }
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= 9) {
        break;
      }
      localSendMessageHandler.a(new ctn(this, paramMessageRecord, localPbSendMsgReq, paramBusinessObserver, paramBoolean));
      i1 += 1;
    }
    label148:
    if (i2 < 3) {
      if (i2 != 0) {
        break label202;
      }
    }
    label202:
    for (long l1 = 480000L;; l1 = (3 - i2) * 480000 / 3 - i2 * 2000)
    {
      long l2 = i2 * 480000 / 3;
      localSendMessageHandler.getClass();
      localSendMessageHandler.a(l2, l1, "period");
      i2 += 1;
      break label148;
      break;
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
        if ((paramMessageRecord1 instanceof MessageForFunnyFace))
        {
          Object localObject = (MessageForFunnyFace)paramMessageRecord1;
          if ((((MessageForFunnyFace)localObject).mFunnyFaceMessage == null) || (((MessageForFunnyFace)localObject).mFunnyFaceMessage.faceId != 1)) {
            break;
          }
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
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord1.frienduin, paramMessageRecord1.istroop, paramMessageRecord1.uniseq, paramMessageRecord2.mFunnyFaceMessage.getBytes());
              return;
            }
          }
          catch (Exception paramMessageRecord1) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.msg.MessageHandler", 2, paramMessageRecord1.toString());
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<<---handleError serviceCmd:" + paramFromServiceMsg.getServiceCmd());
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (ProcessorDispatcher.a().containsKey(str)) {
      a(str, paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      int i1;
      do
      {
        return;
        if ("MessageSvc.PbGetMsg".equalsIgnoreCase(str))
        {
          l();
          return;
        }
        if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(str))
        {
          d(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("TransService.ReqGetSign".equalsIgnoreCase(str))
        {
          c(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (!"MessageSvc.PbSendMsg".equalsIgnoreCase(str)) {
          break;
        }
        i1 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
        if ((i1 == 1) || (i1 == 3) || (i1 == 14) || (i1 == 5) || (i1 == 6) || (i1 == 10) || (i1 == 11) || (i1 == 12) || (i1 == 8) || (i1 == 16) || (i1 == 17) || (i1 == 18) || (i1 == 15))
        {
          e(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (i1 == 9)
        {
          a().b(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (i1 == 13)
        {
          a().c(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (i1 == 4)
        {
          h(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
      } while (i1 != 2);
      f(paramToServiceMsg, paramFromServiceMsg);
      return;
      if ("PbMessageSvc.PbDelOneRoamMsg".equalsIgnoreCase(str))
      {
        r(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("AccostSvc.ClientMsg".equalsIgnoreCase(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("PbMessageSvc.PbMsgReadedReport".equalsIgnoreCase(str))
      {
        s(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("MessageSvc.PullGroupMsgSeq".equalsIgnoreCase(str))
      {
        m(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while ((!"MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(str)) && (!"MessageSvc.SetRoamMsg".equalsIgnoreCase(str)));
    k(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    long l1 = System.currentTimeMillis();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(128);
      ((StringBuilder)localObject).append("<<---onReceive success ssoSeq:").append(paramToServiceMsg.getRequestSsoSeq()).append(" serviceCmd: ").append(str).append(",resultCode:").append(paramFromServiceMsg.getResultCode());
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (("StreamSvr.UploadStreamMsg".equals(str)) && (paramFromServiceMsg.getResultCode() != 1000))
    {
      short s1 = paramToServiceMsg.extraData.getShort("PackSeq");
      a(3011, false, new Object[] { new MessageFactoryReceiver.UploadStreamStruct(paramToServiceMsg.extraData.getString("filepath"), s1, paramToServiceMsg.extraData.getShort("flowLayer"), null, 0) });
    }
    if (c(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "cmdfilter error=" + str);
      }
    }
    do
    {
      return;
      if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
      {
        i(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (this.g);
    if (ProcessorDispatcher.a().containsKey(str)) {
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
        MsgAutoMonitorUtil.a().e(System.currentTimeMillis() - l2);
      }
      else if ("RegPrxySvc.PullDisMsgSeq".equalsIgnoreCase(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, (SvcResponsePullDisMsgSeq)paramObject);
      }
      else if ("RegPrxySvc.PullDisGroupSeq".equalsIgnoreCase(str))
      {
        l2 = System.currentTimeMillis();
        a(paramToServiceMsg, paramFromServiceMsg, (SvcResponsePullDisGroupSeq)paramObject);
        MsgAutoMonitorUtil.a().d(System.currentTimeMillis() - l2);
      }
      else if ("RegPrxySvc.NoticeEnd".equalsIgnoreCase(str))
      {
        m(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.PbGetMsg".equalsIgnoreCase(str))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.PbGetGroupMsg".equalsIgnoreCase(str))
      {
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.PbGetDiscussMsg".equalsIgnoreCase(str))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.infoLogin".equalsIgnoreCase(str))
      {
        a(paramFromServiceMsg, paramObject);
      }
      else if ("RegPrxySvc.getOffMsg".equalsIgnoreCase(str))
      {
        a(paramFromServiceMsg, paramObject);
      }
      else if ("MessageSvc.PbGetMsg".equalsIgnoreCase(str))
      {
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b()) {
            break label620;
          }
          k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
        catch (Exception paramToServiceMsg)
        {
          paramToServiceMsg.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.MessageHandler", 2, "handleGetC2CMessageResp_PB exception ! ", paramToServiceMsg);
          }
          l();
        }
        continue;
        label620:
        a("c2c_processor").a(1002, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
      }
      else if (!"MessageSvc.DelMsgV2".equalsIgnoreCase(str))
      {
        if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(str))
        {
          if (paramObject == null) {
            d(paramToServiceMsg, paramFromServiceMsg);
          } else {
            b(paramToServiceMsg, 3012, true, new Object[] { paramObject });
          }
        }
        else
        {
          boolean bool;
          if ("MessageSvc.PushNotify".equalsIgnoreCase(str))
          {
            int i2 = 0;
            bool = false;
            RequestPushNotify localRequestPushNotify;
            if ((paramObject instanceof RequestPushNotify))
            {
              localRequestPushNotify = (RequestPushNotify)paramObject;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.ao = localRequestPushNotify.wUserActive;
              if ((localRequestPushNotify.wGeneralFlag & 0x8) == 8)
              {
                bool = true;
                Long.toString(localRequestPushNotify.lBindedUin);
              }
              i2 = bool;
              if (QLog.isColorLevel()) {
                if (!bool) {
                  break label868;
                }
              }
            }
            label868:
            for (localObject = "SUB_ACCOUNT";; localObject = "Q.msg.MessageHandler")
            {
              QLog.d((String)localObject, 2, "MessageSvc.PushNotify,notify.wUserActive:" + localRequestPushNotify.wUserActive + " isSubAccount=" + bool + " cmd" + localRequestPushNotify.strCmd);
              i2 = bool;
              if (i2 != 0) {
                break;
              }
              c(paramToServiceMsg, paramFromServiceMsg, paramObject);
              break;
            }
          }
          if (("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(str)) || ("MessageSvc.SetRoamMsg".equalsIgnoreCase(str)))
          {
            a(paramToServiceMsg, paramFromServiceMsg, (SvcResponseSetRoamMsg)paramObject);
          }
          else if ("PbMessageSvc.PbDelOneRoamMsg".equalsIgnoreCase(str))
          {
            r(paramToServiceMsg, paramFromServiceMsg, paramObject);
          }
          else if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(str))
          {
            a(paramToServiceMsg, paramFromServiceMsg, (SvcResponseDelRoamMsg)paramObject);
          }
          else if ("PbMessageSvc.PbMsgReadedReport".equalsIgnoreCase(str))
          {
            s(paramToServiceMsg, paramFromServiceMsg, paramObject);
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
            a(paramToServiceMsg, paramFromServiceMsg, (MessageFactoryReceiver.SigStruct)paramObject);
          }
          else if ("StreamSvr.RespUploadStreamMsg".equalsIgnoreCase(str))
          {
            if (paramObject == null) {
              a(3011, false, null);
            } else {
              a(3011, true, new Object[] { (MessageFactoryReceiver.UploadStreamStruct)paramObject });
            }
          }
          else if ("MessageSvc.PbSendMsg".equalsIgnoreCase(str))
          {
            int i1 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
            if ((i1 == 1) || (i1 == 3) || (i1 == 14) || (i1 == 5) || (i1 == 6) || (i1 == 10) || (i1 == 11) || (i1 == 12) || (i1 == 8) || (i1 == 16) || (i1 == 17) || (i1 == 18) || (i1 == 15)) {
              d(paramToServiceMsg, paramFromServiceMsg, paramObject);
            } else if (i1 == 9) {
              a("offlinefile_processor").a(7002, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
            } else if (i1 == 13) {
              a("offlinefile_processor").a(7003, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
            } else if (i1 == 4) {
              h(paramToServiceMsg, paramFromServiceMsg, paramObject);
            } else if (i1 == 2) {
              e(paramToServiceMsg, paramFromServiceMsg, paramObject);
            }
          }
          else if ("StreamSvr.PushStreamMsg".equalsIgnoreCase(str))
          {
            if (paramObject != null)
            {
              paramToServiceMsg = (Object[])paramObject;
              l2 = ((Long)paramToServiceMsg[0]).longValue();
              paramFromServiceMsg = (StreamInfo)paramToServiceMsg[1];
              paramObject = (StreamData)paramToServiceMsg[2];
              long l3 = ((Long)paramToServiceMsg[3]).longValue();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFromServiceMsg, paramObject, l2, l3);
            }
          }
          else if ("AccostSvc.ClientMsg".equalsIgnoreCase(str))
          {
            g(paramToServiceMsg, paramFromServiceMsg, paramObject);
          }
          else if ("AccostSvc.ReqGetBlackList".equalsIgnoreCase(str))
          {
            b(paramToServiceMsg, paramFromServiceMsg, paramObject);
          }
          else if ("OnlinePush.PbPushTransMsg".equalsIgnoreCase(str))
          {
            paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
            paramFromServiceMsg = new byte[paramToServiceMsg.length - 4];
            PkgTools.a(paramFromServiceMsg, 0, paramToServiceMsg, 4, paramToServiceMsg.length - 4);
            paramToServiceMsg = new OnlinePushTrans.PbMsgInfo();
            try
            {
              paramToServiceMsg.mergeFrom(paramFromServiceMsg);
              if (paramToServiceMsg != null)
              {
                if (paramToServiceMsg.msg_type.get() == 207) {
                  b(paramToServiceMsg.msg_data.get().toByteArray());
                }
              }
              else
              {
                paramFromServiceMsg = a("OnlinePush.RespPush");
                if (paramToServiceMsg != null)
                {
                  paramFromServiceMsg.extraData.putInt("svrip", paramToServiceMsg.svr_ip.get());
                  paramFromServiceMsg.extraData.putInt("seq", paramToServiceMsg.msg_seq.get());
                }
                paramFromServiceMsg.extraData.putLong("lUin", Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
                paramFromServiceMsg.setNeedCallback(false);
                a(paramFromServiceMsg);
              }
            }
            catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
            {
              for (;;)
              {
                paramToServiceMsg = null;
                paramFromServiceMsg.printStackTrace();
                continue;
                if ((paramToServiceMsg.msg_type.get() == 44) || (paramToServiceMsg.msg_type.get() == 34)) {
                  a().a(3, 1);
                } else if ((paramToServiceMsg.msg_type.get() != 529) || (paramToServiceMsg.msg_subtype.get() != 11)) {}
              }
            }
          }
          else
          {
            if ("AccostSvc.ReqInsertBlackList".equals(paramFromServiceMsg.getServiceCmd()))
            {
              paramToServiceMsg = paramToServiceMsg.extraData.getString("insertUin");
              if (paramFromServiceMsg.getResultCode() == 1000) {
                ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramToServiceMsg);
              }
              if (paramFromServiceMsg.getResultCode() == 1000) {}
              for (bool = true;; bool = false)
              {
                a(6001, bool, paramToServiceMsg);
                break;
              }
            }
            if ("AccostSvc.ReqDeleteBlackList".equals(paramFromServiceMsg.getServiceCmd()))
            {
              paramToServiceMsg = paramToServiceMsg.extraData.getString("deleteUin");
              if (paramFromServiceMsg.getResultCode() == 1000) {
                ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramToServiceMsg);
              }
              if (paramFromServiceMsg.getResultCode() == 1000) {}
              for (bool = true;; bool = false)
              {
                a(6002, bool, paramToServiceMsg);
                break;
              }
            }
            if ("MessageSvc.PullGroupMsgSeq".equalsIgnoreCase(str))
            {
              paramObject = (SvcResponsePullGroupMsgSeq)paramObject;
              try
              {
                b(paramToServiceMsg, paramFromServiceMsg, paramObject);
              }
              catch (Exception paramObject)
              {
                paramObject.printStackTrace();
                if (QLog.isColorLevel()) {
                  QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp exception ! ", paramObject);
                }
                m(paramToServiceMsg, paramFromServiceMsg);
              }
            }
            else if ("MessageSvc.PbGetGroupMsg".equalsIgnoreCase(str))
            {
              try
              {
                q(paramToServiceMsg, paramFromServiceMsg, paramObject);
              }
              catch (Exception paramObject)
              {
                paramObject.printStackTrace();
                if (QLog.isColorLevel()) {
                  QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgResp_PB exception ! ", paramObject);
                }
                o(paramToServiceMsg, paramFromServiceMsg);
              }
            }
            else if ("MessageSvc.PbGetDiscussMsg".equalsIgnoreCase(str))
            {
              try
              {
                j(paramToServiceMsg, paramFromServiceMsg, paramObject);
              }
              catch (Exception paramObject)
              {
                paramObject.printStackTrace();
                if (QLog.isColorLevel()) {
                  QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgResp_PB exception ! ", paramObject);
                }
                q(paramToServiceMsg, paramFromServiceMsg);
              }
            }
            else if ("MessageSvc.RequestPushStatus".equalsIgnoreCase(str))
            {
              if (paramObject != null)
              {
                paramToServiceMsg = (RequestPushStatus)paramObject;
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "RequestPushStatus status:" + paramToServiceMsg.cStatus + "supportdataline:" + paramToServiceMsg.cDataLine);
                }
                paramFromServiceMsg = (RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(9);
                byte b1 = 0;
                if (paramToServiceMsg.cStatus == 1)
                {
                  b1 = 1;
                  if (QLog.isDevelopLevel()) {
                    QLog.d("Q.msg.MessageHandler", 4, "PConline now");
                  }
                  n();
                }
                for (;;)
                {
                  paramFromServiceMsg.a(b1);
                  paramFromServiceMsg.b(paramToServiceMsg.cDataLine);
                  paramFromServiceMsg.c(paramToServiceMsg.cViewPcFile);
                  paramFromServiceMsg.a(paramToServiceMsg.iPCVersion);
                  a(6007, true, new Object[] { Byte.valueOf(b1), Byte.valueOf(paramToServiceMsg.cDataLine) });
                  break;
                  if (paramToServiceMsg.cStatus == 2)
                  {
                    b1 = 0;
                    if (QLog.isDevelopLevel()) {
                      QLog.d("Q.msg.MessageHandler", 4, "PCoffline now");
                    }
                    m();
                  }
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "RequestPushStatus ret, but data is null");
              }
            }
            else if (("OnlinePush.PbPushGroupMsg".equalsIgnoreCase(str)) || ("OnlinePush.PbPushDisMsg".equalsIgnoreCase(str)) || ("OnlinePush.PbC2CMsgSync".equalsIgnoreCase(str)))
            {
              try
              {
                f(paramToServiceMsg, paramFromServiceMsg, paramObject);
              }
              catch (Exception paramToServiceMsg)
              {
                paramToServiceMsg.printStackTrace();
              }
              if (QLog.isColorLevel()) {
                QLog.w("Q.msg.MessageHandler", 2, "handleMessagePush_PB exception ! ", paramToServiceMsg);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(Long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramLong);
    c(localArrayList);
  }
  
  public void a(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("AccostSvc.ReqInsertBlackList");
    localToServiceMsg.extraData.putString("insertUin", paramString);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramString;
    long[] arrayOfLong = new long[1];
    arrayOfLong[0] = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "getPullTroopMsgNumber troopUinArray.length: " + arrayOfString.length + " troopUinArray:" + arrayOfString + ", lastSeqAry:" + arrayOfLong + ", doSome:" + paramInt);
    }
    paramString = a("MessageSvc.PullGroupMsgSeq");
    paramString.extraData.putStringArray("array_groupuin", arrayOfString);
    paramString.extraData.putLongArray("lastSeqAry", arrayOfLong);
    paramString.extraData.putInt("doSome", paramInt);
    a(paramString);
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    a(paramString, paramInt1, paramLong, paramInt2, paramBoolean, null, false);
  }
  
  public void a(String paramString1, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "----------addFriendTipsMr friendUin: " + paramString1 + " istroop: " + paramInt1 + ", " + paramString2 + ", " + paramBoolean2 + ", sourceId=" + paramInt2);
    }
    if (paramLong < 0L) {
      paramLong = NetConnInfoCenter.getServerTime();
    }
    for (;;)
    {
      MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(-1013);
      localMessageForGrayTips.frienduin = paramString1;
      if (paramInt1 == 1)
      {
        localMessageForGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1, paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131362801), paramLong, -1013, paramInt1, paramLong);
        localMessageForGrayTips.isread = true;
        if (!paramBoolean1) {
          break label464;
        }
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1);
        if (paramString2 == null) {
          break label399;
        }
        paramString2 = paramString2.iterator();
        paramInt1 = 0;
        label181:
        paramInt2 = paramInt1;
        if (!paramString2.hasNext()) {
          break label402;
        }
        MessageRecord localMessageRecord = (MessageRecord)paramString2.next();
        if ((Math.abs(localMessageRecord.time - localMessageForGrayTips.time) >= 30L) || (localMessageRecord.msgtype != localMessageForGrayTips.msgtype)) {
          break label490;
        }
        paramInt1 = 1;
      }
      label399:
      label402:
      label464:
      label490:
      for (;;)
      {
        break label181;
        if (!TextUtils.isEmpty(paramString2))
        {
          if (paramBoolean2) {}
          for (paramInt2 = -1018;; paramInt2 = -1019)
          {
            localMessageForGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1, paramString1, paramString2, paramLong, paramInt2, paramInt1, paramLong);
            break;
          }
        }
        localMessageForGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1, paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131362800), paramLong, -1013, paramInt1, paramLong);
        if ((paramInt2 != 2007) && (paramInt2 != 3007) && (paramInt2 != 2017) && (paramInt2 == 3017)) {}
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Show_addfrd_tips", 0, 0, "", "", "", "");
        break;
        paramInt2 = 0;
        if (paramInt2 == 0) {
          b(localMessageForGrayTips);
        }
        try
        {
          for (;;)
          {
            paramLong = Long.parseLong(paramString1);
            long l1 = Long.parseLong(paramString1);
            long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, l1, paramLong, l2, "", (int)System.currentTimeMillis(), "OidbSvc.0x852_48", (short)34, false, true);
            return;
            b(localMessageForGrayTips);
          }
        }
        catch (NumberFormatException paramString1)
        {
          while (!QLog.isColorLevel()) {}
          QLog.d("Q.msg.MessageHandler", 2, "troopCode not long type!");
          return;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt, paramString, paramLong1))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt, paramString, paramLong1);
      paramString.time = paramLong2;
      paramString.extraflag = 0;
      a(paramString);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, paramLong1, paramLong2, paramLong3);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt, paramString, paramLong1))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt, paramString, paramLong1);
      paramString.shmsgseq = paramLong2;
      paramString.time = paramLong3;
      paramString.extraflag = 0;
      a(paramString);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3, short paramShort, long paramLong4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "--->>getRoamMsgByTime friendUin: " + paramString + " beginTime: " + paramLong1 + " endTime: " + paramLong3 + " middleTime: " + paramLong2 + " maxCnt: " + paramShort + " random: " + paramLong4);
    }
    if ((paramLong4 == 0L) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
    ToServiceMsg localToServiceMsg = a("MessageSvc.PbGetRoamMsg");
    localToServiceMsg.extraData.putLong("lBeginTime", paramLong1);
    localToServiceMsg.extraData.putLong("lEndTime", paramLong3);
    msg_svc.PbGetRoamMsgReq localPbGetRoamMsgReq = new msg_svc.PbGetRoamMsgReq();
    if ((paramLong4 == 0L) && (paramLong2 == 0L))
    {
      localPbGetRoamMsgReq.last_msgtime.set(paramLong3);
      localPbGetRoamMsgReq.peer_uin.set(Long.parseLong(paramString));
      localPbGetRoamMsgReq.random.set(paramLong4);
      paramString = localPbGetRoamMsgReq.read_cnt;
      if (paramShort == 0) {
        break label249;
      }
    }
    for (;;)
    {
      paramString.set(paramShort);
      localToServiceMsg.putWupBuffer(localPbGetRoamMsgReq.toByteArray());
      b(localToServiceMsg);
      return;
      localPbGetRoamMsgReq.last_msgtime.set(paramLong2);
      break;
      label249:
      paramShort = 1000;
    }
  }
  
  public void a(String paramString, long paramLong, short paramShort, Bundle paramBundle)
  {
    Pair localPair = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramString);
    long l1;
    if (localPair == null) {
      l1 = 0L;
    }
    for (;;)
    {
      a(paramString, paramLong, paramShort, paramBundle, l1);
      return;
      long l2 = ((Long)localPair.second).longValue();
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.MessageHandler", 2, "getRoamMsgInOneDay rand=" + l2);
        l1 = l2;
      }
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b(paramString);
      if (localObject != null) {
        break label234;
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
        paramLong2 = MessageCache.a();
      }
      localObject = a("MessageSvc.PbGetOneDayRoamMsg");
      msg_svc.PbGetOneDayRoamMsgReq localPbGetOneDayRoamMsgReq = new msg_svc.PbGetOneDayRoamMsgReq();
      localPbGetOneDayRoamMsgReq.last_msgtime.set(paramLong2);
      localPbGetOneDayRoamMsgReq.peer_uin.set(Long.parseLong(paramString));
      localPbGetOneDayRoamMsgReq.random.set(l1);
      localPbGetOneDayRoamMsgReq.read_cnt.set(paramShort);
      ((ToServiceMsg)localObject).putWupBuffer(localPbGetOneDayRoamMsgReq.toByteArray());
      if (paramBundle != null) {
        ((ToServiceMsg)localObject).extraData.putBundle("context", paramBundle);
      }
      b((ToServiceMsg)localObject);
      return;
      label234:
      paramLong2 = ((Long)((Pair)localObject).second).longValue();
      l1 = paramLong2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.MessageHandler", 2, "getRoamMsgInOneDay rand=" + paramLong2);
        l1 = paramLong2;
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      localFriendsManagerImp.a(localFriendsManagerImp.a(paramString1, paramString2));
    }
  }
  
  public void a(String paramString1, String paramString2, byte paramByte, BusinessObserver paramBusinessObserver)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      return;
    }
    paramBusinessObserver = a("TransService.ReqTmpChatPicDownload", paramBusinessObserver);
    paramBusinessObserver.extraData.putString("selfuin", paramString1);
    paramBusinessObserver.extraData.putString("filekey", paramString2);
    paramBusinessObserver.extraData.putByte("picscale", paramByte);
    a(paramBusinessObserver);
  }
  
  public void a(String paramString1, String paramString2, byte paramByte, String paramString3, long paramLong1, long paramLong2)
  {
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    for (long l1 = 0L; l1 < 3L; l1 += 1L) {
      localSendMessageHandler.postDelayed(new ctp(this, l1, paramString1, paramString2, paramByte, paramString3, paramLong1, paramLong2), 30000L * l1);
    }
    a(paramLong1, localSendMessageHandler);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, short paramShort, int paramInt, long paramLong)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0)) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramString1, "StreamSvr.UploadStreamMsg");
    localToServiceMsg.extraData.putString("selfuin", paramString1);
    localToServiceMsg.extraData.putString("uin", paramString2);
    localToServiceMsg.extraData.putString("filepath", paramString3);
    localToServiceMsg.extraData.putShort("PackSeq", paramShort);
    localToServiceMsg.extraData.putShort("flowLayer", StreamDataManager.a(paramString3));
    localToServiceMsg.extraData.putInt("msgseq", paramInt);
    localToServiceMsg.extraData.putLong("random", paramLong);
    localToServiceMsg.setTimeout(60000L);
    localToServiceMsg.setNeedRemindSlowNetwork(true);
    a(localToServiceMsg);
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
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramString1 + "." + paramString2, 1000, paramBoolean1, null, paramInt, paramBoolean2, paramBoolean3);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        Object localObject = a(str);
        if (((localObject == null) || (System.currentTimeMillis() - ((AppShareID)localObject).updateTime >= 86400000L)) && (this.jdField_a_of_type_JavaUtilHashSet.add(str)))
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
        ConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localArrayList);
      }
    }
  }
  
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    int i2 = 0;
    ToServiceMsg localToServiceMsg = a("MessageSvc.DelMsgV2");
    long[] arrayOfLong;
    Object localObject;
    short[] arrayOfShort;
    int i1;
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      arrayOfLong = new long[paramArrayList1.size()];
      localObject = new int[paramArrayList1.size()];
      arrayOfShort = new short[paramArrayList1.size()];
      i1 = 0;
      while (i1 < paramArrayList1.size())
      {
        arrayOfLong[i1] = ((ctv)paramArrayList1.get(i1)).jdField_a_of_type_Long;
        localObject[i1] = ((ctv)paramArrayList1.get(i1)).jdField_a_of_type_Int;
        arrayOfShort[i1] = ((ctv)paramArrayList1.get(i1)).jdField_a_of_type_Short;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "--->>delC2CMessage i: " + i1 + " fromUin:" + arrayOfLong[i1] + " msgTime: " + localObject[i1] + " msgSeq:" + arrayOfShort[i1]);
        }
        i1 += 1;
      }
      localToServiceMsg.extraData.putLongArray("fromUin", arrayOfLong);
      localToServiceMsg.extraData.putIntArray("msgTime", (int[])localObject);
      localToServiceMsg.extraData.putShortArray("msgSeq", arrayOfShort);
    }
    if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
    {
      paramArrayList1 = new long[paramArrayList2.size()];
      arrayOfLong = new long[paramArrayList2.size()];
      localObject = new long[paramArrayList2.size()];
      arrayOfShort = new short[paramArrayList2.size()];
      i1 = i2;
      while (i1 < paramArrayList2.size())
      {
        paramArrayList1[i1] = ((AccostMessageProcessor.DelAccostMsg)paramArrayList2.get(i1)).jdField_a_of_type_Long;
        arrayOfLong[i1] = ((AccostMessageProcessor.DelAccostMsg)paramArrayList2.get(i1)).b;
        localObject[i1] = ((AccostMessageProcessor.DelAccostMsg)paramArrayList2.get(i1)).c;
        arrayOfShort[i1] = ((AccostMessageProcessor.DelAccostMsg)paramArrayList2.get(i1)).jdField_a_of_type_Short;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "--->>delC2CMessage i: " + i1 + " fromUin:" + paramArrayList1[i1] + " msgId: " + localObject[i1] + " msgType:" + arrayOfShort[i1]);
        }
        i1 += 1;
      }
      localToServiceMsg.extraData.putLongArray("accostFromUin", paramArrayList1);
      localToServiceMsg.extraData.putLongArray("accostToUin", arrayOfLong);
      localToServiceMsg.extraData.putLongArray("accostMsgId", (long[])localObject);
      localToServiceMsg.extraData.putShortArray("accostMsgType", arrayOfShort);
    }
    a(localToServiceMsg);
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
        if (((localMessageRecord instanceof MessageForPic)) || ((localMessageRecord instanceof MessageForMixedMsg))) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, 3);
        }
      }
    }
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg)
  {
    boolean bool = true;
    String str = null;
    if (QLog.isColorLevel()) {
      QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush recv msg0x210.Submsgtype0x51");
    }
    if (paramMsgType0x210.sub_msg_type.get() != 81) {
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush submsgtype != 0x51");
      }
    }
    do
    {
      do
      {
        return;
        if (paramMsgType0x210.msg_content != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush msg_content is null");
      return;
      paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
      if (paramMsgType0x210 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush decode ox210Stream is null");
    return;
    new SubMsgType0x51.MsgBody();
    label344:
    label349:
    label354:
    label359:
    label364:
    for (;;)
    {
      try
      {
        SubMsgType0x51.MsgBody localMsgBody = new SubMsgType0x51.MsgBody();
        localMsgBody.mergeFrom(paramMsgType0x210);
        if (!localMsgBody.bytes_qrsig_url.has()) {
          break label359;
        }
        paramMsgType0x210 = new String(localMsgBody.bytes_qrsig_url.get().toByteArray(), "utf-8");
        if (!localMsgBody.bytes_hint1.has()) {
          break label354;
        }
        paramMsg = new String(localMsgBody.bytes_hint1.get().toByteArray(), "utf-8");
        if (localMsgBody.bytes_hint2.has()) {
          str = new String(localMsgBody.bytes_hint2.get().toByteArray(), "utf-8");
        }
        if (!localMsgBody.uint32_allow_tmp_auth.has()) {
          break label349;
        }
        if (localMsgBody.uint32_allow_tmp_auth.get() != 1) {
          break label344;
        }
      }
      catch (Exception paramMsgType0x210) {}
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush recv devlock quicklogin push qrcode=" + paramMsgType0x210 + " maintip=" + paramMsg + " smalltip" + str);
      }
      EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210, paramMsg, str, bool);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DevLock", 2, "failed to parse msg0x210.Submsgtype0x51");
      return;
      bool = false;
      break label364;
      bool = false;
      continue;
      paramMsg = null;
      continue;
      paramMsgType0x210 = null;
    }
  }
  
  public void a(short paramShort, byte paramByte)
  {
    ToServiceMsg localToServiceMsg = a("MessageSvc.SetRoamMsgAllUser");
    localToServiceMsg.extraData.putShort("shType", paramShort);
    localToServiceMsg.extraData.putByte("cValue", paramByte);
    a(localToServiceMsg);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(s, 2, "Msg Pull Finish picPreDownloadOn");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    LoadingStateManager.a().a(3);
    a(6005, paramBoolean, null, true);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrand", 2, "decodeTurnBrandTipsPush decode msgContent is null");
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject1 = new SubMsgType0x6f.MsgBody();
          ((SubMsgType0x6f.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
          paramArrayOfByte = (SubMsgType0x6f.ForwardBody)((SubMsgType0x6f.MsgBody)localObject1).rpt_msg_mod_infos.get().get(0);
          if (paramArrayOfByte.msg_fanpanzi_notify.has())
          {
            Object localObject2 = (SubMsgType0x6f.FanpaiziNotify)paramArrayOfByte.msg_fanpanzi_notify.get();
            if (((SubMsgType0x6f.FanpaiziNotify)localObject2).uint64_from_uin.has())
            {
              localObject1 = Long.toString(((SubMsgType0x6f.FanpaiziNotify)localObject2).uint64_from_uin.get());
              ((SubMsgType0x6f.FanpaiziNotify)localObject2).str_from_nick.get();
              paramArrayOfByte = "";
              if (((SubMsgType0x6f.FanpaiziNotify)localObject2).bytes_tips_content.has()) {
                paramArrayOfByte = ((SubMsgType0x6f.FanpaiziNotify)localObject2).bytes_tips_content.get().toStringUtf8();
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
              if (((SubMsgType0x6f.FanpaiziNotify)localObject2).bytes_sig.has())
              {
                localObject2 = ((SubMsgType0x6f.FanpaiziNotify)localObject2).bytes_sig.get().toByteArray();
                if (localObject2 != null) {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().h((String)localObject1, (byte[])localObject2);
                }
              }
              AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, paramArrayOfByte, 1001, null, true, true, false);
              if (QLog.isColorLevel())
              {
                QLog.d("TurnBrand", 2, "handle turnbrand push friendUin=" + (String)localObject1 + ",senderUin=" + (String)localObject1);
                return;
              }
            }
          }
        }
        catch (Exception paramArrayOfByte) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("TurnBrand", 2, "failed to get msg0x210.SubMsgType0x6f", paramArrayOfByte);
  }
  
  public boolean a()
  {
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "----------handleMsgNew: " + this.e);
      }
      return this.e;
    }
  }
  
  public boolean a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, Bundle paramBundle)
  {
    long l1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(String.valueOf(paramLong1), 3000);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "--->>getPullDiscussionMsg uin: " + paramLong1 + " beginSeq: " + paramLong2 + " endSeq: " + paramLong3 + " delSeq: " + l1);
    }
    if ((paramLong2 < 0L) || (paramLong3 < 0L)) {
      return false;
    }
    Pair localPair = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(String.valueOf(paramLong1));
    ToServiceMsg localToServiceMsg = a("MessageSvc.PbGetDiscussMsg");
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
    c(localToServiceMsg);
    return true;
  }
  
  public boolean a(long paramLong, SendMessageHandler paramSendMessageHandler)
  {
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), paramSendMessageHandler);
        paramSendMessageHandler.jdField_a_of_type_Long = paramLong;
        return true;
      }
      return false;
    }
  }
  
  public boolean a(SendMessageHandler paramSendMessageHandler, String paramString)
  {
    long l1 = paramSendMessageHandler.a(System.currentTimeMillis());
    boolean bool2;
    if (l1 < 450000L)
    {
      l1 = 480000L - l1 - 5000L;
      bool2 = paramSendMessageHandler.a(0L, l1, paramString);
      bool1 = bool2;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<<<---retrySendMessage scheduleSuccess[" + bool2 + "] msgSeq[" + paramSendMessageHandler.jdField_a_of_type_Long + "] timeout[" + l1 + "] reason[" + paramString + "]");
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if ((bool1) || (!paramSendMessageHandler.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<<<---retrySendMessage Wait SendMessage Retry");
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<<<---retrySendMessage No unfinished retry attampt.");
      }
      return false;
    }
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean, Bundle paramBundle, int paramInt)
  {
    long l1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(paramString, 1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "--->>getPullTroopMsg troopUin2: " + paramString + " beginSeq: " + paramLong1 + " endSeq: " + paramLong2 + " delSeq: " + l1 + " pull num : " + (paramLong2 - paramLong1 + 1L) + " doSome:" + paramInt);
    }
    if ((paramLong1 < 0L) || (paramLong2 < 0L)) {
      return false;
    }
    ToServiceMsg localToServiceMsg = a("MessageSvc.PbGetGroupMsg");
    localToServiceMsg.extraData.putString("groupuin", paramString);
    localToServiceMsg.extraData.putLong("lBeginSeq", paramLong1);
    localToServiceMsg.extraData.putLong("lEndSeq", paramLong2);
    localToServiceMsg.extraData.putBoolean("isRefreshHead", paramBoolean);
    localToServiceMsg.extraData.putBundle("context", paramBundle);
    localToServiceMsg.extraData.putInt("doSome", paramInt);
    paramBundle = new msg_svc.PbGetGroupMsgReq();
    paramBundle.group_code.set(Long.valueOf(paramString).longValue());
    paramBundle.begin_seq.set(paramLong1);
    paramBundle.end_seq.set(paramLong2);
    FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    paramBundle.public_group.set(localFriendManager.f(paramString));
    localToServiceMsg.putWupBuffer(paramBundle.toByteArray());
    c(localToServiceMsg);
    return true;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (paramBoolean1) && ((!paramBoolean2) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause));
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List paramList)
  {
    paramBoolean1 = a(paramBoolean1, paramBoolean2);
    if ((paramBoolean1) && (paramList != null) && (paramList.size() > 0) && (MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)paramList.get(0))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenTroopDebug", 2, "opentroop and hotchattroop msg not notify.");
      }
      return false;
    }
    return paramBoolean1;
  }
  
  public byte[] a()
  {
    Object localObject = new msg_svc.PbGetMsgReq();
    byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a();
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
    PkgTools.a(arrayOfByte, 4, (byte[])localObject, 0, localObject.length);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "--->>createGetMsgReq");
    }
    return arrayOfByte;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "----------resetGetMsgFlag ");
    }
    this.jdField_d_of_type_Boolean = false;
    this.e = false;
  }
  
  public void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
  }
  
  public void b(long paramLong)
  {
    ToServiceMsg localToServiceMsg = a("AccostSvc.ReqGetBlackList");
    localToServiceMsg.extraData.putLong("lNextMid", paramLong);
    a(localToServiceMsg);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMessageRecord);
    if (!paramMessageRecord.isread) {}
    for (boolean bool = true;; bool = false)
    {
      a("addMessageAndNotify", 1000, true, null, 1, a(bool, MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList)), false);
      return;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramToServiceMsg, paramInt, paramBoolean, paramObject);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
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
      long l2 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      long l3 = paramFromServiceMsg.getResultCode();
      long l4 = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 9223372036854775807L);
      SendMessageHandler localSendMessageHandler = a(l1);
      if (localSendMessageHandler != null)
      {
        paramFromServiceMsg = MessageHandlerUtils.a(paramToServiceMsg, paramFromServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<---TimeConsume---> cmd[" + paramToServiceMsg.getServiceCmd() + "] seq[" + l1 + "] retryIndex[" + l2 + "] " + paramFromServiceMsg[0] + "");
        }
        localSendMessageHandler.a((int)l2, l3, l4, paramFromServiceMsg);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "can not found handler");
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && (paramObject != null))
    {
      paramToServiceMsg = (RespGetBlackList)paramObject;
      if (paramToServiceMsg.stHeader.eReplyCode == 0)
      {
        int i2 = paramToServiceMsg.vBlackListUin.size();
        if (i2 > 0)
        {
          paramFromServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
          int i1 = 0;
          while (i1 < i2)
          {
            paramObject = ((Long)paramToServiceMsg.vBlackListUin.get(i1)).longValue() + "";
            if (!paramFromServiceMsg.b(paramObject)) {
              paramFromServiceMsg.a(paramObject);
            }
            i1 += 1;
          }
        }
        if (paramToServiceMsg.lNextMid != -1L) {
          break label135;
        }
      }
    }
    return;
    label135:
    b(paramToServiceMsg.lNextMid);
  }
  
  public void b(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("AccostSvc.ReqDeleteBlackList");
    localToServiceMsg.extraData.putString("deleteUin", paramString);
    a(localToServiceMsg);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (MsgProxyUtils.a(paramString, paramInt))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
      if (paramString != null) {}
    }
    else
    {
      return;
    }
    paramInt = MobileQQService.c;
    MobileQQService.c = paramInt + 1;
    long l1 = paramInt;
    long l2 = System.currentTimeMillis();
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    a(l1, localSendMessageHandler);
    paramInt = 0;
    while (paramInt < 9)
    {
      localSendMessageHandler.a(new ctu(this, paramString, l2, l1));
      paramInt += 1;
    }
    paramInt = 0;
    label95:
    if (paramInt < 3) {
      if (paramInt != 0) {
        break label142;
      }
    }
    label142:
    for (l1 = 480000L;; l1 = (3 - paramInt) * 480000 / 3 - paramInt * 2000)
    {
      l2 = paramInt * 480000 / 3;
      localSendMessageHandler.getClass();
      localSendMessageHandler.a(l2, l1, "period");
      paramInt += 1;
      break label95;
      break;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramString1, paramString2, (byte)1);
    }
  }
  
  public void b(String paramString1, String paramString2, byte paramByte, String paramString3, long paramLong1, long paramLong2)
  {
    long l1 = 480000L * 3L / 3L;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 1001).hasReply) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramString1, paramString2, paramByte, bool, paramString3, paramLong1, paramLong2, l1 - 3L * 2000L);
      return;
    }
  }
  
  public void b(ArrayList paramArrayList)
  {
    a(paramArrayList, true);
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "getC2CMessage:isPullRoamMsg:" + paramBoolean);
    }
    a((byte)3, null, 0, paramBoolean, true, false);
  }
  
  public boolean b()
  {
    boolean bool = false;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("saveTroopMsgFilter. troopSettingList size=");
      if (this.jdField_b_of_type_JavaUtilArrayList != null) {
        break label75;
      }
    }
    label75:
    for (int i1 = 0;; i1 = this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      QLog.d("Q.msg.MessageHandler", 2, i1);
      if (this.jdField_b_of_type_JavaUtilArrayList != null)
      {
        DBUtils.a().a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_b_of_type_JavaUtilArrayList = null;
        bool = true;
      }
      return bool;
    }
  }
  
  public void c()
  {
    this.bD = 0;
    this.bO = 0;
  }
  
  public void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    d(paramInt, paramBoolean, paramObject);
  }
  
  public void c(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("MessageSvc.DelRoamMsg");
    localToServiceMsg.extraData.putString("uin", paramString);
    a(localToServiceMsg);
  }
  
  public void c(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      localFriendsManagerImp.a(localFriendsManagerImp.a(paramString1, paramString2));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      this.jdField_d_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  protected boolean c(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.GetMsgV4");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.PbGetMsg");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.PbBindUinGetMsg");
      this.jdField_a_of_type_JavaUtilSet.add("PbMessageSvc.PbBindUinMsgReadedConfirm");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.DelMsgV2");
      this.jdField_a_of_type_JavaUtilSet.add("TransService.ReqOffFilePack");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.PushNotify");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.SetRoamMsgAllUser");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.SetRoamMsg");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.DelRoamMsg");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.GroupMsgReadConfirm");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.DisMsgReadConfirm");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.MsgReadedReport");
      this.jdField_a_of_type_JavaUtilSet.add("PbMessageSvc.PbMsgReadedReport");
      this.jdField_a_of_type_JavaUtilSet.add("ADMsgSvc.PushMsg");
      this.jdField_a_of_type_JavaUtilSet.add("VideoSvc.Send");
      this.jdField_a_of_type_JavaUtilSet.add("VideoCCSvc.PutInfo");
      this.jdField_a_of_type_JavaUtilSet.add("SharpSvr.c2sack");
      this.jdField_a_of_type_JavaUtilSet.add("SharpSvr.s2c");
      this.jdField_a_of_type_JavaUtilSet.add("OnlinePush.RespPush");
      this.jdField_a_of_type_JavaUtilSet.add("OnlinePush.ReqPush");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.PushReaded");
      this.jdField_a_of_type_JavaUtilSet.add("TransService.ReqTmpChatPicDownload");
      this.jdField_a_of_type_JavaUtilSet.add("TransService.ReqGetSign");
      this.jdField_a_of_type_JavaUtilSet.add("OnlinePush.PbPushTransMsg");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.PbSendMsg");
      this.jdField_a_of_type_JavaUtilSet.add("StreamSvr.RespUploadStreamMsg");
      this.jdField_a_of_type_JavaUtilSet.add("StreamSvr.PushStreamMsg");
      this.jdField_a_of_type_JavaUtilSet.add("AccostSvc.ClientMsg");
      this.jdField_a_of_type_JavaUtilSet.add("AccostSvc.SvrMsg");
      this.jdField_a_of_type_JavaUtilSet.add("AccostSvc.ReqInsertBlackList");
      this.jdField_a_of_type_JavaUtilSet.add("AccostSvc.ReqGetBlackList");
      this.jdField_a_of_type_JavaUtilSet.add("AccostSvc.ReqDeleteBlackList");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.PbGetDiscussMsg");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.PbGetGroupMsg");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.PullGroupMsgSeq");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.RequestPushStatus");
      this.jdField_a_of_type_JavaUtilSet.add("OnlinePush.PbPushGroupMsg");
      this.jdField_a_of_type_JavaUtilSet.add("OnlinePush.PbPushDisMsg");
      this.jdField_a_of_type_JavaUtilSet.add("OnlinePush.PbC2CMsgSync");
      this.jdField_a_of_type_JavaUtilSet.add("RegPrxySvc.PbGetMsg");
      this.jdField_a_of_type_JavaUtilSet.add("RegPrxySvc.GetMsgV2");
      this.jdField_a_of_type_JavaUtilSet.add("RegPrxySvc.PullGroupMsgSeq");
      this.jdField_a_of_type_JavaUtilSet.add("RegPrxySvc.PullDisMsgSeq");
      this.jdField_a_of_type_JavaUtilSet.add("RegPrxySvc.PullDisGroupSeq");
      this.jdField_a_of_type_JavaUtilSet.add("RegPrxySvc.NoticeEnd");
      this.jdField_a_of_type_JavaUtilSet.add("RegPrxySvc.PbGetGroupMsg");
      this.jdField_a_of_type_JavaUtilSet.add("RegPrxySvc.PbGetDiscussMsg");
      this.jdField_a_of_type_JavaUtilSet.add("RegPrxySvc.getOffMsg");
      this.jdField_a_of_type_JavaUtilSet.add("RegPrxySvc.infoLogin");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.PbGetRoamMsg");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.PbGetOneDayRoamMsg");
      this.jdField_a_of_type_JavaUtilSet.add("PbMessageSvc.PbDelOneRoamMsg");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.Pb.ReqSystemMsg");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.Pb.ReqNextSystemMsg");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.Pb.ReqSystemMsgRead");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.Pb.ReqSystemMsgAction");
      this.jdField_a_of_type_JavaUtilSet.add("NearFieldTranFileSvr.NotifyList");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.Pb.ReqSystemMsgNew");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.Pb.ReqSystemMsgNew.Friend");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.Pb.ReqSystemMsgNew.Group");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.g = true;
    c();
    b();
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.d();
    AudioUtil.a();
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    h();
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() != null) {
          ((SendMessageHandler)localEntry.getValue()).a();
        }
      }
    }
    this.jdField_b_of_type_JavaUtilHashMap.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void d(String paramString)
  {
    a(paramString, 0);
  }
  
  public void d(boolean paramBoolean)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
    int i1;
    if ((localList != null) && (!localList.isEmpty()))
    {
      i1 = 0;
      if ((i1 < localList.size()) && (i1 < 40)) {}
    }
    else
    {
      c(false);
      if (!paramBoolean) {
        break label453;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "checkBreakPoint syncC2CMsg");
      }
      b(true);
    }
    label453:
    while (!a())
    {
      return;
      RecentUser localRecentUser = (RecentUser)localList.get(i1);
      int i2;
      if (localRecentUser.type == 1)
      {
        i2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(localRecentUser.uin);
        if (((i2 == 1) || (i2 == 4)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localRecentUser.uin, 1))) {}
      }
      for (;;)
      {
        i1 += 1;
        break;
        Pair localPair = a(localRecentUser.uin, 1);
        i2 = (int)(((Long)localPair.second).longValue() - ((Long)localPair.first).longValue());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "checkBreakPoint troopUin: " + localRecentUser.uin + " msg count: " + i2);
        }
        if (i2 > 0)
        {
          try
          {
            a(localRecentUser.uin, ((Long)localPair.first).longValue() + 1L, ((Long)localPair.second).longValue(), false, null, 0);
          }
          catch (Exception localException1) {}
          continue;
          if ((localException1.type == 3000) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localException1.uin, 3000)))
          {
            localPair = a(localException1.uin, 3000);
            i2 = (int)(((Long)localPair.second).longValue() - ((Long)localPair.first).longValue());
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "checkBreakPoint discUin: " + localException1.uin + " msg count: " + i2);
            }
            if (i2 > 0) {
              try
              {
                a(Long.valueOf(localException1.uin).longValue(), ((Long)localPair.first).longValue() + 1L, ((Long)localPair.second).longValue(), false, null);
              }
              catch (Exception localException2) {}
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "checkBreakPoint getNewC2CMsg");
    }
    b(false);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a(false);
    c(false);
    a(false);
  }
  
  public void e(String paramString)
  {
    if (a(paramString) != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("openid", 2, "get openid key = " + paramString);
    }
    AccountManager localAccountManager = (AccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0);
    HashMap localHashMap = new HashMap();
    RequestCustomSig localRequestCustomSig = new RequestCustomSig();
    localRequestCustomSig.ulCustumFlag = 8192L;
    localRequestCustomSig.ulSType = 1L;
    localRequestCustomSig.reserved = new byte[0];
    localHashMap.put("RequestCustomSig", localRequestCustomSig);
    localHashMap.put("OpenAppid", paramString);
    localAccountManager.changeToken(localHashMap, new ctr(this, paramString));
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "flushDiscussionAndTroopMsg begin.");
    }
    ConcurrentHashMap localConcurrentHashMap1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.a();
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
            break label239;
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
        localConcurrentHashMap2 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b();
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
    else
    {
      label113:
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
                label186:
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
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b();
      return;
      bool = false;
      break;
      label239:
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "flushDiscussionAndTroopMsg, troopSize=" + localArrayList.size());
      }
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext()) {
        d((String)localIterator.next(), "flushDiscussionAndTroopMsg");
      }
      break label113;
      bool = false;
      break label186;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "flushDiscussionAndTroopMsg, disSize=" + localArrayList.size());
      }
      localIterator = localArrayList.iterator();
      while (localIterator.hasNext()) {
        e((String)localIterator.next(), "flushDiscussionAndTroopMsg");
      }
    }
  }
  
  public void g()
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ArrayOfCtx != null) {
          break label193;
        }
        this.jdField_c_of_type_JavaUtilArrayList = new ArrayList(20);
        this.jdField_d_of_type_JavaUtilArrayList = new ArrayList(10);
        this.jdField_a_of_type_ArrayOfCtx = new ctx[6];
        break label193;
        if (i1 < this.jdField_a_of_type_ArrayOfCtx.length)
        {
          if ((this.jdField_a_of_type_ArrayOfCtx[i1] != null) && (!this.jdField_a_of_type_ArrayOfCtx[i1].a())) {
            break label198;
          }
          if (i1 == 0)
          {
            this.jdField_a_of_type_ArrayOfCtx[i1] = new ctx(this, this.jdField_d_of_type_JavaUtilArrayList);
            this.jdField_a_of_type_ArrayOfCtx[i1].setName("MessageHandleThread" + (i1 + 1));
            this.jdField_a_of_type_ArrayOfCtx[i1].setPriority(5);
            this.jdField_a_of_type_ArrayOfCtx[i1].start();
            break label198;
          }
          this.jdField_a_of_type_ArrayOfCtx[i1] = new ctx(this, this.jdField_c_of_type_JavaUtilArrayList);
        }
      }
      return;
      label193:
      int i1 = 0;
      continue;
      label198:
      i1 += 1;
    }
  }
  
  public void h()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ArrayOfCtx != null)
      {
        int i1 = 0;
        while (i1 < this.jdField_a_of_type_ArrayOfCtx.length)
        {
          this.jdField_a_of_type_ArrayOfCtx[i1].a();
          i1 += 1;
        }
      }
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        this.jdField_c_of_type_JavaUtilArrayList.notifyAll();
        this.jdField_d_of_type_JavaUtilArrayList = null;
        this.jdField_c_of_type_JavaUtilArrayList = null;
        this.jdField_a_of_type_ArrayOfCtx = null;
        return;
      }
    }
  }
  
  public void i()
  {
    ConcurrentHashMap localConcurrentHashMap;
    Object localObject1;
    Object localObject2;
    int i1;
    Object localObject3;
    String str;
    int i2;
    long l1;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f())
    {
      localConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
      localObject1 = new ArrayList();
      localObject2 = localConcurrentHashMap.entrySet().iterator();
      i1 = 0;
      if (((Iterator)localObject2).hasNext())
      {
        Iterator localIterator = ((ConcurrentHashMap)((Map.Entry)((Iterator)localObject2).next()).getValue()).entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (MessageCache.MsgSendingInfo)((Map.Entry)localIterator.next()).getValue();
          str = ((MessageCache.MsgSendingInfo)localObject3).jdField_a_of_type_JavaLangString;
          i2 = ((MessageCache.MsgSendingInfo)localObject3).jdField_a_of_type_Int;
          l1 = ((MessageCache.MsgSendingInfo)localObject3).jdField_a_of_type_Long;
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, i2, l1);
          if (localObject3 == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(str, i2, l1);
          }
          else
          {
            if (!(localObject3 instanceof ChatMessage)) {
              break label664;
            }
            ((ChatMessage)localObject3).parse();
            if (!(localObject3 instanceof MessageForStructing)) {
              break label664;
            }
            MessageForStructing localMessageForStructing = (MessageForStructing)localObject3;
            if ((localMessageForStructing.structingMsg == null) || (localMessageForStructing.structingMsg.mMsgServiceID != 35)) {
              break label664;
            }
            i1 = 1;
          }
        }
      }
    }
    label664:
    for (;;)
    {
      long l2 = ((MessageRecord)localObject3).time;
      long l3 = MessageCache.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "msgSending:setMsgSendingInfo, uin:" + str + " istroop:" + i2 + " uniseq:" + l1 + " time:" + l2 + " currentServerTime:" + l3);
      }
      if ((i1 != 0) || ((l3 - l2) * 1000L + 30000L >= 480000L) || (l3 - l2 < 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "msgSending:msg sending flag set to failed");
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, i2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(str, i2, l1);
        if ((localObject3 != null) && (((QQMessageFacade.Message)localObject3).uniseq == l1)) {
          ((QQMessageFacade.Message)localObject3).extraflag = 32768;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, i2, l1, 32768, 1002);
        a(6003, false, new String[] { str });
      }
      for (;;)
      {
        break;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "msgSending:resend msg, key =" + ((MessageRecord)localObject3).uniseq + "+" + ((MessageRecord)localObject3).frienduin + "+" + ((MessageRecord)localObject3).istroop);
        }
        MsgProxyUtils.b((List)localObject1, (MessageRecord)localObject3, true);
      }
      break;
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((MessageRecord)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "msgSending:addSendingCache suc");
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject2);
          a((MessageRecord)localObject2, null, true);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "msgSending:last, msgSendingTemp:" + localConcurrentHashMap);
      }
      localConcurrentHashMap.clear();
      return;
    }
  }
  
  public void j()
  {
    int i1 = 0;
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      localObject2 = ((SharedPreferences)localObject1).getString("msgSending", null);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "msgSending:init,read msgSending file," + (String)localObject2 + " msgCache:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().hashCode());
      }
      if (localObject2 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONArray((String)localObject2);
        if (i1 < ((JSONArray)localObject2).length())
        {
          if (((JSONArray)localObject2).isNull(i1)) {
            break label304;
          }
          Object localObject3 = ((JSONArray)localObject2).getJSONObject(i1);
          String str = ((JSONObject)localObject3).getString("uin");
          int i2 = ((JSONObject)localObject3).getInt("type");
          long l1 = ((JSONObject)localObject3).getLong("uniseq");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(str, i2, l1);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, i2, l1);
          if (localObject3 == null) {
            break label304;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((MessageRecord)localObject3);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject3);
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "msgSending:init,read msgSending file," + localException.getMessage());
        }
        localException.printStackTrace();
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).remove("msgSending");
        ((SharedPreferences.Editor)localObject1).commit();
      }
      return;
      label304:
      i1 += 1;
    }
  }
  
  public void k()
  {
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if (localPbMsgReadedReportReq == null) {
      return;
    }
    int i1 = MobileQQService.c;
    MobileQQService.c = i1 + 1;
    long l1 = i1;
    long l2 = System.currentTimeMillis();
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    a(l1, localSendMessageHandler);
    i1 = 0;
    while (i1 < 9)
    {
      localSendMessageHandler.a(new ctt(this, localPbMsgReadedReportReq, l2, l1));
      i1 += 1;
    }
    i1 = 0;
    label88:
    if (i1 < 3) {
      if (i1 != 0) {
        break label135;
      }
    }
    label135:
    for (l1 = 480000L;; l1 = (3 - i1) * 480000 / 3 - i1 * 2000)
    {
      l2 = i1 * 480000 / 3;
      localSendMessageHandler.getClass();
      localSendMessageHandler.a(l2, l1, "period");
      i1 += 1;
      break label88;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler
 * JD-Core Version:    0.7.0.1
 */