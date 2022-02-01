import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PathMeasure;
import com.tencent.mobileqq.doutu.combo.ComboMasterView;

public class afec
  implements ValueAnimator.AnimatorUpdateListener
{
  public afec(ComboMasterView paramComboMasterView, PathMeasure paramPathMeasure, float[] paramArrayOfFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_AndroidGraphicsPathMeasure.getPosTan(f, this.cx, null);
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView.setTranslationX(this.cx[0]);
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView.setTranslationY(this.cx[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afec
 * JD-Core Version:    0.7.0.1
 */