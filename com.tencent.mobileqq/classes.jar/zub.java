import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Comparator;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class zub
  implements Comparator
{
  public zub(SystemMessageProcessor paramSystemMessageProcessor) {}
  
  public int a(structmsg.StructMsg paramStructMsg1, structmsg.StructMsg paramStructMsg2)
  {
    if (paramStructMsg1.msg_time.get() < paramStructMsg2.msg_time.get()) {
      return 1;
    }
    if (paramStructMsg1.msg_time.get() > paramStructMsg2.msg_time.get()) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zub
 * JD-Core Version:    0.7.0.1
 */