import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class yfl
  implements Comparator<MessageRecord>
{
  yfl(yfh paramyfh) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.time - paramMessageRecord2.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yfl
 * JD-Core Version:    0.7.0.1
 */