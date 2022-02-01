import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.viola.lottie.KdLottieView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

class tvk
  implements OnCompositionLoadedListener
{
  tvk(tvj paramtvj) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition != null)
    {
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaLottieKdLottieView.setImageAssetsFolder(this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaLottieKdLottieView.setComposition(paramLottieComposition);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaLottieKdLottieView.playAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tvk
 * JD-Core Version:    0.7.0.1
 */