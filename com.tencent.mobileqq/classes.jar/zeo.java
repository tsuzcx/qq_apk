import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class zeo
  implements View.OnTouchListener
{
  zeo(zei paramzei) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      zei.a(this.a, 0);
    }
    if (zei.a(this.a) != null) {
      zei.a(this.a).a(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zeo
 * JD-Core Version:    0.7.0.1
 */