import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;
import java.net.URL;

public class zbz
  implements Runnable
{
  public zbz(ConfigHandler paramConfigHandler, String paramString, File paramFile) {}
  
  public void run()
  {
    try
    {
      HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b, new URL(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_JavaIoFile);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zbz
 * JD-Core Version:    0.7.0.1
 */