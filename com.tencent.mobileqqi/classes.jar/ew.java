import android.os.Handler;
import com.dataline.util.widget.WaitTextView;
import com.dataline.util.widget.WaitTextView.RefreshListener;

public class ew
  implements Runnable
{
  public ew(WaitTextView paramWaitTextView) {}
  
  public void run()
  {
    WaitTextView.a(this.a);
    if (WaitTextView.a(this.a) != null) {
      WaitTextView.a(this.a).a();
    }
    WaitTextView.a(this.a).postDelayed(this, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ew
 * JD-Core Version:    0.7.0.1
 */