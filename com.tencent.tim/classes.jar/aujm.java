import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.tim.resourcesgrab.ResourceGrabView;

public class aujm
  implements View.OnTouchListener
{
  float downX = 0.0F;
  float downY = 0.0F;
  int erF = 0;
  
  public aujm(ResourceGrabView paramResourceGrabView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      ResourceGrabView.a(this.b, System.currentTimeMillis());
      this.downX = paramMotionEvent.getX();
      this.downY = paramMotionEvent.getY();
      this.erF = ResourceGrabView.a(this.b).y;
      continue;
      float f1 = paramMotionEvent.getY();
      paramView = ResourceGrabView.a(this.b);
      float f2 = paramView.y;
      paramView.y = ((int)((f1 - this.downY) / 3.0F + f2));
      ResourceGrabView.a(this.b).updateViewLayout(this.b, ResourceGrabView.a(this.b));
      continue;
      int i = ResourceGrabView.a(this.b).y;
      int j = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      if ((Math.abs(i - this.erF) <= j) && (System.currentTimeMillis() - ResourceGrabView.a(this.b) >= 500L)) {
        this.b.evq();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aujm
 * JD-Core Version:    0.7.0.1
 */