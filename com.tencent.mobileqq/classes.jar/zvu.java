import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import java.util.ArrayList;

class zvu
  extends zvz
{
  zvu(zvq paramzvq, zvx paramzvx, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
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
    this.jdField_a_of_type_Zvq.dispatchChangeFinished(this.jdField_a_of_type_Zvx.a, true);
    zvq.g(this.jdField_a_of_type_Zvq).remove(this.jdField_a_of_type_Zvx.a);
    zvq.a(this.jdField_a_of_type_Zvq);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.jdField_a_of_type_Zvq.dispatchChangeStarting(this.jdField_a_of_type_Zvx.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zvu
 * JD-Core Version:    0.7.0.1
 */