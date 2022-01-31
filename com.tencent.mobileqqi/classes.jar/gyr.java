import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.troop.widget.MediaControllerX;

public class gyr
  implements View.OnTouchListener
{
  public gyr(MediaControllerX paramMediaControllerX) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (MediaControllerX.a(this.a))) {
      this.a.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gyr
 * JD-Core Version:    0.7.0.1
 */