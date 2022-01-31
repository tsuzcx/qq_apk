import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class ufo
  implements Runnable
{
  public ufo(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void run()
  {
    if ((this.a.d == 1) || (this.a.d == 11) || (this.a.d == 16))
    {
      Object[] arrayOfObject = this.a.a(this.a.b);
      this.a.a.sendMessage(this.a.a.obtainMessage(1, arrayOfObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ufo
 * JD-Core Version:    0.7.0.1
 */