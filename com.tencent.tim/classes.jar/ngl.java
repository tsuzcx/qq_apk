import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview.b;

public class ngl
  implements View.OnTouchListener
{
  public ngl(ReadInJoyNavigationGridview paramReadInJoyNavigationGridview) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((MotionEventCompat.getActionMasked(paramMotionEvent) == 0) && (ReadInJoyNavigationGridview.a(this.b) != null)) {
      ReadInJoyNavigationGridview.a(this.b).aDt();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ngl
 * JD-Core Version:    0.7.0.1
 */