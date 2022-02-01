import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.BusinessWPATmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class tqj
  implements tpu
{
  public boolean Or()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    byte[] arrayOfByte = paramQQAppInterface.a().K(paramMessageRecord.frienduin);
    msg_svc.BusinessWPATmp localBusinessWPATmp = new msg_svc.BusinessWPATmp();
    localBusinessWPATmp.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    if (arrayOfByte != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCRMRoutingType", 2, "conversation------>sig:" + aqhs.bytes2HexStr(arrayOfByte) + ",length:" + arrayOfByte.length);
      }
      localBusinessWPATmp.sig.set(ByteStringMicro.copyFrom(arrayOfByte));
    }
    for (;;)
    {
      paramRoutingHead.business_wpa_tmp.set(localBusinessWPATmp);
      return true;
      paramMessageRecord = paramQQAppInterface.a().L(paramMessageRecord.frienduin);
      if (paramMessageRecord != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BusinessCRMRoutingType", 2, "conversation------>sigt:" + aqhs.bytes2HexStr(paramMessageRecord) + ",length:" + paramMessageRecord.length);
        }
        localBusinessWPATmp.sigt.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
    }
  }
  
  public int lk()
  {
    return 1024;
  }
  
  public int vg()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tqj
 * JD-Core Version:    0.7.0.1
 */