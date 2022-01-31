import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

public class fko
  implements Comparator
{
  public fko(RecentUserProxy paramRecentUserProxy) {}
  
  public int a(RecentUser paramRecentUser1, RecentUser paramRecentUser2)
  {
    long l1 = Math.max(paramRecentUser1.lastmsgtime, paramRecentUser1.lastmsgdrafttime);
    long l2 = Math.max(paramRecentUser2.lastmsgtime, paramRecentUser2.lastmsgdrafttime);
    if (l1 < l2) {
      return 1;
    }
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fko
 * JD-Core Version:    0.7.0.1
 */