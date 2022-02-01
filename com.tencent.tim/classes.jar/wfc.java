import android.text.TextUtils;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity.a;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity.c;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import java.util.ArrayList;
import java.util.Iterator;

public class wfc
  extends accn
{
  public wfc(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramObject != null) && (!TextUtils.isEmpty(paramObject.uin)))
      {
        Iterator localIterator = this.a.pU.iterator();
        UncommonlyUsedContactsActivity.c localc;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localc = (UncommonlyUsedContactsActivity.c)localIterator.next();
        } while ((localc.b == null) || (!(localc.b instanceof Friends)) || (!paramObject.uin.equals(((Friends)localc.b).uin)));
      }
      for (int i = 1; i != 0; i = 0)
      {
        UncommonlyUsedContactsActivity.a(this.a);
        this.a.a.notifyDataSetChanged();
        return;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wfc
 * JD-Core Version:    0.7.0.1
 */