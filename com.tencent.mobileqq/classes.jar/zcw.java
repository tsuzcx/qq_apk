import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.biz.widgets.TabLayout;
import java.io.PrintStream;

public class zcw
  implements ValueAnimator.AnimatorUpdateListener
{
  public zcw(TabLayout paramTabLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView, int paramInt5) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    System.out.println("value = " + f);
    int i = 0;
    while (i < this.jdField_a_of_type_Int - this.b)
    {
      paramValueAnimator = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.getChildAt(this.c + i);
      if (paramValueAnimator != null) {
        paramValueAnimator.setTranslationX(this.d * f);
      }
      i += 1;
    }
    this.jdField_a_of_type_AndroidViewView.setTranslationX(f * -this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zcw
 * JD-Core Version:    0.7.0.1
 */