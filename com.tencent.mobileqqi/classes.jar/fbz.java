import android.os.Process;
import com.tencent.mobileqq.app.EmoticonManagerImp;

public class fbz
  implements Runnable
{
  public fbz(EmoticonManagerImp paramEmoticonManagerImp) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    EmoticonManagerImp.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fbz
 * JD-Core Version:    0.7.0.1
 */