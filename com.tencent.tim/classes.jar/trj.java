import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.CommTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class trj
  implements tpu
{
  public boolean Or()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    msg_svc.CommTmp localCommTmp = new msg_svc.CommTmp();
    localCommTmp.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    localCommTmp.c2c_type.set(1);
    localCommTmp.svr_type.set(149);
    QQMessageFacade.Message localMessage = paramQQAppInterface.b().a(paramMessageRecord.frienduin, 1001);
    if (QLog.isColorLevel()) {
      QLog.d("TribeTmpRoutingType", 2, "TRIBE_TMP------>reply=" + localMessage.hasReply);
    }
    paramMessageRecord = paramQQAppInterface.a().R(paramMessageRecord.frienduin);
    if (paramMessageRecord != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("fight_accost", 4, "发送兴趣部落临时会消息 有key------>" + aqhs.bytes2HexStr(paramMessageRecord) + ",length:" + paramMessageRecord.length);
      }
      localCommTmp.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.comm_tmp.set(localCommTmp);
    return true;
  }
  
  public int lk()
  {
    return 10002;
  }
  
  public int vg()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     trj
 * JD-Core Version:    0.7.0.1
 */