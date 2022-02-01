import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class ance
  implements anbs
{
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, anax paramanax)
  {
    if (paramanax.cEE) {}
    long l1;
    long l2;
    long l3;
    label505:
    do
    {
      int i;
      HashMap localHashMap;
      do
      {
        do
        {
          long l4;
          do
          {
            do
            {
              do
              {
                return;
                if ((paramMsg.msg_body.has()) && (((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()) && (!paramanax.isRead) && (!paramanax.cEG)) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.e("VideoDecoder", 2, "<---decodeC2CMsgPkg_Video return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + paramanax.isRead + "syncOther:" + paramanax.cEG);
              return;
              l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
              l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
              long l5 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
              l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
              long l6 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get();
              l3 = Long.valueOf(paramMessageHandler.app.getCurrentAccountUin()).longValue();
              paramList = l2 + "-" + l6 + "-" + l5 + "-" + l4;
              if (QLog.isColorLevel()) {
                QLog.d("VideoDecoder", 2, "<---decodeC2CMsgPkg_Video :  key:" + paramList);
              }
              paramList = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
              l4 = anaz.gQ() - l1;
              i = imi.a(paramList);
              if (imm.isSupportSharpAudio()) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("svenxu", 2, "Discard video message cause device not support");
            return;
            if (l4 < 60L) {
              break;
            }
          } while ((i == 1) && (!QLog.isColorLevel()));
          QLog.d("svenxu", 2, "Discard video message because of time out " + l4 + " s");
          return;
          localHashMap = (HashMap)paramanax.getTag(1000);
          paramanax = (HashSet)paramanax.getTag(1001);
          if (i != 1) {
            break label505;
          }
          if (imm.isSupportSharpAudio()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("shanezhaiSHARP", 2, "discard video push message because the sdk is lower");
        return;
      } while (localHashMap == null);
      localHashMap.put(Long.valueOf(l2), paramMsg);
      return;
      if (i != 3) {
        break;
      }
    } while (!imm.isSupportSharpAudio());
    if (paramanax != null) {
      paramanax.add(Long.valueOf(l2));
    }
    paramMessageHandler.a(l3, paramList, l2, (int)l1);
    return;
    paramMessageHandler.a(l3, paramList, l2, (int)l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ance
 * JD-Core Version:    0.7.0.1
 */