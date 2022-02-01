import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.view.WSTabLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uwp
  implements View.OnClickListener
{
  uwp(uwo paramuwo, WSTabLayout paramWSTabLayout) {}
  
  public void onClick(View paramView)
  {
    if (WSTabLayout.a(this.jdField_a_of_type_Uwo.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout) != null) {
      WSTabLayout.a(this.jdField_a_of_type_Uwo.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout).a(uwo.a(this.jdField_a_of_type_Uwo));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwp
 * JD-Core Version:    0.7.0.1
 */