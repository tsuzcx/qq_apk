import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import java.util.ArrayList;

class yyz
  extends yzd
{
  yyz(yyu paramyyu, yzb paramyzb, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
  {
    super(null);
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPropertyAnimatorCompat.setListener((ViewPropertyAnimatorListener)null);
    ViewCompat.setAlpha(this.jdField_a_of_type_AndroidViewView, 1.0F);
    ViewCompat.setTranslationX(this.jdField_a_of_type_AndroidViewView, 0.0F);
    ViewCompat.setTranslationY(this.jdField_a_of_type_AndroidViewView, 0.0F);
    ViewCompat.setScaleX(this.jdField_a_of_type_AndroidViewView, 1.0F);
    ViewCompat.setScaleY(this.jdField_a_of_type_AndroidViewView, 1.0F);
    this.jdField_a_of_type_Yyu.dispatchChangeFinished(this.jdField_a_of_type_Yzb.b, false);
    yyu.g(this.jdField_a_of_type_Yyu).remove(this.jdField_a_of_type_Yzb.b);
    yyu.a(this.jdField_a_of_type_Yyu);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.jdField_a_of_type_Yyu.dispatchChangeStarting(this.jdField_a_of_type_Yzb.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyz
 * JD-Core Version:    0.7.0.1
 */