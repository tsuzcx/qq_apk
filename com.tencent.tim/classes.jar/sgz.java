import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener;
import java.util.ArrayList;
import java.util.Iterator;

class sgz
  implements TopGestureLayout.InterceptTouchEventListener
{
  sgz(sgy paramsgy, Rect paramRect) {}
  
  public void OnDispatchTouchEvent(MotionEvent paramMotionEvent) {}
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    int i;
    int j;
    do
    {
      while (!paramMotionEvent.hasNext())
      {
        do
        {
          return true;
          i = (int)(paramMotionEvent.getX() + 0.5F);
          j = (int)(paramMotionEvent.getY() + 0.5F);
        } while (sgy.a(this.b) == null);
        paramMotionEvent = sgy.a(this.b).iterator();
      }
      ((View)paramMotionEvent.next()).getGlobalVisibleRect(this.aN);
    } while (!this.aN.contains(i, j));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sgz
 * JD-Core Version:    0.7.0.1
 */