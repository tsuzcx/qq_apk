import android.os.Bundle;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class dpw
  implements Runnable
{
  public dpw(UniformDownloadMgr paramUniformDownloadMgr, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    long l = 0L;
    for (;;)
    {
      try
      {
        localURL = new URL(this.jdField_a_of_type_JavaLangString);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        URL localURL;
        int i;
        localMalformedURLException.printStackTrace();
        continue;
      }
      try
      {
        i = localURL.openConnection().getContentLength();
        l = i;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    this.jdField_a_of_type_AndroidOsBundle.putLong("_filesize_from_dlg", l);
    UniformDownloadMgr.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    UniformDownloadMgr.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dpw
 * JD-Core Version:    0.7.0.1
 */