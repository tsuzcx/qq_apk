import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;

public class cpd
  implements View.OnClickListener
{
  public cpd(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.c();
    GesturePWDUtils.setGestureUnlockFailedType(this.a, 0);
    StatisticCollector.a(this.a.getBaseContext()).a(this.a.b, this.a.b.a(), "Gesture_pwd", "click_forgive", 0, 1, "0", null, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cpd
 * JD-Core Version:    0.7.0.1
 */