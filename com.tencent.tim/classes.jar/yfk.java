import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class yfk
  implements Comparator<MessageRecord>
{
  yfk(yfh paramyfh) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yfk
 * JD-Core Version:    0.7.0.1
 */