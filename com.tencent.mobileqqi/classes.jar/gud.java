import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;

public class gud
  implements View.OnTouchListener
{
  public gud(NearbyTroopsActivity paramNearbyTroopsActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      this.a.a.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gud
 * JD-Core Version:    0.7.0.1
 */