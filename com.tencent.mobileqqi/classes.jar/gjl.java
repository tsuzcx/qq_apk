import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantActivity;
import java.util.Comparator;

public class gjl
  implements Comparator
{
  public gjl(QZoneShareAlbumAssistantActivity paramQZoneShareAlbumAssistantActivity) {}
  
  public int a(RecentBaseData paramRecentBaseData1, RecentBaseData paramRecentBaseData2)
  {
    long l1 = paramRecentBaseData1.a();
    long l2 = paramRecentBaseData2.a();
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
 * Qualified Name:     gjl
 * JD-Core Version:    0.7.0.1
 */