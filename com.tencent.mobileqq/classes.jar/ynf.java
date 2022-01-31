import com.tencent.mobileqq.activity.aio.HotReactiveHelper;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.HashSet;

public class ynf
  implements Runnable
{
  public ynf(BuddyListAdapter paramBuddyListAdapter) {}
  
  public void run()
  {
    if ((FriendsManager)BuddyListAdapter.a(this.a).getManager(50) != null)
    {
      HashSet localHashSet = HotReactiveHelper.a();
      if ((localHashSet != null) && (localHashSet.size() > 0))
      {
        ArrayList localArrayList = new ArrayList(localHashSet);
        BuddyListAdapter.a(this.a).b(localArrayList);
        localHashSet.clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ynf
 * JD-Core Version:    0.7.0.1
 */