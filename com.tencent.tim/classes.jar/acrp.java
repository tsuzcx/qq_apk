import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.DelDecideInfo;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.DelMsgInfo;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.DelUnDecideInfo;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.ReqBody;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.RspBody;
import tencent.mobileim.structmsg.structmsg.FlagInfo;
import tencent.mobileim.structmsg.structmsg.MsgInviteExt;
import tencent.mobileim.structmsg.structmsg.ReqNextSystemMsg;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgAction;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgNew;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgRead;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgAction;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgNew;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgRead;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class acrp
  extends tnv
{
  private int czo;
  private int czp;
  private int czq;
  private final int czr = 2;
  private final int czs = 2;
  private final int czt = 2;
  private ArrayList<Integer> tV;
  
  public acrp(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    if (paramRspSystemMsgNew != null)
    {
      if ((paramRspSystemMsgNew != null) && (paramRspSystemMsgNew.head.result.get() == 0)) {
        break label130;
      }
      if (QLog.isColorLevel()) {
        QLog.e("SystemMessageProcessor", 2, "rspSystemMsg.head.result.get()" + paramRspSystemMsgNew.head.result.get());
      }
      this.a.n(paramToServiceMsg, paramFromServiceMsg);
    }
    label130:
    do
    {
      for (;;)
      {
        return;
        try
        {
          for (;;)
          {
            paramRspSystemMsgNew = new structmsg.RspSystemMsgNew();
            try
            {
              paramRspSystemMsgNew.mergeFrom((byte[])paramObject);
            }
            catch (Exception localException1)
            {
              paramObject = paramRspSystemMsgNew;
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject1;
            Object localObject2;
            int m;
            int k;
            int j;
            boolean bool1;
            ysf localysf;
            int i;
            int n;
            long l1;
            long l2;
            Object localObject3;
            String str;
            long l3;
            boolean bool2;
            paramObject = null;
            continue;
            continue;
            paramObject = "";
          }
        }
      }
      paramRspSystemMsgNew = paramObject;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : decode pb error:", localException1);
      paramRspSystemMsgNew = paramObject;
      break;
      localObject1 = (acff)this.app.getManager(51);
      localObject2 = paramRspSystemMsgNew.friendmsgs.get();
      m = ((List)localObject2).size();
      k = paramRspSystemMsgNew.unread_friend_count.get();
      j = paramRspSystemMsgNew.uint32_un_read_count3.get();
      if (paramRspSystemMsgNew.uint32_over.get() == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        anzd.a().U(this.app, bool1);
        localysf = (ysf)this.app.getManager(34);
        i = localysf.xp();
        anzd.a().M(this.app, k);
        n = paramToServiceMsg.extraData.getInt("getSystemMsgSender");
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageProcessor", 2, "processFriendSystemMsg-->requestFrom:" + n);
        }
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder(128);
          paramObject.append("<---handleGetFriendSystemMsgResp : decode pb MsgsSize = ").append(m).append(" latest_friend_seq").append(paramRspSystemMsgNew.latest_friend_seq.get()).append(" latest_group_seq").append(paramRspSystemMsgNew.latest_group_seq.get()).append(" following_friend_seq").append(paramRspSystemMsgNew.following_friend_seq.get()).append(" following_group_seq").append(paramRspSystemMsgNew.following_group_seq.get()).append(" unreadCount").append(k).append(" localunreadCount").append(i).append(" isSysMsgOver").append(bool1).append(" unreadCountForSuspicious").append(j);
          QLog.d("Q.systemmsg.", 2, paramObject.toString());
        }
        if ((k != 0) || (m != 0) || (n != 2)) {
          break;
        }
        this.app.b().N(acbn.bkJ, 0);
        localysf.cln();
        b(4014, true, null);
        return;
      }
      if (!paramRspSystemMsgNew.msg_display.has()) {
        break label2001;
      }
      paramObject = paramRspSystemMsgNew.msg_display.get();
      l1 = 0L;
      if (((List)localObject2).size() > 0)
      {
        l2 = ((structmsg.StructMsg)((List)localObject2).get(0)).msg_time.get();
        localObject3 = ((structmsg.StructMsg)((List)localObject2).get(0)).msg;
        l1 = l2;
        if (localObject3 != null)
        {
          l1 = l2;
          if (((structmsg.SystemMsg)localObject3).has())
          {
            if ((((structmsg.SystemMsg)localObject3).bytes_game_nick.has()) && (((structmsg.StructMsg)((List)localObject2).get(0)).req_uin.has()))
            {
              str = ((structmsg.SystemMsg)localObject3).bytes_game_nick.get().toStringUtf8();
              l1 = ((structmsg.StructMsg)((List)localObject2).get(0)).req_uin.get();
              KplRoleInfo.saveGameNickWithUin(this.app, String.valueOf(l1), str);
            }
            if (((structmsg.SystemMsg)localObject3).bytes_game_msg.has())
            {
              localObject3 = ((structmsg.SystemMsg)localObject3).bytes_game_msg.get().toStringUtf8();
              KplRoleInfo.saveKplVerifyMsg(this.app, (String)localObject3);
            }
            l1 = l2;
            if (paramRspSystemMsgNew.bytes_game_nick.has())
            {
              KplRoleInfo.saveGameNickWithUin(this.app, paramToServiceMsg.getUin(), paramRspSystemMsgNew.bytes_game_nick.get());
              l1 = l2;
            }
          }
        }
      }
      this.czo = 0;
      j = 0;
      l2 = this.app.a().aD("last_friend_seq_47");
      l3 = paramRspSystemMsgNew.latest_friend_seq.get();
      if (l2 != l3) {
        break label869;
      }
      if ((k == 0) || (l1 != 0L)) {
        break label811;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SystemMessageProcessor", 2, "sentSeq == respSeq | unreadCount = " + k + " | newFriendLastMsgTime = 0");
    return;
    label811:
    paramToServiceMsg = paramObject;
    if (TextUtils.isEmpty(paramObject)) {
      paramToServiceMsg = rS();
    }
    if ((i != k) && (k == 0)) {
      this.app.b().a(acbn.bkJ, 0, true, true);
    }
    localysf.b(new ytq(paramToServiceMsg, l1));
    return;
    label869:
    i = j;
    if (k == 0)
    {
      i = j;
      if (m == 0) {
        i = 1;
      }
    }
    this.app.a().aN("last_friend_seq_47", paramRspSystemMsgNew.latest_friend_seq.get());
    this.app.a().aN("following_friend_seq_47", paramRspSystemMsgNew.following_friend_seq.get());
    anzd.a().c(false, this.app);
    label1312:
    label1318:
    label1324:
    label1860:
    if (i == 0)
    {
      paramRspSystemMsgNew = new ArrayList(m);
      if (paramFromServiceMsg.getUin() == null)
      {
        paramToServiceMsg = this.app.getAccount();
        if (k <= 0) {
          break label1312;
        }
        bool1 = true;
        label982:
        i = 0;
        label985:
        if (i >= m) {
          break label1354;
        }
        paramFromServiceMsg = anbi.d(-2050);
        paramFromServiceMsg.msgtype = -2050;
        paramFromServiceMsg.selfuin = paramToServiceMsg;
        paramFromServiceMsg.frienduin = acbn.bkJ;
        paramFromServiceMsg.senderuin = (((structmsg.StructMsg)((List)localObject2).get(i)).req_uin.get() + "");
        paramFromServiceMsg.istroop = 0;
        paramFromServiceMsg.time = ((structmsg.StructMsg)((List)localObject2).get(i)).msg_time.get();
        if (((structmsg.StructMsg)((List)localObject2).get(i)).uint32_unread_flag.get() != 0) {
          break label1318;
        }
        bool2 = true;
        label1110:
        paramFromServiceMsg.isread = bool2;
        localObject3 = (MessageForSystemMsg)paramFromServiceMsg;
        ((MessageForSystemMsg)localObject3).structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)((List)localObject2).get(i)).get());
        j = ((MessageForSystemMsg)localObject3).structMsg.msg_type.get();
        n = ((MessageForSystemMsg)localObject3).structMsg.msg.sub_type.get();
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp|i = " + i + ", isRead = " + paramFromServiceMsg.isread + ", time = " + paramFromServiceMsg.time + ", uin = " + paramFromServiceMsg.senderuin);
        }
        if (i != 0) {
          break label1998;
        }
        paramFromServiceMsg.extStr = paramObject;
        if (n != 13) {
          break label1998;
        }
        bool1 = false;
        if ((j != 1) || (anzf.lL(n))) {
          break label1324;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : decode pb filtered");
        }
      }
      for (;;)
      {
        i += 1;
        break label985;
        paramToServiceMsg = paramFromServiceMsg.getUin();
        break;
        bool1 = false;
        break label982;
        bool2 = false;
        break label1110;
        paramFromServiceMsg.msgData = ((MessageForSystemMsg)localObject3).structMsg.toByteArray();
        ((ChatMessage)paramFromServiceMsg).parse();
        paramRspSystemMsgNew.add(localObject3);
      }
      label1354:
      if (paramRspSystemMsgNew.size() > 0)
      {
        i = paramRspSystemMsgNew.size();
        l2 = ((MessageRecord)paramRspSystemMsgNew.get(i - 1)).time;
        l3 = anzd.a().p(this.app);
        paramFromServiceMsg = this.app.b().a(acbn.bkJ, 0, l3);
        localObject2 = paramFromServiceMsg.iterator();
        if (i < 20) {
          while (((Iterator)localObject2).hasNext())
          {
            localObject1 = (ChatMessage)((Iterator)localObject2).next();
            this.app.b().d(acbn.bkJ, 0, ((ChatMessage)localObject1).uniseq, false);
            ((Iterator)localObject2).remove();
          }
        }
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ChatMessage)((Iterator)localObject2).next();
          if (((ChatMessage)localObject3).time >= l2)
          {
            this.app.b().d(acbn.bkJ, 0, ((ChatMessage)localObject3).uniseq, false);
            ((Iterator)localObject2).remove();
          }
          else if ((localObject3 instanceof MessageForSystemMsg))
          {
            Object localObject4 = (MessageForSystemMsg)localObject3;
            if (((MessageForSystemMsg)localObject4).structMsg == null) {
              ((MessageForSystemMsg)localObject4).parse();
            }
            str = ((MessageForSystemMsg)localObject4).senderuin;
            i = ((MessageForSystemMsg)localObject4).structMsg.msg.sub_type.get();
            if ((i == 13) && (((acff)localObject1).isFriend(str)))
            {
              this.app.b().d(acbn.bkJ, 0, ((ChatMessage)localObject3).uniseq, false);
              ((Iterator)localObject2).remove();
            }
            else if ((i == 1) || (i == 13))
            {
              localObject4 = paramRspSystemMsgNew.iterator();
              while (((Iterator)localObject4).hasNext())
              {
                Object localObject5 = (MessageRecord)((Iterator)localObject4).next();
                if ((localObject5 instanceof MessageForSystemMsg))
                {
                  j = ((MessageForSystemMsg)localObject5).structMsg.msg.sub_type.get();
                  localObject5 = ((MessageRecord)localObject5).senderuin;
                  if ((j == i) && (localObject5 != null) && (((String)localObject5).equals(str)))
                  {
                    this.app.b().d(acbn.bkJ, 0, ((ChatMessage)localObject3).uniseq, false);
                    ((Iterator)localObject2).remove();
                  }
                }
              }
            }
          }
        }
        if (paramFromServiceMsg.size() == 0)
        {
          anzd.a().t(this.app, l2);
          paramFromServiceMsg = this.app.b();
          paramToServiceMsg = String.valueOf(paramToServiceMsg);
          if ((!achp.F(paramRspSystemMsgNew)) || (!this.app.isBackground_Stop)) {
            break label1909;
          }
          bool2 = true;
          paramFromServiceMsg.c(paramRspSystemMsgNew, paramToServiceMsg, bool2);
          localysf.AI(true);
          jr(paramRspSystemMsgNew);
          a("handleGetSystemMsgResp", true, k, bool1, false);
          localysf.b(new ytq(paramObject, l1));
        }
      }
    }
    for (;;)
    {
      label1826:
      b(4005, true, null);
      return;
      if (paramRspSystemMsgNew.size() >= 20) {
        break;
      }
      anzd.a().c(true, this.app);
      break;
      label1909:
      bool2 = false;
      break label1826;
      localysf.AI(true);
      break label1860;
      if (QLog.isColorLevel()) {
        QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : clear local data. sentSeq:" + l2 + " respSeq:" + l3);
      }
      this.app.b().N(acbn.bkJ, 0);
      localysf.cln();
    }
  }
  
  private void aF(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("latestFriendSeq");
    long l2 = paramToServiceMsg.extraData.getLong("latestGroupSeq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l4 = paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    int i = paramToServiceMsg.extraData.getInt("type");
    this.a.ae(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = this.a.a(l3);
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label130;
      }
      paramFromServiceMsg = this.a;
      paramToServiceMsg.getClass();
      if (!paramFromServiceMsg.a(paramToServiceMsg, "msf")) {
        break label130;
      }
    }
    label130:
    while ((480000L != l4) && (!paramToServiceMsg.aFa())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgReadedReportError type=" + i + ";reqSeq=" + l3 + ";latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
    }
    this.a.hB(l3);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SystemMessageProcessor", 4, "processGroupSystemMsg");
    }
    ajdr localajdr = (ajdr)this.app.getManager(37);
    int m = paramToServiceMsg.extraData.getInt("getSystemMsgSender");
    bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->requestFrom:" + m);
    }
    String str1;
    if (paramFromServiceMsg.getUin() == null)
    {
      str1 = this.app.getAccount();
      localObject2 = null;
      if (paramRspSystemMsgNew == null) {
        break label167;
      }
      label100:
      paramObject = new StringBuilder();
      if ((paramRspSystemMsgNew != null) && (paramRspSystemMsgNew.head.result.get() == 0)) {
        break label223;
      }
      paramObject.setLength(0);
      if (QLog.isColorLevel()) {
        QLog.e("SystemMessageProcessor", 2, paramObject.toString());
      }
      this.a.n(paramToServiceMsg, paramFromServiceMsg);
    }
    label167:
    label223:
    do
    {
      for (;;)
      {
        return;
        str1 = paramFromServiceMsg.getUin();
        break;
        try
        {
          for (;;)
          {
            paramRspSystemMsgNew = new structmsg.RspSystemMsgNew();
            try
            {
              paramRspSystemMsgNew.mergeFrom((byte[])paramObject);
            }
            catch (Exception localException1)
            {
              paramObject = paramRspSystemMsgNew;
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int i;
            Object localObject1;
            int k;
            int n;
            int i1;
            Object localObject3;
            int i2;
            int i3;
            boolean bool3;
            boolean bool2;
            String str2;
            Object localObject4;
            Object localObject5;
            paramObject = localObject2;
            continue;
            long l2 = -1L;
            continue;
            long l1 = -1L;
            continue;
            int j = -1;
            continue;
            paramToServiceMsg = paramFromServiceMsg;
            continue;
            paramToServiceMsg = null;
            continue;
            bool1 = true;
            continue;
            bool1 = true;
            continue;
          }
        }
      }
      paramRspSystemMsgNew = paramObject;
      if (!QLog.isColorLevel()) {
        break label100;
      }
      QLog.e("SystemMessageProcessor", 2, "<---handleGetGroupSystemMsgResp : decode pb error:", localException1);
      paramRspSystemMsgNew = paramObject;
      break label100;
      paramObject = paramRspSystemMsgNew.groupmsgs.get();
      j = paramObject.size();
      i = paramRspSystemMsgNew.unread_group_count.get();
      paramFromServiceMsg = (TroopManager)this.app.getManager(52);
      j -= 1;
      if (j >= 0)
      {
        localObject1 = (structmsg.StructMsg)paramObject.get(j);
        if ((localObject1 == null) || (!((structmsg.StructMsg)localObject1).msg.has()) || (!((structmsg.SystemMsg)((structmsg.StructMsg)localObject1).msg.get()).uint32_c2c_invite_join_group_flag.has()) || (((structmsg.SystemMsg)((structmsg.StructMsg)localObject1).msg.get()).uint32_c2c_invite_join_group_flag.get() <= 0)) {
          break label4221;
        }
        k = ((structmsg.SystemMsg)((structmsg.StructMsg)localObject1).msg.get()).group_msg_type.get();
        n = ((structmsg.SystemMsg)((structmsg.StructMsg)localObject1).msg.get()).sub_type.get();
        i1 = ((structmsg.StructMsg)localObject1).uint32_unread_flag.get();
        l1 = ((structmsg.StructMsg)localObject1).msg.group_code.get();
        l2 = ((structmsg.StructMsg)localObject1).msg_time.get();
        if (QLog.isColorLevel()) {
          QLog.i("SystemMessageProcessor", 2, "uint32_c2c_invite_join_group_flag not 0 groupMsgType:" + k + " subType:" + n + "  unread_flag:" + i1 + "  unreadCount:" + i + " troopCode:" + l1 + "  msgTime:" + l2);
        }
        if ((i1 == 0) && (j >= i)) {
          break label4218;
        }
        i -= 1;
        if ((k == 2) && (n == 2))
        {
          localObject1 = String.format("%s_%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
          if ((paramFromServiceMsg == null) || (paramFromServiceMsg.kE((String)localObject1))) {}
        }
        for (;;)
        {
          j -= 1;
          break;
          paramObject.remove(j);
        }
      }
      n = paramObject.size();
      i1 = Math.max(i, 0);
      i = anze.a().af(this.app);
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "<---handleGetGroupSystemMsgResp : decode pb groupMsgsSize = " + n + " latest_friend_seq" + paramRspSystemMsgNew.latest_friend_seq.get() + " latest_group_seq" + paramRspSystemMsgNew.latest_group_seq.get() + " following_friend_seq" + paramRspSystemMsgNew.following_friend_seq.get() + " following_group_seq" + paramRspSystemMsgNew.following_group_seq.get() + " uint32_has_suspicious_flag = " + paramRspSystemMsgNew.uint32_has_suspicious_flag.get() + " unreadCount" + i1 + " localUnreadCount" + i + " requestFrom = " + m);
      }
      if (m == 3)
      {
        yym.a(this, this.app, paramRspSystemMsgNew, paramObject, i1, str1);
        return;
      }
      yym.a(paramRspSystemMsgNew, this.app);
    } while (n == 0);
    this.czo = 0;
    this.app.a().aN("last_group_seq", paramRspSystemMsgNew.latest_group_seq.get());
    anze.a().N(this.app, i1);
    this.app.a().G(acbn.bkT, 9000, i1 - i);
    paramFromServiceMsg = new ArrayList();
    i = 0;
    if (paramToServiceMsg.getServiceCmd().equals("ProfileService.Pb.ReqSystemMsgNew"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "CMD_GET_SYSTEM_MSG_BOTH");
      }
      j = 1;
      this.app.b().a(acbn.bkK, 0, true, true);
      this.app.b().a(acbn.bkP, 0, true, true);
      this.app.a().aN("following_group_seq", paramRspSystemMsgNew.following_group_seq.get());
      yxz.cmT();
      anze.a().c(false, this.app);
      i = j;
      if (localajdr != null)
      {
        localajdr.LQ(false);
        i = j;
      }
    }
    Collections.sort(paramObject, new acrq(this));
    j = 0;
    if (j < n)
    {
      localObject1 = anbi.d(-2018);
      ((MessageRecord)localObject1).msgtype = -2018;
      ((MessageRecord)localObject1).selfuin = str1;
      ((MessageRecord)localObject1).frienduin = acbn.bkK;
      localObject3 = (structmsg.StructMsg)paramObject.get(j);
      k = ((structmsg.StructMsg)localObject3).msg.group_msg_type.get();
      i2 = apuh.jO(k);
      if (i2 == 1) {
        ((MessageRecord)localObject1).senderuin = (((structmsg.StructMsg)localObject3).msg.action_uin.get() + "");
      }
      for (;;)
      {
        ((MessageRecord)localObject1).istroop = 0;
        localObject2 = (MessageForSystemMsg)localObject1;
        ((MessageForSystemMsg)localObject2).structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)localObject3).get());
        ((MessageForSystemMsg)localObject2).shmsgseq = ((MessageForSystemMsg)localObject2).structMsg.msg_seq.get();
        i2 = ((MessageForSystemMsg)localObject2).structMsg.msg_type.get();
        i3 = ((MessageForSystemMsg)localObject2).structMsg.msg.sub_type.get();
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("requestFrom:").append(m);
          paramToServiceMsg.append(" isLatestPushMsgProcessed:").append(bool1);
          paramToServiceMsg.append(" type:").append(i2);
          paramToServiceMsg.append(" groupMsgType:").append(k);
          paramToServiceMsg.append(" subType:").append(i3);
          paramToServiceMsg.append(" troopUin:").append(((structmsg.StructMsg)localObject3).msg.group_code.get());
          paramToServiceMsg.append(" msgTime:").append(((structmsg.StructMsg)localObject3).msg_time.get());
          QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->" + paramToServiceMsg.toString());
        }
        if ((i2 != 1) || (anzf.lL(i3))) {
          break label1412;
        }
        bool3 = bool1;
        j += 1;
        bool1 = bool3;
        break;
        if (i2 == 2) {
          ((MessageRecord)localObject1).senderuin = (((structmsg.StructMsg)localObject3).req_uin.get() + "");
        }
      }
      label1412:
      if (i3 == 1) {
        ((MessageRecord)localObject1).senderuin = (((structmsg.StructMsg)localObject3).msg.action_uin.get() + "");
      }
      bool3 = true;
      bool2 = true;
      if ((m == 1) && (!bool1)) {
        if ((k == 2) && (i3 == 2))
        {
          str2 = String.valueOf(((structmsg.StructMsg)localObject3).msg.group_code.get());
          localObject4 = (TroopManager)this.app.getManager(52);
          if (((TroopManager)localObject4).b(str2) == null)
          {
            paramToServiceMsg = new TroopInfo();
            paramToServiceMsg.troopuin = str2;
            ((TroopManager)localObject4).h(paramToServiceMsg);
            if (QLog.isColorLevel()) {
              QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg--> add troop : " + str2);
            }
            localObject5 = (acms)this.app.getBusinessHandler(20);
            ((acms)localObject5).a(paramToServiceMsg.troopuin, false, "", true, true, true, false);
            ((acms)localObject5).a(1, accc.Z(paramToServiceMsg.troopuin), 0L, 2, 0, 0, true);
            ((acms)localObject5).notifyUI(127, true, new Object[] { str2 });
          }
          if (((MessageForSystemMsg)localObject2).structMsg.msg.msg_invite_extinfo.has())
          {
            paramToServiceMsg = (structmsg.MsgInviteExt)((MessageForSystemMsg)localObject2).structMsg.msg.msg_invite_extinfo.get();
            label1676:
            if (paramToServiceMsg == null) {
              break label1933;
            }
            k = paramToServiceMsg.uint32_wait_state.get();
            label1689:
            if ((k == 2) || (k == 4))
            {
              localObject5 = (TroopManager)this.app.getManager(52);
              ((TroopManager)localObject5).l(((TroopManager)localObject5).b(str2));
              ahwb.a(this.app, (MessageForSystemMsg)localObject2, paramToServiceMsg, str2);
              if (QLog.isColorLevel()) {
                QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->msgPos:" + j + ":addFriendTipsMr");
              }
            }
            if (k != 4) {
              break label1939;
            }
            bool1 = false;
            label1787:
            paramToServiceMsg = (acms)this.app.getBusinessHandler(20);
            if (paramToServiceMsg != null) {
              paramToServiceMsg.d(str2, Boolean.valueOf(false));
            }
            ((TroopManager)localObject4).FD(String.format("%s_%s", new Object[] { str2, Long.valueOf(((structmsg.StructMsg)localObject3).msg_time.get()) }));
            bool3 = true;
            bool2 = bool1;
            bool1 = bool3;
          }
        }
      }
      for (;;)
      {
        ((MessageRecord)localObject1).msgData = ((MessageForSystemMsg)localObject2).structMsg.toByteArray();
        if (bool2) {
          paramFromServiceMsg.add(localObject2);
        }
        bool3 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->isAdd2Loacal:" + bool2);
        bool3 = bool1;
        break;
        paramToServiceMsg = null;
        break label1676;
        label1933:
        k = -1;
        break label1689;
        label1939:
        if (((structmsg.StructMsg)localObject3).msg.uint32_c2c_invite_join_group_flag.get() == 0) {
          break label4212;
        }
        bool1 = false;
        break label1787;
        if (k == 3)
        {
          paramToServiceMsg = (TroopManager)this.app.getManager(52);
          localObject3 = paramToServiceMsg.b(((structmsg.StructMsg)localObject3).msg.group_code.get() + "");
          if (localObject3 != null)
          {
            ((TroopInfo)localObject3).dwCmdUinUinFlag = 1L;
            if (((TroopInfo)localObject3).Administrator == null) {
              break label2197;
            }
            if (((TroopInfo)localObject3).Administrator.startsWith("|")) {
              ((TroopInfo)localObject3).Administrator = ((TroopInfo)localObject3).Administrator.substring(1);
            }
            if (!((TroopInfo)localObject3).Administrator.endsWith("|")) {}
          }
          label2197:
          for (((TroopInfo)localObject3).Administrator = ((TroopInfo)localObject3).Administrator.substring(0, ((TroopInfo)localObject3).Administrator.length() - 1);; ((TroopInfo)localObject3).Administrator = "")
          {
            if (!((TroopInfo)localObject3).Administrator.contains(this.app.getCurrentAccountUin())) {
              ((TroopInfo)localObject3).Administrator = (((TroopInfo)localObject3).Administrator + "|" + this.app.getCurrentAccountUin());
            }
            paramToServiceMsg.i((TroopInfo)localObject3);
            paramToServiceMsg = (acms)this.app.getBusinessHandler(20);
            if (paramToServiceMsg != null) {
              paramToServiceMsg.hT(Long.parseLong(((TroopInfo)localObject3).troopuin));
            }
            bool1 = true;
            break;
          }
        }
        if (k == 19)
        {
          paramToServiceMsg = (TroopManager)this.app.getManager(52);
          localObject3 = paramToServiceMsg.b(((structmsg.StructMsg)localObject3).msg.group_code.get() + "");
          if (localObject3 != null)
          {
            ((TroopInfo)localObject3).dwCmdUinUinFlag = 1L;
            paramToServiceMsg.i((TroopInfo)localObject3);
          }
          bool1 = true;
        }
        else if (k == 17)
        {
          paramToServiceMsg = (TroopManager)this.app.getManager(52);
          localObject3 = paramToServiceMsg.b(((structmsg.StructMsg)localObject3).msg.group_code.get() + "");
          if (localObject3 != null)
          {
            ((TroopInfo)localObject3).dwCmdUinUinFlag = 0L;
            paramToServiceMsg.i((TroopInfo)localObject3);
          }
          bool1 = true;
        }
        else
        {
          if (k == 15)
          {
            paramToServiceMsg = (TroopManager)this.app.getManager(52);
            localObject3 = paramToServiceMsg.b(((structmsg.StructMsg)localObject3).msg.group_code.get() + "");
            if (localObject3 != null)
            {
              ((TroopInfo)localObject3).dwCmdUinUinFlag = 0L;
              if (((TroopInfo)localObject3).Administrator == null) {
                break label2606;
              }
              if (((TroopInfo)localObject3).Administrator.startsWith("|")) {
                ((TroopInfo)localObject3).Administrator = ((TroopInfo)localObject3).Administrator.substring(1);
              }
              if (!((TroopInfo)localObject3).Administrator.endsWith("|")) {}
            }
            label2606:
            for (((TroopInfo)localObject3).Administrator = ((TroopInfo)localObject3).Administrator.substring(0, ((TroopInfo)localObject3).Administrator.length() - 1);; ((TroopInfo)localObject3).Administrator = "")
            {
              ((TroopInfo)localObject3).Administrator = ((TroopInfo)localObject3).Administrator.replace(this.app.getCurrentAccountUin() + "|", "").replace("|" + this.app.getCurrentAccountUin(), "").replace(this.app.getCurrentAccountUin(), "");
              paramToServiceMsg.i((TroopInfo)localObject3);
              bool1 = true;
              break;
            }
          }
          if ((k == 13) || (k == 6))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->msgPos:" + j + ",msgTime:" + ((structmsg.StructMsg)localObject3).msg_time + ",msgType:" + k + ":delete troopMember, delete troop, clear local history");
            }
            paramToServiceMsg = (TroopManager)this.app.getManager(52);
            if (paramToServiceMsg != null)
            {
              paramToServiceMsg.aC(((structmsg.StructMsg)localObject3).msg.group_code.get() + "", ((structmsg.StructMsg)localObject3).req_uin.get() + "");
              paramToServiceMsg.af(((structmsg.StructMsg)localObject3).msg.group_code.get(), ((structmsg.StructMsg)localObject3).msg_time.get());
            }
            bool1 = true;
          }
          else
          {
            if ((k != 8) && (k != 7)) {
              break label4206;
            }
            l1 = ((structmsg.StructMsg)localObject3).msg.group_code.get();
            if (QLog.isColorLevel()) {
              QLog.d("SystemMessageProcessor", 2, String.format("handlePassiveExit online troopUin: %s, msgType: %s, i: %s, unreadCount: %s", new Object[] { String.valueOf(l1), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i1) }));
            }
            paramToServiceMsg = (TroopManager)this.app.getManager(52);
            if (paramToServiceMsg != null) {
              paramToServiceMsg.b((structmsg.StructMsg)localObject3);
            }
            bool1 = true;
            continue;
            if ((k == 2) && (i3 == 2))
            {
              l1 = ((structmsg.StructMsg)localObject3).msg.group_code.get();
              if (((MessageForSystemMsg)localObject2).structMsg.msg.msg_invite_extinfo.has())
              {
                paramToServiceMsg = (structmsg.MsgInviteExt)((MessageForSystemMsg)localObject2).structMsg.msg.msg_invite_extinfo.get();
                label2973:
                if (paramToServiceMsg == null) {
                  break label3034;
                }
              }
              label3034:
              for (k = paramToServiceMsg.uint32_wait_state.get();; k = -1)
              {
                if ((k == 2) || (k == 4)) {
                  ahwb.a(this.app, (MessageForSystemMsg)localObject2, paramToServiceMsg, String.valueOf(l1));
                }
                bool2 = bool3;
                if (k == 4) {
                  bool2 = false;
                }
                break;
                paramToServiceMsg = null;
                break label2973;
              }
            }
            if ((k == 8) || (k == 7))
            {
              l1 = ((structmsg.StructMsg)localObject3).msg.group_code.get();
              if (QLog.isColorLevel()) {
                QLog.d("SystemMessageProcessor", 2, String.format("handlePassiveExit offline troopUin: %s, msgType: %s, i: %s, unreadCount: %s", new Object[] { String.valueOf(l1), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i1) }));
              }
              if (j < i1)
              {
                paramToServiceMsg = (TroopManager)this.app.getManager(52);
                if (paramToServiceMsg != null) {
                  paramToServiceMsg.b((structmsg.StructMsg)localObject3);
                }
              }
            }
            else if ((k == 13) || (k == 6))
            {
              paramToServiceMsg = (TroopManager)this.app.getManager(52);
              if ((paramToServiceMsg != null) && (!paramToServiceMsg.v(((structmsg.StructMsg)localObject3).msg.group_code.get(), ((structmsg.StructMsg)localObject3).msg_time.get())))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->msgPos:" + j + ",msgTime:" + ((structmsg.StructMsg)localObject3).msg_time + ",msgType:" + k + ":delete troopMember, delete troop, clear local history");
                }
                str2 = ((structmsg.StructMsg)localObject3).msg.group_code.get() + "";
                localObject4 = ((structmsg.StructMsg)localObject3).req_uin.get() + "";
                localObject5 = (acms)this.app.getBusinessHandler(20);
                if (localObject5 != null) {
                  ((acms)localObject5).E(str2, (String)localObject4, true);
                }
                paramToServiceMsg.af(((structmsg.StructMsg)localObject3).msg.group_code.get(), ((structmsg.StructMsg)localObject3).msg_time.get());
              }
            }
          }
        }
      }
    }
    localObject1 = (ackm)this.app.getManager(33);
    localObject2 = paramFromServiceMsg.iterator();
    do
    {
      do
      {
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramToServiceMsg = (MessageRecord)((Iterator)localObject2).next();
        } while (!(paramToServiceMsg instanceof MessageForSystemMsg));
        paramToServiceMsg = ((MessageForSystemMsg)paramToServiceMsg).getSystemMsg();
      } while ((paramToServiceMsg == null) || (!paramToServiceMsg.msg.has()) || (!paramToServiceMsg.msg.group_msg_type.has()));
      j = paramToServiceMsg.msg.group_msg_type.get();
    } while ((j == 13) || (j == 6));
    if (paramToServiceMsg != null)
    {
      anze.a().c(paramToServiceMsg);
      l1 = paramToServiceMsg.msg_time.get();
      if ((i1 != 0) || (i != 0)) {
        ((ackm)localObject1).a(acbn.bkT, 9000, acfp.m(2131692100), l1, l1);
      }
    }
    paramToServiceMsg = yxz.df();
    if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
    {
      paramToServiceMsg = g(paramToServiceMsg, paramFromServiceMsg);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
      {
        paramToServiceMsg = w(paramToServiceMsg);
        if (paramToServiceMsg.size() > 0)
        {
          this.app.b().a(acbn.bkK, 0, true, true);
          this.app.b().a(acbn.bkP, 0, true, true);
          paramFromServiceMsg = this.app.b();
          localObject1 = String.valueOf(str1);
          if ((!achp.F(paramToServiceMsg)) || (!this.app.isBackground_Stop)) {
            break label4160;
          }
        }
        label4160:
        for (bool1 = true;; bool1 = false)
        {
          paramFromServiceMsg.c(paramToServiceMsg, (String)localObject1, bool1);
          a("handleGetSystemMsgResp", true, i1, false, false);
          if (!TextUtils.isEmpty(paramRspSystemMsgNew.grp_msg_display.get())) {
            anze.a().aM(this.app, paramRspSystemMsgNew.grp_msg_display.get());
          }
          if ((paramRspSystemMsgNew.msg_ribbon_group.has()) && (paramRspSystemMsgNew.msg_ribbon_group.get() != null))
          {
            paramRspSystemMsgNew = (structmsg.StructMsg)paramRspSystemMsgNew.msg_ribbon_group.get();
            paramFromServiceMsg = anbi.d(-2018);
            paramFromServiceMsg.selfuin = str1;
            paramFromServiceMsg.frienduin = acbn.bkP;
            paramFromServiceMsg.senderuin = (paramRspSystemMsgNew.req_uin.get() + "");
            paramFromServiceMsg.istroop = 0;
            localObject1 = (MessageForSystemMsg)paramFromServiceMsg;
            ((MessageForSystemMsg)localObject1).structMsg = paramRspSystemMsgNew;
            paramFromServiceMsg.msgData = ((MessageForSystemMsg)localObject1).structMsg.toByteArray();
            paramRspSystemMsgNew = new ArrayList();
            paramRspSystemMsgNew.add(paramFromServiceMsg);
            this.app.b().c(paramRspSystemMsgNew, String.valueOf(str1), true);
            if (QLog.isColorLevel()) {
              QLog.d("Q.systemmsg.", 2, "ribbon info");
            }
          }
          paramFromServiceMsg = this.app.getHandler(Conversation.class);
          if ((paramFromServiceMsg != null) && ((i1 > 0) || (i != 0))) {
            paramFromServiceMsg.sendMessage(paramFromServiceMsg.obtainMessage(1009));
          }
          paramFromServiceMsg = (structmsg.StructMsg)paramObject.get(0);
          if (paramFromServiceMsg.msg.has())
          {
            if (!((structmsg.SystemMsg)paramFromServiceMsg.msg.get()).group_msg_type.has()) {
              break label4190;
            }
            j = ((structmsg.SystemMsg)paramFromServiceMsg.msg.get()).group_msg_type.get();
            if (!((structmsg.SystemMsg)paramFromServiceMsg.msg.get()).group_code.has()) {
              break label4182;
            }
            l1 = ((structmsg.SystemMsg)paramFromServiceMsg.msg.get()).group_code.get();
            if (!paramFromServiceMsg.req_uin.has()) {
              break label4174;
            }
            l2 = paramFromServiceMsg.req_uin.get();
            if ((j != -1) && (l2 != -1L) && (l1 != -1L)) {
              h(j, l1, l2);
            }
          }
          b(4005, true, paramToServiceMsg);
          new ArrayList();
          this.app.b().b(acbn.bkK, 0, null);
          paramToServiceMsg = (aein)aeif.a().o(634);
          if ((localajdr.aqu()) || (i == 0) || (!paramToServiceMsg.bUc)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SystemMessageProcessor", 2, "Begin Auto Get Next");
          }
          Ki(0);
          return;
        }
      }
    }
  }
  
  private void cOj()
  {
    try
    {
      if (this.tV == null) {
        this.tV = new ArrayList(20);
      }
      return;
    }
    finally {}
  }
  
  public static long d(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (MessageRecord)paramList.get(0);
      if ((paramList instanceof MessageForSystemMsg))
      {
        paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
        if ((paramList != null) && (paramList.msg_seq.has()))
        {
          long l = paramList.msg_seq.get();
          if (l > 0L) {
            return l;
          }
        }
      }
    }
    return 0L;
  }
  
  public static List<MessageRecord> g(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return paramList1;
    }
    if (d(paramList1) >= d(paramList2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, new Object[] { "getNotiData", "insertAddedMessageToOri pull" });
      }
      paramList1.addAll(paramList2);
      return paramList1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, new Object[] { "getNotiData", "insertAddedMessageToOri push" });
    }
    paramList2.addAll(paramList1);
    return paramList2;
  }
  
  private void h(int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SystemMessageProcessor", 1, "sendGroupSystemMsgToVideo, msgType[" + paramInt + "], troopUin[" + paramLong1 + "], userUin[" + paramLong2 + "]");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.q2v.GroupSystemMsg");
    localIntent.putExtra("type", paramInt);
    localIntent.putExtra("relationType", 1);
    localIntent.putExtra("relationId", paramLong1);
    localIntent.putExtra("userUin", paramLong2);
    if ((paramInt == 3) || (paramInt == 15)) {
      localIntent.putExtra("needSendCmd", true);
    }
    this.app.getApp().sendBroadcast(localIntent);
    if ((paramInt == 7) || (paramInt == 8)) {
      this.app.a().cl(paramLong1);
    }
  }
  
  private void ir(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getUin() == null) {
      this.app.getAccount();
    }
    Object localObject2;
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = new structmsg.RspSystemMsgNew();
      }
      catch (Exception localException1)
      {
        localObject1 = null;
      }
      try
      {
        ((structmsg.RspSystemMsgNew)localObject1).mergeFrom((byte[])paramObject);
        localObject2 = localObject1;
        localObject1 = new StringBuilder();
        if ((localObject2 != null) && (localObject2.head.result.get() == 0)) {
          break;
        }
        ((StringBuilder)localObject1).append("processSystemMsg error " + localObject2.head.result.get());
        if (QLog.isColorLevel()) {
          QLog.e("SystemMessageProcessor", 2, ((StringBuilder)localObject1).toString());
        }
        this.a.n(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      catch (Exception localException2)
      {
        break label145;
      }
      paramFromServiceMsg.getUin();
      continue;
      label145:
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.e("SystemMessageProcessor", 2, "<---handleGetSystemMsgRespNew : decode pb error:", localException1);
        localObject2 = localObject1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("SystemMessageProcessor", 2, "SystemMessageProcessor: listsize");
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject, localObject2);
    b(paramToServiceMsg, paramFromServiceMsg, paramObject, localObject2);
  }
  
  private void is(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("latestFriendSeq");
    long l2 = paramToServiceMsg.extraData.getLong("latestGroupSeq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    int i = paramToServiceMsg.extraData.getInt("type");
    this.a.ae(paramToServiceMsg, paramFromServiceMsg);
    if (this.a.a(l3) == null) {}
    for (;;)
    {
      return;
      if (paramObject == null) {
        continue;
      }
      paramToServiceMsg = new structmsg.RspSystemMsgRead();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg == null) {
          continue;
        }
        int j = paramToServiceMsg.head.result.get();
        if (j == 0) {
          this.a.hB(l3);
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgReadedReport type =" + i + ";reqSeq=" + l3 + ";resultCode=" + j + ";latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SystemMessageProcessor", 2, "<---handleSendSystemMsgReadedReport :type = " + i + " decode pb:", paramFromServiceMsg);
          }
        }
      }
    }
  }
  
  private void it(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getUin() == null) {
      this.app.getAccount();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new structmsg.RspSystemMsgAction();
      }
      catch (Exception paramObject)
      {
        int i;
        paramFromServiceMsg = null;
        if (QLog.isColorLevel()) {
          QLog.e("SystemMessageProcessor", 2, "<---handleSendSystemMsgAction : decode pb:", paramObject);
        }
        continue;
        String str = paramFromServiceMsg.head.msg_fail.get();
        paramObject = str;
        if (str == null) {
          paramObject = "";
        }
        paramToServiceMsg.extraData.putString("system_msg_action_resp_error_key", paramObject);
        bool = false;
        continue;
      }
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          break label302;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgAction result id=" + paramFromServiceMsg.head.result.get());
        }
        if (paramFromServiceMsg.head.result.get() != 0) {
          continue;
        }
        bool = true;
        str = paramFromServiceMsg.msg_detail.get();
        paramObject = str;
        if (str == null) {
          paramObject = "";
        }
        i = -1;
        if (paramFromServiceMsg.remark_result.has()) {
          i = paramFromServiceMsg.remark_result.get();
        }
        paramToServiceMsg.extraData.putString("system_msg_action_resp_key", paramObject);
        paramToServiceMsg.extraData.putInt("system_msg_action_resp_result_code_key", paramFromServiceMsg.head.result.get());
        paramToServiceMsg.extraData.putInt("system_msg_action_resp_type_key", paramFromServiceMsg.type.get());
        paramToServiceMsg.extraData.putString("system_msg_action_resp_invalid_decided_key", paramFromServiceMsg.msg_invalid_decided.get());
        paramToServiceMsg.extraData.putInt("system_msg_action_resp_remark_result_key", i);
      }
      catch (Exception paramObject)
      {
        continue;
        bool = false;
        continue;
      }
      b(4011, bool, paramToServiceMsg);
      return;
      paramFromServiceMsg.getUin();
    }
  }
  
  private void jr(List<MessageRecord> paramList)
  {
    acxw localacxw = this.app.a().a();
    RecentUser localRecentUser = localacxw.a(acbn.bkA, 4000);
    localRecentUser.msgType = 26;
    localRecentUser.displayName = ysf.aZI;
    Object localObject = (MessageForSystemMsg)paramList.get(0);
    ((MessageForSystemMsg)localObject).parse();
    if (!TextUtils.isEmpty(((MessageForSystemMsg)localObject).extStr)) {}
    for (String str = ((MessageForSystemMsg)localObject).extStr;; str = ((MessageForSystemMsg)localObject).structMsg.msg.req_uin_nick.get() + " " + ((MessageForSystemMsg)localObject).structMsg.msg.msg_describe.get())
    {
      localRecentUser.lastmsgtime = ((MessageForSystemMsg)localObject).time;
      localRecentUser.msgData = str.getBytes();
      localRecentUser.msg = str;
      localRecentUser.reParse();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("mDataList.size() ").append(paramList.size()).append(" | msg = ");
        paramList = str;
        if (TextUtils.isEmpty(str)) {
          paramList = "";
        }
        QLog.d("SystemMessageProcessor", 2, paramList);
      }
      localacxw.e(localRecentUser);
      return;
    }
  }
  
  private String rS()
  {
    Object localObject = this.app.b().k(acbn.bkJ, 0);
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "mLocalDataList is null !");
      }
    }
    while ((localObject == null) || (((List)localObject).size() <= 0)) {
      return "";
    }
    localObject = (MessageForSystemMsg)((List)localObject).get(((List)localObject).size() - 1);
    ((MessageForSystemMsg)localObject).parse();
    return ((MessageForSystemMsg)localObject).structMsg.msg.req_uin_nick.get() + " " + ((MessageForSystemMsg)localObject).structMsg.msg.msg_describe.get();
  }
  
  public void FN(boolean paramBoolean)
  {
    int i = amzo.seq;
    amzo.seq = i + 1;
    long l2 = i;
    System.currentTimeMillis();
    long l3 = this.app.a().aD("last_friend_seq_47");
    if (paramBoolean) {}
    for (long l1 = this.app.a().aD("last_group_suspicious_seq");; l1 = this.app.a().aD("last_group_seq"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendGroupSystemMsgReadedReport reqSeq=" + l2 + ";latestFriendSeq=" + l3 + ";latestGroupSeq=" + l1 + ", isSuspicoius=" + paramBoolean);
      }
      structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
      localReqSystemMsgRead.latest_group_seq.set(l1);
      localReqSystemMsgRead.checktype.set(3);
      if (paramBoolean) {
        localReqSystemMsgRead.uint32_req_msg_type.set(2);
      }
      ProtoReqManager.c localc = new ProtoReqManager.c();
      localc.clW = "ProfileService.Pb.ReqSystemMsgRead.Group";
      localc.fW = localReqSystemMsgRead.toByteArray();
      localc.a = new acrw(this, l2, l3, l1);
      this.app.getProtoReqManager().b(localc);
      return;
    }
  }
  
  public void Kg(int paramInt)
  {
    y(paramInt, 0, false);
  }
  
  public void Kh(int paramInt)
  {
    y(paramInt, 2, true);
  }
  
  public void Ki(int paramInt)
  {
    this.a.createToServiceMsg("ProfileService.Pb.ReqNextSystemMsg.Group");
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsgfollowing_group_seq = " + this.app.a().aD("following_group_seq") + "following_group_seq = " + this.app.a().aD("following_group_suspicious_seq") + " requestFrom =" + paramInt);
    }
    structmsg.ReqNextSystemMsg localReqNextSystemMsg = new structmsg.ReqNextSystemMsg();
    localReqNextSystemMsg.msg_num.set(100);
    if (paramInt == 3)
    {
      localReqNextSystemMsg.following_group_seq.set(this.app.a().aD("following_group_suspicious_seq"));
      localReqNextSystemMsg.uint32_req_msg_type.set(2);
    }
    for (;;)
    {
      localReqNextSystemMsg.checktype.set(3);
      localReqNextSystemMsg.version.set(1000);
      Object localObject = new structmsg.FlagInfo();
      ((structmsg.FlagInfo)localObject).GrpMsg_Kick_Admin.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_WordingDown.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_GetOfficialAccount.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_GetPayInGroup.set(1);
      ((structmsg.FlagInfo)localObject).FrdMsg_Discuss2ManyChat.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_NotAllowJoinGrp_InviteNotFrd.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_NeedAutoAdminWording.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_get_transfer_group_msg_flag.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_get_quit_pay_group_msg_flag.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_support_invite_auto_join.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_mask_invite_auto_join.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_GetDisbandedByAdmin.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_GetC2cInviteJoinGroup.set(1);
      localReqNextSystemMsg.flag.set((MessageMicro)localObject);
      localObject = new ProtoReqManager.c();
      ((ProtoReqManager.c)localObject).dVU();
      ((ProtoReqManager.c)localObject).clW = "ProfileService.Pb.ReqNextSystemMsg.Group";
      ((ProtoReqManager.c)localObject).fW = localReqNextSystemMsg.toByteArray();
      ((ProtoReqManager.c)localObject).fi = new Integer(paramInt);
      ((ProtoReqManager.c)localObject).a = new acrr(this);
      this.app.getProtoReqManager().b((ProtoReqManager.c)localObject);
      return;
      localReqNextSystemMsg.following_group_seq.set(this.app.a().aD("following_group_seq"));
    }
  }
  
  public String a(structmsg.StructMsg paramStructMsg)
  {
    if ((paramStructMsg != null) && (paramStructMsg.msg.has())) {
      return String.valueOf(((structmsg.SystemMsg)paramStructMsg.msg.get()).group_code.get()) + String.valueOf(paramStructMsg.req_uin.get()) + String.valueOf(((structmsg.SystemMsg)paramStructMsg.msg.get()).group_msg_type.get());
    }
    return "";
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6)
  {
    a(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3, paramInt4, paramInt5, paramSystemMsgActionInfo, paramInt6, "");
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6, String paramString)
  {
    long l = paramInt1 + paramLong1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgAction logStr=" + l);
    }
    paramString = new structmsg.ReqSystemMsgAction();
    paramString.msg_type.set(paramInt1);
    paramString.msg_seq.set(paramLong1);
    paramString.req_uin.set(paramLong2);
    paramString.sub_type.set(paramInt2);
    paramString.src_id.set(paramInt3);
    paramString.sub_src_id.set(paramInt4);
    paramString.group_msg_type.set(paramInt5);
    paramString.action_info.set(paramSystemMsgActionInfo);
    paramString.language.set(1000);
    paramSystemMsgActionInfo = new ProtoReqManager.c();
    paramSystemMsgActionInfo.dVU();
    paramSystemMsgActionInfo.clW = "ProfileService.Pb.ReqSystemMsgAction.Group";
    paramSystemMsgActionInfo.fW = paramString.toByteArray();
    paramString = this.a.createToServiceMsg("ProfileService.Pb.ReqSystemMsgAction.Group");
    paramString.addAttribute("_tag_LOGSTR", String.valueOf(l));
    paramString.extraData.putInt("system_msg_action_type", paramInt6);
    paramSystemMsgActionInfo.fi = paramString;
    paramSystemMsgActionInfo.a = new acrs(this);
    this.app.getProtoReqManager().b(paramSystemMsgActionInfo);
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6, structmsg.StructMsg paramStructMsg, boolean paramBoolean)
  {
    long l = paramInt1 + paramLong1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgAction logStr=" + l);
    }
    Object localObject = new structmsg.ReqSystemMsgAction();
    ((structmsg.ReqSystemMsgAction)localObject).msg_type.set(paramInt1);
    ((structmsg.ReqSystemMsgAction)localObject).msg_seq.set(paramLong1);
    ((structmsg.ReqSystemMsgAction)localObject).req_uin.set(paramLong2);
    ((structmsg.ReqSystemMsgAction)localObject).sub_type.set(paramInt2);
    ((structmsg.ReqSystemMsgAction)localObject).src_id.set(paramInt3);
    ((structmsg.ReqSystemMsgAction)localObject).sub_src_id.set(paramInt4);
    ((structmsg.ReqSystemMsgAction)localObject).group_msg_type.set(paramInt5);
    ((structmsg.ReqSystemMsgAction)localObject).action_info.set(paramSystemMsgActionInfo);
    ProtoReqManager.c localc = new ProtoReqManager.c();
    localc.dVU();
    localc.clW = "ProfileService.Pb.ReqSystemMsgAction.Friend";
    localc.fW = ((structmsg.ReqSystemMsgAction)localObject).toByteArray();
    localObject = this.a.createToServiceMsg("ProfileService.Pb.ReqSystemMsgAction.Friend");
    ((ToServiceMsg)localObject).addAttribute("_tag_LOGSTR", String.valueOf(l));
    ((ToServiceMsg)localObject).extraData.putInt("system_msg_action_type", paramInt6);
    ((ToServiceMsg)localObject).extraData.putBoolean("isUncommonlyUsedFrd", paramBoolean);
    localc.fi = localObject;
    localc.a = new acrt(this, paramInt6, paramInt3, paramSystemMsgActionInfo, paramStructMsg, paramLong2);
    this.app.getProtoReqManager().b(localc);
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    case 6004: 
    case 6005: 
    case 6007: 
    default: 
      return;
    case 6002: 
      this.czo = 0;
      return;
    case 6001: 
      this.czp = 0;
      return;
    case 6003: 
      this.czq = 0;
      return;
    case 6006: 
      aF(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 6008: 
      c(4015, false, paramToServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "handleGetDelAllSysMsg Error!");
    }
    c(8039, false, new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) });
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, long paramLong1, long paramLong2, msg_comm.MsgHead paramMsgHead)
  {
    if ((paramInt == 85) || (paramInt == 36))
    {
      ahwb.a(this.app, paramArrayOfByte, paramLong1, paramLong2, paramMsgHead);
      c(2001, true, null);
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, int paramInt3)
  {
    String str = String.valueOf(paramLong2);
    acff localacff = (acff)this.app.getManager(51);
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(1);
    if ((paramInt1 == 188) || (paramInt1 == 189))
    {
      cOj();
      if (!this.tV.contains(Integer.valueOf(paramInt3))) {}
    }
    while (paramInt1 != 190)
    {
      return;
      this.tV.add(Integer.valueOf(paramInt3));
      str = String.valueOf(str);
      if (paramLong1 == paramLong2) {}
      for (boolean bool = true;; bool = false)
      {
        localFriendListHandler.a(str, 0, 3999, null, bool, false, paramLong3);
        return;
      }
    }
    localacff.bF(str, false);
  }
  
  public void a(long paramLong1, long paramLong2, short paramShort, int paramInt1, msg_comm.Msg paramMsg, int paramInt2)
  {
    String str = String.valueOf(paramLong2);
    Object localObject = (acff)this.app.getManager(51);
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(1);
    if ((paramShort == 188) || (paramShort == 189))
    {
      cOj();
      if (!this.tV.contains(Integer.valueOf(paramInt2))) {}
    }
    while (paramShort != 190)
    {
      return;
      this.tV.add(Integer.valueOf(paramInt2));
      localObject = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
      localObject = SystemMsg.decode(this.app, aqhs.bytes2HexStr((byte[])localObject), String.valueOf(str), paramInt1);
      if (localObject != null) {}
      for (localObject = ((SystemMsg)localObject).strGameName;; localObject = "")
      {
        localFriendListHandler.a(String.valueOf(str), 0, 3999, (String)localObject, true, false, paramMsg.msg_head.msg_time.get());
        ysq.a(this.app, paramLong1, paramLong2, paramShort, paramMsg, paramInt2);
        return;
      }
    }
    ((acff)localObject).bF(str, false);
  }
  
  public void a(structmsg.StructMsg paramStructMsg, String paramString, int paramInt, long paramLong)
  {
    Oidb_0x5cf.ReqBody localReqBody = new Oidb_0x5cf.ReqBody();
    Oidb_0x5cf.DelMsgInfo localDelMsgInfo = new Oidb_0x5cf.DelMsgInfo();
    localReqBody.uint32_version.set(1);
    localReqBody.uint32_type.set(9);
    Object localObject = this.app.getAccount();
    localReqBody.uint64_touin.set(Long.parseLong((String)localObject));
    localReqBody.fixed32_sequence.set((int)paramStructMsg.msg_seq.get());
    localDelMsgInfo.uint32_platform.set(2);
    if (paramStructMsg.msg.sub_type.get() < 2)
    {
      localObject = new Oidb_0x5cf.DelUnDecideInfo();
      ((Oidb_0x5cf.DelUnDecideInfo)localObject).uint64_uin.set(paramStructMsg.req_uin.get());
      localDelMsgInfo.rpt_msg_undecide_info.add((MessageMicro)localObject);
    }
    for (;;)
    {
      localReqBody.msg_del_msg_info.set(localDelMsgInfo);
      paramStructMsg = this.app.a().makeOIDBPkg("OidbSvc.0x5cf_0", 1487, 0, localReqBody.toByteArray());
      paramStructMsg.extraData.putString("frienduin", paramString);
      paramStructMsg.extraData.putInt("istroop", paramInt);
      paramStructMsg.extraData.putLong("uniseq", paramLong);
      this.a.sendPbReq(paramStructMsg);
      return;
      localObject = new Oidb_0x5cf.DelDecideInfo();
      ((Oidb_0x5cf.DelDecideInfo)localObject).uint64_uin.set(paramStructMsg.req_uin.get());
      ((Oidb_0x5cf.DelDecideInfo)localObject).uint32_time.set((int)paramStructMsg.msg_time.get());
      ((Oidb_0x5cf.DelDecideInfo)localObject).uint32_req_type.set(paramStructMsg.msg.sub_type.get());
      localDelMsgInfo.rpt_msg_decide_info.add((MessageMicro)localObject);
    }
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    case 6004: 
    case 6005: 
    default: 
      return;
    case 6002: 
      if (this.czo < 2)
      {
        this.czo += 1;
        Kg(4);
        return;
      }
      this.czo = 0;
      return;
    case 6001: 
      if (this.czp < 2)
      {
        this.czp += 1;
        Kg(2);
        return;
      }
      this.czp = 0;
      return;
    case 6003: 
      if (this.czq < 2)
      {
        this.czq += 1;
        Kg(3);
        return;
      }
      this.czq = 0;
      return;
    case 6006: 
      aF(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 6007: 
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "onSendSystemMsgActionError");
      }
      c(4012, false, paramToServiceMsg);
      return;
    case 6008: 
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "handleGetDelSingleSysMsg Error!");
      }
      c(4015, false, paramToServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "handleGetDelAllSysMsg timeout!");
    }
    c(8039, false, new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) });
  }
  
  public void cOb()
  {
    long l1 = this.app.a().aD("last_friend_seq_47");
    long l2 = this.app.a().aD("last_group_seq");
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_friend_seq.set(l1);
    localReqSystemMsgRead.latest_group_seq.set(l2);
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "sendSystemMsgReadedReport latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
    }
    a(true, true, false, 0L, new acru(this, l1, l2, localReqSystemMsgRead));
  }
  
  public void cOc()
  {
    int i = amzo.seq;
    amzo.seq = i + 1;
    long l1 = i;
    System.currentTimeMillis();
    long l2 = this.app.a().aD("last_friend_seq_47");
    long l3 = this.app.a().aD("last_group_seq");
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendSystemMsgReadedReport reqSeq=" + l1 + ";latestFriendSeq=" + l2 + ";latestGroupSeq=" + l3);
    }
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_friend_seq.set(l2);
    localReqSystemMsgRead.checktype.set(2);
    ProtoReqManager.c localc = new ProtoReqManager.c();
    localc.clW = "ProfileService.Pb.ReqSystemMsgRead.Friend";
    localc.fW = localReqSystemMsgRead.toByteArray();
    localc.a = new acrv(this, l1, l2, l3);
    this.app.getProtoReqManager().b(localc);
  }
  
  public void cOd()
  {
    FN(false);
  }
  
  public void cOe()
  {
    long l = this.app.a().aD("last_group_suspicious_seq");
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_group_seq.set(l);
    localReqSystemMsgRead.uint32_req_msg_type.set(2);
    localReqSystemMsgRead.type.set(1);
    localReqSystemMsgRead.checktype.set(3);
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "clearSystemMsg latestGroupSeq=" + l);
    }
    a(true, true, false, 0L, new acrx(this, l, localReqSystemMsgRead));
  }
  
  public void cOf()
  {
    long l1 = this.app.a().aD("last_friend_seq_47");
    long l2 = this.app.a().aD("last_group_seq");
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_group_seq.set(l2);
    localReqSystemMsgRead.type.set(1);
    localReqSystemMsgRead.checktype.set(3);
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "clearSystemMsg latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
    }
    a(true, true, false, 0L, new acry(this, l1, l2, localReqSystemMsgRead));
  }
  
  public void cOg()
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "clearAllSystemMsg");
    }
    Object localObject = new Oidb_0x5cf.ReqBody();
    ((Oidb_0x5cf.ReqBody)localObject).uint32_version.set(1);
    ((Oidb_0x5cf.ReqBody)localObject).uint32_type.set(10);
    ((Oidb_0x5cf.ReqBody)localObject).uint64_touin.set(this.app.getLongAccountUin());
    localObject = this.app.a().makeOIDBPkg("OidbSvc.0x5cf_1", 1487, 0, ((Oidb_0x5cf.ReqBody)localObject).toByteArray());
    this.a.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void cOh()
  {
    this.a.createToServiceMsg("ProfileService.Pb.ReqNextSystemMsg.Friend");
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "<---sendGetNextFriendSystemMsgfollowing_friend_seq = " + this.app.a().aD("following_friend_seq_47"));
    }
    structmsg.ReqNextSystemMsg localReqNextSystemMsg = new structmsg.ReqNextSystemMsg();
    localReqNextSystemMsg.msg_num.set(20);
    localReqNextSystemMsg.following_friend_seq.set(this.app.a().aD("following_friend_seq_47"));
    localReqNextSystemMsg.checktype.set(2);
    localReqNextSystemMsg.version.set(1000);
    localReqNextSystemMsg.friend_msg_type_flag.set(1L);
    Object localObject = new structmsg.FlagInfo();
    ((structmsg.FlagInfo)localObject).FrdMsg_GetBusiCard.set(1);
    ((structmsg.FlagInfo)localObject).FrdMsg_Discuss2ManyChat.set(1);
    ((structmsg.FlagInfo)localObject).FrdMsg_NeedWaitingMsg.set(1);
    localReqNextSystemMsg.flag.set((MessageMicro)localObject);
    localObject = new ProtoReqManager.c();
    ((ProtoReqManager.c)localObject).dVU();
    ((ProtoReqManager.c)localObject).clW = "ProfileService.Pb.ReqNextSystemMsg.Friend";
    ((ProtoReqManager.c)localObject).fW = localReqNextSystemMsg.toByteArray();
    ((ProtoReqManager.c)localObject).a = new acrz(this);
    this.app.getProtoReqManager().b((ProtoReqManager.c)localObject);
  }
  
  public void cOi()
  {
    Ki(0);
  }
  
  public void f(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    case 6004: 
    case 6005: 
    default: 
      return;
    case 6002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        ir((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      bN(getClass().getName(), paramInt);
      return;
    case 6001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2], null);
        return;
      }
      bN(getClass().getName(), paramInt);
      return;
    case 6003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2], null);
        return;
      }
      bN(getClass().getName(), paramInt);
      return;
    case 6006: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        is((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      bN(getClass().getName(), paramInt);
      return;
    case 6007: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        it((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      bN(getClass().getName(), paramInt);
      return;
    case 6008: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        iv((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      c(4015, false, null);
      bN(getClass().getName(), paramInt);
      return;
    }
    iu((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
  }
  
  public void iu(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "handleDelAllSysMsg");
    }
    paramToServiceMsg = new Oidb_0x5cf.RspBody();
    this.app.a();
    int i = MessageHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.systemmsg.", 2, "handleDelAllSysMsg. " + i);
      }
      if (bool)
      {
        this.app.b().N(acbn.bkJ, 0);
        ((ysf)this.app.getManager(34)).cln();
      }
      c(8039, bool, new Object[] { Integer.valueOf(i) });
      return;
    }
  }
  
  public void iv(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      c(4015, false, null);
      return;
    }
    Oidb_0x5cf.RspBody localRspBody = new Oidb_0x5cf.RspBody();
    this.app.a();
    int i = MessageHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (i == 0)
    {
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("frienduin");
      i = paramToServiceMsg.extraData.getInt("istroop");
      long l = paramToServiceMsg.extraData.getLong("uniseq");
      this.app.b().d(paramFromServiceMsg, i, l, false);
      if (QLog.isColorLevel()) {
        QLog.w("Q.systemmsg.", 2, "<---handleGetDelSingleSysMsg Success!");
      }
      c(4014, true, paramToServiceMsg);
      return;
    }
    if (i == 1)
    {
      c(4014, true, paramToServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "<---handleGetDelSingleSysMsg Error!");
    }
    c(4015, false, paramToServiceMsg);
  }
  
  public ArrayList<MessageRecord> w(List<MessageRecord> paramList)
  {
    if ((QLog.isColorLevel()) && (paramList != null)) {
      QLog.d("SystemMessageProcessor", 2, "noti size is " + paramList.size());
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (localArrayList == null)) {
      return localArrayList;
    }
    HashSet localHashSet = new HashSet();
    HashMap localHashMap = new HashMap();
    localArrayList.clear();
    aein localaein = (aein)aeif.a().o(634);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((localMessageRecord instanceof MessageForSystemMsg))
      {
        structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
        String str = a(localStructMsg);
        if (((localStructMsg == null) || (!localStructMsg.msg_time.has()) || (System.currentTimeMillis() - localStructMsg.msg_time.get() * 1000L <= localaein.Wf * 1000L)) && (localStructMsg != null) && (localStructMsg.msg_seq.has())) {
          if (localHashSet.contains(Long.valueOf(localStructMsg.msg_seq.get())))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SystemMessageProcessor", 2, new Object[] { "getNotiData", "Repeat Msg Seq =", Long.valueOf(localStructMsg.msg_seq.get()) });
            }
          }
          else if ((localHashMap.containsKey(str)) && (localStructMsg.msg.has()) && (((structmsg.SystemMsg)localStructMsg.msg.get()).sub_type.get() == 1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SystemMessageProcessor", 2, new Object[] { "getNotiData", "New Repeat Undeal Msg Seq =", Long.valueOf(localStructMsg.msg_seq.get()) });
            }
            if (localStructMsg.msg_seq.get() > ((structmsg.StructMsg)localHashMap.get(str)).msg_seq.get())
            {
              if (QLog.isColorLevel()) {
                QLog.d("SystemMessageProcessor", 2, new Object[] { "getNotiData", "New Repeat Undeal Msg Seq =", Long.valueOf(localStructMsg.msg_seq.get()), "Old Repeat Undeal Msg Seq =", Long.valueOf(((structmsg.StructMsg)localHashMap.get(str)).msg_seq.get()) });
              }
              int i = 0;
              while (i < localArrayList.size() - 1)
              {
                localMessageRecord = (MessageRecord)localArrayList.get(i);
                if (((MessageForSystemMsg)localMessageRecord).getSystemMsg().msg_seq.get() == ((structmsg.StructMsg)localHashMap.get(str)).msg_seq.get())
                {
                  localArrayList.remove(i);
                  localArrayList.add(localMessageRecord);
                  localHashMap.put(str, localStructMsg);
                }
                i += 1;
              }
            }
            localHashSet.add(Long.valueOf(localStructMsg.msg_seq.get()));
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("SystemMessageProcessor", 2, new Object[] { "getNotiData", "No Repeat Msg Seq =", Long.valueOf(localStructMsg.msg_seq.get()) });
            }
            localHashSet.add(Long.valueOf(localStructMsg.msg_seq.get()));
            localHashMap.put(str, localStructMsg);
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void y(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject2 = "ProfileService.Pb.ReqSystemMsgNew";
    int i = 0;
    Object localObject1 = null;
    structmsg.ReqSystemMsgNew localReqSystemMsgNew;
    PBUInt64Field localPBUInt64Field;
    long l;
    switch (paramInt1)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.w("Q.systemmsg.", 2, "<---sendGetSystemMsg type=" + paramInt1 + " latest_friend_seq = " + this.app.a().aD("last_friend_seq_47") + " latest_group_seq = " + this.app.a().aD("last_group_seq") + " last_group_suspicious_seq = " + this.app.a().aD("last_group_suspicious_seq"));
      }
      localObject2 = this.a.createToServiceMsg((String)localObject2);
      localReqSystemMsgNew = new structmsg.ReqSystemMsgNew();
      localReqSystemMsgNew.msg_num.set(20);
      localReqSystemMsgNew.checktype.set(i);
      localPBUInt64Field = localReqSystemMsgNew.latest_friend_seq;
      if (paramBoolean)
      {
        l = 0L;
        label192:
        localPBUInt64Field.set(l);
        if (paramInt2 != 3) {
          break label766;
        }
        localPBUInt64Field = localReqSystemMsgNew.latest_group_seq;
        if (!paramBoolean) {
          break label748;
        }
        l = 0L;
        label218:
        localPBUInt64Field.set(l);
        if (localObject1 != null) {
          localReqSystemMsgNew.flag.set((MessageMicro)localObject1);
        }
        localReqSystemMsgNew.is_get_frd_ribbon.set(false);
        localReqSystemMsgNew.version.set(1000);
        localReqSystemMsgNew.is_get_grp_ribbon.set(false);
        localReqSystemMsgNew.friend_msg_type_flag.set(1L);
        if (paramInt2 != 3) {
          break label808;
        }
        localReqSystemMsgNew.uint32_req_msg_type.set(2);
      }
      break;
    }
    for (;;)
    {
      ((ToServiceMsg)localObject2).extraData.putInt("getSystemMsgSender", paramInt2);
      ((ToServiceMsg)localObject2).putWupBuffer(localReqSystemMsgNew.toByteArray());
      this.a.sendPbReq((ToServiceMsg)localObject2);
      return;
      localObject1 = new structmsg.FlagInfo();
      ((structmsg.FlagInfo)localObject1).GrpMsg_Kick_Admin.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_HiddenGrp.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_WordingDown.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetOfficialAccount.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetPayInGroup.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_Discuss2ManyChat.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_GetBusiCard.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_NeedWaitingMsg.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_NotAllowJoinGrp_InviteNotFrd.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_uint32_need_all_unread_msg.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_get_transfer_group_msg_flag.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_NeedAutoAdminWording.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_get_quit_pay_group_msg_flag.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_support_invite_auto_join.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_mask_invite_auto_join.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetDisbandedByAdmin.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetC2cInviteJoinGroup.set(1);
      localObject2 = (ajdr)this.app.getManager(37);
      i = 4;
      localObject2 = "ProfileService.Pb.ReqSystemMsgNew";
      break;
      localObject2 = "ProfileService.Pb.ReqSystemMsgNew.Friend";
      i = 2;
      localObject1 = new structmsg.FlagInfo();
      ((structmsg.FlagInfo)localObject1).FrdMsg_GetBusiCard.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_Discuss2ManyChat.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_NeedWaitingMsg.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_uint32_need_all_unread_msg.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetC2cInviteJoinGroup.set(1);
      break;
      localObject2 = "ProfileService.Pb.ReqSystemMsgNew.Group";
      i = 3;
      localObject1 = new structmsg.FlagInfo();
      ((structmsg.FlagInfo)localObject1).GrpMsg_Kick_Admin.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_HiddenGrp.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_WordingDown.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetOfficialAccount.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetPayInGroup.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_Discuss2ManyChat.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_NeedWaitingMsg.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_NotAllowJoinGrp_InviteNotFrd.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_get_transfer_group_msg_flag.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_NeedAutoAdminWording.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_get_quit_pay_group_msg_flag.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_support_invite_auto_join.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_mask_invite_auto_join.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetDisbandedByAdmin.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetC2cInviteJoinGroup.set(1);
      break;
      l = this.app.a().aD("last_friend_seq_47");
      break label192;
      label748:
      l = this.app.a().aD("last_group_suspicious_seq");
      break label218;
      label766:
      localPBUInt64Field = localReqSystemMsgNew.latest_group_seq;
      if (paramBoolean) {}
      for (l = 0L;; l = this.app.a().aD("last_group_seq"))
      {
        localPBUInt64Field.set(l);
        break;
      }
      label808:
      localReqSystemMsgNew.uint32_req_msg_type.set(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acrp
 * JD-Core Version:    0.7.0.1
 */