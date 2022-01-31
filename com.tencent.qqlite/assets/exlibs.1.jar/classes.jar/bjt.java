import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.SnapScreenActivity;
import com.tencent.mobileqq.app.ScreenShotDisableListener;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class bjt
  implements View.OnClickListener
{
  public bjt(SnapScreenActivity paramSnapScreenActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    if ((this.a.a instanceof ScreenShotDisableListener)) {
      ((ScreenShotDisableListener)this.a.a).a();
    }
    SettingCloneUtil.writeValue(this.a.a, null, this.a.getString(2131363054), "qqsetting_screenshot_key", false);
    Toast.makeText(this.a.a, 2131363188, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bjt
 * JD-Core Version:    0.7.0.1
 */