import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.JumpFilterHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class cqy
  implements Runnable
{
  public cqy(ConfigHandler paramConfigHandler, String paramString, long paramLong) {}
  
  public void run()
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a.getApplication().getFilesDir(), "qq_safe_jump_whitelist.zip");
    String str = MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString);
    int i = HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a, str, localFile);
    if (QLog.isColorLevel()) {
      QLog.d("JumpWhiteList", 2, "handleJumpWhiteList download: " + i);
    }
    if (i == 0)
    {
      JumpFilterHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a, this.jdField_a_of_type_Long, localFile.getAbsolutePath());
      return;
    }
    JumpFilterHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cqy
 * JD-Core Version:    0.7.0.1
 */