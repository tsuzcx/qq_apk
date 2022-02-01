import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.ProtoReqManager.IProtoRespBack;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgAction;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class fjt
  implements ProtoReqManager.IProtoRespBack
{
  public fjt(SystemMessageProcessor paramSystemMessageProcessor, int paramInt, long paramLong, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, structmsg.StructMsg paramStructMsg) {}
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    bool = false;
    ToServiceMsg localToServiceMsg = (ToServiceMsg)paramProtoReq.a;
    if (paramProtoResp.a.getResultCode() != 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageSystemMessageProcessor.a(4012, false, localToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception code:" + paramProtoResp.a.getResultCode());
      }
      return;
    }
    for (;;)
    {
      try
      {
        paramProtoResp = paramProtoResp.a.getWupBuffer();
        localObject = new structmsg.RspSystemMsgAction();
        ((structmsg.RspSystemMsgAction)localObject).mergeFrom(paramProtoResp);
        j = ((structmsg.RspSystemMsgAction)localObject).head.result.get();
        if (j != 0) {
          continue;
        }
        bool = true;
        paramProtoReq = ((structmsg.RspSystemMsgAction)localObject).msg_detail.get();
        if (paramProtoReq != null) {
          continue;
        }
        paramProtoReq = "";
      }
      catch (Exception paramProtoResp)
      {
        Object localObject;
        int j;
        FriendsManagerImp localFriendsManagerImp;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", paramProtoResp);
        bool = false;
        continue;
        int i = -1;
        continue;
        continue;
      }
      if (!((structmsg.RspSystemMsgAction)localObject).remark_result.has()) {
        continue;
      }
      i = ((structmsg.RspSystemMsgAction)localObject).remark_result.get();
      localToServiceMsg.extraData.putString("system_msg_action_resp_key", paramProtoReq);
      localToServiceMsg.extraData.putInt("system_msg_action_resp_result_code_key", ((structmsg.RspSystemMsgAction)localObject).head.result.get());
      localToServiceMsg.extraData.putInt("system_msg_action_resp_type_key", ((structmsg.RspSystemMsgAction)localObject).type.get());
      localToServiceMsg.extraData.putString("system_msg_action_resp_invalid_decided_key", ((structmsg.RspSystemMsgAction)localObject).msg_invalid_decided.get());
      localToServiceMsg.extraData.putInt("system_msg_action_resp_remark_result_key", i);
      if ((bool) && (this.jdField_a_of_type_Int == 0))
      {
        localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppMessageSystemMessageProcessor.a.getManager(8);
        if (((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppMessageSystemMessageProcessor.a.a(1)).a(this.jdField_a_of_type_ComTencentMobileqqAppMessageSystemMessageProcessor.a.getAccount(), String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.get())) {
          localFriendsManagerImp.a(String.valueOf(this.jdField_a_of_type_Long), false);
        }
        paramProtoResp = null;
        if (i != 0) {}
      }
      try
      {
        paramProtoResp = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.remark.get();
        if (paramProtoResp != null)
        {
          localObject = paramProtoResp;
          if (!"".equals(paramProtoResp)) {}
        }
        else
        {
          localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        }
        if ((localObject != null) && (!"".equals(localObject)))
        {
          localFriendsManagerImp.a(String.valueOf(this.jdField_a_of_type_Long), (String)localObject, (byte)1);
          paramProtoResp = localFriendsManagerImp.a(String.valueOf(this.jdField_a_of_type_Long));
          if (paramProtoResp != null)
          {
            paramProtoResp.strReMark = ((String)localObject);
            localFriendsManagerImp.a(paramProtoResp);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageSystemMessageProcessor.a.a(1).a(3, true, String.valueOf(this.jdField_a_of_type_Long));
          this.jdField_a_of_type_ComTencentMobileqqAppMessageSystemMessageProcessor.a.a(1).a(27, true, new Object[] { String.valueOf(this.jdField_a_of_type_Long), localObject, Byte.valueOf(1) });
        }
      }
      catch (Exception paramProtoResp)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", paramProtoResp);
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgActionResp result:" + j + " msg:" + paramProtoReq);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageSystemMessageProcessor.a(4011, bool, localToServiceMsg);
      return;
      paramProtoReq = ((structmsg.RspSystemMsgAction)localObject).head.msg_fail.get();
      paramProtoResp = paramProtoReq;
      if (paramProtoReq == null) {
        paramProtoResp = "";
      }
      localToServiceMsg.extraData.putString("system_msg_action_resp_error_key", paramProtoResp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fjt
 * JD-Core Version:    0.7.0.1
 */