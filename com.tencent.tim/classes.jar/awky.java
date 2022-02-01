import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

class awky
  implements View.OnTouchListener
{
  private float bA;
  private float bz;
  boolean isTouchMove = false;
  
  awky(awkv paramawkv) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramMotionEvent.getActionMasked() == 6) {
      this.isTouchMove = true;
    }
    boolean bool = awkv.a(this.this$0).onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool;
            this.bz = paramMotionEvent.getX();
            this.bA = paramMotionEvent.getY();
          } while (awkv.a(this.this$0) == null);
          awkv.a(this.this$0).a("onActionDown", new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
          return bool;
        } while ((awkv.a(this.this$0).isInProgress()) || (paramMotionEvent.getPointerCount() != 1) || (this.isTouchMove) || (awkv.a(this.this$0) == null));
        awkv.a(this.this$0).a("onActionMove", new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
        return bool;
        if ((Math.abs(this.bz - f1) > ViewConfiguration.getTouchSlop()) || (Math.abs(this.bA - f2) > ViewConfiguration.getTouchSlop())) {
          break;
        }
        paramView = awkv.a(this.this$0, paramMotionEvent.getX(), paramMotionEvent.getY());
        if (awkv.a(this.this$0) != null) {
          awkv.a(this.this$0).ad(paramView[0], paramView[1]);
        }
      } while (!awkv.d(this.this$0));
      awlg.jF("ar_activity_click", "1");
      awkv.c(this.this$0, false);
      return bool;
      this.isTouchMove = false;
    } while (awkv.a(this.this$0) == null);
    awkv.a(this.this$0).a("onActionUp", new float[] { 0.0F, 0.0F });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awky
 * JD-Core Version:    0.7.0.1
 */