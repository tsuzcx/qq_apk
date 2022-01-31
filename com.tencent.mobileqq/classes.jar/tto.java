import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class tto
  implements Runnable
{
  public tto(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "VideoRedbag, SplashActivity doOnResume, sendRealNameCheckReq");
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      RedBagVideoManager.a((QQAppInterface)localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tto
 * JD-Core Version:    0.7.0.1
 */