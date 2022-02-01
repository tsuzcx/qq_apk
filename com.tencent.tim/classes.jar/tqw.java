import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.AccostTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class tqw
  implements tpu
{
  public boolean Or()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    msg_svc.AccostTmp localAccostTmp = new msg_svc.AccostTmp();
    localAccostTmp.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    QQMessageFacade.Message localMessage = paramQQAppInterface.b().a(paramMessageRecord.frienduin, 1001);
    localAccostTmp.reply.set(localMessage.hasReply);
    if (QLog.isColorLevel()) {
      QLog.d("LBSFriendRoutingType", 2, "LBS_FRIEND------>reply=" + localMessage.hasReply);
    }
    paramMessageRecord = paramQQAppInterface.a().T(paramMessageRecord.frienduin);
    if (paramMessageRecord != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("fight_accost", 4, "发送附近人临时会消息 有keyLBSFriend------>" + aqhs.bytes2HexStr(paramMessageRecord) + ",length:" + paramMessageRecord.length);
      }
      localAccostTmp.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.accost_tmp.set(localAccostTmp);
    return true;
  }
  
  public int lk()
  {
    return 1001;
  }
  
  public int vg()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tqw
 * JD-Core Version:    0.7.0.1
 */