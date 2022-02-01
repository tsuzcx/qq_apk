import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener;
import java.util.ArrayList;
import java.util.Iterator;

class zjt
  implements TopGestureLayout.InterceptTouchEventListener
{
  zjt(zjs paramzjs, Rect paramRect) {}
  
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
        } while (zjs.a(this.jdField_a_of_type_Zjs) == null);
        paramMotionEvent = zjs.a(this.jdField_a_of_type_Zjs).iterator();
      }
      ((View)paramMotionEvent.next()).getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
    } while (!this.jdField_a_of_type_AndroidGraphicsRect.contains(i, j));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjt
 * JD-Core Version:    0.7.0.1
 */