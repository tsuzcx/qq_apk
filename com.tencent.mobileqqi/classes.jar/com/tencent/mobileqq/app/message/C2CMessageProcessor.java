package com.tencent.mobileqq.app.message;

import MessageSvcPack.UinPairReadInfo;
import OnlinePushPack.DelMsgInfo;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.av.VideoConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
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
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import fnl;
import fnm;
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
    long l7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject1 = paramUinPairMsg.msg.get();
    if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
      return new Pair(paramString, Integer.valueOf(0));
    }
    ArrayList localArrayList2 = new ArrayList();
    a((List)localObject1, localArrayList2);
    StringBuilder localStringBuilder = new StringBuilder();
    HashMap localHashMap = new HashMap();
    HashSet localHashSet = new HashSet();
    DecodeProtoPkgContext localDecodeProtoPkgContext = new DecodeProtoPkgContext(l7, Long.parseLong(paramString), true, paramBoolean2, paramBoolean3, false);
    localDecodeProtoPkgContext.jdField_e_of_type_Boolean = true;
    localDecodeProtoPkgContext.a(1000, localHashMap);
    localDecodeProtoPkgContext.a(1001, localHashSet);
    long l1 = -1L;
    int i = 0;
    localObject1 = paramString;
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
          break label1501;
        }
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<---decodeC2CMessagePackage: msgList[" + k + "] : msg doesn't has msgHead.");
        break label1501;
      }
      l3 = ((msg_comm.MsgHead)localObject3).to_uin.get();
      l8 = ((msg_comm.MsgHead)localObject3).from_uin.get();
      l4 = ((msg_comm.MsgHead)localObject3).from_uin.get();
      l5 = ((msg_comm.MsgHead)localObject3).msg_time.get();
      if (l5 <= paramLong) {
        break label1492;
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
        long l8;
        long l4;
        long l5;
        long l9;
        int j;
        continue;
        paramBoolean3 = true;
        boolean bool = true;
      }
      l3 = l2;
      l2 = l1;
      l1 = l3;
    }
    l9 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l4, l3, paramUinPairMsg.peer_uin.get());
    localObject1 = String.valueOf(l9);
    long l3 = l2;
    l4 = l1;
    j = i;
    for (;;)
    {
      try
      {
        l6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l9), 0);
        if ((l5 <= l6) && (bool))
        {
          l3 = l2;
          l4 = l1;
          j = i;
          if (!QLog.isColorLevel()) {
            break label1534;
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
          QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
          break label1534;
        }
        l3 = l2;
        l4 = l1;
        j = i;
        localDecodeProtoPkgContext.jdField_a_of_type_Boolean = bool;
        l3 = l2;
        l4 = l1;
        j = i;
        localDecodeProtoPkgContext.jdField_e_of_type_Long = l9;
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
          break label839;
        }
        l3 = l2;
        l4 = l1;
        j = i;
        if (!MsgUtils.a(((MessageRecord)localObject3).issend)) {
          break label828;
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
          break label813;
        }
      }
      catch (Exception localException1)
      {
        i = j;
        l1 = l4;
        l2 = l3;
      }
      QLog.w("Q.msg.BaseMessageProcessor", 2, "decodeC2CMessage error,", localException1);
      label813:
      l3 = l1;
      l1 = l2;
      l2 = l3;
      break label1513;
      label828:
      long l6 = l5;
      l5 = l2;
      continue;
      label839:
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
            ((MessageRecord)localObject3).vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l9), String.valueOf(l8));
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
          ((MessageRecord)localObject3).vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l9), String.valueOf(l8));
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
    break label1513;
    if (localObject1 != null)
    {
      paramUinPairMsg = (msg_comm.UinPairMsg)localObject1;
      if (!((String)localObject1).equals("0")) {}
    }
    else
    {
      paramUinPairMsg = paramString;
    }
    if (!localHashMap.isEmpty())
    {
      paramString = localHashSet.iterator();
      while (paramString.hasNext())
      {
        localObject1 = (Long)paramString.next();
        localHashMap.remove(localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("svenxu", 2, "Discard video request because canceled: fromUin = " + localObject1);
        }
      }
      paramString = localHashMap.keySet().iterator();
      while (paramString.hasNext())
      {
        localObject1 = (msg_comm.Msg)localHashMap.get((Long)paramString.next());
        if ((((msg_comm.Msg)localObject1).msg_body.has()) && (((im_msg_body.MsgBody)((msg_comm.Msg)localObject1).msg_body.get()).msg_content.has())) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l7, ((im_msg_body.MsgBody)((msg_comm.Msg)localObject1).msg_body.get()).msg_content.get().toByteArray(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject1).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject1).msg_head.get()).msg_time.get());
        }
      }
    }
    if (localArrayList1.size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramUinPairMsg), 0, localArrayList1, paramBoolean1);
      paramBoolean3 = MessageHandlerUtils.a(localArrayList1);
      bool = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList1);
      if (!paramBoolean2) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localArrayList1);
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((!paramBoolean3) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause)) {
        break label1481;
      }
    }
    label1481:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramString.a(localArrayList1, str, paramBoolean1);
      a(localArrayList1);
      a("handleGetBuddyMessageResp", true, localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramBoolean3, bool), paramBoolean2);
      return new Pair(paramUinPairMsg, Integer.valueOf(i));
    }
    for (;;)
    {
      label1492:
      label1501:
      label1513:
      k += 1;
      l3 = l2;
      l2 = l1;
      l1 = l3;
      break;
      label1534:
      l3 = l1;
      l1 = l2;
      l2 = l3;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, msg_comm.MsgHead paramMsgHead)
  {
    String str2 = paramQQAppInterface.a();
    Long localLong = Long.valueOf(Long.parseLong(str2));
    String str3 = String.valueOf(paramLong1);
    String str1 = null;
    String str4 = "" + paramMsgHead.auth_uin.get();
    paramMsgHead = paramMsgHead.auth_nick.get();
    if ((!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(paramMsgHead)) && (str4.equals(paramString1))) {}
    for (;;)
    {
      if ((str2 != null) && (str2.equals(paramString1)))
      {
        BaseApplicationImpl.getContext().getString(2131559191);
        return;
      }
      if (TextUtils.isEmpty(paramMsgHead)) {
        paramMsgHead = MessageHandlerUtils.a(paramQQAppInterface, paramString1, str3);
      }
      for (;;)
      {
        if ((paramInt == -126) || (paramInt == 2)) {
          paramString1 = paramMsgHead + BaseApplicationImpl.getContext().getString(2131559192);
        }
        for (;;)
        {
          if (paramString1 == null) {
            break label316;
          }
          paramString2 = MessageRecordFactory.a(-1012);
          paramString2.init(localLong.longValue(), paramLong1, paramLong1, paramString1, paramLong2, -1012, 1, paramLong3);
          paramString2.isread = true;
          if (a(paramString2, false)) {
            break;
          }
          paramQQAppInterface.a().a(paramString2, String.valueOf(localLong));
          return;
          if (paramInt != -125)
          {
            paramString1 = str1;
            if (paramInt != 3) {}
          }
          else
          {
            str1 = MessageHandlerUtils.a(paramQQAppInterface, paramString2, str3);
            paramString1 = str1;
            if (str2 != null)
            {
              paramString1 = str1;
              if (str2.equals(paramString2)) {
                paramString1 = BaseApplicationImpl.getContext().getString(2131559193);
              }
            }
            paramString1 = BaseApplicationImpl.getContext().getString(2131559194, new Object[] { paramString1, paramMsgHead });
          }
        }
        label316:
        break;
      }
      paramMsgHead = "";
    }
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 422	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 424
    //   7: iconst_1
    //   8: invokevirtual 430	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   11: istore 8
    //   13: aload_1
    //   14: getfield 422	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   17: ldc_w 432
    //   20: iconst_1
    //   21: invokevirtual 430	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   24: istore 10
    //   26: aload_1
    //   27: getfield 422	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   30: ldc_w 434
    //   33: iconst_0
    //   34: invokevirtual 430	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   37: istore 9
    //   39: aload_2
    //   40: invokevirtual 439	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   43: ifnonnull +246 -> 289
    //   46: aload_0
    //   47: getfield 30	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   50: invokevirtual 442	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   53: invokestatic 445	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   56: astore 21
    //   58: aload 21
    //   60: invokevirtual 398	java/lang/Long:longValue	()J
    //   63: pop2
    //   64: new 447	msf/msgsvc/msg_svc$PbGetMsgResp
    //   67: dup
    //   68: invokespecial 448	msf/msgsvc/msg_svc$PbGetMsgResp:<init>	()V
    //   71: astore 21
    //   73: aload 21
    //   75: aload_3
    //   76: checkcast 450	[B
    //   79: checkcast 450	[B
    //   82: invokevirtual 454	msf/msgsvc/msg_svc$PbGetMsgResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   85: checkcast 447	msf/msgsvc/msg_svc$PbGetMsgResp
    //   88: astore 21
    //   90: aload 21
    //   92: ifnonnull +35 -> 127
    //   95: invokestatic 457	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   98: invokestatic 462	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   101: aload_0
    //   102: getfield 30	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   105: invokevirtual 39	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   108: ldc_w 464
    //   111: iconst_0
    //   112: lconst_0
    //   113: lconst_0
    //   114: new 76	java/util/HashMap
    //   117: dup
    //   118: invokespecial 77	java/util/HashMap:<init>	()V
    //   121: ldc_w 357
    //   124: invokevirtual 467	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   127: new 73	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   134: astore 22
    //   136: aload 21
    //   138: ifnull +25 -> 163
    //   141: aload 21
    //   143: getfield 470	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   146: invokevirtual 471	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   149: ifeq +14 -> 163
    //   152: aload 21
    //   154: getfield 470	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   160: ifeq +207 -> 367
    //   163: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +113 -> 279
    //   169: aload 22
    //   171: iconst_0
    //   172: invokevirtual 192	java/lang/StringBuilder:setLength	(I)V
    //   175: aload 22
    //   177: ldc_w 473
    //   180: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: astore 23
    //   185: aload_1
    //   186: ifnonnull +140 -> 326
    //   189: ldc_w 475
    //   192: astore_3
    //   193: aload 23
    //   195: aload_3
    //   196: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   199: ldc_w 477
    //   202: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: astore 23
    //   207: aload 21
    //   209: ifnonnull +128 -> 337
    //   212: ldc_w 475
    //   215: astore_3
    //   216: aload 23
    //   218: aload_3
    //   219: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   222: ldc_w 479
    //   225: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: astore 23
    //   230: aload 21
    //   232: ifnonnull +120 -> 352
    //   235: ldc_w 475
    //   238: astore_3
    //   239: aload 23
    //   241: aload_3
    //   242: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   245: ldc_w 481
    //   248: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: iload 8
    //   253: invokevirtual 484	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   256: ldc_w 486
    //   259: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: iload 10
    //   264: invokevirtual 484	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: ldc 130
    //   270: iconst_2
    //   271: aload 22
    //   273: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 488	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: aload_0
    //   280: getfield 305	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   283: aload_1
    //   284: aload_2
    //   285: invokevirtual 491	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   288: return
    //   289: aload_2
    //   290: invokevirtual 439	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   293: invokestatic 445	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   296: astore 21
    //   298: goto -240 -> 58
    //   301: astore 21
    //   303: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   306: ifeq +14 -> 320
    //   309: ldc 130
    //   311: iconst_2
    //   312: ldc_w 493
    //   315: aload 21
    //   317: invokestatic 495	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   320: aconst_null
    //   321: astore 21
    //   323: goto -233 -> 90
    //   326: aload_1
    //   327: invokevirtual 498	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   330: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   333: astore_3
    //   334: goto -141 -> 193
    //   337: aload 21
    //   339: getfield 470	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   342: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   345: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: astore_3
    //   349: goto -133 -> 216
    //   352: aload 21
    //   354: getfield 501	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   357: invokevirtual 302	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   360: invokestatic 506	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   363: astore_3
    //   364: goto -125 -> 239
    //   367: aconst_null
    //   368: astore_2
    //   369: aload 21
    //   371: getfield 501	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   374: invokevirtual 302	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   377: ifeq +15 -> 392
    //   380: aload 21
    //   382: getfield 501	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   385: invokevirtual 308	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   388: invokevirtual 314	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   391: astore_2
    //   392: aload 21
    //   394: getfield 509	msf/msgsvc/msg_svc$PbGetMsgResp:uin_pair_msgs	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   397: invokevirtual 51	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   400: astore 23
    //   402: aload_0
    //   403: getfield 305	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   406: iconst_0
    //   407: putfield 512	com/tencent/mobileqq/app/MessageHandler:bK	I
    //   410: aload 21
    //   412: getfield 516	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   415: invokevirtual 519	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   418: ifeq +1328 -> 1746
    //   421: aload 21
    //   423: getfield 516	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   426: invokevirtual 520	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   429: istore 5
    //   431: iload 5
    //   433: iconst_2
    //   434: if_icmpge +1306 -> 1740
    //   437: iconst_1
    //   438: i2b
    //   439: istore 4
    //   441: aload_0
    //   442: getfield 30	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   445: invokevirtual 183	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   448: aload_2
    //   449: invokevirtual 523	com/tencent/mobileqq/service/message/MessageCache:a	([B)V
    //   452: aload_0
    //   453: getfield 305	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   456: iconst_0
    //   457: invokevirtual 527	com/tencent/mobileqq/app/MessageHandler:c	(Z)V
    //   460: iconst_0
    //   461: istore 7
    //   463: aload_0
    //   464: getfield 305	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   467: invokevirtual 529	com/tencent/mobileqq/app/MessageHandler:a	()Z
    //   470: ifeq +6 -> 476
    //   473: iconst_1
    //   474: istore 7
    //   476: iload 4
    //   478: ifle +21 -> 499
    //   481: aload_0
    //   482: getfield 305	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   485: iload 4
    //   487: aload_2
    //   488: iload 5
    //   490: iload 8
    //   492: iload 10
    //   494: iload 7
    //   496: invokevirtual 532	com/tencent/mobileqq/app/MessageHandler:a	(B[BIZZZ)V
    //   499: invokestatic 537	java/lang/System:currentTimeMillis	()J
    //   502: pop2
    //   503: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +150 -> 656
    //   509: aload 22
    //   511: iconst_0
    //   512: invokevirtual 192	java/lang/StringBuilder:setLength	(I)V
    //   515: aload 22
    //   517: ldc_w 473
    //   520: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: astore_2
    //   524: aload_1
    //   525: ifnonnull +746 -> 1271
    //   528: ldc_w 475
    //   531: astore_1
    //   532: aload_2
    //   533: aload_1
    //   534: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   537: ldc_w 477
    //   540: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload 21
    //   545: getfield 470	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   548: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   551: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   554: ldc_w 539
    //   557: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: aload 21
    //   562: getfield 501	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   565: invokevirtual 302	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   568: invokevirtual 484	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   571: ldc_w 541
    //   574: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: iload 4
    //   579: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   582: ldc_w 543
    //   585: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: iload 5
    //   590: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   593: ldc_w 545
    //   596: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: iload 8
    //   601: invokevirtual 484	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   604: ldc_w 486
    //   607: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: iload 10
    //   612: invokevirtual 484	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   615: ldc_w 547
    //   618: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: aload 23
    //   623: invokeinterface 57 1 0
    //   628: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   631: ldc_w 549
    //   634: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: aload_3
    //   638: invokevirtual 552	java/lang/Object:hashCode	()I
    //   641: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   644: pop
    //   645: ldc 130
    //   647: iconst_2
    //   648: aload 22
    //   650: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   653: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   656: iconst_0
    //   657: istore 5
    //   659: lconst_0
    //   660: lstore 11
    //   662: iload 5
    //   664: aload 23
    //   666: invokeinterface 57 1 0
    //   671: if_icmpge +695 -> 1366
    //   674: invokestatic 537	java/lang/System:currentTimeMillis	()J
    //   677: lstore 13
    //   679: aload 23
    //   681: iload 5
    //   683: invokeinterface 553 2 0
    //   688: checkcast 41	msf/msgcomm/msg_comm$UinPairMsg
    //   691: astore 21
    //   693: aload 21
    //   695: getfield 170	msf/msgcomm/msg_comm$UinPairMsg:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   698: invokevirtual 156	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   701: invokestatic 180	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   704: astore_2
    //   705: aload 21
    //   707: getfield 556	msf/msgcomm/msg_comm$UinPairMsg:last_read_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   710: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   713: i2l
    //   714: ldc2_w 557
    //   717: land
    //   718: lstore 15
    //   720: aload 21
    //   722: getfield 45	msf/msgcomm/msg_comm$UinPairMsg:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   725: invokevirtual 51	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   728: astore_3
    //   729: aload 21
    //   731: getfield 561	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   734: invokevirtual 471	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   737: ifeq +545 -> 1282
    //   740: aload 21
    //   742: getfield 561	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   745: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   748: ifeq +534 -> 1282
    //   751: iconst_1
    //   752: istore 7
    //   754: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   757: ifeq +77 -> 834
    //   760: aload 22
    //   762: iconst_0
    //   763: invokevirtual 192	java/lang/StringBuilder:setLength	(I)V
    //   766: aload 22
    //   768: ldc_w 563
    //   771: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: aload_2
    //   775: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: ldc_w 565
    //   781: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: iload 7
    //   786: invokevirtual 484	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   789: ldc_w 567
    //   792: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: lload 15
    //   797: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   800: ldc_w 569
    //   803: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: astore 24
    //   808: aload_3
    //   809: ifnonnull +479 -> 1288
    //   812: ldc_w 475
    //   815: astore_1
    //   816: aload 24
    //   818: aload_1
    //   819: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: ldc 130
    //   825: iconst_2
    //   826: aload 22
    //   828: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   834: aload_3
    //   835: ifnull +509 -> 1344
    //   838: aload_3
    //   839: invokeinterface 57 1 0
    //   844: ifle +500 -> 1344
    //   847: aload_3
    //   848: invokeinterface 57 1 0
    //   853: iconst_1
    //   854: if_icmple +15 -> 869
    //   857: aload_3
    //   858: new 571	fnk
    //   861: dup
    //   862: aload_0
    //   863: invokespecial 574	fnk:<init>	(Lcom/tencent/mobileqq/app/message/C2CMessageProcessor;)V
    //   866: invokestatic 580	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   869: aload_0
    //   870: getfield 30	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   873: bipush 8
    //   875: invokevirtual 584	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   878: checkcast 586	com/tencent/mobileqq/app/FriendsManagerImp
    //   881: aload_3
    //   882: iconst_0
    //   883: invokeinterface 553 2 0
    //   888: checkcast 103	msf/msgcomm/msg_comm$Msg
    //   891: getfield 107	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   894: invokevirtual 112	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   897: checkcast 109	msf/msgcomm/msg_comm$MsgHead
    //   900: getfield 159	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   903: invokevirtual 156	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   906: invokevirtual 589	com/tencent/mobileqq/app/FriendsManagerImp:a	(J)V
    //   909: aload_0
    //   910: getfield 305	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   913: aload_2
    //   914: iconst_0
    //   915: invokevirtual 592	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;I)Ljava/lang/Object;
    //   918: astore 24
    //   920: aload 24
    //   922: monitorenter
    //   923: aload_0
    //   924: aload_2
    //   925: aload 21
    //   927: lload 15
    //   929: iload 7
    //   931: iload 8
    //   933: iload 9
    //   935: invokespecial 594	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(Ljava/lang/String;Lmsf/msgcomm/msg_comm$UinPairMsg;JZZZ)Landroid/util/Pair;
    //   938: astore_2
    //   939: aload_2
    //   940: getfield 598	android/util/Pair:first	Ljava/lang/Object;
    //   943: checkcast 177	java/lang/String
    //   946: astore_1
    //   947: aload_2
    //   948: getfield 601	android/util/Pair:second	Ljava/lang/Object;
    //   951: checkcast 61	java/lang/Integer
    //   954: invokevirtual 604	java/lang/Integer:intValue	()I
    //   957: istore 6
    //   959: aload 24
    //   961: monitorexit
    //   962: iload 7
    //   964: ifne +171 -> 1135
    //   967: aload_0
    //   968: getfield 30	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   971: invokevirtual 183	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   974: aload_1
    //   975: invokevirtual 607	com/tencent/mobileqq/service/message/MessageCache:f	(Ljava/lang/String;)J
    //   978: lstore 17
    //   980: aload_3
    //   981: iconst_0
    //   982: invokeinterface 553 2 0
    //   987: checkcast 103	msf/msgcomm/msg_comm$Msg
    //   990: getfield 107	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   993: invokevirtual 112	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   996: checkcast 109	msf/msgcomm/msg_comm$MsgHead
    //   999: getfield 163	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1002: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1005: i2l
    //   1006: lstore 19
    //   1008: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1011: ifeq +62 -> 1073
    //   1014: ldc 130
    //   1016: iconst_2
    //   1017: new 73	java/lang/StringBuilder
    //   1020: dup
    //   1021: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1024: ldc_w 609
    //   1027: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: aload_1
    //   1031: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: ldc_w 611
    //   1037: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: lload 17
    //   1042: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1045: ldc_w 613
    //   1048: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: lload 19
    //   1053: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1056: ldc_w 541
    //   1059: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: iload 4
    //   1064: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1067: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1070: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1073: lload 17
    //   1075: lconst_0
    //   1076: lcmp
    //   1077: ifeq +11 -> 1088
    //   1080: lload 19
    //   1082: lload 17
    //   1084: lcmp
    //   1085: ifge +35 -> 1120
    //   1088: aload_0
    //   1089: getfield 30	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1092: invokevirtual 183	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1095: aload_1
    //   1096: lload 19
    //   1098: lconst_0
    //   1099: invokevirtual 616	com/tencent/mobileqq/service/message/MessageCache:b	(Ljava/lang/String;JJ)V
    //   1102: iload 4
    //   1104: ifle +16 -> 1120
    //   1107: aload_0
    //   1108: getfield 30	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1111: invokevirtual 183	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1114: aload_1
    //   1115: lload 19
    //   1117: invokevirtual 619	com/tencent/mobileqq/service/message/MessageCache:f	(Ljava/lang/String;J)V
    //   1120: iload 4
    //   1122: ifne +13 -> 1135
    //   1125: aload_0
    //   1126: getfield 30	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1129: invokevirtual 183	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1132: invokevirtual 621	com/tencent/mobileqq/service/message/MessageCache:c	()V
    //   1135: invokestatic 537	java/lang/System:currentTimeMillis	()J
    //   1138: lload 13
    //   1140: lsub
    //   1141: lload 11
    //   1143: ladd
    //   1144: lstore 13
    //   1146: lload 13
    //   1148: lstore 11
    //   1150: iload 8
    //   1152: ifeq +110 -> 1262
    //   1155: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1158: ifeq +29 -> 1187
    //   1161: ldc 130
    //   1163: iconst_2
    //   1164: new 73	java/lang/StringBuilder
    //   1167: dup
    //   1168: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1171: ldc_w 623
    //   1174: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: aload_1
    //   1178: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1184: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1187: new 625	android/os/Message
    //   1190: dup
    //   1191: invokespecial 626	android/os/Message:<init>	()V
    //   1194: astore_2
    //   1195: aload_2
    //   1196: iconst_1
    //   1197: putfield 629	android/os/Message:what	I
    //   1200: new 426	android/os/Bundle
    //   1203: dup
    //   1204: invokespecial 630	android/os/Bundle:<init>	()V
    //   1207: astore_3
    //   1208: aload_3
    //   1209: ldc_w 632
    //   1212: lload 15
    //   1214: invokevirtual 635	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1217: aload_3
    //   1218: ldc_w 637
    //   1221: aload_1
    //   1222: invokevirtual 641	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1225: aload_3
    //   1226: ldc_w 643
    //   1229: iload 6
    //   1231: invokevirtual 647	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1234: aload_2
    //   1235: aload_3
    //   1236: invokevirtual 651	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1239: aload_0
    //   1240: getfield 305	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1243: aload_2
    //   1244: invokevirtual 654	com/tencent/mobileqq/app/MessageHandler:a	(Landroid/os/Message;)V
    //   1247: aload_0
    //   1248: getfield 20	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1251: aload_1
    //   1252: invokeinterface 655 2 0
    //   1257: pop
    //   1258: lload 13
    //   1260: lstore 11
    //   1262: iload 5
    //   1264: iconst_1
    //   1265: iadd
    //   1266: istore 5
    //   1268: goto -606 -> 662
    //   1271: aload_1
    //   1272: invokevirtual 498	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   1275: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1278: astore_1
    //   1279: goto -747 -> 532
    //   1282: iconst_0
    //   1283: istore 7
    //   1285: goto -531 -> 754
    //   1288: aload_3
    //   1289: invokeinterface 57 1 0
    //   1294: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1297: astore_1
    //   1298: goto -482 -> 816
    //   1301: astore_1
    //   1302: aload 24
    //   1304: monitorexit
    //   1305: aload_1
    //   1306: athrow
    //   1307: astore_1
    //   1308: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1311: ifeq +30 -> 1341
    //   1314: ldc 130
    //   1316: iconst_2
    //   1317: new 73	java/lang/StringBuilder
    //   1320: dup
    //   1321: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1324: ldc_w 657
    //   1327: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: aload_1
    //   1331: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1334: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1337: aload_1
    //   1338: invokestatic 495	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1341: goto -79 -> 1262
    //   1344: aload_0
    //   1345: getfield 30	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1348: invokevirtual 260	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1351: aload_2
    //   1352: iconst_0
    //   1353: invokevirtual 660	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;
    //   1356: getfield 663	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1359: istore 6
    //   1361: aload_2
    //   1362: astore_1
    //   1363: goto -228 -> 1135
    //   1366: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1369: ifeq +30 -> 1399
    //   1372: ldc 130
    //   1374: iconst_2
    //   1375: new 73	java/lang/StringBuilder
    //   1378: dup
    //   1379: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1382: ldc_w 665
    //   1385: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: lload 11
    //   1390: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1393: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1396: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1399: iload 4
    //   1401: ifgt -1113 -> 288
    //   1404: iload 8
    //   1406: ifeq +285 -> 1691
    //   1409: aload_0
    //   1410: getfield 30	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1413: invokevirtual 668	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/ConversationFacade;
    //   1416: invokevirtual 672	com/tencent/mobileqq/app/message/ConversationFacade:a	()Ljava/util/Set;
    //   1419: invokeinterface 292 1 0
    //   1424: astore_1
    //   1425: aload_1
    //   1426: invokeinterface 221 1 0
    //   1431: ifeq +251 -> 1682
    //   1434: aload_1
    //   1435: invokeinterface 225 1 0
    //   1440: checkcast 674	com/tencent/mobileqq/data/ConversationInfo
    //   1443: astore_2
    //   1444: aload_2
    //   1445: getfield 678	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1448: ifnull -23 -> 1425
    //   1451: aload_0
    //   1452: getfield 20	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1455: invokeinterface 679 1 0
    //   1460: ifeq -35 -> 1425
    //   1463: aload_0
    //   1464: getfield 20	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1467: aload_2
    //   1468: getfield 678	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1471: invokeinterface 682 2 0
    //   1476: ifne -51 -> 1425
    //   1479: aload_2
    //   1480: getfield 685	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1483: invokestatic 688	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(I)Z
    //   1486: ifeq -61 -> 1425
    //   1489: aload_2
    //   1490: getfield 691	com/tencent/mobileqq/data/ConversationInfo:unreadCount	I
    //   1493: ifle -68 -> 1425
    //   1496: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1499: ifeq +32 -> 1531
    //   1502: ldc 130
    //   1504: iconst_2
    //   1505: new 73	java/lang/StringBuilder
    //   1508: dup
    //   1509: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1512: ldc_w 693
    //   1515: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1518: aload_2
    //   1519: getfield 678	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1522: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1525: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1528: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1531: aload_2
    //   1532: getfield 678	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1535: invokevirtual 696	java/lang/String:length	()I
    //   1538: iconst_4
    //   1539: if_icmple -114 -> 1425
    //   1542: aload_2
    //   1543: getfield 685	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1546: sipush 1001
    //   1549: if_icmpne +59 -> 1608
    //   1552: aload_0
    //   1553: getfield 30	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1556: invokevirtual 183	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1559: aload_2
    //   1560: getfield 678	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1563: invokevirtual 700	com/tencent/mobileqq/service/message/MessageCache:k	(Ljava/lang/String;)[B
    //   1566: astore_3
    //   1567: aload_3
    //   1568: ifnull -143 -> 1425
    //   1571: aload_3
    //   1572: arraylength
    //   1573: ifle -148 -> 1425
    //   1576: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1579: ifeq +29 -> 1608
    //   1582: ldc 130
    //   1584: iconst_2
    //   1585: new 73	java/lang/StringBuilder
    //   1588: dup
    //   1589: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1592: ldc_w 702
    //   1595: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1598: aload_3
    //   1599: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1602: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1605: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1608: new 625	android/os/Message
    //   1611: dup
    //   1612: invokespecial 626	android/os/Message:<init>	()V
    //   1615: astore_3
    //   1616: aload_3
    //   1617: iconst_1
    //   1618: putfield 629	android/os/Message:what	I
    //   1621: new 426	android/os/Bundle
    //   1624: dup
    //   1625: invokespecial 630	android/os/Bundle:<init>	()V
    //   1628: astore 21
    //   1630: aload 21
    //   1632: ldc_w 632
    //   1635: ldc2_w 703
    //   1638: invokevirtual 635	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1641: aload 21
    //   1643: ldc_w 637
    //   1646: aload_2
    //   1647: getfield 678	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1650: invokevirtual 641	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1653: aload 21
    //   1655: ldc_w 643
    //   1658: aload_2
    //   1659: getfield 685	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1662: invokevirtual 647	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1665: aload_3
    //   1666: aload 21
    //   1668: invokevirtual 651	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1671: aload_0
    //   1672: getfield 305	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1675: aload_3
    //   1676: invokevirtual 654	com/tencent/mobileqq/app/MessageHandler:a	(Landroid/os/Message;)V
    //   1679: goto -254 -> 1425
    //   1682: aload_0
    //   1683: getfield 20	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1686: invokeinterface 707 1 0
    //   1691: invokestatic 712	com/tencent/util/MsgAutoMonitorUtil:a	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   1694: invokevirtual 714	com/tencent/util/MsgAutoMonitorUtil:e	()V
    //   1697: aload_0
    //   1698: sipush 4001
    //   1701: iconst_1
    //   1702: aconst_null
    //   1703: invokevirtual 717	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(IZLjava/lang/Object;)V
    //   1706: aload_0
    //   1707: getfield 305	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1710: invokevirtual 529	com/tencent/mobileqq/app/MessageHandler:a	()Z
    //   1713: ifeq -1425 -> 288
    //   1716: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1719: ifeq +12 -> 1731
    //   1722: ldc 130
    //   1724: iconst_2
    //   1725: ldc_w 719
    //   1728: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1731: aload_0
    //   1732: getfield 305	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1735: iconst_0
    //   1736: invokevirtual 721	com/tencent/mobileqq/app/MessageHandler:b	(Z)V
    //   1739: return
    //   1740: iconst_0
    //   1741: istore 4
    //   1743: goto -1302 -> 441
    //   1746: iconst_2
    //   1747: istore 5
    //   1749: goto -1318 -> 431
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1752	0	this	C2CMessageProcessor
    //   0	1752	1	paramToServiceMsg	ToServiceMsg
    //   0	1752	2	paramFromServiceMsg	FromServiceMsg
    //   0	1752	3	paramObject	Object
    //   439	1303	4	b1	byte
    //   429	1319	5	i	int
    //   957	403	6	j	int
    //   461	823	7	bool1	boolean
    //   11	1394	8	bool2	boolean
    //   37	897	9	bool3	boolean
    //   24	587	10	bool4	boolean
    //   660	729	11	l1	long
    //   677	582	13	l2	long
    //   718	495	15	l3	long
    //   978	105	17	l4	long
    //   1006	110	19	l5	long
    //   56	241	21	localObject1	Object
    //   301	15	21	localException	Exception
    //   321	1346	21	localObject2	Object
    //   134	693	22	localStringBuilder	StringBuilder
    //   183	497	23	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   73	90	301	java/lang/Exception
    //   923	962	1301	finally
    //   1302	1305	1301	finally
    //   909	923	1307	java/lang/Exception
    //   1305	1307	1307	java/lang/Exception
  }
  
  private void a(List paramList1, List paramList2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("<---decodeC2CMessagePackage: msgFilter_OnePkg ");
    int i = 0;
    if (paramList1 == null) {}
    do
    {
      return;
      HashSet localHashSet = new HashSet();
      StringBuilder localStringBuilder2 = new StringBuilder(64);
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext())
      {
        msg_comm.Msg localMsg = (msg_comm.Msg)localIterator.next();
        if (localMsg.msg_head.has())
        {
          long l1 = ((msg_comm.MsgHead)localMsg.msg_head.get()).from_uin.get();
          long l2 = ((msg_comm.MsgHead)localMsg.msg_head.get()).msg_seq.get();
          long l3 = ((msg_comm.MsgHead)localMsg.msg_head.get()).msg_uid.get();
          localStringBuilder2.setLength(0);
          localStringBuilder2.append("key_").append(l1).append("_").append(l2).append("_").append(l3);
          String str = localStringBuilder2.toString();
          if (localHashSet.contains(str))
          {
            if (QLog.isColorLevel()) {
              localStringBuilder1.append("<  duplicatedMsg : ").append(str).append("  >");
            }
            i = 1;
          }
          for (;;)
          {
            break;
            localHashSet.add(str);
            paramList2.add(localMsg);
          }
        }
      }
    } while ((i == 0) || (!QLog.isColorLevel()));
    localStringBuilder1.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
    QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder1.toString());
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!localMsgHead.c2c_cmd.has()) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster: no C2CCmd.");
      }
    }
    long l1;
    long l2;
    int i;
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
      int j = localMsgHead.from_instid.get();
      if (paramFromServiceMsg.getUin() == null)
      {
        localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        l7 = ((Long)localObject1).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster:fromUin:" + l2 + ",toUin:" + l3 + ",msgTime:" + l5 + ",msgSeq:" + l4 + ",msgUid:" + l6 + ",userActive:" + i + ",fromInstid:" + j + ",hasAppShare:" + paramMsg.appshare_info.has() + ",hasMsgBody:" + paramMsg.msg_body.has());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.ah = i;
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
                QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster after analysis mr.senderuin: " + localMessageRecord.senderuin + " mr.msgtype: " + localMessageRecord.msgtype + " mr.frienduin: " + localMessageRecord.frienduin + " mr.shmsgseq: " + localMessageRecord.shmsgseq + " mr.time:" + localMessageRecord.time + " mr.msg: " + localMessageRecord.getLogColorContent());
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
            QLog.w("Q.msg.BaseMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", paramMsg);
          }
          paramMsg = null;
        }
        bool2 = MessageHandlerUtils.a((ArrayList)localObject2);
        bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((List)localObject2);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (!bool2) {
          break label826;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) {}
    label826:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((QQMessageFacade)localObject1).a((ArrayList)localObject2, String.valueOf(l7), bool1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMsgHead.msg_seq.get());
      i = paramFromServiceMsg.getRequestSsoSeq();
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2, paramMsg, paramPbPushMsg.svrip.get(), i);
      if (l1 == 127L) {
        break;
      }
      a("handleMsgPush_PB_SlaveMaster", true, (List)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool3), false);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b((ArrayList)localObject2);
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = new msg_svc.PbGetRoamMsgResp();
    String str;
    int i;
    List localList;
    for (;;)
    {
      int j;
      try
      {
        paramFromServiceMsg = (msg_svc.PbGetRoamMsgResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          break label1377;
        }
        str = String.valueOf(paramFromServiceMsg.peer_uin.get());
        j = paramFromServiceMsg.result.get();
        paramObject = paramFromServiceMsg.msg.get();
        if (paramObject == null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(str)) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(str);
          }
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.BaseMessageProcessor", 2, "handlePBGetRoamMsg code=" + j + ", msgList is null !");
          }
          a(1004, false, null);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageProcessor", 2, "handlePBGetRoamMsg InvalidProtocolBufferMicroException ! ", paramFromServiceMsg);
        }
        paramFromServiceMsg = null;
        continue;
      }
      catch (OutOfMemoryError paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramFromServiceMsg);
        }
        paramFromServiceMsg = null;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "handlePBGetRoamMsg code=" + j + ", msgList.size()=" + paramObject.size() + ",peerUin=" + str);
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
              break label615;
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
              QLog.w("Q.msg.BaseMessageProcessor", 2, "handlePBGetRoamMsg exception ! ", paramToServiceMsg);
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
              break label1372;
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
            label450:
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.BaseMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramToServiceMsg);
            }
            i = 0;
            continue;
            label615:
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
          ((Entity)((Iterator)localObject2).next()).setStatus(1000);
        }
      }
      l1 = Long.parseLong(str);
    }
    catch (Exception localException1) {}
    label769:
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
    label1372:
    label1377:
    label1387:
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
          break label1387;
        }
      }
      localArrayList.addAll((Collection)localObject1);
      break label769;
      QLog.w("Q.msg.BaseMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException2);
      break label1387;
      if (!localArrayList.isEmpty())
      {
        Collections.sort(localArrayList, new fnl(this));
        l1 = ((MessageRecord)localArrayList.get(0)).time;
        long l2 = Math.min(paramToServiceMsg.extraData.getLong("lEndTime"), ((MessageRecord)localArrayList.get(localArrayList.size() - 1)).time + 5L);
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 0, l1, l2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "delChatMsgOfRoamTime: roam size=" + localArrayList.size() + ", begin_svr=" + paramFromServiceMsg.last_msgtime.get() + ", begin_msg=" + ((MessageRecord)localArrayList.get(0)).time + ", end=" + l2 + ", del size=" + i);
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
            QLog.w("Q.msg.BaseMessageProcessor", 2, "handlePBGetRoamMsg exception ! ", paramToServiceMsg);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList);
        }
      }
      catch (OutOfMemoryError paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.BaseMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramToServiceMsg);
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
      paramToServiceMsg = null;
      break label450;
      a(1004, false, null);
      return;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handlePBGetRoamMsgInOneDay ");
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
        break label653;
      }
      i = paramFromServiceMsg.result.get();
      paramToServiceMsg = paramFromServiceMsg.msg.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "handlePBGetRoamMsgInOneDay code=" + i + ", complete=" + paramFromServiceMsg.iscomplete.get() + " ,respRandom:" + paramFromServiceMsg.random.get() + ", lastMsgTime:" + paramFromServiceMsg.last_msgtime.get() + ", msgList.size()=" + paramToServiceMsg.size() + ", context" + localBundle);
      }
      if (i != 0) {
        break label654;
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
          Object localObject;
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
          break label441;
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
              QLog.w("Q.msg.BaseMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException1);
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
    label441:
    if (paramObject.size() > 0)
    {
      Collections.sort(paramObject, new fnm(this));
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
            break label696;
          }
          bool1 = true;
          if ((i != 0) && (i != 1) && (i != 4)) {
            break label702;
          }
          bool2 = true;
          if ((!bool2) || (!bool3)) {
            break label745;
          }
          if (!bool1) {
            break label708;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(l2), 0L, 0L);
          label577:
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
          QLog.d("Q.msg.BaseMessageProcessor", 2, "code == 0x01");
          l1 = l2;
          paramToServiceMsg = paramObject;
          continue;
          bool1 = false;
          break label525;
          label702:
          bool2 = false;
          break label545;
          label708:
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()), paramFromServiceMsg.last_msgtime.get(), paramFromServiceMsg.random.get());
          break label577;
          label745:
          if (bool3) {
            break label577;
          }
          if (bool1)
          {
            localBundle.putLong("tempEct", 0L);
            localBundle.putLong("tempRandom", 0L);
            break label577;
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
  
  public ArrayList a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    if (!(paramPBDecodeContext instanceof DecodeProtoPkgContext)) {
      return new ArrayList();
    }
    DecodeProtoPkgContext localDecodeProtoPkgContext = (DecodeProtoPkgContext)paramPBDecodeContext;
    long l1 = System.currentTimeMillis();
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
        QLog.d("Q.msg.BaseMessageProcessor", 2, paramMsg);
        return localArrayList;
      }
    }
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    int i1 = (short)localMsgHead.msg_seq.get();
    long l4 = localMsgHead.to_uin.get();
    long l2 = localMsgHead.from_uin.get();
    long l5 = localMsgHead.msg_time.get();
    long l3 = localMsgHead.msg_uid.get();
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
      paramPBDecodeContext = null;
      label387:
      Object localObject;
      label589:
      int i;
      if (!localDecodeProtoPkgContext.jdField_d_of_type_Boolean)
      {
        paramPBDecodeContext = MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long), String.valueOf(l2));
        if (((Long)paramPBDecodeContext.first).longValue() != 4294967295L) {
          ((Long)paramPBDecodeContext.first).longValue();
        }
      }
      else
      {
        localDecodeProtoPkgContext.jdField_d_of_type_Long = 0L;
        localDecodeProtoPkgContext.jdField_b_of_type_Long = l2;
        localDecodeProtoPkgContext.jdField_c_of_type_Long = l5;
        if (l2 != localDecodeProtoPkgContext.jdField_a_of_type_Long) {
          break label1054;
        }
        localDecodeProtoPkgContext.jdField_a_of_type_Boolean = true;
        localDecodeProtoPkgContext.f = true;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          StringBuilder localStringBuilder = ((StringBuilder)localObject).append("<---decodeSinglePBMsg_C2C : decode msg: msgTime:").append(l5).append(" shortSeq:").append(i1).append(" uint32Seq:").append(localMsgHead.msg_seq.get()).append(" msgUid:").append(l3).append(" toUin:").append(l4).append(" senderUin:").append(l2).append(" friendUin:").append(localDecodeProtoPkgContext.jdField_e_of_type_Long).append(" isReaded:").append(localDecodeProtoPkgContext.jdField_a_of_type_Boolean).append(" isSyncFromOtherTerm:").append(localDecodeProtoPkgContext.f).append(" msgType:").append(i2).append(" C2CCmd:").append(i3).append(" hasTemp:").append(localMsgHead.c2c_tmp_msg_head.has()).append(" hasShare:").append(paramMsg.appshare_info.has()).append(" pkgID:");
          if (paramPBDecodeContext != null) {
            break label1063;
          }
          paramPBDecodeContext = "nullPair";
          localStringBuilder.append(paramPBDecodeContext).append(" longMsgID:").append(m).append(" longMsgCount:").append(k).append(" longMsgIndex:").append(j);
          QLog.d("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject).toString());
        }
        paramPBDecodeContext = new ArrayList();
        if ((i2 != 140) && (i2 != 141) && ((i2 != 529) || (localMsgHead.c2c_cmd.get() != 6))) {
          break label1129;
        }
        n = 1;
        localObject = MessageProtoCodec.a(paramMsg);
        if (((TempSessionInfo)localObject).b != -1) {
          break label1074;
        }
        i = 0;
        label705:
        if (i == 0) {
          break label1126;
        }
        i = ((TempSessionInfo)localObject).b;
        MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg, (TempSessionInfo)localObject, localDecodeProtoPkgContext);
      }
      label885:
      label1021:
      do
      {
        for (;;)
        {
          paramMsg = paramPBDecodeContext.iterator();
          for (;;)
          {
            if (!paramMsg.hasNext()) {
              break label2115;
            }
            paramPBDecodeContext = (MessageRecord)paramMsg.next();
            if (paramPBDecodeContext != null)
            {
              paramPBDecodeContext.selfuin = String.valueOf(localDecodeProtoPkgContext.jdField_a_of_type_Long);
              paramPBDecodeContext.frienduin = String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long);
              paramPBDecodeContext.senderuin = String.valueOf(localDecodeProtoPkgContext.jdField_b_of_type_Long);
              paramPBDecodeContext.time = localDecodeProtoPkgContext.jdField_c_of_type_Long;
              paramPBDecodeContext.shmsgseq = i1;
              paramPBDecodeContext.msgUid = l3;
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
                paramPBDecodeContext.senderuin = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l2));
                if ((TextUtils.isEmpty(paramPBDecodeContext.frienduin)) && (localDecodeProtoPkgContext.jdField_d_of_type_Boolean)) {
                  paramPBDecodeContext.frienduin = String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long);
                }
              }
              if (!localDecodeProtoPkgContext.f) {
                break label2103;
              }
              paramPBDecodeContext.issend = 2;
              paramPBDecodeContext.isread = true;
              paramPBDecodeContext.vipBubbleID = localDecodeProtoPkgContext.jdField_d_of_type_Long;
              localArrayList.add(paramPBDecodeContext);
            }
          }
          ((Long)paramPBDecodeContext.second).longValue();
          break;
          localDecodeProtoPkgContext.f = false;
          break label387;
          paramPBDecodeContext = (Serializable)paramPBDecodeContext.first;
          break label589;
          if ((((TempSessionInfo)localObject).b != 1000) && (((TempSessionInfo)localObject).b != 1020))
          {
            i = n;
            if (((TempSessionInfo)localObject).b != 1004) {
              break label705;
            }
          }
          localDecodeProtoPkgContext.jdField_b_of_type_Long = ((TempSessionInfo)localObject).jdField_c_of_type_Long;
          i = n;
          break label705;
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
              else if (i2 == 193)
              {
                i = n;
                if (!localDecodeProtoPkgContext.jdField_d_of_type_Boolean)
                {
                  MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext);
                  i = n;
                }
              }
              else if (i2 == 734)
              {
                MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.f);
                i = n;
              }
              else if (i2 == 519)
              {
                i = n;
                if (!localDecodeProtoPkgContext.jdField_d_of_type_Boolean)
                {
                  i = n;
                  if (VideoConstants.jdField_a_of_type_Boolean)
                  {
                    MessageProtoCodec.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.f);
                    i = n;
                  }
                }
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
                    SystemMsgController.a().b(l2, l5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  }
                  for (;;)
                  {
                    return localArrayList;
                    paramMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
                    if (!MessageHandler.jdField_c_of_type_Boolean) {
                      SystemMsgController.a().a(l2, l5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                    } else {
                      FriendSystemMsgController.a().a(l2, l5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                    }
                  }
                }
                if (a(i2))
                {
                  a(paramPBDecodeContext, paramMsg, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
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
                      SystemMsgController.a().b(l2, l5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                    }
                    for (;;)
                    {
                      return localArrayList;
                      GroupSystemMsgController.a().a(l2, l5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                    }
                  }
                  if (i2 != 528) {
                    break label1893;
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
      label1054:
      label1063:
      label1074:
      label1126:
      label1129:
      if (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.has())
      {
        n = 1;
        localObject = MessageProtoCodec.a(paramMsg);
        if (((TempSessionInfo)localObject).b == -1)
        {
          i = 0;
          if (i == 0) {
            break label2130;
          }
          i = ((TempSessionInfo)localObject).b;
          MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg, (TempSessionInfo)localObject, localDecodeProtoPkgContext);
        }
      }
      for (;;)
      {
        label1893:
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
        label1943:
        l4 = localDecodeProtoPkgContext.jdField_e_of_type_Long;
        boolean bool2 = localDecodeProtoPkgContext.jdField_a_of_type_Boolean;
        boolean bool3 = localDecodeProtoPkgContext.jdField_b_of_type_Boolean;
        if (l2 == localDecodeProtoPkgContext.jdField_a_of_type_Long) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          MessageProtoCodec.a((MessageHandler)localObject, paramPBDecodeContext, paramMsg, l4, bool2, bool3, bool1, localDecodeProtoPkgContext.jdField_d_of_type_Long, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
          break;
          if ((((TempSessionInfo)localObject).b != 1000) && (((TempSessionInfo)localObject).b != 1020))
          {
            i = n;
            if (((TempSessionInfo)localObject).b != 1004) {
              break label1943;
            }
          }
          localDecodeProtoPkgContext.jdField_b_of_type_Long = ((TempSessionInfo)localObject).jdField_c_of_type_Long;
          i = n;
          break label1943;
        }
        paramPBDecodeContext.extStr = "";
        break label885;
        label2103:
        paramPBDecodeContext.isread = localDecodeProtoPkgContext.jdField_a_of_type_Boolean;
        break label1021;
        label2115:
        MsgAutoMonitorUtil.a().f(System.currentTimeMillis() - l1);
        return localArrayList;
        label2130:
        i = 0;
      }
      j = 0;
      k = 0;
      m = 0;
    }
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
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2]);
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
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.c(paramMsg);
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
  
  public boolean a(int paramInt)
  {
    return paramInt == 33;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.C2CMessageProcessor
 * JD-Core Version:    0.7.0.1
 */