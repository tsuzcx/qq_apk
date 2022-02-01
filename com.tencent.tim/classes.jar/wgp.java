import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.VisitorsActivity;

public class wgp
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public wgp(VisitorsActivity paramVisitorsActivity) {}
  
  public void onGlobalLayout()
  {
    this.this$0.aM.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int[] arrayOfInt = new int[2];
    this.this$0.aM.getLocationInWindow(arrayOfInt);
    this.this$0.bMU = arrayOfInt[1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wgp
 * JD-Core Version:    0.7.0.1
 */