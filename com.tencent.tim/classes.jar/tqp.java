import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.AddressListTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class tqp
  implements tpu
{
  public boolean Or()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    msg_svc.AddressListTmp localAddressListTmp = new msg_svc.AddressListTmp();
    localAddressListTmp.from_phone.set(paramMessageRecord.senderuin);
    localAddressListTmp.to_phone.set(paramMessageRecord.frienduin);
    paramMessageRecord = paramQQAppInterface.a().M(paramMessageRecord.frienduin);
    if (paramMessageRecord != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactRoutingType", 2, "sameState------>" + aqhs.bytes2HexStr(paramMessageRecord) + ",length:" + paramMessageRecord.length);
      }
      localAddressListTmp.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.address_list.set(localAddressListTmp);
    return true;
  }
  
  public int lk()
  {
    return 1006;
  }
  
  public int vg()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tqp
 * JD-Core Version:    0.7.0.1
 */