import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

public class czl
  implements Comparator
{
  public czl(C2CMessageProcessor paramC2CMessageProcessor) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.time - paramMessageRecord2.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     czl
 * JD-Core Version:    0.7.0.1
 */