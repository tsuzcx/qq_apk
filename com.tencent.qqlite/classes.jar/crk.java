import android.os.Process;
import com.tencent.mobileqq.app.BrowserAppInterface;

public class crk
  extends Thread
{
  public crk(BrowserAppInterface paramBrowserAppInterface) {}
  
  public void run()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     crk
 * JD-Core Version:    0.7.0.1
 */