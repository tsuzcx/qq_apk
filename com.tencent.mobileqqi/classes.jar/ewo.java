import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mobileqq.activity.voip.VoipHistoryActivity;
import com.tencent.mobileqq.activity.voip.VoipHistoryAllType;
import com.tencent.mobileqq.activity.voip.VoipHistoryInterface;
import com.tencent.mobileqq.data.voip.VoipHistoryData;
import com.tencent.widget.AdapterView.AdapterContextMenuInfo;
import java.util.ArrayList;

public class ewo
  implements MenuItem.OnMenuItemClickListener
{
  public ewo(VoipHistoryActivity paramVoipHistoryActivity) {}
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    paramMenuItem = (VoipHistoryAllType)VoipHistoryActivity.a(this.a).get(paramMenuItem.a);
    VoipHistoryActivity.a(this.a).a((VoipHistoryData)paramMenuItem.obj);
    this.a.doOnResume();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ewo
 * JD-Core Version:    0.7.0.1
 */