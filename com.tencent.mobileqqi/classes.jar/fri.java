import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class fri
  extends Thread
{
  public fri(ConfigServlet paramConfigServlet, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void run()
  {
    if (HttpDownloadUtil.a((AppInterface)this.jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet.getAppRuntime(), this.jdField_a_of_type_JavaLangString, new File(this.jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet.getAppRuntime().getApplication().getFilesDir().getAbsolutePath() + "/" + "flashlogo.png"))) {
      SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet.getAppRuntime().getApplication(), this.jdField_a_of_type_Int, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fri
 * JD-Core Version:    0.7.0.1
 */