import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.ui.framework.QzoneGameFloatView;
import com.tencent.qphone.base.util.QLog;

public class abqi
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
  
  public abqi(QzoneGameFloatView paramQzoneGameFloatView, DisplayMetrics paramDisplayMetrics) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (paramView == this.this$0.AM) {
      switch (paramMotionEvent.getAction())
      {
      default: 
        bool = true;
      }
    }
    label204:
    do
    {
      return bool;
      this.this$0.AO.setVisibility(8);
      int j = (int)paramMotionEvent.getRawX();
      this.lastX = j;
      this.startX = j;
      j = (int)paramMotionEvent.getRawY();
      this.lastY = j;
      this.startY = j;
      break;
      if (this.this$0.AN.getVisibility() == 0) {
        break;
      }
      j = (int)paramMotionEvent.getRawX() - this.lastX;
      int k = (int)paramMotionEvent.getRawY() - this.lastY;
      this.left = (paramView.getLeft() + j);
      this.top = (paramView.getTop() + k);
      this.right = (j + paramView.getRight());
      this.bottom = (paramView.getBottom() + k);
      if (this.left < 0)
      {
        this.left = 0;
        this.right = (this.left + paramView.getWidth());
        if (this.top >= 0) {
          break label416;
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
        break;
        if (this.right <= this.this$0.mScreenWidth) {
          break label204;
        }
        this.right = this.this$0.mScreenWidth;
        this.left = (this.right - paramView.getWidth());
        break label204;
        if (this.bottom > this.this$0.mScreenHeight)
        {
          this.bottom = this.this$0.mScreenHeight;
          this.top = (this.this$0.mScreenHeight - paramView.getHeight());
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
          break;
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
            if (this.this$0.b == null) {
              break;
            }
            abmt.b(abmt.getAppInterface(), ablp.a(0, 0, 3, 901003001, this.this$0.b.gameId, this.this$0.b.src));
          }
          catch (Throwable paramView)
          {
            QLog.e("cmframe_QzoneGameFloatView", 1, "floatbtn.setrotationy error!", paramView);
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
              QLog.e("cmframe_QzoneGameFloatView", 1, "floatbtn.setrotationy error!", paramMotionEvent);
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
        paramMotionEvent.setAnimationListener(new abqj(this, paramView));
        paramView.startAnimation(paramMotionEvent);
        break;
        paramMotionEvent = new TranslateAnimation(0.0F, this.cqM, 0.0F, 0.0F);
        this.right = this.this$0.mScreenWidth;
        this.left = (this.right - paramView.getWidth());
      }
      if (paramView == this.this$0.AO)
      {
        this.this$0.AO.setVisibility(8);
        this.this$0.AN.setVisibility(8);
        this.this$0.setFloatBtnBackground(this.this$0.AM, true);
        this.this$0.mask.setVisibility(8);
        return true;
      }
    } while (paramView != this.this$0.mask);
    label416:
    this.this$0.AO.setVisibility(8);
    this.this$0.AN.setVisibility(8);
    this.this$0.setFloatBtnBackground(this.this$0.AM, true);
    this.this$0.mask.setVisibility(8);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abqi
 * JD-Core Version:    0.7.0.1
 */