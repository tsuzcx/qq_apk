import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

public class aha
  implements Comparator
{
  public aha(Conversation paramConversation) {}
  
  public int a(RecentBaseData paramRecentBaseData1, RecentBaseData paramRecentBaseData2)
  {
    if (((paramRecentBaseData1 instanceof RecentUserBaseData)) && ((paramRecentBaseData2 instanceof RecentUserBaseData)))
    {
      paramRecentBaseData1 = (RecentUserBaseData)paramRecentBaseData1;
      paramRecentBaseData2 = (RecentUserBaseData)paramRecentBaseData2;
      if ((paramRecentBaseData1.a.showUpTime > 0L) || (paramRecentBaseData2.a.showUpTime > 0L)) {
        return Conversation.a(this.a, paramRecentBaseData1.a, paramRecentBaseData2.a);
      }
      return Conversation.b(this.a, paramRecentBaseData1.a, paramRecentBaseData2.a);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     aha
 * JD-Core Version:    0.7.0.1
 */