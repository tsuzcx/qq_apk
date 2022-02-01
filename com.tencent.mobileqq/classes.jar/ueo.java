import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ueo
  implements View.OnClickListener
{
  ueo(uen paramuen) {}
  
  public void onClick(View paramView)
  {
    long l = 3010204L;
    if (uki.e(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {}
    for (;;)
    {
      if (((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
      {
        JumpMode localJumpMode = udy.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (Activity)this.a.jdField_a_of_type_AndroidContentContext);
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.adClickPos = AdClickPos.SoftAdComponent;
        ueb.a(localJumpMode, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, ois.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), ueb.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, l, 9L, null, "1"));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (uki.c(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
        l = 3010304L;
      } else if (uki.f(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
        l = 3010404L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ueo
 * JD-Core Version:    0.7.0.1
 */