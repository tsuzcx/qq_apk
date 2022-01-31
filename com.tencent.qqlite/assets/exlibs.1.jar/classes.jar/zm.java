import android.app.Dialog;
import com.tencent.mobileqq.activity.BaseChatPie;

public class zm
  implements Runnable
{
  public zm(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if ((this.a.e != null) && (this.a.e.isShowing())) {
      this.a.e.dismiss();
    }
    while ((this.a.f == null) || (!this.a.f.isShowing())) {
      return;
    }
    this.a.f.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     zm
 * JD-Core Version:    0.7.0.1
 */