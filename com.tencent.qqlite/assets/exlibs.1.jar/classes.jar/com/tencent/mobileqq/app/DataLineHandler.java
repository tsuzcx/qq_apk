package com.tencent.mobileqq.app;

import IMMsgBodyPack.MsgType0x210SubMsgType0x13;
import IMMsgBodyPack.MsgType0x210SubMsgType0x13_MsgItem;
import IMMsgBodyPack.Type_1_QQDataTextMsg;
import MessageSvcPack.UinPairReadInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteWifiphotoActivity;
import com.dataline.core.MoloHandler;
import com.dataline.mpfile.MpFileConstant;
import com.dataline.mpfile.MpfileDataCenter;
import com.dataline.util.DBNetworkUtil;
import com.dataline.util.DataLineReportUtil;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.GifDrawable;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.ApplyDownloadReq;
import com.tencent.litetransfersdk.ApplyUploadHitReq;
import com.tencent.litetransfersdk.ApplyUploadReq;
import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgCSBody0x346;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.HttpServer;
import com.tencent.mobileqq.service.TextMsgPush;
import com.tencent.mobileqq.service.TextMsgTask;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.TransMsgContext;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import crb;
import crc;
import crd;
import cre;
import crf;
import crg;
import crh;
import cri;
import crj;
import crk;
import crl;
import crm;
import cro;
import crp;
import crq;
import crr;
import crs;
import crt;
import cru;
import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.PbSendMsgResp;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitReqV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV3;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.msg.im_msg_head.InstCtrl;
import tencent.im.msg.im_msg_head.InstInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.ActionInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FTNNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FileControl;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MoloNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MpFileNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.NFCNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.RNFCNotify;
import wifiphoto.WifiPhotoDataCenter;
import wifiphoto.WifiPhotoMsgStrategy;
import wifiphoto.WifiPhotoStatusMgr;

