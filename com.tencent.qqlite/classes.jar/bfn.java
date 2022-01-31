import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class bfn
  implements Runnable
{
  public bfn(QQSettingMe paramQQSettingMe, String paramString) {}
  
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new bfo(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bfn
 * JD-Core Version:    0.7.0.1
 */