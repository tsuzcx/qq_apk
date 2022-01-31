import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;

public class zhm
  implements Runnable
{
  public zhm(QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void run()
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.g();
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h()) && (bool2) && (!bool1) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.k()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.l()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m()) && (QQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      Object localObject = SkinEngine.getInstances().getSkinRootPath();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new StringBuilder((String)localObject);
        ((StringBuilder)localObject).append(File.separatorChar).append("voice").append(File.separatorChar).append("tab").append(this.jdField_a_of_type_Int).append(".mp3");
        File localFile = new File(((StringBuilder)localObject).toString());
        if (QLog.isColorLevel()) {
          QLog.d("playThemeVoice", 2, "Uri:" + ((StringBuilder)localObject).toString());
        }
        if (localFile.exists()) {
          AudioUtil.a(Uri.fromFile(localFile), false, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhm
 * JD-Core Version:    0.7.0.1
 */