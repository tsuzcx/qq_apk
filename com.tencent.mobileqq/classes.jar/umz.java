import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class umz
  implements ValueAnimator.AnimatorUpdateListener
{
  umz(umy paramumy, GradientDrawable paramGradientDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    int j = (int)AIOUtils.px2dp(i, this.jdField_a_of_type_Umy.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_Umy.jdField_a_of_type_AndroidWidgetTextView.setTranslationY(i);
    float f = (-j - 29) * 64 / 30.0F;
    j = (int)(255.0F - (-j - 29) * 127 / 30.0F);
    i = j;
    if (j > 255) {
      i = 255;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(Color.argb((int)(102.0F - f), 0, 0, 0));
    this.jdField_a_of_type_Umy.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable);
    this.jdField_a_of_type_Umy.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(i, 255, 255, 255));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umz
 * JD-Core Version:    0.7.0.1
 */