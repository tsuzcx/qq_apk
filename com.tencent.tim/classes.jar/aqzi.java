import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;

class aqzi
  implements View.OnTouchListener
{
  int bottom;
  int cqM;
  boolean isDrag;
  int lastX;
  int lastY;
  int left = 2000;
  int right;
  int startX;
  int startY;
  int top;
  
  aqzi(aqzg paramaqzg, DisplayMetrics paramDisplayMetrics) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == this.this$0.AM)
    {
      int j;
      int k;
      switch (paramMotionEvent.getAction())
      {
      default: 
      case 0: 
      case 2: 
        do
        {
          return true;
          this.this$0.AO.setVisibility(8);
          j = (int)paramMotionEvent.getRawX();
          this.lastX = j;
          this.startX = j;
          j = (int)paramMotionEvent.getRawY();
          this.lastY = j;
          this.startY = j;
          return true;
        } while (this.this$0.AN.getVisibility() == 0);
        j = (int)paramMotionEvent.getRawX() - this.lastX;
        k = (int)paramMotionEvent.getRawY() - this.lastY;
        this.left = (paramView.getLeft() + j);
        this.top = (paramView.getTop() + k);
        this.right = (j + paramView.getRight());
        this.bottom = (paramView.getBottom() + k);
        if (this.left < 0)
        {
          this.left = 0;
          this.right = (this.left + paramView.getWidth());
          label195:
          if (this.top >= 0) {
            break label406;
          }
          this.top = 0;
          this.bottom = (this.top + paramView.getHeight());
        }
        for (;;)
        {
          paramView.layout(this.left, this.top, this.right, this.bottom);
          this.lastX = ((int)paramMotionEvent.getRawX());
          this.lastY = ((int)paramMotionEvent.getRawY());
          if ((this.isDrag) || ((Math.abs(paramMotionEvent.getRawX() - this.startX) <= this.i.density * 5.0F) && (Math.abs(paramMotionEvent.getRawY() - this.startY) <= this.i.density * 5.0F))) {
            break;
          }
          this.this$0.AN.setVisibility(8);
          this.this$0.setFloatBtnBackground(this.this$0.AM, true);
          this.this$0.mask.setVisibility(8);
          this.isDrag = true;
          return true;
          if (this.right <= this.this$0.mScreenWidth) {
            break label195;
          }
          this.right = this.this$0.mScreenWidth;
          this.left = (this.right - paramView.getWidth());
          break label195;
          label406:
          if (this.bottom > this.this$0.mScreenHeight)
          {
            this.bottom = this.this$0.mScreenHeight;
            this.top = (this.this$0.mScreenHeight - paramView.getHeight());
          }
        }
      }
      this.this$0.setFloatBtnBackground(this.this$0.AM, true);
      if (!this.isDrag)
      {
        if (this.this$0.AN.getVisibility() == 0)
        {
          this.this$0.AN.setVisibility(8);
          this.this$0.setFloatBtnBackground(this.this$0.AM, true);
          this.this$0.mask.setVisibility(8);
          return true;
        }
        this.this$0.AN.setVisibility(0);
        this.this$0.setFloatBtnBackground(this.this$0.AM, false);
        this.this$0.mask.setVisibility(0);
        j = paramView.getTop();
        k = paramView.getWidth() / 2;
        if (this.left + k < this.this$0.mScreenWidth / 2) {
          if (Build.VERSION.SDK_INT < 11) {}
        }
        for (;;)
        {
          try
          {
            this.this$0.AM.setRotationY(180.0F);
            paramView = (FrameLayout.LayoutParams)this.this$0.AN.getLayoutParams();
            paramView.gravity = 3;
            paramView.leftMargin = (k + this.left);
            paramView.topMargin = j;
            this.this$0.AN.setLayoutParams(paramView);
            this.this$0.AN.setPadding((int)(this.i.density * 35.0F), this.this$0.AN.getPaddingTop(), (int)(this.i.density * 20.0F), this.this$0.AN.getPaddingBottom());
            anot.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_show", 0, 1, 0, this.this$0.a.Dr + "", "", "", "");
            return true;
          }
          catch (Throwable paramView)
          {
            QLog.e("WebLog_SwiftFloatViewUI", 1, "floatbtn.setrotationy error!", paramView);
            continue;
          }
          if (Build.VERSION.SDK_INT >= 11) {}
          try
          {
            this.this$0.AM.setRotationY(0.0F);
            paramMotionEvent = (FrameLayout.LayoutParams)this.this$0.AN.getLayoutParams();
            paramMotionEvent.gravity = 5;
            paramMotionEvent.rightMargin = (k + (this.this$0.mScreenWidth - paramView.getRight()));
            paramMotionEvent.topMargin = j;
            this.this$0.AN.setLayoutParams(paramMotionEvent);
            this.this$0.AN.setPadding((int)(this.i.density * 20.0F), this.this$0.AN.getPaddingTop(), (int)(this.i.density * 35.0F), this.this$0.AN.getPaddingBottom());
          }
          catch (Throwable paramMotionEvent)
          {
            for (;;)
            {
              QLog.e("WebLog_SwiftFloatViewUI", 1, "floatbtn.setrotationy error!", paramMotionEvent);
            }
          }
        }
      }
      this.cqM = Math.min(this.left, this.this$0.mScreenWidth - this.right);
      if (this.cqM == this.left)
      {
        paramMotionEvent = new TranslateAnimation(0.0F, -this.left, 0.0F, 0.0F);
        this.left = 0;
        this.right = (this.left + paramView.getWidth());
      }
      for (;;)
      {
        paramMotionEvent.setDuration(500L);
        paramView.setVisibility(8);
        paramMotionEvent.setAnimationListener(new aqzj(this, paramView));
        paramView.startAnimation(paramMotionEvent);
        return true;
        paramMotionEvent = new TranslateAnimation(0.0F, this.cqM, 0.0F, 0.0F);
        this.right = this.this$0.mScreenWidth;
        this.left = (this.right - paramView.getWidth());
      }
    }
    if (paramView == this.this$0.AO)
    {
      this.this$0.AO.setVisibility(8);
      this.this$0.AN.setVisibility(8);
      this.this$0.setFloatBtnBackground(this.this$0.AM, true);
      this.this$0.mask.setVisibility(8);
      return true;
    }
    if (paramView == this.this$0.mask)
    {
      this.this$0.AO.setVisibility(8);
      this.this$0.AN.setVisibility(8);
      this.this$0.setFloatBtnBackground(this.this$0.AM, true);
      this.this$0.mask.setVisibility(8);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqzi
 * JD-Core Version:    0.7.0.1
 */