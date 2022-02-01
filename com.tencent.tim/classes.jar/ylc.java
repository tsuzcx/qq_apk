import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.bless.BlessActivity;

public class ylc
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ylc(BlessActivity paramBlessActivity, RelativeLayout paramRelativeLayout) {}
  
  public void onGlobalLayout()
  {
    this.ig.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    BlessActivity.a(this.this$0, this.ig.getHeight());
    BlessActivity.b(this.this$0, this.ig.getWidth());
    BlessActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ylc
 * JD-Core Version:    0.7.0.1
 */