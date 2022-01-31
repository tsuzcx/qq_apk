import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;

public class gty
  extends GestureDetector.SimpleOnGestureListener
{
  public gty(NearbyTroopsActivity paramNearbyTroopsActivity) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null) || (this.a.a == null)) {}
    while (paramMotionEvent2.getY() - paramMotionEvent1.getY() >= 0.0F) {
      return false;
    }
    this.a.b(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gty
 * JD-Core Version:    0.7.0.1
 */