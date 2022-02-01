import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import java.util.ArrayList;

class zzp
  extends zzu
{
  zzp(zzl paramzzl, zzs paramzzs, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
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
    this.jdField_a_of_type_Zzl.dispatchChangeFinished(this.jdField_a_of_type_Zzs.a, true);
    zzl.g(this.jdField_a_of_type_Zzl).remove(this.jdField_a_of_type_Zzs.a);
    zzl.a(this.jdField_a_of_type_Zzl);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.jdField_a_of_type_Zzl.dispatchChangeStarting(this.jdField_a_of_type_Zzs.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzp
 * JD-Core Version:    0.7.0.1
 */