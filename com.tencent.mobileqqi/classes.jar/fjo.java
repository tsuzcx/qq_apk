import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;

public class fjo
  implements Runnable
{
  public fjo(QQAppInterface paramQQAppInterface, String paramString, File paramFile) {}
  
  public void run()
  {
    File localFile;
    if (HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile))
    {
      localFile = new File(QQAppInterface.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getApplicationContext().getFilesDir(), this.jdField_a_of_type_JavaLangString);
      if (localFile == null) {
        break label64;
      }
    }
    label64:
    for (long l = localFile.length();; l = 0L)
    {
      QQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fjo
 * JD-Core Version:    0.7.0.1
 */