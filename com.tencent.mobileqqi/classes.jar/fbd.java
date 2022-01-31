import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mobileqq.activity.voip.VoipHistoryActivity;
import com.tencent.mobileqq.activity.voip.VoipHistoryAllType;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.widget.AdapterView.AdapterContextMenuInfo;
import java.util.ArrayList;

public class fbd
  implements MenuItem.OnMenuItemClickListener
{
  public fbd(VoipHistoryActivity paramVoipHistoryActivity) {}
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    paramMenuItem = (VoipHistoryAllType)VoipHistoryActivity.a(this.a).get(paramMenuItem.a);
    QCallFacade localQCallFacade = (QCallFacade)this.a.b.getManager(36);
    if (localQCallFacade != null) {
      localQCallFacade.a(((QCallRecent)paramMenuItem.obj).uin, ((QCallRecent)paramMenuItem.obj).type);
    }
    this.a.doOnResume();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fbd
 * JD-Core Version:    0.7.0.1
 */