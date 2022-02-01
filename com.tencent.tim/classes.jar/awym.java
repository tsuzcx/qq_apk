import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

class awym
  implements View.OnTouchListener
{
  awym(awyk paramawyk) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((awyk.a(this.a) != null) && (awyk.b(this.a) != null)) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, awyk.b(this.a), awyk.a(this.a));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awym
 * JD-Core Version:    0.7.0.1
 */