public class DataLineHandler
  extends BusinessHandler
{
  public static final int A = 1006;
  public static final int B = 1007;
  public static final int C = 1;
  public static final int D = 2;
  public static final int E = 3;
  public static final int F = 4;
  public static final int G = 5;
  public static final int H = 6;
  public static final int I = 7;
  public static final int J = 528;
  private static int K = 0;
  private static final int L = 38;
  private static final int M = 104;
  private static int N = 0;
  public static final int a = 5;
  public static final long a = 9223372036854775807L;
  public static final String a = "DataLineHandler";
  public static WifiPhotoDataCenter a;
  public static final int b = 50;
  private static final String jdField_b_of_type_JavaLangString = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600";
  public static final int c = 1;
  private static final String jdField_c_of_type_JavaLangString = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700";
  public static final int d = 2;
  private static final String d = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800";
  public static final int e = 3;
  private static final String e = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200";
  public static final int f = 4;
  private static final String f = "datalineSendTimekey";
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  public static final int k = 9;
  public static final int l = 10;
  public static final int m = 11;
  public static final int n = 14;
  public static final int o = 15;
  public static final int p = 16;
  public static final int q = 17;
  public static final int r = 2;
  public static final int s = 10;
  public static final int t = 14;
  public static final int u = 19;
  public static final int v = 1001;
  public static final int w = 1002;
  public static final int x = 1003;
  public static final int y = 1004;
  public static final int z = 1005;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private MoloHandler jdField_a_of_type_ComDatalineCoreMoloHandler = new MoloHandler(this);
  private MpfileDataCenter jdField_a_of_type_ComDatalineMpfileMpfileDataCenter = null;
  public LiteTransferWrapper a;
  public MsgHeader a;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new crg(this);
  public HttpServer a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList;
  Timer jdField_a_of_type_JavaUtilTimer;
  TimerTask jdField_a_of_type_JavaUtilTimerTask;
  protected Vector a;
  public boolean a;
  private long jdField_b_of_type_Long = 0L;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private Timer jdField_b_of_type_JavaUtilTimer;
  public boolean b;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_WifiphotoWifiPhotoDataCenter = new WifiPhotoDataCenter(BaseApplication.getContext());
  }
  
  DataLineHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentLitetransfersdkMsgHeader = new MsgHeader();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper = new LiteTransferWrapper(this);
    o();
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new crb(this, paramQQAppInterface);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addAction("com.tencent.dataline.wifiphoto.ACTION_WIFIPHOTO_CONNECTED");
    localIntentFilter.addAction("mqql.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqql.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqql.intent.action.FORCE_LOGOUT");
    localIntentFilter.addAction("mqql.intent.action.EXIT_" + paramQQAppInterface.a().getPackageName());
    localIntentFilter.addAction("mqql.intent.action.LOGOUT");
    paramQQAppInterface.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (!jdField_a_of_type_WifiphotoWifiPhotoDataCenter.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr.a())
    {
      paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendMessage(paramQQAppInterface.obtainMessage(1134022));
      }
    }
    m();
  }
  
  public static int a(DataLineHandler.EFILETYPE paramEFILETYPE)
  {
    switch (crn.a[paramEFILETYPE.ordinal()])
    {
    case 2: 
    default: 
      return -2005;
    case 1: 
      return -2000;
    }
    return -2009;
  }
  
  public static DataLineHandler.EFILETYPE a(int paramInt)
  {
    DataLineHandler.EFILETYPE localEFILETYPE = DataLineHandler.EFILETYPE.FILE_TYPE_FILE;
    switch (paramInt)
    {
    default: 
      return DataLineHandler.EFILETYPE.FILE_TYPE_FILE;
    case -2000: 
      return DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE;
    }
    return DataLineHandler.EFILETYPE.FILE_TYPE_VIDEO;
  }
  
  private msg_svc.PbSendMsgReq a(int paramInt1, String paramString, TransMsgContext paramTransMsgContext, long paramLong1, int paramInt2, long paramLong2)
  {
    return MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramString, paramTransMsgContext, paramLong1, paramInt2);
  }
  
  private void a(int paramInt, short paramShort, MsgType0x210SubMsgType0x13 paramMsgType0x210SubMsgType0x13)
  {
    if (paramMsgType0x210SubMsgType0x13.uint32_type == 1L) {
      d(paramInt, paramShort, paramMsgType0x210SubMsgType0x13);
    }
    do
    {
      do
      {
        return;
      } while ((paramMsgType0x210SubMsgType0x13.uint32_type != 3L) && (paramMsgType0x210SubMsgType0x13.uint32_type != 5L));
      if (paramMsgType0x210SubMsgType0x13.uint32_type == 3L)
      {
        b(paramInt, paramShort, paramMsgType0x210SubMsgType0x13);
        return;
      }
    } while (paramMsgType0x210SubMsgType0x13.uint32_type != 5L);
    c(paramInt, paramShort, paramMsgType0x210SubMsgType0x13);
  }
  
  private void a(int paramInt, short paramShort, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("wifiphoto", 2, "handleWifiphotoType3MsgPush");
    }
    if (!DBNetworkUtil.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("wifiphoto", 2, "WiFi status is disabled");
      }
      t();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("wifiphoto", 2, "handleWifiphotoType3MsgPush sendWifiPhotoAskHandShake");
    }
    s();
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, List paramList)
  {
    paramList = paramList.iterator();
    Object localObject;
    DataLineMsgRecord localDataLineMsgRecord;
    int i1;
    while (paramList.hasNext())
    {
      localObject = (SubMsgType0x7.MsgBody.MoloNotify)paramList.next();
      if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).bytes_buf.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "应用宝消息  moloHandler SubCmd0x5 do not has bytes_buf");
        }
      }
      else
      {
        localDataLineMsgRecord = this.jdField_a_of_type_ComDatalineCoreMoloHandler.a(((SubMsgType0x7.MsgBody.MoloNotify)localObject).bytes_buf.get().toByteArray());
        if (localDataLineMsgRecord == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "应用宝消息 moloHandler dealWith return null");
          }
        }
        else
        {
          if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_id.has()) {
            break label363;
          }
          i1 = ((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_id.get();
          localDataLineMsgRecord.groupId = i1;
          if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_size.has()) {
            break label369;
          }
          i1 = ((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_size.get();
          label152:
          localDataLineMsgRecord.groupSize = i1;
          if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_curindex.has()) {
            break label375;
          }
          i1 = ((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_curindex.get();
          label180:
          localDataLineMsgRecord.groupIndex = i1;
          if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "应用宝消息 groupId[" + localDataLineMsgRecord.groupId + "],size[" + localDataLineMsgRecord.groupSize + "],index[" + localDataLineMsgRecord.groupIndex + "], sessionid[" + localDataLineMsgRecord.sessionid + "], key[" + localDataLineMsgRecord.strMoloKey);
          }
          if (localDataLineMsgRecord.groupSize == 1)
          {
            localDataLineMsgRecord.groupId = 0;
            localDataLineMsgRecord.groupSize = 0;
            localDataLineMsgRecord.groupIndex = 0;
          }
          if ((DataLineMsgSet.isSingle(localDataLineMsgRecord)) || (!a(localDataLineMsgRecord.groupId))) {
            break label381;
          }
          if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "应用宝消息msg record in deleted group, sessionid[" + localDataLineMsgRecord.sessionid);
          }
        }
      }
    }
    label363:
    label369:
    label375:
    label381:
    do
    {
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label152;
      i1 = 0;
      break label180;
      a().a().a().a(localDataLineMsgRecord, true);
      if ((DataLineMsgSet.isSingle(localDataLineMsgRecord)) || (!a(localDataLineMsgRecord.groupId))) {
        break label484;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "应用宝消息 msg record in deleted group 2, sessionid[" + localDataLineMsgRecord.sessionid);
      }
      paramList = a().a().a(localDataLineMsgRecord.sessionid);
    } while (paramList == null);
    a(paramList);
    return;
    label484:
    label503:
    boolean bool;
    if (DataLineMsgSet.isSingle(localDataLineMsgRecord))
    {
      DataLineReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      n();
      bool = false;
      if (!a(localDataLineMsgRecord.sessionid, localDataLineMsgRecord.groupId)) {
        break label649;
      }
    }
    for (;;)
    {
      b(6, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf((byte)DataLineHandler.EFILETYPE.FILE_TYPE_FILE.ordinal()), Boolean.valueOf(false), Boolean.valueOf(bool), Long.valueOf(localDataLineMsgRecord.filesize) });
      break;
      localObject = a().a().a(localDataLineMsgRecord.groupId);
      if ((localObject != null) && (((DataLineMsgSet)localObject).getComeCount() != 1)) {
        break label503;
      }
      DataLineReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      n();
      break label503;
      label649:
      localDataLineMsgRecord.issuc = true;
      localDataLineMsgRecord.fileMsgStatus = 1L;
      bool = NetworkUtil.g(BaseApplication.getContext());
      if (localDataLineMsgRecord.filesize <= 5242880L)
      {
        i1 = 1;
        label684:
        if ((!bool) && ((!c()) || (i1 == 0))) {
          break label768;
        }
        bool = true;
        if (bool) {
          localDataLineMsgRecord.fileMsgStatus = 0L;
        }
      }
      try
      {
        b(111);
        this.jdField_a_of_type_ComDatalineCoreMoloHandler.a(localDataLineMsgRecord.strMoloKey);
        DataLineReportUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        label741:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().c(localDataLineMsgRecord.msgId);
        continue;
        i1 = 0;
        break label684;
        label768:
        bool = false;
      }
      catch (Exception localException)
      {
        break label741;
      }
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList)
  {
    new Handler(Looper.getMainLooper()).post(new crk(this, paramMsgHeader, paramList));
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SubMsgType0x7.MsgBody.FTNNotify localFTNNotify = (SubMsgType0x7.MsgBody.FTNNotify)paramList.next();
      if ((localFTNNotify.uint64_sessionid.has()) && (localFTNNotify.uint32_originfiletype.has()) && (localFTNNotify.str_file_name.has()) && (localFTNNotify.uint64_file_len.has()) && (localFTNNotify.bytes_file_md5.has()) && (localFTNNotify.str_file_index.has())) {
        localArrayList.add(localFTNNotify);
      }
    }
    if (localArrayList.size() > 0) {
      new Handler(Looper.getMainLooper()).post(new cri(this, paramMsgHeader, localArrayList, paramBoolean));
    }
  }
  
  private void a(long paramLong1, long paramLong2, List paramList)
  {
    paramList = paramList.iterator();
    label260:
    label265:
    label269:
    while (paramList.hasNext())
    {
      Object localObject = (SubMsgType0x7.MsgBody.MpFileNotify)paramList.next();
      label52:
      int i1;
      label73:
      int i2;
      if (((SubMsgType0x7.MsgBody.MpFileNotify)localObject).fixed32_ip.has())
      {
        paramLong1 = ((SubMsgType0x7.MsgBody.MpFileNotify)localObject).fixed32_ip.get();
        if (!((SubMsgType0x7.MsgBody.MpFileNotify)localObject).uint32_port.has()) {
          break label248;
        }
        i1 = ((SubMsgType0x7.MsgBody.MpFileNotify)localObject).uint32_port.get();
        if (!((SubMsgType0x7.MsgBody.MpFileNotify)localObject).uint32_operate.has()) {
          break label254;
        }
        i2 = ((SubMsgType0x7.MsgBody.MpFileNotify)localObject).uint32_operate.get();
        label94:
        if (!((SubMsgType0x7.MsgBody.MpFileNotify)localObject).uint64_sessionid.has()) {
          break label260;
        }
        paramLong2 = ((SubMsgType0x7.MsgBody.MpFileNotify)localObject).uint64_sessionid.get();
        label114:
        if (!((SubMsgType0x7.MsgBody.MpFileNotify)localObject).uint32_type.has()) {
          break label265;
        }
      }
      for (int i3 = ((SubMsgType0x7.MsgBody.MpFileNotify)localObject).uint32_type.get();; i3 = 0)
      {
        if (i3 == 1) {
          break label269;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putLong("ip", paramLong1);
        ((Bundle)localObject).putInt("port", i1);
        ((Bundle)localObject).putInt("result", i2);
        ((Bundle)localObject).putLong(MpFileConstant.f, paramLong2);
        ((Bundle)localObject).putInt(MpFileConstant.e, 0);
        Intent localIntent = new Intent();
        localIntent.setAction(MpFileConstant.d);
        localIntent.putExtras((Bundle)localObject);
        a().a(localIntent);
        BaseApplication.getContext().sendBroadcast(localIntent);
        break;
        paramLong1 = 0L;
        break label52;
        label248:
        i1 = 0;
        break label73;
        label254:
        i2 = 0;
        break label94;
        paramLong2 = 0L;
        break label114;
      }
    }
  }
  
  private void a(long paramLong1, long paramLong2, SubMsgType0x7.MsgBody.GenericSubCmd paramGenericSubCmd)
  {
    try
    {
      if (!paramGenericSubCmd.uint32_type.has()) {
        return;
      }
      TextMsgPush localTextMsgPush;
      Object localObject1;
      Object localObject2;
      Iterator localIterator;
      switch (paramGenericSubCmd.uint32_type.get())
      {
      case 1: 
        if (paramGenericSubCmd.uint64_sessionid.has()) {
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramGenericSubCmd.uint64_sessionid.get())))
          {
            localTextMsgPush = new TextMsgPush(Long.valueOf(paramGenericSubCmd.uint32_size.get()), Long.valueOf(paramGenericSubCmd.uint64_sessionid.get()));
            this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramGenericSubCmd.uint64_sessionid.get()), localTextMsgPush);
            if (!paramGenericSubCmd.bytes_buf.has()) {
              break label598;
            }
            localObject1 = new String();
            localObject2 = new SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg();
            ((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg)localObject2).mergeFrom(paramGenericSubCmd.bytes_buf.get().toByteArray());
            localIterator = ((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg)localObject2).rpt_msg_item.get().iterator();
          }
        }
        break;
      }
      label595:
      label598:
      label600:
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject2 = (SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localIterator.next();
          if ((!((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).uint32_type.has()) || (((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).uint32_type.get() != 1) || (!((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).bytes_text.has())) {
            break label595;
          }
          String str = new String(((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).bytes_text.get().toByteArray());
          localObject2 = (String)localObject1 + str;
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break label600;
          }
          QLog.d("DataLineHandler", 2, str);
          localObject1 = localObject2;
          break label600;
          localTextMsgPush = (TextMsgPush)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramGenericSubCmd.uint64_sessionid.get()));
          break;
        }
        if (paramGenericSubCmd.uint32_index.has())
        {
          localTextMsgPush.a(paramGenericSubCmd.uint32_index.get(), (String)localObject1);
          if (localTextMsgPush.a())
          {
            this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramGenericSubCmd.uint64_sessionid.get()));
            localObject1 = new DataLineMsgRecord();
            ((DataLineMsgRecord)localObject1).msgId = paramGenericSubCmd.uint64_sessionid.get();
            ((DataLineMsgRecord)localObject1).sessionid = paramGenericSubCmd.uint64_sessionid.get();
            ((DataLineMsgRecord)localObject1).msg = localTextMsgPush.a();
            ((DataLineMsgRecord)localObject1).msgtype = -1000;
            ((DataLineMsgRecord)localObject1).issend = 0;
            ((DataLineMsgRecord)localObject1).isread = false;
            ((DataLineMsgRecord)localObject1).time = paramLong1;
            ((DataLineMsgRecord)localObject1).issuc = true;
            ((DataLineMsgRecord)localObject1).sessionid = ((DataLineMsgRecord)localObject1).msgId;
            ((DataLineMsgRecord)localObject1).shmsgseq = paramLong2;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((DataLineMsgRecord)localObject1, true);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, false);
            b(8, true, new Object[] { Integer.valueOf((int)paramLong1), localTextMsgPush.a() });
            return;
            a((int)paramLong1, (short)(int)paramLong2, null);
            return;
            if (paramGenericSubCmd.bytes_buf.has())
            {
              b((int)paramLong1, (short)(int)paramLong2, paramGenericSubCmd.bytes_buf.get().toByteArray());
              return;
              break label600;
            }
          }
        }
        return;
        return;
      }
      return;
    }
    catch (Exception paramGenericSubCmd) {}
  }
  
  private void a(JSONObject paramJSONObject)
  {
    SubMsgType0x7.MsgBody.GenericSubCmd localGenericSubCmd = new SubMsgType0x7.MsgBody.GenericSubCmd();
    localGenericSubCmd.uint64_sessionid.set(1L);
    localGenericSubCmd.uint32_size.set(1);
    localGenericSubCmd.uint32_index.set(0);
    localGenericSubCmd.uint32_type.set(3);
    localGenericSubCmd.bytes_buf.set(ByteStringMicro.copyFrom(paramJSONObject.toString().getBytes()));
    localGenericSubCmd.setHasFlag(true);
    paramJSONObject = new SubMsgType0x7.MsgBody();
    paramJSONObject.uint32_sub_cmd.set(4);
    a(paramJSONObject.msg_header);
    paramJSONObject.msg_subcmd_0x4_generic.set(localGenericSubCmd);
    paramJSONObject.setHasFlag(true);
    a(1L, 1002, paramJSONObject, 1L);
  }
  
  private void a(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader)
  {
    int i1 = AppSetting.jdField_a_of_type_Int;
    paramMsgHeader.uint32_src_app_id.set(1001);
    paramMsgHeader.uint32_src_inst_id.set(i1);
    paramMsgHeader.uint32_dst_app_id.set(1);
    paramMsgHeader.uint32_dst_inst_id.set(1);
    paramMsgHeader.uint64_dst_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
    paramMsgHeader.setHasFlag(true);
  }
  
  static boolean a(Session paramSession, String paramString)
  {
    if (paramSession != null) {
      if ((paramString == null) || (paramString.length() == 0))
      {
        if ((paramSession.actionInfo != null) && (paramSession.actionInfo.strServiceName != null) && (paramSession.actionInfo.strServiceName.length() != 0)) {}
      }
      else {
        while ((paramSession.actionInfo != null) && (paramSession.actionInfo.strServiceName != null) && (paramSession.actionInfo.strServiceName.equals(paramString))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean a(TextMsgTask paramTextMsgTask)
  {
    int i1 = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    int i3 = paramTextMsgTask.a(localStringBuffer);
    if (i3 == -1) {
      return false;
    }
    while (i1 < localStringBuffer.length())
    {
      int i2 = i1;
      if (localStringBuffer.charAt(i1) == '\024')
      {
        i2 = i1;
        if (i1 < localStringBuffer.length() - 1)
        {
          int i4 = localStringBuffer.charAt(i1 + 1);
          i2 = i1;
          if (i4 >= 0)
          {
            i2 = i1;
            if (i4 < MessageUtils.a.length)
            {
              localStringBuffer.setCharAt(i1 + 1, (char)MessageUtils.a[i4]);
              i2 = i1 + 1;
            }
          }
        }
      }
      i1 = i2 + 1;
    }
    paramTextMsgTask.a(a(paramTextMsgTask.a().longValue(), 1001, paramTextMsgTask.a(), i3, localStringBuffer.toString().getBytes()));
    return true;
  }
  
  public static int b()
  {
    int i1 = Long.valueOf(System.currentTimeMillis()).intValue();
    int i2 = K;
    K = i2 + 1;
    return i1 << 16 | i2;
  }
  
  private void b(int paramInt, short paramShort, MsgType0x210SubMsgType0x13 paramMsgType0x210SubMsgType0x13)
  {
    a(paramInt, paramShort, null);
  }
  
  private void b(int paramInt, short paramShort, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("wifiphoto", 2, "handleWifiphotoType5MsgPush");
    }
    System.currentTimeMillis();
    paramArrayOfByte = new String(paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("wifiphoto", 2, "handleWifiphotoType5MsgPush" + paramArrayOfByte);
    }
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      String str = paramArrayOfByte.getString("subtype");
      if (str.equalsIgnoreCase("1"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("wifiphoto", 2, "handleWifiphotoType5MsgPush 1");
        }
        r();
        return;
      }
      if (str.equalsIgnoreCase("2")) {
        if (!paramArrayOfByte.has("msgid")) {
          break label388;
        }
      }
      label388:
      for (long l1 = paramArrayOfByte.getLong("msgid");; l1 = 0L)
      {
        if ((l1 == 0L) || (!jdField_a_of_type_WifiphotoWifiPhotoDataCenter.jdField_a_of_type_WifiphotoWifiPhotoMsgStrategy.a(l1)))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("wifiphoto", 2, "handleWifiphotoType5MsgPush 4 handshake msg id is not valid");
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("wifiphoto", 2, "handleWifiphotoType5MsgPush 2");
        }
        if (!jdField_a_of_type_WifiphotoWifiPhotoDataCenter.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr.a()) {
          break;
        }
        b(false);
        jdField_a_of_type_WifiphotoWifiPhotoDataCenter.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr.d();
        return;
        if (!str.equalsIgnoreCase("4")) {
          break;
        }
        str = paramArrayOfByte.getString("open");
        if (QLog.isColorLevel()) {
          QLog.d("wifiphoto", 2, String.format("handleWifiphotoType5MsgPush 4, isOpen is [%s]", new Object[] { str }));
        }
        if (str.equalsIgnoreCase("0"))
        {
          if (!jdField_a_of_type_WifiphotoWifiPhotoDataCenter.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr.a()) {
            break;
          }
          b(false);
          jdField_a_of_type_WifiphotoWifiPhotoDataCenter.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr.d();
          return;
        }
        if (!str.equalsIgnoreCase("1")) {
          break;
        }
        if (paramArrayOfByte.has("msgid")) {}
        for (l1 = paramArrayOfByte.getLong("msgid");; l1 = 0L)
        {
          if ((l1 == 0L) || (!jdField_a_of_type_WifiphotoWifiPhotoDataCenter.jdField_a_of_type_WifiphotoWifiPhotoMsgStrategy.a(l1)))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("wifiphoto", 2, "handleWifiphotoType5MsgPush 4 handshake msg id is not valid");
            return;
          }
          f();
          return;
        }
      }
      return;
    }
    catch (JSONException paramArrayOfByte) {}
  }
  
  private void b(long paramLong1, long paramLong2, long paramLong3, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList, boolean paramBoolean)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      SubMsgType0x7.MsgBody.NFCNotify localNFCNotify = (SubMsgType0x7.MsgBody.NFCNotify)localIterator.next();
      if ((localNFCNotify.uint64_sessionid.has()) && (localNFCNotify.uint32_originfiletype.has()) && (localNFCNotify.str_file_name.has()) && (localNFCNotify.uint64_file_len.has()) && (localNFCNotify.bytes_file_md5.has()) && (localNFCNotify.fixed32_ip.has()) && (localNFCNotify.uint32_port.has()) && (localNFCNotify.bytes_url_notify.has()) && (localNFCNotify.bytes_tokenkey.has())) {
        new Handler(Looper.getMainLooper()).post(new crj(this, paramMsgHeader, paramList, paramBoolean));
      }
    }
  }
  
  private void b(ArrayList paramArrayList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      c();
    }
    do
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Session localSession = (Session)paramArrayList.next();
        File localFile = new File(localSession.strFilePathSrc);
        if ((!paramBoolean) && (!localFile.exists())) {
          c(localFile.getName());
        } else if ((!paramBoolean) && (localFile.length() == 0L)) {
          a(localFile.getName());
        } else if ((!paramBoolean) && (localFile.length() > 2147483648L)) {
          b(localFile.getName());
        } else {
          localArrayList.add(localSession);
        }
      }
    } while (localArrayList.size() == 0);
    paramArrayList = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper;
    if (localArrayList.size() == 1) {}
    for (boolean bool = false;; bool = true)
    {
      paramArrayList.SendGroup(localArrayList, paramBoolean, bool);
      return;
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    SubMsgType0x7.MsgBody.GenericSubCmd localGenericSubCmd = new SubMsgType0x7.MsgBody.GenericSubCmd();
    localGenericSubCmd.uint64_sessionid.set(1L);
    localGenericSubCmd.uint32_size.set(1);
    localGenericSubCmd.uint32_index.set(0);
    localGenericSubCmd.uint32_type.set(5);
    localGenericSubCmd.bytes_buf.set(ByteStringMicro.copyFrom(paramJSONObject.toString().getBytes()));
    localGenericSubCmd.setHasFlag(true);
    paramJSONObject = new SubMsgType0x7.MsgBody();
    paramJSONObject.uint32_sub_cmd.set(4);
    a(paramJSONObject.msg_header);
    paramJSONObject.msg_subcmd_0x4_generic.set(localGenericSubCmd);
    paramJSONObject.setHasFlag(true);
    a(1L, 1002, paramJSONObject, 1L);
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    int i1 = AppSetting.jdField_a_of_type_Int;
    if ((paramInt1 == 1001) && ((paramInt2 == i1) || (paramInt2 == 0))) {}
    while (!QLog.isColorLevel()) {
      return true;
    }
    QLog.d("DataLineHandler", 2, "msgBody command not for android" + paramInt2 + " " + i1);
    return true;
  }
  
  private void c(int paramInt, short paramShort, MsgType0x210SubMsgType0x13 paramMsgType0x210SubMsgType0x13)
  {
    b(paramInt, paramShort, paramMsgType0x210SubMsgType0x13.bytes_buf);
  }
  
  private void d(int paramInt, short paramShort, MsgType0x210SubMsgType0x13 paramMsgType0x210SubMsgType0x13)
  {
    if (paramMsgType0x210SubMsgType0x13.uint32_type != 1L) {}
    TextMsgPush localTextMsgPush;
    do
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid)))
      {
        localTextMsgPush = new TextMsgPush(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint32_size), Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid), localTextMsgPush);
      }
      for (;;)
      {
        Type_1_QQDataTextMsg localType_1_QQDataTextMsg = new Type_1_QQDataTextMsg();
        localType_1_QQDataTextMsg.readFrom(new JceInputStream(paramMsgType0x210SubMsgType0x13.bytes_buf));
        localObject = new String();
        int i1 = 0;
        while (i1 < localType_1_QQDataTextMsg.msg_item.size())
        {
          String str = new String(((MsgType0x210SubMsgType0x13_MsgItem)localType_1_QQDataTextMsg.msg_item.get(i1)).bytes_text);
          localObject = (String)localObject + str;
          if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, str);
          }
          i1 += 1;
        }
        localTextMsgPush = (TextMsgPush)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
      }
      localTextMsgPush.a((int)paramMsgType0x210SubMsgType0x13.uint32_index, (String)localObject);
    } while (!localTextMsgPush.a());
    this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
    Object localObject = new DataLineMsgRecord();
    ((DataLineMsgRecord)localObject).msgId = paramMsgType0x210SubMsgType0x13.uint64_sessionid;
    ((DataLineMsgRecord)localObject).sessionid = paramMsgType0x210SubMsgType0x13.uint64_sessionid;
    ((DataLineMsgRecord)localObject).msg = localTextMsgPush.a();
    ((DataLineMsgRecord)localObject).msgtype = -1000;
    ((DataLineMsgRecord)localObject).issend = 0;
    ((DataLineMsgRecord)localObject).isread = false;
    ((DataLineMsgRecord)localObject).time = paramInt;
    ((DataLineMsgRecord)localObject).issuc = true;
    ((DataLineMsgRecord)localObject).sessionid = ((DataLineMsgRecord)localObject).msgId;
    ((DataLineMsgRecord)localObject).shmsgseq = paramShort;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((DataLineMsgRecord)localObject, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
    b(8, true, new Object[] { Integer.valueOf(paramInt), localTextMsgPush.a() });
  }
  
  private void d(ToServiceMsg paramToServiceMsg)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), DataLineServlet.class);
    localNewIntent.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    long l1 = System.currentTimeMillis();
    paramToServiceMsg.extraData.putLong("datalineSendTimekey", l1);
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((TextMsgTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).a().equals(paramToServiceMsg)) {}
    }
    for (paramToServiceMsg = (TextMsgTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);; paramToServiceMsg = null)
    {
      if (paramToServiceMsg == null) {}
      do
      {
        return;
        i1 += 1;
        break;
        paramToServiceMsg.a().progress = 1.0F;
        if (!paramFromServiceMsg.isSuccess())
        {
          paramToServiceMsg.a().issuc = false;
          b(1, false, new Object[] { paramToServiceMsg.a(), paramToServiceMsg.a() });
          return;
        }
        if (paramToServiceMsg.a())
        {
          paramToServiceMsg.a().issuc = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramToServiceMsg.a().msgId);
          this.jdField_a_of_type_JavaUtilArrayList.remove(paramToServiceMsg);
          b(1, true, new Object[] { paramToServiceMsg.a(), paramToServiceMsg.a() });
          return;
        }
      } while (a(paramToServiceMsg));
      paramToServiceMsg.a().issuc = false;
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramToServiceMsg);
      b(1, false, new Object[] { paramToServiceMsg.a(), paramToServiceMsg.a() });
      return;
    }
  }
  
  private void l()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_PC_STATE";
    if (this.jdField_c_of_type_Boolean)
    {
      localSharedPreferences.edit().putLong(str, this.jdField_b_of_type_Long).commit();
      return;
    }
    localSharedPreferences.edit().remove(str).commit();
  }
  
  private void m()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_PC_STATE";
    if (localSharedPreferences.contains(str))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_Long = localSharedPreferences.getLong(str, 0L);
      return;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void n()
  {
    if (this.jdField_b_of_type_Boolean == true) {}
    for (boolean bool = false;; bool = true)
    {
      a().a(1, bool, false);
      return;
    }
  }
  
  private void o()
  {
    int i1 = AppSetting.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentLitetransfersdkMsgHeader.uint32_src_app_id = 1001;
    this.jdField_a_of_type_ComTencentLitetransfersdkMsgHeader.uint32_src_inst_id = i1;
    this.jdField_a_of_type_ComTencentLitetransfersdkMsgHeader.uint32_dst_app_id = 1;
    this.jdField_a_of_type_ComTencentLitetransfersdkMsgHeader.uint32_dst_inst_id = 1;
    this.jdField_a_of_type_ComTencentLitetransfersdkMsgHeader.uint64_dst_uin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
  }
  
  private void p()
  {
    q();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimerTask = new crh(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_JavaUtilTimerTask, 5000L, 5000L);
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_JavaUtilTimerTask != null)
    {
      this.jdField_a_of_type_JavaUtilTimerTask.cancel();
      this.jdField_a_of_type_JavaUtilTimerTask = null;
    }
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  private void r()
  {
    Object localObject2 = "0";
    String str3 = "0";
    String str4 = "0";
    String str2 = str4;
    String str1 = str3;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer != null)
    {
      str2 = str4;
      str1 = str3;
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer.a() == true)
      {
        if (!DBNetworkUtil.a()) {
          break label165;
        }
        localObject1 = DBNetworkUtil.b();
      }
    }
    for (;;)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer.a();
      str2 = DBNetworkUtil.a();
      str1 = String.valueOf(i1);
      localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("ip", localObject1);
        ((JSONObject)localObject2).put("port", str1);
        ((JSONObject)localObject2).put("token", jdField_a_of_type_WifiphotoWifiPhotoDataCenter.jdField_a_of_type_JavaLangString);
        ((JSONObject)localObject2).put("subnetMask", str2);
        if (Environment.getExternalStorageState().equals("mounted_ro")) {
          ((JSONObject)localObject2).put("readonly", true);
        }
        for (;;)
        {
          a((JSONObject)localObject2);
          return;
          label165:
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer.a().toString();
          break;
          ((JSONObject)localObject2).put("readonly", false);
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  private void s()
  {
    Long localLong = Long.valueOf(jdField_a_of_type_WifiphotoWifiPhotoDataCenter.jdField_a_of_type_WifiphotoWifiPhotoMsgStrategy.a());
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("subtype", "4");
      if (localLong.longValue() > 0L) {
        localJSONObject.put("msgid", localLong);
      }
      jdField_a_of_type_WifiphotoWifiPhotoDataCenter.jdField_a_of_type_WifiphotoWifiPhotoMsgStrategy.a(localLong.longValue());
      b(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void t()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("subtype", "3");
      localJSONObject.put("msgid", 0);
      b(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void u()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("subtype", "5");
      localJSONObject.put("msgid", 0);
      b(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateGroupID();
  }
  
  public int a(String paramString)
  {
    if (paramString == null) {
      return 1;
    }
    return this.jdField_a_of_type_ComDatalineCoreMoloHandler.a(paramString);
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public long a(String paramString1, String paramString2, DataLineHandler.EFILETYPE paramEFILETYPE, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramString1 = a(paramString1, paramString2, paramEFILETYPE, paramLong, paramInt1, paramInt2, paramInt3, paramBoolean);
    if (paramString1 == null) {
      return 0L;
    }
    localArrayList.add(paramString1);
    b(localArrayList, paramBoolean);
    return paramString1.uSessionID;
  }
  
  public MpfileDataCenter a()
  {
    if (this.jdField_a_of_type_ComDatalineMpfileMpfileDataCenter == null) {
      this.jdField_a_of_type_ComDatalineMpfileMpfileDataCenter = new MpfileDataCenter(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComDatalineMpfileMpfileDataCenter;
  }
  
  public Session a(long paramLong)
  {
    boolean bool = true;
    DataLineMsgRecord localDataLineMsgRecord = a().a().a().b(paramLong);
    if (localDataLineMsgRecord == null) {
      return null;
    }
    Session localSession = new Session();
    localSession.uSessionID = localDataLineMsgRecord.sessionid;
    if (localDataLineMsgRecord.issend == 1) {}
    for (;;)
    {
      localSession.bSend = bool;
      localSession.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkMsgHeader;
      localSession.dwGroupID = localDataLineMsgRecord.groupId;
      localSession.dwGroupSize = localDataLineMsgRecord.groupSize;
      localSession.dwGroupIndex = localDataLineMsgRecord.groupIndex;
      localSession.emFileType = a(localDataLineMsgRecord.msgtype).ordinal();
      localSession.strFilePathSrc = localDataLineMsgRecord.path;
      localSession.strFilePathThumb = localDataLineMsgRecord.thumbPath;
      localSession.uFileSizeSrc = localDataLineMsgRecord.filesize;
      localSession.vFileMD5Src = localDataLineMsgRecord.md5;
      localSession.actionInfo = null;
      return localSession;
      bool = false;
    }
  }
  
  public Session a(String paramString1, String paramString2, DataLineHandler.EFILETYPE paramEFILETYPE, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "--->>sendFile sUin: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + " sPath: " + paramString1 + " sPathThumb: " + paramString2 + " type:" + paramEFILETYPE);
    }
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      localObject = new File(paramString1);
      if (!((File)localObject).exists())
      {
        c(((File)localObject).getName());
        return null;
      }
      if (((File)localObject).length() == 0L)
      {
        a(((File)localObject).getName());
        return null;
      }
      if (((File)localObject).length() > 2147483648L)
      {
        b(((File)localObject).getName());
        return null;
      }
    }
    long l1 = paramLong;
    if (paramLong == 0L) {
      l1 = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(paramInt1);
    }
    Object localObject = new Session();
    ((Session)localObject).uSessionID = l1;
    ((Session)localObject).bSend = true;
    ((Session)localObject).msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkMsgHeader;
    ((Session)localObject).emFileType = paramEFILETYPE.ordinal();
    ((Session)localObject).dwGroupID = paramInt1;
    ((Session)localObject).dwGroupSize = paramInt2;
    ((Session)localObject).dwGroupIndex = paramInt3;
    ((Session)localObject).strFilePathSrc = paramString1;
    ((Session)localObject).strFilePathThumb = paramString2;
    if (paramString1 == null)
    {
      paramLong = 0L;
      ((Session)localObject).uFileSizeSrc = paramLong;
      if (paramString2 != null) {
        break label297;
      }
    }
    label297:
    for (paramLong = 0L;; paramLong = new File(paramString2).length())
    {
      ((Session)localObject).uFileSizeThumb = paramLong;
      return localObject;
      paramLong = new File(paramString1).length();
      break;
    }
  }
  
  public final QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public ToServiceMsg a(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(4);
    a(localMsgBody.msg_header);
    localMsgBody.msg_subcmd_0x4_generic.uint64_sessionid.set(paramLong);
    localMsgBody.msg_subcmd_0x4_generic.uint32_size.set(paramInt2);
    localMsgBody.msg_subcmd_0x4_generic.uint32_index.set(paramInt3);
    localMsgBody.msg_subcmd_0x4_generic.uint32_type.set(1);
    SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg localQQDataTextMsg = new SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg();
    SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem localMsgItem = new SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem();
    localMsgItem.uint32_type.set(1);
    localMsgItem.bytes_text.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localMsgItem.setHasFlag(true);
    localQQDataTextMsg.rpt_msg_item.add(localMsgItem);
    localQQDataTextMsg.setHasFlag(true);
    localMsgBody.msg_subcmd_0x4_generic.bytes_buf.set(ByteStringMicro.copyFrom(localQQDataTextMsg.toByteArray()));
    localMsgBody.msg_subcmd_0x4_generic.setHasFlag(true);
    localMsgBody.setHasFlag(true);
    return a(paramLong, paramInt1, localMsgBody, paramLong);
  }
  
  public ToServiceMsg a(long paramLong1, int paramInt, SubMsgType0x7.MsgBody paramMsgBody, long paramLong2)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    paramMsgBody = paramMsgBody.toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "send0x211C2CDatalineMsg DataLineMsgRecord:" + paramLong2);
    }
    return a(paramLong1, str, 529, 7, paramInt, paramMsgBody, paramLong2);
  }
  
  public ToServiceMsg a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(11);
    a(localMsgBody.msg_header);
    SubMsgType0x7.MsgBody.MpFileNotify localMpFileNotify = new SubMsgType0x7.MsgBody.MpFileNotify();
    localMpFileNotify.uint64_sessionid.set(paramLong2);
    localMpFileNotify.uint32_operate.set(paramInt2);
    localMpFileNotify.uint32_type.set(1);
    localMpFileNotify.setHasFlag(true);
    localMsgBody.rpt_msg_subcmd_0xb_mpfile_notify.add(localMpFileNotify);
    localMsgBody.setHasFlag(true);
    return a(paramLong1, paramInt1, localMsgBody, paramLong2);
  }
  
  public ToServiceMsg a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(3);
    a(localMsgBody.msg_header);
    SubMsgType0x7.MsgBody.FileControl localFileControl = new SubMsgType0x7.MsgBody.FileControl();
    localFileControl.uint64_sessionid.set(paramLong2);
    localFileControl.uint32_operate.set(paramInt2);
    localFileControl.uint32_seq.set(paramInt3);
    localFileControl.uint32_group_id.set(paramInt4);
    localFileControl.uint32_batchID.set(paramInt5);
    localFileControl.setHasFlag(true);
    localMsgBody.rpt_msg_subcmd_0x3_filecontrol.add(localFileControl);
    localMsgBody.setHasFlag(true);
    return a(paramLong1, paramInt1, localMsgBody, paramLong2);
  }
  
  public ToServiceMsg a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong3)
  {
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(6);
    a(localMsgBody.msg_header);
    SubMsgType0x7.MsgBody.RNFCNotify localRNFCNotify = new SubMsgType0x7.MsgBody.RNFCNotify();
    localRNFCNotify.uint64_sessionid.set(paramLong2);
    localRNFCNotify.fixed32_ip.set(paramInt2);
    localRNFCNotify.uint32_port.set(paramInt3);
    localRNFCNotify.bytes_url_notify_original.set(ByteStringMicro.copyFrom(paramArrayOfByte1));
    localRNFCNotify.bytes_token_original.set(ByteStringMicro.copyFrom(paramArrayOfByte2));
    localRNFCNotify.bytes_url_notify.set(ByteStringMicro.copyFrom(paramArrayOfByte3));
    localRNFCNotify.bytes_tokenkey.set(ByteStringMicro.copyFrom("1234567890123456".getBytes()));
    localRNFCNotify.uint64_file_len.set(paramLong3);
    localRNFCNotify.setHasFlag(true);
    localMsgBody.rpt_msg_subcmd_0x6_rnfc_notify.add(localRNFCNotify);
    localMsgBody.setHasFlag(true);
    return a(paramLong1, paramInt1, localMsgBody, paramLong2);
  }
  
  public ToServiceMsg a(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte1, long paramLong3, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, ActionInfo paramActionInfo)
  {
    String str = a(paramString1, paramString1, paramInt2, false);
    paramString1 = new SubMsgType0x7.MsgBody();
    paramString1.uint32_sub_cmd.set(1);
    a(paramString1.msg_header);
    SubMsgType0x7.MsgBody.FTNNotify localFTNNotify = new SubMsgType0x7.MsgBody.FTNNotify();
    localFTNNotify.uint64_sessionid.set(paramLong2);
    localFTNNotify.str_file_name.set(str);
    localFTNNotify.str_file_index.set(paramString2);
    localFTNNotify.bytes_file_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte1));
    localFTNNotify.uint64_file_len.set(paramLong3);
    if (paramArrayOfByte2 != null) {
      localFTNNotify.bytes_originfile_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte2));
    }
    localFTNNotify.uint32_originfiletype.set(paramInt2);
    if (paramInt4 > 1)
    {
      localFTNNotify.uint32_group_id.set(paramInt3);
      localFTNNotify.uint32_group_size.set(paramInt4);
      localFTNNotify.uint32_group_curindex.set(paramInt5);
      localFTNNotify.uint32_batchID.set(paramInt6);
      localFTNNotify.uint32_groupflag.set(paramInt7);
    }
    paramString2 = new SubMsgType0x7.MsgBody.ActionInfo();
    paramString2.str_service_name.set(paramActionInfo.strServiceName);
    if (paramActionInfo.vServiceInfo != null) {
      paramString2.bytes_buf.set(ByteStringMicro.copyFrom(paramActionInfo.vServiceInfo));
    }
    paramString2.setHasFlag(true);
    localFTNNotify.msg_ActionInfo.set(paramString2);
    localFTNNotify.setHasFlag(true);
    paramString1.rpt_msg_subcmd_0x1_ftn_notify.add(localFTNNotify);
    paramString1.setHasFlag(true);
    return a(paramLong1, paramInt1, paramString1, paramLong2);
  }
  
  public ToServiceMsg a(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean, String paramString, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, byte[] paramArrayOfByte3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, ActionInfo paramActionInfo)
  {
    String str = a(paramString, paramString, paramInt4, paramBoolean);
    paramString = new SubMsgType0x7.MsgBody();
    paramString.uint32_sub_cmd.set(2);
    a(paramString.msg_header);
    SubMsgType0x7.MsgBody.NFCNotify localNFCNotify = new SubMsgType0x7.MsgBody.NFCNotify();
    localNFCNotify.uint64_sessionid.set(paramLong2);
    localNFCNotify.str_file_name.set(str);
    if (paramArrayOfByte1 != null) {
      localNFCNotify.bytes_file_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte1));
    }
    localNFCNotify.fixed32_ip.set(paramInt2);
    localNFCNotify.uint32_port.set(paramInt3);
    localNFCNotify.bytes_url_notify.set(ByteStringMicro.copyFrom(paramArrayOfByte3));
    localNFCNotify.bytes_tokenkey.set(ByteStringMicro.copyFrom("1234567890123456".getBytes()));
    localNFCNotify.uint64_file_len.set(paramLong3);
    if (paramArrayOfByte2 != null) {
      localNFCNotify.bytes_originfile_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte2));
    }
    localNFCNotify.uint32_originfiletype.set(paramInt4);
    if (paramInt6 > 1)
    {
      localNFCNotify.uint32_group_id.set(paramInt5);
      localNFCNotify.uint32_group_size.set(paramInt6);
      localNFCNotify.uint32_group_curindex.set(paramInt7);
      localNFCNotify.uint32_batchID.set(paramInt8);
      localNFCNotify.uint32_groupflag.set(paramInt9);
    }
    paramArrayOfByte1 = new SubMsgType0x7.MsgBody.ActionInfo();
    paramArrayOfByte1.str_service_name.set(paramActionInfo.strServiceName);
    if (paramActionInfo.vServiceInfo != null) {
      paramArrayOfByte1.bytes_buf.set(ByteStringMicro.copyFrom(paramActionInfo.vServiceInfo));
    }
    paramArrayOfByte1.setHasFlag(true);
    localNFCNotify.msg_ActionInfo.set(paramArrayOfByte1);
    localNFCNotify.setHasFlag(true);
    paramString.rpt_msg_subcmd_0x2_nfc_notify.add(localNFCNotify);
    paramString.setHasFlag(true);
    return a(paramLong1, paramInt1, paramString, paramLong2);
  }
  
  public ToServiceMsg a(long paramLong, MsgCSBody0x346 paramMsgCSBody0x346)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(paramMsgCSBody0x346.uMsgSubType);
    localReqBody.uint32_business_id.set(38);
    localReqBody.uint32_client_type.set(104);
    Object localObject3 = localReqBody.uint32_seq;
    int i1 = N;
    N = i1 + 1;
    ((PBUInt32Field)localObject3).set(i1);
    switch (paramMsgCSBody0x346.uMsgSubType)
    {
    default: 
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("DataLineHandler", 2, "send0x346Req, unknwon nCmdType:" + paramMsgCSBody0x346.uMsgSubType);
        localObject1 = localObject2;
      }
      break;
    }
    for (;;)
    {
      paramMsgCSBody0x346 = localReqBody.toByteArray();
      localObject2 = new byte[paramMsgCSBody0x346.length + 4];
      PkgTools.a((byte[])localObject2, 0, paramMsgCSBody0x346.length + 4);
      PkgTools.a((byte[])localObject2, 4, paramMsgCSBody0x346, paramMsgCSBody0x346.length);
      paramMsgCSBody0x346 = (MsgCSBody0x346)localObject1;
      if (localObject1 != null)
      {
        ((ToServiceMsg)localObject1).putWupBuffer((byte[])localObject2);
        ((ToServiceMsg)localObject1).addAttribute("cookie", Long.valueOf(paramLong));
        ((ToServiceMsg)localObject1).extraData.putInt("DATALINE_TRYINDEX", 0);
        d((ToServiceMsg)localObject1);
        paramMsgCSBody0x346 = (MsgCSBody0x346)localObject1;
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return paramMsgCSBody0x346;
              localObject2 = new cmd0x346.ApplyUploadReqV2();
              localObject3 = paramMsgCSBody0x346.pMsgBody0x346_uploadReq;
              paramMsgCSBody0x346 = (MsgCSBody0x346)localObject1;
            } while (localObject3 == null);
            ((cmd0x346.ApplyUploadReqV2)localObject2).uint64_sender_uin.set(((ApplyUploadReq)localObject3).uint64_sender_uin);
            ((cmd0x346.ApplyUploadReqV2)localObject2).uint64_recver_uin.set(((ApplyUploadReq)localObject3).uint64_recver_uin);
            ((cmd0x346.ApplyUploadReqV2)localObject2).uint64_file_size.set(((ApplyUploadReq)localObject3).uint64_file_size);
            ((cmd0x346.ApplyUploadReqV2)localObject2).str_file_name.set(((ApplyUploadReq)localObject3).str_file_name);
            ((cmd0x346.ApplyUploadReqV2)localObject2).bytes_10m_md5.set(ByteStringMicro.copyFrom(((ApplyUploadReq)localObject3).bytes_10m_md5));
            ((cmd0x346.ApplyUploadReqV2)localObject2).bytes_3sha.set(ByteStringMicro.copyFrom(((ApplyUploadReq)localObject3).bytes_sha));
            ((cmd0x346.ApplyUploadReqV2)localObject2).str_local_filepath.set(((ApplyUploadReq)localObject3).str_local_filepath);
            ((cmd0x346.ApplyUploadReqV2)localObject2).uint32_danger_level.set(((ApplyUploadReq)localObject3).uint32_danger_level);
            ((cmd0x346.ApplyUploadReqV2)localObject2).uint64_total_space.set(((ApplyUploadReq)localObject3).uint64_total_space);
            localReqBody.msg_apply_upload_req_v2.set((MessageMicro)localObject2);
            localObject1 = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600", null);
            break;
            localObject2 = new cmd0x346.ApplyUploadReqV3();
            localObject3 = paramMsgCSBody0x346.pMsgBody0x346_uploadReq;
            paramMsgCSBody0x346 = (MsgCSBody0x346)localObject1;
          } while (localObject3 == null);
          ((cmd0x346.ApplyUploadReqV3)localObject2).uint64_sender_uin.set(((ApplyUploadReq)localObject3).uint64_sender_uin);
          ((cmd0x346.ApplyUploadReqV3)localObject2).uint64_recver_uin.set(((ApplyUploadReq)localObject3).uint64_recver_uin);
          ((cmd0x346.ApplyUploadReqV3)localObject2).uint64_file_size.set(((ApplyUploadReq)localObject3).uint64_file_size);
          ((cmd0x346.ApplyUploadReqV3)localObject2).str_file_name.set(((ApplyUploadReq)localObject3).str_file_name);
          ((cmd0x346.ApplyUploadReqV3)localObject2).bytes_10m_md5.set(ByteStringMicro.copyFrom(((ApplyUploadReq)localObject3).bytes_10m_md5));
          ((cmd0x346.ApplyUploadReqV3)localObject2).bytes_sha.set(ByteStringMicro.copyFrom(((ApplyUploadReq)localObject3).bytes_sha));
          ((cmd0x346.ApplyUploadReqV3)localObject2).str_local_filepath.set(((ApplyUploadReq)localObject3).str_local_filepath);
          ((cmd0x346.ApplyUploadReqV3)localObject2).uint32_danger_level.set(((ApplyUploadReq)localObject3).uint32_danger_level);
          ((cmd0x346.ApplyUploadReqV3)localObject2).uint64_total_space.set(((ApplyUploadReq)localObject3).uint64_total_space);
          localReqBody.msg_apply_upload_req_v3.set((MessageMicro)localObject2);
          localObject1 = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700", null);
          break;
          localObject2 = new cmd0x346.ApplyUploadHitReqV2();
          localObject3 = paramMsgCSBody0x346.pMsgBody0x346_1800;
          paramMsgCSBody0x346 = (MsgCSBody0x346)localObject1;
        } while (localObject3 == null);
        ((cmd0x346.ApplyUploadHitReqV2)localObject2).uint64_sender_uin.set(((ApplyUploadHitReq)localObject3).uint64_sender_uin);
        ((cmd0x346.ApplyUploadHitReqV2)localObject2).uint64_recver_uin.set(((ApplyUploadHitReq)localObject3).uint64_recver_uin);
        ((cmd0x346.ApplyUploadHitReqV2)localObject2).uint64_file_size.set(((ApplyUploadHitReq)localObject3).uint64_file_size);
        ((cmd0x346.ApplyUploadHitReqV2)localObject2).str_file_name.set(((ApplyUploadHitReq)localObject3).str_file_name);
        ((cmd0x346.ApplyUploadHitReqV2)localObject2).bytes_10m_md5.set(ByteStringMicro.copyFrom(((ApplyUploadHitReq)localObject3).bytes_10m_md5));
        ((cmd0x346.ApplyUploadHitReqV2)localObject2).bytes_3sha.set(ByteStringMicro.copyFrom(((ApplyUploadHitReq)localObject3).bytes_3sha));
        ((cmd0x346.ApplyUploadHitReqV2)localObject2).bytes_sha.set(ByteStringMicro.copyFrom(((ApplyUploadHitReq)localObject3).bytes_sha));
        ((cmd0x346.ApplyUploadHitReqV2)localObject2).str_local_filepath.set(((ApplyUploadHitReq)localObject3).str_local_filepath);
        ((cmd0x346.ApplyUploadHitReqV2)localObject2).uint32_danger_level.set(((ApplyUploadHitReq)localObject3).uint32_danger_level);
        ((cmd0x346.ApplyUploadHitReqV2)localObject2).uint64_total_space.set(((ApplyUploadHitReq)localObject3).uint64_total_space);
        localReqBody.msg_apply_upload_hit_req_v2.set((MessageMicro)localObject2);
        localObject1 = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800", null);
        break;
        localObject2 = new cmd0x346.ApplyDownloadReq();
        localObject3 = paramMsgCSBody0x346.pMsgBody0x346_1200;
        paramMsgCSBody0x346 = (MsgCSBody0x346)localObject1;
      } while (localObject3 == null);
      ((cmd0x346.ApplyDownloadReq)localObject2).uint64_uin.set(((ApplyDownloadReq)localObject3).uint64_uin);
      ((cmd0x346.ApplyDownloadReq)localObject2).bytes_uuid.set(ByteStringMicro.copyFrom(((ApplyDownloadReq)localObject3).bytes_uuid));
      ((cmd0x346.ApplyDownloadReq)localObject2).uint32_owner_type.set(((ApplyDownloadReq)localObject3).uint32_owner_type);
      localReqBody.msg_apply_download_req.set((MessageMicro)localObject2);
      localObject1 = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", null);
    }
  }
  
  public ToServiceMsg a(long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
    localToServiceMsg.extraData.putBoolean("ISFROM_DATALINE", true);
    localToServiceMsg.extraData.putInt("DATALINE_CMD", paramInt3);
    localToServiceMsg.addAttribute("cookie", Long.valueOf(paramLong1));
    localToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", 0);
    paramLong1 = FileManagerUtil.b();
    long l1 = FileManagerUtil.a();
    TransMsgContext localTransMsgContext = new TransMsgContext();
    localTransMsgContext.jdField_a_of_type_Int = paramInt2;
    localTransMsgContext.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    paramString = a(13, paramString, localTransMsgContext, l1, MessageUtils.b(paramLong1), paramLong2);
    paramArrayOfByte = new im_msg_head.InstInfo();
    paramArrayOfByte.uint32_apppid.set(1);
    paramArrayOfByte.uint32_instid.set(1);
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add(paramArrayOfByte);
    paramArrayOfByte = new im_msg_head.InstInfo();
    paramArrayOfByte.uint32_apppid.set(this.jdField_a_of_type_ComTencentLitetransfersdkMsgHeader.uint32_src_app_id);
    paramArrayOfByte.uint32_instid.set(this.jdField_a_of_type_ComTencentLitetransfersdkMsgHeader.uint32_src_inst_id);
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.msg_from_inst = paramArrayOfByte;
    paramString.routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
    localToServiceMsg.putWupBuffer(paramString.toByteArray());
    b(localToServiceMsg);
    return localToServiceMsg;
  }
  
  protected Class a()
  {
    return DataLineObserver.class;
  }
  
  public Long a(int paramInt)
  {
    return Long.valueOf(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(paramInt));
  }
  
  public Long a(String paramString)
  {
    if (paramString.length() == 0) {
      return Long.valueOf(0L);
    }
    Long localLong = a(0);
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgId = localLong.longValue();
    localDataLineMsgRecord.sessionid = localLong.longValue();
    localDataLineMsgRecord.msg = paramString;
    localDataLineMsgRecord.msgtype = -1000;
    localDataLineMsgRecord.issend = 1;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    localDataLineMsgRecord.vipBubbleID = c();
    localDataLineMsgRecord.time = MessageCache.a();
    localDataLineMsgRecord.sessionid = localLong.longValue();
    localDataLineMsgRecord.progress = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localDataLineMsgRecord, false);
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      return Long.valueOf(0L);
    }
    localDataLineMsgRecord.issuc = true;
    paramString = new TextMsgTask(paramString, localLong, localDataLineMsgRecord);
    if (!a(paramString)) {
      return Long.valueOf(0L);
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    return localLong;
  }
  
  public String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    String str = paramString1;
    if (paramInt == DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE.ordinal())
    {
      str = paramString1;
      if (FileManagerUtil.a(paramString1) != 0)
      {
        str = paramString1;
        if (!paramBoolean) {
          if (!GifDrawable.isGifFile(new File(paramString2))) {
            break label72;
          }
        }
      }
    }
    label72:
    for (paramString2 = ".gif";; paramString2 = ".jpg")
    {
      str = paramString1 + paramString2;
      return str;
    }
  }
  
  public void a()
  {
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(AppConstants.T), 6000).time;
    if ((l1 != 0L) && (l1 != this.jdField_c_of_type_Long))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new UinPairReadInfo(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue(), l1, 0L, null));
      ((C2CMessageProcessor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("c2c_processor")).b(localArrayList);
      this.jdField_c_of_type_Long = l1;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComDatalineCoreMoloHandler.b(paramInt);
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "manually cancel a file . session =" + paramLong);
    }
    if (paramLong == 0L)
    {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(paramInt, paramLong, 32, paramBoolean);
      return;
    }
    DataLineMsgRecord localDataLineMsgRecord = a().a().a().b(paramLong);
    if (localDataLineMsgRecord == null)
    {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(paramInt, paramLong, 32, paramBoolean);
      return;
    }
    localDataLineMsgRecord.fileMsgStatus = 2L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().c(localDataLineMsgRecord.msgId);
    if (localDataLineMsgRecord.strMoloKey != null)
    {
      this.jdField_a_of_type_ComDatalineCoreMoloHandler.c(localDataLineMsgRecord.strMoloKey);
      return;
    }
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(localDataLineMsgRecord.groupId, paramLong, 32, paramBoolean);
  }
  
  public void a(Session paramSession, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramSession != null) && (paramString != null) && (paramString.length() > 0))
    {
      paramSession.actionInfo = new ActionInfo();
      paramSession.actionInfo.strServiceName = paramString;
      paramSession.actionInfo.vServiceInfo = paramArrayOfByte;
    }
  }
  
  public void a(BaseActivity paramBaseActivity, String paramString, DataLineHandler.EFILETYPE paramEFILETYPE)
  {
    Intent localIntent = new Intent(paramBaseActivity, LiteActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", paramBaseActivity.getString(2131362936));
    localIntent.putExtras(localBundle);
    localIntent.putExtra("dataline_send_file_path", paramString);
    localIntent.putExtra("dataline_send_file_type", paramEFILETYPE.ordinal());
    localIntent.putExtra("dataline_send_file_flag", true);
    paramBaseActivity.startActivity(localIntent);
    paramBaseActivity.finish();
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord, boolean paramBoolean)
  {
    if (paramDataLineMsgRecord == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      paramDataLineMsgRecord = a(paramDataLineMsgRecord.path, paramDataLineMsgRecord.thumbPath, a(paramDataLineMsgRecord.msgtype), paramDataLineMsgRecord.sessionid, paramDataLineMsgRecord.groupId, paramDataLineMsgRecord.groupSize, paramDataLineMsgRecord.groupIndex, true);
    } while (paramDataLineMsgRecord == null);
    localArrayList.add(paramDataLineMsgRecord);
    b(localArrayList, paramBoolean);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600")) {
      a(paramToServiceMsg, paramFromServiceMsg, 1610);
    }
    do
    {
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700"))
      {
        a(paramToServiceMsg, paramFromServiceMsg, 1710);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800"))
      {
        a(paramToServiceMsg, paramFromServiceMsg, 1810);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200"))
      {
        a(paramToServiceMsg, paramFromServiceMsg, 1210);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DataLineHandler", 2, "<PbSendMsg><R><---handle0x346Rsp, unknown cmd:" + paramFromServiceMsg.getServiceCmd());
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000))
    {
      int i1 = paramToServiceMsg.extraData.getInt("DATALINE_TRYINDEX");
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "<PbSendMsg><R><---handle0x346Rsp, retry = " + i1 + ", nCmdType:" + paramInt);
      }
      if (i1 < 3)
      {
        paramToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", i1 + 1);
        d(paramToServiceMsg);
        return;
      }
    }
    new Handler(Looper.getMainLooper()).post(new cru(this, paramToServiceMsg, paramFromServiceMsg, paramInt));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (c(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new crt(this, paramToServiceMsg, paramFromServiceMsg, paramObject));
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      FMToastUtil.a("'" + paramString + "'" + BaseApplication.getContext().getResources().getString(2131361871));
      return;
    }
    new Handler(localLooper).post(new cro(this, paramString));
  }
  
  public void a(ArrayList paramArrayList)
  {
    a(paramArrayList, null, null);
  }
  
  public void a(ArrayList paramArrayList, String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayList == null) {}
    int i2;
    int i1;
    ArrayList localArrayList;
    Session localSession;
    for (;;)
    {
      return;
      i2 = paramArrayList.size();
      if (i2 > 5) {
        break;
      }
      i1 = 0;
      while (i1 < i2)
      {
        localArrayList = new ArrayList();
        localSession = a(((FileInfo)paramArrayList.get(i1)).d(), null, DataLineHandler.EFILETYPE.FILE_TYPE_FILE, 0L, 0, 0, 0, false);
        a(localSession, paramString, paramArrayOfByte);
        if (localSession != null) {
          localArrayList.add(localSession);
        }
        if (localArrayList.size() > 0) {
          b(localArrayList, false);
        }
        i1 += 1;
      }
    }
    if ((i2 > 5) && (i2 < 50))
    {
      localArrayList = new ArrayList();
      int i3 = a();
      i1 = 0;
      label139:
      if (i1 < i2)
      {
        localSession = a(((FileInfo)paramArrayList.get(i1)).d(), null, DataLineHandler.EFILETYPE.FILE_TYPE_FILE, 0L, i3, i2, i1, false);
        a(localSession, paramString, paramArrayOfByte);
        if (localSession != null) {
          localArrayList.add(localSession);
        }
        if (!DataLineMsgSet.isSingle(DataLineHandler.EFILETYPE.FILE_TYPE_FILE, i3)) {
          break label456;
        }
        localSession.dwGroupID = 0;
        localSession.dwGroupIndex = 0;
        localSession.dwGroupSize = 0;
        if (localArrayList.size() > 0) {
          b(localArrayList, false);
        }
        localArrayList = new ArrayList();
      }
    }
    label293:
    label453:
    label456:
    for (;;)
    {
      i1 += 1;
      break label139;
      if (localArrayList.size() <= 0) {
        break;
      }
      b(localArrayList, false);
      return;
      i2 = a();
      localArrayList = new ArrayList();
      i1 = 0;
      if (i1 < 50)
      {
        localSession = a(((FileInfo)paramArrayList.get(i1)).d(), null, DataLineHandler.EFILETYPE.FILE_TYPE_FILE, 0L, i2, 50, i1, false);
        a(localSession, paramString, paramArrayOfByte);
        if (localSession != null) {
          localArrayList.add(localSession);
        }
        if (!DataLineMsgSet.isSingle(DataLineHandler.EFILETYPE.FILE_TYPE_FILE, i2)) {
          break label453;
        }
        localSession.dwGroupID = 0;
        localSession.dwGroupIndex = 0;
        localSession.dwGroupSize = 0;
        if (localArrayList.size() > 0) {
          b(localArrayList, false);
        }
        localArrayList = new ArrayList();
      }
      for (;;)
      {
        i1 += 1;
        break label293;
        if (localArrayList.size() > 0) {
          b(localArrayList, false);
        }
        i1 = 0;
        while (i1 < 50)
        {
          paramArrayList.remove(0);
          i1 += 1;
        }
        break;
      }
    }
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (DataLineMsgRecord)paramArrayList.next();
      localObject = a(((DataLineMsgRecord)localObject).path, ((DataLineMsgRecord)localObject).thumbPath, a(((DataLineMsgRecord)localObject).msgtype), ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    if (localArrayList.size() > 0) {
      b(localArrayList, paramBoolean);
    }
  }
  
  /* Error */
  public void a(msg_comm.Msg paramMsg)
  {
    // Byte code:
    //   0: new 1871	msf/msgcomm/msg_comm$MsgType0x210
    //   3: dup
    //   4: invokespecial 1872	msf/msgcomm/msg_comm$MsgType0x210:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_1
    //   12: getfield 1878	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   15: invokevirtual 1883	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   18: checkcast 1880	tencent/im/msg/im_msg_body$MsgBody
    //   21: getfield 1886	tencent/im/msg/im_msg_body$MsgBody:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   24: invokevirtual 370	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   27: invokevirtual 376	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   30: invokevirtual 1887	msf/msgcomm/msg_comm$MsgType0x210:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: checkcast 1871	msf/msgcomm/msg_comm$MsgType0x210
    //   36: astore 5
    //   38: aload 5
    //   40: astore 4
    //   42: invokestatic 317	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +12 -> 57
    //   48: ldc 37
    //   50: iconst_2
    //   51: ldc_w 1889
    //   54: invokestatic 324	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: new 1038	com/qq/taf/jce/JceInputStream
    //   60: dup
    //   61: aload 4
    //   63: getfield 1890	msf/msgcomm/msg_comm$MsgType0x210:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   66: invokevirtual 370	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   69: invokevirtual 376	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   72: invokespecial 1039	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   75: astore 5
    //   77: new 1892	IMMsgBodyPack/MsgType0x210
    //   80: dup
    //   81: invokespecial 1893	IMMsgBodyPack/MsgType0x210:<init>	()V
    //   84: astore 4
    //   86: aload 4
    //   88: aload 5
    //   90: invokevirtual 1894	IMMsgBodyPack/MsgType0x210:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   93: new 392	com/tencent/mobileqq/data/DataLineMsgRecord
    //   96: dup
    //   97: invokespecial 737	com/tencent/mobileqq/data/DataLineMsgRecord:<init>	()V
    //   100: astore 5
    //   102: aload 5
    //   104: aload_1
    //   105: getfield 1898	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   108: invokevirtual 1901	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   111: checkcast 1900	msf/msgcomm/msg_comm$MsgHead
    //   114: getfield 1904	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   117: invokevirtual 390	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   120: i2l
    //   121: putfield 757	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   124: aload 5
    //   126: aload_1
    //   127: getfield 1898	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   130: invokevirtual 1901	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   133: checkcast 1900	msf/msgcomm/msg_comm$MsgHead
    //   136: getfield 1907	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   139: invokevirtual 390	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   142: i2l
    //   143: putfield 754	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   146: aload 5
    //   148: aload_1
    //   149: getfield 1898	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   152: invokevirtual 1901	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   155: checkcast 1900	msf/msgcomm/msg_comm$MsgHead
    //   158: getfield 1910	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   161: invokevirtual 623	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   164: putfield 539	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   167: aload_0
    //   168: aload 5
    //   170: invokevirtual 1912	com/tencent/mobileqq/app/DataLineHandler:a	(Lcom/tencent/mobileqq/data/DataLineMsgRecord;)Z
    //   173: ifeq +82 -> 255
    //   176: invokestatic 317	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +53 -> 232
    //   182: ldc 37
    //   184: iconst_2
    //   185: new 206	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   192: ldc_w 1914
    //   195: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload 5
    //   200: getfield 757	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   203: invokevirtual 424	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   206: ldc_w 1916
    //   209: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 5
    //   214: getfield 754	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   217: invokevirtual 424	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   220: ldc_w 1918
    //   223: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 324	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: return
    //   233: astore 5
    //   235: invokestatic 317	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +14 -> 252
    //   241: ldc 37
    //   243: iconst_2
    //   244: ldc_w 1920
    //   247: aload 5
    //   249: invokestatic 1923	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   252: goto -210 -> 42
    //   255: aload_0
    //   256: getfield 290	com/tencent/mobileqq/app/DataLineHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   259: bipush 9
    //   261: invokevirtual 1926	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   264: checkcast 1928	com/tencent/mobileqq/app/RegisterProxySvcPackHandler
    //   267: astore_1
    //   268: aload_1
    //   269: ifnull +38 -> 307
    //   272: aload_1
    //   273: invokevirtual 1929	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:a	()I
    //   276: istore_2
    //   277: aload_1
    //   278: invokevirtual 1931	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:b	()I
    //   281: istore_3
    //   282: iload_2
    //   283: iconst_1
    //   284: if_icmpne +8 -> 292
    //   287: iload_2
    //   288: iconst_2
    //   289: if_icmpeq +8 -> 297
    //   292: aload_1
    //   293: iconst_1
    //   294: invokevirtual 1933	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:a	(I)V
    //   297: iload_3
    //   298: iconst_1
    //   299: if_icmpeq +8 -> 307
    //   302: aload_1
    //   303: iconst_1
    //   304: invokevirtual 1934	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:b	(I)V
    //   307: aload 4
    //   309: getfield 1937	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   312: ldc2_w 1938
    //   315: lcmp
    //   316: ifne +76 -> 392
    //   319: aload_0
    //   320: aload 4
    //   322: getfield 1943	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   325: getfield 1945	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_src_app_id	J
    //   328: l2i
    //   329: aload 4
    //   331: getfield 1943	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   334: getfield 1947	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_src_inst_id	J
    //   337: l2i
    //   338: invokevirtual 1949	com/tencent/mobileqq/app/DataLineHandler:a	(II)Z
    //   341: ifne -109 -> 232
    //   344: aload_0
    //   345: aload 4
    //   347: getfield 1943	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   350: getfield 1951	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_dst_app_id	J
    //   353: l2i
    //   354: aload 4
    //   356: getfield 1943	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   359: getfield 1953	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_dst_inst_id	J
    //   362: l2i
    //   363: invokespecial 1955	com/tencent/mobileqq/app/DataLineHandler:b	(II)Z
    //   366: ifeq -134 -> 232
    //   369: aload_0
    //   370: aload 5
    //   372: getfield 754	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   375: l2i
    //   376: aload 5
    //   378: getfield 757	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   381: l2i
    //   382: i2s
    //   383: aload 4
    //   385: getfield 1943	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   388: invokespecial 1957	com/tencent/mobileqq/app/DataLineHandler:a	(ISLIMMsgBodyPack/MsgType0x210SubMsgType0x13;)V
    //   391: return
    //   392: aload 4
    //   394: getfield 1937	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   397: ldc2_w 1750
    //   400: lcmp
    //   401: ifne +167 -> 568
    //   404: aload_0
    //   405: aload 4
    //   407: getfield 1961	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   410: getfield 1966	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uSrcAppId	J
    //   413: l2i
    //   414: aload 4
    //   416: getfield 1961	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   419: getfield 1969	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uSrcInstId	J
    //   422: l2i
    //   423: invokevirtual 1949	com/tencent/mobileqq/app/DataLineHandler:a	(II)Z
    //   426: ifne -194 -> 232
    //   429: aload_0
    //   430: aload 4
    //   432: getfield 1961	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   435: getfield 1972	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstAppId	J
    //   438: l2i
    //   439: aload 4
    //   441: getfield 1961	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   444: getfield 1975	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstInstId	J
    //   447: l2i
    //   448: invokespecial 1955	com/tencent/mobileqq/app/DataLineHandler:b	(II)Z
    //   451: ifeq -219 -> 232
    //   454: aload_0
    //   455: getfield 163	com/tencent/mobileqq/app/DataLineHandler:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   458: aload 4
    //   460: getfield 1961	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   463: getfield 1978	IMMsgBodyPack/MsgType0x210SubMsgType0x2:lSessionId	J
    //   466: aload 4
    //   468: getfield 1961	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   471: getfield 1981	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uOriginfiletype	J
    //   474: aload 4
    //   476: getfield 1961	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   479: getfield 1984	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstUin	J
    //   482: new 697	java/lang/String
    //   485: dup
    //   486: aload 4
    //   488: getfield 1961	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   491: getfield 1987	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileName	[B
    //   494: invokespecial 723	java/lang/String:<init>	([B)V
    //   497: aload 4
    //   499: getfield 1961	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   502: getfield 1990	IMMsgBodyPack/MsgType0x210SubMsgType0x2:lFileLen	J
    //   505: aload 4
    //   507: getfield 1961	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   510: getfield 1993	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileMd5	[B
    //   513: new 697	java/lang/String
    //   516: dup
    //   517: aload 4
    //   519: getfield 1961	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   522: getfield 1996	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileIndex	[B
    //   525: invokespecial 723	java/lang/String:<init>	([B)V
    //   528: aload 4
    //   530: getfield 1961	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   533: getfield 1999	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strOriginfile_md5	[B
    //   536: iconst_0
    //   537: iconst_0
    //   538: iconst_0
    //   539: iconst_0
    //   540: aload 5
    //   542: getfield 754	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   545: l2i
    //   546: i2l
    //   547: aload 5
    //   549: getfield 757	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   552: l2i
    //   553: i2s
    //   554: i2l
    //   555: aload 5
    //   557: getfield 539	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   560: iconst_0
    //   561: invokevirtual 2003	com/tencent/litetransfersdk/LiteTransferWrapper:OnFileComing210_0x2	(JJJLjava/lang/String;J[BLjava/lang/String;[BIIIIJJJZ)V
    //   564: return
    //   565: astore_1
    //   566: aload_1
    //   567: athrow
    //   568: aload 4
    //   570: getfield 1937	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   573: ldc2_w 2004
    //   576: lcmp
    //   577: ifne +181 -> 758
    //   580: aload_0
    //   581: aload 4
    //   583: getfield 2009	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   586: getfield 2012	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uSrcAppId	J
    //   589: l2i
    //   590: aload 4
    //   592: getfield 2009	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   595: getfield 2013	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uSrcInstId	J
    //   598: l2i
    //   599: invokevirtual 1949	com/tencent/mobileqq/app/DataLineHandler:a	(II)Z
    //   602: ifne -370 -> 232
    //   605: aload_0
    //   606: aload 4
    //   608: getfield 2009	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   611: getfield 2014	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstAppId	J
    //   614: l2i
    //   615: aload 4
    //   617: getfield 2009	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   620: getfield 2015	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstInstId	J
    //   623: l2i
    //   624: invokespecial 1955	com/tencent/mobileqq/app/DataLineHandler:b	(II)Z
    //   627: ifeq -395 -> 232
    //   630: aload_0
    //   631: getfield 163	com/tencent/mobileqq/app/DataLineHandler:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   634: aload 4
    //   636: getfield 2009	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   639: getfield 2016	IMMsgBodyPack/MsgType0x210SubMsgType0xa:lSessionId	J
    //   642: aload 4
    //   644: getfield 2009	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   647: getfield 2017	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uOriginfiletype	J
    //   650: aload 4
    //   652: getfield 2009	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   655: getfield 2018	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstUin	J
    //   658: new 697	java/lang/String
    //   661: dup
    //   662: aload 4
    //   664: getfield 2009	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   667: getfield 2019	IMMsgBodyPack/MsgType0x210SubMsgType0xa:strFileName	[B
    //   670: invokespecial 723	java/lang/String:<init>	([B)V
    //   673: aload 4
    //   675: getfield 2009	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   678: getfield 2022	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uFileLen	J
    //   681: aload 4
    //   683: getfield 2009	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   686: getfield 2025	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vMd5	[B
    //   689: aload 4
    //   691: getfield 2009	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   694: getfield 2028	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uServerIp	J
    //   697: aload 4
    //   699: getfield 2009	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   702: getfield 2031	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uServerPort	J
    //   705: aload 4
    //   707: getfield 2009	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   710: getfield 2034	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vUrlNotify	[B
    //   713: aload 4
    //   715: getfield 2009	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   718: getfield 2037	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vTokenKey	[B
    //   721: aload 4
    //   723: getfield 2009	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   726: getfield 2038	IMMsgBodyPack/MsgType0x210SubMsgType0xa:strOriginfile_md5	[B
    //   729: iconst_0
    //   730: iconst_0
    //   731: iconst_0
    //   732: iconst_0
    //   733: aload 5
    //   735: getfield 754	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   738: l2i
    //   739: i2l
    //   740: aload 5
    //   742: getfield 757	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   745: l2i
    //   746: i2s
    //   747: i2l
    //   748: aload 5
    //   750: getfield 539	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   753: iconst_0
    //   754: invokevirtual 2042	com/tencent/litetransfersdk/LiteTransferWrapper:onFileComing210_0xa	(JJJLjava/lang/String;J[BJJ[B[B[BIIIIJJJZ)V
    //   757: return
    //   758: aload 4
    //   760: getfield 1937	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   763: ldc2_w 2043
    //   766: lcmp
    //   767: ifne -535 -> 232
    //   770: aload_0
    //   771: aload 4
    //   773: getfield 2048	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   776: getfield 2051	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_src_app_id	J
    //   779: l2i
    //   780: aload 4
    //   782: getfield 2048	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   785: getfield 2052	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_src_inst_id	J
    //   788: l2i
    //   789: invokevirtual 1949	com/tencent/mobileqq/app/DataLineHandler:a	(II)Z
    //   792: ifne -560 -> 232
    //   795: aload_0
    //   796: aload 4
    //   798: getfield 2048	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   801: getfield 2053	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_dst_app_id	J
    //   804: l2i
    //   805: aload 4
    //   807: getfield 2048	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   810: getfield 2054	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_dst_inst_id	J
    //   813: l2i
    //   814: invokespecial 1955	com/tencent/mobileqq/app/DataLineHandler:b	(II)Z
    //   817: ifeq -585 -> 232
    //   820: aload_0
    //   821: getfield 163	com/tencent/mobileqq/app/DataLineHandler:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   824: aload 4
    //   826: getfield 2048	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   829: getfield 2055	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint64_sessionid	J
    //   832: aload 4
    //   834: getfield 2048	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   837: getfield 2057	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_operate	J
    //   840: iconst_0
    //   841: aload 5
    //   843: getfield 754	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   846: l2i
    //   847: aload 5
    //   849: getfield 757	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   852: l2i
    //   853: i2s
    //   854: invokevirtual 2061	com/tencent/litetransfersdk/LiteTransferWrapper:onFileOperate0x210	(JJIIS)V
    //   857: return
    //   858: astore_1
    //   859: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	860	0	this	DataLineHandler
    //   0	860	1	paramMsg	msg_comm.Msg
    //   276	14	2	i1	int
    //   281	19	3	i2	int
    //   7	826	4	localObject1	Object
    //   36	177	5	localObject2	Object
    //   233	615	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	38	233	java/lang/Exception
    //   86	232	565	finally
    //   255	268	565	finally
    //   272	282	565	finally
    //   292	297	565	finally
    //   302	307	565	finally
    //   307	391	565	finally
    //   392	564	565	finally
    //   568	757	565	finally
    //   758	857	565	finally
    //   86	232	858	java/lang/Exception
    //   255	268	858	java/lang/Exception
    //   272	282	858	java/lang/Exception
    //   292	297	858	java/lang/Exception
    //   302	307	858	java/lang/Exception
    //   307	391	858	java/lang/Exception
    //   392	564	858	java/lang/Exception
    //   568	757	858	java/lang/Exception
    //   758	857	858	java/lang/Exception
  }
  
  public void a(msg_comm.Msg paramMsg, SubMsgType0x7.MsgBody paramMsgBody)
  {
    Object localObject;
    for (;;)
    {
      try
      {
        localObject = new DataLineMsgRecord();
        ((DataLineMsgRecord)localObject).shmsgseq = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
        ((DataLineMsgRecord)localObject).time = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
        ((DataLineMsgRecord)localObject).msgId = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
        if (!a((DataLineMsgRecord)localObject)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "<<<<<<<<<<recv repeat 0x211 msg begin seq:" + ((DataLineMsgRecord)localObject).shmsgseq + "time:" + ((DataLineMsgRecord)localObject).time + ">>>>>>>>>>");
        }
        if (paramMsgBody.uint32_sub_cmd.has()) {}
        switch (paramMsgBody.uint32_sub_cmd.get())
        {
        case 6: 
        case 7: 
        case 8: 
          label212:
          if (!QLog.isColorLevel()) {
            break label2100;
          }
          QLog.d("DataLineHandler", 2, "<<<<<<<<<<recv repeat 0x211 msg end >>>>>>>>>>");
          return;
        }
      }
      catch (Exception paramMsg)
      {
        paramMsg = paramMsg;
        if (!QLog.isColorLevel()) {
          break label2100;
        }
        QLog.d("DataLineHandler", 2, "<<<<<<<<<<handleDataLinePushMsg_PB_0x211 Exception:" + paramMsg.toString() + ">>>>>>>>>>");
        return;
      }
      finally {}
      if ((!paramMsgBody.msg_subcmd_0x4_generic.has()) || (!paramMsgBody.msg_subcmd_0x4_generic.uint32_type.has())) {
        break label2100;
      }
      switch (paramMsgBody.msg_subcmd_0x4_generic.uint32_type.get())
      {
      case 1: 
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "0x211 0x7 0x4 0x1文本消息");
        }
        break;
      case 3: 
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "0x211 0x7 0x4 0x3 WifiPhoto");
        }
        break;
      case 5: 
        if (QLog.isColorLevel())
        {
          QLog.d("DataLineHandler", 2, "0x211 0x7 0x4 0x5 WifiPhoto");
          continue;
          if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
            break label2100;
          }
          paramMsg = paramMsgBody.rpt_msg_subcmd_0x1_ftn_notify.get().iterator();
          while (paramMsg.hasNext())
          {
            paramMsgBody = (SubMsgType0x7.MsgBody.FTNNotify)paramMsg.next();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("0x211 0x7 0x1 文件原图中转通知 groupid:");
              if (!paramMsgBody.uint32_group_id.has()) {
                break label2104;
              }
              i1 = paramMsgBody.uint32_group_id.get();
              label480:
              localObject = ((StringBuilder)localObject).append(i1).append(" groupSize:");
              if (!paramMsgBody.uint32_group_size.has()) {
                break label2109;
              }
              i1 = paramMsgBody.uint32_group_size.get();
              label512:
              localObject = ((StringBuilder)localObject).append(i1).append("groupIndex:");
              if (!paramMsgBody.uint32_group_curindex.has()) {
                break label2114;
              }
              i1 = paramMsgBody.uint32_group_curindex.get();
              label544:
              QLog.d("DataLineHandler", 2, i1);
            }
          }
          if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
            break label2100;
          }
          paramMsg = paramMsgBody.rpt_msg_subcmd_0x2_nfc_notify.get().iterator();
          while (paramMsg.hasNext())
          {
            paramMsgBody = (SubMsgType0x7.MsgBody.NFCNotify)paramMsg.next();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("0x211 0x7 0x2 文件原图近场通知 groupid:");
              if (!paramMsgBody.uint32_group_id.has()) {
                break label2119;
              }
              i1 = paramMsgBody.uint32_group_id.get();
              label646:
              localObject = ((StringBuilder)localObject).append(i1).append(" groupSize:");
              if (!paramMsgBody.uint32_group_size.has()) {
                break label2124;
              }
              i1 = paramMsgBody.uint32_group_size.get();
              label678:
              localObject = ((StringBuilder)localObject).append(i1).append("groupIndex:");
              if (!paramMsgBody.uint32_group_curindex.has()) {
                break label2129;
              }
              i1 = paramMsgBody.uint32_group_curindex.get();
              label710:
              QLog.d("DataLineHandler", 2, i1);
            }
          }
          paramMsg = paramMsgBody.rpt_msg_subcmd_0x3_filecontrol.get().iterator();
          while (paramMsg.hasNext())
          {
            paramMsgBody = (SubMsgType0x7.MsgBody.FileControl)paramMsg.next();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("0x211 0x7 0x3 文件控制命令 groupid:");
              if (!paramMsgBody.uint32_group_id.has()) {
                break label2134;
              }
              i1 = paramMsgBody.uint32_group_id.get();
              label799:
              QLog.d("DataLineHandler", 2, i1);
            }
          }
          paramMsg = paramMsgBody.rpt_msg_subcmd_0x5_molo_notify.get().iterator();
          while (paramMsg.hasNext())
          {
            paramMsgBody = (SubMsgType0x7.MsgBody.MoloNotify)paramMsg.next();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("0x211 0x7 0x5 应用宝通知 groupid:");
              if (!paramMsgBody.uint32_group_id.has()) {
                break label2139;
              }
              i1 = paramMsgBody.uint32_group_id.get();
              label888:
              localObject = ((StringBuilder)localObject).append(i1).append(" groupSize:");
              if (!paramMsgBody.uint32_group_size.has()) {
                break label2144;
              }
              i1 = paramMsgBody.uint32_group_size.get();
              label920:
              localObject = ((StringBuilder)localObject).append(i1).append("groupIndex:");
              if (!paramMsgBody.uint32_group_curindex.has()) {
                break label2149;
              }
              i1 = paramMsgBody.uint32_group_curindex.get();
              label952:
              QLog.d("DataLineHandler", 2, i1);
            }
          }
          if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
            break label2100;
          }
          paramMsg = paramMsgBody.rpt_msg_subcmd_0x9_ftn_thumb_notify.get().iterator();
          while (paramMsg.hasNext())
          {
            paramMsgBody = (SubMsgType0x7.MsgBody.FTNNotify)paramMsg.next();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("0x211 0x7 0x9 文件缩略图中转通知 groupid:");
              if (!paramMsgBody.uint32_group_id.has()) {
                break label2154;
              }
              i1 = paramMsgBody.uint32_group_id.get();
              label1054:
              localObject = ((StringBuilder)localObject).append(i1).append(" groupSize:");
              if (!paramMsgBody.uint32_group_size.has()) {
                break label2159;
              }
              i1 = paramMsgBody.uint32_group_size.get();
              label1086:
              localObject = ((StringBuilder)localObject).append(i1).append("groupIndex:");
              if (!paramMsgBody.uint32_group_curindex.has()) {
                break label2164;
              }
              i1 = paramMsgBody.uint32_group_curindex.get();
              label1118:
              QLog.d("DataLineHandler", 2, i1);
            }
          }
          if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
            break label2100;
          }
          paramMsg = paramMsgBody.rpt_msg_subcmd_0xa_nfc_thumb_notify.get().iterator();
          label1162:
          do
          {
            if (!paramMsg.hasNext()) {
              break;
            }
            paramMsgBody = (SubMsgType0x7.MsgBody.NFCNotify)paramMsg.next();
          } while (!QLog.isColorLevel());
          localObject = new StringBuilder().append("0x211 0x7 0xa 文件缩略图近场通知 groupid:");
          if (!paramMsgBody.uint32_group_id.has()) {
            break label2169;
          }
          i1 = paramMsgBody.uint32_group_id.get();
          label1220:
          localObject = ((StringBuilder)localObject).append(i1).append(" groupSize:");
          if (!paramMsgBody.uint32_group_size.has()) {
            break label2174;
          }
          i1 = paramMsgBody.uint32_group_size.get();
          label1252:
          localObject = ((StringBuilder)localObject).append(i1).append("groupIndex:");
          if (!paramMsgBody.uint32_group_curindex.has()) {
            break label2179;
          }
        }
        break;
      }
    }
    label2179:
    for (int i1 = paramMsgBody.uint32_group_curindex.get();; i1 = 0)
    {
      QLog.d("DataLineHandler", 2, i1);
      break label1162;
      if (!paramMsgBody.msg_header.has()) {
        throw new Exception("msgBody do not has msg_header");
      }
      if (!paramMsgBody.msg_header.uint32_src_app_id.has()) {
        throw new Exception("msgBody do not has uint32_src_app_id");
      }
      if (!paramMsgBody.msg_header.uint32_src_inst_id.has()) {
        throw new Exception("msgBody do not has uint32_src_inst_id");
      }
      if (!paramMsgBody.msg_header.uint32_dst_app_id.has()) {
        throw new Exception("msgBody do not has uint32_dst_app_id");
      }
      if (!paramMsgBody.msg_header.uint32_dst_inst_id.has()) {
        throw new Exception("msgBody do not has uint32_dst_inst_id");
      }
      if (a(paramMsgBody.msg_header.uint32_src_app_id.get(), paramMsgBody.msg_header.uint32_src_inst_id.get())) {
        throw new Exception("msgBody command from android");
      }
      if ((paramMsgBody.uint32_sub_cmd.get() != 5) && (!b(paramMsgBody.msg_header.uint32_dst_app_id.get(), paramMsgBody.msg_header.uint32_dst_inst_id.get()))) {
        throw new Exception("msgBody command not for android");
      }
      paramMsg = (RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(9);
      if (paramMsg != null)
      {
        i1 = paramMsg.a();
        int i2 = paramMsg.b();
        if ((i1 != 1) || (i1 != 2)) {
          paramMsg.a(1);
        }
        if (i2 != 1) {
          paramMsg.b(1);
        }
      }
      if (!paramMsgBody.uint32_sub_cmd.has()) {
        throw new Exception("msgBody do not has uint32_sub_cmd");
      }
      switch (paramMsgBody.uint32_sub_cmd.get())
      {
      case 1: 
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "0x211 0x7 0x1 文件原图中转通知");
        }
        if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
          throw new Exception("msg_header do not has uint64_dst_uin");
        }
      case 4: 
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "0x211 0x7 0x4 通用协议");
        }
        if (!paramMsgBody.msg_subcmd_0x4_generic.has()) {
          throw new Exception("msgBody do not has msg_subcmd_0x4_generic");
        }
        a(((DataLineMsgRecord)localObject).time, ((DataLineMsgRecord)localObject).shmsgseq, paramMsgBody.msg_subcmd_0x4_generic);
        return;
        a(((DataLineMsgRecord)localObject).time, ((DataLineMsgRecord)localObject).shmsgseq, ((DataLineMsgRecord)localObject).msgId, paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x1_ftn_notify.get(), false);
        return;
      case 2: 
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "0x211 0x7 0x2 文件原图近场通知");
        }
        if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
          throw new Exception("msg_header do not has uint64_dst_uin");
        }
        b(((DataLineMsgRecord)localObject).time, ((DataLineMsgRecord)localObject).shmsgseq, ((DataLineMsgRecord)localObject).msgId, paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x2_nfc_notify.get(), false);
        return;
      case 3: 
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "0x211 0x7 0x3 文件控制命令");
        }
        a(((DataLineMsgRecord)localObject).time, ((DataLineMsgRecord)localObject).shmsgseq, ((DataLineMsgRecord)localObject).msgId, paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x3_filecontrol.get());
        return;
      case 5: 
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "0x211 0x7 0x5 应用宝通知");
        }
        a(((DataLineMsgRecord)localObject).time, ((DataLineMsgRecord)localObject).shmsgseq, ((DataLineMsgRecord)localObject).msgId, paramMsgBody.rpt_msg_subcmd_0x5_molo_notify.get());
        return;
      case 11: 
        a(((DataLineMsgRecord)localObject).time, ((DataLineMsgRecord)localObject).shmsgseq, paramMsgBody.rpt_msg_subcmd_0xb_mpfile_notify.get());
        return;
      case 9: 
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "0x211 0x7 0x9 文件缩略图中转通知");
        }
        if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
          throw new Exception("msg_header do not has uint64_dst_uin");
        }
        a(((DataLineMsgRecord)localObject).time, ((DataLineMsgRecord)localObject).shmsgseq, ((DataLineMsgRecord)localObject).msgId, paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x9_ftn_thumb_notify.get(), true);
        return;
      case 10: 
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "0x211 0x7 0xa 文件缩略图近场通知");
        }
        if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
          throw new Exception("msg_header do not has uint64_dst_uin");
        }
        b(((DataLineMsgRecord)localObject).time, ((DataLineMsgRecord)localObject).shmsgseq, ((DataLineMsgRecord)localObject).msgId, paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0xa_nfc_thumb_notify.get(), true);
        return;
        break label212;
        label2100:
        return;
        break label212;
        label2104:
        i1 = 0;
        break label480;
        label2109:
        i1 = 0;
        break label512;
        label2114:
        i1 = 0;
        break label544;
        label2119:
        i1 = 0;
        break label646;
        label2124:
        i1 = 0;
        break label678;
        label2129:
        i1 = 0;
        break label710;
        label2134:
        i1 = 0;
        break label799;
        label2139:
        i1 = 0;
        break label888;
        label2144:
        i1 = 0;
        break label920;
        label2149:
        i1 = 0;
        break label952;
        label2154:
        i1 = 0;
        break label1054;
        label2159:
        i1 = 0;
        break label1086;
        label2164:
        i1 = 0;
        break label1118;
        label2169:
        i1 = 0;
        break label1220;
        label2174:
        i1 = 0;
        break label1252;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    l();
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(paramInt));
  }
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    int i1 = AppSetting.jdField_a_of_type_Int;
    if ((paramInt1 == 1001) && (paramInt2 == i1) && (QLog.isColorLevel())) {
      QLog.d("DataLineHandler", 2, "msgBody command from android" + paramInt2 + " " + i1);
    }
    return false;
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
    DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt);
    if ((localDataLineMsgSet != null) && (localDataLineMsgSet.isPaused()))
    {
      if (localDataLineMsgRecord != null)
      {
        localDataLineMsgRecord.issuc = true;
        localDataLineMsgRecord.fileMsgStatus = 2L;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().c(localDataLineMsgRecord.msgId);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      if ((localObject != null) && (((DataLineMsgSetList)localObject).size() > 0))
      {
        localObject = ((DataLineMsgSetList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Iterator localIterator = ((DataLineMsgSet)((Iterator)localObject).next()).values().iterator();
          while (localIterator.hasNext())
          {
            DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
            this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localDataLineMsgRecord.shmsgseq));
          }
        }
      }
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (((Long)((Iterator)localObject).next()).longValue() != paramDataLineMsgRecord.shmsgseq);
    for (boolean bool = true;; bool = false)
    {
      if (!bool)
      {
        this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(paramDataLineMsgRecord.shmsgseq));
        if (this.jdField_a_of_type_JavaUtilList.size() > 120) {
          this.jdField_a_of_type_JavaUtilList.remove(0);
        }
      }
      return bool;
    }
  }
  
  public boolean a(DataLineMsgSet paramDataLineMsgSet)
  {
    if (!paramDataLineMsgSet.isSingle()) {
      c(paramDataLineMsgSet.getGroupId());
    }
    Iterator localIterator = paramDataLineMsgSet.values().iterator();
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      if (localDataLineMsgRecord.strMoloKey != null)
      {
        List localList = a().a().a(localDataLineMsgRecord.strMoloKey);
        if ((localList == null) || (localList.size() == 1))
        {
          this.jdField_a_of_type_ComDatalineCoreMoloHandler.d(localDataLineMsgRecord.strMoloKey);
          if (QLog.isDevelopLevel()) {
            QLog.d("DataLineHandler", 4, "删除应用宝消息 sessionid[" + localDataLineMsgRecord.sessionid);
          }
        }
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramDataLineMsgSet) >= 0;
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.jdField_a_of_type_ComDatalineCoreMoloHandler.e(paramString);
  }
  
  public boolean a(List paramList)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "manually receives a file . sessionlist");
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    boolean bool1 = false;
    if (paramList.hasNext())
    {
      Long localLong = (Long)paramList.next();
      DataLineMsgRecord localDataLineMsgRecord = a().a().a().b(localLong.longValue());
      if (localDataLineMsgRecord != null)
      {
        localDataLineMsgRecord.fileMsgStatus = 0L;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().c(localDataLineMsgRecord.msgId);
      }
      if ((localDataLineMsgRecord != null) && (localDataLineMsgRecord.strMoloKey != null))
      {
        this.jdField_a_of_type_ComDatalineCoreMoloHandler.a(localDataLineMsgRecord.strMoloKey);
        bool1 = true;
      }
      for (;;)
      {
        break;
        localArrayList.add(localLong);
      }
    }
    if (localArrayList.size() > 0)
    {
      paramList = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper;
      if (localArrayList.size() != 1) {
        break label186;
      }
    }
    label186:
    for (bool1 = bool2;; bool1 = true)
    {
      bool1 = paramList.recvGroup(localArrayList, bool1);
      return bool1;
    }
  }
  
  public ToServiceMsg b(String paramString)
  {
    return a(paramString);
  }
  
  public void b()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      FMToastUtil.a(2131361874);
      return;
    }
    new Handler(localLooper).post(new crr(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComDatalineCoreMoloHandler.a(paramInt);
  }
  
  public void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (this.jdField_b_of_type_JavaUtilTimer != null)
    {
      this.jdField_b_of_type_JavaUtilTimer.cancel();
      this.jdField_b_of_type_JavaUtilTimer = null;
    }
    if ((paramInt == 3) || (paramInt == 2) || (paramInt == 1) || (paramInt == 8))
    {
      this.jdField_b_of_type_JavaUtilTimer = new Timer();
      this.jdField_b_of_type_JavaUtilTimer.schedule(new crm(this), 20000L);
    }
    a(paramInt, paramBoolean, paramObject);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "received a cmd=" + paramFromServiceMsg.getServiceCmd());
    }
    if (paramFromServiceMsg.getServiceCmd().equals("TransService.FileDeleteReq")) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!paramFromServiceMsg.getServiceCmd().equals("MessageSvc.PbSendMsg")) {
      return;
    }
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void b(String paramString)
  {
    int i1 = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131492887) - (int)DisplayUtils.a(BaseApplicationImpl.getContext(), 5.0F);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      paramString = "'" + paramString + "'" + BaseApplication.getContext().getResources().getString(2131361873);
      QQToast.a(BaseApplicationImpl.getContext(), 1, paramString, 0).b(i1);
      return;
    }
    new Handler(localLooper).post(new crp(this, paramString, i1));
  }
  
  public void b(boolean paramBoolean)
  {
    g();
    Intent localIntent = new Intent();
    if (localIntent != null)
    {
      localIntent.setAction("com.tencent.dataline.wifiphoto.ACTION_WIFIPHOTO_CLOSE");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
    }
    if (paramBoolean) {
      h();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("dl_pc_online_notify", true);
  }
  
  public boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.jdField_a_of_type_ComDatalineCoreMoloHandler.b(paramString);
  }
  
  public int c()
  {
    return ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).b();
  }
  
  public void c()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      FMToastUtil.a(2131361875);
      return;
    }
    new Handler(localLooper).post(new crs(this));
  }
  
  public void c(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      if (!this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(paramInt)))
      {
        this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
        if (this.jdField_b_of_type_JavaUtilList.size() > 256) {
          this.jdField_b_of_type_JavaUtilList.remove(0);
        }
      }
      return;
    }
  }
  
  public final void c(ToServiceMsg paramToServiceMsg)
  {
    a(paramToServiceMsg);
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null))
    {
      int i1 = paramToServiceMsg.extraData.getInt("DATALINE_TRYINDEX");
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "<PbSendMsg><R><---handleDeleteResp, retry = " + i1);
      }
      if (i1 < 3)
      {
        paramToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", i1 + 1);
        c(paramToServiceMsg);
        return;
      }
    }
    new Handler(Looper.getMainLooper()).post(new crc(this, paramToServiceMsg, paramFromServiceMsg, paramObject));
  }
  
  public void c(String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      FMToastUtil.a("'" + paramString + "'" + BaseApplication.getContext().getResources().getString(2131361846));
      return;
    }
    new Handler(localLooper).post(new crq(this, paramString));
  }
  
  public boolean c()
  {
    return a().getPreferences().getBoolean("auto_receive_files", false);
  }
  
  protected boolean c(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("TransService.FileDeleteReq");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.PbSendMsg");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "--->>close cancel all task");
    }
    if (this.jdField_b_of_type_JavaUtilTimer != null)
    {
      this.jdField_b_of_type_JavaUtilTimer.cancel();
      this.jdField_b_of_type_JavaUtilTimer = null;
    }
    d(32);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      if ((localObject != null) && (((DataLineMsgSetList)localObject).size() > 0))
      {
        localObject = ((DataLineMsgSetList)localObject).iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!((DataLineMsgSet)((Iterator)localObject).next()).hasSendingOrRecving());
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.endLiteTransfer(bool);
      g();
      this.jdField_a_of_type_ComDatalineCoreMoloHandler.a();
      return;
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelAll(paramInt);
    this.jdField_a_of_type_ComDatalineCoreMoloHandler.a();
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg.extraData.getInt("ROUNTING_TYPE") != 13) || (!paramToServiceMsg.extraData.getBoolean("ISFROM_DATALINE"))) {
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      int i1 = paramToServiceMsg.extraData.getInt("DATALINE_TRYINDEX");
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "<PbSendMsg><R><---handle0x211C2CMessageError, retry = " + i1);
      }
      if (i1 < 3)
      {
        paramToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", i1 + 1);
        b(paramToServiceMsg);
        return;
      }
    }
    new Handler(Looper.getMainLooper()).post(new crd(this, paramToServiceMsg, paramFromServiceMsg, paramObject));
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    DataLineMsgSet localDataLineMsgSet;
    if (localObject != null)
    {
      localObject = ((DataLineMsgSetList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDataLineMsgSet = (DataLineMsgSet)((Iterator)localObject).next();
        if (!localDataLineMsgSet.isSingle()) {
          c(localDataLineMsgSet.getGroupId());
        }
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false);
    if (localObject != null)
    {
      localObject = ((DataLineMsgSetList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDataLineMsgSet = (DataLineMsgSet)((Iterator)localObject).next();
        if (!localDataLineMsgSet.isSingle()) {
          c(localDataLineMsgSet.getGroupId());
        }
      }
    }
    this.jdField_a_of_type_ComDatalineCoreMoloHandler.b();
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    msg_svc.PbSendMsgResp localPbSendMsgResp = new msg_svc.PbSendMsgResp();
    try
    {
      localPbSendMsgResp = (msg_svc.PbSendMsgResp)localPbSendMsgResp.mergeFrom((byte[])paramObject);
      if ((localPbSendMsgResp == null) || (!localPbSendMsgResp.result.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("DataLineHandler", 2, "handle0x211C2CMessageResp::server did not return a valid result code, use 4 instead.");
        }
        i1 = 4;
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "<PbSendMsg><R><---handle0x211C2CMessageResp: ---ServiceCmd:" + paramToServiceMsg.getServiceCmd() + "----replyCode:" + i1);
        }
        switch (paramToServiceMsg.extraData.getInt("DATALINE_CMD"))
        {
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1;
        if (QLog.isColorLevel()) {
          QLog.e("DataLineHandler", 2, "<---handle0x211C2CMessageResp::invalid.", localException);
        }
        Object localObject = null;
        continue;
        if (localObject.result.get() != 0)
        {
          i1 = localObject.result.get();
          continue;
          g(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.handleFTNNotifyReply(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.handleNFCNotifyReply(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.handleFileOperateReply(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
        else
        {
          i1 = 0;
        }
      }
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer == null) || (!this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer.a())) {
      j();
    }
    if (!jdField_a_of_type_WifiphotoWifiPhotoDataCenter.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr.a())
    {
      jdField_a_of_type_WifiphotoWifiPhotoDataCenter.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr.b();
      new cre(this).start();
      StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "Open_wp");
      if (QLog.isColorLevel()) {
        QLog.d("wifiphoto", 2, "StatisticAssist click Open_wp");
      }
      if (!(SplashActivity.sTopActivity instanceof LiteWifiphotoActivity))
      {
        localObject = new Intent(SplashActivity.sTopActivity, LiteWifiphotoActivity.class);
        ((Intent)localObject).putExtra("isFromStatusbar", false);
        SplashActivity.sTopActivity.startActivity((Intent)localObject);
        SplashActivity.sTopActivity.overridePendingTransition(2130968592, 0);
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if (localObject != null)
      {
        Message localMessage = ((Handler)localObject).obtainMessage(1134021);
        localMessage.arg1 = 1;
        ((Handler)localObject).sendMessage(localMessage);
      }
      return;
    }
    new crf(this).start();
  }
  
  public void g()
  {
    jdField_a_of_type_WifiphotoWifiPhotoDataCenter.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr.d();
    Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
    if (localHandler != null) {
      localHandler.sendMessage(localHandler.obtainMessage(1134022));
    }
    q();
    jdField_a_of_type_WifiphotoWifiPhotoDataCenter.a();
  }
  
  public void h()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("subtype", "1");
      localJSONObject.put("msgid", 0);
      b(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void i()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("subtype", "2");
      localJSONObject.put("msgid", 0);
      b(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void j()
  {
    if (!DBNetworkUtil.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("wifiphoto", 2, "WiFi status is disabled");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer != null) {
      k();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer == null) {
      this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer = new HttpServer(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer.a("", new crl(this));
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer.a();
      this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler
 * JD-Core Version:    0.7.0.1
 */