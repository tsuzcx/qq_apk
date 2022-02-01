import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoySlideAnimLayout;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;

public class njh
  implements ValueAnimator.AnimatorUpdateListener
{
  public njh(SlideActiveAnimController paramSlideActiveAnimController, float paramFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.ap.setTranslationY(this.kv - paramValueAnimator.floatValue());
    this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setTranslationY(-paramValueAnimator.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     njh
 * JD-Core Version:    0.7.0.1
 */