import android.os.Process;
import com.tencent.mobileqq.app.EmoticonManagerImp;

public class ctr
  implements Runnable
{
  public ctr(EmoticonManagerImp paramEmoticonManagerImp) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    EmoticonManagerImp.a(this.a);
    this.a.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ctr
 * JD-Core Version:    0.7.0.1
 */