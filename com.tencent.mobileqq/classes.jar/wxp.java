import android.os.Handler;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class wxp
  extends DownloadListener
{
  public wxp(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "download onDone status=" + paramDownloadTask.a() + ",errCode=" + paramDownloadTask.jdField_a_of_type_Int);
    }
    int i = paramDownloadTask.jdField_a_of_type_JavaLangString.indexOf("?");
    String str;
    if (i == -1)
    {
      str = paramDownloadTask.jdField_a_of_type_JavaLangString;
      if (!AvatarPendantUtil.jdField_a_of_type_JavaLangString.equals(str)) {
        break label290;
      }
      if ((paramDownloadTask.jdField_a_of_type_Int != 0) || (paramDownloadTask.e != 200)) {
        break label237;
      }
      str = AvatarPendantUtil.b + "/icon.zip";
      localFile = new File(AvatarPendantUtil.c);
      if (DownloaderFactory.a(new File(str), localFile, false)) {
        break label215;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "unzip avatarPendantMarketIcon fail: " + paramDownloadTask.e + ", url: " + paramDownloadTask.jdField_a_of_type_JavaLangString);
      }
      FileUtils.a(AvatarPendantUtil.b);
    }
    label215:
    label237:
    while (!QLog.isColorLevel())
    {
      File localFile;
      return;
      str = paramDownloadTask.jdField_a_of_type_JavaLangString.substring(0, i);
      break;
      AvatarPendantActivity.b(this.a);
      this.a.a.sendEmptyMessage(1000);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "download avatarPendantMarketIcon fail: " + paramDownloadTask.e + ", url: " + paramDownloadTask.jdField_a_of_type_JavaLangString);
      }
      FileUtils.a(AvatarPendantUtil.b);
      return;
    }
    label290:
    QLog.e("AvatarPendantActivity", 2, "onDone unkonw url: " + paramDownloadTask.jdField_a_of_type_JavaLangString + ",errCode:" + paramDownloadTask.jdField_a_of_type_Int + ",httpCode:" + paramDownloadTask.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wxp
 * JD-Core Version:    0.7.0.1
 */