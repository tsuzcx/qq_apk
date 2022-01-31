import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;

public class zu
  implements Runnable
{
  public zu(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (this.a.f != null) {
      this.a.f.setVisibility(8);
    }
    if (BaseChatPie.a(this.a) != null) {
      BaseChatPie.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     zu
 * JD-Core Version:    0.7.0.1
 */