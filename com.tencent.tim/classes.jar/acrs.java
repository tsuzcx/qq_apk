import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.ProtoReqManager.b;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgAction;

class acrs
  implements ProtoReqManager.b
{
  acrs(acrp paramacrp) {}
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    ToServiceMsg localToServiceMsg = (ToServiceMsg)paramc.fi;
    if (paramd.g.getResultCode() != 1000) {
      this.a.b(4012, false, localToServiceMsg);
    }
    for (;;)
    {
      try
      {
        paramd = paramd.g.getWupBuffer();
        localRspSystemMsgAction = new structmsg.RspSystemMsgAction();
        localRspSystemMsgAction.mergeFrom(paramd);
        j = localRspSystemMsgAction.head.result.get();
        if (j != 0) {
          continue;
        }
        bool1 = true;
        paramd = localRspSystemMsgAction.msg_detail.get();
        if (paramd != null) {
          continue;
        }
        paramd = "";
      }
      catch (Exception paramd)
      {
        structmsg.RspSystemMsgAction localRspSystemMsgAction;
        int j;
        boolean bool1;
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", paramd);
        boolean bool2 = false;
        continue;
        continue;
      }
      i = -1;
      if (localRspSystemMsgAction.remark_result.has()) {
        i = localRspSystemMsgAction.remark_result.get();
      }
      localToServiceMsg.extraData.putString("system_msg_action_resp_key", paramd);
      localToServiceMsg.extraData.putInt("system_msg_action_resp_result_code_key", localRspSystemMsgAction.head.result.get());
      localToServiceMsg.extraData.putInt("system_msg_action_resp_type_key", localRspSystemMsgAction.type.get());
      localToServiceMsg.extraData.putString("system_msg_action_resp_invalid_decided_key", localRspSystemMsgAction.msg_invalid_decided.get());
      localToServiceMsg.extraData.putInt("system_msg_action_resp_remark_result_key", i);
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgActionResp result:" + j + " msg:" + paramd);
        bool2 = bool1;
      }
      this.a.b(4011, bool2, localToServiceMsg);
      return;
      paramc = localRspSystemMsgAction.head.msg_fail.get();
      paramd = paramc;
      if (paramc == null) {
        paramd = "";
      }
      localToServiceMsg.extraData.putString("system_msg_action_resp_error_key", paramd);
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acrs
 * JD-Core Version:    0.7.0.1
 */