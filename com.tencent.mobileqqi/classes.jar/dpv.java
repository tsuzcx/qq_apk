import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class dpv
  implements Runnable
{
  public dpv(SplashActivity paramSplashActivity, int paramInt) {}
  
  public void run()
  {
    if ((SplashActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity) != null) && (SplashActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity).getBoolean("theme_voice_setting_" + this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a(), true))) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.b(this.jdField_a_of_type_Int + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dpv
 * JD-Core Version:    0.7.0.1
 */