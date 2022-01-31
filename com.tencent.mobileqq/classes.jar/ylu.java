import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener;
import java.util.ArrayList;
import java.util.Iterator;

class ylu
  implements TopGestureLayout.InterceptTouchEventListener
{
  ylu(ylt paramylt, Rect paramRect) {}
  
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
        } while (ylt.a(this.jdField_a_of_type_Ylt) == null);
        paramMotionEvent = ylt.a(this.jdField_a_of_type_Ylt).iterator();
      }
      ((View)paramMotionEvent.next()).getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
    } while (!this.jdField_a_of_type_AndroidGraphicsRect.contains(i, j));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ylu
 * JD-Core Version:    0.7.0.1
 */