import android.os.Handler;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity;
import java.util.ArrayList;

public class dhw
  implements Runnable
{
  public dhw(SetTroopAdminsActivity paramSetTroopAdminsActivity) {}
  
  public void run()
  {
    ArrayList localArrayList = this.a.a();
    this.a.a.sendMessage(this.a.a.obtainMessage(2, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dhw
 * JD-Core Version:    0.7.0.1
 */