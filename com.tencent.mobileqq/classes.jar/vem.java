import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.view.WSTabLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vem
  implements View.OnClickListener
{
  vem(vel paramvel, WSTabLayout paramWSTabLayout) {}
  
  public void onClick(View paramView)
  {
    if (WSTabLayout.a(this.jdField_a_of_type_Vel.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout) != null) {
      WSTabLayout.a(this.jdField_a_of_type_Vel.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout).a(vel.a(this.jdField_a_of_type_Vel));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vem
 * JD-Core Version:    0.7.0.1
 */