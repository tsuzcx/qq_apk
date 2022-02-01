import com.tencent.mobileqq.app.message.BaseMessageProcessorForTroopAndDisc;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

public class fiw
  implements Comparator
{
  public fiw(BaseMessageProcessorForTroopAndDisc paramBaseMessageProcessorForTroopAndDisc) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)((paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq) % 2L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fiw
 * JD-Core Version:    0.7.0.1
 */