import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyVideoAdHighLightBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdVideo185UIStateUtil$onProgressUpdate$1$1"}, k=3, mv={1, 1, 16})
final class tvz
  implements View.OnClickListener
{
  tvz(ReadInJoyVideoAdHighLightBar paramReadInJoyVideoAdHighLightBar, AdvertisementInfo paramAdvertisementInfo, rti paramrti, sdg paramsdg) {}
  
  public final void onClick(View paramView)
  {
    rti localrti = this.jdField_a_of_type_Rti;
    if (localrti != null) {
      localrti.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar.getContext(), obb.aE, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_Sdg.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvz
 * JD-Core Version:    0.7.0.1
 */