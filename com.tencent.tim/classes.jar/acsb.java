import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor.2;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor.3;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.c;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.MessageRecord;>;
import msf.msgsvc.msg_svc.PbC2CMsgWithDrawReq;
import msf.msgsvc.msg_svc.PbC2CMsgWithDrawReq.MsgInfo;
import msf.msgsvc.msg_svc.PbC2CMsgWithDrawResp;
import msf.msgsvc.msg_svc.PbDelRoamMsgReq;
import msf.msgsvc.msg_svc.PbDelRoamMsgReq.C2CMsg;
import msf.msgsvc.msg_svc.PbDelRoamMsgReq.DisMsg;
import msf.msgsvc.msg_svc.PbDelRoamMsgReq.GrpMsg;
import msf.msgsvc.msg_svc.PbDelRoamMsgResp;
import msf.msgsvc.msg_svc.PbGroupMsgWithDrawReq;
import msf.msgsvc.msg_svc.PbGroupMsgWithDrawReq.MessageInfo;
import msf.msgsvc.msg_svc.PbGroupMsgWithDrawResp;
import msf.msgsvc.msg_svc.PbGroupMsgWithDrawResp.MessageResult;
import msf.msgsvc.msg_svc.PbMsgWithDrawReq;
import msf.msgsvc.msg_svc.PbMsgWithDrawResp;
import msf.msgsvc.msg_svc.PbSendMsgResp;
import msf.msgsvc.msg_svc.RoutingHead;
import msg.blessing_helper.blessing_helper.msg;
import tencent.im.msgrevoke.msgrevoke_userdef.MsgInfoUserDef;
import tencent.im.msgrevoke.msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef;
import tencent.im.msgrevoke.msgrevoke_userdef.UinTypeUserDef;

