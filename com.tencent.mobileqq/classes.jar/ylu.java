import android.content.Context;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import java.io.File;

public class ylu
  implements Runnable
{
  public ylu(QvipSpecialSoundManager paramQvipSpecialSoundManager, yls paramyls) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(this.jdField_a_of_type_Yls.c))
    {
      File localFile = new File(QvipSpecialSoundManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager).getFilesDir(), this.jdField_a_of_type_Yls.c);
      if (localFile.exists()) {}
      for (long l = localFile.length();; l = 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(l);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.b("updateSpecialSound down fial, id=" + this.jdField_a_of_type_Yls.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ylu
 * JD-Core Version:    0.7.0.1
 */