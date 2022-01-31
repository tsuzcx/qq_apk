import com.tencent.mobileqq.activity.messagesearch.C2CMessageResultAdapter;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

public class wwp
  implements Comparator
{
  public wwp(C2CMessageResultAdapter paramC2CMessageResultAdapter) {}
  
  public int a(MessageItem paramMessageItem1, MessageItem paramMessageItem2)
  {
    return (int)(paramMessageItem2.a.time - paramMessageItem1.a.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wwp
 * JD-Core Version:    0.7.0.1
 */