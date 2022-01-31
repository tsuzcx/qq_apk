import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager.3;

public class tza
  extends AnimatorListenerAdapter
{
  public tza(QCircleFuelAnimationManager.3 param3, PointF paramPointF) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.jdField_a_of_type_ComTencentBizQqcircleManagerQCircleFuelAnimationManager$3.b.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizQqcircleManagerQCircleFuelAnimationManager$3.b.setX(this.jdField_a_of_type_AndroidGraphicsPointF.x);
    this.jdField_a_of_type_ComTencentBizQqcircleManagerQCircleFuelAnimationManager$3.b.setY(this.jdField_a_of_type_AndroidGraphicsPointF.y + bdoo.a(20.0F));
    this.jdField_a_of_type_ComTencentBizQqcircleManagerQCircleFuelAnimationManager$3.b.clearAnimation();
    paramAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizQqcircleManagerQCircleFuelAnimationManager$3.a, "scaleX", new float[] { 1.0F, 1.2F, 1.0F }).setDuration(300L);
    if (Build.VERSION.SDK_INT >= 21) {
      paramAnimator.setInterpolator(new PathInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    }
    paramAnimator.start();
    paramAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizQqcircleManagerQCircleFuelAnimationManager$3.a, "scaleY", new float[] { 1.0F, 1.2F, 1.0F }).setDuration(300L);
    if (Build.VERSION.SDK_INT >= 21) {
      paramAnimator.setInterpolator(new PathInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    }
    paramAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tza
 * JD-Core Version:    0.7.0.1
 */