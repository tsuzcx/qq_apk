import android.content.Context;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.contact.troop.TroopView;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.ContactSearchableTroop;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class egr
  extends SearchResultDialog
{
  public egr(TroopView paramTroopView, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, ForwardOperations paramForwardOperations)
  {
    super(paramContext, paramQQAppInterface, paramInt, paramForwardOperations);
  }
  
  protected List a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject = this.a.a.a();
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(new ContactSearchableTroop(paramContext, paramQQAppInterface, (TroopInfo)((Iterator)localObject).next(), 0L, 0L));
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     egr
 * JD-Core Version:    0.7.0.1
 */