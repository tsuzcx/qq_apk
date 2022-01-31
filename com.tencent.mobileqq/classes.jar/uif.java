import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.VisitorsActivity;

public class uif
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public uif(VisitorsActivity paramVisitorsActivity) {}
  
  public void onGlobalLayout()
  {
    this.a.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int[] arrayOfInt = new int[2];
    this.a.b.getLocationOnScreen(arrayOfInt);
    this.a.i = arrayOfInt[1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uif
 * JD-Core Version:    0.7.0.1
 */