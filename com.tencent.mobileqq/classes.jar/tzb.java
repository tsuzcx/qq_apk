import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.ImageView;

final class tzb
  implements ValueAnimator.AnimatorUpdateListener
{
  tzb(ViewGroup paramViewGroup, ImageView paramImageView1, ImageView paramImageView2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue("scaleX")).floatValue();
    float f2 = ((Float)paramValueAnimator.getAnimatedValue("scaleY")).floatValue();
    this.jdField_a_of_type_AndroidViewViewGroup.setPivotX(0.5F);
    this.jdField_a_of_type_AndroidViewViewGroup.setScaleX(f1);
    this.jdField_a_of_type_AndroidViewViewGroup.setPivotY(0.5F);
    this.jdField_a_of_type_AndroidViewViewGroup.setScaleY(f2);
    this.jdField_a_of_type_AndroidViewViewGroup.setTranslationX(((Float)paramValueAnimator.getAnimatedValue("translateX")).floatValue());
    this.jdField_a_of_type_AndroidViewViewGroup.setTranslationY(((Float)paramValueAnimator.getAnimatedValue("translateY")).floatValue());
    int i = this.jdField_a_of_type_AndroidViewViewGroup.getWidth();
    int j = this.jdField_a_of_type_AndroidViewViewGroup.getHeight();
    float f3;
    if (f1 < f2)
    {
      f1 = f2 / f1;
      f2 = i;
      f3 = i;
      this.jdField_a_of_type_AndroidWidgetImageView.setPivotX(0.5F);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(f1);
      this.jdField_a_of_type_AndroidWidgetImageView.setTranslationX((f2 - f3 * f1) * 0.5F);
      this.jdField_a_of_type_AndroidWidgetImageView.setPivotY(0.5F);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleY(1.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setTranslationY(0.0F);
    }
    for (;;)
    {
      this.b.setAlpha(((Float)paramValueAnimator.getAnimatedValue("backgroundAlpha")).floatValue());
      return;
      if (f2 < f1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setPivotX(0.5F);
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(1.0F);
        this.jdField_a_of_type_AndroidWidgetImageView.setTranslationX(0.0F);
        f1 /= f2;
        f2 = j;
        f3 = j;
        this.jdField_a_of_type_AndroidWidgetImageView.setPivotY(0.5F);
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleY(f1);
        this.jdField_a_of_type_AndroidWidgetImageView.setTranslationY((f2 - f3 * f1) * 0.5F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzb
 * JD-Core Version:    0.7.0.1
 */