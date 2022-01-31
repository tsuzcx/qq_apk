import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ant
  extends SearchResultDialog
{
  public ant(ForwardRecentActivity paramForwardRecentActivity, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, ForwardOperations paramForwardOperations)
  {
    super(paramContext, paramQQAppInterface, paramInt, paramForwardOperations);
  }
  
  @SuppressLint({"UseSparseArrays"})
  protected List a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (ForwardRecentActivity.a(this.a) != null)
    {
      Iterator localIterator = ForwardRecentActivity.a(this.a).iterator();
      if (localIterator.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)localIterator.next();
        long l = 0L;
        switch (localRecentUser.type)
        {
        }
        for (;;)
        {
          localArrayList.add(new ContactsSearchableRecentUser(paramContext, paramQQAppInterface, localRecentUser, l, a()));
          break;
          l = 38654705664L;
          continue;
          l = 12884901888L;
          continue;
          l = 21474836480L;
          continue;
          l = 21474836480L;
        }
      }
    }
    if ((FriendManager)paramQQAppInterface.getManager(8) == null) {
      return localArrayList;
    }
    if (ForwardRecentActivity.a(this.a)) {
      localArrayList.addAll(a(paramContext, paramQQAppInterface, 34359738368L, paramInt, false, null));
    }
    if (ForwardRecentActivity.b(this.a)) {
      localArrayList.addAll(a(paramContext, paramQQAppInterface, 30064771072L));
    }
    if (ForwardRecentActivity.c(this.a)) {
      localArrayList.addAll(a(paramContext, paramQQAppInterface, 25769803776L, paramInt, null, a()));
    }
    if (ForwardRecentActivity.d(this.a)) {
      localArrayList.addAll(b(paramContext, paramQQAppInterface, 17179869184L, paramInt));
    }
    if (ForwardRecentActivity.e(this.a)) {
      localArrayList.addAll(a(paramContext, paramQQAppInterface, 17179869184L, paramInt));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ant
 * JD-Core Version:    0.7.0.1
 */