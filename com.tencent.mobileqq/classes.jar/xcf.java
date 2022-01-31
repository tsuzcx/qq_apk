import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;

public class xcf
  implements Runnable
{
  public xcf(PreloadComDownloader paramPreloadComDownloader, String paramString1, String paramString2, DownloadListener paramDownloadListener, Bundle paramBundle) {}
  
  public void run()
  {
    DownloadTask localDownloadTask = new DownloadTask(this.jdField_a_of_type_JavaLangString, new File(this.b));
    localDownloadTask.f = "QwalletPreload";
    if (PreloadComDownloader.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadComDownloader) != null) {
      PreloadComDownloader.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadComDownloader).a(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xcf
 * JD-Core Version:    0.7.0.1
 */