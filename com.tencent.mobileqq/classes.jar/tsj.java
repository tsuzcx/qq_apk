import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;

public class tsj
  implements ValueAnimator.AnimatorUpdateListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  public tsj(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((paramValueAnimator.getCurrentPlayTime() >= 100L) && (!this.jdField_a_of_type_Boolean))
    {
      ColorBandVideoEntranceButton.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton).start();
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tsj
 * JD-Core Version:    0.7.0.1
 */