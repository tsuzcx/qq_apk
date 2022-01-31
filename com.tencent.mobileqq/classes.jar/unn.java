import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

public class unn
  implements Comparator
{
  public unn(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    long l2 = paramMessageRecord1.time - paramMessageRecord2.time;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = paramMessageRecord1.getId() - paramMessageRecord2.getId();
    }
    if (l1 > 0L) {
      return -1;
    }
    if (l1 < 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     unn
 * JD-Core Version:    0.7.0.1
 */