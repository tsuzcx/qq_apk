import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;

public class anci
  implements anbs
{
  private void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) || (!((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.has())) {}
    do
    {
      return;
      if (paramMsg.content_head.has()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("NormalBuddyDecoder", 2, "<---decodeC2CMessagePackage: msg doesn't has the contentHead.");
    return;
    Object localObject = (msg_comm.ContentHead)paramMsg.content_head.get();
    if ((((msg_comm.ContentHead)localObject).auto_reply.has()) && (((msg_comm.ContentHead)localObject).auto_reply.get() == 1)) {}
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      localObject = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append("<---decodeC2CMsgPkg_Buddy:elems size:").append(((List)localObject).size()).append(" isAutoReply:").append(paramBoolean2);
        QLog.d("NormalBuddyDecoder", 2, localStringBuilder.toString());
      }
      if (!paramBoolean2) {
        break label303;
      }
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break;
      }
      paramMessageHandler = BaseApplication.getContext().getString(2131690677);
      paramMsg = new anbg().O((List)localObject);
      if (TextUtils.isEmpty(paramMsg)) {
        break;
      }
      paramMessageHandler = paramMessageHandler + " " + paramMsg;
      paramMsg = anbi.d(-10000);
      paramMsg.msgtype = -10000;
      paramMsg.msg = paramMessageHandler;
      paramList.add(paramMsg);
      return;
    }
    label303:
    anbh.a(paramMessageHandler, paramList, paramMsg, true, paramBoolean1, null);
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, anax paramanax)
  {
    a(paramMessageHandler, paramList, paramMsg, paramanax.friendUin, paramanax.cEC, paramanax.isRead, paramanax.cEE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anci
 * JD-Core Version:    0.7.0.1
 */