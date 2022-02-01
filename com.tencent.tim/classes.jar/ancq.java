import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.MsgBody;

public class ancq
  implements ancz
{
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, anax paramanax, MessageHandler paramMessageHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearbyTroopPush", 2, "receive offline msgtype0x210.submsgtype0x67 group recmd msg");
    }
    paramList = new submsgtype0x67.MsgBody();
    try
    {
      paramList.mergeFrom(paramMsgType0x210.msg_content.get().toByteArray());
      if (paramList.rpt_msg_grpinfo.has())
      {
        paramMsgType0x210 = paramList.rpt_msg_grpinfo.get();
        paramList = (acgr)paramMessageHandler.app.getBusinessHandler(3);
        if (paramList != null) {
          paramList.iS(paramMsgType0x210);
        }
      }
      anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearbyTroopPush", 2, "receive offline msgtype0x210.submsgtype0x67 mergeFrom exception: " + paramMsgType0x210.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ancq
 * JD-Core Version:    0.7.0.1
 */