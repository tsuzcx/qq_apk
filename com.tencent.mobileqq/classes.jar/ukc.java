import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule.BussinessData;

public class ukc
  implements Runnable
{
  public ukc(AioAnimationDetector paramAioAnimationDetector, AIOAnimationConatiner paramAIOAnimationConatiner, Drawable paramDrawable, AioAnimationRule paramAioAnimationRule) {}
  
  public void run()
  {
    AIOAnimationConatiner localAIOAnimationConatiner = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule.a == null) {}
    for (int i = -1;; i = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule.a.a)
    {
      localAIOAnimationConatiner.a(2, 300, new Object[] { localDrawable, Integer.valueOf(0), Integer.valueOf(i) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ukc
 * JD-Core Version:    0.7.0.1
 */