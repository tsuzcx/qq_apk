import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

public class vtr
  implements Runnable
{
  public vtr(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    PublicAccountChatPie.a(this.a).removeView(this.a.o);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vtr
 * JD-Core Version:    0.7.0.1
 */