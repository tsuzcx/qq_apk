import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.voip.VoipHistoryActivity;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.widget.AdapterView.AdapterContextMenuInfo;

public class ewp
  implements MenuItem.OnMenuItemClickListener
{
  public ewp(VoipHistoryActivity paramVoipHistoryActivity) {}
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    this.a.b(((ViewGroup)VoipHistoryActivity.a(this.a).getChildAt(paramMenuItem.a)).getChildAt(0));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ewp
 * JD-Core Version:    0.7.0.1
 */