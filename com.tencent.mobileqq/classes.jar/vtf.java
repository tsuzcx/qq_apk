import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.view.WSTabLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vtf
  implements View.OnClickListener
{
  vtf(vte paramvte, WSTabLayout paramWSTabLayout) {}
  
  public void onClick(View paramView)
  {
    if (WSTabLayout.a(this.jdField_a_of_type_Vte.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout) != null) {
      WSTabLayout.a(this.jdField_a_of_type_Vte.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout).a(vte.a(this.jdField_a_of_type_Vte));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtf
 * JD-Core Version:    0.7.0.1
 */