public class acsb
  extends tnv
{
  public static int czA = 6;
  public static int czB = 1;
  public static int czC = 2;
  public static int czD = 3;
  public static int czE = 1;
  public static int czF = 2;
  public static int czG = 3;
  public static int czH = -1;
  public static int czI = -2;
  public static int czJ = 1;
  public static int czK = 2;
  public static int czv = 1;
  public static int czw = 2;
  public static int czx = 3;
  public static int czy = 4;
  public static int czz = 5;
  private EmojiStickerManager.c a;
  private final int czL = 12;
  private final int czM = 6;
  private final int czN = 1080000;
  
  public acsb(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private void a(MessageRecord paramMessageRecord, long paramLong1, long paramLong2, int paramInt)
  {
    long l = System.currentTimeMillis();
    int j = paramMessageRecord.istroop;
    int i = anbk.ac(paramMessageRecord.msgUid);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.UncommonMessageProcessor", 2, "<DELMSG><S>--->deleteMsgFromServerInner : uinType:" + paramMessageRecord.istroop + " peerUin:" + paramMessageRecord.frienduin + " msgType:" + paramMessageRecord.msgtype + " uniseq:" + paramMessageRecord.uniseq + " reqSeq:" + paramLong1 + " msgSeq:" + paramMessageRecord.shmsgseq + " random:" + i + " msgTime:" + paramMessageRecord.time + " msgUid:" + paramMessageRecord.msgUid + " mr.longMsgCount:" + paramMessageRecord.longMsgCount + " longMsgIndex:" + paramMessageRecord.longMsgIndex + " longMsgId:" + paramMessageRecord.longMsgId);
    }
    if (paramMessageRecord.frienduin == null)
    {
      QLog.d("Q.msg.UncommonMessageProcessor", 1, new Object[] { "deleteMsgFromServerInner error, istroop:", Integer.valueOf(paramMessageRecord.istroop), " msgtype:", Integer.valueOf(paramMessageRecord.msgtype) });
      return;
    }
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("PbMessageSvc.PbDelOneRoamMsg");
    localToServiceMsg.extraData.putLong("timeOut", paramLong2);
    localToServiceMsg.extraData.putLong("startTime", l);
    localToServiceMsg.extraData.putInt("retryIndex", paramInt);
    localToServiceMsg.extraData.putInt("uintype", j);
    localToServiceMsg.extraData.putString("peeruin", paramMessageRecord.frienduin);
    localToServiceMsg.extraData.putLong("uniseq", paramMessageRecord.uniseq);
    localToServiceMsg.extraData.putLong("seq", paramMessageRecord.shmsgseq);
    localToServiceMsg.extraData.putLong("msgSeq", paramLong1);
    msg_svc.PbDelRoamMsgReq localPbDelRoamMsgReq = new msg_svc.PbDelRoamMsgReq();
    Object localObject;
    if ((j == 0) || (j == 1000) || (j == 1004))
    {
      paramInt = (short)(int)paramMessageRecord.shmsgseq;
      localToServiceMsg.extraData.putInt("msgrandom", i);
      String str = this.app.getCurrentAccountUin();
      localObject = new msg_svc.PbDelRoamMsgReq.C2CMsg();
      ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject).peer_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject).from_uin.set(Long.valueOf(str).longValue());
      ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject).msg_time.set((int)paramMessageRecord.time);
      ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject).msg_seq.set(0xFFFF & paramInt);
      ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject).msg_random.set(i);
      localPbDelRoamMsgReq.c2c_msg.set((MessageMicro)localObject);
      if (paramMessageRecord.msgtype == -2005)
      {
        paramMessageRecord = this.app.a().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, 0);
        if ((paramMessageRecord != null) && (paramMessageRecord.nOLfileSessionId != 0L))
        {
          ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject).msg_time.set((int)paramMessageRecord.msgTime);
          paramInt = (short)(int)paramMessageRecord.msgSeq;
          ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject).msg_seq.set(paramInt & 0xFFFFFFFF);
          ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject).msg_random.set(anbk.ac(paramMessageRecord.msgUid));
        }
      }
    }
    for (;;)
    {
      localToServiceMsg.putWupBuffer(localPbDelRoamMsgReq.toByteArray());
      localToServiceMsg.setTimeout(paramLong2);
      localToServiceMsg.setEnableFastResend(true);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.o(localToServiceMsg);
      return;
      if (j == 1)
      {
        localObject = new msg_svc.PbDelRoamMsgReq.GrpMsg();
        ((msg_svc.PbDelRoamMsgReq.GrpMsg)localObject).group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        ((msg_svc.PbDelRoamMsgReq.GrpMsg)localObject).msg_seq.set(Long.valueOf(paramMessageRecord.shmsgseq).longValue());
        if (((paramMessageRecord instanceof MessageForReplyText)) && (((MessageForReplyText)paramMessageRecord).isBarrageMsg))
        {
          ((msg_svc.PbDelRoamMsgReq.GrpMsg)localObject).uint32_resv_flag.set(1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.UncommonMessageProcessor", 2, "delete single msg, isBarrageMsg");
          }
        }
        localPbDelRoamMsgReq.grp_msg.set((MessageMicro)localObject);
      }
      else if (j == 3000)
      {
        localObject = new msg_svc.PbDelRoamMsgReq.DisMsg();
        ((msg_svc.PbDelRoamMsgReq.DisMsg)localObject).discuss_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        ((msg_svc.PbDelRoamMsgReq.DisMsg)localObject).msg_seq.set(paramMessageRecord.shmsgseq);
        localPbDelRoamMsgReq.dis_msg.set((MessageMicro)localObject);
      }
    }
  }
  
  private void aG(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    long l2 = paramToServiceMsg.extraData.getLong("msgSeq");
    int i = paramToServiceMsg.extraData.getInt("msgtype");
    boolean bool = paramToServiceMsg.extraData.getBoolean(anbb.ccQ);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.UncommonMessageProcessor", 2, "<---handleSendBlessMessageError: ---cmd:" + str + " uniseq:" + l1 + " msgSeq:" + l2 + " msgType:" + i + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq() + " appseq:" + paramFromServiceMsg.getAppSeq() + " isRedBagVideo:" + bool);
    }
    int j = paramFromServiceMsg.getResultCode();
    if (j == 2901)
    {
      l2 = System.currentTimeMillis();
      long l3 = paramToServiceMsg.extraData.getLong("key_msg_info_time_start", 0L);
      l2 = paramToServiceMsg.getTimeout() - (l2 - l3);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.UncommonMessageProcessor", 2, "handleSendBlessMessageError, 2901 error, resend timeout: " + l2);
      }
      if (l2 > 0L)
      {
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("MessageSvc.PbMultiMsgSend");
        paramFromServiceMsg.extraData.putLong("uniseq", l1);
        paramFromServiceMsg.extraData.putInt("msgtype", i);
        paramFromServiceMsg.extraData.putLong("key_msg_info_time_start", System.currentTimeMillis());
        paramFromServiceMsg.setTimeout(l2);
        paramFromServiceMsg.putWupBuffer(paramToServiceMsg.getWupBuffer());
        paramFromServiceMsg.setEnableFastResend(true);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.o(paramFromServiceMsg);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.f(8019, false, new Object[] { Integer.valueOf(j), Long.valueOf(0L), Boolean.valueOf(false) });
  }
  
  private void aH(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l = paramToServiceMsg.extraData.getLong("bless_sendreq_time");
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.f(8018, false, new Object[] { Integer.valueOf(0) });
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.UncommonMessageProcessor", 2, String.format("handleSendDirtyBlessTextCheckError, time: %d", new Object[] { Long.valueOf(l) }));
    }
  }
  
  private void aI(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("MARK_REQUEST_REVOKE_OR_DELETEMULTI ");
    String str;
    long l1;
    long l2;
    long l3;
    int j;
    if (i == 1)
    {
      ArrayList localArrayList = paramToServiceMsg.extraData.getParcelableArrayList("key_msg_info_revoke");
      str = ((RevokeMsgInfo)localArrayList.get(0)).frienduin;
      i = ((RevokeMsgInfo)localArrayList.get(0)).istroop;
      l1 = ((RevokeMsgInfo)localArrayList.get(0)).msguid;
      l2 = ((RevokeMsgInfo)localArrayList.get(0)).shmsgseq;
      l3 = ((RevokeMsgInfo)localArrayList.get(0)).time;
      j = paramFromServiceMsg.getResultCode();
      if (j == 2901)
      {
        long l4 = System.currentTimeMillis();
        long l5 = paramToServiceMsg.extraData.getLong("key_msg_info_time_start", 0L);
        l4 = paramToServiceMsg.getTimeout() - (l4 - l5);
        if (QLog.isColorLevel()) {
          QLog.d("revokeMsg", 2, "handleRevokeMsgError, 2901 error, resend timeout: " + l4);
        }
        if (l4 > 0L)
        {
          paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("PbMessageSvc.PbMsgWithDraw");
          paramFromServiceMsg.setTimeout(l4);
          paramFromServiceMsg.putWupBuffer(paramToServiceMsg.getWupBuffer());
          paramFromServiceMsg.extraData.putLong("key_msg_info_time_start", System.currentTimeMillis());
          paramFromServiceMsg.extraData.putParcelableArrayList("key_msg_info_revoke", localArrayList);
          paramFromServiceMsg.extraData.putInt("MARK_REQUEST_REVOKE_OR_DELETEMULTI ", 1);
          paramFromServiceMsg.setEnableFastResend(true);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.o(paramFromServiceMsg);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("revokeMsg", 2, String.format("handleRevokeMsgError,frienduin %s, istroop %s, msgUid %s, time %s, shmsgseq %s", new Object[] { str, Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2) }));
            }
            g(str, i, czy, j);
            return;
          } while (i != 2);
          l1 = paramToServiceMsg.extraData.getLong("msgSeq");
          l2 = paramToServiceMsg.extraData.getLong("timeOut");
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.ae(paramToServiceMsg, paramFromServiceMsg);
          paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l1);
        } while (paramToServiceMsg == null);
        if (paramFromServiceMsg.getResultCode() != 2901) {
          break;
        }
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
        paramToServiceMsg.getClass();
      } while (paramFromServiceMsg.a(paramToServiceMsg, "msf"));
    } while ((1080000L != l2) && (!paramToServiceMsg.aFa()));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.UncommonMessageProcessor", 2, "<---handleMultiDeleteMsgError : Failed at last.");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.hB(l1);
  }
  
  private void aJ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("seq");
    long l2 = paramToServiceMsg.extraData.getLong("uniseq");
    long l3 = paramToServiceMsg.extraData.getLong("timeOut");
    int i = paramToServiceMsg.extraData.getInt("uintype");
    int j = paramToServiceMsg.extraData.getInt("msgrandom");
    String str = paramToServiceMsg.extraData.getString("peeruin");
    long l4 = paramToServiceMsg.extraData.getLong("msgSeq");
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.UncommonMessageProcessor", 2, "<DELMSG><E><---handleDeleteMsgError : uinType :" + i + " uin:" + str + " seq:" + l1 + " uniseq:" + l2 + " random:" + j + " timeOut:" + l3 + " reqSeq:" + l4);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.ae(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l4);
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label226;
      }
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      paramToServiceMsg.getClass();
      if (!paramFromServiceMsg.a(paramToServiceMsg, "msf")) {
        break label226;
      }
    }
    label226:
    while ((1080000L != l3) && (!paramToServiceMsg.aFa())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.UncommonMessageProcessor", 2, "<---handleDeleteMsgError : Failed at last.");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.hB(l4);
  }
  
  public static void h(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("pm_uin", paramString);
    localHashMap.put("pm_uinType", String.valueOf(paramInt1));
    localHashMap.put("pm_errorType", String.valueOf(paramInt2));
    localHashMap.put("pm_errorSubType", String.valueOf(paramInt3));
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    anpc.a(BaseApplication.getContext()).collectPerformance(localAppInterface.getCurrentAccountUin(), "revokeMsgErrorTag", false, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.UncommonMessageProcessor", 2, String.format("Statistics TAG:%s, uin:%s, uinType:%d, errorType:%d, errorSubType:%d", new Object[] { "revokeMsgErrorTag", paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
  }
  
  private void iw(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l2 = paramToServiceMsg.extraData.getLong("uniseq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    int j = paramToServiceMsg.extraData.getInt("msgtype");
    boolean bool3 = paramToServiceMsg.extraData.getBoolean(anbb.ccQ);
    paramToServiceMsg = new msg_svc.PbSendMsgResp();
    try
    {
      paramToServiceMsg = (msg_svc.PbSendMsgResp)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.result.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.UncommonMessageProcessor", 2, "<---handleSendBlessMessageResp : server did not return a valid result code, use 4 instead.");
        }
        i = 4;
        bool2 = false;
        l1 = 0L;
        if ((i != 0) && (i != 241)) {
          break label368;
        }
        bool1 = true;
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.f(8019, bool1, new Object[] { Integer.valueOf(i), Long.valueOf(l1), Boolean.valueOf(bool3) });
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.UncommonMessageProcessor", 2, String.format("<---handleSendBlessMessageResp : ----replyCode: %d isSuc: %s uniseq: %d msgSeq: %d msgType: %d waitTime: %d ssoseq: %d  appseq: %d isRedBagVideo:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(j), Long.valueOf(l1), Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()), Integer.valueOf(paramFromServiceMsg.getAppSeq()), Boolean.valueOf(bool3) }));
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        int i;
        boolean bool2;
        long l1;
        boolean bool1;
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.msg.UncommonMessageProcessor", 2, "<---handleSendBlessMessageResp : invalid.", paramToServiceMsg);
          localStringBuilder = new StringBuilder().append("<---handleSendBlessMessageResp : data:");
          if (paramObject != null) {
            break label332;
          }
        }
        label332:
        for (paramToServiceMsg = "null";; paramToServiceMsg = Arrays.toString((byte[])paramObject))
        {
          QLog.e("Q.msg.UncommonMessageProcessor", 2, paramToServiceMsg);
          paramToServiceMsg = new msg_svc.PbSendMsgResp();
          break;
        }
        if (paramToServiceMsg.result.get() != 0)
        {
          i = paramToServiceMsg.result.get();
          continue;
          label368:
          bool1 = bool2;
          if (i == 67)
          {
            l1 = paramToServiceMsg.uint32_svrbusy_wait_time.get();
            bool1 = bool2;
          }
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  private void ix(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("bless_sendreq_time");
    paramToServiceMsg = new blessing_helper.msg();
    try
    {
      i = ((blessing_helper.msg)paramToServiceMsg.mergeFrom((byte[])paramObject)).result.get();
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      if (i == 0)
      {
        bool = true;
        paramToServiceMsg.f(8018, bool, new Object[] { Integer.valueOf(i) });
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.UncommonMessageProcessor", 2, String.format("handleSendDirtyBlessTextCheckResp, time: %d, result: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) }));
        }
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.UncommonMessageProcessor", 2, String.format("handleSendDirtyBlessTextCheckResp, parse data error", new Object[0]));
        }
        int i = -1;
        continue;
        boolean bool = false;
      }
    }
  }
  
  private void iy(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("MARK_REQUEST_REVOKE_OR_DELETEMULTI ");
    int k;
    int m;
    long l;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (i == 2)
    {
      k = 1;
      m = 1;
      j = 1;
      l = paramToServiceMsg.extraData.getLong("msgSeq");
      localObject1 = new msg_svc.PbMsgWithDrawResp();
      try
      {
        paramObject = (msg_svc.PbMsgWithDrawResp)((msg_svc.PbMsgWithDrawResp)localObject1).mergeFrom((byte[])paramObject);
        if (paramObject.c2c_with_draw.has())
        {
          paramObject = paramObject.c2c_with_draw.get();
          i = m;
          if (paramObject == null) {
            break label487;
          }
          i = m;
          if (paramObject.isEmpty()) {
            break label487;
          }
          paramObject = paramObject.iterator();
          for (;;)
          {
            i = j;
            if (!paramObject.hasNext()) {
              break;
            }
            localObject1 = (msg_svc.PbC2CMsgWithDrawResp)paramObject.next();
            k = ((msg_svc.PbC2CMsgWithDrawResp)localObject1).result.get();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l);
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.ae(paramToServiceMsg, paramFromServiceMsg);
            i = j;
            if (k == 255)
            {
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
              localObject2.getClass();
              ((MessageHandler)localObject3).a((SendMessageHandler)localObject2, "server");
              i = 0;
            }
            localObject1 = ((msg_svc.PbC2CMsgWithDrawResp)localObject1).errmsg.get();
            j = i;
            if (QLog.isColorLevel())
            {
              QLog.d("revokeMsg", 2, String.format("handleDeleteMultiMsgResp,result: %s, errorMsg: %s", new Object[] { Integer.valueOf(k), localObject1 }));
              j = i;
            }
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.UncommonMessageProcessor", 2, "<---handleDeleteMultiMsgResp : ParseFrom PbMsgWithDrawResp Error.");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.hB(l);
      }
    }
    for (;;)
    {
      i = m;
      if (paramObject.group_with_draw.has())
      {
        paramObject = paramObject.group_with_draw.get();
        i = m;
        if (paramObject != null)
        {
          i = m;
          if (!paramObject.isEmpty())
          {
            paramObject = paramObject.iterator();
            j = k;
            for (;;)
            {
              i = j;
              if (!paramObject.hasNext()) {
                break;
              }
              localObject1 = (msg_svc.PbGroupMsgWithDrawResp)paramObject.next();
              k = ((msg_svc.PbGroupMsgWithDrawResp)localObject1).result.get();
              this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.ae(paramToServiceMsg, paramFromServiceMsg);
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l);
              i = j;
              if (k == 255)
              {
                localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
                localObject2.getClass();
                ((MessageHandler)localObject3).a((SendMessageHandler)localObject2, "server");
                i = 0;
              }
              localObject1 = ((msg_svc.PbGroupMsgWithDrawResp)localObject1).errmsg.get();
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("revokeMsg", 2, String.format("handleDeleteMultiMsgResp,result: %s, errorMsg: %s", new Object[] { Integer.valueOf(k), localObject1 }));
                j = i;
              }
            }
          }
        }
      }
      label487:
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.hB(l);
        return;
        if (i == 1)
        {
          localObject1 = paramToServiceMsg.extraData.getParcelableArrayList("key_msg_info_revoke");
          if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty()))
          {
            g(" ", 0, czx, czH);
            return;
          }
          m = ((RevokeMsgInfo)((ArrayList)localObject1).get(0)).istroop;
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = ((ArrayList)localObject1).iterator();
            while (paramToServiceMsg.hasNext())
            {
              paramFromServiceMsg = (RevokeMsgInfo)paramToServiceMsg.next();
              QLog.d("revokeMsg", 2, "handleRevokeMsgResp," + paramFromServiceMsg.toString());
            }
          }
          paramToServiceMsg = new msg_svc.PbMsgWithDrawResp();
          for (;;)
          {
            try
            {
              paramFromServiceMsg = (msg_svc.PbMsgWithDrawResp)paramToServiceMsg.mergeFrom((byte[])paramObject);
              paramToServiceMsg = null;
              if (!paramFromServiceMsg.c2c_with_draw.has()) {
                break label877;
              }
              paramObject = paramFromServiceMsg.c2c_with_draw.get();
              if ((paramObject == null) || (paramObject.isEmpty()) || (((msg_svc.PbC2CMsgWithDrawResp)paramObject.get(0)).uint32_sub_cmd.get() != 1)) {
                break label877;
              }
              paramFromServiceMsg = paramObject.iterator();
              paramToServiceMsg = null;
              if (!paramFromServiceMsg.hasNext()) {
                break;
              }
              paramObject = (msg_svc.PbC2CMsgWithDrawResp)paramFromServiceMsg.next();
              i = paramObject.result.get();
              if ((i >= 0) && (i <= 1000))
              {
                this.app.b().cN((ArrayList)localObject1);
                if (QLog.isColorLevel()) {
                  QLog.d("revokeMsg", 2, String.format("handleRevokeMsgResp,result: %s, errorMsg: %s", new Object[] { Integer.valueOf(i), paramToServiceMsg }));
                }
                continue;
              }
              paramToServiceMsg = paramObject.errmsg.get();
            }
            catch (Exception paramToServiceMsg)
            {
              if (QLog.isColorLevel()) {
                QLog.e("Q.msg.UncommonMessageProcessor", 2, "<---handleRevokeMsgResp : ParseFrom PbMsgWithDrawResp Error.");
              }
              g(((RevokeMsgInfo)((ArrayList)localObject1).get(0)).frienduin, m, czx, czI);
              return;
            }
            g(((RevokeMsgInfo)((ArrayList)localObject1).get(0)).frienduin, m, czx, i);
          }
          label877:
          if (paramFromServiceMsg.group_with_draw.has())
          {
            paramFromServiceMsg = paramFromServiceMsg.group_with_draw.get();
            if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isEmpty()) && (((msg_svc.PbGroupMsgWithDrawResp)paramFromServiceMsg.get(0)).uint32_sub_cmd.get() == 1))
            {
              localObject2 = paramFromServiceMsg.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (msg_svc.PbGroupMsgWithDrawResp)((Iterator)localObject2).next();
                int n = ((msg_svc.PbGroupMsgWithDrawResp)localObject3).result.get();
                if ((n != 0) && (n != 1002) && (n != 1004) && (n != 1006)) {
                  break label1047;
                }
                this.app.b().cN((ArrayList)localObject1);
                if (QLog.isColorLevel()) {
                  QLog.d("revokeMsg", 2, String.format("handleRevokeMsgResp,result: %s, errorMsg: %s", new Object[] { Integer.valueOf(n), paramToServiceMsg }));
                }
              }
            }
          }
        }
      }
    }
    label1047:
    int j = 0;
    if (((msg_svc.PbGroupMsgWithDrawResp)localObject3).failed_msg_list.has())
    {
      List localList = ((msg_svc.PbGroupMsgWithDrawResp)localObject3).failed_msg_list.get();
      if ((localList != null) && (!localList.isEmpty()))
      {
        Iterator localIterator = localList.iterator();
        i = 0;
        j = 0;
        while (localIterator.hasNext())
        {
          paramObject = (msg_svc.PbGroupMsgWithDrawResp.MessageResult)localIterator.next();
          k = paramObject.uint32_result.get();
          int i1 = paramObject.uint32_msg_seq.get();
          paramFromServiceMsg = "";
          try
          {
            paramObject = paramObject.bytes_err_msg.get().toStringUtf8();
            paramFromServiceMsg = paramObject;
          }
          catch (Exception paramObject)
          {
            for (;;)
            {
              continue;
              j = i;
              i = 0;
              continue;
              i = j;
            }
          }
          if (k != 4) {
            break label1315;
          }
          i = j + 1;
          if (QLog.isColorLevel()) {
            QLog.d("revokeMsg", 2, String.format("handleRevokeMsgResp, more failInfo, shmsgseq: %s, result: %s, errorMsg: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(k), paramFromServiceMsg }));
          }
          j = i;
          i = k;
        }
        if (j == localList.size())
        {
          k = 1;
          j = i;
        }
      }
    }
    label1315:
    for (i = k;; i = 0)
    {
      if (i != 0)
      {
        this.app.b().cN((ArrayList)localObject1);
        break;
      }
      paramToServiceMsg = ((msg_svc.PbGroupMsgWithDrawResp)localObject3).errmsg.get();
      g(((RevokeMsgInfo)((ArrayList)localObject1).get(0)).frienduin, m, czx, j);
      break;
    }
  }
  
  private void iz(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = paramToServiceMsg.extraData.getLong("seq");
    long l2 = paramToServiceMsg.extraData.getLong("uniseq");
    int i = paramToServiceMsg.extraData.getInt("uintype");
    int j = paramToServiceMsg.extraData.getInt("msgrandom");
    Object localObject = paramToServiceMsg.extraData.getString("peeruin");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l4 = anbk.I(j);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.UncommonMessageProcessor", 2, "<DELMSG><R><---handleDeleteMsgResp : uinType :" + i + " uin:" + (String)localObject + " seq:" + l1 + " uniseq:" + l2 + " msgUid:" + l4 + " random:" + j + " reqSeq:" + l3);
    }
    localObject = new msg_svc.PbDelRoamMsgResp();
    try
    {
      paramObject = (msg_svc.PbDelRoamMsgResp)((msg_svc.PbDelRoamMsgResp)localObject).mergeFrom((byte[])paramObject);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.ae(paramToServiceMsg, paramFromServiceMsg);
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3);
      if (paramToServiceMsg == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.UncommonMessageProcessor", 2, "<DELMSG><R><---handleSendC2CMessageResp_PB : ---cmd:" + paramFromServiceMsg.getServiceCmd() + ",no SendMessageHandler found.");
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
              QLog.e("Q.msg.UncommonMessageProcessor", 2, "<---handleDeleteMsgResp : ParseFrom PbDelRoamMsgResp Error.");
            }
            paramObject = null;
          }
        } while ((paramObject == null) || (!paramObject.result.has()));
        i = paramObject.result.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.UncommonMessageProcessor", 2, "<DELMSG><R><---handleDeleteMsgResp : result :" + i);
        }
        if ((i != 17) && (i != -102) && (i != 255)) {
          break;
        }
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
        paramToServiceMsg.getClass();
      } while (!paramFromServiceMsg.a(paramToServiceMsg, "server"));
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.hB(l3);
    }
  }
  
  public void Y(MessageRecord paramMessageRecord)
  {
    Object localObject;
    if ((paramMessageRecord == null) || ((paramMessageRecord.istroop != 0) && (paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 3000) && (paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1004))) {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("<DELMSG><S>--->deleteMsgFromServerInner:");
        if (paramMessageRecord != null) {
          break label94;
        }
        paramMessageRecord = "mr is Null.";
        QLog.d("Q.msg.UncommonMessageProcessor", 2, paramMessageRecord);
      }
    }
    label184:
    label451:
    for (;;)
    {
      return;
      label94:
      paramMessageRecord = " isTroop:" + paramMessageRecord.istroop;
      break;
      if ((!top.s(paramMessageRecord)) && (top.fy(paramMessageRecord.msgtype)))
      {
        localObject = new ArrayList();
        int k;
        int i;
        if ((paramMessageRecord instanceof MessageForLongMsg))
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.UncommonMessageProcessor", 2, "--->deleteMsgFromServer : is long msg, sent from local, find the prepare slice to del.");
          }
          ((List)localObject).addAll(((MessageForLongMsg)paramMessageRecord).longMsgFragmentList);
          k = ((List)localObject).size();
          i = 0;
        }
        for (;;)
        {
          if (i >= k) {
            break label451;
          }
          MessageRecord localMessageRecord = (MessageRecord)((List)localObject).get(i);
          if (localMessageRecord.isSendFromLocal())
          {
            if (paramMessageRecord.extraflag == 32772)
            {
              if (paramMessageRecord.istroop == 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.UncommonMessageProcessor", 2, "--->deleteMsgFromServer : delete a sending C2C msg, waitting for the response to complete.");
                }
                this.app.a().ax(paramMessageRecord);
                return;
                ((List)localObject).add(paramMessageRecord);
                break label184;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.msg.UncommonMessageProcessor", 2, "--->deleteMsgFromServer : delete a sending group/dics msg, waitting for the push to complete.");
              return;
            }
            if (paramMessageRecord.extraflag == 32768) {
              break;
            }
          }
          int j = amzo.seq;
          amzo.seq = j + 1;
          long l1 = j;
          SendMessageHandler localSendMessageHandler = new SendMessageHandler();
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l1, localSendMessageHandler);
          j = 0;
          while (j < 12)
          {
            localSendMessageHandler.a(new UncommonMessageProcessor.3(this, localMessageRecord, l1));
            j += 1;
          }
          j = 0;
          if (j < 6)
          {
            if (j == 0) {}
            for (l1 = 1080000L;; l1 = (6 - j) * 1080000 / 6 - j * 2000)
            {
              long l2 = j * 1080000 / 6;
              localSendMessageHandler.getClass();
              localSendMessageHandler.b(l2, l1, "period");
              j += 1;
              break;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public ToServiceMsg a(List<MessageRecord> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (MessageRecord)paramList.get(0);
    if ((paramInt == 1) && (!((MessageRecord)localObject1).isSend()) && (!apuh.a(this.app, (MessageRecord)localObject1, this.app.getCurrentAccountUin())))
    {
      QLog.e("revokeMsg", 1, "buildRevokeOrDeleteMultiMsgReq error, msg not send");
      g(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, czA, czJ);
      return null;
    }
    boolean bool = ((MessageRecord)localObject1).isLongMsg();
    int j = ((MessageRecord)localObject1).istroop;
    int i;
    if (j == 1000) {
      i = 1;
    }
    for (;;)
    {
      if (paramInt == 1) {
        localObject1 = "sendRevokeMsgReq";
      }
      for (;;)
      {
        label139:
        Object localObject5 = new ArrayList();
        MessageRecord localMessageRecord;
        int k;
        Object localObject6;
        switch (j)
        {
        default: 
          paramList = null;
          localObject1 = null;
        case 0: 
        case 1000: 
        case 1004: 
          for (;;)
          {
            Object localObject2 = new msg_svc.PbMsgWithDrawReq();
            if (localObject1 != null) {
              ((msg_svc.PbMsgWithDrawReq)localObject2).c2c_with_draw.add((MessageMicro)localObject1);
            }
            if (paramList != null) {
              ((msg_svc.PbMsgWithDrawReq)localObject2).group_with_draw.add(paramList);
            }
            paramList = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("PbMessageSvc.PbMsgWithDraw");
            paramList.putWupBuffer(((msg_svc.PbMsgWithDrawReq)localObject2).toByteArray());
            paramList.extraData.putLong("key_msg_info_time_start", l);
            paramList.extraData.putParcelableArrayList("key_msg_info_revoke", localArrayList);
            paramList.extraData.putInt("MARK_REQUEST_REVOKE_OR_DELETEMULTI ", paramInt);
            paramList.setEnableFastResend(true);
            return paramList;
            if (j != 1004) {
              break label1786;
            }
            i = 2;
            break;
            if (paramInt != 2) {
              break label1778;
            }
            localObject1 = "sendDeleteMultiMsgReq";
            break label139;
            localObject4 = new msg_svc.PbC2CMsgWithDrawReq();
            ((msg_svc.PbC2CMsgWithDrawReq)localObject4).uint32_sub_cmd.set(paramInt);
            localIterator = paramList.iterator();
            while (localIterator.hasNext())
            {
              localMessageRecord = (MessageRecord)localIterator.next();
              k = (short)(int)localMessageRecord.shmsgseq;
              int m = anbk.ac(localMessageRecord.msgUid);
              localObject6 = new msg_svc.PbC2CMsgWithDrawReq.MsgInfo();
              if ((paramInt == 1) && (j == 0)) {}
              for (localObject2 = localMessageRecord.senderuin;; localObject2 = localMessageRecord.selfuin) {
                try
                {
                  ((msg_svc.PbC2CMsgWithDrawReq.MsgInfo)localObject6).uint64_from_uin.set(Long.valueOf((String)localObject2).longValue());
                  ((msg_svc.PbC2CMsgWithDrawReq.MsgInfo)localObject6).uint64_to_uin.set(Long.valueOf(localMessageRecord.frienduin).longValue());
                  ((msg_svc.PbC2CMsgWithDrawReq.MsgInfo)localObject6).uint32_msg_seq.set(k & 0xFFFF);
                  ((msg_svc.PbC2CMsgWithDrawReq.MsgInfo)localObject6).uint64_msg_uid.set(localMessageRecord.msgUid);
                  ((msg_svc.PbC2CMsgWithDrawReq.MsgInfo)localObject6).uint64_msg_time.set(localMessageRecord.time);
                  ((msg_svc.PbC2CMsgWithDrawReq.MsgInfo)localObject6).uint32_msg_random.set(m);
                  if (localMessageRecord.isLongMsg())
                  {
                    ((msg_svc.PbC2CMsgWithDrawReq.MsgInfo)localObject6).uint32_div_seq.set(localMessageRecord.longMsgId);
                    ((msg_svc.PbC2CMsgWithDrawReq.MsgInfo)localObject6).uint32_pkg_num.set(localMessageRecord.longMsgCount);
                    ((msg_svc.PbC2CMsgWithDrawReq.MsgInfo)localObject6).uint32_pkg_index.set(localMessageRecord.longMsgIndex);
                  }
                  if (localMessageRecord.msgtype == -2005)
                  {
                    localObject2 = this.app.a().a(localMessageRecord.uniseq, localMessageRecord.frienduin, localMessageRecord.istroop);
                    if ((localObject2 != null) && (!TextUtils.isEmpty(((FileManagerEntity)localObject2).Uuid))) {
                      ((ArrayList)localObject5).add(((FileManagerEntity)localObject2).Uuid);
                    }
                    ((msg_svc.PbC2CMsgWithDrawReq.MsgInfo)localObject6).uint32_msg_type.set(1);
                  }
                  localObject2 = new msg_svc.RoutingHead();
                  if (anbh.a(this.app, localMessageRecord, (msg_svc.RoutingHead)localObject2)) {
                    ((msg_svc.PbC2CMsgWithDrawReq.MsgInfo)localObject6).routing_head.set((MessageMicro)localObject2);
                  }
                  ((msg_svc.PbC2CMsgWithDrawReq)localObject4).msg_info.add((MessageMicro)localObject6);
                  localArrayList.add(new RevokeMsgInfo(localMessageRecord));
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("revokeMsg", 2, String.format((String)localObject1 + ",istroop %s, frienduin %s, shmsgseq %s, time %s, random %s, uid %s", new Object[] { Integer.valueOf(localMessageRecord.istroop), localMessageRecord.frienduin, Long.valueOf(localMessageRecord.shmsgseq), Long.valueOf(localMessageRecord.time), Integer.valueOf(m), Long.valueOf(localMessageRecord.msgUid) }));
                }
                catch (Exception localException)
                {
                  QLog.e("Q.msg.UncommonMessageProcessor", 1, "build revoke request error", localException);
                }
              }
            }
            if (bool)
            {
              ((msg_svc.PbC2CMsgWithDrawReq)localObject4).uint32_long_message_flag.set(1);
              localObject1 = new msgrevoke_userdef.UinTypeUserDef();
              ((msgrevoke_userdef.UinTypeUserDef)localObject1).uint32_from_uin_type.set(i);
              if (((ArrayList)localObject5).size() > 0) {
                ((msgrevoke_userdef.UinTypeUserDef)localObject1).str_file_uuid.addAll((Collection)localObject5);
              }
              if ((i != 1) && (i != 2)) {}
            }
            try
            {
              ((msgrevoke_userdef.UinTypeUserDef)localObject1).uint64_from_group_code.set(Long.valueOf(((MessageRecord)paramList.get(0)).senderuin).longValue());
              ((msg_svc.PbC2CMsgWithDrawReq)localObject4).bytes_reserved.set(ByteStringMicro.copyFrom(((msgrevoke_userdef.UinTypeUserDef)localObject1).toByteArray()));
              paramList = null;
              localObject1 = localObject4;
              continue;
              ((msg_svc.PbC2CMsgWithDrawReq)localObject4).uint32_long_message_flag.set(0);
            }
            catch (Exception paramList)
            {
              for (;;)
              {
                QLog.e("Q.msg.UncommonMessageProcessor", 1, " convert exception:", paramList);
              }
            }
          }
        }
        Object localObject4 = new msg_svc.PbGroupMsgWithDrawReq();
        Iterator localIterator = paramList.iterator();
        Object localObject3;
        if (localIterator.hasNext())
        {
          localMessageRecord = (MessageRecord)localIterator.next();
          i = (int)localMessageRecord.shmsgseq;
          k = anbk.ac(localMessageRecord.msgUid);
          localObject6 = new msg_svc.PbGroupMsgWithDrawReq.MessageInfo();
          ((msg_svc.PbGroupMsgWithDrawReq.MessageInfo)localObject6).uint32_msg_seq.set(i & 0xFFFFFFFF);
          ((msg_svc.PbGroupMsgWithDrawReq.MessageInfo)localObject6).uint32_msg_random.set(k);
          if (localMessageRecord.msgtype == -2005)
          {
            localObject3 = this.app.a().a(localMessageRecord.uniseq, localMessageRecord.frienduin, localMessageRecord.istroop);
            if ((localObject3 != null) && (!TextUtils.isEmpty(((FileManagerEntity)localObject3).Uuid))) {
              ((ArrayList)localObject5).add(((FileManagerEntity)localObject3).Uuid);
            }
            ((msg_svc.PbGroupMsgWithDrawReq.MessageInfo)localObject6).uint32_msg_type.set(1);
          }
          if (((localMessageRecord instanceof MessageForReplyText)) && (((MessageForReplyText)localMessageRecord).isBarrageMsg))
          {
            ((msg_svc.PbGroupMsgWithDrawReq.MessageInfo)localObject6).uint32_resv_flag.set(1);
            if (QLog.isColorLevel())
            {
              if (paramInt != 1) {
                break label1358;
              }
              localObject3 = "revoke";
              label1160:
              QLog.d("Q.msg.UncommonMessageProcessor", 2, new Object[] { localObject3, " msg, isBarrageMsg" });
            }
          }
          ((msg_svc.PbGroupMsgWithDrawReq)localObject4).msg_list.add((MessageMicro)localObject6);
          localObject3 = new RevokeMsgInfo(localMessageRecord);
          ((RevokeMsgInfo)localObject3).opType = 0;
          if (j == 1)
          {
            if (!TextUtils.equals(this.app.getCurrentAccountUin(), localMessageRecord.senderuin))
            {
              if (!apuh.f(this.app, localMessageRecord.frienduin, this.app.getCurrentAccountUin())) {
                break label1366;
              }
              ((RevokeMsgInfo)localObject3).opType = 2;
            }
            label1260:
            if (!jof.a(localMessageRecord)) {
              break label1397;
            }
          }
          label1358:
          label1366:
          label1397:
          for (i = 1;; i = 0)
          {
            ((RevokeMsgInfo)localObject3).dyl = i;
            localArrayList.add(localObject3);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("revokeMsg", 2, String.format((String)localObject1 + ",istroop %s, frienduin %s, shmsgseq %s", new Object[] { Integer.valueOf(localMessageRecord.istroop), localMessageRecord.frienduin, Long.valueOf(localMessageRecord.shmsgseq) }));
            break;
            localObject3 = "delete";
            break label1160;
            if (!apuh.g(this.app, localMessageRecord.frienduin, this.app.getCurrentAccountUin())) {
              break label1260;
            }
            ((RevokeMsgInfo)localObject3).opType = 1;
            break label1260;
          }
        }
        ((msg_svc.PbGroupMsgWithDrawReq)localObject4).uint32_sub_cmd.set(paramInt);
        if (j == 1)
        {
          ((msg_svc.PbGroupMsgWithDrawReq)localObject4).uint32_group_type.set(0);
          label1426:
          ((msg_svc.PbGroupMsgWithDrawReq)localObject4).uint64_group_code.set(Long.valueOf(((MessageRecord)paramList.get(0)).frienduin).longValue());
          localObject1 = new msgrevoke_userdef.MsgInfoUserDef();
          if (((ArrayList)localObject5).size() > 0) {
            ((msgrevoke_userdef.MsgInfoUserDef)localObject1).str_file_uuid.addAll((Collection)localObject5);
          }
          if (paramInt != 1) {
            break label1659;
          }
          if (bool) {
            break label1544;
          }
          ((msgrevoke_userdef.MsgInfoUserDef)localObject1).uint32_long_message_flag.set(0);
        }
        for (;;)
        {
          ((msg_svc.PbGroupMsgWithDrawReq)localObject4).bytes_userdef.set(ByteStringMicro.copyFrom(((msgrevoke_userdef.MsgInfoUserDef)localObject1).toByteArray()));
          paramList = (List<MessageRecord>)localObject4;
          localObject1 = null;
          break;
          if (j != 3000) {
            break label1426;
          }
          ((msg_svc.PbGroupMsgWithDrawReq)localObject4).uint32_group_type.set(1);
          break label1426;
          label1544:
          ((msgrevoke_userdef.MsgInfoUserDef)localObject1).uint32_long_message_flag.set(1);
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject3 = (MessageRecord)paramList.next();
            i = (int)((MessageRecord)localObject3).shmsgseq;
            localObject5 = new msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef();
            ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject5).uint32_msg_seq.set(i & 0xFFFFFFFF);
            ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject5).long_msg_id.set(((MessageRecord)localObject3).longMsgId);
            ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject5).long_msg_num.set(((MessageRecord)localObject3).longMsgCount);
            ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject5).long_msg_index.set(((MessageRecord)localObject3).longMsgIndex);
            ((msgrevoke_userdef.MsgInfoUserDef)localObject1).long_msg_info.add((MessageMicro)localObject5);
          }
          continue;
          label1659:
          if (paramInt == 2)
          {
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              localObject3 = (MessageRecord)paramList.next();
              i = (int)((MessageRecord)localObject3).shmsgseq;
              localObject5 = new msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef();
              ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject5).uint32_msg_seq.set(i & 0xFFFFFFFF);
              if (((MessageRecord)localObject3).isLongMsg())
              {
                ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject5).long_msg_id.set(((MessageRecord)localObject3).longMsgId);
                ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject5).long_msg_num.set(((MessageRecord)localObject3).longMsgCount);
                ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject5).long_msg_index.set(((MessageRecord)localObject3).longMsgIndex);
              }
              ((msgrevoke_userdef.MsgInfoUserDef)localObject1).long_msg_info.add((MessageMicro)localObject5);
            }
          }
        }
        label1778:
        localObject1 = "";
      }
      label1786:
      i = 0;
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 8001: 
      aG(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 8002: 
      aI(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 8003: 
      aJ(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    aH(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(MessageRecord paramMessageRecord, ArrayList<String> paramArrayList, ujt.a parama)
  {
    paramArrayList = achp.a(this.app, paramMessageRecord, paramArrayList, parama);
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.UncommonMessageProcessor", 2, "sendBlessMsg error, msgReq is null!");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.f(8019, false, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Boolean.valueOf(false) });
      return;
    }
    if (((paramMessageRecord instanceof MessageForShortVideo)) && (((MessageForShortVideo)paramMessageRecord).redBagType == LocalMediaInfo.REDBAG_TYPE_GET)) {}
    for (boolean bool = true;; bool = false)
    {
      a(false, true, true, 0L, new acsc(this, paramMessageRecord, bool, paramArrayList));
      return;
    }
  }
  
  public void a(EmojiStickerManager.c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$c = paramc;
  }
  
  public void am(List<MessageRecord> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$c != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$c.onResult(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.f(8016, true, new Object[] { paramList, Boolean.valueOf(paramBoolean) });
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 8001: 
      aG(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 8002: 
      aI(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 8003: 
      aJ(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    aH(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void f(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 8001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        iw((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      bN(getClass().getName(), paramInt);
      return;
    case 8002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        iy((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      bN(getClass().getName(), paramInt);
      return;
    case 8003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        iz((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      bN(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      ix((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
      return;
    }
    bN(getClass().getName(), paramInt);
  }
  
  public void g(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.app.a().awx())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$c != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$c.onResult(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.f(8016, false, null);
      h(paramString, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void js(List<MessageRecord> paramList)
  {
    int k = 0;
    int i = amzo.seq;
    amzo.seq = i + 1;
    long l1 = i;
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l1, localSendMessageHandler);
    paramList = a(paramList, 2);
    if (paramList == null) {
      return;
    }
    paramList.extraData.putLong("msgSeq", l1);
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 12) {
        break;
      }
      localSendMessageHandler.a(new UncommonMessageProcessor.2(this, paramList));
      i += 1;
    }
    label93:
    if (j < 6) {
      if (j != 0) {
        break label144;
      }
    }
    label144:
    for (l1 = 1080000L;; l1 = (6 - j) * 1080000 / 6 - j * 2000)
    {
      long l2 = j * 1080000 / 6;
      localSendMessageHandler.getClass();
      localSendMessageHandler.b(l2, l1, "period");
      j += 1;
      break label93;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acsb
 * JD-Core Version:    0.7.0.1
 */