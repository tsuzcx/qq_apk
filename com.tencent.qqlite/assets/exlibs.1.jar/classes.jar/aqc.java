import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity;
import com.tencent.mobileqq.activity.GesturePWDSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;

public class aqc
  implements View.OnClickListener
{
  public aqc(GesturePWDSettingActivity paramGesturePWDSettingActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131297162: 
    case 2131297163: 
    default: 
      return;
    case 2131297161: 
      GesturePWDUtils.setGesturePWDMode(this.a, this.a.app.a(), 21);
      this.a.a();
      return;
    }
    paramView = new Intent(this.a, GesturePWDCreateActivity.class);
    this.a.startActivityForResult(paramView, 11);
    this.a.overridePendingTransition(2130968592, 2130968589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aqc
 * JD-Core Version:    0.7.0.1
 */