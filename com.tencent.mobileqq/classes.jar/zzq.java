import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import java.util.ArrayList;

class zzq
  extends zzu
{
  zzq(zzl paramzzl, zzs paramzzs, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
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
    this.jdField_a_of_type_Zzl.dispatchChangeFinished(this.jdField_a_of_type_Zzs.b, false);
    zzl.g(this.jdField_a_of_type_Zzl).remove(this.jdField_a_of_type_Zzs.b);
    zzl.a(this.jdField_a_of_type_Zzl);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.jdField_a_of_type_Zzl.dispatchChangeStarting(this.jdField_a_of_type_Zzs.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzq
 * JD-Core Version:    0.7.0.1
 */