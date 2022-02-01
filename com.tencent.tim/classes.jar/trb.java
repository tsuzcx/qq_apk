import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.NearByAssistantTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class trb
  implements tpu
{
  public boolean Or()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    msg_svc.NearByAssistantTmp localNearByAssistantTmp = new msg_svc.NearByAssistantTmp();
    localNearByAssistantTmp.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramMessageRecord = paramQQAppInterface.a().V(paramMessageRecord.frienduin);
    if (paramMessageRecord != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("nearby_assistant", 4, "发送附近人助手临时会话消息 有NearbyAssistantKey------>" + aqhs.bytes2HexStr(paramMessageRecord) + ",length:" + paramMessageRecord.length);
      }
      localNearByAssistantTmp.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.nearby_assistant_tmp.set(localNearByAssistantTmp);
    return true;
  }
  
  public int lk()
  {
    return 0;
  }
  
  public int vg()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     trb
 * JD-Core Version:    0.7.0.1
 */