import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager.CallBack;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public class esy
  implements Runnable
{
  public esy(QvipSpecialSoundManager paramQvipSpecialSoundManager, QvipSpecialSoundManager.CallBack paramCallBack) {}
  
  public void run()
  {
    String str = QvipSpecialSoundManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(str);
    boolean bool = QvipSpecialSoundManager.a.containsKey("key_special_sound_list" + QvipSpecialSoundManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager).a());
    QvipSpecialSoundManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager, this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager$CallBack, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     esy
 * JD-Core Version:    0.7.0.1
 */