import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zhy
  implements View.OnClickListener
{
  public zhy(SubscribeHybirdFragment paramSubscribeHybirdFragment, zda paramzda) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeHybirdFragment.a(this.jdField_a_of_type_Zda);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhy
 * JD-Core Version:    0.7.0.1
 */