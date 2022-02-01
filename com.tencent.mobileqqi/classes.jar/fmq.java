import android.graphics.Bitmap;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.LebaConfig;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class fmq
  implements Runnable
{
  public fmq(LebaConfig paramLebaConfig, URL paramURL, File paramFile, String paramString) {}
  
  public void run()
  {
    try
    {
      if (!HttpDownloadUtil.a(LebaConfig.a(this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig), this.jdField_a_of_type_JavaNetURL, this.jdField_a_of_type_JavaIoFile)) {
        break label199;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.config", 2, "Download icon key = " + this.jdField_a_of_type_JavaLangString + "suc--------");
      }
      Bitmap localBitmap = LebaConfig.a(this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig, this.jdField_a_of_type_JavaIoFile);
      if (localBitmap != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.config", 2, "Download icon key = " + this.jdField_a_of_type_JavaLangString + "notify UI++++++++");
        }
        Iterator localIterator = LebaConfig.c(this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig).iterator();
        while (localIterator.hasNext()) {
          ((DownloadIconsListener)localIterator.next()).a(this.jdField_a_of_type_JavaLangString, localBitmap);
        }
      }
      LebaConfig.a(this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig, this.jdField_a_of_type_JavaLangString);
    }
    catch (Exception localException)
    {
      LebaConfig.a(this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig).remove(this.jdField_a_of_type_JavaLangString);
      LebaConfig.b(this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig, this.jdField_a_of_type_JavaLangString);
      return;
    }
    return;
    label199:
    LebaConfig.a(this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig).remove(this.jdField_a_of_type_JavaLangString);
    LebaConfig.b(this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fmq
 * JD-Core Version:    0.7.0.1
 */