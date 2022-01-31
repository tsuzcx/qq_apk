import android.os.Process;
import com.tencent.mobileqq.app.BrowserAppInterface;

public class cqj
  extends Thread
{
  public cqj(BrowserAppInterface paramBrowserAppInterface) {}
  
  public void run()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cqj
 * JD-Core Version:    0.7.0.1
 */