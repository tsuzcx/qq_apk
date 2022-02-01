import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ztt
  implements View.OnTouchListener
{
  ztt(ztn paramztn) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      ztn.a(this.a, 0);
    }
    if (ztn.a(this.a) != null) {
      ztn.a(this.a).a(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ztt
 * JD-Core Version:    0.7.0.1
 */