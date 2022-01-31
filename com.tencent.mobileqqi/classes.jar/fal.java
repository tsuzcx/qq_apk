import com.tencent.mobileqq.activity.aio.anim.AioAnimationConfigHelper;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class fal
  implements Runnable
{
  public fal(ConfigHandler paramConfigHandler, String paramString, long paramLong) {}
  
  public void run()
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a.getApplication().getFilesDir(), "eggs_config.zip");
    int i = HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a, this.jdField_a_of_type_JavaLangString, localFile);
    if (QLog.isColorLevel()) {
      QLog.d("eggs", 2, "handleUpdateEggsActions download: " + i);
    }
    if (i == 0)
    {
      AioAnimationConfigHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a, this.jdField_a_of_type_Long, localFile.getAbsolutePath());
      return;
    }
    AioAnimationConfigHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fal
 * JD-Core Version:    0.7.0.1
 */