import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.im_msg_body.RichText;

public abstract interface tpm
{
  public abstract im_msg_body.RichText a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface);
  
  public abstract void a(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, QQAppInterface paramQQAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tpm
 * JD-Core Version:    0.7.0.1
 */