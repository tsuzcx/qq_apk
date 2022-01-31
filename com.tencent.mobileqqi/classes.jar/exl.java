import android.content.Context;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import java.io.File;

public class exl
  implements Runnable
{
  public exl(QvipSpecialSoundManager paramQvipSpecialSoundManager, exk paramexk) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(this.jdField_a_of_type_Exk.c))
    {
      File localFile = new File(QvipSpecialSoundManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager).getFilesDir(), this.jdField_a_of_type_Exk.c);
      if (localFile != null) {}
      for (long l = localFile.length();; l = 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(l);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.b("updateSpecialSound down fial, id=" + this.jdField_a_of_type_Exk.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     exl
 * JD-Core Version:    0.7.0.1
 */