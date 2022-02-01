import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sej
  implements View.OnClickListener
{
  public sej(SubscribeHybirdFragment paramSubscribeHybirdFragment, san paramsan) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeHybirdFragment.a(this.jdField_a_of_type_San);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sej
 * JD-Core Version:    0.7.0.1
 */