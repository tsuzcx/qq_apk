import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager.CallBack;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class exd
  implements QvipSpecialSoundManager.CallBack
{
  public exd(QvipSpecialSoundActivity paramQvipSpecialSoundActivity, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity.a = ((List)QvipSpecialSoundManager.a.get(this.jdField_a_of_type_JavaLangString));
        QvipSpecialSoundActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        QvipSpecialSoundActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity);
      }
      if (QLog.isColorLevel()) {
        QLog.i("SpecialSoundActivity", 2, "special sound cofing is empty.");
      }
      QvipSpecialSoundActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity.getString(2131562063));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     exd
 * JD-Core Version:    0.7.0.1
 */