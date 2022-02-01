import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelectPositionFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ChannelTopPositionView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class top
  implements View.OnClickListener
{
  public top(ChannelTopPositionView paramChannelTopPositionView) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChannelTopPositionView", 2, "onclick");
    }
    if (ChannelTopPositionView.a(this.a) != null) {
      PublicFragmentActivity.a(ChannelTopPositionView.a(this.a), ReadInJoySelectPositionFragment.class);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     top
 * JD-Core Version:    0.7.0.1
 */