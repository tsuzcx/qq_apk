import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import java.util.ArrayList;

class zoe
  extends zoi
{
  zoe(znz paramznz, zog paramzog, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
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
    this.jdField_a_of_type_Znz.dispatchChangeFinished(this.jdField_a_of_type_Zog.b, false);
    znz.g(this.jdField_a_of_type_Znz).remove(this.jdField_a_of_type_Zog.b);
    znz.a(this.jdField_a_of_type_Znz);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.jdField_a_of_type_Znz.dispatchChangeStarting(this.jdField_a_of_type_Zog.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zoe
 * JD-Core Version:    0.7.0.1
 */