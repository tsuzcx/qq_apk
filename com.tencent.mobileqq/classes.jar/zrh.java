import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.step.QQComicStep;

public class zrh
  implements Runnable
{
  public zrh(QQComicStep paramQQComicStep) {}
  
  public void run()
  {
    ThreadManager.executeOnNetWorkThread(new zri(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zrh
 * JD-Core Version:    0.7.0.1
 */