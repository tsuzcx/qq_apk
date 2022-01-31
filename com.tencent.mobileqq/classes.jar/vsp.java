import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;

public class vsp
  implements Runnable
{
  public vsp(MultiForwardChatPie paramMultiForwardChatPie) {}
  
  public void run()
  {
    MultiForwardChatPie.a(this.a).setVisibility(0);
    MultiForwardChatPie.a(this.a).setText(2131433404);
    this.a.d.setText(this.a.g);
    this.a.y();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vsp
 * JD-Core Version:    0.7.0.1
 */