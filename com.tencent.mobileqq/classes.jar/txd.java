import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyCutImageView;

class txd
  extends AnimatorListenerAdapter
{
  txd(txb paramtxb, ReadInjoyCutImageView paramReadInjoyCutImageView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyCutImageView.setVisibility(4);
    txb.a(this.jdField_a_of_type_Txb).a();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyCutImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txd
 * JD-Core Version:    0.7.0.1
 */