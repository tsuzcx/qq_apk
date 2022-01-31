import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.step.QQComicStep;

public class zob
  implements Runnable
{
  public zob(QQComicStep paramQQComicStep) {}
  
  public void run()
  {
    ThreadManager.executeOnNetWorkThread(new zoc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zob
 * JD-Core Version:    0.7.0.1
 */