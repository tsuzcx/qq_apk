import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopMessageProcessor;
import java.util.Comparator;

public class enq
  implements Comparator
{
  public enq(TroopMessageProcessor paramTroopMessageProcessor) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)((paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq) % 2L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     enq
 * JD-Core Version:    0.7.0.1
 */