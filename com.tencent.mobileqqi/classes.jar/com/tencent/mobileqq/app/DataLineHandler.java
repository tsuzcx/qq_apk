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
import android.util.Log;
import com.dataline.activities.LiteWifiphotoActivity;
import com.dataline.core.MoloHandler;
import com.dataline.mpfile.MpFileConstant;
import com.dataline.mpfile.MpfileDataCenter;
import com.dataline.util.DBNetworkUtil;
import com.dataline.util.DataLineReportUtil;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.config.AppSetting;
import com.tencent.image.GifDrawable;
import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.SplashActivity;
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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import far;
import fas;
import fat;
import fau;
import fav;
import faw;
import fax;
import fay;
import faz;
import fba;
import fbb;
import fbc;
import fbe;
import fbf;
import fbg;
import fbh;
import fbi;
import fbj;
import fbk;
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
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.PbSendMsgResp;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_head.InstCtrl;
import tencent.im.msg.im_msg_head.InstInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
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
  public static final int A = 3;
  public static final int B = 4;
  public static final int C = 5;
  public static final int D = 6;
  public static final int E = 7;
  public static final int F = 528;
  private static int G = 0;
  public static final int a = 5;
  public static final long a = 9223372036854775807L;
  public static final String a = "DataLineHandler";
  public static WifiPhotoDataCenter a;
  public static final int b = 50;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  public static final int k = 9;
  public static final int l = 10;
  public static final int m = 11;
  public static final int n = 2;
  public static final int o = 10;
  public static final int p = 14;
  public static final int q = 19;
  public static final int r = 1001;
  public static final int s = 1002;
  public static final int t = 1003;
  public static final int u = 1004;
  public static final int v = 1005;
  public static final int w = 1006;
  public static final int x = 1007;
  public static final int y = 1;
  public static final int z = 2;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private MoloHandler jdField_a_of_type_ComDatalineCoreMoloHandler = new MoloHandler(this);
  private MpfileDataCenter jdField_a_of_type_ComDatalineMpfileMpfileDataCenter = null;
  public LiteTransferWrapper a;
  public MsgHeader a;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new faw(this);
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
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper = new LiteTransferWrapper(this);
    this.jdField_a_of_type_ComTencentLitetransfersdkMsgHeader = new MsgHeader();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    o();
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new far(this, paramQQAppInterface);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addAction("com.tencent.dataline.wifiphoto.ACTION_WIFIPHOTO_CONNECTED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.i.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.i.intent.action.FORCE_LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + paramQQAppInterface.a().getPackageName());
    localIntentFilter.addAction("mqq.i.intent.action.LOGOUT");
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
    switch (fbd.a[paramEFILETYPE.ordinal()])
    {
    case 2: 
    default: 
      return -2005;
    case 1: 
      return -2000;
    }
    return -2333;
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
  
  private ToServiceMsg a(long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2)
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
    paramString.routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
    localToServiceMsg.putWupBuffer(paramString.toByteArray());
    b(localToServiceMsg);
    return localToServiceMsg;
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
      Log.i("wifiphoto", "WiFi status is disabled");
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
          QLog.d("dataline", 2, "moloHandler SubCmd0x5 do not has bytes_buf");
        }
      }
      else
      {
        localDataLineMsgRecord = this.jdField_a_of_type_ComDatalineCoreMoloHandler.a(((SubMsgType0x7.MsgBody.MoloNotify)localObject).bytes_buf.get().toByteArray());
        if (localDataLineMsgRecord == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("dataline", 2, "moloHandler dealWith return null");
          }
        }
        else
        {
          if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_id.has()) {
            break label318;
          }
          i1 = ((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_id.get();
          localDataLineMsgRecord.groupId = i1;
          if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_size.has()) {
            break label324;
          }
          i1 = ((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_size.get();
          label154:
          localDataLineMsgRecord.groupSize = i1;
          if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_curindex.has()) {
            break label330;
          }
          i1 = ((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_curindex.get();
          label182:
          localDataLineMsgRecord.groupIndex = i1;
          if (QLog.isColorLevel()) {
            QLog.d("dataline", 2, "msg group: id-" + localDataLineMsgRecord.groupId + ",size-" + localDataLineMsgRecord.groupSize + ",index-" + localDataLineMsgRecord.groupIndex);
          }
          if (localDataLineMsgRecord.groupSize == 1)
          {
            localDataLineMsgRecord.groupId = 0;
            localDataLineMsgRecord.groupSize = 0;
            localDataLineMsgRecord.groupIndex = 0;
          }
          if ((DataLineMsgSet.isSingle(localDataLineMsgRecord)) || (!a(localDataLineMsgRecord.groupId))) {
            break label336;
          }
          if (QLog.isColorLevel()) {
            QLog.d("dataline", 2, "msg record in deleted group");
          }
        }
      }
    }
    label318:
    label324:
    label330:
    label336:
    do
    {
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label154;
      i1 = 0;
      break label182;
      a().a().a(localDataLineMsgRecord, true);
      if ((DataLineMsgSet.isSingle(localDataLineMsgRecord)) || (!a(localDataLineMsgRecord.groupId))) {
        break label416;
      }
      if (QLog.isColorLevel()) {
        QLog.d("dataline", 2, "msg record in deleted group 2");
      }
      paramList = a().a().a(localDataLineMsgRecord.sessionid);
    } while (paramList == null);
    a(paramList);
    return;
    label416:
    label435:
    boolean bool;
    if (DataLineMsgSet.isSingle(localDataLineMsgRecord))
    {
      DataLineReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      n();
      bool = false;
      if (!a(localDataLineMsgRecord.sessionid, localDataLineMsgRecord.groupId)) {
        break label581;
      }
    }
    for (;;)
    {
      b(6, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf((byte)DataLineHandler.EFILETYPE.FILE_TYPE_FILE.ordinal()), Boolean.valueOf(false), Boolean.valueOf(bool), Long.valueOf(localDataLineMsgRecord.filesize) });
      break;
      localObject = a().a().a(localDataLineMsgRecord.groupId);
      if ((localObject != null) && (((DataLineMsgSet)localObject).getComeCount() != 1)) {
        break label435;
      }
      DataLineReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      n();
      break label435;
      label581:
      localDataLineMsgRecord.issuc = true;
      localDataLineMsgRecord.fileMsgStatus = 1L;
      bool = NetworkUtil.g(BaseApplication.getContext());
      if (localDataLineMsgRecord.filesize <= 5242880L)
      {
        i1 = 1;
        label616:
        if ((!bool) && ((!c()) || (i1 == 0))) {
          break label697;
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
        label673:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localDataLineMsgRecord.msgId);
        continue;
        i1 = 0;
        break label616;
        label697:
        bool = false;
      }
      catch (Exception localException)
      {
        break label673;
      }
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList)
  {
    new Handler(Looper.getMainLooper()).post(new fba(this, paramMsgHeader, paramList));
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
      new Handler(Looper.getMainLooper()).post(new fay(this, paramMsgHeader, localArrayList, paramBoolean));
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
              break label596;
            }
            localObject1 = new String();
            localObject2 = new SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg();
            ((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg)localObject2).mergeFrom(paramGenericSubCmd.bytes_buf.get().toByteArray());
            localIterator = ((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg)localObject2).rpt_msg_item.get().iterator();
          }
        }
        break;
      }
      label593:
      label596:
      label598:
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject2 = (SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localIterator.next();
          if ((!((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).uint32_type.has()) || (((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).uint32_type.get() != 1) || (!((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).bytes_text.has())) {
            break label593;
          }
          String str = new String(((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).bytes_text.get().toByteArray());
          localObject2 = (String)localObject1 + str;
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break label598;
          }
          QLog.d("dataline", 2, str);
          localObject1 = localObject2;
          break label598;
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
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((DataLineMsgRecord)localObject1, true);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, false);
            b(8, true, new Object[] { Integer.valueOf((int)paramLong1), localTextMsgPush.a() });
            return;
            a((int)paramLong1, (short)(int)paramLong2, null);
            return;
            if (paramGenericSubCmd.bytes_buf.has())
            {
              b((int)paramLong1, (short)(int)paramLong2, paramGenericSubCmd.bytes_buf.get().toByteArray());
              return;
              break label598;
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
  
  private boolean a(TextMsgTask paramTextMsgTask)
  {
    int i1 = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    int i2 = paramTextMsgTask.a(localStringBuffer);
    if (i2 == -1) {
      return false;
    }
    while (i1 < localStringBuffer.length())
    {
      if ((localStringBuffer.charAt(i1) == '\024') && (i1 < localStringBuffer.length() - 1))
      {
        int i3 = localStringBuffer.charAt(i1 + 1);
        if ((i3 >= 0) && (i3 < MessageUtils.a.length)) {
          localStringBuffer.setCharAt(i1 + 1, (char)MessageUtils.a[i3]);
        }
      }
      i1 += 1;
    }
    paramTextMsgTask.a(a(paramTextMsgTask.a().longValue(), 1001, paramTextMsgTask.a(), i2, localStringBuffer.toString().getBytes()));
    return true;
  }
  
  public static int b()
  {
    int i1 = Long.valueOf(System.currentTimeMillis()).intValue();
    int i2 = G;
    G = i2 + 1;
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
        new Handler(Looper.getMainLooper()).post(new faz(this, paramMsgHeader, paramList, paramBoolean));
      }
    }
  }
  
  private void b(ArrayList paramArrayList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      d();
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
    QLog.d("dataline", 2, "msgBody command not for android" + paramInt2 + " " + i1);
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
            QLog.d("dataline", 2, str);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((DataLineMsgRecord)localObject, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
    b(8, true, new Object[] { Integer.valueOf(paramInt), localTextMsgPush.a() });
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramToServiceMsg.a().msgId);
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
    this.jdField_a_of_type_JavaUtilTimerTask = new fax(this);
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
    String str2 = "0";
    String str1 = str2;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer != null)
    {
      str1 = str2;
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer.a() == true)
      {
        if (!DBNetworkUtil.a()) {
          break label136;
        }
        localObject1 = DBNetworkUtil.a();
      }
    }
    for (;;)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer.a();
      str1 = String.valueOf(i1);
      localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("ip", localObject1);
        ((JSONObject)localObject2).put("port", str1);
        ((JSONObject)localObject2).put("token", jdField_a_of_type_WifiphotoWifiPhotoDataCenter.jdField_a_of_type_JavaLangString);
        if (Environment.getExternalStorageState().equals("mounted_ro")) {
          ((JSONObject)localObject2).put("readonly", true);
        }
        for (;;)
        {
          a((JSONObject)localObject2);
          return;
          label136:
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
    DataLineMsgRecord localDataLineMsgRecord = a().a().b(paramLong);
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
      if (((File)localObject).length() > 4294967296L)
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
  
  public ToServiceMsg a(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte1, long paramLong3, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    paramString1 = a(paramString1, paramString1, paramInt2, false);
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(1);
    a(localMsgBody.msg_header);
    SubMsgType0x7.MsgBody.FTNNotify localFTNNotify = new SubMsgType0x7.MsgBody.FTNNotify();
    localFTNNotify.uint64_sessionid.set(paramLong2);
    localFTNNotify.str_file_name.set(paramString1);
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
    localFTNNotify.setHasFlag(true);
    localMsgBody.rpt_msg_subcmd_0x1_ftn_notify.add(localFTNNotify);
    localMsgBody.setHasFlag(true);
    return a(paramLong1, paramInt1, localMsgBody, paramLong2);
  }
  
  public ToServiceMsg a(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean, String paramString, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, byte[] paramArrayOfByte3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    paramString = a(paramString, paramString, paramInt4, paramBoolean);
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(2);
    a(localMsgBody.msg_header);
    SubMsgType0x7.MsgBody.NFCNotify localNFCNotify = new SubMsgType0x7.MsgBody.NFCNotify();
    localNFCNotify.uint64_sessionid.set(paramLong2);
    localNFCNotify.str_file_name.set(paramString);
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
    localNFCNotify.setHasFlag(true);
    localMsgBody.rpt_msg_subcmd_0x2_nfc_notify.add(localNFCNotify);
    localMsgBody.setHasFlag(true);
    return a(paramLong1, paramInt1, localMsgBody, paramLong2);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localDataLineMsgRecord, false);
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
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(AppConstants.P), 6000).time;
    if ((l1 != 0L) && (l1 != this.jdField_c_of_type_Long))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new UinPairReadInfo(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue(), l1, 0L, null));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localArrayList);
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
    if (paramLong == 0L) {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(paramInt, paramLong, 32, paramBoolean);
    }
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      return;
      localDataLineMsgRecord = a().a().b(paramLong);
    } while (localDataLineMsgRecord == null);
    localDataLineMsgRecord.fileMsgStatus = 2L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localDataLineMsgRecord.msgId);
    if (localDataLineMsgRecord.strMoloKey != null)
    {
      this.jdField_a_of_type_ComDatalineCoreMoloHandler.c(localDataLineMsgRecord.strMoloKey);
      return;
    }
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(localDataLineMsgRecord.groupId, paramLong, 32, paramBoolean);
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
      new Handler(localLooper).post(new fbj(this, paramToServiceMsg, paramFromServiceMsg, paramObject));
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      FMToastUtil.a("'" + paramString + "'" + BaseApplication.getContext().getResources().getString(2131558545));
      return;
    }
    new Handler(localLooper).post(new fbe(this, paramString));
  }
  
  public void a(ArrayList paramArrayList)
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
        localSession = a(((FileInfo)paramArrayList.get(i1)).c(), null, DataLineHandler.EFILETYPE.FILE_TYPE_FILE, 0L, 0, 0, 0, false);
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
      label120:
      if (i1 < i2)
      {
        localSession = a(((FileInfo)paramArrayList.get(i1)).c(), null, DataLineHandler.EFILETYPE.FILE_TYPE_FILE, 0L, i3, i2, i1, false);
        if (localSession != null) {
          localArrayList.add(localSession);
        }
        if (!DataLineMsgSet.isSingle(DataLineHandler.EFILETYPE.FILE_TYPE_FILE, i3)) {
          break label401;
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
    label257:
    label398:
    label401:
    for (;;)
    {
      i1 += 1;
      break label120;
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
        localSession = a(((FileInfo)paramArrayList.get(i1)).c(), null, DataLineHandler.EFILETYPE.FILE_TYPE_FILE, 0L, i2, 50, i1, false);
        if (localSession != null) {
          localArrayList.add(localSession);
        }
        if (!DataLineMsgSet.isSingle(DataLineHandler.EFILETYPE.FILE_TYPE_FILE, i2)) {
          break label398;
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
        break label257;
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
    //   0: new 1548	msf/msgcomm/msg_comm$MsgType0x210
    //   3: dup
    //   4: invokespecial 1549	msf/msgcomm/msg_comm$MsgType0x210:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_1
    //   12: getfield 1555	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   15: invokevirtual 1560	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   18: checkcast 1557	tencent/im/msg/im_msg_body$MsgBody
    //   21: getfield 1563	tencent/im/msg/im_msg_body$MsgBody:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   24: invokevirtual 483	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   27: invokevirtual 486	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   30: invokevirtual 1564	msf/msgcomm/msg_comm$MsgType0x210:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: checkcast 1548	msf/msgcomm/msg_comm$MsgType0x210
    //   36: astore 5
    //   38: aload 5
    //   40: astore 4
    //   42: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +12 -> 57
    //   48: ldc 26
    //   50: iconst_2
    //   51: ldc_w 1566
    //   54: invokestatic 430	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: new 1087	com/qq/taf/jce/JceInputStream
    //   60: dup
    //   61: aload 4
    //   63: getfield 1567	msf/msgcomm/msg_comm$MsgType0x210:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   66: invokevirtual 483	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   69: invokevirtual 486	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   72: invokespecial 1088	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   75: astore 5
    //   77: new 1569	IMMsgBodyPack/MsgType0x210
    //   80: dup
    //   81: invokespecial 1570	IMMsgBodyPack/MsgType0x210:<init>	()V
    //   84: astore 4
    //   86: aload 4
    //   88: aload 5
    //   90: invokevirtual 1571	IMMsgBodyPack/MsgType0x210:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   93: new 499	com/tencent/mobileqq/data/DataLineMsgRecord
    //   96: dup
    //   97: invokespecial 813	com/tencent/mobileqq/data/DataLineMsgRecord:<init>	()V
    //   100: astore 5
    //   102: aload 5
    //   104: aload_1
    //   105: getfield 1575	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   108: invokevirtual 1578	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   111: checkcast 1577	msf/msgcomm/msg_comm$MsgHead
    //   114: getfield 1581	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   117: invokevirtual 497	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   120: i2l
    //   121: putfield 833	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   124: aload 5
    //   126: aload_1
    //   127: getfield 1575	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   130: invokevirtual 1578	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   133: checkcast 1577	msf/msgcomm/msg_comm$MsgHead
    //   136: getfield 1584	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   139: invokevirtual 497	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   142: i2l
    //   143: putfield 830	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   146: aload 5
    //   148: aload_1
    //   149: getfield 1575	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   152: invokevirtual 1578	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   155: checkcast 1577	msf/msgcomm/msg_comm$MsgHead
    //   158: getfield 1587	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   161: invokevirtual 709	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   164: putfield 627	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   167: aload_0
    //   168: aload 5
    //   170: invokevirtual 1589	com/tencent/mobileqq/app/DataLineHandler:a	(Lcom/tencent/mobileqq/data/DataLineMsgRecord;)Z
    //   173: ifeq +83 -> 256
    //   176: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +54 -> 233
    //   182: ldc_w 477
    //   185: iconst_2
    //   186: new 184	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   193: ldc_w 1591
    //   196: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload 5
    //   201: getfield 833	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   204: invokevirtual 1344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   207: ldc_w 1593
    //   210: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 5
    //   215: getfield 830	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   218: invokevirtual 1344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   221: ldc_w 1595
    //   224: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 430	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: return
    //   234: astore 5
    //   236: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq +14 -> 253
    //   242: ldc 26
    //   244: iconst_2
    //   245: ldc_w 1597
    //   248: aload 5
    //   250: invokestatic 1600	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   253: goto -211 -> 42
    //   256: aload_0
    //   257: getfield 396	com/tencent/mobileqq/app/DataLineHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   260: bipush 9
    //   262: invokevirtual 1603	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   265: checkcast 1605	com/tencent/mobileqq/app/RegisterProxySvcPackHandler
    //   268: astore_1
    //   269: aload_1
    //   270: ifnull +38 -> 308
    //   273: aload_1
    //   274: invokevirtual 1606	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:a	()I
    //   277: istore_2
    //   278: aload_1
    //   279: invokevirtual 1608	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:b	()I
    //   282: istore_3
    //   283: iload_2
    //   284: iconst_1
    //   285: if_icmpne +8 -> 293
    //   288: iload_2
    //   289: iconst_2
    //   290: if_icmpeq +8 -> 298
    //   293: aload_1
    //   294: iconst_1
    //   295: invokevirtual 1610	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:a	(I)V
    //   298: iload_3
    //   299: iconst_1
    //   300: if_icmpeq +8 -> 308
    //   303: aload_1
    //   304: iconst_1
    //   305: invokevirtual 1611	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:b	(I)V
    //   308: aload 4
    //   310: getfield 1614	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   313: ldc2_w 1615
    //   316: lcmp
    //   317: ifne +76 -> 393
    //   320: aload_0
    //   321: aload 4
    //   323: getfield 1620	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   326: getfield 1622	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_src_app_id	J
    //   329: l2i
    //   330: aload 4
    //   332: getfield 1620	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   335: getfield 1624	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_src_inst_id	J
    //   338: l2i
    //   339: invokevirtual 1626	com/tencent/mobileqq/app/DataLineHandler:a	(II)Z
    //   342: ifne -109 -> 233
    //   345: aload_0
    //   346: aload 4
    //   348: getfield 1620	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   351: getfield 1628	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_dst_app_id	J
    //   354: l2i
    //   355: aload 4
    //   357: getfield 1620	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   360: getfield 1630	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_dst_inst_id	J
    //   363: l2i
    //   364: invokespecial 1632	com/tencent/mobileqq/app/DataLineHandler:b	(II)Z
    //   367: ifeq -134 -> 233
    //   370: aload_0
    //   371: aload 5
    //   373: getfield 830	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   376: l2i
    //   377: aload 5
    //   379: getfield 833	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   382: l2i
    //   383: i2s
    //   384: aload 4
    //   386: getfield 1620	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   389: invokespecial 1634	com/tencent/mobileqq/app/DataLineHandler:a	(ISLIMMsgBodyPack/MsgType0x210SubMsgType0x13;)V
    //   392: return
    //   393: aload 4
    //   395: getfield 1614	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   398: ldc2_w 1490
    //   401: lcmp
    //   402: ifne +167 -> 569
    //   405: aload_0
    //   406: aload 4
    //   408: getfield 1638	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   411: getfield 1643	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uSrcAppId	J
    //   414: l2i
    //   415: aload 4
    //   417: getfield 1638	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   420: getfield 1646	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uSrcInstId	J
    //   423: l2i
    //   424: invokevirtual 1626	com/tencent/mobileqq/app/DataLineHandler:a	(II)Z
    //   427: ifne -194 -> 233
    //   430: aload_0
    //   431: aload 4
    //   433: getfield 1638	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   436: getfield 1649	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstAppId	J
    //   439: l2i
    //   440: aload 4
    //   442: getfield 1638	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   445: getfield 1652	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstInstId	J
    //   448: l2i
    //   449: invokespecial 1632	com/tencent/mobileqq/app/DataLineHandler:b	(II)Z
    //   452: ifeq -219 -> 233
    //   455: aload_0
    //   456: getfield 122	com/tencent/mobileqq/app/DataLineHandler:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   459: aload 4
    //   461: getfield 1638	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   464: getfield 1655	IMMsgBodyPack/MsgType0x210SubMsgType0x2:lSessionId	J
    //   467: aload 4
    //   469: getfield 1638	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   472: getfield 1658	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uOriginfiletype	J
    //   475: aload 4
    //   477: getfield 1638	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   480: getfield 1661	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstUin	J
    //   483: new 777	java/lang/String
    //   486: dup
    //   487: aload 4
    //   489: getfield 1638	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   492: getfield 1664	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileName	[B
    //   495: invokespecial 799	java/lang/String:<init>	([B)V
    //   498: aload 4
    //   500: getfield 1638	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   503: getfield 1667	IMMsgBodyPack/MsgType0x210SubMsgType0x2:lFileLen	J
    //   506: aload 4
    //   508: getfield 1638	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   511: getfield 1670	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileMd5	[B
    //   514: new 777	java/lang/String
    //   517: dup
    //   518: aload 4
    //   520: getfield 1638	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   523: getfield 1673	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileIndex	[B
    //   526: invokespecial 799	java/lang/String:<init>	([B)V
    //   529: aload 4
    //   531: getfield 1638	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   534: getfield 1676	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strOriginfile_md5	[B
    //   537: iconst_0
    //   538: iconst_0
    //   539: iconst_0
    //   540: iconst_0
    //   541: aload 5
    //   543: getfield 830	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   546: l2i
    //   547: i2l
    //   548: aload 5
    //   550: getfield 833	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   553: l2i
    //   554: i2s
    //   555: i2l
    //   556: aload 5
    //   558: getfield 627	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   561: iconst_0
    //   562: invokevirtual 1680	com/tencent/litetransfersdk/LiteTransferWrapper:OnFileComing210_0x2	(JJJLjava/lang/String;J[BLjava/lang/String;[BIIIIJJJZ)V
    //   565: return
    //   566: astore_1
    //   567: aload_1
    //   568: athrow
    //   569: aload 4
    //   571: getfield 1614	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   574: ldc2_w 1681
    //   577: lcmp
    //   578: ifne +181 -> 759
    //   581: aload_0
    //   582: aload 4
    //   584: getfield 1686	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   587: getfield 1689	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uSrcAppId	J
    //   590: l2i
    //   591: aload 4
    //   593: getfield 1686	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   596: getfield 1690	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uSrcInstId	J
    //   599: l2i
    //   600: invokevirtual 1626	com/tencent/mobileqq/app/DataLineHandler:a	(II)Z
    //   603: ifne -370 -> 233
    //   606: aload_0
    //   607: aload 4
    //   609: getfield 1686	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   612: getfield 1691	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstAppId	J
    //   615: l2i
    //   616: aload 4
    //   618: getfield 1686	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   621: getfield 1692	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstInstId	J
    //   624: l2i
    //   625: invokespecial 1632	com/tencent/mobileqq/app/DataLineHandler:b	(II)Z
    //   628: ifeq -395 -> 233
    //   631: aload_0
    //   632: getfield 122	com/tencent/mobileqq/app/DataLineHandler:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   635: aload 4
    //   637: getfield 1686	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   640: getfield 1693	IMMsgBodyPack/MsgType0x210SubMsgType0xa:lSessionId	J
    //   643: aload 4
    //   645: getfield 1686	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   648: getfield 1694	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uOriginfiletype	J
    //   651: aload 4
    //   653: getfield 1686	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   656: getfield 1695	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstUin	J
    //   659: new 777	java/lang/String
    //   662: dup
    //   663: aload 4
    //   665: getfield 1686	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   668: getfield 1696	IMMsgBodyPack/MsgType0x210SubMsgType0xa:strFileName	[B
    //   671: invokespecial 799	java/lang/String:<init>	([B)V
    //   674: aload 4
    //   676: getfield 1686	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   679: getfield 1699	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uFileLen	J
    //   682: aload 4
    //   684: getfield 1686	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   687: getfield 1702	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vMd5	[B
    //   690: aload 4
    //   692: getfield 1686	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   695: getfield 1705	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uServerIp	J
    //   698: aload 4
    //   700: getfield 1686	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   703: getfield 1708	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uServerPort	J
    //   706: aload 4
    //   708: getfield 1686	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   711: getfield 1711	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vUrlNotify	[B
    //   714: aload 4
    //   716: getfield 1686	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   719: getfield 1714	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vTokenKey	[B
    //   722: aload 4
    //   724: getfield 1686	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   727: getfield 1715	IMMsgBodyPack/MsgType0x210SubMsgType0xa:strOriginfile_md5	[B
    //   730: iconst_0
    //   731: iconst_0
    //   732: iconst_0
    //   733: iconst_0
    //   734: aload 5
    //   736: getfield 830	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   739: l2i
    //   740: i2l
    //   741: aload 5
    //   743: getfield 833	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   746: l2i
    //   747: i2s
    //   748: i2l
    //   749: aload 5
    //   751: getfield 627	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   754: iconst_0
    //   755: invokevirtual 1719	com/tencent/litetransfersdk/LiteTransferWrapper:onFileComing210_0xa	(JJJLjava/lang/String;J[BJJ[B[B[BIIIIJJJZ)V
    //   758: return
    //   759: aload 4
    //   761: getfield 1614	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   764: ldc2_w 1720
    //   767: lcmp
    //   768: ifne -535 -> 233
    //   771: aload_0
    //   772: aload 4
    //   774: getfield 1725	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   777: getfield 1728	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_src_app_id	J
    //   780: l2i
    //   781: aload 4
    //   783: getfield 1725	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   786: getfield 1729	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_src_inst_id	J
    //   789: l2i
    //   790: invokevirtual 1626	com/tencent/mobileqq/app/DataLineHandler:a	(II)Z
    //   793: ifne -560 -> 233
    //   796: aload_0
    //   797: aload 4
    //   799: getfield 1725	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   802: getfield 1730	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_dst_app_id	J
    //   805: l2i
    //   806: aload 4
    //   808: getfield 1725	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   811: getfield 1731	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_dst_inst_id	J
    //   814: l2i
    //   815: invokespecial 1632	com/tencent/mobileqq/app/DataLineHandler:b	(II)Z
    //   818: ifeq -585 -> 233
    //   821: aload_0
    //   822: getfield 122	com/tencent/mobileqq/app/DataLineHandler:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   825: aload 4
    //   827: getfield 1725	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   830: getfield 1732	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint64_sessionid	J
    //   833: aload 4
    //   835: getfield 1725	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   838: getfield 1734	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_operate	J
    //   841: iconst_0
    //   842: aload 5
    //   844: getfield 830	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   847: l2i
    //   848: aload 5
    //   850: getfield 833	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   853: l2i
    //   854: i2s
    //   855: invokevirtual 1738	com/tencent/litetransfersdk/LiteTransferWrapper:onFileOperate0x210	(JJIIS)V
    //   858: return
    //   859: astore_1
    //   860: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	861	0	this	DataLineHandler
    //   0	861	1	paramMsg	msg_comm.Msg
    //   277	14	2	i1	int
    //   282	19	3	i2	int
    //   7	827	4	localObject1	Object
    //   36	178	5	localObject2	Object
    //   234	615	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	38	234	java/lang/Exception
    //   86	233	566	finally
    //   256	269	566	finally
    //   273	283	566	finally
    //   293	298	566	finally
    //   303	308	566	finally
    //   308	392	566	finally
    //   393	565	566	finally
    //   569	758	566	finally
    //   759	858	566	finally
    //   86	233	859	java/lang/Exception
    //   256	269	859	java/lang/Exception
    //   273	283	859	java/lang/Exception
    //   293	298	859	java/lang/Exception
    //   303	308	859	java/lang/Exception
    //   308	392	859	java/lang/Exception
    //   393	565	859	java/lang/Exception
    //   569	758	859	java/lang/Exception
    //   759	858	859	java/lang/Exception
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
          QLog.d("dataline", 2, "<<<<<<<<<<recv repeat 0x211 msg begin seq:" + ((DataLineMsgRecord)localObject).shmsgseq + "time:" + ((DataLineMsgRecord)localObject).time + ">>>>>>>>>>");
        }
        if (paramMsgBody.uint32_sub_cmd.has()) {}
        switch (paramMsgBody.uint32_sub_cmd.get())
        {
        case 6: 
        case 7: 
        case 8: 
          label212:
          if (!QLog.isColorLevel()) {
            break label2115;
          }
          QLog.d("dataline", 2, "<<<<<<<<<<recv repeat 0x211 msg end >>>>>>>>>>");
          return;
        }
      }
      catch (Exception paramMsg)
      {
        paramMsg = paramMsg;
        if (!QLog.isColorLevel()) {
          break label2115;
        }
        QLog.d("dataline", 2, "<<<<<<<<<<handleDataLinePushMsg_PB_0x211 Exception:" + paramMsg.toString() + ">>>>>>>>>>");
        return;
      }
      finally {}
      if ((!paramMsgBody.msg_subcmd_0x4_generic.has()) || (!paramMsgBody.msg_subcmd_0x4_generic.uint32_type.has())) {
        break label2115;
      }
      switch (paramMsgBody.msg_subcmd_0x4_generic.uint32_type.get())
      {
      case 1: 
        if (QLog.isColorLevel()) {
          QLog.d("dataline", 2, "0x211 0x7 0x4 0x1文本消息");
        }
        break;
      case 3: 
        if (QLog.isColorLevel()) {
          QLog.d("dataline", 2, "0x211 0x7 0x4 0x3 WifiPhoto");
        }
        break;
      case 5: 
        if (QLog.isColorLevel())
        {
          QLog.d("dataline", 2, "0x211 0x7 0x4 0x5 WifiPhoto");
          continue;
          if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
            break label2115;
          }
          paramMsg = paramMsgBody.rpt_msg_subcmd_0x1_ftn_notify.get().iterator();
          while (paramMsg.hasNext())
          {
            paramMsgBody = (SubMsgType0x7.MsgBody.FTNNotify)paramMsg.next();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("0x211 0x7 0x1 文件原图中转通知 groupid:");
              if (!paramMsgBody.uint32_group_id.has()) {
                break label2119;
              }
              i1 = paramMsgBody.uint32_group_id.get();
              label484:
              localObject = ((StringBuilder)localObject).append(i1).append(" groupSize:");
              if (!paramMsgBody.uint32_group_size.has()) {
                break label2124;
              }
              i1 = paramMsgBody.uint32_group_size.get();
              label516:
              localObject = ((StringBuilder)localObject).append(i1).append("groupIndex:");
              if (!paramMsgBody.uint32_group_curindex.has()) {
                break label2129;
              }
              i1 = paramMsgBody.uint32_group_curindex.get();
              label548:
              QLog.d("dataline", 2, i1);
            }
          }
          if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
            break label2115;
          }
          paramMsg = paramMsgBody.rpt_msg_subcmd_0x2_nfc_notify.get().iterator();
          while (paramMsg.hasNext())
          {
            paramMsgBody = (SubMsgType0x7.MsgBody.NFCNotify)paramMsg.next();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("0x211 0x7 0x2 文件原图近场通知 groupid:");
              if (!paramMsgBody.uint32_group_id.has()) {
                break label2134;
              }
              i1 = paramMsgBody.uint32_group_id.get();
              label651:
              localObject = ((StringBuilder)localObject).append(i1).append(" groupSize:");
              if (!paramMsgBody.uint32_group_size.has()) {
                break label2139;
              }
              i1 = paramMsgBody.uint32_group_size.get();
              label683:
              localObject = ((StringBuilder)localObject).append(i1).append("groupIndex:");
              if (!paramMsgBody.uint32_group_curindex.has()) {
                break label2144;
              }
              i1 = paramMsgBody.uint32_group_curindex.get();
              label715:
              QLog.d("dataline", 2, i1);
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
                break label2149;
              }
              i1 = paramMsgBody.uint32_group_id.get();
              label805:
              QLog.d("dataline", 2, i1);
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
                break label2154;
              }
              i1 = paramMsgBody.uint32_group_id.get();
              label895:
              localObject = ((StringBuilder)localObject).append(i1).append(" groupSize:");
              if (!paramMsgBody.uint32_group_size.has()) {
                break label2159;
              }
              i1 = paramMsgBody.uint32_group_size.get();
              label927:
              localObject = ((StringBuilder)localObject).append(i1).append("groupIndex:");
              if (!paramMsgBody.uint32_group_curindex.has()) {
                break label2164;
              }
              i1 = paramMsgBody.uint32_group_curindex.get();
              label959:
              QLog.d("dataline", 2, i1);
            }
          }
          if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
            break label2115;
          }
          paramMsg = paramMsgBody.rpt_msg_subcmd_0x9_ftn_thumb_notify.get().iterator();
          while (paramMsg.hasNext())
          {
            paramMsgBody = (SubMsgType0x7.MsgBody.FTNNotify)paramMsg.next();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("0x211 0x7 0x9 文件缩略图中转通知 groupid:");
              if (!paramMsgBody.uint32_group_id.has()) {
                break label2169;
              }
              i1 = paramMsgBody.uint32_group_id.get();
              label1062:
              localObject = ((StringBuilder)localObject).append(i1).append(" groupSize:");
              if (!paramMsgBody.uint32_group_size.has()) {
                break label2174;
              }
              i1 = paramMsgBody.uint32_group_size.get();
              label1094:
              localObject = ((StringBuilder)localObject).append(i1).append("groupIndex:");
              if (!paramMsgBody.uint32_group_curindex.has()) {
                break label2179;
              }
              i1 = paramMsgBody.uint32_group_curindex.get();
              label1126:
              QLog.d("dataline", 2, i1);
            }
          }
          if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
            break label2115;
          }
          paramMsg = paramMsgBody.rpt_msg_subcmd_0xa_nfc_thumb_notify.get().iterator();
          label1171:
          do
          {
            if (!paramMsg.hasNext()) {
              break;
            }
            paramMsgBody = (SubMsgType0x7.MsgBody.NFCNotify)paramMsg.next();
          } while (!QLog.isColorLevel());
          localObject = new StringBuilder().append("0x211 0x7 0xa 文件缩略图近场通知 groupid:");
          if (!paramMsgBody.uint32_group_id.has()) {
            break label2184;
          }
          i1 = paramMsgBody.uint32_group_id.get();
          label1229:
          localObject = ((StringBuilder)localObject).append(i1).append(" groupSize:");
          if (!paramMsgBody.uint32_group_size.has()) {
            break label2189;
          }
          i1 = paramMsgBody.uint32_group_size.get();
          label1261:
          localObject = ((StringBuilder)localObject).append(i1).append("groupIndex:");
          if (!paramMsgBody.uint32_group_curindex.has()) {
            break label2194;
          }
        }
        break;
      }
    }
    label2179:
    label2184:
    label2189:
    label2194:
    for (int i1 = paramMsgBody.uint32_group_curindex.get();; i1 = 0)
    {
      QLog.d("dataline", 2, i1);
      break label1171;
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
          QLog.d("dataline", 2, "0x211 0x7 0x1 文件原图中转通知");
        }
        if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
          throw new Exception("msg_header do not has uint64_dst_uin");
        }
      case 4: 
        if (QLog.isColorLevel()) {
          QLog.d("dataline", 2, "0x211 0x7 0x4 通用协议");
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
          QLog.d("dataline", 2, "0x211 0x7 0x2 文件原图近场通知");
        }
        if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
          throw new Exception("msg_header do not has uint64_dst_uin");
        }
        b(((DataLineMsgRecord)localObject).time, ((DataLineMsgRecord)localObject).shmsgseq, ((DataLineMsgRecord)localObject).msgId, paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x2_nfc_notify.get(), false);
        return;
      case 3: 
        if (QLog.isColorLevel()) {
          QLog.d("dataline", 2, "0x211 0x7 0x3 文件控制命令");
        }
        a(((DataLineMsgRecord)localObject).time, ((DataLineMsgRecord)localObject).shmsgseq, ((DataLineMsgRecord)localObject).msgId, paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x3_filecontrol.get());
        return;
      case 5: 
        if (QLog.isColorLevel()) {
          QLog.d("dataline", 2, "0x211 0x7 0x5 应用宝通知");
        }
        a(((DataLineMsgRecord)localObject).time, ((DataLineMsgRecord)localObject).shmsgseq, ((DataLineMsgRecord)localObject).msgId, paramMsgBody.rpt_msg_subcmd_0x5_molo_notify.get());
        return;
      case 11: 
        a(((DataLineMsgRecord)localObject).time, ((DataLineMsgRecord)localObject).shmsgseq, paramMsgBody.rpt_msg_subcmd_0xb_mpfile_notify.get());
        return;
      case 9: 
        if (QLog.isColorLevel()) {
          QLog.d("dataline", 2, "0x211 0x7 0x9 文件缩略图中转通知");
        }
        if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
          throw new Exception("msg_header do not has uint64_dst_uin");
        }
        a(((DataLineMsgRecord)localObject).time, ((DataLineMsgRecord)localObject).shmsgseq, ((DataLineMsgRecord)localObject).msgId, paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x9_ftn_thumb_notify.get(), true);
        return;
      case 10: 
        if (QLog.isColorLevel()) {
          QLog.d("dataline", 2, "0x211 0x7 0xa 文件缩略图近场通知");
        }
        if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
          throw new Exception("msg_header do not has uint64_dst_uin");
        }
        b(((DataLineMsgRecord)localObject).time, ((DataLineMsgRecord)localObject).shmsgseq, ((DataLineMsgRecord)localObject).msgId, paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0xa_nfc_thumb_notify.get(), true);
        return;
        break label212;
        label2115:
        return;
        break label212;
        label2119:
        i1 = 0;
        break label484;
        label2124:
        i1 = 0;
        break label516;
        label2129:
        i1 = 0;
        break label548;
        label2134:
        i1 = 0;
        break label651;
        label2139:
        i1 = 0;
        break label683;
        label2144:
        i1 = 0;
        break label715;
        label2149:
        i1 = 0;
        break label805;
        label2154:
        i1 = 0;
        break label895;
        label2159:
        i1 = 0;
        break label927;
        label2164:
        i1 = 0;
        break label959;
        label2169:
        i1 = 0;
        break label1062;
        label2174:
        i1 = 0;
        break label1094;
        i1 = 0;
        break label1126;
        i1 = 0;
        break label1229;
        i1 = 0;
        break label1261;
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
      QLog.d("dataline", 2, "msgBody command from android" + paramInt2 + " " + i1);
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localDataLineMsgRecord.msgId);
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
            MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
            this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localMessageRecord.shmsgseq));
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
        if ((localList == null) || (localList.size() == 1)) {
          this.jdField_a_of_type_ComDatalineCoreMoloHandler.d(localDataLineMsgRecord.strMoloKey);
        }
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDataLineMsgSet) >= 0;
  }
  
  public boolean a(String paramString)
  {
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
      DataLineMsgRecord localDataLineMsgRecord = a().a().b(localLong.longValue());
      if (localDataLineMsgRecord != null)
      {
        localDataLineMsgRecord.fileMsgStatus = 0L;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localDataLineMsgRecord.msgId);
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
        break label180;
      }
    }
    label180:
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
      FMToastUtil.a(2131558548);
      return;
    }
    new Handler(localLooper).post(new fbh(this));
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
      this.jdField_b_of_type_JavaUtilTimer.schedule(new fbc(this), 20000L);
    }
    a(paramInt, paramBoolean, paramObject);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "received a cmd=" + paramFromServiceMsg.getServiceCmd());
    }
    if (paramFromServiceMsg.getServiceCmd().equals("TransService.FileUploadReq")) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("TransService.FileDownloadReq"))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("TransService.FileDeleteReq"))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramFromServiceMsg.getServiceCmd().equals("MessageSvc.PbSendMsg"));
    f(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void b(String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      FMToastUtil.a("'" + paramString + "'" + BaseApplication.getContext().getResources().getString(2131558547));
      return;
    }
    new Handler(localLooper).post(new fbf(this, paramString));
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
    return this.jdField_a_of_type_ComDatalineCoreMoloHandler.b(paramString);
  }
  
  public int c()
  {
    return ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).b();
  }
  
  public void c()
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
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.endLiteTransfer();
    g();
    this.jdField_a_of_type_ComDatalineCoreMoloHandler.a();
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
        QLog.d("DataLineHandler", 2, "<PbSendMsg><R><---handleUploadResp, retry = " + i1);
      }
      if (i1 < 3)
      {
        paramToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", i1 + 1);
        c(paramToServiceMsg);
        return;
      }
    }
    new Handler(Looper.getMainLooper()).post(new fbk(this, paramToServiceMsg, paramFromServiceMsg, paramObject));
  }
  
  public void c(String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      FMToastUtil.a("'" + paramString + "'" + BaseApplication.getContext().getResources().getString(2131558519));
      return;
    }
    new Handler(localLooper).post(new fbg(this, paramString));
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
      this.jdField_a_of_type_JavaUtilSet.add("TransService.FileUploadReq");
      this.jdField_a_of_type_JavaUtilSet.add("TransService.FileDownloadReq");
      this.jdField_a_of_type_JavaUtilSet.add("TransService.FileDeleteReq");
      this.jdField_a_of_type_JavaUtilSet.add("MessageSvc.PbSendMsg");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void d()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      FMToastUtil.a(2131558549);
      return;
    }
    new Handler(localLooper).post(new fbi(this));
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelAll(paramInt);
    this.jdField_a_of_type_ComDatalineCoreMoloHandler.a();
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null))
    {
      int i1 = paramToServiceMsg.extraData.getInt("DATALINE_TRYINDEX");
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "<PbSendMsg><R><---handleDownloadResp, retry = " + i1);
      }
      if (i1 < 3)
      {
        paramToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", i1 + 1);
        c(paramToServiceMsg);
        return;
      }
    }
    new Handler(Looper.getMainLooper()).post(new fas(this, paramToServiceMsg, paramFromServiceMsg, paramObject));
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
    new Handler(Looper.getMainLooper()).post(new fat(this, paramToServiceMsg, paramFromServiceMsg, paramObject));
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer == null) || (!this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer.a())) {
      j();
    }
    if (!jdField_a_of_type_WifiphotoWifiPhotoDataCenter.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr.a())
    {
      jdField_a_of_type_WifiphotoWifiPhotoDataCenter.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr.b();
      new fav(this).start();
      StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "Open_wp");
      if (QLog.isColorLevel()) {
        QLog.d("wifiphoto", 2, "StatisticAssist click Open_wp");
      }
      if (!(SplashActivity.a instanceof LiteWifiphotoActivity))
      {
        localObject = new Intent(SplashActivity.a, LiteWifiphotoActivity.class);
        ((Intent)localObject).putExtra("isFromStatusbar", false);
        SplashActivity.a.startActivity((Intent)localObject);
        SplashActivity.a.overridePendingTransition(2130968598, 0);
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if (localObject != null)
      {
        Message localMessage = ((Handler)localObject).obtainMessage(1134021);
        localMessage.arg1 = 1;
        ((Handler)localObject).sendMessage(localMessage);
      }
    }
  }
  
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
    new Handler(Looper.getMainLooper()).post(new fau(this, paramToServiceMsg, paramFromServiceMsg, paramObject));
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
  
  public void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
          i(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.handleFTNNotifyReply(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.handleNFCNotifyReply(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.handleFileOperateReply(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
        else
        {
          i1 = 0;
        }
      }
    }
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
      Log.i("wifiphoto", "WiFi status is disabled");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer != null) {
      k();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer == null) {
      this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer = new HttpServer();
    }
    this.jdField_a_of_type_ComTencentMobileqqServiceHttpServer.a("", new fbb(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler
 * JD-Core Version:    0.7.0.1
 */