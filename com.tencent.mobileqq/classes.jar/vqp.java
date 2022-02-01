import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.PointF;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager.1;

public class vqp
  extends AnimatorListenerAdapter
{
  public vqp(QCircleFuelAnimationManager.1 param1, PointF paramPointF) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.jdField_a_of_type_ComTencentBizQqcircleManagerQCircleFuelAnimationManager$1.b.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizQqcircleManagerQCircleFuelAnimationManager$1.b.setX(this.jdField_a_of_type_AndroidGraphicsPointF.x);
    this.jdField_a_of_type_ComTencentBizQqcircleManagerQCircleFuelAnimationManager$1.b.setY(this.jdField_a_of_type_AndroidGraphicsPointF.y + bhtq.a(5.0F));
    this.jdField_a_of_type_ComTencentBizQqcircleManagerQCircleFuelAnimationManager$1.b.clearAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqp
 * JD-Core Version:    0.7.0.1
 */