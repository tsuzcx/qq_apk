import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.codec.decoder.CreateGrpInPCDecoder.1;
import java.util.List;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class anbr
  implements anbs
{
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, anax paramanax)
  {
    paramList = (msg_comm.MsgHead)paramMsg.msg_head.get();
    int i = (short)paramList.msg_seq.get();
    long l1 = paramList.from_uin.get();
    long l2 = paramList.msg_uid.get();
    int j = paramList.msg_type.get();
    paramMsg = String.valueOf(aqcz.x(paramMsg.msg_body.msg_content.get().toByteArray()));
    paramList = (TroopManager)paramMessageHandler.app.getManager(52);
    if ((paramList != null) && (paramList.b(paramMsg) == null))
    {
      paramanax = new TroopInfo();
      paramanax.troopuin = paramMsg;
      paramanax.troopcode = paramMsg;
      paramanax.dwAdditionalFlag = 1L;
      paramList.i(paramanax);
    }
    paramList = (acms)paramMessageHandler.app.getBusinessHandler(20);
    if (paramList != null) {
      paramMessageHandler.app.getHandler(getClass()).postDelayed(new CreateGrpInPCDecoder.1(this, paramList, paramMsg), 2000L);
    }
    anbh.a(paramMessageHandler, l1, i, l2, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anbr
 * JD-Core Version:    0.7.0.1
 */