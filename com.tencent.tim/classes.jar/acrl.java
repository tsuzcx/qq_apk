import ActionMsg.MsgBody;
import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import PushNotifyPack.RequestPushNotify;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbBindUinGetMsgReq;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmReq;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmResp;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumReq;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumResp;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo;
import msf.msgsvc.msg_svc.PbUnReadMsgSeqReq;
import msf.msgsvc.msg_svc.PbUnReadMsgSeqResp;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import oicq.wlogin_sdk.request.Ticket;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.ReqBody;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.ReqBody;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class acrl
  extends tob
{
  public acrl(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private void c(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    paramMsg = (msg_comm.MsgHead)paramMsg.msg_head.get();
    long l1 = paramMsg.from_uin.get();
    long l2 = paramMsg.msg_time.get();
    long l3 = paramPbPushMsg.uint64_bind_uin.get();
    if (l1 == l3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountMessageProcessor", 2, new Object[] { "processSubAccountTroopMessage fromUin = bindUin:", Long.valueOf(l3), " fromUin:", Long.valueOf(l1), " msgTime:", Long.valueOf(l2) });
      }
      return;
    }
    paramMsg = new SubAccountMessage();
    paramMsg.frienduin = String.valueOf(13002L);
    paramMsg.unreadNum = 1;
    paramMsg.msgtype = -1000;
    paramMsg.time = l2;
    paramMsg.senderuin = String.valueOf(13002L);
    paramMsg.subUin = String.valueOf(l3);
    paramMsg.istroop = 1;
    paramMsg.sendername = acfp.m(2131720593);
    paramMsg.msg = "";
    paramPbPushMsg = (anxr)this.app.getManager(61);
    if (paramPbPushMsg != null)
    {
      paramPbPushMsg.a(paramMsg);
      paramPbPushMsg.b(paramMsg);
      paramPbPushMsg.Rz(paramMsg.subUin);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, new Object[] { "processSubAccountTroopMessage bindUin:", Long.valueOf(l3), " fromUin:", Long.valueOf(l1), " msgTime:", Long.valueOf(l2) });
    }
    paramMsg = new anxs();
    paramMsg.aLa = paramFromServiceMsg.getUin();
    paramMsg.aQf = String.valueOf(l3);
    paramMsg.cKB = true;
    paramMsg.cKC = true;
    paramMsg.errorType = 0;
    b(8003, true, paramMsg);
  }
  
  private String g(MessageRecord paramMessageRecord, String paramString)
  {
    switch (paramMessageRecord.msgtype)
    {
    default: 
      paramString = e(paramMessageRecord, paramString);
    }
    do
    {
      return paramString;
      return a(paramMessageRecord, paramString);
      return b(paramMessageRecord, paramString);
      return c(paramMessageRecord, paramString);
      return this.app.getApp().getResources().getString(2131692316);
      return f(paramMessageRecord, paramString);
      return this.app.getApp().getResources().getString(2131720462);
      paramMessageRecord = (MessageForApollo)paramMessageRecord;
      paramMessageRecord.parse();
      return ApolloUtil.a(this.app, paramMessageRecord);
      return d(paramMessageRecord, paramString);
    } while (!(paramMessageRecord instanceof MessageForArkBabyqReply));
    paramMessageRecord = (MessageForArkBabyqReply)paramMessageRecord;
    paramMessageRecord.parse();
    return paramMessageRecord.babyqReplyText;
  }
  
  private void in(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1;
    if (paramToServiceMsg == null) {
      str1 = "null";
    }
    for (;;)
    {
      String str2;
      label16:
      int i;
      long l;
      Object localObject2;
      msg_svc.PbBindUinMsgReadedConfirmResp localPbBindUinMsgReadedConfirmResp;
      Object localObject1;
      int j;
      if (paramToServiceMsg == null)
      {
        str2 = "null";
        i = -1;
        l = 0L;
        localObject2 = null;
        paramFromServiceMsg = null;
        localPbBindUinMsgReadedConfirmResp = new msg_svc.PbBindUinMsgReadedConfirmResp();
        localObject1 = localObject2;
        j = i;
      }
      try
      {
        paramObject = (msg_svc.PbBindUinMsgReadedConfirmResp)localPbBindUinMsgReadedConfirmResp.mergeFrom((byte[])paramObject);
        localObject1 = localObject2;
        j = i;
        i = paramObject.result.get();
        localObject1 = localObject2;
        j = i;
        if (paramObject.sync_cookie.has())
        {
          localObject1 = localObject2;
          j = i;
          paramFromServiceMsg = paramObject.sync_cookie.get().toByteArray();
        }
        localObject1 = paramFromServiceMsg;
        j = i;
        if (paramObject.bind_uin.has())
        {
          localObject1 = paramFromServiceMsg;
          j = i;
          l = paramObject.bind_uin.get();
        }
        localObject1 = paramFromServiceMsg;
        j = i;
        if (paramObject.errmsg.has())
        {
          localObject1 = paramFromServiceMsg;
          j = i;
          paramObject = paramObject.errmsg.get();
          localObject2 = paramObject;
          localObject1 = paramFromServiceMsg;
          j = i;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder().append("handleConfirmSubAccountMsgNumReaded() subUin=").append(str2).append(" lSubUin=").append(l).append(" errMsg=").append(paramObject).append(" cookie=");
              if (paramFromServiceMsg == null)
              {
                localObject1 = "null";
                QLog.d("SUB_ACCOUNT", 2, localObject1);
                j = i;
                localObject1 = paramFromServiceMsg;
                localObject2 = paramObject;
              }
            }
            else
            {
              if (QLog.isColorLevel())
              {
                paramFromServiceMsg = new StringBuilder().append("handleConfirmSubAccountMsgNumReaded() ssoSeq:");
                if (paramToServiceMsg != null) {
                  continue;
                }
                paramToServiceMsg = "null";
                paramFromServiceMsg = paramFromServiceMsg.append(paramToServiceMsg).append(" result=").append(j).append(" syncCookie=");
                if (localObject1 != null) {
                  continue;
                }
                paramToServiceMsg = "null";
                QLog.d("SUB_ACCOUNT", 2, paramToServiceMsg + " errms=" + String.valueOf(localObject2));
              }
              boolean bool = false;
              if (j == 0)
              {
                paramToServiceMsg = (anxr)this.app.getManager(61);
                if (paramToServiceMsg != null) {
                  paramToServiceMsg.C(str2, (byte[])localObject1);
                }
                bool = true;
              }
              b(8011, bool, new String[] { str2, str1 });
              return;
              str1 = paramToServiceMsg.extraData.getString("nextAction");
              break;
              str2 = paramToServiceMsg.extraData.getString("subAccount");
              break label16;
            }
            j = paramFromServiceMsg.length;
            localObject1 = Integer.valueOf(j);
            continue;
            localException1 = localException1;
            paramObject = null;
            i = j;
            paramFromServiceMsg = (FromServiceMsg)localObject1;
          }
          catch (Exception localException2)
          {
            continue;
          }
          localObject2 = paramObject;
          localObject1 = paramFromServiceMsg;
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.e("SUB_ACCOUNT", 2, "handleConfirmSubAccountMsgNumReaded() decode pb:", localException1);
            localObject2 = paramObject;
            localObject1 = paramFromServiceMsg;
            j = i;
            continue;
            paramToServiceMsg = Integer.valueOf(paramToServiceMsg.getRequestSsoSeq());
            continue;
            paramToServiceMsg = Integer.toString(localObject1.length);
            continue;
            paramObject = null;
          }
        }
      }
    }
  }
  
  /* Error */
  private void io(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: new 151	anxs
    //   3: dup
    //   4: invokespecial 152	anxs:<init>	()V
    //   7: astore 29
    //   9: aload_1
    //   10: getfield 331	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   13: ldc_w 340
    //   16: invokevirtual 338	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 30
    //   21: aload_1
    //   22: invokevirtual 357	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   25: astore 31
    //   27: aload 29
    //   29: aload 31
    //   31: putfield 161	anxs:aLa	Ljava/lang/String;
    //   34: aload 29
    //   36: aload 30
    //   38: putfield 164	anxs:aQf	Ljava/lang/String;
    //   41: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +31 -> 75
    //   47: ldc_w 298
    //   50: iconst_2
    //   51: new 280	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 359
    //   61: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload 30
    //   66: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: new 361	msf/msgsvc/msg_svc$PbGetMsgResp
    //   78: dup
    //   79: invokespecial 362	msf/msgsvc/msg_svc$PbGetMsgResp:<init>	()V
    //   82: astore 26
    //   84: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +20 -> 107
    //   90: ldc_w 364
    //   93: iconst_2
    //   94: aload_3
    //   95: checkcast 240	[B
    //   98: checkcast 240	[B
    //   101: invokestatic 370	aqhs:bytes2HexStr	([B)Ljava/lang/String;
    //   104: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: aload 26
    //   109: aload_3
    //   110: checkcast 240	[B
    //   113: checkcast 240	[B
    //   116: invokevirtual 371	msf/msgsvc/msg_svc$PbGetMsgResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   119: checkcast 361	msf/msgsvc/msg_svc$PbGetMsgResp
    //   122: astore_3
    //   123: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +112 -> 238
    //   129: new 280	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   136: ldc_w 373
    //   139: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: astore 27
    //   144: aload_1
    //   145: ifnonnull +196 -> 341
    //   148: ldc 235
    //   150: astore 26
    //   152: aload 27
    //   154: aload 26
    //   156: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   159: ldc_w 375
    //   162: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: astore 27
    //   167: aload_3
    //   168: ifnonnull +185 -> 353
    //   171: ldc 235
    //   173: astore 26
    //   175: aload 27
    //   177: aload 26
    //   179: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   182: ldc_w 377
    //   185: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: astore 27
    //   190: aload_3
    //   191: ifnonnull +177 -> 368
    //   194: ldc 235
    //   196: astore 26
    //   198: aload 27
    //   200: aload 26
    //   202: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   205: ldc_w 379
    //   208: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: astore 27
    //   213: aload_3
    //   214: ifnonnull +169 -> 383
    //   217: ldc 235
    //   219: astore 26
    //   221: ldc_w 298
    //   224: iconst_2
    //   225: aload 27
    //   227: aload 26
    //   229: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aload_3
    //   239: ifnonnull +159 -> 398
    //   242: new 381	java/util/HashMap
    //   245: dup
    //   246: invokespecial 382	java/util/HashMap:<init>	()V
    //   249: astore_1
    //   250: aload_1
    //   251: ldc_w 384
    //   254: ldc_w 386
    //   257: invokevirtual 390	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   260: pop
    //   261: aload_1
    //   262: ldc_w 392
    //   265: ldc_w 394
    //   268: invokevirtual 390	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   271: pop
    //   272: aload_1
    //   273: ldc_w 396
    //   276: ldc_w 398
    //   279: invokevirtual 390	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   282: pop
    //   283: invokestatic 401	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   286: invokestatic 406	anpc:a	(Landroid/content/Context;)Lanpc;
    //   289: aload_0
    //   290: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   293: invokevirtual 409	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   296: ldc_w 411
    //   299: iconst_0
    //   300: lconst_0
    //   301: lconst_0
    //   302: aload_1
    //   303: ldc 126
    //   305: invokevirtual 415	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   308: aload_0
    //   309: sipush 8003
    //   312: iconst_0
    //   313: aload 29
    //   315: invokevirtual 177	acrl:b	(IZLjava/lang/Object;)V
    //   318: return
    //   319: astore_3
    //   320: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +13 -> 336
    //   326: ldc 60
    //   328: iconst_2
    //   329: ldc_w 417
    //   332: aload_3
    //   333: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   336: aconst_null
    //   337: astore_3
    //   338: goto -215 -> 123
    //   341: aload_1
    //   342: invokevirtual 353	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   345: invokestatic 345	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: astore 26
    //   350: goto -198 -> 152
    //   353: aload_3
    //   354: getfield 418	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   357: invokevirtual 47	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   360: invokestatic 345	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   363: astore 26
    //   365: goto -190 -> 175
    //   368: aload_3
    //   369: getfield 419	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   372: invokevirtual 256	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   375: invokestatic 424	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   378: astore 26
    //   380: goto -182 -> 198
    //   383: aload_3
    //   384: getfield 428	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   387: invokevirtual 431	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   390: invokestatic 345	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   393: astore 26
    //   395: goto -174 -> 221
    //   398: aload_0
    //   399: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   402: bipush 61
    //   404: invokevirtual 135	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   407: checkcast 137	anxr
    //   410: astore 32
    //   412: aload_3
    //   413: getfield 418	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   416: invokevirtual 432	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   419: ifeq +13 -> 432
    //   422: aload_3
    //   423: getfield 418	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   426: invokevirtual 47	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   429: ifeq +623 -> 1052
    //   432: aload_3
    //   433: getfield 418	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   436: invokevirtual 47	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   439: istore 5
    //   441: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   444: ifeq +31 -> 475
    //   447: ldc_w 298
    //   450: iconst_2
    //   451: new 280	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   458: ldc_w 434
    //   461: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: iload 5
    //   466: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   469: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: new 381	java/util/HashMap
    //   478: dup
    //   479: invokespecial 382	java/util/HashMap:<init>	()V
    //   482: astore_1
    //   483: aload_1
    //   484: ldc_w 384
    //   487: ldc_w 436
    //   490: invokevirtual 390	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   493: pop
    //   494: aload_1
    //   495: ldc_w 392
    //   498: new 280	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   505: ldc_w 438
    //   508: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: iload 5
    //   513: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   516: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokevirtual 390	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   522: pop
    //   523: aload_1
    //   524: ldc_w 396
    //   527: ldc_w 398
    //   530: invokevirtual 390	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   533: pop
    //   534: invokestatic 401	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   537: invokestatic 406	anpc:a	(Landroid/content/Context;)Lanpc;
    //   540: aload_0
    //   541: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   544: invokevirtual 409	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   547: ldc_w 411
    //   550: iconst_0
    //   551: lconst_0
    //   552: lconst_0
    //   553: aload_1
    //   554: ldc 126
    //   556: invokevirtual 415	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   559: iload 5
    //   561: bipush 100
    //   563: if_icmple +3970 -> 4533
    //   566: iload 5
    //   568: bipush 100
    //   570: isub
    //   571: istore 5
    //   573: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   576: ifeq +31 -> 607
    //   579: ldc_w 298
    //   582: iconst_2
    //   583: new 280	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   590: ldc_w 440
    //   593: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: iload 5
    //   598: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   601: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   607: iload 5
    //   609: lookupswitch	default:+35->644, 1:+421->1030, 1000:+370->979, 1001:+391->1000
    //   645: iconst_2
    //   646: sipush 1200
    //   649: if_icmpeq +75 -> 724
    //   652: iload 5
    //   654: sipush 1214
    //   657: if_icmpeq +67 -> 724
    //   660: iload 5
    //   662: sipush 1215
    //   665: if_icmpeq +59 -> 724
    //   668: iload 5
    //   670: sipush 1218
    //   673: if_icmpeq +51 -> 724
    //   676: iload 5
    //   678: sipush 1232
    //   681: if_icmpeq +43 -> 724
    //   684: iload 5
    //   686: sipush 1233
    //   689: if_icmpeq +35 -> 724
    //   692: iload 5
    //   694: sipush 1240
    //   697: if_icmpeq +27 -> 724
    //   700: iload 5
    //   702: sipush 1241
    //   705: if_icmpeq +19 -> 724
    //   708: iload 5
    //   710: sipush 1242
    //   713: if_icmpeq +11 -> 724
    //   716: iload 5
    //   718: sipush 1221
    //   721: if_icmpne +320 -> 1041
    //   724: aload 29
    //   726: sipush 1004
    //   729: putfield 174	anxs:errorType	I
    //   732: aload 29
    //   734: iload 5
    //   736: putfield 443	anxs:serverErrorType	I
    //   739: aload 29
    //   741: aload_3
    //   742: getfield 444	msf/msgsvc/msg_svc$PbGetMsgResp:errmsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   745: invokevirtual 278	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   748: putfield 447	anxs:errorMsg	Ljava/lang/String;
    //   751: aload 29
    //   753: iconst_1
    //   754: putfield 168	anxs:cKB	Z
    //   757: aload_0
    //   758: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   761: iconst_0
    //   762: aload 30
    //   764: invokestatic 452	anxk:a	(Lcom/tencent/mobileqq/app/QQAppInterface;BLjava/lang/String;)V
    //   767: aload_0
    //   768: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   771: aload 30
    //   773: bipush 6
    //   775: invokestatic 456	anxk:G	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   778: aload 29
    //   780: iconst_1
    //   781: putfield 171	anxs:cKC	Z
    //   784: aload 32
    //   786: aload 30
    //   788: aconst_null
    //   789: iconst_1
    //   790: invokevirtual 460	anxr:R	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   793: aload 32
    //   795: aload 30
    //   797: iconst_3
    //   798: invokevirtual 464	anxr:am	(Ljava/lang/String;I)Z
    //   801: istore 12
    //   803: aload 32
    //   805: aload 30
    //   807: iload 5
    //   809: aload_3
    //   810: getfield 444	msf/msgsvc/msg_svc$PbGetMsgResp:errmsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   813: invokevirtual 278	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   816: invokevirtual 467	anxr:ab	(Ljava/lang/String;ILjava/lang/String;)V
    //   819: aload 32
    //   821: aload 30
    //   823: invokevirtual 470	anxr:RC	(Ljava/lang/String;)V
    //   826: iload 12
    //   828: ifeq +103 -> 931
    //   831: iconst_1
    //   832: aload_0
    //   833: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   836: invokevirtual 473	com/tencent/mobileqq/app/QQAppInterface:a	()Ltog;
    //   839: aload 30
    //   841: sipush 7000
    //   844: invokevirtual 479	tog:A	(Ljava/lang/String;I)I
    //   847: isub
    //   848: istore 5
    //   850: iload 5
    //   852: ifeq +45 -> 897
    //   855: aload_0
    //   856: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   859: invokevirtual 473	com/tencent/mobileqq/app/QQAppInterface:a	()Ltog;
    //   862: aload 30
    //   864: sipush 7000
    //   867: iload 5
    //   869: invokevirtual 482	tog:G	(Ljava/lang/String;II)V
    //   872: aload_0
    //   873: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   876: invokevirtual 485	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   879: iconst_2
    //   880: anewarray 87	java/lang/String
    //   883: dup
    //   884: iconst_0
    //   885: getstatic 490	acbn:bku	Ljava/lang/String;
    //   888: aastore
    //   889: dup
    //   890: iconst_1
    //   891: aload 30
    //   893: aastore
    //   894: invokevirtual 496	com/tencent/imcore/message/QQMessageFacade:as	(Ljava/lang/Object;)V
    //   897: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   900: ifeq +31 -> 931
    //   903: ldc_w 298
    //   906: iconst_2
    //   907: new 280	java/lang/StringBuilder
    //   910: dup
    //   911: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   914: ldc_w 498
    //   917: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: aload 30
    //   922: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   928: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   931: aload_0
    //   932: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   935: aload 30
    //   937: iconst_0
    //   938: invokevirtual 502	com/tencent/mobileqq/app/QQAppInterface:updateSubAccountLogin	(Ljava/lang/String;Z)V
    //   941: aload_0
    //   942: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   945: invokevirtual 506	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   948: invokevirtual 512	mqq/app/MobileQQ:refreAccountList	()Ljava/util/List;
    //   951: pop
    //   952: aload_0
    //   953: sipush 8003
    //   956: iconst_0
    //   957: aload 29
    //   959: invokevirtual 177	acrl:b	(IZLjava/lang/Object;)V
    //   962: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   965: ifeq -647 -> 318
    //   968: ldc_w 298
    //   971: iconst_2
    //   972: ldc_w 514
    //   975: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   978: return
    //   979: aload 29
    //   981: sipush 1008
    //   984: putfield 174	anxs:errorType	I
    //   987: aload_0
    //   988: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   991: ldc_w 516
    //   994: invokestatic 520	anxk:aJ	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   997: goto -45 -> 952
    //   1000: aload 29
    //   1002: sipush 1002
    //   1005: putfield 174	anxs:errorType	I
    //   1008: aload_0
    //   1009: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1012: iconst_0
    //   1013: aload 30
    //   1015: invokestatic 452	anxk:a	(Lcom/tencent/mobileqq/app/QQAppInterface;BLjava/lang/String;)V
    //   1018: aload_0
    //   1019: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1022: aload 30
    //   1024: invokestatic 520	anxk:aJ	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   1027: goto -75 -> 952
    //   1030: aload 29
    //   1032: sipush 1006
    //   1035: putfield 174	anxs:errorType	I
    //   1038: goto -86 -> 952
    //   1041: aload 29
    //   1043: sipush 1000
    //   1046: putfield 174	anxs:errorType	I
    //   1049: goto -97 -> 952
    //   1052: aload 32
    //   1054: aload 30
    //   1056: iconst_1
    //   1057: invokevirtual 464	anxr:am	(Ljava/lang/String;I)Z
    //   1060: pop
    //   1061: aload_2
    //   1062: invokevirtual 158	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   1065: astore 26
    //   1067: ldc2_w 521
    //   1070: lstore 16
    //   1072: aload 30
    //   1074: invokestatic 526	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1077: lstore 14
    //   1079: aload 26
    //   1081: ifnonnull +130 -> 1211
    //   1084: aload_0
    //   1085: sipush 8003
    //   1088: iconst_0
    //   1089: aload 29
    //   1091: invokevirtual 177	acrl:b	(IZLjava/lang/Object;)V
    //   1094: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1097: ifeq +13 -> 1110
    //   1100: ldc_w 298
    //   1103: iconst_2
    //   1104: ldc_w 528
    //   1107: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1110: new 381	java/util/HashMap
    //   1113: dup
    //   1114: invokespecial 382	java/util/HashMap:<init>	()V
    //   1117: astore_1
    //   1118: aload_1
    //   1119: ldc_w 384
    //   1122: ldc_w 386
    //   1125: invokevirtual 390	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1128: pop
    //   1129: aload_1
    //   1130: ldc_w 392
    //   1133: ldc_w 530
    //   1136: invokevirtual 390	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1139: pop
    //   1140: aload_1
    //   1141: ldc_w 396
    //   1144: ldc_w 398
    //   1147: invokevirtual 390	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1150: pop
    //   1151: invokestatic 401	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1154: invokestatic 406	anpc:a	(Landroid/content/Context;)Lanpc;
    //   1157: aload_0
    //   1158: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1161: invokevirtual 409	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1164: ldc_w 411
    //   1167: iconst_0
    //   1168: lconst_0
    //   1169: lconst_0
    //   1170: aload_1
    //   1171: ldc 126
    //   1173: invokevirtual 415	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1176: return
    //   1177: astore 27
    //   1179: aload 27
    //   1181: invokevirtual 533	java/lang/Exception:printStackTrace	()V
    //   1184: lload 16
    //   1186: lstore 14
    //   1188: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1191: ifeq -112 -> 1079
    //   1194: ldc_w 298
    //   1197: iconst_2
    //   1198: ldc_w 535
    //   1201: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1204: lload 16
    //   1206: lstore 14
    //   1208: goto -129 -> 1079
    //   1211: aload_2
    //   1212: invokevirtual 158	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   1215: invokestatic 538	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1218: invokevirtual 541	java/lang/Long:longValue	()J
    //   1221: lstore 16
    //   1223: lload 16
    //   1225: ldc2_w 521
    //   1228: lcmp
    //   1229: ifne +121 -> 1350
    //   1232: aload_0
    //   1233: sipush 8003
    //   1236: iconst_0
    //   1237: aload 29
    //   1239: invokevirtual 177	acrl:b	(IZLjava/lang/Object;)V
    //   1242: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1245: ifeq +13 -> 1258
    //   1248: ldc_w 298
    //   1251: iconst_2
    //   1252: ldc_w 543
    //   1255: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1258: new 381	java/util/HashMap
    //   1261: dup
    //   1262: invokespecial 382	java/util/HashMap:<init>	()V
    //   1265: astore_1
    //   1266: aload_1
    //   1267: ldc_w 384
    //   1270: ldc_w 386
    //   1273: invokevirtual 390	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1276: pop
    //   1277: aload_1
    //   1278: ldc_w 392
    //   1281: ldc_w 545
    //   1284: invokevirtual 390	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1287: pop
    //   1288: aload_1
    //   1289: ldc_w 396
    //   1292: ldc_w 398
    //   1295: invokevirtual 390	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1298: pop
    //   1299: invokestatic 401	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1302: invokestatic 406	anpc:a	(Landroid/content/Context;)Lanpc;
    //   1305: aload_0
    //   1306: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1309: invokevirtual 409	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1312: ldc_w 411
    //   1315: iconst_0
    //   1316: lconst_0
    //   1317: lconst_0
    //   1318: aload_1
    //   1319: ldc 126
    //   1321: invokevirtual 415	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1324: return
    //   1325: astore_2
    //   1326: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1329: ifeq +13 -> 1342
    //   1332: ldc_w 298
    //   1335: iconst_2
    //   1336: ldc_w 547
    //   1339: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1342: ldc2_w 521
    //   1345: lstore 16
    //   1347: goto -124 -> 1223
    //   1350: aload 32
    //   1352: invokevirtual 550	anxr:azj	()Z
    //   1355: ifne +20 -> 1375
    //   1358: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1361: ifeq -1043 -> 318
    //   1364: ldc_w 298
    //   1367: iconst_2
    //   1368: ldc_w 552
    //   1371: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1374: return
    //   1375: aload_3
    //   1376: getfield 419	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1379: invokevirtual 256	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1382: ifeq +3145 -> 4527
    //   1385: aload_3
    //   1386: getfield 419	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1389: invokevirtual 259	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1392: invokevirtual 265	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1395: astore 26
    //   1397: aload_3
    //   1398: getfield 428	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   1401: invokevirtual 553	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   1404: ifeq +3117 -> 4521
    //   1407: aload_3
    //   1408: getfield 428	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   1411: invokevirtual 431	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   1414: istore 5
    //   1416: iload 5
    //   1418: iconst_2
    //   1419: if_icmpge +3093 -> 4512
    //   1422: iconst_1
    //   1423: i2b
    //   1424: istore 4
    //   1426: iconst_0
    //   1427: istore 6
    //   1429: aload_3
    //   1430: getfield 554	msf/msgsvc/msg_svc$PbGetMsgResp:bind_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1433: invokevirtual 269	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1436: ifeq +3070 -> 4506
    //   1439: aload_3
    //   1440: getfield 554	msf/msgsvc/msg_svc$PbGetMsgResp:bind_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1443: invokevirtual 38	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1446: lstore 18
    //   1448: aload 32
    //   1450: ifnull +3050 -> 4500
    //   1453: aload 32
    //   1455: lload 18
    //   1457: invokestatic 556	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1460: invokevirtual 560	anxr:aQ	(Ljava/lang/String;)Ljava/util/List;
    //   1463: astore 27
    //   1465: aload_1
    //   1466: getfield 331	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   1469: ldc_w 562
    //   1472: invokevirtual 566	android/os/Bundle:getStringArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1475: astore 28
    //   1477: aload 28
    //   1479: ifnonnull +3018 -> 4497
    //   1482: new 568	java/util/ArrayList
    //   1485: dup
    //   1486: invokespecial 569	java/util/ArrayList:<init>	()V
    //   1489: astore 28
    //   1491: new 381	java/util/HashMap
    //   1494: dup
    //   1495: invokespecial 382	java/util/HashMap:<init>	()V
    //   1498: astore 33
    //   1500: aload_3
    //   1501: getfield 573	msf/msgsvc/msg_svc$PbGetMsgResp:uin_pair_msgs	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1504: invokevirtual 577	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1507: astore 34
    //   1509: iconst_0
    //   1510: istore 7
    //   1512: iload 7
    //   1514: aload 34
    //   1516: invokeinterface 582 1 0
    //   1521: if_icmpge +2437 -> 3958
    //   1524: aload 34
    //   1526: iload 7
    //   1528: invokeinterface 585 2 0
    //   1533: checkcast 587	msf/msgcomm/msg_comm$UinPairMsg
    //   1536: astore_2
    //   1537: aload_2
    //   1538: getfield 590	msf/msgcomm/msg_comm$UinPairMsg:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1541: invokevirtual 38	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1544: lstore 24
    //   1546: aload_2
    //   1547: getfield 593	msf/msgcomm/msg_comm$UinPairMsg:last_read_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1550: invokevirtual 47	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1553: i2l
    //   1554: lstore 20
    //   1556: aload_2
    //   1557: getfield 595	msf/msgcomm/msg_comm$UinPairMsg:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1560: invokevirtual 577	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1563: astore_3
    //   1564: iload 6
    //   1566: ifne +14 -> 1580
    //   1569: aload 28
    //   1571: lload 24
    //   1573: invokestatic 556	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1576: invokevirtual 599	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1579: pop
    //   1580: aload_2
    //   1581: getfield 602	msf/msgcomm/msg_comm$UinPairMsg:unread_msg_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1584: invokevirtual 47	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1587: istore 9
    //   1589: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1592: ifeq +31 -> 1623
    //   1595: ldc_w 298
    //   1598: iconst_2
    //   1599: new 280	java/lang/StringBuilder
    //   1602: dup
    //   1603: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   1606: ldc_w 604
    //   1609: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: lload 24
    //   1614: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1617: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1620: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1623: aload_3
    //   1624: ifnull +17 -> 1641
    //   1627: aload_3
    //   1628: invokeinterface 582 1 0
    //   1633: ifeq +8 -> 1641
    //   1636: iload 9
    //   1638: ifne +130 -> 1768
    //   1641: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1644: ifeq +31 -> 1675
    //   1647: ldc_w 298
    //   1650: iconst_2
    //   1651: new 280	java/lang/StringBuilder
    //   1654: dup
    //   1655: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   1658: ldc_w 606
    //   1661: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1664: lload 24
    //   1666: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1669: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1672: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1675: aload 27
    //   1677: ifnull +82 -> 1759
    //   1680: aload 27
    //   1682: invokeinterface 610 1 0
    //   1687: astore_2
    //   1688: aload_2
    //   1689: invokeinterface 615 1 0
    //   1694: ifeq +65 -> 1759
    //   1697: aload_2
    //   1698: invokeinterface 619 1 0
    //   1703: checkcast 80	com/tencent/mobileqq/data/SubAccountMessage
    //   1706: astore_3
    //   1707: aload_3
    //   1708: ifnull -20 -> 1688
    //   1711: aload_3
    //   1712: getfield 94	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   1715: astore_3
    //   1716: aload_3
    //   1717: ifnull -29 -> 1688
    //   1720: aload_3
    //   1721: lload 24
    //   1723: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1726: invokevirtual 623	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1729: ifeq -41 -> 1688
    //   1732: aload 28
    //   1734: lload 24
    //   1736: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1739: invokevirtual 599	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1742: pop
    //   1743: aload 33
    //   1745: lload 24
    //   1747: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1750: iload 9
    //   1752: invokestatic 345	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1755: invokevirtual 390	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1758: pop
    //   1759: iload 7
    //   1761: iconst_1
    //   1762: iadd
    //   1763: istore 7
    //   1765: goto -253 -> 1512
    //   1768: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1771: ifeq +46 -> 1817
    //   1774: ldc_w 298
    //   1777: iconst_2
    //   1778: new 280	java/lang/StringBuilder
    //   1781: dup
    //   1782: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   1785: ldc_w 625
    //   1788: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1791: lload 24
    //   1793: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1796: ldc_w 627
    //   1799: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1802: aload_3
    //   1803: invokeinterface 582 1 0
    //   1808: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1811: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1814: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1817: new 629	anax
    //   1820: dup
    //   1821: lload 14
    //   1823: lload 24
    //   1825: iconst_0
    //   1826: iconst_0
    //   1827: iconst_0
    //   1828: iconst_1
    //   1829: invokespecial 632	anax:<init>	(JJZZZZ)V
    //   1832: astore 35
    //   1834: aload_3
    //   1835: ifnull -76 -> 1759
    //   1838: aload_3
    //   1839: invokeinterface 582 1 0
    //   1844: ifle -85 -> 1759
    //   1847: aload_3
    //   1848: new 634	acrm
    //   1851: dup
    //   1852: aload_0
    //   1853: invokespecial 637	acrm:<init>	(Lacrl;)V
    //   1856: invokestatic 643	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   1859: aload_2
    //   1860: getfield 646	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1863: invokevirtual 432	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1866: ifeq +359 -> 2225
    //   1869: aload_2
    //   1870: getfield 646	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1873: invokevirtual 47	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1876: ifeq +349 -> 2225
    //   1879: iconst_1
    //   1880: istore 12
    //   1882: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1885: ifeq +72 -> 1957
    //   1888: ldc_w 298
    //   1891: iconst_2
    //   1892: new 280	java/lang/StringBuilder
    //   1895: dup
    //   1896: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   1899: ldc_w 625
    //   1902: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1905: lload 24
    //   1907: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1910: ldc_w 648
    //   1913: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1916: aload_3
    //   1917: invokeinterface 582 1 0
    //   1922: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1925: ldc_w 650
    //   1928: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1931: iload 12
    //   1933: invokevirtual 653	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1936: ldc_w 655
    //   1939: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1942: lload 20
    //   1944: ldc2_w 656
    //   1947: land
    //   1948: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1951: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1954: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1957: aload_3
    //   1958: invokeinterface 610 1 0
    //   1963: astore 36
    //   1965: aload 36
    //   1967: invokeinterface 615 1 0
    //   1972: ifeq -213 -> 1759
    //   1975: aload 36
    //   1977: invokeinterface 619 1 0
    //   1982: checkcast 19	msf/msgcomm/msg_comm$Msg
    //   1985: astore 37
    //   1987: aload 37
    //   1989: ifnull -24 -> 1965
    //   1992: aload 37
    //   1994: getfield 23	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1997: invokevirtual 29	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2000: checkcast 25	msf/msgcomm/msg_comm$MsgHead
    //   2003: astore 38
    //   2005: aload 38
    //   2007: getfield 660	msf/msgcomm/msg_comm$MsgHead:msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2010: invokevirtual 47	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2013: istore 8
    //   2015: aconst_null
    //   2016: astore_2
    //   2017: aload 37
    //   2019: getfield 23	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   2022: invokevirtual 29	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2025: checkcast 25	msf/msgcomm/msg_comm$MsgHead
    //   2028: getfield 663	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2031: invokevirtual 47	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2034: istore 10
    //   2036: sipush 193
    //   2039: iload 8
    //   2041: if_icmpeq +11 -> 2052
    //   2044: sipush 734
    //   2047: iload 8
    //   2049: if_icmpne +305 -> 2354
    //   2052: lload 14
    //   2054: lload 24
    //   2056: lcmp
    //   2057: ifne +174 -> 2231
    //   2060: aload_2
    //   2061: ifnull +64 -> 2125
    //   2064: aload_2
    //   2065: invokeinterface 666 1 0
    //   2070: ifne +55 -> 2125
    //   2073: aload 27
    //   2075: ifnull +50 -> 2125
    //   2078: aload 27
    //   2080: invokeinterface 666 1 0
    //   2085: ifne +40 -> 2125
    //   2088: aload_2
    //   2089: iconst_0
    //   2090: invokeinterface 585 2 0
    //   2095: checkcast 181	com/tencent/mobileqq/data/MessageRecord
    //   2098: getfield 667	com/tencent/mobileqq/data/MessageRecord:time	J
    //   2101: aload 27
    //   2103: iconst_0
    //   2104: invokeinterface 585 2 0
    //   2109: checkcast 80	com/tencent/mobileqq/data/SubAccountMessage
    //   2112: getfield 105	com/tencent/mobileqq/data/SubAccountMessage:time	J
    //   2115: lcmp
    //   2116: ifge +9 -> 2125
    //   2119: aload_2
    //   2120: invokeinterface 670 1 0
    //   2125: aload_2
    //   2126: ifnull +12 -> 2138
    //   2129: aload_2
    //   2130: invokeinterface 582 1 0
    //   2135: ifne +638 -> 2773
    //   2138: aload 27
    //   2140: ifnull -175 -> 1965
    //   2143: aload 27
    //   2145: invokeinterface 610 1 0
    //   2150: astore_2
    //   2151: aload_2
    //   2152: invokeinterface 615 1 0
    //   2157: ifeq -192 -> 1965
    //   2160: aload_2
    //   2161: invokeinterface 619 1 0
    //   2166: checkcast 80	com/tencent/mobileqq/data/SubAccountMessage
    //   2169: astore_3
    //   2170: aload_3
    //   2171: ifnull -20 -> 2151
    //   2174: aload_3
    //   2175: getfield 94	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   2178: astore_3
    //   2179: aload_3
    //   2180: ifnull -29 -> 2151
    //   2183: aload_3
    //   2184: lload 24
    //   2186: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2189: invokevirtual 623	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2192: ifeq -41 -> 2151
    //   2195: aload 28
    //   2197: lload 24
    //   2199: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2202: invokevirtual 599	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2205: pop
    //   2206: aload 33
    //   2208: lload 24
    //   2210: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2213: iload 9
    //   2215: invokestatic 345	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2218: invokevirtual 390	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2221: pop
    //   2222: goto -257 -> 1965
    //   2225: iconst_0
    //   2226: istore 12
    //   2228: goto -346 -> 1882
    //   2231: new 568	java/util/ArrayList
    //   2234: dup
    //   2235: invokespecial 569	java/util/ArrayList:<init>	()V
    //   2238: astore_2
    //   2239: sipush 193
    //   2242: invokestatic 675	anbi:d	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2245: astore_3
    //   2246: aload_3
    //   2247: lload 14
    //   2249: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2252: putfield 678	com/tencent/mobileqq/data/MessageRecord:selfuin	Ljava/lang/String;
    //   2255: aload_3
    //   2256: lload 24
    //   2258: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2261: putfield 679	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   2264: aload_3
    //   2265: lload 24
    //   2267: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2270: putfield 680	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   2273: aload_3
    //   2274: aload 38
    //   2276: getfield 683	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2279: invokevirtual 47	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2282: i2l
    //   2283: putfield 686	com/tencent/mobileqq/data/MessageRecord:shmsgseq	J
    //   2286: aload_3
    //   2287: aload 38
    //   2289: getfield 689	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2292: invokevirtual 38	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2295: putfield 692	com/tencent/mobileqq/data/MessageRecord:msgUid	J
    //   2298: aload_3
    //   2299: aload 38
    //   2301: getfield 42	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2304: invokevirtual 47	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2307: i2l
    //   2308: putfield 667	com/tencent/mobileqq/data/MessageRecord:time	J
    //   2311: aload_3
    //   2312: iconst_0
    //   2313: putfield 693	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   2316: aload_3
    //   2317: aload_0
    //   2318: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2321: invokevirtual 195	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2324: invokevirtual 201	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2327: ldc_w 694
    //   2330: invokevirtual 207	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2333: putfield 695	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   2336: aload_3
    //   2337: sipush 193
    //   2340: putfield 182	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   2343: aload_2
    //   2344: aload_3
    //   2345: invokeinterface 696 2 0
    //   2350: pop
    //   2351: goto -291 -> 2060
    //   2354: iload 8
    //   2356: invokestatic 702	anbk:lu	(I)Z
    //   2359: ifeq +332 -> 2691
    //   2362: aload 38
    //   2364: getfield 663	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2367: invokevirtual 432	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2370: ifeq +321 -> 2691
    //   2373: iload 10
    //   2375: sipush 169
    //   2378: if_icmpeq +51 -> 2429
    //   2381: iload 10
    //   2383: sipush 241
    //   2386: if_icmpeq +43 -> 2429
    //   2389: iload 10
    //   2391: sipush 242
    //   2394: if_icmpeq +35 -> 2429
    //   2397: iload 10
    //   2399: sipush 243
    //   2402: if_icmpeq +27 -> 2429
    //   2405: iload 10
    //   2407: sipush 129
    //   2410: if_icmpeq +19 -> 2429
    //   2413: iload 10
    //   2415: sipush 131
    //   2418: if_icmpeq +11 -> 2429
    //   2421: iload 10
    //   2423: sipush 133
    //   2426: if_icmpne +265 -> 2691
    //   2429: iload 10
    //   2431: sipush 129
    //   2434: if_icmpeq -469 -> 1965
    //   2437: iload 10
    //   2439: sipush 131
    //   2442: if_icmpeq -477 -> 1965
    //   2445: iload 10
    //   2447: sipush 133
    //   2450: if_icmpeq -485 -> 1965
    //   2453: iload 10
    //   2455: sipush 135
    //   2458: if_icmpeq -493 -> 1965
    //   2461: iload 10
    //   2463: sipush 243
    //   2466: if_icmpeq -501 -> 1965
    //   2469: aload 37
    //   2471: getfield 706	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   2474: invokevirtual 709	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2477: checkcast 708	tencent/im/msg/im_msg_body$MsgBody
    //   2480: getfield 713	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   2483: invokevirtual 716	tencent/im/msg/im_msg_body$RichText:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2486: checkcast 715	tencent/im/msg/im_msg_body$RichText
    //   2489: getfield 720	tencent/im/msg/im_msg_body$RichText:not_online_file	Ltencent/im/msg/im_msg_body$NotOnlineFile;
    //   2492: invokevirtual 723	tencent/im/msg/im_msg_body$NotOnlineFile:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2495: checkcast 722	tencent/im/msg/im_msg_body$NotOnlineFile
    //   2498: getfield 726	tencent/im/msg/im_msg_body$NotOnlineFile:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2501: invokevirtual 259	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2504: invokevirtual 729	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2507: astore_2
    //   2508: aload_2
    //   2509: astore_3
    //   2510: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2513: ifeq +32 -> 2545
    //   2516: ldc_w 298
    //   2519: iconst_2
    //   2520: new 280	java/lang/StringBuilder
    //   2523: dup
    //   2524: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   2527: ldc_w 731
    //   2530: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2533: aload_2
    //   2534: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2537: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2540: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2543: aload_2
    //   2544: astore_3
    //   2545: aload_3
    //   2546: astore_2
    //   2547: aload_3
    //   2548: invokestatic 736	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2551: ifeq +20 -> 2571
    //   2554: aload_0
    //   2555: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2558: invokevirtual 195	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2561: invokevirtual 201	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2564: ldc_w 737
    //   2567: invokevirtual 207	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2570: astore_2
    //   2571: sipush -2005
    //   2574: invokestatic 675	anbi:d	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2577: astore_3
    //   2578: aload_3
    //   2579: lload 14
    //   2581: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2584: putfield 678	com/tencent/mobileqq/data/MessageRecord:selfuin	Ljava/lang/String;
    //   2587: aload_3
    //   2588: lload 24
    //   2590: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2593: putfield 679	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   2596: aload_3
    //   2597: lload 24
    //   2599: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2602: putfield 680	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   2605: aload_3
    //   2606: aload 38
    //   2608: getfield 683	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2611: invokevirtual 47	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2614: i2l
    //   2615: putfield 686	com/tencent/mobileqq/data/MessageRecord:shmsgseq	J
    //   2618: aload_3
    //   2619: aload 38
    //   2621: getfield 689	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2624: invokevirtual 38	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2627: putfield 692	com/tencent/mobileqq/data/MessageRecord:msgUid	J
    //   2630: aload_3
    //   2631: aload 38
    //   2633: getfield 42	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2636: invokevirtual 47	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2639: i2l
    //   2640: putfield 667	com/tencent/mobileqq/data/MessageRecord:time	J
    //   2643: aload_3
    //   2644: iconst_0
    //   2645: putfield 693	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   2648: aload_3
    //   2649: aload_2
    //   2650: putfield 695	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   2653: aload_3
    //   2654: sipush -2005
    //   2657: putfield 182	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   2660: new 568	java/util/ArrayList
    //   2663: dup
    //   2664: invokespecial 569	java/util/ArrayList:<init>	()V
    //   2667: astore_2
    //   2668: aload_2
    //   2669: aload_3
    //   2670: invokeinterface 696 2 0
    //   2675: pop
    //   2676: goto -616 -> 2060
    //   2679: astore_3
    //   2680: aconst_null
    //   2681: astore_2
    //   2682: aload_3
    //   2683: invokevirtual 533	java/lang/Exception:printStackTrace	()V
    //   2686: aload_2
    //   2687: astore_3
    //   2688: goto -143 -> 2545
    //   2691: aload_0
    //   2692: aload 37
    //   2694: aload 35
    //   2696: invokevirtual 740	acrl:a	(Lmsf/msgcomm/msg_comm$Msg;Lanbl;)Ljava/util/List;
    //   2699: astore_2
    //   2700: aload_2
    //   2701: ifnull +47 -> 2748
    //   2704: aload_2
    //   2705: invokeinterface 582 1 0
    //   2710: ifle +38 -> 2748
    //   2713: aload_2
    //   2714: iconst_0
    //   2715: invokeinterface 585 2 0
    //   2720: checkcast 181	com/tencent/mobileqq/data/MessageRecord
    //   2723: astore_3
    //   2724: aload_3
    //   2725: getfield 693	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   2728: sipush 1033
    //   2731: if_icmpeq -766 -> 1965
    //   2734: aload_3
    //   2735: getfield 693	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   2738: istore 8
    //   2740: iload 8
    //   2742: sipush 1034
    //   2745: if_icmpeq -780 -> 1965
    //   2748: goto -688 -> 2060
    //   2751: astore_3
    //   2752: aconst_null
    //   2753: astore_2
    //   2754: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2757: ifeq +13 -> 2770
    //   2760: ldc 60
    //   2762: iconst_2
    //   2763: ldc_w 742
    //   2766: aload_3
    //   2767: invokestatic 745	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2770: goto -710 -> 2060
    //   2773: new 747	java/lang/StringBuffer
    //   2776: dup
    //   2777: invokespecial 748	java/lang/StringBuffer:<init>	()V
    //   2780: astore 39
    //   2782: aload_2
    //   2783: iconst_0
    //   2784: invokeinterface 585 2 0
    //   2789: checkcast 181	com/tencent/mobileqq/data/MessageRecord
    //   2792: astore 38
    //   2794: aload 38
    //   2796: getfield 667	com/tencent/mobileqq/data/MessageRecord:time	J
    //   2799: lstore 22
    //   2801: aload_2
    //   2802: invokeinterface 610 1 0
    //   2807: astore 40
    //   2809: iconst_0
    //   2810: istore 12
    //   2812: aload 40
    //   2814: invokeinterface 615 1 0
    //   2819: ifeq +1672 -> 4491
    //   2822: aload 40
    //   2824: invokeinterface 619 1 0
    //   2829: checkcast 181	com/tencent/mobileqq/data/MessageRecord
    //   2832: astore_2
    //   2833: aload_2
    //   2834: ifnull -22 -> 2812
    //   2837: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2840: ifeq +30 -> 2870
    //   2843: ldc_w 298
    //   2846: iconst_2
    //   2847: new 280	java/lang/StringBuilder
    //   2850: dup
    //   2851: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   2854: ldc_w 750
    //   2857: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2860: aload_2
    //   2861: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2864: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2867: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2870: aload_2
    //   2871: getfield 695	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   2874: astore_3
    //   2875: aload_3
    //   2876: ifnull +19 -> 2895
    //   2879: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2882: ifeq +13 -> 2895
    //   2885: ldc_w 298
    //   2888: iconst_2
    //   2889: ldc_w 752
    //   2892: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2895: aload_2
    //   2896: getfield 679	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   2899: ifnull -87 -> 2812
    //   2902: getstatic 755	acbn:bkD	Ljava/lang/String;
    //   2905: invokestatic 321	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2908: aload_2
    //   2909: getfield 679	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   2912: invokevirtual 623	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2915: ifeq +79 -> 2994
    //   2918: iconst_1
    //   2919: istore 8
    //   2921: aload_0
    //   2922: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2925: aload_3
    //   2926: aload_2
    //   2927: getfield 182	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   2930: aload_2
    //   2931: getfield 680	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   2934: invokestatic 758	anxk:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   2937: astore_2
    //   2938: aload_2
    //   2939: ifnonnull +45 -> 2984
    //   2942: aload 39
    //   2944: ifnull +11 -> 2955
    //   2947: aload 39
    //   2949: invokevirtual 761	java/lang/StringBuffer:length	()I
    //   2952: ifne +102 -> 3054
    //   2955: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2958: ifeq -993 -> 1965
    //   2961: ldc_w 298
    //   2964: iconst_2
    //   2965: ldc_w 763
    //   2968: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2971: goto -1006 -> 1965
    //   2974: astore 41
    //   2976: aload 41
    //   2978: invokevirtual 533	java/lang/Exception:printStackTrace	()V
    //   2981: goto -86 -> 2895
    //   2984: aload 39
    //   2986: aload_2
    //   2987: invokevirtual 766	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2990: pop
    //   2991: goto -49 -> 2942
    //   2994: aload_2
    //   2995: getfield 182	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   2998: sipush -5004
    //   3001: if_icmpne +1487 -> 4488
    //   3004: aload_2
    //   3005: instanceof 768
    //   3008: ifeq +1480 -> 4488
    //   3011: ldc_w 770
    //   3014: aload 38
    //   3016: getfield 680	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   3019: invokevirtual 773	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3022: ifeq +1466 -> 4488
    //   3025: iconst_1
    //   3026: istore 12
    //   3028: aload_0
    //   3029: aload_2
    //   3030: aload_3
    //   3031: invokespecial 775	acrl:g	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)Ljava/lang/String;
    //   3034: astore_3
    //   3035: aload_3
    //   3036: astore_2
    //   3037: aload_3
    //   3038: ifnonnull +6 -> 3044
    //   3041: ldc 126
    //   3043: astore_2
    //   3044: aload 39
    //   3046: aload_2
    //   3047: invokevirtual 766	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   3050: pop
    //   3051: goto -239 -> 2812
    //   3054: aload 27
    //   3056: ifnull +71 -> 3127
    //   3059: iload 8
    //   3061: ifne +66 -> 3127
    //   3064: aload 27
    //   3066: invokeinterface 610 1 0
    //   3071: astore_2
    //   3072: aload_2
    //   3073: invokeinterface 615 1 0
    //   3078: ifeq +49 -> 3127
    //   3081: aload_2
    //   3082: invokeinterface 619 1 0
    //   3087: checkcast 80	com/tencent/mobileqq/data/SubAccountMessage
    //   3090: astore_3
    //   3091: aload_3
    //   3092: ifnull -20 -> 3072
    //   3095: aload_3
    //   3096: getfield 94	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   3099: astore_3
    //   3100: aload_3
    //   3101: ifnull -29 -> 3072
    //   3104: aload_3
    //   3105: lload 24
    //   3107: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3110: invokevirtual 623	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3113: ifeq -41 -> 3072
    //   3116: aload 28
    //   3118: lload 24
    //   3120: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3123: invokevirtual 599	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3126: pop
    //   3127: aload 37
    //   3129: getfield 23	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   3132: invokevirtual 29	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3135: checkcast 25	msf/msgcomm/msg_comm$MsgHead
    //   3138: astore_2
    //   3139: aload_2
    //   3140: ifnull +1343 -> 4483
    //   3143: aload_2
    //   3144: getfield 778	msf/msgcomm/msg_comm$MsgHead:from_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3147: invokevirtual 276	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   3150: ifeq +1333 -> 4483
    //   3153: aload_2
    //   3154: getfield 778	msf/msgcomm/msg_comm$MsgHead:from_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3157: invokevirtual 278	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3160: astore_2
    //   3161: iload 8
    //   3163: ifeq +20 -> 3183
    //   3166: aload_0
    //   3167: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3170: invokevirtual 195	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3173: invokevirtual 201	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   3176: ldc_w 779
    //   3179: invokevirtual 207	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   3182: astore_2
    //   3183: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3186: ifeq +31 -> 3217
    //   3189: ldc_w 298
    //   3192: iconst_2
    //   3193: new 280	java/lang/StringBuilder
    //   3196: dup
    //   3197: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   3200: ldc_w 781
    //   3203: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3206: iload 12
    //   3208: invokevirtual 653	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3211: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3214: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3217: aload 29
    //   3219: iconst_1
    //   3220: putfield 168	anxs:cKB	Z
    //   3223: new 80	com/tencent/mobileqq/data/SubAccountMessage
    //   3226: dup
    //   3227: invokespecial 83	com/tencent/mobileqq/data/SubAccountMessage:<init>	()V
    //   3230: astore 37
    //   3232: iload 8
    //   3234: ifeq +691 -> 3925
    //   3237: aload 37
    //   3239: getstatic 755	acbn:bkD	Ljava/lang/String;
    //   3242: invokestatic 321	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3245: putfield 94	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   3248: iload 12
    //   3250: ifeq +688 -> 3938
    //   3253: iconst_1
    //   3254: istore 13
    //   3256: aload 37
    //   3258: iload 13
    //   3260: putfield 784	com/tencent/mobileqq/data/SubAccountMessage:isread	Z
    //   3263: aload 37
    //   3265: aload 39
    //   3267: invokevirtual 785	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   3270: putfield 129	com/tencent/mobileqq/data/SubAccountMessage:msg	Ljava/lang/String;
    //   3273: aload 37
    //   3275: aload 38
    //   3277: getfield 788	com/tencent/mobileqq/data/MessageRecord:extInt	I
    //   3280: putfield 789	com/tencent/mobileqq/data/SubAccountMessage:extInt	I
    //   3283: aload 37
    //   3285: aload 38
    //   3287: getfield 792	com/tencent/mobileqq/data/MessageRecord:extLong	I
    //   3290: putfield 793	com/tencent/mobileqq/data/SubAccountMessage:extLong	I
    //   3293: aload 37
    //   3295: aload 38
    //   3297: getfield 796	com/tencent/mobileqq/data/MessageRecord:extraflag	I
    //   3300: putfield 797	com/tencent/mobileqq/data/SubAccountMessage:extraflag	I
    //   3303: aload 37
    //   3305: aload 38
    //   3307: getfield 800	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   3310: putfield 801	com/tencent/mobileqq/data/SubAccountMessage:extStr	Ljava/lang/String;
    //   3313: aload 37
    //   3315: aload 38
    //   3317: getfield 693	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   3320: putfield 114	com/tencent/mobileqq/data/SubAccountMessage:istroop	I
    //   3323: aload 37
    //   3325: aload 38
    //   3327: getfield 804	com/tencent/mobileqq/data/MessageRecord:isValid	Z
    //   3330: putfield 805	com/tencent/mobileqq/data/SubAccountMessage:isValid	Z
    //   3333: aload 37
    //   3335: aload 38
    //   3337: getfield 808	com/tencent/mobileqq/data/MessageRecord:longMsgCount	I
    //   3340: putfield 809	com/tencent/mobileqq/data/SubAccountMessage:longMsgCount	I
    //   3343: aload 37
    //   3345: aload 38
    //   3347: getfield 812	com/tencent/mobileqq/data/MessageRecord:longMsgId	I
    //   3350: putfield 813	com/tencent/mobileqq/data/SubAccountMessage:longMsgId	I
    //   3353: aload 37
    //   3355: aload 38
    //   3357: getfield 816	com/tencent/mobileqq/data/MessageRecord:longMsgIndex	I
    //   3360: putfield 817	com/tencent/mobileqq/data/SubAccountMessage:longMsgIndex	I
    //   3363: aload 37
    //   3365: aload 38
    //   3367: getfield 692	com/tencent/mobileqq/data/MessageRecord:msgUid	J
    //   3370: putfield 818	com/tencent/mobileqq/data/SubAccountMessage:msgUid	J
    //   3373: aload 37
    //   3375: aload 38
    //   3377: getfield 686	com/tencent/mobileqq/data/MessageRecord:shmsgseq	J
    //   3380: putfield 819	com/tencent/mobileqq/data/SubAccountMessage:shmsgseq	J
    //   3383: aload 37
    //   3385: aload 38
    //   3387: getfield 822	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   3390: putfield 823	com/tencent/mobileqq/data/SubAccountMessage:uniseq	J
    //   3393: aload 37
    //   3395: aload 38
    //   3397: getfield 826	com/tencent/mobileqq/data/MessageRecord:msgseq	J
    //   3400: putfield 827	com/tencent/mobileqq/data/SubAccountMessage:msgseq	J
    //   3403: iload 12
    //   3405: ifeq +539 -> 3944
    //   3408: iconst_0
    //   3409: istore 8
    //   3411: aload 37
    //   3413: iload 8
    //   3415: putfield 98	com/tencent/mobileqq/data/SubAccountMessage:unreadNum	I
    //   3418: aload 37
    //   3420: sipush -1000
    //   3423: putfield 101	com/tencent/mobileqq/data/SubAccountMessage:msgtype	I
    //   3426: aload 37
    //   3428: lload 16
    //   3430: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3433: putfield 828	com/tencent/mobileqq/data/SubAccountMessage:selfuin	Ljava/lang/String;
    //   3436: aload_2
    //   3437: ifnull +12 -> 3449
    //   3440: aload_2
    //   3441: astore_3
    //   3442: aload_2
    //   3443: invokevirtual 829	java/lang/String:length	()I
    //   3446: ifne +9 -> 3455
    //   3449: aload 37
    //   3451: getfield 94	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   3454: astore_3
    //   3455: aload 37
    //   3457: aload_3
    //   3458: putfield 124	com/tencent/mobileqq/data/SubAccountMessage:sendername	Ljava/lang/String;
    //   3461: aload 37
    //   3463: lload 24
    //   3465: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3468: putfield 108	com/tencent/mobileqq/data/SubAccountMessage:senderuin	Ljava/lang/String;
    //   3471: aload 37
    //   3473: lload 18
    //   3475: invokestatic 556	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3478: putfield 111	com/tencent/mobileqq/data/SubAccountMessage:subUin	Ljava/lang/String;
    //   3481: lload 22
    //   3483: lconst_0
    //   3484: lcmp
    //   3485: ifne +466 -> 3951
    //   3488: invokestatic 834	java/lang/System:currentTimeMillis	()J
    //   3491: ldc2_w 835
    //   3494: ldiv
    //   3495: lstore 20
    //   3497: aload 37
    //   3499: lload 20
    //   3501: putfield 105	com/tencent/mobileqq/data/SubAccountMessage:time	J
    //   3504: aload 37
    //   3506: aload_0
    //   3507: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3510: getfield 839	com/tencent/mobileqq/app/QQAppInterface:isBackground_Pause	Z
    //   3513: putfield 842	com/tencent/mobileqq/data/SubAccountMessage:needNotify	Z
    //   3516: aload 37
    //   3518: ldc2_w 835
    //   3521: lload 22
    //   3523: lmul
    //   3524: iconst_1
    //   3525: getstatic 845	anxk:ciB	Ljava/lang/String;
    //   3528: invokestatic 850	aqmu:a	(JZLjava/lang/String;)Ljava/lang/String;
    //   3531: putfield 853	com/tencent/mobileqq/data/SubAccountMessage:mTimeString	Ljava/lang/String;
    //   3534: aload 37
    //   3536: new 855	aofk
    //   3539: dup
    //   3540: aload 37
    //   3542: getfield 129	com/tencent/mobileqq/data/SubAccountMessage:msg	Ljava/lang/String;
    //   3545: iconst_3
    //   3546: bipush 16
    //   3548: invokespecial 858	aofk:<init>	(Ljava/lang/CharSequence;II)V
    //   3551: putfield 862	com/tencent/mobileqq/data/SubAccountMessage:mEmoRecentMsg	Ljava/lang/CharSequence;
    //   3554: aload 38
    //   3556: invokestatic 868	com/tencent/mobileqq/data/MessageForQQWalletMsg:isRedPacketMsg	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   3559: ifeq +11 -> 3570
    //   3562: aload 37
    //   3564: ldc_w 870
    //   3567: putfield 873	com/tencent/mobileqq/data/SubAccountMessage:subExtr	Ljava/lang/String;
    //   3570: aload 38
    //   3572: instanceof 875
    //   3575: ifeq +11 -> 3586
    //   3578: aload 37
    //   3580: ldc_w 870
    //   3583: putfield 873	com/tencent/mobileqq/data/SubAccountMessage:subExtr	Ljava/lang/String;
    //   3586: aload 32
    //   3588: ifnull +10 -> 3598
    //   3591: aload 32
    //   3593: aload 37
    //   3595: invokevirtual 143	anxr:b	(Lcom/tencent/mobileqq/data/SubAccountMessage;)V
    //   3598: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3601: ifeq +80 -> 3681
    //   3604: ldc_w 298
    //   3607: iconst_2
    //   3608: new 280	java/lang/StringBuilder
    //   3611: dup
    //   3612: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   3615: ldc_w 877
    //   3618: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3621: aload 37
    //   3623: getfield 98	com/tencent/mobileqq/data/SubAccountMessage:unreadNum	I
    //   3626: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3629: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3632: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3635: aload 37
    //   3637: getfield 129	com/tencent/mobileqq/data/SubAccountMessage:msg	Ljava/lang/String;
    //   3640: invokestatic 736	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3643: ifne +38 -> 3681
    //   3646: ldc_w 298
    //   3649: iconst_2
    //   3650: new 280	java/lang/StringBuilder
    //   3653: dup
    //   3654: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   3657: ldc_w 879
    //   3660: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3663: aload 37
    //   3665: getfield 129	com/tencent/mobileqq/data/SubAccountMessage:msg	Ljava/lang/String;
    //   3668: iconst_0
    //   3669: invokevirtual 883	java/lang/String:charAt	(I)C
    //   3672: invokevirtual 886	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3675: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3678: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3681: aload_0
    //   3682: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3685: aload 30
    //   3687: bipush 6
    //   3689: invokestatic 456	anxk:G	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   3692: aload 29
    //   3694: iconst_1
    //   3695: putfield 171	anxs:cKC	Z
    //   3698: aload 38
    //   3700: getfield 182	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   3703: invokestatic 675	anbi:d	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3706: astore_2
    //   3707: aload_2
    //   3708: aload 38
    //   3710: invokestatic 890	com/tencent/mobileqq/data/MessageRecord:copyMessageRecordBaseField	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   3713: aload_2
    //   3714: sipush 7000
    //   3717: putfield 693	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   3720: aload_2
    //   3721: aload 30
    //   3723: putfield 679	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   3726: aload_0
    //   3727: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3730: invokevirtual 473	com/tencent/mobileqq/app/QQAppInterface:a	()Ltog;
    //   3733: aload_2
    //   3734: getfield 679	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   3737: aload_2
    //   3738: getfield 693	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   3741: invokevirtual 479	tog:A	(Ljava/lang/String;I)I
    //   3744: istore 10
    //   3746: iconst_0
    //   3747: istore 8
    //   3749: aload 32
    //   3751: ifnull +12 -> 3763
    //   3754: aload 32
    //   3756: aload 30
    //   3758: invokevirtual 894	anxr:eA	(Ljava/lang/String;)I
    //   3761: istore 8
    //   3763: iload 8
    //   3765: iload 10
    //   3767: isub
    //   3768: istore 11
    //   3770: iload 11
    //   3772: ifeq +35 -> 3807
    //   3775: aload_0
    //   3776: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3779: invokevirtual 473	com/tencent/mobileqq/app/QQAppInterface:a	()Ltog;
    //   3782: aload_2
    //   3783: getfield 679	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   3786: aload_2
    //   3787: getfield 693	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   3790: iload 11
    //   3792: invokevirtual 482	tog:G	(Ljava/lang/String;II)V
    //   3795: aload 32
    //   3797: ifnull +10 -> 3807
    //   3800: aload 32
    //   3802: aload 30
    //   3804: invokevirtual 147	anxr:Rz	(Ljava/lang/String;)V
    //   3807: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3810: ifeq +64 -> 3874
    //   3813: ldc_w 298
    //   3816: iconst_2
    //   3817: new 280	java/lang/StringBuilder
    //   3820: dup
    //   3821: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   3824: ldc_w 896
    //   3827: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3830: aload 30
    //   3832: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3835: ldc_w 898
    //   3838: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3841: iload 8
    //   3843: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3846: ldc_w 900
    //   3849: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3852: iload 10
    //   3854: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3857: ldc_w 902
    //   3860: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3863: iload 11
    //   3865: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3868: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3871: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3874: new 568	java/util/ArrayList
    //   3877: dup
    //   3878: invokespecial 569	java/util/ArrayList:<init>	()V
    //   3881: astore_3
    //   3882: aload_3
    //   3883: aload_2
    //   3884: invokevirtual 599	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3887: pop
    //   3888: aload_0
    //   3889: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3892: invokevirtual 485	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3895: aload_3
    //   3896: aload 31
    //   3898: iconst_0
    //   3899: iconst_0
    //   3900: iconst_1
    //   3901: invokevirtual 905	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/util/ArrayList;Ljava/lang/String;ZZZ)V
    //   3904: iload 12
    //   3906: ifne -1941 -> 1965
    //   3909: aload_0
    //   3910: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3913: aload_3
    //   3914: invokevirtual 906	java/util/ArrayList:size	()I
    //   3917: iconst_1
    //   3918: iconst_1
    //   3919: invokevirtual 910	com/tencent/mobileqq/app/QQAppInterface:q	(IZZ)V
    //   3922: goto -1957 -> 1965
    //   3925: aload 37
    //   3927: lload 24
    //   3929: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3932: putfield 94	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   3935: goto -687 -> 3248
    //   3938: iconst_0
    //   3939: istore 13
    //   3941: goto -685 -> 3256
    //   3944: iload 9
    //   3946: istore 8
    //   3948: goto -537 -> 3411
    //   3951: lload 22
    //   3953: lstore 20
    //   3955: goto -458 -> 3497
    //   3958: aload 27
    //   3960: ifnull +293 -> 4253
    //   3963: aload 27
    //   3965: invokeinterface 582 1 0
    //   3970: ifle +283 -> 4253
    //   3973: iload 6
    //   3975: ifeq +278 -> 4253
    //   3978: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3981: ifeq +13 -> 3994
    //   3984: ldc_w 298
    //   3987: iconst_2
    //   3988: ldc_w 912
    //   3991: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3994: iconst_0
    //   3995: istore 6
    //   3997: iload 6
    //   3999: aload 27
    //   4001: invokeinterface 582 1 0
    //   4006: if_icmpge +247 -> 4253
    //   4009: aload 27
    //   4011: iload 6
    //   4013: invokeinterface 585 2 0
    //   4018: checkcast 80	com/tencent/mobileqq/data/SubAccountMessage
    //   4021: astore_2
    //   4022: aload_2
    //   4023: ifnull +10 -> 4033
    //   4026: aload_2
    //   4027: getfield 94	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   4030: ifnonnull +12 -> 4042
    //   4033: iload 6
    //   4035: iconst_1
    //   4036: iadd
    //   4037: istore 6
    //   4039: goto -42 -> 3997
    //   4042: aload_2
    //   4043: getfield 94	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   4046: getstatic 755	acbn:bkD	Ljava/lang/String;
    //   4049: invokestatic 321	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4052: invokevirtual 773	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4055: ifne -22 -> 4033
    //   4058: aload_2
    //   4059: getfield 94	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   4062: ldc2_w 84
    //   4065: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4068: invokevirtual 773	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4071: ifne -38 -> 4033
    //   4074: iconst_0
    //   4075: istore 8
    //   4077: aload 28
    //   4079: invokevirtual 913	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   4082: astore_3
    //   4083: iload 8
    //   4085: istore 7
    //   4087: aload_3
    //   4088: invokeinterface 615 1 0
    //   4093: ifeq +34 -> 4127
    //   4096: aload_3
    //   4097: invokeinterface 619 1 0
    //   4102: checkcast 87	java/lang/String
    //   4105: astore 31
    //   4107: aload 31
    //   4109: ifnull -26 -> 4083
    //   4112: aload_2
    //   4113: getfield 94	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   4116: aload 31
    //   4118: invokevirtual 623	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4121: ifeq -38 -> 4083
    //   4124: iconst_1
    //   4125: istore 7
    //   4127: iload 7
    //   4129: ifeq +48 -> 4177
    //   4132: aload 33
    //   4134: aload_2
    //   4135: getfield 94	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   4138: invokevirtual 916	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   4141: ifeq +36 -> 4177
    //   4144: aload 32
    //   4146: aload_0
    //   4147: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4150: lload 18
    //   4152: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4155: aload_2
    //   4156: getfield 94	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   4159: aload 33
    //   4161: aload_2
    //   4162: getfield 94	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   4165: invokevirtual 919	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4168: checkcast 342	java/lang/Integer
    //   4171: invokevirtual 922	java/lang/Integer:intValue	()I
    //   4174: invokevirtual 926	anxr:o	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;I)V
    //   4177: iload 7
    //   4179: ifne -146 -> 4033
    //   4182: aload 32
    //   4184: ifnull -151 -> 4033
    //   4187: aload 32
    //   4189: lload 18
    //   4191: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4194: aload_2
    //   4195: getfield 94	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   4198: invokevirtual 930	anxr:Y	(Ljava/lang/String;Ljava/lang/String;)I
    //   4201: istore 7
    //   4203: iload 7
    //   4205: ifeq -172 -> 4033
    //   4208: aload_0
    //   4209: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4212: invokevirtual 473	com/tencent/mobileqq/app/QQAppInterface:a	()Ltog;
    //   4215: aload 30
    //   4217: sipush 7000
    //   4220: iload 7
    //   4222: invokevirtual 482	tog:G	(Ljava/lang/String;II)V
    //   4225: aload_0
    //   4226: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4229: invokevirtual 485	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   4232: iconst_2
    //   4233: anewarray 87	java/lang/String
    //   4236: dup
    //   4237: iconst_0
    //   4238: getstatic 490	acbn:bku	Ljava/lang/String;
    //   4241: aastore
    //   4242: dup
    //   4243: iconst_1
    //   4244: aload 30
    //   4246: aastore
    //   4247: invokevirtual 496	com/tencent/imcore/message/QQMessageFacade:as	(Ljava/lang/Object;)V
    //   4250: goto -217 -> 4033
    //   4253: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4256: ifeq +18 -> 4274
    //   4259: aload 26
    //   4261: ifnull +153 -> 4414
    //   4264: ldc_w 298
    //   4267: iconst_2
    //   4268: ldc_w 932
    //   4271: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4274: aload 32
    //   4276: ifnull +12 -> 4288
    //   4279: aload 32
    //   4281: aload 30
    //   4283: aload 26
    //   4285: invokevirtual 325	anxr:C	(Ljava/lang/String;[B)V
    //   4288: new 381	java/util/HashMap
    //   4291: dup
    //   4292: invokespecial 382	java/util/HashMap:<init>	()V
    //   4295: astore_2
    //   4296: aload_2
    //   4297: ldc_w 384
    //   4300: ldc_w 934
    //   4303: invokevirtual 390	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4306: pop
    //   4307: aload_2
    //   4308: ldc_w 392
    //   4311: ldc_w 936
    //   4314: invokevirtual 390	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4317: pop
    //   4318: aload_2
    //   4319: ldc_w 396
    //   4322: ldc_w 398
    //   4325: invokevirtual 390	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4328: pop
    //   4329: invokestatic 401	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4332: invokestatic 406	anpc:a	(Landroid/content/Context;)Lanpc;
    //   4335: aload_0
    //   4336: getfield 15	acrl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4339: invokevirtual 409	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4342: ldc_w 411
    //   4345: iconst_1
    //   4346: lconst_0
    //   4347: lconst_0
    //   4348: aload_2
    //   4349: ldc 126
    //   4351: invokevirtual 415	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   4354: iload 4
    //   4356: ifle +86 -> 4442
    //   4359: lload 18
    //   4361: lconst_0
    //   4362: lcmp
    //   4363: ifle +64 -> 4427
    //   4366: aload_1
    //   4367: getfield 331	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4370: ldc_w 938
    //   4373: invokevirtual 338	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4376: astore_1
    //   4377: aload_1
    //   4378: ifnull +64 -> 4442
    //   4381: aload_0
    //   4382: iload 4
    //   4384: iload 5
    //   4386: lload 18
    //   4388: invokestatic 90	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4391: aload_1
    //   4392: aload 28
    //   4394: invokevirtual 941	acrl:a	(BILjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   4397: aload 29
    //   4399: iconst_0
    //   4400: putfield 944	anxs:cKz	Z
    //   4403: aload_0
    //   4404: sipush 8003
    //   4407: iconst_1
    //   4408: aload 29
    //   4410: invokevirtual 177	acrl:b	(IZLjava/lang/Object;)V
    //   4413: return
    //   4414: ldc_w 298
    //   4417: iconst_2
    //   4418: ldc_w 946
    //   4421: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4424: goto -150 -> 4274
    //   4427: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4430: ifeq +12 -> 4442
    //   4433: ldc 60
    //   4435: iconst_2
    //   4436: ldc_w 948
    //   4439: invokestatic 950	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4442: aload 29
    //   4444: iconst_0
    //   4445: putfield 174	anxs:errorType	I
    //   4448: aload_0
    //   4449: sipush 8003
    //   4452: iconst_1
    //   4453: aload 29
    //   4455: invokevirtual 177	acrl:b	(IZLjava/lang/Object;)V
    //   4458: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4461: ifeq -4143 -> 318
    //   4464: ldc_w 298
    //   4467: iconst_2
    //   4468: ldc_w 952
    //   4471: invokestatic 307	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4474: return
    //   4475: astore_3
    //   4476: goto -1722 -> 2754
    //   4479: astore_3
    //   4480: goto -1798 -> 2682
    //   4483: aconst_null
    //   4484: astore_2
    //   4485: goto -1324 -> 3161
    //   4488: goto -1460 -> 3028
    //   4491: iconst_0
    //   4492: istore 8
    //   4494: goto -1552 -> 2942
    //   4497: goto -3006 -> 1491
    //   4500: aconst_null
    //   4501: astore 27
    //   4503: goto -3038 -> 1465
    //   4506: lconst_0
    //   4507: lstore 18
    //   4509: goto -3061 -> 1448
    //   4512: iconst_1
    //   4513: istore 6
    //   4515: iconst_0
    //   4516: istore 4
    //   4518: goto -3089 -> 1429
    //   4521: iconst_2
    //   4522: istore 5
    //   4524: goto -3108 -> 1416
    //   4527: aconst_null
    //   4528: astore 26
    //   4530: goto -3133 -> 1397
    //   4533: goto -3960 -> 573
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4536	0	this	acrl
    //   0	4536	1	paramToServiceMsg	ToServiceMsg
    //   0	4536	2	paramFromServiceMsg	FromServiceMsg
    //   0	4536	3	paramObject	Object
    //   1424	3093	4	b	byte
    //   439	4084	5	i	int
    //   1427	3087	6	j	int
    //   1510	2711	7	k	int
    //   2013	2480	8	m	int
    //   1587	2358	9	n	int
    //   2034	1819	10	i1	int
    //   3768	96	11	i2	int
    //   801	3104	12	bool1	boolean
    //   3254	686	13	bool2	boolean
    //   1077	1503	14	l1	long
    //   1070	2359	16	l2	long
    //   1446	3062	18	l3	long
    //   1554	2400	20	l4	long
    //   2799	1153	22	l5	long
    //   1544	2384	24	l6	long
    //   82	4447	26	localObject1	Object
    //   142	84	27	localStringBuilder	StringBuilder
    //   1177	3	27	localException1	Exception
    //   1463	3039	27	localList1	List
    //   1475	2918	28	localArrayList	ArrayList
    //   7	4447	29	localanxs	anxs
    //   19	4263	30	str1	String
    //   25	4092	31	str2	String
    //   410	3870	32	localanxr	anxr
    //   1498	2662	33	localHashMap	java.util.HashMap
    //   1507	18	34	localList2	List
    //   1832	863	35	localanax	anax
    //   1963	13	36	localIterator1	Iterator
    //   1985	1941	37	localObject2	Object
    //   2003	1706	38	localObject3	Object
    //   2780	486	39	localStringBuffer	java.lang.StringBuffer
    //   2807	16	40	localIterator2	Iterator
    //   2974	3	41	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   84	107	319	java/lang/Exception
    //   107	123	319	java/lang/Exception
    //   1072	1079	1177	java/lang/Exception
    //   1211	1223	1325	java/lang/Exception
    //   2469	2508	2679	java/lang/Exception
    //   2691	2700	2751	java/lang/Exception
    //   2879	2895	2974	java/lang/Exception
    //   2704	2740	4475	java/lang/Exception
    //   2510	2543	4479	java/lang/Exception
  }
  
  private void ip(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null)) {}
    Object localObject;
    label222:
    String str;
    int i;
    int j;
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare() req = " + paramToServiceMsg);
          }
          if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare() resultCode = " + paramFromServiceMsg.getResultCode() + " isSuccess = " + paramFromServiceMsg.isSuccess() + " resp = " + paramFromServiceMsg);
          }
          localObject = new oidb_sso.OIDBSSOPkg();
          try
          {
            localObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
            if ((localObject != null) && (((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() != null) && (((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get() == 1)) {
              break label222;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare ssoPkg check error");
              return;
            }
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare ssoPkg.mergeFrom exception");
      return;
      paramObject = new Oidb_0x5d0.RspBody();
      try
      {
        paramObject.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
        if (QLog.isColorLevel()) {
          QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare  contentItem.size=" + paramObject.rpt_msg_contentItem.size());
        }
        localObject = String.valueOf(paramObject.uint64_uin.get());
        paramToServiceMsg = String.valueOf(paramToServiceMsg.getAttribute("subaccount"));
        str = paramFromServiceMsg.getUin();
        i = paramObject.uint32_sys_time.get();
        j = paramObject.uint32_advise_gap.get();
        if (QLog.isColorLevel()) {
          QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare  contentItem.size=" + paramObject.rpt_msg_contentItem.get().size() + "  rspBody.uin=" + String.valueOf(paramObject.uint64_uin.get()) + "  resp.getUin()=" + paramFromServiceMsg.getUin() + "  sysTime=" + i + " adviseGap=" + j);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"0".equals(localObject)) && (TextUtils.equals((CharSequence)localObject, paramToServiceMsg)) && (TextUtils.equals(str, this.app.getCurrentUin()))) {
          break;
        }
        QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare req or resp params error");
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare  rspBody==null");
    return;
    new acrn(this, paramObject, str, (String)localObject, i, j).execute(new Void[0]);
  }
  
  String a(MessageRecord paramMessageRecord, String paramString)
  {
    String str = paramString;
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      str = paramString;
      if (paramMessageRecord.structingMsg != null) {
        str = paramMessageRecord.structingMsg.mMsgBrief;
      }
    }
    paramMessageRecord = str;
    if (TextUtils.isEmpty(str)) {
      paramMessageRecord = this.app.getApp().getResources().getString(2131720589);
    }
    return paramMessageRecord;
  }
  
  public void a(byte paramByte, int paramInt, String paramString1, String paramString2, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() start, subUin=" + paramString1);
    }
    ToServiceMsg localToServiceMsg = this.a.createToServiceMsg("MessageSvc.PbBindUinGetMsg");
    localToServiceMsg.extraData.putByte("cChannel", paramByte);
    localToServiceMsg.extraData.putInt("cSyncFlag", paramInt);
    localToServiceMsg.extraData.putBoolean("isSubAccount", true);
    localToServiceMsg.extraData.putString("subAccount", paramString1);
    localToServiceMsg.extraData.putString("subaccount_a2", paramString2);
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      localToServiceMsg.extraData.putStringArrayList("hadGetMsgListUin", paramArrayList);
    }
    paramArrayList = (anxr)this.app.getManager(61);
    if (paramArrayList != null) {}
    for (paramArrayList = paramArrayList.aa(paramString1);; paramArrayList = null)
    {
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
            localPbBindUinGetMsgReq.bind_uin_sig.set(ByteStringMicro.copyFrom(aqoj.ag(paramString2)));
            if (paramArrayList == null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() cookie=" + paramArrayList.length);
            }
            localPbBindUinGetMsgReq.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayList));
            localPbBindUinGetMsgReq.sync_flag.set(paramInt);
            localToServiceMsg.putWupBuffer(localPbBindUinGetMsgReq.toByteArray());
            this.a.sendPbReq(localToServiceMsg);
            return;
            paramString1 = paramString1;
            paramString1.printStackTrace();
          } while (!QLog.isColorLevel());
          QLog.e("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() subAccount is null or not a long");
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() cookie = null");
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountMessageProcessor processError");
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount cmd =  CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handlerGetSubAccountError end");
    }
    paramFromServiceMsg = new anxs();
    String str = paramToServiceMsg.extraData.getString("subAccount");
    paramFromServiceMsg.aLa = paramToServiceMsg.getUin();
    paramFromServiceMsg.aQf = str;
    paramFromServiceMsg.errorType = 1001;
    b(8003, false, paramFromServiceMsg);
  }
  
  public void a(RequestPushNotify paramRequestPushNotify)
  {
    Object localObject = paramRequestPushNotify.stMsgInfo;
    if (528 == ((MsgInfo)localObject).shMsgType)
    {
      localObject = anas.a(((MsgInfo)localObject).vMsg);
      if ((localObject != null) && (((MsgType0x210)localObject).vProtobuf != null)) {
        break label35;
      }
    }
    label35:
    do
    {
      do
      {
        return;
      } while ((((MsgType0x210)localObject).uSubMsgType != 138L) && (((MsgType0x210)localObject).uSubMsgType != 139L));
      Submsgtype0x8a.ReqBody localReqBody = new Submsgtype0x8a.ReqBody();
      try
      {
        localReqBody.mergeFrom(((MsgType0x210)localObject).vProtobuf);
        ancp.a(this.app, localReqBody, paramRequestPushNotify.lBindedUin, true);
        return;
      }
      catch (Exception paramRequestPushNotify) {}
    } while (!QLog.isColorLevel());
    QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b sub account msg, prase reqBody error");
  }
  
  public boolean a(SubAccountInfo paramSubAccountInfo)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, "getSubAccountSpecialCareList()");
    }
    if ((paramSubAccountInfo == null) || (TextUtils.isEmpty(paramSubAccountInfo.subuin))) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      Object localObject1 = new Oidb_0x5d0.ReqBody();
      Object localObject2 = new ArrayList();
      ((List)localObject2).add(Integer.valueOf(9));
      ((Oidb_0x5d0.ReqBody)localObject1).rpt_uint32_fieldlist.set((List)localObject2);
      ((Oidb_0x5d0.ReqBody)localObject1).uint32_start_time.set(anxk.d(this.app, this.app.getCurrentUin(), paramSubAccountInfo.subuin));
      try
      {
        long l = Long.parseLong(paramSubAccountInfo.subuin);
        ((Oidb_0x5d0.ReqBody)localObject1).uint64_bind_uin.set(l);
        localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1488);
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
        ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x5d0.ReqBody)localObject1).toByteArray()));
        if (QLog.isColorLevel()) {
          QLog.d("SubAccountMessageProcessor", 2, "getSubAccountSpecialCareList() uin = " + paramSubAccountInfo.subuin);
        }
        localObject1 = this.a.createToServiceMsg("OidbSvc.0x5d0_1");
        ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
        ((ToServiceMsg)localObject1).setTimeout(60000L);
        ((ToServiceMsg)localObject1).addAttribute("from_where", "subaccount");
        ((ToServiceMsg)localObject1).addAttribute("subaccount", paramSubAccountInfo.subuin);
        if (QLog.isColorLevel()) {
          QLog.d("SubAccountMessageProcessor", 2, "getSubAccountSpecialCareList() before send request = " + localObject1);
        }
        this.a.sendPbReq((ToServiceMsg)localObject1);
        if (QLog.isColorLevel())
        {
          QLog.d("SubAccountMessageProcessor", 2, "getSubAccountSpecialCareList() after send request = " + localObject1);
          return true;
        }
      }
      catch (NumberFormatException paramSubAccountInfo)
      {
        paramSubAccountInfo.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "getSubAccountSpecialCareList subAccount parselong error ");
        }
      }
    }
    return false;
  }
  
  public void aD(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumTimeOut");
    }
    paramToServiceMsg = new anxt();
    paramToServiceMsg.ciC = this.app.getAccount();
    paramToServiceMsg.errorType = 1;
    this.a.notifyUI(8024, false, paramToServiceMsg);
  }
  
  public void aE(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumError");
    }
    paramToServiceMsg = new anxt();
    paramToServiceMsg.ciC = this.app.getAccount();
    this.a.notifyUI(8024, false, paramToServiceMsg);
  }
  
  String b(MessageRecord paramMessageRecord, String paramString)
  {
    if (acei.W(paramMessageRecord)) {
      return this.app.getApp().getResources().getString(2131692311);
    }
    if ((paramMessageRecord instanceof MessageForPic)) {
      return ((MessageForPic)paramMessageRecord).getSummaryMsg();
    }
    return this.app.getApp().getResources().getString(2131692315);
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountMessageProcessor processTimeOut");
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount cmd =  CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handlerGetSubAccountTimeout end");
    }
    paramFromServiceMsg = new anxs();
    String str = paramToServiceMsg.extraData.getString("subAccount");
    paramFromServiceMsg.aLa = paramToServiceMsg.getUin();
    paramFromServiceMsg.aQf = str;
    paramFromServiceMsg.errorType = 1007;
    b(8003, false, paramFromServiceMsg);
  }
  
  String c(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = paramMessageRecord.msg;
    paramString = null;
    paramMessageRecord = paramString;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("/");
        paramMessageRecord = paramString;
        if (localObject != null)
        {
          paramMessageRecord = paramString;
          if (localObject.length > 0)
          {
            localObject = localObject[(localObject.length - 1)].split("\\|");
            paramMessageRecord = paramString;
            if (localObject != null)
            {
              paramMessageRecord = paramString;
              if (localObject.length > 0) {
                paramMessageRecord = localObject[0];
              }
            }
          }
        }
      }
    }
    catch (Exception paramMessageRecord)
    {
      do
      {
        for (;;)
        {
          paramMessageRecord.printStackTrace();
          paramMessageRecord = paramString;
        }
        paramString = paramMessageRecord;
      } while (paramMessageRecord.equalsIgnoreCase(this.app.getApp().getResources().getString(2131692310)));
    }
    if (TextUtils.isEmpty(paramMessageRecord))
    {
      paramString = this.app.getApp().getResources().getString(2131692310);
      return paramString;
    }
    return this.app.getApp().getResources().getString(2131692310) + paramMessageRecord;
  }
  
  String d(MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramMessageRecord instanceof MessageForPubAccount)) {}
    for (;;)
    {
      try
      {
        paramString = ((MessageForPubAccount)paramMessageRecord).mPAMessage;
        if (paramString == null) {
          return null;
        }
        paramMessageRecord = ((PAMessage.Item)paramString.items.get(0)).title;
        if ((((PAMessage.Item)paramString.items.get(0)).cover != null) || (((PAMessage.Item)paramString.items.get(0)).digestList == null)) {
          continue;
        }
        paramMessageRecord = paramMessageRecord + "：" + (String)((PAMessage.Item)paramString.items.get(0)).digestList.get(0);
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SUB_ACCOUNT", 2, "subaccount handlerMsgPB, MSG_TYPE_PUBLIC_ACCOUNT error e = " + paramMessageRecord.getMessage());
        paramMessageRecord = null;
        continue;
      }
      return paramMessageRecord;
      continue;
      paramMessageRecord = paramString;
    }
  }
  
  public void dX(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, "subaccount handleGetSubAccountTroop error");
    }
  }
  
  String e(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject;
    try
    {
      if (aqfw.mn(paramMessageRecord.msgtype))
      {
        paramMessageRecord = aqfw.a(paramMessageRecord.msg);
        localObject = paramString;
        if (paramMessageRecord != null)
        {
          if ((paramMessageRecord.actMsgContentValue != null) && (paramMessageRecord.actMsgContentValue.length() > 0)) {
            return paramMessageRecord.actMsgContentValue;
          }
          paramMessageRecord = this.app.a().a(aqgb.bM(paramMessageRecord.shareAppID));
          return this.app.getApp().getString(2131690420) + paramMessageRecord.messagetail + this.app.getApp().getString(2131690421);
        }
      }
      else
      {
        localObject = paramString;
        if (!aqfw.fJ(paramMessageRecord.msgtype))
        {
          localObject = paramString;
          if (paramMessageRecord.msg != null)
          {
            localObject = paramString;
            if (paramMessageRecord.msg.indexOf("http://maps.google.com/maps?q=") != -1)
            {
              localObject = anbk.r(paramMessageRecord.msg);
              paramString = "";
              paramMessageRecord = paramString;
              if (localObject != null)
              {
                paramMessageRecord = paramString;
                if (localObject[2] != null) {
                  paramMessageRecord = localObject[2];
                }
              }
              paramMessageRecord = "[" + this.app.getApp().getString(2131721250) + "] " + paramMessageRecord;
              return paramMessageRecord;
            }
          }
        }
      }
    }
    catch (Exception paramString)
    {
      paramMessageRecord = null;
      paramString.printStackTrace();
      localObject = paramMessageRecord;
      if (QLog.isColorLevel())
      {
        QLog.d("SUB_ACCOUNT", 2, "subaccount handlerMsgPB, MSG_TYPE_PUBLIC_ACCOUNT error e = " + paramString.getMessage());
        localObject = paramMessageRecord;
      }
    }
    return localObject;
  }
  
  String f(MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramMessageRecord instanceof MessageForMarketFace))
    {
      paramMessageRecord = ((MessageForMarketFace)paramMessageRecord).mMarkFaceMessage;
      if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramMessageRecord.faceName))) {
        return "[" + paramMessageRecord.faceName + "]";
      }
      return this.app.getApp().getResources().getString(2131693094);
    }
    return this.app.getApp().getResources().getString(2131693094);
  }
  
  public void f(int paramInt, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountMessageProcessor processResponse");
    }
    switch (paramInt)
    {
    }
    aeoa localaeoa;
    do
    {
      do
      {
        return;
        if ((paramVarArgs != null) && (paramVarArgs.length == 3))
        {
          io((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
          return;
        }
        bN(getClass().getName(), paramInt);
        return;
        if ((paramVarArgs != null) && (paramVarArgs.length == 3))
        {
          in((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
          return;
        }
        bN(getClass().getName(), paramInt);
        return;
        if ((paramVarArgs != null) && (paramVarArgs.length == 3))
        {
          ip((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SUB_ACCOUNT", 2, "subaccount cmd=CMD_MESSAGESERVICE_SUBACCOUNT_SPECIAL_CARE GetSubAccountSpecialCare error");
      return;
      localaeoa = (aeoa)aeif.a().o(607);
    } while ((localaeoa == null) || (localaeoa.bVj));
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      c((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2]);
      return;
    }
    dX(getClass().getName(), paramInt);
  }
  
  public void fi(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() subAccount=" + paramString1);
    }
    long l;
    try
    {
      l = Long.parseLong(paramString1);
      if (l <= 10000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() return, lSubUin=" + l);
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        l = 0L;
      }
      localObject = (anxr)this.app.getManager(61);
      if (localObject == null) {}
    }
    for (Object localObject = ((anxr)localObject).aa(paramString1);; localObject = null)
    {
      ToServiceMsg localToServiceMsg = this.a.createToServiceMsg("PbMessageSvc.PbBindUinMsgReadedConfirm");
      localToServiceMsg.extraData.putBoolean("isSubAccount", true);
      localToServiceMsg.extraData.putString("subAccount", paramString1);
      localToServiceMsg.extraData.putString("nextAction", paramString2);
      paramString1 = new msg_svc.PbBindUinMsgReadedConfirmReq();
      paramString1.bind_uin.set(l);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() getSubAccoundMsg_PB  syncCookie=" + Integer.toString(localObject.length));
        }
        paramString1.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      for (;;)
      {
        localToServiceMsg.putWupBuffer(paramString1.toByteArray());
        this.a.sendPbReq(localToServiceMsg);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() getSubAccoundMsg_PB  cookie = null");
        }
      }
    }
  }
  
  public void i(boolean paramBoolean, ArrayList<SimpleAccount> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("getThirdQQUnreadMsgNum_PB isCronJob = ").append(paramBoolean).append(" thirdAccount size = ");
      if (paramArrayList != null) {
        break label110;
      }
    }
    label110:
    for (int i = 0;; i = paramArrayList.size())
    {
      QLog.d("SubAccountMessageProcessor", 2, i);
      if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
        break;
      }
      paramArrayList = new anxt();
      paramArrayList.ciC = this.app.getAccount();
      if (QLog.isColorLevel()) {
        QLog.e("SubAccountMessageProcessor", 2, "getThirdQQUnreadMsgNum_PB error no third account");
      }
      this.a.notifyUI(8024, false, paramArrayList);
      return;
    }
    TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
    WtloginManager localWtloginManager = (WtloginManager)this.app.getManager(1);
    Object localObject1 = new msg_svc.PbUnReadMsgSeqReq();
    msg_svc.PbThirdQQUnReadMsgNumReq localPbThirdQQUnReadMsgNumReq = new msg_svc.PbThirdQQUnReadMsgNumReq();
    long l1 = anaz.gQ();
    if ((localTicketManager != null) && (localWtloginManager != null))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject2 = (SimpleAccount)paramArrayList.next();
        if (localObject2 != null)
        {
          try
          {
            msg_svc.PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo localThirdQQReqInfo = new msg_svc.PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo();
            localObject2 = ((SimpleAccount)localObject2).getUin();
            Object localObject3 = localTicketManager.getA2((String)localObject2);
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty(((String)localObject3).trim()))) {
              continue;
            }
            Ticket localTicket = localWtloginManager.GetLocalTicket((String)localObject2, 16L, 64);
            if ((localTicket == null) || (l1 > localTicket._expire_time)) {
              continue;
            }
            long l2 = Long.parseLong((String)localObject2);
            localThirdQQReqInfo.third_uin.set(l2);
            localThirdQQReqInfo.third_uin_sig.set(ByteStringMicro.copyFrom(aqoj.ag((String)localObject3)));
            localObject3 = anxk.a(this.app, (String)localObject2);
            if (localObject3 != null) {
              localThirdQQReqInfo.third_uin_cookie.set(ByteStringMicro.copyFrom((byte[])localObject3));
            }
            if (QLog.isColorLevel()) {
              QLog.d("SubAccountMessageProcessor", 2, "getThirdQQUnreadMsgNum_PB third uin = " + (String)localObject2);
            }
            localPbThirdQQUnReadMsgNumReq.thirdqq_req_info.add(localThirdQQReqInfo);
          }
          catch (NumberFormatException localNumberFormatException) {}
          if (QLog.isColorLevel()) {
            QLog.e("SubAccountMessageProcessor", 2, "getThirdQQUnreadMsgNum_PB error " + localNumberFormatException.getMessage());
          }
        }
      }
    }
    if ((!localPbThirdQQUnReadMsgNumReq.thirdqq_req_info.has()) || (localPbThirdQQUnReadMsgNumReq.thirdqq_req_info.get() == null) || (localPbThirdQQUnReadMsgNumReq.thirdqq_req_info.get().size() == 0))
    {
      paramArrayList = new anxt();
      paramArrayList.ciC = this.app.getAccount();
      if (QLog.isColorLevel()) {
        QLog.e("SubAccountMessageProcessor", 2, "getThirdQQUnreadMsgNum_PB error no third qq info");
      }
      this.a.notifyUI(8024, false, paramArrayList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, "getThirdQQUnreadMsgNum_PB really send msg to service");
    }
    paramArrayList = localPbThirdQQUnReadMsgNumReq.source;
    if (paramBoolean) {}
    for (i = 1;; i = 2)
    {
      paramArrayList.set(i);
      ((msg_svc.PbUnReadMsgSeqReq)localObject1).thirdqq_unread_info.set(localPbThirdQQUnReadMsgNumReq);
      paramArrayList = new ToServiceMsg("mobileqq.service", this.app.getCurrentUin(), "PbMessageSvc.PbUnReadMsgSeq");
      paramArrayList.extraData.putString("action", "getThirdQQUnreadNum");
      paramArrayList.extraData.putString("mainAccount", this.app.getAccount());
      paramArrayList.putWupBuffer(((msg_svc.PbUnReadMsgSeqReq)localObject1).toByteArray());
      this.a.sendPbReq(paramArrayList);
      return;
    }
  }
  
  public void iq(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      aE(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    Object localObject = new msg_svc.PbUnReadMsgSeqResp();
    try
    {
      paramObject = (msg_svc.PbUnReadMsgSeqResp)((msg_svc.PbUnReadMsgSeqResp)localObject).mergeFrom((byte[])paramObject);
      if ((!paramObject.thirdqq_unread_info.has()) || (paramObject.thirdqq_unread_info.get() == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("SubAccountMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumResp_PB: server did not return thirdqq_unread_info");
        }
        aE(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SubAccountMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumResp_PB: server did not return a valid response");
      }
      aE(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    paramObject = (msg_svc.PbThirdQQUnReadMsgNumResp)paramObject.thirdqq_unread_info.get();
    if ((paramObject.result.get() != 0) || (paramObject.thirdqq_resp_info.get() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumResp_PB unreadNumSeqResp.result: " + paramObject.result.get() + " ,unreadNumSeqResp.errmsg: " + paramObject.errmsg.get() + " or thirdqq_resp_info is null");
      }
      aE(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    paramFromServiceMsg = new anxt();
    int i = paramObject.result.get();
    localObject = paramObject.errmsg.get();
    int j = paramObject.interval.get();
    paramFromServiceMsg.interval = j;
    paramFromServiceMsg.errorMsg = ((String)localObject);
    paramFromServiceMsg.result = i;
    paramToServiceMsg = paramToServiceMsg.extraData.getString("mainAccount");
    paramFromServiceMsg.ciC = paramToServiceMsg;
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumResp_PB: result  interval=" + j + " errmsg=" + (String)localObject + " result=" + i);
    }
    long l = anaz.gQ();
    i = 0;
    while (i < paramObject.thirdqq_resp_info.get().size())
    {
      localObject = (msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)paramObject.thirdqq_resp_info.get().get(i);
      String str = String.valueOf(((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).third_uin.get());
      byte[] arrayOfByte = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).third_uin_cookie.get().toByteArray();
      int k = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).msg_num.get();
      int m = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).msg_flag.get();
      int n = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).redbag_time.get();
      int i1 = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).status.get();
      int i2 = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).last_msg_time.get();
      if ((paramFromServiceMsg.dNj < i2) && (i2 <= l)) {
        paramFromServiceMsg.dNj = i2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumResp_PB: thirdUin=" + str + " num=" + k + " flag=" + m + " redbagtime=" + n + " status=" + i1 + " lastmsgtime=" + i2 + "  cookie=" + arrayOfByte);
      }
      anxk.a(this.app, paramToServiceMsg, str, arrayOfByte, k, m, n, i1, i2);
      i += 1;
    }
    anxk.H(this.app, paramToServiceMsg, j);
    this.a.notifyUI(8024, true, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acrl
 * JD-Core Version:    0.7.0.1
 */