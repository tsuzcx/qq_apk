import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyCutImageView;

class tqp
  extends AnimatorListenerAdapter
{
  tqp(tqn paramtqn, ReadInjoyCutImageView paramReadInjoyCutImageView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyCutImageView.setVisibility(4);
    tqn.a(this.jdField_a_of_type_Tqn).a();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyCutImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tqp
 * JD-Core Version:    0.7.0.1
 */