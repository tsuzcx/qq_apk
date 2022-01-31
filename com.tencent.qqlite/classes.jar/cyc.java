import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Comparator;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;

public class cyc
  implements Comparator
{
  public cyc(C2CMessageProcessor paramC2CMessageProcessor) {}
  
  public int a(msg_comm.Msg paramMsg1, msg_comm.Msg paramMsg2)
  {
    return ((msg_comm.MsgHead)paramMsg1.msg_head.get()).msg_time.get() - ((msg_comm.MsgHead)paramMsg2.msg_head.get()).msg_time.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cyc
 * JD-Core Version:    0.7.0.1
 */