import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgsvc.msg_svc.DisTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class tqr
  implements tpu
{
  public boolean Or()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new msg_svc.DisTmp();
    paramQQAppInterface.dis_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
    paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramRoutingHead.dis_tmp.set(paramQQAppInterface);
    return true;
  }
  
  public int lk()
  {
    return 1004;
  }
  
  public int vg()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tqr
 * JD-Core Version:    0.7.0.1
 */