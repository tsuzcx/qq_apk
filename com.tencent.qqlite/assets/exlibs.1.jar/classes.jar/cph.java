import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.OnTroopListClickListener;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItem;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListViewItemTag;

public class cph
  implements View.OnClickListener
{
  public cph(TroopListAdapter2 paramTroopListAdapter2) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof TroopListAdapter2.TroopListViewItemTag)) {}
    do
    {
      return;
      paramView = (TroopListAdapter2.TroopListViewItemTag)paramView;
    } while ((paramView.a == null) || (paramView.a.a == null));
    this.a.a.a(paramView.a.a, paramView.a.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cph
 * JD-Core Version:    0.7.0.1
 */