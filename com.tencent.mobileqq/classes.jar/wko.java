import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.bless.BlessResultActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class wko
  implements Runnable
{
  public wko(BlessResultActivity paramBlessResultActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "VideoRedbag, BlessResultActivity doOnResume, sendRealNameCheckReq");
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      RedBagVideoManager.a((QQAppInterface)localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wko
 * JD-Core Version:    0.7.0.1
 */