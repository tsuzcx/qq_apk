package com.tencent.mobileqq.app.message;

import ActionMsg.MsgBody;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.subaccount.SubAccountDataControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fjt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbBindUinGetMsgReq;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmReq;
import msf.msgsvc.msg_svc.PbGetMsgResp;

public class SubAccountMessageProcessor
  extends C2CMessageProcessor
{
  public SubAccountMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 19	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc 21
    //   6: invokevirtual 27	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore 6
    //   11: aload_1
    //   12: getfield 19	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   15: ldc 29
    //   17: invokevirtual 27	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   20: astore 7
    //   22: iconst_m1
    //   23: istore 5
    //   25: aconst_null
    //   26: astore_2
    //   27: new 31	msf/msgsvc/msg_svc$PbBindUinMsgReadedConfirmResp
    //   30: dup
    //   31: invokespecial 34	msf/msgsvc/msg_svc$PbBindUinMsgReadedConfirmResp:<init>	()V
    //   34: astore 8
    //   36: iload 5
    //   38: istore 4
    //   40: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +23 -> 66
    //   46: iload 5
    //   48: istore 4
    //   50: ldc 42
    //   52: iconst_2
    //   53: aload_3
    //   54: checkcast 44	[B
    //   57: checkcast 44	[B
    //   60: invokestatic 49	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   63: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: iload 5
    //   68: istore 4
    //   70: aload 8
    //   72: aload_3
    //   73: checkcast 44	[B
    //   76: checkcast 44	[B
    //   79: invokevirtual 57	msf/msgsvc/msg_svc$PbBindUinMsgReadedConfirmResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   82: checkcast 31	msf/msgsvc/msg_svc$PbBindUinMsgReadedConfirmResp
    //   85: astore_3
    //   86: iload 5
    //   88: istore 4
    //   90: aload_3
    //   91: getfield 61	msf/msgsvc/msg_svc$PbBindUinMsgReadedConfirmResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   94: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   97: istore 5
    //   99: iload 5
    //   101: istore 4
    //   103: aload_3
    //   104: getfield 71	msf/msgsvc/msg_svc$PbBindUinMsgReadedConfirmResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   107: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   110: ifeq +18 -> 128
    //   113: iload 5
    //   115: istore 4
    //   117: aload_3
    //   118: getfield 71	msf/msgsvc/msg_svc$PbBindUinMsgReadedConfirmResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   121: invokevirtual 79	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   124: invokevirtual 85	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   127: astore_2
    //   128: aload_3
    //   129: getfield 89	msf/msgsvc/msg_svc$PbBindUinMsgReadedConfirmResp:errmsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   132: invokevirtual 92	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   135: ifeq +213 -> 348
    //   138: aload_3
    //   139: getfield 89	msf/msgsvc/msg_svc$PbBindUinMsgReadedConfirmResp:errmsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   142: invokevirtual 95	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   145: astore_3
    //   146: iload 5
    //   148: istore 4
    //   150: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +81 -> 234
    //   156: new 97	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   163: ldc 100
    //   165: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: astore 8
    //   170: aload_1
    //   171: ifnonnull +114 -> 285
    //   174: ldc 106
    //   176: astore_1
    //   177: aload 8
    //   179: aload_1
    //   180: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: ldc 111
    //   185: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: iload 4
    //   190: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: ldc 116
    //   195: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: astore 8
    //   200: aload_2
    //   201: ifnonnull +95 -> 296
    //   204: ldc 106
    //   206: astore_1
    //   207: ldc 118
    //   209: iconst_2
    //   210: aload 8
    //   212: aload_1
    //   213: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc 120
    //   218: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_3
    //   222: invokestatic 126	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   225: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: iload 4
    //   236: ifeq +68 -> 304
    //   239: aload_0
    //   240: sipush 8011
    //   243: iconst_0
    //   244: iconst_2
    //   245: anewarray 122	java/lang/String
    //   248: dup
    //   249: iconst_0
    //   250: aload 7
    //   252: aastore
    //   253: dup
    //   254: iconst_1
    //   255: aload 6
    //   257: aastore
    //   258: invokevirtual 132	com/tencent/mobileqq/app/message/SubAccountMessageProcessor:a	(IZLjava/lang/Object;)V
    //   261: return
    //   262: astore_3
    //   263: aconst_null
    //   264: astore_2
    //   265: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +12 -> 280
    //   271: ldc 118
    //   273: iconst_2
    //   274: ldc 134
    //   276: aload_3
    //   277: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   280: aconst_null
    //   281: astore_3
    //   282: goto -132 -> 150
    //   285: aload_1
    //   286: invokevirtual 141	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   289: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   292: astore_1
    //   293: goto -116 -> 177
    //   296: aload_2
    //   297: invokestatic 49	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   300: astore_1
    //   301: goto -94 -> 207
    //   304: invokestatic 151	com/tencent/mobileqq/subaccount/SubAccountAssistantImpl:a	()Lcom/tencent/mobileqq/subaccount/SubAccountAssistantImpl;
    //   307: aload_0
    //   308: getfield 154	com/tencent/mobileqq/app/message/SubAccountMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   311: aload 7
    //   313: aload_2
    //   314: invokevirtual 157	com/tencent/mobileqq/subaccount/SubAccountAssistantImpl:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;[B)V
    //   317: aload_0
    //   318: sipush 8011
    //   321: iconst_1
    //   322: iconst_2
    //   323: anewarray 122	java/lang/String
    //   326: dup
    //   327: iconst_0
    //   328: aload 7
    //   330: aastore
    //   331: dup
    //   332: iconst_1
    //   333: aload 6
    //   335: aastore
    //   336: invokevirtual 132	com/tencent/mobileqq/app/message/SubAccountMessageProcessor:a	(IZLjava/lang/Object;)V
    //   339: return
    //   340: astore_3
    //   341: iload 5
    //   343: istore 4
    //   345: goto -80 -> 265
    //   348: aconst_null
    //   349: astore_3
    //   350: goto -204 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	this	SubAccountMessageProcessor
    //   0	353	1	paramToServiceMsg	ToServiceMsg
    //   0	353	2	paramFromServiceMsg	FromServiceMsg
    //   0	353	3	paramObject	Object
    //   38	306	4	i	int
    //   23	319	5	j	int
    //   9	325	6	str1	String
    //   20	309	7	str2	String
    //   34	177	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   40	46	262	java/lang/Exception
    //   50	66	262	java/lang/Exception
    //   70	86	262	java/lang/Exception
    //   90	99	262	java/lang/Exception
    //   103	113	262	java/lang/Exception
    //   117	128	262	java/lang/Exception
    //   128	146	340	java/lang/Exception
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount cmd =  CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handleGetSubC2CMessageResp_PB end");
      QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB ");
    }
    SubAccountBackProtocData localSubAccountBackProtocData = new SubAccountBackProtocData();
    String str1 = paramToServiceMsg.extraData.getString("subAccount");
    String str2 = paramToServiceMsg.getUin();
    localSubAccountBackProtocData.b = str2;
    localSubAccountBackProtocData.c = str1;
    Object localObject1 = new msg_svc.PbGetMsgResp();
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("printPBuffer", 2, HexUtil.a((byte[])paramObject));
      }
      paramObject = (msg_svc.PbGetMsgResp)((msg_svc.PbGetMsgResp)localObject1).mergeFrom((byte[])paramObject);
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "subaccount <---handleGetSubC2CMessageResp_PB : decode pb:", paramObject);
        }
        paramObject = null;
        continue;
        localObject1 = Integer.valueOf(paramToServiceMsg.getRequestSsoSeq());
        continue;
        localObject1 = Integer.valueOf(paramObject.result.get());
        continue;
        localObject1 = Boolean.valueOf(paramObject.sync_cookie.has());
      }
      if (!paramObject.result.has()) {
        break label354;
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("subaccount <---handleGetSubC2CMessageResp_PB ssoSeq:");
      if (paramToServiceMsg == null)
      {
        localObject1 = "null";
        localStringBuilder = localStringBuilder.append(localObject1).append(" msgStruct.cReplyCode: ");
        if (paramObject != null) {
          break label304;
        }
        localObject1 = "null";
        localStringBuilder = localStringBuilder.append(localObject1).append(",hasSyncCookie:");
        if (paramObject != null) {
          break label319;
        }
        localObject1 = "null";
        QLog.d("Q.msg.BaseMessageProcessor", 2, localObject1);
      }
    }
    else
    {
      if (paramObject != null) {
        break label334;
      }
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("param_FailCode", "12014");
      paramToServiceMsg.put("fail_step", "getmsgresp_null");
      paramToServiceMsg.put("fail_location", "MessageHandler");
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBGetMsg", false, 0L, 0L, paramToServiceMsg, "");
      a(8003, false, localSubAccountBackProtocData);
      return;
    }
    label304:
    label319:
    label334:
    label354:
    int i;
    if (paramObject.result.get() != 0)
    {
      i = paramObject.result.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB rspResult = " + i);
      }
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("param_FailCode", "12015");
      paramToServiceMsg.put("fail_step", "result_" + i);
      paramToServiceMsg.put("fail_location", "MessageHandler");
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBGetMsg", false, 0L, 0L, paramToServiceMsg, "");
      if (i <= 100) {
        break label4428;
      }
      i -= 100;
    }
    label693:
    label1718:
    label2617:
    label3395:
    label3403:
    label4428:
    for (;;)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB really rspResult = " + i);
        }
        long l1;
        switch (i)
        {
        default: 
          if ((i == 1200) || (i == 1214) || (i == 1215) || (i == 1218) || (i == 1232) || (i == 1233) || (i == 1240) || (i == 1241) || (i == 1242) || (i == 1221))
          {
            localSubAccountBackProtocData.p = 1004;
            localSubAccountBackProtocData.q = i;
            localSubAccountBackProtocData.jdField_a_of_type_JavaLangString = paramObject.errmsg.get();
            paramToServiceMsg = SubAccountAssistantImpl.a().a();
            paramFromServiceMsg = SubAccountAssistantImpl.a();
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            l1 = Long.parseLong(str1);
            if (paramToServiceMsg == null)
            {
              paramToServiceMsg = null;
              paramFromServiceMsg.a((QQAppInterface)localObject1, (byte)0, l1, paramToServiceMsg, 21);
              SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, null);
              SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, i, paramObject.errmsg.get());
              SubAccountAssistantImpl.a().b(str1);
              SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, System.currentTimeMillis() / 1000L);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateSubAccountLogin(str1, false);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().refreAccountList();
            }
          }
          break;
        }
        for (;;)
        {
          a(8003, false, localSubAccountBackProtocData);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB getMsgResp == null || !getMsgResp.result.has() || getMsgResp.result.get() != 0 ");
          return;
          localSubAccountBackProtocData.p = 1008;
          SubAccountAssistantImpl.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          continue;
          localSubAccountBackProtocData.p = 1002;
          try
          {
            SubAccountAssistantImpl.a().a();
            SubAccountAssistantImpl.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
          }
          catch (Exception paramToServiceMsg)
          {
            for (;;)
            {
              paramToServiceMsg.printStackTrace();
            }
          }
          localSubAccountBackProtocData.p = 1006;
          continue;
          paramToServiceMsg = HexUtil.a(paramToServiceMsg);
          break label693;
          localSubAccountBackProtocData.p = 1000;
        }
        localObject1 = paramFromServiceMsg.getUin();
        long l2 = -1L;
        try
        {
          l1 = Long.parseLong(str1);
          if (localObject1 == null)
          {
            a(8003, false, localSubAccountBackProtocData);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB tmpBackUin == null ");
            }
            paramToServiceMsg = new HashMap();
            paramToServiceMsg.put("param_FailCode", "12014");
            paramToServiceMsg.put("fail_step", "backuin_null");
            paramToServiceMsg.put("fail_location", "MessageHandler");
            StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBGetMsg", false, 0L, 0L, paramToServiceMsg, "");
            return;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            localException1.printStackTrace();
            l1 = l2;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB subAccount parselong error ");
              l1 = l2;
              continue;
              try
              {
                l2 = Long.valueOf(paramFromServiceMsg.getUin()).longValue();
                if (l2 == -1L)
                {
                  a(8003, false, localSubAccountBackProtocData);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB selfUin == -1 ");
                  }
                  paramToServiceMsg = new HashMap();
                  paramToServiceMsg.put("param_FailCode", "12014");
                  paramToServiceMsg.put("fail_step", "selfUin_null");
                  paramToServiceMsg.put("fail_location", "MessageHandler");
                  StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBGetMsg", false, 0L, 0L, paramToServiceMsg, "");
                  return;
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB selfUin parselong error ");
                  }
                  l2 = -1L;
                }
                if (paramObject.sync_cookie.has()) {}
                for (localObject1 = paramObject.sync_cookie.get().toByteArray();; localObject1 = null)
                {
                  if (paramObject.sync_flag.has()) {}
                  for (int j = paramObject.sync_flag.get();; j = 2)
                  {
                    byte b;
                    int k;
                    if (j < 2)
                    {
                      b = (byte)1;
                      k = 0;
                    }
                    for (;;)
                    {
                      if (paramObject.bind_uin.has()) {}
                      for (long l3 = paramObject.bind_uin.get();; l3 = 0L)
                      {
                        List localList1 = SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l3));
                        ArrayList localArrayList = paramToServiceMsg.extraData.getStringArrayList("hadGetMsgListUin");
                        if (localArrayList == null) {
                          localArrayList = new ArrayList();
                        }
                        for (;;)
                        {
                          List localList2 = paramObject.uin_pair_msgs.get();
                          int m = 0;
                          long l5;
                          long l4;
                          int n;
                          boolean bool1;
                          Object localObject2;
                          int i1;
                          label1905:
                          StringBuffer localStringBuffer;
                          label2028:
                          MessageRecord localMessageRecord;
                          Object localObject3;
                          if (m < localList2.size())
                          {
                            paramFromServiceMsg = (msg_comm.UinPairMsg)localList2.get(m);
                            l5 = paramFromServiceMsg.peer_uin.get();
                            l4 = paramFromServiceMsg.last_read_time.get();
                            paramObject = paramFromServiceMsg.msg.get();
                            n = paramFromServiceMsg.unread_msg_num.get();
                            if (QLog.isColorLevel()) {
                              QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUi cc n:" + l5);
                            }
                            if ((paramObject == null) || (paramObject.size() == 0) || (n == 0))
                            {
                              if (QLog.isColorLevel()) {
                                QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB msgList == null || msgList.size() == 0 msg is null " + l5);
                              }
                              if (localList1 != null)
                              {
                                paramFromServiceMsg = localList1.iterator();
                                while (paramFromServiceMsg.hasNext())
                                {
                                  paramObject = (SubAccountMessage)paramFromServiceMsg.next();
                                  if (paramObject != null)
                                  {
                                    paramObject = paramObject.frienduin;
                                    if ((paramObject != null) && (paramObject.equalsIgnoreCase(String.valueOf(l5)))) {
                                      localArrayList.add(String.valueOf(l5));
                                    }
                                  }
                                }
                              }
                            }
                            DecodeProtoPkgContext localDecodeProtoPkgContext;
                            do
                            {
                              m += 1;
                              break;
                              if (QLog.isColorLevel()) {
                                QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUin:" + l5 + ",msgList size:" + paramObject.size());
                              }
                              localDecodeProtoPkgContext = new DecodeProtoPkgContext(l1, l5, false, false, false, true);
                            } while ((paramObject == null) || (paramObject.size() <= 0));
                            Collections.sort(paramObject, new fjt(this));
                            msg_comm.MsgHead localMsgHead;
                            if ((paramFromServiceMsg.msg_completed.has()) && (paramFromServiceMsg.msg_completed.get() != 0))
                            {
                              bool1 = true;
                              if (QLog.isColorLevel()) {
                                QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUin:" + l5 + "msgList size: " + paramObject.size() + ",uMsgCompleted:" + bool1 + ",lastReadTime:" + (l4 & 0xFFFFFFFF));
                              }
                              Iterator localIterator1 = paramObject.iterator();
                              break label1841;
                              break label1841;
                              do
                              {
                                if (!localIterator1.hasNext()) {
                                  break;
                                }
                                localObject2 = (msg_comm.Msg)localIterator1.next();
                              } while (localObject2 == null);
                              localMsgHead = (msg_comm.MsgHead)((msg_comm.Msg)localObject2).msg_head.get();
                              i = localMsgHead.msg_type.get();
                              paramObject = null;
                              i1 = ((msg_comm.MsgHead)((msg_comm.Msg)localObject2).msg_head.get()).c2c_cmd.get();
                              if ((193 != i) && (734 != i)) {
                                break label2028;
                              }
                              if (l1 != l5) {
                                break label1905;
                              }
                              paramFromServiceMsg = paramObject;
                            }
                            for (;;)
                            {
                              if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() != 0)) {
                                break label2304;
                              }
                              if (localList1 == null) {
                                break label1718;
                              }
                              paramFromServiceMsg = localList1.iterator();
                              if (!paramFromServiceMsg.hasNext()) {
                                break label1718;
                              }
                              paramObject = (SubAccountMessage)paramFromServiceMsg.next();
                              if (paramObject == null) {
                                break label1717;
                              }
                              paramObject = paramObject.frienduin;
                              if ((paramObject == null) || (!paramObject.equalsIgnoreCase(String.valueOf(l5)))) {
                                break label1717;
                              }
                              localArrayList.add(String.valueOf(l5));
                              break label1718;
                              bool1 = false;
                              break;
                              paramFromServiceMsg = new ArrayList();
                              paramObject = MessageRecordFactory.a(193);
                              paramObject.selfuin = String.valueOf(l1);
                              paramObject.frienduin = String.valueOf(l5);
                              paramObject.senderuin = String.valueOf(l5);
                              paramObject.shmsgseq = localMsgHead.msg_seq.get();
                              paramObject.msgUid = localMsgHead.msg_uid.get();
                              paramObject.time = localMsgHead.msg_time.get();
                              paramObject.istroop = 0;
                              paramObject.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131561553);
                              paramObject.msgtype = 193;
                              paramFromServiceMsg.add(paramObject);
                              continue;
                              if ((MessageUtils.c(i)) && (localMsgHead.c2c_cmd.has()) && ((i1 == 169) || (i1 == 241) || (i1 == 242) || (i1 == 243) || (i1 == 129) || (i1 == 131) || (i1 == 133)))
                              {
                                if ((i1 == 129) || (i1 == 131) || (i1 == 133) || (i1 == 135) || (i1 == 243)) {
                                  break label1718;
                                }
                                paramObject = MessageRecordFactory.a(-2005);
                                paramObject.selfuin = String.valueOf(l1);
                                paramObject.frienduin = String.valueOf(l5);
                                paramObject.senderuin = String.valueOf(l5);
                                paramObject.shmsgseq = localMsgHead.msg_seq.get();
                                paramObject.msgUid = localMsgHead.msg_uid.get();
                                paramObject.time = localMsgHead.msg_time.get();
                                paramObject.istroop = 0;
                                paramObject.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131561539);
                                paramObject.msgtype = -2005;
                                paramFromServiceMsg = new ArrayList();
                                paramFromServiceMsg.add(paramObject);
                                continue;
                              }
                              try
                              {
                                paramFromServiceMsg = a((msg_comm.Msg)localObject2, localDecodeProtoPkgContext);
                              }
                              catch (Exception localException2)
                              {
                                paramFromServiceMsg = paramObject;
                              }
                              if (QLog.isColorLevel())
                              {
                                QLog.w("Q.msg.BaseMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException2);
                                paramFromServiceMsg = paramObject;
                              }
                            }
                            localStringBuffer = new StringBuffer();
                            localMessageRecord = (MessageRecord)paramFromServiceMsg.get(0);
                            l4 = localMessageRecord.time;
                            Iterator localIterator2 = paramFromServiceMsg.iterator();
                            bool1 = false;
                            for (;;)
                            {
                              if (localIterator2.hasNext())
                              {
                                localObject3 = (MessageRecord)localIterator2.next();
                                if (localObject3 != null)
                                {
                                  paramObject = ((MessageRecord)localObject3).msg;
                                  if (paramObject == null) {
                                    break;
                                  }
                                }
                              }
                            }
                          }
                          for (;;)
                          {
                            try
                            {
                              if (QLog.isColorLevel()) {
                                QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount handleGetSubC2CMessageResp_PB  basemsg  = ");
                              }
                              if (((MessageRecord)localObject3).frienduin == null) {
                                break label2343;
                              }
                              if (String.valueOf(AppConstants.U).equalsIgnoreCase(((MessageRecord)localObject3).frienduin))
                              {
                                paramFromServiceMsg = SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject, ((MessageRecord)localObject3).msgtype, ((MessageRecord)localObject3).senderuin);
                                if (paramFromServiceMsg == null)
                                {
                                  i = 1;
                                  if ((localStringBuffer != null) && (localStringBuffer.length() != 0)) {
                                    break label3208;
                                  }
                                  if (!QLog.isColorLevel()) {
                                    break label1718;
                                  }
                                  QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount <---handleGetSubC2CMessageResp_PB show == null || show.length() == 0; msg is not decode success.");
                                }
                              }
                            }
                            catch (Exception paramFromServiceMsg)
                            {
                              paramFromServiceMsg.printStackTrace();
                              continue;
                              localStringBuffer.append(paramFromServiceMsg);
                              i = 1;
                              continue;
                              switch (((MessageRecord)localObject3).msgtype)
                              {
                              }
                            }
                            try
                            {
                              if (!ActionMsgUtil.a(((MessageRecord)localObject3).msgtype)) {
                                break label3036;
                              }
                              localObject3 = ActionMsgUtil.a(((MessageRecord)localObject3).msg);
                              paramFromServiceMsg = paramObject;
                              if (localObject3 != null)
                              {
                                if ((((MsgBody)localObject3).actMsgContentValue == null) || (((MsgBody)localObject3).actMsgContentValue.length() <= 0)) {
                                  break label2964;
                                }
                                paramFromServiceMsg = ((MsgBody)localObject3).actMsgContentValue;
                              }
                            }
                            catch (Exception localException3)
                            {
                              for (;;)
                              {
                                paramObject = null;
                                localException3.printStackTrace();
                                paramFromServiceMsg = paramObject;
                                if (QLog.isColorLevel())
                                {
                                  QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount handlerMsgPB, MSG_TYPE_PUBLIC_ACCOUNT error e = " + localException3.getMessage());
                                  paramFromServiceMsg = paramObject;
                                }
                              }
                            }
                            paramObject = paramFromServiceMsg;
                            if (paramFromServiceMsg == null) {
                              paramObject = "";
                            }
                            localStringBuffer.append(paramObject);
                            break label2343;
                            if ((localObject3 instanceof MessageForStructing))
                            {
                              paramFromServiceMsg = (MessageForStructing)localObject3;
                              if (paramFromServiceMsg.structingMsg == null) {}
                            }
                            for (paramFromServiceMsg = paramFromServiceMsg.structingMsg.mMsgBrief;; paramFromServiceMsg = paramObject)
                            {
                              for (;;)
                              {
                                if (!TextUtils.isEmpty(paramFromServiceMsg)) {
                                  break label4384;
                                }
                                paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131562979);
                                break;
                                paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131561544);
                                break;
                                paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131561539);
                                break;
                                paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131561555);
                                break;
                                paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131561548);
                                break;
                                paramFromServiceMsg = paramObject;
                                if (!(localObject3 instanceof MessageForPubAccount)) {
                                  break label3205;
                                }
                                if ("2010741172".equals(localMessageRecord.senderuin)) {
                                  bool1 = true;
                                }
                                try
                                {
                                  paramObject = ((MessageForPubAccount)localObject3).mPAMessage;
                                  if (paramObject == null)
                                  {
                                    paramFromServiceMsg = null;
                                    break;
                                  }
                                  paramFromServiceMsg = ((PAMessage.Item)paramObject.items.get(0)).title;
                                  if ((((PAMessage.Item)paramObject.items.get(0)).cover == null) && (((PAMessage.Item)paramObject.items.get(0)).digestList != null)) {
                                    paramFromServiceMsg = paramFromServiceMsg + "：" + (String)((PAMessage.Item)paramObject.items.get(0)).digestList.get(0);
                                  }
                                  for (;;)
                                  {
                                    break;
                                  }
                                }
                                catch (Exception paramObject)
                                {
                                  paramFromServiceMsg = null;
                                  paramObject.printStackTrace();
                                  if (QLog.isColorLevel()) {
                                    QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount handlerMsgPB, MSG_TYPE_PUBLIC_ACCOUNT error e = " + paramObject.getMessage());
                                  }
                                }
                              }
                              paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppShareIDUtil.a(((MsgBody)localObject3).shareAppID));
                              paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131563302) + paramFromServiceMsg.messagetail + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562904);
                              break label2617;
                              label3036:
                              paramFromServiceMsg = paramObject;
                              if (ActionMsgUtil.b(((MessageRecord)localObject3).msgtype)) {
                                break label2617;
                              }
                              paramFromServiceMsg = paramObject;
                              if (((MessageRecord)localObject3).msg == null) {
                                break label2617;
                              }
                              paramFromServiceMsg = paramObject;
                              if (((MessageRecord)localObject3).msg.indexOf("http://maps.google.com/maps?q=") == -1) {
                                break label2617;
                              }
                              localObject3 = QQMessageFacade.a(((MessageRecord)localObject3).msg);
                              paramObject = "";
                              paramFromServiceMsg = paramObject;
                              if (localObject3 != null)
                              {
                                paramFromServiceMsg = paramObject;
                                if (localObject3[2] != null) {
                                  paramFromServiceMsg = localObject3[2];
                                }
                              }
                              paramFromServiceMsg = "[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562304) + "] " + paramFromServiceMsg;
                              break label2617;
                              if ((localList1 != null) && (i == 0))
                              {
                                paramFromServiceMsg = localList1.iterator();
                                while (paramFromServiceMsg.hasNext())
                                {
                                  paramObject = (SubAccountMessage)paramFromServiceMsg.next();
                                  if (paramObject != null)
                                  {
                                    paramObject = paramObject.frienduin;
                                    if ((paramObject != null) && (paramObject.equalsIgnoreCase(String.valueOf(l5)))) {
                                      localArrayList.add(String.valueOf(l5));
                                    }
                                  }
                                }
                              }
                              paramFromServiceMsg = (msg_comm.MsgHead)((msg_comm.Msg)localObject2).msg_head.get();
                              if ((paramFromServiceMsg != null) && (paramFromServiceMsg.from_nick.has())) {}
                              for (paramFromServiceMsg = paramFromServiceMsg.from_nick.get();; paramFromServiceMsg = null)
                              {
                                if (i != 0) {
                                  paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131562249);
                                }
                                if (QLog.isColorLevel()) {
                                  QLog.d("Q.msg.BaseMessageProcessor", 2, "sub.account.msg isQQMail=" + bool1);
                                }
                                localObject2 = new SubAccountMessage();
                                boolean bool2;
                                if (i != 0)
                                {
                                  ((SubAccountMessage)localObject2).frienduin = String.valueOf(AppConstants.U);
                                  if (!bool1) {
                                    break label3971;
                                  }
                                  bool2 = true;
                                  ((SubAccountMessage)localObject2).isread = bool2;
                                  ((SubAccountMessage)localObject2).msg = localStringBuffer.toString();
                                  ((SubAccountMessage)localObject2).extInt = localMessageRecord.extInt;
                                  ((SubAccountMessage)localObject2).extLong = localMessageRecord.extLong;
                                  ((SubAccountMessage)localObject2).extraflag = localMessageRecord.extraflag;
                                  ((SubAccountMessage)localObject2).extStr = localMessageRecord.extStr;
                                  ((SubAccountMessage)localObject2).istroop = localMessageRecord.istroop;
                                  ((SubAccountMessage)localObject2).isValid = localMessageRecord.isValid;
                                  ((SubAccountMessage)localObject2).longMsgCount = localMessageRecord.longMsgCount;
                                  ((SubAccountMessage)localObject2).longMsgId = localMessageRecord.longMsgId;
                                  ((SubAccountMessage)localObject2).longMsgIndex = localMessageRecord.longMsgIndex;
                                  ((SubAccountMessage)localObject2).msgUid = localMessageRecord.msgUid;
                                  ((SubAccountMessage)localObject2).shmsgseq = localMessageRecord.shmsgseq;
                                  ((SubAccountMessage)localObject2).uniseq = localMessageRecord.uniseq;
                                  ((SubAccountMessage)localObject2).msgseq = localMessageRecord.msgseq;
                                  if (!bool1) {
                                    break label3977;
                                  }
                                  i = 0;
                                  label3558:
                                  ((SubAccountMessage)localObject2).unreadNum = i;
                                  ((SubAccountMessage)localObject2).msgtype = -1000;
                                  ((SubAccountMessage)localObject2).selfuin = String.valueOf(l2);
                                  if (paramFromServiceMsg != null)
                                  {
                                    paramObject = paramFromServiceMsg;
                                    if (paramFromServiceMsg.length() != 0) {}
                                  }
                                  else
                                  {
                                    paramObject = ((SubAccountMessage)localObject2).frienduin;
                                  }
                                  ((SubAccountMessage)localObject2).sendername = paramObject;
                                  ((SubAccountMessage)localObject2).senderuin = String.valueOf(l5);
                                  if (l4 != 0L) {
                                    break label3984;
                                  }
                                  l4 = System.currentTimeMillis() / 1000L;
                                }
                                for (;;)
                                {
                                  ((SubAccountMessage)localObject2).time = l4;
                                  SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SubAccountMessage)localObject2, String.valueOf(l3));
                                  DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
                                  if (QLog.isColorLevel())
                                  {
                                    QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount set msg read false hasData = false  unreadNum=" + ((SubAccountMessage)localObject2).unreadNum);
                                    if (!TextUtils.isEmpty(((SubAccountMessage)localObject2).msg)) {
                                      QLog.d("Q.msg.BaseMessageProcessor", 2, "msg=" + ((SubAccountMessage)localObject2).msg.charAt(0));
                                    }
                                  }
                                  paramFromServiceMsg = MessageRecordFactory.a(localMessageRecord.msgtype);
                                  MessageRecord.copyMessageRecordBaseField(paramFromServiceMsg, localMessageRecord);
                                  paramFromServiceMsg.istroop = 7000;
                                  paramFromServiceMsg.frienduin = AppConstants.O;
                                  i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFromServiceMsg.frienduin, paramFromServiceMsg.istroop);
                                  i1 = SubAccountDataControll.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                                  int i2 = i1 - i;
                                  if (i2 != 0) {
                                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramFromServiceMsg.frienduin, paramFromServiceMsg.istroop, i2);
                                  }
                                  if (QLog.isColorLevel()) {
                                    QLog.d("Q.msg.BaseMessageProcessor", 2, "sub.account.msg conversion target=" + i1 + " old=" + i + " increase=" + i2);
                                  }
                                  paramObject = new ArrayList();
                                  paramObject.add(paramFromServiceMsg);
                                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramObject, str2, false, false, true);
                                  if (bool1) {
                                    break label1718;
                                  }
                                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramObject.size(), true, true);
                                  break label1718;
                                  break;
                                  ((SubAccountMessage)localObject2).frienduin = String.valueOf(l5);
                                  break label3395;
                                  bool2 = false;
                                  break label3403;
                                  i = n;
                                  break label3558;
                                }
                                if ((localList1 != null) && (localList1.size() > 0) && (k != 0))
                                {
                                  if (QLog.isColorLevel()) {
                                    QLog.d("Q.msg.BaseMessageProcessor", 2, "handleGetSubC2CMessageResp_PB dbSubMsgList......");
                                  }
                                  i = 0;
                                  if (i < localList1.size())
                                  {
                                    paramFromServiceMsg = (SubAccountMessage)localList1.get(i);
                                    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.frienduin != null)) {}
                                  }
                                }
                                for (;;)
                                {
                                  label4061:
                                  i += 1;
                                  break label4025;
                                  if (!paramFromServiceMsg.frienduin.equals(String.valueOf(AppConstants.U)))
                                  {
                                    paramObject = localArrayList.iterator();
                                    do
                                    {
                                      if (!paramObject.hasNext()) {
                                        break;
                                      }
                                      str2 = (String)paramObject.next();
                                    } while ((str2 == null) || (!paramFromServiceMsg.frienduin.equalsIgnoreCase(str2)));
                                    for (k = 1;; k = 0)
                                    {
                                      if (k != 0) {
                                        break label4377;
                                      }
                                      SubAccountAssistantImpl.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l3), paramFromServiceMsg.frienduin);
                                      break label4061;
                                      if (QLog.isColorLevel())
                                      {
                                        if (localObject1 == null) {
                                          break label4314;
                                        }
                                        QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount handleGetSubC2CMessageResp_PB  cookie = ");
                                      }
                                      for (;;)
                                      {
                                        SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, (byte[])localObject1);
                                        paramFromServiceMsg = new HashMap();
                                        paramFromServiceMsg.put("param_FailCode", "12016");
                                        paramFromServiceMsg.put("fail_step", "success");
                                        paramFromServiceMsg.put("fail_location", "MessageHandler");
                                        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBGetMsg", true, 0L, 0L, paramFromServiceMsg, "");
                                        if (b <= 0) {
                                          break label4341;
                                        }
                                        if (l3 <= 0L) {
                                          break;
                                        }
                                        paramToServiceMsg = paramToServiceMsg.extraData.getString("subaccount_a2");
                                        if (paramToServiceMsg == null) {
                                          break label4341;
                                        }
                                        a(b, j, String.valueOf(l3), paramToServiceMsg, localArrayList);
                                        localSubAccountBackProtocData.jdField_a_of_type_Boolean = false;
                                        a(8003, true, localSubAccountBackProtocData);
                                        return;
                                        label4314:
                                        QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount handleGetSubC2CMessageResp_PB  cookie = null");
                                      }
                                      if (QLog.isColorLevel()) {
                                        QLog.e("Q.msg.BaseMessageProcessor", 2, "subaccount handleGetSubC2CMessageResp_PB error happen, binduin <= 0 from server");
                                      }
                                      label4341:
                                      localSubAccountBackProtocData.p = 0;
                                      a(8003, true, localSubAccountBackProtocData);
                                      if (!QLog.isColorLevel()) {
                                        break;
                                      }
                                      QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB end");
                                      return;
                                    }
                                  }
                                }
                              }
                              break label2617;
                            }
                            i = 0;
                          }
                        }
                      }
                      k = 1;
                      b = 0;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(byte paramByte, int paramInt, String paramString1, String paramString2, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount start get subaccount in getSubAccoundMsg_PB");
    }
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("MessageSvc.PbBindUinGetMsg");
    localToServiceMsg.extraData.putByte("cChannel", paramByte);
    localToServiceMsg.extraData.putInt("cSyncFlag", paramInt);
    localToServiceMsg.extraData.putBoolean("isSubAccount", true);
    localToServiceMsg.extraData.putString("subAccount", paramString1);
    localToServiceMsg.extraData.putString("subaccount_a2", paramString2);
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      localToServiceMsg.extraData.putStringArrayList("hadGetMsgListUin", paramArrayList);
    }
    paramArrayList = SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    msg_svc.PbBindUinGetMsgReq localPbBindUinGetMsgReq = new msg_svc.PbBindUinGetMsgReq();
    if (paramString1 != null) {}
    try
    {
      localPbBindUinGetMsgReq.bind_uin.set(Long.parseLong(paramString1));
      if (paramString2 == null) {}
    }
    catch (Exception paramString1)
    {
      try
      {
        do
        {
          localPbBindUinGetMsgReq.bind_uin_sig.set(ByteStringMicro.copyFrom(PkgTools.a(paramString2)));
          if (paramArrayList == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount getSubAccoundMsg_PB  cookie = " + PkgTools.b(paramArrayList));
          }
          localPbBindUinGetMsgReq.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayList));
          localPbBindUinGetMsgReq.sync_flag.set(paramInt);
          localToServiceMsg.putWupBuffer(localPbBindUinGetMsgReq.toByteArray());
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(localToServiceMsg);
          return;
          paramString1 = paramString1;
          paramString1.printStackTrace();
        } while (!QLog.isColorLevel());
        QLog.e("Q.msg.BaseMessageProcessor", 2, "getSubAccoundMsg_PB subAccount is null or not a long");
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount getSubAccoundMsg_PB  cookie = null");
          }
        }
      }
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount cmd =  CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handlerGetSubAccountError end");
    }
    paramFromServiceMsg = new SubAccountBackProtocData();
    String str = paramToServiceMsg.extraData.getString("subAccount");
    paramFromServiceMsg.b = paramToServiceMsg.getUin();
    paramFromServiceMsg.c = str;
    paramFromServiceMsg.p = 1001;
    a(8003, false, paramFromServiceMsg);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "confirmSubAccountMsgNumReaded..subAccount=" + paramString1);
    }
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("PbMessageSvc.PbBindUinMsgReadedConfirm");
    localToServiceMsg.extraData.putBoolean("isSubAccount", true);
    localToServiceMsg.extraData.putString("subAccount", paramString1);
    localToServiceMsg.extraData.putString("nextAction", paramString2);
    paramString1 = SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramString2 = new msg_svc.PbBindUinMsgReadedConfirmReq();
    if (paramString1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "confirmSubAccountMsgNumReaded getSubAccoundMsg_PB  syncCookie= " + PkgTools.b(paramString1));
      }
      paramString2.sync_cookie.set(ByteStringMicro.copyFrom(paramString1));
    }
    for (;;)
    {
      localToServiceMsg.putWupBuffer(paramString2.toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(localToServiceMsg);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "confirmSubAccountMsgNumReaded getSubAccoundMsg_PB  cookie = null");
      }
    }
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "subaccount cmd =  CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handlerGetSubAccountTimeout end");
    }
    paramFromServiceMsg = new SubAccountBackProtocData();
    String str = paramToServiceMsg.extraData.getString("subAccount");
    paramFromServiceMsg.b = paramToServiceMsg.getUin();
    paramFromServiceMsg.c = str;
    paramFromServiceMsg.p = 1007;
    a(8003, false, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.SubAccountMessageProcessor
 * JD-Core Version:    0.7.0.1
 */