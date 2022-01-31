import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.widget.PopupMenuDialog.OnDismissListener;

public class xre
  implements PopupMenuDialog.OnDismissListener
{
  public xre(RecentOptPopBar paramRecentOptPopBar) {}
  
  public void a()
  {
    this.a.g();
    if (RecentOptPopBar.a(this.a) != null)
    {
      RecentOptPopBar.a(this.a).getLayoutParams().height = ((int)(126.0F * DeviceInfoUtil.a));
      RecentOptPopBar.a(this.a).requestLayout();
    }
    if (CmGameUtil.a() == null) {}
    ApolloManager localApolloManager;
    do
    {
      do
      {
        return;
        localApolloManager = (ApolloManager)CmGameUtil.a().getManager(152);
      } while ((localApolloManager == null) || (localApolloManager.b() != 3) || (localApolloManager.h));
      CmGameUtil.b(3);
    } while (localApolloManager == null);
    localApolloManager.h = true;
    this.a.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xre
 * JD-Core Version:    0.7.0.1
 */