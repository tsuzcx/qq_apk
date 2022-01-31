import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class uav
  implements Runnable
{
  public uav(TroopMemberListActivity paramTroopMemberListActivity) {}
  
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
 * Qualified Name:     uav
 * JD-Core Version:    0.7.0.1
 */