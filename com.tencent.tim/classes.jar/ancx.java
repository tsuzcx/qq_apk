import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;

public class ancx
  implements ancz
{
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    ((aclo)paramMessageHandler.app.getBusinessHandler(18)).aN(paramMsgType0x210.msg_content.get().toByteArray());
    anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, anax paramanax, MessageHandler paramMessageHandler)
  {
    a(paramMessageHandler, paramMsg, paramMsgType0x210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ancx
 * JD-Core Version:    0.7.0.1
 */