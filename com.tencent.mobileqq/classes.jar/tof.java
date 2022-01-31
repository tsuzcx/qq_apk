import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.qphone.base.util.QLog;

public class tof
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString;
  
  private tof(QQLSActivity paramQQLSActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QQLSActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity)) {}
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_JavaLangString = paramIntent.getAction();
          if (!"android.intent.action.SCREEN_ON".equals(this.jdField_a_of_type_JavaLangString)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QQLSActivity", 2, "ScreenBroadcastReceiver ACTION_SCREEN_ON");
        return;
        if (!"android.intent.action.SCREEN_OFF".equals(this.jdField_a_of_type_JavaLangString)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQLSActivity", 2, "ScreenBroadcastReceiver ACTION_SCREEN_OFF");
      return;
    } while (!"android.intent.action.USER_PRESENT".equals(this.jdField_a_of_type_JavaLangString));
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder().append("ScreenBroadcastReceiver ACTION_USER_PRESENTmanager.isEnterAio");
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a;
      QLog.d("QQLSActivity", 2, QQLSRecentManager.f);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a;
    if (!QQLSRecentManager.f) {
      QQLSActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tof
 * JD-Core Version:    0.7.0.1
 */