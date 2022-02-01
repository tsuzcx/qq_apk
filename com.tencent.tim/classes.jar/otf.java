import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class otf
  implements View.OnTouchListener
{
  otf(otd paramotd, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    otd.a(this.a, paramView);
    this.a.bfS = this.val$position;
    otd.a(this.a).onTouchEvent(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     otf
 * JD-Core Version:    0.7.0.1
 */