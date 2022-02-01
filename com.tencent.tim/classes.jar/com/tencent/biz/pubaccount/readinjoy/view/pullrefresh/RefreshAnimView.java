package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import nqe;

public class RefreshAnimView
  extends RelativeLayout
{
  private RefreshEyeView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView;
  private LottieComposition jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition;
  private ImageView jh;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private TextView mTextView;
  
  public RefreshAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate(paramContext, 2131562926, this);
    this.jh = ((ImageView)findViewById(2131370918));
    this.mTextView = ((TextView)findViewById(2131377042));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView = ((RefreshEyeView)findViewById(2131377035));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.stopLoading();
    ThreadManager.excute(new RefreshAnimView.1(this, paramContext), 64, null, true);
  }
  
  public void A(boolean paramBoolean, String paramString)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setAnimationListener(new nqe(this, paramString, paramBoolean));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.startAnimation(localScaleAnimation);
  }
  
  public void bae()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.startLoading();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.setVisibility(0);
    }
  }
  
  public void eT(long paramLong)
  {
    this.mHandler.postDelayed(new RefreshAnimView.2(this), paramLong);
  }
  
  public void reset()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.stopLoading();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.clearAnimation();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.setScaleX(1.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.setScaleY(1.0F);
    this.jh.setImageDrawable(null);
    this.mTextView.clearAnimation();
    this.mTextView.setText("");
    this.mTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public void u(double paramDouble)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.setWaveHeightPercent(paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView
 * JD-Core Version:    0.7.0.1
 */