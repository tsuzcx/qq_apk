import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class zct
  implements Runnable
{
  public zct(LebaHelper paramLebaHelper, URL paramURL, File paramFile, String paramString) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaNetURL, this.jdField_a_of_type_JavaIoFile))
        {
          if (QLog.isColorLevel()) {
            QLog.d("LebaHelper", 2, "Download icon key = " + this.jdField_a_of_type_JavaLangString + "suc--------");
          }
          Object localObject1 = null;
          if (BaseApplicationImpl.sImageCache != null)
          {
            localObject1 = "LebaIcon://" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath();
            localObject1 = (Bitmap)BaseApplicationImpl.sImageCache.get(localObject1);
          }
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder().append("get Bitmap from cache, result=");
            if (localObject1 == null) {
              break label349;
            }
            bool = true;
            QLog.d("LebaHelper", 2, bool);
          }
          if (localObject1 != null) {
            break label346;
          }
          localObject1 = LebaHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper, this.jdField_a_of_type_JavaIoFile);
          if (localObject1 != null) {
            if (QLog.isColorLevel()) {
              QLog.d("LebaHelper", 2, "Download icon key = " + this.jdField_a_of_type_JavaLangString + "notify UI++++++++");
            }
          }
          synchronized (this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.d)
          {
            if (i < this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.d.size())
            {
              ((DownloadIconsListener)this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.d.get(i)).a(this.jdField_a_of_type_JavaLangString, (Bitmap)localObject1);
              i += 1;
              continue;
            }
            LebaHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper, this.jdField_a_of_type_JavaLangString);
            return;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.jdField_a_of_type_JavaUtilSet.remove(this.jdField_a_of_type_JavaLangString);
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.jdField_a_of_type_JavaUtilSet.remove(this.jdField_a_of_type_JavaLangString);
        LebaHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper, this.jdField_a_of_type_JavaLangString);
        return;
      }
      LebaHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper, this.jdField_a_of_type_JavaLangString);
      return;
      label346:
      continue;
      label349:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zct
 * JD-Core Version:    0.7.0.1
 */