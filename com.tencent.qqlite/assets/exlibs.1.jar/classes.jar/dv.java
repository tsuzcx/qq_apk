import android.os.Handler;
import com.dataline.util.widget.WaitTextView;
import com.dataline.util.widget.WaitTextView.RefreshListener;

public class dv
  implements Runnable
{
  public dv(WaitTextView paramWaitTextView) {}
  
  public void run()
  {
    WaitTextView.a(this.a);
    if (WaitTextView.a(this.a) != null) {
      WaitTextView.a(this.a).a();
    }
    WaitTextView.a(this.a).postDelayed(this, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dv
 * JD-Core Version:    0.7.0.1
 */