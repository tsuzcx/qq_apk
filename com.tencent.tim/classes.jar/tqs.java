import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.AuthTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class tqs
  implements tpu
{
  public boolean Or()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    msg_svc.AuthTmp localAuthTmp = new msg_svc.AuthTmp();
    localAuthTmp.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramMessageRecord = paramQQAppInterface.a().P(paramMessageRecord.frienduin);
    if (paramMessageRecord != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendValidationRoutingType", 2, "friendValidation------>" + aqhs.bytes2HexStr(paramMessageRecord) + ",length:" + paramMessageRecord.length);
      }
      localAuthTmp.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.auth_tmp.set(localAuthTmp);
    return true;
  }
  
  public int lk()
  {
    return 1022;
  }
  
  public int vg()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tqs
 * JD-Core Version:    0.7.0.1
 */