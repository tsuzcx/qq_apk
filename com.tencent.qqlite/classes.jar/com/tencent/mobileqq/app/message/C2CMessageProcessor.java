package com.tencent.mobileqq.app.message;

import MessageSvcPack.SvcResponseMsgReadedReport;
import MessageSvcPack.UinPairReadInfo;
import OnlinePushPack.DelMsgInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import cyj;
import cyk;
import cyl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbGetOneDayRoamMsgResp;
import msf.msgsvc.msg_svc.PbGetRoamMsgResp;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import tencent.im.msg.im_msg_body.MsgBody;

public class C2CMessageProcessor
  extends BaseMessageProcessor
{
  private static final int b = 33;
  public static final String b = "Q.msg.C2CMessageProcessor";
  private Set a;
  
  public C2CMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
  }
  
  private Pair a(String paramString, msg_comm.UinPairMsg paramUinPairMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList1 = new ArrayList();
    new ArrayList();
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject1 = paramUinPairMsg.msg.get();
    if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
      return new Pair(paramString, Integer.valueOf(0));
    }
    ArrayList localArrayList2 = new ArrayList();
    a((List)localObject1, localArrayList2);
    StringBuilder localStringBuilder = new StringBuilder();
    DecodeProtoPkgContext localDecodeProtoPkgContext = new DecodeProtoPkgContext(l1, Long.parseLong(paramString), true, paramBoolean2, paramBoolean3, false);
    localDecodeProtoPkgContext.jdField_e_of_type_Boolean = true;
    int i = 0;
    localObject1 = paramString;
    l1 = -1L;
    long l2 = -1L;
    int k = 0;
    if (k < localArrayList2.size()) {}
    try
    {
      localObject2 = (msg_comm.Msg)localArrayList2.get(k);
      localObject3 = (msg_comm.MsgHead)((msg_comm.Msg)localObject2).msg_head.get();
      im_msg_body.MsgBody localMsgBody = (im_msg_body.MsgBody)((msg_comm.Msg)localObject2).msg_body.get();
      if (!((msg_comm.Msg)localObject2).msg_head.has())
      {
        if (!QLog.isColorLevel()) {
          break label1259;
        }
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage: msgList[" + k + "] : msg doesn't has msgHead.");
        break label1259;
      }
      l3 = ((msg_comm.MsgHead)localObject3).to_uin.get();
      l7 = ((msg_comm.MsgHead)localObject3).from_uin.get();
      l4 = ((msg_comm.MsgHead)localObject3).from_uin.get();
      l5 = ((msg_comm.MsgHead)localObject3).msg_time.get();
      if (l5 <= paramLong) {
        break label1250;
      }
      paramBoolean3 = false;
      bool = false;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        long l7;
        long l4;
        long l5;
        long l8;
        int j;
        continue;
        paramBoolean3 = true;
        boolean bool = true;
      }
      l3 = l2;
      l2 = l1;
      l1 = l3;
    }
    l8 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l4, l3, paramUinPairMsg.peer_uin.get());
    localObject1 = String.valueOf(l8);
    long l3 = l2;
    l4 = l1;
    j = i;
    for (;;)
    {
      try
      {
        l6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l8), 0);
        if ((l5 <= l6) && (bool))
        {
          l3 = l2;
          l4 = l1;
          j = i;
          if (!QLog.isColorLevel()) {
            break label1292;
          }
          l3 = l2;
          l4 = l1;
          j = i;
          localStringBuilder.setLength(0);
          l3 = l2;
          l4 = l1;
          j = i;
          localStringBuilder.append("<---decodeC2CMessagePackage : msgList[").append(k).append("] : filter msg by del time delTime =").append(l6).append(", msgTime = ").append(l5);
          l3 = l2;
          l4 = l1;
          j = i;
          QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
          break label1292;
        }
        l3 = l2;
        l4 = l1;
        j = i;
        localDecodeProtoPkgContext.jdField_a_of_type_Boolean = bool;
        l3 = l2;
        l4 = l1;
        j = i;
        localDecodeProtoPkgContext.jdField_e_of_type_Long = l8;
        l3 = l2;
        l4 = l1;
        j = i;
        localDecodeProtoPkgContext.h = paramBoolean3;
        l3 = l2;
        l4 = l1;
        j = i;
        localObject2 = a((msg_comm.Msg)localObject2, localDecodeProtoPkgContext).iterator();
        l3 = l2;
        l4 = l1;
        j = i;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        l3 = l2;
        l4 = l1;
        j = i;
        localObject3 = (MessageRecord)((Iterator)localObject2).next();
        l3 = l2;
        l4 = l1;
        j = i;
        l5 = ((MessageRecord)localObject3).vipBubbleID;
        if (l5 == -1L) {
          break label801;
        }
        l3 = l2;
        l4 = l1;
        j = i;
        if (!MsgUtils.a(((MessageRecord)localObject3).issend)) {
          break label790;
        }
        l6 = l1;
        l3 = l5;
        l4 = l6;
        j = i;
        int m = ((MessageRecord)localObject3).istroop;
        l2 = l5;
        l1 = l6;
        i = m;
        l3 = l5;
        l4 = l6;
        j = m;
        if (a((MessageRecord)localObject3, true)) {
          continue;
        }
        l3 = l5;
        l4 = l6;
        j = m;
        localArrayList1.add(localObject3);
        l2 = l5;
        l1 = l6;
        i = m;
        continue;
        if (!QLog.isColorLevel()) {
          break label775;
        }
      }
      catch (Exception localException1)
      {
        i = j;
        l1 = l4;
        l2 = l3;
      }
      QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeC2CMessage error,", localException1);
      label775:
      l3 = l1;
      l1 = l2;
      l2 = l3;
      break label1271;
      label790:
      long l6 = l5;
      l5 = l2;
      continue;
      label801:
      l3 = l2;
      l4 = l1;
      j = i;
      if (((MessageRecord)localObject3).msgtype == -2002)
      {
        l3 = l2;
        l4 = l1;
        j = i;
        if (MsgUtils.a(((MessageRecord)localObject3).issend))
        {
          if (l2 != -1L)
          {
            l3 = l2;
            l4 = l1;
            j = i;
            ((MessageRecord)localObject3).vipBubbleID = l2;
            l5 = l2;
            l6 = l1;
          }
          else
          {
            l3 = l2;
            l4 = l1;
            j = i;
            ((MessageRecord)localObject3).vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l8), String.valueOf(l7));
            l5 = l2;
            l6 = l1;
          }
        }
        else if (l1 != -1L)
        {
          l3 = l2;
          l4 = l1;
          j = i;
          ((MessageRecord)localObject3).vipBubbleID = l1;
          l5 = l2;
          l6 = l1;
        }
        else
        {
          l3 = l2;
          l4 = l1;
          j = i;
          ((MessageRecord)localObject3).vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l8), String.valueOf(l7));
          l5 = l2;
          l6 = l1;
        }
      }
      else
      {
        l3 = l2;
        l4 = l1;
        j = i;
        ((MessageRecord)localObject3).vipBubbleID = 0L;
        l5 = l2;
        l6 = l1;
      }
    }
    l3 = l1;
    l1 = l2;
    l2 = l3;
    break label1271;
    if (localObject1 != null)
    {
      paramUinPairMsg = (msg_comm.UinPairMsg)localObject1;
      if (!((String)localObject1).equals("0")) {}
    }
    else
    {
      paramUinPairMsg = paramString;
    }
    if (localArrayList1.size() > 0)
    {
      if (!paramBoolean2) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localArrayList1);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramUinPairMsg), 0, localArrayList1, paramBoolean1);
      paramBoolean3 = MessageHandlerUtils.a(localArrayList1);
      bool = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList1);
      j = MsgProxyUtils.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((!paramBoolean3) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause)) {
        break label1239;
      }
    }
    label1239:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramString.a(localArrayList1, str, paramBoolean1);
      a(localArrayList1);
      a("handleGetBuddyMessageResp", true, j, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramBoolean3, bool), paramBoolean2);
      return new Pair(paramUinPairMsg, Integer.valueOf(i));
    }
    for (;;)
    {
      label1250:
      label1259:
      label1271:
      k += 1;
      l3 = l2;
      l2 = l1;
      l1 = l3;
      break;
      label1292:
      l3 = l1;
      l1 = l2;
      l2 = l3;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, msg_comm.MsgHead paramMsgHead)
  {
    String str = paramQQAppInterface.a();
    Long localLong = Long.valueOf(Long.parseLong(str));
    Object localObject1 = String.valueOf(paramLong1);
    Object localObject2 = "" + paramMsgHead.auth_uin.get();
    paramMsgHead = paramMsgHead.auth_nick.get();
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(paramMsgHead)) && (((String)localObject2).equals(paramString1))) {}
    for (;;)
    {
      if ((str != null) && (str.equals(paramString1))) {
        return;
      }
      if (TextUtils.isEmpty(paramMsgHead)) {
        paramMsgHead = MessageHandlerUtils.a(paramQQAppInterface, paramString1, (String)localObject1);
      }
      for (;;)
      {
        if ((paramInt == -126) || (paramInt == 2))
        {
          localObject1 = paramMsgHead + " 已加入该群";
          paramString2 = (MessageForGrayTips)MessageRecordFactory.a(-1012);
          paramString2.init(localLong.longValue(), paramLong1, paramLong1, (String)localObject1, paramLong2, -1012, 1, paramLong3);
          paramString2.switch2HightlightMsg();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("key_action", 5);
          ((Bundle)localObject1).putString("troop_mem_uin", paramString1);
          ((Bundle)localObject1).putBoolean("need_update_nick", false);
          paramString2.addHightlightItem(0, paramMsgHead.length(), (Bundle)localObject1);
          paramString2.isread = true;
          if (a(paramString2, false)) {
            break;
          }
          paramQQAppInterface.a().a(paramString2, String.valueOf(localLong));
          return;
        }
        if ((paramInt != -125) && (paramInt != 3)) {
          break;
        }
        localObject1 = MessageHandlerUtils.a(paramQQAppInterface, paramString2, (String)localObject1);
        if ((str != null) && (str.equals(paramString2)))
        {
          paramInt = 1;
          localObject1 = "你";
        }
        for (;;)
        {
          if (paramInt != 0) {}
          for (str = (String)localObject1 + "邀请 ";; str = (String)localObject1 + " 邀请 ")
          {
            Object localObject3 = str + paramMsgHead + " 加入了群";
            localObject2 = (MessageForGrayTips)MessageRecordFactory.a(-1012);
            ((MessageForGrayTips)localObject2).init(localLong.longValue(), paramLong1, paramLong1, (String)localObject3, paramLong2, -1012, 1, paramLong3);
            ((MessageForGrayTips)localObject2).switch2HightlightMsg();
            if (paramInt == 0)
            {
              localObject3 = new Bundle();
              ((Bundle)localObject3).putInt("key_action", 5);
              ((Bundle)localObject3).putString("troop_mem_uin", paramString2);
              ((Bundle)localObject3).putBoolean("need_update_nick", false);
              ((MessageForGrayTips)localObject2).addHightlightItem(0, ((String)localObject1).length(), (Bundle)localObject3);
            }
            paramString2 = new Bundle();
            paramString2.putInt("key_action", 5);
            paramString2.putString("troop_mem_uin", paramString1);
            paramString2.putBoolean("need_update_nick", false);
            ((MessageForGrayTips)localObject2).addHightlightItem(str.length(), str.length() + paramMsgHead.length(), paramString2);
            ((MessageForGrayTips)localObject2).isread = true;
            if (a((MessageRecord)localObject2, false)) {
              break;
            }
            paramQQAppInterface.a().a((MessageRecord)localObject2, String.valueOf(localLong));
            return;
          }
          paramInt = 0;
        }
      }
      paramMsgHead = "";
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l1);
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label93;
      }
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      paramToServiceMsg.getClass();
      if (!paramFromServiceMsg.a(paramToServiceMsg, "msf")) {
        break label93;
      }
    }
    label93:
    while ((480000L != l2) && (!paramToServiceMsg.a())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "<ReadReport><E>_C2C_reqSeq:" + l1);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l1);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponseMsgReadedReport paramSvcResponseMsgReadedReport)
  {
    paramToServiceMsg.getServiceCmd();
    long l = paramToServiceMsg.extraData.getLong("msgSeq");
    paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l) == null) {}
    while (paramSvcResponseMsgReadedReport == null) {
      return;
    }
    int i = paramSvcResponseMsgReadedReport.cReplyCode;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "<ReadReport><R>_C2C_reqSeq:" + l + " replyCode:" + i);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l);
  }
  
  /* Error */
  private void a(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 404	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 463
    //   7: iconst_1
    //   8: invokevirtual 467	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   11: istore 9
    //   13: aload_1
    //   14: getfield 404	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   17: ldc_w 469
    //   20: iconst_1
    //   21: invokevirtual 467	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   24: istore 11
    //   26: aload_1
    //   27: getfield 404	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   30: ldc_w 471
    //   33: iconst_0
    //   34: invokevirtual 467	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   37: istore 10
    //   39: aload_2
    //   40: invokevirtual 474	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   43: ifnonnull +246 -> 289
    //   46: aload_0
    //   47: getfield 33	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   50: invokevirtual 477	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   53: invokestatic 480	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   56: astore 22
    //   58: aload 22
    //   60: invokevirtual 345	java/lang/Long:longValue	()J
    //   63: pop2
    //   64: new 482	msf/msgsvc/msg_svc$PbGetMsgResp
    //   67: dup
    //   68: invokespecial 483	msf/msgsvc/msg_svc$PbGetMsgResp:<init>	()V
    //   71: astore 22
    //   73: aload 22
    //   75: aload_3
    //   76: checkcast 485	[B
    //   79: checkcast 485	[B
    //   82: invokevirtual 489	msf/msgsvc/msg_svc$PbGetMsgResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   85: checkcast 482	msf/msgsvc/msg_svc$PbGetMsgResp
    //   88: astore 22
    //   90: aload 22
    //   92: ifnonnull +35 -> 127
    //   95: invokestatic 495	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   98: invokestatic 500	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   101: aload_0
    //   102: getfield 33	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   105: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   108: ldc_w 502
    //   111: iconst_0
    //   112: lconst_0
    //   113: lconst_0
    //   114: new 504	java/util/HashMap
    //   117: dup
    //   118: invokespecial 505	java/util/HashMap:<init>	()V
    //   121: ldc_w 313
    //   124: invokevirtual 508	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   127: new 76	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   134: astore 23
    //   136: aload 22
    //   138: ifnull +25 -> 163
    //   141: aload 22
    //   143: getfield 511	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   146: invokevirtual 512	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   149: ifeq +14 -> 163
    //   152: aload 22
    //   154: getfield 511	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: invokevirtual 162	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   160: ifeq +207 -> 367
    //   163: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +113 -> 279
    //   169: aload 23
    //   171: iconst_0
    //   172: invokevirtual 187	java/lang/StringBuilder:setLength	(I)V
    //   175: aload 23
    //   177: ldc_w 514
    //   180: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: astore 24
    //   185: aload_1
    //   186: ifnonnull +140 -> 326
    //   189: ldc_w 516
    //   192: astore_3
    //   193: aload 24
    //   195: aload_3
    //   196: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   199: ldc_w 521
    //   202: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: astore 24
    //   207: aload 22
    //   209: ifnonnull +128 -> 337
    //   212: ldc_w 516
    //   215: astore_3
    //   216: aload 24
    //   218: aload_3
    //   219: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   222: ldc_w 523
    //   225: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: astore 24
    //   230: aload 22
    //   232: ifnonnull +120 -> 352
    //   235: ldc_w 516
    //   238: astore_3
    //   239: aload 24
    //   241: aload_3
    //   242: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   245: ldc_w 525
    //   248: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: iload 9
    //   253: invokevirtual 528	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   256: ldc_w 530
    //   259: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: iload 11
    //   264: invokevirtual 528	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: ldc 10
    //   270: iconst_2
    //   271: aload 23
    //   273: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 532	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: aload_0
    //   280: getfield 299	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   283: aload_1
    //   284: aload_2
    //   285: invokevirtual 534	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   288: return
    //   289: aload_2
    //   290: invokevirtual 474	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   293: invokestatic 480	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   296: astore 22
    //   298: goto -240 -> 58
    //   301: astore 22
    //   303: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   306: ifeq +14 -> 320
    //   309: ldc 10
    //   311: iconst_2
    //   312: ldc_w 536
    //   315: aload 22
    //   317: invokestatic 538	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   320: aconst_null
    //   321: astore 22
    //   323: goto -233 -> 90
    //   326: aload_1
    //   327: invokevirtual 541	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   330: invokestatic 68	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   333: astore_3
    //   334: goto -141 -> 193
    //   337: aload 22
    //   339: getfield 511	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   342: invokevirtual 162	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   345: invokestatic 68	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: astore_3
    //   349: goto -133 -> 216
    //   352: aload 22
    //   354: getfield 545	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   357: invokevirtual 548	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   360: invokestatic 553	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   363: astore_3
    //   364: goto -125 -> 239
    //   367: aconst_null
    //   368: astore_2
    //   369: aload 22
    //   371: getfield 545	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   374: invokevirtual 548	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   377: ifeq +15 -> 392
    //   380: aload 22
    //   382: getfield 545	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   385: invokevirtual 556	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   388: invokevirtual 562	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   391: astore_2
    //   392: aload 22
    //   394: getfield 565	msf/msgsvc/msg_svc$PbGetMsgResp:uin_pair_msgs	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   397: invokevirtual 54	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   400: astore 24
    //   402: aload_0
    //   403: getfield 299	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   406: iconst_0
    //   407: putfield 568	com/tencent/mobileqq/app/MessageHandler:bD	I
    //   410: aload 22
    //   412: getfield 572	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   415: invokevirtual 575	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   418: ifeq +1378 -> 1796
    //   421: aload 22
    //   423: getfield 572	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   426: invokevirtual 576	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   429: istore 5
    //   431: iload 5
    //   433: iconst_2
    //   434: if_icmpge +1356 -> 1790
    //   437: iconst_1
    //   438: i2b
    //   439: istore 4
    //   441: aload_0
    //   442: getfield 33	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   445: invokevirtual 178	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   448: aload_2
    //   449: invokevirtual 579	com/tencent/mobileqq/service/message/MessageCache:a	([B)V
    //   452: aload_0
    //   453: getfield 299	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   456: iconst_0
    //   457: invokevirtual 583	com/tencent/mobileqq/app/MessageHandler:c	(Z)V
    //   460: iconst_0
    //   461: istore 8
    //   463: aload_0
    //   464: getfield 299	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   467: invokevirtual 584	com/tencent/mobileqq/app/MessageHandler:a	()Z
    //   470: ifeq +6 -> 476
    //   473: iconst_1
    //   474: istore 8
    //   476: iload 4
    //   478: ifle +21 -> 499
    //   481: aload_0
    //   482: getfield 299	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   485: iload 4
    //   487: aload_2
    //   488: iload 5
    //   490: iload 9
    //   492: iload 11
    //   494: iload 8
    //   496: invokevirtual 587	com/tencent/mobileqq/app/MessageHandler:a	(B[BIZZZ)V
    //   499: invokestatic 592	java/lang/System:currentTimeMillis	()J
    //   502: pop2
    //   503: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +150 -> 656
    //   509: aload 23
    //   511: iconst_0
    //   512: invokevirtual 187	java/lang/StringBuilder:setLength	(I)V
    //   515: aload 23
    //   517: ldc_w 514
    //   520: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: astore_2
    //   524: aload_1
    //   525: ifnonnull +797 -> 1322
    //   528: ldc_w 516
    //   531: astore_1
    //   532: aload_2
    //   533: aload_1
    //   534: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   537: ldc_w 521
    //   540: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload 22
    //   545: getfield 511	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   548: invokevirtual 162	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   551: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   554: ldc_w 594
    //   557: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: aload 22
    //   562: getfield 545	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   565: invokevirtual 548	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   568: invokevirtual 528	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   571: ldc_w 596
    //   574: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: iload 4
    //   579: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   582: ldc_w 598
    //   585: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: iload 5
    //   590: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   593: ldc_w 600
    //   596: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: iload 9
    //   601: invokevirtual 528	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   604: ldc_w 530
    //   607: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: iload 11
    //   612: invokevirtual 528	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   615: ldc_w 602
    //   618: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: aload 24
    //   623: invokeinterface 60 1 0
    //   628: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   631: ldc_w 604
    //   634: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: aload_3
    //   638: invokevirtual 607	java/lang/Object:hashCode	()I
    //   641: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   644: pop
    //   645: ldc 10
    //   647: iconst_2
    //   648: aload 23
    //   650: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   653: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   656: iconst_0
    //   657: istore 5
    //   659: lconst_0
    //   660: lstore 12
    //   662: iload 5
    //   664: aload 24
    //   666: invokeinterface 60 1 0
    //   671: if_icmpge +745 -> 1416
    //   674: invokestatic 592	java/lang/System:currentTimeMillis	()J
    //   677: lstore 14
    //   679: aload 24
    //   681: iload 5
    //   683: invokeinterface 608 2 0
    //   688: checkcast 44	msf/msgcomm/msg_comm$UinPairMsg
    //   691: astore 22
    //   693: aload 22
    //   695: getfield 165	msf/msgcomm/msg_comm$UinPairMsg:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   698: invokevirtual 151	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   701: invokestatic 175	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   704: astore_2
    //   705: aload 22
    //   707: getfield 611	msf/msgcomm/msg_comm$UinPairMsg:last_read_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   710: invokevirtual 162	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   713: i2l
    //   714: ldc2_w 612
    //   717: land
    //   718: lstore 16
    //   720: aload 22
    //   722: getfield 48	msf/msgcomm/msg_comm$UinPairMsg:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   725: invokevirtual 54	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   728: astore_3
    //   729: aload 22
    //   731: getfield 616	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   734: invokevirtual 512	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   737: ifeq +596 -> 1333
    //   740: aload 22
    //   742: getfield 616	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   745: invokevirtual 162	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   748: ifeq +585 -> 1333
    //   751: iconst_1
    //   752: istore 8
    //   754: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   757: ifeq +77 -> 834
    //   760: aload 23
    //   762: iconst_0
    //   763: invokevirtual 187	java/lang/StringBuilder:setLength	(I)V
    //   766: aload 23
    //   768: ldc_w 618
    //   771: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: aload_2
    //   775: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: ldc_w 620
    //   781: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: iload 8
    //   786: invokevirtual 528	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   789: ldc_w 622
    //   792: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: lload 16
    //   797: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   800: ldc_w 624
    //   803: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: astore 25
    //   808: aload_3
    //   809: ifnonnull +530 -> 1339
    //   812: ldc_w 516
    //   815: astore_1
    //   816: aload 25
    //   818: aload_1
    //   819: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: ldc 10
    //   825: iconst_2
    //   826: aload 23
    //   828: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   834: aload_3
    //   835: ifnull +559 -> 1394
    //   838: aload_3
    //   839: invokeinterface 60 1 0
    //   844: ifle +550 -> 1394
    //   847: aload_3
    //   848: invokeinterface 60 1 0
    //   853: iconst_1
    //   854: if_icmple +15 -> 869
    //   857: aload_3
    //   858: new 626	cyi
    //   861: dup
    //   862: aload_0
    //   863: invokespecial 629	cyi:<init>	(Lcom/tencent/mobileqq/app/message/C2CMessageProcessor;)V
    //   866: invokestatic 635	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   869: aload_0
    //   870: getfield 33	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   873: bipush 8
    //   875: invokevirtual 639	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   878: checkcast 641	com/tencent/mobileqq/app/FriendsManagerImp
    //   881: aload_3
    //   882: iconst_0
    //   883: invokeinterface 608 2 0
    //   888: checkcast 100	msf/msgcomm/msg_comm$Msg
    //   891: getfield 104	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   894: invokevirtual 109	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   897: checkcast 106	msf/msgcomm/msg_comm$MsgHead
    //   900: getfield 154	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   903: invokevirtual 151	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   906: invokevirtual 642	com/tencent/mobileqq/app/FriendsManagerImp:a	(J)V
    //   909: aload_0
    //   910: getfield 299	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   913: aload_2
    //   914: iconst_0
    //   915: invokevirtual 645	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;I)Ljava/lang/Object;
    //   918: astore_1
    //   919: aload_1
    //   920: monitorenter
    //   921: aload_0
    //   922: aload_2
    //   923: aload 22
    //   925: lload 16
    //   927: iload 8
    //   929: iload 9
    //   931: iload 10
    //   933: invokespecial 647	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(Ljava/lang/String;Lmsf/msgcomm/msg_comm$UinPairMsg;JZZZ)Landroid/util/Pair;
    //   936: astore 22
    //   938: aload 22
    //   940: getfield 651	android/util/Pair:first	Ljava/lang/Object;
    //   943: checkcast 172	java/lang/String
    //   946: astore_2
    //   947: aload 22
    //   949: getfield 654	android/util/Pair:second	Ljava/lang/Object;
    //   952: checkcast 64	java/lang/Integer
    //   955: invokevirtual 657	java/lang/Integer:intValue	()I
    //   958: istore 7
    //   960: aload_1
    //   961: monitorexit
    //   962: iload 7
    //   964: istore 6
    //   966: aload_2
    //   967: astore_1
    //   968: iload 8
    //   970: ifne +183 -> 1153
    //   973: aload_0
    //   974: getfield 33	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   977: invokevirtual 178	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   980: aload_2
    //   981: invokevirtual 660	com/tencent/mobileqq/service/message/MessageCache:f	(Ljava/lang/String;)J
    //   984: lstore 18
    //   986: aload_3
    //   987: iconst_0
    //   988: invokeinterface 608 2 0
    //   993: checkcast 100	msf/msgcomm/msg_comm$Msg
    //   996: getfield 104	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   999: invokevirtual 109	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1002: checkcast 106	msf/msgcomm/msg_comm$MsgHead
    //   1005: getfield 158	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1008: invokevirtual 162	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1011: i2l
    //   1012: lstore 20
    //   1014: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1017: ifeq +62 -> 1079
    //   1020: ldc 10
    //   1022: iconst_2
    //   1023: new 76	java/lang/StringBuilder
    //   1026: dup
    //   1027: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   1030: ldc_w 662
    //   1033: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: aload_2
    //   1037: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: ldc_w 664
    //   1043: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: lload 18
    //   1048: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1051: ldc_w 666
    //   1054: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: lload 20
    //   1059: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1062: ldc_w 596
    //   1065: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: iload 4
    //   1070: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1073: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1076: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1079: lload 18
    //   1081: lconst_0
    //   1082: lcmp
    //   1083: ifeq +11 -> 1094
    //   1086: lload 20
    //   1088: lload 18
    //   1090: lcmp
    //   1091: ifge +35 -> 1126
    //   1094: aload_0
    //   1095: getfield 33	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1098: invokevirtual 178	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1101: aload_2
    //   1102: lload 20
    //   1104: lconst_0
    //   1105: invokevirtual 669	com/tencent/mobileqq/service/message/MessageCache:b	(Ljava/lang/String;JJ)V
    //   1108: iload 4
    //   1110: ifle +16 -> 1126
    //   1113: aload_0
    //   1114: getfield 33	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1117: invokevirtual 178	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1120: aload_2
    //   1121: lload 20
    //   1123: invokevirtual 672	com/tencent/mobileqq/service/message/MessageCache:f	(Ljava/lang/String;J)V
    //   1126: iload 7
    //   1128: istore 6
    //   1130: aload_2
    //   1131: astore_1
    //   1132: iload 4
    //   1134: ifne +19 -> 1153
    //   1137: aload_0
    //   1138: getfield 33	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1141: invokevirtual 178	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1144: invokevirtual 674	com/tencent/mobileqq/service/message/MessageCache:c	()V
    //   1147: aload_2
    //   1148: astore_1
    //   1149: iload 7
    //   1151: istore 6
    //   1153: invokestatic 592	java/lang/System:currentTimeMillis	()J
    //   1156: lstore 18
    //   1158: iload 9
    //   1160: ifeq +143 -> 1303
    //   1163: aload_1
    //   1164: astore_2
    //   1165: iload 6
    //   1167: sipush 1006
    //   1170: if_icmpne +30 -> 1200
    //   1173: aload_0
    //   1174: getfield 33	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1177: bipush 10
    //   1179: invokevirtual 639	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1182: checkcast 676	com/tencent/mobileqq/model/PhoneContactManager
    //   1185: aload_1
    //   1186: invokeinterface 679 2 0
    //   1191: astore_3
    //   1192: aload_1
    //   1193: astore_2
    //   1194: aload_3
    //   1195: ifnull +5 -> 1200
    //   1198: aload_3
    //   1199: astore_2
    //   1200: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1203: ifeq +29 -> 1232
    //   1206: ldc 10
    //   1208: iconst_2
    //   1209: new 76	java/lang/StringBuilder
    //   1212: dup
    //   1213: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   1216: ldc_w 681
    //   1219: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: aload_2
    //   1223: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1229: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1232: new 683	android/os/Message
    //   1235: dup
    //   1236: invokespecial 684	android/os/Message:<init>	()V
    //   1239: astore_1
    //   1240: aload_1
    //   1241: iconst_1
    //   1242: putfield 687	android/os/Message:what	I
    //   1245: new 354	android/os/Bundle
    //   1248: dup
    //   1249: invokespecial 355	android/os/Bundle:<init>	()V
    //   1252: astore_3
    //   1253: aload_3
    //   1254: ldc_w 689
    //   1257: lload 16
    //   1259: invokevirtual 692	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1262: aload_3
    //   1263: ldc_w 694
    //   1266: aload_2
    //   1267: invokevirtual 367	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1270: aload_3
    //   1271: ldc_w 696
    //   1274: iload 6
    //   1276: invokevirtual 361	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1279: aload_1
    //   1280: aload_3
    //   1281: invokevirtual 700	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1284: aload_0
    //   1285: getfield 299	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1288: aload_1
    //   1289: invokevirtual 703	com/tencent/mobileqq/app/MessageHandler:a	(Landroid/os/Message;)V
    //   1292: aload_0
    //   1293: getfield 23	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1296: aload_2
    //   1297: invokeinterface 706 2 0
    //   1302: pop
    //   1303: lload 12
    //   1305: lload 18
    //   1307: lload 14
    //   1309: lsub
    //   1310: ladd
    //   1311: lstore 12
    //   1313: iload 5
    //   1315: iconst_1
    //   1316: iadd
    //   1317: istore 5
    //   1319: goto -657 -> 662
    //   1322: aload_1
    //   1323: invokevirtual 541	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   1326: invokestatic 68	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1329: astore_1
    //   1330: goto -798 -> 532
    //   1333: iconst_0
    //   1334: istore 8
    //   1336: goto -582 -> 754
    //   1339: aload_3
    //   1340: invokeinterface 60 1 0
    //   1345: invokestatic 68	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1348: astore_1
    //   1349: goto -533 -> 816
    //   1352: astore_2
    //   1353: aload_1
    //   1354: monitorexit
    //   1355: aload_2
    //   1356: athrow
    //   1357: astore_1
    //   1358: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1361: ifeq +30 -> 1391
    //   1364: ldc 10
    //   1366: iconst_2
    //   1367: new 76	java/lang/StringBuilder
    //   1370: dup
    //   1371: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   1374: ldc_w 708
    //   1377: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1380: aload_1
    //   1381: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1384: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1387: aload_1
    //   1388: invokestatic 538	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1391: goto -78 -> 1313
    //   1394: aload_0
    //   1395: getfield 33	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1398: invokevirtual 255	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1401: aload_2
    //   1402: iconst_0
    //   1403: invokevirtual 711	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;
    //   1406: getfield 714	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1409: istore 6
    //   1411: aload_2
    //   1412: astore_1
    //   1413: goto -260 -> 1153
    //   1416: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1419: ifeq +30 -> 1449
    //   1422: ldc 10
    //   1424: iconst_2
    //   1425: new 76	java/lang/StringBuilder
    //   1428: dup
    //   1429: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   1432: ldc_w 716
    //   1435: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1438: lload 12
    //   1440: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1443: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1446: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1449: iload 4
    //   1451: ifgt -1163 -> 288
    //   1454: iload 9
    //   1456: ifeq +285 -> 1741
    //   1459: aload_0
    //   1460: getfield 33	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1463: invokevirtual 719	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/ConversationFacade;
    //   1466: invokevirtual 724	com/tencent/mobileqq/app/message/ConversationFacade:a	()Ljava/util/Set;
    //   1469: invokeinterface 725 1 0
    //   1474: astore_1
    //   1475: aload_1
    //   1476: invokeinterface 216 1 0
    //   1481: ifeq +251 -> 1732
    //   1484: aload_1
    //   1485: invokeinterface 220 1 0
    //   1490: checkcast 727	com/tencent/mobileqq/data/ConversationInfo
    //   1493: astore_2
    //   1494: aload_2
    //   1495: getfield 730	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1498: ifnull -23 -> 1475
    //   1501: aload_0
    //   1502: getfield 23	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1505: invokeinterface 731 1 0
    //   1510: ifeq -35 -> 1475
    //   1513: aload_0
    //   1514: getfield 23	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1517: aload_2
    //   1518: getfield 730	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1521: invokeinterface 734 2 0
    //   1526: ifne -51 -> 1475
    //   1529: aload_2
    //   1530: getfield 737	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1533: invokestatic 738	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(I)Z
    //   1536: ifeq -61 -> 1475
    //   1539: aload_2
    //   1540: getfield 741	com/tencent/mobileqq/data/ConversationInfo:unreadCount	I
    //   1543: ifle -68 -> 1475
    //   1546: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1549: ifeq +32 -> 1581
    //   1552: ldc 10
    //   1554: iconst_2
    //   1555: new 76	java/lang/StringBuilder
    //   1558: dup
    //   1559: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   1562: ldc_w 743
    //   1565: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1568: aload_2
    //   1569: getfield 730	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1572: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1575: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1578: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1581: aload_2
    //   1582: getfield 730	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1585: invokevirtual 376	java/lang/String:length	()I
    //   1588: iconst_4
    //   1589: if_icmple -114 -> 1475
    //   1592: aload_2
    //   1593: getfield 737	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1596: sipush 1001
    //   1599: if_icmpne +59 -> 1658
    //   1602: aload_0
    //   1603: getfield 33	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1606: invokevirtual 178	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1609: aload_2
    //   1610: getfield 730	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1613: invokevirtual 747	com/tencent/mobileqq/service/message/MessageCache:k	(Ljava/lang/String;)[B
    //   1616: astore_3
    //   1617: aload_3
    //   1618: ifnull -143 -> 1475
    //   1621: aload_3
    //   1622: arraylength
    //   1623: ifle -148 -> 1475
    //   1626: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1629: ifeq +29 -> 1658
    //   1632: ldc 10
    //   1634: iconst_2
    //   1635: new 76	java/lang/StringBuilder
    //   1638: dup
    //   1639: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   1642: ldc_w 749
    //   1645: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1648: aload_3
    //   1649: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1652: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1655: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1658: new 683	android/os/Message
    //   1661: dup
    //   1662: invokespecial 684	android/os/Message:<init>	()V
    //   1665: astore_3
    //   1666: aload_3
    //   1667: iconst_1
    //   1668: putfield 687	android/os/Message:what	I
    //   1671: new 354	android/os/Bundle
    //   1674: dup
    //   1675: invokespecial 355	android/os/Bundle:<init>	()V
    //   1678: astore 22
    //   1680: aload 22
    //   1682: ldc_w 689
    //   1685: ldc2_w 750
    //   1688: invokevirtual 692	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1691: aload 22
    //   1693: ldc_w 694
    //   1696: aload_2
    //   1697: getfield 730	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1700: invokevirtual 367	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1703: aload 22
    //   1705: ldc_w 696
    //   1708: aload_2
    //   1709: getfield 737	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1712: invokevirtual 361	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1715: aload_3
    //   1716: aload 22
    //   1718: invokevirtual 700	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1721: aload_0
    //   1722: getfield 299	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1725: aload_3
    //   1726: invokevirtual 703	com/tencent/mobileqq/app/MessageHandler:a	(Landroid/os/Message;)V
    //   1729: goto -254 -> 1475
    //   1732: aload_0
    //   1733: getfield 23	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1736: invokeinterface 754 1 0
    //   1741: invokestatic 759	com/tencent/util/MsgAutoMonitorUtil:a	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   1744: invokevirtual 761	com/tencent/util/MsgAutoMonitorUtil:e	()V
    //   1747: aload_0
    //   1748: sipush 4001
    //   1751: iconst_1
    //   1752: aconst_null
    //   1753: invokevirtual 764	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(IZLjava/lang/Object;)V
    //   1756: aload_0
    //   1757: getfield 299	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1760: invokevirtual 584	com/tencent/mobileqq/app/MessageHandler:a	()Z
    //   1763: ifeq -1475 -> 288
    //   1766: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1769: ifeq +12 -> 1781
    //   1772: ldc 10
    //   1774: iconst_2
    //   1775: ldc_w 766
    //   1778: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1781: aload_0
    //   1782: getfield 299	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1785: iconst_0
    //   1786: invokevirtual 768	com/tencent/mobileqq/app/MessageHandler:b	(Z)V
    //   1789: return
    //   1790: iconst_0
    //   1791: istore 4
    //   1793: goto -1352 -> 441
    //   1796: iconst_2
    //   1797: istore 5
    //   1799: goto -1368 -> 431
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1802	0	this	C2CMessageProcessor
    //   0	1802	2	paramFromServiceMsg	FromServiceMsg
    //   0	1802	3	paramObject	Object
    //   439	1353	4	b1	byte
    //   429	1369	5	i	int
    //   964	446	6	j	int
    //   958	192	7	k	int
    //   461	874	8	bool1	boolean
    //   11	1444	9	bool2	boolean
    //   37	895	10	bool3	boolean
    //   24	587	11	bool4	boolean
    //   660	779	12	l1	long
    //   677	631	14	l2	long
    //   718	540	16	l3	long
    //   984	322	18	l4	long
    //   1012	110	20	l5	long
    //   56	241	22	localObject1	Object
    //   301	15	22	localException	Exception
    //   321	1396	22	localObject2	Object
    //   134	693	23	localStringBuilder1	StringBuilder
    //   183	497	24	localObject3	Object
    //   806	11	25	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   73	90	301	java/lang/Exception
    //   921	962	1352	finally
    //   1353	1355	1352	finally
    //   909	921	1357	java/lang/Exception
    //   1355	1357	1357	java/lang/Exception
  }
  
  private void a(List paramList1, List paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---C2CMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!localMsgHead.c2c_cmd.has()) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster: no C2CCmd.");
      }
    }
    long l1;
    long l2;
    int i;
    int j;
    Object localObject1;
    long l7;
    Object localObject2;
    boolean bool2;
    boolean bool3;
    for (;;)
    {
      return;
      l1 = localMsgHead.c2c_cmd.get();
      l2 = localMsgHead.from_uin.get();
      long l3 = localMsgHead.to_uin.get();
      long l4 = localMsgHead.msg_seq.get();
      long l5 = localMsgHead.msg_time.get();
      long l6 = localMsgHead.msg_uid.get();
      i = localMsgHead.user_active.get();
      j = localMsgHead.from_instid.get();
      if (paramFromServiceMsg.getUin() == null)
      {
        localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        l7 = ((Long)localObject1).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster:fromUin:" + l2 + ",toUin:" + l3 + ",msgTime:" + l5 + ",msgSeq:" + l4 + ",msgUid:" + l6 + ",userActive:" + i + ",fromInstid:" + j + ",hasAppShare:" + paramMsg.appshare_info.has() + ",hasMsgBody:" + paramMsg.msg_body.has());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.ao = i;
        localObject1 = new ArrayList();
        Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
      try
      {
        localObject2 = new DecodeProtoPkgContext(l7, l3, true, false, false, false);
        ((DecodeProtoPkgContext)localObject2).h = true;
        paramMsg = a(paramMsg, (PBDecodeContext)localObject2);
        MessageHandlerUtils.a(paramMsg);
        if ((paramMsg != null) && (paramMsg.size() != 0))
        {
          if (localObject1 != null) {
            a(paramMsg, (ArrayList)localObject1, true);
          }
          paramMsg = new ArrayList();
          localObject2 = new ArrayList();
          if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
          {
            j = ((ArrayList)localObject1).size();
            i = 0;
            while (i < j)
            {
              MessageRecord localMessageRecord = (MessageRecord)((ArrayList)localObject1).get(i);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster after analysis mr.senderuin: " + localMessageRecord.senderuin + " mr.msgtype: " + localMessageRecord.msgtype + " mr.frienduin: " + localMessageRecord.frienduin + " mr.shmsgseq: " + localMessageRecord.shmsgseq + " mr.time:" + localMessageRecord.time + " mr.msg: " + localMessageRecord.getLogColorContent());
              }
              localMessageRecord.isread = true;
              localMessageRecord.issend = 2;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.time);
              ((ArrayList)localObject2).add(localMessageRecord);
              DelMsgInfo localDelMsgInfo = new DelMsgInfo();
              localDelMsgInfo.lFromUin = Long.parseLong(localMessageRecord.senderuin);
              localDelMsgInfo.shMsgSeq = ((short)(int)localMessageRecord.shmsgseq);
              localDelMsgInfo.uMsgTime = localMessageRecord.time;
              paramMsg.add(localDelMsgInfo);
              i += 1;
              continue;
              localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
            }
          }
        }
      }
      catch (Exception paramMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", paramMsg);
          }
          paramMsg = null;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((List)localObject2);
        bool2 = MessageHandlerUtils.a((ArrayList)localObject2);
        bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)localObject2);
        i = MsgProxyUtils.a((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (!bool2) {
          break label837;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) {}
    label837:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((QQMessageFacade)localObject1).a((ArrayList)localObject2, String.valueOf(l7), bool1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMsgHead.msg_seq.get());
      j = paramFromServiceMsg.getRequestSsoSeq();
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2, paramMsg, paramPbPushMsg.svrip.get(), j);
      if (l1 == 127L) {
        break;
      }
      a("handleMsgPush_PB_SlaveMaster", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool3), false);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b((ArrayList)localObject2);
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = new msg_svc.PbGetRoamMsgResp();
    String str;
    List localList;
    int i;
    for (;;)
    {
      int j;
      try
      {
        paramFromServiceMsg = (msg_svc.PbGetRoamMsgResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          break label1410;
        }
        str = String.valueOf(paramFromServiceMsg.peer_uin.get());
        j = paramFromServiceMsg.result.get();
        localList = paramFromServiceMsg.msg.get();
        if (localList == null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(str)) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(str);
          }
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg code=" + j + ", msgList is null !");
          }
          a(1004, false, null);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg InvalidProtocolBufferMicroException ! ", paramFromServiceMsg);
        }
        paramFromServiceMsg = null;
        continue;
      }
      catch (OutOfMemoryError paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramFromServiceMsg);
        }
        paramFromServiceMsg = null;
        continue;
        paramObject = new ArrayList();
        a(localList, paramObject);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg code=" + j + ", msgList.size()=" + paramObject.size() + ",peerUin=" + str + ",time=" + paramFromServiceMsg.last_msgtime.get());
        }
        i = 0;
        if (j == 0) {}
      }
      if ((j != 1) || (j == 0)) {
        try
        {
          if (paramObject.size() > 0)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(str)) {
              break label648;
            }
            localList = (List)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.get(str);
            if (localList.size() == 0) {
              localList.addAll(0, paramObject);
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(str, paramToServiceMsg.extraData.getLong("lBeginTime"), paramFromServiceMsg.last_msgtime.get(), paramToServiceMsg.extraData.getLong("lEndTime"), (short)0, paramFromServiceMsg.random.get());
            return;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg exception ! ", paramToServiceMsg);
            }
            i = 0;
            if (i != 0) {
              break;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(str)) {
              this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(str);
            }
            paramToServiceMsg = new Object[2];
            if (!paramFromServiceMsg.errmsg.has()) {
              break label1405;
            }
            paramToServiceMsg[0] = Boolean.valueOf(false);
            paramToServiceMsg[1] = paramFromServiceMsg.errmsg.get();
            a(1004, false, paramToServiceMsg);
            return;
            if ((localList.size() > 0) && ((((msg_comm.MsgHead)((msg_comm.Msg)localList.get(0)).msg_head.get()).msg_uid.get() != ((msg_comm.MsgHead)((msg_comm.Msg)paramObject.get(0)).msg_head.get()).msg_uid.get()) || (((msg_comm.MsgHead)((msg_comm.Msg)localList.get(0)).msg_head.get()).msg_seq.get() != ((msg_comm.MsgHead)((msg_comm.Msg)paramObject.get(0)).msg_head.get()).msg_seq.get()))) {
              localList.addAll(0, paramObject);
            }
          }
        }
        catch (OutOfMemoryError paramToServiceMsg)
        {
          for (;;)
          {
            label483:
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramToServiceMsg);
            }
            i = 0;
            continue;
            label648:
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.put(str, paramObject);
          }
        }
      }
    }
    paramObject = new ArrayList(paramObject);
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(str))
    {
      paramObject.addAll((Collection)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.get(str));
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(str);
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramObject, Long.valueOf(str).longValue(), true);
      if (localList != null)
      {
        localObject2 = localList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((MessageRecord)((Iterator)localObject2).next()).setStatus(1000);
        }
      }
      l1 = Long.parseLong(str);
    }
    catch (Exception localException1) {}
    label802:
    long l1;
    Object localObject1;
    if (!paramObject.isEmpty())
    {
      localObject1 = (msg_comm.Msg)paramObject.get(0);
      l1 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((msg_comm.MsgHead)((msg_comm.Msg)localObject1).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject1).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
    }
    Object localObject2 = new DecodeProtoPkgContext(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), l1, true, true, false, false);
    ((DecodeProtoPkgContext)localObject2).h = true;
    Iterator localIterator = paramObject.iterator();
    paramObject = null;
    if (localIterator.hasNext()) {
      localObject1 = (msg_comm.Msg)localIterator.next();
    }
    label1410:
    label1420:
    for (;;)
    {
      try
      {
        localObject1 = a((msg_comm.Msg)localObject1, (PBDecodeContext)localObject2);
        paramObject = localObject1;
        if ((paramObject != null) && (paramObject.size() > 0)) {
          localArrayList.addAll(paramObject);
        }
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label1420;
        }
      }
      localArrayList.addAll((Collection)localObject1);
      break label802;
      QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException2);
      break label1420;
      if (!localArrayList.isEmpty())
      {
        Collections.sort(localArrayList, new cyj(this));
        l1 = ((MessageRecord)localArrayList.get(0)).time;
        long l2 = Math.min(paramToServiceMsg.extraData.getLong("lEndTime"), ((MessageRecord)localArrayList.get(localArrayList.size() - 1)).time + 5L);
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 0, l1, l2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "delChatMsgOfRoamTime: roam size=" + localArrayList.size() + ", begin_svr=" + paramFromServiceMsg.last_msgtime.get() + ", begin_msg=" + ((MessageRecord)localArrayList.get(0)).time + ", end=" + l2 + ", del size=" + i);
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg exception ! ", paramToServiceMsg);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList);
        }
      }
      catch (OutOfMemoryError paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramToServiceMsg);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList);
        }
      }
      finally
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(localArrayList, false);
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()));
      if ((paramToServiceMsg == null) || (((Long)paramToServiceMsg.first).longValue() > paramFromServiceMsg.last_msgtime.get())) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()), paramFromServiceMsg.last_msgtime.get(), paramFromServiceMsg.random.get());
      }
      a(1004, true, null);
      i = 1;
      break;
      label1405:
      paramToServiceMsg = null;
      break label483;
      a(1004, false, null);
      return;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsgInOneDay ");
    }
    paramFromServiceMsg = new msg_svc.PbGetOneDayRoamMsgResp();
    Bundle localBundle;
    long l2;
    int i;
    try
    {
      paramFromServiceMsg = (msg_svc.PbGetOneDayRoamMsgResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      localBundle = paramToServiceMsg.extraData.getBundle("context");
      paramObject = null;
      l2 = 0L;
      if (paramFromServiceMsg == null) {
        break label669;
      }
      i = paramFromServiceMsg.result.get();
      Object localObject = paramFromServiceMsg.msg.get();
      paramToServiceMsg = new ArrayList();
      a((List)localObject, paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsgInOneDay code=" + i + ", complete=" + paramFromServiceMsg.iscomplete.get() + " ,respRandom:" + paramFromServiceMsg.random.get() + ", lastMsgTime:" + paramFromServiceMsg.last_msgtime.get() + ", msgList.size()=" + paramToServiceMsg.size() + ", context" + localBundle);
      }
      if (i != 0) {
        break label670;
      }
      paramObject = new ArrayList();
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramToServiceMsg, paramFromServiceMsg.peer_uin.get(), true);
        if (localObject != null) {
          paramObject.addAll((Collection)localObject);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          DecodeProtoPkgContext localDecodeProtoPkgContext;
          Iterator localIterator;
          continue;
          long l1 = 0L;
          paramToServiceMsg = null;
        }
      }
      l1 = paramFromServiceMsg.peer_uin.get();
      if (!paramToServiceMsg.isEmpty())
      {
        localObject = (msg_comm.Msg)paramToServiceMsg.get(0);
        l1 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
      }
      localDecodeProtoPkgContext = new DecodeProtoPkgContext(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), l1, true, true, false, false);
      localDecodeProtoPkgContext.h = true;
      localIterator = paramToServiceMsg.iterator();
      paramToServiceMsg = null;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label457;
        }
        localObject = (msg_comm.Msg)localIterator.next();
        try
        {
          localObject = a((msg_comm.Msg)localObject, localDecodeProtoPkgContext);
          paramToServiceMsg = (ToServiceMsg)localObject;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException1);
            }
          }
        }
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0)) {
          paramObject.addAll(paramToServiceMsg);
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = null;
      }
    }
    label457:
    if (paramObject.size() > 0)
    {
      Collections.sort(paramObject, new cyk(this));
      l1 = ((MessageRecord)paramObject.get(0)).time;
      paramToServiceMsg = paramObject;
      for (;;)
      {
        boolean bool3;
        boolean bool1;
        boolean bool2;
        if (localBundle != null)
        {
          localBundle.getInt("size_req", 0);
          l2 = localBundle.getLong("UIN", 0L);
          bool3 = localBundle.getBoolean("canUpdateEct", true);
          if (paramFromServiceMsg.iscomplete.get() == 0) {
            break label712;
          }
          bool1 = true;
          if ((i != 0) && (i != 1) && (i != 4)) {
            break label718;
          }
          bool2 = true;
          if ((!bool2) || (!bool3)) {
            break label761;
          }
          if (!bool1) {
            break label724;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(l2), 0L, 0L);
          label593:
          localBundle.putBoolean("complete", bool1);
          localBundle.putBoolean("success", bool2);
          localBundle.putLong("lowTime", l1);
          paramObject = new ArrayList();
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramFromServiceMsg.peer_uin.get()), 0, paramToServiceMsg, paramObject, localBundle);
          if (paramToServiceMsg != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramObject, false);
          }
          return;
          l1 = l2;
          paramToServiceMsg = paramObject;
          if (i != 1) {
            continue;
          }
          l1 = l2;
          paramToServiceMsg = paramObject;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.msg.C2CMessageProcessor", 2, "code == 0x01");
          l1 = l2;
          paramToServiceMsg = paramObject;
          continue;
          bool1 = false;
          break label541;
          label718:
          bool2 = false;
          break label561;
          label724:
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()), paramFromServiceMsg.last_msgtime.get(), paramFromServiceMsg.random.get());
          break label593;
          label761:
          if (bool3) {
            break label593;
          }
          if (bool1)
          {
            localBundle.putLong("tempEct", 0L);
            localBundle.putLong("tempRandom", 0L);
            break label593;
          }
          localBundle.putLong("tempEct", paramFromServiceMsg.last_msgtime.get());
          localBundle.putLong("tempRandom", paramFromServiceMsg.random.get());
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            paramFromServiceMsg.printStackTrace();
          }
        }
      }
    }
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    return 64 + "key_uid_" + l1 + "_seq_" + l2;
  }
  
  public ArrayList a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    if (!(paramPBDecodeContext instanceof DecodeProtoPkgContext)) {
      return new ArrayList();
    }
    DecodeProtoPkgContext localDecodeProtoPkgContext = (DecodeProtoPkgContext)paramPBDecodeContext;
    long l2 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if ((paramMsg == null) || (!paramMsg.msg_head.has()) || (!paramMsg.msg_body.has()))
    {
      if (QLog.isColorLevel())
      {
        paramPBDecodeContext = new StringBuilder().append("decodeSinglePBMsg_C2C return : ");
        if (paramMsg != null) {
          break label104;
        }
      }
      label104:
      for (paramMsg = " msg=null";; paramMsg = " msg.msg_head:" + paramMsg.msg_head + " msg.msg_body:" + paramMsg.msg_body.has())
      {
        QLog.d("Q.msg.C2CMessageProcessor", 2, paramMsg);
        return localArrayList;
      }
    }
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    int i1 = (short)localMsgHead.msg_seq.get();
    long l5 = localMsgHead.to_uin.get();
    long l3 = localMsgHead.from_uin.get();
    long l6 = localMsgHead.msg_time.get();
    long l4 = localMsgHead.msg_uid.get();
    int i2 = localMsgHead.msg_type.get();
    int i3 = paramMsg.msg_head.c2c_cmd.get();
    int n = 0;
    int m;
    int k;
    int j;
    if (paramMsg.content_head.has())
    {
      paramPBDecodeContext = (msg_comm.ContentHead)paramMsg.content_head.get();
      m = paramPBDecodeContext.div_seq.get();
      k = paramPBDecodeContext.pkg_num.get();
      j = paramPBDecodeContext.pkg_index.get();
    }
    for (;;)
    {
      long l1 = -1L;
      paramPBDecodeContext = null;
      label394:
      Object localObject;
      label596:
      int i;
      if (!localDecodeProtoPkgContext.jdField_d_of_type_Boolean)
      {
        paramPBDecodeContext = MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long), String.valueOf(l3));
        if (((Long)paramPBDecodeContext.first).longValue() != 4294967295L) {
          l1 = ((Long)paramPBDecodeContext.first).longValue();
        }
      }
      else
      {
        localDecodeProtoPkgContext.jdField_d_of_type_Long = l1;
        localDecodeProtoPkgContext.jdField_b_of_type_Long = l3;
        localDecodeProtoPkgContext.jdField_c_of_type_Long = l6;
        if (l3 != localDecodeProtoPkgContext.jdField_a_of_type_Long) {
          break label1062;
        }
        localDecodeProtoPkgContext.jdField_a_of_type_Boolean = true;
        localDecodeProtoPkgContext.f = true;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          StringBuilder localStringBuilder = ((StringBuilder)localObject).append("<---decodeSinglePBMsg_C2C : decode msg: msgTime:").append(l6).append(" shortSeq:").append(i1).append(" uint32Seq:").append(localMsgHead.msg_seq.get()).append(" msgUid:").append(l4).append(" toUin:").append(l5).append(" senderUin:").append(l3).append(" friendUin:").append(localDecodeProtoPkgContext.jdField_e_of_type_Long).append(" isReaded:").append(localDecodeProtoPkgContext.jdField_a_of_type_Boolean).append(" isSyncFromOtherTerm:").append(localDecodeProtoPkgContext.f).append(" msgType:").append(i2).append(" C2CCmd:").append(i3).append(" hasTemp:").append(localMsgHead.c2c_tmp_msg_head.has()).append(" hasShare:").append(paramMsg.appshare_info.has()).append(" pkgID:");
          if (paramPBDecodeContext != null) {
            break label1071;
          }
          paramPBDecodeContext = "nullPair";
          localStringBuilder.append(paramPBDecodeContext).append(" longMsgID:").append(m).append(" longMsgCount:").append(k).append(" longMsgIndex:").append(j);
          QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject).toString());
        }
        paramPBDecodeContext = new ArrayList();
        if ((i2 != 140) && (i2 != 141) && ((i2 != 529) || (localMsgHead.c2c_cmd.get() != 6))) {
          break label1137;
        }
        n = 1;
        localObject = MessageProtoCodec.a(paramMsg);
        if (((TempSessionInfo)localObject).b != -1) {
          break label1082;
        }
        i = 0;
        label712:
        if (i == 0) {
          break label1134;
        }
        i = ((TempSessionInfo)localObject).b;
        MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg, (TempSessionInfo)localObject, localDecodeProtoPkgContext);
      }
      label892:
      do
      {
        for (;;)
        {
          paramMsg = paramPBDecodeContext.iterator();
          for (;;)
          {
            if (!paramMsg.hasNext()) {
              break label2031;
            }
            paramPBDecodeContext = (MessageRecord)paramMsg.next();
            if (paramPBDecodeContext != null)
            {
              paramPBDecodeContext.selfuin = String.valueOf(localDecodeProtoPkgContext.jdField_a_of_type_Long);
              paramPBDecodeContext.frienduin = String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long);
              paramPBDecodeContext.senderuin = String.valueOf(localDecodeProtoPkgContext.jdField_b_of_type_Long);
              paramPBDecodeContext.time = localDecodeProtoPkgContext.jdField_c_of_type_Long;
              paramPBDecodeContext.shmsgseq = i1;
              paramPBDecodeContext.msgUid = l4;
              paramPBDecodeContext.istroop = i;
              paramPBDecodeContext.longMsgId = m;
              paramPBDecodeContext.longMsgCount = k;
              paramPBDecodeContext.longMsgIndex = j;
              localObject = (msg_comm.C2CTmpMsgHead)localMsgHead.c2c_tmp_msg_head.get();
              if ((localObject != null) && (((msg_comm.C2CTmpMsgHead)localObject).lock_display.has()))
              {
                if (((msg_comm.C2CTmpMsgHead)localObject).lock_display.get() != 1) {
                  break;
                }
                paramPBDecodeContext.extStr = "lockDisplay";
              }
              if (i == 1006)
              {
                if (localMsgHead.from_nick.has()) {
                  ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long), (short)0, localMsgHead.from_nick.get(), "");
                }
                paramPBDecodeContext.frienduin = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long));
                paramPBDecodeContext.senderuin = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l3));
                if ((TextUtils.isEmpty(paramPBDecodeContext.frienduin)) && (localDecodeProtoPkgContext.jdField_d_of_type_Boolean)) {
                  paramPBDecodeContext.frienduin = String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long);
                }
              }
              if (!localDecodeProtoPkgContext.f) {
                break label2019;
              }
              paramPBDecodeContext.issend = 2;
              paramPBDecodeContext.isread = true;
              paramPBDecodeContext.vipBubbleID = localDecodeProtoPkgContext.jdField_d_of_type_Long;
              localArrayList.add(paramPBDecodeContext);
            }
          }
          l1 = ((Long)paramPBDecodeContext.second).longValue();
          break;
          localDecodeProtoPkgContext.f = false;
          break label394;
          paramPBDecodeContext = (Serializable)paramPBDecodeContext.first;
          break label596;
          if ((((TempSessionInfo)localObject).b != 1000) && (((TempSessionInfo)localObject).b != 1020))
          {
            i = n;
            if (((TempSessionInfo)localObject).b != 1004) {
              break label712;
            }
          }
          localDecodeProtoPkgContext.jdField_b_of_type_Long = ((TempSessionInfo)localObject).jdField_c_of_type_Long;
          i = n;
          break label712;
          return localArrayList;
          if (paramMsg.appshare_info.has())
          {
            MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg, 0L, 0L, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
            i = n;
          }
          else
          {
            if ((MessageUtils.c(i2)) && (localMsgHead.c2c_cmd.has())) {
              i = n;
            }
            switch (i3)
            {
            case 193: 
            default: 
              i = n;
              break;
            case 11: 
            case 175: 
              MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg, localDecodeProtoPkgContext.jdField_e_of_type_Long, localDecodeProtoPkgContext.jdField_b_of_type_Boolean, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
              i = n;
              break;
            case 169: 
            case 241: 
            case 242: 
            case 243: 
              MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, i3, paramMsg, localDecodeProtoPkgContext.jdField_e_of_type_Long, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.jdField_b_of_type_Boolean, localDecodeProtoPkgContext.f, localDecodeProtoPkgContext.jdField_d_of_type_Long, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
              i = n;
              break;
            case 129: 
            case 131: 
            case 133: 
              MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext.jdField_e_of_type_Long, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.jdField_b_of_type_Boolean, localDecodeProtoPkgContext.jdField_d_of_type_Long);
              i = n;
              continue;
              if (i2 == 208)
              {
                MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg);
                i = n;
              }
              else
              {
                if (SystemMsg.isSystemMessage(i2))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.systemmsg.", 2, "friend system msg notify");
                  }
                  i = 0;
                  if ((i2 == 188) || (i2 == 189)) {
                    i = 1;
                  }
                  if ((!localDecodeProtoPkgContext.jdField_c_of_type_Boolean) && (i == 0)) {
                    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(2);
                  }
                  localDecodeProtoPkgContext.jdField_e_of_type_Long = 9998L;
                  MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.f, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
                  if (i != 0) {
                    SystemMsgController.a().b(l3, l6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  }
                  for (;;)
                  {
                    return localArrayList;
                    paramMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
                    if (!MessageHandler.jdField_c_of_type_Boolean) {
                      SystemMsgController.a().a(l3, l6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                    } else {
                      FriendSystemMsgController.a().a(l3, l6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                    }
                  }
                }
                if (a(i2))
                {
                  a(paramPBDecodeContext, paramMsg, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
                  i = n;
                }
                else if (732 == i2)
                {
                  a(paramMsg, i1, l3, l4, i2);
                  i = n;
                }
                else
                {
                  if (SystemMsg.isTroopSystemMessage(i2))
                  {
                    i = 0;
                    if ((i2 == 85) || (i2 == 36)) {
                      i = 1;
                    }
                    if ((!localDecodeProtoPkgContext.jdField_c_of_type_Boolean) && (i == 0)) {
                      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(3);
                    }
                    localDecodeProtoPkgContext.jdField_e_of_type_Long = 9998L;
                    MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.f, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
                    if (i != 0) {
                      SystemMsgController.a().b(l3, l6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                    }
                    for (;;)
                    {
                      return localArrayList;
                      GroupSystemMsgController.a().a(l3, l6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                    }
                  }
                  if (i2 != 528) {
                    break label1809;
                  }
                  i = n;
                  if (!localDecodeProtoPkgContext.jdField_d_of_type_Boolean)
                  {
                    MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, localDecodeProtoPkgContext.jdField_a_of_type_Long, paramMsg, localDecodeProtoPkgContext.h);
                    i = n;
                  }
                }
              }
              break;
            }
          }
        }
        i = n;
      } while (i2 != 529);
      label1028:
      label1062:
      label1071:
      label1082:
      label1134:
      label1137:
      if (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.has())
      {
        n = 1;
        localObject = MessageProtoCodec.a(paramMsg);
        if (((TempSessionInfo)localObject).b == -1)
        {
          i = 0;
          if (i == 0) {
            break label2046;
          }
          i = ((TempSessionInfo)localObject).b;
          MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg, (TempSessionInfo)localObject, localDecodeProtoPkgContext);
        }
      }
      for (;;)
      {
        label1809:
        label1859:
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
        l1 = localDecodeProtoPkgContext.jdField_e_of_type_Long;
        boolean bool2 = localDecodeProtoPkgContext.jdField_a_of_type_Boolean;
        boolean bool3 = localDecodeProtoPkgContext.jdField_b_of_type_Boolean;
        if (l3 == localDecodeProtoPkgContext.jdField_a_of_type_Long) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          MessageProtoCodec.a((MessageHandler)localObject, paramPBDecodeContext, paramMsg, l1, bool2, bool3, bool1, localDecodeProtoPkgContext.jdField_d_of_type_Long, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
          break;
          if ((((TempSessionInfo)localObject).b != 1000) && (((TempSessionInfo)localObject).b != 1020))
          {
            i = n;
            if (((TempSessionInfo)localObject).b != 1004) {
              break label1859;
            }
          }
          localDecodeProtoPkgContext.jdField_b_of_type_Long = ((TempSessionInfo)localObject).jdField_c_of_type_Long;
          i = n;
          break label1859;
        }
        paramPBDecodeContext.extStr = "";
        break label892;
        label2019:
        paramPBDecodeContext.isread = localDecodeProtoPkgContext.jdField_a_of_type_Boolean;
        break label1028;
        label2031:
        MsgAutoMonitorUtil.a().f(System.currentTimeMillis() - l2);
        return localArrayList;
        label2046:
        i = 0;
      }
      j = 0;
      k = 0;
      m = 0;
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 2001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        c((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 2003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (SvcResponseMsgReadedReport)paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(ArrayList paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (localMessageRecord.msgtype == -3006)
      {
        PAMessage localPAMessage = XMLMessageUtils.a(localMessageRecord);
        if ((localPAMessage != null) && (localPAMessage.mMsgId > 0L)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localMessageRecord.frienduin, "mp_msg_sys_15", "msg_get", 0, 1, 0, Long.toString(localPAMessage.mMsgId), "", "", "");
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramArrayList);
  }
  
  public void a(List paramList, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    paramList = (msg_comm.MsgHead)paramMsg.msg_head.get();
    paramMsg = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    long l1 = Utils.a(paramMsg, 0);
    int i = paramMsg[4];
    long l2 = Utils.a(paramMsg, 5);
    i = paramMsg[9];
    long l3 = Utils.a(paramMsg, 10);
    int j = paramMsg[14];
    try
    {
      new String(paramMsg, 15, j, "GBK");
      if (!paramBoolean)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, String.valueOf(l2), String.valueOf(l3), l1, paramList.msg_time.get(), paramList.msg_seq.get(), paramList);
        paramMsg = new ArrayList();
        paramMsg.add(new UinPairReadInfo(paramList.from_uin.get(), paramList.msg_time.get(), 0L, null));
        ((C2CMessageProcessor)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("c2c_processor")).b(paramMsg);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        new String(paramMsg, 15, j);
      }
    }
  }
  
  public void a(msg_comm.Msg paramMsg, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if ((paramMsg == null) || (!paramMsg.msg_body.has()) || (!paramMsg.msg_body.msg_content.has())) {}
    do
    {
      byte[] arrayOfByte1;
      Object localObject;
      int i;
      do
      {
        do
        {
          do
          {
            return;
            arrayOfByte1 = paramMsg.msg_body.msg_content.get().toByteArray();
            localObject = new byte[arrayOfByte1.length];
            PkgTools.a((byte[])localObject, 0, arrayOfByte1, 0, localObject.length);
          } while (localObject.length < 5);
          i = localObject[4];
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "<---hotchat and opentroop push  groupCode:" + PkgTools.a(arrayOfByte1, 0) + " subType:" + i);
          }
          if ((i != 12) && (i != 14)) {
            break;
          }
        } while (!((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a((byte[])localObject, paramInt1));
        return;
      } while (i != 16);
      if (arrayOfByte1.length > 7)
      {
        localObject = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
        byte[] arrayOfByte2 = new byte[arrayOfByte1.length - 7];
        PkgTools.a(arrayOfByte2, 0, arrayOfByte1, 7, arrayOfByte2.length);
        ((TroopTipsMsgMgr)localObject).a(arrayOfByte2, paramInt1, paramMsg.msg_head.msg_time.get(), true);
      }
      MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramLong1, paramInt1, paramLong2, paramInt2);
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.C2CMessageProcessor", 2, String.format("handle0x2dcMessage==>sendDelMsgReqToServer fromUin:%f, seq:%f, msgUid:%f, msgType:%d", new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) }));
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 33;
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void b(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    a(true, false, false, 0L, new cyl(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.C2CMessageProcessor
 * JD-Core Version:    0.7.0.1
 */