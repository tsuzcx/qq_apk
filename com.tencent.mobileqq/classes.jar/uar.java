import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.biz.qqcircle.transition.QCircleTransitionImageView;

public class uar
  implements Interpolator
{
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new DecelerateInterpolator();
  
  private uar(QCircleTransitionImageView paramQCircleTransitionImageView) {}
  
  public void a(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
  }
  
  public float getInterpolation(float paramFloat)
  {
    float f = paramFloat;
    if (this.jdField_a_of_type_AndroidViewAnimationInterpolator != null) {
      f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(paramFloat);
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uar
 * JD-Core Version:    0.7.0.1
 */