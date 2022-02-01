import com.tencent.mobileqq.search.searchengine.OnlineFileSearchEngine;
import com.tencent.tim.teamwork.PadInfo;
import java.util.Comparator;

public class amwn
  implements Comparator<amqx>
{
  public amwn(OnlineFileSearchEngine paramOnlineFileSearchEngine) {}
  
  public int a(amqx paramamqx1, amqx paramamqx2)
  {
    long l1 = Math.max(paramamqx1.a.lastEditTime, paramamqx1.a.currentUserBrowseTime);
    long l2 = Math.max(paramamqx2.a.lastEditTime, paramamqx2.a.currentUserBrowseTime);
    if (l1 - l2 > 0L) {
      return -1;
    }
    if (l1 - l2 < 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amwn
 * JD-Core Version:    0.7.0.1
 */