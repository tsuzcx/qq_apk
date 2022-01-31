import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class bby
  implements View.OnTouchListener
{
  int jdField_a_of_type_Int = 2000;
  boolean jdField_a_of_type_Boolean;
  int b;
  int c;
  int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public bby(QQBrowserActivity paramQQBrowserActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).setVisibility(8);
      int k = (int)paramMotionEvent.getRawX();
      this.e = k;
      this.g = k;
      k = (int)paramMotionEvent.getRawY();
      this.f = k;
      this.h = k;
      paramView.setBackgroundResource(2130838238);
      continue;
      if (QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).getVisibility() != 0)
      {
        k = (int)paramMotionEvent.getRawX() - this.e;
        int m = (int)paramMotionEvent.getRawY() - this.f;
        this.jdField_a_of_type_Int = (paramView.getLeft() + k);
        this.b = (paramView.getTop() + m);
        this.c = (k + paramView.getRight());
        this.d = (paramView.getBottom() + m);
        if (this.jdField_a_of_type_Int < 0)
        {
          this.jdField_a_of_type_Int = 0;
          this.c = (this.jdField_a_of_type_Int + paramView.getWidth());
          label194:
          if (this.b >= 0) {
            break label397;
          }
          this.b = 0;
          this.d = (this.b + paramView.getHeight());
        }
        for (;;)
        {
          paramView.layout(this.jdField_a_of_type_Int, this.b, this.c, this.d);
          this.e = ((int)paramMotionEvent.getRawX());
          this.f = ((int)paramMotionEvent.getRawY());
          if ((this.jdField_a_of_type_Boolean) || ((Math.abs(paramMotionEvent.getRawX() - this.g) <= this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.density * 5.0F) && (Math.abs(paramMotionEvent.getRawY() - this.h) <= this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.density * 5.0F))) {
            break;
          }
          QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b.setVisibility(8);
          this.jdField_a_of_type_Boolean = true;
          break;
          if (this.c <= this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.z) {
            break label194;
          }
          this.c = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.z;
          this.jdField_a_of_type_Int = (this.c - paramView.getWidth());
          break label194;
          label397:
          if (this.d > this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.A)
          {
            this.d = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.A;
            this.b = (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.A - paramView.getHeight());
          }
        }
        paramView.setBackgroundResource(2130838237);
        if (this.jdField_a_of_type_Boolean) {
          break;
        }
        if (QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).getVisibility() == 0)
        {
          QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b.setVisibility(8);
        }
        else
        {
          QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b.setVisibility(0);
          k = (int)Math.max(0.0F, Math.min(paramView.getTop() - this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.density * 10.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.A - QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).getHeight()));
          if (this.jdField_a_of_type_Int + paramView.getWidth() / 2 < this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.z / 2)
          {
            m = (int)(paramView.getLeft() + this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.density * 60.0F);
            QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).setBackgroundResource(2130838236);
            paramView = (FrameLayout.LayoutParams)QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).getLayoutParams();
            paramView.leftMargin = m;
            paramView.topMargin = k;
            QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).setLayoutParams(paramView);
          }
          else
          {
            m = paramView.getLeft();
            int n = (int)(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.density * 10.0F);
            int i1 = QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).getWidth();
            QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).setBackgroundResource(2130838235);
            paramView = (FrameLayout.LayoutParams)QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).getLayoutParams();
            paramView.leftMargin = (m - n - i1);
            paramView.topMargin = k;
            QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).setLayoutParams(paramView);
          }
        }
      }
    }
    this.i = Math.min(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.z - this.c);
    this.j = Math.min(this.b, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.A - this.d);
    if (this.i > this.j) {
      if (this.j != this.b)
      {
        paramMotionEvent = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.j);
        this.b = (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.A - paramView.getHeight());
        this.d = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.A;
      }
    }
    for (;;)
    {
      paramMotionEvent.setDuration(500L);
      paramView.setVisibility(8);
      paramMotionEvent.setAnimationListener(new bbz(this, paramView));
      paramView.startAnimation(paramMotionEvent);
      break;
      paramMotionEvent = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.b);
      this.b = 0;
      this.d = paramView.getHeight();
      continue;
      if (this.i != this.jdField_a_of_type_Int)
      {
        paramMotionEvent = new TranslateAnimation(0.0F, this.i, 0.0F, 0.0F);
        this.jdField_a_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.z - paramView.getWidth());
        this.c = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.z;
      }
      else
      {
        paramMotionEvent = new TranslateAnimation(0.0F, -this.jdField_a_of_type_Int, 0.0F, 0.0F);
        this.jdField_a_of_type_Int = 0;
        this.c = paramView.getWidth();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bby
 * JD-Core Version:    0.7.0.1
 */