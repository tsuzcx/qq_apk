import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class uee
  implements Runnable
{
  public uee(VipProfileCardDiyActivity paramVipProfileCardDiyActivity, File paramFile, String paramString) {}
  
  public void run()
  {
    DownloadTask localDownloadTask = new DownloadTask(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile);
    localDownloadTask.f = "profileCardDownload";
    localDownloadTask.e = "VIP_profilecard";
    int i = DownloaderFactory.a(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.app);
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.c(this.jdField_a_of_type_JavaLangString);
      return;
    }
    QLog.e("VipProfileCardDiyActivity", 1, "download card background failed. errorCode=" + i + ", url=" + this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uee
 * JD-Core Version:    0.7.0.1
 */