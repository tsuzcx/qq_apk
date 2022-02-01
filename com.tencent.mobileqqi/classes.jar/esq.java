import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import java.io.File;
import java.util.HashMap;

public class esq
  implements Runnable
{
  public esq(QvipSpecialSoundActivity paramQvipSpecialSoundActivity, String paramString, File paramFile) {}
  
  public void run()
  {
    boolean bool = QvipSpecialSoundActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity).a(this.jdField_a_of_type_JavaLangString);
    Object localObject;
    if (QvipSpecialSoundActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity) != null)
    {
      localObject = Message.obtain(QvipSpecialSoundActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity), 0);
      ((Message)localObject).obj = Boolean.valueOf(bool);
      QvipSpecialSoundActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity).sendMessage((Message)localObject);
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
      localObject = new File(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity.getFilesDir(), this.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        break label136;
      }
    }
    label136:
    for (long l = ((File)localObject).length();; l = 0L)
    {
      QvipSpecialSoundActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity).a(l);
      QvipSpecialSoundActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity).remove(this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     esq
 * JD-Core Version:    0.7.0.1
 */