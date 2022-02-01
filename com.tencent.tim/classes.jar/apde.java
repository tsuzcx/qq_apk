import PushNotifyPack.GroupMsgReadedNotify;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbGetGroupMsgResp;
import msf.msgsvc.msg_svc.PbGroupReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import tencent.im.msg.im_msg_body.MsgBody;

public class apde
  extends tnx
{
  public Comparator w = new apdf(this);
  
  public apde(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private long a(ArrayList<msg_comm.Msg> paramArrayList, ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2, String paramString1, String paramString2)
  {
    paramString2 = new ArrayList();
    long l1 = this.app.a().aA(paramString1);
    if (paramArrayList == null) {
      return l1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMessageProcessor", 2, "<---groupMsgRecordHandle_PB : troopUin: " + paramString1 + ", msgs size:" + paramArrayList.size());
    }
    Iterator localIterator = paramArrayList.iterator();
    long l3;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramArrayList = (msg_comm.Msg)localIterator.next();
        if (paramArrayList == null) {
          continue;
        }
        Object localObject = (msg_comm.MsgHead)paramArrayList.msg_head.get();
        l2 = ((msg_comm.MsgHead)localObject).msg_seq.get();
        l3 = ((msg_comm.MsgHead)localObject).msg_uid.get();
        long l4 = ((msg_comm.MsgHead)localObject).to_uin.get();
        long l5 = ((msg_comm.MsgHead)localObject).from_uin.get();
        long l6 = ((msg_comm.MsgHead)localObject).msg_time.get();
        int i = ((msg_comm.MsgHead)localObject).user_active.get();
        int j = ((msg_comm.MsgHead)localObject).from_instid.get();
        localObject = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject).group_info.get();
        int k = ((msg_comm.GroupInfo)localObject).group_type.get();
        long l7 = ((msg_comm.GroupInfo)localObject).group_code.get();
        long l8 = ((msg_comm.GroupInfo)localObject).group_info_seq.get();
        aozx localaozx = new aozx();
        localObject = a((msg_comm.GroupInfo)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMessageProcessor", 2, "<---groupMsgRecordHandle_PB : troopUin: " + paramString1 + ", fromUin:" + l5 + ",toUin:" + l4 + ",msgTime:" + l6 + ",msgSeq:" + l2 + ",msgUid:" + l3 + ",userActive:" + i + ",fromInstid:" + j + ",groupCode:" + l7 + ",groupType:" + k + ",groupSeq:" + l8 + ",cardName:" + aqft.pk((String)localObject) + ",hasAppShare:" + paramArrayList.appshare_info.has() + ",hasMsgBody:" + paramArrayList.msg_body.has());
        }
        localObject = new ArrayList();
        anbl localanbl = new anbl();
        localanbl.friendUin = Long.valueOf(paramString1).longValue();
        localanbl.uinType = 1;
        localanbl.dEX = k;
        if (paramArrayList.content_head.has())
        {
          msg_comm.ContentHead localContentHead = (msg_comm.ContentHead)paramArrayList.content_head.get();
          i = localContentHead.div_seq.get();
          j = localContentHead.pkg_index.get();
          k = localContentHead.pkg_num.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMessageProcessor", 2, "<---groupMsgRecordHandle_PB ContentHead: troopUin: " + paramString1 + ", divSeq:" + i + ",pkgIndex:" + j + ",pkgNum:" + k);
          }
        }
        l3 = System.currentTimeMillis();
        try
        {
          paramArrayList = a(paramArrayList, (ArrayList)localObject, localanbl, true, localaozx);
          if (paramArrayList != null) {
            paramString2.add(paramArrayList);
          }
          if (QLog.isColorLevel())
          {
            l4 = System.currentTimeMillis();
            QLog.d("Q.msg.TroopMessageProcessor", 2, "<---groupMsgRecordHandle_PB decodeSinglePbMsg_GroupDis: troopUin: " + paramString1 + ", cost=" + (l4 - l3));
          }
          if ((localObject != null) && (((ArrayList)localObject).size() != 0))
          {
            achp.iZ((List)localObject);
            paramArrayList2.addAll((Collection)localObject);
            if (l2 > l1) {
              l1 = l2;
            }
          }
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.TroopMessageProcessor", 2, "decodeSinglePbMsg_GroupDis error,", paramArrayList);
            }
            paramArrayList = null;
          }
        }
      }
    }
    long l2 = System.currentTimeMillis();
    ((TroopManager)this.app.getManager(52)).ak(paramString2);
    if (QLog.isColorLevel())
    {
      l3 = System.currentTimeMillis();
      QLog.d("Q.msg.TroopMessageProcessor", 2, "<---groupMsgRecordHandle_PB  saveTroopMemberNickAndLevelAndExtraInfo: troopUin: " + paramString1 + ", cost=" + (l3 - l2));
      l2 = l3;
    }
    for (;;)
    {
      if (paramArrayList2 != null) {
        a(paramArrayList2, paramArrayList1, true);
      }
      if (QLog.isColorLevel())
      {
        l3 = System.currentTimeMillis();
        QLog.d("Q.msg.TroopMessageProcessor", 2, "<---groupMsgRecordHandle_PB  msgListFilter: troopUin: " + paramString1 + ", cost=" + (l3 - l2));
      }
      return l1;
    }
  }
  
  @Nullable
  private String a(msg_comm.GroupInfo paramGroupInfo)
  {
    if ((paramGroupInfo.group_card.has()) && (paramGroupInfo.group_card.get() != null))
    {
      paramGroupInfo = paramGroupInfo.group_card.get().toByteArray();
      try
      {
        paramGroupInfo = new String(paramGroupInfo, "utf-8");
        return paramGroupInfo;
      }
      catch (UnsupportedEncodingException paramGroupInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMessageProcessor", 2, "getCardName fail", paramGroupInfo);
        }
      }
    }
    return null;
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, MessageRecord paramMessageRecord)
  {
    String str;
    int i;
    if ((paramLong1 == 10000L) && ((paramMessageRecord instanceof MessageForStructing)))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if ((paramMessageRecord != null) && (paramMessageRecord.structingMsg != null) && (paramMessageRecord.structingMsg.mMsgServiceID == 60))
      {
        paramMessageRecord = (TroopManager)this.app.getManager(52);
        str = String.valueOf(paramLong2);
        if (paramMessageRecord == null) {
          break label211;
        }
        paramMessageRecord = paramMessageRecord.b(paramString);
        if (paramMessageRecord == null) {
          break label205;
        }
        if ((!TextUtils.isEmpty(paramMessageRecord.troopowneruin)) || (!TextUtils.isEmpty(paramMessageRecord.Administrator))) {
          break label145;
        }
        i = 0;
      }
    }
    for (;;)
    {
      if ((i != 2) || (paramMessageRecord == null)) {
        ((acms)this.app.getBusinessHandler(20)).hT(Long.parseLong(paramString));
      }
      return;
      label145:
      if ((!TextUtils.isEmpty(paramMessageRecord.troopowneruin)) && (paramMessageRecord.troopowneruin.equalsIgnoreCase(str)))
      {
        i = 0;
      }
      else if ((!TextUtils.isEmpty(paramMessageRecord.Administrator)) && (paramMessageRecord.Administrator.contains(str)))
      {
        i = 1;
      }
      else
      {
        label205:
        i = 2;
        continue;
        label211:
        paramMessageRecord = null;
        i = 2;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ArrayList<msg_comm.Msg> paramArrayList, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, String paramString)
  {
    Object localObject2 = paramToServiceMsg.extraData.getString("groupuin");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = String.valueOf(paramPbGetGroupMsgResp.group_code.get());
    }
    localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    long l1 = this.app.a().aA((String)localObject1);
    if (paramArrayList != null) {
      l1 = a(paramArrayList, (ArrayList)localObject2, (ArrayList)localObject3, (String)localObject1, paramString);
    }
    for (;;)
    {
      ((TroopManager)this.app.getManager(52)).Fv((String)localObject1);
      boolean bool1 = false;
      long l2;
      if ((paramPbGetGroupMsgResp.result.get() == 104) && (((ArrayList)localObject2).size() == 0))
      {
        l2 = paramToServiceMsg.extraData.getLong("lEndSeq", paramPbGetGroupMsgResp.return_end_seq.get());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMessageProcessor", 2, "initGetPullTroopMsg reply 104 !! reqEndSeq = " + l2);
        }
        this.app.a().aK((String)localObject1, l2);
      }
      for (int j = 1;; j = 0)
      {
        paramArrayList = new StringBuilder(128);
        int i;
        label690:
        boolean bool2;
        if (((ArrayList)localObject2).size() > 0)
        {
          Collections.sort((List)localObject2, this.w);
          paramToServiceMsg = new ArrayList();
          paramPbGetGroupMsgResp = new ArrayList();
          i = ((ArrayList)localObject2).size() - 1;
          if (i >= 0)
          {
            localObject3 = (MessageRecord)((ArrayList)localObject2).get(i);
            if (QLog.isColorLevel())
            {
              paramArrayList.setLength(0);
              paramArrayList.append("----------initGetPullTroopMsg update send message  mr.senderuin: ").append(((MessageRecord)localObject3).senderuin).append(" mr.msgtype: ").append(((MessageRecord)localObject3).msgtype).append(" mr.frienduin: ").append(((MessageRecord)localObject3).frienduin).append(" mr.shmsgseq: ").append(((MessageRecord)localObject3).shmsgseq).append(" mr.time:").append(((MessageRecord)localObject3).time).append(" mr.msg: ").append(((MessageRecord)localObject3).getLogColorContent());
              QLog.d("Q.msg.TroopMessageProcessor", 2, paramArrayList.toString());
            }
            if (((((MessageRecord)localObject3).senderuin != null) && (((MessageRecord)localObject3).senderuin.equals(this.app.getCurrentAccountUin()))) || ((jof.a((MessageRecord)localObject3)) && (jof.b((MessageRecord)localObject3))))
            {
              if (jof.a((MessageRecord)localObject3))
              {
                ((MessageRecord)localObject3).senderuin = this.app.getCurrentAccountUin();
                localObject4 = jof.a((MessageRecord)localObject3);
                jof.a().a(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).vipBubbleID, ((jof.a)localObject4).aCv, ((jof.a)localObject4).TG, ((jof.a)localObject4).expire_time, ((jof.a)localObject4).TF, ((jof.a)localObject4).TH);
              }
              Object localObject4 = this.app.b().a(((MessageRecord)localObject3).frienduin, 1, (MessageRecord)localObject3);
              if (localObject4 == null) {
                break label690;
              }
              if (((localObject3 instanceof MessageForText)) && ((localObject4 instanceof MessageForText)) && (((MessageRecord)localObject3).getRepeatCount() > 0))
              {
                ((MessageRecord)localObject4).setRepeatCount(((MessageRecord)localObject3).getRepeatCount());
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.TroopMessageProcessor", 2, "<---initGetPullTroopMsg_PB ===> update findMr.repeatCount=" + ((MessageRecord)localObject3).getRepeatCount());
                }
              }
              if (!this.app.a().aww()) {
                this.app.a().e(((MessageRecord)localObject4).frienduin, ((MessageRecord)localObject4).istroop, ((MessageRecord)localObject4).uniseq);
              }
              this.a.b(((MessageRecord)localObject3).frienduin, 1, ((MessageRecord)localObject4).uniseq, ((MessageRecord)localObject3).shmsgseq, ((MessageRecord)localObject3).time);
              this.app.a().aJ((String)localObject1, ((MessageRecord)localObject3).shmsgseq);
            }
            for (;;)
            {
              i -= 1;
              break;
              if (!paramPbGetGroupMsgResp.contains(((MessageRecord)localObject3).senderuin)) {
                paramPbGetGroupMsgResp.add(((MessageRecord)localObject3).senderuin);
              }
              paramToServiceMsg.add(0, localObject3);
            }
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (paramPbGetGroupMsgResp != null) && (paramPbGetGroupMsgResp.size() > 0))
          {
            this.app.a();
            if (anaz.a == null)
            {
              this.app.a();
              anaz.a = new anaz.e();
            }
            this.app.a();
            if (anaz.a.il == null)
            {
              this.app.a();
              anaz.a.il = new ConcurrentHashMap();
            }
            this.app.a();
            anaz.a.il.put(localObject1, paramPbGetGroupMsgResp);
          }
          if (paramToServiceMsg.size() > 0)
          {
            paramPbGetGroupMsgResp = this.app.a().e((String)localObject1);
            if (paramPbGetGroupMsgResp == null) {
              break label1341;
            }
            paramArrayList = (tnu)this.app.b().a(1);
            l2 = ((Long)paramPbGetGroupMsgResp[0]).longValue();
            int k = paramToServiceMsg.size();
            i = 0;
            while (i < k)
            {
              paramPbGetGroupMsgResp = (MessageRecord)paramToServiceMsg.get(i);
              if ((paramPbGetGroupMsgResp instanceof MessageForMarketFace)) {
                ajdf.a(this.app, (MessageForMarketFace)paramPbGetGroupMsgResp);
              }
              if ((((MessageRecord)paramToServiceMsg.get(i)).senderuin != null) && (((MessageRecord)paramToServiceMsg.get(i)).senderuin.equalsIgnoreCase(this.app.getCurrentAccountUin())))
              {
                ((MessageRecord)paramToServiceMsg.get(i)).isread = true;
                ((MessageRecord)paramToServiceMsg.get(i)).issend = 2;
              }
              if (l2 >= ((MessageRecord)paramToServiceMsg.get(i)).shmsgseq) {
                ((MessageRecord)paramToServiceMsg.get(i)).isread = true;
              }
              i += 1;
            }
            if (paramArrayList.a((String)localObject1, 1, paramToServiceMsg, paramString)) {
              break label1341;
            }
            bool2 = achp.F(paramToServiceMsg);
            i = top.a(paramToServiceMsg, this.app);
            paramPbGetGroupMsgResp = this.app.b();
            if ((bool2) && (this.app.isBackground_Stop))
            {
              bool1 = true;
              paramPbGetGroupMsgResp.a(paramToServiceMsg, paramString, bool1, false);
              paramArrayList.k((String)localObject1, 1, l2);
              paramArrayList.r((String)localObject1, paramToServiceMsg);
              bool1 = bool2;
            }
          }
        }
        for (;;)
        {
          if ((j != 0) && (this.app.a().eb((String)localObject1) == 1))
          {
            paramArrayList = this.app.a().e((String)localObject1);
            if (paramArrayList != null)
            {
              l2 = ((Long)paramArrayList[0]).longValue();
              ((tnu)this.app.b().a(1)).k((String)localObject1, 1, l2);
            }
          }
          if (l1 >= 0L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.TroopMessageProcessor", 2, "groupMsgRecordHandle info.lGroupCode: " + (String)localObject1 + " info.lsMsgSeq: " + l1);
            }
            this.app.a().aJ((String)localObject1, l1);
          }
          bool2 = achp.G(paramToServiceMsg);
          a("initGetPullTroopMsg", true, i, this.a.a(bool1, bool2, paramToServiceMsg), false);
          this.a.dI(paramToServiceMsg);
          ((aqrc)this.app.getManager(235)).c.ka(paramToServiceMsg);
          if (paramToServiceMsg.size() > 0) {
            acqz.e((MessageRecord)paramToServiceMsg.get(0), this.app);
          }
          return;
          bool1 = false;
          break;
          j = 1;
          i = 0;
          bool1 = false;
          continue;
          j = 1;
          paramToServiceMsg = (ToServiceMsg)localObject2;
          i = 0;
          continue;
          label1341:
          i = 0;
          bool1 = false;
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, ArrayList<msg_comm.Msg> paramArrayList, String paramString)
  {
    paramString = new ArrayList();
    aozx localaozx = new aozx();
    Object localObject1;
    if (paramArrayList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopMessageProcessor", 2, "<---refreshTroopHead_PB: size:" + paramArrayList.size());
      }
      localObject1 = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paramArrayList = (msg_comm.Msg)localIterator.next();
          if (paramArrayList == null) {
            continue;
          }
          Object localObject2 = (msg_comm.MsgHead)paramArrayList.msg_head.get();
          long l1 = ((msg_comm.MsgHead)localObject2).msg_seq.get();
          long l2 = ((msg_comm.MsgHead)localObject2).msg_uid.get();
          long l3 = ((msg_comm.MsgHead)localObject2).to_uin.get();
          long l4 = ((msg_comm.MsgHead)localObject2).from_uin.get();
          long l5 = ((msg_comm.MsgHead)localObject2).msg_time.get();
          int i = ((msg_comm.MsgHead)localObject2).user_active.get();
          int j = ((msg_comm.MsgHead)localObject2).from_instid.get();
          localObject2 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject2).group_info.get();
          int k = ((msg_comm.GroupInfo)localObject2).group_type.get();
          long l6 = ((msg_comm.GroupInfo)localObject2).group_code.get();
          long l7 = ((msg_comm.GroupInfo)localObject2).group_info_seq.get();
          Object localObject3 = a((msg_comm.GroupInfo)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMessageProcessor", 2, "<---refreshTroopHead_PB : fromUin:" + l4 + ",toUin:" + l3 + ",msgTime:" + l5 + ",msgSeq:" + l1 + ",msgUid:" + l2 + ",userActive:" + i + ",fromInstid:" + j + ",groupCode:" + l6 + ",groupType:" + k + ",groupSeq:" + l7 + ",Hascard:" + ((msg_comm.GroupInfo)localObject2).group_card.has() + ",cardName:" + aqft.pk((String)localObject3) + ",hasAppShare:" + paramArrayList.appshare_info.has() + ",hasMsgBody:" + paramArrayList.msg_body.has());
          }
          localObject2 = new ArrayList();
          localObject3 = new anbl();
          ((anbl)localObject3).friendUin = paramPbGetGroupMsgResp.group_code.get();
          ((anbl)localObject3).uinType = 1;
          ((anbl)localObject3).dEX = k;
          if (paramArrayList.content_head.has())
          {
            msg_comm.ContentHead localContentHead = (msg_comm.ContentHead)paramArrayList.content_head.get();
            i = localContentHead.div_seq.get();
            j = localContentHead.pkg_index.get();
            k = localContentHead.pkg_num.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.TroopMessageProcessor", 2, "<---refreshTroopHead_PB ContentHead: divSeq:" + i + ",pkgIndex:" + j + ",pkgNum:" + k);
            }
          }
          try
          {
            paramArrayList = a(paramArrayList, (ArrayList)localObject2, (anbl)localObject3, true, localaozx);
            if (paramArrayList != null)
            {
              paramArrayList.level = -1;
              ((ArrayList)localObject1).add(paramArrayList);
            }
            if (((ArrayList)localObject2).size() != 0)
            {
              achp.iZ((List)localObject2);
              if (paramString != null) {
                a((List)localObject2, paramString, true);
              }
            }
          }
          catch (Exception paramArrayList)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.w("Q.msg.TroopMessageProcessor", 2, "decodeSinglePbMsg_GroupDis error,", paramArrayList);
              }
              paramArrayList = null;
            }
          }
        }
      }
      ((TroopManager)this.app.getManager(52)).ak((List)localObject1);
    }
    paramArrayList = paramString.iterator();
    while (paramArrayList.hasNext())
    {
      localObject1 = (MessageRecord)paramArrayList.next();
      if ((((MessageRecord)localObject1).senderuin != null) && (((MessageRecord)localObject1).senderuin.equalsIgnoreCase(this.app.getCurrentAccountUin()))) {
        ((MessageRecord)localObject1).issend = 2;
      }
      ((MessageRecord)localObject1).isread = true;
    }
    Collections.sort(paramString, this.w);
    paramArrayList = paramPbGetGroupMsgResp.group_code.toString();
    ((ajdr)this.app.getManager(37)).a(paramArrayList, localaozx);
    paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
    paramArrayList = new ArrayList();
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.putLong("beginSeq", paramPbGetGroupMsgResp.return_begin_seq.get());
      paramToServiceMsg.putLong("endSeq", paramPbGetGroupMsgResp.return_end_seq.get());
      paramToServiceMsg.putBoolean("success", true);
    }
    this.app.b().b(String.valueOf(paramPbGetGroupMsgResp.group_code.get()), 1, paramString, paramArrayList, paramToServiceMsg);
    this.a.dI(paramArrayList);
    ((aqrc)this.app.getManager(235)).c.ka(paramString);
  }
  
  private void a(String paramString, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (((paramMessageRecord1 instanceof MessageForText)) && ((paramMessageRecord2 instanceof MessageForText)) && (paramMessageRecord1.getRepeatCount() > 0))
    {
      paramMessageRecord2.setRepeatCount(paramMessageRecord1.getRepeatCount());
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group ===> update findMr.repeatCount=" + paramMessageRecord2.getRepeatCount());
      }
    }
    long l = paramMessageRecord2.shmsgseq;
    this.a.b(paramMessageRecord1.frienduin, 1, paramMessageRecord2.uniseq, paramMessageRecord1.shmsgseq, paramMessageRecord1.time);
    Object localObject1;
    if (paramMessageRecord1.msgtype == -2011)
    {
      this.app.a(1);
      localObject1 = this.app.b().a(paramMessageRecord1.frienduin, 1, paramMessageRecord1.shmsgseq, -5020);
      if ((localObject1 != null) && ((localObject1 instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localObject1).tipParam != null) && (((MessageForUniteGrayTip)localObject1).tipParam.dbK == 3276802))
      {
        this.app.b().i(paramMessageRecord1.frienduin, 1, ((MessageRecord)localObject1).uniseq);
        this.app.b().b(paramMessageRecord1.frienduin, 1, (MessageRecord)localObject1);
        QLog.i("Q.msg.TroopMessageProcessor" + aoaf.cjv, 1, "updateGroupMsgSeqAndTime. docs gray msg. shmsgseq = " + paramMessageRecord1.shmsgseq + ", grayMsgType = " + -5020 + ", grayUniSeq = " + ((MessageRecord)localObject1).uniseq);
      }
    }
    label342:
    label361:
    while (paramMessageRecord1.msgtype != -2000)
    {
      if (paramMessageRecord2.msgtype != -2017) {
        break;
      }
      localObject1 = top.a(paramMessageRecord2, paramMessageRecord1);
      this.app.b().c(paramMessageRecord1.frienduin, 1, paramMessageRecord2.uniseq, (byte[])localObject1);
      wte.a().h(this.app, paramMessageRecord2.uniseq);
      if (!this.app.a().aR(paramMessageRecord2)) {
        break label888;
      }
      y(paramMessageRecord2);
      this.app.a().aJ(paramString, paramMessageRecord1.shmsgseq);
      return;
    }
    label900:
    label906:
    for (;;)
    {
      try
      {
        localObject1 = this.app.b().c(paramMessageRecord1.frienduin, 1, l, -5040);
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break label900;
        }
        localObject1 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
        if (!QLog.isColorLevel()) {
          break label906;
        }
        QLog.i("Q.msg.TroopMessageProcessorTroopGrayTipUtils", 2, "updateGroupMsgSeqAndTime. grayMr = " + localObject1);
      }
      catch (Exception localException)
      {
        QLog.i("Q.msg.TroopMessageProcessorTroopGrayTipUtils", 1, "update grayTip seq exception", localException);
      }
      if ((localObject1 == null) || (!(localObject1 instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)localObject1).tipParam == null) || (((MessageForUniteGrayTip)localObject1).tipParam.dbK != 131086)) {
        break;
      }
      l = Long.parseLong(((MessageRecord)localObject1).getExtInfoFromExtStr("grayLastUniseq"));
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.TroopMessageProcessorTroopGrayTipUtils", 2, "updateGroupMsgSeqAndTime. TroopGrayTip. grayMr.lastUniseq=" + l);
      }
      if (l != paramMessageRecord2.uniseq) {
        break;
      }
      this.app.b().a(paramMessageRecord1.frienduin, 1, ((MessageRecord)localObject1).uniseq, paramMessageRecord1.shmsgseq, paramMessageRecord1.time);
      break;
      break;
      if ((anrx.aX(paramMessageRecord2)) || (paramMessageRecord2.msgtype == -2048))
      {
        if (paramMessageRecord1.msgtype == -2048)
        {
          localObject2 = (MessageForTroopReward)paramMessageRecord1;
          ((MessageForTroopReward)localObject2).mediaPath = ((MessageForTroopReward)paramMessageRecord2).mediaPath;
          ((MessageForTroopReward)localObject2).prewrite();
          paramMessageRecord1.msgData = ((MessageForTroopReward)localObject2).msgData;
          if (QLog.isColorLevel()) {
            QLog.d(".troop.troop_reward", 2, "replace msg,rewardId:" + ((MessageForTroopReward)localObject2).rewardId);
          }
        }
        this.app.a().e(paramMessageRecord1.frienduin, 1, paramMessageRecord2.uniseq);
        this.app.b().c(paramMessageRecord1.frienduin, 1, paramMessageRecord2.uniseq, paramMessageRecord1.msgData);
        b(999, true, paramMessageRecord1.frienduin);
        break label342;
      }
      if (paramMessageRecord2.msgtype != -1049) {
        break label342;
      }
      Object localObject2 = (MessageForReplyText)paramMessageRecord2;
      ((MessageForReplyText)paramMessageRecord1).extStr = ((MessageForReplyText)localObject2).extStr;
      this.app.a().e(paramMessageRecord1.frienduin, 1, paramMessageRecord2.uniseq);
      this.app.b().a(paramMessageRecord1.frienduin, 1, paramMessageRecord2.uniseq, "extStr", paramMessageRecord1.extStr);
      this.app.b().a(paramMessageRecord1.frienduin, 1, paramMessageRecord2.uniseq, "extLong", Integer.valueOf(paramMessageRecord1.extLong));
      break label342;
      label888:
      this.a.a(paramMessageRecord1, paramMessageRecord2);
      break label361;
      localObject2 = null;
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg, boolean paramBoolean)
  {
    Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!((msg_comm.MsgHead)localObject1).group_info.has())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group: no groupInfo.");
      }
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject2 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject1).group_info.get();
    long l2 = ((msg_comm.MsgHead)localObject1).from_uin.get();
    long l6 = ((msg_comm.MsgHead)localObject1).to_uin.get();
    long l3 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
    long l4 = ((msg_comm.MsgHead)localObject1).msg_time.get();
    long l7 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
    int i1 = ((msg_comm.MsgHead)localObject1).user_active.get();
    int i2 = ((msg_comm.MsgHead)localObject1).from_instid.get();
    long l8 = ((msg_comm.GroupInfo)localObject2).group_code.get();
    int n = ((msg_comm.GroupInfo)localObject2).group_type.get();
    long l9 = ((msg_comm.GroupInfo)localObject2).group_info_seq.get();
    label178:
    long l5;
    Object localObject3;
    int k;
    int i;
    int j;
    if (paramFromServiceMsg.getUin() == null)
    {
      localObject1 = Long.valueOf(this.app.getCurrentAccountUin());
      l5 = ((Long)localObject1).longValue();
      localObject3 = a((msg_comm.GroupInfo)localObject2);
      localObject1 = new ArrayList();
      if (!paramMsg.content_head.has()) {
        break label1694;
      }
      localObject2 = (msg_comm.ContentHead)paramMsg.content_head.get();
      k = ((msg_comm.ContentHead)localObject2).div_seq.get();
      i = ((msg_comm.ContentHead)localObject2).pkg_index.get();
      int m = ((msg_comm.ContentHead)localObject2).pkg_num.get();
      j = i;
      i = m;
    }
    for (;;)
    {
      String str;
      boolean bool1;
      label355:
      boolean bool2;
      for (;;)
      {
        this.app.cxj = i1;
        str = String.valueOf(l8);
        localObject2 = new ArrayList();
        anbl localanbl = new anbl();
        localanbl.friendUin = l8;
        localanbl.uinType = 1;
        localanbl.dEX = n;
        Object localObject4;
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder().append("<---handleMsgPush_PB_Group : needAck ").append(paramBoolean).append(" pushMsg ");
          if (paramPbPushMsg != null)
          {
            bool1 = true;
            QLog.d("Q.msg.TroopMessageProcessor", 2, bool1);
          }
        }
        else
        {
          if ((paramBoolean) && (paramPbPushMsg != null)) {
            this.a.a(l5, paramPbPushMsg.svrip.get(), paramFromServiceMsg.getRequestSsoSeq(), paramPbPushMsg);
          }
          if (this.app.a().eb(str) != 2) {
            break label467;
          }
        }
        label467:
        for (paramBoolean = true;; paramBoolean = false)
        {
          if (this.app.a.abS()) {
            break label473;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group : isNeedPushMsg false");
          return;
          localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
          break label178;
          bool1 = false;
          break label355;
        }
        label473:
        paramPbPushMsg = (ajdr)this.app.getManager(37);
        if (!MessageHandler.bIl)
        {
          if (paramBoolean) {
            break label608;
          }
          this.app.a().q(str, new Object[] { paramMsg, paramFromServiceMsg });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group : unfinished troopuin=" + str);
          return;
        }
        if (!this.app.a.abU())
        {
          this.app.a().q(str, new Object[] { paramMsg, paramFromServiceMsg });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group : isSyncNormalMsgFinish false");
          return;
        }
        label608:
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder("<---handleMsgPush_PB_Group : before analysis :");
          ((StringBuilder)localObject4).append(" fromUin:").append(l2).append(" toUin:").append(l6).append(" msgTime:").append(l4).append(" msgSeq:").append(l3).append(" msgUid:").append(l7).append(" userActive:").append(i1).append(" fromInstid:").append(i2).append(" groupCode:").append(l8).append(" groupType:").append(n).append(" groupSeq:").append(l9).append(" cardName:").append(aqft.pk((String)localObject3)).append(" hasAppShare:").append(paramMsg.appshare_info.has()).append(" bFinished:").append(paramBoolean).append(" divSeq:").append(k).append(" pkgIndex:").append(j).append(" pkgNum:").append(i);
          QLog.d("Q.msg.TroopMessageProcessor", 2, ((StringBuilder)localObject4).toString());
          if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null)
          {
            l6 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() / 1000L;
            QLog.d("Q.msg.TroopMessageProcessor", 2, "push_cost=" + (l6 - l4) + ",type=GROUP_PUSH_MSG");
          }
        }
        ((TroopManager)this.app.getManager(52)).Fv(str);
        paramFromServiceMsg = new aozx();
        try
        {
          a(paramMsg, (ArrayList)localObject1, localanbl, true, paramFromServiceMsg);
          achp.iZ((List)localObject1);
          if (((ArrayList)localObject1).size() == 0)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group : msg list is empty after decode.");
            return;
          }
        }
        catch (Exception paramMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.TroopMessageProcessor", 2, "decodeSinglePbMsg_GroupDis error,", paramMsg);
            }
          }
          a((List)localObject1, (ArrayList)localObject2, true);
          paramMsg = new ArrayList();
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
          {
            j = ((ArrayList)localObject2).size();
            i = 0;
            if (i < j)
            {
              localObject3 = (MessageRecord)((ArrayList)localObject2).get(i);
              a(l2, l5, str, (MessageRecord)localObject3);
              if ((localObject3 instanceof MessageForMarketFace)) {
                ajdf.a(this.app, (MessageForMarketFace)localObject3);
              }
              if (QLog.isColorLevel())
              {
                localObject4 = new StringBuilder("<---handleMsgPush_PB_Group : after analysis :");
                ((StringBuilder)localObject4).append(" mr.senderuin:").append(((MessageRecord)localObject3).senderuin).append(" mr.msgtype:").append(((MessageRecord)localObject3).msgtype).append(" mr.frienduin:").append(((MessageRecord)localObject3).frienduin).append(" mr.shmsgseq:").append(((MessageRecord)localObject3).shmsgseq).append(" mr.time:").append(((MessageRecord)localObject3).time).append(" mr.msg:").append(((MessageRecord)localObject3).getLogColorContent());
                QLog.d("Q.msg.TroopMessageProcessor", 2, ((StringBuilder)localObject4).toString());
              }
              if (((((MessageRecord)localObject3).senderuin != null) && (((MessageRecord)localObject3).senderuin.equalsIgnoreCase(this.app.getCurrentAccountUin()))) || ((jof.a((MessageRecord)localObject3)) && (jof.b((MessageRecord)localObject3))))
              {
                if (jof.a((MessageRecord)localObject3))
                {
                  ((MessageRecord)localObject3).senderuin = this.app.getCurrentAccountUin();
                  localObject4 = jof.a((MessageRecord)localObject3);
                  jof.a().a(String.valueOf(localanbl.friendUin), ((MessageRecord)localObject3).vipBubbleID, ((jof.a)localObject4).aCv, ((jof.a)localObject4).TG, ((jof.a)localObject4).expire_time, ((jof.a)localObject4).TF, ((jof.a)localObject4).TH);
                }
                localObject4 = this.app.b().a(((MessageRecord)localObject3).frienduin, 1, (MessageRecord)localObject3);
                if (localObject4 != null) {
                  a(str, (MessageRecord)localObject3, (MessageRecord)localObject4);
                }
              }
              for (;;)
              {
                i += 1;
                break;
                ((MessageRecord)localObject3).isread = true;
                ((MessageRecord)localObject3).issend = 2;
                this.app.b().s(((MessageRecord)localObject3).frienduin, 1, ((MessageRecord)localObject3).shmsgseq);
                paramMsg.add(localObject3);
                if ((localObject3 instanceof MessageForTroopFile)) {
                  ((aocq)this.app.getManager(272)).Z((ChatMessage)localObject3);
                }
              }
            }
          }
          this.app.a().mp(paramMsg);
          bool1 = achp.F(paramMsg);
          bool2 = achp.G(paramMsg);
          i = top.a(paramMsg, this.app);
          paramPbPushMsg.a(str, paramFromServiceMsg);
          paramFromServiceMsg = this.app.b();
          if (!bool1) {
            break label1688;
          }
        }
      }
      if (this.app.isBackground_Stop) {}
      label1688:
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramFromServiceMsg.c(paramMsg, String.valueOf(l5), paramBoolean);
        anod.T(0, 1, 1, paramMsg.size());
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          this.app.a().aJ(str, l3);
          paramFromServiceMsg = (MessageRecord)((ArrayList)localObject1).get(0);
          ((aptw)this.app.getManager(203)).bh(paramFromServiceMsg);
        }
        if (n == 127) {
          break;
        }
        a("handleMsgPush_PB_Group", true, i, this.a.a(bool1, bool2, paramMsg), false);
        this.a.dI(paramMsg);
        ((aqrc)this.app.getManager(235)).c.ka((List)localObject2);
        l1 = System.currentTimeMillis() - l1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMessageProcessor", 2, "decodecMsg cost:" + l1);
        }
        acqz.ad("actGroupDecodeCost", l1);
        if (((ArrayList)localObject2).size() <= 0) {
          break;
        }
        acqz.e((MessageRecord)((ArrayList)localObject2).get(0), this.app);
        return;
      }
      label1694:
      i = 0;
      j = 0;
      k = 0;
    }
  }
  
  private void t(List<msg_comm.Msg> paramList1, List<msg_comm.Msg> paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---TroopMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("Q.msg.TroopMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public List<MessageRecord> a(msg_comm.Msg paramMsg, anbl paramanbl)
  {
    return null;
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void a(GroupMsgReadedNotify paramGroupMsgReadedNotify)
  {
    String str = String.valueOf(paramGroupMsgReadedNotify.lGroupCode);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMessageProcessor", 2, "GroupMsgReadedNotify lGroupCode is " + paramGroupMsgReadedNotify.lGroupCode + ", lMemberSeq  is " + paramGroupMsgReadedNotify.lMemberSeq);
    }
    Object[] arrayOfObject = this.app.a().e(str);
    if ((arrayOfObject != null) && (arrayOfObject.length >= 2))
    {
      long l = ((Long)arrayOfObject[0]).longValue();
      ((Long)arrayOfObject[1]).longValue();
      if (l < paramGroupMsgReadedNotify.lMemberSeq) {
        this.app.a().s(str, new Object[] { Long.valueOf(paramGroupMsgReadedNotify.lMemberSeq), Long.valueOf(paramGroupMsgReadedNotify.lGroupMsgSeq) });
      }
    }
    this.app.b().s(str, 1, paramGroupMsgReadedNotify.lMemberSeq);
    if (paramGroupMsgReadedNotify.lMemberSeq >= 0L) {
      this.app.b().a.ea(str, 1);
    }
    paramGroupMsgReadedNotify = (apsa)this.app.getManager(132);
    if (paramGroupMsgReadedNotify.qQ(str))
    {
      paramGroupMsgReadedNotify.TO(str);
      if (!paramGroupMsgReadedNotify.qP(str)) {
        paramGroupMsgReadedNotify.TM(str);
      }
    }
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void b(String paramString, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMessageProcessor", 2, "doSomeAfterGetPullTroopMsg doSome:" + paramInt + " troopUin:" + paramString);
    }
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    }
    ((HotChatManager)this.app.getManager(60)).a(paramString, paramPbGetGroupMsgResp, paramInt);
  }
  
  public void f(int paramInt, Object... paramVarArgs)
  {
    ArrayList localArrayList;
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
      bN(getClass().getName(), paramInt);
      return;
    case 1002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 4))
      {
        localArrayList = new ArrayList();
        t((ArrayList)paramVarArgs[1], localArrayList);
        a((ToServiceMsg)paramVarArgs[0], localArrayList, (msg_svc.PbGetGroupMsgResp)paramVarArgs[2], (String)paramVarArgs[3]);
        return;
      }
      bN(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      localArrayList = new ArrayList();
      t((ArrayList)paramVarArgs[2], localArrayList);
      a((ToServiceMsg)paramVarArgs[0], (msg_svc.PbGetGroupMsgResp)paramVarArgs[1], localArrayList, (String)paramVarArgs[3]);
      return;
    }
    bN(getClass().getName(), paramInt);
  }
  
  public void m(String paramString, int paramInt, long paramLong)
  {
    super.m(paramString, paramInt, paramLong);
    if (!paramString.matches("^\\d+$")) {
      return;
    }
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    msg_svc.PbGroupReadedReportReq localPbGroupReadedReportReq = new msg_svc.PbGroupReadedReportReq();
    localPbGroupReadedReportReq.group_code.set(Long.valueOf(paramString).longValue());
    localPbGroupReadedReportReq.last_read_seq.set(paramLong);
    localPbMsgReadedReportReq.grp_read_report.add(localPbGroupReadedReportReq);
    a(localPbMsgReadedReportReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apde
 * JD-Core Version:    0.7.0.1
 */