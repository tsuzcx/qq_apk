import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import java.util.ArrayList;

class zod
  extends zoi
{
  zod(znz paramznz, zog paramzog, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPropertyAnimatorCompat.setListener((ViewPropertyAnimatorListener)null);
    ViewCompat.setAlpha(paramView, 1.0F);
    ViewCompat.setTranslationX(paramView, 0.0F);
    ViewCompat.setTranslationY(paramView, 0.0F);
    ViewCompat.setScaleX(paramView, 1.0F);
    ViewCompat.setScaleY(paramView, 1.0F);
    this.jdField_a_of_type_Znz.dispatchChangeFinished(this.jdField_a_of_type_Zog.a, true);
    znz.g(this.jdField_a_of_type_Znz).remove(this.jdField_a_of_type_Zog.a);
    znz.a(this.jdField_a_of_type_Znz);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.jdField_a_of_type_Znz.dispatchChangeStarting(this.jdField_a_of_type_Zog.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zod
 * JD-Core Version:    0.7.0.1
 */