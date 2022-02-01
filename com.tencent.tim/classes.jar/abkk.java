import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView;

public class abkk
  implements View.OnTouchListener
{
  private int bottom;
  private boolean isDrag;
  private int lastX;
  private int lastY;
  private int left;
  private int right;
  private int startX;
  private int startY;
  private int top;
  
  public abkk(CmGameDebugView paramCmGameDebugView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == CmGameDebugView.a(this.a))
    {
      this.startX = ((int)paramMotionEvent.getRawX());
      this.startY = ((int)paramMotionEvent.getRawY());
      switch (paramMotionEvent.getAction())
      {
      default: 
      case 0: 
        for (;;)
        {
          return true;
          this.lastX = this.startX;
          this.lastY = this.startY;
        }
      case 2: 
        int i = this.startX - this.lastX;
        int j = this.startY - this.lastY;
        this.left = (paramView.getLeft() + i);
        this.top = (paramView.getTop() + j);
        this.right = (i + paramView.getRight());
        this.bottom = (paramView.getBottom() + j);
        if (this.left < 0)
        {
          this.left = 0;
          this.right = (this.left + paramView.getWidth());
          label173:
          if (this.top >= 0) {
            break label355;
          }
          this.top = 0;
          this.bottom = (this.top + paramView.getHeight());
        }
        for (;;)
        {
          paramMotionEvent = (FrameLayout.LayoutParams)paramView.getLayoutParams();
          paramMotionEvent.setMargins(this.left, this.top, 0, 0);
          paramView.setLayoutParams(paramMotionEvent);
          if ((!this.isDrag) && ((Math.abs(this.startX - this.lastX) > CmGameDebugView.a(this.a).density * 2.0F) || (Math.abs(this.startY - this.lastY) > CmGameDebugView.a(this.a).density * 2.0F))) {
            this.isDrag = true;
          }
          this.lastX = this.startX;
          this.lastY = this.startY;
          break;
          if (this.right <= this.a.mScreenWidth) {
            break label173;
          }
          this.right = this.a.mScreenWidth;
          this.left = (this.right - paramView.getWidth());
          break label173;
          label355:
          if (this.bottom > this.a.mScreenHeight)
          {
            this.bottom = this.a.mScreenHeight;
            this.top = (this.a.mScreenHeight - paramView.getHeight());
          }
        }
      }
      if (!this.isDrag)
      {
        if (CmGameDebugView.a(this.a).getVisibility() == 0) {
          break label434;
        }
        this.a.cCA();
      }
      for (;;)
      {
        this.isDrag = false;
        break;
        label434:
        this.a.cCB();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abkk
 * JD-Core Version:    0.7.0.1
 */