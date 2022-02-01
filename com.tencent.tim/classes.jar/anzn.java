import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.tablequery.TableQueryViewer;

public class anzn
  implements View.OnTouchListener
{
  public anzn(TableQueryViewer paramTableQueryViewer) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.c.getContext();
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getRawY();
    if (i == 0) {
      TableQueryViewer.a(this.c, (int)paramMotionEvent.getY());
    }
    label171:
    do
    {
      return false;
      if (i == 2)
      {
        if ((TableQueryViewer.a(this.c)) || (Math.abs(paramMotionEvent.getY() - TableQueryViewer.a(this.c)) > aqcx.dip2px(paramView, 10.0F)))
        {
          TableQueryViewer.a(this.c, true);
          paramMotionEvent = (WindowManager.LayoutParams)this.c.getLayoutParams();
          paramMotionEvent.y = (j - TableQueryViewer.a(this.c) - riw.dip2px(paramView, 0.0F));
          i = TableQueryViewer.a(this.c).getDefaultDisplay().getHeight();
          if (paramMotionEvent.y >= 0) {
            break label171;
          }
          paramMotionEvent.y = 0;
        }
        for (;;)
        {
          TableQueryViewer.a(this.c).updateViewLayout(TableQueryViewer.a(this.c), paramMotionEvent);
          return true;
          if (paramMotionEvent.y > i - this.c.getHeight()) {
            paramMotionEvent.y = (i - this.c.getHeight());
          }
        }
      }
    } while ((i != 1) && (i != 3));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anzn
 * JD-Core Version:    0.7.0.1
 */