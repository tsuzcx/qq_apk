import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.QQQueryBusinessTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class tre
  implements tpu
{
  public boolean Or()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().J(paramMessageRecord.frienduin);
    msg_svc.QQQueryBusinessTmp localQQQueryBusinessTmp = new msg_svc.QQQueryBusinessTmp();
    localQQQueryBusinessTmp.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    if (paramQQAppInterface != null)
    {
      paramMessageRecord = new byte[paramQQAppInterface.length - 2];
      aqoj.copyData(paramMessageRecord, 0, paramQQAppInterface, 2, paramQQAppInterface.length - 2);
      if (QLog.isColorLevel()) {
        QLog.d("PcQQSearchTmpRoutingType", 2, "wpa------>" + aqhs.bytes2HexStr(paramMessageRecord) + ",length:" + paramMessageRecord.length);
      }
      localQQQueryBusinessTmp.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.qq_querybusiness_tmp.set(localQQQueryBusinessTmp);
    return true;
  }
  
  public int lk()
  {
    return 1023;
  }
  
  public int vg()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tre
 * JD-Core Version:    0.7.0.1
 */