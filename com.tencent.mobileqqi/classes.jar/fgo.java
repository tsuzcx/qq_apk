import android.os.Process;
import com.tencent.mobileqq.app.EmoticonManagerImp;

public class fgo
  implements Runnable
{
  public fgo(EmoticonManagerImp paramEmoticonManagerImp) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    EmoticonManagerImp.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fgo
 * JD-Core Version:    0.7.0.1
 */