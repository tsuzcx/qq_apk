import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyCutImageView;

class kno
  extends AnimatorListenerAdapter
{
  kno(knm paramknm, ReadInjoyCutImageView paramReadInjoyCutImageView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setVisibility(4);
    knm.a(this.jdField_a_of_type_Knm).onAnimationEnd();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kno
 * JD-Core Version:    0.7.0.1
 */