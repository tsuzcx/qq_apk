import android.os.Handler;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity;
import java.util.ArrayList;

public class bji
  implements Runnable
{
  public bji(SetTroopAdminsActivity paramSetTroopAdminsActivity) {}
  
  public void run()
  {
    ArrayList localArrayList = this.a.a();
    this.a.a.sendMessage(this.a.a.obtainMessage(2, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bji
 * JD-Core Version:    0.7.0.1
 */