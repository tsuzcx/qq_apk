import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.search.ContactSearchableFriend;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class clf
  extends SearchResultDialog
{
  public clf(ForwardFriendListActivity paramForwardFriendListActivity, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, ForwardOperations paramForwardOperations)
  {
    super(paramContext, paramQQAppInterface, paramInt, paramForwardOperations);
  }
  
  @SuppressLint({"UseSparseArrays"})
  protected List a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = ForwardFriendListActivity.a(this.a).a();
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ArrayList)localHashMap.get((Integer)localIterator.next());
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Friends localFriends = (Friends)((Iterator)localObject).next();
          localArrayList.add(new ContactSearchableFriend(paramContext, paramQQAppInterface, localFriends, ForwardFriendListActivity.a(this.a).a(localFriends.groupid), 0L, 42949672960L));
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     clf
 * JD-Core Version:    0.7.0.1
 */