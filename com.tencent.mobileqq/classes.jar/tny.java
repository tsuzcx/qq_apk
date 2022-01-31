import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.Comparator;

public class tny
  implements Comparator
{
  public tny(QQLSActivity paramQQLSActivity) {}
  
  public int a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if (paramChatMessage1.shmsgseq == paramChatMessage2.shmsgseq) {
      return 0;
    }
    if (paramChatMessage1.shmsgseq > paramChatMessage2.shmsgseq) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tny
 * JD-Core Version:    0.7.0.1
 */