import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.GrpTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class tqu
  implements tpu
{
  public boolean Or()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((!TextUtils.isEmpty(paramMessageRecord.senderuin)) && (Long.valueOf(paramMessageRecord.senderuin).longValue() != 0L) && (!TextUtils.equals(paramMessageRecord.senderuin, paramMessageRecord.selfuin)) && (TextUtils.equals(paramMessageRecord.senderuin, paramMessageRecord.frienduin))) {}
    paramQQAppInterface = new msg_svc.GrpTmp();
    if (TextUtils.isEmpty(paramMessageRecord.senderuin))
    {
      paramQQAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.selfuin).longValue());
      if (QLog.isColorLevel()) {
        QLog.d("GrpTmpRoutingType", 2, "createSendRichTextMsgReq, senderuin error, senderuin: " + paramMessageRecord.senderuin + " frienduin: " + paramMessageRecord.frienduin + " msgtype: " + paramMessageRecord.msgtype);
      }
    }
    for (;;)
    {
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramRoutingHead.grp_tmp.set(paramQQAppInterface);
      return true;
      paramQQAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
    }
  }
  
  public int lk()
  {
    return 1000;
  }
  
  public int vg()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tqu
 * JD-Core Version:    0.7.0.1
 */