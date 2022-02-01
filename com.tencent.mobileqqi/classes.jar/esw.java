import android.content.Context;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import java.io.File;

public class esw
  implements Runnable
{
  public esw(QvipSpecialSoundManager paramQvipSpecialSoundManager, esv paramesv) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(this.jdField_a_of_type_Esv.c))
    {
      File localFile = new File(QvipSpecialSoundManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager).getFilesDir(), this.jdField_a_of_type_Esv.c);
      if (localFile != null) {}
      for (long l = localFile.length();; l = 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(l);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.b("updateSpecialSound down fial, id=" + this.jdField_a_of_type_Esv.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     esw
 * JD-Core Version:    0.7.0.1
 */