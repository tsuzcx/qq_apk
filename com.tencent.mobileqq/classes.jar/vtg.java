import com.tencent.biz.qqstory.takevideo.shareto.ShareToActivity;
import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

public class vtg
  implements Comparator<RecentUser>
{
  public vtg(ShareToActivity paramShareToActivity) {}
  
  public int a(RecentUser paramRecentUser1, RecentUser paramRecentUser2)
  {
    if (paramRecentUser1.lastmsgtime > paramRecentUser2.lastmsgtime) {
      return -1;
    }
    if (paramRecentUser1.lastmsgtime < paramRecentUser2.lastmsgtime) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vtg
 * JD-Core Version:    0.7.0.1
 */