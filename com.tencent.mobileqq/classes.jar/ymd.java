import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.api.motivevideo.GdtMvViewAnimationAbs.1;
import com.tencent.gdtad.api.motivevideo.GdtMvViewAnimationAbs.2;

public class ymd
{
  protected Context a;
  protected Handler a;
  public ylv a;
  
  protected ymd(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static void a(View paramView)
  {
    if ((paramView == null) || (paramView.getVisibility() != 0)) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    paramView.startAnimation(localAlphaAnimation);
    paramView.setVisibility(8);
  }
  
  private void a(ylv paramylv)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramylv.h.getLayoutParams();
    localLayoutParams.height = paramylv.n;
    localLayoutParams.width = paramylv.o;
    localLayoutParams.addRule(3, 0);
    localLayoutParams.addRule(12, 0);
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(15);
    paramylv.h.setLayoutParams(localLayoutParams);
    paramylv.h.postInvalidate();
  }
  
  public static void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(100L);
    paramView.startAnimation(localAlphaAnimation);
    paramView.setVisibility(0);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Ylv == null) || (this.jdField_a_of_type_Ylv.g == null)) {
      return;
    }
    a(this.jdField_a_of_type_Ylv.g);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GdtMvViewAnimationAbs.1(this), 300L);
  }
  
  public void a(int paramInt) {}
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, -1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.topMargin;
    int j = localLayoutParams.leftMargin;
    int k = localLayoutParams.rightMargin;
    a(paramView);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GdtMvViewAnimationAbs.2(this, localLayoutParams, i, paramInt1, j, paramInt2, paramInt3, k, paramView), 200L);
  }
  
  protected void a(ylv paramylv, View paramView)
  {
    paramylv.h = paramView;
    paramylv.o = ypk.a(470, 750, ypk.f(this.jdField_a_of_type_AndroidContentContext));
    paramylv.n = ypk.a(470, 1334, ypk.e(this.jdField_a_of_type_AndroidContentContext));
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ymd
 * JD-Core Version:    0.7.0.1
 */