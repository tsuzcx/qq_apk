import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ztg
  implements Runnable
{
  public ztg(UpgradeController paramUpgradeController) {}
  
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
 * Qualified Name:     ztg
 * JD-Core Version:    0.7.0.1
 */