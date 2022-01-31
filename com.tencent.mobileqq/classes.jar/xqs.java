import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.process.CmGameUtil;

public class xqs
  implements Runnable
{
  public xqs(RecentOptPopBar paramRecentOptPopBar) {}
  
  public void run()
  {
    if (CmGameUtil.a() == null) {}
    ApolloManager localApolloManager;
    do
    {
      return;
      localApolloManager = (ApolloManager)CmGameUtil.a().getManager(152);
    } while ((localApolloManager == null) || (localApolloManager.h));
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xqs
 * JD-Core Version:    0.7.0.1
 */