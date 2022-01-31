import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

public final class zqf
  implements Comparator
{
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zqf
 * JD-Core Version:    0.7.0.1
 */