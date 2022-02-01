import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageItemView;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class uay
  implements ValueAnimator.AnimatorUpdateListener
{
  uay(uas paramuas, BarrageItemView paramBarrageItemView, float paramFloat) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator == null) {
      return;
    }
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    }
    float f1 = ((Float)paramValueAnimator).floatValue();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageItemView.setX(f1);
    float f2 = this.jdField_a_of_type_Float;
    float f3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageItemView.getWidth();
    uas.a(this.jdField_a_of_type_Uas, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageItemView, (int)(f2 - (f1 + f3)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uay
 * JD-Core Version:    0.7.0.1
 */