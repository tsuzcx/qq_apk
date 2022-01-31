import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.transfile.ProtoReqManager.IProtoRespBack;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspNextSystemMsg;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class zrc
  implements ProtoReqManager.IProtoRespBack
{
  public zrc(SystemMessageProcessor paramSystemMessageProcessor) {}
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    if (paramProtoResp.a.getResultCode() != 1000)
    {
      this.a.a(4006, false, null);
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
        localObject1 = (FriendsManager)this.a.a.getManager(50);
        paramProtoReq = this.a.a.getAccount();
        localRspNextSystemMsg = new structmsg.RspNextSystemMsg();
        localRspNextSystemMsg.mergeFrom((byte[])paramProtoResp.a.getWupBuffer());
        new StringBuilder();
        if ((localRspNextSystemMsg == null) || (localRspNextSystemMsg.head.result.get() != 0)) {
          this.a.a(4006, false, null);
        }
        paramProtoResp = new ArrayList();
        localObject2 = localRspNextSystemMsg.msgs.get();
        j = ((List)localObject2).size();
        if (!QLog.isColorLevel()) {
          break label859;
        }
        QLog.e("Q.systemmsg.", 2, "<---sendGetNextFriendSystemMsg Resp : decode pb size = " + j);
      }
      catch (Exception paramProtoResp)
      {
        int j;
        long l3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.systemmsg.", 2, "clearFriendSystemMsgResp exception", paramProtoResp);
        this.a.a(4006, false, null);
        return;
      }
      if (i < j)
      {
        localObject3 = MessageRecordFactory.a(-2018);
        ((MessageRecord)localObject3).msgtype = -2018;
        ((MessageRecord)localObject3).selfuin = paramProtoReq;
        ((MessageRecord)localObject3).frienduin = AppConstants.K;
        ((MessageRecord)localObject3).senderuin = (((structmsg.StructMsg)((List)localObject2).get(i)).req_uin.get() + "");
        ((MessageRecord)localObject3).istroop = 0;
        ((MessageRecord)localObject3).time = ((structmsg.StructMsg)((List)localObject2).get(i)).msg_time.get();
        ((MessageRecord)localObject3).isread = true;
        localMessageForSystemMsg = (MessageForSystemMsg)localObject3;
        localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)((List)localObject2).get(i)).get());
        ((MessageRecord)localObject3).msgData = localMessageForSystemMsg.structMsg.toByteArray();
        localMessageForSystemMsg.parse();
        paramProtoResp.add(localMessageForSystemMsg);
        i += 1;
      }
      else if (paramProtoResp.size() > 0)
      {
        i = paramProtoResp.size();
        long l1 = ((MessageRecord)paramProtoResp.get(0)).time;
        long l2 = ((MessageRecord)paramProtoResp.get(i - 1)).time;
        l3 = FriendSystemMsgController.a().a(this.a.a);
        localObject2 = this.a.a.a().a(AppConstants.K, 0, l3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ChatMessage)((Iterator)localObject2).next();
          if ((((ChatMessage)localObject3).time >= l2) && (((ChatMessage)localObject3).time <= l1))
          {
            this.a.a.a().b(AppConstants.K, 0, ((ChatMessage)localObject3).uniseq, false);
            ((Iterator)localObject2).remove();
          }
          else if ((localObject3 instanceof MessageForSystemMsg))
          {
            localMessageForSystemMsg = (MessageForSystemMsg)localObject3;
            if (localMessageForSystemMsg.structMsg == null) {
              localMessageForSystemMsg.parse();
            }
            String str = localMessageForSystemMsg.senderuin;
            if ((localMessageForSystemMsg.structMsg.msg.sub_type.get() == 13) && (((FriendsManager)localObject1).b(str)))
            {
              this.a.a.a().b(AppConstants.K, 0, ((ChatMessage)localObject3).uniseq, false);
              ((Iterator)localObject2).remove();
            }
          }
        }
        FriendSystemMsgController.a().a(this.a.a, l2);
        if (paramProtoResp.size() < 20) {
          FriendSystemMsgController.a().a(true, this.a.a);
        }
        l2 = localRspNextSystemMsg.following_friend_seq.get();
        l1 = l2;
        if (l2 <= 0L) {
          l1 = this.a.a.a().d("following_friend_seq_47");
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---sendGetNextFriendSystemMsg : decode pb following_friend_seq" + l1);
        }
        this.a.a.a().d("following_friend_seq_47", l1);
        localObject1 = this.a.a.a();
        paramProtoReq = String.valueOf(paramProtoReq);
        if ((!MessageHandlerUtils.a(paramProtoResp)) || (!this.a.a.isBackground_Stop)) {
          break label864;
        }
      }
    }
    label859:
    label864:
    for (boolean bool = true;; bool = false)
    {
      ((QQMessageFacade)localObject1).a(paramProtoResp, paramProtoReq, bool);
      this.a.a("handleGetSystemMsgResp", true, paramProtoResp.size(), false, false);
      for (;;)
      {
        this.a.a(4005, true, null);
        return;
        FriendSystemMsgController.a().a(true, this.a.a);
      }
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zrc
 * JD-Core Version:    0.7.0.1
 */