import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class tof
  implements Comparator<MessageRecord>
{
  tof(tob paramtob) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord2.time - paramMessageRecord1.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tof
 * JD-Core Version:    0.7.0.1
 */