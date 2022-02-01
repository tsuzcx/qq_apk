import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class acqx
  implements Comparator<MessageRecord>
{
  acqx(acqw paramacqw) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)((paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq) % 2L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acqx
 * JD-Core Version:    0.7.0.1
 */