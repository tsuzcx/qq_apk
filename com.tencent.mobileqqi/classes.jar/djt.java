import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.widget.QQTabWidget.onTabWidgetTouchMoveListener;
import com.tencent.qphone.base.util.QLog;

public class djt
  implements QQTabWidget.onTabWidgetTouchMoveListener
{
  public djt(SplashActivity paramSplashActivity) {}
  
  public void a()
  {
    int i = GesturePWDUtils.getGesturePWDState(this.a, this.a.b.a());
    int j = GesturePWDUtils.getGesturePWDMode(this.a, this.a.b.a());
    if ((i == 2) && (j == 20))
    {
      if (QLog.isColorLevel()) {
        QLog.d("mainactivity", 2, "gesturepwd manual move.");
      }
      SplashActivity.c(this.a);
      this.a.overridePendingTransition(2130968598, 2130968595);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     djt
 * JD-Core Version:    0.7.0.1
 */