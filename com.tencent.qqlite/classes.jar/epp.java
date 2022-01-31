import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.troop.widget.MediaControllerX;

public class epp
  implements View.OnTouchListener
{
  public epp(MediaControllerX paramMediaControllerX) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (MediaControllerX.a(this.a))) {
      this.a.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     epp
 * JD-Core Version:    0.7.0.1
 */