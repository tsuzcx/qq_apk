import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyScrollViewSwitcher;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyScrollViewSwitcher.b;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyScrollViewSwitcher.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nrx
  implements View.OnClickListener
{
  public nrx(ReadInJoyScrollViewSwitcher paramReadInJoyScrollViewSwitcher, ReadInJoyScrollViewSwitcher.c paramc) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyScrollViewSwitcher.a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyScrollViewSwitcher.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyScrollViewSwitcher$c);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nrx
 * JD-Core Version:    0.7.0.1
 */