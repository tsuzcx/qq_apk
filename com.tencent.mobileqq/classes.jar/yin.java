import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.subscribe.component.base.RefreshHeaderView;

public class yin
  implements ValueAnimator.AnimatorUpdateListener
{
  public yin(RefreshHeaderView paramRefreshHeaderView, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView.setVisibleHeight(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    if ((this.jdField_a_of_type_Int == 0) && (((Integer)paramValueAnimator.getAnimatedValue()).intValue() == 0)) {
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseRefreshHeaderView.setState(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yin
 * JD-Core Version:    0.7.0.1
 */