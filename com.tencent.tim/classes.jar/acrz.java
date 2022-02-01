import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.transfile.ProtoReqManager.b;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspNextSystemMsg;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class acrz
  implements ProtoReqManager.b
{
  acrz(acrp paramacrp) {}
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    if (paramd.g.getResultCode() != 1000)
    {
      this.a.b(4006, false, null);
      return;
    }
    Object localObject1;
    int i;
    for (;;)
    {
      structmsg.RspNextSystemMsg localRspNextSystemMsg;
      Object localObject2;
      Object localObject3;
      MessageForSystemMsg localMessageForSystemMsg;
      try
      {
        localObject1 = (acff)acrp.b(this.a).getManager(51);
        paramc = acrp.c(this.a).getAccount();
        localRspNextSystemMsg = new structmsg.RspNextSystemMsg();
        localRspNextSystemMsg.mergeFrom((byte[])paramd.g.getWupBuffer());
        new StringBuilder();
        if ((localRspNextSystemMsg == null) || (localRspNextSystemMsg.head.result.get() != 0)) {
          this.a.b(4006, false, null);
        }
        paramd = new ArrayList();
        localObject2 = localRspNextSystemMsg.msgs.get();
        j = ((List)localObject2).size();
        if (!QLog.isColorLevel()) {
          break label860;
        }
        QLog.e("Q.systemmsg.", 2, "<---sendGetNextFriendSystemMsg Resp : decode pb size = " + j);
      }
      catch (Exception paramd)
      {
        int j;
        long l3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.systemmsg.", 2, "clearFriendSystemMsgResp exception", paramd);
        this.a.b(4006, false, null);
        return;
      }
      if (i < j)
      {
        localObject3 = anbi.d(-2018);
        ((MessageRecord)localObject3).msgtype = -2018;
        ((MessageRecord)localObject3).selfuin = paramc;
        ((MessageRecord)localObject3).frienduin = acbn.bkJ;
        ((MessageRecord)localObject3).senderuin = (((structmsg.StructMsg)((List)localObject2).get(i)).req_uin.get() + "");
        ((MessageRecord)localObject3).istroop = 0;
        ((MessageRecord)localObject3).time = ((structmsg.StructMsg)((List)localObject2).get(i)).msg_time.get();
        ((MessageRecord)localObject3).isread = true;
        localMessageForSystemMsg = (MessageForSystemMsg)localObject3;
        localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)((List)localObject2).get(i)).get());
        ((MessageRecord)localObject3).msgData = localMessageForSystemMsg.structMsg.toByteArray();
        localMessageForSystemMsg.parse();
        paramd.add(localMessageForSystemMsg);
        i += 1;
      }
      else if (paramd.size() > 0)
      {
        i = paramd.size();
        long l1 = ((MessageRecord)paramd.get(0)).time;
        long l2 = ((MessageRecord)paramd.get(i - 1)).time;
        l3 = anzd.a().p(acrp.d(this.a));
        localObject2 = acrp.e(this.a).b().a(acbn.bkJ, 0, l3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ChatMessage)((Iterator)localObject2).next();
          if ((((ChatMessage)localObject3).time >= l2) && (((ChatMessage)localObject3).time <= l1))
          {
            acrp.f(this.a).b().d(acbn.bkJ, 0, ((ChatMessage)localObject3).uniseq, false);
            ((Iterator)localObject2).remove();
          }
          else if ((localObject3 instanceof MessageForSystemMsg))
          {
            localMessageForSystemMsg = (MessageForSystemMsg)localObject3;
            if (localMessageForSystemMsg.structMsg == null) {
              localMessageForSystemMsg.parse();
            }
            String str = localMessageForSystemMsg.senderuin;
            if ((localMessageForSystemMsg.structMsg.msg.sub_type.get() == 13) && (((acff)localObject1).isFriend(str)))
            {
              acrp.g(this.a).b().d(acbn.bkJ, 0, ((ChatMessage)localObject3).uniseq, false);
              ((Iterator)localObject2).remove();
            }
          }
        }
        anzd.a().t(acrp.h(this.a), l2);
        if (paramd.size() < 20) {
          anzd.a().c(true, acrp.i(this.a));
        }
        l2 = localRspNextSystemMsg.following_friend_seq.get();
        l1 = l2;
        if (l2 <= 0L) {
          l1 = acrp.j(this.a).a().aD("following_friend_seq_47");
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---sendGetNextFriendSystemMsg : decode pb following_friend_seq" + l1);
        }
        acrp.k(this.a).a().aN("following_friend_seq_47", l1);
        localObject1 = acrp.m(this.a).b();
        paramc = String.valueOf(paramc);
        if ((!achp.F(paramd)) || (!acrp.l(this.a).isBackground_Stop)) {
          break label865;
        }
      }
    }
    label860:
    label865:
    for (boolean bool = true;; bool = false)
    {
      ((QQMessageFacade)localObject1).c(paramd, paramc, bool);
      this.a.a("handleGetSystemMsgResp", true, paramd.size(), false, false);
      for (;;)
      {
        this.a.b(4005, true, null);
        return;
        anzd.a().c(true, acrp.n(this.a));
      }
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acrz
 * JD-Core Version:    0.7.0.1
 */