import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class ybc
  implements Comparator<MessageRecord>
{
  ybc(ybb paramybb) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.time - paramMessageRecord2.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ybc
 * JD-Core Version:    0.7.0.1
 */