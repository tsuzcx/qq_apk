import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.transfile.ProtoReqManager.b;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspNextSystemMsg;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class acrr
  implements ProtoReqManager.b
{
  acrr(acrp paramacrp) {}
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    if (paramd.g.getResultCode() != 1000) {
      this.a.b(4006, false, null);
    }
    label54:
    Object localObject2;
    do
    {
      return;
      try
      {
        if ((paramc.fi == null) || (!(paramc.fi instanceof Integer))) {
          break label888;
        }
        i = ((Integer)paramc.fi).intValue();
        paramc = acrp.o(this.a).getAccount();
        localObject2 = new structmsg.RspNextSystemMsg();
        ((structmsg.RspNextSystemMsg)localObject2).mergeFrom((byte[])paramd.g.getWupBuffer());
        new StringBuilder();
        if ((localObject2 == null) || (((structmsg.RspNextSystemMsg)localObject2).head.result.get() != 0)) {
          this.a.b(4006, false, null);
        }
        if (i != 3) {
          break;
        }
        yym.a(this.a, acrp.p(this.a), (structmsg.RspNextSystemMsg)localObject2, paramc);
        return;
      }
      catch (Exception paramd) {}
    } while (!QLog.isColorLevel());
    QLog.d("Q.systemmsg.", 2, "clearFriendSystemMsgResp exception", paramd);
    return;
    paramd = new ArrayList();
    Object localObject1 = ((structmsg.RspNextSystemMsg)localObject2).msgs.get();
    int j = ((List)localObject1).size();
    if (QLog.isColorLevel()) {
      QLog.e("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsg Resp : decode pb size = " + j);
    }
    HashSet localHashSet = new HashSet();
    int i = 0;
    label239:
    if (i < j)
    {
      structmsg.StructMsg localStructMsg = (structmsg.StructMsg)((structmsg.StructMsg)((List)localObject1).get(i)).get();
      if ((localStructMsg == null) || (!localStructMsg.msg_seq.has()) || (!localHashSet.contains(Long.valueOf(localStructMsg.msg_seq.get()))))
      {
        MessageRecord localMessageRecord = anbi.d(-2018);
        localMessageRecord.msgtype = -2018;
        localMessageRecord.selfuin = paramc;
        localMessageRecord.frienduin = acbn.bkK;
        localMessageRecord.senderuin = (((structmsg.StructMsg)((List)localObject1).get(i)).req_uin.get() + "");
        localMessageRecord.istroop = 0;
        MessageForSystemMsg localMessageForSystemMsg = (MessageForSystemMsg)localMessageRecord;
        localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)((List)localObject1).get(i)).get());
        localMessageRecord.msgData = localMessageForSystemMsg.structMsg.toByteArray();
        paramd.add(localMessageForSystemMsg);
        if ((localStructMsg != null) && (localStructMsg.msg_seq.has())) {
          localHashSet.add(Long.valueOf(localStructMsg.msg_seq.get()));
        }
      }
    }
    else
    {
      localObject1 = (ajdr)acrp.q(this.a).getManager(37);
      if (paramd.size() > 0)
      {
        if (paramd.size() < 100)
        {
          anze.a().c(true, acrp.r(this.a));
          if (localObject1 != null) {
            ((ajdr)localObject1).LQ(true);
          }
        }
        long l2 = ((structmsg.RspNextSystemMsg)localObject2).following_group_seq.get();
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = acrp.s(this.a).a().aD("following_group_seq");
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsg : decode pb following_group_seq" + l1);
        }
        acrp.t(this.a).a().aN("following_group_seq", l1);
        localObject2 = yxz.df();
        if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
          break label885;
        }
        localObject2 = acrp.g((List)localObject2, paramd);
        if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
          break label885;
        }
        paramd = this.a.w((List)localObject2);
        acrp.u(this.a).b().a(acbn.bkK, 0, true, true);
        localObject2 = acrp.w(this.a).b();
        paramc = String.valueOf(paramc);
        if ((!achp.F(paramd)) || (!acrp.v(this.a).isBackground_Stop)) {
          break label900;
        }
      }
    }
    label668:
    for (boolean bool = true;; bool = false)
    {
      ((QQMessageFacade)localObject2).c(paramd, paramc, bool);
      this.a.a("handleGetSystemMsgResp", true, paramd.size(), false, false);
      this.a.b(4005, true, paramd);
      for (;;)
      {
        paramd = (aein)aeif.a().o(634);
        i = paramd.cNi;
        paramc = acrp.y(this.a).b().b(acbn.bkK, 0, null);
        if ((((ajdr)localObject1).aqu()) || (paramc == null) || (paramc.size() >= i) || (!paramd.bUc)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageProcessor", 2, "Auto Get Msg Continue");
        }
        this.a.Ki(0);
        return;
        anze.a().c(true, acrp.x(this.a));
        if (localObject1 != null) {
          ((ajdr)localObject1).LQ(true);
        }
      }
      label885:
      break label668;
      label888:
      i = 0;
      break label54;
      i += 1;
      break label239;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acrr
 * JD-Core Version:    0.7.0.1
 */