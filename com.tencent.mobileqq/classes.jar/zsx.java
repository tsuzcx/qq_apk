import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

public class zsx
  implements Comparator
{
  public zsx(C2CMessageProcessor paramC2CMessageProcessor) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord2.time - paramMessageRecord1.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zsx
 * JD-Core Version:    0.7.0.1
 */