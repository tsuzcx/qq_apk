import android.os.Handler;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity;
import java.util.ArrayList;

public class bjl
  implements Runnable
{
  public bjl(SetTroopAdminsActivity paramSetTroopAdminsActivity) {}
  
  public void run()
  {
    ArrayList localArrayList = this.a.a();
    this.a.a.sendMessage(this.a.a.obtainMessage(2, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bjl
 * JD-Core Version:    0.7.0.1
 */