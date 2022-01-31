import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;

public class wbr
  implements Runnable
{
  public wbr(NearbyChatPie paramNearbyChatPie) {}
  
  public void run()
  {
    Intent localIntent = this.a.a.getIntent();
    localIntent.putExtra("uintype", 0);
    NearbyChatPie.a(this.a, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wbr
 * JD-Core Version:    0.7.0.1
 */