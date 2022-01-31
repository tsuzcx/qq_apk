package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import fjc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbGetDiscussMsgResp;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import tencent.im.msg.im_msg_body.MsgBody;

public class DiscMessageProcessor
  extends BaseMessageProcessorForTroopAndDisc
{
  public static final String c = "Q.msg.DiscMessageProcessor";
  public fjc a;
  private final Timer a;
  public final ConcurrentHashMap a;
  
  public DiscMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilTimer = ThreadManager.a();
    this.jdField_a_of_type_Fjc = new fjc(this, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ArrayList paramArrayList, msg_svc.PbGetDiscussMsgResp paramPbGetDiscussMsgResp)
  {
    Object localObject = new ArrayList();
    String str = String.valueOf(paramToServiceMsg.extraData.getLong("lDisUin", paramPbGetDiscussMsgResp.discuss_uin.get()));
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(str);
    StringBuilder localStringBuilder = new StringBuilder();
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("<<---initGetPullDiscussionMsg discussUin: ").append(str).append(" res.cReplyCode: ").append(paramPbGetDiscussMsgResp.result.get()).append(" lastSeq: ").append(l1);
      QLog.d("Q.msg.DiscMessageProcessor", 2, localStringBuilder.toString());
    }
    if (paramArrayList != null) {
      a(paramArrayList, (ArrayList)localObject);
    }
    if ((paramPbGetDiscussMsgResp.result.get() == 104) && (((ArrayList)localObject).size() == 0))
    {
      l1 = paramToServiceMsg.extraData.getLong("lEndSeq", paramPbGetDiscussMsgResp.return_end_seq.get());
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMessageProcessor", 2, "initGetPullDiscussionMsg reply 104 !! disUin=" + str + ", reqEndSeq=" + l1);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str, l1);
    }
    int i;
    do
    {
      do
      {
        return;
      } while (((ArrayList)localObject).size() <= 0);
      paramToServiceMsg = ((ArrayList)localObject).iterator();
      while (paramToServiceMsg.hasNext())
      {
        paramArrayList = (MessageRecord)paramToServiceMsg.next();
        if ((paramArrayList.senderuin != null) && (paramArrayList.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
        {
          paramArrayList.isread = true;
          paramArrayList.issend = 2;
        }
      }
      Collections.sort((List)localObject, this.jdField_a_of_type_JavaUtilComparator);
      paramToServiceMsg = new ArrayList();
      i = ((ArrayList)localObject).size() - 1;
      if (i >= 0)
      {
        paramArrayList = (MessageRecord)((ArrayList)localObject).get(i);
        if (QLog.isColorLevel())
        {
          localStringBuilder.setLength(0);
          localStringBuilder.append("----------initGetPullDiscussionMsg update send message  mr.senderuin: ").append(paramArrayList.senderuin).append(" mr.msgtype: ").append(paramArrayList.msgtype).append(" mr.frienduin: ").append(paramArrayList.frienduin).append(" mr.shmsgseq: ").append(paramArrayList.shmsgseq).append(" mr.time:").append(paramArrayList.time).append(" mr.msg: ").append(paramArrayList.getLogColorContent());
          QLog.d("Q.msg.DiscMessageProcessor", 2, localStringBuilder.toString());
        }
        if ((paramArrayList.senderuin != null) && (paramArrayList.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
        {
          paramPbGetDiscussMsgResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayList.frienduin, 3000, paramArrayList);
          if (paramPbGetDiscussMsgResp != null)
          {
            if (((paramArrayList instanceof MessageForText)) && ((paramPbGetDiscussMsgResp instanceof MessageForText)) && (paramArrayList.getRepeatCount() > 0))
            {
              paramPbGetDiscussMsgResp.setRepeatCount(paramArrayList.getRepeatCount());
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.DiscMessageProcessor", 2, "<---initGetPullDiscussionMsg_PB ===> update findMr.repeatCount=" + paramArrayList.getRepeatCount());
              }
            }
            if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f()) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramPbGetDiscussMsgResp.frienduin, paramPbGetDiscussMsgResp.istroop, paramPbGetDiscussMsgResp.uniseq);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramArrayList.frienduin, 3000, paramPbGetDiscussMsgResp.uniseq, paramArrayList.shmsgseq, paramArrayList.time);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(str, paramArrayList.shmsgseq);
          }
        }
        for (;;)
        {
          i -= 1;
          break;
          paramToServiceMsg.add(0, paramArrayList);
        }
      }
      l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(str);
    } while (paramToServiceMsg.size() <= 0);
    paramArrayList = paramToServiceMsg.iterator();
    if (paramArrayList.hasNext())
    {
      paramPbGetDiscussMsgResp = (MessageRecord)paramArrayList.next();
      if (paramPbGetDiscussMsgResp.shmsgseq > l1) {
        l1 = paramPbGetDiscussMsgResp.shmsgseq;
      }
      for (;;)
      {
        break;
      }
    }
    paramArrayList = (BaseMessageManagerForTroopAndDisc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1);
    boolean bool2;
    boolean bool1;
    if (!paramArrayList.a(str, 3000, paramToServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
    {
      paramPbGetDiscussMsgResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
      long l2 = ((Long)paramPbGetDiscussMsgResp[0]).longValue();
      int j = paramToServiceMsg.size();
      i = 0;
      while (i < j)
      {
        if ((((MessageRecord)paramToServiceMsg.get(i)).senderuin != null) && (((MessageRecord)paramToServiceMsg.get(i)).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
        {
          ((MessageRecord)paramToServiceMsg.get(i)).isread = true;
          ((MessageRecord)paramToServiceMsg.get(i)).issend = 2;
        }
        if (((Long)paramPbGetDiscussMsgResp[0]).longValue() >= ((MessageRecord)paramToServiceMsg.get(i)).shmsgseq) {
          ((MessageRecord)paramToServiceMsg.get(i)).isread = true;
        }
        i += 1;
      }
      bool2 = MessageHandlerUtils.a(paramToServiceMsg);
      boolean bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg);
      paramPbGetDiscussMsgResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause))
      {
        bool1 = true;
        paramPbGetDiscussMsgResp.a(paramToServiceMsg, (String)localObject, bool1, false);
        paramArrayList.c(str, 3000, l2);
        paramArrayList.a(str, paramToServiceMsg);
        bool1 = bool3;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(str, l1);
      a("initGetPullDiscussionMsg", true, paramToServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool1), false);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg);
      return;
      bool1 = false;
      break;
      bool1 = false;
      bool2 = false;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ArrayList paramArrayList, msg_svc.PbGetDiscussMsgResp paramPbGetDiscussMsgResp, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList2 = new ArrayList();
    MessageInfo localMessageInfo = new MessageInfo();
    Object localObject1;
    Object localObject2;
    long l1;
    long l2;
    long l3;
    int i;
    long l4;
    int j;
    int k;
    long l5;
    int m;
    long l6;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMessageProcessor", 2, "<---refreshDiscussionHead_PB: size:" + paramArrayList.size());
      }
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (msg_comm.Msg)localIterator.next();
        paramArrayList = (msg_comm.MsgHead)((msg_comm.Msg)localObject1).msg_head.get();
        if (!paramArrayList.discuss_info.has())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMessageProcessor", 2, "<---refreshDiscussionHead_PB: no discussInfo.");
          }
        }
        else
        {
          localObject2 = (msg_comm.DiscussInfo)paramArrayList.discuss_info.get();
          l1 = paramArrayList.from_uin.get();
          l2 = paramArrayList.to_uin.get();
          l3 = paramArrayList.msg_seq.get();
          i = paramArrayList.msg_time.get();
          l4 = paramArrayList.msg_uid.get();
          j = paramArrayList.user_active.get();
          k = paramArrayList.from_instid.get();
          l5 = ((msg_comm.DiscussInfo)localObject2).discuss_uin.get();
          m = ((msg_comm.DiscussInfo)localObject2).discuss_type.get();
          l6 = ((msg_comm.DiscussInfo)localObject2).discuss_info_seq.get();
          if ((!((msg_comm.DiscussInfo)localObject2).discuss_remark.has()) || (((msg_comm.DiscussInfo)localObject2).discuss_remark.get() == null)) {
            break label1098;
          }
        }
      }
    }
    label1098:
    for (paramArrayList = ((msg_comm.DiscussInfo)localObject2).discuss_remark.get().toByteArray();; paramArrayList = null)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMessageProcessor", 2, "<---refreshDiscussionHead_PB : fromUin:" + l1 + ",toUin:" + l2 + ",msgTime:" + i + ",msgSeq:" + l3 + ",msgUid:" + l4 + ",userActive:" + j + ",fromInstid:" + k + ",disUin:" + l5 + ",disType:" + m + ",disSeq:" + l6 + ",remarkSender:" + Arrays.toString(paramArrayList) + ",hasAppShare:" + ((msg_comm.Msg)localObject1).appshare_info.has() + ",hasMsgBody:" + ((msg_comm.Msg)localObject1).msg_body.has());
        }
        localObject2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        PBDecodeContext localPBDecodeContext = new PBDecodeContext();
        localPBDecodeContext.e = l5;
        localPBDecodeContext.c = 3000;
        localPBDecodeContext.d = m;
        if (((msg_comm.Msg)localObject1).content_head.has())
        {
          msg_comm.ContentHead localContentHead = (msg_comm.ContentHead)((msg_comm.Msg)localObject1).content_head.get();
          i = localContentHead.div_seq.get();
          j = localContentHead.pkg_index.get();
          k = localContentHead.pkg_num.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMessageProcessor", 2, "<---refreshDiscussionHead_PB ContentHead: divSeq:" + i + ",pkgIndex:" + j + ",pkgNum:" + k);
          }
        }
        try
        {
          a((msg_comm.Msg)localObject1, localArrayList3, localPBDecodeContext, true, null);
          if (localArrayList3.size() > 0) {
            a(localArrayList3, (ArrayList)localObject2, true);
          }
          if ((localObject2 == null) || (((ArrayList)localObject2).size() < 1)) {
            break;
          }
          MessageHandlerUtils.a((List)localObject2);
          localArrayList1.addAll((Collection)localObject2);
          MessageHandlerUtils.a("Q.msg.DiscMessageProcessor", paramString, l3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), String.valueOf(l5));
          if ((paramArrayList == null) || (paramArrayList.length <= 0)) {
            break;
          }
          localObject2 = String.valueOf(l1);
          localObject1 = HexUtil.a(paramArrayList) + ":" + (String)localObject2;
          if (localHashSet.contains(localObject1)) {
            break;
          }
          paramArrayList = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramArrayList, String.valueOf(l5), (String)localObject2, false);
          if (paramArrayList == null) {
            break;
          }
          localArrayList2.add(paramArrayList);
          localHashSet.add(localObject1);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.DiscMessageProcessor", 2, "decodeSinglePbMsg_GroupDis error,", localException);
            }
          }
        }
      }
      if (localArrayList2.size() > 0) {
        ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(localArrayList2);
      }
      paramArrayList = localArrayList1.iterator();
      while (paramArrayList.hasNext())
      {
        paramString = (MessageRecord)paramArrayList.next();
        if ((paramString.senderuin != null) && (paramString.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
          paramString.issend = 2;
        }
        paramString.isread = true;
      }
      Collections.sort(localArrayList1, this.jdField_a_of_type_JavaUtilComparator);
      paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
      paramArrayList = paramPbGetDiscussMsgResp.discuss_uin.toString();
      paramString = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.DiscMessageProcessor_At_Me_DISC", 2, "processRefreshHead");
      }
      paramString.a(paramArrayList + "&" + 3000, localMessageInfo);
      paramArrayList = new ArrayList();
      if (paramToServiceMsg != null)
      {
        paramToServiceMsg.putLong("beginSeq", paramPbGetDiscussMsgResp.return_begin_seq.get());
        paramToServiceMsg.putLong("endSeq", paramPbGetDiscussMsgResp.return_end_seq.get());
        paramToServiceMsg.putBoolean("success", true);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramPbGetDiscussMsgResp.discuss_uin.get()), 3000, localArrayList1, paramArrayList, paramToServiceMsg);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramArrayList);
      return;
    }
  }
  
  private void a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMessageProcessor", 2, "discussionMsgRecordHandle_PB msgs is null or size <= 0");
      }
      return;
    }
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList1 = new ArrayList();
    new ArrayList();
    Iterator localIterator = paramArrayList1.iterator();
    long l1 = 0L;
    label62:
    msg_comm.Msg localMsg;
    Object localObject1;
    Object localObject2;
    long l4;
    long l2;
    long l3;
    int i;
    long l5;
    int j;
    int k;
    int m;
    long l6;
    if (localIterator.hasNext())
    {
      localMsg = (msg_comm.Msg)localIterator.next();
      localObject1 = new MessageInfo();
      paramArrayList1 = (msg_comm.MsgHead)localMsg.msg_head.get();
      if ((!paramArrayList1.discuss_info.has()) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.DiscMessageProcessor", 2, "<---handleMsgPush_PB_Group: no groupInfo.");
      }
      localObject2 = (msg_comm.DiscussInfo)paramArrayList1.discuss_info.get();
      l4 = paramArrayList1.from_uin.get();
      l2 = paramArrayList1.to_uin.get();
      l3 = paramArrayList1.msg_seq.get();
      i = paramArrayList1.msg_time.get();
      l5 = paramArrayList1.msg_uid.get();
      j = paramArrayList1.user_active.get();
      k = paramArrayList1.from_instid.get();
      l1 = ((msg_comm.DiscussInfo)localObject2).discuss_uin.get();
      m = ((msg_comm.DiscussInfo)localObject2).discuss_type.get();
      l6 = ((msg_comm.DiscussInfo)localObject2).discuss_info_seq.get();
      if ((!((msg_comm.DiscussInfo)localObject2).discuss_remark.has()) || (((msg_comm.DiscussInfo)localObject2).discuss_remark.get() == null)) {
        break label998;
      }
    }
    label992:
    label995:
    label998:
    for (paramArrayList1 = ((msg_comm.DiscussInfo)localObject2).discuss_remark.get().toByteArray();; paramArrayList1 = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMessageProcessor", 2, "<---discussionMsgRecordHandle_PB : fromUin:" + l4 + ",toUin:" + l2 + ",msgTime:" + i + ",msgSeq:" + l3 + ",msgUid:" + l5 + ",userActive:" + j + ",fromInstid:" + k + ",disUin:" + l1 + ",disType:" + m + ",disSeq:" + l6 + ",remarkSender:" + Arrays.toString(paramArrayList1) + ",hasAppShare:" + localMsg.appshare_info.has() + ",hasMsgBody:" + localMsg.msg_body.has());
      }
      localObject2 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      PBDecodeContext localPBDecodeContext = new PBDecodeContext();
      localPBDecodeContext.e = l1;
      localPBDecodeContext.c = 3000;
      localPBDecodeContext.d = m;
      if (localMsg.content_head.has())
      {
        msg_comm.ContentHead localContentHead = (msg_comm.ContentHead)localMsg.content_head.get();
        i = localContentHead.div_seq.get();
        j = localContentHead.pkg_index.get();
        k = localContentHead.pkg_num.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMessageProcessor", 2, "<---discussionMsgRecordHandle_PB ContentHead. disUin:" + l1 + ", divSeq:" + i + ",pkgIndex:" + j + ",pkgNum:" + k);
        }
      }
      l2 = System.currentTimeMillis();
      for (;;)
      {
        try
        {
          a(localMsg, localArrayList2, localPBDecodeContext, true, (MessageInfo)localObject1);
          if (!QLog.isColorLevel()) {
            break label995;
          }
          l3 = System.currentTimeMillis();
          QLog.d("Q.msg.DiscMessageProcessor", 2, "<---discussionMsgRecordHandle_PB decodeSinglePbMsg_Group. isUin:" + l1 + ", cost=" + (l3 - l2));
          l2 = l3;
          if (localArrayList2 != null) {
            a(localArrayList2, (ArrayList)localObject2, true);
          }
          if (QLog.isColorLevel())
          {
            l3 = System.currentTimeMillis();
            QLog.d("Q.msg.DiscMessageProcessor", 2, "<---discussionMsgRecordHandle_PB msgListFilter. disUin:" + l1 + ", cost=" + (l3 - l2));
          }
          if (localObject2 == null) {
            break label992;
          }
          if (((ArrayList)localObject2).size() >= 1) {}
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("Q.msg.DiscMessageProcessor", 2, "decodeSinglePbMsg_GroupDis error,", localException);
          continue;
          MessageHandlerUtils.a((List)localObject2);
          paramArrayList2.addAll((Collection)localObject2);
          if ((paramArrayList1 != null) && (paramArrayList1.length > 0))
          {
            localObject1 = String.valueOf(l4);
            String str = HexUtil.a(paramArrayList1) + ":" + (String)localObject1;
            if (!localHashSet.contains(str))
            {
              paramArrayList1 = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramArrayList1, String.valueOf(l1), (String)localObject1, false);
              if (paramArrayList1 != null)
              {
                localArrayList1.add(paramArrayList1);
                localHashSet.add(str);
              }
            }
          }
        }
        break label62;
        l2 = System.currentTimeMillis();
        if (localArrayList1.size() > 0) {
          ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(localArrayList1);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        l3 = System.currentTimeMillis();
        QLog.d("Q.msg.DiscMessageProcessor", 2, "<---discussionMsgRecordHandle_PB saveDiscussionMemberInfoList. disUin:" + l1 + ", cost=" + (l3 - l2));
        return;
        break label62;
      }
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg, boolean paramBoolean)
  {
    Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!((msg_comm.MsgHead)localObject1).discuss_info.has())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMessageProcessor", 2, "<---handleMsgPush_PB_Group: no groupInfo.");
      }
      return;
    }
    Object localObject2 = (msg_comm.DiscussInfo)((msg_comm.MsgHead)localObject1).discuss_info.get();
    long l1 = ((msg_comm.MsgHead)localObject1).from_uin.get();
    long l4 = ((msg_comm.MsgHead)localObject1).to_uin.get();
    long l5 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
    int n = ((msg_comm.MsgHead)localObject1).msg_time.get();
    long l6 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
    int i1 = ((msg_comm.MsgHead)localObject1).user_active.get();
    int i2 = ((msg_comm.MsgHead)localObject1).from_instid.get();
    long l2 = ((msg_comm.DiscussInfo)localObject2).discuss_uin.get();
    int i3 = ((msg_comm.DiscussInfo)localObject2).discuss_type.get();
    long l7 = ((msg_comm.DiscussInfo)localObject2).discuss_info_seq.get();
    long l3;
    if (paramFromServiceMsg.getUin() == null)
    {
      localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      l3 = ((Long)localObject1).longValue();
      if ((!((msg_comm.DiscussInfo)localObject2).discuss_remark.has()) || (((msg_comm.DiscussInfo)localObject2).discuss_remark.get() == null)) {
        break label1802;
      }
    }
    label1409:
    label1802:
    for (localObject1 = ((msg_comm.DiscussInfo)localObject2).discuss_remark.get().toByteArray();; localObject1 = null)
    {
      int k;
      int j;
      int i;
      if (paramMsg.content_head.has())
      {
        localObject2 = (msg_comm.ContentHead)paramMsg.content_head.get();
        k = ((msg_comm.ContentHead)localObject2).div_seq.get();
        j = ((msg_comm.ContentHead)localObject2).pkg_index.get();
        i = ((msg_comm.ContentHead)localObject2).pkg_num.get();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.ah = i1;
        int m = paramFromServiceMsg.getRequestSsoSeq();
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3, paramPbPushMsg.svrip.get(), m);
          return;
          localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(l2)) != 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(String.valueOf(l2), new Object[] { paramMsg, paramFromServiceMsg, paramPbPushMsg });
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMessageProcessor", 2, "handleMsgPush_PB_Dis unfinished discussionUin=" + l2);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3, paramPbPushMsg.svrip.get(), m);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder("<---handleMsgPush_PB_Dis ");
          paramFromServiceMsg.append(" fromUin:").append(l1).append(" toUin").append(l4).append(" msgTime:").append(n).append(" msgSeq:").append(l5).append(" msgUid:").append(l6).append(" userActive:").append(i1).append(" fromInstid:").append(i2).append(" disUin:").append(l2).append(" disType:").append(i3).append(" disSeq:").append(l7).append(" remarkSender:").append(HexUtil.a((byte[])localObject1)).append(" divSeq:").append(k).append(" pkgIndex:").append(j).append(" pkgNum:").append(i).append(" hasShare:").append(paramMsg.appshare_info.has());
          QLog.d("Q.msg.DiscMessageProcessor", 2, paramFromServiceMsg.toString());
        }
        ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).b(l2);
        paramFromServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramFromServiceMsg.a(l1);
        localObject2 = new PBDecodeContext();
        ((PBDecodeContext)localObject2).e = l2;
        ((PBDecodeContext)localObject2).c = 3000;
        ((PBDecodeContext)localObject2).d = i3;
        localObject2 = a(paramMsg, (PBDecodeContext)localObject2);
        Object localObject3 = new HashSet();
        ArrayList localArrayList = new ArrayList();
        paramMsg = new ArrayList();
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          MessageHandlerUtils.a((List)localObject2);
          j = ((List)localObject2).size();
          i = 0;
          if (i < j)
          {
            Object localObject4 = (MessageRecord)((List)localObject2).get(i);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.DiscMessageProcessor", 2, "----------handleMsgPush_PB_Dis after analysis  mr.senderuin: " + ((MessageRecord)localObject4).senderuin + " mr.msgtype: " + ((MessageRecord)localObject4).msgtype + " mr.frienduin: " + ((MessageRecord)localObject4).frienduin + " mr.shmsgseq: " + ((MessageRecord)localObject4).shmsgseq + " mr.time:" + ((MessageRecord)localObject4).time + " mr.msg: " + ((MessageRecord)localObject4).getLogColorContent());
            }
            Object localObject5;
            if ((((MessageRecord)localObject4).senderuin != null) && (((MessageRecord)localObject4).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
            {
              localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject4).frienduin, 3000, (MessageRecord)localObject4);
              if (localObject5 != null)
              {
                if (((localObject4 instanceof MessageForText)) && ((localObject5 instanceof MessageForText)) && (((MessageRecord)localObject4).getRepeatCount() > 0))
                {
                  ((MessageRecord)localObject5).setRepeatCount(((MessageRecord)localObject4).getRepeatCount());
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.DiscMessageProcessor", 2, "<---handleMsgPush_PB_Dis ===> update findMr.repeatCount=" + ((MessageRecord)localObject5).getRepeatCount());
                  }
                }
                this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(((MessageRecord)localObject4).frienduin, 3000, ((MessageRecord)localObject5).uniseq, ((MessageRecord)localObject4).shmsgseq, ((MessageRecord)localObject4).time);
                this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((MessageRecord)localObject4, (MessageRecord)localObject5);
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject5))
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(((MessageRecord)localObject5).frienduin, 3000, ((MessageRecord)localObject5).uniseq);
                  a(6003, true, ((MessageRecord)localObject5).frienduin);
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(((MessageRecord)localObject5).msgseq);
                }
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(((MessageRecord)localObject4).frienduin, ((MessageRecord)localObject4).shmsgseq);
              }
            }
            for (;;)
            {
              i += 1;
              break;
              ((MessageRecord)localObject4).isread = true;
              ((MessageRecord)localObject4).issend = 2;
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(((MessageRecord)localObject4).frienduin, 3000, ((MessageRecord)localObject4).shmsgseq);
              paramMsg.add(localObject4);
              if ((i == 0) && (localObject1 != null) && (localObject1.length > 0))
              {
                String str = ((MessageRecord)localObject4).senderuin;
                localObject5 = HexUtil.a((byte[])localObject1) + ":" + str;
                if (!((HashSet)localObject3).contains(localObject5))
                {
                  localObject4 = paramFromServiceMsg.a((byte[])localObject1, ((MessageRecord)localObject4).frienduin, str, false);
                  if (localObject4 != null)
                  {
                    localArrayList.add(localObject4);
                    ((HashSet)localObject3).add(localObject5);
                  }
                }
              }
            }
          }
        }
        if (localArrayList.size() > 0) {
          paramFromServiceMsg.c(localArrayList);
        }
        paramFromServiceMsg = new ArrayList();
        if ((paramMsg != null) && (paramMsg.size() > 0)) {
          paramFromServiceMsg.addAll(paramMsg);
        }
        if (paramFromServiceMsg.size() > 0)
        {
          boolean bool2 = MessageHandlerUtils.a(paramFromServiceMsg);
          boolean bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFromServiceMsg);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMsg);
          paramMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause))
          {
            bool1 = true;
            paramMsg.a(paramFromServiceMsg, String.valueOf(l3), bool1);
            paramMsg = new HashMap();
            localObject1 = paramFromServiceMsg.iterator();
          }
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label1582;
            }
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
            if (((MessageRecord)localObject2).istroop == 3000)
            {
              if (paramMsg.containsKey(((MessageRecord)localObject2).frienduin))
              {
                localObject3 = ((MessageRecord)localObject2).frienduin;
                if (((MessageRecord)localObject2).shmsgseq > ((Long)paramMsg.get(((MessageRecord)localObject2).frienduin)).longValue()) {}
                for (l1 = ((MessageRecord)localObject2).shmsgseq;; l1 = ((Long)paramMsg.get(((MessageRecord)localObject2).frienduin)).longValue())
                {
                  paramMsg.put(localObject3, Long.valueOf(l1));
                  break label1409;
                  bool1 = false;
                  break;
                }
              }
              paramMsg.put(((MessageRecord)localObject2).frienduin, Long.valueOf(Math.max(((MessageRecord)localObject2).shmsgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(((MessageRecord)localObject2).frienduin))));
            }
          }
          label1582:
          localObject1 = paramMsg.keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g((String)localObject2, ((Long)paramMsg.get(localObject2)).longValue());
          }
          paramMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(l2);
          paramMsg = paramMsg.a(((StringBuilder)localObject1).toString(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          i = 0;
          if (paramMsg != null)
          {
            if ((paramMsg.flag & 0x1) != 0) {
              break label1778;
            }
            i = 1;
          }
          if ((i == 0) || (!this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool3))) {
            break label1784;
          }
        }
        label1778:
        label1784:
        for (boolean bool1 = true;; bool1 = false)
        {
          a("handleMsgPush_PB_Dis", true, paramFromServiceMsg, bool1, false);
          if (paramBoolean) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3, paramPbPushMsg.svrip.get(), m);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramFromServiceMsg);
          return;
          i = 0;
          break;
        }
        i = 0;
        j = 0;
        k = 0;
      }
    }
  }
  
  public List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    MessageInfo localMessageInfo = new MessageInfo();
    try
    {
      a(paramMsg, localArrayList1, paramPBDecodeContext, true, localMessageInfo);
      long l = paramMsg.msg_head.discuss_info.discuss_uin.get();
      paramMsg = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.DiscMessageProcessor_At_Me_DISC", 2, "decodeMessage");
      }
      paramMsg.a(String.valueOf(l) + "&" + 3000, localMessageInfo);
    }
    catch (Exception paramMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.DiscMessageProcessor", 2, "decodeSinglePbMsg_GroupDis error,", paramMsg);
        }
      }
    }
    a(localArrayList1, localArrayList2, true);
    return localArrayList2;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 4))
      {
        a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2], ((Boolean)paramVarArgs[3]).booleanValue());
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((ToServiceMsg)paramVarArgs[0], (ArrayList)paramVarArgs[1], (msg_svc.PbGetDiscussMsgResp)paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      a((ToServiceMsg)paramVarArgs[0], (ArrayList)paramVarArgs[1], (msg_svc.PbGetDiscussMsgResp)paramVarArgs[2], (String)paramVarArgs[3]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DiscMessageProcessor
 * JD-Core Version:    0.7.0.1
 */