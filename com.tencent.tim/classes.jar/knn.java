import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyCutImageView;

class knn
  implements ValueAnimator.AnimatorUpdateListener
{
  knn(knm paramknm, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, ReadInjoyCutImageView paramReadInjoyCutImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    float f1 = this.iJ;
    float f2 = paramValueAnimator.floatValue();
    float f3 = this.iK;
    float f4 = paramValueAnimator.floatValue();
    float f5 = this.iL;
    float f6 = paramValueAnimator.floatValue();
    float f7 = this.iM;
    float f8 = paramValueAnimator.floatValue();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setLeftAreaTranslate(f1 * f2, f3 * f4);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setRightAreaTranslate(f5 * f6, f8 * f7);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     knn
 * JD-Core Version:    0.7.0.1
 */