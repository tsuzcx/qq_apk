import android.text.TextUtils;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity.ListItem;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import java.util.ArrayList;
import java.util.Iterator;

public class ukf
  extends CardObserver
{
  public ukf(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramObject != null) && (!TextUtils.isEmpty(paramObject.uin)))
      {
        Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        UncommonlyUsedContactsActivity.ListItem localListItem;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localListItem = (UncommonlyUsedContactsActivity.ListItem)localIterator.next();
        } while ((localListItem.a == null) || (!(localListItem.a instanceof Friends)) || (!paramObject.uin.equals(((Friends)localListItem.a).uin)));
      }
      for (int i = 1; i != 0; i = 0)
      {
        UncommonlyUsedContactsActivity.a(this.a);
        this.a.jdField_a_of_type_Ukj.notifyDataSetChanged();
        return;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ukf
 * JD-Core Version:    0.7.0.1
 */