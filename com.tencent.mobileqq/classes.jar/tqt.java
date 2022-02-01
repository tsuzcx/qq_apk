import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyScrollViewSwitcher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class tqt
  implements View.OnClickListener
{
  public tqt(ReadInJoyScrollViewSwitcher paramReadInJoyScrollViewSwitcher, tqw paramtqw) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyScrollViewSwitcher.a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyScrollViewSwitcher.a.a(this.jdField_a_of_type_Tqw);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tqt
 * JD-Core Version:    0.7.0.1
 */