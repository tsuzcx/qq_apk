import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;

public class eik
  extends GestureDetector.SimpleOnGestureListener
{
  public eik(NearbyTroopsView paramNearbyTroopsView) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eik
 * JD-Core Version:    0.7.0.1
 */