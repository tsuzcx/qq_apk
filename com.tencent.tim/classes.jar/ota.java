import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.view.WSTabLayout;
import com.tencent.biz.pubaccount.weishi_new.view.WSTabLayout.a;
import com.tencent.biz.pubaccount.weishi_new.view.WSTabLayout.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ota
  implements View.OnClickListener
{
  public ota(WSTabLayout.b paramb, WSTabLayout paramWSTabLayout) {}
  
  public void onClick(View paramView)
  {
    if (WSTabLayout.a(this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout$b.b) != null) {
      WSTabLayout.a(this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout$b.b).uC(WSTabLayout.b.a(this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout$b));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ota
 * JD-Core Version:    0.7.0.1
 */