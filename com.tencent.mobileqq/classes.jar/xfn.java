import com.tencent.mobileqq.activity.qwallet.config.QWalletConfig.ConfigInfo;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class xfn
  implements Runnable
{
  public xfn(PreloadManager paramPreloadManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "synDataFromMoggy");
    }
    Object localObject = (QWalletConfigManager)this.a.a.getManager(244);
    if (localObject != null)
    {
      ((QWalletConfigManager)localObject).a("preload", this.a);
      localObject = ((QWalletConfigManager)localObject).a("preload");
      this.a.a((QWalletConfig.ConfigInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xfn
 * JD-Core Version:    0.7.0.1
 */