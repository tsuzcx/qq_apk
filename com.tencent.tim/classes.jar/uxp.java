import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.tencent.mobileqq.activity.ForwardRecentActivity;

public class uxp
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public uxp(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onGlobalLayout()
  {
    this.this$0.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
    ForwardRecentActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     uxp
 * JD-Core Version:    0.7.0.1
 */