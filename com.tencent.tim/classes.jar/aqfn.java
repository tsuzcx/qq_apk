import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class aqfn
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return false;
        aqfl.y(false);
        aqfl.lastX = f1;
        aqfl.lastY = f2;
        paramMotionEvent = Message.obtain();
        paramMotionEvent.what = aqfl.c.dYW;
        paramMotionEvent.obj = paramView;
        aqfl.a().sendMessageDelayed(paramMotionEvent, 1000L);
        return false;
      } while ((aqfl.access$400()) || ((Math.abs(aqfl.lastX - f1) <= 20.0F) && (Math.abs(aqfl.lastY - f2) <= 20.0F)));
      aqfl.y(true);
      aqfl.a().removeMessages(aqfl.c.dYW);
      return false;
    }
    aqfl.a().removeMessages(aqfl.c.dYW);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqfn
 * JD-Core Version:    0.7.0.1
 */