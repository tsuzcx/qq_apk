import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.step.QQComicStep;

public class zxs
  implements Runnable
{
  public zxs(QQComicStep paramQQComicStep) {}
  
  public void run()
  {
    ThreadManager.executeOnNetWorkThread(new zxt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zxs
 * JD-Core Version:    0.7.0.1
 */