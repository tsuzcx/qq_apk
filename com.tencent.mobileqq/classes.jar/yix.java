import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

public class yix
  implements Runnable
{
  public yix(DiyPendantFetcher paramDiyPendantFetcher) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      this.a.a((QQAppInterface)localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     yix
 * JD-Core Version:    0.7.0.1
 */