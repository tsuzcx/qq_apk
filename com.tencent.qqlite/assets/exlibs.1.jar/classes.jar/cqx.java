import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;
import java.net.URL;

public class cqx
  implements Runnable
{
  public cqx(ConfigHandler paramConfigHandler, String paramString, File paramFile) {}
  
  public void run()
  {
    try
    {
      HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a, new URL(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_JavaIoFile);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cqx
 * JD-Core Version:    0.7.0.1
 */