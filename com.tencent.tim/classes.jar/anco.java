import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0x128.submsgtype0x128.MsgBody;

public class anco
  implements ancz
{
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, anax paramanax, MessageHandler paramMessageHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendDecoder", 2, "extendfriend limitchat offLinePush receive submsgtype0x128 decodeC2CMsgPkg_MsgType0x210 receive 0x128 push message");
    }
    int i = paramMsgType0x210.sub_msg_type.get();
    try
    {
      paramList = new submsgtype0x128.MsgBody();
      paramList.mergeFrom(paramMsgType0x210.msg_content.get().toByteArray());
      paramMsgType0x210 = (afsg)paramMessageHandler.app.getBusinessHandler(127);
      if (i == 296) {}
      for (boolean bool = true;; bool = false)
      {
        paramMsgType0x210.a(paramList, bool);
        QLog.d("ExtendFriendDecoderExtendFriendLimitChat", 2, "SubMsgType0x27.ChatMatchInfo subType " + i);
        anbh.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
      }
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      QLog.e("ExtendFriendDecoder", 1, "troopFormLog offLinePush receive submsgtype match chat0x128 decodeC2CMsgPkg_MsgType0x210 receive 0x128 push message, errInfo->" + paramMsgType0x210.getMessage() + " msgType" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anco
 * JD-Core Version:    0.7.0.1
 */