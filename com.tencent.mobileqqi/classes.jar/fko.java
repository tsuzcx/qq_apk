import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class fko
  implements Runnable
{
  public fko(RecentUserProxy paramRecentUserProxy, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentUserProxy", 2, "checkNewFriendUpgrade | start");
    }
    Object localObject1 = null;
    for (;;)
    {
      int i;
      synchronized (RecentUserProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy))
      {
        Iterator localIterator = RecentUserProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy).iterator();
        if (localIterator.hasNext())
        {
          RecentUser localRecentUser = (RecentUser)localIterator.next();
          if ((localRecentUser != null) && (AppConstants.R.equals(localRecentUser.uin))) {
            localObject1 = localRecentUser;
          }
        }
        else if (localObject1 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy.b((RecentUser)localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fko
 * JD-Core Version:    0.7.0.1
 */