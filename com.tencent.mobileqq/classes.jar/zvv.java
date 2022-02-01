import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import java.util.ArrayList;

class zvv
  extends zvz
{
  zvv(zvq paramzvq, zvx paramzvx, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
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
    this.jdField_a_of_type_Zvq.dispatchChangeFinished(this.jdField_a_of_type_Zvx.b, false);
    zvq.g(this.jdField_a_of_type_Zvq).remove(this.jdField_a_of_type_Zvx.b);
    zvq.a(this.jdField_a_of_type_Zvq);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.jdField_a_of_type_Zvq.dispatchChangeStarting(this.jdField_a_of_type_Zvx.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zvv
 * JD-Core Version:    0.7.0.1
 */