import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GesturePWDSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.ReportController;

public class coy
  implements CompoundButton.OnCheckedChangeListener
{
  public coy(GesturePWDSettingActivity paramGesturePWDSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    GesturePWDUtils.setGesturePWDMode(this.a, this.a.b.a(), 21);
    paramCompoundButton = this.a;
    String str = this.a.b.a();
    if (paramBoolean)
    {
      i = 2;
      GesturePWDUtils.setGesturePWDState(paramCompoundButton, str, i);
      this.a.a(paramBoolean);
      paramCompoundButton = this.a.b;
      if (!paramBoolean) {
        break label112;
      }
    }
    label112:
    for (int i = j;; i = 0)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Setting_Gesture_password", 0, i, "", "", "", "");
      this.a.a();
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     coy
 * JD-Core Version:    0.7.0.1
 */