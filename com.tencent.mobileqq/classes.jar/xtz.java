import android.os.Handler;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class xtz
  implements Runnable
{
  public xtz(EditLocalVideoActivity paramEditLocalVideoActivity, String paramString) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_JavaLangString.lastIndexOf("/") + 1, this.jdField_a_of_type_JavaLangString.lastIndexOf("?"));
    if ((new File(EditLocalVideoActivity.b() + str).exists()) && (str != null) && (str.toLowerCase().endsWith(".m4a")))
    {
      EditLocalVideoActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity, EditLocalVideoActivity.b() + str);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity.a.postDelayed(new xua(this), 500L);
      QLog.d("EditLocalVideoActivity", 2, "music exist------：" + str);
      return;
    }
    Object localObject = new xub(this);
    if ((str != null) && (str.toLowerCase().endsWith(".m4a")))
    {
      localObject = new DownloadRequest(this.jdField_a_of_type_JavaLangString, new String[] { EditLocalVideoActivity.b() + str }, false, (Downloader.DownloadListener)localObject);
      ((DownloadRequest)localObject).mode = Downloader.DownloadMode.FastMode;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity.a.post(new xuf(this));
      DownloaderFactory.getInstance(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity.getBaseContext()).getCommonDownloader().download((DownloadRequest)localObject, false);
      EditLocalVideoActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity, EditLocalVideoActivity.b() + str);
      return;
    }
    QLog.d("EditLocalVideoActivity", 2, "error musicUrl=" + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xtz
 * JD-Core Version:    0.7.0.1
 */