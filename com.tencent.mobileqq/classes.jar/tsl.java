import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;
import com.tencent.qphone.base.util.QLog;

public class tsl
  extends AnimatorListenerAdapter
{
  public tsl(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton, String paramString) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    QLog.d("ColorBandVideoEntranceButton", 1, "scaleAnimatorSet cancel");
    ColorBandVideoEntranceButton.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, this.jdField_a_of_type_JavaLangString);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ColorBandVideoEntranceButton.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, this.jdField_a_of_type_JavaLangString);
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    QLog.d("ColorBandVideoEntranceButton", 1, "scaleAnimatorSet pause");
    ColorBandVideoEntranceButton.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tsl
 * JD-Core Version:    0.7.0.1
 */