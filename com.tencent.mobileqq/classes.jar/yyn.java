import com.tencent.mobileqq.activity.weather.WeatherManager;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class yyn
  implements Runnable
{
  public yyn(ConfigHandler paramConfigHandler, String paramString, WeatherManager paramWeatherManager, long paramLong) {}
  
  public void run()
  {
    boolean bool = false;
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b.getApplication().getFilesDir(), "WeatherResource.zip");
    String str = MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString);
    int i = HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b, str, localFile);
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "handleWeatherResources download: " + i + ",downloadpath" + localFile.getAbsolutePath());
    }
    if (i == 0) {
      bool = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager.a(this.jdField_a_of_type_Long, localFile.getAbsolutePath());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a(9, bool, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     yyn
 * JD-Core Version:    0.7.0.1
 */