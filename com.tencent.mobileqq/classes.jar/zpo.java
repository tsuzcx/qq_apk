import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

public class zpo
  implements Comparator
{
  public zpo(C2CMessageProcessor paramC2CMessageProcessor) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.time - paramMessageRecord2.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zpo
 * JD-Core Version:    0.7.0.1
 */