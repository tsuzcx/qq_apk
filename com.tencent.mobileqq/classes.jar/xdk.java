import android.support.v4.view.ViewPager;
import android.view.View;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class xdk
  implements Runnable
{
  public xdk(CommonHbFragment paramCommonHbFragment) {}
  
  public void run()
  {
    if ((CommonHbFragment.b(this.a) == null) || (CommonHbFragment.b(this.a).size() <= 0)) {}
    View localView;
    do
    {
      do
      {
        return;
        localView = ((View)CommonHbFragment.b(this.a).get(CommonHbFragment.a(this.a).getCurrentItem())).findViewById(2131368025);
        if (localView != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("CommonHbFragment", 2, "tempView is null");
      return;
    } while ((localView.getVisibility() != 0) || (!"1".equals(CommonHbFragment.g(this.a))));
    if (QLog.isColorLevel()) {
      QLog.i("CommonHbFragment", 2, "start perform click sub type");
    }
    localView.performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdk
 * JD-Core Version:    0.7.0.1
 */