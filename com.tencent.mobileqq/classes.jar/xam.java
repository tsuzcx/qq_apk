import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class xam
  implements ThreadExcutor.IThreadListener
{
  public xam(PreloadImgManager paramPreloadImgManager, List paramList, Map paramMap, Bundle paramBundle) {}
  
  public void a() {}
  
  public void b()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      DownloadTask localDownloadTask = new DownloadTask(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilMap, UUID.randomUUID().toString());
      localDownloadTask.a(this.jdField_a_of_type_AndroidOsBundle);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager.a.a(localDownloadTask, PreloadImgManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager), null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xam
 * JD-Core Version:    0.7.0.1
 */