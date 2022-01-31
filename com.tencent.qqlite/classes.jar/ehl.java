import android.os.Handler;
import com.tencent.mobileqq.transfile.NetworkCenter;

public class ehl
  implements Runnable
{
  public ehl(NetworkCenter paramNetworkCenter) {}
  
  public void run()
  {
    this.a.b();
    NetworkCenter.a(this.a).postDelayed(this, 120000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ehl
 * JD-Core Version:    0.7.0.1
 */