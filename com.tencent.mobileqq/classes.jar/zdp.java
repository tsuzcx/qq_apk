import android.os.Handler;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class zdp
  implements Runnable
{
  public zdp(FrameHelperActivity paramFrameHelperActivity, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a.removeMessages(15);
    ThemeBackground localThemeBackground = ThemeBackground.getThemeBgObj(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext(), 1, "setting");
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a.sendMessage(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a.obtainMessage(15, localThemeBackground));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zdp
 * JD-Core Version:    0.7.0.1
 */