import UserGrowth.stPublisherRsp;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class udc
  implements View.OnClickListener
{
  public udc(WSHomeFragment paramWSHomeFragment, stPublisherRsp paramstPublisherRsp) {}
  
  public void onClick(View paramView)
  {
    WSHomeFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragment, this.jdField_a_of_type_UserGrowthStPublisherRsp);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udc
 * JD-Core Version:    0.7.0.1
 */