import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
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
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

class acrt
  implements ProtoReqManager.b
{
  acrt(acrp paramacrp, int paramInt1, int paramInt2, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, structmsg.StructMsg paramStructMsg, long paramLong) {}
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    bool1 = false;
    ToServiceMsg localToServiceMsg = (ToServiceMsg)paramc.fi;
    if (paramd.g.getResultCode() != 1000)
    {
      this.jdField_a_of_type_Acrp.b(4012, false, localToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception code:" + paramd.g.getResultCode());
      }
      return;
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
        int i;
        boolean bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", paramd);
        bool1 = false;
        continue;
        if (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.has()) {
          continue;
        }
        paramc.a(String.valueOf(this.val$uin), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.get(), this.czu, this.d.msg.msg_additional.get(), false, bool2, -1L);
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
      bool2 = localToServiceMsg.extraData.getBoolean("isUncommonlyUsedFrd");
      if ((bool1) && (this.val$actionType == 0))
      {
        paramc = (FriendListHandler)acrp.a(this.jdField_a_of_type_Acrp).getBusinessHandler(1);
        if ((this.czu != 3016) && (this.czu != 2016)) {
          continue;
        }
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.has()) && (this.d != null) && (this.d.msg.msg_source.has())) {
          paramc.a(String.valueOf(this.val$uin), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.get(), this.czu, this.d.msg.msg_source.get(), false, bool2, -1L);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgActionResp result:" + j + " msg:" + paramd);
      }
      this.jdField_a_of_type_Acrp.b(4011, bool1, localToServiceMsg);
      return;
      paramc = localRspSystemMsgAction.head.msg_fail.get();
      paramd = paramc;
      if (paramc == null) {
        paramd = "";
      }
      localToServiceMsg.extraData.putString("system_msg_action_resp_error_key", paramd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acrt
 * JD-Core Version:    0.7.0.1
 */