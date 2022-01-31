import android.os.Process;
import com.tencent.mobileqq.app.EmoticonManagerImp;

public class fca
  implements Runnable
{
  public fca(EmoticonManagerImp paramEmoticonManagerImp) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    EmoticonManagerImp.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fca
 * JD-Core Version:    0.7.0.1
 */