import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class uax
  implements View.OnClickListener
{
  uax(uas paramuas, BarrageInfo paramBarrageInfo) {}
  
  public final void onClick(View paramView)
  {
    uar localuar = this.jdField_a_of_type_Uas.a();
    if (localuar != null)
    {
      String str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageInfo.a;
      Intrinsics.checkExpressionValueIsNotNull(str, "barrageInfo.id");
      localuar.onEventBarrageOnClick(str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uax
 * JD-Core Version:    0.7.0.1
 */