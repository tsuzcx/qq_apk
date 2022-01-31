import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasScrollView;

public class yql
  implements View.OnTouchListener
{
  public yql(GdtCanvasScrollView paramGdtCanvasScrollView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return false;
    } while (GdtCanvasScrollView.a(this.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yql
 * JD-Core Version:    0.7.0.1
 */