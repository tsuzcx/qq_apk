import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class zwm
  implements Runnable
{
  public zwm(UpgradeController paramUpgradeController) {}
  
  public void run()
  {
    File localFile = new File(UpgradeController.a(this.a).k);
    if (localFile.exists())
    {
      localFile.delete();
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeConfigManager", 2, "the jacked apk has been removed.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zwm
 * JD-Core Version:    0.7.0.1
 */