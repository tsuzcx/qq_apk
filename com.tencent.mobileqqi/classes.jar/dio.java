import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.SnapScreenActivity;
import com.tencent.mobileqq.app.ScreenShotDisableListener;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class dio
  implements View.OnClickListener
{
  public dio(SnapScreenActivity paramSnapScreenActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    if ((this.a.a instanceof ScreenShotDisableListener)) {
      ((ScreenShotDisableListener)this.a.a).a();
    }
    SettingCloneUtil.writeValue(this.a.a, null, this.a.getString(2131563437), "qqsetting_screenshot_key", false);
    Toast.makeText(this.a.a, 2131562818, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dio
 * JD-Core Version:    0.7.0.1
 */