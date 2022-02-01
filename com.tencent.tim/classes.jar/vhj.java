import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.widget.QQTabWidget.a;
import com.tencent.qphone.base.util.QLog;

public class vhj
  implements QQTabWidget.a
{
  public vhj(MainFragment paramMainFragment) {}
  
  public void bRJ()
  {
    int i = GesturePWDUtils.getGesturePWDState(MainFragment.a(this.this$0).getApp(), MainFragment.a(this.this$0).getCurrentAccountUin());
    int j = GesturePWDUtils.getGesturePWDMode(MainFragment.a(this.this$0).getApp(), MainFragment.a(this.this$0).getCurrentAccountUin());
    if ((i == 2) && (j == 20))
    {
      if (QLog.isColorLevel()) {
        QLog.d("mainactivity", 2, "gesturepwd manual move.");
      }
      ((SplashActivity)this.this$0.getActivity()).startUnlockActivity();
      this.this$0.getActivity().overridePendingTransition(2130772009, 2130772002);
      MainFragment.al(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vhj
 * JD-Core Version:    0.7.0.1
 */