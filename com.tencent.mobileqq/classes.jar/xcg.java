import com.tencent.mobileqq.activity.qwallet.preload.PreloadConfig;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.qphone.base.util.QLog;

public class xcg
  implements Runnable
{
  public xcg(PreloadConfig paramPreloadConfig) {}
  
  public void run()
  {
    synchronized (this.a.mSaveLock)
    {
      if (this.a.isModulesChange(this.a.mLastModules))
      {
        QWalletTools.a(this.a, this.a.mSavePath);
        if (QLog.isColorLevel()) {
          QLog.d("PreloadManager", 2, "really save:" + this.a);
        }
        this.a.mLastModules = this.a.getCloneModules();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xcg
 * JD-Core Version:    0.7.0.1
 */