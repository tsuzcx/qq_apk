import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgsvc.msg_svc.PublicPlat;
import msf.msgsvc.msg_svc.RoutingHead;

public class trf
  implements tpu
{
  public boolean Or()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().H(paramMessageRecord.frienduin);
    msg_svc.PublicPlat localPublicPlat = new msg_svc.PublicPlat();
    localPublicPlat.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    if (paramQQAppInterface != null)
    {
      paramMessageRecord = new byte[paramQQAppInterface.length - 2];
      aqoj.copyData(paramMessageRecord, 0, paramQQAppInterface, 2, paramQQAppInterface.length - 2);
      localPublicPlat.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.public_plat.set(localPublicPlat);
    return true;
  }
  
  public int lk()
  {
    return 1008;
  }
  
  public int vg()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     trf
 * JD-Core Version:    0.7.0.1
 */